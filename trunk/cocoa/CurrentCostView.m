//
//  CurrentCostView.m
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import "CurrentCostView.h"

@interface CurrentCostView ()

- (void)drawStringCenteredIn:(NSRect)rect;
- (void)prepareAttributes;

@end

@implementation CurrentCostView

@synthesize watts, temp, time;

- (id)initWithFrame:(NSRect)rect 
{
	if (![super initWithFrame:rect]) {
		return nil;
	}
	
	[self prepareAttributes];
	watts = @"";
	time = @"00:00";
	temp = @"0˚C";
	
	return self;
}

- (void)dealloc
{
	[watts release];
	[temp release];
	[time release];
	[attributes release];
	
	[super dealloc];
}

- (void)drawRect:(NSRect)rect
{
	NSRect bounds = [self bounds];
	[[NSColor whiteColor] set];
	[self drawStringCenteredIn:bounds];
	
	if (([[self window] firstResponder] == self) && [NSGraphicsContext currentContextDrawingToScreen]) {
		[NSGraphicsContext saveGraphicsState];
		NSSetFocusRingStyle(NSFocusRingOnly);
		[NSBezierPath fillRect:bounds];
		[NSGraphicsContext restoreGraphicsState];
	}
	
}

- (BOOL)isOpaque
{
	return NO;
}

- (void)setWatts:(NSString *)power
{
	power = [power copy];
	[watts release];
	watts = power;
	
	[self setNeedsDisplay:YES];
}


- (BOOL)acceptsFirstResponder
{
	return NO;
}

- (BOOL)resignFirstResponder
{
	[self setNeedsDisplay:YES];
	return NO;
}

- (BOOL)becomeFirstResponder
{
	[self setNeedsDisplay:YES];
	return NO;
}

- (void)drawStringCenteredIn:(NSRect)rect
{
	NSSize wattsSize = [watts sizeWithAttributes:attributes];
	
	NSPoint origin;
	origin.x = rect.origin.x + (rect.size.width - wattsSize.width) / 2;
	origin.y = rect.origin.y + (rect.size.height - wattsSize.height) / 2;
	
	[watts drawAtPoint:origin withAttributes:attributes];
}

- (void)prepareAttributes
{
	attributes = [[NSMutableDictionary alloc] init];
	[attributes setObject:[NSFont fontWithName:@"Helvetica" size:30] forKey:NSFontAttributeName];
	[attributes setObject:[NSColor blackColor] forKey:NSForegroundColorAttributeName];
}

@end
