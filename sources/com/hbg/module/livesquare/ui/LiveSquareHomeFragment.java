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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
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
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import com.xiaomi.mipush.sdk.Constants;
import ef.b;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class LiveSquareHomeFragment extends BaseFragment<LiveSquarePresenter, LiveSquarePresenter.e> implements LiveSquarePresenter.e, View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public LoadingLayout f26606l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f26607m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f26608n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f26609o;

    /* renamed from: p  reason: collision with root package name */
    public com.hbg.module.livesquare.adapter.e f26610p;

    /* renamed from: q  reason: collision with root package name */
    public int f26611q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f26612r = 0;

    /* renamed from: s  reason: collision with root package name */
    public boolean[] f26613s = new boolean[3];

    /* renamed from: t  reason: collision with root package name */
    public boolean f26614t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f26615u = false;

    /* renamed from: v  reason: collision with root package name */
    public ConsecutiveScrollerLayout f26616v;

    /* renamed from: w  reason: collision with root package name */
    public long f26617w = 0;

    /* renamed from: x  reason: collision with root package name */
    public HbgBaseProvider f26618x = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: y  reason: collision with root package name */
    public HbgBaseApmProvider f26619y = ((HbgBaseApmProvider) b2.a.d().a("/provider/apm").navigation());

    /* renamed from: z  reason: collision with root package name */
    public int f26620z;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        public int getSpanSize(int i11) {
            if (LiveSquareHomeFragment.this.f26610p == null || LiveSquareHomeFragment.this.f26610p.getItemViewType(i11) == 4) {
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
            ((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).M0(LiveSquareHomeFragment.this.f26620z, LiveSquareHomeFragment.this.B5());
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
            if (LiveSquareHomeFragment.this.f26610p != null && childAdapterPosition >= 0 && (i11 = LiveSquareHomeFragment.this.f26610p.i()) != null && childAdapterPosition < i11.size() && LiveSquareHomeFragment.this.f26610p.getItemViewType(childAdapterPosition) == 4) {
                LiveSquareBaseData liveSquareBaseData = i11.get(childAdapterPosition);
                if (liveSquareBaseData.getIndex() == -1) {
                    return;
                }
                if (liveSquareBaseData.getIndex() % 2 == 0) {
                    rect.left = LiveSquareHomeFragment.this.f26611q;
                    rect.right = LiveSquareHomeFragment.this.f26612r;
                    return;
                }
                rect.left = LiveSquareHomeFragment.this.f26612r;
                rect.right = LiveSquareHomeFragment.this.f26611q;
            }
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
            if (LiveSquareHomeFragment.this.f26610p.f26450e == null) {
                return;
            }
            if (LiveSquareHomeFragment.this.f26610p.f26449d < findFirstVisibleItemPosition || LiveSquareHomeFragment.this.f26610p.f26449d > findLastVisibleItemPosition) {
                LiveSquareHomeFragment.this.f26610p.f26450e.pauseVideo();
            } else {
                LiveSquareHomeFragment.this.f26610p.f26450e.resumeVideo();
            }
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
            public final /* synthetic */ LiveDetailBean f26627a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f26628b;

            public b(LiveDetailBean liveDetailBean, int i11) {
                this.f26627a = liveDetailBean;
                this.f26628b = i11;
            }

            public void a(HBDialogFragment hBDialogFragment) {
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
                if (LiveSquareHomeFragment.this.yh() != null) {
                    ((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).S0(Integer.parseInt(this.f26627a.f70249id), false, this.f26628b);
                }
            }
        }

        public e() {
        }

        public void a(LiveSquareBaseData liveSquareBaseData, int i11, int i12) {
            if (liveSquareBaseData != null) {
                i6.d.i("hblive***  data:" + liveSquareBaseData);
                switch (i11) {
                    case 100:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                            LiveSquareHomeFragment.this.jump2Detail(liveDetailBean.status, liveDetailBean.f70249id);
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
                            LiveSquareHomeFragment.this.jump2Detail(liveDetailBean2.status, liveDetailBean2.f70249id);
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
                            LiveSquareHomeFragment.this.jump2Detail(liveDetailBean3.status, liveDetailBean3.f70249id);
                            List<LiveSpeaker> list3 = liveDetailBean3.speakerList;
                            if (list3 != null && list3.size() > 0) {
                                LiveTrackUtils.h("APP_LIVE_quotation_tabclk", 3, liveDetailBean3.f70249id, liveDetailBean3.title, liveDetailBean3.speakerList.get(0).groupId);
                                return;
                            }
                            return;
                        }
                        return;
                    case 103:
                        if (LiveSquareHomeFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                            ((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).S0(Integer.parseInt(((LiveDetailBean) liveSquareBaseData).f70249id), true, i12);
                            return;
                        }
                        return;
                    case 104:
                        if (LiveSquareHomeFragment.this.yh() != null && (liveSquareBaseData instanceof LiveDetailBean)) {
                            LiveDetailBean liveDetailBean4 = (LiveDetailBean) liveSquareBaseData;
                            if (((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).B0()) {
                                DialogUtils.c0(LiveSquareHomeFragment.this.getActivity(), LiveSquareHomeFragment.this.getString(R$string.n_live_cancel_prepare_hint_dialog), (String) null, LiveSquareHomeFragment.this.getString(R$string.n_cancel), LiveSquareHomeFragment.this.getString(R$string.n_confirm), new a(), new b(liveDetailBean4, i12));
                                return;
                            }
                            return;
                        }
                        return;
                    case 105:
                        LiveSquareHomeFragment liveSquareHomeFragment = LiveSquareHomeFragment.this;
                        if (liveSquareHomeFragment.f26618x.j(liveSquareHomeFragment.requireActivity()) && (liveSquareBaseData instanceof LiveSpeaker)) {
                            LiveSpeaker liveSpeaker = (LiveSpeaker) liveSquareBaseData;
                            if (!TextUtils.isEmpty(liveSpeaker.groupId)) {
                                dd.b.f22740a.j(LiveSquareHomeFragment.this.getActivity(), liveSpeaker.groupId, liveSpeaker.title, (String) null);
                                LiveTrackUtils.c("APP_LIVE_group_getinto", (Object) null, liveSpeaker.showId, liveSpeaker.title, liveSpeaker.groupId, 2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 106:
                        if (liveSquareBaseData.getModuleType() == 3) {
                            dd.b.f22740a.g(LiveSquareHomeFragment.this.requireContext());
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 4) {
                            LiveSquareHomeFragment.this.Sh(1);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 5) {
                            LiveSquareHomeFragment.this.Sh(3);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 2) {
                            LiveSquareHomeFragment.this.Sh(2);
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

    public class f implements ConsecutiveScrollerLayout.e {
        public f() {
        }

        public void a(View view, int i11, int i12, int i13) {
            i6.d.c("ray22", " scrollY : $scrollY oldScrollY : $oldScrollY");
            if (LiveSquareHomeFragment.this.f26609o != null && LiveSquareHomeFragment.this.f26609o.getLayoutManager() != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) LiveSquareHomeFragment.this.f26609o.getLayoutManager();
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int itemCount = linearLayoutManager.getItemCount();
                i6.d.c("ray22", " lastVisibleItem : " + findLastCompletelyVisibleItemPosition + "count : " + itemCount + "---scrollState=" + i13);
                int i14 = itemCount - findLastCompletelyVisibleItemPosition;
                long currentTimeMillis = System.currentTimeMillis();
                if (i11 - i12 > 1 && i14 < 14 && itemCount > 5) {
                    if (LiveSquareHomeFragment.this.f26617w == 0) {
                        long unused = LiveSquareHomeFragment.this.f26617w = currentTimeMillis;
                        ((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).N0();
                    } else if (currentTimeMillis - LiveSquareHomeFragment.this.f26617w > 1000) {
                        long unused2 = LiveSquareHomeFragment.this.f26617w = currentTimeMillis;
                        ((LiveSquarePresenter) LiveSquareHomeFragment.this.yh()).N0();
                    }
                }
            }
        }
    }

    static {
        Class<LiveSquareHomeFragment> cls = LiveSquareHomeFragment.class;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Th(Object obj) {
        Xh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(PageVisible pageVisible) {
        Xh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(LiveSquareBaseData liveSquareBaseData) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.p(liveSquareBaseData);
        }
    }

    public static LiveSquareHomeFragment Wh(int i11, String str) {
        LiveSquareHomeFragment liveSquareHomeFragment = new LiveSquareHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i11);
        bundle.putString("uidUnique", str);
        liveSquareHomeFragment.setArguments(bundle);
        return liveSquareHomeFragment;
    }

    public void Ah() {
        super.Ah();
        this.f26607m.setOnClickListener(this);
        this.f26608n.setOnClickListener(this);
        WrapContentGridLayoutManager wrapContentGridLayoutManager = new WrapContentGridLayoutManager(getContext(), 2);
        this.f26609o.setLayoutManager(wrapContentGridLayoutManager);
        this.f26609o.setItemAnimator((RecyclerView.ItemAnimator) null);
        com.hbg.module.livesquare.adapter.e eVar = new com.hbg.module.livesquare.adapter.e(getContext());
        this.f26610p = eVar;
        eVar.q(this);
        this.f26610p.t(this.f26620z);
        this.f26609o.setAdapter(this.f26610p);
        wrapContentGridLayoutManager.t(new a());
        View findViewById = this.f26606l.findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            findViewById.setOnClickListener(new b());
        }
        this.f26609o.addItemDecoration(new c());
        this.f26609o.addOnScrollListener(new d());
        this.f26610p.s(new e());
        we.b.l("liveAppointment", Object.class).observe(this, new i(this));
        we.b.l("pageVisible", PageVisible.class).observe(this, new h(this));
    }

    public String B5() {
        return getArguments().getString("uidUnique");
    }

    public void Cd(List<LiveSquareBaseData> list) {
        if (this.f26606l != null) {
            this.f26609o.setVisibility(0);
            this.f26606l.setVisibility(8);
        }
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.r(list);
        }
        Oh();
    }

    public void Lb(List<LiveSquareBaseData> list, boolean z11) {
        this.f26610p.c(list);
    }

    public void Na() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void Oh() {
        HbgBaseApmProvider hbgBaseApmProvider;
        if (!this.f26615u && (hbgBaseApmProvider = this.f26619y) != null) {
            this.f26615u = true;
            hbgBaseApmProvider.i("huobiapp_market_content_live_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
        }
    }

    /* renamed from: Ph */
    public LiveSquarePresenter xh() {
        return new LiveSquarePresenter();
    }

    /* renamed from: Qh */
    public LiveSquarePresenter.e zh() {
        return this;
    }

    public void R4() {
    }

    public final void Rh() {
        this.f26616v.setOnVerticalScrollChangeListener(new f());
    }

    public final void Sh(int i11) {
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

    public void Uc(RecommendSpeakerList recommendSpeakerList) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.l(recommendSpeakerList);
        }
    }

    public void Xh() {
        this.f26609o.scrollToPosition(0);
        ((LiveSquarePresenter) yh()).M0(this.f26620z, B5());
    }

    public void c3() {
        if (this.f26606l != null) {
            this.f26609o.setVisibility(8);
            this.f26606l.setVisibility(0);
            this.f26606l.i();
        }
        Oh();
    }

    public void finishLoading() {
        if (this.f26606l != null) {
            this.f26609o.setVisibility(0);
            this.f26606l.setVisibility(8);
        }
    }

    public void ig() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void initViews() {
        HbgBaseApmProvider hbgBaseApmProvider;
        super.initViews();
        if (!this.f26614t && (hbgBaseApmProvider = this.f26619y) != null) {
            this.f26614t = true;
            hbgBaseApmProvider.o("huobiapp_market_content_live_end");
        }
        this.f26606l = (LoadingLayout) this.f67460i.b(R$id.loading_layout);
        this.f26609o = (RecyclerView) this.f67460i.b(R$id.rv_content);
        this.f26607m = (ImageView) this.f67460i.b(R$id.iv_back);
        this.f26608n = (TextView) this.f67460i.b(R$id.viewErrorRetry);
        this.f26616v = (ConsecutiveScrollerLayout) this.f67460i.b(R$id.scrollerLayout);
        Rh();
        we.c.g(this, new g(this));
    }

    public void j6(LiveSquareBaseData liveSquareBaseData) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
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
        if (this.f26606l != null) {
            this.f26609o.setVisibility(8);
            this.f26606l.setVisibility(0);
            this.f26606l.k();
        }
        Oh();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.iv_back) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity);
            activity.finish();
        } else if (view.getId() == R$id.viewErrorRetry && yh() != null) {
            ((LiveSquarePresenter) yh()).M0(this.f26620z, B5());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
        this.f26611q = Utils.a(getContext(), 5.0f);
        this.f26612r = Utils.a(getContext(), 10.0f);
        if (getArguments() != null) {
            this.f26620z = getArguments().getInt("type");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPause() {
        super.onPause();
        Arrays.fill(this.f26613s, false);
    }

    public void onResume() {
        super.onResume();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached() && yh() != null && proTokenUpdate != null && !TextUtils.isEmpty(proTokenUpdate.proToken)) {
            ((LiveSquarePresenter) yh()).M0(this.f26620z, B5());
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_live_square_home, viewGroup, false);
    }

    public void r5(LiveCategoryArr liveCategoryArr) {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.k(liveCategoryArr);
        }
    }

    public void showLoading() {
        if (this.f26606l != null) {
            this.f26609o.setVisibility(8);
            this.f26606l.setVisibility(0);
            this.f26606l.p();
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (this.f26610p.f26450e != null) {
            RecyclerView.LayoutManager layoutManager = this.f26609o.getLayoutManager();
            if (layoutManager == null || !z11) {
                this.f26610p.f26450e.pauseVideo();
                return;
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
            int i11 = eVar.f26449d;
            if (i11 < findFirstVisibleItemPosition || i11 > findLastVisibleItemPosition) {
                eVar.f26450e.pauseVideo();
            } else {
                eVar.f26450e.resumeVideo();
            }
        }
    }

    public int w4() {
        return this.f26620z;
    }

    public void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11) {
        com.hbg.module.livesquare.adapter.e eVar;
        if (liveAppointmentData != null && (eVar = this.f26610p) != null && eVar.i() != null) {
            if (z11) {
                if (i11 < this.f26610p.i().size()) {
                    LiveSquareBaseData liveSquareBaseData = this.f26610p.i().get(i11);
                    if (liveSquareBaseData instanceof LiveDetailBean) {
                        LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                        if (liveDetailBean.appointed == 0) {
                            liveDetailBean.appointed = 1;
                            liveDetailBean.appointedNum = liveAppointmentData.getAppointedNum();
                            com.hbg.module.livesquare.adapter.e eVar2 = this.f26610p;
                            if (eVar2 != null) {
                                eVar2.notifyItemChanged(i11);
                            }
                        }
                    }
                }
                LivePrepareDialog livePrepareDialog = new LivePrepareDialog(liveAppointmentData, (LiveDetailBean) this.f26610p.i().get(i11));
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity);
                livePrepareDialog.show(activity.getSupportFragmentManager(), "");
                if (liveAppointmentData.getLiveGroup() != null) {
                    LiveTrackUtils.e("APP_LIVE_notice_success", 1, Long.valueOf(liveAppointmentData.getLiveGroup().getId()), liveAppointmentData.getLiveGroup().getTitle(), liveAppointmentData.getLiveGroup().getGroupId(), 1);
                }
            } else if (i11 < this.f26610p.i().size()) {
                LiveSquareBaseData liveSquareBaseData2 = this.f26610p.i().get(i11);
                if (liveSquareBaseData2 instanceof LiveDetailBean) {
                    LiveDetailBean liveDetailBean2 = (LiveDetailBean) liveSquareBaseData2;
                    if (liveDetailBean2.appointed == 1) {
                        liveDetailBean2.appointed = 0;
                        liveDetailBean2.appointedNum = liveAppointmentData.getAppointedNum();
                        com.hbg.module.livesquare.adapter.e eVar3 = this.f26610p;
                        if (eVar3 != null) {
                            eVar3.notifyItemChanged(i11);
                        }
                    }
                }
            }
        }
    }

    public void x9() {
        com.hbg.module.livesquare.adapter.e eVar = this.f26610p;
        if (eVar != null) {
            eVar.e();
        }
    }
}
