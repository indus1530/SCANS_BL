package edu.aku.hassannaqvi.uen_midline.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONUtils {
    public static JSONObject mergeJSONObjects(JSONObject Obj1, JSONObject Obj2) {
        JSONObject merged = new JSONObject();
        JSONObject[] objs = new JSONObject[]{Obj1, Obj2};
        for (JSONObject obj : objs) {
            Iterator it = obj.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                try {
                    merged.put(key, obj.get(key));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return merged;
    }
}
