/**
 * src/android: OpenSchemeUrl.java
**/

package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSchemeUrl extends CordovaPlugin {
    @Override public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("open")) {
            String url = args.getString(0);
            this.open(url, callbackContext);
            return true;
        }

        return false;
    }

    private void open(String url, CallbackContext callbackContext) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

            callbackContext.success();
        }

        catch (android.content.ActivityNotFoundException error) {
            callbackContext.error(error);
        }
    }
}
