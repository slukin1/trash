package uy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ta.a.e.h;

public class f {
    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return true;
        }
    }
}
