package sm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.util.ArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f76543a;

    static {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_AUDIO, PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE, "android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        }
        f76543a = strArr;
    }

    public static boolean a(Context context) {
        return b(f76543a, context);
    }

    public static boolean b(String[] strArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        ActivityCompat.requestPermissions((Activity) context, strArr2, 0);
        return false;
    }
}
