package lv;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.WebTimingData;
import com.huobi.woodpecker.model.WebViewMonitorRecord;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import com.huobi.woodpecker.utils.RecordUtil;
import com.huobi.woodpecker.utils.StringUtils;
import com.huobi.woodpecker.webview.NavigationTimingBean;
import com.huobi.woodpecker.webview.OpenUrlManager;
import java.util.Map;
import kv.e;
import org.json.JSONException;
import org.json.JSONObject;
import wu.c;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static b f22946c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22947a = true;

    /* renamed from: b  reason: collision with root package name */
    public String f22948b;

    /* renamed from: lv.a$a  reason: collision with other inner class name */
    public class C0199a extends TypeToken<Map<String, Object>> {
        public C0199a() {
        }
    }

    public interface b {
        void a(WebTimingData webTimingData);
    }

    public a(String str) {
        this.f22948b = str;
    }

    public static long a(long j11) {
        if (j11 < 0 || j11 > Period.MIN60_MILLS) {
            return 0;
        }
        return j11;
    }

    public void b(String str) {
        e.j("====================== come in handleError msg=" + str);
        if (this.f22947a) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    WoodPeckerSDK.f().g().a((Map) new Gson().fromJson(str, new C0199a().getType()));
                }
            } catch (Exception e11) {
                e.g("WoodPeckerJSObject", "handleError: ", e11);
            }
        } else if (e.l()) {
            e.o("WoodPeckerJSObject", "handleResource isNeedUpload=" + this.f22947a);
        }
    }

    public void c(String str) {
        long j11;
        long j12;
        long domComplete;
        long responseEnd;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        if (e.l()) {
            e.j("====================== come in handleResource");
        }
        String str2 = "WoodPeckerJSObject";
        if (this.f22947a) {
            NavigationTimingBean navigationTimingBean = new NavigationTimingBean();
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("payload");
                String string = jSONObject.getString("url");
                if (StringUtils.a(string)) {
                    jSONObject.getString("domain");
                    jSONObject.getString(ShareConstants.MEDIA_URI);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("navigationTiming");
                    long j18 = jSONObject2.getLong("navigationStart");
                    long j19 = jSONObject2.getLong("redirectStart");
                    long j21 = jSONObject2.getLong("redirectEnd");
                    long j22 = jSONObject2.getLong("fetchStart");
                    long j23 = jSONObject2.getLong("domainLookupStart");
                    String str3 = str2;
                    try {
                        long j24 = jSONObject2.getLong("domainLookupEnd");
                        long j25 = jSONObject2.getLong("connectStart");
                        long j26 = jSONObject2.getLong("secureConnectionStart");
                        long j27 = jSONObject2.getLong("connectEnd");
                        long j28 = jSONObject2.getLong("requestStart");
                        long j29 = jSONObject2.getLong("responseStart");
                        long j30 = jSONObject2.getLong("responseEnd");
                        long j31 = jSONObject2.getLong("unloadEventStart");
                        long j32 = jSONObject2.getLong("unloadEventEnd");
                        long j33 = jSONObject2.getLong("domLoading");
                        long j34 = jSONObject2.getLong("domInteractive");
                        long j35 = jSONObject2.getLong("domContentLoadedEventStart");
                        long j36 = jSONObject2.getLong("domContentLoadedEventEnd");
                        long j37 = jSONObject2.getLong("domComplete");
                        long j38 = jSONObject2.getLong("loadEventStart");
                        long j39 = jSONObject2.getLong("loadEventEnd");
                        String str4 = string;
                        long j40 = jSONObject2.getLong("pageTime");
                        navigationTimingBean.setNavigationStart(j18);
                        navigationTimingBean.setRedirectStart(j19);
                        navigationTimingBean.setRedirectEnd(j21);
                        navigationTimingBean.setFetchStart(j22);
                        navigationTimingBean.setDomainLookupStart(j23);
                        navigationTimingBean.setDomainLookupEnd(j24);
                        navigationTimingBean.setConnectStart(j25);
                        navigationTimingBean.setSecureConnectionStart(j26);
                        navigationTimingBean.setConnectEnd(j27);
                        navigationTimingBean.setRequestStart(j28);
                        navigationTimingBean.setResponseStart(j29);
                        navigationTimingBean.setResponseEnd(j30);
                        navigationTimingBean.setUnloadEventStart(j31);
                        navigationTimingBean.setUnloadEventEnd(j32);
                        navigationTimingBean.setDomLoading(j33);
                        navigationTimingBean.setDomInteractive(j34);
                        navigationTimingBean.setDomContentLoadedEventStart(j35);
                        navigationTimingBean.setDomContentLoadedEventEnd(j36);
                        navigationTimingBean.setDomComplete(j37);
                        navigationTimingBean.setLoadEventStart(j38);
                        navigationTimingBean.setLoadEventEnd(j39);
                        navigationTimingBean.setPageTime(j40);
                        str2 = str3;
                        try {
                            e.c(str2, navigationTimingBean.toString());
                            long a11 = a(navigationTimingBean.getDomainLookupEnd() - navigationTimingBean.getDomainLookupStart());
                            if (e.l()) {
                                e.c(str2, "DNS 建连时间()  = [" + a11 + "] = " + navigationTimingBean.getDomainLookupEnd() + " - " + navigationTimingBean.getDomainLookupStart());
                            }
                            long a12 = a(navigationTimingBean.getConnectEnd() - navigationTimingBean.getConnectStart());
                            if (e.l()) {
                                e.c(str2, "TCP 连接时间  = [" + a12 + "] = " + navigationTimingBean.getConnectEnd() + " - " + navigationTimingBean.getConnectStart());
                            }
                            long a13 = a(navigationTimingBean.getConnectEnd() - navigationTimingBean.getSecureConnectionStart());
                            if (e.l()) {
                                e.c(str2, "SSL 连接时间  = [" + a13 + "] = " + navigationTimingBean.getConnectEnd() + " - " + navigationTimingBean.getSecureConnectionStart());
                            }
                            long responseStart = navigationTimingBean.getResponseStart() - navigationTimingBean.getRequestStart();
                            if (e.l()) {
                                e.c(str2, "请求连接时间  = [" + responseStart + "] = " + navigationTimingBean.getResponseStart() + " - " + navigationTimingBean.getRequestStart());
                            }
                            long a14 = a(responseStart);
                            long a15 = a(navigationTimingBean.getResponseEnd() - navigationTimingBean.getResponseStart());
                            if (e.l()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("资源内容传输时间（单位：毫秒）  = [");
                                sb2.append(a15);
                                sb2.append("] = ");
                                j11 = a15;
                                sb2.append(navigationTimingBean.getResponseEnd());
                                sb2.append(" - ");
                                sb2.append(navigationTimingBean.getResponseStart());
                                e.c(str2, sb2.toString());
                            } else {
                                j11 = a15;
                            }
                            long a16 = a(navigationTimingBean.getLoadEventEnd() - navigationTimingBean.getDomContentLoadedEventEnd());
                            if (e.l()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("页面资源加载时间  = [");
                                sb3.append(a16);
                                sb3.append("] = ");
                                j12 = a16;
                                sb3.append(navigationTimingBean.getLoadEventEnd());
                                sb3.append(" - ");
                                sb3.append(navigationTimingBean.getDomContentLoadedEventEnd());
                                e.c(str2, sb3.toString());
                            } else {
                                j12 = a16;
                            }
                            if (navigationTimingBean.getDomComplete() == 0) {
                                domComplete = navigationTimingBean.getLoadEventStart();
                                responseEnd = navigationTimingBean.getResponseEnd();
                            } else {
                                domComplete = navigationTimingBean.getDomComplete();
                                responseEnd = navigationTimingBean.getResponseEnd();
                            }
                            long a17 = a(domComplete - responseEnd);
                            if (e.l()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("页面解析时间 Page parse time  = [");
                                sb4.append(a17);
                                sb4.append("] = ");
                                j13 = a17;
                                sb4.append(navigationTimingBean.getDomComplete());
                                sb4.append(" - ");
                                sb4.append(navigationTimingBean.getResponseEnd());
                                e.c(str2, sb4.toString());
                            } else {
                                j13 = a17;
                            }
                            long a18 = a(navigationTimingBean.getResponseEnd() - navigationTimingBean.getFetchStart());
                            if (e.l()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("页面白屏时间 First paint time  = [");
                                sb5.append(a18);
                                sb5.append("] = ");
                                j14 = a18;
                                sb5.append(navigationTimingBean.getResponseEnd());
                                sb5.append(" - ");
                                sb5.append(navigationTimingBean.getFetchStart());
                                e.c(str2, sb5.toString());
                            } else {
                                j14 = a18;
                            }
                            long a19 = a(navigationTimingBean.getResponseStart() - navigationTimingBean.getDomainLookupStart());
                            if (e.l()) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("首包时间 First byte time  = [");
                                sb6.append(a19);
                                sb6.append("] = ");
                                j15 = a19;
                                sb6.append(navigationTimingBean.getResponseStart());
                                sb6.append(" - ");
                                sb6.append(navigationTimingBean.getDomainLookupStart());
                                e.c(str2, sb6.toString());
                            } else {
                                j15 = a19;
                            }
                            long a21 = a(navigationTimingBean.getDomContentLoadedEventEnd() - navigationTimingBean.getNavigationStart());
                            if (e.l()) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("DOM Ready 时间 Page dom ready time  = [");
                                sb7.append(a21);
                                sb7.append("] = ");
                                j16 = a21;
                                sb7.append(navigationTimingBean.getDomContentLoadedEventEnd());
                                sb7.append(" - ");
                                sb7.append(navigationTimingBean.getNavigationStart());
                                e.c(str2, sb7.toString());
                            } else {
                                j16 = a21;
                            }
                            long a22 = a(navigationTimingBean.getLoadEventEnd() - navigationTimingBean.getNavigationStart());
                            if (e.l()) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("页面整体加载时间 Page load time  = [");
                                sb8.append(a22);
                                sb8.append("] = ");
                                j17 = a22;
                                sb8.append(navigationTimingBean.getLoadEventEnd());
                                sb8.append(" - ");
                                sb8.append(navigationTimingBean.getNavigationStart());
                                e.c(str2, sb8.toString());
                            } else {
                                j17 = a22;
                            }
                            long a23 = a(navigationTimingBean.getRequestStart() - navigationTimingBean.getFetchStart());
                            if (e.l()) {
                                e.c(str2, "客户端到服务端的耗时，端到端  = [" + a23 + "] = " + navigationTimingBean.getRequestStart() + " - " + navigationTimingBean.getFetchStart());
                            }
                            String str5 = str4;
                            boolean z11 = !OpenUrlManager.b().c(str5);
                            if (z11) {
                                OpenUrlManager.b().a(str5);
                            }
                            WebTimingData webTimingData = new WebTimingData(str5, z11, a11, a12, a13, a14, j11, j12, j13, j14, j15, j16, j17, 0, a23);
                            webTimingData.f21146op = OpPathMonitor.c().d();
                            WebViewMonitorRecord webViewMonitorRecord = new WebViewMonitorRecord();
                            webViewMonitorRecord.setData(webTimingData);
                            webViewMonitorRecord.setAction(ActionType.APP_WEBVIEW);
                            try {
                                if (!TextUtils.isEmpty(this.f22948b)) {
                                    webViewMonitorRecord.setUa(this.f22948b);
                                }
                                webViewMonitorRecord.setUrl(str5);
                                RecordUtil.a(webViewMonitorRecord);
                                if (e.l()) {
                                    e.c(str2, webViewMonitorRecord.toJsonString());
                                }
                                c.b(webViewMonitorRecord);
                                b bVar = f22946c;
                                if (bVar != null) {
                                    bVar.a(webTimingData);
                                }
                            } catch (JSONException e11) {
                                e = e11;
                                e.g(str2, "handleResource: JSONException", e);
                            }
                        } catch (JSONException e12) {
                            e = e12;
                            e.g(str2, "handleResource: JSONException", e);
                        }
                    } catch (JSONException e13) {
                        e = e13;
                        str2 = str3;
                        e.g(str2, "handleResource: JSONException", e);
                    }
                }
            } catch (JSONException e14) {
                e = e14;
                e.g(str2, "handleResource: JSONException", e);
            }
        } else if (e.l()) {
            e.o(str2, "handleResource isNeedUpload=" + this.f22947a);
        }
    }

    @JavascriptInterface
    public void sendError(String str) {
        b(str);
    }

    @JavascriptInterface
    public void sendResource(String str) {
        c(str);
    }
}
