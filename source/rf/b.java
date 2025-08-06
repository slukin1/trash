package rf;

import android.app.Application;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;
import vf.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f29194a = new b();

    public static final void a(Application application) {
        try {
            InputStream open = application.getAssets().open("tscr.json");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e11) {
                    Log.d("TSCR", "IOException = " + e11);
                }
            }
            JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
            open.close();
            int i11 = jSONObject.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
            int i12 = jSONObject.getInt("flutter");
            int i13 = jSONObject.getInt("edge");
            HashMap hashMap = new HashMap();
            hashMap.put("nativeCount", Integer.valueOf(i11));
            hashMap.put("flutterCount", Integer.valueOf(i12));
            hashMap.put("edgeCount", Integer.valueOf(i13));
            a.a("technical_stack_coverage_rate", hashMap);
        } catch (Exception e12) {
            Log.d("TSCR", "Exception = " + e12);
        }
    }
}
