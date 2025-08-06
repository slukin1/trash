package com.geetest.captcha;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0014\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0015\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0018\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u001c\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u001d\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/geetest/captcha/utils/LogUtils;", "", "()V", "DEBUG", "", "ERROR", "INFO", "LEVEL", "PRINT_SIZE", "TAG", "", "VERBOSE", "WARN", "logger", "Lcom/geetest/captcha/utils/LogUtils$Logger;", "d", "", "msg", "tag", "destroy", "e", "i", "init", "level", "log2sd", "printLongString", "data", "release", "v", "w", "Logger", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class ag {

    /* renamed from: a  reason: collision with root package name */
    public static final ag f65177a = new ag();

    /* renamed from: b  reason: collision with root package name */
    private static int f65178b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static a f65179c;

    /* renamed from: d  reason: collision with root package name */
    private static String f65180d = "Captcha";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/geetest/captcha/utils/LogUtils$Logger;", "", "()V", "handler", "Landroid/os/Handler;", "sdf", "Ljava/text/SimpleDateFormat;", "thread", "Landroid/os/HandlerThread;", "checkLogFile", "", "destroy", "init", "log", "tag", "", "msg", "write", "content", "Companion", "Item", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0713a f65181a = new C0713a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private HandlerThread f65182b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f65183c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final SimpleDateFormat f65184d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/geetest/captcha/utils/LogUtils$Logger$Companion;", "", "()V", "EXTERNAL_DIR", "", "FILE_NAME", "MAX_FILE_SIZE", "", "WHAT_INIT", "", "WHAT_MSG", "build", "sdf", "Ljava/text/SimpleDateFormat;", "millis", "tag", "msg", "deleteCauseExceedMaxSize", "", "externalDirPath", "captcha_release"}, k = 1, mv = {1, 1, 16})
        /* renamed from: com.geetest.captcha.ag$a$a  reason: collision with other inner class name */
        public static final class C0713a {
            private C0713a() {
            }

            public static String a() {
                StringBuilder sb2 = new StringBuilder();
                ah ahVar = ah.f65189a;
                sb2.append(ah.a());
                sb2.append(File.separator);
                sb2.append("Geetest");
                return sb2.toString();
            }

            public /* synthetic */ C0713a(byte b11) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/geetest/captcha/utils/LogUtils$Logger$Item;", "", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "millis", "", "getMillis", "()J", "setMillis", "(J)V", "tag", "getTag", "setTag", "captcha_release"}, k = 1, mv = {1, 1, 16})
        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public long f65185a;

            /* renamed from: b  reason: collision with root package name */
            public String f65186b;

            /* renamed from: c  reason: collision with root package name */
            public String f65187c;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/geetest/captcha/utils/LogUtils$Logger$init$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "captcha_release"}, k = 1, mv = {1, 1, 16})
        public static final class c extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65188a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a aVar, Looper looper) {
                super(looper);
                this.f65188a = aVar;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    if (!Thread.interrupted()) {
                        int i11 = message.what;
                        if (i11 == 0) {
                            Object obj = message.obj;
                            if (obj != null) {
                                b bVar = (b) obj;
                                C0713a aVar = a.f65181a;
                                SimpleDateFormat a11 = this.f65188a.f65184d;
                                long j11 = bVar.f65185a;
                                String str = bVar.f65186b;
                                String str2 = bVar.f65187c;
                                a.a(a11.format(new Date(j11)) + 9 + str + 10 + str2 + 10);
                                return;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type com.geetest.captcha.utils.LogUtils.Logger.Item");
                        } else if (i11 == 1) {
                            C0713a aVar2 = a.f65181a;
                            File file = new File(C0713a.a());
                            if (file.exists()) {
                                File file2 = new File(file, "captcha_log.txt");
                                if (file2.exists() && file2.length() >= 10485760) {
                                    file2.delete();
                                }
                            }
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public final synchronized void b() {
            Message obtainMessage = this.f65183c.obtainMessage();
            obtainMessage.what = 1;
            this.f65183c.sendMessage(obtainMessage);
        }

        public final synchronized void c() {
            try {
                this.f65183c.removeMessages(0);
                this.f65183c.removeMessages(1);
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f65182b.quitSafely();
                } else {
                    this.f65182b.quit();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public final synchronized void a() {
            HandlerThread handlerThread = new HandlerThread("Captcha Thread");
            this.f65182b = handlerThread;
            handlerThread.start();
            this.f65183c = new c(this, this.f65182b.getLooper());
        }

        public final synchronized void a(String str, String str2) {
            Message obtainMessage = this.f65183c.obtainMessage();
            obtainMessage.what = 0;
            b bVar = new b();
            bVar.f65185a = System.currentTimeMillis();
            bVar.f65186b = str;
            bVar.f65187c = str2;
            obtainMessage.obj = bVar;
            this.f65183c.sendMessage(obtainMessage);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[SYNTHETIC, Splitter:B:29:0x004f] */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void a(java.lang.String r6) {
            /*
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                java.lang.String r2 = com.geetest.captcha.ag.a.C0713a.a()     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                boolean r2 = r1.exists()     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                if (r2 != 0) goto L_0x0013
                r1.mkdirs()     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            L_0x0013:
                java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                java.lang.String r5 = "captcha_log.txt"
                r4.<init>(r1, r5)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                r1 = 1
                r3.<init>(r4, r1)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
                java.lang.String r0 = "utf-8"
                java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
                if (r6 == 0) goto L_0x0039
                byte[] r6 = r6.getBytes(r0)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
                r2.write(r6)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
                r2.close()     // Catch:{ IOException -> 0x0038 }
            L_0x0038:
                return
            L_0x0039:
                kotlin.TypeCastException r6 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r6.<init>(r0)     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
                throw r6     // Catch:{ Exception -> 0x0044, all -> 0x0041 }
            L_0x0041:
                r6 = move-exception
                r0 = r2
                goto L_0x0047
            L_0x0044:
                r0 = r2
                goto L_0x004d
            L_0x0046:
                r6 = move-exception
            L_0x0047:
                if (r0 == 0) goto L_0x004c
                r0.close()     // Catch:{ IOException -> 0x004c }
            L_0x004c:
                throw r6
            L_0x004d:
                if (r0 == 0) goto L_0x0052
                r0.close()     // Catch:{ IOException -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.ag.a.a(java.lang.String):void");
        }
    }

    private ag() {
    }

    public static void a(String str) {
        if (f65178b <= 2) {
            Log.d(f65180d, str);
            c(f65180d, str);
        }
    }

    public static void b(String str, String str2) {
        if (f65178b <= 3) {
            Log.i(str, str2);
            c(str, str2);
        }
    }

    private static void c(String str, String str2) {
        if (f65179c == null) {
            a aVar = new a();
            f65179c = aVar;
            aVar.a();
            a aVar2 = f65179c;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        a aVar3 = f65179c;
        if (aVar3 != null) {
            aVar3.a(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (f65178b <= 2) {
            Log.d(str, str2);
            c(str, str2);
        }
    }

    public static void b(String str) {
        Log.i(f65180d, str);
        c(f65180d, str);
    }

    public static void a() {
        try {
            a aVar = f65179c;
            if (aVar != null) {
                if (aVar != null) {
                    aVar.c();
                }
                f65179c = null;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
