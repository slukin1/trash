package com.hbg.lib.imsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.imsdk.HbgTopView;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogItem;
import com.hbg.lib.network.hbg.core.bean.PushUserSig;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.huobi.im.imsignal.IMSdk;
import com.hbg.module.huobi.im.imsignal.ImSdkModuleConfig;
import com.huobi.view.keyboard.CustomBoardView;
import com.twitter.sdk.android.core.identity.AuthHandler;
import com.xiaomi.mipush.sdk.Constants;
import e7.m;
import e7.n;
import e7.o;
import e7.p;
import e7.q;
import e7.r;
import e7.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class HbgDialogManager {

    /* renamed from: l  reason: collision with root package name */
    public static final String f69118l = "HbgDialogManager";

    /* renamed from: m  reason: collision with root package name */
    public static HbgImDialogPageType f69119m = HbgImDialogPageType.INDEX;

    /* renamed from: n  reason: collision with root package name */
    public static volatile HbgDialogManager f69120n;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f69121o;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f69122p;

    /* renamed from: a  reason: collision with root package name */
    public boolean f69123a;

    /* renamed from: b  reason: collision with root package name */
    public e7.h f69124b;

    /* renamed from: c  reason: collision with root package name */
    public Subscriber<Long> f69125c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69126d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69127e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, HbgWebDialogView> f69128f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f69129g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public HbgTopView f69130h;

    /* renamed from: i  reason: collision with root package name */
    public BottomBarView f69131i;

    /* renamed from: j  reason: collision with root package name */
    public String f69132j;

    /* renamed from: k  reason: collision with root package name */
    public i6.a f69133k = new i6.a("HBgDialog", new e7.l(this));

    public class a extends RequestCallback1<HbgIntCodeResponse<List<HbgDialogConfigInfo>>> {
        public a() {
        }

        /* renamed from: a */
        public void onRequestSuccess(HbgIntCodeResponse<List<HbgDialogConfigInfo>> hbgIntCodeResponse) {
            long ts2 = hbgIntCodeResponse.getTs();
            if (hbgIntCodeResponse.isSuccess()) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                List data = hbgIntCodeResponse.getData();
                String json = new Gson().toJson((Object) data);
                i6.k.o("GlobalFloatData_NET", json);
                String l11 = HbgDialogManager.f69118l;
                i6.d.c(l11, "receiveMessage_NET:" + json);
                bundle.putSerializable("data", (Serializable) data);
                bundle.putLong(AuthHandler.EXTRA_TOKEN_SECRET, ts2);
                message.what = 1;
                message.setData(bundle);
                HbgDialogManager.this.f69133k.sendMessage(message);
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.e(HbgDialogManager.f69118l, th2.getMessage());
            i6.k.f("GlobalFloatData_NET_ERROR", th2.getMessage());
        }
    }

    public class b extends RequestCallback1<HbgIntCodeResponse> {
        public b() {
        }

        /* renamed from: a */
        public void onRequestSuccess(HbgIntCodeResponse hbgIntCodeResponse) {
            if (hbgIntCodeResponse.getCode() == 200) {
                String l11 = HbgDialogManager.f69118l;
                i6.d.c(l11, "requestHbgReport success" + hbgIntCodeResponse.getCode());
                return;
            }
            String l12 = HbgDialogManager.f69118l;
            i6.d.c(l12, "requestHbgReport fail:" + hbgIntCodeResponse.getCode());
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            String l11 = HbgDialogManager.f69118l;
            i6.d.c(l11, "requestHbgReport fail:" + th2.getMessage());
        }
    }

    public class c extends BaseSubscriber<Long> {
        public c() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            Message message = new Message();
            message.obj = l11;
            message.what = 3;
            HbgDialogManager.this.f69133k.sendMessage(message);
        }
    }

    public class d extends TypeToken<List<HbgDialogConfigInfo>> {
        public d() {
        }
    }

    public class e implements ImSdkModuleConfig.a {
        public e() {
        }

        public void b(WebView webView) {
            if (HbgDialogManager.this.f69124b != null) {
                HbgDialogManager.this.f69124b.b(webView);
            }
        }
    }

    public class f implements od.a {
        public f() {
        }

        public void a() {
            boolean unused = HbgDialogManager.this.f69127e = false;
        }

        public void b() {
            HbgDialogManager.this.c0();
        }

        public void onUserSigExpired() {
            i6.d.c(HbgDialogManager.f69118l, "-->onUserSigExpired-->onUserSigExpired");
            HbgDialogManager.this.c0();
        }
    }

    public class g extends RequestCallback1<PushUserSig> {
        public g() {
        }

        /* renamed from: a */
        public void onRequestSuccess(PushUserSig pushUserSig) {
            HbgDialogManager.this.O(pushUserSig);
            String l11 = HbgDialogManager.f69118l;
            i6.d.c(l11, "requestIMUserSig Success:" + pushUserSig.getTencentUserId());
            String unused = HbgDialogManager.this.f69132j = pushUserSig.getTencentUserId();
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            boolean unused = HbgDialogManager.this.f69127e = false;
        }
    }

    public class h implements od.b {
        public h() {
        }

        public void a() {
            i6.d.c(HbgDialogManager.f69118l, "loginIMSdk fail");
            boolean unused = HbgDialogManager.this.f69127e = false;
        }

        public void b() {
            boolean unused = HbgDialogManager.this.f69126d = true;
            boolean unused2 = HbgDialogManager.this.f69127e = false;
            i6.d.c(HbgDialogManager.f69118l, "loginIMSdk Success");
        }
    }

    public class i implements e7.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HbgDialogConfigInfo f69142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HbgWebDialogView f69143b;

        public i(HbgDialogConfigInfo hbgDialogConfigInfo, HbgWebDialogView hbgWebDialogView) {
            this.f69142a = hbgDialogConfigInfo;
            this.f69143b = hbgWebDialogView;
        }

        public void a(String str, long j11, int i11) {
            String l11 = HbgDialogManager.f69118l;
            i6.d.c(l11, "-->onClose:" + str);
            if (i11 != 0) {
                s.a(j11);
                HbgDialogManager.this.W(j11);
                if (!TextUtils.isEmpty(str)) {
                    BaseModuleConfig.a().k0(str);
                    BaseModuleConfig.a().w("Ads_feature_click", HbgDialogManager.this.C(this.f69142a));
                    HbgDialogManager.this.b0(1, j11);
                } else {
                    BaseModuleConfig.a().w("Ads_feature_close", HbgDialogManager.this.C(this.f69142a));
                    HbgDialogManager.this.b0(2, j11);
                }
            }
            String l12 = HbgDialogManager.f69118l;
            i6.k.o(l12, "GlobalFloatData_WEB_CLOSE :  url:" + str + " dialogId:" + j11 + " clickedH5Close:" + i11 + " info:" + new Gson().toJson((Object) this.f69142a));
            HbgDialogManager.this.v(this.f69142a.positionType);
            HbgDialogManager.this.W(j11);
        }

        public void onDismiss() {
            HbgDialogManager.this.o0(this.f69142a);
        }

        public void onShow() {
            this.f69143b.setVisibility(0);
            String l11 = HbgDialogManager.f69118l;
            i6.d.c(l11, "showHbgDialog_H5 显示隐藏的全域弹层，ID：" + this.f69142a.dialogId);
        }
    }

    public class j implements HbgTopView.c {
        public j() {
        }

        public void a(long j11) {
            s.a(j11);
            HbgDialogManager.this.W(j11);
        }

        public void onDismiss() {
            i6.d.c(HbgDialogManager.f69118l, "===> onDismiss 调用 removeTopView() ");
            HbgDialogManager.this.f69129g.remove(4);
            g7.a.c(HbgDialogManager.this.f69130h);
            HbgTopView unused = HbgDialogManager.this.f69130h = null;
        }
    }

    public class k implements e7.e {
        public k() {
        }

        public void a(String str, long j11, int i11) {
            s.a(j11);
        }

        public void onDismiss() {
            HbgDialogManager.this.X();
        }

        public void onShow() {
        }
    }

    public class l implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f69147b;

        public l(Activity activity) {
            this.f69147b = activity;
        }

        public void run() {
            ((FrameLayout) this.f69147b.findViewById(16908290)).removeView(HbgDialogManager.this.f69131i);
        }
    }

    public static HbgDialogManager A() {
        if (f69120n == null) {
            synchronized (HbgDialogManager.class) {
                f69120n = new HbgDialogManager();
            }
        }
        return f69120n;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(String str, String str2) {
        i6.k.o("GlobalFloatData_IM", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        String str3 = f69118l;
        i6.d.c(str3, "RECEIVE_MSG:" + str2);
        Message message = new Message();
        message.obj = str2;
        message.what = 2;
        this.f69133k.sendMessage(message);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            Bundle data = message.getData();
            List list = (List) data.getSerializable("data");
            s.j(list, data.getLong(AuthHandler.EXTRA_TOKEN_SECRET));
            T(list);
            m0();
        } else if (i11 == 2) {
            String str = (String) message.obj;
            i6.d.b("receiveMessage_PUSH: text:" + str);
            try {
                List list2 = (List) new Gson().fromJson(str, new d().getType());
                if (list2 != null && !list2.isEmpty()) {
                    T(list2);
                    s.i(list2);
                    Z(list2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else if (i11 == 3) {
            S(((Long) message.obj).longValue());
        }
    }

    public static /* synthetic */ int I(HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogConfigInfo hbgDialogConfigInfo2) {
        if (hbgDialogConfigInfo.localShow) {
            return 1;
        }
        if (hbgDialogConfigInfo2.localShow) {
            return -1;
        }
        return hbgDialogConfigInfo2.showLevel - hbgDialogConfigInfo.showLevel;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K() {
        v(0);
        v(3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        v(0);
        v(3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        int i11 = hbgDialogConfigInfo.positionType;
        if (i11 == 0 || i11 == 3 || i11 == 1) {
            String str = f69118l;
            i6.d.c(str, "showDialogAndUpdateNumber:CENTER||SIDE:" + hbgDialogConfigInfo.dialogId + Constants.ACCEPT_TIME_SEPARATOR_SP + hbgDialogConfigInfo.pageIds);
            l0(hbgDialogConfigInfo, hbgDialogItem);
        } else if (i11 == 4) {
            String str2 = f69118l;
            i6.d.c(str2, "showDialogAndUpdateNumber:TOP:" + hbgDialogConfigInfo.dialogId + Constants.ACCEPT_TIME_SEPARATOR_SP + hbgDialogConfigInfo.pageIds);
            k0((FragmentActivity) e7.i.h().f(), hbgDialogConfigInfo, hbgDialogItem);
        } else if (i11 == 2) {
            String str3 = f69118l;
            i6.d.c(str3, "showDialogAndUpdateNumber:BOTTOM:" + hbgDialogConfigInfo.dialogId + Constants.ACCEPT_TIME_SEPARATOR_SP + hbgDialogConfigInfo.pageIds);
            f0((FragmentActivity) e7.i.h().f(), hbgDialogConfigInfo, hbgDialogItem);
        } else {
            String str4 = f69118l;
            i6.d.c(str4, "showDialogAndUpdateNumber: else " + hbgDialogConfigInfo.positionType);
        }
    }

    public static void d0(boolean z11) {
        if (z11) {
            A().v(0);
            A().v(3);
        }
        i6.d.c("test", "arc");
        f69122p = z11;
    }

    public String B() {
        return this.f69132j;
    }

    public final HashMap C(HbgDialogConfigInfo hbgDialogConfigInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
        hashMap.put("popup_name", hbgDialogConfigInfo.remark);
        hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
        hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
        hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
        hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
        return hashMap;
    }

    public String D() {
        return y();
    }

    public void E(e7.h hVar) {
        this.f69124b = hVar;
        boolean l11 = SP.l("SP_KEY_IM_DIALOG_APP_START", true);
        this.f69123a = l11;
        if (l11) {
            SP.y("SP_KEY_IM_DIALOG_APP_START", false);
        }
        if (hVar != null) {
            try {
                BottomBarView bottomBarView = this.f69131i;
                if (!(bottomBarView == null || bottomBarView.getParent() == null)) {
                    ((ViewGroup) this.f69131i.getParent()).removeView(this.f69131i);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.f69131i = new BottomBarView(hVar.getActivity());
            this.f69130h = new HbgTopView(hVar.getActivity());
            String str = f69118l;
            i6.d.c(str, "-->init-->userId:" + D());
            this.f69127e = true;
            a0();
            ImSdkModuleConfig.b(new e());
            IMSdk.c(hVar.getActivity().getApplication(), SystemUtils.c() ? 20000142 : 20000241, new f());
        }
    }

    public void F(Map<String, HbgDialogPageBean> map) {
        s.f(map);
    }

    public void O(PushUserSig pushUserSig) {
        if (pushUserSig != null) {
            IMSdk.d(pushUserSig.getTencentUserId(), pushUserSig.getUserSign(), pushUserSig.getName(), new h(), new r(this));
        }
    }

    public void P() {
        c0();
        a0();
        String uid = BaseModuleConfig.a().getUid();
        Log.d("56789>", "登陆成功 onLoginSuccess uid = " + uid);
    }

    public void Q() {
        c0();
        String uid = BaseModuleConfig.a().getUid();
        Log.d("56789>", "退出登陆 onLogoutSuccess uid = " + uid);
        IMSdk.b();
    }

    public void R() {
        if (!this.f69127e && !this.f69126d) {
            E(this.f69124b);
        } else if (this.f69126d) {
            this.f69127e = false;
            this.f69126d = false;
        }
    }

    public void S(long j11) {
        String str = f69118l;
        i6.d.c(str, Thread.currentThread() + "==========倒计时：" + j11);
        s.f70076f = s.f70076f + 1000;
        ArrayList<HbgDialogConfigInfo> arrayList = new ArrayList<>(s.f70073c);
        Collections.sort(arrayList, q.f54297b);
        for (HbgDialogConfigInfo hbgDialogConfigInfo : arrayList) {
            boolean d11 = s.d(hbgDialogConfigInfo, s.f70076f);
            String str2 = f69118l;
            i6.d.c(str2, "needShow : " + d11);
            if (d11) {
                h0(hbgDialogConfigInfo, s.f70076f);
            }
        }
    }

    public final void T(List<HbgDialogConfigInfo> list) {
        List<HbgDialogItem> list2;
        if (this.f69124b != null && list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (HbgDialogConfigInfo next : list) {
                int i11 = next.positionType;
                if ((i11 == 0 || i11 == 1 || i11 == 3) && (list2 = next.dialogItem) != null && !list2.isEmpty()) {
                    for (HbgDialogItem hbgDialogItem : next.dialogItem) {
                        String k11 = this.f69124b.k(hbgDialogItem.url);
                        if (this.f69124b.c()) {
                            if (k11.contains("?")) {
                                k11 = k11 + "&beginner=1";
                            } else {
                                k11 = k11 + "?beginner=1";
                            }
                        }
                        hashSet.add(k11);
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                this.f69124b.e(hashSet);
            }
        }
    }

    public void U(List<String> list) {
        e7.i.h().j(list);
    }

    public void V(List<String> list) {
        e7.i.h().k(list);
    }

    public void W(long j11) {
        Iterator<HbgDialogConfigInfo> it2 = s.f70073c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HbgDialogConfigInfo next = it2.next();
            if (next.dialogId == j11) {
                s.f70073c.remove(next);
                break;
            }
        }
        Map<Long, HbgDialogConfigInfo> map = s.f70072b;
        HbgDialogConfigInfo hbgDialogConfigInfo = map.get(Long.valueOf(j11));
        if (hbgDialogConfigInfo != null) {
            s.f70075e.remove(Integer.valueOf(hbgDialogConfigInfo.positionType));
        }
        map.remove(Long.valueOf(j11));
    }

    public final void X() {
        Activity f11 = e7.i.h().f();
        if (this.f69131i != null && f11 != null) {
            f11.runOnUiThread(new l(f11));
            this.f69131i.setConfigInfo((HbgDialogConfigInfo) null);
            this.f69131i.setNativeDialogItem((HbgDialogItem) null);
            this.f69131i.setH5DialogItem((HbgDialogItem) null);
            s.f70075e.remove(2);
        }
    }

    public final void Y(int i11) {
        Activity f11 = e7.i.h().f();
        HbgWebDialogView hbgWebDialogView = this.f69128f.get(Integer.valueOf(i11));
        if (f11 != null) {
            WindowManager windowManager = (WindowManager) f11.getSystemService("window");
            if (hbgWebDialogView != null) {
                try {
                    if (!(hbgWebDialogView.getParent() == null || windowManager == null)) {
                        windowManager.removeView(hbgWebDialogView);
                    }
                } catch (Exception e11) {
                    i6.k.f("EXCEPTION", "remove center view:" + e11.toString());
                    return;
                }
            }
            s.f70075e.remove(Integer.valueOf(i11));
            this.f69129g.remove(i11);
        }
    }

    public final void Z(List<HbgDialogConfigInfo> list) {
        for (HbgDialogConfigInfo next : list) {
            if (next.positionType == 4) {
                HashMap hashMap = new HashMap();
                hashMap.put("popup_id", Long.valueOf(next.dialogId));
                hashMap.put("popup_name", next.remark);
                rd.q.a("Native_topbar_received", hashMap);
            }
        }
    }

    public void a0() {
        v7.b.a().l("0", y()).d(new a());
    }

    public void b0(int i11, long j11) {
        String y11 = y();
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.android.tpush.common.Constants.FLAG_DEVICE_ID, y11);
        hashMap.put("eventType", Integer.valueOf(i11));
        hashMap.put("advId", Long.valueOf(j11));
        String str = f69118l;
        i6.d.c(str, "requestHbgReport" + hashMap);
        v7.b.a().hbgReport(hashMap).d(new b());
    }

    public void c0() {
        v7.b.a().N(y()).d(new g());
    }

    public void e0(long j11) {
        s.l(j11);
    }

    public void f0(FragmentActivity fragmentActivity, HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        i6.i.b().f(new o(this, fragmentActivity, hbgDialogConfigInfo, hbgDialogItem));
    }

    /* renamed from: g0 */
    public final void J(FragmentActivity fragmentActivity, HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        String str = f69118l;
        i6.d.c(str, "-->showBottomDialog--> url:" + hbgDialogItem.url);
        if (hbgDialogConfigInfo.positionType == 2) {
            i6.d.c(str, "showBottomDialog:POSITION_TYPE_BOTTOM_BAR:" + hbgDialogItem.showText);
            this.f69131i.setConfigInfo(hbgDialogConfigInfo);
            this.f69131i.setNativeDialogItem(hbgDialogItem);
            this.f69131i.setNativeDialogId(hbgDialogConfigInfo.dialogId);
            this.f69131i.setCallback(new k());
        }
        FrameLayout frameLayout = (FrameLayout) fragmentActivity.findViewById(16908290);
        this.f69131i.setGravity(80);
        int i11 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = this.f69131i.getLocationY();
        int childCount = frameLayout.getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            } else if (frameLayout.getChildAt(i12) instanceof CustomBoardView) {
                i11 = i12;
                break;
            } else {
                i12++;
            }
        }
        if (!this.f69131i.isAttachedToWindow()) {
            if (this.f69131i.getParent() != null) {
                ((ViewGroup) this.f69131i.getParent()).removeView(this.f69131i);
            }
            frameLayout.addView(this.f69131i, i11, layoutParams);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
        hashMap.put("popup_name", hbgDialogConfigInfo.remark);
        hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
        hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
        hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
        hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
        BaseModuleConfig.a().w("Ads_feature_show", hashMap);
    }

    public final void h0(HbgDialogConfigInfo hbgDialogConfigInfo, long j11) {
        if (e7.i.h().f() != null && hbgDialogConfigInfo != null && z() != null) {
            int i11 = hbgDialogConfigInfo.positionType;
            if (i11 == 0 || i11 == 3) {
                ViewGroup viewGroup = (ViewGroup) e7.i.h().f().getWindow().getDecorView();
                int childCount = viewGroup.getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    if ("POPUP_WINDOW_VIEW_TAG".equals(viewGroup.getChildAt(i12).getTag())) {
                        i6.i.b().f(new m(this));
                        return;
                    }
                }
                if (i6.j.b()) {
                    i6.i.b().f(new n(this));
                    return;
                } else if (f69121o || f69122p) {
                    return;
                }
            }
            if (s.f70075e.containsKey(Integer.valueOf(hbgDialogConfigInfo.positionType))) {
                String str = f69118l;
                i6.d.c(str, "当前positionType已弹出 :currentShowLeverMap : " + s.f70075e);
                i6.d.c(str, "准备弹出：positionType :" + hbgDialogConfigInfo.positionType + ", dialogId：" + hbgDialogConfigInfo.dialogId);
                HbgDialogConfigInfo hbgDialogConfigInfo2 = s.f70075e.get(Integer.valueOf(hbgDialogConfigInfo.positionType));
                int i13 = -1;
                long j12 = -1;
                if (hbgDialogConfigInfo2 != null) {
                    i13 = hbgDialogConfigInfo2.showLevel;
                    j12 = hbgDialogConfigInfo2.dialogId;
                }
                if ((hbgDialogConfigInfo.showLevel > i13 || hbgDialogConfigInfo.localShow) && j12 != hbgDialogConfigInfo.dialogId) {
                    i6.d.c(str, "showLevel够大，能插队：info.showLevel:" + hbgDialogConfigInfo.showLevel + " currentShowLevel：" + i13);
                    v(hbgDialogConfigInfo.positionType);
                    i0(hbgDialogConfigInfo, j11);
                    return;
                }
                i6.d.c(str, "不满足弹出条件 : showLevel不够大，不能插队：info.showLevel:" + hbgDialogConfigInfo.showLevel + " currentShowLevel：" + i13);
                return;
            }
            String str2 = f69118l;
            i6.d.c(str2, "当前positionType未弹出 " + hbgDialogConfigInfo.positionType + Constants.ACCEPT_TIME_SEPARATOR_SP + hbgDialogConfigInfo.dialogId);
            i0(hbgDialogConfigInfo, j11);
        }
    }

    public final void i0(HbgDialogConfigInfo hbgDialogConfigInfo, long j11) {
        boolean z11;
        List<HbgDialogItem> list = hbgDialogConfigInfo.dialogItem;
        if (list != null && !list.isEmpty()) {
            for (HbgDialogItem next : list) {
                int i11 = hbgDialogConfigInfo.positionType;
                boolean z12 = true;
                if (i11 == 2 || i11 == 4) {
                    z11 = AppLanguageHelper.getInstance().getCurLanguageHeader().equalsIgnoreCase(next.language);
                } else {
                    z11 = true;
                }
                if (!hbgDialogConfigInfo.localShow) {
                    z12 = z11;
                    continue;
                }
                if (z12) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
                    hashMap.put("popup_name", hbgDialogConfigInfo.remark);
                    hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
                    hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
                    hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
                    hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
                    rd.q.a("Ads_feature_ready", hashMap);
                    if (hbgDialogConfigInfo.positionType == 4) {
                        s.k(hbgDialogConfigInfo, j11);
                    }
                    s.f70075e.put(Integer.valueOf(hbgDialogConfigInfo.positionType), hbgDialogConfigInfo);
                    i6.k.o(f69118l, "GlobalFloatData_SHOW : " + new Gson().toJson((Object) hbgDialogConfigInfo));
                    b0(0, hbgDialogConfigInfo.dialogId);
                    i6.i.b().f(new p(this, hbgDialogConfigInfo, next));
                    return;
                }
            }
        }
    }

    public void j0(long j11, int i11, String str, int i12, String str2, String str3, String str4, String str5, String str6) {
        HbgDialogConfigInfo hbgDialogConfigInfo = new HbgDialogConfigInfo();
        hbgDialogConfigInfo.dialogId = j11;
        hbgDialogConfigInfo.positionType = i11;
        hbgDialogConfigInfo.alphaValue = i12;
        hbgDialogConfigInfo.localShow = true;
        HbgDialogItem hbgDialogItem = new HbgDialogItem();
        hbgDialogItem.url = str;
        hbgDialogItem.icon = str2;
        hbgDialogItem.showText = str4;
        hbgDialogItem.showTitle = str3;
        hbgDialogItem.buttonText = str5;
        hbgDialogItem.showCloseButton = str6;
        ArrayList arrayList = new ArrayList();
        hbgDialogConfigInfo.dialogItem = arrayList;
        arrayList.add(hbgDialogItem);
        s.b(hbgDialogConfigInfo);
        S(0);
    }

    public void k0(FragmentActivity fragmentActivity, HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        String str = f69118l;
        i6.d.c(str, "显示顶部弹窗... url = " + hbgDialogItem.url + " info = " + hbgDialogConfigInfo.toString());
        if (this.f69130h == null) {
            this.f69130h = new HbgTopView(fragmentActivity);
        }
        this.f69130h.A(hbgDialogConfigInfo, hbgDialogItem);
        this.f69130h.setCallback(new j());
        this.f69130h.B();
        int indexOf = this.f69129g.indexOf(4);
        if (indexOf != -1) {
            this.f69129g.remove(indexOf);
        }
        this.f69129g.add(4);
    }

    public void l0(HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        Activity f11 = e7.i.h().f();
        String k11 = z().k(hbgDialogItem.url);
        e7.h hVar = this.f69124b;
        if (hVar != null && hVar.c()) {
            if (k11.contains("?")) {
                k11 = k11 + "&beginner=1";
            } else {
                k11 = k11 + "?beginner=1";
            }
        }
        i6.d.c(f69118l, "showWebView：url = " + k11);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", hbgDialogConfigInfo.remark);
            hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
            hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
            hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
            hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
            BaseModuleConfig.a().w("Ads_feature_show", hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        String str = f69118l;
        i6.d.c(str, "showWebView：positionType = " + hbgDialogConfigInfo.positionType);
        o0(hbgDialogConfigInfo);
        HbgWebDialogView hbgWebDialogView = new HbgWebDialogView(f11);
        this.f69128f.put(Integer.valueOf(hbgDialogConfigInfo.positionType), hbgWebDialogView);
        hbgWebDialogView.setUrl(k11);
        hbgWebDialogView.setDialogId(hbgDialogConfigInfo);
        hbgWebDialogView.setDialogTag("CenterHbImDialogFragment");
        hbgWebDialogView.setCallback(new i(hbgDialogConfigInfo, hbgWebDialogView));
        hbgWebDialogView.setDialogDispatchCallback(new e7.j(this, hbgDialogConfigInfo));
        hbgWebDialogView.setViewDispatchTouchCallback(e7.k.f54286a);
        hbgWebDialogView.setAlpha(hbgDialogConfigInfo.alphaValue);
        WindowManager windowManager = (WindowManager) f11.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (hbgDialogConfigInfo.positionType == 1) {
            layoutParams.gravity = 80;
            int a11 = i6.n.a(f11, 40.0f);
            hbgWebDialogView.setWebViewHeight(a11);
            layoutParams.height = a11 + A().z().d() + i6.n.a(f11, 4.0f);
        } else {
            layoutParams.gravity = 48;
        }
        layoutParams.format = 1;
        layoutParams.flags = 67108872;
        i6.d.c(str, "showWebView：initViewFinish");
        if (windowManager != null && !hbgWebDialogView.isAttachedToWindow()) {
            try {
                hbgWebDialogView.l();
                windowManager.addView(hbgWebDialogView, layoutParams);
                g7.a.a(hbgWebDialogView);
                int indexOf = this.f69129g.indexOf(Integer.valueOf(hbgDialogConfigInfo.positionType));
                if (indexOf != -1) {
                    this.f69129g.remove(indexOf);
                }
                this.f69129g.add(Integer.valueOf(hbgDialogConfigInfo.positionType));
                i6.d.c(str, "showWebView：finish");
            } catch (Exception e12) {
                i6.d.c(f69118l, "showWebView：error：" + e12.getMessage());
                i6.k.f("EXCEPTION", "add top view:" + e12.toString());
            }
        }
        String str2 = f69118l;
        i6.d.c(str2, "-->showWebView--> url:" + k11 + " tag:" + hbgWebDialogView.getTag());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showHbgDialog_H5 弹出全域弹层并隐藏，ID：");
        sb2.append(hbgDialogConfigInfo.dialogId);
        i6.d.c(str2, sb2.toString());
        hbgWebDialogView.setVisibility(8);
    }

    public void m0() {
        Subscriber<Long> subscriber = this.f69125c;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f69125c = new c();
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS).subscribe(this.f69125c);
    }

    public void n0() {
        Subscriber<Long> subscriber = this.f69125c;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void o0(HbgDialogConfigInfo hbgDialogConfigInfo) {
        if (!hbgDialogConfigInfo.localShow) {
            Activity f11 = e7.i.h().f();
            Fragment g11 = e7.i.h().g();
            HbgDialogConfigInfo hbgDialogConfigInfo2 = null;
            String str = null;
            for (Map.Entry next : s.f70074d.entrySet()) {
                try {
                    if (TextUtils.equals(((HbgDialogPageBean) next.getValue()).name, f11.getClass().getName()) || TextUtils.equals(((HbgDialogPageBean) next.getValue()).name, g11.getClass().getName())) {
                        str = (String) next.getKey();
                    }
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(str)) {
                List<HbgDialogConfigInfo> list = s.f70073c;
                Iterator<HbgDialogConfigInfo> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (hbgDialogConfigInfo.dialogId == it2.next().dialogId) {
                            hbgDialogConfigInfo2 = hbgDialogConfigInfo;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (hbgDialogConfigInfo2 != null) {
                    try {
                        if (hbgDialogConfigInfo2.interval > 0) {
                            for (HbgDialogConfigInfo next2 : list) {
                                if (next2.pageIds.contains(Integer.valueOf(Integer.parseInt(str))) && hbgDialogConfigInfo.positionType == next2.positionType) {
                                    next2.startTime = s.f70076f + hbgDialogConfigInfo2.interval;
                                }
                            }
                            i6.d.c(f69118l, "关闭弹层更新开始时间：服务器时间：" + s.f70076f + " 间隔：" + hbgDialogConfigInfo2.interval);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }

    public void u() {
        for (Map.Entry<Integer, HbgWebDialogView> key : this.f69128f.entrySet()) {
            Y(((Integer) key.getKey()).intValue());
        }
        this.f69128f.clear();
        X();
    }

    public void v(int i11) {
        if (i11 == 0 || i11 == 3 || i11 == 1) {
            Y(i11);
            this.f69128f.remove(Integer.valueOf(i11));
        } else if (i11 == 4) {
            i6.d.c(f69118l, "===> closeImPop 调用 removeTopView() ");
            HbgTopView hbgTopView = this.f69130h;
            if (hbgTopView != null) {
                hbgTopView.q();
            }
            this.f69129g.remove(i11);
        } else if (i11 == 2) {
            X();
        }
        s.f70075e.remove(Integer.valueOf(i11));
        String str = f69118l;
        i6.k.o(str, "GlobalFloatData_CLOSE :  positionType:" + i11);
    }

    public void w(long j11) {
        for (HbgDialogConfigInfo next : s.f70073c) {
            if (next.dialogId == j11) {
                v(next.positionType);
                return;
            }
        }
    }

    public Application.ActivityLifecycleCallbacks x() {
        return e7.i.h();
    }

    public String y() {
        return m0.a();
    }

    public e7.h z() {
        return this.f69124b;
    }
}
