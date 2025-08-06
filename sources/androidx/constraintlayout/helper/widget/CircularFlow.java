package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {

    /* renamed from: w  reason: collision with root package name */
    public static int f7332w;

    /* renamed from: x  reason: collision with root package name */
    public static float f7333x;

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f7334m;

    /* renamed from: n  reason: collision with root package name */
    public int f7335n;

    /* renamed from: o  reason: collision with root package name */
    public float[] f7336o;

    /* renamed from: p  reason: collision with root package name */
    public int[] f7337p;

    /* renamed from: q  reason: collision with root package name */
    public int f7338q;

    /* renamed from: r  reason: collision with root package name */
    public int f7339r;

    /* renamed from: s  reason: collision with root package name */
    public String f7340s;

    /* renamed from: t  reason: collision with root package name */
    public String f7341t;

    /* renamed from: u  reason: collision with root package name */
    public Float f7342u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f7343v;

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i11 = 0;
            this.f7339r = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    u(str.substring(i11).trim());
                    return;
                } else {
                    u(str.substring(i11, indexOf).trim());
                    i11 = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i11 = 0;
            this.f7338q = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    v(str.substring(i11).trim());
                    return;
                } else {
                    v(str.substring(i11, indexOf).trim());
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f7336o, this.f7339r);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f7337p, this.f7338q);
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f7335n = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7340s = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f7341t = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f7333x));
                    this.f7342u = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f7332w));
                    this.f7343v = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7340s;
        if (str != null) {
            this.f7336o = new float[1];
            setAngles(str);
        }
        String str2 = this.f7341t;
        if (str2 != null) {
            this.f7337p = new int[1];
            setRadius(str2);
        }
        Float f11 = this.f7342u;
        if (f11 != null) {
            setDefaultAngle(f11.floatValue());
        }
        Integer num = this.f7343v;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        w();
    }

    public void setDefaultAngle(float f11) {
        f7333x = f11;
    }

    public void setDefaultRadius(int i11) {
        f7332w = i11;
    }

    public final void u(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.f7921d != null && (fArr = this.f7336o) != null) {
            if (this.f7339r + 1 > fArr.length) {
                this.f7336o = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.f7336o[this.f7339r] = (float) Integer.parseInt(str);
            this.f7339r++;
        }
    }

    public final void v(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.f7921d != null && (iArr = this.f7337p) != null) {
            if (this.f7338q + 1 > iArr.length) {
                this.f7337p = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.f7337p[this.f7338q] = (int) (((float) Integer.parseInt(str)) * this.f7921d.getResources().getDisplayMetrics().density);
            this.f7338q++;
        }
    }

    public final void w() {
        this.f7334m = (ConstraintLayout) getParent();
        for (int i11 = 0; i11 < this.f7920c; i11++) {
            View viewById = this.f7334m.getViewById(this.f7919b[i11]);
            if (viewById != null) {
                int i12 = f7332w;
                float f11 = f7333x;
                int[] iArr = this.f7337p;
                if (iArr == null || i11 >= iArr.length) {
                    Integer num = this.f7343v;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.f7927j.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f7338q++;
                        if (this.f7337p == null) {
                            this.f7337p = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f7337p = radius;
                        radius[this.f7338q - 1] = i12;
                    }
                } else {
                    i12 = iArr[i11];
                }
                float[] fArr = this.f7336o;
                if (fArr == null || i11 >= fArr.length) {
                    Float f12 = this.f7342u;
                    if (f12 == null || f12.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.f7927j.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f7339r++;
                        if (this.f7336o == null) {
                            this.f7336o = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f7336o = angles;
                        angles[this.f7339r - 1] = f11;
                    }
                } else {
                    f11 = fArr[i11];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.f7960q = f11;
                layoutParams.f7956o = this.f7335n;
                layoutParams.f7958p = i12;
                viewById.setLayoutParams(layoutParams);
            }
        }
        d();
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
