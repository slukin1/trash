package com.hbg.lite.index.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import bb.e;
import bb.f;
import bb.g;
import bb.h;
import bb.i;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.n;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lib.network.otc.core.bean.UserAssetLimitBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuNewDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseFragment;
import com.hbg.lite.index.bean.LiteIndexBannerTopNoticeModel;
import com.hbg.lite.index.bean.LiteIndexChatTutorialModel;
import com.hbg.lite.index.bean.ReminderData;
import com.hbg.lite.index.presenter.LiteIndexPresenter;
import com.hbg.lite.index.ui.LiteIndexFastBuyItemView;
import com.hbg.lite.main.ui.LiteMainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ky.j;
import ny.d;

public class LiteIndexFragment extends LiteBaseFragment<LiteIndexPresenter, LiteIndexPresenter.g> implements LiteIndexPresenter.g, LiteIndexFastBuyItemView.a {
    public RelativeLayout A;
    public FrameLayout B;
    public LoadingLayout C;
    public BottomMenuNewDialogFragment D = new BottomMenuNewDialogFragment();
    public SmartRefreshHeader E;
    public MenuItemBean.a F = new f(this);

    /* renamed from: l  reason: collision with root package name */
    public LiteIndexBannerTopNoticeView f77142l;

    /* renamed from: m  reason: collision with root package name */
    public LiteIndexTutorialView f77143m;

    /* renamed from: n  reason: collision with root package name */
    public LiteIndexOtcReminderView f77144n;

    /* renamed from: o  reason: collision with root package name */
    public LiteIndexFastBuyItemView f77145o;

    /* renamed from: p  reason: collision with root package name */
    public MyNestedScrollView f77146p;

    /* renamed from: q  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f77147q;

    /* renamed from: r  reason: collision with root package name */
    public SmartRefreshLayout f77148r;

    /* renamed from: s  reason: collision with root package name */
    public LiteIndexSkeletonView f77149s;

    /* renamed from: t  reason: collision with root package name */
    public View f77150t;

    /* renamed from: u  reason: collision with root package name */
    public View f77151u;

    /* renamed from: v  reason: collision with root package name */
    public RelativeLayout f77152v;

    /* renamed from: w  reason: collision with root package name */
    public int f77153w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f77154x;

