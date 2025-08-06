package ot;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.huobi.tradenew.guide.TradeVerticalSpotUserGuideMaskView;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f84552a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f84553b;

    /* renamed from: c  reason: collision with root package name */
    public final TradeVerticalSpotUserGuideMaskView f84554c;

    /* renamed from: d  reason: collision with root package name */
    public final LayoutInflater f84555d;

    /* renamed from: e  reason: collision with root package name */
    public int f84556e = -1;

    public a(ViewGroup viewGroup) {
        this.f84553b = viewGroup;
        this.f84555d = LayoutInflater.from(viewGroup.getContext());
        this.f84554c = new TradeVerticalSpotUserGuideMaskView(viewGroup.getContext());
    }

    public void a() {
        this.f84553b.removeView(this.f84554c);
        this.f84556e = -1;
    }

    public b b() {
        int i11;
        List<b> list = this.f84552a;
        if (list != null && (i11 = this.f84556e) >= 0 && i11 < list.size()) {
            return this.f84552a.get(this.f84556e);
        }
        return null;
    }

    public LayoutInflater c() {
        return this.f84555d;
    }

    public TradeVerticalSpotUserGuideMaskView d() {
        return this.f84554c;
    }

    public ViewGroup e() {
        return this.f84553b;
    }

    public void f(List<b> list) {
        this.f84552a = list;
    }

    public void g(int i11) {
        this.f84556e = i11;
        if (this.f84554c.getParent() == null) {
            this.f84553b.addView(this.f84554c);
        }
        if (i11 >= 0 && i11 < this.f84552a.size()) {
            this.f84552a.get(i11).a();
        }
    }

    public void h() {
        if (this.f84554c.getParent() != null) {
            ((ViewGroup) this.f84554c.getParent()).removeView(this.f84554c);
        }
        this.f84553b.addView(this.f84554c);
        g(0);
    }
}
