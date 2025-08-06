package com.hbg.lib.common.dynamic.downloader;

import android.text.TextUtils;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import i6.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import okhttp3.OkHttpClient;

public class HBDynamicResDownManager {

    /* renamed from: c  reason: collision with root package name */
    public static List<DyanmicConfig> f67438c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public boolean f67439a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f67440b;

    public static class CompleteException extends Exception {
        private CompleteException() {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final HBDynamicResDownManager f67441a = new HBDynamicResDownManager();
    }

    public static HBDynamicResDownManager b() {
        return b.f67441a;
    }

    public final void a(DyanmicConfig.DynamicBaseBean dynamicBaseBean) {
        if (dynamicBaseBean != null) {
            try {
                if (!this.f67440b.isEmpty()) {
                    for (int i11 = 0; i11 < this.f67440b.size(); i11++) {
                        b bVar = this.f67440b.get(i11);
                        k.i("Downloader", "NotifyListener() called with: beanType = [" + dynamicBaseBean.getClass().getName() + "], listener.dyanmicType() = [" + bVar.b() + "]", false);
                        if (dynamicBaseBean.getClass().getName().equals(bVar.b())) {
                            bVar.a(dynamicBaseBean.md5);
                        }
                    }
                }
            } catch (Exception e11) {
                k.h("Downloader", "unzip: 通知失败时,就直接结速了", e11, false);
            }
        }
    }

    public final String c(boolean z11, boolean z12) {
        String str;
        String str2 = "app-static-1306115679.file.myqcloud.com";
        if (z12) {
            if (!z11) {
                str2 = "hbg-prod-fed-public.hbfile.net";
            }
            str = "https://$domain/hbapp-directory/dynamic/android/$version/$canary/manifest.json".replace("$domain", str2);
        } else {
            if (z11) {
                str2 = "hbg-prod-fed-public.hbfile.net";
            }
            str = "https://$domain/hbapp-directory/dynamic/android/$version/$canary/manifest.json".replace("$domain", str2);
        }
        String replace = str.replace("$canary", BaseApplication.f67407b ? "huidu" : "release");
        return replace.replace("$version", BaseApplication.e() + "");
    }

    public final String d(boolean z11, boolean z12, DyanmicConfig.DynamicBaseBean dynamicBaseBean) {
        String str;
        String str2 = "app-static-1306115679.file.myqcloud.com";
        if (z12) {
            if (!z11) {
                str2 = "hbg-prod-fed-public.hbfile.net";
            }
            str = "https://$domain/hbapp-directory/dynamic/android/$version/$canary".replace("$domain", str2);
        } else {
            if (z11) {
                str2 = "hbg-prod-fed-public.hbfile.net";
            }
            str = "https://$domain/hbapp-directory/dynamic/android/$version/$canary".replace("$domain", str2);
        }
        String replace = str.replace("$canary", BaseApplication.f67407b ? "huidu" : "release");
        String replace2 = replace.replace("$version", BaseApplication.e() + "");
        return replace2 + dynamicBaseBean.sourcePath;
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (i11 % 2 == 0) {
                sb2.append(charArray[i11]);
            }
        }
        return sb2.toString();
    }

