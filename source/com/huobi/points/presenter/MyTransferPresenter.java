package com.huobi.points.presenter;

import android.content.Intent;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.entity.Points;
import com.huobi.points.utils.PointsDataSource;
import iq.b;
import iq.c;
import iq.e;
import iq.f;
import q6.d;
import u6.g;

public class MyTransferPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public long f80474a;

    public interface a extends g {
        void M9();

        void Y1();

        void z3(Points points);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(Long l11) {
        ((a) getUI()).Y1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).M9();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(Throwable th2) {
        ((a) getUI()).M9();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(Points points) {
        ((a) getUI()).z3(points);
    }

    public static /* synthetic */ void a0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void b0(Throwable th2) {
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f80474a = intent.getLongExtra("extra", 0);
        }
        f0();
    }

    public void d0() {
        PointsDataSource.b(this.f80474a).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new iq.d(this), new b(this), new e(this)));
    }

    public void f0() {
        PointsDataSource.f(this.f80474a).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new c(this), f.f55803b, iq.g.f55805b));
    }
}
