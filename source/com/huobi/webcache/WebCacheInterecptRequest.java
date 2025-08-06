package com.huobi.webcache;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pu.a;

public class WebCacheInterecptRequest {

    /* renamed from: m  reason: collision with root package name */
    public static boolean f20660m = false;

    /* renamed from: n  reason: collision with root package name */
    public static int f20661n;

    /* renamed from: o  reason: collision with root package name */
    public static int f20662o;

    /* renamed from: p  reason: collision with root package name */
    public static int f20663p;

    /* renamed from: q  reason: collision with root package name */
    public static List<String> f20664q = Collections.synchronizedList(new ArrayList(128));

    /* renamed from: r  reason: collision with root package name */
    public static List<String> f20665r = Collections.synchronizedList(new ArrayList(128));

    /* renamed from: s  reason: collision with root package name */
    public static List<String> f20666s = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with root package name */
    public final CacheExtensionConfig f20667a = new CacheExtensionConfig();

    /* renamed from: b  reason: collision with root package name */
    public boolean f20668b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20669c = true;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f20670d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f20671e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f20672f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f20673g = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f20674h = true;

    /* renamed from: i  reason: collision with root package name */
    public CacheStrategy f20675i = CacheStrategy.FORCE;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20676j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20677k = true;

    /* renamed from: l  reason: collision with root package name */
    public ConcurrentHashMap<String, String> f20678l = new ConcurrentHashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final WebCacheInterecptRequest f20679a = new WebCacheInterecptRequest();
    }

    public static void b() {
        f20661n = 0;
        f20662o = 0;
        f20663p = 0;
        f20664q.clear();
        f20665r.clear();
        f20666s.clear();
    }

    public static WebCacheInterecptRequest d() {
        return a.f20679a;
    }

    @SuppressLint({"LongLogTag"})
    public static void g() {
        if (f20660m && f20662o != 0) {
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "printCacheStatistics() called");
            }
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "requestNum=" + f20661n);
            }
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "resourceNum=" + f20662o);
            }
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "resourceCacheNum=" + f20663p);
            }
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "resourceUrlList=\n" + f20664q);
            }
            if (d().f20674h) {
                Log.d("WebCacheInterecptRequest", "resourceUrlCacheList=\n" + f20665r);
            }
            if (f20662o == f20663p) {
                Log.d("WebCacheInterecptRequest", "已经全部缓存了");
            } else {
                f20666s.clear();
                HashSet hashSet = new HashSet();
                hashSet.addAll(f20665r);
                for (int i11 = 0; i11 < f20664q.size(); i11++) {
                    if (!hashSet.contains(f20664q.get(i11))) {
                        f20666s.add(f20664q.get(i11));
                    }
                }
                Log.d("WebCacheInterecptRequest", "没有命中缓存的列表=\n" + f20666s);
            }
            b();
        }
    }

    public final void a(WebView webView, LoadFinishCallBack loadFinishCallBack, String str, String str2) {
        if (loadFinishCallBack != null) {
            loadFinishCallBack.a(str2, str, webView);
        }
    }

    public final String c(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.f20678l) != null && !concurrentHashMap.isEmpty()) {
            for (String next : this.f20678l.keySet()) {
                if (str.endsWith(next)) {
                    return this.f20678l.get(next);
                }
            }
        }
        return null;
    }

    @SuppressLint({"LongLogTag"})
    public final WebResourceResponse e(WebView webView, String str, String str2, String str3, a.e eVar, LoadFinishCallBack loadFinishCallBack) {
        if (!g.h().k(eVar)) {
            if (this.f20674h) {
                Log.i("WebCacheInterecptRequest", "没有可用的缓存，正常资源，走系统默认请求 url=" + str);
            }
            a(webView, loadFinishCallBack, str, "webviewError:缓存数据有问题");
            return null;
        } else if (H5HttpUtils.k(this.f20667a, str3)) {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.X_REQUESTED_WITH);
            hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,OPTIONS");
            if (this.f20674h) {
                Log.i("WebCacheInterecptRequest", "缓存结果：跨域资源，从缓存中直接返回 url=" + str);
            }
            a(webView, loadFinishCallBack, str, "finish");
            return new WebResourceResponse(str2, "utf-8", 200, "OK", hashMap, g.e(eVar));
        } else {
            if (this.f20674h) {
                Log.i("WebCacheInterecptRequest", "缓存结果：从缓存中直接返回 url=" + str);
            }
            a(webView, loadFinishCallBack, str, "finish");
            return new WebResourceResponse(str2, "utf-8", g.e(eVar));
        }
    }

    @SuppressLint({"LongLogTag"})
    public WebResourceResponse f(WebView webView, WebResourceRequest webResourceRequest) {
        return s(webView, webResourceRequest, 2, (LoadFinishCallBack) null);
    }

    public void h(HashSet<String> hashSet) {
        if (hashSet != null) {
            this.f20673g.clear();
            this.f20673g.addAll(hashSet);
        }
    }

    public void i(boolean z11) {
        this.f20669c = z11;
    }

    public void j(boolean z11) {
        this.f20668b = z11;
    }

    public void k(CacheStrategy cacheStrategy) {
        this.f20675i = cacheStrategy;
    }

    public void l(HashSet<String> hashSet) {
        if (hashSet != null) {
            this.f20672f.clear();
            this.f20672f.addAll(hashSet);
        }
    }

    public void m(boolean z11) {
        this.f20674h = z11;
    }

    public void n(HashSet<String> hashSet) {
        if (hashSet != null) {
            this.f20671e.clear();
            this.f20671e.addAll(hashSet);
        }
    }

    public void o(HashSet<String> hashSet) {
        if (hashSet != null) {
            this.f20670d.clear();
            this.f20670d.addAll(hashSet);
        }
    }

    public void p(ConcurrentHashMap<String, String> concurrentHashMap) {
        if (concurrentHashMap != null) {
            this.f20678l.clear();
            this.f20678l.putAll(concurrentHashMap);
        }
    }

    public void q(boolean z11) {
        this.f20677k = z11;
    }

    public void r(boolean z11) {
        this.f20676j = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a2  */
    @android.annotation.SuppressLint({"LongLogTag"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.webkit.WebResourceResponse s(android.webkit.WebView r18, android.webkit.WebResourceRequest r19, int r20, com.huobi.webcache.LoadFinishCallBack r21) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            r10 = r20
            r11 = r21
            android.net.Uri r0 = r19.getUrl()
            java.lang.String r0 = r0.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r12 = 0
            java.lang.String r13 = "WebCacheInterecptRequest"
            if (r1 != 0) goto L_0x0402
            java.lang.String r1 = "http"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0023
            goto L_0x0402
        L_0x0023:
            com.huobi.webcache.CacheStrategy r1 = r8.f20675i
            com.huobi.webcache.CacheStrategy r2 = com.huobi.webcache.CacheStrategy.NO_CACHE
            if (r1 != r2) goto L_0x0047
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x0041
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：非缓存模式,系统默认请求,不缓存 url="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1)
        L_0x0041:
            java.lang.String r1 = "webview network:CacheStrategy.NO_CACHE"
            r8.a(r9, r11, r0, r1)
            return r12
        L_0x0047:
            boolean r1 = f20660m
            r2 = 1
            if (r1 == 0) goto L_0x0051
            int r1 = f20661n
            int r1 = r1 + r2
            f20661n = r1
        L_0x0051:
            java.util.HashSet<java.lang.String> r1 = r8.f20673g
            android.net.Uri r3 = r19.getUrl()
            java.lang.String r3 = r3.toString()
            boolean r1 = com.huobi.webcache.H5HttpUtils.j(r1, r3)
            if (r1 == 0) goto L_0x007f
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x0079
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：命中黑名单,系统默认请求,不缓存 url="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1)
        L_0x0079:
            java.lang.String r1 = "webview network:black list"
            r8.a(r9, r11, r0, r1)
            return r12
        L_0x007f:
            boolean r1 = r19.isForMainFrame()
            java.util.HashSet<java.lang.String> r3 = r8.f20671e
            boolean r3 = com.huobi.webcache.H5HttpUtils.i(r3, r0)
            android.net.Uri r4 = r19.getUrl()
            java.lang.String r4 = r4.getPath()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00c9
            java.lang.String r5 = r8.c(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x00c9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            java.lang.String r7 = "?"
            boolean r0 = r0.contains(r7)
            java.lang.String r14 = "cacheversion="
            if (r0 == 0) goto L_0x00bc
            java.lang.String r0 = "&"
            r6.append(r0)
            r6.append(r14)
            r6.append(r5)
            goto L_0x00c5
        L_0x00bc:
            r6.append(r7)
            r6.append(r14)
            r6.append(r5)
        L_0x00c5:
            java.lang.String r0 = r6.toString()
        L_0x00c9:
            r14 = r0
            boolean r0 = r8.f20677k
            java.lang.String r5 = "finish"
            if (r0 == 0) goto L_0x010b
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x010b
            java.lang.String r0 = "favicon.ico"
            boolean r0 = r4.endsWith(r0)
            if (r0 == 0) goto L_0x010b
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = "缓存结果：favicon.ico，直接返回."
            android.util.Log.d(r13, r0)
        L_0x00e7:
            r8.a(r9, r11, r14, r5)
            boolean r0 = f20660m     // Catch:{ Exception -> 0x0102 }
            if (r0 == 0) goto L_0x0102
            java.util.List<java.lang.String> r0 = f20664q     // Catch:{ Exception -> 0x0102 }
            r0.add(r14)     // Catch:{ Exception -> 0x0102 }
            java.util.List<java.lang.String> r0 = f20665r     // Catch:{ Exception -> 0x0102 }
            r0.add(r14)     // Catch:{ Exception -> 0x0102 }
            int r0 = f20662o     // Catch:{ Exception -> 0x0102 }
            int r0 = r0 + r2
            f20662o = r0     // Catch:{ Exception -> 0x0102 }
            int r0 = f20663p     // Catch:{ Exception -> 0x0102 }
            int r0 = r0 + r2
            f20663p = r0     // Catch:{ Exception -> 0x0102 }
        L_0x0102:
            android.content.Context r0 = r18.getContext()
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.c(r0)
            return r0
        L_0x010b:
            java.lang.String r0 = r19.getMethod()
            java.lang.String r4 = "POST"
            boolean r0 = r0.equals(r4)
            java.lang.String r4 = "empty response"
            if (r0 != 0) goto L_0x03d9
            java.lang.String r0 = r19.getMethod()
            java.lang.String r6 = "OPTIONS"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0127
            goto L_0x03d9
        L_0x0127:
            if (r10 == 0) goto L_0x012b
            if (r10 != r2) goto L_0x013b
        L_0x012b:
            java.util.HashSet<java.lang.String> r0 = r8.f20670d
            boolean r0 = com.huobi.webcache.H5HttpUtils.j(r0, r14)
            if (r0 == 0) goto L_0x013b
            r8.a(r9, r11, r14, r4)
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x013b:
            if (r10 != 0) goto L_0x0156
            com.huobi.webcache.CacheExtensionConfig r0 = r8.f20667a
            boolean r0 = r0.f(r14)
            if (r0 == 0) goto L_0x0156
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x014e
            java.lang.String r0 = "缓存结果：黑名单，直接返回空的Response,造成拦截请求的效果."
            android.util.Log.e(r13, r0)
        L_0x014e:
            r8.a(r9, r11, r14, r4)
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x0156:
            com.huobi.webcache.CacheExtensionConfig r0 = r8.f20667a
            java.lang.String r0 = r0.e(r14)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r6 = "GET"
            r7 = 2
            if (r4 == 0) goto L_0x01d0
            if (r10 == 0) goto L_0x0169
            if (r10 != r7) goto L_0x0180
        L_0x0169:
            if (r3 != 0) goto L_0x01ce
            boolean r4 = r8.f20668b
            if (r4 == 0) goto L_0x0171
            if (r1 != 0) goto L_0x01ce
        L_0x0171:
            boolean r4 = r8.f20669c
            if (r4 == 0) goto L_0x0180
            java.lang.String r4 = r19.getMethod()
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0180
            goto L_0x01ce
        L_0x0180:
            boolean r2 = r8.f20674h
            if (r2 == 0) goto L_0x01b4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "缓存结果：不能识别的mimeType("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ")getMethod="
            r2.append(r3)
            java.lang.String r3 = r19.getMethod()
            r2.append(r3)
            java.lang.String r3 = ",isForMainFrame="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ",走,系统默认请求,不缓存 url="
            r2.append(r1)
            r2.append(r14)
            java.lang.String r1 = r2.toString()
            android.util.Log.e(r13, r1)
        L_0x01b4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "webview network:不能识别的mimeType("
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ")"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.a(r9, r11, r14, r0)
            return r12
        L_0x01ce:
            java.lang.String r0 = "text/html"
        L_0x01d0:
            r4 = r0
            java.lang.String r0 = com.huobi.webcache.CacheExtensionConfig.c(r14)
            if (r10 == 0) goto L_0x01d9
            if (r10 != r7) goto L_0x01f7
        L_0x01d9:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L_0x01f7
            if (r3 != 0) goto L_0x01f5
            boolean r3 = r8.f20668b
            if (r3 == 0) goto L_0x01e7
            if (r1 != 0) goto L_0x01f5
        L_0x01e7:
            boolean r1 = r8.f20669c
            if (r1 == 0) goto L_0x01f7
            java.lang.String r1 = r19.getMethod()
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x01f7
        L_0x01f5:
            java.lang.String r0 = "html"
        L_0x01f7:
            com.huobi.webcache.CacheExtensionConfig r1 = r8.f20667a
            boolean r1 = r1.i(r0)
            if (r1 == 0) goto L_0x0221
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：媒体类型文件,系统默认请求,不缓存extension="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " ,url="
            r1.append(r0)
            r1.append(r14)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r13, r0)
            java.lang.String r0 = "webview network:媒体类型文件"
            r8.a(r9, r11, r14, r0)
            return r12
        L_0x0221:
            java.util.HashSet<java.lang.String> r1 = r8.f20672f
            boolean r1 = com.huobi.webcache.H5HttpUtils.a(r1, r0)
            if (r1 != 0) goto L_0x024f
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x0249
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：不能缓存的文件类型,系统默认请求,不缓存"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " url="
            r1.append(r0)
            r1.append(r14)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r13, r0)
        L_0x0249:
            java.lang.String r0 = "webview network:不能缓存的文件类型"
            r8.a(r9, r11, r14, r0)
            return r12
        L_0x024f:
            java.lang.String r15 = "webviewError:"
            if (r10 != r2) goto L_0x028a
            com.huobi.webcache.g r0 = com.huobi.webcache.g.h()     // Catch:{ Exception -> 0x0267 }
            android.webkit.WebResourceResponse r0 = r0.b(r14)     // Catch:{ Exception -> 0x0267 }
            if (r0 == 0) goto L_0x0261
            r8.a(r9, r11, r14, r5)     // Catch:{ Exception -> 0x0267 }
            goto L_0x0266
        L_0x0261:
            java.lang.String r1 = "webviewError:缓存数据有问题"
            r8.a(r9, r11, r14, r1)     // Catch:{ Exception -> 0x0267 }
        L_0x0266:
            return r0
        L_0x0267:
            r0 = move-exception
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x026f
            r0.printStackTrace()
        L_0x026f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.a(r9, r11, r14, r0)
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x028a:
            if (r10 != 0) goto L_0x029d
            java.util.Map r1 = r19.getRequestHeaders()
            if (r1 == 0) goto L_0x029d
            java.util.Map r1 = r19.getRequestHeaders()
            java.lang.String r3 = "huobi_pro_cache"
            java.lang.String r6 = "1"
            r1.put(r3, r6)
        L_0x029d:
            boolean r1 = f20660m     // Catch:{ all -> 0x02ab }
            if (r1 == 0) goto L_0x02ab
            java.util.List<java.lang.String> r1 = f20664q     // Catch:{ all -> 0x02ab }
            r1.add(r14)     // Catch:{ all -> 0x02ab }
            int r1 = f20662o     // Catch:{ all -> 0x02ab }
            int r1 = r1 + r2
            f20662o = r1     // Catch:{ all -> 0x02ab }
        L_0x02ab:
            boolean r1 = r8.f20676j
            java.lang.String r7 = "缓存结果：缓存请求出错,返回空请求,url="
            java.lang.String r6 = "缓存结果：缓存请求出错,用系统连接重试,url="
            if (r1 == 0) goto L_0x0319
            com.huobi.webcache.g r0 = com.huobi.webcache.g.h()     // Catch:{ all -> 0x02c7 }
            java.util.Map r1 = r19.getRequestHeaders()     // Catch:{ all -> 0x02c7 }
            android.webkit.WebResourceResponse r0 = r0.q(r14, r1)     // Catch:{ all -> 0x02c7 }
            if (r0 != 0) goto L_0x02c3
            java.lang.String r5 = ""
        L_0x02c3:
            r8.a(r9, r11, r14, r5)     // Catch:{ all -> 0x02c7 }
            return r0
        L_0x02c7:
            r0 = move-exception
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x02cf
            r0.printStackTrace()
        L_0x02cf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.a(r9, r11, r14, r0)
            if (r10 != 0) goto L_0x0302
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x02fd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r13, r0)
        L_0x02fd:
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x0302:
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x0318
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r13, r0)
        L_0x0318:
            return r12
        L_0x0319:
            com.huobi.webcache.g r1 = com.huobi.webcache.g.h()
            java.lang.String r3 = "utf-8"
            pu.a$e r16 = r1.f(r14, r4, r3)
            if (r16 != 0) goto L_0x03bc
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x033d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：现在没有缓存,开始缓存 url="
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1)
        L_0x033d:
            com.huobi.webcache.g r1 = com.huobi.webcache.g.h()     // Catch:{ IOException -> 0x0368 }
            java.util.Map r2 = r19.getRequestHeaders()     // Catch:{ IOException -> 0x0368 }
            r1.o(r14, r4, r3, r2)     // Catch:{ IOException -> 0x0368 }
            com.huobi.webcache.g r1 = com.huobi.webcache.g.h()     // Catch:{ IOException -> 0x0368 }
            pu.a$e r16 = r1.f(r14, r4, r3)     // Catch:{ IOException -> 0x0368 }
            r8.a(r9, r11, r14, r5)     // Catch:{ IOException -> 0x0368 }
            r1 = r17
            r2 = r18
            r3 = r14
            r5 = r0
            r12 = r6
            r6 = r16
            r16 = r12
            r12 = r7
            r7 = r21
            android.webkit.WebResourceResponse r0 = r1.e(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0366 }
            return r0
        L_0x0366:
            r0 = move-exception
            goto L_0x036c
        L_0x0368:
            r0 = move-exception
            r16 = r6
            r12 = r7
        L_0x036c:
            r0.printStackTrace()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.a(r9, r11, r14, r0)
            if (r10 != 0) goto L_0x03a2
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x039d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r13, r0)
        L_0x039d:
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x03a2:
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x03ba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r16
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r13, r0)
        L_0x03ba:
            r1 = 0
            return r1
        L_0x03bc:
            boolean r1 = f20660m     // Catch:{ all -> 0x03ca }
            if (r1 == 0) goto L_0x03ca
            java.util.List<java.lang.String> r1 = f20665r     // Catch:{ all -> 0x03ca }
            r1.add(r14)     // Catch:{ all -> 0x03ca }
            int r1 = f20663p     // Catch:{ all -> 0x03ca }
            int r1 = r1 + r2
            f20663p = r1     // Catch:{ all -> 0x03ca }
        L_0x03ca:
            r1 = r17
            r2 = r18
            r3 = r14
            r5 = r0
            r6 = r16
            r7 = r21
            android.webkit.WebResourceResponse r0 = r1.e(r2, r3, r4, r5, r6, r7)
            return r0
        L_0x03d9:
            if (r10 != 0) goto L_0x03e3
            r8.a(r9, r11, r14, r4)
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x03e3:
            boolean r0 = r8.f20674h
            if (r0 == 0) goto L_0x03fb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "缓存结果：POST请求,走,系统默认请求,不缓存 url="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r13, r0)
        L_0x03fb:
            java.lang.String r0 = "webview network:POST请求"
            r8.a(r9, r11, r14, r0)
            r1 = 0
            return r1
        L_0x0402:
            boolean r1 = r8.f20674h
            if (r1 == 0) goto L_0x041a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存结果：非法url,走系统默认请求,不处理 url="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1)
        L_0x041a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "webview network:IllegalArgument:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r8.a(r9, r11, r0, r1)
            if (r10 != 0) goto L_0x0435
            android.webkit.WebResourceResponse r0 = com.huobi.webcache.H5HttpUtils.b()
            return r0
        L_0x0435:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.WebCacheInterecptRequest.s(android.webkit.WebView, android.webkit.WebResourceRequest, int, com.huobi.webcache.LoadFinishCallBack):android.webkit.WebResourceResponse");
    }
}
