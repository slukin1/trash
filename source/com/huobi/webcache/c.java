package com.huobi.webcache;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.aspectj.lang.JoinPoint;

public class c {

    /* renamed from: l  reason: collision with root package name */
    public static int f20690l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f20691m = new ConcurrentHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    public static final LoadFinishCallBack f20692n = new a();

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f20693o = null;

    /* renamed from: p  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f20694p = null;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20695a;

    /* renamed from: b  reason: collision with root package name */
    public long f20696b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Context> f20697c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20698d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20699e;

    /* renamed from: f  reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f20700f;

    /* renamed from: g  reason: collision with root package name */
    public WebView f20701g;

    /* renamed from: h  reason: collision with root package name */
    public String f20702h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f20703i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20704j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f20705k;

    public static class a extends LoadFinishCallBack<String> {
        /* renamed from: b */
        public void a(String str, String str2, WebView webView) {
            if (str.startsWith("webviewError")) {
                c.f20691m.put(str2, str);
            }
        }
    }

    public class b implements Handler.Callback {

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ JoinPoint.StaticPart f20706c = null;

        static {
            a();
        }

        public b() {
        }

        public static /* synthetic */ void a() {
            org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("PreloadService.java", b.class);
            f20706c = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.huobi.webcache.OnlyCacheWebView", "android.webkit.WebViewClient", "client", "", "void"), 110);
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 34 || i11 == 37) {
                if (i11 != 37) {
                    c.this.f20703i.removeMessages(37);
                    if (c.this.f20695a) {
                        Log.e("PreloadService", "handleMessage() called with: msg = [LOAD_NEXT_URL]");
                    }
                } else if (c.this.f20695a) {
                    Log.e("PreloadService", "handleMessage() called with: msg = [FINISH_CURRENT_TASK]");
                }
                Object obj = message.obj;
                if (obj instanceof OnlyCacheWebView) {
                    OnlyCacheWebView onlyCacheWebView = (OnlyCacheWebView) obj;
                    try {
                        a aVar = new a(c.f20690l, c.this.f20703i, c.this.f20695a);
                        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f20706c, this, onlyCacheWebView, aVar);
                        WoodPeckerWebViewAspect.h().g(new d(new Object[]{this, onlyCacheWebView, aVar, c11}).linkClosureAndJoinPoint(4112));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    if (c.this.f20695a) {
                        onlyCacheWebView.setWebChromeClient(new WebChromeClientWrapper());
                    }
                    onlyCacheWebView.stopLoading();
                    c.this.o(onlyCacheWebView);
                } else {
                    c cVar = c.this;
                    cVar.o(cVar.l());
                }
            } else if (i11 == 35) {
                c.this.w();
            } else if (i11 == 36 && c.this.f20695a) {
                Toast.makeText((Context) c.this.f20697c.get(), c.this.k() + "完成", 0).show();
                if (!c.f20691m.isEmpty()) {
                    c.this.w();
                }
            }
            return true;
        }
    }

    /* renamed from: com.huobi.webcache.c$c  reason: collision with other inner class name */
    public static class C0158c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static final c f20708a = new c((a) null);
    }

    static {
        i();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static /* synthetic */ void i() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("PreloadService.java", c.class);
        f20693o = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 297);
        f20694p = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 382);
    }

    public static c j() {
        return C0158c.f20708a;
    }

    public final String k() {
        int i11 = f20690l;
        if (i11 == 0) {
            return "缓存";
        }
        return i11 == 1 ? "检查" : "加载";
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final WebView l() {
        if (!this.f20704j || this.f20701g == null) {
            try {
                this.f20701g = new OnlyCacheWebView((Context) this.f20697c.get());
            } catch (Exception e11) {
                e11.printStackTrace();
                if (this.f20697c.get() instanceof Activity) {
                    this.f20701g = new OnlyCacheWebView(((Context) this.f20697c.get()).getApplicationContext());
                }
            }
        }
        WebView webView = this.f20701g;
        if (webView == null) {
            return webView;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        try {
            WebView webView2 = this.f20701g;
            a aVar = new a(f20690l, this.f20703i, this.f20695a);
            JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f20694p, this, webView2, aVar);
            WoodPeckerWebViewAspect.h().g(new f(new Object[]{this, webView2, aVar, c11}).linkClosureAndJoinPoint(4112));
        } catch (Exception unused) {
        }
        if (this.f20695a) {
            this.f20701g.setWebChromeClient(new WebChromeClientWrapper());
        }
        return this.f20701g;
    }

    public boolean m() {
        return this.f20698d;
    }

    public boolean n() {
        return this.f20699e;
    }

    public final synchronized void o(WebView webView) {
        if (webView == null) {
            this.f20700f.clear();
        }
        String poll = this.f20700f.poll();
        if (TextUtils.isEmpty(poll) && this.f20700f.size() == 0) {
            z(webView);
            if (f20690l == 1) {
                this.f20703i.sendEmptyMessage(35);
            } else {
                this.f20703i.sendEmptyMessage(36);
            }
        } else if (poll == null || !poll.startsWith("http")) {
            if (this.f20695a) {
                Log.e("PreloadService", "loadRequestWithWebView() called with: 没有开始loadUrl,url不合法 url= [" + poll + "]");
            }
            o(webView);
        } else {
            this.f20702h = poll;
            if (this.f20695a) {
                Log.e("PreloadService", "==============开始" + k() + "还剩[" + this.f20700f.size() + "]个待缓存,  当前缓存的weburl=" + poll);
            }
            Handler handler = this.f20703i;
            handler.sendMessageDelayed(Message.obtain(handler, 37, webView), this.f20696b);
            if (this.f20695a) {
                Log.e("PreloadService", "loadRequestWithWebView() called with: view = [" + (this.f20696b / 1000) + "秒后超时], request = [" + poll + "]");
            }
            if (this.f20705k == null) {
                this.f20705k = new HashMap();
            }
            this.f20705k.put("huobi_pro_cache", "1");
            g.h().n(webView, this.f20702h, this.f20705k);
        }
    }

    public synchronized void p(Context context, int i11, HashSet<String> hashSet, Map<String, String> map) {
        if (this.f20699e) {
            if (this.f20695a) {
                Log.e("PreloadService", "preload() called with: 正在缓存中,将list加入缓存列队:" + hashSet);
            }
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (!this.f20700f.contains(next)) {
                    this.f20700f.offer(next);
                }
            }
            if (this.f20695a) {
                Log.e("PreloadService", String.format("preload() called cacheUrls.size()=%s ", new Object[]{this.f20700f.size() + ""}));
                Iterator<String> it3 = this.f20700f.iterator();
                int i12 = 1;
                while (it3.hasNext()) {
                    Log.e("PreloadService", String.format("preload(%d) called url=%s ", new Object[]{Integer.valueOf(i12), it3.next()}));
                    i12++;
                }
            }
        } else if (this.f20698d) {
            if (this.f20695a) {
                Log.e("PreloadService", "preload() called with: 已经缓存完了,将list加入缓存列队:" + hashSet);
            }
            r(context, i11, hashSet, map);
        } else {
            x(context, i11, hashSet, map);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void q(java.util.HashSet<java.lang.String> r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x008f
            int r2 = r8.size()     // Catch:{ all -> 0x00a0 }
            if (r2 != 0) goto L_0x000d
            goto L_0x008f
        L_0x000d:
            java.lang.ref.WeakReference<android.content.Context> r2 = r7.f20697c     // Catch:{ all -> 0x00a0 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00a0 }
            if (r2 == 0) goto L_0x007e
            int r2 = r8.size()     // Catch:{ all -> 0x00a0 }
            if (r2 <= 0) goto L_0x007e
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> r2 = r7.f20700f     // Catch:{ all -> 0x00a0 }
            r2.addAll(r8)     // Catch:{ all -> 0x00a0 }
            boolean r8 = r7.f20695a     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x0074
            java.lang.String r8 = "PreloadService"
            java.lang.String r2 = "preloadCreateWebViewWithUrls called cacheUrls.size()=%s "
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r4.<init>()     // Catch:{ all -> 0x00a0 }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> r5 = r7.f20700f     // Catch:{ all -> 0x00a0 }
            int r5 = r5.size()     // Catch:{ all -> 0x00a0 }
            r4.append(r5)     // Catch:{ all -> 0x00a0 }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a0 }
            r3[r0] = r4     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x00a0 }
            android.util.Log.e(r8, r2)     // Catch:{ all -> 0x00a0 }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> r8 = r7.f20700f     // Catch:{ all -> 0x00a0 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00a0 }
            r2 = r1
        L_0x0051:
            boolean r3 = r8.hasNext()     // Catch:{ all -> 0x00a0 }
            if (r3 == 0) goto L_0x0074
            java.lang.String r3 = "PreloadService"
            java.lang.String r4 = "preloadCreateWebViewWithUrls(%d) called url=%s "
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a0 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a0 }
            r5[r0] = r6     // Catch:{ all -> 0x00a0 }
            java.lang.Object r6 = r8.next()     // Catch:{ all -> 0x00a0 }
            r5[r1] = r6     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00a0 }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x00a0 }
            int r2 = r2 + 1
            goto L_0x0051
        L_0x0074:
            r7.f20699e = r1     // Catch:{ all -> 0x00a0 }
            android.os.Handler r8 = r7.f20703i     // Catch:{ all -> 0x00a0 }
            r0 = 34
            r8.sendEmptyMessage(r0)     // Catch:{ all -> 0x00a0 }
            goto L_0x008d
        L_0x007e:
            r7.f20699e = r0     // Catch:{ all -> 0x00a0 }
            r7.f20698d = r1     // Catch:{ all -> 0x00a0 }
            boolean r8 = r7.f20695a     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x008d
            java.lang.String r8 = "PreloadService"
            java.lang.String r0 = "preloadCreateWebViewWithUrls() called with: 没有开始缓存url任务,因为Context被回收了"
            android.util.Log.e(r8, r0)     // Catch:{ all -> 0x00a0 }
        L_0x008d:
            monitor-exit(r7)
            return
        L_0x008f:
            r7.f20699e = r0     // Catch:{ all -> 0x00a0 }
            r7.f20698d = r1     // Catch:{ all -> 0x00a0 }
            boolean r8 = r7.f20695a     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x009e
            java.lang.String r8 = "PreloadService"
            java.lang.String r0 = "preloadCreateWebViewWithUrls() called with: 没有需要缓存url任务"
            android.util.Log.e(r8, r0)     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r7)
            return
        L_0x00a0:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.c.q(java.util.HashSet):void");
    }

    public synchronized void r(Context context, int i11, HashSet<String> hashSet, Map<String, String> map) {
        y();
        x(context, i11, hashSet, map);
    }

    public void s(boolean z11) {
        this.f20695a = z11;
    }

    public void t(long j11) {
        if (j11 < 3000 || j11 > 30000) {
            j11 = 8000;
        }
        this.f20696b = j11;
    }

    public final void w() {
        ConcurrentHashMap<String, String> concurrentHashMap = f20691m;
        if (!concurrentHashMap.isEmpty()) {
            if (this.f20695a) {
                Log.e("PreloadService", k() + "完成,有部分连接异常:");
            }
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                String str = (String) next.getValue();
                String str2 = (String) next.getKey();
                Log.e("PreloadService", "Key = " + ((String) next.getKey()) + ", Value = " + ((String) next.getValue()));
            }
        } else if (this.f20695a) {
            Log.e("PreloadService", "所有连接正常" + k() + "完成");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void x(android.content.Context r2, int r3, java.util.HashSet<java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x007a }
            r0.<init>(r2)     // Catch:{ all -> 0x007a }
            r1.f20697c = r0     // Catch:{ all -> 0x007a }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> r2 = r1.f20700f     // Catch:{ all -> 0x007a }
            r2.clear()     // Catch:{ all -> 0x007a }
            java.lang.String r2 = ""
            r1.f20702h = r2     // Catch:{ all -> 0x007a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = f20691m     // Catch:{ all -> 0x007a }
            r2.clear()     // Catch:{ all -> 0x007a }
            f20690l = r3     // Catch:{ all -> 0x007a }
            boolean r2 = r1.f20698d     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0029
            boolean r2 = r1.f20695a     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = "PreloadService"
            java.lang.String r3 = "preloadCreateWebViewWithUrls() called with: 已经缓存完了"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x007a }
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            boolean r2 = r1.f20699e     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x003a
            boolean r2 = r1.f20695a     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "PreloadService"
            java.lang.String r3 = "preloadCreateWebViewWithUrls() called with: 正在缓存中"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x007a }
        L_0x0038:
            monitor-exit(r1)
            return
        L_0x003a:
            if (r5 == 0) goto L_0x004c
            boolean r2 = r5.isEmpty()     // Catch:{ all -> 0x007a }
            if (r2 != 0) goto L_0x004c
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f20705k     // Catch:{ all -> 0x007a }
            r2.clear()     // Catch:{ all -> 0x007a }
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f20705k     // Catch:{ all -> 0x007a }
            r2.putAll(r5)     // Catch:{ all -> 0x007a }
        L_0x004c:
            boolean r2 = r1.f20695a     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0075
            java.lang.String r2 = "PreloadService"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r3.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r5 = "preLoadUrls() called with: preLoadType= "
            r3.append(r5)     // Catch:{ all -> 0x007a }
            int r5 = f20690l     // Catch:{ all -> 0x007a }
            r3.append(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = " ,urls = ["
            r3.append(r5)     // Catch:{ all -> 0x007a }
            r3.append(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = "]"
            r3.append(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007a }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x007a }
        L_0x0075:
            r1.q(r4)     // Catch:{ all -> 0x007a }
            monitor-exit(r1)
            return
        L_0x007a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.c.x(android.content.Context, int, java.util.HashSet, java.util.Map):void");
    }

    public synchronized void y() {
        z(this.f20701g);
        WebView webView = this.f20701g;
        if (webView != null) {
            webView.removeAllViews();
        }
        this.f20703i.removeCallbacksAndMessages(0);
        if (!this.f20704j) {
            this.f20701g = null;
        }
        this.f20698d = false;
    }

    public void z(WebView webView) {
        if (this.f20695a) {
            Log.e("PreloadService", "stopPreload停止预加载服务, view:" + webView);
        }
        if (webView != null) {
            try {
                webView.stopLoading();
            } catch (Throwable unused) {
            }
            if (webView.getHandler() != null) {
                webView.getHandler().removeCallbacksAndMessages((Object) null);
            }
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.setWebChromeClient((WebChromeClient) null);
            try {
                JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f20693o, this, webView, (Object) null);
                WoodPeckerWebViewAspect.h().g(new e(new Object[]{this, webView, null, c11}).linkClosureAndJoinPoint(4112));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                webView.clearHistory();
            } catch (Throwable unused2) {
            }
        }
        if (!this.f20704j) {
            this.f20701g = null;
        }
        this.f20698d = true;
        this.f20699e = false;
    }

    public c() {
        this.f20695a = true;
        this.f20696b = 8000;
        this.f20698d = false;
        this.f20699e = false;
        this.f20700f = new ConcurrentLinkedQueue<>();
        this.f20702h = "";
        this.f20703i = new Handler(Looper.getMainLooper(), new b());
        this.f20704j = false;
        this.f20705k = new HashMap();
    }
}
