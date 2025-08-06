package com.tencent.qcloud.tuikit.tuicallengine.j;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.e.o;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public class c {

    public static class a implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ V2TIMCallback f48517a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48518b;

        public a(V2TIMCallback v2TIMCallback, String str) {
            this.f48517a = v2TIMCallback;
            this.f48518b = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("SignalingSendUtils", "sendLineBusySignalingToInvitee failed, userId: " + this.f48518b + " ,errorCode: " + i11 + " errorMsg: " + str);
            V2TIMCallback v2TIMCallback = this.f48517a;
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(i11, str);
            }
        }

        public void onSuccess() {
            V2TIMCallback v2TIMCallback = this.f48517a;
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        }
    }

    public static void a(String str, String str2, TUICallDefine.MediaType mediaType) {
        V2TIMManager.getSignalingManager().reject(str, o.a(str2, mediaType, true), new b(str));
    }

    public static void a(String str, String str2, TUICallDefine.MediaType mediaType, V2TIMCallback v2TIMCallback) {
        String str3 = str;
        V2TIMManager.getSignalingManager().invite(str3, o.a(str2, mediaType, false), false, (V2TIMOfflinePushInfo) null, 0, new a((V2TIMCallback) null, str));
    }
}
