package cordova.plugin.bubblelayout;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;

import in.dcreators.bubblehead.*;

/**
 * This class echoes a string called from JavaScript.
 */
public class BubbleLayout extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }else if (action.equals("subtract")) {
            this.subtract(args, callbackContext);
            return true;
        }else if (action.equals("showBubbleHead")) {
            this.subtract(args, callbackContext);
            return true;
        }
        return false;
    }

    private void showBubbleHead(JSONArray args, CallbackContext callbackContext){
        if(args != null){
            final CordovaPlugin that = this;
            try{
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(that.cordova.getActivity().getBaseContext(), FloatingViewService.class);
                        that.cordova.startService(intent);
                    }
                });
            }catch(Exception e){
                callbackContext.error("Something went wrong"+ e);
            }
        }else{
            callbackContext.error("Please pass values");
        }
    }

    private void add(JSONArray args, CallbackContext callbackContext){
        if(args != null){
            try{
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                callbackContext.success(""+ (p1+p2));
            }catch(Exception e){
                callbackContext.error("Something went wrong"+ e);
            }
        }else{
            callbackContext.error("Please pass values");
        }
    }

    private void subtract(JSONArray args, CallbackContext callbackContext){
        if(args != null){
            try{
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                callbackContext.success(""+ (p1-p2));
            }catch(Exception e){
                callbackContext.error("Something went wrong"+ e);
            }
        }else{
            callbackContext.error("Please pass values");
        }
    }
}
