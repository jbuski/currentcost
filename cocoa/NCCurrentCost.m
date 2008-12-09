//
//  CCSerialPort.m
//  CCSerialPort
//
//  Created by Neil on 02/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import "NCCurrentCost.h"

@implementation NCCurrentCost

@synthesize delegate;

#pragma mark Constructors and destructors

- (id)init:(NSString *)path withBaudRate:(int)baudRate
{
	if (self = [super init]) {
		bsdPath = [path copy];
		baud = baudRate;
			
		options = (struct termios*)malloc(sizeof(*options));
		originalOptions = (struct termios*)malloc(sizeof(*originalOptions));
	}
	
	return self;
}

- (void)dealloc 
{
	[self close];
	
	free(originalOptions);
	free(options);
	
	[serviceType release];
	[serviceName release];
	[bsdPath release];
	
	[super dealloc];
}

#pragma mark Public Methods

- (void)open
{
	const char *path = [bsdPath fileSystemRepresentation];
	
	fd = open(path, O_RDONLY | O_NOCTTY);
	if (fd == -1) {
		// Error opening the serial port
		NSLog(@"Error opening serial port");
		return;
	}
	
	if (tcgetattr(fd, originalOptions) == -1) {
		// Error getting options
		NSLog(@"Error getting options");
		return;
	}
	
	*options = *originalOptions;
	handle = [[NSFileHandle alloc] initWithFileDescriptor:fd];
	
	// Set the baud rate to 2400 bps
	cfsetspeed(options, B2400);
	
	options->c_cc[VMIN] = 1;
    options->c_cc[VTIME] = 10;
	
	// 8 data bits
	options->c_cflag |= CS8;
	
	// No parity
	options->c_cflag &= ~PARENB;
	
	// One stop bit
	options->c_cflag &= ~CSTOPB;
	
	// No flow control
	options->c_cflag &= ~(IXON | IXOFF | IXANY);
	
	if (tcsetattr(fd,TCSANOW, options) != 0) {
		// Error setting options
		NSLog(@"Error setting options");
		return;
	}
	
}

- (void)close
{
	fcntl(fd, F_SETFL, fcntl(fd, F_GETFL, 0) | O_NONBLOCK);
	
	[handle closeFile];
	[handle release];
	handle = nil;
	
	close(fd);
	fd = -1;
}

 - (void)read
{
	char    buffer[MAX_CC_BUFFER_SIZE];	
    char    *bufPtr;					
    ssize_t numBytes;					
	
	memset(&buffer, 0, sizeof(buffer));
	bufPtr = buffer;
	
	do
	{
		numBytes = read(fd, bufPtr, MAX_CC_BUFFER_SIZE);
		if (numBytes > 0)
		{
			bufPtr += numBytes;
			
			if (*(bufPtr - 1) == '\n')
			{
				NSRange range = [[NSString stringWithUTF8String:buffer] rangeOfString:@"\n"];
				
				if ([delegate respondsToSelector:@selector(dataWasReceived:)]) {
					NSData *rawData  = [[NSData alloc] initWithBytes:buffer length:range.location];
					NSXMLDocument *xml = [[NSXMLDocument alloc] initWithData:rawData options:0 error:nil];

					if (xml != nil) {
						[delegate performSelectorOnMainThread:@selector(dataWasReceived:) withObject:xml waitUntilDone:YES];
					}
					
					[xml release];
					[rawData release];
				}
				
#ifdef CCDEBUG
				NSString *sentence = [data substringToIndex:range.location - 1];
				NSLog(@"%@", sentence);				
				[sentence release];
#endif
				break;
			}
		}
	} while (numBytes > 0);
}

- (void)setDelegate:(id)newDelegate
{
	[newDelegate retain];
	[delegate release];
	delegate = newDelegate;
}

@end