    public final int f(HBDynamicBaseManager hBDynamicBaseManager, OkHttpClient okHttpClient, boolean z11, DyanmicConfig.DynamicBaseBean dynamicBaseBean) {
        return g(hBDynamicBaseManager, okHttpClient, z11, dynamicBaseBean, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g(com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager r19, okhttp3.OkHttpClient r20, boolean r21, com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean r22, java.lang.String r23) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            if (r3 == 0) goto L_0x0273
            if (r5 != 0) goto L_0x0012
            goto L_0x0273
        L_0x0012:
            long r7 = java.lang.System.currentTimeMillis()
            boolean r0 = r2.n(r5)
            java.lang.String r9 = "]"
            r10 = 0
            java.lang.String r11 = "Downloader"
            if (r0 == 0) goto L_0x0255
            java.io.File r12 = new java.io.File
            java.lang.String r0 = r5.md5
            java.io.File r0 = r2.e(r0)
            java.lang.String r13 = r5.sourcePath
            r12.<init>(r0, r13)
            boolean r0 = r12.exists()
            java.lang.String r13 = "]file="
            if (r0 == 0) goto L_0x006f
            java.lang.String r0 = r5.md5
            java.lang.String r14 = com.hbg.lib.common.dynamic.downloader.Util.c(r12)
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x006c
            r1.j(r2, r5, r12, r6)     // Catch:{ IOException -> 0x0065 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0065 }
            r0.<init>()     // Catch:{ IOException -> 0x0065 }
            java.lang.String r14 = "startDownload(Zip已经存在,并且md5相同,跳过下载,直接解压存储完成) called with: isFirstConnect = ["
            r0.append(r14)     // Catch:{ IOException -> 0x0065 }
            r0.append(r4)     // Catch:{ IOException -> 0x0065 }
            r0.append(r13)     // Catch:{ IOException -> 0x0065 }
            java.lang.String r14 = r12.getPath()     // Catch:{ IOException -> 0x0065 }
            r0.append(r14)     // Catch:{ IOException -> 0x0065 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0065 }
            i6.k.i(r11, r0, r10)     // Catch:{ IOException -> 0x0065 }
            r0 = 3
            return r0
        L_0x0065:
            r0 = move-exception
            java.lang.String r14 = "startDownload: 解压旧的zip时发生错误:"
            i6.k.h(r11, r14, r0, r10)
            goto L_0x006f
        L_0x006c:
            r12.deleteOnExit()
        L_0x006f:
            android.app.Application r0 = com.hbg.lib.common.BaseApplication.b()
            boolean r0 = com.hbg.lib.common.network.NetworkStatus.b(r0)
            java.lang.String r14 = r1.d(r0, r4, r5)
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()
            if (r0 == 0) goto L_0x00a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r15 = "startDownload() called with: realUrl = ["
            r0.append(r15)
            r0.append(r14)
            java.lang.String r15 = "], isFirstConnect = ["
            r0.append(r15)
            r0.append(r4)
            java.lang.String r15 = "], bean = ["
            r0.append(r15)
            r0.append(r5)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r11, r0)
        L_0x00a8:
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r14)
            okhttp3.Request$Builder r0 = r0.get()
            okhttp3.Request r0 = r0.build()
            okhttp3.Call r0 = r3.newCall(r0)     // Catch:{ IOException -> 0x0213 }
            okhttp3.Response r0 = r0.execute()     // Catch:{ IOException -> 0x0213 }
            boolean r15 = r0.isSuccessful()     // Catch:{ IOException -> 0x0213 }
            if (r15 == 0) goto L_0x01d0
            boolean r15 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ IOException -> 0x0213 }
            if (r15 == 0) goto L_0x00e7
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ca }
            r15.<init>()     // Catch:{ IOException -> 0x01ca }
            java.lang.String r10 = "startDownload: 请求耗时="
            r15.append(r10)     // Catch:{ IOException -> 0x01ca }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x01ca }
            long r1 = r16 - r7
            r15.append(r1)     // Catch:{ IOException -> 0x01ca }
            java.lang.String r1 = r15.toString()     // Catch:{ IOException -> 0x01ca }
            android.util.Log.d(r11, r1)     // Catch:{ IOException -> 0x01ca }
        L_0x00e7:
            boolean r1 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ IOException -> 0x01ca }
            java.lang.String r2 = "], url = ["
            if (r1 == 0) goto L_0x010c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ca }
            r1.<init>()     // Catch:{ IOException -> 0x01ca }
            java.lang.String r10 = "startDownload(开始下载文件) called with: isFirstConnect = ["
            r1.append(r10)     // Catch:{ IOException -> 0x01ca }
            r1.append(r4)     // Catch:{ IOException -> 0x01ca }
            r1.append(r2)     // Catch:{ IOException -> 0x01ca }
            r1.append(r14)     // Catch:{ IOException -> 0x01ca }
            r1.append(r9)     // Catch:{ IOException -> 0x01ca }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x01ca }
            android.util.Log.d(r11, r1)     // Catch:{ IOException -> 0x01ca }
        L_0x010c:
            boolean r1 = r12.exists()     // Catch:{ IOException -> 0x01ca }
            if (r1 == 0) goto L_0x0115
            r12.deleteOnExit()     // Catch:{ IOException -> 0x01ca }
        L_0x0115:
            okhttp3.ResponseBody r0 = r0.body()     // Catch:{ IOException -> 0x01ca }
            java.io.InputStream r0 = r0.byteStream()     // Catch:{ IOException -> 0x01ca }
            com.blankj.utilcode.util.k.e(r12, r0)     // Catch:{ IOException -> 0x01ca }
            java.lang.String r0 = com.hbg.lib.common.dynamic.downloader.Util.c(r12)     // Catch:{ IOException -> 0x01ca }
            boolean r1 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ IOException -> 0x01ca }
            if (r1 == 0) goto L_0x0146
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ca }
            r1.<init>()     // Catch:{ IOException -> 0x01ca }
            java.lang.String r10 = "startDownload: 到下载完成耗时="
            r1.append(r10)     // Catch:{ IOException -> 0x01ca }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x01ca }
            r15 = r9
            long r9 = r16 - r7
            r1.append(r9)     // Catch:{ IOException -> 0x01ca }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x01ca }
            android.util.Log.d(r11, r1)     // Catch:{ IOException -> 0x01ca }
            goto L_0x0147
        L_0x0146:
            r15 = r9
        L_0x0147:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x01ca }
            if (r1 != 0) goto L_0x0191
            java.lang.String r1 = r5.md5     // Catch:{ IOException -> 0x01ca }
            boolean r1 = java.util.Objects.equals(r0, r1)     // Catch:{ IOException -> 0x01ca }
            if (r1 == 0) goto L_0x0191
            r1 = r18
            r9 = r19
            r1.j(r9, r5, r12, r6)     // Catch:{ IOException -> 0x0211 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211 }
            r0.<init>()     // Catch:{ IOException -> 0x0211 }
            java.lang.String r6 = "startDownload(下载下载解压存储完成,共耗时:"
            r0.append(r6)     // Catch:{ IOException -> 0x0211 }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0211 }
            long r6 = r16 - r7
            r0.append(r6)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r6 = ") called with: isFirstConnect = ["
            r0.append(r6)     // Catch:{ IOException -> 0x0211 }
            r0.append(r4)     // Catch:{ IOException -> 0x0211 }
            r0.append(r2)     // Catch:{ IOException -> 0x0211 }
            r0.append(r14)     // Catch:{ IOException -> 0x0211 }
            r0.append(r13)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r2 = r12.getPath()     // Catch:{ IOException -> 0x0211 }
            r0.append(r2)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0211 }
            r2 = 0
            i6.k.i(r11, r0, r2)     // Catch:{ IOException -> 0x0211 }
            r0 = 1
            return r0
        L_0x0191:
            r1 = r18
            r9 = r19
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211 }
            r2.<init>()     // Catch:{ IOException -> 0x0211 }
            java.lang.String r6 = "startDownload(下载的zip的md5与配置是的不一致) called with: filemd5 = ["
            r2.append(r6)     // Catch:{ IOException -> 0x0211 }
            r2.append(r0)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = "], "
            r2.append(r0)     // Catch:{ IOException -> 0x0211 }
            java.lang.Class r0 = r22.getClass()     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ IOException -> 0x0211 }
            r2.append(r0)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = ".md5 = ["
            r2.append(r0)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = r5.md5     // Catch:{ IOException -> 0x0211 }
            r2.append(r0)     // Catch:{ IOException -> 0x0211 }
            r6 = r15
            r2.append(r6)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0211 }
            r2 = 0
            i6.k.i(r11, r0, r2)     // Catch:{ IOException -> 0x0211 }
            r0 = -1
            return r0
        L_0x01ca:
            r0 = move-exception
            r1 = r18
            r9 = r19
            goto L_0x0215
        L_0x01d0:
            r6 = r9
            r9 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211 }
            r2.<init>()     // Catch:{ IOException -> 0x0211 }
            java.lang.String r7 = "startDownload() called with: client = [文件不存在或不可用], isFirstConnect = ["
            r2.append(r7)     // Catch:{ IOException -> 0x0211 }
            r2.append(r4)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r7 = "], code = ["
            r2.append(r7)     // Catch:{ IOException -> 0x0211 }
            int r7 = r0.code()     // Catch:{ IOException -> 0x0211 }
            r2.append(r7)     // Catch:{ IOException -> 0x0211 }
            r2.append(r6)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0211 }
            r6 = 0
            i6.k.i(r11, r2, r6)     // Catch:{ IOException -> 0x0211 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0211 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211 }
            r6.<init>()     // Catch:{ IOException -> 0x0211 }
            java.lang.String r7 = "文件不存在或不可用 code="
            r6.append(r7)     // Catch:{ IOException -> 0x0211 }
            int r0 = r0.code()     // Catch:{ IOException -> 0x0211 }
            r6.append(r0)     // Catch:{ IOException -> 0x0211 }
            java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x0211 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0211 }
            throw r2     // Catch:{ IOException -> 0x0211 }
        L_0x0211:
            r0 = move-exception
            goto L_0x0215
        L_0x0213:
            r0 = move-exception
            r9 = r2
        L_0x0215:
            java.lang.String r2 = "   ,IOException="
            if (r4 == 0) goto L_0x0239
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "startDownload(下载失败,换域名再试一次) :realUrl="
            r4.append(r6)
            r4.append(r14)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r4 = 0
            i6.k.i(r11, r0, r4)
            int r0 = r1.f(r9, r3, r4, r5)
            return r0
        L_0x0239:
            r4 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "startDownload(下载失败,流程结速) :realUrl="
            r3.append(r5)
            r3.append(r14)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            i6.k.i(r11, r0, r4)
            return r4
        L_0x0255:
            r6 = r9
            r4 = r10
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "startDownload(当前已经是最新版本了) called with: bean = ["
            r0.append(r2)
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            i6.k.i(r11, r0, r4)
            r1.a(r5)
            r0 = 2
            return r0
        L_0x0273:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager.g(com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager, okhttp3.OkHttpClient, boolean, com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean, java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:161:0x045d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x045e, code lost:
        r1 = r0;
        r12 = "]";
        r6 = r4;
        r5 = r19;
        r3 = r20;
        r4 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ef, code lost:
        r2 = r0;
        r18 = "]";
        r26 = r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:52:0x01e7, B:62:0x0203] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0328 A[SYNTHETIC, Splitter:B:104:0x0328] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0382 A[SYNTHETIC, Splitter:B:121:0x0382] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03e2 A[Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x045d A[ExcHandler: Exception (r0v13 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r24 
      PHI: (r24v4 java.lang.String) = (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v6 java.lang.String), (r24v12 java.lang.String), (r24v12 java.lang.String) binds: [B:62:0x0203, B:63:?, B:84:0x02ca, B:85:?, B:101:0x0324, B:102:?, B:118:0x037e, B:119:?, B:135:0x03d8, B:121:0x0382, B:132:0x03d1, B:104:0x0328, B:115:0x0377, B:87:0x02ce, B:98:0x031d, B:65:0x0207, B:80:0x02c0, B:43:0x01a8, B:52:0x01e7] A[DONT_GENERATE, DONT_INLINE], Splitter:B:62:0x0203] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x05d3  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x05f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0207 A[SYNTHETIC, Splitter:B:65:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02ce A[SYNTHETIC, Splitter:B:87:0x02ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h(okhttp3.OkHttpClient r28, boolean r29) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r9 = r29
            java.lang.String r10 = "下载manifest异常,换域名再试一次.Exception:"
            java.lang.String r11 = "downloader_fail_retry"
            java.lang.String r12 = "startDownloadTask(已经重试了,还是下载失败了) called with: isFirstConnect = [false], url = ["
            java.lang.String r13 = "已经重试了,还是下载失败了,DOWN_RS_IO_ERROR:"
            java.lang.String r14 = "downloader_fail"
            r5 = 1
            if (r8 != 0) goto L_0x001b
            java.lang.String r1 = "OkHttpClient client=null"
            com.hbg.lib.common.dynamic.downloader.Util.b(r14, r5, r1)
            r1 = -2
            return r1
        L_0x001b:
            r15 = 1
            r7.f67439a = r15
            android.app.Application r1 = com.hbg.lib.common.BaseApplication.b()
            boolean r1 = com.hbg.lib.common.network.NetworkStatus.b(r1)
            java.lang.String r4 = r7.c(r1, r9)
            boolean r1 = com.hbg.lib.common.dynamic.downloader.Util.a()
            java.lang.String r2 = "], isFirstConnect = ["
            java.lang.String r3 = "]"
            java.lang.String r15 = "Downloader"
            if (r1 == 0) goto L_0x0053
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "startDownloadTask() called with: realUrl = ["
            r1.append(r5)
            r1.append(r4)
            r1.append(r2)
            r1.append(r9)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r15, r1)
        L_0x0053:
            java.lang.String r1 = "isFirstConnect="
            java.lang.String r5 = "|"
            if (r9 == 0) goto L_0x007a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r9)
            r6.append(r5)
            r6.append(r4)
            java.lang.String r1 = r6.toString()
            java.lang.String r6 = "downloader_start"
            r19 = r12
            r20 = r13
            r12 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r6, r12, r1)
            goto L_0x009a
        L_0x007a:
            r19 = r12
            r20 = r13
            r12 = 1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r9)
            r6.append(r5)
            r6.append(r4)
            java.lang.String r1 = r6.toString()
            java.lang.String r6 = "downloader_retry"
            com.hbg.lib.common.dynamic.downloader.Util.b(r6, r12, r1)
        L_0x009a:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            okhttp3.Request$Builder r1 = r1.url((java.lang.String) r4)
            okhttp3.CacheControl r6 = okhttp3.CacheControl.FORCE_NETWORK
            okhttp3.Request$Builder r1 = r1.cacheControl(r6)
            okhttp3.Request$Builder r1 = r1.get()
            okhttp3.Request r1 = r1.build()
            r12 = 0
            okhttp3.Call r1 = r8.newCall(r1)     // Catch:{ Exception -> 0x05c8 }
            okhttp3.Response r1 = r1.execute()     // Catch:{ Exception -> 0x05c8 }
            boolean r6 = r1.isSuccessful()     // Catch:{ Exception -> 0x05c8 }
            if (r6 != 0) goto L_0x012a
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ Exception -> 0x011f }
            if (r2 == 0) goto L_0x00f9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
            r2.<init>()     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "startDownloadTask(没有需要的补丁) called with: isFirstConnect = ["
            r2.append(r6)     // Catch:{ Exception -> 0x011f }
            r2.append(r9)     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "], url = ["
            r2.append(r6)     // Catch:{ Exception -> 0x011f }
            r2.append(r4)     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "], response.isSuccessful()=["
            r2.append(r6)     // Catch:{ Exception -> 0x011f }
            r2.append(r12)     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "], code=["
            r2.append(r6)     // Catch:{ Exception -> 0x011f }
            int r6 = r1.code()     // Catch:{ Exception -> 0x011f }
            r2.append(r6)     // Catch:{ Exception -> 0x011f }
            r2.append(r3)     // Catch:{ Exception -> 0x011f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x011f }
            android.util.Log.d(r15, r2)     // Catch:{ Exception -> 0x011f }
        L_0x00f9:
            java.lang.String r2 = "downloader_success_empty"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
            r6.<init>()     // Catch:{ Exception -> 0x011f }
            java.lang.String r13 = "没有需要下载的补丁response.isSuccessful=false|code="
            r6.append(r13)     // Catch:{ Exception -> 0x011f }
            int r1 = r1.code()     // Catch:{ Exception -> 0x011f }
            r6.append(r1)     // Catch:{ Exception -> 0x011f }
            r6.append(r5)     // Catch:{ Exception -> 0x011f }
            r6.append(r4)     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x011f }
            r5 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r5, r1)     // Catch:{ Exception -> 0x011f }
            r7.f67439a = r12     // Catch:{ Exception -> 0x011f }
            r1 = 1
            return r1
        L_0x011f:
            r0 = move-exception
            r1 = r0
            r12 = r3
            r6 = r4
            r4 = r14
            r5 = r19
            r3 = r20
            goto L_0x05d1
        L_0x012a:
            okhttp3.ResponseBody r1 = r1.body()     // Catch:{ Exception -> 0x05c8 }
            java.lang.String r1 = r1.string()     // Catch:{ Exception -> 0x05c8 }
            boolean r5 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ Exception -> 0x05c8 }
            if (r5 == 0) goto L_0x0155
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
            r5.<init>()     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "startDownloadTask() called with: resultString = ["
            r5.append(r6)     // Catch:{ Exception -> 0x011f }
            r5.append(r1)     // Catch:{ Exception -> 0x011f }
            r5.append(r2)     // Catch:{ Exception -> 0x011f }
            r5.append(r9)     // Catch:{ Exception -> 0x011f }
            r5.append(r3)     // Catch:{ Exception -> 0x011f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x011f }
            android.util.Log.d(r15, r5)     // Catch:{ Exception -> 0x011f }
        L_0x0155:
            java.lang.String r5 = "downloader_json_success"
            r12 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r5, r12, r1)     // Catch:{ Exception -> 0x05c8 }
            com.google.gson.Gson r5 = com.huobi.store.GsonHelper.a()     // Catch:{ Exception -> 0x05c8 }
            java.lang.Class<com.hbg.lib.common.dynamic.downloader.DyanmicConfig> r6 = com.hbg.lib.common.dynamic.downloader.DyanmicConfig.class
            java.lang.Object r1 = r5.fromJson((java.lang.String) r1, r6)     // Catch:{ Exception -> 0x05c8 }
            r12 = r1
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig r12 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig) r12     // Catch:{ Exception -> 0x05c8 }
            boolean r1 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ Exception -> 0x05c8 }
            if (r1 == 0) goto L_0x018c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
            r1.<init>()     // Catch:{ Exception -> 0x011f }
            java.lang.String r5 = "startDownloadTask() called with: config = ["
            r1.append(r5)     // Catch:{ Exception -> 0x011f }
            r1.append(r12)     // Catch:{ Exception -> 0x011f }
            r1.append(r2)     // Catch:{ Exception -> 0x011f }
            r1.append(r9)     // Catch:{ Exception -> 0x011f }
            r1.append(r3)     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x011f }
            android.util.Log.d(r15, r1)     // Catch:{ Exception -> 0x011f }
        L_0x018c:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n> r1 = r12.i18n     // Catch:{ CompleteException -> 0x046f }
            java.lang.String r6 = ""
            java.lang.String r22 = "success"
            java.lang.String r23 = "fail"
            if (r1 == 0) goto L_0x0201
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x01f7 }
            if (r1 != 0) goto L_0x0201
            java.lang.String r1 = "downloader_i18n_start"
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n> r2 = r12.i18n     // Catch:{ CompleteException -> 0x01f7 }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x01f7 }
            r24 = r14
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r13, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            e6.d r1 = e6.d.r()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n> r2 = r12.i18n     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 0
            java.lang.Object r2 = r2.get(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r2 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 1
            int r1 = r7.f(r1, r8, r5, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_i18n_"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 <= 0) goto L_0x01cc
            r5 = r22
            goto L_0x01ce
        L_0x01cc:
            r5 = r23
        L_0x01ce:
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            long r13 = (long) r1     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r13, r6)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r2 == 0) goto L_0x01e4
            java.lang.String r2 = "startDownloadTask() i18n资源下载完成\n\n\n\n\n"
            android.util.Log.d(r15, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
        L_0x01e4:
            if (r1 <= 0) goto L_0x01e7
            goto L_0x0203
        L_0x01e7:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            throw r1     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
        L_0x01ee:
            r0 = move-exception
            r2 = r0
            r18 = r3
            r26 = r4
        L_0x01f4:
            r1 = 0
            goto L_0x0478
        L_0x01f7:
            r0 = move-exception
            r24 = r14
        L_0x01fa:
            r2 = r0
            r18 = r3
            r26 = r4
            goto L_0x0477
        L_0x0201:
            r24 = r14
        L_0x0203:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r1 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 == 0) goto L_0x02ca
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 != 0) goto L_0x02ca
            r1 = 0
        L_0x020e:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r2 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            int r2 = r2.size()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 >= r2) goto L_0x02ca
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_edgeednge"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r5 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r5 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r5     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = r5.destPath     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "_start"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r5 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r5 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r5     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = r5.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r13, r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r2 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r2 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.destPath     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            e6.c r2 = e6.c.r(r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r5 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r5 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r5     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r13 = 1
            int r2 = r7.f(r2, r8, r13, r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_%s_%s_%s"
            r13 = 3
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r14 = "edgeednge"
            r21 = 0
            r13[r21] = r14     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r14 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r14 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r14     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r14 = r14.destPath     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r16 = 1
            r13[r16] = r14     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r14 = 2
            if (r2 <= 0) goto L_0x0281
            r25 = r22
            goto L_0x0283
        L_0x0281:
            r25 = r23
        L_0x0283:
            r13[r14] = r25     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = java.lang.String.format(r5, r13)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            long r13 = (long) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r5, r13, r6)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            boolean r5 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r5 == 0) goto L_0x02ba
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r13 = "startDownloadTask("
            r5.append(r13)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5.append(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r13 = ") EdgeEdnge资源下载完成"
            r5.append(r13)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r13 = r12.edgeEdnges     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.Object r13 = r13.get(r1)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5.append(r13)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r13 = "\n\n\n\n\n"
            r5.append(r13)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = r5.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            android.util.Log.d(r15, r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
        L_0x02ba:
            if (r2 <= 0) goto L_0x02c0
            int r1 = r1 + 1
            goto L_0x020e
        L_0x02c0:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            throw r1     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
        L_0x02c7:
            r0 = move-exception
            goto L_0x01fa
        L_0x02ca:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image> r1 = r12.images     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 == 0) goto L_0x0324
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 != 0) goto L_0x0324
            java.lang.String r1 = "downloader_image_start"
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image> r2 = r12.images     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r13, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            e6.g r1 = e6.g.v()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image> r2 = r12.images     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 0
            java.lang.Object r2 = r2.get(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r2 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 1
            int r1 = r7.f(r1, r8, r5, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_image_"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 <= 0) goto L_0x0302
            r5 = r22
            goto L_0x0304
        L_0x0302:
            r5 = r23
        L_0x0304:
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            long r13 = (long) r1     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r13, r6)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r2 == 0) goto L_0x031a
            java.lang.String r2 = "startDownloadTask() image资源下载完成\n\n\n\n\n"
            android.util.Log.d(r15, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
        L_0x031a:
            if (r1 <= 0) goto L_0x031d
            goto L_0x0324
        L_0x031d:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            throw r1     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
        L_0x0324:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig> r1 = r12.configs     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 == 0) goto L_0x037e
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 != 0) goto L_0x037e
            java.lang.String r1 = "downloader_configs_start"
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig> r2 = r12.configs     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r13, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            e6.h r1 = e6.h.r()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig> r2 = r12.configs     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 0
            java.lang.Object r2 = r2.get(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r2 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 1
            int r1 = r7.f(r1, r8, r5, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_configs_"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 <= 0) goto L_0x035c
            r5 = r22
            goto L_0x035e
        L_0x035c:
            r5 = r23
        L_0x035e:
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            long r13 = (long) r1     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r13, r6)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r2 == 0) goto L_0x0374
            java.lang.String r2 = "startDownloadTask() Config资源下载完成\n\n\n\n\n"
            android.util.Log.d(r15, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
        L_0x0374:
            if (r1 <= 0) goto L_0x0377
            goto L_0x037e
        L_0x0377:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            throw r1     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
        L_0x037e:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color> r1 = r12.colors     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 == 0) goto L_0x03d8
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 != 0) goto L_0x03d8
            java.lang.String r1 = "downloader_color_start"
            r13 = 0
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color> r2 = r12.colors     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r13, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            e6.b r1 = e6.b.v()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color> r2 = r12.colors     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 0
            java.lang.Object r2 = r2.get(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r2 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r2     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r5 = 1
            int r1 = r7.f(r1, r8, r5, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            r2.<init>()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r5 = "downloader_color_"
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r1 <= 0) goto L_0x03b6
            r5 = r22
            goto L_0x03b8
        L_0x03b6:
            r5 = r23
        L_0x03b8:
            r2.append(r5)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            long r13 = (long) r1     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r13, r6)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
            if (r2 == 0) goto L_0x03ce
            java.lang.String r2 = "startDownloadTask() color资源下载完成\n\n\n\n\n"
            android.util.Log.d(r15, r2)     // Catch:{ CompleteException -> 0x02c7, Exception -> 0x045d }
        L_0x03ce:
            if (r1 <= 0) goto L_0x03d1
            goto L_0x03d8
        L_0x03d1:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
            throw r1     // Catch:{ CompleteException -> 0x01ee, Exception -> 0x045d }
        L_0x03d8:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$OfflinePackage> r1 = r12.offlinePackages     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 == 0) goto L_0x044f
            boolean r1 = r1.isEmpty()     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            if (r1 != 0) goto L_0x044f
            java.lang.String r1 = "downloader_offlinePackages_start"
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$OfflinePackage> r2 = r12.offlinePackages     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r13, r2)     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$OfflinePackage> r1 = r12.offlinePackages     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            r5 = r1
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$DynamicBaseBean r5 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.DynamicBaseBean) r5     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            java.lang.String r1 = r5.destPath     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            java.lang.String r17 = r7.e(r1)     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            e6.j r2 = e6.j.s()     // Catch:{ CompleteException -> 0x0469, Exception -> 0x045d }
            r18 = 1
            r1 = r27
            r13 = r3
            r3 = r28
            r14 = r4
            r4 = r18
            r18 = r13
            r26 = r14
            r13 = 1
            r13 = r6
            r6 = r17
            int r1 = r1.g(r2, r3, r4, r5, r6)     // Catch:{ CompleteException -> 0x045b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CompleteException -> 0x045b }
            r2.<init>()     // Catch:{ CompleteException -> 0x045b }
            java.lang.String r3 = "downloader_offlinePackages_"
            r2.append(r3)     // Catch:{ CompleteException -> 0x045b }
            if (r1 <= 0) goto L_0x0429
            r3 = r22
            goto L_0x042b
        L_0x0429:
            r3 = r23
        L_0x042b:
            r2.append(r3)     // Catch:{ CompleteException -> 0x045b }
            java.lang.String r2 = r2.toString()     // Catch:{ CompleteException -> 0x045b }
            long r3 = (long) r1     // Catch:{ CompleteException -> 0x045b }
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r3, r13)     // Catch:{ CompleteException -> 0x045b }
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ CompleteException -> 0x045b }
            if (r2 == 0) goto L_0x0441
            java.lang.String r2 = "startDownloadTask() offlinePackages资源下载完成\n\n\n\n\n"
            android.util.Log.d(r15, r2)     // Catch:{ CompleteException -> 0x045b }
        L_0x0441:
            if (r1 <= 0) goto L_0x0444
            goto L_0x0453
        L_0x0444:
            com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException r1 = new com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager$CompleteException     // Catch:{ CompleteException -> 0x044b }
            r2 = 0
            r1.<init>()     // Catch:{ CompleteException -> 0x044b }
            throw r1     // Catch:{ CompleteException -> 0x044b }
        L_0x044b:
            r0 = move-exception
            r2 = r0
            goto L_0x01f4
        L_0x044f:
            r18 = r3
            r26 = r4
        L_0x0453:
            java.lang.String r1 = "startDownloadTask() called with: 所有的下载任务完成"
            r2 = 0
            i6.k.i(r15, r1, r2)     // Catch:{ CompleteException -> 0x045b }
            goto L_0x05ba
        L_0x045b:
            r0 = move-exception
            goto L_0x0476
        L_0x045d:
            r0 = move-exception
            r1 = r0
            r12 = r3
            r6 = r4
            r5 = r19
            r3 = r20
            r4 = r24
            goto L_0x05d1
        L_0x0469:
            r0 = move-exception
            r18 = r3
            r26 = r4
            goto L_0x0476
        L_0x046f:
            r0 = move-exception
            r18 = r3
            r26 = r4
            r24 = r14
        L_0x0476:
            r2 = r0
        L_0x0477:
            r1 = 1
        L_0x0478:
            if (r1 != 0) goto L_0x05ba
            if (r9 == 0) goto L_0x04ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049f }
            r1.<init>()     // Catch:{ Exception -> 0x049f }
            r1.append(r10)     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r2.getMessage()     // Catch:{ Exception -> 0x049f }
            r1.append(r3)     // Catch:{ Exception -> 0x049f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x049f }
            r3 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r11, r3, r1)     // Catch:{ Exception -> 0x049f }
            java.lang.String r1 = "startDownloadTask: 下载DynamicBean异常,换域名再试一次"
            r3 = 0
            i6.k.h(r15, r1, r2, r3)     // Catch:{ Exception -> 0x049f }
            int r1 = r7.h(r8, r3)     // Catch:{ Exception -> 0x049f }
            return r1
        L_0x049f:
            r0 = move-exception
            r1 = r0
            r12 = r18
            r5 = r19
            r3 = r20
            r4 = r24
            r6 = r26
            goto L_0x05d1
        L_0x04ad:
            java.lang.String r1 = "downloader_fail_clear"
            java.lang.String r3 = "下载流程有问题,清除所有已经下载的资源"
            r4 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r4, r3)     // Catch:{ Exception -> 0x05ae }
            java.lang.String r1 = "startDownloadTask() called with: 下载流程有问题,清除所有已经下载的资源"
            r3 = 0
            i6.k.i(r15, r1, r3)     // Catch:{ Exception -> 0x05ae }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n> r1 = r12.i18n     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x04d8
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x049f }
            if (r1 != 0) goto L_0x04d8
            e6.d r1 = e6.d.r()     // Catch:{ Exception -> 0x049f }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n> r3 = r12.i18n     // Catch:{ Exception -> 0x049f }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$I18n r3 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.I18n) r3     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r3.md5     // Catch:{ Exception -> 0x049f }
            r1.b(r3)     // Catch:{ Exception -> 0x049f }
        L_0x04d8:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r1 = r12.edgeEdnges     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x0509
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x049f }
            if (r1 != 0) goto L_0x0509
            r1 = 0
        L_0x04e3:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r3 = r12.edgeEdnges     // Catch:{ Exception -> 0x049f }
            int r3 = r3.size()     // Catch:{ Exception -> 0x049f }
            if (r1 >= r3) goto L_0x0509
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r3 = r12.edgeEdnges     // Catch:{ Exception -> 0x049f }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r3 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r3     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r3.destPath     // Catch:{ Exception -> 0x049f }
            e6.c r3 = e6.c.r(r3)     // Catch:{ Exception -> 0x049f }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge> r4 = r12.edgeEdnges     // Catch:{ Exception -> 0x049f }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$EdgeEdnge r4 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.EdgeEdnge) r4     // Catch:{ Exception -> 0x049f }
            java.lang.String r4 = r4.md5     // Catch:{ Exception -> 0x049f }
            r3.b(r4)     // Catch:{ Exception -> 0x049f }
            int r1 = r1 + 1
            goto L_0x04e3
        L_0x0509:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image> r1 = r12.images     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x0525
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x049f }
            if (r1 != 0) goto L_0x0525
            e6.g r1 = e6.g.v()     // Catch:{ Exception -> 0x049f }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image> r3 = r12.images     // Catch:{ Exception -> 0x049f }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Image r3 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.Image) r3     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r3.md5     // Catch:{ Exception -> 0x049f }
            r1.b(r3)     // Catch:{ Exception -> 0x049f }
        L_0x0525:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig> r1 = r12.configs     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x0541
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x049f }
            if (r1 != 0) goto L_0x0541
            e6.h r1 = e6.h.r()     // Catch:{ Exception -> 0x049f }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig> r3 = r12.configs     // Catch:{ Exception -> 0x049f }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$JsonConfig r3 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.JsonConfig) r3     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r3.md5     // Catch:{ Exception -> 0x049f }
            r1.b(r3)     // Catch:{ Exception -> 0x049f }
        L_0x0541:
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color> r1 = r12.colors     // Catch:{ Exception -> 0x05ae }
            if (r1 == 0) goto L_0x055d
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x049f }
            if (r1 != 0) goto L_0x055d
            e6.b r1 = e6.b.v()     // Catch:{ Exception -> 0x049f }
            java.util.List<com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color> r3 = r12.colors     // Catch:{ Exception -> 0x049f }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x049f }
            com.hbg.lib.common.dynamic.downloader.DyanmicConfig$Color r3 = (com.hbg.lib.common.dynamic.downloader.DyanmicConfig.Color) r3     // Catch:{ Exception -> 0x049f }
            java.lang.String r3 = r3.md5     // Catch:{ Exception -> 0x049f }
            r1.b(r3)     // Catch:{ Exception -> 0x049f }
        L_0x055d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ae }
            r1.<init>()     // Catch:{ Exception -> 0x05ae }
            r3 = r20
            r1.append(r3)     // Catch:{ Exception -> 0x05a8 }
            java.lang.String r4 = r2.getMessage()     // Catch:{ Exception -> 0x05a8 }
            r1.append(r4)     // Catch:{ Exception -> 0x05a8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x05a8 }
            r4 = r24
            r5 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r4, r5, r1)     // Catch:{ Exception -> 0x05a2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05a2 }
            r1.<init>()     // Catch:{ Exception -> 0x05a2 }
            r5 = r19
            r1.append(r5)     // Catch:{ Exception -> 0x059e }
            r6 = r26
            r1.append(r6)     // Catch:{ Exception -> 0x059a }
            r12 = r18
            r1.append(r12)     // Catch:{ Exception -> 0x0598 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0598 }
            r13 = 0
            i6.k.h(r15, r1, r2, r13)     // Catch:{ Exception -> 0x0598 }
            r7.f67439a = r13     // Catch:{ Exception -> 0x0598 }
            return r13
        L_0x0598:
            r0 = move-exception
            goto L_0x05d0
        L_0x059a:
            r0 = move-exception
            r12 = r18
            goto L_0x05d0
        L_0x059e:
            r0 = move-exception
            r12 = r18
            goto L_0x05b7
        L_0x05a2:
            r0 = move-exception
            r12 = r18
            r5 = r19
            goto L_0x05b7
        L_0x05a8:
            r0 = move-exception
            r12 = r18
            r5 = r19
            goto L_0x05b5
        L_0x05ae:
            r0 = move-exception
            r12 = r18
            r5 = r19
            r3 = r20
        L_0x05b5:
            r4 = r24
        L_0x05b7:
            r6 = r26
            goto L_0x05d0
        L_0x05ba:
            java.lang.String r1 = "downloader_success"
            java.lang.String r2 = "DOWN_RS_SUCCESS"
            r3 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r1, r3, r2)
            r1 = 0
            r7.f67439a = r1
            r1 = 1
            return r1
        L_0x05c8:
            r0 = move-exception
            r12 = r3
            r6 = r4
            r4 = r14
            r5 = r19
            r3 = r20
        L_0x05d0:
            r1 = r0
        L_0x05d1:
            if (r9 == 0) goto L_0x05f6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r3 = r1.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r9 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r11, r9, r2)
            java.lang.String r2 = "startDownloadTask: 下载manifest异常,换域名再试一次"
            r3 = 0
            i6.k.h(r15, r2, r1, r3)
            int r1 = r7.h(r8, r3)
            return r1
        L_0x05f6:
            r9 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r3 = r1.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.hbg.lib.common.dynamic.downloader.Util.b(r4, r9, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r6)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r3 = 0
            i6.k.h(r15, r2, r1, r3)
            r7.f67439a = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager.h(okhttp3.OkHttpClient, boolean):int");
    }

    public final HashSet<String> i(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        if (list != null && !list.isEmpty()) {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    public final void j(HBDynamicBaseManager hBDynamicBaseManager, DyanmicConfig.DynamicBaseBean dynamicBaseBean, File file, String str) throws IOException {
        File file2 = new File(file.getParentFile(), TextUtils.isEmpty(dynamicBaseBean.destPath) ? "dest" : dynamicBaseBean.destPath);
        if (file2.exists()) {
            l.c(file2);
        }
        k(file, file2, str);
        hBDynamicBaseManager.o(dynamicBaseBean.md5, file2, dynamicBaseBean.destPath, i(dynamicBaseBean.dependents));
        a(dynamicBaseBean);
    }

    public final void k(File file, File file2, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            b0.b(file, file2);
        } else {
            Util.e(file, file2, str);
        }
    }

    public HBDynamicResDownManager() {
        this.f67439a = false;
        this.f67440b = new ArrayList();
    }
}
