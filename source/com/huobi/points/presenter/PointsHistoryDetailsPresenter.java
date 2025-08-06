package com.huobi.points.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.utils.PointsDataSource;
import com.huobi.utils.k0;
import iq.p;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import u6.g;

public class PointsHistoryDetailsPresenter extends ActivityPresenter<a> {

    public interface a extends g {
        void Z6(Points points, PointsAction pointsAction);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(PointsAction pointsAction, Points points) {
        ((a) getUI()).Z6(points, pointsAction);
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            PointsAction pointsAction = (PointsAction) intent.getSerializableExtra("points_pack");
            PointsDataSource.f(pointsAction.getOrderId()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new p(this, pointsAction)));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }
}
