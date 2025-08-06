package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.h0;
import androidx.fragment.R$styleable;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class FragmentContainerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final List<View> f9548b;

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f9549c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f9550d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9551e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9552a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            return onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public FragmentContainerView(Context context) {
        super(context);
        this.f9548b = new ArrayList();
        this.f9549c = new ArrayList();
        this.f9551e = true;
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public final void a(View view) {
        if (this.f9549c.contains(view)) {
            this.f9548b.add(view);
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.J0(view) != null) {
            super.addView(view, i11, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        WindowInsetsCompat x11 = WindowInsetsCompat.x(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f9550d;
        if (onApplyWindowInsetsListener != null) {
            windowInsetsCompat = WindowInsetsCompat.x(a.f9552a.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            windowInsetsCompat = h0.i0(this, x11);
        }
        if (!windowInsetsCompat.q()) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                h0.j(getChildAt(i11), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f9551e) {
            for (View drawChild : this.f9548b) {
                super.drawChild(canvas, drawChild, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        if (!this.f9551e || !(!this.f9548b.isEmpty()) || !this.f9548b.contains(view)) {
            return super.drawChild(canvas, view, j11);
        }
        return false;
    }

    public void endViewTransition(View view) {
        this.f9549c.remove(view);
        if (this.f9548b.remove(view)) {
            this.f9551e = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return FragmentManager.o0(this).l0(getId());
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                a(getChildAt(childCount));
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i11) {
        a(getChildAt(i11));
        super.removeViewAt(i11);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i11, int i12) {
        int i13 = i11 + i12;
        for (int i14 = i11; i14 < i13; i14++) {
            a(getChildAt(i14));
        }
        super.removeViews(i11, i12);
    }

    public void removeViewsInLayout(int i11, int i12) {
        int i13 = i11 + i12;
        for (int i14 = i11; i14 < i13; i14++) {
            a(getChildAt(i14));
        }
        super.removeViewsInLayout(i11, i12);
    }

    public final void setDrawDisappearingViewsLast(boolean z11) {
        this.f9551e = z11;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f9550d = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            this.f9549c.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        String str;
        this.f9548b = new ArrayList();
        this.f9549c = new ArrayList();
        this.f9551e = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = Constants.CLASS;
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
            }
        }
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        this.f9548b = new ArrayList();
        this.f9549c = new ArrayList();
        this.f9551e = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment l02 = fragmentManager.l0(id2);
        if (classAttribute != null && l02 == null) {
            if (id2 == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a11 = fragmentManager.z0().a(context.getClassLoader(), classAttribute);
            a11.mFragmentId = id2;
            a11.mContainerId = id2;
            a11.mTag = string;
            a11.mFragmentManager = fragmentManager;
            a11.mHost = fragmentManager.C0();
            a11.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.q().z(true).d(this, a11, string).m();
        }
        fragmentManager.h1(this);
    }
}
