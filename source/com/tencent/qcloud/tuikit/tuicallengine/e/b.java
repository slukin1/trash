package com.tencent.qcloud.tuikit.tuicallengine.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.f.n;
import com.tencent.qcloud.tuikit.tuicallengine.h.e;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f48321a;

    /* renamed from: b  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.f.a f48322b = new com.tencent.qcloud.tuikit.tuicallengine.f.a();

    /* renamed from: c  reason: collision with root package name */
    public Handler f48323c;

    /* renamed from: d  reason: collision with root package name */
    public e f48324d;

    /* renamed from: e  reason: collision with root package name */
    public l f48325e;

    /* renamed from: f  reason: collision with root package name */
    public final TUICallObserver f48326f = new C0601b();

    /* renamed from: g  reason: collision with root package name */
    public final TRTCCloudListener f48327g = new c();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            p.a(b.this.f48321a, "profile_call_status").a("result", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN.toLowerCase());
            b.this.a(-1, "The call ended unexpectedly");
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.e.b$b  reason: collision with other inner class name */
    public class C0601b extends TUICallObserver {
        public C0601b() {
        }

        public void onCallBegin(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
            super.onCallBegin(roomId, mediaType, role);
            b bVar = b.this;
            if (bVar.f48325e == null) {
                bVar.f48325e = new l(bVar.f48321a);
            }
            bVar.f48325e.a(TUIConstants.TUICalling.EVENT_KEY_CALLING);
        }

        public void onCallCancelled(String str) {
            super.onCallCancelled(str);
            b.this.a(0, "success");
            b.a(b.this);
            l lVar = b.this.f48325e;
            if (lVar != null) {
                lVar.c();
            }
        }

        public void onCallEnd(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role, long j11) {
            super.onCallEnd(roomId, mediaType, role, j11);
            p a11 = p.a(b.this.f48321a, "profile_call_status");
            if (!TextUtils.isEmpty("total_time")) {
                a11.f48370c.edit().putLong("total_time", j11).commit();
            }
            b.this.a(0, "success");
            b.a(b.this);
            l lVar = b.this.f48325e;
            if (lVar != null) {
                lVar.c();
            }
        }

        public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
            super.onCallReceived(str, list, str2, mediaType, str3);
            b bVar = b.this;
            if (bVar.f48325e == null) {
                bVar.f48325e = new l(bVar.f48321a);
            }
            bVar.f48325e.a("waiting");
        }
    }

    public class c extends TRTCCloudListener {
        public c() {
        }

        public void onEnterRoom(long j11) {
            super.onEnterRoom(j11);
            p.a(b.this.f48321a, "profile_call_status_detail").a("enter_room", b.a(b.this, o.b()));
        }

        public void onExitRoom(int i11) {
            super.onExitRoom(i11);
        }
    }

    public b(Context context) {
        this.f48321a = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("data_report");
        handlerThread.start();
        this.f48323c = new Handler(handlerThread.getLooper());
        a();
    }

    public static String a(b bVar, long j11) {
        bVar.getClass();
        if (j11 <= 0) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j11));
    }

    public void a(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar) {
        if (aVar != null) {
            TUICallEngine.createInstance(this.f48321a).addObserver(this.f48326f);
            k.f48439a = this.f48321a;
            k.b.f48445a.a(this.f48327g);
            this.f48322b = aVar;
            aVar.f48382l.observe(new c(this));
            this.f48322b.f48383m.observe(new d(this));
            this.f48322b.f48384n.observe(new e(this));
            this.f48322b.f48385o.observe(new f(this));
            this.f48322b.f48386p.observe(new g(this));
            this.f48322b.f48381k.f48387a.observe(new h(this));
            this.f48322b.f48381k.f48388b.observe(new i(this));
            this.f48322b.f48381k.f48389c.observe(new j(this));
            this.f48322b.f48381k.f48390d.observe(new k(this));
            this.f48322b.f48381k.f48391e.observe(new a(this));
            p a11 = p.a(this.f48321a, "profile_call_base");
            a11.a("version", TUICallDefine.VERSION);
            a11.a("platform", "android");
            n nVar = n.Native;
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            if (i11 == 11) {
                nVar = n.UniApp;
            } else if (i11 == 7) {
                nVar = n.Flutter;
            }
            a11.a("framework", nVar.toString().toLowerCase());
            int i12 = n.a.f48451a.f48449a;
            if (!TextUtils.isEmpty("sdk_app_id")) {
                a11.f48370c.edit().putInt("sdk_app_id", i12).commit();
            }
            a11.a("user_id", V2TIMManager.getInstance().getLoginUser());
            TUICommonDefine.RoomId roomId = this.f48322b.f48371a;
            int i13 = roomId.intRoomId;
            String str = roomId.strRoomId;
            if (i13 > 0) {
                str = String.valueOf(i13);
            }
            a11.a("room_id", str);
            int i14 = this.f48322b.f48371a.intRoomId > 0 ? 1 : 2;
            if (!TextUtils.isEmpty("room_id_type")) {
                a11.f48370c.edit().putInt("room_id_type", i14).commit();
            }
            String str2 = "";
            a11.a("group_id", TextUtils.isEmpty(this.f48322b.f48372b) ? str2 : this.f48322b.f48372b);
            a11.a("invitee_list", this.f48322b.f48374d.toString());
            a11.a("role", TUICallDefine.Role.Called.equals(this.f48322b.f48375e) ? "callee" : "caller");
            a11.a("invite_id", String.valueOf(this.f48322b.f48382l.get()));
            a11.a("initial_invite_id", String.valueOf(this.f48322b.f48383m.get()));
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48322b;
            a11.a("call_scene", o.a(aVar2.f48372b, aVar2.f48374d));
            if (this.f48322b.f48384n.get() != null) {
                str2 = this.f48322b.f48384n.get().toString().toLowerCase();
            }
            a11.a(MessengerShareContentUtility.MEDIA_TYPE, str2);
            p a12 = p.a(this.f48321a, "profile_call_status_detail");
            if (this.f48322b.f48381k.f48387a.get() != null) {
                boolean booleanValue = Boolean.valueOf(this.f48322b.f48381k.f48387a.get().booleanValue()).booleanValue();
                if (!TextUtils.isEmpty("ability_bit")) {
                    a12.f48370c.edit().putBoolean("ability_bit", booleanValue).commit();
                }
            }
        }
    }

    public final void a() {
        Handler handler = this.f48323c;
        if (handler != null) {
            handler.post(new a());
        }
    }

    public void a(long j11, String str) {
        LinkedHashMap linkedHashMap;
        p a11 = p.a(this.f48321a, "profile_call_status");
        if (!TextUtils.isEmpty("code")) {
            a11.f48370c.edit().putLong("code", j11).commit();
        }
        p.a(this.f48321a, "profile_call_status").a("message", str);
        Context context = this.f48321a;
        p a12 = p.a(context, "profile_call_base");
        if (a12.f48370c.getAll().isEmpty()) {
            linkedHashMap = null;
        } else {
            p a13 = p.a(context, "profile_call_status");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("code", Long.valueOf(a13.f48370c.getLong("code", 0)));
            linkedHashMap2.put("message", a13.f48370c.getString("message", ""));
            JSONObject jSONObject = new JSONObject(p.a(context, "profile_call_status_detail").f48370c.getAll());
            JSONObject jSONObject2 = new JSONObject(linkedHashMap2);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("result", a13.f48370c.getString("result", ""));
            linkedHashMap3.put("total_time", Long.valueOf(a13.f48370c.getLong("total_time", 0)));
            linkedHashMap3.put("detail", jSONObject);
            linkedHashMap3.put("error", jSONObject2);
            JSONObject jSONObject3 = new JSONObject(a12.f48370c.getAll());
            JSONObject jSONObject4 = new JSONObject(linkedHashMap3);
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("base_info", jSONObject3);
            linkedHashMap4.put("call_status", jSONObject4);
            linkedHashMap = linkedHashMap4;
        }
        if (linkedHashMap != null) {
            try {
                JSONObject jSONObject5 = new JSONObject(linkedHashMap);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(FirebaseAnalytics.Param.LEVEL, 1);
                jSONObject6.put(RemoteMessageConst.MessageBody.MSG, jSONObject5.toString());
                jSONObject6.put("more_msg", "TUICallEngine");
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("api", "reportOnlineLog");
                jSONObject7.put("params", jSONObject6);
                TRTCCloud.sharedInstance(context).callExperimentalAPI(jSONObject7.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        p.a(this.f48321a, "profile_call_base").a();
        p.a(this.f48321a, "profile_call_status").a();
        p.a(this.f48321a, "profile_call_status_detail").a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.qcloud.tuikit.tuicallengine.e.b r9) {
        /*
            com.tencent.qcloud.tuikit.tuicallengine.f.a r0 = r9.f48322b
            if (r0 == 0) goto L_0x0188
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r0 = r0.f48382l
            java.lang.Object r0 = r0.get()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0014
            goto L_0x0188
        L_0x0014:
            com.tencent.qcloud.tuikit.tuicallengine.h.e r0 = r9.f48324d
            if (r0 != 0) goto L_0x0021
            com.tencent.qcloud.tuikit.tuicallengine.h.e r0 = new com.tencent.qcloud.tuikit.tuicallengine.h.e
            android.content.Context r1 = r9.f48321a
            r0.<init>(r1)
            r9.f48324d = r0
        L_0x0021:
            com.tencent.qcloud.tuikit.tuicallengine.h.e r0 = r9.f48324d
            com.tencent.qcloud.tuikit.tuicallengine.f.a r9 = r9.f48322b
            r0.getClass()
            if (r9 == 0) goto L_0x0188
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r2 = r9.f48382l
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "call_id"
            r1.put(r3, r2)
            java.lang.String r2 = r9.f48373c
            java.lang.String r3 = "inviter"
            r1.put(r3, r2)
            java.util.List<java.lang.String> r2 = r9.f48374d
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "[\\[\\]]"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replaceAll(r3, r4)
            java.lang.String r3 = "remote_user_list"
            r1.put(r3, r2)
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r2 = r9.f48375e
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "role"
            r1.put(r3, r2)
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$MediaType> r2 = r9.f48384n
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "media_type"
            r1.put(r3, r2)
            java.lang.String r2 = r9.f48372b
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x007b
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Scene r2 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Scene.GROUP_CALL
            goto L_0x0089
        L_0x007b:
            java.util.List<java.lang.String> r2 = r9.f48374d
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0087
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Scene r2 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Scene.MULTI_CALL
            goto L_0x0089
        L_0x0087:
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Scene r2 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Scene.SINGLE_CALL
        L_0x0089:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "call_scene"
            r1.put(r3, r2)
            java.lang.String r2 = r9.f48372b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "group_id"
            r1.put(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.tencent.qcloud.tuikit.tuicallengine.k.a$a r3 = com.tencent.qcloud.tuikit.tuicallengine.k.a.C0607a.Unknown
            r2.add(r3)
            com.tencent.qcloud.tuikit.tuicallengine.k.a$a r3 = com.tencent.qcloud.tuikit.tuicallengine.k.a.C0607a.Reject
            r2.add(r3)
            com.tencent.qcloud.tuikit.tuicallengine.k.a$a r3 = com.tencent.qcloud.tuikit.tuicallengine.k.a.C0607a.Ignore
            r2.add(r3)
            com.tencent.qcloud.tuikit.tuicallengine.k.a$a r3 = com.tencent.qcloud.tuikit.tuicallengine.k.a.C0607a.Timeout
            r2.add(r3)
            com.tencent.qcloud.tuikit.tuicallengine.k.a$a r3 = com.tencent.qcloud.tuikit.tuicallengine.k.a.C0607a.BusyLine
            r2.add(r3)
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$CallRecords$Result r3 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.CallRecords.Result.Unknown
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r4 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Role.Caller
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r5 = r9.f48375e
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00ce
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$CallRecords$Result r3 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.CallRecords.Result.Outgoing
            goto L_0x00f1
        L_0x00ce:
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r5 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Role.Called
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r6 = r9.f48375e
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x00e7
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<com.tencent.qcloud.tuikit.tuicallengine.k.a$a> r6 = r9.f48385o
            java.lang.Object r6 = r6.get()
            boolean r2 = r2.contains(r6)
            if (r2 == 0) goto L_0x00e7
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$CallRecords$Result r3 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.CallRecords.Result.Missed
            goto L_0x00f1
        L_0x00e7:
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r2 = r9.f48375e
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00f1
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$CallRecords$Result r3 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.CallRecords.Result.Incoming
        L_0x00f1:
            int r2 = r3.ordinal()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "status"
            r1.put(r3, r2)
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r2 = r9.f48375e
            boolean r2 = r4.equals(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0122
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r2 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r2 = r2.f48388b
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0113
            goto L_0x0136
        L_0x0113:
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r2 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r2 = r2.f48388b
            java.lang.Object r2 = r2.get()
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            goto L_0x0147
        L_0x0122:
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r2 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Role.Called
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r5 = r9.f48375e
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0146
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r2 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r2 = r2.f48389c
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0137
        L_0x0136:
            goto L_0x0146
        L_0x0137:
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r2 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r2 = r2.f48389c
            java.lang.Object r2 = r2.get()
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            goto L_0x0147
        L_0x0146:
            r5 = r3
        L_0x0147:
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r2 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r2 = r2.f48391e
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0153
            r7 = r3
            goto L_0x0161
        L_0x0153:
            com.tencent.qcloud.tuikit.tuicallengine.f.a$a r9 = r9.f48381k
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.Long> r9 = r9.f48391e
            java.lang.Object r9 = r9.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r7 = r9.longValue()
        L_0x0161:
            long r7 = r7 - r5
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r3 = r7
        L_0x0168:
            java.lang.Long r9 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "begin_time"
            r1.put(r2, r9)
            java.lang.Long r9 = java.lang.Long.valueOf(r3)
            java.lang.String r2 = "total_time"
            r1.put(r2, r9)
            android.content.Context r9 = r0.f48465a
            com.tencent.qcloud.tuikit.tuicallengine.h.d r9 = com.tencent.qcloud.tuikit.tuicallengine.h.d.a((android.content.Context) r9)
            com.tencent.qcloud.tuikit.tuicallengine.h.a r0 = new com.tencent.qcloud.tuikit.tuicallengine.h.a
            r0.<init>(r9, r1)
            r9.a((java.lang.Runnable) r0)
        L_0x0188:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallengine.e.b.a(com.tencent.qcloud.tuikit.tuicallengine.e.b):void");
    }
}
