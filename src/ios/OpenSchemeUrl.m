/**
 * src/ios: OpenSchemeUrl.m
**/

#import <Cordova/CDVPlugin.h>
#import "OpenSchemeUrl.h"

@implementation OpenSchemeUrl
    - (void) open: (CDVInvokedUrlCommand*) command {
        @try {
            NSString* url = [command.arguments objectAtIndex:0];

            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
            CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }

        @catch (NSException *exception) {
            NSString* reason = [exception reason];
            CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:reason];
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }
    }
@end;
