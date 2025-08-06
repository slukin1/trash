package com.huobi.app.rms;

import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class HBResourceDownloadManager {

    /* renamed from: c  reason: collision with root package name */
    public static final a f42166c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final i<HBResourceDownloadManager> f42167d = LazyKt__LazyJVMKt.a(HBResourceDownloadManager$Companion$manager$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<HBRMSResourceInfoModel> f42168a;

    /* renamed from: b  reason: collision with root package name */
    public final i f42169b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final HBResourceDownloadManager a() {
            return (HBResourceDownloadManager) HBResourceDownloadManager.f42167d.getValue();
        }
    }

    public static final class b implements Callback {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HBRMSResourceInfoModel f42170b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HBResourceDownloadManager f42171c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ p<Long, Long, Unit> f42172d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f42173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ p<Exception, String, Unit> f42174f;

        public b(HBRMSResourceInfoModel hBRMSResourceInfoModel, HBResourceDownloadManager hBResourceDownloadManager, p<? super Long, ? super Long, Unit> pVar, long j11, p<? super Exception, ? super String, Unit> pVar2) {
            this.f42170b = hBRMSResourceInfoModel;
            this.f42171c = hBResourceDownloadManager;
            this.f42172d = pVar;
            this.f42173e = j11;
            this.f42174f = pVar2;
        }

        public void onFailure(Call call, IOException iOException) {
            p<Exception, String, Unit> pVar = this.f42174f;
            if (pVar != null) {
                pVar.invoke(iOException, null);
            }
            this.f42171c.f42168a.remove(this.f42170b);
        }

        public void onResponse(Call call, Response response) {
            String str;
            ResponseBody body = response.body();
            String str2 = "configId==" + this.f42170b.getConfigId() + ",packageId==" + this.f42170b.getPackageId() + ',';
            if (body != null) {
                String header$default = Response.header$default(response, "Content-Length", (String) null, 2, (Object) null);
                long parseLong = header$default != null ? Long.parseLong(header$default) : -1;
                this.f42171c.f(this.f42170b.getZipLocalDirPath());
                File file = new File(this.f42170b.getResourceDownloadFilePath());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                InputStream byteStream = body.byteStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = byteStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    p<Long, Long, Unit> pVar = this.f42172d;
                    if (pVar != null) {
                        pVar.invoke(Long.valueOf(fileOutputStream.getChannel().size()), Long.valueOf(parseLong));
                    }
                }
                fileOutputStream.close();
                String str3 = str2 + "duration==" + (System.currentTimeMillis() - this.f42173e);
                if (!FileUtil.b(this.f42170b.getMd5(), file)) {
                    p<Exception, String, Unit> pVar2 = this.f42174f;
                    if (pVar2 != null) {
                        pVar2.invoke(new Exception("MD5 check fail"), null);
                    }
                    str = "failure," + str3;
                } else if (this.f42171c.h(file, this.f42170b.getResourcePath())) {
                    p<Exception, String, Unit> pVar3 = this.f42174f;
                    if (pVar3 != null) {
                        pVar3.invoke(null, this.f42170b.getResourcePath());
                    }
                    str = "success," + str3;
                } else {
                    FileUtil.c(new File(this.f42170b.getResourcePath()));
                    new File(this.f42170b.getResourcePath()).delete();
                    p<Exception, String, Unit> pVar4 = this.f42174f;
                    if (pVar4 != null) {
                        pVar4.invoke(new Exception("Unzip failed"), null);
                    }
                    str = "failure," + str3;
                }
                this.f42171c.f42168a.remove(this.f42170b);
            } else {
                p<Exception, String, Unit> pVar5 = this.f42174f;
                if (pVar5 != null) {
                    pVar5.invoke(new Exception("Empty response body"), null);
                }
                str = "failure," + str2 + "duration==0";
            }
            LogAndWoodRecorder.c("RMSDownload", str);
        }
    }

    public HBResourceDownloadManager() {
        this.f42168a = new CopyOnWriteArrayList<>();
        this.f42169b = LazyKt__LazyJVMKt.a(HBResourceDownloadManager$downloadRequestManager$2.INSTANCE);
    }

    public /* synthetic */ HBResourceDownloadManager(r rVar) {
        this();
    }

    public final boolean c(HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        CopyOnWriteArrayList<HBRMSResourceInfoModel> copyOnWriteArrayList = this.f42168a;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (HBRMSResourceInfoModel md5 : copyOnWriteArrayList) {
            if (x.b(md5.getMd5(), hBRMSResourceInfoModel.getMd5())) {
                return true;
            }
        }
        return false;
    }

    public final void d(File file) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    d(file2);
                }
                file2.delete();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void e(com.huobi.app.rms.bean.HBRMSResourceInfoModel r10, d10.p<? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> r11, d10.p<? super java.lang.Exception, ? super java.lang.String, kotlin.Unit> r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r0.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = "RMS "
            r0.append(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r10.getResourceTypeEnName()     // Catch:{ all -> 0x00a5 }
            r0.append(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = "开始下载资源包："
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = r10.getPackageUrl()     // Catch:{ all -> 0x00a5 }
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            r2 = 65288(0xff08, float:9.1488E-41)
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = r10.getMd5()     // Catch:{ all -> 0x00a5 }
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            r3 = 65289(0xff09, float:9.149E-41)
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x00a5 }
            boolean r1 = r9.c(r10)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x006e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r11.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r12 = "资源包正在下载队列中，不重复下载："
            r11.append(r12)     // Catch:{ all -> 0x00a5 }
            java.lang.String r12 = r10.getPackageUrl()     // Catch:{ all -> 0x00a5 }
            r11.append(r12)     // Catch:{ all -> 0x00a5 }
            r11.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r10 = r10.getMd5()     // Catch:{ all -> 0x00a5 }
            r11.append(r10)     // Catch:{ all -> 0x00a5 }
            r11.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x00a5 }
            android.util.Log.i(r0, r10)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r9)
            return
        L_0x006e:
            java.util.concurrent.CopyOnWriteArrayList<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r0 = r9.f42168a     // Catch:{ all -> 0x00a5 }
            r0.add(r10)     // Catch:{ all -> 0x00a5 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r10.getPackageUrl()     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x008b
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            okhttp3.Request$Builder r0 = r1.url((java.lang.String) r0)     // Catch:{ all -> 0x00a5 }
            okhttp3.Request r0 = r0.build()     // Catch:{ all -> 0x00a5 }
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r0 == 0) goto L_0x00a3
            okhttp3.OkHttpClient r1 = r9.g()     // Catch:{ all -> 0x00a5 }
            okhttp3.Call r0 = r1.newCall(r0)     // Catch:{ all -> 0x00a5 }
            com.huobi.app.rms.HBResourceDownloadManager$b r8 = new com.huobi.app.rms.HBResourceDownloadManager$b     // Catch:{ all -> 0x00a5 }
            r1 = r8
            r2 = r10
            r3 = r9
            r4 = r11
            r7 = r12
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x00a5 }
            r0.enqueue(r8)     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r9)
            return
        L_0x00a5:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBResourceDownloadManager.e(com.huobi.app.rms.bean.HBRMSResourceInfoModel, d10.p, d10.p):void");
    }

    public final File f(String str) {
        File file = new File(str);
        if (StringsKt__StringsJVMKt.v(str, "/Skin", false, 2, (Object) null)) {
            d(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final OkHttpClient g() {
        return (OkHttpClient) this.f42169b.getValue();
    }

    public final boolean h(File file, String str) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                File file2 = new File(str, nextEntry.getName());
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    String parent = file2.getParent();
                    File file3 = parent != null ? new File(parent) : null;
                    if (file3 != null && !file3.exists()) {
                        file3.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                }
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }
}
