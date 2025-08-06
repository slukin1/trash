package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.zendesk.logger.Logger;

class NetworkUtils {
    private static final String LOG_TAG = "NetworkUtils";

    private NetworkUtils() {
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (!(connectivityManager == null || context == null)) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                Logger.g(LOG_TAG, "Getting active network information", new Object[0]);
                return connectivityManager.getActiveNetworkInfo();
            }
            Logger.l(LOG_TAG, "Will not return if network is available because we do not have the permission to do so: ACCESS_NETWORK_STATE", new Object[0]);
        }
        return null;
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            Logger.l(LOG_TAG, "Context is null. Cannot get ConnectivityManager", new Object[0]);
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            Logger.l(LOG_TAG, "Connectivity manager is null", new Object[0]);
        }
        return connectivityManager;
    }

    public static boolean isConnectedOrConnecting(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }
}
