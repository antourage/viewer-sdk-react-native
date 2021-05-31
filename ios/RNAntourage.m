#import "RNAntourage.h"
@import Antourage;

@implementation RNAntourage

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(configure)
{
  [Antourage configure];
}

RCT_EXPORT_METHOD(showFeed)
{
  dispatch_async(dispatch_get_main_queue(), ^(void){
    [[Antourage shared] showFeed];
  });
  
}

RCT_EXPORT_METHOD(onPause){}

@end
