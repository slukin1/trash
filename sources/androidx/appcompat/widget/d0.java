package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import c.a;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4555a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f4556b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f4557c;

    public d0(Context context, TypedArray typedArray) {
        this.f4555a = context;
        this.f4556b = typedArray;
    }

    public static d0 t(Context context, int i11, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(i11, iArr));
    }

    public static d0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static d0 v(Context context, AttributeSet attributeSet, int[] iArr, int i11, int i12) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr, i11, i12));
    }

    public boolean a(int i11, boolean z11) {
        return this.f4556b.getBoolean(i11, z11);
    }

    public int b(int i11, int i12) {
        return this.f4556b.getColor(i11, i12);
    }

    public ColorStateList c(int i11) {
        int resourceId;
        ColorStateList a11;
        if (!this.f4556b.hasValue(i11) || (resourceId = this.f4556b.getResourceId(i11, 0)) == 0 || (a11 = a.a(this.f4555a, resourceId)) == null) {
            return this.f4556b.getColorStateList(i11);
        }
        return a11;
    }

    public float d(int i11, float f11) {
        return this.f4556b.getDimension(i11, f11);
    }

    public int e(int i11, int i12) {
        return this.f4556b.getDimensionPixelOffset(i11, i12);
    }

    public int f(int i11, int i12) {
        return this.f4556b.getDimensionPixelSize(i11, i12);
    }

    public Drawable g(int i11) {
        int resourceId;
        if (!this.f4556b.hasValue(i11) || (resourceId = this.f4556b.getResourceId(i11, 0)) == 0) {
            return this.f4556b.getDrawable(i11);
        }
        return a.b(this.f4555a, resourceId);
    }

    public Drawable h(int i11) {
        int resourceId;
        if (!this.f4556b.hasValue(i11) || (resourceId = this.f4556b.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.b().d(this.f4555a, resourceId, true);
    }

    public float i(int i11, float f11) {
        return this.f4556b.getFloat(i11, f11);
    }

    public Typeface j(int i11, int i12, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f4556b.getResourceId(i11, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f4557c == null) {
            this.f4557c = new TypedValue();
        }
        return ResourcesCompat.i(this.f4555a, resourceId, this.f4557c, i12, fontCallback);
    }

    public int k(int i11, int i12) {
        return this.f4556b.getInt(i11, i12);
    }

    public int l(int i11, int i12) {
        return this.f4556b.getInteger(i11, i12);
    }

    public int m(int i11, int i12) {
        return this.f4556b.getLayoutDimension(i11, i12);
    }

    public int n(int i11, int i12) {
        return this.f4556b.getResourceId(i11, i12);
    }

    public String o(int i11) {
        return this.f4556b.getString(i11);
    }

    public CharSequence p(int i11) {
        return this.f4556b.getText(i11);
    }

    public CharSequence[] q(int i11) {
        return this.f4556b.getTextArray(i11);
    }

    public TypedArray r() {
        return this.f4556b;
    }

    public boolean s(int i11) {
        return this.f4556b.hasValue(i11);
    }

    public void w() {
        this.f4556b.recycle();
    }
}
