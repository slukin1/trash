package com.huobi.otc.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.huobi.otc.bean.OtcCallEndEvent;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.bean.VoiceSignInfo;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallkit.TUICallKit;
import java.util.List;
import jp.l;
import org.greenrobot.eventbus.EventBus;

public class OtcVoiceHelper {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f78921a;

    /* renamed from: b  reason: collision with root package name */
    public static String f78922b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f78923c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f78924d;

    /* renamed from: e  reason: collision with root package name */
    public static VoiceInfo f78925e;

    /* renamed from: f  reason: collision with root package name */
    public static TUICallObserver f78926f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final TUILoginListener f78927g = new f();

    public class a extends TUICallObserver {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f78928a = new C0841a();

        /* renamed from: b  reason: collision with root package name */
        public long f78929b;

        /* renamed from: com.huobi.otc.helper.OtcVoiceHelper$a$a  reason: collision with other inner class name */
        public class C0841a implements Runnable {
            public C0841a() {
            }

            public void run() {
                if (TUICallKit.getInstance() != null) {
                    TUICallKit.getInstance().hangup((TUICommonDefine.Callback) null);
                }
            }
        }

        public void onCallBegin(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
            super.onCallBegin(roomId, mediaType, role);
            this.f78929b = System.currentTimeMillis();
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onCallBegin", 0);
                if (OtcVoiceHelper.f78925e != null) {
                    ThreadUtils.postOnUiThreadDelayed(this.f78928a, (long) (OtcVoiceHelper.f78925e.getSingleVoiceTime() * 1000));
                }
            }
        }

