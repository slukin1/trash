package e6;

import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import d6.a;
import java.io.File;
import java.util.HashMap;

public class c extends HBDynamicBaseManager {

    /* renamed from: k  reason: collision with root package name */
    public static final HashMap<String, c> f68123k = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final String f68124i;

    /* renamed from: j  reason: collision with root package name */
    public String f68125j = null;

    public c(String str) {
        t(str);
        this.f68124i = str;
    }

    public static c r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, c> hashMap = f68123k;
        if (!hashMap.containsKey(str)) {
            hashMap.put(str, new c(str));
        }
        return hashMap.get(str);
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic");
        sb2.append(str2);
        sb2.append("edgeengine");
        sb2.append(str2);
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "EdgeEngine_" + this.f68124i;
    }

    public String h() {
        return DyanmicConfig.EdgeEdnge.class.getName() + this.f68125j;
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Util.a()) {
            Log.d("EdgeEngine" + this.f68125j, "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public String q(String str) {
        if (Util.a()) {
            Log.d("EdgeEngine" + this.f68125j, "getDefaultCurrentDynamicPath() called rs=dydefault/edgeengine/" + str);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dydefault");
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("edgeengine");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    public String s(String str) {
        a aVar = this.f67446c;
        if (aVar != null) {
            return aVar.b("edgeengine", str, "");
        }
        return "";
    }

    public void t(String str) {
        this.f68125j = DyanmicConfig.EdgeEdnge.class.getName() + str;
    }
}
