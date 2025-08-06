package com.huobi.edgeengine.ability;

import android.text.TextUtils;
import android.util.Log;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import gs.g;
import i6.d;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rj.b;

public class EngineAnatylicsAbility extends AbstractAbility {
    public static String d(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Date) {
            return TimeUtils.formatDate((Date) obj);
        }
        return obj.toString();
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        String str;
        if (aVar == null || obj == null) {
            Log.d("Console", "call EngineAnatylicsAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("event") ? v8Object.getString("event") : "";
            if (v8Object.contains("properties")) {
                str = v8Object.getString("properties");
            } else {
                str = "";
            }
            d.c("Console", "call EngineAnatylicsAbility event " + string + " properties:" + str);
            g.m(string, c(str));
            aVar.a(true, "");
        } catch (Throwable th2) {
            Log.d("Console", "call EngineAnatylicsAbility Exception ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public boolean b() {
        return false;
    }

    public final JSONObject c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                jSONObject.put(next, obj.toString());
            } else {
                int i11 = 0;
                if (obj instanceof List) {
                    List list = (List) obj;
                    int size = list.size();
                    JSONArray jSONArray = new JSONArray();
                    while (i11 < size) {
                        jSONArray.put(d(list.get(i11)));
                        i11++;
                    }
                    jSONObject.put(next, jSONArray);
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    while (i11 < jSONArray2.length()) {
                        jSONArray2.put(i11, d(jSONArray2.opt(i11)));
                        i11++;
                    }
                }
            }
        }
        return jSONObject;
    }
}