    /* renamed from: y  reason: collision with root package name */
    public t f77155y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f77156z;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (LiteIndexFragment.this.zh().isCanBeSeen()) {
                ((LiteIndexPresenter) LiteIndexFragment.this.yh()).K0(true);
                ((LiteIndexPresenter) LiteIndexFragment.this.yh()).O0();
                return;
            }
            LiteIndexFragment.this.Z1(true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ra.c.c().l("3566", (Map<String, Object>) null);
            Intent g11 = ra.c.b().g(LiteIndexFragment.this.getActivity());
            if (!ra.c.c().p()) {
                ra.c.b().e(LiteIndexFragment.this.getActivity(), g11, (Intent) null);
            } else if (!NetworkStatus.c(LiteIndexFragment.this.getActivity())) {
                HuobiToastUtil.j(R$string.server_error);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else {
                LiteIndexFragment.this.startActivity(g11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements BottomMenuNewDialogFragment.a {
        public c() {
        }

        public void onCancel() {
        }

        public void onDismiss() {
            LiteIndexFragment.this.f77145o.setRotation(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        Rh(i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(MenuItemBean menuItemBean) {
        String type = menuItemBean.getType();
        if (!TextUtils.isEmpty(type) && !TextUtils.equals(String.valueOf(sa.a.c()), type)) {
            sa.a.j(String.valueOf(type));
            ((LiteIndexPresenter) yh()).y0(1);
            ((LiteIndexPresenter) yh()).z0(true);
            ((LiteIndexPresenter) yh()).O0();
            ((LiteIndexPresenter) yh()).N0();
            if (getActivity() != null && (getActivity() instanceof LiteMainActivity)) {
                ((LiteMainActivity) getActivity()).oh();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(View view, MenuItemBean menuItemBean, int i11) {
        this.D.dismiss();
        this.f77145o.postDelayed(new i(this, menuItemBean), 200);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Message message) {
        if (message.what == 1) {
            this.f77154x = false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (getActivity() instanceof LiteMainActivity) {
            ((LiteMainActivity) getActivity()).Qg();
        }
        ra.c.c().l("247", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ((LiteIndexPresenter) yh()).K0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f77151u.setOnClickListener(new bb.c(this));
        this.A.setOnClickListener(new b());
        this.D.uh(new c());
        this.C.setOnRetryClickListener(new bb.d(this));
    }

    public void F8(boolean z11) {
        View b11 = this.f67460i.b(R$id.id_lite_index_red_dot);
        if (b11 != null) {
            b11.post(new h(b11, z11));
        }
    }

    public void Fa() {
        this.f77142l.e();
    }

    public void Fb(LiteIndexChatTutorialModel liteIndexChatTutorialModel) {
        this.f77143m.setData(liteIndexChatTutorialModel);
    }

    public void J0() {
        EasyRecyclerView<s9.a> easyRecyclerView;
        try {
            if (isAlive() && (easyRecyclerView = this.f77147q) != null) {
                easyRecyclerView.c();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* renamed from: Kh */
    public LiteIndexPresenter xh() {
        return new LiteIndexPresenter();
    }

    public void Le(MarketMergedInfo marketMergedInfo) {
        this.f77145o.h(marketMergedInfo);
    }

    /* renamed from: Lh */
    public LiteIndexPresenter.g zh() {
        return this;
    }

    public void Pd() {
        this.B.setVisibility(8);
        this.C.g();
    }

    public void Rf() {
        this.f77142l.d();
    }

    public final void Rh(int i11) {
        boolean z11 = true;
        if (this.f77153w != i11) {
            if (!this.f77154x) {
                this.f77154x = true;
            }
            this.f77155y.removeMessages(1);
            this.f77155y.sendEmptyMessageDelayed(1, 100);
            this.f77153w = i11;
        }
        View view = this.f77150t;
        if (i11 <= 0) {
            z11 = false;
        }
        ViewUtil.m(view, z11);
    }

    public void Sh() {
        this.f77148r.i(true);
        this.f77148r.g(false);
        this.f77148r.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.E = smartRefreshHeader;
        this.f77148r.j0(smartRefreshHeader);
        this.f77148r.e0(new a());
    }

    public void Th() {
        n.o().A("INDEX_HINT_STEP1", this.f77151u);
    }

    public final void Uh(String str, List<String> list) {
        if (!CollectionsUtils.b(list)) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                arrayList.add(new MenuItemBean(next, va.b.l(next).toUpperCase(Locale.US), TextUtils.equals(next, String.valueOf(str)) ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, this.F));
            }
            this.D.vh(arrayList);
        }
        if (!CollectionsUtils.b(this.D.th())) {
            this.D.show(getChildFragmentManager(), "BottomMenuFragment");
            this.f77145o.setRotation(180);
        }
    }

    public void W4(String str) {
        Uh(str, ((LiteIndexPresenter) yh()).x0());
    }

    public void X6() {
        this.f77149s.setVisibility(8);
        this.f77149s.c();
        this.f77146p.setScrollingEnabled(true);
    }

    public void Z1(boolean z11) {
        if (z11) {
            this.f77148r.finishRefresh();
            this.f77148r.setNoMoreData(false);
            return;
        }
        this.f77148r.w();
    }

    public void ih() {
        this.f77149s.setVisibility(0);
        this.f77149s.b();
        this.f77146p.setScrollingEnabled(false);
    }

    public void initViews() {
        super.initViews();
        this.f77152v = (RelativeLayout) this.f67460i.b(R$id.main_content);
        this.f77150t = this.f67460i.b(R$id.id_lite_index_divider_view);
        this.f77142l = (LiteIndexBannerTopNoticeView) this.f67460i.b(R$id.banner_top_notice_view);
        this.f77146p = (MyNestedScrollView) this.f67460i.b(R$id.nest_scroll_view);
        this.f77144n = (LiteIndexOtcReminderView) this.f67460i.b(R$id.otc_reminder_view);
        this.f77145o = (LiteIndexFastBuyItemView) this.f67460i.b(R$id.fast_buy_view);
        this.f77147q = (EasyRecyclerView) this.f67460i.b(R$id.id_lite_index_recyclerView);
        this.f77151u = this.f67460i.b(R$id.id_lite_index_account_btn);
        this.B = (FrameLayout) this.f67460i.b(R$id.loading_layout_fl);
        this.C = (LoadingLayout) this.f67460i.b(R$id.lite_index_loading_layout);
        this.f77149s = (LiteIndexSkeletonView) this.f67460i.b(R$id.index_item_skeleton_view);
        this.f77148r = (SmartRefreshLayout) this.f67460i.b(R$id.lite_index_refresh_layout);
        this.f77143m = this.f77142l.getTutorialView();
        this.f77146p.setOnScrollChangeListener(new e(this));
        this.f77145o.setCallback(this);
        this.f77147q.setNestedScrollingEnabled(false);
        Th();
        Sh();
        this.f77156z = (TextView) this.f67460i.b(R$id.tv_message_count);
        this.A = (RelativeLayout) this.f67460i.b(R$id.rl_message);
        this.C.setTranslationY((float) (-getResources().getDimensionPixelOffset(R$dimen.dimen_40)));
    }

    public void j8(int i11, int i12) {
        nb.c.f(getActivity(), String.valueOf(i12), String.valueOf(i11), true);
    }

    public void je() {
        this.B.setVisibility(0);
        this.C.k();
        this.f77149s.setVisibility(8);
        this.f77149s.c();
        this.f77145o.c();
    }

    public void lh(za.a aVar) {
        this.f77142l.setMCallback(aVar);
        this.f77143m.setMCallback(aVar);
        this.f77144n.setMCallback(aVar);
    }

    public void mb() {
        LiteIndexFastBuyItemView liteIndexFastBuyItemView = this.f77145o;
        if (liteIndexFastBuyItemView != null) {
            liteIndexFastBuyItemView.i();
        }
    }

    public void ng(UserAssetLimitBean userAssetLimitBean) {
        if (userAssetLimitBean == null || TextUtils.isEmpty(userAssetLimitBean.getMinAmount())) {
            this.f77145o.g("", 2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f77155y = new t(new g(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.lite_fragment_index, (ViewGroup) null);
    }

    public void tc(List<s9.a> list) {
        EasyRecyclerView<s9.a> easyRecyclerView = this.f77147q;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11 && !ra.c.c().p()) {
            this.f77156z.setVisibility(8);
        }
    }

    public void v7(ReminderData reminderData) {
        this.f77144n.setData(reminderData);
    }

    public void xf(LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel) {
        this.f77142l.setData(liteIndexBannerTopNoticeModel);
    }
}
