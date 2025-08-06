package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.core.view.n0;
import androidx.core.widget.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {

    /* renamed from: b  reason: collision with root package name */
    public final Rect f4402b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public int f4403c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f4404d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f4405e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f4406f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f4407g;

    /* renamed from: h  reason: collision with root package name */
    public d f4408h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4409i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4410j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4411k;

    /* renamed from: l  reason: collision with root package name */
    public n0 f4412l;

    /* renamed from: m  reason: collision with root package name */
    public i f4413m;

    /* renamed from: n  reason: collision with root package name */
    public f f4414n;

    public static class a {
        public static void a(View view, float f11, float f12) {
            view.drawableHotspotChanged(f11, f12);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static Method f4415a;

        /* renamed from: b  reason: collision with root package name */
        public static Method f4416b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f4417c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f4418d = true;

        static {
            Class<AbsListView> cls = AbsListView.class;
            try {
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("positionSelector", new Class[]{cls2, View.class, Boolean.TYPE, cls3, cls3});
                f4415a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls2});
                f4416b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls2});
                f4417c = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }

        public static boolean a() {
            return f4418d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void b(DropDownListView dropDownListView, int i11, View view) {
            try {
                f4415a.invoke(dropDownListView, new Object[]{Integer.valueOf(i11), view, Boolean.FALSE, -1, -1});
                f4416b.invoke(dropDownListView, new Object[]{Integer.valueOf(i11)});
                f4417c.invoke(dropDownListView, new Object[]{Integer.valueOf(i11)});
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z11) {
            absListView.setSelectedChildViewEnabled(z11);
        }
    }

    public static class d extends d.a {

        /* renamed from: c  reason: collision with root package name */
        public boolean f4419c = true;

        public d(Drawable drawable) {
            super(drawable);
        }

        public void c(boolean z11) {
            this.f4419c = z11;
        }

        public void draw(Canvas canvas) {
            if (this.f4419c) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f11, float f12) {
            if (this.f4419c) {
                super.setHotspot(f11, f12);
            }
        }

        public void setHotspotBounds(int i11, int i12, int i13, int i14) {
            if (this.f4419c) {
                super.setHotspotBounds(i11, i12, i13, i14);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f4419c) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z11, boolean z12) {
            if (this.f4419c) {
                return super.setVisible(z11, z12);
            }
            return false;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final Field f4420a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
            f4420a = field;
        }

        public static boolean a(AbsListView absListView) {
            Field field = f4420a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        public static void b(AbsListView absListView, boolean z11) {
            Field field = f4420a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z11));
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f4414n = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f4414n = null;
            dropDownListView.drawableStateChanged();
        }
    }

    public DropDownListView(Context context, boolean z11) {
        super(context, (AttributeSet) null, R$attr.dropDownListViewStyle);
        this.f4410j = z11;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z11) {
        d dVar = this.f4408h;
        if (dVar != null) {
            dVar.c(z11);
        }
    }

    public final void a() {
        this.f4411k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f4407g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        n0 n0Var = this.f4412l;
        if (n0Var != null) {
            n0Var.c();
            this.f4412l = null;
        }
    }

    public final void b(View view, int i11) {
        performItemClick(view, i11, getItemIdAtPosition(i11));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (!this.f4402b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f4402b);
            selector.draw(canvas);
        }
    }

    public int d(int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i17 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        View view = null;
        while (i18 < count) {
            int itemViewType = adapter.getItemViewType(i18);
            if (itemViewType != i19) {
                view = null;
                i19 = itemViewType;
            }
            view = adapter.getView(i18, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i22 = layoutParams.height;
            if (i22 > 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
            } else {
                i16 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i11, i16);
            view.forceLayout();
            if (i18 > 0) {
                i17 += dividerHeight;
            }
            i17 += view.getMeasuredHeight();
            if (i17 >= i14) {
                return (i15 < 0 || i18 <= i15 || i21 <= 0 || i17 == i14) ? i14 : i21;
            }
            if (i15 >= 0 && i18 >= i15) {
                i21 = i17;
            }
            i18++;
        }
        return i17;
    }

    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.f4414n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = r1
            r3 = r2
            goto L_0x0046
        L_0x0011:
            r9 = r1
            r3 = r9
            goto L_0x0046
        L_0x0014:
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = r2
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.i r9 = r7.f4413m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.i r9 = new androidx.core.widget.i
            r9.<init>(r7)
            r7.f4413m = r9
        L_0x005a:
            androidx.core.widget.i r9 = r7.f4413m
            r9.m(r2)
            androidx.core.widget.i r9 = r7.f4413m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.i r8 = r7.f4413m
            if (r8 == 0) goto L_0x006c
            r8.m(r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i11, View view) {
        Rect rect = this.f4402b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f4403c;
        rect.top -= this.f4404d;
        rect.right += this.f4405e;
        rect.bottom += this.f4406f;
        boolean j11 = j();
        if (view.isEnabled() != j11) {
            k(!j11);
            if (i11 != -1) {
                refreshDrawableState();
            }
        }
    }

    public final void g(int i11, View view) {
        Drawable selector = getSelector();
        boolean z11 = true;
        boolean z12 = (selector == null || i11 == -1) ? false : true;
        if (z12) {
            selector.setVisible(false, false);
        }
        f(i11, view);
        if (z12) {
            Rect rect = this.f4402b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z11 = false;
            }
            selector.setVisible(z11, false);
            u0.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    public final void h(int i11, View view, float f11, float f12) {
        g(i11, view);
        Drawable selector = getSelector();
        if (selector != null && i11 != -1) {
            u0.a.k(selector, f11, f12);
        }
    }

    public boolean hasFocus() {
        return this.f4410j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f4410j || super.hasWindowFocus();
    }

    public final void i(View view, int i11, float f11, float f12) {
        View childAt;
        this.f4411k = true;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            a.a(this, f11, f12);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i13 = this.f4407g;
        if (!(i13 == -1 || (childAt = getChildAt(i13 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f4407g = i11;
        float left = f11 - ((float) view.getLeft());
        float top = f12 - ((float) view.getTop());
        if (i12 >= 21) {
            a.a(view, left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i11, view, f11, f12);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public boolean isFocused() {
        return this.f4410j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f4410j && this.f4409i) || super.isInTouchMode();
    }

    public final boolean j() {
        if (androidx.core.os.a.b()) {
            return c.a(this);
        }
        return e.a(this);
    }

    public final void k(boolean z11) {
        if (androidx.core.os.a.b()) {
            c.b(this, z11);
        } else {
            e.b(this, z11);
        }
    }

    public final boolean l() {
        return this.f4411k;
    }

    public final void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public void onDetachedFromWindow() {
        this.f4414n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f4414n == null) {
            f fVar = new f();
            this.f4414n = fVar;
            fVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i11 < 30 || !b.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, pointToPosition, childAt);
                    }
                }
                m();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f4407g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f4414n;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z11) {
        this.f4409i = z11;
    }

    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f4408h = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f4403c = rect.left;
        this.f4404d = rect.top;
        this.f4405e = rect.right;
        this.f4406f = rect.bottom;
    }
}
