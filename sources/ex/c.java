package ex;

import com.appsflyer.AppsFlyerProperties;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static b a(File file) {
        Map<String, String> b11 = b(file);
        if (b11 == null) {
            return null;
        }
        b11.remove(AppsFlyerProperties.CHANNEL);
        return new b(b11.get(AppsFlyerProperties.CHANNEL), b11);
    }

    public static Map<String, String> b(File file) {
        try {
            String c11 = c(file);
            if (c11 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c11);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return e.d(file, 1903654775);
    }
}
