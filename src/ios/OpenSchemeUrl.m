/**
 * src/ios: OpenSchemeUrl.m
**/

#import <Cordova/CDVPlugin.h>
#import "OpenSchemeUrl.h"

@implementation OpenSchemeUrl
    - (void) open: (CDVInvokedUrlCommand*) command {
        NSString* url = [command.arguments objectAtIndex:0];

        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url] options:@{} completionHandler:^(BOOL success) {
            CDVPluginResult* pluginResult = nil;

            if (success) {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
            } else {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"URL schema not handled."];
            }

            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }];
    }
@end;
