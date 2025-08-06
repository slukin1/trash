package com.huobi.woodpecker;

import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.huobi.woodpecker.aop.WoodPeckerHttpDNSFailRetryAspect;
import com.huobi.woodpecker.model.HttpDnsConfig;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.ReflectUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kv.e;
import m2.c;
import m2.d;
import okhttp3.Call;
import okhttp3.Dns;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;

public class HBOkHttpDNS implements Dns {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f20915g = null;

    /* renamed from: a  reason: collision with root package name */
    public HttpDnsConfig f20916a;

    /* renamed from: b  reason: collision with root package name */
    public c f20917b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Pattern> f20918c;

    /* renamed from: d  reason: collision with root package name */
    public int f20919d;

    /* renamed from: e  reason: collision with root package name */
    public String f20920e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20921f;

    public static class HBArrayList extends ArrayList<InetAddress> {
        public HBArrayList(InetAddress... inetAddressArr) {
            super(1);
            if (inetAddressArr != null && inetAddressArr.length > 0) {
                for (InetAddress add : inetAddressArr) {
                    add(add);
                }
            }
        }
    }

    public class a implements d {
        public a() {
        }

        public void log(String str) {
            e.c("Ali-HBOkHttpDNS", str);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final HBOkHttpDNS f20923a = new HBOkHttpDNS((a) null);
    }

    static {
        a();
    }

    public /* synthetic */ HBOkHttpDNS(a aVar) {
        this();
    }

    public static /* synthetic */ void a() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("HBOkHttpDNS.java", HBOkHttpDNS.class);
        f20915g = cVar.h("method-call", cVar.g("401", "lookup", "okhttp3.Dns", "java.lang.String", "arg0", "java.net.UnknownHostException", "java.util.List"), HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
    }

    public static HBOkHttpDNS e() {
        return b.f20923a;
    }

    public static final /* synthetic */ List m(HBOkHttpDNS hBOkHttpDNS, Dns dns, String str, JoinPoint joinPoint, WoodPeckerHttpDNSFailRetryAspect woodPeckerHttpDNSFailRetryAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Call call;
        Object target = proceedingJoinPoint.getTarget();
        Object b11 = proceedingJoinPoint.b();
        Object[] c11 = proceedingJoinPoint.c();
        if (e.l()) {
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns target=" + target);
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns thiz=" + b11);
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns args[0]=" + c11[0]);
        }
        if (!(target instanceof HBOkHttpDNS) || (call = (Call) ReflectUtils.a(Call.class, b11.getClass(), TUIConstants.TUICalling.METHOD_NAME_CALL, b11, true)) == null || call.request() == null || call.request().url() == null) {
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupFromHostPathIfHttpDns -> joinPoint.proceed() thiz=" + b11);
            return dns.lookup(str);
        }
        String host = call.request().url().host();
        String encodedPath = call.request().url().encodedPath();
        e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns -> HBOkHttpDNS.lookupByHostPath()");
        return ((HBOkHttpDNS) target).j((String) c11[0], host, encodedPath);
    }

    public void b(String str) {
        if (g()) {
            this.f20916a.removeConfig(str);
        }
    }

    public String c() {
        return this.f20920e;
    }

    public int d() {
        return this.f20919d;
    }

