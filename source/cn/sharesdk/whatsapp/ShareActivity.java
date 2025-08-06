package cn.sharesdk.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.luck.picture.lib.config.SelectMimeType;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import java.io.File;
import java.util.HashMap;

public class ShareActivity extends FakeActivity {
    private static final int REQUEST_CODE_INTERACTIVE_MSG = 1;
    private static final String WHATSSAP_APP_ID = "com.whatsapp";
    private PlatformActionListener listener;
    private Platform platform;

    public void onActivityResult(int i11, int i12, Intent intent) {
        HashMap hashMap = new HashMap();
        finish();
        if (i11 == 1 && intent != null) {
            try {
                if (intent.getExtras() != null) {
                    for (String str : intent.getExtras().keySet()) {
                        hashMap.put(str, intent.getExtras().get(str));
                    }
                }
            } catch (Throwable th2) {
                this.listener.onComplete(this.platform, 9, hashMap);
                throw th2;
            }
        }
        this.listener.onComplete(this.platform, 9, hashMap);
    }

    public void onCreate() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e11) {
            SSDKLog.b().a((Throwable) e11);
        }
        Bundle extras = this.activity.getIntent().getExtras();
        String string = extras.getString(ShareConstants.MEDIA_URI);
        String string2 = extras.getString("path");
        String string3 = extras.getString("title");
        String string4 = extras.getString("text");
        String string5 = extras.getString(PlaceFields.PHONE);
        int i11 = extras.getInt("type");
        if (!TextUtils.isEmpty(string)) {
            try {
                startActivityForResult(new Intent("android.intent.action.SEND", Uri.parse(string)), 1);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        } else {
            Intent intent = new Intent("android.intent.action.SEND");
            if (1 == i11 && (!TextUtils.isEmpty(string4) || !TextUtils.isEmpty(string3))) {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", string3);
                intent.putExtra("android.intent.extra.TEXT", string4);
            } else if (2 == i11 && !TextUtils.isEmpty(string2)) {
                try {
                    File file = new File(string2);
                    Context context = MobSDK.getContext();
                    Uri a11 = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                    MobSDK.getContext().grantUriPermission(SSOAuthHandler.TWITTER_PACKAGE_NAME, a11, 3);
                    intent.putExtra("android.intent.extra.STREAM", a11);
                    intent.setType(SelectMimeType.SYSTEM_IMAGE);
                    if (!TextUtils.isEmpty(string4)) {
                        intent.putExtra("android.intent.extra.TEXT", string4);
                    }
                } catch (Throwable th3) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("whatsapp shareActivity image path switch bitmap catch: " + th3, new Object[0]);
                }
            } else if (6 == i11 && !TextUtils.isEmpty(string2)) {
                intent.setType(SelectMimeType.SYSTEM_VIDEO);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(string2));
            } else if (100 == i11 && !TextUtils.isEmpty(string5)) {
                intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + string5));
            }
            intent.setPackage(WHATSSAP_APP_ID);
            intent.addFlags(1);
            try {
                startActivityForResult(intent, 1);
            } catch (Throwable th4) {
                SSDKLog.b().a(th4);
            }
        }
    }

    public void setPlatformActionListener(Platform platform2, PlatformActionListener platformActionListener) {
        this.platform = platform2;
        this.listener = platformActionListener;
    }
}
