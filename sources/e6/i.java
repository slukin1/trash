package e6;

import android.util.Log;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import d6.a;
import java.io.File;

public class i extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public String f68136i;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f68137a = new i();
    }

    public static i q() {
        return b.f68137a;
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic");
        sb2.append(str2);
        sb2.append(SymbolBean.OFFLINE);
        sb2.append(str2);
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "OfflineManager";
    }

    public String h() {
        return this.f68136i;
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Util.a()) {
            Log.d("OfflineManager" + this.f68136i, "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public a.C0737a r(String str, String str2) {
        if (this.f67446c == null) {
            return null;
        }
        return this.f67446c.a("h5", new a.b(str, str2));
    }

    public i() {
        this.f68136i = "";
    }
}
