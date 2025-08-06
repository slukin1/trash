package cn.sharesdk.kakao.story;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.luck.picture.lib.config.SelectMimeType;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import java.io.File;
import java.util.HashMap;

public class ShareActivity extends FakeActivity {
    public static final String AUTHORIZE = "auth";
    private static final String EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
    private static final String EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
    private static final String EXTRA_REDIRECT_URL = "com.kakao.sdk.talk.redirectUrl";
    private static final int REQUEST_CODE_AUTH = 3;
    private static final int REQUEST_CODE_INTERACTIVE_IMAGE = 2;
    private static final int REQUEST_CODE_INTERACTIVE_MSG = 1;
    public static final String SHARE = "share";
    private String action;
    private PlatformActionListener listener;
    private Platform platform;

    public void onActivityResult(int i11, int i12, Intent intent) {
        finish();
        if (1 == i11 || 2 == i11) {
            HashMap hashMap = new HashMap();
            if (!(intent == null || intent.getExtras() == null)) {
                for (String str : intent.getExtras().keySet()) {
                    hashMap.put(str, intent.getExtras().get(str));
                }
            }
            this.listener.onComplete(this.platform, 9, hashMap);
        } else if (i11 != 3) {
        } else {
            if (i12 == -1) {
                try {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString(EXTRA_ERROR_TYPE);
                    String string2 = extras.getString(EXTRA_REDIRECT_URL);
                    if (string == null && string2 != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(EXTRA_REDIRECT_URL, string2);
                        this.listener.onComplete(this.platform, 1, hashMap2);
                    } else if (string == null || !string.equals("NotSupportError")) {
                        String string3 = extras.getString(EXTRA_ERROR_DESCRIPTION);
                        PlatformActionListener platformActionListener = this.listener;
                        Platform platform2 = this.platform;
                        platformActionListener.onError(platform2, 1, new Throwable(string + ";msg=" + string3));
                    } else {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(EXTRA_REDIRECT_URL, "LoggedOut");
                        this.listener.onComplete(this.platform, 1, hashMap3);
                    }
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("kakaoStory onActivityResult error" + th2);
                }
            } else {
                this.listener.onCancel(this.platform, 1);
            }
        }
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
        if (this.action.equals("auth")) {
            try {
                startActivityForResult((Intent) extras.getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK), 3);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        } else if (this.action.equals("share")) {
            String string = extras.getString(ShareConstants.MEDIA_URI);
            String string2 = extras.getString("path");
            String string3 = extras.getString("title");
            String string4 = extras.getString("text");
            int i11 = extras.getInt("type");
            if (!TextUtils.isEmpty(string)) {
                try {
                    startActivityForResult(new Intent("android.intent.action.SEND", Uri.parse(string)), 1);
                } catch (Throwable th3) {
                    SSDKLog.b().a(th3);
                }
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                if (1 == i11 && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string3)) {
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", string3);
                    intent.putExtra("android.intent.extra.TEXT", string4);
                } else if (2 == i11 && !TextUtils.isEmpty(string2)) {
                    intent.setType(SelectMimeType.SYSTEM_IMAGE);
                    try {
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(MobSDK.getContext().getContentResolver(), string2, new File(string2).getName(), "shareimg")));
                    } catch (Throwable th4) {
                        SSDKLog.b().a(th4);
                    }
                } else if (6 == i11 && !TextUtils.isEmpty(string2)) {
                    try {
                        File file = new File(string2);
                        if (file.exists()) {
                            Context context = MobSDK.getContext();
                            Uri a11 = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            SSDKLog b11 = SSDKLog.b();
                            b11.a("ShareSDKFileProvider localUri== " + a11, new Object[0]);
                            MobSDK.getContext().grantUriPermission("com.kakao.story", a11, 3);
                            intent.setType(SelectMimeType.SYSTEM_VIDEO);
                            intent.putExtra("android.intent.extra.STREAM", a11);
                        } else {
                            return;
                        }
                    } catch (Throwable th5) {
                        SSDKLog.b().a(th5);
                    }
                }
                intent.setPackage("com.kakao.story");
                try {
                    startActivityForResult(intent, 2);
                } catch (Throwable th6) {
                    SSDKLog.b().a(th6);
                }
            }
        }
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setPlatformActionListener(Platform platform2, PlatformActionListener platformActionListener) {
        this.platform = platform2;
        this.listener = platformActionListener;
    }
}
