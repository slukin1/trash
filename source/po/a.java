package po;

import android.text.TextUtils;
import bh.j;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.ChannelUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.vulcan.net.UrlConfig;
import com.huochat.community.network.domain.DomainTool;
import i6.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f84569b = new a();

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f84570a;

    /* renamed from: po.a$a  reason: collision with other inner class name */
    public class C0883a extends TypeToken<HashMap<String, Integer>> {
        public C0883a() {
        }
    }

    public a() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        this.f84570a = hashMap;
        InputStream inputStream = null;
        try {
            hashMap.clear();
            inputStream = j.c().getResources().getAssets().open("vulcan_scene.json");
            String k11 = FileUtil.k(inputStream);
            this.f84570a.putAll((HashMap) new Gson().fromJson(k11, new C0883a().getType()));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public static void a() {
        k.o("VulcanSdk", "changeHost - 1");
        if (iu.a.f().k()) {
            k.o("VulcanSdk", "changeHost - 2");
            UrlConfig.f(d());
            return;
        }
        k.o("VulcanSdk", "changeHost - 3");
        e();
    }

    public static a c() {
        return f84569b;
    }

    public static String d() {
        String O = DomainSwitcher.O();
        if (TextUtils.isEmpty(O)) {
            return null;
        }
        String replaceAll = O.replaceAll("pro/", "");
        return DomainTool.DOMAIN_PREFIX + replaceAll;
    }

    public static void e() {
        String d11 = d();
        k.o("VulcanSdk", "vd - " + d11);
        iu.a.f().i(j.c(), d11, 1, ChannelUtils.a(), false);
    }

    public int b(String str) {
        if (this.f84570a.containsKey(str)) {
            return this.f84570a.get(str).intValue();
        }
        return -999;
    }
}
