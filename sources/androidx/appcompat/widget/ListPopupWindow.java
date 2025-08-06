package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import androidx.core.widget.k;
import java.lang.reflect.Method;

public class ListPopupWindow implements h.e {
    public static Method H;
    public static Method I;
    public static Method J;
    public final e A;
    public Runnable B;
    public final Handler C;
    public final Rect D;
    public Rect E;
    public boolean F;
    public PopupWindow G;

    /* renamed from: b  reason: collision with root package name */
    public Context f4424b;

    /* renamed from: c  reason: collision with root package name */
    public ListAdapter f4425c;

    /* renamed from: d  reason: collision with root package name */
    public DropDownListView f4426d;

    /* renamed from: e  reason: collision with root package name */
    public int f4427e;

    /* renamed from: f  reason: collision with root package name */
    public int f4428f;

    /* renamed from: g  reason: collision with root package name */
    public int f4429g;

    /* renamed from: h  reason: collision with root package name */
    public int f4430h;

    /* renamed from: i  reason: collision with root package name */
    public int f4431i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4432j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4433k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4434l;

    /* renamed from: m  reason: collision with root package name */
    public int f4435m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4436n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4437o;

    /* renamed from: p  reason: collision with root package name */
    public int f4438p;

    /* renamed from: q  reason: collision with root package name */
    public View f4439q;

    /* renamed from: r  reason: collision with root package name */
    public int f4440r;

    /* renamed from: s  reason: collision with root package name */
    public DataSetObserver f4441s;

    /* renamed from: t  reason: collision with root package name */
    public View f4442t;

    /* renamed from: u  reason: collision with root package name */
    public Drawable f4443u;

    /* renamed from: v  reason: collision with root package name */
    public AdapterView.OnItemClickListener f4444v;

    /* renamed from: w  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f4445w;

    /* renamed from: x  reason: collision with root package name */
    public final i f4446x;

    /* renamed from: y  reason: collision with root package name */
    public final h f4447y;

