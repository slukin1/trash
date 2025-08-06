package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import com.luck.picture.lib.config.SelectMimeType;
import com.mob.MobSDK;
import java.io.File;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f13522a;

    /* renamed from: b  reason: collision with root package name */
    private String f13523b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13524c = true;

    public void a(String str) {
        this.f13522a = str;
        this.f13523b = "";
    }

    public void a(String str, String str2) {
        this.f13522a = str;
        this.f13523b = str2;
    }

    public void a(final Platform.ShareParams shareParams, Platform platform) throws Throwable {
        SSDKLog.b().a("ShareSDK QQ ShareBypassApproval toShare", new Object[0]);
        final Intent intent = new Intent();
        final String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            platform.getShortLintk(text, false, (ShareSDKCallback<String>) new ShareSDKCallback<String>() {
                /* renamed from: a */
                public void onCallback(String str) {
                    if (TextUtils.isEmpty(str)) {
                        shareParams.setText(text);
                    } else {
                        shareParams.setText(str);
                    }
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.putExtra("Kdescription", str);
                    g.this.a(shareParams, intent);
                }
            });
        } else {
            a(shareParams, intent);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r2.size() <= 0) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(cn.sharesdk.framework.Platform.ShareParams r11, android.content.Intent r12) {
        /*
            r10 = this;
            java.lang.String r0 = r11.getImagePath()     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = r11.getImageUrl()     // Catch:{ all -> 0x01d3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x01d3 }
            r2.<init>()     // Catch:{ all -> 0x01d3 }
            java.lang.String[] r3 = r11.getImageArray()     // Catch:{ all -> 0x01d3 }
            if (r3 != 0) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.String[] r2 = r11.getImageArray()     // Catch:{ all -> 0x01d3 }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ all -> 0x01d3 }
        L_0x001c:
            java.lang.String r3 = "images"
            if (r2 == 0) goto L_0x0026
            int r4 = r2.size()     // Catch:{ all -> 0x01d3 }
            if (r4 > 0) goto L_0x0093
        L_0x0026:
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01d3 }
            if (r4 != 0) goto L_0x0037
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01d3 }
            r4.<init>(r0)     // Catch:{ all -> 0x01d3 }
            boolean r4 = r4.exists()     // Catch:{ all -> 0x01d3 }
            if (r4 != 0) goto L_0x008a
        L_0x0037:
            android.graphics.Bitmap r11 = r11.getImageData()     // Catch:{ all -> 0x01d3 }
            if (r11 == 0) goto L_0x007c
            boolean r4 = r11.isRecycled()     // Catch:{ all -> 0x01d3 }
            if (r4 != 0) goto L_0x007c
            android.content.Context r0 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = com.mob.tools.utils.ResHelper.getCachePath(r0, r3)     // Catch:{ all -> 0x01d3 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01d3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r4.<init>()     // Catch:{ all -> 0x01d3 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01d3 }
            r4.append(r5)     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = ".png"
            r4.append(r5)     // Catch:{ all -> 0x01d3 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d3 }
            r1.<init>(r0, r4)     // Catch:{ all -> 0x01d3 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x01d3 }
            r0.<init>(r1)     // Catch:{ all -> 0x01d3 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x01d3 }
            r5 = 100
            r11.compress(r4, r5, r0)     // Catch:{ all -> 0x01d3 }
            r0.flush()     // Catch:{ all -> 0x01d3 }
            r0.close()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r1.getAbsolutePath()     // Catch:{ all -> 0x01d3 }
            goto L_0x008a
        L_0x007c:
            boolean r11 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01d3 }
            if (r11 != 0) goto L_0x008a
            android.content.Context r11 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = com.mob.tools.utils.BitmapHelper.downloadBitmap(r11, r1)     // Catch:{ all -> 0x01d3 }
        L_0x008a:
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01d3 }
            if (r11 != 0) goto L_0x0093
            r2.add(r0)     // Catch:{ all -> 0x01d3 }
        L_0x0093:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x01d3 }
            r11.<init>()     // Catch:{ all -> 0x01d3 }
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x01d3 }
        L_0x009c:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x01d3 }
            r2 = 0
            if (r1 == 0) goto L_0x014b
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01d3 }
            java.lang.String r4 = "http"
            boolean r4 = r1.startsWith(r4)     // Catch:{ all -> 0x01d3 }
            if (r4 == 0) goto L_0x00b9
            android.content.Context r4 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = com.mob.tools.utils.BitmapHelper.downloadBitmap(r4, r1)     // Catch:{ all -> 0x01d3 }
        L_0x00b9:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01d3 }
            r4.<init>(r1)     // Catch:{ all -> 0x01d3 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x01d3 }
            if (r5 == 0) goto L_0x009c
            java.lang.String r5 = "/data/"
            boolean r5 = r1.startsWith(r5)     // Catch:{ all -> 0x01d3 }
            if (r5 == 0) goto L_0x00fe
            android.content.Context r5 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = com.mob.tools.utils.ResHelper.getCachePath(r5, r3)     // Catch:{ all -> 0x01d3 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x01d3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r7.<init>()     // Catch:{ all -> 0x01d3 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01d3 }
            r7.append(r8)     // Catch:{ all -> 0x01d3 }
            java.lang.String r8 = r4.getName()     // Catch:{ all -> 0x01d3 }
            r7.append(r8)     // Catch:{ all -> 0x01d3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01d3 }
            r6.<init>(r5, r7)     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ all -> 0x01d3 }
            r6.createNewFile()     // Catch:{ all -> 0x01d3 }
            boolean r1 = com.mob.tools.utils.ResHelper.copyFile((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x00fe
            r4 = r6
        L_0x00fe:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d3 }
            r5 = 24
            if (r1 < r5) goto L_0x0142
            android.content.Context r1 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r5.<init>()     // Catch:{ all -> 0x0134 }
            android.content.Context r6 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0134 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x0134 }
            r5.append(r6)     // Catch:{ all -> 0x0134 }
            java.lang.String r6 = ".cn.sharesdk.ShareSDKFileProvider"
            r5.append(r6)     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0134 }
            android.net.Uri r1 = cn.sharesdk.framework.utils.ShareSDKFileProvider.a(r1, r5, r4)     // Catch:{ all -> 0x0134 }
            android.content.Context r4 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = r10.f13522a     // Catch:{ all -> 0x0134 }
            r6 = 3
            r4.grantUriPermission(r5, r1, r6)     // Catch:{ all -> 0x0134 }
            r11.add(r1)     // Catch:{ all -> 0x0134 }
            goto L_0x009c
        L_0x0134:
            r1 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r4 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = "ShareSDK ShareBypassApproval getUriForFile exception"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x01d3 }
            r4.a(r1, r5, r2)     // Catch:{ all -> 0x01d3 }
            goto L_0x009c
        L_0x0142:
            android.net.Uri r1 = android.net.Uri.fromFile(r4)     // Catch:{ all -> 0x01d3 }
            r11.add(r1)     // Catch:{ all -> 0x01d3 }
            goto L_0x009c
        L_0x014b:
            int r0 = r11.size()     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = "android.intent.action.SEND"
            if (r0 > 0) goto L_0x015c
            r12.setAction(r1)     // Catch:{ all -> 0x01d3 }
            java.lang.String r11 = "text/plain"
            r12.setType(r11)     // Catch:{ all -> 0x01d3 }
            goto L_0x01a4
        L_0x015c:
            int r0 = r11.size()     // Catch:{ all -> 0x01d3 }
            r3 = 1
            java.lang.String r4 = "image/*"
            java.lang.String r5 = "android.intent.extra.STREAM"
            if (r0 != r3) goto L_0x0199
            java.lang.Object r0 = r11.get(r2)     // Catch:{ all -> 0x01d3 }
            if (r0 == 0) goto L_0x0199
            r12.setAction(r1)     // Catch:{ all -> 0x01d3 }
            java.lang.Object r0 = r11.get(r2)     // Catch:{ all -> 0x01d3 }
            android.os.Parcelable r0 = (android.os.Parcelable) r0     // Catch:{ all -> 0x01d3 }
            r12.putExtra(r5, r0)     // Catch:{ all -> 0x01d3 }
            java.net.FileNameMap r0 = java.net.URLConnection.getFileNameMap()     // Catch:{ all -> 0x01d3 }
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x01d3 }
            android.net.Uri r11 = (android.net.Uri) r11     // Catch:{ all -> 0x01d3 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01d3 }
            java.lang.String r11 = r0.getContentTypeFor(r11)     // Catch:{ all -> 0x01d3 }
            if (r11 == 0) goto L_0x0195
            int r0 = r11.length()     // Catch:{ all -> 0x01d3 }
            if (r0 > 0) goto L_0x0194
            goto L_0x0195
        L_0x0194:
            r4 = r11
        L_0x0195:
            r12.setType(r4)     // Catch:{ all -> 0x01d3 }
            goto L_0x01a4
        L_0x0199:
            java.lang.String r0 = "android.intent.action.SEND_MULTIPLE"
            r12.setAction(r0)     // Catch:{ all -> 0x01d3 }
            r12.putParcelableArrayListExtra(r5, r11)     // Catch:{ all -> 0x01d3 }
            r12.setType(r4)     // Catch:{ all -> 0x01d3 }
        L_0x01a4:
            java.lang.String r11 = r10.f13523b     // Catch:{ all -> 0x01d3 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x01d3 }
            if (r11 == 0) goto L_0x01b2
            java.lang.String r11 = r10.f13522a     // Catch:{ all -> 0x01d3 }
            r12.setPackage(r11)     // Catch:{ all -> 0x01d3 }
            goto L_0x01b9
        L_0x01b2:
            java.lang.String r11 = r10.f13522a     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r10.f13523b     // Catch:{ all -> 0x01d3 }
            r12.setClassName(r11, r0)     // Catch:{ all -> 0x01d3 }
        L_0x01b9:
            r11 = 335544320(0x14000000, float:6.4623485E-27)
            r12.addFlags(r11)     // Catch:{ all -> 0x01d3 }
            android.content.Context r11 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01c6 }
            r11.startActivity(r12)     // Catch:{ all -> 0x01c6 }
            goto L_0x01db
        L_0x01c6:
            r11 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r12 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = "ShareSDK  QQ ShareBypassApproval toShare catch"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x01d3 }
            r12.a(r11, r0, r1)     // Catch:{ all -> 0x01d3 }
            goto L_0x01db
        L_0x01d3:
            r11 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r12 = cn.sharesdk.framework.utils.SSDKLog.b()
            r12.a((java.lang.Throwable) r11)
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.g.a(cn.sharesdk.framework.Platform$ShareParams, android.content.Intent):void");
    }

    public void a(Uri uri, Platform platform, PlatformActionListener platformActionListener) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(SelectMimeType.SYSTEM_VIDEO);
        intent.setPackage(this.f13522a);
        intent.putExtra("android.intent.extra.STREAM", uri);
        if (TextUtils.isEmpty(this.f13523b)) {
            intent.setPackage(this.f13522a);
        } else {
            intent.setClassName(this.f13522a, this.f13523b);
        }
        try {
            intent.addFlags(268435456);
            MobSDK.getContext().startActivity(intent);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ShareParams", (Object) null);
        if (platformActionListener != null) {
            platformActionListener.onComplete(platform, 9, hashMap);
        }
    }

    public void a(String str, Platform platform, PlatformActionListener platformActionListener) {
        Intent intent = new Intent("android.intent.action.SEND");
        if (str.endsWith("mp4") || str.endsWith("mkv")) {
            intent.setType(SelectMimeType.SYSTEM_VIDEO);
        }
        if (TextUtils.isEmpty(this.f13523b)) {
            intent.setPackage(this.f13522a);
        } else {
            intent.setClassName(this.f13522a, this.f13523b);
        }
        if (Build.VERSION.SDK_INT < 24) {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
        } else if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Context context = MobSDK.getContext();
                Uri a11 = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                MobSDK.getContext().grantUriPermission(this.f13522a, a11, 3);
                intent.putExtra("android.intent.extra.STREAM", a11);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2, "ShareSDK ShareBypassApproval getUriForFile exception", new Object[0]);
            }
        }
        try {
            intent.addFlags(268435456);
            MobSDK.getContext().startActivity(intent);
        } catch (Throwable th3) {
            SSDKLog.b().a(th3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ShareParams", (Object) null);
        if (platformActionListener != null) {
            platformActionListener.onComplete(platform, 9, hashMap);
        }
    }
}
