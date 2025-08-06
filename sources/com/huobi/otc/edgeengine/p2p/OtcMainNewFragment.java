package com.huobi.otc.edgeengine.p2p;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSON;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lite.enums.TradeSide;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.otc.OtcModuleConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcAdvertLabelBean;
import com.huobi.otc.enums.OtcAdsFilterType;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.event.LinksJumpOtcEvent;
import com.huobi.otc.event.OnFilterEvent;
import com.huobi.otc.event.OnImageToTopEvent;
import com.huobi.otc.event.OnScrollToTopImageClickEvent;
import com.huobi.otc.event.OnSelectCoinEvent;
import com.huobi.otc.event.OtcActivityEvent;
import com.huobi.otc.event.OtcAdModeChangeEvent;
import com.huobi.otc.event.OtcAdPriceChangeEvent;
import com.huobi.otc.event.OtcFollowEvent;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.otc.ui.OtcSeaViewRoomActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.widget.OtcActiveView;
import com.huobi.otc.widget.OtcAdsFilterTopView;
import com.huobi.otc.widget.OtcCommonRectFIndicator;
import com.huochat.community.network.domain.DomainTool;
import com.huochat.community.util.JsonTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.b1;
import jp.v1;
import k20.h;
import op.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import pro.huobi.R;
import rx.Observable;
import tg.r;
import u6.g;
import vp.c1;

public class OtcMainNewFragment extends BaseFragment<OtcMainNewPresenter, g> implements a.C0880a, OtcAdsFilterTopView.d {
    public View A;
    public boolean B;
    public c1 C;

    /* renamed from: l  reason: collision with root package name */
    public ViewGroup f78343l;

    /* renamed from: m  reason: collision with root package name */
    public ViewGroup f78344m;

    /* renamed from: n  reason: collision with root package name */
    public ViewGroup f78345n;

    /* renamed from: o  reason: collision with root package name */
    public rj.b f78346o;

    /* renamed from: p  reason: collision with root package name */
    public View f78347p;

    /* renamed from: q  reason: collision with root package name */
    public View f78348q;

    /* renamed from: r  reason: collision with root package name */
    public View f78349r;

    /* renamed from: s  reason: collision with root package name */
    public View f78350s;

    /* renamed from: t  reason: collision with root package name */
    public final Paint f78351t = new Paint();

    /* renamed from: u  reason: collision with root package name */
    public FrameLayout f78352u;

    /* renamed from: v  reason: collision with root package name */
    public Bundle f78353v;

    /* renamed from: w  reason: collision with root package name */
    public Bundle f78354w;

    /* renamed from: x  reason: collision with root package name */
    public Fragment f78355x;

    /* renamed from: y  reason: collision with root package name */
    public Fragment f78356y;

    /* renamed from: z  reason: collision with root package name */
    public View f78357z;

    public class a extends TypeToken<List<OtcAdvertLabelBean>> {
        public a() {
        }
    }

    public class b extends BaseSubscriber<List<OtcTradeConfigListBean.QuoteAsset>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f78359b;

        public b(int i11) {
            this.f78359b = i11;
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
        }

        public void onNext(List<OtcTradeConfigListBean.QuoteAsset> list) {
            super.onNext(list);
            String c11 = up.g.c("otc_brand_select_trade_currency_quote_asset");
            if (!TextUtils.isEmpty(c11)) {
                if (!CollectionsUtils.b(list)) {
                    boolean z11 = false;
                    for (OtcTradeConfigListBean.QuoteAsset name : list) {
                        if (name.getName().equalsIgnoreCase(c11)) {
                            z11 = true;
                        }
                    }
                    if (!z11 && this.f78359b == 0) {
                        c11 = list.get(0).getName().toUpperCase();
                    }
                }
            } else if (!CollectionsUtils.b(list)) {
                c11 = up.g.c("otc_select_trade_currency_quote_asset");
                boolean z12 = false;
                for (OtcTradeConfigListBean.QuoteAsset name2 : list) {
                    if (name2.getName().equalsIgnoreCase(c11)) {
                        z12 = true;
                    }
                }
                if (!z12 && this.f78359b == 0) {
                    c11 = list.get(0).getName().toUpperCase();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("currencyName", c11);
            ((OtcTradeActivity) OtcMainNewFragment.this.getActivity()).li(this.f78359b, true, hashMap);
        }
    }

    public class c implements OtcActiveView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcActiveView f78361a;

        public c(OtcActiveView otcActiveView) {
            this.f78361a = otcActiveView;
        }

        public void onClose(String str) {
            if (!TextUtils.isEmpty(str)) {
                BaseModuleConfig.a().k0(str);
            }
            if (OtcMainNewFragment.this.f78343l != null) {
                OtcMainNewFragment.this.f78343l.removeView(this.f78361a);
            }
        }
    }

