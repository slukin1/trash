package vf;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.HashMap;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f37361a = new a();

    public static final void a(String str, HashMap<Object, Object> hashMap) {
        if (hashMap.isEmpty()) {
            SensorsDataAPI.sharedInstance().track(str);
            return;
        }
        SensorsDataAPI.sharedInstance().track(str, new JSONObject(MapsKt__MapsKt.u(hashMap)));
    }
}
