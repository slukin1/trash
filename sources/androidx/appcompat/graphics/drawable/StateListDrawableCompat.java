package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;

public class StateListDrawableCompat extends DrawableContainerCompat {

    /* renamed from: n  reason: collision with root package name */
    public a f4006n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4007o;

    public static class a extends DrawableContainerCompat.d {
        public int[][] J;

        public a(a aVar, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(aVar, stateListDrawableCompat, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        public int A(int[] iArr, Drawable drawable) {
            int a11 = a(drawable);
            this.J[a11] = iArr;
            return a11;
        }

        public int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int h11 = h();
            for (int i11 = 0; i11 < h11; i11++) {
                if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                    return i11;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, (Resources) null);
        }

        public void o(int i11, int i12) {
            super.o(i11, i12);
            int[][] iArr = new int[i12][];
            System.arraycopy(this.J, 0, iArr, 0, i11);
            this.J = iArr;
        }

        public void s() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this((a) null, (Resources) null);
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public void h(DrawableContainerCompat.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f4006n = (a) dVar;
        }
    }

    public boolean isStateful() {
        return true;
    }

    /* renamed from: j */
    public a b() {
        return new a(this.f4006n, this, (Resources) null);
    }

    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i11 = 0;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i12);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i13 = i11 + 1;
                if (!attributeSet.getAttributeBooleanValue(i12, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i11] = attributeNameResource;
                i11 = i13;
            }
        }
        return StateSet.trimStateSet(iArr, i11);
    }

    public Drawable mutate() {
        if (!this.f4007o && super.mutate() == this) {
            this.f4006n.s();
            this.f4007o = true;
        }
        return this;
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int B = this.f4006n.B(iArr);
        if (B < 0) {
            B = this.f4006n.B(StateSet.WILD_CARD);
        }
        return g(B) || onStateChange;
    }

    public StateListDrawableCompat(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    public StateListDrawableCompat(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }
}
