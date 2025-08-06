package com.huobi.home.engine;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.huobi.home.data.HomepageConfig;
import com.huobi.home.data.TransferAmountInfo;
import com.huobi.home.ui.HomeModuleBaseView;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.x;
import rj.b;
import tg.r;

@SuppressLint({"StaticFieldLeak"})
public final class HomeEngineCore {

    /* renamed from: a  reason: collision with root package name */
    public static final HomeEngineCore f72473a = new HomeEngineCore();

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, HomeModuleBaseView> f72474b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, HomeModuleBaseView> f72475c = new ConcurrentHashMap<>();

    public final void a(b bVar, ViewGroup viewGroup, HomeModuleBaseView homeModuleBaseView) {
        if (viewGroup != null && homeModuleBaseView != null) {
            ViewParent parent = homeModuleBaseView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(homeModuleBaseView);
            }
            viewGroup.addView(homeModuleBaseView);
            HomeModuleBaseView.g(homeModuleBaseView, (List) null, false, new HomeEngineCore$addView$1(homeModuleBaseView, bVar), 3, (Object) null);
        }
    }

    public final boolean b(HomepageConfig.Module module, TransferAmountInfo transferAmountInfo) {
        List<Long> list;
        if (!StringsKt__StringsJVMKt.x(module != null ? module.isNeedLogin : null, "1", false, 2, (Object) null) || r.x().F0()) {
            if (StringsKt__StringsJVMKt.x(module != null ? module.isNeedAssets : null, "1", false, 2, (Object) null)) {
                if (!StringsKt__StringsJVMKt.x(transferAmountInfo != null ? transferAmountInfo.f72470a : null, "1", false, 2, (Object) null)) {
                    Log.d("Home", "checkModule isNeedAssets return");
                    return true;
                }
            }
            if (!(module == null || (list = module.version) == null || list.size() != 2)) {
                Long l11 = module.version.get(0);
                Long l12 = module.version.get(1);
                Log.d("Home", "checkModule version minVersion" + l11 + " maxVersion" + l12);
                if (((l11 == null || l11.longValue() != -1) && l11.longValue() > 105400) || ((l12 == null || l12.longValue() != -1) && l12.longValue() < 105400)) {
                    Log.d("Home", "checkModule version return");
                    return true;
                }
            }
            return false;
        }
        Log.d("Home", "checkModule isNeedLogin return");
        return true;
    }

    public final HomeModuleBaseView c(b bVar, FragmentActivity fragmentActivity, String str, HomepageConfig.Module module) {
        View view;
        HomepageConfig.Params params;
        HomepageConfig.Params params2;
        if (str.equals("ranking")) {
            c.f72480a.g(bVar);
        }
        String str2 = null;
        if (x.b(module != null ? module.type : null, "engine")) {
            if (bVar != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((module == null || (params2 = module.params) == null) ? null : params2.enterView);
                sb2.append(".xml");
                view = bVar.E(sb2.toString(), fragmentActivity, false, (JSONObject) null);
            } else {
                view = null;
            }
            if (bVar != null) {
                bVar.I(str + ".start()");
            }
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        HomeModuleBaseView homeModuleBaseView = new HomeModuleBaseView(fragmentActivity);
        if (!(module == null || (params = module.params) == null)) {
            str2 = params.yuguImage;
        }
        homeModuleBaseView.setAnimationRes(str2);
        homeModuleBaseView.a(str, view);
        homeModuleBaseView.h();
        return homeModuleBaseView;
    }

    public final synchronized void d(b bVar, FragmentActivity fragmentActivity) {
        for (Map.Entry next : f72474b.entrySet()) {
            if (bVar != null) {
                bVar.I(((String) next.getKey()) + ".start()");
            }
        }
        for (Map.Entry next2 : f72475c.entrySet()) {
            if (bVar != null) {
                bVar.I(((String) next2.getKey()) + ".start()");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        r1 = r12.structure;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void e(rj.b r8, androidx.fragment.app.FragmentActivity r9, android.view.ViewGroup r10, android.view.ViewGroup r11, com.huobi.home.data.HomepageConfig r12, com.huobi.home.data.TransferAmountInfo r13) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r0 = f72474b     // Catch:{ all -> 0x01f2 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x01f2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01f2 }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x01f2 }
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x01f2 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x01f2 }
            if (r10 == 0) goto L_0x0022
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x01f2 }
            r10.removeView(r2)     // Catch:{ all -> 0x01f2 }
        L_0x0022:
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r2 = (com.huobi.home.ui.HomeModuleBaseView) r2     // Catch:{ all -> 0x01f2 }
            android.view.ViewParent r2 = r2.getParent()     // Catch:{ all -> 0x01f2 }
            if (r2 == 0) goto L_0x000b
            boolean r3 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x01f2 }
            if (r3 == 0) goto L_0x000b
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x01f2 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x01f2 }
            r2.removeView(r1)     // Catch:{ all -> 0x01f2 }
            goto L_0x000b
        L_0x003e:
            r0 = 0
            if (r12 == 0) goto L_0x0048
            com.huobi.home.data.HomepageConfig$Structure r1 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r1 == 0) goto L_0x0048
            java.util.List<java.lang.String> r1 = r1.navigation     // Catch:{ all -> 0x01f2 }
            goto L_0x0049
        L_0x0048:
            r1 = r0
        L_0x0049:
            if (r1 == 0) goto L_0x00f9
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x01f2 }
            r1.<init>()     // Catch:{ all -> 0x01f2 }
            if (r12 == 0) goto L_0x0055
            com.huobi.home.data.HomepageConfig$Structure r2 = r12.structure     // Catch:{ all -> 0x01f2 }
            goto L_0x0056
        L_0x0055:
            r2 = r0
        L_0x0056:
            if (r2 != 0) goto L_0x0059
            goto L_0x006d
        L_0x0059:
            if (r12 == 0) goto L_0x0062
            com.huobi.home.data.HomepageConfig$Structure r3 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r3 == 0) goto L_0x0062
            java.util.List<java.lang.String> r3 = r3.navigation     // Catch:{ all -> 0x01f2 }
            goto L_0x0063
        L_0x0062:
            r3 = r0
        L_0x0063:
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.S(r3)     // Catch:{ all -> 0x01f2 }
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r3)     // Catch:{ all -> 0x01f2 }
            r2.navigation = r3     // Catch:{ all -> 0x01f2 }
        L_0x006d:
            if (r12 == 0) goto L_0x0076
            com.huobi.home.data.HomepageConfig$Structure r2 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r2 == 0) goto L_0x0076
            java.util.List<java.lang.String> r2 = r2.navigation     // Catch:{ all -> 0x01f2 }
            goto L_0x0077
        L_0x0076:
            r2 = r0
        L_0x0077:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x01f2 }
        L_0x007b:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x01f2 }
            if (r3 == 0) goto L_0x00f7
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x01f2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x01f2 }
            java.lang.String r4 = "Home"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r5.<init>()     // Catch:{ all -> 0x01f2 }
            java.lang.String r6 = "render "
            r5.append(r6)     // Catch:{ all -> 0x01f2 }
            r5.append(r3)     // Catch:{ all -> 0x01f2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01f2 }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x01f2 }
            if (r12 == 0) goto L_0x00aa
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.data.HomepageConfig$Module> r4 = r12.modules     // Catch:{ all -> 0x01f2 }
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x01f2 }
            com.huobi.home.data.HomepageConfig$Module r4 = (com.huobi.home.data.HomepageConfig.Module) r4     // Catch:{ all -> 0x01f2 }
            goto L_0x00ab
        L_0x00aa:
            r4 = r0
        L_0x00ab:
            boolean r5 = r7.b(r4, r13)     // Catch:{ all -> 0x01f2 }
            if (r5 != 0) goto L_0x007b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r5 = f72474b     // Catch:{ all -> 0x01f2 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x01f2 }
            if (r5 == 0) goto L_0x00e4
            if (r8 == 0) goto L_0x00cf
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r4.<init>()     // Catch:{ all -> 0x01f2 }
            r4.append(r3)     // Catch:{ all -> 0x01f2 }
            java.lang.String r5 = ".start()"
            r4.append(r5)     // Catch:{ all -> 0x01f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01f2 }
            r8.I(r4)     // Catch:{ all -> 0x01f2 }
        L_0x00cf:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r4 = f72474b     // Catch:{ all -> 0x01f2 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r4 = (com.huobi.home.ui.HomeModuleBaseView) r4     // Catch:{ all -> 0x01f2 }
            r7.a(r8, r10, r4)     // Catch:{ all -> 0x01f2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r4 = f72474b     // Catch:{ all -> 0x01f2 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x01f2 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01f2 }
            goto L_0x007b
        L_0x00e4:
            if (r9 == 0) goto L_0x00ed
            com.huobi.home.engine.HomeEngineCore r5 = f72473a     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r4 = r5.c(r8, r9, r3, r4)     // Catch:{ all -> 0x01f2 }
            goto L_0x00ee
        L_0x00ed:
            r4 = r0
        L_0x00ee:
            if (r4 == 0) goto L_0x007b
            r7.a(r8, r10, r4)     // Catch:{ all -> 0x01f2 }
            r1.put(r3, r4)     // Catch:{ all -> 0x01f2 }
            goto L_0x007b
        L_0x00f7:
            f72474b = r1     // Catch:{ all -> 0x01f2 }
        L_0x00f9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r10 = f72475c     // Catch:{ all -> 0x01f2 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x01f2 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01f2 }
        L_0x0103:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x01f2 }
            if (r1 == 0) goto L_0x0136
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x01f2 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x01f2 }
            if (r11 == 0) goto L_0x011a
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x01f2 }
            r11.removeView(r2)     // Catch:{ all -> 0x01f2 }
        L_0x011a:
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r2 = (com.huobi.home.ui.HomeModuleBaseView) r2     // Catch:{ all -> 0x01f2 }
            android.view.ViewParent r2 = r2.getParent()     // Catch:{ all -> 0x01f2 }
            if (r2 == 0) goto L_0x0103
            boolean r3 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x01f2 }
            if (r3 == 0) goto L_0x0103
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x01f2 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x01f2 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x01f2 }
            r2.removeView(r1)     // Catch:{ all -> 0x01f2 }
            goto L_0x0103
        L_0x0136:
            if (r12 == 0) goto L_0x013f
            com.huobi.home.data.HomepageConfig$Structure r10 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r10 == 0) goto L_0x013f
            java.util.List<java.lang.String> r10 = r10.fluent     // Catch:{ all -> 0x01f2 }
            goto L_0x0140
        L_0x013f:
            r10 = r0
        L_0x0140:
            if (r10 == 0) goto L_0x01f0
            java.util.concurrent.ConcurrentHashMap r10 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x01f2 }
            r10.<init>()     // Catch:{ all -> 0x01f2 }
            if (r12 == 0) goto L_0x014c
            com.huobi.home.data.HomepageConfig$Structure r1 = r12.structure     // Catch:{ all -> 0x01f2 }
            goto L_0x014d
        L_0x014c:
            r1 = r0
        L_0x014d:
            if (r1 != 0) goto L_0x0150
            goto L_0x0164
        L_0x0150:
            if (r12 == 0) goto L_0x0159
            com.huobi.home.data.HomepageConfig$Structure r2 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r2 == 0) goto L_0x0159
            java.util.List<java.lang.String> r2 = r2.fluent     // Catch:{ all -> 0x01f2 }
            goto L_0x015a
        L_0x0159:
            r2 = r0
        L_0x015a:
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.S(r2)     // Catch:{ all -> 0x01f2 }
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r2)     // Catch:{ all -> 0x01f2 }
            r1.fluent = r2     // Catch:{ all -> 0x01f2 }
        L_0x0164:
            if (r12 == 0) goto L_0x016d
            com.huobi.home.data.HomepageConfig$Structure r1 = r12.structure     // Catch:{ all -> 0x01f2 }
            if (r1 == 0) goto L_0x016d
            java.util.List<java.lang.String> r1 = r1.fluent     // Catch:{ all -> 0x01f2 }
            goto L_0x016e
        L_0x016d:
            r1 = r0
        L_0x016e:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x01f2 }
        L_0x0172:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x01f2 }
            if (r2 == 0) goto L_0x01ee
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x01f2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01f2 }
            java.lang.String r3 = "Home"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r4.<init>()     // Catch:{ all -> 0x01f2 }
            java.lang.String r5 = "render "
            r4.append(r5)     // Catch:{ all -> 0x01f2 }
            r4.append(r2)     // Catch:{ all -> 0x01f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01f2 }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x01f2 }
            if (r12 == 0) goto L_0x01a1
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.data.HomepageConfig$Module> r3 = r12.modules     // Catch:{ all -> 0x01f2 }
            if (r3 == 0) goto L_0x01a1
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x01f2 }
            com.huobi.home.data.HomepageConfig$Module r3 = (com.huobi.home.data.HomepageConfig.Module) r3     // Catch:{ all -> 0x01f2 }
            goto L_0x01a2
        L_0x01a1:
            r3 = r0
        L_0x01a2:
            boolean r4 = r7.b(r3, r13)     // Catch:{ all -> 0x01f2 }
            if (r4 != 0) goto L_0x0172
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r4 = f72475c     // Catch:{ all -> 0x01f2 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x01f2 }
            if (r4 == 0) goto L_0x01db
            if (r8 == 0) goto L_0x01c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r3.<init>()     // Catch:{ all -> 0x01f2 }
            r3.append(r2)     // Catch:{ all -> 0x01f2 }
            java.lang.String r4 = ".start()"
            r3.append(r4)     // Catch:{ all -> 0x01f2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01f2 }
            r8.I(r3)     // Catch:{ all -> 0x01f2 }
        L_0x01c6:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r3 = f72475c     // Catch:{ all -> 0x01f2 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r3 = (com.huobi.home.ui.HomeModuleBaseView) r3     // Catch:{ all -> 0x01f2 }
            r7.a(r8, r11, r3)     // Catch:{ all -> 0x01f2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.home.ui.HomeModuleBaseView> r3 = f72475c     // Catch:{ all -> 0x01f2 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x01f2 }
            r10.put(r2, r3)     // Catch:{ all -> 0x01f2 }
            goto L_0x0172
        L_0x01db:
            if (r9 == 0) goto L_0x01e4
            com.huobi.home.engine.HomeEngineCore r4 = f72473a     // Catch:{ all -> 0x01f2 }
            com.huobi.home.ui.HomeModuleBaseView r3 = r4.c(r8, r9, r2, r3)     // Catch:{ all -> 0x01f2 }
            goto L_0x01e5
        L_0x01e4:
            r3 = r0
        L_0x01e5:
            if (r3 == 0) goto L_0x0172
            r7.a(r8, r11, r3)     // Catch:{ all -> 0x01f2 }
            r10.put(r2, r3)     // Catch:{ all -> 0x01f2 }
            goto L_0x0172
        L_0x01ee:
            f72475c = r10     // Catch:{ all -> 0x01f2 }
        L_0x01f0:
            monitor-exit(r7)
            return
        L_0x01f2:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.HomeEngineCore.e(rj.b, androidx.fragment.app.FragmentActivity, android.view.ViewGroup, android.view.ViewGroup, com.huobi.home.data.HomepageConfig, com.huobi.home.data.TransferAmountInfo):void");
    }

    public final synchronized void f(String str, String str2) {
        HomeModuleBaseView homeModuleBaseView = f72475c.get(str2);
        Log.d("Home1", str + " -:- " + str2);
        if (!(homeModuleBaseView == null || str == null)) {
            int hashCode = str.hashCode();
            if (hashCode != 174257742) {
                if (hashCode != 216239514) {
                    if (hashCode == 724809599) {
                        if (str.equals("showLoading")) {
                            homeModuleBaseView.c();
                            homeModuleBaseView.h();
                        }
                    }
                } else if (str.equals("hideLoading")) {
                    homeModuleBaseView.j();
                    homeModuleBaseView.b();
                }
            } else if (str.equals("hideModule")) {
                homeModuleBaseView.d();
            }
        }
    }

    public final synchronized void g(b bVar, FragmentActivity fragmentActivity, ViewGroup viewGroup, ViewGroup viewGroup2, HomepageConfig homepageConfig, TransferAmountInfo transferAmountInfo) {
        ConcurrentHashMap<String, HomepageConfig.Module> concurrentHashMap;
        HomepageConfig.Structure structure;
        HomepageConfig.Structure structure2;
        HomepageConfig.Structure structure3;
        ConcurrentHashMap<String, HomepageConfig.Module> concurrentHashMap2;
        HomepageConfig.Structure structure4;
        HomepageConfig.Structure structure5;
        HomepageConfig.Structure structure6;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startRenderHome ");
        sb2.append(fragmentActivity == null);
        Log.d("Home", sb2.toString());
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (((homepageConfig == null || (structure6 = homepageConfig.structure) == null) ? null : structure6.navigation) != null) {
            HomepageConfig.Structure structure7 = homepageConfig != null ? homepageConfig.structure : null;
            if (structure7 != null) {
                structure7.navigation = CollectionsKt___CollectionsKt.I0(CollectionsKt___CollectionsKt.S((homepageConfig == null || (structure5 = homepageConfig.structure) == null) ? null : structure5.navigation));
            }
            for (String next : (homepageConfig == null || (structure4 = homepageConfig.structure) == null) ? null : structure4.navigation) {
                Log.d("Home", "render " + next);
                HomepageConfig.Module module = (homepageConfig == null || (concurrentHashMap2 = homepageConfig.modules) == null) ? null : concurrentHashMap2.get(next);
                if (!b(module, transferAmountInfo)) {
                    HomeModuleBaseView c11 = fragmentActivity != null ? f72473a.c(bVar, fragmentActivity, next, module) : null;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("navigation ");
                    sb3.append(next);
                    sb3.append(c11 == null);
                    Log.d("startRenderHome", sb3.toString());
                    if (c11 != null) {
                        a(bVar, viewGroup2, c11);
                        f72474b.put(next, c11);
                    }
                }
            }
        }
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        if (((homepageConfig == null || (structure3 = homepageConfig.structure) == null) ? null : structure3.fluent) != null) {
            HomepageConfig.Structure structure8 = homepageConfig != null ? homepageConfig.structure : null;
            if (structure8 != null) {
                structure8.fluent = CollectionsKt___CollectionsKt.I0(CollectionsKt___CollectionsKt.S((homepageConfig == null || (structure2 = homepageConfig.structure) == null) ? null : structure2.fluent));
            }
            for (String next2 : (homepageConfig == null || (structure = homepageConfig.structure) == null) ? null : structure.fluent) {
                Log.d("Home", "render " + next2);
                HomepageConfig.Module module2 = (homepageConfig == null || (concurrentHashMap = homepageConfig.modules) == null) ? null : concurrentHashMap.get(next2);
                if (!b(module2, transferAmountInfo)) {
                    HomeModuleBaseView c12 = fragmentActivity != null ? f72473a.c(bVar, fragmentActivity, next2, module2) : null;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("fluent ");
                    sb4.append(next2);
                    sb4.append(c12 == null);
                    Log.d("startRenderHome", sb4.toString());
                    if (c12 != null) {
                        a(bVar, viewGroup2, c12);
                        f72475c.put(next2, c12);
                    }
                }
            }
        }
    }
}
