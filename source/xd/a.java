package xd;

import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import java.util.List;
import rx.Subscription;

public abstract class a implements l {

    /* renamed from: a  reason: collision with root package name */
    public String f26333a;

    /* renamed from: b  reason: collision with root package name */
    public Period f26334b;

    /* renamed from: c  reason: collision with root package name */
    public C0233a f26335c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26336d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26337e = false;

    /* renamed from: xd.a$a  reason: collision with other inner class name */
    public interface C0233a {
        void A(boolean z11);

        void d(KlineInfo klineInfo);

        void e(List<? extends KlineInfo> list, boolean z11);

        void f(List<KlineInfo> list);

        int getKlineNum();
    }

    public a(C0233a aVar) {
        this.f26335c = aVar;
    }

    public boolean a(Period period) {
        Period period2 = this.f26334b;
        boolean z11 = period2 != null && period2 == period;
        if (!z11) {
            c(period2, false);
        }
        this.f26334b = period;
        return z11;
    }

    public void b(boolean z11) {
        this.f26336d = z11;
    }

    public void d(String str) {
        this.f26333a = str;
    }

    public void f() {
        this.f26336d = true;
        C0233a aVar = this.f26335c;
        if (aVar != null) {
            aVar.A(true);
        }
    }

    public Period g() {
        return this.f26334b;
    }

    public void h(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public int i() {
        if (this.f26334b == Period.expandtl) {
            return 49;
        }
        C0233a aVar = this.f26335c;
        if (aVar != null) {
            return aVar.getKlineNum();
        }
        return 300;
    }

    public boolean j(String str, Period period) {
        return (str == null || period == null) ? false : true;
    }

    public void k() {
        c(this.f26334b, true);
    }

    public String k1() {
        return this.f26333a;
    }

    public void onPause() {
        this.f26337e = false;
        c(this.f26334b, false);
    }

    public void onResume() {
        this.f26337e = true;
    }
}
