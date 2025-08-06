package g3;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.bbc876219.lib.hook.CrashUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class d implements InvocationHandler {

    /* renamed from: b  reason: collision with root package name */
    public Object f15838b;

    /* renamed from: c  reason: collision with root package name */
    public ApplicationInfo f15839c;

    /* renamed from: d  reason: collision with root package name */
    public PackageInfo f15840d;

    public d(Object obj) {
        this.f15838b = obj;
    }

    public final ApplicationInfo a() {
        if (this.f15839c == null) {
            ApplicationInfo applicationInfo = new ApplicationInfo();
            this.f15839c = applicationInfo;
            applicationInfo.metaData = new Bundle();
            ApplicationInfo applicationInfo2 = this.f15839c;
            applicationInfo2.taskAffinity = "";
            applicationInfo2.permission = "";
            applicationInfo2.processName = "";
            applicationInfo2.className = "";
            applicationInfo2.sourceDir = "";
            applicationInfo2.dataDir = "";
            applicationInfo2.packageName = "";
            applicationInfo2.name = "";
        }
        return this.f15839c;
    }

    public final PackageInfo b() {
        if (this.f15840d == null) {
            PackageInfo packageInfo = new PackageInfo();
            this.f15840d = packageInfo;
            packageInfo.versionName = "";
            packageInfo.packageName = "";
            packageInfo.activities = new ActivityInfo[0];
            packageInfo.services = new ServiceInfo[0];
            packageInfo.providers = new ProviderInfo[0];
            packageInfo.receivers = new ActivityInfo[0];
            packageInfo.sharedUserId = "";
        }
        return this.f15840d;
    }

    public final int c(Object[] objArr) {
        if (objArr == null || objArr.length <= 1) {
            return 0;
        }
        return objArr[1].intValue();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if ("getApplicationInfo".equals(method.getName())) {
            int c11 = c(objArr);
            try {
                return method.invoke(this.f15838b, objArr);
            } catch (Throwable th2) {
                if ((c11 & 128) != 0) {
                    throw th2;
                } else if (CrashUtils.c(th2)) {
                    CrashUtils.e(th2);
                    return a();
                } else {
                    throw th2;
                }
            }
        } else if (!"getPackageInfo".equals(method.getName())) {
            return method.invoke(this.f15838b, objArr);
        } else {
            try {
                return method.invoke(this.f15838b, objArr);
            } catch (Throwable th3) {
                if (CrashUtils.c(th3)) {
                    CrashUtils.e(th3);
                    return b();
                }
                throw th3;
            }
        }
    }
}
