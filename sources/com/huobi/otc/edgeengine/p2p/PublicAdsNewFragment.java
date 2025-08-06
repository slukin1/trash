package com.huobi.otc.edgeengine.p2p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lite.enums.TradeSide;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huochat.community.util.JsonTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jp.v1;
import lp.e;
import pro.huobi.R;
import rx.Observable;
import u6.g;

public class PublicAdsNewFragment extends BaseFragment<PublicAdsNewPresenter, g> {

    /* renamed from: l  reason: collision with root package name */
    public FrameLayout f78371l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f78372m;

    /* renamed from: n  reason: collision with root package name */
    public int f78373n;

    /* renamed from: o  reason: collision with root package name */
    public List<String> f78374o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<String> f78375p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public boolean f78376q = true;

    /* renamed from: r  reason: collision with root package name */
    public String f78377r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f78378s;

    /* renamed from: t  reason: collision with root package name */
    public mp.c f78379t;

    /* renamed from: u  reason: collision with root package name */
    public rj.b f78380u;

    /* renamed from: v  reason: collision with root package name */
    public RecyclerView f78381v;

    /* renamed from: w  reason: collision with root package name */
    public List<OtcTradeConfigListBean.CryptoAsset> f78382w;

    /* renamed from: x  reason: collision with root package name */
    public List<OtcTradeConfigListBean.CryptoAsset> f78383x;

