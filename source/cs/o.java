package cs;

import com.huobi.staring.bean.ProRemindListItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import u6.g;

public abstract class o implements ProRemindListItem.a {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f83819a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public g f83820b;

    /* renamed from: c  reason: collision with root package name */
    public a f83821c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f83822d;

    public interface a {
        void J0();
    }

    public o(g gVar, a aVar) {
        this.f83820b = gVar;
        this.f83821c = aVar;
    }

    public boolean a() {
        return this.f83822d;
    }

    public void c(boolean z11, ProRemindListItem proRemindListItem) {
        if (z11) {
            this.f83819a.remove(proRemindListItem.symbol);
        } else {
            this.f83819a.add(proRemindListItem.symbol);
        }
        a aVar = this.f83821c;
        if (aVar != null) {
            aVar.J0();
        }
    }

    public boolean e(ProRemindListItem proRemindListItem) {
        return this.f83819a.contains(proRemindListItem.symbol);
    }

    public void f(String str) {
        this.f83819a.add(str);
    }

    public void g() {
        this.f83819a.clear();
    }

    public List<String> h() {
        return new ArrayList(this.f83819a);
    }

    public void i(boolean z11) {
        this.f83822d = z11;
    }
}
