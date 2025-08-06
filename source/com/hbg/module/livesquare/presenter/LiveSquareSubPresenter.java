package com.hbg.module.livesquare.presenter;

import bf.i;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentGroupData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import java.util.ArrayList;
import java.util.List;
import u6.g;

public class LiveSquareSubPresenter extends BaseFragmentPresenter<d> {

    /* renamed from: c  reason: collision with root package name */
    public int f26548c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f26549d = 1;

    /* renamed from: e  reason: collision with root package name */
    public HbgBaseProvider f26550e;

    public class a extends BaseSubscriber<List<LiveSquareBaseData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f26551b;

        public a(boolean z11) {
            this.f26551b = z11;
        }

        public void onError(Throwable th2) {
            if (LiveSquareSubPresenter.this.getActivity() != null && !LiveSquareSubPresenter.this.getActivity().isFinishing() && LiveSquareSubPresenter.this.getUI() != null && !LiveSquareSubPresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  " + th2.getMessage());
                ((d) LiveSquareSubPresenter.this.getUI()).kb(this.f26551b);
            }
        }

        public void onNext(List<LiveSquareBaseData> list) {
            if (LiveSquareSubPresenter.this.getActivity() != null && !LiveSquareSubPresenter.this.getActivity().isFinishing() && LiveSquareSubPresenter.this.getUI() != null && !LiveSquareSubPresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  请求成功" + list);
                i6.d.i("hblive***  size: " + list.size());
                if (list.size() != 0) {
                    ((d) LiveSquareSubPresenter.this.getUI()).pd(list, this.f26551b, LiveSquareSubPresenter.this.f26548c <= LiveSquareSubPresenter.this.f26549d);
                } else {
                    ((d) LiveSquareSubPresenter.this.getUI()).vb(this.f26551b);
                }
            }
        }
    }

    public class b extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f26553b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f26554c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f26555d;

        public b(int i11, boolean z11, int i12) {
            this.f26553b = i11;
            this.f26554c = z11;
            this.f26555d = i12;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (LiveSquareSubPresenter.this.getActivity() != null && !LiveSquareSubPresenter.this.getActivity().isFinishing() && LiveSquareSubPresenter.this.getUI() != null && !LiveSquareSubPresenter.this.Q().isDetached()) {
                if (liveAppointmentData.getLiveGroup() == null) {
                    LiveAppointmentGroupData liveAppointmentGroupData = new LiveAppointmentGroupData();
                    liveAppointmentGroupData.setLiveId((long) this.f26553b);
                    liveAppointmentData.setLiveGroup(liveAppointmentGroupData);
                }
                ((d) LiveSquareSubPresenter.this.getUI()).x(liveAppointmentData, this.f26554c, this.f26555d);
                we.b.l("liveAppointment", Object.class).g(0);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class c extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f26557b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f26558c;

        public c(boolean z11, int i11) {
            this.f26557b = z11;
            this.f26558c = i11;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (LiveSquareSubPresenter.this.getActivity() != null && !LiveSquareSubPresenter.this.getActivity().isFinishing() && LiveSquareSubPresenter.this.getUI() != null && !LiveSquareSubPresenter.this.Q().isDetached()) {
                ((d) LiveSquareSubPresenter.this.getUI()).x(liveAppointmentData, this.f26557b, this.f26558c);
                HuobiToastUtil.s(R$string.n_live_cancel_success);
                we.b.l("liveAppointment", Object.class).g(0);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.g(R$string.n_live_cancel_failure);
        }
    }

    public interface d extends g {
        void A(boolean z11);

        void E7();

        int getViewType();

        void kb(boolean z11);

        void pd(List<LiveSquareBaseData> list, boolean z11, boolean z12);

        void vb(boolean z11);

        void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11);
    }

    public void Z(boolean z11) {
        if (z11) {
            r0();
        }
    }

    public boolean n0() {
        HbgBaseProvider hbgBaseProvider = this.f26550e;
        return hbgBaseProvider != null && hbgBaseProvider.j(getActivity());
    }

    public void q0(boolean z11) {
        if (getUI() != null) {
            if (z11) {
                ((d) getUI()).E7();
                this.f26548c = 1;
            }
            v7.b.a().getLiveSquareCategoryData(((d) getUI()).getViewType(), this.f26548c, -1).b().compose(RxJavaHelper.t((g) null)).map(new i(this)).subscribe(new a(z11));
        }
    }

    public void r0() {
        if (getUI() != null) {
            ((d) getUI()).A(true);
            q0(true);
        }
    }

    /* renamed from: s0 */
    public final List<LiveSquareBaseData> p0(LiveSquareSubData liveSquareSubData) {
        if (liveSquareSubData == null || getUI() == null) {
            return null;
        }
        this.f26549d = liveSquareSubData.getPageAll();
        this.f26548c++;
        ArrayList arrayList = new ArrayList();
        if (liveSquareSubData.getListData() != null && liveSquareSubData.getListData().size() > 0) {
            for (int i11 = 0; i11 < liveSquareSubData.getListData().size(); i11++) {
                int viewType = ((d) getUI()).getViewType();
                LiveDetailBean liveDetailBean = liveSquareSubData.getListData().get(i11);
                if (viewType == 1) {
                    liveDetailBean.setModuleType(4);
                    if (liveSquareSubData.getListData().size() == 1 && liveSquareSubData.getPageNum() == 1) {
                        liveDetailBean.setViewType(3);
                    } else {
                        liveDetailBean.setViewType(4);
                    }
                } else if (viewType == 2) {
                    liveDetailBean.setModuleType(2);
                    if (liveSquareSubData.getListData().size() == 1 && liveSquareSubData.getPageNum() == 1) {
                        liveDetailBean.setViewType(3);
                    } else {
                        liveDetailBean.setViewType(4);
                    }
                } else if (viewType == 3) {
                    liveDetailBean.setModuleType(5);
                    if (liveSquareSubData.getListData().size() == 1 && liveSquareSubData.getPageNum() == 1) {
                        liveDetailBean.setViewType(3);
                    } else {
                        liveDetailBean.setViewType(4);
                    }
                }
            }
            arrayList.addAll(liveSquareSubData.getListData());
        }
        return arrayList;
    }

    /* renamed from: t0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        this.f26550e = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
    }

    public void u0(int i11, boolean z11, int i12) {
        if (getUI() != null) {
            if (z11) {
                HbgBaseProvider hbgBaseProvider = this.f26550e;
                if (hbgBaseProvider != null && hbgBaseProvider.j(getActivity())) {
                    v7.b.a().v0(String.valueOf(i11)).b().compose(RxJavaHelper.t((g) null)).subscribe(new b(i11, z11, i12));
                    return;
                }
                return;
            }
            v7.b.a().K0(String.valueOf(i11)).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(z11, i12));
        }
    }
}
