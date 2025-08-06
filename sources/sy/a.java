package sy;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;
import vy.f;

public class a {
    public static String a(String str) {
        Context f11 = py.a.c().f();
        if (f11 == null) {
            return "";
        }
        return f.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", new Object[]{"audid", py.a.c().b(), b(str, "", "", f11.getPackageName())}));
    }

    public static String b(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put("appName", str4);
        return new JSONObject(f.b(hashMap)).toString();
    }
}
