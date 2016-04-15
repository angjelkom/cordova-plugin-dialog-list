package com.dialogList;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

public class DialogList extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        try {
            if ("dialog-list".equals(action)) {

                JSONObject arg_object = args.getJSONObject(0);
                final String title = arg_object.getString("title");

                JSONArray listItems = arg_object.getJSONArray("list");
                List<String> arrayList = new ArrayList<String>();

                // we start with index 1 because index 0 is the title

                int length = listItems.length();
                for (int x = 0; x < length; x++) {
                    try {
                        arrayList.add(listItems.getString(x));
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                final CharSequence[] items = arrayList.toArray(new CharSequence[arrayList.size()]);

                cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(cordova.getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                        dlg.setTitle(title);
                        dlg.setItems(items, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                callbackContext.success(which);
                            }
                        });
                        dlg.create();
                        dlg.show();
                    }
                });
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
