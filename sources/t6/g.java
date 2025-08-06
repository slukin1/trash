package t6;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.screenshot.ContentObserverListenerManager;
import com.hbg.lib.core.screenshot.FileObserverListenerManager;
import com.luck.picture.lib.permissions.PermissionConfig;
import i6.d;
import i6.k;
import i6.n;
import io.flutter.embedding.android.FlutterFragmentActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class g {

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f69063f;

    /* renamed from: a  reason: collision with root package name */
    public FileObserverListenerManager f69064a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f69065b;

    /* renamed from: c  reason: collision with root package name */
    public d f69066c;

    /* renamed from: d  reason: collision with root package name */
    public String f69067d;

    /* renamed from: e  reason: collision with root package name */
    public Context f69068e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final g f69069a = new g();
    }

    public static final g f() {
        return b.f69069a;
    }

    public static boolean h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(String str, String str2) {
        d.d("setOnScreenshotListener  ManagerCallback absolutePath:" + str2 + " listenerManagerName：" + str + " mLastScreenShotTime:" + f69063f);
        if (!TextUtils.isEmpty(str2) && this.f69066c != null && !str2.equals(this.f69067d) && !e(str, str2)) {
            this.f69066c.a(str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(String[] strArr, String str) {
        if (!d()) {
            if (str.startsWith("file://")) {
                str = str.substring(str.lastIndexOf("/"));
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            d.d("setOnScreenshotListener absolutePath:" + str + " bitmap:" + decodeFile + " hasPermissions:" + EasyPermissions.hasPermissions(this.f69068e, strArr) + " currentActivity:" + oa.a.g().b());
            if (decodeFile == null) {
                decodeFile = n();
                k.o("ScreenshotManager", "decodeFile error absolutePath:" + str + " hasSDpermission:" + EasyPermissions.hasPermissions(this.f69068e, strArr) + " currentActivity:" + oa.a.g().b() + " bitmap:" + decodeFile);
                if (decodeFile == null) {
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(decodeFile);
            BaseModuleConfig.a().newShareWithImages(arrayList, true, false, "screenshot");
        }
    }

    public void c(a aVar) {
        this.f69065b.add(aVar);
        aVar.b(new e(this));
    }

    public final boolean d() {
        if (oa.a.g().b() == null) {
            return false;
        }
        Activity b11 = oa.a.g().b();
        String simpleName = b11.getClass().getSimpleName();
        if (!simpleName.equals("ContentShareActivity") && !simpleName.equals("ScreenshotShareActivity")) {
            if (!simpleName.equals("NetworkDetectionActivity")) {
                return false;
            }
            if (b11 instanceof c) {
                ((c) b11).Ua();
            }
        }
        return true;
    }

    public boolean e(String str, String str2) {
        if (str2.equalsIgnoreCase(this.f69067d) || str2.endsWith(".tmp") || System.currentTimeMillis() - f69063f < 1000) {
            return true;
        }
        long lastModified = new File(str2).lastModified();
        d.d("setOnScreenshotListener absolutePath:" + str2 + " listenerManagerName：" + str + " filterEvent lastModified:" + lastModified + " mLastScreenShotTime:" + f69063f);
        if (h()) {
            if (!str2.contains(this.f69068e.getPackageName())) {
                k.o("ScreenManager", "package different:" + str2);
                return true;
            } else if (lastModified <= f69063f || lastModified - f69063f < 1000) {
                return true;
            }
        } else if (lastModified <= f69063f || lastModified - f69063f < 1000) {
            return true;
        }
        f69063f = System.currentTimeMillis();
        this.f69067d = str2;
        return false;
    }

    public void g() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE};
        }
        k(new f(this, strArr));
    }

    public void k(d dVar) {
        this.f69066c = dVar;
    }

    public void l() {
        d.j("ScreenshotManager", "startListen mContext:" + this.f69068e);
        f69063f = System.currentTimeMillis();
        for (a a11 : this.f69065b) {
            a11.a();
        }
    }

    public void m() {
        d.j("ScreenshotManager", "stopListen mContext:" + this.f69068e);
        for (a c11 : this.f69065b) {
            c11.c();
        }
    }

    public final Bitmap n() {
        Activity b11 = oa.a.g().b();
        if (b11 != null && !(b11 instanceof FlutterFragmentActivity)) {
            String simpleName = b11.getClass().getSimpleName();
            if (!simpleName.equals("UtilsTransActivity") && !simpleName.equals("LiveDetailActivity")) {
                return n.k(b11, true);
            }
        }
        return null;
    }

    public g() {
        this.f69065b = new ArrayList();
        FileObserverListenerManager fileObserverListenerManager = new FileObserverListenerManager();
        this.f69064a = fileObserverListenerManager;
        c(fileObserverListenerManager);
        c(new ContentObserverListenerManager());
        g();
        this.f69068e = BaseApplication.b();
    }
}
