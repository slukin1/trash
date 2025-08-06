package ly;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.a0;
import androidx.core.view.p;
import androidx.core.view.t;
import androidx.core.widget.NestedScrollView;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.impl.ScrollBoundaryDeciderAdapter;
import com.scwang.smartrefresh.layout.util.DesignUtil;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import ky.e;
import ky.i;
import ky.k;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public int f37205a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f37206b = (Integer.MAX_VALUE - 1);

    /* renamed from: c  reason: collision with root package name */
    public View f37207c;

    /* renamed from: d  reason: collision with root package name */
    public View f37208d;

    /* renamed from: e  reason: collision with root package name */
    public View f37209e;

    /* renamed from: f  reason: collision with root package name */
    public View f37210f;

    /* renamed from: g  reason: collision with root package name */
    public View f37211g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37212h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37213i = true;

    /* renamed from: j  reason: collision with root package name */
    public MotionEvent f37214j;

    /* renamed from: k  reason: collision with root package name */
    public ScrollBoundaryDeciderAdapter f37215k = new ScrollBoundaryDeciderAdapter();

    /* renamed from: ly.a$a  reason: collision with other inner class name */
    public class C0508a implements oy.a {
        public C0508a() {
        }

        public void a(boolean z11, boolean z12) {
            a aVar = a.this;
            aVar.f37212h = z11;
            aVar.f37213i = z12;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public int f37217b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f37218c;

        public b(int i11) {
            this.f37218c = i11;
            this.f37217b = i11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            try {
                View view = a.this.f37209e;
                if (view instanceof AbsListView) {
                    a.u((AbsListView) view, intValue - this.f37217b);
                } else {
                    view.scrollBy(0, intValue - this.f37217b);
                }
            } catch (Throwable unused) {
            }
            this.f37217b = intValue;
        }
    }

    public a(View view) {
        this.f37208d = view;
        this.f37207c = view;
    }

    public static boolean s(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof a0) || (view instanceof p) || (view instanceof t) || (view instanceof WebView) || (view instanceof ViewPager);
    }

    public static int t(View view) {
        int i11;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i12 = layoutParams.height;
        if (i12 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i11);
        return view.getMeasuredHeight();
    }

    public static void u(AbsListView absListView, int i11) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i11);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition != -1 && (childAt = absListView.getChildAt(0)) != null) {
                ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i11);
            }
        } else {
            absListView.smoothScrollBy(i11, 0);
        }
    }

    public void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f37214j = obtain;
        obtain.offsetLocation((float) (-this.f37207c.getLeft()), (float) (-this.f37207c.getTop()));
        View view = this.f37209e;
        View view2 = this.f37207c;
        if (view != view2) {
            this.f37209e = q(view2, this.f37214j, view);
        }
        if (this.f37209e == this.f37207c) {
            this.f37215k.c((MotionEvent) null);
        } else {
            this.f37215k.c(this.f37214j);
        }
    }

    public void b(boolean z11) {
        this.f37215k.d(z11);
    }

    public ValueAnimator.AnimatorUpdateListener c(int i11) {
        View view = this.f37209e;
        if (view == null || i11 == 0) {
            return null;
        }
        if ((i11 >= 0 || !ScrollBoundaryUtil.c(view)) && (i11 <= 0 || !ScrollBoundaryUtil.e(this.f37209e))) {
            return null;
        }
        return new b(i11);
    }

    public int d() {
        return this.f37207c.getMeasuredWidth();
    }

    public void e(int i11, int i12) {
        this.f37207c.measure(i11, i12);
    }

    public boolean f() {
        return this.f37213i && this.f37215k.a(this.f37207c);
    }

    public void g(i iVar, View view, View view2) {
        p(this.f37207c, iVar);
        if (view != null || view2 != null) {
            this.f37210f = view;
            this.f37211g = view2;
            FrameLayout frameLayout = new FrameLayout(this.f37207c.getContext());
            iVar.f().getLayout().removeView(this.f37207c);
            ViewGroup.LayoutParams layoutParams = this.f37207c.getLayoutParams();
            frameLayout.addView(this.f37207c, -1, -1);
            iVar.f().getLayout().addView(frameLayout, layoutParams);
            this.f37207c = frameLayout;
            if (view != null) {
                view.setClickable(true);
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams2.height = t(view);
                viewGroup.addView(new Space(this.f37207c.getContext()), indexOfChild, layoutParams2);
                frameLayout.addView(view);
            }
            if (view2 != null) {
                view2.setClickable(true);
                ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild2 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
                layoutParams3.height = t(view2);
                viewGroup2.addView(new Space(this.f37207c.getContext()), indexOfChild2, layoutParams3);
                layoutParams4.gravity = 80;
                frameLayout.addView(view2, layoutParams4);
            }
        }
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.f37207c.getLayoutParams();
    }

    public View getView() {
        return this.f37207c;
    }

    public int h() {
        return this.f37207c.getMeasuredHeight();
    }

    public void i(int i11) {
        this.f37208d.setTranslationY((float) i11);
        View view = this.f37210f;
        if (view != null) {
            view.setTranslationY((float) Math.max(0, i11));
        }
        View view2 = this.f37211g;
        if (view2 != null) {
            view2.setTranslationY((float) Math.min(0, i11));
        }
    }

    public void j(int i11, int i12) {
        this.f37205a = i11;
        this.f37206b = i12;
    }

    public View k() {
        return this.f37209e;
    }

    public void l(int i11) {
        View view = this.f37209e;
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i11);
        } else if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i11);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i11);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i11);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i11);
        }
    }

    public void layout(int i11, int i12, int i13, int i14) {
        this.f37207c.layout(i11, i12, i13, i14);
    }

    public boolean m() {
        return this.f37212h && this.f37215k.b(this.f37207c);
    }

    public void n() {
        this.f37214j = null;
    }

    public void o(k kVar) {
        if (kVar instanceof ScrollBoundaryDeciderAdapter) {
            this.f37215k = (ScrollBoundaryDeciderAdapter) kVar;
        } else {
            this.f37215k.e(kVar);
        }
    }

    public void p(View view, i iVar) {
        C0508a aVar = null;
        this.f37209e = null;
        boolean isInEditMode = this.f37207c.isInEditMode();
        while (true) {
            View view2 = this.f37209e;
            if (view2 == null || ((view2 instanceof t) && !(view2 instanceof p))) {
                view = r(view, view2 == null);
                if (view != this.f37209e) {
                    if (!isInEditMode) {
                        if (aVar == null) {
                            aVar = new C0508a();
                        }
                        DesignUtil.a(view, iVar, aVar);
                    }
                    this.f37209e = view;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public View q(View view, MotionEvent motionEvent, View view2) {
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            while (childCount > 0) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (!ScrollBoundaryUtil.f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    childCount--;
                } else if (!(childAt instanceof ViewPager) && s(childAt)) {
                    return childAt;
                } else {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return q(childAt, obtain, view2);
                }
            }
        }
        return view2;
    }

    public View r(View view, boolean z11) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(Collections.singletonList(view));
        View view2 = null;
        while (!linkedBlockingQueue.isEmpty() && view2 == null) {
            View view3 = (View) linkedBlockingQueue.poll();
            if (view3 != null) {
                if ((z11 || view3 != view) && s(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                        linkedBlockingQueue.add(viewGroup.getChildAt(i11));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }
}
