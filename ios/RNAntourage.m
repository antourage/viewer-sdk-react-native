#import "RNAntourage.h"
@import AntourageViewer;

@implementation RNAntourage

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(configure:(NSInteger)teamID)
{
    [Antourage.shared setTeamID:teamID];
}

RCT_EXPORT_METHOD(registerNotifications:(NSString *)fcmToken callback:(RCTResponseSenderBlock)callback)
{
    [Antourage.shared registerForRemoteNotificationsWithFcmToken:fcmToken completion:^(NSString *topic) {
        callback(@[topic]);
    }];
}

RCT_EXPORT_METHOD(unregisterNotifications:(RCTResponseSenderBlock)callback)
{
    [Antourage.shared unregisterForRemoteNotificationsWithCompletion:^(BOOL success) {
        callback(@[@(success)]);
    }];
}

@end
