package cn.sharesdk.kakao.talk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ShareActivity extends FakeActivity {
    public static final String AUTHORIZE = "auth";
    private static final String EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
    private static final String EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
    private static final String EXTRA_REDIRECT_URL = "com.kakao.sdk.talk.redirectUrl";
    private static final int REQUEST_CODE_AUTH = 1;
    private static final int REQUEST_CODE_INTERACTIVE_POST = 3;
    public static final String SHARE = "share";
    private String action;
    private PlatformActionListener listener;
    private Platform platform;

    public void onActivityResult(int i11, int i12, Intent intent) {
        finish();
        if (i11 == 3) {
            try {
                HashMap hashMap = new HashMap();
                if (!(intent == null || intent.getExtras() == null)) {
                    for (String str : intent.getExtras().keySet()) {
                        hashMap.put(str, intent.getExtras().get(str));
                    }
                }
                this.listener.onComplete(this.platform, 9, hashMap);
            } catch (Throwable th2) {
                SSDKLog b11 = SSDKLog.b();
                b11.a("kakaoTalk onActivityResult error" + th2);
            }
        } else if (i11 != 1) {
        } else {
            if (i12 == -1) {
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
            } else {
                this.listener.onCancel(this.platform, 1);
            }
        }
    }

    public void onCreate() {
        Intent intent;
        Uri uri;
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e11) {
            SSDKLog.b().a((Throwable) e11);
        }
        Bundle extras = this.activity.getIntent().getExtras();
        if (this.action.equals("auth")) {
            Intent intent2 = (Intent) extras.getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (this.activity.getPackageManager().resolveActivity(intent2, 0) != null) {
                try {
                    startActivityForResult(intent2, 1);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            } else {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this.platform, 1, new Throwable("Invalid intent"));
                }
                finish();
            }
        } else if (this.action.equals("share")) {
            try {
                intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setPackage("com.kakao.talk");
                String string = extras.getString("text");
                String string2 = extras.getString(InnerShareParams.IMAGE_PATH);
                String[] stringArray = extras.getStringArray(InnerShareParams.IMAGE_ARRAY);
                String string3 = extras.getString("url");
                String string4 = extras.getString(InnerShareParams.FILE_PATH);
                if (!TextUtils.isEmpty(string)) {
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", string);
                } else if (!TextUtils.isEmpty(string2)) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        File file = new File(string2);
                        File file2 = new File(MobSDK.getContext().getExternalFilesDir((String) null).getPath() + "/" + file.getName());
                        if (!file.getPath().equals(file2.getPath()) ? ResHelper.copyFile(file.getPath(), file2.getPath()) : true) {
                            Context context = MobSDK.getContext();
                            uri = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            MobSDK.getContext().grantUriPermission("com.kakao.talk", uri, 3);
                        } else {
                            uri = null;
                        }
                    } else {
                        uri = Uri.parse("android.resource://com.kakao.sdk.link.sample/" + string2);
                    }
                    intent.setType(PictureMimeType.PNG_Q);
                    intent.putExtra("android.intent.extra.STREAM", uri);
                } else if (stringArray != null) {
                    intent.setType(PictureMimeType.PNG_Q);
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < stringArray.length; i11++) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            File file3 = new File(stringArray[i11]);
                            File file4 = new File(MobSDK.getContext().getExternalFilesDir((String) null).getPath() + "/" + file3.getName());
                            if (!file3.getPath().equals(file4.getPath()) ? ResHelper.copyFile(file3.getPath(), file4.getPath()) : true) {
                                Context context2 = MobSDK.getContext();
                                Uri a11 = ShareSDKFileProvider.a(context2, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file3);
                                MobSDK.getContext().grantUriPermission("com.kakao.talk", a11, 3);
                                arrayList.add(a11);
                            }
                        } else {
                            arrayList.add(Uri.parse("android.resource://com.kakao.sdk.link.sample/" + stringArray[i11]));
                        }
                    }
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                } else if (!TextUtils.isEmpty(string3)) {
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", string3);
                } else if (!TextUtils.isEmpty(string4)) {
                    File file5 = new File(string4);
                    ContentResolver contentResolver = MobSDK.getContext().getContentResolver();
                    Uri insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, b.a(new File(string4), System.currentTimeMillis()));
                    if (insert != null) {
                        byte[] bArr = new byte[1024];
                        FileOutputStream fileOutputStream = new FileOutputStream(contentResolver.openFileDescriptor(insert, "w").getFileDescriptor());
                        FileInputStream fileInputStream = new FileInputStream(new File(string4));
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                        fileOutputStream.flush();
                        intent.setType(SelectMimeType.SYSTEM_VIDEO);
                        intent.putExtra("android.intent.extra.STREAM", insert);
                    } else {
                        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "此款机型拷贝到相册失败，localUri is null, insert MediaStore failed， 将会再次尝试一下别的路径");
                        File a12 = b.a(MobSDK.getContext(), file5.getAbsolutePath());
                        if (a12 != null && a12.exists()) {
                            intent.setType(SelectMimeType.SYSTEM_VIDEO);
                            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(a12));
                        }
                        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "别的路径尝试拷贝完成");
                    }
                }
            } catch (Throwable th3) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.platform, 9, th3);
                }
                SSDKLog.b().a(th3);
                return;
            }
            startActivityForResult(intent, 3);
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
