package com.tencent.qcloud.tuikit.tuicallkit.config;

import android.content.Context;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;

public class OfflinePushInfoConfig {
    public static TUICallDefine.OfflinePushInfo createOfflinePushInfo(Context context) {
        TUICallDefine.OfflinePushInfo offlinePushInfo = new TUICallDefine.OfflinePushInfo();
        offlinePushInfo.setTitle(TUILogin.getNickName());
        offlinePushInfo.setDesc(context.getString(R.string.tuicalling_have_a_new_call));
        offlinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
        offlinePushInfo.setIgnoreIOSBadge(false);
        offlinePushInfo.setIOSSound("phone_ringing.mp3");
        offlinePushInfo.setAndroidSound("phone_ringing");
        offlinePushInfo.setAndroidVIVOClassification(1);
        offlinePushInfo.setAndroidFCMChannelID(OfflinePushInfoUtils.FCM_PUSH_CHANNEL_ID);
        offlinePushInfo.setAndroidHuaWeiCategory("IM");
        offlinePushInfo.setIOSPushType(TUICallDefine.IOSOfflinePushType.APNs);
        return offlinePushInfo;
    }
}