    public class d implements HBWebView.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcActiveView f78363a;

        public d(OtcActiveView otcActiveView) {
            this.f78363a = otcActiveView;
        }

        public void onError(int i11, String str) {
            if (OtcMainNewFragment.this.f78343l != null) {
                OtcMainNewFragment.this.f78343l.removeView(this.f78363a);
            }
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f78365a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.otc.enums.OtcAdsFilterType[] r0 = com.huobi.otc.enums.OtcAdsFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f78365a = r0
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.PAY_METHOD_FILTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f78365a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.AMOUNT_FILTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f78365a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.PAY_METHOD_FILTER_NEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.edgeengine.p2p.OtcMainNewFragment.e.<clinit>():void");
        }
    }

    public static /* synthetic */ List Th(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                for (OtcTradeConfigListBean.QuoteAsset next : ((OtcTradeConfigListBean) it2.next()).getQuoteAsset()) {
                    if (!arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (!CollectionsUtils.b(list2)) {
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                for (OtcTradeConfigListBean.QuoteAsset next2 : ((OtcTradeConfigListBean) it3.next()).getQuoteAsset()) {
                    if (!arrayList.contains(next2)) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(Object obj) {
        try {
            int parseInt = Integer.parseInt(obj.toString());
            if (parseInt != Oh()) {
                i6.d.j("updateP2pList", "OtcMainNewFragment--registerDataCallback change siteType>" + Oh() + " to " + parseInt + " tradeType-> " + toString());
                op.a.r(Nh()).P(this);
                bi(parseInt);
                Ih(parseInt);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(Object obj) {
        if (obj instanceof String) {
            List list = (List) new Gson().fromJson((String) obj, new a().getType());
            op.a r11 = op.a.r(Nh());
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) getActivity();
            if (otcTradeActivity != null) {
                String valueOf = String.valueOf(otcTradeActivity.fd());
                if (Ph() == 1) {
                    r11.p().put(valueOf, list);
                } else {
                    r11.e().put(valueOf, list);
                }
            }
        }
    }

    public void Ah() {
    }

    public void G8(OtcAdsFilterType otcAdsFilterType) {
        int i11 = e.f78365a[otcAdsFilterType.ordinal()];
        if (i11 == 1) {
            ei(Oh() == 0 ? 7 : 0);
        } else if (i11 == 2) {
            ei(6);
        } else if (i11 == 3) {
            ei(5);
        }
    }

    public final Fragment Gh(FragmentManager fragmentManager, Class cls, Bundle bundle, ViewGroup viewGroup, String str) {
        if (!(getActivity() instanceof OtcTradeActivity)) {
            return null;
        }
        NightHelper.e().d((BaseCoreActivity) getActivity());
        FragmentTransaction q11 = fragmentManager.q();
        for (Fragment next : fragmentManager.B0()) {
            if (next != null && !(next instanceof DialogFragment)) {
                q11.q(next);
            }
        }
        Fragment Sh = Sh(getActivity(), fragmentManager, cls.getName(), bundle, str);
        if (!Sh.isAdded()) {
            q11.c(viewGroup.getId(), Sh, str);
        }
        q11.A(Sh).k();
        return Sh;
    }

    public final void Hh(int i11) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((OtcTradeActivity) activity).ii(i11);
        }
    }

    public final void Ih(int i11) {
        op.a.r(Nh()).B(this);
        if (i11 == 0) {
            try {
                Observable.zip(nb.g.j().g(v1.c(i11), TradeSide.buy, true), nb.g.j().g(v1.c(i11), TradeSide.sell, true), ep.a.f54400b).compose(RxJavaHelper.t((g) null)).subscribe(new b(i11));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("currencyName", up.g.c("otc_select_trade_currency_quote_asset"));
            i6.d.j("updateTradingPairs", "updateTradingPairs changeSiteType-->" + i11);
            ((OtcTradeActivity) getActivity()).li(i11, true, hashMap);
        }
        Yh();
        Hh(i11);
        di();
        rj.b bVar = this.f78346o;
        if (bVar != null) {
            bVar.I("pageWillAppear()");
        }
    }

    /* renamed from: Jh */
    public OtcMainNewPresenter xh() {
        return new OtcMainNewPresenter();
    }

    public String Kh(String str) {
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(NightHelper.e().g() ? 1 : 0))});
        if (str.contains("?")) {
            return str + ContainerUtils.FIELD_DELIMITER + format;
        }
        return str + "?" + format;
    }

    public final String Lh(String str) {
        return "show_hkd_risk_tip_dialog" + OtcModuleConfig.a().getUid() + str;
    }

    public rj.b Mh() {
        return this.f78346o;
    }

    public final int Nh() {
        return Oh() == 0 ? 2 : 0;
    }

    public void O9() {
    }

    public final int Oh() {
        if (getActivity() instanceof OtcTradeActivity) {
            return ((OtcTradeActivity) getActivity()).Sh();
        }
        return -1;
    }

    public final int Ph() {
        if (getActivity() instanceof OtcTradeActivity) {
            return ((OtcTradeActivity) getActivity()).getTradePosition();
        }
        return -1;
    }

    /* renamed from: Qh */
    public g zh() {
        return this;
    }

    public final void Rh(View view) {
        this.f78352u = (FrameLayout) this.f67460i.b(R.id.fl_buy_sell);
        if (this.f78346o != null) {
            ek.b.f47515a.i(EdgeEngineScene.OTC_P2P.getScene());
        }
        this.f78346o = ek.b.f47515a.b(getContext(), EdgeEngineScene.OTC_P2P.getScene());
        Xh();
        this.f78346o.I("start()");
        this.f78346o.u("p2pMainTab.selectedMainTabIndex", new ep.b(this));
        ep.c cVar = new ep.c(this);
        this.f78346o.u("advertList.brand.extend", cVar);
        this.f78346o.u("advertList.normal.extend", cVar);
        this.f78343l = (ViewGroup) view.findViewById(R.id.fl_p2p_root);
        this.f78343l.addView(this.f78346o.D("site_tab_bar.xml", getContext()), 0);
        this.f78344m = (ViewGroup) view.findViewById(R.id.otc_appbar_scroll_view_group);
        this.f78345n = (ViewGroup) view.findViewById(R.id.otc_appbar_no_scroll_view_group);
        Yh();
        boolean j11 = b1.h().j();
        rj.b bVar = this.f78346o;
        bVar.I("changeTradeModel(" + (j11 ? 1 : 0) + ")");
        int Oh = Oh();
        if (Oh != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("siteType", Integer.valueOf(Oh));
            String str = Ph() <= 0 ? "buy" : "sell";
            hashMap.put("tradeType", str);
            String c11 = up.g.c(Oh == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
            hashMap.put("currencyName", c11);
            String j12 = va.b.j(c11);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, j12);
            hashMap.put("symbol", va.b.n(j12));
            rj.b bVar2 = this.f78346o;
            if (bVar2 != null) {
                bVar2.I("locateTo(" + JsonTool.toJSONString(hashMap) + ")");
                i6.d.j("updateP2pList", "OtcMainNewFragment--onViewCreated siteType>" + Oh + " tradeType->" + str + " currency:" + c11 + " " + toString());
            }
            Ih(Oh);
        }
    }

    public Fragment Sh(Activity activity, FragmentManager fragmentManager, String str, Bundle bundle, String str2) {
        Fragment m02 = fragmentManager.m0(str2);
        if (m02 != null) {
            if (!(m02.getArguments() == null || bundle == null)) {
                m02.getArguments().putAll(bundle);
            }
            return m02;
        }
        for (Fragment next : fragmentManager.B0()) {
            if (next != null && next.getClass().getName().equals(str) && str2.equals(next.getTag())) {
                if (!(next.getArguments() == null || bundle == null)) {
                    next.getArguments().putAll(bundle);
                }
                return next;
            }
        }
        Fragment a11 = fragmentManager.z0().a(activity.getClassLoader(), str);
        a11.setArguments(bundle);
        return a11;
    }

    public void Wh(String str) {
        if (Oh() == 0) {
            Fragment fragment = this.f78355x;
            if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                ((PublicAdsNewFragment) this.f78355x).Uh(str);
                return;
            }
            return;
        }
        Fragment fragment2 = this.f78356y;
        if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
            ((PublicAdsNewFragment) this.f78356y).Uh(str);
        }
    }

    public void Xh() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", p.a(this.f78346o.d()).toLowerCase());
        hashMap.put("iconURLHost", AssetModuleConfig.a().j().replace(DomainTool.DOMAIN_PREFIX, ""));
        hashMap.put("colorMode", NightHelper.e().g() ? "1" : "0");
        hashMap.put("OS", "1");
        hashMap.put("uid", r.x().J());
        hashMap.put(AttributionReporter.APP_VERSION, String.valueOf(105400));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int h11 = PixelUtils.h((float) displayMetrics.widthPixels);
        int h12 = PixelUtils.h((float) displayMetrics.heightPixels);
        hashMap.put("screenWidth", Integer.valueOf(h11));
        hashMap.put("screenHeight", Integer.valueOf(h12));
        rj.b bVar = this.f78346o;
        bVar.I("sendCommonConfig(" + JSON.toJSONString(hashMap) + ")");
    }

    public final void Yh() {
        if (this.f78357z == null) {
            View D = this.f78346o.D("normal_banner.xml", getContext());
            this.f78357z = D;
            this.f78344m.addView(D, 0);
        }
        if (this.f78349r == null) {
            View D2 = this.f78346o.D("normal_advert_filter_bar.xml", getContext());
            this.f78349r = D2;
            this.f78344m.addView(D2);
        }
        if (this.f78350s == null) {
            View D3 = this.f78346o.D("normal_advert_filter_and_trade_tip.xml", getContext());
            this.f78350s = D3;
            this.f78345n.addView(D3);
        }
        if (this.A == null) {
            View D4 = this.f78346o.D("brand_banner.xml", getContext());
            this.A = D4;
            View findViewById = D4.findViewById(R.id.id_otc_banner_indicator);
            if (findViewById != null && (findViewById instanceof OtcCommonRectFIndicator)) {
                ((OtcCommonRectFIndicator) findViewById).a(Color.parseColor("#5E5E61"), Color.parseColor("#5E5E61"));
            }
            this.f78344m.addView(this.A, 0);
        }
        if (this.f78347p == null) {
            View D5 = this.f78346o.D("brand_advert_filter_bar.xml", getContext());
            this.f78347p = D5;
            this.f78344m.addView(D5);
        }
        if (this.f78348q == null) {
            View D6 = this.f78346o.D("brand_advert_filter_and_trade_tip.xml", getContext());
            this.f78348q = D6;
            this.f78345n.addView(D6);
        }
    }

    public final void Zh(int i11) {
        if (Oh() == 0) {
            Fragment fragment = this.f78355x;
            if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                ((PublicAdsNewFragment) this.f78355x).Zh(i11);
                return;
            }
            return;
        }
        Fragment fragment2 = this.f78356y;
        if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
            ((PublicAdsNewFragment) this.f78356y).Zh(i11);
        }
    }

    public void ai(boolean z11) {
        if (!z11 && this.B) {
            for (Fragment next : getChildFragmentManager().B0()) {
                if (next instanceof PublicAdsNewFragment) {
                    PublicAdsNewFragment publicAdsNewFragment = (PublicAdsNewFragment) next;
                    if (publicAdsNewFragment.Sh() && publicAdsNewFragment.Oh() != null) {
                        publicAdsNewFragment.Oh().a();
                    }
                }
            }
        }
        this.B = z11;
    }

    public final void bi(int i11) {
        if (getActivity() instanceof OtcTradeActivity) {
            ((OtcTradeActivity) getActivity()).si(i11);
        }
    }

    public final void ci(int i11) {
        if (getActivity() instanceof OtcTradeActivity) {
            ((OtcTradeActivity) getActivity()).vi(i11);
        }
    }

    public final void di() {
        if (Oh() == 0) {
            if (this.f78353v == null) {
                Bundle bundle = new Bundle();
                this.f78353v = bundle;
                bundle.putInt("siteType", 0);
            }
            Bundle bundle2 = this.f78353v;
            FrameLayout frameLayout = this.f78352u;
            this.f78355x = Gh(getChildFragmentManager(), PublicAdsNewFragment.class, bundle2, frameLayout, PublicAdsNewFragment.class.getName() + 0);
            return;
        }
        if (this.f78354w == null) {
            Bundle bundle3 = new Bundle();
            this.f78354w = bundle3;
            bundle3.putInt("siteType", 1);
        }
        Bundle bundle4 = this.f78354w;
        FrameLayout frameLayout2 = this.f78352u;
        this.f78356y = Gh(getChildFragmentManager(), PublicAdsNewFragment.class, bundle4, frameLayout2, PublicAdsNewFragment.class.getName() + 1);
    }

    public final void ei(int i11) {
        if (getActivity() != null && (getActivity() instanceof OtcTradeActivity)) {
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) getActivity();
            otcTradeActivity.xi(i11, Ph(), !b1.h().j() ? 1 : 0, String.valueOf(otcTradeActivity.fd()), Oh());
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void findCurrentFragmentToScroll(OnScrollToTopImageClickEvent onScrollToTopImageClickEvent) {
        if (Oh() == 0) {
            Fragment fragment = this.f78355x;
            if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                ((PublicAdsNewFragment) this.f78355x).Mh();
                return;
            }
            return;
        }
        Fragment fragment2 = this.f78356y;
        if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
            ((PublicAdsNewFragment) this.f78356y).Mh();
        }
    }

    public void j4(int i11, String str, boolean z11) {
        if (Oh() != -1) {
            HashMap hashMap = new HashMap();
            String c11 = up.g.c(i11 == 0 ? "otc_select_trade_currency_quote_asset" : "otc_brand_select_trade_currency_quote_asset");
            hashMap.put("currencyName", c11);
            String j11 = va.b.j(c11);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, j11);
            hashMap.put("symbol", va.b.n(j11));
            rj.b bVar = this.f78346o;
            bVar.I("updateTradingPairs(" + JsonTool.toJSONString(hashMap) + ")");
            i6.d.j("updateTradingPairs", "OtcMainNewFragment --onSelectCurrency--updateIndicator> quoteName " + c11 + " " + this);
            if (Oh() == 0) {
                Fragment fragment = this.f78355x;
                if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                    ((PublicAdsNewFragment) this.f78355x).j4(i11, c11, z11);
                    return;
                }
                return;
            }
            Fragment fragment2 = this.f78356y;
            if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
                ((PublicAdsNewFragment) this.f78356y).j4(i11, c11, z11);
            }
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onActivityEvent(OtcActivityEvent otcActivityEvent) {
        ViewGroup viewGroup;
        if ((oa.a.g().b() instanceof OtcTradeActivity) && otcActivityEvent != null && !TextUtils.isEmpty(otcActivityEvent.getHbgContentUrl()) && (viewGroup = this.f78343l) != null && viewGroup.getChildCount() == 1) {
            OtcActiveView otcActiveView = new OtcActiveView(getActivity());
            String hbgContentUrl = otcActivityEvent.getHbgContentUrl();
            if (hbgContentUrl.indexOf("/") == 0) {
                hbgContentUrl = hbgContentUrl.substring(1);
            }
            otcActiveView.setUrl(Kh(BaseModuleConfig.a().k(hbgContentUrl)));
            otcActiveView.setCallback(new c(otcActiveView));
            otcActiveView.setLoadErrorListener(new d(otcActiveView));
            otcActiveView.D();
            this.f78343l.addView(otcActiveView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAdModeChange(OtcAdModeChangeEvent otcAdModeChangeEvent) {
        boolean j11 = b1.h().j();
        rj.b bVar = this.f78346o;
        if (bVar != null) {
            bVar.I("changeTradeModel(" + (j11 ? 1 : 0) + ")");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAdPriceChange(OtcAdPriceChangeEvent otcAdPriceChangeEvent) {
        if (zh() != null && zh().isAlive() && this.f78346o != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("advertId", otcAdPriceChangeEvent.advertId);
            hashMap.put(FirebaseAnalytics.Param.PRICE, otcAdPriceChangeEvent.price);
            rj.b bVar = this.f78346o;
            bVar.I("onAdvertPriceChanged(" + JsonTool.toJSONString(hashMap) + ")");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        op.a.r(Nh()).P(this);
        ek.b.f47515a.e(EdgeEngineScene.OTC_P2P.getScene());
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onFilterEvent(OtcFilterEvent otcFilterEvent) {
        if (getActivity() != null && zh().isAlive()) {
            AbilityFunction.a c11 = otcFilterEvent.c();
            String b11 = otcFilterEvent.b();
            i6.d.j("adfsdfdsfaf", "onFilterEvent action--->" + b11 + " siteType->" + Oh());
            b11.hashCode();
            char c12 = 65535;
            switch (b11.hashCode()) {
                case -2051432204:
                    if (b11.equals("toSeaviewRoom")) {
                        c12 = 0;
                        break;
                    }
                    break;
                case -1963767608:
                    if (b11.equals("toStrictSelection")) {
                        c12 = 1;
                        break;
                    }
                    break;
                case -1907673382:
                    if (b11.equals("checkRiskState")) {
                        c12 = 2;
                        break;
                    }
                    break;
                case -1853910365:
                    if (b11.equals("onFilterOptionWithCurrency")) {
                        c12 = 3;
                        break;
                    }
                    break;
                case -1566346506:
                    if (b11.equals("toBindPhone")) {
                        c12 = 4;
                        break;
                    }
                    break;
                case -1367244233:
                    if (b11.equals("toCreateOrder")) {
                        c12 = 5;
                        break;
                    }
                    break;
                case -1103532182:
                    if (b11.equals("onFilterOptionWithAmount")) {
                        c12 = 6;
                        break;
                    }
                    break;
                case -1076188561:
                    if (b11.equals("onFilterOptionWithPayMehod")) {
                        c12 = 7;
                        break;
                    }
                    break;
                case -901917130:
                    if (b11.equals("mesureSizeOfString")) {
                        c12 = 8;
                        break;
                    }
                    break;
                case -263691976:
                    if (b11.equals("toSetAdverts")) {
                        c12 = 9;
                        break;
                    }
                    break;
                case -206375193:
                    if (b11.equals("onFilterOptionWithMore")) {
                        c12 = 10;
                        break;
                    }
                    break;
                case 668231559:
                    if (b11.equals("toGreateAdvert")) {
                        c12 = 11;
                        break;
                    }
                    break;
                case 1038137133:
                    if (b11.equals("onFilterOptionWithDirection")) {
                        c12 = 12;
                        break;
                    }
                    break;
                case 1358749956:
                    if (b11.equals("onFilterOptionWithCryptoCurrency")) {
                        c12 = 13;
                        break;
                    }
                    break;
                case 2043761615:
                    if (b11.equals("goMerchantHome")) {
                        c12 = 14;
                        break;
                    }
                    break;
            }
            switch (c12) {
                case 0:
                    i6.d.j("checkRiskState-toSeaviewRoom>", otcFilterEvent.h());
                    try {
                        JSONObject jSONObject = new JSONObject(otcFilterEvent.h());
                        Intent intent = new Intent(getActivity(), OtcSeaViewRoomActivity.class);
                        int i11 = jSONObject.getInt("coinId");
                        intent.putExtra("coinId", i11);
                        Bundle bundle = new Bundle();
                        String string = jSONObject.getString("tradeType");
                        OtcTradeType parseFromValue = OtcTradeType.parseFromValue(string);
                        OtcTradeType otcTradeType = OtcTradeType.BUY;
                        if (parseFromValue == otcTradeType) {
                            otcTradeType = OtcTradeType.SELL;
                        }
                        bundle.putSerializable("TradeType", otcTradeType);
                        intent.putExtra("tradeBundle", bundle);
                        getActivity().startActivityForResult(intent, OtcSeaViewRoomActivity.f79533g);
                        i6.d.j("checkRiskState-toSeaviewRoom>", i11 + "  " + string);
                        break;
                    } catch (Exception e11) {
                        throw new RuntimeException(e11);
                    }
                case 1:
                    if (getContext() instanceof OtcTradeActivity) {
                        ((OtcTradeActivity) getContext()).zi();
                        break;
                    }
                    break;
                case 2:
                    try {
                        String g11 = otcFilterEvent.g();
                        String d11 = otcFilterEvent.d();
                        String Lh = Lh(d11);
                        i6.d.j("adfsdfdsfaf", "checkRiskState method --->" + g11 + " " + d11);
                        if (g11.equals("set")) {
                            ConfigPreferences.n("otc_config", Lh, true);
                            break;
                        } else {
                            c11.a(true, Boolean.valueOf(ConfigPreferences.a("otc_config", Lh)));
                            return;
                        }
                    } catch (Exception e12) {
                        i6.d.j("checkRiskState-Exception>", "-->" + e12.getMessage());
                        break;
                    }
                case 3:
                    if (getContext() instanceof OtcTradeActivity) {
                        OtcTradeActivity otcTradeActivity = (OtcTradeActivity) getContext();
                        otcTradeActivity.xi(3, otcTradeActivity.Rh(), !b1.h().j() ? 1 : 0, String.valueOf(otcTradeActivity.fd()), Oh());
                        break;
                    }
                    break;
                case 4:
                    if (getActivity() instanceof OtcTradeActivity) {
                        UserSecurityInfoData Wh = ((OtcTradeActivity) getActivity()).Wh();
                        if (this.C == null) {
                            this.C = new c1(getContext(), this, getFragmentManager());
                        }
                        this.C.G(Wh);
                        break;
                    }
                    break;
                case 5:
                    OtcModuleConfig.b().T(getActivity(), (Ads) new Gson().fromJson(otcFilterEvent.h(), Ads.class), false, (String) null, (String) null);
                    break;
                case 6:
                    G8(OtcAdsFilterType.AMOUNT_FILTER);
                    break;
                case 7:
                    G8(OtcAdsFilterType.PAY_METHOD_FILTER_NEW);
                    break;
                case 8:
                    try {
                        int e13 = otcFilterEvent.e();
                        otcFilterEvent.f();
                        String i12 = otcFilterEvent.i();
                        this.f78351t.setTextSize((float) e13);
                        float measureText = this.f78351t.measureText(i12);
                        HashMap hashMap = new HashMap();
                        hashMap.put("width", Float.valueOf(measureText));
                        c11.a(true, JsonTool.toJSONString(hashMap));
                        return;
                    } catch (Exception e14) {
                        i6.d.j("adfsdfdsfaf-mesureSizeOfString-Exception>", "-->" + e14.getMessage());
                        break;
                    }
                case 9:
                    if (getActivity() instanceof OtcTradeActivity) {
                        ((OtcTradeActivity) getActivity()).m5().r(OtcTradeAreaEnum.AD_AREA, (Bundle) null);
                        break;
                    }
                    break;
                case 10:
                    G8(OtcAdsFilterType.PAY_METHOD_FILTER);
                    break;
                case 11:
                    i6.d.j("checkRiskState-toGreateAdvert>", otcFilterEvent.h());
                    if (getActivity() instanceof OtcTradePresenter.i) {
                        b1.h().k(getActivity(), (OtcTradePresenter.i) getActivity());
                        break;
                    }
                    break;
                case 12:
                    if ("buy".equals(otcFilterEvent.h())) {
                        ci(0);
                        Zh(0);
                    } else {
                        ci(1);
                        Zh(1);
                    }
                    int Nh = Nh();
                    op.a.r(Nh).H("");
                    op.a.r(Nh).D("");
                    op.a.r(Nh).y();
                    break;
                case 13:
                    if (getContext() instanceof OtcTradeActivity) {
                        OtcTradeActivity otcTradeActivity2 = (OtcTradeActivity) getContext();
                        otcTradeActivity2.xi(1, Ph(), !b1.h().j() ? 1 : 0, String.valueOf(otcTradeActivity2.fd()), Oh());
                        break;
                    }
                    break;
                case 14:
                    OtcModuleConfig.b().K(getActivity(), Long.valueOf(otcFilterEvent.h().toString()));
                    break;
            }
            c11.a(true, (Object) null);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onFollow(OtcFollowEvent otcFollowEvent) {
        if (otcFollowEvent.params != null && otcFollowEvent.object != this && zh() != null && zh().isAlive()) {
            Long valueOf = Long.valueOf(otcFollowEvent.params.get("uid"));
            HashMap hashMap = new HashMap();
            hashMap.put("type", otcFollowEvent.params.get("type"));
            hashMap.put("relationStatus", otcFollowEvent.params.get("relationStatus"));
            hashMap.put("uid", valueOf);
            rj.b bVar = this.f78346o;
            bVar.I("onMerchantAttentionChanged(" + JsonTool.toJSONString(hashMap) + ")");
        }
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            Hh(1);
        } else {
            Hh(Oh());
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onLinksJumpOtc(LinksJumpOtcEvent linksJumpOtcEvent) {
        if (linksJumpOtcEvent != null) {
            int Ph = Ph();
            HashMap hashMap = new HashMap();
            int siteType = linksJumpOtcEvent.getSiteType();
            hashMap.put("siteType", Integer.valueOf(siteType));
            hashMap.put("tradeType", Ph <= 0 ? "buy" : "sell");
            String fiatName = linksJumpOtcEvent.getFiatName();
            if (TextUtils.isEmpty(fiatName)) {
                fiatName = up.g.c(Oh() == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
            }
            hashMap.put("currencyName", fiatName);
            String j11 = va.b.j(fiatName);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, j11);
            hashMap.put("symbol", va.b.n(j11));
            rj.b bVar = this.f78346o;
            if (bVar != null) {
                bVar.I("locateTo(" + JsonTool.toJSONString(hashMap) + ")");
                i6.d.j("updateP2pList", "OtcMainNewFragment--onLinksJumpOtc locateTo siteType>" + siteType + " tradePosition->" + Ph + " currency:" + fiatName + " " + toString());
            }
            Ih(siteType);
            if (siteType == 0) {
                Fragment fragment = this.f78355x;
                if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                    ((PublicAdsNewFragment) this.f78355x).ai(Ph, linksJumpOtcEvent.getCryptoName());
                    return;
                }
                return;
            }
            Fragment fragment2 = this.f78356y;
            if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
                ((PublicAdsNewFragment) this.f78356y).ai(Ph, linksJumpOtcEvent.getCryptoName());
            }
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onOnFilterEvent(OnFilterEvent onFilterEvent) {
        if (getActivity() != null && zh().isAlive() && this.f78346o != null) {
            i6.d.j("updateP2pList", "getJsonToMap->" + onFilterEvent.getJsonToMap());
            rj.b bVar = this.f78346o;
            bVar.I("updateP2pList(" + JsonTool.toJSONString(onFilterEvent.getJsonToMap()) + ")");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onSelectCoinEvent(OnSelectCoinEvent onSelectCoinEvent) {
        if (getActivity() != null && zh().isAlive()) {
            Wh(onSelectCoinEvent.getCoinName());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        Rh(view);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_main_otc_new, viewGroup, false);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void setToTopVisible(OnImageToTopEvent onImageToTopEvent) {
        if (Oh() == 0) {
            Fragment fragment = this.f78355x;
            if (fragment != null && (fragment instanceof PublicAdsNewFragment) && fragment.isAdded() && this.f78355x.getView() != null) {
                ((PublicAdsNewFragment) this.f78355x).Yh();
                return;
            }
            return;
        }
        Fragment fragment2 = this.f78356y;
        if (fragment2 != null && (fragment2 instanceof PublicAdsNewFragment) && fragment2.isAdded() && this.f78356y.getView() != null) {
            ((PublicAdsNewFragment) this.f78356y).Yh();
        }
    }

    public void th(boolean z11) {
        super.th(z11);
        if (!z11) {
            SoftInputUtils.f(getActivity());
        }
        ai(z11);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            rj.b bVar = this.f78346o;
            if (bVar != null) {
                bVar.I("moduleWillAppear()");
                return;
            }
            return;
        }
        rj.b bVar2 = this.f78346o;
        if (bVar2 != null) {
            bVar2.I("moduleWillDisappear()");
        }
    }
}
