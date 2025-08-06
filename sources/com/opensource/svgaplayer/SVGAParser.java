package com.opensource.svgaplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import d10.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 >2\u00020\u0001:\u0004.?14B\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010)¢\u0006\u0004\b<\u0010=J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\r\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J$\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fJ,\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010$2\u0006\u0010#\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fJ.\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006JB\u0010(\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010'\u001a\u00020\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\"\u0010:\u001a\u0002038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006@"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser;", "", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "Lcom/opensource/svgaplayer/SVGAParser$c;", "callback", "", "alias", "", "v", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "w", "cacheKey", "o", "Ljava/io/InputStream;", "inputStream", "", "y", "byteArray", "u", "bytes", "", "x", "z", "Ljava/io/File;", "outputFile", "dstDirPath", "t", "name", "Lcom/opensource/svgaplayer/SVGAParser$d;", "playCallback", "m", "Ljava/net/URL;", "url", "Lkotlin/Function0;", "r", "q", "closeInputStream", "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "", "b", "I", "mFrameWidth", "c", "mFrameHeight", "Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "d", "Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "getFileDownloader", "()Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "setFileDownloader", "(Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;)V", "fileDownloader", "context", "<init>", "(Landroid/content/Context;)V", "h", "FileDownloader", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGAParser {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f28500e = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    public static SVGAParser f28501f = new SVGAParser((Context) null);

    /* renamed from: g  reason: collision with root package name */
    public static ExecutorService f28502g = Executors.newCachedThreadPool(a.f28514b);

    /* renamed from: h  reason: collision with root package name */
    public static final b f28503h = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f28504a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f28505b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f28506c;

    /* renamed from: d  reason: collision with root package name */
    public FileDownloader f28507d;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00060\u0004H\u0016R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Ljava/io/InputStream;", "", "complete", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failure", "Lkotlin/Function0;", "b", "", "a", "Z", "()Z", "setNoCache", "(Z)V", "noCache", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static class FileDownloader {

        /* renamed from: a  reason: collision with root package name */
        public boolean f28508a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
        public static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FileDownloader f28509b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ URL f28510c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f28511d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f28512e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f28513f;

            public a(FileDownloader fileDownloader, URL url, Ref$BooleanRef ref$BooleanRef, l lVar, l lVar2) {
                this.f28509b = fileDownloader;
                this.f28510c = url;
                this.f28511d = ref$BooleanRef;
                this.f28512e = lVar;
                this.f28513f = lVar2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
                ay.b.f26389a.f("SVGAParser", "================ svga file download canceled ================");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
                r5 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                kotlin.io.b.a(r4, r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a1, code lost:
                throw r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
                r4 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
                kotlin.io.b.a(r2, r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ac, code lost:
                throw r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x00af, code lost:
                r3 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
                kotlin.io.b.a(r1, r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b3, code lost:
                throw r3;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = "SVGAParser"
                    ay.b r1 = ay.b.f26389a     // Catch:{ Exception -> 0x00b4 }
                    java.lang.String r2 = "================ svga file download start ================"
                    r1.e(r0, r2)     // Catch:{ Exception -> 0x00b4 }
                    android.net.http.HttpResponseCache r2 = android.net.http.HttpResponseCache.getInstalled()     // Catch:{ Exception -> 0x00b4 }
                    if (r2 != 0) goto L_0x0021
                    com.opensource.svgaplayer.SVGAParser$FileDownloader r2 = r10.f28509b     // Catch:{ Exception -> 0x00b4 }
                    boolean r2 = r2.a()     // Catch:{ Exception -> 0x00b4 }
                    if (r2 != 0) goto L_0x0021
                    java.lang.String r2 = "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache"
                    r1.b(r0, r2)     // Catch:{ Exception -> 0x00b4 }
                    java.lang.String r2 = "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache "
                    r1.b(r0, r2)     // Catch:{ Exception -> 0x00b4 }
                L_0x0021:
                    java.net.URL r1 = r10.f28510c     // Catch:{ Exception -> 0x00b4 }
                    java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00b4 }
                    boolean r2 = r1 instanceof java.net.HttpURLConnection     // Catch:{ Exception -> 0x00b4 }
                    r3 = 0
                    if (r2 != 0) goto L_0x002d
                    r1 = r3
                L_0x002d:
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00b4 }
                    if (r1 == 0) goto L_0x00dc
                    r2 = 20000(0x4e20, float:2.8026E-41)
                    r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00b4 }
                    java.lang.String r2 = "GET"
                    r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00b4 }
                    java.lang.String r2 = "Connection"
                    java.lang.String r4 = "close"
                    r1.setRequestProperty(r2, r4)     // Catch:{ Exception -> 0x00b4 }
                    r1.connect()     // Catch:{ Exception -> 0x00b4 }
                    java.io.InputStream r1 = r1.getInputStream()     // Catch:{ Exception -> 0x00b4 }
                    java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00ad }
                    r2.<init>()     // Catch:{ all -> 0x00ad }
                    r4 = 4096(0x1000, float:5.74E-42)
                    byte[] r5 = new byte[r4]     // Catch:{ all -> 0x00a6 }
                L_0x0052:
                    kotlin.jvm.internal.Ref$BooleanRef r6 = r10.f28511d     // Catch:{ all -> 0x00a6 }
                    boolean r6 = r6.element     // Catch:{ all -> 0x00a6 }
                    java.lang.String r7 = "================ svga file download canceled ================"
                    if (r6 == 0) goto L_0x0060
                    ay.b r4 = ay.b.f26389a     // Catch:{ all -> 0x00a6 }
                    r4.f(r0, r7)     // Catch:{ all -> 0x00a6 }
                    goto L_0x0068
                L_0x0060:
                    r6 = 0
                    int r8 = r1.read(r5, r6, r4)     // Catch:{ all -> 0x00a6 }
                    r9 = -1
                    if (r8 != r9) goto L_0x00a2
                L_0x0068:
                    kotlin.jvm.internal.Ref$BooleanRef r4 = r10.f28511d     // Catch:{ all -> 0x00a6 }
                    boolean r4 = r4.element     // Catch:{ all -> 0x00a6 }
                    if (r4 == 0) goto L_0x007a
                    ay.b r4 = ay.b.f26389a     // Catch:{ all -> 0x00a6 }
                    r4.f(r0, r7)     // Catch:{ all -> 0x00a6 }
                    kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x00ad }
                    kotlin.io.b.a(r1, r3)     // Catch:{ Exception -> 0x00b4 }
                    return
                L_0x007a:
                    java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00a6 }
                    byte[] r5 = r2.toByteArray()     // Catch:{ all -> 0x00a6 }
                    r4.<init>(r5)     // Catch:{ all -> 0x00a6 }
                    ay.b r5 = ay.b.f26389a     // Catch:{ all -> 0x009b }
                    java.lang.String r6 = "================ svga file download complete ================"
                    r5.e(r0, r6)     // Catch:{ all -> 0x009b }
                    d10.l r5 = r10.f28512e     // Catch:{ all -> 0x009b }
                    r5.invoke(r4)     // Catch:{ all -> 0x009b }
                    kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x009b }
                    kotlin.io.b.a(r4, r3)     // Catch:{ all -> 0x00a6 }
                    kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x00ad }
                    kotlin.io.b.a(r1, r3)     // Catch:{ Exception -> 0x00b4 }
                    goto L_0x00dc
                L_0x009b:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x009d }
                L_0x009d:
                    r5 = move-exception
                    kotlin.io.b.a(r4, r3)     // Catch:{ all -> 0x00a6 }
                    throw r5     // Catch:{ all -> 0x00a6 }
                L_0x00a2:
                    r2.write(r5, r6, r8)     // Catch:{ all -> 0x00a6 }
                    goto L_0x0052
                L_0x00a6:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x00a8 }
                L_0x00a8:
                    r4 = move-exception
                    kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x00ad }
                    throw r4     // Catch:{ all -> 0x00ad }
                L_0x00ad:
                    r2 = move-exception
                    throw r2     // Catch:{ all -> 0x00af }
                L_0x00af:
                    r3 = move-exception
                    kotlin.io.b.a(r1, r2)     // Catch:{ Exception -> 0x00b4 }
                    throw r3     // Catch:{ Exception -> 0x00b4 }
                L_0x00b4:
                    r1 = move-exception
                    ay.b r2 = ay.b.f26389a
                    java.lang.String r3 = "================ svga file download fail ================"
                    r2.b(r0, r3)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "error: "
                    r3.append(r4)
                    java.lang.String r4 = r1.getMessage()
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r2.b(r0, r3)
                    r1.printStackTrace()
                    d10.l r0 = r10.f28513f
                    r0.invoke(r1)
                L_0x00dc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.FileDownloader.a.run():void");
            }
        }

        public final boolean a() {
            return this.f28508a;
        }

        public d10.a<Unit> b(URL url, l<? super InputStream, Unit> lVar, l<? super Exception, Unit> lVar2) {
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            SVGAParser$FileDownloader$resume$cancelBlock$1 sVGAParser$FileDownloader$resume$cancelBlock$1 = new SVGAParser$FileDownloader$resume$cancelBlock$1(ref$BooleanRef);
            SVGAParser.f28503h.a().execute(new a(this, url, ref$BooleanRef, lVar, lVar2));
            return sVGAParser$FileDownloader$resume$cancelBlock$1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, k = 3, mv = {1, 1, 15})
    public static final class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public static final a f28514b = new a();

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SVGAParser-Thread-" + SVGAParser.f28500e.getAndIncrement());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R*\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$b;", "", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "a", "()Ljava/util/concurrent/ExecutorService;", "setThreadPoolExecutor$com_opensource_svgaplayer", "(Ljava/util/concurrent/ExecutorService;)V", "", "TAG", "Ljava/lang/String;", "Lcom/opensource/svgaplayer/SVGAParser;", "mShareParser", "Lcom/opensource/svgaplayer/SVGAParser;", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class b {
        public b() {
        }

        public final ExecutorService a() {
            return SVGAParser.f28502g;
        }

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$c;", "", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "", "a", "onError", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface c {
        void a(SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$d;", "", "", "Ljava/io/File;", "file", "", "a", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface d {
        void a(List<? extends File> list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SVGAParser f28529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28530c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f28531d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f28532e;

        public e(SVGAParser sVGAParser, String str, c cVar, d dVar) {
            this.f28529b = sVGAParser;
            this.f28530c = str;
            this.f28531d = cVar;
            this.f28532e = dVar;
        }

        public final void run() {
            AssetManager assets;
            InputStream open;
            try {
                Context b11 = this.f28529b.f28504a;
                if (b11 != null && (assets = b11.getAssets()) != null && (open = assets.open(this.f28530c)) != null) {
                    SVGAParser sVGAParser = this.f28529b;
                    SVGACache sVGACache = SVGACache.f28468c;
                    sVGAParser.p(open, sVGACache.c("file:///assets/" + this.f28530c), this.f28531d, true, this.f28532e, this.f28530c);
                }
            } catch (Exception e11) {
                this.f28529b.w(e11, this.f28531d, this.f28530c);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SVGAParser f28533b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28534c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f28535d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f28536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f28537f;

        public f(SVGAParser sVGAParser, String str, c cVar, String str2, d dVar) {
            this.f28533b = sVGAParser;
            this.f28534c = str;
            this.f28535d = cVar;
            this.f28536e = str2;
            this.f28537f = dVar;
        }

        public final void run() {
            if (SVGACache.f28468c.i()) {
                this.f28533b.o(this.f28534c, this.f28535d, this.f28536e);
            } else {
                this.f28533b.q(this.f28534c, this.f28535d, this.f28537f, this.f28536e);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28538b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28539c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f28540d;

        public g(String str, c cVar, SVGAVideoEntity sVGAVideoEntity) {
            this.f28538b = str;
            this.f28539c = cVar;
            this.f28540d = sVGAVideoEntity;
        }

        public final void run() {
            ay.b bVar = ay.b.f26389a;
            bVar.e("SVGAParser", "================ " + this.f28538b + " parser complete ================");
            c cVar = this.f28539c;
            if (cVar != null) {
                cVar.a(this.f28540d);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f28541b;

        public h(c cVar) {
            this.f28541b = cVar;
        }

        public final void run() {
            c cVar = this.f28541b;
            if (cVar != null) {
                cVar.onError();
            }
        }
    }

    public SVGAParser(Context context) {
        this.f28504a = context != null ? context.getApplicationContext() : null;
        SVGACache.f28468c.k(context);
        this.f28507d = new FileDownloader();
    }

    public static /* synthetic */ void n(SVGAParser sVGAParser, String str, c cVar, d dVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            dVar = null;
        }
        sVGAParser.m(str, cVar, dVar);
    }

    public static /* synthetic */ d10.a s(SVGAParser sVGAParser, URL url, c cVar, d dVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            dVar = null;
        }
        return sVGAParser.r(url, cVar, dVar);
    }

    public final void m(String str, c cVar, d dVar) {
        if (this.f28504a == null) {
            ay.b.f26389a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        ay.b bVar = ay.b.f26389a;
        bVar.e("SVGAParser", "================ decode " + str + " from assets ================");
        f28502g.execute(new e(this, str, cVar, dVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.b.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e9, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        kotlin.io.b.a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f0, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f4, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(java.lang.String r11, com.opensource.svgaplayer.SVGAParser.c r12, java.lang.String r13) {
        /*
            r10 = this;
            ay.b r0 = ay.b.f26389a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "================ decode "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = " from cache ================"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SVGAParser"
            r0.e(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "decodeFromCacheKey called with cacheKey : "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.a(r2, r1)
            android.content.Context r1 = r10.f28504a
            if (r1 != 0) goto L_0x003b
            java.lang.String r11 = "在配置 SVGAParser context 前, 无法解析 SVGA 文件。"
            r0.b(r2, r11)
            return
        L_0x003b:
            com.opensource.svgaplayer.SVGACache r1 = com.opensource.svgaplayer.SVGACache.f28468c     // Catch:{ Exception -> 0x0113 }
            java.io.File r11 = r1.b(r11)     // Catch:{ Exception -> 0x0113 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0113 }
            java.lang.String r3 = "movie.binary"
            r1.<init>(r11, r3)     // Catch:{ Exception -> 0x0113 }
            boolean r3 = r1.isFile()     // Catch:{ Exception -> 0x0113 }
            r4 = 0
            if (r3 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = r4
        L_0x0051:
            if (r1 == 0) goto L_0x0092
            java.lang.String r3 = "binary change to entity"
            r0.e(r2, r3)     // Catch:{ Exception -> 0x0083 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0083 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r5 = "binary change to entity success"
            r0.e(r2, r5)     // Catch:{ all -> 0x007c }
            com.opensource.svgaplayer.SVGAVideoEntity r5 = new com.opensource.svgaplayer.SVGAVideoEntity     // Catch:{ all -> 0x007c }
            com.squareup.wire.ProtoAdapter<com.opensource.svgaplayer.proto.MovieEntity> r6 = com.opensource.svgaplayer.proto.MovieEntity.ADAPTER     // Catch:{ all -> 0x007c }
            java.lang.Object r6 = r6.d(r3)     // Catch:{ all -> 0x007c }
            com.opensource.svgaplayer.proto.MovieEntity r6 = (com.opensource.svgaplayer.proto.MovieEntity) r6     // Catch:{ all -> 0x007c }
            int r7 = r10.f28505b     // Catch:{ all -> 0x007c }
            int r8 = r10.f28506c     // Catch:{ all -> 0x007c }
            r5.<init>((com.opensource.svgaplayer.proto.MovieEntity) r6, (java.io.File) r11, (int) r7, (int) r8)     // Catch:{ all -> 0x007c }
            r10.v(r5, r12, r13)     // Catch:{ all -> 0x007c }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x007c }
            kotlin.io.b.a(r3, r4)     // Catch:{ Exception -> 0x0083 }
            goto L_0x0092
        L_0x007c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x007e }
        L_0x007e:
            r4 = move-exception
            kotlin.io.b.a(r3, r0)     // Catch:{ Exception -> 0x0083 }
            throw r4     // Catch:{ Exception -> 0x0083 }
        L_0x0083:
            r0 = move-exception
            ay.b r3 = ay.b.f26389a     // Catch:{ Exception -> 0x0113 }
            java.lang.String r4 = "binary change to entity fail"
            r3.c(r2, r4, r0)     // Catch:{ Exception -> 0x0113 }
            r11.delete()     // Catch:{ Exception -> 0x0113 }
            r1.delete()     // Catch:{ Exception -> 0x0113 }
            throw r0     // Catch:{ Exception -> 0x0113 }
        L_0x0092:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0113 }
            java.lang.String r3 = "movie.spec"
            r1.<init>(r11, r3)     // Catch:{ Exception -> 0x0113 }
            boolean r3 = r1.isFile()     // Catch:{ Exception -> 0x0113 }
            if (r3 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r1 = r4
        L_0x00a1:
            if (r1 == 0) goto L_0x0117
            java.lang.String r3 = "spec change to entity"
            r0.e(r2, r3)     // Catch:{ Exception -> 0x00f5 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f5 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00f5 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00ee }
            r3.<init>()     // Catch:{ all -> 0x00ee }
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r5]     // Catch:{ all -> 0x00e7 }
        L_0x00b6:
            r7 = 0
            int r8 = r0.read(r6, r7, r5)     // Catch:{ all -> 0x00e7 }
            r9 = -1
            if (r8 != r9) goto L_0x00e3
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00e7 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00e7 }
            r6.<init>(r5)     // Catch:{ all -> 0x00e7 }
            ay.b r5 = ay.b.f26389a     // Catch:{ all -> 0x00e7 }
            java.lang.String r7 = "spec change to entity success"
            r5.e(r2, r7)     // Catch:{ all -> 0x00e7 }
            com.opensource.svgaplayer.SVGAVideoEntity r5 = new com.opensource.svgaplayer.SVGAVideoEntity     // Catch:{ all -> 0x00e7 }
            int r7 = r10.f28505b     // Catch:{ all -> 0x00e7 }
            int r8 = r10.f28506c     // Catch:{ all -> 0x00e7 }
            r5.<init>((org.json.JSONObject) r6, (java.io.File) r11, (int) r7, (int) r8)     // Catch:{ all -> 0x00e7 }
            r10.v(r5, r12, r13)     // Catch:{ all -> 0x00e7 }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00e7 }
            kotlin.io.b.a(r3, r4)     // Catch:{ all -> 0x00ee }
            kotlin.io.b.a(r0, r4)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0117
        L_0x00e3:
            r3.write(r6, r7, r8)     // Catch:{ all -> 0x00e7 }
            goto L_0x00b6
        L_0x00e7:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r5 = move-exception
            kotlin.io.b.a(r3, r4)     // Catch:{ all -> 0x00ee }
            throw r5     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00f0 }
        L_0x00f0:
            r4 = move-exception
            kotlin.io.b.a(r0, r3)     // Catch:{ Exception -> 0x00f5 }
            throw r4     // Catch:{ Exception -> 0x00f5 }
        L_0x00f5:
            r0 = move-exception
            ay.b r3 = ay.b.f26389a     // Catch:{ Exception -> 0x0113 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0113 }
            r4.<init>()     // Catch:{ Exception -> 0x0113 }
            r4.append(r13)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r5 = " movie.spec change to entity fail"
            r4.append(r5)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0113 }
            r3.c(r2, r4, r0)     // Catch:{ Exception -> 0x0113 }
            r11.delete()     // Catch:{ Exception -> 0x0113 }
            r1.delete()     // Catch:{ Exception -> 0x0113 }
            throw r0     // Catch:{ Exception -> 0x0113 }
        L_0x0113:
            r11 = move-exception
            r10.w(r11, r12, r13)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.o(java.lang.String, com.opensource.svgaplayer.SVGAParser$c, java.lang.String):void");
    }

    public final void p(InputStream inputStream, String str, c cVar, boolean z11, d dVar, String str2) {
        if (this.f28504a == null) {
            ay.b.f26389a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        ay.b bVar = ay.b.f26389a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("================ decode ");
        String str3 = str2;
        sb2.append(str3);
        sb2.append(" from input stream ================");
        bVar.e("SVGAParser", sb2.toString());
        f28502g.execute(new SVGAParser$decodeFromInputStream$1(this, inputStream, str, cVar, str3, dVar, z11));
    }

    public final void q(String str, c cVar, d dVar, String str2) {
        f28502g.execute(new SVGAParser$decodeFromSVGAFileCacheKey$1(this, str2, str, cVar, dVar));
    }

    public final d10.a<Unit> r(URL url, c cVar, d dVar) {
        if (this.f28504a == null) {
            ay.b.f26389a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return null;
        }
        String url2 = url.toString();
        ay.b bVar = ay.b.f26389a;
        bVar.e("SVGAParser", "================ decode from url: " + url2 + " ================");
        SVGACache sVGACache = SVGACache.f28468c;
        String d11 = sVGACache.d(url);
        if (sVGACache.h(d11)) {
            bVar.e("SVGAParser", "this url cached");
            f28502g.execute(new f(this, d11, cVar, url2, dVar));
            return null;
        }
        bVar.e("SVGAParser", "no cached, prepare to download");
        return this.f28507d.b(url, new SVGAParser$decodeFromURL$2(this, d11, cVar, dVar, url2), new SVGAParser$decodeFromURL$3(this, url, cVar, url2));
    }

    public final void t(File file, String str) {
        String canonicalPath = new File(str).getCanonicalPath();
        if (!StringsKt__StringsJVMKt.M(file.getCanonicalPath(), canonicalPath, false, 2, (Object) null)) {
            throw new IOException("Found Zip Path Traversal Vulnerability with " + canonicalPath);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        kotlin.io.b.a(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] u(byte[] r6) {
        /*
            r5 = this;
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            int r1 = r6.length
            r2 = 0
            r0.setInput(r6, r2, r1)
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r6]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
        L_0x0013:
            int r4 = r0.inflate(r1, r2, r6)     // Catch:{ all -> 0x0029 }
            if (r4 > 0) goto L_0x0025
            r0.end()     // Catch:{ all -> 0x0029 }
            byte[] r6 = r3.toByteArray()     // Catch:{ all -> 0x0029 }
            r0 = 0
            kotlin.io.b.a(r3, r0)
            return r6
        L_0x0025:
            r3.write(r1, r2, r4)     // Catch:{ all -> 0x0029 }
            goto L_0x0013
        L_0x0029:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x002b }
        L_0x002b:
            r0 = move-exception
            kotlin.io.b.a(r3, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.u(byte[]):byte[]");
    }

    public final void v(SVGAVideoEntity sVGAVideoEntity, c cVar, String str) {
        new Handler(Looper.getMainLooper()).post(new g(str, cVar, sVGAVideoEntity));
    }

    public final void w(Exception exc, c cVar, String str) {
        exc.printStackTrace();
        ay.b bVar = ay.b.f26389a;
        bVar.b("SVGAParser", "================ " + str + " parser error ================");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" parse error");
        bVar.c("SVGAParser", sb2.toString(), exc);
        new Handler(Looper.getMainLooper()).post(new h(cVar));
    }

    public final boolean x(byte[] bArr) {
        return bArr.length > 4 && bArr[0] == 80 && bArr[1] == 75 && bArr[2] == 3 && bArr[3] == 4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        kotlin.io.b.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] y(java.io.InputStream r6) {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x001d }
        L_0x0009:
            r3 = 0
            int r4 = r6.read(r2, r3, r1)     // Catch:{ all -> 0x001d }
            if (r4 > 0) goto L_0x0019
            byte[] r6 = r0.toByteArray()     // Catch:{ all -> 0x001d }
            r1 = 0
            kotlin.io.b.a(r0, r1)
            return r6
        L_0x0019:
            r0.write(r2, r3, r4)     // Catch:{ all -> 0x001d }
            goto L_0x0009
        L_0x001d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            kotlin.io.b.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.y(java.io.InputStream):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r4 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.b.a(r2, (java.lang.Throwable) null);
        ay.b.f26389a.b("SVGAParser", "================ unzip complete ================");
        r9.closeEntry();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.io.b.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        kotlin.io.b.a(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        kotlin.io.b.a(r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008f, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(java.io.InputStream r9, java.lang.String r10) {
        /*
            r8 = this;
            ay.b r0 = ay.b.f26389a
            java.lang.String r1 = "SVGAParser"
            java.lang.String r2 = "================ unzip prepare ================"
            r0.e(r1, r2)
            com.opensource.svgaplayer.SVGACache r0 = com.opensource.svgaplayer.SVGACache.f28468c
            java.io.File r10 = r0.b(r10)
            r10.mkdirs()
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0090 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0090 }
            java.util.zip.ZipInputStream r9 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x0089 }
            r9.<init>(r0)     // Catch:{ all -> 0x0089 }
        L_0x001c:
            java.util.zip.ZipEntry r2 = r9.getNextEntry()     // Catch:{ all -> 0x0082 }
            r3 = 0
            if (r2 == 0) goto L_0x0079
            java.lang.String r4 = r2.getName()     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "../"
            r6 = 2
            r7 = 0
            boolean r4 = kotlin.text.StringsKt__StringsKt.R(r4, r5, r7, r6, r3)     // Catch:{ all -> 0x0082 }
            if (r4 == 0) goto L_0x0032
            goto L_0x001c
        L_0x0032:
            java.lang.String r4 = r2.getName()     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "/"
            boolean r4 = kotlin.text.StringsKt__StringsKt.R(r4, r5, r7, r6, r3)     // Catch:{ all -> 0x0082 }
            if (r4 == 0) goto L_0x003f
            goto L_0x001c
        L_0x003f:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0082 }
            r4.<init>(r10, r2)     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r10.getAbsolutePath()     // Catch:{ all -> 0x0082 }
            r8.t(r4, r2)     // Catch:{ all -> 0x0082 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0082 }
            r2.<init>(r4)     // Catch:{ all -> 0x0082 }
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0072 }
        L_0x0058:
            int r5 = r9.read(r4)     // Catch:{ all -> 0x0072 }
            if (r5 > 0) goto L_0x006e
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0072 }
            kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x0082 }
            ay.b r2 = ay.b.f26389a     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "================ unzip complete ================"
            r2.b(r1, r3)     // Catch:{ all -> 0x0082 }
            r9.closeEntry()     // Catch:{ all -> 0x0082 }
            goto L_0x001c
        L_0x006e:
            r2.write(r4, r7, r5)     // Catch:{ all -> 0x0072 }
            goto L_0x0058
        L_0x0072:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r4 = move-exception
            kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x0082 }
            throw r4     // Catch:{ all -> 0x0082 }
        L_0x0079:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0082 }
            kotlin.io.b.a(r9, r3)     // Catch:{ all -> 0x0089 }
            kotlin.io.b.a(r0, r3)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x0082:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r3 = move-exception
            kotlin.io.b.a(r9, r2)     // Catch:{ all -> 0x0089 }
            throw r3     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x008b }
        L_0x008b:
            r2 = move-exception
            kotlin.io.b.a(r0, r9)     // Catch:{ Exception -> 0x0090 }
            throw r2     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            r9 = move-exception
            ay.b r0 = ay.b.f26389a
            java.lang.String r2 = "================ unzip error ================"
            r0.b(r1, r2)
            java.lang.String r2 = "error"
            r0.c(r1, r2, r9)
            com.opensource.svgaplayer.SVGACache r0 = com.opensource.svgaplayer.SVGACache.f28468c
            java.lang.String r1 = r10.getAbsolutePath()
            r0.f(r1)
            r10.delete()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.z(java.io.InputStream, java.lang.String):void");
    }
}
