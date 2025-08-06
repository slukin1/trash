package com.tencent.qcloud.tuikit.tuicallengine.i;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.huobi.finance.bean.FinanceRecordItem;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.e.m;
import com.tencent.qcloud.tuikit.tuicallengine.e.o;
import com.tencent.qcloud.tuikit.tuicallengine.f.g;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.i.a;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.k.b;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import com.tencent.trtc.TRTCCloud;
import java.lang.ref.WeakReference;
import java.util.List;

public class h extends a {

    /* renamed from: h  reason: collision with root package name */
    public long f48505h = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f48506i;

    /* renamed from: j  reason: collision with root package name */
    public SignalingData f48507j;

    public class a implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48508a;

        public a(TUICommonDefine.Callback callback) {
            this.f48508a = callback;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4SingleCalling", "call failed, errorCode: " + i11 + " , errorMsg: " + str);
            TUICommonDefine.Callback callback = this.f48508a;
            if (callback != null) {
                callback.onError(i11, str);
            }
            h.this.b();
        }

        public void onSuccess() {
            TUILog.i("V4SingleCalling", "call success");
            TUICommonDefine.Callback callback = this.f48508a;
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    public class b implements V2TIMCallback {
        public b() {
        }

        public void onError(int i11, String str) {
            TUILog.e("V4SingleCalling", "accept SwitchToAudio failed, callID: " + h.this.f48471c.f48382l.get() + " , errorCode:" + i11 + " , errorMsg:" + str);
        }

        public void onSuccess() {
            h.this.b(TUICallDefine.MediaType.Audio);
        }
    }

    public class c implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48511a;

        public c(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
            this.f48511a = bVar;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4SingleCalling", "sendAcceptSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48511a;
            bVar.f48536d.post(new b.c(i11, str));
            h.this.e((String) null);
        }

        public void onSuccess() {
            h hVar = h.this;
            if (hVar.f48471c.f48377g) {
                k.f48439a = hVar.f48469a;
                k.b.f48445a.c();
            }
            this.f48511a.a();
        }
    }

    public class d implements V2TIMCallback {
        public d(h hVar) {
        }

        public void onError(int i11, String str) {
            TUILog.e("V4SingleCalling", "sendRejectSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
        }

        public void onSuccess() {
        }
    }

    public class e implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48513a;

        public e(h hVar, String str) {
            this.f48513a = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4SingleCalling", "markInviteSignalingConsumed failed, inviteId: " + this.f48513a + " ,errorCode: " + i11 + " ,errorMsg: " + str);
        }

        public void onSuccess() {
        }
    }

    public h(Context context) {
        super(context);
    }

    public void a(TUICommonDefine.Callback callback) {
        TUILog.i("V4SingleCalling", "accept");
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        aVar.f48376f = TUICallDefine.Status.Accept;
        aVar.f48386p.set(m.AcceptCall);
        this.f48474f = callback;
        b(this.f48471c.f48382l.get(), this.f48507j);
        k.f48439a = this.f48469a;
        k kVar = k.b.f48445a;
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
        kVar.a(aVar2.f48371a, aVar2.f48384n.get());
    }

    public void b(TUICommonDefine.Callback callback) {
        SignalingData a11 = o.a(this.f48471c, 0);
        this.f48507j = a11;
        a11.getData().setExcludeFromHistoryMessage(true);
        String a12 = o.a(this.f48507j);
        String str = this.f48471c.f48374d.get(0);
        TUILog.i("V4SingleCalling", "call sendInvite, user: " + str + " , inviteData: " + a12);
        V2TIMOfflinePushInfo a13 = this.f48472d.a(this.f48471c.f48380j);
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        TUICallDefine.CallParams callParams = this.f48471c.f48380j;
        this.f48471c.f48382l.set(V2TIMManager.getSignalingManager().invite(str, a12, false, a13, callParams != null ? callParams.timeout : 30, new a(callback)));
    }

