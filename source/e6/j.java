package e6;

import android.util.Log;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import java.io.File;

public class j extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public String f68138i;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final j f68139a = new j();
    }

    public static j s() {
        return b.f68139a;
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic");
        sb2.append(str2);
        sb2.append("offlinepackage");
        sb2.append(str2);
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "OfflinePackageManager";
    }

    public String h() {
        return this.f68138i;
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Util.a()) {
            Log.d("OfflinePackageManager" + this.f68138i, "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public String q() {
        if (!l()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("dynamic");
        sb2.append(str);
        sb2.append("offlinepackage");
        sb2.append(str);
        sb2.append(BaseApplication.e());
        sb2.append(str);
        sb2.append(f());
        sb2.append(str);
        String path = new File(sb2.toString()).getPath();
        if (Util.a()) {
            Log.d("OfflinePackageManager" + this.f68138i, "getCurrentDynamicPath() called rs=" + path);
        }
        return path;
    }

    public String r() {
        if (Util.a()) {
            Log.d("OfflinePackageManager" + this.f68138i, "getDefaultCurrentDynamicPath() called rs=dydefault/offlinepackage/");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dydefault");
        String str = File.separator;
        sb2.append(str);
        sb2.append("offlinepackage");
        sb2.append(str);
        return sb2.toString();
    }

    public j() {
        this.f68138i = "";
    }
}
