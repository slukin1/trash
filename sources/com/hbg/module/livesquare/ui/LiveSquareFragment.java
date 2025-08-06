package com.hbg.module.livesquare.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryArr;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.custom.decoration.WrapContentGridLayoutManager;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.event.bean.PageVisible;
import com.hbg.module.livesquare.dialog.LivePrepareDialog;
import com.hbg.module.livesquare.presenter.LiveSquarePresenter;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import com.xiaomi.mipush.sdk.Constants;
import ef.b;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import k20.h;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class LiveSquareFragment extends BaseFragment<LiveSquarePresenter, LiveSquarePresenter.e> implements LiveSquarePresenter.e, View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public LoadingLayout f26583l;

    /* renamed from: m  reason: collision with root package name */
    public SmartRefreshLayout f26584m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f26585n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f26586o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f26587p;

    /* renamed from: q  reason: collision with root package name */
    public com.hbg.module.livesquare.adapter.e f26588q;

    /* renamed from: r  reason: collision with root package name */
    public int f26589r = 0;

    /* renamed from: s  reason: collision with root package name */
    public boolean[] f26590s = new boolean[3];

    /* renamed from: t  reason: collision with root package name */
    public boolean f26591t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f26592u = false;

    /* renamed from: v  reason: collision with root package name */
    public HbgBaseProvider f26593v = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: w  reason: collision with root package name */
    public HbgBaseApmProvider f26594w = ((HbgBaseApmProvider) b2.a.d().a("/provider/apm").navigation());

    /* renamed from: x  reason: collision with root package name */
    public int f26595x;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        public int getSpanSize(int i11) {
            if (LiveSquareFragment.this.f26588q == null || LiveSquareFragment.this.f26588q.getItemViewType(i11) == 4) {
                return 1;
            }
            return 2;
        }
    }

    public class b implements ny.d {
        public b() {
        }

        public void P8(j jVar) {
            ((LiveSquarePresenter) LiveSquareFragment.this.yh()).N0();
        }

        public void bf(j jVar) {
            i6.d.i("hblive***  onRefresh");
            ((LiveSquarePresenter) LiveSquareFragment.this.yh()).M0(LiveSquareFragment.this.f26595x, LiveSquareFragment.this.B5());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            i6.d.i("hblive***  onRetry");
            ((LiveSquarePresenter) LiveSquareFragment.this.yh()).M0(LiveSquareFragment.this.f26595x, LiveSquareFragment.this.B5());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d extends RecyclerView.ItemDecoration {
        public d() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            List<LiveSquareBaseData> i11;
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (LiveSquareFragment.this.f26588q != null && childAdapterPosition >= 0 && (i11 = LiveSquareFragment.this.f26588q.i()) != null && childAdapterPosition < i11.size() && LiveSquareFragment.this.f26588q.getItemViewType(childAdapterPosition) == 4) {
                LiveSquareBaseData liveSquareBaseData = i11.get(childAdapterPosition);
                if (liveSquareBaseData.getIndex() == -1) {
                    return;
                }
                if (liveSquareBaseData.getIndex() % 2 == 0) {
                    rect.right = LiveSquareFragment.this.f26589r;
                } else {
                    rect.left = LiveSquareFragment.this.f26589r;
                }
            }
        }
    }

    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
            if (LiveSquareFragment.this.f26588q.f26450e == null) {
                return;
            }
            if (LiveSquareFragment.this.f26588q.f26449d < findFirstVisibleItemPosition || LiveSquareFragment.this.f26588q.f26449d > findLastVisibleItemPosition) {
                LiveSquareFragment.this.f26588q.f26450e.pauseVideo();
            } else {
                LiveSquareFragment.this.f26588q.f26450e.resumeVideo();
            }
        }
    }

    public class f implements b.a {

        public class a implements DialogUtils.b.f {
            public a() {
            }

            public void a(HBDialogFragment hBDialogFragment) {
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
            }
        }

        public class b implements DialogUtils.b.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LiveDetailBean f26603a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f26604b;

            public b(LiveDetailBean liveDetailBean, int i11) {
                this.f26603a = liveDetailBean;
                this.f26604b = i11;
            }

            public void a(HBDialogFragment hBDialogFragment) {
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
                if (LiveSquareFragment.this.yh() != null) {
                    ((LiveSquarePresenter) LiveSquareFragment.this.yh()).S0(Integer.parseInt(this.f26603a.f70249id), false, this.f26604b);
                }
            }
        }

        public f() {
        }

        public void a(LiveSquareBaseData liveSquareBaseData, int i11, int i12) {
            if (liveSquareBaseData != null) {
                i6.d.i("hblive***  data:" + liveSquareBaseData);
                switch (i11) {
                    case 100:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                            LiveSquareFragment.this.jump2Detail(liveDetailBean.status, liveDetailBean.f70249id);
                            List<LiveSpeaker> list = liveDetailBean.speakerList;
                            if (list != null && list.size() > 0) {
                                LiveTrackUtils.h("APP_LIVE_quotation_tabclk", 2, liveDetailBean.f70249id, liveDetailBean.title, liveDetailBean.speakerList.get(0).groupId);
                                return;
                            }
                            return;
                        }
                        return;
                    case 101:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean2 = (LiveDetailBean) liveSquareBaseData;
                            LiveSquareFragment.this.jump2Detail(liveDetailBean2.status, liveDetailBean2.f70249id);
                            List<LiveSpeaker> list2 = liveDetailBean2.speakerList;
                            if (list2 != null && list2.size() > 0) {
                                LiveTrackUtils.h("APP_LIVE_quotation_tabclk", 1, liveDetailBean2.f70249id, liveDetailBean2.title, liveDetailBean2.speakerList.get(0).groupId);
                                return;
                            }
                            return;
                        }
                        return;
                    case 102:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean3 = (LiveDetailBean) liveSquareBaseData;
                            LiveSquareFragment.this.jump2Detail(liveDetailBean3.status, liveDetailBean3.f70249id);
                            List<LiveSpeaker> list3 = liveDetailBean3.speakerList;
                            if (list3 != null && list3.size() > 0) {
                                LiveTrackUtils.h("APP_LIVE_quotation_tabclk", 3, liveDetailBean3.f70249id, liveDetailBean3.title, liveDetailBean3.speakerList.get(0).groupId);
                                return;
                            }
                            return;
                        }
                        return;
                    case 103:
                        if (LiveSquareFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                            ((LiveSquarePresenter) LiveSquareFragment.this.yh()).S0(Integer.parseInt(((LiveDetailBean) liveSquareBaseData).f70249id), true, i12);
                            return;
                        }
                        return;
                    case 104:
                        if (LiveSquareFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                            LiveDetailBean liveDetailBean4 = (LiveDetailBean) liveSquareBaseData;
                            if (((LiveSquarePresenter) LiveSquareFragment.this.yh()).B0()) {
                                DialogUtils.c0(LiveSquareFragment.this.getActivity(), LiveSquareFragment.this.getString(R$string.n_live_cancel_prepare_hint_dialog), (String) null, LiveSquareFragment.this.getString(R$string.n_cancel), LiveSquareFragment.this.getString(R$string.n_confirm), new a(), new b(liveDetailBean4, i12));
                                return;
                            }
                            return;
                        }
                        return;
                    case 105:
                        LiveSquareFragment liveSquareFragment = LiveSquareFragment.this;
                        if (liveSquareFragment.f26593v.j(liveSquareFragment.requireActivity()) && (liveSquareBaseData instanceof LiveSpeaker)) {
                            LiveSpeaker liveSpeaker = (LiveSpeaker) liveSquareBaseData;
                            if (!TextUtils.isEmpty(liveSpeaker.groupId)) {
                                int i13 = liveSpeaker.type;
                                if ((i13 == 2 || i13 == 3) && liveSpeaker.hasJion == 0) {
                                    Postcard a11 = b2.a.d().a("/webView/index");
                                    BaseModuleConfig.a a12 = BaseModuleConfig.a();
                                    a11.withString("url", a12.k("live/community/privateGroup?groupId=" + liveSpeaker.groupId)).navigation(LiveSquareFragment.this.requireActivity());
                                    return;
                                }
                                dd.b.f22740a.j(LiveSquareFragment.this.getActivity(), liveSpeaker.groupId, liveSpeaker.title, (String) null);
                                LiveTrackUtils.c("APP_LIVE_group_getinto", (Object) null, liveSpeaker.showId, liveSpeaker.title, liveSpeaker.groupId, 2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 106:
                        if (liveSquareBaseData.getModuleType() == 3) {
                            dd.b.f22740a.g(LiveSquareFragment.this.requireContext());
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 4) {
                            LiveSquareFragment.this.Nh(1);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 5) {
                            LiveSquareFragment.this.Nh(3);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 2) {
                            LiveSquareFragment.this.Nh(2);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                i6.d.i("hblive***  data: is null");
            }
        }
    }

    static {
        Class<LiveSquareFragment> cls = LiveSquareFragment.class;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(Object obj) {
        Sh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(PageVisible pageVisible) {
        Sh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qh(LiveSquareBaseData liveSquareBaseData) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.p(liveSquareBaseData);
        }
    }

    public static LiveSquareFragment Rh(int i11, String str) {
        LiveSquareFragment liveSquareFragment = new LiveSquareFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i11);
        bundle.putString("uidUnique", str);
        liveSquareFragment.setArguments(bundle);
        return liveSquareFragment;
    }

    public void Ah() {
        super.Ah();
        this.f26585n.setOnClickListener(this);
        this.f26586o.setOnClickListener(this);
        WrapContentGridLayoutManager wrapContentGridLayoutManager = new WrapContentGridLayoutManager(getContext(), 2);
        this.f26587p.setLayoutManager(wrapContentGridLayoutManager);
        this.f26587p.setItemAnimator((RecyclerView.ItemAnimator) null);
        com.hbg.module.livesquare.adapter.e eVar = new com.hbg.module.livesquare.adapter.e(getContext());
        this.f26588q = eVar;
        eVar.q(this);
        this.f26588q.t(this.f26595x);
        this.f26587p.setAdapter(this.f26588q);
        wrapContentGridLayoutManager.t(new a());
        this.f26584m.e0(new b());
        View findViewById = this.f26583l.findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            findViewById.setOnClickListener(new c());
        }
        this.f26587p.addItemDecoration(new d());
        this.f26587p.addOnScrollListener(new e());
        this.f26588q.s(new f());
        we.b.l("liveAppointment", Object.class).observe(this, new f(this));
        we.c.h(this, new e(this));
    }

    public String B5() {
        return getArguments().getString("uidUnique");
    }

    public void Cd(List<LiveSquareBaseData> list) {
        LoadingLayout loadingLayout = this.f26583l;
        if (loadingLayout != null) {
            loadingLayout.g();
        }
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.r(list);
        }
        Kh();
    }

    public final void Kh() {
        HbgBaseApmProvider hbgBaseApmProvider;
        if (!this.f26592u && (hbgBaseApmProvider = this.f26594w) != null) {
            this.f26592u = true;
            hbgBaseApmProvider.i("huobiapp_market_content_live_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
        }
    }

    public void Lb(List<LiveSquareBaseData> list, boolean z11) {
        SmartRefreshLayout smartRefreshLayout = this.f26584m;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.w();
            if (!z11) {
                this.f26584m.e();
            }
        }
        this.f26588q.c(list);
    }

    /* renamed from: Lh */
    public LiveSquarePresenter xh() {
        return new LiveSquarePresenter();
    }

    /* renamed from: Mh */
    public LiveSquarePresenter.e zh() {
        return this;
    }

    public void Na() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void Nh(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("selCategoryId", -1);
        int i12 = 2;
        if (i11 == 1) {
            i12 = 1;
        } else if (i11 != 2) {
            i12 = 3;
        }
        bundle.putInt("liveStatus", i12);
        HbgRouter.i(getActivity(), "/live/category_list", bundle);
    }

    public void R4() {
        this.f26584m.e();
    }

    public final void Sh() {
        if (this.f26584m != null && getActivity() != null && !getActivity().isFinishing() && !isDetached()) {
            this.f26584m.t();
        }
    }

    public void Uc(RecommendSpeakerList recommendSpeakerList) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.l(recommendSpeakerList);
        }
    }

    public void c3() {
        LoadingLayout loadingLayout = this.f26583l;
        if (loadingLayout != null) {
            loadingLayout.i();
        }
        Kh();
    }

    public void finishLoading() {
        LoadingLayout loadingLayout = this.f26583l;
        if (loadingLayout != null) {
            loadingLayout.g();
        }
        SmartRefreshLayout smartRefreshLayout = this.f26584m;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
            this.f26584m.setNoMoreData(false);
        }
    }

    public void ig() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void initViews() {
        HbgBaseApmProvider hbgBaseApmProvider;
        super.initViews();
        if (!this.f26591t && (hbgBaseApmProvider = this.f26594w) != null) {
            this.f26591t = true;
            hbgBaseApmProvider.o("huobiapp_market_content_live_end");
        }
        this.f26583l = (LoadingLayout) this.f67460i.b(R$id.loading_layout);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R$id.smart_refresh_layout);
        this.f26584m = smartRefreshLayout;
        smartRefreshLayout.j0(new SmartRefreshHeader(getActivity()));
        this.f26584m.h0(new SmartRefreshFooter(getActivity()));
        this.f26587p = (RecyclerView) this.f67460i.b(R$id.rv_content);
        this.f26585n = (ImageView) this.f67460i.b(R$id.iv_back);
        this.f26586o = (TextView) this.f67460i.b(R$id.viewErrorRetry);
        we.c.g(this, new d(this));
    }

    public void j6(LiveSquareBaseData liveSquareBaseData) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.j(liveSquareBaseData);
        }
    }

    public final void jump2Detail(int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("liveStatus", i11);
        bundle.putString("liveId", str);
        HbgRouter.i(getActivity(), "/live/room", bundle);
    }

    public void m0() {
        LoadingLayout loadingLayout = this.f26583l;
        if (loadingLayout != null) {
            loadingLayout.k();
        }
        Kh();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.iv_back) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity);
            activity.finish();
        } else if (view.getId() == R$id.viewErrorRetry && yh() != null) {
            ((LiveSquarePresenter) yh()).M0(this.f26595x, B5());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
        this.f26589r = Utils.a(getContext(), 10.5f);
        if (getArguments() != null) {
            this.f26595x = getArguments().getInt("type");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPause() {
        super.onPause();
        Arrays.fill(this.f26590s, false);
    }

    public void onResume() {
        super.onResume();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached() && yh() != null && proTokenUpdate != null && !TextUtils.isEmpty(proTokenUpdate.proToken)) {
            ((LiveSquarePresenter) yh()).M0(this.f26595x, B5());
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_live_square, viewGroup, false);
    }

    public void r5(LiveCategoryArr liveCategoryArr) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.k(liveCategoryArr);
        }
    }

    public void showLoading() {
        LoadingLayout loadingLayout = this.f26583l;
        if (loadingLayout != null) {
            loadingLayout.p();
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (this.f26588q.f26450e != null) {
            RecyclerView.LayoutManager layoutManager = this.f26587p.getLayoutManager();
            if (layoutManager == null || !z11) {
                this.f26588q.f26450e.pauseVideo();
                return;
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
            int i11 = eVar.f26449d;
            if (i11 < findFirstVisibleItemPosition || i11 > findLastVisibleItemPosition) {
                eVar.f26450e.pauseVideo();
            } else {
                eVar.f26450e.resumeVideo();
            }
        }
    }

    public int w4() {
        return this.f26595x;
    }

    public void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11) {
        com.hbg.module.livesquare.adapter.e eVar;
        if (liveAppointmentData != null && (eVar = this.f26588q) != null && eVar.i() != null) {
            if (z11) {
                if (i11 < this.f26588q.i().size()) {
                    LiveSquareBaseData liveSquareBaseData = this.f26588q.i().get(i11);
                    if (liveSquareBaseData instanceof LiveDetailBean) {
                        LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                        if (liveDetailBean.appointed == 0) {
                            liveDetailBean.appointed = 1;
                            liveDetailBean.appointedNum = liveAppointmentData.getAppointedNum();
                            com.hbg.module.livesquare.adapter.e eVar2 = this.f26588q;
                            if (eVar2 != null) {
                                eVar2.notifyItemChanged(i11);
                            }
                        }
                    }
                }
                LivePrepareDialog livePrepareDialog = new LivePrepareDialog(liveAppointmentData, (LiveDetailBean) this.f26588q.i().get(i11));
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity);
                livePrepareDialog.show(activity.getSupportFragmentManager(), "");
                if (liveAppointmentData.getLiveGroup() != null) {
                    LiveTrackUtils.e("APP_LIVE_notice_success", 1, Long.valueOf(liveAppointmentData.getLiveGroup().getId()), liveAppointmentData.getLiveGroup().getTitle(), liveAppointmentData.getLiveGroup().getGroupId(), 1);
                }
            } else if (i11 < this.f26588q.i().size()) {
                LiveSquareBaseData liveSquareBaseData2 = this.f26588q.i().get(i11);
                if (liveSquareBaseData2 instanceof LiveDetailBean) {
                    LiveDetailBean liveDetailBean2 = (LiveDetailBean) liveSquareBaseData2;
                    if (liveDetailBean2.appointed == 1) {
                        liveDetailBean2.appointed = 0;
                        liveDetailBean2.appointedNum = liveAppointmentData.getAppointedNum();
                        com.hbg.module.livesquare.adapter.e eVar3 = this.f26588q;
                        if (eVar3 != null) {
                            eVar3.notifyItemChanged(i11);
                        }
                    }
                }
            }
        }
    }

    public void x9() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26588q;
        if (eVar != null) {
            eVar.e();
        }
    }
}
