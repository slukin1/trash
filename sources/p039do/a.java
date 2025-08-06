package p039do;

import android.content.Context;
import co.b;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.main.trade.enums.TradeTabsType;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import u6.g;

/* renamed from: do.a  reason: invalid package */
public abstract class a<T extends b> {

    /* renamed from: b  reason: collision with root package name */
    public Context f83829b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<g> f83830c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f83831d;

    /* renamed from: e  reason: collision with root package name */
    public TradeTabsType f83832e = TradeTabsType.OTHER;

    /* renamed from: f  reason: collision with root package name */
    public T f83833f;

    /* renamed from: g  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83834g = new CopyOnWriteArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f83835h;

    /* renamed from: i  reason: collision with root package name */
    public int f83836i;

    public a(Context context, TradeType tradeType, T t11, g gVar) {
        this.f83829b = context;
        this.f83831d = tradeType;
        this.f83833f = t11;
        if (gVar != null) {
            this.f83830c = new WeakReference<>(gVar);
        }
    }

    public boolean f() {
        return this.f83835h;
    }

    public String g(int i11) {
        return this.f83829b.getResources().getString(i11);
    }

    public T h() {
        return this.f83833f;
    }

    public TradeType i() {
        return this.f83831d;
    }

    public g j() {
        WeakReference<g> weakReference = this.f83830c;
        if (weakReference != null) {
            return (g) weakReference.get();
        }
        return null;
    }

    public abstract void k();

    public abstract void l();

    public void m(boolean z11) {
        if (this.f83835h != z11) {
            this.f83835h = z11;
            l();
        }
    }

    public void n(int i11, boolean z11) {
        this.f83836i = i11;
    }

    public abstract void o();

    public void p() {
        if (h() != null) {
            h().Yf(this.f83831d, this.f83834g);
        }
    }
}
