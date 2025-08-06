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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.livesquare.dialog.LivePrepareDialog;
import com.hbg.module.livesquare.presenter.LiveSquareSubPresenter;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import ef.b;
import java.util.List;
import k20.h;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class LiveSquareSubFragment extends BaseFragment<LiveSquareSubPresenter, LiveSquareSubPresenter.d> implements LiveSquareSubPresenter.d, View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public SmartRefreshLayout f26631l;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f26632m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingLayout f26633n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f26634o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f26635p;

    /* renamed from: q  reason: collision with root package name */
    public com.hbg.module.livesquare.adapter.e f26636q;

    /* renamed from: r  reason: collision with root package name */
    public int f26637r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f26638s;

    /* renamed from: t  reason: collision with root package name */
    public int f26639t;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        public int getSpanSize(int i11) {
            if (LiveSquareSubFragment.this.f26636q == null || LiveSquareSubFragment.this.f26636q.getItemViewType(i11) == 4) {
                return 1;
            }
            return 2;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            i6.d.i("hblive***  onRetry");
            ((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).r0();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends RecyclerView.ItemDecoration {
        public c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            List<LiveSquareBaseData> i11;
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (LiveSquareSubFragment.this.f26636q != null && childAdapterPosition >= 0 && (i11 = LiveSquareSubFragment.this.f26636q.i()) != null && childAdapterPosition < i11.size() && LiveSquareSubFragment.this.f26636q.getItemViewType(childAdapterPosition) == 4) {
                if (childAdapterPosition % 2 == 0) {
                    rect.left = LiveSquareSubFragment.this.f26639t;
                } else {
                    rect.right = LiveSquareSubFragment.this.f26639t;
                }
            }
        }
    }

    public class d implements ny.d {
        public d() {
        }

        public void P8(j jVar) {
            i6.d.i("hblive***   onLoadMore hasMore = " + LiveSquareSubFragment.this.f26638s);
            if (LiveSquareSubFragment.this.f26638s) {
                ((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).q0(false);
            } else {
                LiveSquareSubFragment.this.f26631l.e();
            }
        }

        public void bf(j jVar) {
            i6.d.i("hblive***  onRefresh");
            boolean unused = LiveSquareSubFragment.this.f26638s = true;
            ((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).q0(true);
        }
    }

    public class e implements b.a {

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
            public final /* synthetic */ LiveDetailBean f26646a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f26647b;

            public b(LiveDetailBean liveDetailBean, int i11) {
                this.f26646a = liveDetailBean;
                this.f26647b = i11;
            }

            public void a(HBDialogFragment hBDialogFragment) {
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
                if (LiveSquareSubFragment.this.yh() != null) {
                    ((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).u0(Integer.parseInt(this.f26646a.f70249id), false, this.f26647b);
                }
            }
        }

        public e() {
        }

        public void a(LiveSquareBaseData liveSquareBaseData, int i11, int i12) {
            switch (i11) {
                case 100:
                    if (liveSquareBaseData instanceof LiveDetailBean) {
                        LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                        LiveSquareSubFragment.this.jump2Detail(liveDetailBean.status, liveDetailBean.f70249id);
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
                        LiveSquareSubFragment.this.jump2Detail(liveDetailBean2.status, liveDetailBean2.f70249id);
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
                        LiveSquareSubFragment.this.jump2Detail(liveDetailBean3.status, liveDetailBean3.f70249id);
                        List<LiveSpeaker> list3 = liveDetailBean3.speakerList;
                        if (list3 != null && list3.size() > 0) {
                            LiveTrackUtils.h("APP_LIVE_quotation_tabclk", 3, liveDetailBean3.f70249id, liveDetailBean3.title, liveDetailBean3.speakerList.get(0).groupId);
                            return;
                        }
                        return;
                    }
                    return;
                case 103:
                    if (LiveSquareSubFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                        ((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).u0(Integer.parseInt(((LiveDetailBean) liveSquareBaseData).f70249id), true, i12);
                        return;
                    }
                    return;
                case 104:
                    if (LiveSquareSubFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                        LiveDetailBean liveDetailBean4 = (LiveDetailBean) liveSquareBaseData;
                        if (((LiveSquareSubPresenter) LiveSquareSubFragment.this.yh()).n0()) {
                            DialogUtils.c0(LiveSquareSubFragment.this.getActivity(), LiveSquareSubFragment.this.getString(R$string.n_live_cancel_prepare_hint_dialog), (String) null, LiveSquareSubFragment.this.getString(R$string.n_cancel), LiveSquareSubFragment.this.getString(R$string.n_confirm), new a(), new b(liveDetailBean4, i12));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void A(boolean z11) {
        LoadingLayout loadingLayout = this.f26633n;
        if (loadingLayout != null && z11) {
            loadingLayout.p();
        }
    }

    public void Ah() {
        this.f26634o.setOnClickListener(this);
        View findViewById = this.f26633n.findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            findViewById.setOnClickListener(new b());
        }
        this.f26632m.addItemDecoration(new c());
        this.f26631l.e0(new d());
        this.f26636q.s(new e());
    }

    public void E7() {
        SmartRefreshLayout smartRefreshLayout = this.f26631l;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setNoMoreData(false);
        }
    }

    /* renamed from: Ih */
    public LiveSquareSubPresenter xh() {
        return new LiveSquareSubPresenter();
    }

    /* renamed from: Jh */
    public LiveSquareSubPresenter.d zh() {
        return this;
    }

    public int getViewType() {
        return this.f26637r;
    }

    public void initViews() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R$id.sfl_live_sub);
        this.f26631l = smartRefreshLayout;
        smartRefreshLayout.i(true);
        this.f26631l.g(true);
        this.f26631l.V(true);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
        this.f26631l.j0(smartRefreshHeader);
        this.f26631l.h0(smartRefreshFooter);
        this.f26633n = (LoadingLayout) this.f67460i.b(R$id.loading_layout);
        this.f26632m = (RecyclerView) this.f67460i.b(R$id.rv_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        this.f26632m.setLayoutManager(gridLayoutManager);
        com.hbg.module.livesquare.adapter.e eVar = new com.hbg.module.livesquare.adapter.e(getContext());
        this.f26636q = eVar;
        eVar.q(this);
        this.f26636q.t(2);
        this.f26632m.setAdapter(this.f26636q);
        gridLayoutManager.t(new a());
        this.f26634o = (ImageView) this.f67460i.b(R$id.iv_back);
        TextView textView = (TextView) this.f67460i.b(R$id.tv_title);
        this.f26635p = textView;
        int i11 = this.f26637r;
        if (i11 == 1) {
            textView.setText(getString(R$string.n_live_appointment));
        } else if (i11 == 2) {
            textView.setText(getString(R$string.n_live));
        } else if (i11 == 3) {
            textView.setText(getString(R$string.n_live_playback));
        }
    }

    public final void jump2Detail(int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("liveStatus", i11);
        bundle.putString("liveId", str);
        HbgRouter.i(getActivity(), "/live/room", bundle);
    }

    public void kb(boolean z11) {
        if (z11) {
            SmartRefreshLayout smartRefreshLayout = this.f26631l;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.finishRefresh();
            }
            LoadingLayout loadingLayout = this.f26633n;
            if (loadingLayout != null) {
                loadingLayout.k();
                return;
            }
            return;
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f26631l;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.w();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.iv_back) {
            getActivity().finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f26637r = getArguments().getInt("view_type_key");
        }
        this.f26639t = Utils.a(getContext(), 10.5f);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached() && yh() != null && proTokenUpdate != null && !TextUtils.isEmpty(proTokenUpdate.proToken) && this.f26637r == 1) {
            ((LiveSquareSubPresenter) yh()).q0(true);
        }
    }

    public void pd(List<LiveSquareBaseData> list, boolean z11, boolean z12) {
        this.f26638s = z12;
        if (z11) {
            SmartRefreshLayout smartRefreshLayout = this.f26631l;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.finishRefresh();
            }
            LoadingLayout loadingLayout = this.f26633n;
            if (loadingLayout != null) {
                loadingLayout.g();
            }
            this.f26636q.r(list);
            return;
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f26631l;
        if (smartRefreshLayout2 != null) {
            if (z12) {
                smartRefreshLayout2.w();
            } else {
                smartRefreshLayout2.e();
            }
        }
        com.hbg.module.livesquare.adapter.e eVar = this.f26636q;
        if (eVar == null) {
            return;
        }
        if (eVar.i() != null) {
            int size = this.f26636q.i().size();
            this.f26636q.i().addAll(list);
            this.f26636q.notifyItemRangeInserted(size, list.size());
            return;
        }
        this.f26636q.r(list);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_live_square_sub, viewGroup, false);
    }

    public void vb(boolean z11) {
        if (z11) {
            SmartRefreshLayout smartRefreshLayout = this.f26631l;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.finishRefresh();
                this.f26633n.i();
                return;
            }
            return;
        }
        this.f26638s = false;
        this.f26631l.e();
    }

    public void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11) {
        com.hbg.module.livesquare.adapter.e eVar;
        if (liveAppointmentData != null && (eVar = this.f26636q) != null && eVar.i() != null) {
            if (z11) {
                if (i11 < this.f26636q.i().size()) {
                    LiveSquareBaseData liveSquareBaseData = this.f26636q.i().get(i11);
                    if (liveSquareBaseData instanceof LiveDetailBean) {
                        LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                        if (liveDetailBean.appointed == 0) {
                            liveDetailBean.appointed = 1;
                            com.hbg.module.livesquare.adapter.e eVar2 = this.f26636q;
                            if (eVar2 != null) {
                                eVar2.notifyItemChanged(i11);
                            }
                        }
                    }
                }
                new LivePrepareDialog(liveAppointmentData, (LiveDetailBean) this.f26636q.i().get(i11)).show(getActivity().getSupportFragmentManager(), "");
                if (liveAppointmentData.getLiveGroup() != null) {
                    LiveTrackUtils.e("APP_LIVE_notice_success", 1, Long.valueOf(liveAppointmentData.getLiveGroup().getId()), liveAppointmentData.getLiveGroup().getTitle(), liveAppointmentData.getLiveGroup().getGroupId(), 1);
                }
            } else if (i11 < this.f26636q.i().size()) {
                LiveSquareBaseData liveSquareBaseData2 = this.f26636q.i().get(i11);
                if (liveSquareBaseData2 instanceof LiveDetailBean) {
                    LiveDetailBean liveDetailBean2 = (LiveDetailBean) liveSquareBaseData2;
                    if (liveDetailBean2.appointed == 1) {
                        liveDetailBean2.appointed = 0;
                        com.hbg.module.livesquare.adapter.e eVar3 = this.f26636q;
                        if (eVar3 != null) {
                            eVar3.notifyItemChanged(i11);
                        }
                    }
                }
            }
        }
    }
}
