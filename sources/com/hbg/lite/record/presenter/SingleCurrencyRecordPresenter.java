package com.hbg.lite.record.presenter;

import android.content.Intent;
import android.view.View;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ra.c;
import sb.f;
import u6.g;

public class SingleCurrencyRecordPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public LegalDetailInfo f77367a;

    public class a extends EasySubscriber<Map<Integer, Map<Integer, String>>> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Map<Integer, Map<Integer, String>> map) {
            super.onNext(map);
            Map map2 = map.get(Integer.valueOf(SingleCurrencyRecordPresenter.this.f77367a.getCoinId()));
            if (map2 != null) {
                SingleCurrencyRecordPresenter.this.f77367a.setAvailable((String) map2.get(0));
                SingleCurrencyRecordPresenter.this.f77367a.setOnOrders((String) map2.get(1));
            }
            ((b) SingleCurrencyRecordPresenter.this.getUI()).n8(SingleCurrencyRecordPresenter.this.f77367a);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface b extends g {
        void S3(LegalDetailInfo legalDetailInfo);

        View getView();

        void n8(LegalDetailInfo legalDetailInfo);
    }

    public LegalDetailInfo S() {
        return this.f77367a;
    }

    public final void T() {
        f.h().o(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = baseCoreActivity.getIntent();
        if (intent != null) {
            this.f77367a = (LegalDetailInfo) intent.getSerializableExtra("record_coin_id");
            if (intent.getBooleanExtra("order_start", false)) {
                ((b) getUI()).getView().post(ib.g.f55040b);
            }
        }
        ((b) getUI()).S3(this.f77367a);
    }

    public void onResume() {
        super.onResume();
        T();
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
    public void onTokenError(p6.a aVar) {
        if (getUI() != null && ((b) getUI()).isAlive()) {
            c.b().e(getActivity(), (Intent) null, new Intent(db.a.b().a()));
            getActivity().finish();
        }
    }
}
