package jumio.core;

import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.jumio.core.environment.Environment;
import com.sumsub.sns.internal.core.common.n0;
import org.json.JSONException;
import org.json.JSONObject;

public final class w0 {
    public static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk-platform", n0.f32119g);
        jSONObject.put("sdk-version", Environment.BUILD_VERSION);
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        jSONObject.put("software-version", Build.VERSION.RELEASE);
        jSONObject.put("software-build-number", Build.DISPLAY);
        jSONObject.put("kernel-version", System.getProperty("os.version"));
        return jSONObject;
    }
}