    public void c(TUICommonDefine.Callback callback) {
        TUILog.i("V4SingleCalling", "hangup callRole: " + this.f48471c.f48375e + " , status: " + this.f48471c.f48376f);
        if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
            if (TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f)) {
                b(this.f48471c.f48382l.get(), this.f48507j);
                String b11 = o.b(this.f48471c);
                TUILog.i("V4SingleCalling", "sendCancelSignaling, cancelData: " + b11);
                V2TIMManager.getSignalingManager().cancel(this.f48471c.f48382l.get(), b11, new i(this));
                this.f48471c.f48385o.set(a.C0607a.Cancel);
                this.f48471c.f48386p.set(m.CancelCall);
                b(V2TIMManager.getInstance().getLoginUser());
                b();
            } else {
                e((String) null);
            }
        } else if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e)) {
            if (TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f)) {
                e(callback);
            } else {
                e((String) null);
            }
        }
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public void d(TUICommonDefine.Callback callback) {
        TUILog.i("V4SingleCalling", "ignoreCalling");
        this.f48471c.f48385o.set(a.C0607a.Ignore);
        this.f48471c.f48386p.set(m.IgnoreCall);
        b(this.f48471c.f48382l.get(), this.f48507j);
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        a(aVar.f48382l.get(), o.a(aVar.f48373c, this.f48471c.f48384n.get(), true));
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
        b(V2TIMManager.getInstance().getLoginUser());
        b();
    }

    public void e(TUICommonDefine.Callback callback) {
        TUILog.i("V4SingleCalling", FinanceRecordItem.STATE_REJECT);
        b(this.f48471c.f48382l.get(), this.f48507j);
        a(this.f48471c.f48382l.get(), o.a(o.c(this.f48471c)));
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
        this.f48471c.f48385o.set(a.C0607a.Reject);
        this.f48471c.f48386p.set(m.RejectCall);
        b(V2TIMManager.getInstance().getLoginUser());
        b();
    }

    public void a(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        b(str, signalingData);
        SignalingData.DataInfo data = signalingData.getData();
        if (data.getUserIDs() != null && !data.getUserIDs().isEmpty()) {
            list = data.getUserIDs();
        }
        TUILog.i("V4SingleCalling", "lineBusy inviteID: " + str + ", inviter: " + str2 + ", userIds: " + list);
        TUICallDefine.MediaType mediaType = TUICallDefine.MediaType.values()[signalingData.getCallType()];
        com.tencent.qcloud.tuikit.tuicallengine.j.c.a(str, str2, mediaType);
        if (list != null && list.size() > 1 && TextUtils.isEmpty(str3)) {
            for (String next : list) {
                if (!this.f48471c.f48373c.equals(next)) {
                    com.tencent.qcloud.tuikit.tuicallengine.j.c.a(next, str2, mediaType, (V2TIMCallback) null);
                }
            }
        }
    }

    public void b(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        if (o.d(signalingData)) {
            SignalingData.DataInfo data = signalingData.getData();
            if (!"hangup".equals(data.getCmd())) {
                if ("switchToAudio".equals(data.getCmd())) {
                    d(str);
                } else if ("lineBusy".equals(data.getCmd())) {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        jVar.d(str2);
                        this.f48470b.a(str2);
                    }
                    b();
                } else {
                    a(str2, signalingData);
                }
            }
        } else {
            this.f48471c.f48384n.set(TUICallDefine.MediaType.values()[signalingData.getCallType()]);
            this.f48471c.f48371a.intRoomId = signalingData.getRoomId();
            if (signalingData.getCallEnd() != 0) {
                e((String) null);
                return;
            }
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            if ("switch_to_audio_call".equals(signalingData.getSwitchToAudioCall())) {
                d(str);
            } else {
                a(str2, signalingData);
            }
        }
    }

    public final void e(String str) {
        TUILog.i("V4SingleCalling", "preExitRoom, mIsInRoom: " + this.f48471c.f48377g + " , leaveUser: " + str);
        if (!TextUtils.isEmpty(str) && this.f48471c.f48377g) {
            String a11 = o.a(o.a(this.f48471c, ((int) (o.b() - this.f48505h)) / 1000));
            TUILog.i("V4SingleCalling", "sendHangupSignaling, user: " + str + " , hangupData: " + a11);
            V2TIMManager.getSignalingManager().invite(str, a11, false, (V2TIMOfflinePushInfo) null, 0, new j(this));
        }
        if (TUICallDefine.Status.Accept.equals(this.f48471c.f48376f)) {
            a();
        } else {
            b(V2TIMManager.getInstance().getLoginUser());
        }
        b();
    }

    public final void d(String str) {
        if (!TUICallDefine.MediaType.Video.equals(this.f48471c.f48384n.get())) {
            SignalingData a11 = o.a();
            SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
            dataInfo.setCmd("switchToAudio");
            dataInfo.setExcludeFromHistoryMessage(true);
            a11.setSwitchToAudioCall("switchToAudio");
            dataInfo.setMessage("reject, remote user call type is not video call");
            a11.setData(dataInfo);
            GsonBuilder gsonBuilder = new GsonBuilder();
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            o.a(gsonBuilder, "call_end");
            a(str, gsonBuilder.create().toJson((Object) a11));
            return;
        }
        SignalingData a12 = o.a();
        SignalingData.DataInfo dataInfo2 = new SignalingData.DataInfo();
        dataInfo2.setCmd("switchToAudio");
        dataInfo2.setExcludeFromHistoryMessage(true);
        a12.setSwitchToAudioCall("switchToAudio");
        a12.setData(dataInfo2);
        GsonBuilder gsonBuilder2 = new GsonBuilder();
        int i12 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        o.a(gsonBuilder2, "call_end");
        V2TIMManager.getSignalingManager().accept(str, gsonBuilder2.create().toJson((Object) a12), new b());
    }

    public void c(String str, String str2, SignalingData signalingData) {
        String str3 = this.f48471c.f48382l.get();
        TUILog.i("V4SingleCalling", "inviteeRejected inviteID: " + str + ", invitee: " + str2 + " , data: " + signalingData + " , curCallID: " + str3);
        if (!TextUtils.isEmpty(str3) && str.equals(str3) && !o.e(signalingData)) {
            if (o.c(signalingData)) {
                j jVar = this.f48470b;
                if (jVar != null) {
                    jVar.d(str2);
                }
                this.f48471c.f48385o.set(a.C0607a.BusyLine);
                this.f48471c.f48386p.set(m.CallBusy);
            } else if (a(str2)) {
                TUILog.i("V4SingleCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
                if (this.f48475g) {
                    b(V2TIMManager.getInstance().getLoginUser());
                    b();
                    return;
                }
                return;
            } else {
                j jVar2 = this.f48470b;
                if (jVar2 != null) {
                    jVar2.f(str2);
                }
                this.f48471c.f48385o.set(a.C0607a.Reject);
                this.f48471c.f48386p.set(m.CallRejected);
            }
            b(V2TIMManager.getInstance().getLoginUser());
            b();
        }
    }

    public void a(TUICallDefine.MediaType mediaType) {
        SignalingData signalingData;
        if (mediaType == null) {
            TUILog.e("V4SingleCalling", "switchCallMediaType failed, callMediaType param doesn't exist");
        } else if (mediaType.equals(this.f48471c.f48384n.get())) {
            TUILog.e("V4SingleCalling", "switchCallMediaType failed, new callMediaType is same as old callMediaType");
        } else {
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            String str = aVar.f48373c;
            if (TUICallDefine.Role.Caller.equals(aVar.f48375e) && !this.f48471c.f48374d.isEmpty()) {
                str = this.f48471c.f48374d.get(0);
            }
            String str2 = str;
            int ordinal = this.f48471c.f48384n.get().ordinal();
            TUICommonDefine.RoomId roomId = this.f48471c.f48371a;
            SignalingData a11 = o.a();
            a11.setCallType(ordinal);
            a11.setRoomId(roomId.intRoomId);
            SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
            dataInfo.setCmd("switchToAudio");
            dataInfo.setRoomID(roomId.intRoomId);
            dataInfo.setStrRoomId(roomId.strRoomId);
            dataInfo.setExcludeFromHistoryMessage(true);
            a11.setSwitchToAudioCall("switchToAudio");
            a11.setData(dataInfo);
            GsonBuilder gsonBuilder = new GsonBuilder();
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            o.a(gsonBuilder, "call_end");
            String json = gsonBuilder.create().toJson((Object) a11);
            int i12 = 30;
            TUICallDefine.CallParams callParams = this.f48471c.f48380j;
            if (callParams != null) {
                i12 = callParams.timeout;
            }
            this.f48506i = V2TIMManager.getSignalingManager().invite(str2, json, false, (V2TIMOfflinePushInfo) null, i12, new k(this));
            if (TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f) && (signalingData = this.f48507j) != null && signalingData.getData() != null) {
                signalingData.setCallType(TUICallDefine.MediaType.Audio.ordinal());
                SignalingData.DataInfo data = signalingData.getData();
                data.setCmd("audioCall");
                signalingData.setData(data);
                V2TIMManager.getSignalingManager().modifyInvitation(this.f48471c.f48382l.get(), new GsonBuilder().create().toJson((Object) signalingData), new l(this));
            }
        }
    }

    public void b(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4SingleCalling", "inviteeAccepted inviteID: " + str + " , invitee: " + str2 + " , data: " + signalingData + " , mCurCallingInfo.callId: " + this.f48471c.f48382l.get());
        if (o.e(signalingData)) {
            if (!TextUtils.isEmpty(str) && str.equals(this.f48506i)) {
                b(TUICallDefine.MediaType.Audio);
            }
        } else if (!TextUtils.isEmpty(this.f48471c.f48382l.get()) && str.equals(this.f48471c.f48382l.get())) {
            if (a(str2)) {
                TUILog.i("V4SingleCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
                if (this.f48475g) {
                    b(V2TIMManager.getInstance().getLoginUser());
                    b();
                    return;
                }
                return;
            }
            TUICallDefine.Status status = TUICallDefine.Status.Accept;
            if (!status.equals(this.f48471c.f48376f)) {
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
                aVar.f48376f = status;
                aVar.f48386p.set(m.CallAccepted);
                k.f48439a = this.f48469a;
                k.b.f48445a.c();
                TRTCCloud.sharedInstance(this.f48469a).muteLocalVideo(0, false);
                if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
                        jVar.a(aVar2.f48371a, aVar2.f48384n.get(), this.f48471c.f48375e);
                    }
                    this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
                    if (this.f48475g) {
                        o.a(status, (TUICommonDefine.Callback) null);
                    }
                }
            }
        }
    }

    public void c(String str) {
        this.f48505h = o.b();
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.b(str);
        }
    }

    public final void a(String str, SignalingData signalingData) {
        if (signalingData.getData().getConsumed()) {
            TUILog.w("V4SingleCalling", "handleDialingSignaling ignore, signaling has been consumed");
            b();
            return;
        }
        this.f48507j = signalingData;
        this.f48471c.f48386p.set(m.ReceiveCall);
        j jVar = this.f48470b;
        if (jVar != null) {
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            jVar.a(str, aVar.f48374d, "", aVar.f48384n.get(), signalingData.getUserData());
        }
    }

    public final void b(TUICallDefine.MediaType mediaType) {
        if (!this.f48471c.f48384n.get().equals(mediaType)) {
            j jVar = this.f48470b;
            if (jVar != null) {
                TUICallDefine.MediaType mediaType2 = this.f48471c.f48384n.get();
                TUILog.i("CallingObserverManager", "onCallMediaTypeChanged, oldCallMediaType: " + mediaType2 + " ,newCallMediaType: " + mediaType);
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        jVar.f48413b.post(new g(jVar, (TUICallObserver) next.get(), mediaType2, mediaType));
                    }
                }
            }
            if (TUICallDefine.MediaType.Audio.equals(mediaType)) {
                TRTCCloud.sharedInstance(this.f48469a).stopLocalPreview();
            }
            this.f48471c.f48384n.set(mediaType);
        }
    }

    public void a(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4SingleCalling", "invitationCancelled inviteID: " + str + " , inviter: " + str2 + " , data: " + signalingData + " , curCallId: " + this.f48471c.f48382l.get());
        if (str.equals(this.f48471c.f48382l.get())) {
            this.f48471c.f48385o.set(a.C0607a.Cancel);
            this.f48471c.f48386p.set(m.CallCanceled);
            j jVar = this.f48470b;
            if (jVar != null) {
                jVar.a(str2);
            }
            b();
        }
    }

    public final void b() {
        if (this.f48471c.f48377g) {
            k.f48439a = this.f48469a;
            k.b.f48445a.b();
        }
        this.f48471c.a();
        this.f48505h = 0;
        this.f48506i = "";
        this.f48507j = null;
        this.f48474f = null;
        a.C0604a aVar = this.f48473e;
        if (aVar != null) {
            com.tencent.qcloud.tuikit.tuicallengine.a.a(com.tencent.qcloud.tuikit.tuicallengine.a.this);
            this.f48473e = null;
        }
    }

    public void a(String str, List<String> list) {
        TUILog.i("V4SingleCalling", "invitationTimeout inviteID: " + str + " , curCallId: " + this.f48471c.f48382l.get() + " ,inviteeList: " + list);
        if (str.equals(this.f48471c.f48382l.get())) {
            if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
                for (String next : list) {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        jVar.e(next);
                    }
                }
                this.f48471c.f48386p.set(m.CallMissed);
            } else {
                this.f48471c.f48386p.set(m.NotAnswerCall);
            }
            this.f48471c.f48385o.set(a.C0607a.Timeout);
            b(V2TIMManager.getInstance().getLoginUser());
            b();
        }
    }

    public final void b(String str, SignalingData signalingData) {
        if (signalingData != null && signalingData.getData() != null) {
            SignalingData.DataInfo data = signalingData.getData();
            data.setConsumed(Boolean.TRUE);
            signalingData.setData(data);
            V2TIMManager.getSignalingManager().modifyInvitation(str, new GsonBuilder().create().toJson((Object) signalingData), new e(this, str));
        }
    }

    public void a(long j11) {
        if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e)) {
            a(TUICallDefine.Status.Accept);
            j jVar = this.f48470b;
            if (jVar != null) {
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
                jVar.a(aVar.f48371a, aVar.f48384n.get(), this.f48471c.f48375e);
            }
            this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48474f);
            String a11 = o.a(this.f48471c);
            TUILog.i("V4SingleCalling", "sendAcceptSignaling, acceptData: " + a11);
            V2TIMManager.getSignalingManager().accept(this.f48471c.f48382l.get(), a11, new c(bVar));
        }
    }

    public void a(String str, int i11) {
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.c(str);
        }
        e(str);
    }

    public final void a(String str, String str2) {
        TUILog.i("V4SingleCalling", "sendRejectSignaling,inviteId: " + str + " ,rejectData: " + str2);
        V2TIMManager.getSignalingManager().reject(str, str2, new d(this));
    }
}
