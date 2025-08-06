package com.sensorsdata.analytics.sensorsanalyticsflutterplugin;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sumsub.sns.internal.core.common.n0;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class SensorsAnalyticsFlutterPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public MethodChannel f29945b;

    public final void A(List list) {
        SensorsDataAPI.sharedInstance().profilePushId((String) list.get(0), (String) list.get(1));
    }

    public final void B(List list) {
        JSONObject b11 = b((Map) list.get(0));
        if (b11 != null) {
            SensorsDataAPI.sharedInstance().profileSet(b11);
        }
    }

    public final void C(List list) {
        JSONObject b11 = b((Map) list.get(0));
        if (b11 != null) {
            SensorsDataAPI.sharedInstance().profileSetOnce(b11);
        }
    }

    public final void D(List list) {
        SensorsDataAPI.sharedInstance().profileUnset((String) list.get(0));
    }

    public final void E(List list) {
        SensorsDataAPI.sharedInstance().profileUnsetPushId((String) list.get(0));
    }

    public final void F(List list) {
        JSONObject b11 = b((Map) list.get(0));
        if (b11 != null) {
            SensorsDataAPI.sharedInstance().registerSuperProperties(b11);
        }
    }

    public final void G(List list) {
        SensorsDataAPI.sharedInstance().removeTimer(a((String) list.get(0)));
    }

    public final void H(List list) {
        SensorsDataAPI.sharedInstance().setFlushBulkSize(((Integer) list.get(0)).intValue());
    }

    public final void I(List list) {
        SensorsDataAPI.sharedInstance().setFlushInterval(((Integer) list.get(0)).intValue());
    }

    public final void J(List list) {
        SensorsDataAPI.sharedInstance().setFlushNetworkPolicy(((Integer) list.get(0)).intValue());
    }

    public final void K(List list) {
        SensorsDataAPI.sharedInstance().setServerUrl((String) list.get(0), ((Boolean) list.get(1)).booleanValue());
    }

    public final void L(List list) {
        SensorsDataAPI.sharedInstance().track(a((String) list.get(0)), b((Map) list.get(1)));
    }

    public final void M(List list) {
        SensorsDataAPI.sharedInstance().trackAppInstall(c(list.get(0)), ((Boolean) list.get(1)).booleanValue());
    }

    public final void N(List list) {
        SensorsDataAPI.sharedInstance().trackInstallation(a((String) list.get(0)), b((Map) list.get(1)));
    }

    public final void O(List list) {
        SensorsDataAPI.sharedInstance().trackTimerEnd(a((String) list.get(0)), b((Map) list.get(1)));
    }

    public final void P(List list) {
        SensorsDataAPI.sharedInstance().trackTimerPause(a((String) list.get(0)));
    }

    public final void Q(List list) {
        SensorsDataAPI.sharedInstance().trackTimerResume(a((String) list.get(0)));
    }

    public final void R(List list, MethodChannel.Result result) {
        result.success(SensorsDataAPI.sharedInstance().trackTimerStart(a((String) list.get(0))));
    }

    public final void S(List list) {
        SensorsDataAPI.sharedInstance().trackViewScreen((String) list.get(0), b((Map) list.get(1)));
    }

    public final void T(List list) {
        SensorsDataAPI.sharedInstance().unregisterSuperProperty((String) list.get(0));
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            SALog.d("SA.SensorsAnalyticsFlutterPlugin", "事件名为空，请检查代码");
        }
        return str;
    }

    public final JSONObject b(Map map) {
        if (map != null) {
            return new JSONObject(map);
        }
        SALog.d("SA.SensorsAnalyticsFlutterPlugin", "传入的属性为空");
        return null;
    }

    public final JSONObject c(Object obj) {
        if (obj != null) {
            return new JSONObject((Map) obj);
        }
        SALog.d("SA.SensorsAnalyticsFlutterPlugin", "传入的属性为空");
        return null;
    }

    public final void d() {
        SensorsDataAPI.sharedInstance().clearSuperProperties();
    }

    public final void e() {
        SensorsDataAPI.sharedInstance().clearTrackTimer();
    }

    public final void f() {
        SensorsDataAPI.sharedInstance().deleteAll();
    }

    public final void g() {
        SensorsDataAPI.sharedInstance().enableDataCollect();
    }

    public final void h(List list) {
        SensorsDataAPI.sharedInstance().enableLog(((Boolean) list.get(0)).booleanValue());
    }

    public final void i(List list) {
        SensorsDataAPI.sharedInstance().enableNetworkRequest(((Boolean) list.get(0)).booleanValue());
    }

    public final void j() {
        SensorsDataAPI.sharedInstance().flush();
    }

    public final void k(MethodChannel.Result result) {
        result.success(SensorsDataAPI.sharedInstance().getAnonymousId());
    }

    public final void l(MethodChannel.Result result) {
        String loginId = SensorsDataAPI.sharedInstance().getLoginId();
        if (!TextUtils.isEmpty(loginId)) {
            result.success(loginId);
        } else {
            result.success(SensorsDataAPI.sharedInstance().getAnonymousId());
        }
    }

    public final void m(MethodChannel.Result result) {
        result.success(Integer.valueOf(SensorsDataAPI.sharedInstance().getFlushBulkSize()));
    }

    public final void n(MethodChannel.Result result) {
        result.success(Integer.valueOf(SensorsDataAPI.sharedInstance().getFlushInterval()));
    }

    public final void o(MethodChannel.Result result) {
        result.success(SensorsDataAPI.sharedInstance().getLoginId());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "sensors_analytics_flutter_plugin");
        this.f29945b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f29945b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            List list = (List) methodCall.arguments;
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -2031738579:
                    if (str.equals("getDistinctId")) {
                        c11 = '\'';
                        break;
                    }
                    break;
                case -1927283321:
                    if (str.equals("trackTimerResume")) {
                        c11 = 23;
                        break;
                    }
                    break;
                case -1731065051:
                    if (str.equals("trackInstallation")) {
                        c11 = 20;
                        break;
                    }
                    break;
                case -1576361437:
                    if (str.equals("profileAppend")) {
                        c11 = '%';
                        break;
                    }
                    break;
                case -1500751692:
                    if (str.equals("profileDelete")) {
                        c11 = '&';
                        break;
                    }
                    break;
                case -1172513444:
                    if (str.equals("trackTimerPause")) {
                        c11 = 22;
                        break;
                    }
                    break;
                case -1169196088:
                    if (str.equals("trackTimerStart")) {
                        c11 = 21;
                        break;
                    }
                    break;
                case -1142215458:
                    if (str.equals("profilePushId")) {
                        c11 = '(';
                        break;
                    }
                    break;
                case -1140038764:
                    if (str.equals("unregisterSuperProperty")) {
                        c11 = '!';
                        break;
                    }
                    break;
                case -1116478559:
                    if (str.equals("getFlushBulkSize")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -1102647815:
                    if (str.equals("profileSet")) {
                        c11 = 30;
                        break;
                    }
                    break;
                case -1097329270:
                    if (str.equals("logout")) {
                        c11 = 28;
                        break;
                    }
                    break;
                case -1031314777:
                    if (str.equals("setFlushInterval")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1026165330:
                    if (str.equals("isNetworkRequestEnable")) {
                        c11 = 18;
                        break;
                    }
                    break;
                case -631672127:
                    if (str.equals("enableLog")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -466034239:
                    if (str.equals("trackTimerEnd")) {
                        c11 = 25;
                        break;
                    }
                    break;
                case -402423012:
                    if (str.equals("trackViewScreen")) {
                        c11 = 29;
                        break;
                    }
                    break;
                case -375431886:
                    if (str.equals("getAnonymousId")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -358737930:
                    if (str.equals("deleteAll")) {
                        c11 = 13;
                        break;
                    }
                    break;
                case -304033503:
                    if (str.equals("removeTimer")) {
                        c11 = 24;
                        break;
                    }
                    break;
                case -135762164:
                    if (str.equals("identify")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 97532676:
                    if (str.equals("flush")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case 103149417:
                    if (str.equals(FirebaseAnalytics.Event.LOGIN)) {
                        c11 = 27;
                        break;
                    }
                    break;
                case 110621003:
                    if (str.equals("track")) {
                        c11 = 19;
                        break;
                    }
                    break;
                case 270514149:
                    if (str.equals("trackAppInstall")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 379130599:
                    if (str.equals("clearTrackTimer")) {
                        c11 = 26;
                        break;
                    }
                    break;
                case 735047622:
                    if (str.equals("profileIncrement")) {
                        c11 = DecodedChar.FNC1;
                        break;
                    }
                    break;
                case 762114142:
                    if (str.equals("setFlushNetworkPolicy")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 785447069:
                    if (str.equals("enableDataCollect")) {
                        c11 = '*';
                        break;
                    }
                    break;
                case 800128051:
                    if (str.equals("getFlushInterval")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 884472065:
                    if (str.equals("clearSuperProperties")) {
                        c11 = '\"';
                        break;
                    }
                    break;
                case 935528939:
                    if (str.equals("registerSuperProperties")) {
                        c11 = ' ';
                        break;
                    }
                    break;
                case 1155718170:
                    if (str.equals("profileSetOnce")) {
                        c11 = 31;
                        break;
                    }
                    break;
                case 1214489344:
                    if (str.equals("profileUnset")) {
                        c11 = n0.h.f32179b;
                        break;
                    }
                    break;
                case 1341940970:
                    if (str.equals("setServerUrl")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1347045909:
                    if (str.equals("setFlushBulkSize")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1379204654:
                    if (str.equals("getLoginId")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1493674229:
                    if (str.equals("profileUnsetPushId")) {
                        c11 = ')';
                        break;
                    }
                    break;
                case 1535217892:
                    if (str.equals("enableNetworkRequest")) {
                        c11 = 15;
                        break;
                    }
                    break;
                case 1556812446:
                    if (str.equals("itemDelete")) {
                        c11 = 17;
                        break;
                    }
                    break;
                case 1561454824:
                    if (str.equals("getPresetProperties")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1815071960:
                    if (str.equals("getSuperProperties")) {
                        c11 = 14;
                        break;
                    }
                    break;
                case 2116193359:
                    if (str.equals("itemSet")) {
                        c11 = 16;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    K(list);
                    return;
                case 1:
                    p(result);
                    return;
                case 2:
                    h(list);
                    return;
                case 3:
                    J(list);
                    return;
                case 4:
                    I(list);
                    return;
                case 5:
                    n(result);
                    return;
                case 6:
                    m(result);
                    return;
                case 7:
                    H(list);
                    return;
                case 8:
                    k(result);
                    return;
                case 9:
                    o(result);
                    return;
                case 10:
                    r(list);
                    return;
                case 11:
                    M(list);
                    return;
                case 12:
                    j();
                    return;
                case 13:
                    f();
                    return;
                case 14:
                    q(result);
                    return;
                case 15:
                    i(list);
                    return;
                case 16:
                    u(list);
                    return;
                case 17:
                    t(list);
                    return;
                case 18:
                    s(result);
                    return;
                case 19:
                    L(list);
                    return;
                case 20:
                    N(list);
                    return;
                case 21:
                    R(list, result);
                    return;
                case 22:
                    P(list);
                    return;
                case 23:
                    Q(list);
                    return;
                case 24:
                    G(list);
                    return;
                case 25:
                    O(list);
                    return;
                case 26:
                    e();
                    return;
                case 27:
                    v(list);
                    return;
                case 28:
                    w();
                    return;
                case 29:
                    S(list);
                    return;
                case 30:
                    B(list);
                    return;
                case 31:
                    C(list);
                    return;
                case ' ':
                    F(list);
                    return;
                case '!':
                    T(list);
                    return;
                case '\"':
                    d();
                    return;
                case '#':
                    D(list);
                    return;
                case '$':
                    z(list);
                    return;
                case '%':
                    x(list);
                    return;
                case '&':
                    y();
                    return;
                case '\'':
                    l(result);
                    return;
                case '(':
                    A(list);
                    return;
                case ')':
                    E(list);
                    return;
                case '*':
                    g();
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            SALog.d("SA.SensorsAnalyticsFlutterPlugin", e11.getMessage());
        }
    }

    public final void p(MethodChannel.Result result) {
        JSONObject presetProperties = SensorsDataAPI.sharedInstance().getPresetProperties();
        if (presetProperties != null) {
            Iterator<String> keys = presetProperties.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, presetProperties.opt(next));
            }
            result.success(hashMap);
            return;
        }
        result.success((Object) null);
    }

    public final void q(MethodChannel.Result result) {
        JSONObject superProperties = SensorsDataAPI.sharedInstance().getSuperProperties();
        if (superProperties != null) {
            Iterator<String> keys = superProperties.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, superProperties.opt(next));
            }
            result.success(hashMap);
            return;
        }
        result.success((Object) null);
    }

    public final void r(List list) {
        SensorsDataAPI.sharedInstance().identify((String) list.get(0));
    }

    public final void s(MethodChannel.Result result) {
        result.success(Boolean.valueOf(SensorsDataAPI.sharedInstance().isNetworkRequestEnable()));
    }

    public final void t(List list) {
        SensorsDataAPI.sharedInstance().itemDelete((String) list.get(0), (String) list.get(1));
    }

    public final void u(List list) {
        SensorsDataAPI.sharedInstance().itemSet((String) list.get(0), (String) list.get(1), c(list.get(2)));
    }

    public final void v(List list) {
        SensorsDataAPI.sharedInstance().login((String) list.get(0));
    }

    public final void w() {
        SensorsDataAPI.sharedInstance().logout();
    }

    public final void x(List list) {
        SensorsDataAPI.sharedInstance().profileAppend((String) list.get(0), (Set<String>) new HashSet((Collection) list.get(1)));
    }

    public final void y() {
        SensorsDataAPI.sharedInstance().profileDelete();
    }

    public final void z(List list) {
        SensorsDataAPI.sharedInstance().profileIncrement((String) list.get(0), (Number) list.get(1));
    }
}
