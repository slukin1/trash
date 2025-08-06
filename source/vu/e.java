package vu;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.woodpecker.model.WSTimeoutRecord;
import com.huobi.woodpecker.model.WebSocketConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import wu.c;

public class e implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, Pair<Integer, Long>> f23414d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, WebSocketConfig> f23415e = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f23416b;

    /* renamed from: c  reason: collision with root package name */
    public List<WebSocketConfig> f23417c;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final e f23418a = new e();
    }

    public static e g() {
        return b.f23418a;
    }

    public final void a(String str, String str2, String str3) {
        String d11 = d(str, str2, str3);
        if (i(d11)) {
            b(d11, str, str2, str3);
            WebSocketConfig e11 = e(str, str2, str3);
            if (e11 != null) {
                if (kv.e.l()) {
                    kv.e.m("WSMM>>>", "checkAndClearTimeoutWhenUnsubbed key=" + d11 + "(unsubbed), configId=" + e11.getId());
                }
                g.d().k(c(e11.getId()));
            }
        }
    }

    public final boolean b(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            if (f23414d.remove(str) != null) {
                return true;
            }
            return false;
        } else if (f23414d.remove(d(str2, str3, str4)) != null) {
            return true;
        } else {
            return false;
        }
    }

    public final int c(int i11) {
        return i11 + 20000;
    }

    public final String d(String str, String str2, String str3) {
        return str + '_' + str2 + '_' + str3;
    }

    public WebSocketConfig e(String str, String str2, String str3) {
        return f(d(str, str2, str3), str, str2, str3);
    }

    public final WebSocketConfig f(String str, String str2, String str3, String str4) {
        if (f23415e.containsKey(str)) {
            return f23415e.get(str);
        }
        List<WebSocketConfig> list = this.f23417c;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (WebSocketConfig next : this.f23417c) {
            if (next.getAction().equals(str3) && next.getTest().equals(str4) && next.getDomain().contains(str2)) {
                f23415e.put(str, next);
                return next;
            }
        }
        return null;
    }

    public boolean h() {
        return !f23414d.isEmpty();
    }

    public boolean handleMessage(Message message) {
        if ((message.what / 100) * 100 != 20000) {
            return false;
        }
        Object obj = message.obj;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            if (strArr.length == 5) {
                String str = strArr[0];
                String str2 = strArr[1];
                String str3 = strArr[2];
                String str4 = strArr[3];
                String str5 = strArr[4];
                int i11 = message.arg1;
                int i12 = message.arg2;
                if (kv.e.l()) {
                    kv.e.m("WSMM>>>", "handleMessage msg.what=" + message.what + ", key=" + str + ", tmIndex=" + i11 + ", timeout=" + i12);
                }
                l(str, str2, str3, str4, str5, i11, (long) i12);
            }
        }
        return true;
    }

    public boolean i(String str) {
        return f23414d.containsKey(str);
    }

    public boolean j() {
        return !this.f23416b;
    }

    public void k(String str, String str2, String str3, String str4) {
        WebSocketConfig f11;
        String str5 = str2;
        String str6 = str3;
        String str7 = str4;
        str3.hashCode();
        String str8 = "sub";
        char c11 = 65535;
        switch (str3.hashCode()) {
            case -891546047:
                if (str6.equals("subbed")) {
                    c11 = 0;
                    break;
                }
                break;
            case -5042662:
                if (str6.equals("unsubbed")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3173:
                if (str6.equals("ch")) {
                    c11 = 2;
                    break;
                }
                break;
            case 112797:
                if (str6.equals("rep")) {
                    c11 = 3;
                    break;
                }
                break;
            case 112798:
                if (str6.equals(HiAnalyticsConstant.Direction.REQUEST)) {
                    c11 = 4;
                    break;
                }
                break;
            case 114240:
                if (str6.equals(str8)) {
                    c11 = 5;
                    break;
                }
                break;
            case 111443207:
                if (str6.equals("unsub")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 6:
                a(str5, str8, str7);
                str8 = "unsub";
                break;
            case 3:
            case 4:
                str8 = HiAnalyticsConstant.Direction.REQUEST;
                break;
            default:
                str8 = null;
                break;
        }
        if (!TextUtils.isEmpty(str8)) {
            String d11 = d(str5, str8, str7);
            if (i(d11) && (f11 = f(d11, str5, str8, str7)) != null) {
                g.d().k(c(f11.getId()));
                Pair pair = f23414d.get(d11);
                int intValue = ((Integer) pair.first).intValue();
                long longValue = ((Long) pair.second).longValue();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j11 = elapsedRealtime - longValue;
                int timeout = f11.getTimeout(intValue);
                long j12 = elapsedRealtime;
                if (timeout <= 0 || j11 < ((long) timeout)) {
                    int i11 = intValue + 1;
                    int timeout2 = f11.getTimeout(i11);
                    if (timeout2 > 0) {
                        f23414d.put(d11, new Pair(Integer.valueOf(i11), Long.valueOf(j12)));
                        if (kv.e.l()) {
                            kv.e.m("WSMM>>>", "receiveMessage => continue key=" + d11 + "(" + str6 + "), configId=" + f11.getId() + ", tmIndex=" + i11 + ", nextTimeout=" + timeout2 + ", startTime=" + j12);
                        }
                        n(c(f11.getId()), d11, str, str2, str8, str4, i11, timeout2);
                        return;
                    }
                    long j13 = j12;
                    if (kv.e.l()) {
                        kv.e.m("WSMM>>>", "receiveMessage => completed key=" + d11 + "(" + str6 + "), configId=" + f11.getId() + ", endTmIndex=" + i11 + ", endTime=" + j13);
                    }
                    b(d11, str2, str8, str7);
                    return;
                }
                if (kv.e.l()) {
                    kv.e.m("WSMM>>>", "receiveMessage => alreadyTimeout key=" + d11 + "(" + str6 + "), configId=" + f11.getId() + ", tmIndex=" + intValue + ", timeout=" + timeout + ", costTime=" + j11);
                }
                l(d11, str, str2, str8, str4, intValue, j11);
            }
        }
    }

    public final void l(String str, String str2, String str3, String str4, String str5, int i11, long j11) {
        if (b(str, str3, str4, str5)) {
            WSTimeoutRecord wSTimeoutRecord = new WSTimeoutRecord();
            if (!TextUtils.isEmpty(str2) && (str2.startsWith(Constants.SCHEME) || str2.startsWith("http"))) {
                str2 = str2.replace("http", "ws");
            }
            ((WSTimeoutRecord.WSData) wSTimeoutRecord.getData()).setHost(str2);
            ((WSTimeoutRecord.WSData) wSTimeoutRecord.getData()).setAction(str4);
            ((WSTimeoutRecord.WSData) wSTimeoutRecord.getData()).setTopic(str5);
            ((WSTimeoutRecord.WSData) wSTimeoutRecord.getData()).setHitNum(i11 + 1);
            if (kv.e.l()) {
                kv.e.m("WSMM>>>", "saveTimeoutRecord occur timeout=" + j11 + ", key=" + str + ", wsTimeoutRecord=" + wSTimeoutRecord.toJsonString());
            }
            c.b(wSTimeoutRecord);
        }
    }

    public void m(String str, String str2, String str3, String str4) {
        WebSocketConfig f11;
        int timeout;
        String d11 = d(str2, str3, str4);
        if (!i(d11) && (f11 = f(d11, str2, str3, str4)) != null && (timeout = f11.getTimeout(0)) > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f23414d.put(d11, new Pair(0, Long.valueOf(elapsedRealtime)));
            if (kv.e.l()) {
                kv.e.m("WSMM>>>", "sendMessage key=" + d11 + ", configId=" + f11.getId() + ", tmIndex=" + 0 + ", timeout=" + timeout + ", startTime=" + elapsedRealtime);
            }
            n(c(f11.getId()), d11, str, str2, str3, str4, 0, timeout);
        }
    }

    public void n(int i11, String str, String str2, String str3, String str4, String str5, int i12, int i13) {
        Message obtain = Message.obtain();
        obtain.what = i11;
        obtain.arg1 = i12;
        obtain.arg2 = i13;
        obtain.obj = new String[]{str, str2, str3, str4, str5};
        g.d().o(obtain, (long) i13);
    }

    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has(io.flutter.plugins.firebase.crashlytics.Constants.ENABLED)) {
                this.f23416b = jSONObject.optBoolean(io.flutter.plugins.firebase.crashlytics.Constants.ENABLED);
            } else if (jSONObject.has("enable")) {
                this.f23416b = jSONObject.optBoolean("enable");
            }
            this.f23417c = WebSocketConfig.fromJsonArr(jSONObject.optJSONArray("rules"));
            f23414d.clear();
            f23415e.clear();
        }
    }

    public e() {
        this.f23416b = false;
        g.d().j(this);
    }
}
