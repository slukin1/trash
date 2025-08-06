package ni;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.huobi.c2c.lend.view.C2CLendTradeView2;
import i6.d;
import java.util.List;

public class a extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.huobi.c2c.lend.a> f47630a;

    /* renamed from: b  reason: collision with root package name */
    public int f47631b = -1;

    public a(List<com.huobi.c2c.lend.a> list) {
        this.f47630a = list;
    }

    public com.huobi.c2c.lend.a a(int i11) {
        if (i11 < 0 || i11 >= this.f47630a.size()) {
            return null;
        }
        return this.f47630a.get(i11);
    }

    public String b(int i11) {
        com.huobi.c2c.lend.a a11 = a(i11);
        if (a11 != null) {
            return a11.e0();
        }
        return null;
    }

    public void c(int i11) {
        com.huobi.c2c.lend.a a11 = a(this.f47631b);
        if (a11 != null) {
            a11.q0();
        }
        this.f47631b = i11;
        com.huobi.c2c.lend.a a12 = a(i11);
        if (a12 != null) {
            a12.r0();
        }
    }

    public void d() {
        d.b("C2CLentPagerAdapter-->onPaused--> mIndex:" + this.f47631b);
        com.huobi.c2c.lend.a a11 = a(this.f47631b);
        if (a11 != null) {
            a11.q0();
        }
        this.f47631b = -1;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        com.huobi.c2c.lend.a aVar;
        if (i11 >= 0 && i11 < this.f47630a.size() && (aVar = this.f47630a.get(i11)) != null) {
            viewGroup.removeView(aVar.f0());
        }
    }

    public void e(int i11) {
        d.b("C2CLentPagerAdapter-->onResume--> mIndex:" + this.f47631b + " position:" + i11);
        this.f47631b = i11;
        com.huobi.c2c.lend.a a11 = a(i11);
        if (a11 != null) {
            a11.r0();
        }
    }

    public void f(int i11) {
        d.b("C2CLentPagerAdapter-->onSetList--> mIndex:" + this.f47631b + " position:" + i11);
        int i12 = this.f47631b;
        if (i12 == i11) {
            String b11 = b(i12);
            String b12 = b(i11);
            if (b11 != null && b11.equalsIgnoreCase(b12)) {
                return;
            }
        }
        c(i11);
    }

    public int getCount() {
        List<com.huobi.c2c.lend.a> list = this.f47630a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        if (i11 < 0 || i11 >= this.f47630a.size()) {
            return null;
        }
        C2CLendTradeView2 f02 = this.f47630a.get(i11).f0();
        viewGroup.addView(f02);
        return f02;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
