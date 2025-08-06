package mu;

import android.os.Build;
import android.text.TextUtils;
import com.huobi.kalle.Kalle;
import com.huobi.kalle.RequestMethod;
import com.huobi.kalle.Url;
import com.huobi.kalle.simple.SimpleCallback;
import com.huobi.kalle.simple.cache.CacheMode;
import com.huobi.vulcan.core.CipherUtils;
import com.huobi.vulcan.core.Scene;
import com.huobi.vulcan.core.SecurityKey;
import com.huobi.vulcan.core.Signature;
import com.huobi.vulcan.model.Config;
import com.huobi.vulcan.model.ConfigRequestData;
import com.huobi.vulcan.model.LogRequestData;
import com.huobi.vulcan.model.SeedBlackListData;
import com.huobi.vulcan.model.SwitchRequestData;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.vulcan.net.HttpEntity;
import com.huobi.vulcan.net.JsonConverter;
import com.huobi.vulcan.net.UrlConfig;
import com.huobi.vulcan.utils.HexUtil;
import com.huobi.vulcan.utils.MD5Util;
import com.huobi.vulcan.utils.StringUtils;
import com.huobi.vulcan.utils.SystemUtils;
import com.huobi.vulcan.utils.riskinfo.DeviceInfoUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import lm.f;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f22962a = Charset.forName("UTF-8");

    /* renamed from: mu.a$a  reason: collision with other inner class name */
    public class C0201a extends SimpleCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aq.a f22963a;

        public C0201a(aq.a aVar) {
            this.f22963a = aVar;
        }

        public void f(lm.h<String, String> hVar) {
            String e11 = hVar.e();
            aq.a aVar = this.f22963a;
            if (aVar != null) {
                aVar.a(e11);
            }
        }
    }

    public class b extends JsonConverter<String> {
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0028, code lost:
            r2 = r2.split("\\|\\|");
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String b(java.lang.String r2, java.lang.reflect.Type r3) {
            /*
                r1 = this;
                java.lang.String r3 = com.huobi.vulcan.core.SecurityKey.i()
                java.lang.String r0 = com.huobi.vulcan.core.SecurityKey.h()
                java.lang.String r2 = com.huobi.vulcan.core.CipherUtils.c(r3, r0, r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "getSwitch-decryptData:"
                r3.append(r0)
                r3.append(r2)
                java.lang.String r3 = r3.toString()
                java.lang.String r0 = "API"
                lu.a.b(r0, r3)
                boolean r3 = com.huobi.vulcan.utils.StringUtils.f(r2)
                if (r3 == 0) goto L_0x0038
                java.lang.String r3 = "\\|\\|"
                java.lang.String[] r2 = r2.split(r3)
                if (r2 == 0) goto L_0x0038
                int r3 = r2.length
                r0 = 2
                if (r3 < r0) goto L_0x0038
                r3 = 0
                r2 = r2[r3]
                return r2
            L_0x0038:
                java.lang.String r2 = "0"
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: mu.a.b.b(java.lang.String, java.lang.reflect.Type):java.lang.String");
        }
    }

    public class c extends SimpleCallback<List<Config>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConfigRequestData f22964a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ aq.a f22965b;

        public c(ConfigRequestData configRequestData, aq.a aVar) {
            this.f22964a = configRequestData;
            this.f22965b = aVar;
        }

        public void f(lm.h<List<Config>, String> hVar) {
            if (String.valueOf(HttpEntity.CODE_NO_UPLOAD_COLLECT_DATA).equalsIgnoreCase(hVar.b())) {
                ku.c.q().z(this.f22964a.getScenes());
            }
            List e11 = hVar.e();
            aq.a aVar = this.f22965b;
            if (aVar != null) {
                aVar.a(e11);
            }
        }
    }

    public class d extends JsonConverter<List<Config>> {
        /* renamed from: c */
        public List<Config> b(String str, Type type) {
            String[] split = str.split("\\|\\|");
            String c11 = CipherUtils.c(SecurityKey.a(), SecurityKey.f(), split[0]);
            lu.a.b("API", c11);
            if (split.length > 1) {
                String c12 = CipherUtils.c(SecurityKey.a(), SecurityKey.f(), split[1]);
                SeedBlackListData seedBlackListData = new SeedBlackListData();
                try {
                    seedBlackListData.fromJson(new JSONObject(c12));
                    ku.b.e().n(seedBlackListData.getMac());
                    ku.b.e().m(seedBlackListData.getAndroidID());
                    ku.b.e().o(seedBlackListData.getSerial());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            ju.a.o().g(iu.a.f().c());
            return Config.fromJsonArrStr(c11);
        }
    }

    public class e extends SimpleCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aq.a f22966a;

        public e(aq.a aVar) {
            this.f22966a = aVar;
        }

        public void f(lm.h<Void, String> hVar) {
            lu.a.b("API", "reportData result=>" + hVar.a() + ", succeed:::" + hVar.e() + ", failed:::" + hVar.b());
            aq.a aVar = this.f22966a;
            if (aVar != null) {
                aVar.a(Boolean.valueOf(hVar.c()));
            }
        }
    }

    public class f extends JsonConverter<Void> {
        /* renamed from: c */
        public Void b(String str, Type type) {
            lu.a.b("API", "vtenc " + str);
            ku.b.e().l(str);
            return null;
        }
    }

    public class g extends SimpleCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aq.a f22967a;

        public g(aq.a aVar) {
            this.f22967a = aVar;
        }

        public void f(lm.h<Void, String> hVar) {
            aq.a aVar = this.f22967a;
            if (aVar != null) {
                aVar.a(Boolean.valueOf(hVar.c()));
            }
        }
    }

    public class h extends JsonConverter<Void> {
        /* renamed from: c */
        public Void b(String str, Type type) {
            return null;
        }
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (StringUtils.d(str3)) {
                str = OptionsBridge.NULL_VALUE;
            } else {
                str = CipherUtils.e(str3);
            }
            sb2.append(str2);
            sb2.append("--");
            sb2.append(str);
            sb2.append("||");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.deleteCharAt(sb2.length() - 1);
        lu.a.b("API", sb2.toString());
        return sb2.toString();
    }

    public static Map<String, String> b(Config config) {
        HashMap hashMap = new HashMap();
        Map<String, String> e11 = ju.a.o().e(config.getScenes(), config.getParameters());
        String h11 = ku.b.e().h(ku.a.b());
        String f11 = ku.b.e().f();
        String d11 = ku.b.e().d();
        if (!StringUtils.d(f11) && !f11.equals(d11)) {
            h11 = d11;
        }
        if (TextUtils.isEmpty(h11)) {
            h11 = ku.b.e().c();
        }
        if (e11 == null || e11.isEmpty()) {
            hashMap.put("p0", "");
            hashMap.put("k0", "");
        } else {
            byte[][] j11 = CipherUtils.j();
            if (j11 == null || j11.length != 2) {
                lu.a.c("API", "生成随机密钥失败!");
                return hashMap;
            }
            String a11 = CipherUtils.a(j11);
            lu.a.b("API", "origin aes key:IV=" + a11);
            String a12 = a(e11);
            byte[] bArr = j11[0];
            byte[] bArr2 = j11[1];
            Charset charset = f22962a;
            String f12 = CipherUtils.f(CipherUtils.h(bArr, bArr2, a12.getBytes(charset)));
            RSAPublicKey k11 = CipherUtils.k(SecurityKey.g());
            if (k11 == null) {
                lu.a.c("API", "公钥加载失败!");
                return hashMap;
            }
            String f13 = CipherUtils.f(CipherUtils.i(k11, a11.getBytes(charset)));
            hashMap.put("p0", f12);
            hashMap.put("k0", f13);
        }
        hashMap.put("cHash", config.getcHash());
        hashMap.put("vToken", h11);
        if (Scene.isInit(config.getScenes())) {
            hashMap.put(VulcanInfo.V_HASH, HexUtil.b(MD5Util.b(h11)));
        }
        return hashMap;
    }

    public static Map<String, String> c(String str, String str2) {
        HashMap hashMap = new HashMap();
        try {
            URI create = URI.create(str2);
            String a11 = Signature.a(SecurityKey.b(), SecurityKey.c(), RequestMethod.POST.toString(), create.getHost(), create.getPath(), hashMap);
            lu.a.b("API", "genSignInfo:" + a11);
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return hashMap;
    }

    public static String d(String str, String str2) {
        return Signature.d(c(str, str2));
    }

    public static void e(int i11, int i12, int i13, aq.a<List<Config>> aVar) {
        ConfigRequestData configRequestData = new ConfigRequestData();
        configRequestData.setType(i11);
        configRequestData.setPlatformType(2);
        configRequestData.setBusinessLine(i12);
        if (i13 > 0) {
            configRequestData.setScenes(i13);
        }
        configRequestData.setAppVersion(SystemUtils.x(ku.a.b()));
        configRequestData.setSdkVersion("1.3.1");
        configRequestData.setvToken(ku.b.e().h(ku.a.b()));
        configRequestData.setCfgV(2);
        lu.a.b("API", "getConfig requestData=>" + configRequestData.toJson());
        f(configRequestData, aVar);
    }

    public static void f(ConfigRequestData configRequestData, aq.a<List<Config>> aVar) {
        String b11 = UrlConfig.b();
        Url.a l11 = Url.j(b11).l(d(RequestMethod.POST.name(), b11));
        Url i11 = l11.i();
        lu.a.b("API", "getConfig-url:" + i11.toString());
        ((f.b) Kalle.b(i11).m(new com.huobi.kalle.f(configRequestData.toJson().toString()))).s(CacheMode.NETWORK_NO_THEN_READ_CACHE).r(b11 + "???" + configRequestData.toString()).t(new d()).u(new c(configRequestData, aVar));
    }

    public static void g(int i11, aq.a<String> aVar) {
        SwitchRequestData switchRequestData = new SwitchRequestData();
        switchRequestData.setPlatformType(2);
        switchRequestData.setPlatformVersion(SystemUtils.f());
        switchRequestData.setModel(Build.BRAND);
        if (ku.a.b() != null) {
            switchRequestData.setAppVersion(SystemUtils.e(ku.a.b()));
        }
        switchRequestData.setBusinessLine(i11);
        h(switchRequestData, aVar);
    }

    public static void h(SwitchRequestData switchRequestData, aq.a<String> aVar) {
        String e11 = UrlConfig.e();
        ((f.b) Kalle.c(e11).m(new com.huobi.kalle.f(switchRequestData.toJson().toString()))).s(CacheMode.NETWORK_NO_THEN_READ_CACHE).r(e11 + "???" + switchRequestData.toString()).t(new b()).u(new C0201a(aVar));
    }

    public static void i(String str, aq.a<Boolean> aVar) {
        String d11 = UrlConfig.d();
        LogRequestData logRequestData = new LogRequestData();
        logRequestData.setDeviceInfo(DeviceInfoUtils.g(ju.a.o().l()));
        logRequestData.setErrUuid(ku.b.e().c());
        logRequestData.setReqId(UUID.randomUUID().toString());
        logRequestData.setVtenc(ku.b.e().i());
        logRequestData.setVtoken(ku.b.e().h(iu.a.f().c()));
        logRequestData.setData(str);
        String g11 = CipherUtils.g(SecurityKey.e(), SecurityKey.d(), logRequestData.toJson().toString());
        lu.a.b("API", "请求参数:" + logRequestData.toJson().toString());
        ((f.b) Kalle.c(d11).m(new com.huobi.kalle.f(g11, "text/plain"))).s(CacheMode.NETWORK_NO_THEN_READ_CACHE).t(new h()).u(new g(aVar));
    }

    public static void j(Config config, aq.a<Boolean> aVar) {
        String c11 = UrlConfig.c();
        Url.a l11 = Url.j(c11).l(d(RequestMethod.POST.name(), c11));
        JSONObject jSONObject = new JSONObject(b(config));
        Url i11 = l11.i();
        lu.a.b("API", "reportData-url:" + i11.toString() + "\n reportData body json=>" + jSONObject);
        ((f.b) Kalle.b(i11).m(new com.huobi.kalle.f(jSONObject.toString()))).t(new f()).u(new e(aVar));
    }
}