    public final Pattern f(String str) {
        Pattern pattern = this.f20918c.get(str);
        if (pattern != null) {
            return pattern;
        }
        Pattern compile = Pattern.compile(str);
        this.f20918c.put(str, compile);
        return compile;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f20916a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g() {
        /*
            r1 = this;
            m2.c r0 = r1.f20917b
            if (r0 == 0) goto L_0x0010
            com.huobi.woodpecker.model.HttpDnsConfig r0 = r1.f20916a
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isAvailable()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.HBOkHttpDNS.g():boolean");
    }

    public final boolean h(String str, String str2) {
        Pattern f11 = f(str2);
        if (f11 != null) {
            return f11.matcher(str).matches();
        }
        return false;
    }

    public boolean i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            e.c("HBOkHttpDNS", "isMatchHttpDns null => hostname:" + str + ", path:" + str2);
            return false;
        }
        HttpDnsConfig httpDnsConfig = this.f20916a;
        if (httpDnsConfig == null) {
            return false;
        }
        HttpDnsConfig.HostPathConfig hostPathConfig = httpDnsConfig.getHostPathConfig(str);
        if (hostPathConfig == null) {
            e.c("HBOkHttpDNS", "isMatchHttpDns not found pathConfig for hostname:" + str);
            return false;
        }
        List<String> paths = hostPathConfig.getPaths();
        if (paths == null || paths.isEmpty()) {
            e.c("HBOkHttpDNS", "isMatchHttpDns not config path rule.");
            return false;
        }
        for (String next : paths) {
            if (h(str2, next)) {
                e.c("HBOkHttpDNS", "isMatchHttpDns path:'" + str2 + "'.matches('" + next + "') => true");
                return true;
            }
        }
        e.c("HBOkHttpDNS", "isMatchHttpDns not matches => hostname:" + str + ", path:" + str2);
        return false;
    }

    public List<InetAddress> j(String str, String str2, String str3) throws UnknownHostException {
        e.c("HBOkHttpDNS", "lookupByHostPath() called with: originHostName = [" + str + "], hostname = [" + str2 + "], path = [" + str3 + "], isEnabled = [" + g() + "], isMatchHttpDns(hostname, path) = [" + i(str2, str3) + "]");
        if (this.f20921f && g() && i(str2, str3)) {
            String b11 = this.f20917b.b(str2);
            if (!TextUtils.isEmpty(b11)) {
                if (e.l()) {
                    e.c("HBOkHttpDNS", "lookupByHostPath() called with: ip = [" + b11 + "]");
                }
                InetAddress[] allByName = InetAddress.getAllByName(b11);
                if (allByName != null && allByName.length > 0) {
                    if (e.l()) {
                        e.c("HBOkHttpDNS", "lookupByHostPath(" + str2 + ", " + str3 + ") => " + b11);
                    }
                    return new HBArrayList(InetAddress.getAllByName(b11));
                }
            }
            e.c("HBOkHttpDNS", "lookupByHostPath(" + str2 + ", " + str3 + ") => empty");
        }
        return k(str);
    }

    public final List<InetAddress> k(String str) throws UnknownHostException {
        Dns dns = Dns.SYSTEM;
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f20915g, this, dns, str);
        if (!(dns instanceof HBOkHttpDNS)) {
            return dns.lookup(str);
        }
        return m(this, dns, str, c11, WoodPeckerHttpDNSFailRetryAspect.d(), (ProceedingJoinPoint) c11);
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        return k(str);
    }

    public void n(JSONObject jSONObject) {
        HttpDnsConfig httpDnsConfig = new HttpDnsConfig(jSONObject);
        e.c("HBOkHttpDNS", "setConfig() called with: obj = [" + jSONObject + "],config = [" + httpDnsConfig + "]");
        if (httpDnsConfig.isAvailable()) {
            this.f20918c.clear();
            if (!httpDnsConfig.isSame(this.f20916a)) {
                c a11 = HttpDns.a(ContextUtil.g(), httpDnsConfig.getAccountID());
                this.f20917b = a11;
                a11.c(true);
                if (!TextUtils.isEmpty(httpDnsConfig.getRegion())) {
                    this.f20917b.e(httpDnsConfig.getRegion());
                } else if (!TextUtils.isEmpty(c())) {
                    this.f20917b.e(c());
                }
                if (e.l()) {
                    this.f20917b.setLogEnabled(e.l());
                    this.f20917b.f(new a());
                }
            }
            if (httpDnsConfig.hasWhiteList()) {
                this.f20917b.d(httpDnsConfig.getAllHostList());
            }
            this.f20916a = httpDnsConfig;
            return;
        }
        this.f20917b = null;
        this.f20918c.clear();
        this.f20916a = httpDnsConfig;
    }

    public void o(String str) {
        this.f20920e = str;
    }

    public HBOkHttpDNS() {
        this.f20916a = null;
        this.f20917b = null;
        this.f20918c = new HashMap();
        this.f20919d = 5000;
        this.f20921f = false;
    }
}
