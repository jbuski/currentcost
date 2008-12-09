//
//  NSString+Trim.m
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import "NSString+Trim.h"


@implementation NSString (Trim)

- (NSString *)stringByTrimmingLeadingZeros
{
	return [NSString stringByTrimmingLeadingZeros:self];
}

+ (NSString *)stringByTrimmingLeadingZeros:(NSString *)numericString 
{
	NSMutableString *copy = [numericString mutableCopy];
	NSCharacterSet *naturalNumberSet = [NSCharacterSet characterSetWithCharactersInString:@"123456789"];
	NSInteger start = -1;
	
	for (NSInteger i = 0; i < [copy length] - 1; i++) {
		unichar chr = [copy characterAtIndex:i];
		if ([naturalNumberSet characterIsMember:chr] == YES) {
			start = i;
			break;
		}
	}
	
	[copy deleteCharactersInRange:NSMakeRange(0, start)];
	return [NSString stringWithString:copy];
}

@end
