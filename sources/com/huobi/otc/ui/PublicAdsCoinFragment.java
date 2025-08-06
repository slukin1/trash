package com.huobi.otc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bj.o0;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.otc.core.bean.AdvertVerifyCapitalConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.event.OtcAdModeChangeEvent;
import com.huobi.otc.event.OtcAdPriceChangeEvent;
import com.huobi.otc.event.OtcFollowEvent;
import com.huobi.otc.persenter.PublicAdsFragmentPresenter;
import com.huobi.otc.service.OTCService;
import com.huobi.otc.widget.OtcAdsSkeletonView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jp.b1;
import jp.v1;
import ky.j;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import op.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import sp.a3;
import sp.b3;
import sp.t2;
import sp.u2;
import sp.v2;
import sp.w2;
import sp.x2;
import sp.y2;
import sp.z2;
import u6.g;
import up.h;
import vp.c1;

public class PublicAdsCoinFragment extends BaseFragment<PublicAdsFragmentPresenter, PublicAdsFragmentPresenter.g> implements PublicAdsFragmentPresenter.g, mp.a, a.C0880a, mp.b {
    public boolean A = true;
    public c1 B;
    public Ads C;

    /* renamed from: l  reason: collision with root package name */
    public OtcTradeActivity f79596l;

    /* renamed from: m  reason: collision with root package name */
    public int f79597m = 0;

    /* renamed from: n  reason: collision with root package name */
    public Ads f79598n;

    /* renamed from: o  reason: collision with root package name */
    public OtcTradeType f79599o;

    /* renamed from: p  reason: collision with root package name */
    public double f79600p;

    /* renamed from: q  reason: collision with root package name */
    public int f79601q;

    /* renamed from: r  reason: collision with root package name */
    public String f79602r;

    /* renamed from: s  reason: collision with root package name */
    public EasyRecyclerView f79603s;

    /* renamed from: t  reason: collision with root package name */
    public OtcAdsSkeletonView f79604t;

    /* renamed from: u  reason: collision with root package name */
    public SmartRefreshLayout f79605u;

    /* renamed from: v  reason: collision with root package name */
    public SmartRefreshHeader f79606v;

    /* renamed from: w  reason: collision with root package name */
    public SmartRefreshFooter f79607w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f79608x;

    /* renamed from: y  reason: collision with root package name */
    public LinearLayout f79609y;

