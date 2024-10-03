
#import "RNScreenshotDetect.h"
#import <React/RCTEventEmitter.h>
#import <React/RCTBridgeModule.h>

@interface ScreenshotDetector : RCTEventEmitter <RCTBridgeModule>
@end

@implementation RNScreenshotDetect

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (instancetype)init {
  self = [super init];
  if (self) {
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(userDidTakeScreenshot:)
                                                 name:UIApplicationUserDidTakeScreenshotNotification
                                               object:nil];
  }
  return self;
}

- (void)userDidTakeScreenshot:(NSNotification *)notification {
  [self sendEventWithName:@"screenshotTaken" body:nil];
}

- (NSArray<NSString *> *)supportedEvents {
  return @[@"screenshotTaken"];
}

- (void)dealloc {
  [[NSNotificationCenter defaultCenter] removeObserver:self];
}

@end
  