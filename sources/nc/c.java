package nc;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import i6.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f19348a = new c();

    public static final void a(String str, HashMap<?, ?> hashMap) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        if (hashMap == null || (str2 = hashMap.toString()) == null) {
            str2 = "";
        }
        sb2.append(str2);
        d.j("SensorsDataHelper", sb2.toString());
        if (hashMap == null) {
            try {
                SensorsDataAPI.sharedInstance().track(str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            try {
                SensorsDataAPI.sharedInstance().track(str, new JSONObject(hashMap));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void b(String str, HashMap hashMap, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            hashMap = null;
        }
        a(str, hashMap);
    }
}
