//
//  CurrentCostView.h
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import <Cocoa/Cocoa.h>


@interface CurrentCostView : NSView {
	NSString *watts;
	NSString *temp;
	NSString *time;
	NSMutableDictionary *attributes;
}

@property (readwrite, copy) NSString *watts;
@property (readwrite, copy) NSString *temp;
@property (readwrite, copy) NSString *time;

@end
