package com.huobi.social.share;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.kakao.talk.KakaoTalk;
import com.facebook.share.internal.ShareConstants;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.kakao.sdk.share.ShareClient;
import com.kakao.sdk.share.model.ImageUploadResult;
import i6.d;
import java.io.File;
import java.util.HashMap;
import kotlin.Unit;
import org.greenrobot.eventbus.EventBus;
import vr.j;

public class b extends vr.a {

    public class a implements PlatformActionListener {
        public a() {
        }

        public void onCancel(Platform platform, int i11) {
        }

        public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
            d.c("ShareKaKao", "分享成功");
            we.b.l("share_event_back", String.class).g("success");
        }

        public void onError(Platform platform, int i11, Throwable th2) {
            d.c("ShareKaKao", "分享失败:" + th2.getMessage());
            we.b.l("share_event_back", String.class).g("fail");
        }
    }

    /* renamed from: com.huobi.social.share.b$b  reason: collision with other inner class name */
    public class C0848b implements PlatformActionListener {
        public C0848b() {
        }

        public void onCancel(Platform platform, int i11) {
        }

        public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
            d.c("ShareKaKao", "分享成功");
            we.b.l("share_event_back", String.class).g("success");
        }

        public void onError(Platform platform, int i11, Throwable th2) {
            d.c("ShareKaKao", "分享失败:" + th2.getMessage());
            we.b.l("share_event_back", String.class).g("fail");
        }
    }

    public b(Context context) {
        super(context);
        String[] strArr = {"com.kakao.talk"};
        int i11 = 0;
        while (i11 < 1) {
            boolean b11 = PackageManagerUtil.b(new String[]{strArr[i11]});
            this.f85013a = b11;
            if (!b11) {
                i11++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit l(ImageUploadResult imageUploadResult, Throwable th2) {
        if (imageUploadResult != null) {
            String url = imageUploadResult.getInfos().getOriginal().getUrl();
            int width = imageUploadResult.getInfos().getOriginal().getWidth();
            int height = imageUploadResult.getInfos().getOriginal().getHeight();
            Platform platform = ShareSDK.getPlatform(KakaoTalk.NAME);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            HashMap hashMap = new HashMap();
            hashMap.put("image", url);
            hashMap.put("width", "" + width);
            hashMap.put("height", "" + height);
            shareParams.setKakaoCustomTemplate(hashMap);
            shareParams.setShareType(20);
            shareParams.setKakaoCustomTemplateId("81652");
            platform.setPlatformActionListener(new C0848b());
            platform.share(shareParams);
        }
        if (th2 == null) {
            return null;
        }
        d.c("ShareKaKao", "分享失败:" + th2.getMessage());
        we.b.l("share_event_back", String.class).g("fail");
        return null;
    }

    public void a() {
        super.a();
        EventBus.d().k(new ShareBusEvent(HBShareHelper.HbPlatform.TYPE_KA_KAO, ShareBusEvent.Type.COMPLETED));
    }

    public void c(String str, String str2, String str3) {
        File file = new File(str2);
        if (file.exists()) {
            ShareClient.b().e(file, true, new j(this));
        }
    }

    public void e(String str, String str2, String str3) {
        Platform platform = ShareSDK.getPlatform(KakaoTalk.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        HashMap hashMap = new HashMap();
        hashMap.put(ShareConstants.TITLE, str);
        hashMap.put("URL", str3);
        shareParams.setKakaoCustomTemplate(hashMap);
        shareParams.setShareType(20);
        shareParams.setKakaoCustomTemplateId("81651");
        platform.setPlatformActionListener(new a());
        platform.share(shareParams);
    }
}
