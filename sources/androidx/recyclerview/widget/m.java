package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f10901a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f10902b;

    /* renamed from: c  reason: collision with root package name */
    public int f10903c;

    /* renamed from: d  reason: collision with root package name */
    public int f10904d;

    /* renamed from: e  reason: collision with root package name */
    public int f10905e;

    /* renamed from: f  reason: collision with root package name */
    public int f10906f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f10907g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10908h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10909i;

    public boolean a(RecyclerView.State state) {
        int i11 = this.f10903c;
        return i11 >= 0 && i11 < state.b();
    }

    public View b(RecyclerView.Recycler recycler) {
        View o11 = recycler.o(this.f10903c);
        this.f10903c += this.f10904d;
        return o11;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f10902b + ", mCurrentPosition=" + this.f10903c + ", mItemDirection=" + this.f10904d + ", mLayoutDirection=" + this.f10905e + ", mStartLine=" + this.f10906f + ", mEndLine=" + this.f10907g + '}';
    }
}