    /* renamed from: y  reason: collision with root package name */
    public String f78384y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f78385z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            SoftInputUtils.f(PublicAdsNewFragment.this.getActivity());
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
            PublicAdsNewFragment.this.Yh();
        }
    }

    public class d extends EasySubscriber<Pair<List<OtcTradeConfigListBean>, List<OtcTradeConfigListBean>>> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(Pair<List<OtcTradeConfigListBean>, List<OtcTradeConfigListBean>> pair) {
            List<String> list;
            super.onNext(pair);
            String c11 = up.g.c(PublicAdsNewFragment.this.f78373n == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
            String unused = PublicAdsNewFragment.this.f78384y = c11;
            List unused2 = PublicAdsNewFragment.this.f78382w = nb.g.j().h(v1.c(PublicAdsNewFragment.this.f78373n), TradeSide.buy, c11);
            List unused3 = PublicAdsNewFragment.this.f78383x = nb.g.j().h(v1.c(PublicAdsNewFragment.this.f78373n), TradeSide.sell, c11);
            PublicAdsNewFragment.this.f78374o.clear();
            PublicAdsNewFragment.this.f78375p.clear();
            if (!CollectionsUtils.b(PublicAdsNewFragment.this.f78382w)) {
                for (int i11 = 0; i11 < PublicAdsNewFragment.this.f78382w.size(); i11++) {
                    OtcTradeConfigListBean.CryptoAsset cryptoAsset = (OtcTradeConfigListBean.CryptoAsset) PublicAdsNewFragment.this.f78382w.get(i11);
                    if (cryptoAsset != null) {
                        PublicAdsNewFragment.this.f78374o.add(cryptoAsset.getName().toUpperCase(Locale.US));
                    }
                }
            }
            if (!CollectionsUtils.b(PublicAdsNewFragment.this.f78383x)) {
                for (int i12 = 0; i12 < PublicAdsNewFragment.this.f78383x.size(); i12++) {
                    OtcTradeConfigListBean.CryptoAsset cryptoAsset2 = (OtcTradeConfigListBean.CryptoAsset) PublicAdsNewFragment.this.f78383x.get(i12);
                    if (cryptoAsset2 != null) {
                        PublicAdsNewFragment.this.f78375p.add(cryptoAsset2.getName().toUpperCase(Locale.US));
                    }
                }
            }
            List list2 = null;
            if (!(PublicAdsNewFragment.this.getActivity() instanceof OtcTradeActivity)) {
                list = null;
            } else if (((OtcTradeActivity) PublicAdsNewFragment.this.getActivity()).getTradePosition() <= 0) {
                list2 = PublicAdsNewFragment.this.f78382w;
                list = PublicAdsNewFragment.this.f78374o;
            } else {
                list2 = PublicAdsNewFragment.this.f78383x;
                list = PublicAdsNewFragment.this.f78375p;
            }
            FragmentActivity activity = PublicAdsNewFragment.this.getActivity();
            if (activity instanceof up.a) {
                ((up.a) activity).aa(false);
            }
            PublicAdsNewFragment.this.Rh(list2, list);
            boolean unused4 = PublicAdsNewFragment.this.f78378s = false;
        }

        public void onCompleted() {
            super.onCompleted();
            boolean unused = PublicAdsNewFragment.this.f78378s = false;
        }

        public void onError2(Throwable th2) {
            boolean unused = PublicAdsNewFragment.this.f78378s = false;
            PublicAdsNewFragment.this.bi(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            boolean unused = PublicAdsNewFragment.this.f78378s = false;
            PublicAdsNewFragment.this.bi(false);
        }
    }

    public static /* synthetic */ Pair Th(List list, List list2) {
        return new Pair(list, list2);
    }

    /* renamed from: Lh */
    public PublicAdsNewPresenter xh() {
        return new PublicAdsNewPresenter();
    }

    public void Mh() {
        RecyclerView recyclerView = this.f78381v;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public rj.b Nh() {
        OtcMainNewFragment Ph;
        if (this.f78380u == null && (Ph = Ph()) != null) {
            this.f78380u = Ph.Mh();
        }
        return this.f78380u;
    }

    public mp.c Oh() {
        return this.f78379t;
    }

    public final OtcMainNewFragment Ph() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OtcMainNewFragment) {
            return (OtcMainNewFragment) parentFragment;
        }
        return null;
    }

    /* renamed from: Qh */
    public g zh() {
        return this;
    }

    public final void Rh(List<OtcTradeConfigListBean.CryptoAsset> list, List<String> list2) {
        int i11 = 0;
        if (!CollectionsUtils.b(list)) {
            bi(true);
            int indexOf = (TextUtils.isEmpty(this.f78377r) || !list2.contains(this.f78377r)) ? -1 : list2.indexOf(this.f78377r);
            if (getActivity() instanceof OtcTradeActivity) {
                int fd2 = ((OtcTradeActivity) getActivity()).fd();
                if (fd2 != (TextUtils.isEmpty(this.f78377r) ? va.b.e(this.f78377r) : -1)) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (va.b.e(list.get(i12).getName()) == fd2) {
                            indexOf = i12;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
            }
            if (indexOf != -1) {
                i11 = indexOf;
            }
            this.f78377r = list2.get(i11);
            Wh(list, i11);
            return;
        }
        bi(false);
    }

    public boolean Sh() {
        return this.f78385z;
    }

    public void Uh(String str) {
        List<OtcTradeConfigListBean.CryptoAsset> list;
        List<OtcTradeConfigListBean.CryptoAsset> list2;
        List<String> list3;
        if (getActivity() instanceof OtcTradeActivity) {
            int Sh = ((OtcTradeActivity) getActivity()).Sh();
            int tradePosition = ((OtcTradeActivity) getActivity()).getTradePosition();
            if (Sh == this.f78373n) {
                List<String> list4 = null;
                if (getActivity() instanceof OtcTradeActivity) {
                    if (tradePosition <= 0) {
                        list2 = this.f78382w;
                        list3 = this.f78374o;
                    } else {
                        list2 = this.f78383x;
                        list3 = this.f78375p;
                    }
                    List<OtcTradeConfigListBean.CryptoAsset> list5 = list2;
                    list4 = list3;
                    list = list5;
                } else {
                    list = null;
                }
                int i11 = 0;
                while (i11 < list4.size()) {
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(list4.get(i11))) {
                        i11++;
                    } else {
                        Wh(list, i11);
                        i6.d.j("updateTradingPairs", "PublicAdsNewFragment --onSelectCoinName--siteType> " + this.f78373n + "tradePosition" + tradePosition + " coinName->" + str + "i:" + i11);
                        return;
                    }
                }
            }
        }
    }

    public final void Vh(int i11) {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof e)) {
            ((e) activity).X5(i11);
        }
    }

    public final void Wh(List<OtcTradeConfigListBean.CryptoAsset> list, int i11) {
        OtcTradeConfigListBean.CryptoAsset cryptoAsset = list.get(i11);
        int e11 = va.b.e(String.valueOf(cryptoAsset.getName()));
        Vh(e11);
        di(cryptoAsset.getName(), e11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (android.view.ViewGroup) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Xh(android.view.View r5) {
        /*
            r4 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r4.f78381v
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r5 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0059
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r0 = r5.getChildCount()
            if (r0 <= 0) goto L_0x0059
            r1 = 0
        L_0x0012:
            if (r1 >= r0) goto L_0x0059
            androidx.recyclerview.widget.RecyclerView r2 = r4.f78381v
            if (r2 == 0) goto L_0x0019
            return
        L_0x0019:
            android.view.View r2 = r5.getChildAt(r1)
            boolean r3 = r2 instanceof androidx.recyclerview.widget.RecyclerView
            if (r3 == 0) goto L_0x0053
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            r4.f78381v = r2
            com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$a r5 = new com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$a
            r5.<init>()
            r2.setOnTouchListener(r5)
            r5 = 0
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r0 = r0 instanceof com.huobi.otc.ui.OtcTradeActivity
            if (r0 == 0) goto L_0x003c
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            com.huobi.otc.ui.OtcTradeActivity r5 = (com.huobi.otc.ui.OtcTradeActivity) r5
        L_0x003c:
            if (r5 == 0) goto L_0x0048
            androidx.recyclerview.widget.RecyclerView r5 = r4.f78381v
            com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$b r0 = new com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$b
            r0.<init>()
            r5.addOnScrollListener(r0)
        L_0x0048:
            androidx.recyclerview.widget.RecyclerView r5 = r4.f78381v
            com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$c r0 = new com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment$c
            r0.<init>()
            r5.addOnScrollListener(r0)
            return
        L_0x0053:
            r4.Xh(r2)
            int r1 = r1 + 1
            goto L_0x0012
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.edgeengine.p2p.PublicAdsNewFragment.Xh(android.view.View):void");
    }

    public void Yh() {
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        if (this.f67463e && (recyclerView = this.f78381v) != null && recyclerView.getAdapter() != null && (linearLayoutManager = (LinearLayoutManager) this.f78381v.getLayoutManager()) != null) {
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

    public void Zh(int i11) {
        List<OtcTradeConfigListBean.CryptoAsset> list;
        List<String> list2;
        if (i11 <= 0) {
            list = this.f78382w;
            list2 = this.f78374o;
        } else {
            list = this.f78383x;
            list2 = this.f78375p;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof up.a) {
            ((up.a) activity).aa(false);
        }
        Rh(list, list2);
    }

    public void ai(int i11, String str) {
        List<OtcTradeConfigListBean.CryptoAsset> list;
        List<String> list2;
        if (i11 <= 0) {
            list = this.f78382w;
            list2 = this.f78374o;
        } else {
            list = this.f78383x;
            list2 = this.f78375p;
        }
        int i12 = 0;
        if (!CollectionsUtils.b(list)) {
            bi(true);
            int indexOf = (TextUtils.isEmpty(str) || !list2.contains(str)) ? -1 : list2.indexOf(str);
            if (indexOf != -1) {
                i12 = indexOf;
            }
            this.f78377r = list2.get(i12);
            Wh(list, i12);
            return;
        }
        bi(false);
    }

    public final void bi(boolean z11) {
        if (z11) {
            this.f78372m.g();
        } else {
            this.f78372m.i();
        }
    }

    public final void ci(String str) {
        if (this.f78378s || (!TextUtils.isEmpty(str) && str.equals(this.f78384y))) {
            i6.d.j("updateP2pList", "updateIndicator-- siteType>" + this.f78373n + " quoteName->" + str + " mQuoteName:" + this.f78384y + " " + toString());
            return;
        }
        this.f78378s = true;
        Observable.zip(nb.g.j().g(v1.c(this.f78373n), TradeSide.buy, true), nb.g.j().g(v1.c(this.f78373n), TradeSide.sell, true), ep.d.f54403b).compose(RxJavaHelper.t(this)).subscribe(new d());
    }

    public final void di(String str, int i11) {
        String c11 = up.g.c(this.f78373n == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
        if (this.f78380u != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("coinName", str);
            hashMap.put("coinId", Integer.valueOf(i11));
            i6.d.j("updateP2pList", "updateTradingPairs--updateTradeList siteType>" + this.f78373n + " coinName->" + str + " currency:" + c11 + " " + toString());
            rj.b bVar = this.f78380u;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateP2pList(");
            sb2.append(JsonTool.toJSONString(hashMap));
            sb2.append(")");
            bVar.I(sb2.toString());
        }
    }

    public void initViews() {
        View view;
        super.initViews();
        this.f78373n = getArguments().getInt("siteType");
        this.f78371l = (FrameLayout) this.f67460i.b(R.id.fl_content);
        this.f78372m = (LoadingLayout) this.f67460i.b(R.id.loading_layout);
        this.f78380u = Nh();
        if (this.f78371l.getChildCount() == 0) {
            if (this.f78373n == 0) {
                view = this.f78380u.D("brand_advert_list.xml", getContext());
            } else {
                view = this.f78380u.D("normal_advert_list.xml", getContext());
            }
            if (view != null) {
                Xh(view);
            }
            this.f78371l.addView(view, 0);
        }
        i6.d.j("updateP2pList", "initViews-- siteType>" + this.f78373n + " " + toString());
        ci((String) null);
    }

    public void j4(int i11, String str, boolean z11) {
        i6.d.j("updateTradingPairs", "PublicAdsNewFragment ----onSelectCurrency>siteType: " + this.f78373n + " listType:" + i11);
        if ((getActivity() instanceof OtcTradeActivity) && this.f78380u != null && this.f78373n == ((OtcTradeActivity) getActivity()).Sh()) {
            ci(str);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f78377r = null;
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_otc_public_page_new, viewGroup, false);
    }

    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        mp.c cVar = this.f78379t;
        if (cVar != null) {
            if (z11) {
                cVar.b();
            } else if (this.f78385z) {
                cVar.a();
            }
        }
        this.f78385z = z11;
    }

    public void uh(boolean z11) {
        rj.b bVar;
        super.uh(z11);
        i6.d.j("updateTradingPairs", "PublicAdsNewFragment --onVisibleChangedFinal->" + z11 + " " + this);
        if (!z11 && (bVar = this.f78380u) != null) {
            bVar.I("pageWillDisappear()");
        }
    }
}