    /* renamed from: z  reason: collision with root package name */
    public final g f4448z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            View q11 = ListPopupWindow.this.q();
            if (q11 != null && q11.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
            DropDownListView dropDownListView;
            if (i11 != -1 && (dropDownListView = ListPopupWindow.this.f4426d) != null) {
                dropDownListView.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i11, boolean z11) {
            return popupWindow.getMaxAvailableHeight(view, i11, z11);
        }
    }

    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z11) {
            popupWindow.setIsClippedToScreen(z11);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            ListPopupWindow.this.o();
        }
    }

    public class f extends DataSetObserver {
        public f() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i11) {
            if (i11 == 1 && !ListPopupWindow.this.x() && ListPopupWindow.this.G.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.removeCallbacks(listPopupWindow.f4446x);
                ListPopupWindow.this.f4446x.run();
            }
        }
    }

    public class h implements View.OnTouchListener {
        public h() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.G) != null && popupWindow.isShowing() && x11 >= 0 && x11 < ListPopupWindow.this.G.getWidth() && y11 >= 0 && y11 < ListPopupWindow.this.G.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.postDelayed(listPopupWindow.f4446x, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.C.removeCallbacks(listPopupWindow2.f4446x);
                return false;
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f4426d;
            if (dropDownListView != null && h0.Z(dropDownListView) && ListPopupWindow.this.f4426d.getCount() > ListPopupWindow.this.f4426d.getChildCount()) {
                int childCount = ListPopupWindow.this.f4426d.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f4438p) {
                    listPopupWindow.G.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                H = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                I = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, R$attr.listPopupWindowStyle);
    }

    public void A(View view) {
        this.f4442t = view;
    }

    public void B(int i11) {
        this.G.setAnimationStyle(i11);
    }

    public void C(int i11) {
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            this.f4428f = rect.left + rect.right + i11;
            return;
        }
        N(i11);
    }

    public void D(int i11) {
        this.f4435m = i11;
    }

    public void E(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void F(int i11) {
        this.G.setInputMethodMode(i11);
    }

    public void G(boolean z11) {
        this.F = z11;
        this.G.setFocusable(z11);
    }

    public void H(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void I(AdapterView.OnItemClickListener onItemClickListener) {
        this.f4444v = onItemClickListener;
    }

    public void J(boolean z11) {
        this.f4434l = true;
        this.f4433k = z11;
    }

    public final void K(boolean z11) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = H;
            if (method != null) {
                try {
                    method.invoke(this.G, new Object[]{Boolean.valueOf(z11)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            d.b(this.G, z11);
        }
    }

    public void L(int i11) {
        this.f4440r = i11;
    }

    public void M(int i11) {
        DropDownListView dropDownListView = this.f4426d;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i11);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i11, true);
            }
        }
    }

    public void N(int i11) {
        this.f4428f = i11;
    }

    public Drawable b() {
        return this.G.getBackground();
    }

    public void c(int i11) {
        this.f4430h = i11;
        this.f4432j = true;
    }

    public void dismiss() {
        this.G.dismiss();
        z();
        this.G.setContentView((View) null);
        this.f4426d = null;
        this.C.removeCallbacks(this.f4446x);
    }

    public int f() {
        if (!this.f4432j) {
            return 0;
        }
        return this.f4430h;
    }

    public ListView h() {
        return this.f4426d;
    }

    public int i() {
        return this.f4429g;
    }

    public boolean isShowing() {
        return this.G.isShowing();
    }

    public void j(int i11) {
        this.f4429g = i11;
    }

    public void m(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f4441s;
        if (dataSetObserver == null) {
            this.f4441s = new f();
        } else {
            ListAdapter listAdapter2 = this.f4425c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f4425c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f4441s);
        }
        DropDownListView dropDownListView = this.f4426d;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f4425c);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n() {
        /*
            r12 = this;
            androidx.appcompat.widget.DropDownListView r0 = r12.f4426d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00be
            android.content.Context r0 = r12.f4424b
            androidx.appcompat.widget.ListPopupWindow$a r5 = new androidx.appcompat.widget.ListPopupWindow$a
            r5.<init>()
            r12.B = r5
            boolean r5 = r12.F
            r5 = r5 ^ r3
            androidx.appcompat.widget.DropDownListView r5 = r12.p(r0, r5)
            r12.f4426d = r5
            android.graphics.drawable.Drawable r6 = r12.f4443u
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            android.widget.ListAdapter r6 = r12.f4425c
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            android.widget.AdapterView$OnItemClickListener r6 = r12.f4444v
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            r5.setFocusable(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            androidx.appcompat.widget.ListPopupWindow$b r6 = new androidx.appcompat.widget.ListPopupWindow$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            androidx.appcompat.widget.ListPopupWindow$g r6 = r12.f4448z
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f4445w
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.DropDownListView r6 = r12.f4426d
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.DropDownListView r5 = r12.f4426d
            android.view.View r6 = r12.f4439q
            if (r6 == 0) goto L_0x00b7
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f4440r
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f4440r
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f4428f
            if (r0 < 0) goto L_0x009b
            r5 = r1
            goto L_0x009d
        L_0x009b:
            r0 = r4
            r5 = r0
        L_0x009d:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b8
        L_0x00b7:
            r0 = r4
        L_0x00b8:
            android.widget.PopupWindow r6 = r12.G
            r6.setContentView(r5)
            goto L_0x00dc
        L_0x00be:
            android.widget.PopupWindow r0 = r12.G
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f4439q
            if (r0 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dc
        L_0x00db:
            r0 = r4
        L_0x00dc:
            android.widget.PopupWindow r5 = r12.G
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f8
            android.graphics.Rect r6 = r12.D
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.D
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f4432j
            if (r7 != 0) goto L_0x00fe
            int r6 = -r6
            r12.f4430h = r6
            goto L_0x00fe
        L_0x00f8:
            android.graphics.Rect r5 = r12.D
            r5.setEmpty()
            r5 = r4
        L_0x00fe:
            android.widget.PopupWindow r6 = r12.G
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r3 = r4
        L_0x0109:
            android.view.View r4 = r12.q()
            int r6 = r12.f4430h
            int r3 = r12.r(r4, r6, r3)
            boolean r4 = r12.f4436n
            if (r4 != 0) goto L_0x017a
            int r4 = r12.f4427e
            if (r4 != r2) goto L_0x011c
            goto L_0x017a
        L_0x011c:
            int r4 = r12.f4428f
            r6 = -2
            if (r4 == r6) goto L_0x0143
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012a
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015b
        L_0x012a:
            android.content.Context r2 = r12.f4424b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015b
        L_0x0143:
            android.content.Context r2 = r12.f4424b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015b:
            r7 = r1
            androidx.appcompat.widget.DropDownListView r6 = r12.f4426d
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0178
            androidx.appcompat.widget.DropDownListView r2 = r12.f4426d
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r3 = r12.f4426d
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0178:
            int r1 = r1 + r0
            return r1
        L_0x017a:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.n():int");
    }

    public void o() {
        DropDownListView dropDownListView = this.f4426d;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public DropDownListView p(Context context, boolean z11) {
        return new DropDownListView(context, z11);
    }

    public View q() {
        return this.f4442t;
    }

    public final int r(View view, int i11, boolean z11) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.G, view, i11, z11);
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, new Object[]{view, Integer.valueOf(i11), Boolean.valueOf(z11)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.G.getMaxAvailableHeight(view, i11);
    }

    public Object s() {
        if (!isShowing()) {
            return null;
        }
        return this.f4426d.getSelectedItem();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public void show() {
        int n11 = n();
        boolean x11 = x();
        k.b(this.G, this.f4431i);
        boolean z11 = true;
        if (!this.G.isShowing()) {
            int i11 = this.f4428f;
            if (i11 == -1) {
                i11 = -1;
            } else if (i11 == -2) {
                i11 = q().getWidth();
            }
            int i12 = this.f4427e;
            if (i12 == -1) {
                n11 = -1;
            } else if (i12 != -2) {
                n11 = i12;
            }
            this.G.setWidth(i11);
            this.G.setHeight(n11);
            K(true);
            this.G.setOutsideTouchable(!this.f4437o && !this.f4436n);
            this.G.setTouchInterceptor(this.f4447y);
            if (this.f4434l) {
                k.a(this.G, this.f4433k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = J;
                if (method != null) {
                    try {
                        method.invoke(this.G, new Object[]{this.E});
                    } catch (Exception e11) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e11);
                    }
                }
            } else {
                d.a(this.G, this.E);
            }
            k.c(this.G, q(), this.f4429g, this.f4430h, this.f4435m);
            this.f4426d.setSelection(-1);
            if (!this.F || this.f4426d.isInTouchMode()) {
                o();
            }
            if (!this.F) {
                this.C.post(this.A);
            }
        } else if (h0.Z(q())) {
            int i13 = this.f4428f;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = q().getWidth();
            }
            int i14 = this.f4427e;
            if (i14 == -1) {
                if (!x11) {
                    n11 = -1;
                }
                if (x11) {
                    this.G.setWidth(this.f4428f == -1 ? -1 : 0);
                    this.G.setHeight(0);
                } else {
                    this.G.setWidth(this.f4428f == -1 ? -1 : 0);
                    this.G.setHeight(-1);
                }
            } else if (i14 != -2) {
                n11 = i14;
            }
            PopupWindow popupWindow = this.G;
            if (this.f4437o || this.f4436n) {
                z11 = false;
            }
            popupWindow.setOutsideTouchable(z11);
            this.G.update(q(), this.f4429g, this.f4430h, i13 < 0 ? -1 : i13, n11 < 0 ? -1 : n11);
        }
    }

    public long t() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f4426d.getSelectedItemId();
    }

    public int u() {
        if (!isShowing()) {
            return -1;
        }
        return this.f4426d.getSelectedItemPosition();
    }

    public View v() {
        if (!isShowing()) {
            return null;
        }
        return this.f4426d.getSelectedView();
    }

    public int w() {
        return this.f4428f;
    }

    public boolean x() {
        return this.G.getInputMethodMode() == 2;
    }

    public boolean y() {
        return this.F;
    }

    public final void z() {
        View view = this.f4439q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f4439q);
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f4427e = -2;
        this.f4428f = -2;
        this.f4431i = 1002;
        this.f4435m = 0;
        this.f4436n = false;
        this.f4437o = false;
        this.f4438p = Integer.MAX_VALUE;
        this.f4440r = 0;
        this.f4446x = new i();
        this.f4447y = new h();
        this.f4448z = new g();
        this.A = new e();
        this.D = new Rect();
        this.f4424b = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i11, i12);
        this.f4429g = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f4430h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f4432j = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i11, i12);
        this.G = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
