package com.hbg.lite.trade.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.R$string;
import i6.i;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pb.b;
import pb.e;
import q6.d;
import ra.c;
import u6.g;

public class LiteOtcTradeSettingPwsdPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f77504a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77505b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77506c;

    public interface a extends g {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W() {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(String str) {
        HuobiToastUtil.s(R$string.otc_trade_setting_success);
        V();
    }

    public static /* synthetic */ void a0(Throwable th2) {
        if (th2 instanceof APIStatusErrorException) {
            HuobiToastUtil.m(((APIStatusErrorException) th2).getErrMsg());
        }
    }

    public final void V() {
        i.b().g(new pb.a(this), 10);
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = baseCoreActivity.getIntent();
        this.f77504a = intent.getBooleanExtra("trade_by_paymethod", false);
        this.f77505b = intent.getBooleanExtra("trade_by_otc_ads", false);
        this.f77506c = intent.getBooleanExtra("trade_by_otc_is_china", false);
    }

    public void c0(String str, String str2) {
        c.c().k().flatMap(new e(str, str2)).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new b(this), pb.c.f53007b, pb.d.f53008b));
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
        if (getUI() != null && ((a) getUI()).isAlive()) {
            Intent intent = new Intent(db.a.b().a());
            c.b().e(getActivity(), intent, intent);
        }
    }
}
