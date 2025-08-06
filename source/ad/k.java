package ad;

import android.content.Context;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.adapter.bean.CommonEmptyItem;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.grid.bean.GridStrategyItem;
import com.hbg.module.exchange.grid.presenter.GridTradePresenter;
import d7.a1;
import i6.g;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class k implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public GridTradePresenter.i f19357a;

    /* renamed from: b  reason: collision with root package name */
    public List<s9.a> f19358b;

    /* renamed from: c  reason: collision with root package name */
    public v9.a<s9.a> f19359c;

    /* renamed from: d  reason: collision with root package name */
    public Subscriber<List<GridStrategyItem>> f19360d;

    /* renamed from: e  reason: collision with root package name */
    public Context f19361e;

    /* renamed from: f  reason: collision with root package name */
    public g f19362f;

    /* renamed from: g  reason: collision with root package name */
    public GridStrategyItem.a f19363g = new b();

    public class a extends EasySubscriber<List<GridStrategyItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f19365c;

        public a(int i11, String str) {
            this.f19364b = i11;
            this.f19365c = str;
        }

        public void onError2(Throwable th2) {
            k.this.p(this.f19364b);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            k.this.p(this.f19364b);
        }

        public void onNext(List<GridStrategyItem> list) {
            k.this.q(this.f19365c, this.f19364b, list);
        }
    }

    public class b implements GridStrategyItem.a {
        public b() {
        }

        public void a(GridStrategyItem gridStrategyItem, Context context) {
            String str;
            GridStrategy d11 = gridStrategyItem.d();
            String Q = m.Q(d11.getTotalYieldRate(), 2, 1);
            try {
                long runTime = d11.getRunTime();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                int days = (int) timeUnit.toDays(runTime);
                str = days + context.getString(R$string.n_day) + (timeUnit.toHours(runTime) - ((long) (days * 24))) + context.getString(R$string.n_hour) + (timeUnit.toMinutes(runTime) - (timeUnit.toHours(runTime) * 60)) + context.getString(R$string.n_minute);
            } catch (Exception e11) {
                i6.k.k(e11);
                str = "";
            }
            vc.b.a().h(context, d11.getSymbol(), d11.getTotalProfitRate(), m.u(d11.getMinPrice(), PrecisionUtil.e(d11.getSymbol())), m.u(d11.getMaxPrice(), PrecisionUtil.e(d11.getSymbol())), Q, String.valueOf(d11.getTradeNum()), str);
        }

        public void b(String str) {
            if (e.a()) {
                k.this.t(str, a1.v().n(str), a1.v().D(str), 1, -1, 0);
            } else {
                k.this.t(str, "", "", 1, -1, 0);
            }
            k.this.s();
        }

        public void c(GridStrategyItem gridStrategyItem, Context context) {
            vc.b.a().p(context, String.valueOf(gridStrategyItem.d().getId()));
        }
    }

    public k(GridTradePresenter.i iVar, Context context) {
        this.f19357a = iVar;
        this.f19361e = context;
        ArrayList arrayList = new ArrayList();
        this.f19358b = arrayList;
        this.f19359c = new v9.a<>(arrayList);
        this.f19362f = new g(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ GridStrategyItem j(GridStrategy gridStrategy) {
        GridStrategyItem gridStrategyItem = new GridStrategyItem();
        gridStrategyItem.e(this.f19363g);
        gridStrategyItem.f(gridStrategy);
        return gridStrategyItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable k(String str, int i11, int i12, String str2, Long l11) {
        return v7.b.a().U(str, i11, i12, str2, -1, "1", 11, (Long) null, (Long) null).b().flatMap(i.f3526b).map(new g(this)).toList();
    }

    public static /* synthetic */ Boolean n(int i11, List list) {
        return Boolean.valueOf(i11 == 0);
    }

    public final Subscriber<List<GridStrategyItem>> g(String str, int i11) {
        return new a(i11, str);
    }

    public v9.a<s9.a> h() {
        return this.f19359c;
    }

    public final GridTradePresenter.i i() {
        return this.f19357a;
    }

    public void m(int i11) {
        if (!i().isAlive()) {
            g gVar = this.f19362f;
            if (gVar != null) {
                gVar.d();
                return;
            }
            return;
        }
        i().k7();
    }

    public final void o(int i11) {
        this.f19358b.clear();
        CommonEmptyItem commonEmptyItem = new CommonEmptyItem();
        commonEmptyItem.l(this.f19361e.getString(R$string.trade_no_record));
        this.f19358b.add(commonEmptyItem);
        this.f19359c.i(this.f19358b);
        this.f19359c.notifyDataSetChanged();
    }

    public final void p(int i11) {
        o(i11);
    }

    public final void q(String str, int i11, List<? extends s9.a> list) {
        this.f19358b.clear();
        if (list.isEmpty()) {
            CommonEmptyItem commonEmptyItem = new CommonEmptyItem();
            commonEmptyItem.l(this.f19361e.getString(R$string.trade_no_record));
            this.f19358b.add(commonEmptyItem);
        } else if (list.size() > 10) {
            this.f19358b.addAll(list.subList(0, 10));
            this.f19358b.add(new xc.a(str, i11, TradeType.GRID));
        } else {
            this.f19358b.addAll(list);
        }
        this.f19359c.notifyDataSetChanged();
    }

    public void r(int i11) {
        o(i11);
    }

    public void s() {
        this.f19362f.d();
        this.f19362f.c();
    }

    public void t(String str, String str2, String str3, int i11, int i12, int i13) {
        if (!vc.b.a().a()) {
            r(i13);
            return;
        }
        Subscriber<List<GridStrategyItem>> subscriber = this.f19360d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f19360d = g(str, i13);
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new h(this, str2, i11, i12, str3)).retryWhen(j.f3527b).filter(new f(i13)).compose(RxJavaHelper.t(i())).subscribe(this.f19360d);
    }

    public void u() {
        this.f19362f.d();
    }

    public void v() {
        Subscriber<List<GridStrategyItem>> subscriber = this.f19360d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}
