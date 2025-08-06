package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import l0.a;

public abstract class ConstraintHelper extends View {

    /* renamed from: b  reason: collision with root package name */
    public int[] f7919b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    public int f7920c;

    /* renamed from: d  reason: collision with root package name */
    public Context f7921d;

    /* renamed from: e  reason: collision with root package name */
    public a f7922e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7923f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f7924g;

    /* renamed from: h  reason: collision with root package name */
    public String f7925h;

    /* renamed from: i  reason: collision with root package name */
    public View[] f7926i = null;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<Integer, String> f7927j = new HashMap<>();

    public ConstraintHelper(Context context) {
        super(context);
        this.f7921d = context;
        k((AttributeSet) null);
    }

    public final void a(String str) {
        if (str != null && str.length() != 0 && this.f7921d != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int i11 = i(trim);
            if (i11 != 0) {
                this.f7927j.put(Integer.valueOf(i11), trim);
                b(i11);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    public final void b(int i11) {
        if (i11 != getId()) {
            int i12 = this.f7920c + 1;
            int[] iArr = this.f7919b;
            if (i12 > iArr.length) {
                this.f7919b = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f7919b;
            int i13 = this.f7920c;
            iArr2[i13] = i11;
            this.f7920c = i13 + 1;
        }
    }

    public final void c(String str) {
        if (str != null && str.length() != 0 && this.f7921d != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = constraintLayout.getChildAt(i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).f7931b0)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        b(childAt.getId());
                    }
                }
            }
        }
    }

    public void d() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            e((ConstraintLayout) parent);
        }
    }

    public void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i11 = 0; i11 < this.f7920c; i11++) {
            View viewById = constraintLayout.getViewById(this.f7919b[i11]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void f(ConstraintLayout constraintLayout) {
    }

    public final int[] g(View view, String str) {
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        for (String trim : split) {
            int i12 = i(trim.trim());
            if (i12 != 0) {
                iArr[i11] = i12;
                i11++;
            }
        }
        return i11 != split.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f7919b, this.f7920c);
    }

    public final int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f7921d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int i(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i11 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i11 = ((Integer) designInformation).intValue();
            }
        }
        if (i11 == 0 && constraintLayout != null) {
            i11 = h(constraintLayout, str);
        }
        if (i11 == 0) {
            try {
                i11 = R$id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i11 == 0 ? this.f7921d.getResources().getIdentifier(str, "id", this.f7921d.getPackageName()) : i11;
    }

    public View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f7926i;
        if (viewArr == null || viewArr.length != this.f7920c) {
            this.f7926i = new View[this.f7920c];
        }
        for (int i11 = 0; i11 < this.f7920c; i11++) {
            this.f7926i[i11] = constraintLayout.getViewById(this.f7919b[i11]);
        }
        return this.f7926i;
    }

    public void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7924g = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f7925h = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintSet.Layout layout = constraint.f8000e;
        int[] iArr = layout.f8036j0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.f8038k0;
            if (str != null && str.length() > 0) {
                ConstraintSet.Layout layout2 = constraint.f8000e;
                layout2.f8036j0 = g(this, layout2.f8038k0);
            }
        }
        helperWidget.b();
        if (constraint.f8000e.f8036j0 != null) {
            int i11 = 0;
            while (true) {
                int[] iArr2 = constraint.f8000e.f8036j0;
                if (i11 < iArr2.length) {
                    ConstraintWidget constraintWidget = sparseArray.get(iArr2[i11]);
                    if (constraintWidget != null) {
                        helperWidget.a(constraintWidget);
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void m(ConstraintWidget constraintWidget, boolean z11) {
    }

    public void n(ConstraintLayout constraintLayout) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7924g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f7925h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i11, int i12) {
        if (this.f7923f) {
            super.onMeasure(i11, i12);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintWidgetContainer constraintWidgetContainer, a aVar, SparseArray<ConstraintWidget> sparseArray) {
        aVar.b();
        for (int i11 = 0; i11 < this.f7920c; i11++) {
            aVar.a(sparseArray.get(this.f7919b[i11]));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f7927j.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f7924g
            r5.setIds(r0)
        L_0x000b:
            l0.a r0 = r5.f7922e
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.b()
            r0 = 0
        L_0x0014:
            int r1 = r5.f7920c
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f7919b
            r1 = r1[r0]
            android.view.View r2 = r6.getViewById(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f7927j
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.h(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f7919b
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f7927j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.getViewById(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            l0.a r1 = r5.f7922e
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.getViewWidget(r2)
            r1.a(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            l0.a r0 = r5.f7922e
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r6.mLayoutWidget
            r0.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.r(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void s() {
        if (this.f7922e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f7969u0 = (ConstraintWidget) this.f7922e;
            }
        }
    }

    public void setIds(String str) {
        this.f7924g = str;
        if (str != null) {
            int i11 = 0;
            this.f7920c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    a(str.substring(i11));
                    return;
                } else {
                    a(str.substring(i11, indexOf));
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f7925h = str;
        if (str != null) {
            int i11 = 0;
            this.f7920c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    c(str.substring(i11));
                    return;
                } else {
                    c(str.substring(i11, indexOf));
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f7924g = null;
        this.f7920c = 0;
        for (int b11 : iArr) {
            b(b11);
        }
    }

    public void setTag(int i11, Object obj) {
        super.setTag(i11, obj);
        if (obj == null && this.f7924g == null) {
            b(i11);
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7921d = context;
        k(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7921d = context;
        k(attributeSet);
    }
}
