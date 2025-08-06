package com.huobi.app.rms.wrapper;

import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import com.huobi.app.rms.bean.HBRMSResourceType;
import d10.p;
import d6.a;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import org.greenrobot.eventbus.ThreadMode;
import tg.r;

public final class HBDynamicPathFetchImpl implements a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a.C0737a> f42175a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f42176b = new HashMap<>();

    public a.C0737a a(String str, a.b bVar) {
        if ((bVar != null ? bVar.f68118a : null) == null || bVar.f68119b == null) {
            return null;
        }
        return e(bVar.f68118a, bVar.f68119b);
    }

    public String b(String str, String str2, String str3) {
        if (str2 != null && x.b(str, "edgeengine")) {
            return d(str2);
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        f(com.huobi.app.rms.bean.HBRMSResourceType.EdgeEngine, new com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getEdgeEnginePath$2(r5, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.f42176b.put(r5, r0.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        android.util.Log.e("HBRMS", "get edgeengine path error");
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r4.f42176b.put(r5, r0.element);
        r5 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        return (java.lang.String) r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r4.f42176b.put(r5, r0.element);
        r5 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0066, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d(java.lang.String r5) {
        /*
            r4 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            java.lang.String r1 = ""
            r0.element = r1
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r1)
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r4.f42176b     // Catch:{ all -> 0x006a }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0022
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r4.f42176b     // Catch:{ all -> 0x006a }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            return r5
        L_0x0022:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            com.huobi.app.rms.bean.HBRMSResourceType r1 = com.huobi.app.rms.bean.HBRMSResourceType.EdgeEngine     // Catch:{ all -> 0x003c }
            com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getEdgeEnginePath$2 r2 = new com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getEdgeEnginePath$2     // Catch:{ all -> 0x003c }
            r2.<init>(r5, r0)     // Catch:{ all -> 0x003c }
            r4.f(r1, r2)     // Catch:{ all -> 0x003c }
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r4.f42176b     // Catch:{ all -> 0x0039 }
            T r2 = r0.element     // Catch:{ all -> 0x0039 }
            r1.put(r5, r2)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r4)
            goto L_0x0052
        L_0x0039:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x003c:
            r1 = move-exception
            java.lang.String r2 = "HBRMS"
            java.lang.String r3 = "get edgeengine path error"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x005a }
            r1.printStackTrace()     // Catch:{ all -> 0x005a }
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r4.f42176b     // Catch:{ all -> 0x0057 }
            T r2 = r0.element     // Catch:{ all -> 0x0057 }
            r1.put(r5, r2)     // Catch:{ all -> 0x0057 }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0057 }
            goto L_0x0037
        L_0x0052:
            T r5 = r0.element
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L_0x0057:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x005a:
            r1 = move-exception
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r4.f42176b     // Catch:{ all -> 0x0067 }
            T r0 = r0.element     // Catch:{ all -> 0x0067 }
            r2.put(r5, r0)     // Catch:{ all -> 0x0067 }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0067 }
            monitor-exit(r4)
            throw r1
        L_0x0067:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x006a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl.d(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: d6.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: d6.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: d6.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: d6.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: d6.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        r3 = com.hbg.lib.common.utils.crypt.MD5Utils.a(r18);
        r15 = com.huobi.app.rms.bean.HBRMSResourceType.H5;
        r7 = r14;
        r16 = r14;
        r14 = r1;
        r1 = new com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getH5Path$2(r17, r3, r10, r13, r12, r7, r11);
        f(r15, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        if (r13.element == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if (android.text.TextUtils.isEmpty(r10.element) != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        r4 = r10.element;
        r3 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (r3 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r6 = r3.getPackageId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00aa, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        r3 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00af, code lost:
        if (r3 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        r7 = r3.getPackageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b7, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b8, code lost:
        r3 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        if (r3 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        r2 = r3.getMd5();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c2, code lost:
        r2 = new d6.a.C0737a(r4, "single", r6, r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c8, code lost:
        r9.f42175a.put(r0, r2);
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d6, code lost:
        if (android.text.TextUtils.isEmpty(r11.element) != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d8, code lost:
        r4 = r11.element;
        r1 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e5, code lost:
        if (r1 == null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e7, code lost:
        r6 = r1.getPackageId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ee, code lost:
        r1 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f2, code lost:
        if (r1 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f4, code lost:
        r7 = r1.getPackageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fb, code lost:
        r1 = r12.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ff, code lost:
        if (r1 == null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        r2 = r1.getMd5();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0105, code lost:
        r2 = new d6.a.C0737a(r4, "multi", r6, r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010b, code lost:
        r9.f42175a.put(r16.element, r2);
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0114, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0115, code lost:
        i6.k.d("HBRMSOffline", "isUrlPath:" + r13.element + " h5Path:" + r10.element + " h5ResPath:" + r11.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0145, code lost:
        return r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d6.a.C0737a e(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r9 = r17
            r0 = r18
            r1 = r19
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.lang.String r2 = ""
            r10.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.lang.String r2 = ""
            r11.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            java.lang.String r2 = "/index.html"
            boolean r2 = kotlin.jvm.internal.x.b(r1, r2)
            if (r2 == 0) goto L_0x003e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x003e:
            r14.element = r1
            monitor-enter(r17)
            java.util.HashMap<java.lang.String, d6.a$a> r1 = r9.f42175a     // Catch:{ all -> 0x0149 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0149 }
            if (r1 == 0) goto L_0x0053
            java.util.HashMap<java.lang.String, d6.a$a> r1 = r9.f42175a     // Catch:{ all -> 0x0149 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0149 }
            d6.a$a r0 = (d6.a.C0737a) r0     // Catch:{ all -> 0x0149 }
            monitor-exit(r17)
            return r0
        L_0x0053:
            java.util.HashMap<java.lang.String, d6.a$a> r1 = r9.f42175a     // Catch:{ all -> 0x0149 }
            T r2 = r14.element     // Catch:{ all -> 0x0149 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0149 }
            if (r1 == 0) goto L_0x0069
            java.util.HashMap<java.lang.String, d6.a$a> r0 = r9.f42175a     // Catch:{ all -> 0x0149 }
            T r1 = r14.element     // Catch:{ all -> 0x0149 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0149 }
            d6.a$a r0 = (d6.a.C0737a) r0     // Catch:{ all -> 0x0149 }
            monitor-exit(r17)
            return r0
        L_0x0069:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0149 }
            monitor-exit(r17)
            java.lang.String r3 = com.hbg.lib.common.utils.crypt.MD5Utils.a(r18)
            com.huobi.app.rms.bean.HBRMSResourceType r15 = com.huobi.app.rms.bean.HBRMSResourceType.H5
            com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getH5Path$2 r8 = new com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl$getH5Path$2
            r1 = r8
            r2 = r17
            r4 = r10
            r5 = r13
            r6 = r12
            r7 = r14
            r16 = r14
            r14 = r8
            r8 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.f(r15, r14)
            monitor-enter(r17)
            boolean r1 = r13.element     // Catch:{ all -> 0x0146 }
            r2 = 0
            if (r1 == 0) goto L_0x00ce
            T r1 = r10.element     // Catch:{ all -> 0x0146 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0146 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0146 }
            if (r1 != 0) goto L_0x00c8
            d6.a$a r1 = new d6.a$a     // Catch:{ all -> 0x0146 }
            T r3 = r10.element     // Catch:{ all -> 0x0146 }
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = "single"
            T r3 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r3 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r3     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x00aa
            java.lang.String r3 = r3.getPackageId()     // Catch:{ all -> 0x0146 }
            r6 = r3
            goto L_0x00ab
        L_0x00aa:
            r6 = r2
        L_0x00ab:
            T r3 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r3 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r3     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x00b7
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x0146 }
            r7 = r3
            goto L_0x00b8
        L_0x00b7:
            r7 = r2
        L_0x00b8:
            T r3 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r3 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r3     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x00c2
            java.lang.String r2 = r3.getMd5()     // Catch:{ all -> 0x0146 }
        L_0x00c2:
            r8 = r2
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0146 }
            r2 = r1
        L_0x00c8:
            java.util.HashMap<java.lang.String, d6.a$a> r1 = r9.f42175a     // Catch:{ all -> 0x0146 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0146 }
            goto L_0x0114
        L_0x00ce:
            T r0 = r11.element     // Catch:{ all -> 0x0146 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0146 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x010b
            d6.a$a r0 = new d6.a$a     // Catch:{ all -> 0x0146 }
            T r1 = r11.element     // Catch:{ all -> 0x0146 }
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = "multi"
            T r1 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r1 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r1     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x00ed
            java.lang.String r1 = r1.getPackageId()     // Catch:{ all -> 0x0146 }
            r6 = r1
            goto L_0x00ee
        L_0x00ed:
            r6 = r2
        L_0x00ee:
            T r1 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r1 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r1     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0146 }
            r7 = r1
            goto L_0x00fb
        L_0x00fa:
            r7 = r2
        L_0x00fb:
            T r1 = r12.element     // Catch:{ all -> 0x0146 }
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r1 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r1     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x0105
            java.lang.String r2 = r1.getMd5()     // Catch:{ all -> 0x0146 }
        L_0x0105:
            r8 = r2
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0146 }
            r2 = r0
        L_0x010b:
            java.util.HashMap<java.lang.String, d6.a$a> r0 = r9.f42175a     // Catch:{ all -> 0x0146 }
            r1 = r16
            T r1 = r1.element     // Catch:{ all -> 0x0146 }
            r0.put(r1, r2)     // Catch:{ all -> 0x0146 }
        L_0x0114:
            monitor-exit(r17)
            java.lang.String r0 = "HBRMSOffline"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "isUrlPath:"
            r1.append(r3)
            boolean r3 = r13.element
            r1.append(r3)
            java.lang.String r3 = " h5Path:"
            r1.append(r3)
            T r3 = r10.element
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r3 = " h5ResPath:"
            r1.append(r3)
            T r3 = r11.element
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            i6.k.d(r0, r1)
            return r2
        L_0x0146:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        L_0x0149:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl.e(java.lang.String, java.lang.String):d6.a$a");
    }

    public final void f(HBRMSResourceType hBRMSResourceType, p<? super Map<?, ?>, ? super HBRMSResourceInfoModel, Boolean> pVar) {
        String extra;
        for (HBRMSResourceInfoModel hBRMSResourceInfoModel : HBRMSManager.f42145q.a().K(hBRMSResourceType)) {
            if (hBRMSResourceInfoModel.isDownloadSuccess() && (extra = hBRMSResourceInfoModel.getExtra()) != null) {
                if (extra.length() > 0) {
                    try {
                        Map map = (Map) JSON.parseObject(extra, Map.class);
                        if (map != null && pVar.invoke(map, hBRMSResourceInfoModel).booleanValue()) {
                            return;
                        }
                    } catch (JSONException e11) {
                        Log.d("HBRMS", "当前 extra: " + extra + " 非JSON 数据");
                        e11.printStackTrace();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final boolean g(int i11) {
        if (!r.x().F0()) {
            return false;
        }
        String J = r.x().J();
        if (J.length() >= 2 && Integer.parseInt(J.substring(J.length() - 2)) <= i11) {
            return true;
        }
        return false;
    }

    public final void h() {
        synchronized (this) {
            this.f42176b.clear();
            this.f42175a.clear();
            Unit unit = Unit.f56620a;
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onClearCache(PathFetchEvent pathFetchEvent) {
        h();
    }
}
