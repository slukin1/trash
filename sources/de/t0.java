package de;

import android.text.TextUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.network.option.controller.OptionMarketIndexInfoController;
import com.hbg.lib.network.option.core.bean.OptionIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import de.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import u6.g;

public class t0 extends t {

    /* renamed from: m  reason: collision with root package name */
    public final FutureContractInfo f25225m;

    /* renamed from: n  reason: collision with root package name */
    public String f25226n;

    /* renamed from: o  reason: collision with root package name */
    public String f25227o;

    /* renamed from: p  reason: collision with root package name */
    public Subscription f25228p;

    /* renamed from: q  reason: collision with root package name */
    public Subscription f25229q;

    /* renamed from: r  reason: collision with root package name */
    public Subscription f25230r;

    /* renamed from: s  reason: collision with root package name */
    public a f25231s;

    /* renamed from: t  reason: collision with root package name */
    public g f25232t;

    public interface a extends t.e {
        void e0(double d11);

        void j(OptionMarketIndexInfo optionMarketIndexInfo);

        void u(KlineInfo klineInfo);

        void z();
    }

    public t0(FutureContractInfo futureContractInfo, String str, String str2, String str3, a aVar, g gVar) {
        super(futureContractInfo.getOptionCode(), str, aVar);
        this.f25225m = futureContractInfo;
        this.f25226n = str2;
        this.f25227o = str3;
        this.f25231s = aVar;
        this.f25232t = gVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(List list) {
        if (list != null && list.size() > 0) {
            String indexPrice = ((OptionIndexInfo) list.get(0)).getIndexPrice();
            if (NumberKlineUtil.c(indexPrice)) {
                this.f25231s.e0(Double.parseDouble(indexPrice));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable B(Long l11) {
        return FutureContractInfoController.n().j(this.f25225m.getSymbol(), this.f25225m.getContractCode(), this.f25225m.getTradePartition(), this.f25225m.getContractType());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(List list) {
        if (list == null || list.size() <= 0) {
            this.f25231s.z();
        } else {
            this.f25231s.p3(((FutureContractInfo) list.get(0)).getExercisePrice());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable v(Long l11) {
        return OptionMarketIndexInfoController.c(false, this.f25226n);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(List list) {
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                OptionMarketIndexInfo optionMarketIndexInfo = (OptionMarketIndexInfo) it2.next();
                if (TextUtils.equals(this.f25226n, optionMarketIndexInfo.getContractCode())) {
                    this.f25231s.j(optionMarketIndexInfo);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable y(Long l11) {
        return p8.a.a().p(this.f25225m.getSymbol(), this.f25213e).b();
    }

    public void f() {
        e(this.f25228p);
        e(this.f25229q);
        e(this.f25230r);
        p8.a.a().c(this.f25217i);
    }

    public void g() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f25228p = Observable.interval(0, 5, timeUnit).flatMap(new n0(this)).retryWhen(r0.f53617b).compose(RxJavaHelper.t(this.f25232t)).subscribe(EasySubscriber.create(new l0(this)));
        this.f25230r = Observable.interval(0, 5, timeUnit).flatMap(new p0(this)).retryWhen(s0.f53619b).compose(RxJavaHelper.t(this.f25232t)).subscribe(EasySubscriber.create(new m0(this)));
        this.f25229q = Observable.interval(0, 5, timeUnit).flatMap(new o0(this)).retryWhen(q0.f53616b).compose(RxJavaHelper.t(this.f25232t)).subscribe(EasySubscriber.create(new k0(this)));
        p8.a.a().d(this.f25217i);
    }

    public void i(KlineInfo klineInfo) {
        a aVar = this.f25231s;
        if (aVar != null) {
            aVar.G3(klineInfo);
        }
    }

    public void j(boolean z11) {
        if (c(this.f25211c, this.f23716b)) {
            p8.a.a().g(z11, this.f25227o, Period.day, this.f25219k);
            p8.a.a().j(z11, this.f25227o, this.f25218j);
        }
    }

    public void k(KlineInfo klineInfo) {
        a aVar = this.f25231s;
        if (aVar != null) {
            aVar.u(klineInfo);
        }
    }
}
