#import "RNAntourage.h"
@import Antourage;

@implementation RNAntourage

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(authWithApiKey:(nonnull NSString *)apiKey
                  refUserId:(nullable NSString *)refUserId
                  nickname:(nullable NSString *)nickname)
{
  [Antourage authWithApiKey:apiKey refUserId:refUserId nickname:nickname];
}

RCT_EXPORT_METHOD(showFeed)
{
  dispatch_async(dispatch_get_main_queue(), ^(void){
    [[Antourage shared] showFeed];
  });
  
}

@end
