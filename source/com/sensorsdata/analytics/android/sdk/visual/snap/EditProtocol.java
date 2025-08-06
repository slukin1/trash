package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.os.Handler;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditProtocol {
    private static final Class<?>[] NO_PARAMS = new Class[0];
    private static final String TAG = "SA.EProtocol";
    private final ResourceIds mResourceIds;
    private List<PropertyDescription> propertyDescriptionList;

    public static class BadInstructionsException extends Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public EditProtocol(ResourceIds resourceIds) {
        this.mResourceIds = resourceIds;
        try {
            JSONObject jSONObject = new JSONObject("{\"type\":\"snapshot_request\",\"payload\":{\"config\":{\"classes\":[{\"name\":\"android.view.View\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.TextView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.ImageView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]}]}}}").getJSONObject("payload");
            if (jSONObject.has(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG)) {
                this.propertyDescriptionList = getListPropertyDescription(jSONObject);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private List<PropertyDescription> getListPropertyDescription(JSONObject jSONObject) throws BadInstructionsException {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG).getJSONArray("classes");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                    linkedList.add(readPropertyDescription(cls, jSONArray2.getJSONObject(i12)));
                }
            }
            return linkedList;
        } catch (JSONException e11) {
            throw new BadInstructionsException("Can't read snapshot configuration", e11);
        } catch (ClassNotFoundException e12) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e12);
        }
    }

    private PropertyDescription readPropertyDescription(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            String str = null;
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), NO_PARAMS, Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                caller = null;
            }
            if (jSONObject.has("set")) {
                str = jSONObject.getJSONObject("set").getString("selector");
            }
            return new PropertyDescription(string, cls, caller, str);
        } catch (NoSuchMethodException e11) {
            throw new BadInstructionsException("Can't create property reader", e11);
        } catch (JSONException e12) {
            throw new BadInstructionsException("Can't read property JSON", e12);
        } catch (ClassNotFoundException e13) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e13);
        }
    }

    public ViewSnapshot readSnapshotConfig(Handler handler) throws BadInstructionsException {
        List<PropertyDescription> list = this.propertyDescriptionList;
        if (list == null) {
            return null;
        }
        return new ViewSnapshot(list, this.mResourceIds, handler);
    }
}