        public void onCallCancelled(String str) {
            super.onCallCancelled(str);
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onCallCancelled", 0);
            }
            boolean unused = OtcVoiceHelper.f78924d = false;
            boolean unused2 = OtcVoiceHelper.f78923c = false;
        }

        public void onCallEnd(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role, long j11) {
            super.onCallEnd(roomId, mediaType, role, j11);
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onCallEnd", System.currentTimeMillis() - this.f78929b);
                ThreadUtils.removeRunnableOnUiThread(this.f78928a);
            }
            boolean unused = OtcVoiceHelper.f78924d = false;
            boolean unused2 = OtcVoiceHelper.f78923c = false;
        }

        public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
            super.onCallReceived(str, list, str2, mediaType, str3);
            boolean unused = OtcVoiceHelper.f78923c = false;
            boolean unused2 = OtcVoiceHelper.f78924d = true;
            this.f78929b = System.currentTimeMillis();
            String unused3 = OtcVoiceHelper.f78922b = str3;
            VoiceInfo unused4 = OtcVoiceHelper.f78925e = null;
            OtcVoiceHelper.q("onCallReceived", 0);
        }

        public void onError(int i11, String str) {
            super.onError(i11, str);
            boolean unused = OtcVoiceHelper.f78924d = false;
            boolean unused2 = OtcVoiceHelper.f78923c = false;
        }

        public void onUserLineBusy(String str) {
            super.onUserLineBusy(str);
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onUserLineBusy", 0);
            }
        }

        public void onUserNoResponse(String str) {
            super.onUserNoResponse(str);
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onUserNoResponse", 0);
            }
        }

        public void onUserReject(String str) {
            super.onUserReject(str);
            if (OtcVoiceHelper.f78923c) {
                OtcVoiceHelper.q("onUserReject", 0);
            }
        }
    }

    public class b extends EasySubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f78931b;

        public b(String str) {
            this.f78931b = str;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (TextUtils.equals(this.f78931b, "onCallEnd") && bool.booleanValue()) {
                EventBus.d().k(new OtcCallEndEvent(OtcVoiceHelper.f78922b));
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class c extends TUICallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f78932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICallback f78933b;

        public c(Context context, TUICallback tUICallback) {
            this.f78932a = context;
            this.f78933b = tUICallback;
        }

        public void onError(int i11, String str) {
        }

        public void onSuccess() {
            boolean unused = OtcVoiceHelper.f78921a = false;
            OtcVoiceHelper.n(this.f78932a, this.f78933b);
        }
    }

    public class d extends EasySubscriber<VoiceSignInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f78934b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICallback f78935c;

        public class a extends TUICallback {

            /* renamed from: com.huobi.otc.helper.OtcVoiceHelper$d$a$a  reason: collision with other inner class name */
            public class C0842a implements Runnable {
                public C0842a() {
                }

                public void run() {
                    OtcVoiceHelper.o(d.this.f78934b, false, (TUICallback) null);
                }
            }

            public a() {
            }

            public void onError(int i11, String str) {
                ThreadUtils.postOnUiThreadDelayed(new C0842a(), 5000);
            }

            public void onSuccess() {
                TUICallback tUICallback = d.this.f78935c;
                if (tUICallback != null) {
                    tUICallback.onSuccess();
                }
            }
        }

        public d(Context context, TUICallback tUICallback) {
            this.f78934b = context;
            this.f78935c = tUICallback;
        }

        /* renamed from: a */
        public void onNext(VoiceSignInfo voiceSignInfo) {
            super.onNext(voiceSignInfo);
            OtcVoiceHelper.p(this.f78934b, voiceSignInfo, new a());
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class e extends TUICallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f78938a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICallback f78939b;

        public class a implements TUICommonDefine.Callback {
            public a() {
            }

            public void onError(int i11, String str) {
            }

            public void onSuccess() {
            }
        }

        public e(Context context, TUICallback tUICallback) {
            this.f78938a = context;
            this.f78939b = tUICallback;
        }

        public void onError(int i11, String str) {
            boolean unused = OtcVoiceHelper.f78921a = false;
            TUICallback tUICallback = this.f78939b;
            if (tUICallback != null) {
                tUICallback.onError(i11, str);
            }
        }

        public void onSuccess() {
            boolean unused = OtcVoiceHelper.f78921a = true;
            TUICallKit.createInstance(this.f78938a).enableFloatWindow(true).setTUICallObserverOut(OtcVoiceHelper.f78926f);
            TUICallEngine.createInstance(this.f78938a).enableMultiDeviceAbility(true, new a());
            TUICallback tUICallback = this.f78939b;
            if (tUICallback != null) {
                tUICallback.onSuccess();
            }
        }
    }

    public class f extends TUILoginListener {
        public void onKickedOffline() {
            super.onKickedOffline();
            boolean unused = OtcVoiceHelper.f78921a = false;
        }

        public void onUserSigExpired() {
            super.onUserSigExpired();
            boolean unused = OtcVoiceHelper.f78921a = false;
        }
    }

    public class g implements TUICommonDefine.Callback {
        public void onError(int i11, String str) {
            boolean unused = OtcVoiceHelper.f78924d = false;
            boolean unused2 = OtcVoiceHelper.f78923c = false;
        }

        public void onSuccess() {
            OtcVoiceHelper.q("SYSTEMPUSH", 0);
        }
    }

    public class h extends TUICallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f78941a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f78942b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VoiceInfo f78943c;

        public h(Context context, String str, VoiceInfo voiceInfo) {
            this.f78941a = context;
            this.f78942b = str;
            this.f78943c = voiceInfo;
        }

        public void onError(int i11, String str) {
        }

        public void onSuccess() {
            Context context = this.f78941a;
            if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
                OtcVoiceHelper.m(this.f78941a, this.f78942b, this.f78943c);
            }
        }
    }

    public static void m(Context context, String str, VoiceInfo voiceInfo) {
        if (voiceInfo != null && !TextUtils.isEmpty(voiceInfo.getReceiveTxUserid()) && !f78924d) {
            if (f78921a) {
                f78923c = true;
                f78924d = true;
                f78922b = str;
                f78925e = voiceInfo;
                TUICallDefine.CallParams callParams = new TUICallDefine.CallParams();
                callParams.userData = str;
                TUICallKit.createInstance(context).call(voiceInfo.getReceiveTxUserid(), TUICallDefine.MediaType.Audio, callParams, new g());
                return;
            }
            o(context, false, new h(context, str, voiceInfo));
        }
    }

    public static void n(Context context, TUICallback tUICallback) {
        l.t(m0.a()).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new d(context, tUICallback));
    }

    public static void o(Context context, boolean z11, TUICallback tUICallback) {
        if (z11 && f78921a) {
            TUILogin.logout((TUICallback) new c(context, tUICallback));
        }
        if (!f78921a) {
            n(context, tUICallback);
        }
    }

    public static void p(Context context, VoiceSignInfo voiceSignInfo, TUICallback tUICallback) {
        TUILogin.addLoginListener(f78927g);
        TUILogin.login(context, SystemUtils.c() ? 20000142 : 20000241, voiceSignInfo.getTencentUserId(), voiceSignInfo.getUserSign(), new e(context, tUICallback));
    }

    public static void q(String str, long j11) {
        l.N(str, j11 / 1000, f78922b).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new b(str));
    }
}
