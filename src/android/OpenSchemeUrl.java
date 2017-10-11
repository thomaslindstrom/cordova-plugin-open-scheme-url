/**
 * src/android: OpenSchemeUrl.java
**/

package no.amphibian.openschemeurl;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

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
            Context context = this.cordova.getActivity().getApplicationContext();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            callbackContext.success();
        }

        catch (android.content.ActivityNotFoundException error) {
            callbackContext.error(error.getMessage());
        }
    }
}
