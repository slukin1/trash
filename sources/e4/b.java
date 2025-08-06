package e4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentMap<String, n3.b> f66221a = new ConcurrentHashMap();

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e11);
            return null;
        }
    }

    public static String b(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    public static n3.b c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, n3.b> concurrentMap = f66221a;
        n3.b bVar = (n3.b) concurrentMap.get(packageName);
        if (bVar != null) {
            return bVar;
        }
        n3.b d11 = d(context);
        n3.b putIfAbsent = concurrentMap.putIfAbsent(packageName, d11);
        return putIfAbsent == null ? d11 : putIfAbsent;
    }

    public static n3.b d(Context context) {
        return new d(b(a(context)));
    }
}
