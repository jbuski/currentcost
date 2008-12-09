//
//  AppController.h
//  Current Cost
//
//  Created by Neil on 05/12/2008.
//  Copyright 2008 Neil Cowburn. All rights reserved.
//

#import <Cocoa/Cocoa.h>
#include "NCCurrentCost.h"
#include "CurrentCostView.h"

@interface AppController : NSObject <NCCurrentCostDelegate> {
	IBOutlet CurrentCostView *ccView;
	IBOutlet NSButton *captureButton;
@private
	NCCurrentCost *ccm;
	BOOL continueLoop;
}

@property (nonatomic, retain) NCCurrentCost *ccm;

- (IBAction)startDataCapture:(id)sender;

@end
