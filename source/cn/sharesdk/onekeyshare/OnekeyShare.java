package cn.sharesdk.onekeyshare;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.mob.MobApplication;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnekeyShare {
    public static final String SHARESDK_TAG = "ShareSDK";
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public HashMap<String, Object> params;

    public OnekeyShare() {
        HashMap<String, Object> hashMap = new HashMap<>();
        this.params = hashMap;
        hashMap.put("customers", new ArrayList());
        this.params.put("hiddenPlatforms", new HashMap());
    }

    public void addHiddenPlatform(String str) {
        ((HashMap) ResHelper.forceCast(this.params.get("hiddenPlatforms"))).put(str, str);
    }

    public void disableSSOWhenAuthorize() {
        this.params.put("disableSSO", Boolean.TRUE);
    }

    public PlatformActionListener getCallback() {
        return (PlatformActionListener) ResHelper.forceCast(this.params.get(TUIConstants.TUIChat.CALL_BACK));
    }

    public ShareContentCustomizeCallback getShareContentCustomizeCallback() {
        return (ShareContentCustomizeCallback) ResHelper.forceCast(this.params.get("customizeCallback"));
    }

    public String getText() {
        if (this.params.containsKey("text")) {
            return String.valueOf(this.params.get("text"));
        }
        return null;
    }

    public void setActivity(Activity activity) {
        this.params.put("activity", activity);
    }

    public void setAddress(String str) {
        this.params.put(InnerShareParams.ADDRESS, str);
    }

    public void setCallback(PlatformActionListener platformActionListener) {
        this.params.put(TUIConstants.TUIChat.CALL_BACK, platformActionListener);
    }

    public void setComment(String str) {
        this.params.put(InnerShareParams.COMMENT, str);
    }

    public void setCustomerLogo(Bitmap bitmap, String str, View.OnClickListener onClickListener) {
        CustomerLogo customerLogo = new CustomerLogo();
        customerLogo.logo = bitmap;
        customerLogo.label = str;
        customerLogo.listener = onClickListener;
        ((ArrayList) ResHelper.forceCast(this.params.get("customers"))).add(customerLogo);
    }

    public void setDialogMode(boolean z11) {
        this.params.put("dialogMode", Boolean.valueOf(z11));
    }

    public void setDisappearShareToast(boolean z11) {
        this.params.put("disappearsharetoast", Boolean.valueOf(z11));
    }

    public void setExecuteUrl(String str) {
        this.params.put("executeurl", str);
    }

    public void setFilePath(String str) {
        this.params.put(InnerShareParams.FILE_PATH, str);
    }

    public void setHashtag(String str) {
        this.params.put("HASHTAG", str);
    }

    public void setHashtags(String[] strArr) {
        this.params.put(InnerShareParams.HASHTAGS, strArr);
    }

    public void setImageArray(String[] strArr) {
        this.params.put(InnerShareParams.IMAGE_ARRAY, strArr);
    }

    public void setImageData(Bitmap bitmap) {
        if (bitmap != null) {
            this.params.put(InnerShareParams.IMAGE_DATA, bitmap);
        }
    }

    public void setImagePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.params.put(InnerShareParams.IMAGE_PATH, str);
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.params.put(InnerShareParams.IMAGE_URL, str);
        }
    }

    public void setInstallUrl(String str) {
        this.params.put("installurl", str);
    }

    public void setLatitude(float f11) {
        this.params.put("latitude", Float.valueOf(f11));
    }

    public void setLinkedinDescription(String str) {
        this.params.put(InnerShareParams.LINKEDIN_DESCRIPTION, str);
    }

    public void setLongitude(float f11) {
        this.params.put("longitude", Float.valueOf(f11));
    }

    public void setMusicUrl(String str) {
        this.params.put(InnerShareParams.MUSIC_URL, str);
    }

    public void setPlatform(String str) {
        this.params.put("platform", str);
    }

    public void setQQMiniProgramAppid(String str) {
        this.params.put(InnerShareParams.QQ_MINI_PROGRAM_APPID, str);
    }

    public void setQQMiniProgramPath(String str) {
        this.params.put(InnerShareParams.QQ_MINI_PROGRAM_PATH, str);
    }

    public void setQQMiniProgramType(String str) {
        this.params.put(InnerShareParams.QQ_MINI_PROGRAM_TYPE, str);
    }

    public void setQuote(String str) {
        this.params.put("QUOTE", str);
    }

    public void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.params.put("customizeCallback", shareContentCustomizeCallback);
    }

    public void setShareToTencentWeiboWhenPerformingQQOrQZoneSharing() {
        this.params.put(InnerShareParams.IS_SHARE_TENCENT_WEIBO, Boolean.TRUE);
    }

    public void setSilent(boolean z11) {
        this.params.put("silent", Boolean.valueOf(z11));
    }

    public void setSite(String str) {
        this.params.put(InnerShareParams.SITE, str);
    }

    public void setSiteUrl(String str) {
        this.params.put(InnerShareParams.SITE_URL, str);
    }

    public void setText(String str) {
        this.params.put("text", str);
    }

    public void setTheme(OnekeyShareTheme onekeyShareTheme) {
        this.params.put("theme", Integer.valueOf(onekeyShareTheme.getValue()));
    }

    public void setTitle(String str) {
        this.params.put("title", str);
    }

    public void setTitleUrl(String str) {
        this.params.put(InnerShareParams.TITLE_URL, str);
    }

    public void setUrl(String str) {
        this.params.put("url", str);
    }

    public void setVenueDescription(String str) {
        this.params.put(InnerShareParams.VENUE_DESCRIPTION, str);
    }

    public void setVenueName(String str) {
        this.params.put(InnerShareParams.VENUE_NAME, str);
    }

    public void setVideoArray(String[] strArr) {
        this.params.put(InnerShareParams.VIDEO_ARRAY, strArr);
    }

    public void setVideoPath(String str) {
        this.params.put("videoPath", str);
    }

    public void setVideoUrl(String str) {
        this.params.put("url", str);
        this.params.put(InnerShareParams.SHARE_TYPE, 6);
    }

    public void setViewToShare(View view) {
        try {
            this.params.put("viewToShare", BitmapHelper.captureView(view, view.getWidth(), view.getHeight()));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void show(final Context context) {
        try {
            this.executorService.execute(new Runnable() {
                public void run() {
                    int i11;
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(OnekeyShare.this.params);
                        Context context = context;
                        if (!(context instanceof MobApplication)) {
                            MobSDK.init(context.getApplicationContext());
                        }
                        ShareSDK.logDemoEvent(1, (Platform) null);
                        boolean z11 = false;
                        try {
                            i11 = ResHelper.parseInt(String.valueOf(hashMap.remove("theme")));
                        } catch (Throwable unused) {
                            i11 = 0;
                        }
                        OnekeyShareThemeImpl impl = OnekeyShareTheme.fromValue(i11).getImpl();
                        impl.setShareParamsMap(hashMap);
                        impl.setDialogMode(hashMap.containsKey("dialogMode") ? ((Boolean) hashMap.remove("dialogMode")).booleanValue() : false);
                        if (hashMap.containsKey("silent")) {
                            z11 = ((Boolean) hashMap.remove("silent")).booleanValue();
                        }
                        impl.setSilent(z11);
                        impl.setCustomerLogos((ArrayList) hashMap.remove("customers"));
                        impl.setHiddenPlatforms((HashMap) hashMap.remove("hiddenPlatforms"));
                        impl.setPlatformActionListener((PlatformActionListener) hashMap.remove(TUIConstants.TUIChat.CALL_BACK));
                        impl.setShareContentCustomizeCallback((ShareContentCustomizeCallback) hashMap.remove("customizeCallback"));
                        if (hashMap.containsKey("disableSSO") && ((Boolean) hashMap.remove("disableSSO")).booleanValue()) {
                            impl.disableSSO();
                        }
                        impl.show(context.getApplicationContext());
                    } catch (Throwable unused2) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
