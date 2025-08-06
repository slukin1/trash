package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.LayoutManager f10914a;

    /* renamed from: b  reason: collision with root package name */
    public int f10915b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f10916c;

    public class a extends r {
        public a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, (a) null);
        }

        public int d(View view) {
            return this.f10914a.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        }

        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f10914a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f10914a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        public int g(View view) {
            return this.f10914a.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public int h() {
            return this.f10914a.getWidth();
        }

        public int i() {
            return this.f10914a.getWidth() - this.f10914a.getPaddingRight();
        }

        public int j() {
            return this.f10914a.getPaddingRight();
        }

        public int k() {
            return this.f10914a.getWidthMode();
        }

        public int l() {
            return this.f10914a.getHeightMode();
        }

        public int m() {
            return this.f10914a.getPaddingLeft();
        }

        public int n() {
            return (this.f10914a.getWidth() - this.f10914a.getPaddingLeft()) - this.f10914a.getPaddingRight();
        }

        public int p(View view) {
            this.f10914a.getTransformedBoundingBox(view, true, this.f10916c);
            return this.f10916c.right;
        }

        public int q(View view) {
            this.f10914a.getTransformedBoundingBox(view, true, this.f10916c);
            return this.f10916c.left;
        }

        public void r(int i11) {
            this.f10914a.offsetChildrenHorizontal(i11);
        }
    }

    public class b extends r {
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, (a) null);
        }

        public int d(View view) {
            return this.f10914a.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        }

        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f10914a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f10914a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public int g(View view) {
            return this.f10914a.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        }

        public int h() {
            return this.f10914a.getHeight();
        }

        public int i() {
            return this.f10914a.getHeight() - this.f10914a.getPaddingBottom();
        }

        public int j() {
            return this.f10914a.getPaddingBottom();
        }

        public int k() {
            return this.f10914a.getHeightMode();
        }

        public int l() {
            return this.f10914a.getWidthMode();
        }

        public int m() {
            return this.f10914a.getPaddingTop();
        }

        public int n() {
            return (this.f10914a.getHeight() - this.f10914a.getPaddingTop()) - this.f10914a.getPaddingBottom();
        }

        public int p(View view) {
            this.f10914a.getTransformedBoundingBox(view, true, this.f10916c);
            return this.f10916c.bottom;
        }

        public int q(View view) {
            this.f10914a.getTransformedBoundingBox(view, true, this.f10916c);
            return this.f10916c.top;
        }

        public void r(int i11) {
            this.f10914a.offsetChildrenVertical(i11);
        }
    }

    public /* synthetic */ r(RecyclerView.LayoutManager layoutManager, a aVar) {
        this(layoutManager);
    }

    public static r a(RecyclerView.LayoutManager layoutManager) {
        return new a(layoutManager);
    }

    public static r b(RecyclerView.LayoutManager layoutManager, int i11) {
        if (i11 == 0) {
            return a(layoutManager);
        }
        if (i11 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static r c(RecyclerView.LayoutManager layoutManager) {
        return new b(layoutManager);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f10915b) {
            return 0;
        }
        return n() - this.f10915b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i11);

    public void s() {
        this.f10915b = n();
    }

    public r(RecyclerView.LayoutManager layoutManager) {
        this.f10915b = Integer.MIN_VALUE;
        this.f10916c = new Rect();
        this.f10914a = layoutManager;
    }
}
