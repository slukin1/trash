package com.hbg.module.huobi.im.imsignal;

import android.content.Context;
import android.util.Log;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.libkt.provider.HbgImProvider;
import com.huobi.framework.im.common.ImCommonCallback;
import com.huobi.framework.im.common.ImManager;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMUserInfo;
import od.d;

public class IMSdk {

    public class a extends V2TIMSDKListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ od.a f20513a;

        public a(od.a aVar) {
            this.f20513a = aVar;
        }

        public void onConnectFailed(int i11, String str) {
            super.onConnectFailed(i11, str);
            Log.d("IMSdk", "连接腾讯云服务器失败");
            od.a aVar = this.f20513a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public void onConnectSuccess() {
            super.onConnectSuccess();
            Log.d("IMSdk", "已经成功连接到腾讯云服务器");
            od.a aVar = this.f20513a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void onConnecting() {
            super.onConnecting();
            Log.d("IMSdk", "正在连接到腾讯云服务器");
        }

        public void onUserSigExpired() {
            super.onUserSigExpired();
            Log.d("IMSdk", "秘钥过期，请重新生成");
            od.a aVar = this.f20513a;
            if (aVar != null) {
                aVar.onUserSigExpired();
            }
        }
    }

    public class b implements ImCommonCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ od.b f20514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ od.c f20515b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20516c;

        public class a extends V2TIMSimpleMsgListener {
            public a() {
            }

            public void onRecvC2CTextMessage(String str, V2TIMUserInfo v2TIMUserInfo, String str2) {
                super.onRecvC2CTextMessage(str, v2TIMUserInfo, str2);
                Log.d("IMSdk", "get message Success" + str2);
                od.c cVar = b.this.f20515b;
                if (cVar != null) {
                    cVar.a(str, str2);
                }
            }
        }

        public b(od.b bVar, od.c cVar, String str) {
            this.f20514a = bVar;
            this.f20515b = cVar;
            this.f20516c = str;
        }

        public static /* synthetic */ void b(String str, UserOtherInfoData userOtherInfoData) {
            String str2;
            if (userOtherInfoData != null) {
                if (userOtherInfoData.getNick_name() != null && !userOtherInfoData.getNick_name().isEmpty()) {
                    str = userOtherInfoData.getNick_name();
                } else if (userOtherInfoData.getPhone() != null && !userOtherInfoData.getPhone().isEmpty()) {
                    str = userOtherInfoData.getPhone();
                } else if (userOtherInfoData.getEmail() != null && !userOtherInfoData.getEmail().isEmpty()) {
                    str = userOtherInfoData.getEmail();
                }
                str2 = userOtherInfoData.getHead_image();
            } else {
                str2 = null;
            }
            IMSdk.e(str, str2);
        }

        public void onFailed(int i11, String str) {
            Log.d("huxiao", "登录失败:" + str);
            od.b bVar = this.f20514a;
            if (bVar != null) {
                bVar.a();
            }
        }

        public void onSuccess() {
            Log.d("huxiao", "登录成功");
            IMConversationHelper.o().s();
            od.b bVar = this.f20514a;
            if (bVar != null) {
                bVar.b();
                ImManager.INSTANCE.addSimpleMsgListener(new a());
                if (BaseModuleConfig.a().a()) {
                    ((HbgImProvider) b2.a.d().a("/provider/im_userinfo").navigation()).a(new d(this.f20516c));
                } else {
                    IMSdk.e(this.f20516c, (String) null);
                }
            }
        }
    }

    public class c implements V2TIMCallback {
        public void onError(int i11, String str) {
            Log.d("IMSdk", "设置昵称失败" + i11 + str);
        }

        public void onSuccess() {
            Log.d("IMSdk", "设置昵称成功");
        }
    }

    public static void b() {
        IMConversationHelper.o().y();
    }

    public static void c(Context context, int i11, od.a aVar) {
        if (context == null) {
            Log.d("IMSdk", "IMSDK initialize failed!!!");
            return;
        }
        ImManager imManager = ImManager.INSTANCE;
        imManager.addIMSDKListener(new a(aVar));
        imManager.init(context.getApplicationContext(), i11, (V2TIMSDKConfig) null, (V2TIMSDKListener) null);
    }

    public static void d(String str, String str2, String str3, od.b bVar, od.c cVar) {
        ImManager.INSTANCE.login(str, str2, new b(bVar, cVar, str3));
    }

    public static void e(String str, String str2) {
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setNickname(str);
        if (str2 != null) {
            v2TIMUserFullInfo.setFaceUrl(str2);
        }
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, new c());
    }
}
