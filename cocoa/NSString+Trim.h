//
//  NSString+Trim.h
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import <Cocoa/Cocoa.h>


@interface NSString (Trim) 

+ (NSString *)stringByTrimmingLeadingZeros:(NSString *)numericString;
- (NSString *)stringByTrimmingLeadingZeros;

@end
