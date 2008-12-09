//
//  AppController.m
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import "AppController.h"
#include "NSString+Trim.h"

@interface AppController () 

- (void)readData:(id)anObject;

@end

@implementation AppController

@synthesize ccm;

- (id)init 
{
	if (self = [super init]) {
		ccm = [[NCCurrentCost alloc] init:@"/dev/cu.usbserial-0000101D" withBaudRate:2400];
		continueLoop = YES;
		[ccm setDelegate:self];
	}
	
	return self;
}

- (IBAction)startDataCapture:(id)sender
{
	continueLoop = YES;
	[ccm open];
	[NSThread detachNewThreadSelector:@selector(readData:) toTarget:self withObject:nil];
}

- (void)dataWasReceived:(NSXMLDocument *)xml
{	
	NSString *tmp = [NSString stringWithFormat:@"Energy Now: %@ Watts", [NSString stringByTrimmingLeadingZeros:[[[xml nodesForXPath:@"/msg/ch1/watts" error:nil] objectAtIndex:0] stringValue]]];
	[ccView setWatts:tmp];
}

- (void)readData:(id)anObject
{
	NSAutoreleasePool *thisPool = [[NSAutoreleasePool alloc] init];
	
	while (continueLoop) {
		[ccm read];
	}
	
	[thisPool release];
}

@end
