package com.hbg.module.livesquare.presenter;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import bf.f;
import bf.h;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentGroupData;
import com.hbg.lib.network.hbg.core.bean.LiveBannerArr;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryArr;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveHotTalkData;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.lib.network.hbg.core.bean.LiveTitleData;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import u6.g;

public class LiveSquarePresenter extends BaseFragmentPresenter<e> {

    /* renamed from: c  reason: collision with root package name */
    public List<LiveSquareBaseData> f26533c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public HbgBaseProvider f26534d;

    /* renamed from: e  reason: collision with root package name */
    public int f26535e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f26536f = 0;

    public class a extends BaseSubscriber<List<LiveSquareBaseData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f26537b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f26538c;

        public a(int i11, String str) {
            this.f26537b = i11;
            this.f26538c = str;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  " + th2.getMessage());
                ((e) LiveSquarePresenter.this.getUI()).m0();
            }
        }

        public void onNext(List<LiveSquareBaseData> list) {
            super.onNext(list);
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  请求成功" + LiveSquarePresenter.this.f26533c);
                i6.d.i("hblive***  size: " + LiveSquarePresenter.this.f26533c.size());
                ((e) LiveSquarePresenter.this.getUI()).finishLoading();
                if (LiveSquarePresenter.this.f26533c == null) {
                    ((e) LiveSquarePresenter.this.getUI()).c3();
                } else if (LiveSquarePresenter.this.f26533c.size() != 0) {
                    ((e) LiveSquarePresenter.this.getUI()).Cd(LiveSquarePresenter.this.f26533c);
                    if (this.f26537b != -100 && com.hbg.module.libkt.base.ext.b.x(this.f26538c)) {
                        LiveSquarePresenter.this.K0(this.f26537b);
                        LiveSquarePresenter.this.L0();
                        LiveSquarePresenter.this.O0();
                    }
                } else {
                    ((e) LiveSquarePresenter.this.getUI()).c3();
                }
            }
        }
    }

    public class b extends BaseSubscriber<List<LiveSquareBaseData>> {
        public b() {
        }

        public void onError(Throwable th2) {
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  " + th2.getMessage());
            }
        }

        public void onNext(List<LiveSquareBaseData> list) {
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                i6.d.i("hblive***  请求成功" + list);
                i6.d.i("hblive***  size: " + list.size());
                if (!com.hbg.module.libkt.base.ext.b.w(list)) {
                    ((e) LiveSquarePresenter.this.getUI()).Lb(list, LiveSquarePresenter.this.f26535e < LiveSquarePresenter.this.f26536f);
                    LiveSquarePresenter.A0(LiveSquarePresenter.this);
                    return;
                }
                ((e) LiveSquarePresenter.this.getUI()).R4();
            }
        }
    }

    public class c extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f26541b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f26542c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f26543d;

        public c(int i11, boolean z11, int i12) {
            this.f26541b = i11;
            this.f26542c = z11;
            this.f26543d = i12;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                if (liveAppointmentData.getLiveGroup() == null) {
                    LiveAppointmentGroupData liveAppointmentGroupData = new LiveAppointmentGroupData();
                    liveAppointmentGroupData.setLiveId((long) this.f26541b);
                    liveAppointmentData.setLiveGroup(liveAppointmentGroupData);
                }
                ((e) LiveSquarePresenter.this.getUI()).x(liveAppointmentData, this.f26542c, this.f26543d);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class d extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f26545b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f26546c;

        public d(boolean z11, int i11) {
            this.f26545b = z11;
            this.f26546c = i11;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (LiveSquarePresenter.this.getActivity() != null && !LiveSquarePresenter.this.getActivity().isFinishing() && LiveSquarePresenter.this.getUI() != null && !LiveSquarePresenter.this.Q().isDetached()) {
                ((e) LiveSquarePresenter.this.getUI()).x(liveAppointmentData, this.f26545b, this.f26546c);
                HuobiToastUtil.s(R$string.n_live_cancel_success);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.g(R$string.n_live_cancel_failure);
        }
    }

    public interface e extends g {
        String B5();

        void Cd(List<LiveSquareBaseData> list);

        void Lb(List<LiveSquareBaseData> list, boolean z11);

        void Na();

        void R4();

        void Uc(RecommendSpeakerList recommendSpeakerList);

        void c3();

        void finishLoading();

        void ig();

        void j6(LiveSquareBaseData liveSquareBaseData);

        void m0();

        void r5(LiveCategoryArr liveCategoryArr);

        void showLoading();

        int w4();

        void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11);

        void x9();
    }

    public static /* synthetic */ int A0(LiveSquarePresenter liveSquarePresenter) {
        int i11 = liveSquarePresenter.f26535e;
        liveSquarePresenter.f26535e = i11 + 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit C0(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            ((e) getUI()).ig();
            return null;
        }
        LiveBannerArr liveBannerArr = new LiveBannerArr();
        liveBannerArr.setModuleType(1);
        liveBannerArr.setViewType(1);
        liveBannerArr.setBanners(arrayList);
        ((e) getUI()).j6(liveBannerArr);
        return null;
    }

    public static /* synthetic */ Unit D0(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit E0(ArrayList arrayList) {
        if (com.hbg.module.libkt.base.ext.b.w(arrayList)) {
            ((e) getUI()).x9();
            return null;
        }
        LiveCategoryArr liveCategoryArr = new LiveCategoryArr();
        liveCategoryArr.setModuleType(6);
        liveCategoryArr.setViewType(6);
        liveCategoryArr.setCategories(arrayList);
        ((e) getUI()).r5(liveCategoryArr);
        return null;
    }

    public static /* synthetic */ Unit F0(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit I0(RecommendSpeakerList recommendSpeakerList) {
        if (recommendSpeakerList == null || com.hbg.module.libkt.base.ext.b.w(recommendSpeakerList.getListData())) {
            ((e) getUI()).Na();
            return null;
        }
        recommendSpeakerList.setModuleType(7);
        recommendSpeakerList.setViewType(7);
        ((e) getUI()).Uc(recommendSpeakerList);
        return null;
    }

    public static /* synthetic */ Unit J0(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    public boolean B0() {
        HbgBaseProvider hbgBaseProvider = this.f26534d;
        return hbgBaseProvider != null && hbgBaseProvider.j(getActivity());
    }

    public void K0(int i11) {
        if (getUI() != null && i11 >= 0) {
            RequestExtKt.c(v7.b.a().getLiveBanner(i11, NightHelper.e().g() ? 1 : 0), new bf.c(this), bf.e.f12357b, (MutableLiveData) null);
        }
    }

    public void L0() {
        if (getUI() != null) {
            RequestExtKt.c(v7.b.a().getLiveCategory(0, NightHelper.e().g() ? 1 : 0), new bf.b(this), f.f12358b, (MutableLiveData) null);
        }
    }

    public void M0(int i11, String str) {
        d9.a<LiveSquareContentData> aVar;
        if (getUI() != null) {
            this.f26533c.clear();
            this.f26535e = 2;
            IHbgApi a11 = v7.b.a();
            if (TextUtils.isEmpty(str)) {
                aVar = a11.getLiveListData(-1);
            } else {
                aVar = a11.getLiveSquareData(str);
            }
            aVar.b().compose(RxJavaHelper.t((g) null)).map(new h(this, str)).subscribe(new a(i11, str));
        }
    }

    public void N0() {
        if (getUI() != null) {
            v7.b.a().getLiveSquareCategoryData(3, this.f26535e, -1).b().compose(RxJavaHelper.t((g) null)).map(new bf.g(this)).subscribe(new b());
        }
    }

    public void O0() {
        if (getUI() != null) {
            RequestExtKt.c(v7.b.a().getRecommendSpeaker(1, 10, 1), new bf.a(this), bf.d.f12356b, (MutableLiveData) null);
        }
    }

    /* renamed from: P0 */
    public final List<LiveSquareBaseData> G0(LiveSquareContentData liveSquareContentData, String str) {
        i6.d.i("hblive***  转换成功");
        if (liveSquareContentData != null) {
            List<LiveDetailBean> broadcast = liveSquareContentData.getBroadcast();
            int i11 = 0;
            if (broadcast != null && broadcast.size() > 0) {
                we.b.l("hasLiving", Object.class).g(0);
                LiveTitleData liveTitleData = new LiveTitleData();
                liveTitleData.setModuleType(2);
                liveTitleData.setViewType(2);
                liveTitleData.setShowLine(false);
                liveTitleData.setShowMore(false);
                liveTitleData.setTitleName(getString(R$string.n_content_live_liveboadcast));
                this.f26533c.add(liveTitleData);
                if (broadcast.size() == 1) {
                    LiveDetailBean liveDetailBean = broadcast.get(0);
                    if (liveDetailBean != null) {
                        liveDetailBean.setModuleType(2);
                        liveDetailBean.setViewType(3);
                        liveDetailBean.setEquId(liveDetailBean.f70249id);
                        liveDetailBean.setRealPos(0);
                    }
                } else if (broadcast.size() > 1) {
                    int i12 = 0;
                    while (i12 < broadcast.size()) {
                        LiveDetailBean liveDetailBean2 = broadcast.get(i12);
                        if (liveDetailBean2 != null) {
                            liveDetailBean2.setModuleType(2);
                            liveDetailBean2.setViewType(i12 == 0 ? 3 : 4);
                            liveDetailBean2.setIndex(i12);
                            liveDetailBean2.setEquId(liveDetailBean2.f70249id);
                            liveDetailBean2.setRealPos(i12);
                        }
                        i12++;
                    }
                }
                this.f26533c.addAll(broadcast);
            }
            List<LiveSpeaker> groupList = liveSquareContentData.getGroupList();
            if (groupList != null && groupList.size() > 0) {
                LiveTitleData liveTitleData2 = new LiveTitleData();
                liveTitleData2.setShowLine(!(broadcast == null || broadcast.size() == 0));
                liveTitleData2.setShowMore(true);
                liveTitleData2.setModuleType(3);
                liveTitleData2.setViewType(2);
                liveTitleData2.setTitleName(getString(R$string.n_live_hot_talk));
                this.f26533c.add(liveTitleData2);
                LiveHotTalkData liveHotTalkData = new LiveHotTalkData();
                liveHotTalkData.setGroupList(groupList);
                liveHotTalkData.setModuleType(3);
                liveHotTalkData.setViewType(5);
                this.f26533c.add(liveHotTalkData);
            }
            List<LiveDetailBean> prepare = liveSquareContentData.getPrepare();
            if (prepare != null && prepare.size() > 0) {
                LiveTitleData liveTitleData3 = new LiveTitleData();
                liveTitleData3.setShowLine(true);
                liveTitleData3.setShowMore(TextUtils.isEmpty(str));
                liveTitleData3.setModuleType(4);
                liveTitleData3.setViewType(2);
                liveTitleData3.setTitleName(getString(R$string.n_content_live_liveboadcast_preview));
                this.f26533c.add(liveTitleData3);
                if (prepare.size() == 1) {
                    LiveDetailBean liveDetailBean3 = prepare.get(0);
                    if (liveDetailBean3 != null) {
                        liveDetailBean3.setModuleType(4);
                        liveDetailBean3.setViewType(3);
                        liveDetailBean3.setEquId(liveDetailBean3.f70249id);
                        liveDetailBean3.setRealPos(0);
                    }
                } else if (prepare.size() > 1) {
                    int i13 = 0;
                    while (i13 < prepare.size()) {
                        LiveDetailBean liveDetailBean4 = prepare.get(i13);
                        if (liveDetailBean4 != null) {
                            liveDetailBean4.setModuleType(4);
                            liveDetailBean4.setViewType(i13 == 0 ? 3 : 4);
                            liveDetailBean4.setIndex(i13);
                            liveDetailBean4.setEquId(liveDetailBean4.f70249id);
                            liveDetailBean4.setRealPos(i13);
                        }
                        i13++;
                    }
                }
                this.f26533c.addAll(prepare);
            }
            List<LiveDetailBean> endOfBroadcast = liveSquareContentData.getEndOfBroadcast();
            if (endOfBroadcast != null && endOfBroadcast.size() > 0) {
                LiveTitleData liveTitleData4 = new LiveTitleData();
                liveTitleData4.setShowLine(true);
                liveTitleData4.setShowMore(TextUtils.isEmpty(str));
                liveTitleData4.setModuleType(5);
                liveTitleData4.setViewType(2);
                liveTitleData4.setTitleName(getString(R$string.n_content_live_playback));
                this.f26533c.add(liveTitleData4);
                if (endOfBroadcast.size() == 1) {
                    LiveDetailBean liveDetailBean5 = endOfBroadcast.get(0);
                    if (liveDetailBean5 != null) {
                        liveDetailBean5.setModuleType(5);
                        liveDetailBean5.setViewType(3);
                        liveDetailBean5.setEquId(liveDetailBean5.f70249id);
                        liveDetailBean5.setRealPos(0);
                    }
                } else if (endOfBroadcast.size() > 1) {
                    while (i11 < endOfBroadcast.size()) {
                        LiveDetailBean liveDetailBean6 = endOfBroadcast.get(i11);
                        if (liveDetailBean6 != null) {
                            liveDetailBean6.setModuleType(5);
                            liveDetailBean6.setViewType(i11 == 0 ? 3 : 4);
                            liveDetailBean6.setIndex(i11);
                            liveDetailBean6.setEquId(liveDetailBean6.f70249id);
                            liveDetailBean6.setRealPos(i11);
                        }
                        i11++;
                    }
                }
                this.f26533c.addAll(endOfBroadcast);
            }
        }
        return this.f26533c;
    }

    /* renamed from: Q0 */
    public final List<LiveSquareBaseData> H0(LiveSquareSubData liveSquareSubData) {
        if (liveSquareSubData == null || getUI() == null) {
            return null;
        }
        this.f26536f = liveSquareSubData.getPageAll();
        ArrayList arrayList = new ArrayList();
        if (liveSquareSubData.getListData() != null && liveSquareSubData.getListData().size() > 0) {
            for (int i11 = 0; i11 < liveSquareSubData.getListData().size(); i11++) {
                LiveDetailBean liveDetailBean = liveSquareSubData.getListData().get(i11);
                liveDetailBean.setModuleType(5);
                if (liveSquareSubData.getListData().size() == 1 && liveSquareSubData.getPageNum() == 1) {
                    liveDetailBean.setViewType(3);
                } else {
                    liveDetailBean.setViewType(4);
                }
                liveDetailBean.setEquId(liveDetailBean.f70249id);
                liveDetailBean.setIndex(i11);
            }
            arrayList.addAll(liveSquareSubData.getListData());
        }
        return arrayList;
    }

    /* renamed from: R0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        this.f26534d = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        if (getUI() != null) {
            ((e) getUI()).showLoading();
            M0(eVar.w4(), eVar.B5());
        }
    }

    public void S0(int i11, boolean z11, int i12) {
        if (getUI() != null) {
            if (z11) {
                HbgBaseProvider hbgBaseProvider = this.f26534d;
                if (hbgBaseProvider != null && hbgBaseProvider.j(getActivity())) {
                    v7.b.a().v0(String.valueOf(i11)).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(i11, z11, i12));
                    return;
                }
                return;
            }
            v7.b.a().K0(String.valueOf(i11)).b().compose(RxJavaHelper.t((g) null)).subscribe(new d(z11, i12));
        }
    }

    public void Z(boolean z11) {
    }
}
