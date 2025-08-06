package com.tencent.qcloud.tuikit.tuicallengine.e;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.utils.BrandUtils;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public Context f48340a;

    /* renamed from: b  reason: collision with root package name */
    public int f48341b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Timer f48342c;

    /* renamed from: d  reason: collision with root package name */
    public String f48343d;

    public class a extends TimerTask {
        public a() {
        }

        public void run() {
            l lVar = l.this;
            String str = lVar.f48343d;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("command", "heartbeat");
            linkedHashMap.put("seq", Integer.valueOf(lVar.f48341b));
            linkedHashMap.putAll(lVar.b());
            linkedHashMap.putAll(lVar.a());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("status", str);
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject(linkedHashMap);
                JSONObject jSONObject3 = new JSONObject(linkedHashMap2);
                jSONObject.put(TtmlNode.TAG_HEAD, jSONObject2);
                jSONObject.put(TtmlNode.TAG_BODY, jSONObject3);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            lVar.a(jSONObject.toString(), false);
        }
    }

    public class b implements V2TIMValueCallback<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f48345a;

        public b(l lVar, boolean z11) {
            this.f48345a = z11;
        }

        public void onError(int i11, String str) {
            if (this.f48345a) {
                TUILog.e("DataReportBusinessChannel", "sendPackageData failed: " + i11 + " ,errMsg: " + str);
            }
        }

        public void onSuccess(Object obj) {
            String str = new String((byte[]) obj, StandardCharsets.UTF_8);
            if (this.f48345a) {
                TUILog.i("DataReportBusinessChannel", "sendPackageData success: " + str);
            }
        }
    }

    public l(Context context) {
        this.f48340a = context;
    }

    public void a(String str) {
        this.f48343d = str;
        if (this.f48342c == null) {
            Timer timer = new Timer();
            this.f48342c = timer;
            timer.schedule(new a(), 0, 2000);
        }
    }

    public final Map<String, Object> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("version", 1);
        linkedHashMap.put(HianalyticsBaseData.SDK_VERSION, TUICallDefine.VERSION);
        n nVar = n.Native;
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        if (i11 == 11) {
            nVar = n.UniApp;
        } else if (i11 == 7) {
            nVar = n.Flutter;
        }
        linkedHashMap.put("framework", nVar.toString().toLowerCase());
        linkedHashMap.put("os_name", "android");
        linkedHashMap.put(TPDownloadProxyEnum.USER_OS_VERSION, BrandUtils.getOsVersion());
        linkedHashMap.put("device_name", "android");
        linkedHashMap.put("client_ts", Long.valueOf(o.b() / 1000));
        return linkedHashMap;
    }

    public void c() {
        Timer timer = this.f48342c;
        if (timer != null) {
            timer.cancel();
        }
        this.f48342c = null;
        this.f48341b = 1;
        this.f48343d = "";
    }

    public String a(m mVar, List<String> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("command", "event_report");
        linkedHashMap.put("seq", Integer.valueOf(this.f48341b));
        linkedHashMap.putAll(b());
        linkedHashMap.putAll(a());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("event_type", a(mVar));
        if (m.StartCall.equals(mVar) || m.InviteUser.equals(mVar)) {
            linkedHashMap2.put("invitee_list", list);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(linkedHashMap);
            JSONObject jSONObject3 = new JSONObject(linkedHashMap2);
            jSONObject.put(TtmlNode.TAG_HEAD, jSONObject2);
            jSONObject.put(TtmlNode.TAG_BODY, jSONObject3);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void a(String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            TUILog.e("DataReportBusinessChannel", "sendPackageData, data is invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("service_command", "callkit_records_svr.*");
            jSONObject.put("request_content", str);
            byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            this.f48341b++;
            V2TIMManager.getInstance().callExperimentalAPI("sendTRTCCustomData", bytes, new b(this, z11));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public final Map<String, Object> a() {
        p a11 = p.a(this.f48340a, "profile_call_base");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("user_id", a11.f48370c.getString("user_id", ""));
        linkedHashMap.put("room_id", String.valueOf(a11.f48370c.getString("room_id", "")));
        linkedHashMap.put("room_id_type", Integer.valueOf(a11.f48370c.getInt("room_id_type", -1)));
        String string = a11.f48370c.getString("invite_id", "");
        String string2 = a11.f48370c.getString("initial_invite_id", "");
        if (!TextUtils.isEmpty(string2) && !OptionsBridge.NULL_VALUE.equalsIgnoreCase(string2)) {
            string = string2;
        }
        linkedHashMap.put(AnalyticsEvents.PARAMETER_CALL_ID, string);
        linkedHashMap.put("group_id", a11.f48370c.getString("group_id", ""));
        linkedHashMap.put(TUIConstants.Message.CALLING_TYPE_KEY, a11.f48370c.getString("call_scene", ""));
        linkedHashMap.put(MessengerShareContentUtility.MEDIA_TYPE, a11.f48370c.getString(MessengerShareContentUtility.MEDIA_TYPE, ""));
        linkedHashMap.put("role", a11.f48370c.getString("role", ""));
        return linkedHashMap;
    }

    public final String a(m mVar) {
        switch (mVar.ordinal()) {
            case 0:
                return "start_call";
            case 1:
                return "call_accepted";
            case 2:
                return "call_missed";
            case 3:
                return "call_rejected";
            case 4:
                return "call_busy";
            case 5:
                return "cancel_call";
            case 6:
                return "call_failed";
            case 7:
                return "receive_call";
            case 8:
                return "accept_call";
            case 9:
                return "not_answer_call";
            case 10:
                return "reject_call";
            case 11:
                return "ignore_call";
            case 12:
                return "call_canceled";
            case 13:
                return "call_end";
            case 14:
                return "call_interrupted";
            case 15:
                return "invite_user";
            case 16:
                return "join_in_group_call";
            default:
                return "";
        }
    }
}
