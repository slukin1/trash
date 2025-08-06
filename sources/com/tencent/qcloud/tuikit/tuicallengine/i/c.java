package com.tencent.qcloud.tuikit.tuicallengine.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huobi.finance.bean.FinanceRecordItem;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSignalingManager;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.a;
import com.tencent.qcloud.tuikit.tuicallengine.e.o;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.i.a;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import com.tencent.trtc.TRTCCloud;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c extends a {

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, String> f48491h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f48492i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    public final HashSet<String> f48493j = new HashSet<>();

    /* renamed from: k  reason: collision with root package name */
    public boolean f48494k;

    /* renamed from: l  reason: collision with root package name */
    public final Handler f48495l = new C0606c(Looper.getMainLooper());

    public class a implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48496a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48497b;

        public a(TUICommonDefine.Callback callback, String str) {
            this.f48496a = callback;
            this.f48497b = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4MultiCalling", "invite call failed, errorCode: " + i11 + " errorMsg: " + str);
            j jVar = c.this.f48470b;
            if (jVar != null) {
                jVar.c(this.f48497b);
            }
            c.this.f48492i.remove(this.f48497b);
            c.this.a(false);
        }

        public void onSuccess() {
            TUILog.i("V4MultiCalling", "invite call success");
            TUICommonDefine.Callback callback = this.f48496a;
            if (callback != null && !c.this.f48494k) {
                callback.onSuccess();
                boolean unused = c.this.f48494k = true;
            }
        }
    }

    public class b implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48499a;

        public b(String str) {
            this.f48499a = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4MultiCalling", "inviteUser failed, errorCode: " + i11 + " errorMsg: " + str);
            j jVar = c.this.f48470b;
            if (jVar != null) {
                jVar.c(this.f48499a);
            }
            c.this.a(false);
        }

        public void onSuccess() {
            TUILog.i("V4MultiCalling", "inviteUser success");
            c.this.f48492i.add(this.f48499a);
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.i.c$c  reason: collision with other inner class name */
    public class C0606c extends Handler {
        public C0606c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Iterator it2 = new ArrayList(c.this.f48492i).iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!TextUtils.isEmpty(str) && !c.this.f48493j.contains(str)) {
                        c.this.f48492i.remove(str);
                        j jVar = c.this.f48470b;
                        if (jVar != null) {
                            jVar.e(str);
                        }
                        c.this.a(false);
                    }
                }
            }
        }
    }

    public class d implements V2TIMCallback {
        public d(c cVar) {
        }

        public void onError(int i11, String str) {
            TUILog.e("V4MultiCalling", "sendHangupSignaling failed,errorCode: " + i11 + " , errorMsg: " + str);
        }

        public void onSuccess() {
            TUILog.i("V4MultiCalling", "sendHangupSignaling success");
        }
    }

    public c(Context context) {
        super(context);
    }

    public void b(TUICommonDefine.Callback callback) {
        List<String> list = this.f48471c.f48374d;
        this.f48492i.addAll(list);
        String a11 = o.a(o.a(this.f48471c, o.b()));
        V2TIMOfflinePushInfo a12 = this.f48472d.a(this.f48471c.f48380j);
        TUILog.i("V4MultiCalling", "multiCall sendInvite, inviteeList: " + list + " ,inviteData: " + a11);
        for (String next : list) {
            V2TIMSignalingManager signalingManager = V2TIMManager.getSignalingManager();
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            this.f48491h.put(next, signalingManager.invite(next, a11, false, a12, 30, new a(callback, next)));
        }
    }

    public void c(TUICommonDefine.Callback callback) {
        TUILog.i("V4MultiCalling", "hangup callRole: " + this.f48471c.f48375e + " ,status: " + this.f48471c.f48376f);
        if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
            if (!TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f) || !this.f48493j.isEmpty()) {
                a(this.f48492i);
                a();
            } else {
                String b11 = o.b(this.f48471c);
                TUILog.i("V4MultiCalling", "sendCancelSignaling, cancelData: " + b11);
                for (Map.Entry next : this.f48491h.entrySet()) {
                    if (next != null) {
                        String str = (String) next.getValue();
                        V2TIMManager.getSignalingManager().cancel(str, b11, new f(this, str));
                    }
                }
                b(V2TIMManager.getInstance().getLoginUser());
            }
        } else if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e) && TUICallDefine.Status.Accept.equals(this.f48471c.f48376f)) {
            a(this.f48492i);
            a();
        }
        b();
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public void d(TUICommonDefine.Callback callback) {
        TUILog.i("V4MultiCalling", "ignoreCalling");
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        a(this.f48471c.f48382l.get(), aVar.f48373c, aVar.f48372b, aVar.f48374d, aVar.f48379i);
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public void e(TUICommonDefine.Callback callback) {
        TUILog.i("V4MultiCalling", FinanceRecordItem.STATE_REJECT);
        SignalingData c11 = o.c(this.f48471c);
        c11.getData().setExcludeFromHistoryMessage(true);
        String a11 = o.a(c11);
        TUILog.i("V4MultiCalling", "sendRejectSignaling, rejectData: " + a11);
        V2TIMManager.getSignalingManager().reject(this.f48471c.f48382l.get(), a11, new g(this));
        b();
        b(V2TIMManager.getInstance().getLoginUser());
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public void a(List<String> list, TUICallDefine.CallParams callParams, TUICommonDefine.ValueCallback valueCallback) {
        List<String> list2 = list;
        list.remove(V2TIMManager.getInstance().getLoginUser());
        ArrayList arrayList = new ArrayList(list);
        arrayList.retainAll(this.f48492i);
        list.remove(arrayList);
        int size = this.f48492i.size() + list.size();
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        if (size > 8) {
            ((a.l.C0591a.C0592a) valueCallback).onError(TUICallDefine.ERROR_PARAM_INVALID, "inviteUser exceeding max user number");
            return;
        }
        ((a.l.C0591a.C0592a) valueCallback).onSuccess(list);
        String a11 = o.a(this.f48471c, list, new ArrayList(this.f48492i), callParams, o.b());
        V2TIMOfflinePushInfo a12 = this.f48472d.a(callParams);
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                V2TIMSignalingManager signalingManager = V2TIMManager.getSignalingManager();
                int i12 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                this.f48491h.put(next, signalingManager.invite(next, a11, false, a12, 30, new b(next)));
            }
        }
    }

    public final String d(String str) {
        return this.f48491h.get(str);
    }

    public void b(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        TUILog.i("V4MultiCalling", "receiveNewInvitation inviteID: " + str + ", inviter: " + str2 + ", groupID: " + str3 + ", inviteeList: " + list + " data: " + signalingData);
        SignalingData.DataInfo data = signalingData.getData();
        if ("hangup".equals(data.getCmd())) {
            j jVar = this.f48470b;
            if (jVar != null) {
                jVar.c(str2);
            }
            this.f48492i.remove(str2);
            this.f48493j.remove(str2);
            a(true);
        } else if ("lineBusy".equals(data.getCmd())) {
            j jVar2 = this.f48470b;
            if (jVar2 != null) {
                jVar2.d(str2);
            }
            this.f48492i.remove(str2);
            this.f48493j.remove(str2);
            a(false);
        } else {
            TUILog.i("V4MultiCalling", "handleDialingSignaling, mCurCallingInfo: " + this.f48471c.toString());
            this.f48491h.put(str2, str);
            k.f48439a = this.f48469a;
            k kVar = k.b.f48445a;
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            kVar.a(aVar.f48371a, aVar.f48384n.get());
            List<String> inCallUserIDs = signalingData.getData().getInCallUserIDs();
            TUILog.i("V4MultiCalling", "receiveNewInvitation, addUserIds: " + inCallUserIDs);
            if (inCallUserIDs != null) {
                this.f48492i.addAll(inCallUserIDs);
            }
            this.f48492i.addAll(this.f48471c.f48374d);
            j jVar3 = this.f48470b;
            if (jVar3 != null) {
                jVar3.a(str2, new ArrayList(this.f48492i), "", this.f48471c.f48384n.get(), signalingData.getUserData());
            }
            this.f48492i.remove(V2TIMManager.getInstance().getLoginUser());
            this.f48492i.add(str2);
            if (inCallUserIDs == null || inCallUserIDs.isEmpty()) {
                TUILog.w("V4MultiCalling", "checkAddUserIDsStatus, addUserIds is empty");
            } else {
                o.a(inCallUserIDs, (TUICommonDefine.ValueCallback) new d(this));
            }
            long b11 = o.b() - data.getInviteTime();
            TUILog.i("V4MultiCalling", "checkUnResponseUser, interval: " + b11);
            if (b11 >= 0) {
                int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                long j11 = ((long) 30) * 1000;
                if (b11 <= j11) {
                    this.f48495l.sendEmptyMessageDelayed(1, j11 - b11);
                }
            }
        }
    }

    public void a(TUICommonDefine.Callback callback) {
        TUILog.i("V4MultiCalling", "accept");
        String a11 = o.a(this.f48471c);
        TUILog.i("V4MultiCalling", "sendAcceptSignaling, acceptData: " + a11);
        V2TIMManager.getSignalingManager().accept(this.f48471c.f48382l.get(), a11, new e(this));
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        TUICallDefine.Status status = TUICallDefine.Status.Accept;
        aVar.f48376f = status;
        a(status);
        j jVar = this.f48470b;
        if (jVar != null) {
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
            jVar.a(aVar2.f48371a, aVar2.f48384n.get(), this.f48471c.f48375e);
        }
        this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public void c(String str) {
        TUILog.i("V4MultiCalling", "onRemoteUserEnterRoom userId: " + str);
    }

    public void c(String str, String str2, SignalingData signalingData) {
        String str3 = this.f48491h.get(str2);
        TUILog.i("V4MultiCalling", "inviteeRejected inviteID: " + str + ", invitee: " + str2 + " , data: " + signalingData + " , curCallID: " + str3);
        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
            if (o.c(signalingData)) {
                j jVar = this.f48470b;
                if (jVar != null) {
                    jVar.d(str2);
                }
            } else if (a(str2)) {
                TUILog.i("V4MultiCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
                if (this.f48475g) {
                    b(V2TIMManager.getInstance().getLoginUser());
                    b();
                    return;
                }
                return;
            }
            this.f48492i.remove(str2);
            this.f48493j.remove(str2);
            a(false);
        }
    }

    public void a(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        SignalingData.DataInfo data = signalingData.getData();
        if (data.getUserIDs() != null && !data.getUserIDs().isEmpty()) {
            list = data.getUserIDs();
        }
        TUILog.i("V4MultiCalling", "lineBusy inviteID: " + str + ", inviter: " + str2 + ", userIds: " + list);
        TUICallDefine.MediaType mediaType = TUICallDefine.MediaType.values()[signalingData.getCallType()];
        com.tencent.qcloud.tuikit.tuicallengine.j.c.a(str, str2, mediaType);
        if (list != null && list.size() > 1 && TextUtils.isEmpty(str3)) {
            for (String next : list) {
                if (!this.f48492i.contains(next) && !this.f48471c.f48373c.equals(next)) {
                    com.tencent.qcloud.tuikit.tuicallengine.j.c.a(next, str2, mediaType, (V2TIMCallback) null);
                }
            }
        }
    }

    public void a(String str, List<String> list) {
        TUILog.i("V4MultiCalling", "invitationTimeout inviteID: " + str + " , inviteeList: " + list);
        if (!list.contains(V2TIMManager.getInstance().getLoginUser())) {
            for (String next : list) {
                TUILog.i("V4MultiCalling", "invitationTimeout, userId: " + next + " , callId: " + d(next));
                if (!str.equals(d(next))) {
                    TUILog.w("V4MultiCalling", "invitationTimeout, ignore");
                } else {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        jVar.e(next);
                    }
                    this.f48492i.remove(next);
                    this.f48493j.remove(next);
                    a(false);
                }
            }
        } else if (!str.equals(this.f48471c.f48382l.get())) {
            TUILog.i("V4MultiCalling", "invitationTimeout, callId: " + this.f48471c.f48382l.get());
        } else {
            b();
            b(V2TIMManager.getInstance().getLoginUser());
        }
    }

    public void b(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4MultiCalling", "inviteeAccepted inviteID: " + str + ", invitee: " + str2 + " data: " + signalingData);
        TUICallDefine.Status status = TUICallDefine.Status.Accept;
        if (!status.equals(this.f48471c.f48376f)) {
            if (a(str2)) {
                TUILog.i("V4MultiCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
                if (this.f48475g) {
                    b(V2TIMManager.getInstance().getLoginUser());
                    b();
                    return;
                }
                return;
            }
            j jVar = this.f48470b;
            if (jVar != null) {
                jVar.b(str2);
            }
            if (!status.equals(this.f48471c.f48376f)) {
                k.f48439a = this.f48469a;
                k.b.f48445a.c();
                TRTCCloud.sharedInstance(this.f48469a).muteLocalVideo(0, false);
                if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
                    j jVar2 = this.f48470b;
                    if (jVar2 != null) {
                        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
                        jVar2.a(aVar.f48371a, aVar.f48384n.get(), this.f48471c.f48375e);
                    }
                    this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
                    if (this.f48475g) {
                        o.a(status, (TUICommonDefine.Callback) null);
                    }
                }
                this.f48471c.f48376f = status;
            }
        }
    }

    public void a(long j11) {
        if (j11 < 0) {
            HashSet hashSet = new HashSet(this.f48471c.f48374d);
            hashSet.add(this.f48471c.f48373c);
            hashSet.remove(V2TIMManager.getInstance().getLoginUser());
            a((HashSet<String>) hashSet);
        }
    }

    public void a(String str, int i11) {
        TUILog.i("V4MultiCalling", "onRemoteUserLeaveRoom userId: " + str + " , inviter: " + this.f48471c.f48373c);
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.c(str);
        }
        boolean contains = this.f48493j.contains(str);
        this.f48492i.remove(str);
        this.f48493j.remove(str);
        a(contains);
    }

    public void a(String str, boolean z11) {
        j jVar;
        TUILog.i("V4MultiCalling", "onUserAudioAvailable userId: " + str + " , available: " + z11);
        this.f48493j.add(str);
        if (z11 && (jVar = this.f48470b) != null) {
            jVar.b(str);
        }
    }

    public final void a(boolean z11) {
        TUILog.i("V4MultiCalling", "preExitRoom: mCallingUserList: " + this.f48492i + " , mAcceptUserSet: " + this.f48493j);
        if (this.f48492i.isEmpty() && this.f48493j.isEmpty()) {
            if (z11) {
                a();
            } else {
                b(V2TIMManager.getInstance().getLoginUser());
            }
            b();
        }
    }

    public void b(String str, boolean z11) {
        TUILog.i("V4MultiCalling", "onUserVideoAvailable userId: " + str + " , available: " + z11);
    }

    public final void b() {
        TUILog.i("V4MultiCalling", "stopCall");
        k.f48439a = this.f48469a;
        k.b.f48445a.b();
        this.f48471c.a();
        this.f48492i.clear();
        this.f48493j.clear();
        this.f48491h.clear();
        a.C0604a aVar = this.f48473e;
        if (aVar != null) {
            com.tencent.qcloud.tuikit.tuicallengine.a.a(com.tencent.qcloud.tuikit.tuicallengine.a.this);
            this.f48473e = null;
        }
        this.f48494k = false;
    }

    public void a(String str, String str2, SignalingData signalingData) {
        String str3 = this.f48491h.get(str2);
        TUILog.i("V4MultiCalling", "invitationCancelled inviteID: " + str + " , inviter: " + str2 + " , data: " + signalingData + " , curCallID: " + str3);
        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
            b();
            j jVar = this.f48470b;
            if (jVar != null) {
                jVar.a(str2);
            }
        }
    }

    public final void a(HashSet<String> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            TUILog.i("V4MultiCalling", "sendHangupSignaling: inviteeList is empty");
            return;
        }
        String a11 = o.a(o.a(this.f48471c, 0));
        Iterator<String> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            V2TIMManager.getSignalingManager().invite(it2.next(), a11, false, (V2TIMOfflinePushInfo) null, 0, new d(this));
        }
    }
}
