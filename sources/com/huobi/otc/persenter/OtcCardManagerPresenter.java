package com.huobi.otc.persenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.hbg.core.bean.UserCardInfoBean;
import com.hbg.lib.network.otc.core.bean.OtcCountryListData;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.otc.OtcModuleConfig;
import java.util.HashMap;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import u6.g;

@Keep
public class OtcCardManagerPresenter extends ActivityPresenter<d> {
    /* access modifiers changed from: private */
    public List<OtcCountryListData> mCountryList;
    /* access modifiers changed from: private */
    public boolean mIsRequesting;

    public class a extends q6.d<List<UserCardInfoBean>> {
        public a(g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            boolean unused = OtcCardManagerPresenter.this.mIsRequesting = false;
            if (OtcCardManagerPresenter.this.getUI() != null) {
                ((d) OtcCardManagerPresenter.this.getUI()).Cb();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            boolean unused = OtcCardManagerPresenter.this.mIsRequesting = false;
            if (OtcCardManagerPresenter.this.getUI() != null) {
                ((d) OtcCardManagerPresenter.this.getUI()).Cb();
            }
        }

        public void onNext(List<UserCardInfoBean> list) {
            super.onNext(list);
            boolean unused = OtcCardManagerPresenter.this.mIsRequesting = false;
            if (OtcCardManagerPresenter.this.getUI() != null) {
                ((d) OtcCardManagerPresenter.this.getUI()).kh(list);
            }
        }
    }

    public class b extends q6.d<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f79009e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, long j11) {
            super(gVar);
            this.f79009e = j11;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (OtcCardManagerPresenter.this.getUI() != null) {
                ((d) OtcCardManagerPresenter.this.getUI()).Q9(this.f79009e);
            }
        }
    }

    public class c extends Subscriber<List<OtcCountryListData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f79012c;

        public c(String str, long j11) {
            this.f79011b = str;
            this.f79012c = j11;
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(List<OtcCountryListData> list) {
            if (OtcCardManagerPresenter.this.getUI() != null && list != null && !list.isEmpty()) {
                List unused = OtcCardManagerPresenter.this.mCountryList = list;
                String access$200 = OtcCardManagerPresenter.this.getCountryNameById(this.f79011b);
                try {
                    access$200 = qu.d.i().h(Integer.valueOf(this.f79011b).intValue(), access$200);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                ((d) OtcCardManagerPresenter.this.getUI()).Ja(this.f79012c, access$200);
            }
        }
    }

    public interface d extends g {
        void Cb();

        void Ja(long j11, String str);

        void Q9(long j11);

        void finishActivity();

        Context getContext();

        void kh(List<UserCardInfoBean> list);
    }

    /* access modifiers changed from: private */
    public String getCountryNameById(String str) {
        for (OtcCountryListData next : this.mCountryList) {
            if (TextUtils.equals(str, String.valueOf(next.getCountryId()))) {
                if (p.h(((d) getUI()).getContext())) {
                    return next.getNameCn();
                }
                return next.getNameEn();
            }
        }
        return "";
    }

    public void getCountryName(long j11, String str) {
        List<OtcCountryListData> list = this.mCountryList;
        if (list == null || list.isEmpty()) {
            OtcModuleConfig.a().getCountryList().compose(RxJavaHelper.t((g) getUI())).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(str, j11));
            return;
        }
        String countryNameById = getCountryNameById(str);
        try {
            countryNameById = qu.d.i().h(Integer.valueOf(str).intValue(), countryNameById);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        ((d) getUI()).Ja(j11, countryNameById);
    }

    public void getUserCardList() {
        if (!this.mIsRequesting) {
            this.mIsRequesting = true;
            HashMap hashMap = new HashMap();
            hashMap.put("merchantCode", !SystemUtils.c() ? "otc" : "2W5omA");
            hashMap.put("paymentMethod", "CreditcardtoCheckout");
            v7.b.a().getUserCardList(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && ((d) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            getActivity().finish();
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((d) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            ((d) getUI()).finishActivity();
        }
    }

    public void removeCard(long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("cardId", Long.valueOf(j11));
        v7.b.a().removeCard(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new b((g) getUI(), j11));
    }

    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        getUserCardList();
    }
}
