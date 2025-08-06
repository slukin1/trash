package cn.sharesdk.whatsapp;

import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.f;
import com.facebook.places.model.PlaceFields;
import com.mob.MobSDK;

public class a extends f {
    public a(Platform platform) {
        super(platform);
    }

    public void a(int i11, String str, String str2, PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra("type", i11);
        intent.putExtra("path", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("text", str2);
        }
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.show(MobSDK.getContext(), intent);
    }

    public String getAuthorizeUrl() {
        return null;
    }

    public b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return null;
    }

    public String getRedirectUri() {
        return null;
    }

    public void a(String str, String str2, PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra("type", 1);
        intent.putExtra("text", str);
        intent.putExtra("title", str2);
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.show(MobSDK.getContext(), intent);
    }

    public void a(String str, PlatformActionListener platformActionListener) {
        Intent intent = new Intent();
        intent.putExtra("type", 100);
        intent.putExtra(PlaceFields.PHONE, str);
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(this.f13438a, platformActionListener);
        shareActivity.show(MobSDK.getContext(), intent);
    }
}
