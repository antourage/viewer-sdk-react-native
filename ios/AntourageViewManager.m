#import "AntourageViewManager.h"
@import AntourageViewer;

@implementation AntourageViewManager

RCT_EXPORT_MODULE()

- (UIView *)view
{
    return [[ANTWidget alloc] init];
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

RCT_EXPORT_VIEW_PROPERTY(portalColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(nameTextColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(nameBackgroundColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(titleTextColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(titleBackgroundColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(ctaTextColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(ctaBackgroundColor, UIColor);
RCT_EXPORT_VIEW_PROPERTY(liveDotColor, UIColor);

@end
