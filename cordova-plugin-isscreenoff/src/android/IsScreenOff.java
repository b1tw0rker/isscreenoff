package cordova.plugin.isscreenoff;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* Isscreen Off */
import android.os.PowerManager;
import static android.os.Build.VERSION.SDK_INT;
import android.content.Context;

import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import static android.content.Context.POWER_SERVICE;
import android.app.Activity;

/**
 * This class echoes a string called from JavaScript.
 */
public class IsScreenOff extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray arg, CallbackContext callbackContext) throws JSONException {

        if (action.equals("MeineCooleAktion")) {
            String message = arg.getString(0);
            // String message = "Fucking Success";
            this.MeineInterneJavaMethode(message, callbackContext);
            return true;
        }

        /*********************************************************** */

        if (action.equals("MeineCheckerFunktion")) {
            ScreenStatusFunction001(callbackContext);
            return true;
        }

        /*********************************************************** */

        return false;
    }

    /**
     * Die Funktionen
     * 
     * @param message
     * @param callbackContext
     */

    private void MeineInterneJavaMethode(String message, CallbackContext callbackContext) {

        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }

    }

    /**
     * Invokes the callback with information if the screen is on.
     *
     * @param callbackContext The callback to invoke.
     */
    @SuppressWarnings("deprecation")
    private void ScreenStatusFunction001 (CallbackContext callbackContext)
    {
        boolean status   = ScreenStatusFunction002();
        PluginResult res = new PluginResult(Status.OK, status);

        callbackContext.sendPluginResult(res);
    }
    
    
    /**
     * Returns if the screen is active.
     */
    @SuppressWarnings("deprecation")
    private boolean ScreenStatusFunction002() {

        PowerManager pm = (PowerManager) getService(POWER_SERVICE);

        if (SDK_INT < 20) {
            return !pm.isScreenOn();
        } else {
            return !pm.isInteractive();
        }

    }



    /**
     * Get the requested system service by name.
     *
     * @param name The name of the service.
     */
    private Object getService(String name)
    {
        return getApp().getSystemService(name);
    }


    /**
     * Returns the activity referenced by cordova.
     */
    Activity getApp() {
        return cordova.getActivity();
    }


















}