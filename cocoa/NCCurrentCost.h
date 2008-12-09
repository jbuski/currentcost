//
//  CCSerialPort.h
//  CCSerialPort
//
//  Created by Neil on 02/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import <Cocoa/Cocoa.h>

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <paths.h>
#include <termios.h>
#include <sys/time.h>
#include <sysexits.h>
#include <sys/param.h>

// #define CCDEBUG 1
#define MAX_CC_BUFFER_SIZE 2048

@protocol NCCurrentCostDelegate
- (void)dataWasReceived:(NSXMLDocument *)newData;
@end

@interface NCCurrentCost : NSObject {
	
id delegate;

@private
	NSString *bsdPath;
	int baud;
	NSString *serviceName;
	NSString *serviceType;
	int fd;
	
	struct termios * __strong options;
	struct termios * __strong originalOptions;
	
	NSFileHandle *handle;
}

@property (readonly,retain) id delegate;

- (id)init:(NSString *)path withBaudRate:(int)baudRate;
- (void)open;
- (void)close;
- (void)read;
- (void)setDelegate:(id)newDelegate;

@end
