package com.huobi.points.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.utils.PointsDataSource;
import iq.o;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import tg.r;

public class PointsDetailListPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f80489a = "";

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshPageSplitter<PointsAction> f80490b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<PointsAction> f80491c = new a();

    public class a implements SmartRefreshPageSplitter.c<PointsAction> {
        public a() {
        }

        public Func1<? super PointsAction, ? extends Long> a() {
            return o.f55822b;
        }

        public Observable<List<PointsAction>> c() {
            Map<String, Object> b11 = MapParamsBuilder.c().b();
            b11.put("size", 10);
            if (!TextUtils.isEmpty(PointsDetailListPresenter.this.f80489a)) {
                b11.put("types", PointsDetailListPresenter.this.f80489a);
            }
            return PointsDataSource.c(b11);
        }

        /* renamed from: f */
        public Observable<List<PointsAction>> b(PointsAction pointsAction) {
            Map<String, Object> b11 = MapParamsBuilder.c().b();
            b11.put("size", 10);
            b11.put("from", Long.valueOf(pointsAction.getId()));
            if (!TextUtils.isEmpty(PointsDetailListPresenter.this.f80489a)) {
                b11.put("types", PointsDetailListPresenter.this.f80489a);
            }
            return PointsDataSource.c(b11);
        }
    }

    public interface b extends SmartRefreshPageSplitter.d {
    }

    public final void R() {
        this.f80490b = new SmartRefreshPageSplitter.Builder().n(true).l(true).m(10).p((SmartRefreshPageSplitter.d) getUI()).o(this.f80491c).k();
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        R();
    }

    public void T() {
        if (r.x().F0()) {
            this.f80490b.B();
        }
    }

    public void U(String str) {
        this.f80489a = str;
    }

    public void onResume() {
        super.onResume();
        T();
    }
}
