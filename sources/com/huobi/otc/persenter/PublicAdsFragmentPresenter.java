package com.huobi.otc.persenter;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.AdvertVerifyCapitalConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcAdvertLabelBean;
import com.huobi.otc.ui.OtcSeaViewRoomActivity;
import i6.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qp.x;
import qp.y;
import qp.z;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import up.w;

public class PublicAdsFragmentPresenter extends BaseFragmentPresenter<g> {

    /* renamed from: c  reason: collision with root package name */
    public int f79164c = 1;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f79165d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f79166e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79167f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f79168g;

    /* renamed from: h  reason: collision with root package name */
    public List<AdvertVerifyCapitalConfigBean> f79169h = new ArrayList();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f79170b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f79171c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f79172d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f79173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f79174f;

        public a(boolean z11, boolean z12, boolean z13, boolean z14, int i11) {
            this.f79170b = z11;
            this.f79171c = z12;
            this.f79172d = z13;
            this.f79173e = z14;
            this.f79174f = i11;
        }

        public void run() {
            PublicAdsFragmentPresenter.this.r0(this.f79170b, this.f79171c, this.f79172d, this.f79173e, this.f79174f);
        }
    }

    public class b extends EasySubscriber<OTCPageListExtendResponse<List<Ads>, List<OtcAdvertLabelBean>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f79176b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f79177c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f79178d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f79179e;

        public b(boolean z11, int i11, boolean z12, boolean z13) {
            this.f79176b = z11;
            this.f79177c = i11;
            this.f79178d = z12;
            this.f79179e = z13;
        }

        /* renamed from: a */
        public void onNext(OTCPageListExtendResponse<List<Ads>, List<OtcAdvertLabelBean>> oTCPageListExtendResponse) {
            if (((g) PublicAdsFragmentPresenter.this.getUI()).D0() == OtcTradeType.SELL) {
                op.a.r(this.f79177c).p().put(String.valueOf(((g) PublicAdsFragmentPresenter.this.getUI()).fd()), oTCPageListExtendResponse.getExtend());
            } else {
                op.a.r(this.f79177c).e().put(String.valueOf(((g) PublicAdsFragmentPresenter.this.getUI()).fd()), oTCPageListExtendResponse.getExtend());
            }
            List list = (List) oTCPageListExtendResponse.getData();
            PublicAdsFragmentPresenter.this.z0(list);
            if (list != null) {
                boolean unused = PublicAdsFragmentPresenter.this.f79167f = true;
                if (PublicAdsFragmentPresenter.this.f79164c == 1) {
                    PublicAdsFragmentPresenter.this.f79165d.clear();
                    if (list.size() >= 3) {
                        ((Ads) list.get(0)).setSeaViewRoomPosition(1);
                        ((Ads) list.get(1)).setSeaViewRoomPosition(2);
                        ((Ads) list.get(2)).setSeaViewRoomPosition(3);
                    } else if (list.size() == 2) {
                        ((Ads) list.get(0)).setSeaViewRoomPosition(1);
                        ((Ads) list.get(1)).setSeaViewRoomPosition(2);
                    } else if (list.size() == 1) {
                        ((Ads) list.get(0)).setSeaViewRoomPosition(1);
                    }
                }
                if (CollectionsUtils.b(list) || ((Ads) list.get(0)).getCoinId() == ((g) PublicAdsFragmentPresenter.this.getUI()).fd()) {
                    PublicAdsFragmentPresenter.this.f79165d.addAll(list);
                    ((g) PublicAdsFragmentPresenter.this.getUI()).Rc(this.f79179e);
                    ((g) PublicAdsFragmentPresenter.this.getUI()).ad(PublicAdsFragmentPresenter.this.f79165d);
                }
            } else if (this.f79178d || CollectionsUtils.b(PublicAdsFragmentPresenter.this.f79165d)) {
                ((g) PublicAdsFragmentPresenter.this.getUI()).m0();
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onStart() {
            if (this.f79176b && PublicAdsFragmentPresenter.this.getUI() != null && ((g) PublicAdsFragmentPresenter.this.getUI()).isAlive()) {
                ((g) PublicAdsFragmentPresenter.this.getUI()).Jb();
            }
        }
    }

    public class c extends Subscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f79181b;

        public c(boolean z11) {
            this.f79181b = z11;
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            Log.e("", "");
        }

        public void onNext(Object obj) {
            ((g) PublicAdsFragmentPresenter.this.getUI()).Rc(this.f79181b);
            ((g) PublicAdsFragmentPresenter.this.getUI()).ad(PublicAdsFragmentPresenter.this.f79165d);
        }
    }

    public class d extends q6.a<OTCStatusResponse<List<AdvertVerifyCapitalConfigBean>>> {
        public d(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusResponse<List<AdvertVerifyCapitalConfigBean>> oTCStatusResponse) {
            if (oTCStatusResponse.isSuccess()) {
                PublicAdsFragmentPresenter.this.f79169h = oTCStatusResponse.getData();
                PublicAdsFragmentPresenter publicAdsFragmentPresenter = PublicAdsFragmentPresenter.this;
                publicAdsFragmentPresenter.z0(publicAdsFragmentPresenter.f79165d);
                ((g) PublicAdsFragmentPresenter.this.getUI()).ad(PublicAdsFragmentPresenter.this.f79165d);
            }
        }
    }

    public class e implements w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f79184a;

        public e(Ads ads) {
            this.f79184a = ads;
        }

        public void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list) {
            ((g) PublicAdsFragmentPresenter.this.getUI()).sd(tradeReMarkBean, this.f79184a, otcAdTicket, list);
        }

        public void b() {
            boolean unused = PublicAdsFragmentPresenter.this.f79166e = true;
        }
    }

    public class f extends q6.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f79186a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(u6.g gVar, Ads ads) {
            super(gVar);
            this.f79186a = ads;
        }

        public void onRequestFailure(Throwable th2) {
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.m(((APIStatusErrorException) th2).getErrMsg());
            } else {
                HuobiToastUtil.j(R$string.n_check_network);
            }
        }

        public void onRequestSuccess(Object obj) {
            ((g) PublicAdsFragmentPresenter.this.getUI()).nb(this.f79186a.getUid());
        }
    }

    public interface g extends SmartRefreshPageSplitter.d {
        OtcTradeType D0();

        void Jb();

        void Rc(boolean z11);

        void X0();

        void ad(List<s9.a> list);

        int fd();

        void hd();

        void m0();

        void nb(long j11);

        void sd(TradeReMarkBean tradeReMarkBean, Ads ads, OtcAdTicket otcAdTicket, List<Coupon> list);

        void sg(boolean z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(boolean z11, boolean z12, OTCPageListExtendResponse oTCPageListExtendResponse) {
        this.f79167f = true;
        List list = (List) oTCPageListExtendResponse.getData();
        if (CollectionsUtils.b(list) || ((Ads) list.get(0)).getCoinId() == ((g) getUI()).fd()) {
            if (this.f79164c == 1) {
                this.f79165d.clear();
            }
            if (!CollectionsUtils.b(list) || this.f79164c == 1) {
                this.f79165d.addAll(list);
                if (!z11) {
                    l0();
                }
                if (this.f79165d.get(0) != null && ((Ads) this.f79165d.get(0)).getTypeHandler() == 2) {
                    ((Ads) this.f79165d.get(0)).getOtcOneKeyBuyConfig().setShowEmptyPic(false);
                }
                ((g) getUI()).Rc(z12);
                ((g) getUI()).ad(this.f79165d);
                return;
            }
            ((g) getUI()).X0();
            if (!z11 && l0()) {
                ((g) getUI()).ad(this.f79165d);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(APIStatusErrorException aPIStatusErrorException) {
        List<s9.a> list = this.f79165d;
        if (list == null || list.size() <= 0) {
            ((g) getUI()).m0();
        } else {
            ((g) getUI()).X0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(Throwable th2) {
        List<s9.a> list = this.f79165d;
        if (list == null || list.size() <= 0) {
            ((g) getUI()).m0();
        } else {
            ((g) getUI()).X0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object x0(int i11, boolean z11, OTCPageListExtendResponse oTCPageListExtendResponse, OTCPageListExtendResponse oTCPageListExtendResponse2) {
        if (((g) getUI()).D0() == OtcTradeType.SELL) {
            op.a.r(i11).p().put(String.valueOf(((g) getUI()).fd()), (List) oTCPageListExtendResponse.getExtend());
        } else {
            op.a.r(i11).e().put(String.valueOf(((g) getUI()).fd()), (List) oTCPageListExtendResponse.getExtend());
        }
        List list = (List) oTCPageListExtendResponse.getData();
        z0(list);
        List list2 = (List) oTCPageListExtendResponse2.getData();
        if (list == null) {
            if (z11 || CollectionsUtils.b(this.f79165d)) {
                ((g) getUI()).m0();
            }
            return null;
        }
        this.f79167f = true;
        if (this.f79164c == 1) {
            this.f79165d.clear();
        }
        if (!CollectionsUtils.b(list) && ((Ads) list.get(0)).getCoinId() != ((g) getUI()).fd()) {
            return null;
        }
        if (this.f79164c == 1) {
            t0(list, list2);
        }
        this.f79165d.addAll(list);
        if (oTCPageListExtendResponse.totalPage <= 1 && oTCPageListExtendResponse2.totalPage <= 1 && this.f79165d.size() <= oTCPageListExtendResponse.pageSize) {
            l0();
        }
        return this.f79165d;
    }

    public final void A0(FragmentActivity fragmentActivity, Ads ads) {
        w.n(fragmentActivity, ads, (u6.g) getUI(), Boolean.FALSE, new e(ads), (String) null);
    }

    public void Z(boolean z11) {
        super.Y(z11);
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
            BaseCoreActivity activity = getActivity();
            if (activity != null) {
                if (!NetworkStatus.c(activity)) {
                    HuobiToastUtil.j(com.hbg.lite.R$string.server_error);
                } else {
                    ((g) getUI()).Jb();
                }
            }
        } else {
            ((g) getUI()).hd();
            if (EventBus.d().i(this)) {
                EventBus.d().r(this);
            }
        }
    }

    public final boolean l0() {
        if (this.f79165d.isEmpty()) {
            return false;
        }
        int size = this.f79165d.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((Ads) this.f79165d.get(i11)).getTypeHandler() == 4) {
                return false;
            }
        }
        Ads ads = new Ads();
        ads.setTypeHandler(4);
        ads.setTradeType(((Ads) this.f79165d.get(0)).getTradeType());
        if (size <= 15) {
            this.f79165d.add(ads);
            return true;
        }
        this.f79165d.add(15, ads);
        return true;
    }

    public void m0(Ads ads) {
        s8.a.a().userRelationChange(String.valueOf(ads.getUid()), MapParamsBuilder.c().a("type", "follow").a("relationStatus", ads.isFollowed() ? "off" : "on").b()).d(new f((u6.g) getUI(), ads));
    }

    public void n0(boolean z11, boolean z12, boolean z13, boolean z14, int i11) {
        if (this.f79168g == null) {
            this.f79168g = new a(z11, z12, z13, z14, i11);
        }
        i.b().h(this.f79168g);
        i.b().g(this.f79168g, 20);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.f79166e) {
            this.f79166e = false;
            OtcModuleConfig.a().e("");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((g) getUI()).isAlive()) {
            Intent a02 = OtcModuleConfig.a().a0(getActivity());
            Intent a03 = OtcModuleConfig.a().a0(getActivity());
            if (OtcModuleConfig.a().Y().equals(a02.getStringExtra("navigator_action"))) {
                a02 = OtcModuleConfig.a().M(getActivity());
                a03 = OtcModuleConfig.a().M(getActivity());
            }
            OtcModuleConfig.a().l(getActivity(), a03, a02);
            getActivity().finish();
        }
    }

    public void p0(FragmentActivity fragmentActivity, Ads ads) {
        A0(fragmentActivity, ads);
    }

    public void q0(boolean z11, boolean z12, int i11) {
        if (getUI() != null && ((g) getUI()).fd() != 0 && ((g) getUI()).D0() != null) {
            this.f79164c++;
            if (z12) {
                ((g) getUI()).sg(false);
                this.f79164c = 1;
            }
            if (z11) {
                this.f79164c = 1;
            }
            HashMap hashMap = new HashMap();
            op.a r11 = op.a.r(i11);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, va.b.j(r11.f()));
            if (!TextUtils.isEmpty(r11.a())) {
                hashMap.put("amount", r11.a());
            }
            hashMap.put("payMethod", r11.n());
            hashMap.put("currPage", String.valueOf(this.f79164c));
            hashMap.put("blockType", r11.j());
            hashMap.put(SymbolBean.ONLINE, "1");
            hashMap.put("isThumbsUp", String.valueOf(r11.w()));
            hashMap.put("isTraded", String.valueOf(r11.x()));
            hashMap.put("isFollowed", String.valueOf(r11.t()));
            if (!TextUtils.isEmpty(r11.b()) && ((g) getUI()).D0() == OtcTradeType.BUY) {
                hashMap.put("merchantTags", r11.b());
            }
            if (!TextUtils.isEmpty(r11.o()) && ((g) getUI()).D0() == OtcTradeType.SELL) {
                hashMap.put("acceptOrder", r11.o());
            }
            hashMap.put("isMerchant", String.valueOf(r11.u()));
            hashMap.put("makerCompleteRate", String.valueOf(r11.i()));
            if (getActivity() instanceof OtcSeaViewRoomActivity) {
                hashMap.put("seaViewRoom", "1");
                hashMap.put("onlyTradable", String.valueOf(false));
            } else {
                hashMap.put("seaViewRoom", "0");
                hashMap.put("onlyTradable", String.valueOf(r11.v()));
            }
            hashMap.put("labelId", r11.g());
            l.l(((g) getUI()).fd(), ((g) getUI()).D0().value, hashMap).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new y(this, TextUtils.equals((CharSequence) hashMap.get("seaViewRoom"), "1"), z11), new qp.w(this), new x(this)));
        }
    }

    public void r0(boolean z11, boolean z12, boolean z13, boolean z14, int i11) {
        boolean z15 = z11;
        boolean z16 = z12;
        if (getUI() != null && ((g) getUI()).fd() != 0 && ((g) getUI()).D0() != null) {
            this.f79164c++;
            if (z16) {
                if (CollectionsUtils.b(this.f79165d)) {
                    ((g) getUI()).sg(false);
                }
                this.f79164c = 1;
            } else if (z15 && !this.f79167f) {
                ((g) getUI()).sg(this.f79167f);
                this.f79164c = 1;
            }
            if (z15) {
                this.f79164c = 1;
            }
            HashMap hashMap = new HashMap();
            op.a r11 = op.a.r(i11);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, va.b.j(r11.f()));
            if (!TextUtils.isEmpty(r11.a())) {
                hashMap.put("amount", r11.a());
            }
            hashMap.put("payMethod", r11.n());
            hashMap.put("makerCompleteRate", String.valueOf(r11.i()));
            hashMap.put("labelId", r11.g());
            hashMap.put("currPage", String.valueOf(this.f79164c));
            hashMap.put("blockType", r11.j());
            hashMap.put(SymbolBean.ONLINE, "1");
            if (!TextUtils.isEmpty(r11.b()) && ((g) getUI()).D0() == OtcTradeType.BUY) {
                hashMap.put("merchantTags", r11.b());
            }
            if (!TextUtils.isEmpty(r11.o()) && ((g) getUI()).D0() == OtcTradeType.SELL) {
                hashMap.put("acceptOrder", r11.o());
            }
            hashMap.put("isMerchant", String.valueOf(r11.u()));
            hashMap.put("isThumbsUp", String.valueOf(r11.w()));
            Object obj = "merchantTags";
            hashMap.put("isTraded", String.valueOf(r11.x()));
            Object obj2 = "currPage";
            hashMap.put("onlyTradable", String.valueOf(r11.v()));
            hashMap.put("isFollowed", String.valueOf(r11.t()));
            HashMap hashMap2 = new HashMap();
            if (z13 && getUI() != null && ((g) getUI()).isAlive()) {
                ((g) getUI()).Jb();
            }
            HashMap hashMap3 = hashMap;
            hashMap2.put("isFollowed", String.valueOf(r11.t()));
            hashMap2.put("isMerchant", String.valueOf(r11.u()));
            hashMap2.put("isThumbsUp", String.valueOf(r11.w()));
            hashMap2.put("isTraded", String.valueOf(r11.x()));
            hashMap2.put("payMethod", r11.n());
            hashMap2.put("makerCompleteRate", String.valueOf(r11.i()));
            hashMap2.put("labelId", r11.g());
            if (!TextUtils.isEmpty(r11.a())) {
                hashMap2.put("amount", r11.a());
            }
            hashMap2.put("seaViewRoom", "1");
            hashMap2.put(FirebaseAnalytics.Param.CURRENCY, va.b.j(r11.f()));
            hashMap2.put("blockType", r11.j());
            hashMap2.put("onlyTradable", String.valueOf(false));
            hashMap2.put(SymbolBean.ONLINE, "1");
            hashMap2.put(obj2, String.valueOf(this.f79164c));
            if (!TextUtils.isEmpty(r11.b()) && ((g) getUI()).D0() == OtcTradeType.BUY) {
                hashMap2.put(obj, r11.b());
            }
            long j11 = 1;
            if (getActivity() instanceof OtcSeaViewRoomActivity) {
                Observable<R> compose = l.l(((g) getUI()).fd(), ((g) getUI()).D0().value, hashMap2).compose(RxJavaHelper.t((u6.g) getUI()));
                if (!z14) {
                    j11 = 0;
                }
                compose.retry(j11).onErrorResumeNext(Observable.just(null)).subscribe(new b(z13, i11, z12, z11));
                return;
            }
            Observable<R> compose2 = Observable.zip(l.l(((g) getUI()).fd(), ((g) getUI()).D0().value, hashMap3), l.l(((g) getUI()).fd(), ((g) getUI()).D0().value, hashMap2), new z(this, i11, z12)).compose(RxJavaHelper.t((u6.g) getUI()));
            if (!z14) {
                j11 = 0;
            }
            compose2.retry(j11).onErrorResumeNext(Observable.just(null)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(z11));
        } else if (getUI() != null) {
            ((g) getUI()).ad(new ArrayList());
        }
    }

    public final void s0() {
        s8.a.a().getAdvertVerifyCapitalConfigs().d(new d((u6.g) getUI()));
    }

    public final void t0(List<Ads> list, List<Ads> list2) {
        if (!CollectionsUtils.b(list2)) {
            Ads ads = list2.get(0);
            ads.setExtraData(list2);
            ads.setTypeHandler(3);
            if (list.size() > 2) {
                list.add(2, ads);
            } else if (list.size() > 0) {
                list.add(list.size(), ads);
            } else {
                list.add(ads);
            }
        }
    }

    /* renamed from: y0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, g gVar) {
        super.onUIReady(baseCoreActivity, gVar);
        OtcModuleConfig.a().T("PM_APP_FIAT_ORDERUNIT");
        s0();
    }

    public final void z0(List list) {
        if (!list.isEmpty() && ((g) getUI()).D0().value.equals("sell")) {
            boolean z11 = false;
            OtcConfigItem.CurrencyBean h11 = va.b.h(String.valueOf(((Ads) list.get(0)).getCurrency()));
            if (h11 != null) {
                Iterator<AdvertVerifyCapitalConfigBean> it2 = this.f79169h.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (h11.getNameShort().toUpperCase().equals(it2.next().getCurrency().toUpperCase())) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z11) {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((Ads) it3.next()).setVerifyCapitalEnabled(z11);
                    }
                }
            }
        }
    }
}