    /* renamed from: z  reason: collision with root package name */
    public LoadingLayout f79610z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            SoftInputUtils.f(PublicAdsCoinFragment.this.getActivity());
            return false;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            OtcModuleConfig.a().W(recyclerView, i11 != 0);
        }
    }

    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            PublicAdsCoinFragment.this.Yh();
        }
    }

    public class d implements ny.d {
        public d() {
        }

        public void P8(j jVar) {
            PublicAdsCoinFragment publicAdsCoinFragment = PublicAdsCoinFragment.this;
            if (publicAdsCoinFragment.A) {
                ((PublicAdsFragmentPresenter) publicAdsCoinFragment.yh()).q0(false, false, PublicAdsCoinFragment.this.f79597m);
            } else {
                publicAdsCoinFragment.X0();
            }
            uf.c.b().r("loadmore", "otc.adlist.page.pulltorefresh", new HashMap());
        }

        public void bf(j jVar) {
            PublicAdsCoinFragment publicAdsCoinFragment = PublicAdsCoinFragment.this;
            publicAdsCoinFragment.A = true;
            ((PublicAdsFragmentPresenter) publicAdsCoinFragment.yh()).n0(true, false, false, false, PublicAdsCoinFragment.this.f79597m);
            uf.c.b().r(HBBaseWebActivity.REFRESH_TAG, "otc.adlist.page.pulltorefresh", (HashMap) null);
        }
    }

    public class e extends BaseSubscriber<LegalQueryData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcAdTicket f79615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ads f79616c;

        public e(OtcAdTicket otcAdTicket, Ads ads) {
            this.f79615b = otcAdTicket;
            this.f79616c = ads;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Ads ads, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            OtcModuleConfig.b().T(PublicAdsCoinFragment.this.getActivity(), ads, false, (String) null, (String) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(Ads ads, HBDialogFragment hBDialogFragment) {
            OtcModuleConfig.b().S(PublicAdsCoinFragment.this.getActivity(), ads.getCoinId(), "2", -1);
            hBDialogFragment.dismiss();
        }

        /* renamed from: i */
        public void onNext(LegalQueryData legalQueryData) {
            super.onNext(legalQueryData);
            double unused = PublicAdsCoinFragment.this.f79600p = m.h0(legalQueryData.getAvaialAble());
            if (PublicAdsCoinFragment.this.f79600p > 0.0d) {
                if (m.a(this.f79615b.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(this.f79615b.getPrice()).compareTo(m.a(this.f79616c.getPrice())) == 0) {
                    OtcModuleConfig.b().T(PublicAdsCoinFragment.this.getActivity(), this.f79616c, false, (String) null, (String) null);
                    return;
                }
                PublicAdsCoinFragment.this.Lh(this.f79616c, this.f79615b);
                DialogUtils.c0(PublicAdsCoinFragment.this.getActivity(), PublicAdsCoinFragment.this.getContext().getString(R$string.otc_price_change_tip), "", PublicAdsCoinFragment.this.getContext().getString(R$string.otc_ppace_order_dialog_btn_cancel), PublicAdsCoinFragment.this.getContext().getString(R$string.otc_ppace_order_dialog_btn_continue), b3.f25999a, new y2(this, this.f79616c));
                return;
            }
            DialogUtils.c0(PublicAdsCoinFragment.this.getActivity(), BaseApplication.b().getResources().getString(R$string.otc_sell_transfer_hint_dialog_content), (String) null, BaseApplication.b().getResources().getString(R$string.otc_sell_transfer_dialog_cancle), BaseApplication.b().getResources().getString(R$string.otc_sell_transfer_dialog), a3.f25994a, new z2(this, this.f79616c));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Void voidR) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (OtcModuleConfig.a().a()) {
            OtcModuleConfig.b().X(activity);
        } else {
            OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rh(Ads ads, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcModuleConfig.b().T(getActivity(), ads, false, (String) null, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sh(Long l11) {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof OtcTradeActivity) && !activity.isFinishing()) {
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) activity;
            if (otcTradeActivity.Ed() == OtcTradeAreaEnum.FREE_AREA) {
                h.k(otcTradeActivity, true);
            }
        }
    }

    public static PublicAdsCoinFragment Th(int i11, OtcTradeType otcTradeType, String str, int i12) {
        PublicAdsCoinFragment publicAdsCoinFragment = new PublicAdsCoinFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("coinID", i11);
        bundle.putString("coinName", str);
        bundle.putString("tradeType", otcTradeType.toString());
        bundle.putInt("listType", i12);
        publicAdsCoinFragment.setArguments(bundle);
        return publicAdsCoinFragment;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(com.hbg.lite.R$string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            if (va.b.o().r() != null) {
                this.f79610z.g();
                ((PublicAdsFragmentPresenter) yh()).r0(true, true, false, false, this.f79597m);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void Ah() {
        super.Ah();
        this.f79610z.setOnRetryClickListener(new t2(this));
        TextView textView = (TextView) this.f79610z.findViewById(R$id.empty_recharge_tv);
        if (textView != null) {
            textView.setTextColor(v1.b());
            textView.setBackgroundResource(R$drawable.otc_ads_empty_btn_bg);
            dw.a.a(textView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new x2(this));
        }
        this.f79605u.e0(new d());
        EventBus.d().p(this);
    }

    public OtcTradeType D0() {
        return this.f79599o;
    }

    public void Jb() {
        if (this.f79604t == null) {
            this.f79604t = (OtcAdsSkeletonView) this.f67460i.b(R$id.otc_ads_skeleton_view);
        }
        OtcAdsSkeletonView otcAdsSkeletonView = this.f79604t;
        if (otcAdsSkeletonView != null && otcAdsSkeletonView.getVisibility() == 0) {
            this.f79604t.b();
        }
    }

    public final void Lh(Ads ads, OtcAdTicket otcAdTicket) {
        OtcAdPriceChangeEvent otcAdPriceChangeEvent = new OtcAdPriceChangeEvent();
        otcAdPriceChangeEvent.advertId = ads.getId();
        otcAdPriceChangeEvent.price = otcAdTicket.getPrice();
        onAdPriceChange(otcAdPriceChangeEvent);
    }

    /* renamed from: Mh */
    public PublicAdsFragmentPresenter xh() {
        return new PublicAdsFragmentPresenter();
    }

    /* JADX WARNING: type inference failed for: r1v18, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Nh(com.huobi.otc.bean.Ads r7) {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.hbg.bean.OtcTradeType r1 = r6.f79599o
            com.hbg.bean.OtcTradeType r2 = com.hbg.bean.OtcTradeType.BUY
            java.lang.String r3 = "sell"
            java.lang.String r4 = "buy"
            if (r1 != r2) goto L_0x0011
            r1 = r3
            goto L_0x0012
        L_0x0011:
            r1 = r4
        L_0x0012:
            java.lang.String r5 = "side"
            r0.put(r5, r1)
            if (r7 == 0) goto L_0x0026
            int r1 = r7.getCoinId()
            java.lang.String r1 = va.b.g(r1)
            java.lang.String r5 = "coin_name"
            r0.put(r5, r1)
        L_0x0026:
            com.hbg.bean.OtcTradeType r1 = r6.f79599o
            if (r1 != r2) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            java.lang.String r1 = "coinId"
            r0.put(r1, r3)
            boolean r1 = r7.isTrade()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r3 = "isTrade"
            r0.put(r3, r1)
            uf.c r1 = uf.c.b()
            com.hbg.bean.OtcTradeType r3 = r6.f79599o
            if (r3 != r2) goto L_0x0049
            java.lang.String r2 = "otc.adlist.page.sell"
            goto L_0x004b
        L_0x0049:
            java.lang.String r2 = "otc.adlist.page.buy"
        L_0x004b:
            java.lang.String r3 = "click_quote"
            r1.r(r3, r2, r0)
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            if (r0 != 0) goto L_0x0057
            return
        L_0x0057:
            uf.a r1 = com.hbg.module.otc.OtcModuleConfig.a()
            boolean r1 = r1.a()
            r2 = 0
            if (r1 != 0) goto L_0x006a
            uf.a r7 = com.hbg.module.otc.OtcModuleConfig.a()
            r7.l(r0, r2, r2)
            return
        L_0x006a:
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            boolean r1 = r1 instanceof com.huobi.otc.ui.OtcTradeActivity
            if (r1 == 0) goto L_0x007a
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            r2 = r1
            com.huobi.otc.ui.OtcTradeActivity r2 = (com.huobi.otc.ui.OtcTradeActivity) r2
            goto L_0x008d
        L_0x007a:
            oa.a r1 = oa.a.g()
            java.lang.Class<com.huobi.otc.ui.OtcTradeActivity> r3 = com.huobi.otc.ui.OtcTradeActivity.class
            android.app.Activity r1 = r1.f(r3)
            if (r1 == 0) goto L_0x008d
            boolean r3 = r1 instanceof com.huobi.otc.ui.OtcTradeActivity
            if (r3 == 0) goto L_0x008d
            r2 = r1
            com.huobi.otc.ui.OtcTradeActivity r2 = (com.huobi.otc.ui.OtcTradeActivity) r2
        L_0x008d:
            if (r2 == 0) goto L_0x0119
            boolean r1 = r2.isFinishing()
            if (r1 == 0) goto L_0x0097
            goto L_0x0119
        L_0x0097:
            com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData r1 = r2.Wh()
            com.huobi.account.entity.OTCKycInfo r2 = r2.Oh()
            if (r1 == 0) goto L_0x00ad
            java.lang.String r3 = r1.getPhone()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ad
            r3 = 1
            goto L_0x00ae
        L_0x00ad:
            r3 = 0
        L_0x00ae:
            boolean r4 = r7.isNeedKyc()
            if (r4 == 0) goto L_0x00bc
            if (r2 == 0) goto L_0x00bc
            int r4 = r2.getStatus()
            if (r4 == 0) goto L_0x00cb
        L_0x00bc:
            boolean r4 = r7.isNeedAdvancedKyc()
            if (r4 == 0) goto L_0x00d7
            if (r2 == 0) goto L_0x00d7
            int r2 = r2.getStatus()
            r4 = 2
            if (r2 == r4) goto L_0x00d7
        L_0x00cb:
            jp.f0 r7 = jp.f0.a()
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            r7.e(r0)
            return
        L_0x00d7:
            boolean r2 = r7.isNeedBindPhoneNum()
            if (r2 == 0) goto L_0x0104
            if (r3 != 0) goto L_0x0104
            if (r1 == 0) goto L_0x0104
            java.lang.String r2 = r1.getPhone()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0104
            vp.c1 r7 = r6.B
            if (r7 != 0) goto L_0x00fe
            vp.c1 r7 = new vp.c1
            android.content.Context r0 = r6.getContext()
            androidx.fragment.app.FragmentManager r2 = r6.getFragmentManager()
            r7.<init>(r0, r6, r2)
            r6.B = r7
        L_0x00fe:
            vp.c1 r7 = r6.B
            r7.G(r1)
            return
        L_0x0104:
            boolean r1 = r7.hasEnablePay()
            if (r1 == 0) goto L_0x0114
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r6.yh()
            com.huobi.otc.persenter.PublicAdsFragmentPresenter r1 = (com.huobi.otc.persenter.PublicAdsFragmentPresenter) r1
            r1.p0(r0, r7)
            goto L_0x0119
        L_0x0114:
            int r7 = com.hbg.module.otc.R$string.otc_order_detail_pay_method_not_support
            com.hbg.lib.widgets.utils.HuobiToastUtil.g(r7)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.ui.PublicAdsCoinFragment.Nh(com.huobi.otc.bean.Ads):void");
    }

    public void O9() {
        ((PublicAdsFragmentPresenter) yh()).n0(true, true, true, true, this.f79597m);
    }

    /* renamed from: Oh */
    public PublicAdsFragmentPresenter.g zh() {
        return this;
    }

    public void Rc(boolean z11) {
        this.f79610z.g();
        this.f79604t.setVisibility(8);
        this.f79604t.c();
        this.f79605u.finishRefresh();
        this.f79605u.w();
        if (z11) {
            this.f79605u.setNoMoreData(false);
        }
        this.f79606v.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
    }

    public void Ta(Ads ads) {
        if (yh() != null) {
            ((PublicAdsFragmentPresenter) yh()).m0(ads);
        }
    }

    public final void Uh(long j11, boolean z11, boolean z12) {
        boolean z13 = z12;
        EasyRecyclerView easyRecyclerView = this.f79603s;
        if (easyRecyclerView != null && easyRecyclerView.getAdapter() != null) {
            List dataList = this.f79603s.getDataList();
            if (!CollectionsUtils.b(dataList)) {
                for (int i11 = 0; i11 < dataList.size(); i11++) {
                    s9.a aVar = (s9.a) dataList.get(i11);
                    if (aVar instanceof Ads) {
                        Ads ads = (Ads) aVar;
                        if (ads.getTypeHandler() == 3) {
                            Xh(j11, z11, z12, aVar, dataList, false);
                            List<Ads> extraData = ads.getExtraData();
                            if (!CollectionsUtils.b(extraData)) {
                                for (int i12 = 0; i12 < extraData.size(); i12++) {
                                    Ads ads2 = extraData.get(i12);
                                    if (ads2.getUid() == j11) {
                                        if (z11) {
                                            ads2.setFollowed(z13);
                                            ads2.setShield(false);
                                            ads2.setShieldChange(false);
                                        } else {
                                            ads2.setShield(z13);
                                            ads2.setFollowed(false);
                                            ads2.setShieldChange(true);
                                        }
                                    }
                                }
                            }
                            this.f79603s.getAdapter().notifyItemChanged(dataList.indexOf(aVar), aVar);
                        } else {
                            Xh(j11, z11, z12, aVar, dataList, true);
                        }
                    }
                }
            }
        }
    }

    public void Vh() {
        op.a.r(this.f79597m).B(this);
    }

    public void Wh() {
        if (this.f79603s != null) {
            if (b1.h().j()) {
                EasyRecyclerView easyRecyclerView = this.f79603s;
                easyRecyclerView.setPadding(easyRecyclerView.getPaddingLeft(), this.f79603s.getPaddingTop(), this.f79603s.getPaddingRight(), UIUtil.a(getContext(), 99.0d));
            } else {
                EasyRecyclerView easyRecyclerView2 = this.f79603s;
                easyRecyclerView2.setPadding(easyRecyclerView2.getPaddingLeft(), this.f79603s.getPaddingTop(), this.f79603s.getPaddingRight(), 0);
            }
            this.f79603s.setClipToPadding(false);
        }
    }

    public void X0() {
        this.A = false;
        this.f79605u.w();
        this.f79605u.setNoMoreData(true);
    }

    public final void Xh(long j11, boolean z11, boolean z12, s9.a aVar, List<s9.a> list, boolean z13) {
        Ads ads = (Ads) aVar;
        if (ads.getUid() == j11) {
            if (z11) {
                ads.setFollowed(z12);
                ads.setShield(false);
                ads.setShieldChange(false);
            } else {
                ads.setShield(z12);
                ads.setFollowed(false);
                ads.setShieldChange(true);
            }
            if (z13) {
                this.f79603s.getAdapter().notifyItemChanged(list.indexOf(aVar), aVar);
            }
        }
    }

    public RecyclerView Y0() {
        return this.f79603s;
    }

    public void Yh() {
        EasyRecyclerView easyRecyclerView;
        LinearLayoutManager linearLayoutManager;
        if (this.f67463e && (easyRecyclerView = this.f79603s) != null && easyRecyclerView.getAdapter() != null && (linearLayoutManager = (LinearLayoutManager) this.f79603s.getLayoutManager()) != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            FragmentActivity activity = getActivity();
            if (findFirstVisibleItemPosition >= 2) {
                if (activity instanceof up.a) {
                    ((up.a) activity).aa(true);
                }
            } else if (activity instanceof up.a) {
                ((up.a) activity).aa(false);
            }
        }
    }

    public void aa(Ads ads) {
        Nh(ads);
    }

    public void ad(List<s9.a> list) {
        ArrayList<s9.a> arrayList = new ArrayList<>(list.size());
        if (CollectionsUtils.b(list)) {
            this.f79610z.i();
            return;
        }
        Ads ads = (Ads) list.get(0);
        if (list.size() != 1 || ads.getOtcOneKeyBuyConfig() == null || !ads.getOtcOneKeyBuyConfig().isShowEmptyPic()) {
            arrayList.addAll(list);
            for (s9.a aVar : arrayList) {
                Ads ads2 = (Ads) aVar;
                ads2.setListener(this);
                ads2.setOnClickOneKeyToBuyListener(this);
            }
            this.f79603s.setData(arrayList);
            this.f79610z.g();
        } else {
            this.f79610z.i();
        }
        Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(new w2(this)));
    }

    public void d9(Ads ads) {
        String str;
        if (getActivity() != null) {
            if (ads.getTradeType() == OtcTradeType.BUY) {
                str = StringUtils.d(getActivity().getString(R$string.n_otc_trade_sell_limit_time_tip), String.valueOf(ads.getPayTerm()));
            } else {
                str = StringUtils.d(getActivity().getString(R$string.n_otc_trade_buy_limit_time_tip), String.valueOf(ads.getPayTerm()));
            }
            DialogUtils.Y(getActivity(), str, "", getActivity().getString(R$string.n_dialog_ok), o0.f12469a);
        }
    }

    public LoadingLayout f6() {
        return this.f79610z;
    }

    public int fd() {
        return this.f79601q;
    }

    public void hd() {
        OtcAdsSkeletonView otcAdsSkeletonView = this.f79604t;
        if (otcAdsSkeletonView != null && otcAdsSkeletonView.getVisibility() == 0) {
            this.f79604t.c();
        }
    }

    public void initViews() {
        super.initViews();
        String string = getArguments().getString("tradeType");
        this.f79601q = getArguments().getInt("coinID");
        this.f79602r = getArguments().getString("coinName");
        boolean z11 = false;
        this.f79597m = getArguments().getInt("listType", 0);
        this.f79599o = OtcTradeType.parseFromValue(string);
        this.f79603s = (EasyRecyclerView) this.f67460i.b(R$id.list_view);
        this.f79605u = (SmartRefreshLayout) this.f67460i.b(R$id.public_ads_ptr);
        this.f79610z = (LoadingLayout) this.f67460i.b(R$id.otc_order_loading_layout);
        this.f79604t = (OtcAdsSkeletonView) this.f67460i.b(R$id.otc_ads_skeleton_view);
        this.f79605u.V(false);
        this.f79605u.f(true);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getContext());
        this.f79606v = smartRefreshHeader;
        this.f79605u.j0(smartRefreshHeader);
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getContext());
        this.f79607w = smartRefreshFooter;
        this.f79605u.h0(smartRefreshFooter);
        LoadingLayout loadingLayout = this.f79610z;
        if (loadingLayout != null) {
            this.f79608x = (TextView) loadingLayout.findViewById(R$id.ads_empty_tv);
            this.f79609y = (LinearLayout) this.f79610z.findViewById(R$id.ads_empty_to_deposit_ll);
            TextView textView = this.f79608x;
            OtcTradeType otcTradeType = this.f79599o;
            OtcTradeType otcTradeType2 = OtcTradeType.BUY;
            ViewUtil.m(textView, otcTradeType == otcTradeType2);
            LinearLayout linearLayout = this.f79609y;
            if (this.f79599o != otcTradeType2) {
                z11 = true;
            }
            ViewUtil.m(linearLayout, z11);
            TextView textView2 = (TextView) this.f79610z.findViewById(R$id.viewErrorRetry);
            ImageView imageView = (ImageView) this.f79610z.findViewById(R$id.error_img);
            if (textView2 != null) {
                textView2.setTextColor(v1.b());
            }
            if (imageView != null) {
                imageView.setImageResource(R$drawable.common_no_network_icon);
            }
        }
        this.f79603s.setOnTouchListener(new a());
        ((ImageView) this.f79610z.findViewById(R$id.id_ads_empty_iv)).setImageResource(R$drawable.home_buy_empty_image);
        if (getActivity() instanceof OtcTradeActivity) {
            this.f79596l = (OtcTradeActivity) getActivity();
        }
        if (this.f79596l != null) {
            this.f79603s.addOnScrollListener(new b());
        }
        this.f79603s.addOnScrollListener(new c());
        Wh();
    }

    public void j4(int i11, String str, boolean z11) {
        ((PublicAdsFragmentPresenter) yh()).n0(true, true, true, false, i11);
    }

    public void l7(Ads ads) {
        if (getActivity() instanceof OtcTradeActivity) {
            ((OtcTradeActivity) getActivity()).yi(ads.getId(), !ads.getTradeType().isBuy() ? 1 : 0, ads.getPrice(), va.b.k(ads.getCurrency()), va.b.g(ads.getCoinId()));
        } else if (getActivity() instanceof OtcSeaViewRoomActivity) {
            ((OtcSeaViewRoomActivity) getActivity()).qh(ads.getId(), !ads.getTradeType().isBuy() ? 1 : 0, ads.getPrice(), va.b.k(ads.getCurrency()), va.b.g(ads.getCoinId()));
        }
    }

    public void m0() {
        this.f79605u.finishRefresh();
        this.f79605u.w();
        this.f79604t.setVisibility(8);
        this.f79604t.c();
        this.f79610z.k();
    }

    public void nb(long j11) {
        OtcFollowEvent otcFollowEvent = new OtcFollowEvent();
        HashMap hashMap = new HashMap();
        hashMap.put("uid", String.valueOf(j11));
        hashMap.put("type", "follow");
        hashMap.put("relationStatus", "on");
        otcFollowEvent.params = hashMap;
        otcFollowEvent.object = this;
        Uh(j11, true, true);
        EventBus.d().k(otcFollowEvent);
        HuobiToastUtil.p(R$string.n_title_operate_success);
    }

    public void o9(Map<String, Object> map, Ads ads) {
        this.f79598n = ads;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAdModeChange(OtcAdModeChangeEvent otcAdModeChangeEvent) {
        if (zh() != null && zh().isAlive()) {
            Wh();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAdPriceChange(OtcAdPriceChangeEvent otcAdPriceChangeEvent) {
        EasyRecyclerView easyRecyclerView;
        if (zh() != null && zh().isAlive() && (easyRecyclerView = this.f79603s) != null && easyRecyclerView.getAdapter() != null) {
            List dataList = this.f79603s.getDataList();
            if (!CollectionsUtils.b(dataList)) {
                for (int i11 = 0; i11 < dataList.size(); i11++) {
                    s9.a aVar = (s9.a) dataList.get(i11);
                    if (aVar instanceof Ads) {
                        Ads ads = (Ads) aVar;
                        if (TextUtils.equals(ads.getId(), otcAdPriceChangeEvent.advertId)) {
                            ads.setPrice(otcAdPriceChangeEvent.price);
                            this.f79603s.getAdapter().notifyItemChanged(dataList.indexOf(aVar), aVar);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        op.a.r(this.f79597m).P(this);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onFollow(OtcFollowEvent otcFollowEvent) {
        if (otcFollowEvent.params != null && otcFollowEvent.object != this && zh() != null && zh().isAlive()) {
            Long valueOf = Long.valueOf(otcFollowEvent.params.get("uid"));
            String str = otcFollowEvent.params.get("type");
            String str2 = otcFollowEvent.params.get("relationStatus");
            if ("shield".equalsIgnoreCase(str)) {
                Uh(valueOf.longValue(), false, "on".equalsIgnoreCase(str2));
            } else if ("follow".equalsIgnoreCase(str)) {
                Uh(valueOf.longValue(), true, "on".equalsIgnoreCase(str2));
            }
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.activity_otc_public_page_child, viewGroup, false);
    }

    public void q6(Ads ads) {
        String k11;
        String str;
        if (getActivity() != null && ads.getVerifyCapitalStatus() == 1 && (k11 = va.b.k(ads.getCurrency())) != null && k11.length() != 0) {
            Iterator<AdvertVerifyCapitalConfigBean> it2 = ((PublicAdsFragmentPresenter) yh()).f79169h.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = "";
                    break;
                }
                AdvertVerifyCapitalConfigBean next = it2.next();
                if (k11.toUpperCase().equals(next.getCurrency().toUpperCase())) {
                    str = next.getOrderAmount();
                    break;
                }
            }
            if (k11.toUpperCase().equals("USD01")) {
                k11 = "USD";
            }
            if (k11.length() > 0 && str.length() > 0) {
                DialogUtils.X(getActivity(), getActivity().getString(R$string.n_otc_advert_verify_capital_title), (CharSequence) null, getActivity().getString(R$string.n_otc_advert_verify_capital_subtitle).replace("{{0}}", str).replace("{{1}}", k11.toUpperCase()), getActivity().getString(R$string.n_otc_know), o0.f12469a);
            }
        }
    }

    public void qe(Ads ads) {
        EasyRecyclerView easyRecyclerView = this.f79603s;
        if (easyRecyclerView != null && easyRecyclerView.getAdapter() != null) {
            List dataList = this.f79603s.getDataList();
            if (!CollectionsUtils.b(dataList)) {
                Ads ads2 = this.C;
                if (ads2 == ads) {
                    ads.setExpand(!ads2.isExpand());
                    this.f79603s.getAdapter().notifyItemChanged(dataList.indexOf(ads), ads);
                    return;
                }
                for (int i11 = 0; i11 < dataList.size(); i11++) {
                    s9.a aVar = (s9.a) dataList.get(i11);
                    if (aVar instanceof Ads) {
                        if (aVar == ads) {
                            this.C = ads;
                            ((Ads) aVar).setExpand(true);
                            this.f79603s.getAdapter().notifyItemChanged(dataList.indexOf(aVar), ads);
                        } else {
                            Ads ads3 = (Ads) aVar;
                            if (ads3.isExpand()) {
                                ads3.setExpand(false);
                                this.f79603s.getAdapter().notifyItemChanged(dataList.indexOf(aVar), aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void sd(TradeReMarkBean tradeReMarkBean, Ads ads, OtcAdTicket otcAdTicket, List<Coupon> list) {
        Ads ads2 = ads;
        OtcAdTicket otcAdTicket2 = otcAdTicket;
        if (this.f79599o == OtcTradeType.BUY) {
            ((OTCService) OtcRetrofit.request(OTCService.class)).getWalletByCoinId(this.f79601q).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((g) null)).subscribe(new e(otcAdTicket2, ads2));
            return;
        }
        if (m.a(otcAdTicket.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(otcAdTicket.getPrice()).compareTo(m.a(ads.getPrice())) == 0) {
            OtcModuleConfig.b().T(getActivity(), ads, false, (String) null, (String) null);
            return;
        }
        Lh(ads2, otcAdTicket2);
        DialogUtils.c0(getActivity(), getContext().getString(R$string.otc_price_change_tip), "", getContext().getString(R$string.otc_ppace_order_dialog_btn_cancel), getContext().getString(R$string.otc_ppace_order_dialog_btn_continue), v2.f26102a, new u2(this, ads2));
    }

    public void sg(boolean z11) {
        if (z11) {
            this.f79610z.p();
            return;
        }
        this.f79610z.g();
        if (this.f79604t == null) {
            this.f79604t = (OtcAdsSkeletonView) this.f67460i.b(R$id.otc_ads_skeleton_view);
        }
        OtcAdsSkeletonView otcAdsSkeletonView = this.f79604t;
        if (otcAdsSkeletonView != null) {
            otcAdsSkeletonView.setVisibility(0);
            this.f79604t.b();
        }
    }

    public SmartRefreshLayout t2() {
        return this.f79605u;
    }

    public void th(boolean z11) {
        super.th(z11);
        if (!z11) {
            SoftInputUtils.f(getActivity());
            return;
        }
        Vh();
        EasyRecyclerView easyRecyclerView = this.f79603s;
        if (easyRecyclerView != null && CollectionsUtils.b(easyRecyclerView.getDataList())) {
            O9();
        }
    }
}
