package com.tencent.qcloud.tuikit.tuicallengine.g;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import java.util.HashMap;
import java.util.List;

public class a {

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.g.a$a  reason: collision with other inner class name */
    public class C0603a implements V2TIMSendCallback<V2TIMMessage> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48452a;

        public C0603a(a aVar, String str) {
            this.f48452a = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("CallingOfflinePushManager", "sendOfflineMessage from [" + V2TIMManager.getInstance().getLoginUser() + "] to [" + this.f48452a + "] failed, errorCode: " + i11 + " ,errorMsg: " + str);
        }

        public void onProgress(int i11) {
        }

        public void onSuccess(Object obj) {
            V2TIMMessage v2TIMMessage = (V2TIMMessage) obj;
        }
    }

    public void a(List<String> list, TUICallDefine.CallParams callParams) {
        if (list == null || list.isEmpty()) {
            TUILog.w("CallingOfflinePushManager", "sendOfflinePushMessage, param is empty");
            return;
        }
        HashMap hashMap = new HashMap();
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        hashMap.put("businessID", TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID);
        V2TIMMessage createCustomMessage = V2TIMManager.getMessageManager().createCustomMessage(new Gson().toJson((Object) hashMap).getBytes());
        V2TIMOfflinePushInfo a11 = a(callParams);
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                V2TIMManager.getMessageManager().sendMessage(createCustomMessage, next, (String) null, 0, true, a11, new C0603a(this, next));
            }
        }
    }

    public V2TIMOfflinePushInfo a(TUICallDefine.CallParams callParams) {
        TUICallDefine.OfflinePushInfo offlinePushInfo;
        if (callParams == null || (offlinePushInfo = callParams.offlinePushInfo) == null) {
            return null;
        }
        TUILog.i("CallingOfflinePushManager", "createV2TIMOfflinePushInfo, info: " + offlinePushInfo);
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setTitle(offlinePushInfo.getTitle());
        v2TIMOfflinePushInfo.setDesc(offlinePushInfo.getDesc());
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID(offlinePushInfo.getAndroidOPPOChannelID());
        v2TIMOfflinePushInfo.setIgnoreIOSBadge(offlinePushInfo.isIgnoreIOSBadge());
        v2TIMOfflinePushInfo.setAndroidSound(offlinePushInfo.getAndroidSound());
        v2TIMOfflinePushInfo.setIOSSound(offlinePushInfo.getIOSSound());
        v2TIMOfflinePushInfo.setAndroidVIVOClassification(offlinePushInfo.getAndroidVIVOClassification());
        v2TIMOfflinePushInfo.setAndroidFCMChannelID(offlinePushInfo.getAndroidFCMChannelID());
        v2TIMOfflinePushInfo.setAndroidHuaWeiCategory(offlinePushInfo.getAndroidHuaWeiCategory());
        v2TIMOfflinePushInfo.setAndroidXiaoMiChannelID(offlinePushInfo.getAndroidXiaoMiChannelID());
        v2TIMOfflinePushInfo.disablePush(offlinePushInfo.isDisablePush());
        int ordinal = TUICallDefine.IOSOfflinePushType.APNs.ordinal();
        if (offlinePushInfo.getIOSPushType() != null) {
            ordinal = offlinePushInfo.getIOSPushType().ordinal();
        }
        v2TIMOfflinePushInfo.setIOSPushType(ordinal);
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put("action", 2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("fcmPushType", 0);
        hashMap2.put("fcmNotificationType", 1);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("entity", hashMap);
        hashMap3.put("timPushFeatures", hashMap2);
        v2TIMOfflinePushInfo.setExt(gson.toJson((Object) hashMap3).getBytes());
        return v2TIMOfflinePushInfo;
    }
}
