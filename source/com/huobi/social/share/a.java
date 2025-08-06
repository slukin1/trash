package com.huobi.social.share;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.File;
import org.greenrobot.eventbus.EventBus;
import we.b;

public class a extends vr.a {
    public a(Context context) {
        super(context);
        String[] strArr = {"com.facebook.orca", "com.facebook.katana", "com.example.facebook", "com.facebook.android"};
        int i11 = 0;
        while (i11 < 4) {
            boolean b11 = PackageManagerUtil.b(new String[]{strArr[i11]});
            this.f85013a = b11;
            if (!b11) {
                i11++;
            } else {
                return;
            }
        }
    }

    public void a() {
        super.a();
        EventBus.d().k(new ShareBusEvent(HBShareHelper.HbPlatform.TYPE_FACEBOOK, ShareBusEvent.Type.COMPLETED));
    }

    public void c(String str, String str2, String str3) {
        if (new File(str2).exists()) {
            new ShareDialog((Activity) this.f85014b).show((ShareContent) new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(BitmapFactory.decodeFile(str2)).build()).build(), ShareDialog.Mode.AUTOMATIC);
            b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            new ShareDialog((Activity) this.f85014b).show((ShareContent) ((ShareLinkContent.Builder) ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str))).setShareHashtag(new ShareHashtag.Builder().setHashtag("").build())).build(), ShareDialog.Mode.AUTOMATIC);
            b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }

    public void e(String str, String str2, String str3) {
        d(str3);
    }
}
