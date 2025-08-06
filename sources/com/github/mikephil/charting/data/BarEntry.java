package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import e5.j;

@SuppressLint({"ParcelCreator"})
public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private j[] mRanges;
    private float[] mYVals;

    public BarEntry(float f11, float f12) {
        super(f11, f12);
    }

    private void calcPosNegSum() {
        float[] fArr = this.mYVals;
        if (fArr == null) {
            this.mNegativeSum = 0.0f;
            this.mPositiveSum = 0.0f;
            return;
        }
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (float f13 : fArr) {
            if (f13 <= 0.0f) {
                f11 += Math.abs(f13);
            } else {
                f12 += f13;
            }
        }
        this.mNegativeSum = f11;
        this.mPositiveSum = f12;
    }

    private static float calcSum(float[] fArr) {
        float f11 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f12 : fArr) {
            f11 += f12;
        }
        return f11;
    }

    public void calcRanges() {
        float[] yVals = getYVals();
        if (yVals != null && yVals.length != 0) {
            this.mRanges = new j[yVals.length];
            float f11 = -getNegativeSum();
            int i11 = 0;
            float f12 = 0.0f;
            while (true) {
                j[] jVarArr = this.mRanges;
                if (i11 < jVarArr.length) {
                    float f13 = yVals[i11];
                    if (f13 < 0.0f) {
                        float f14 = f11 - f13;
                        jVarArr[i11] = new j(f11, f14);
                        f11 = f14;
                    } else {
                        float f15 = f13 + f12;
                        jVarArr[i11] = new j(f12, f15);
                        f12 = f15;
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    @Deprecated
    public float getBelowSum(int i11) {
        return getSumBelow(i11);
    }

    public float getNegativeSum() {
        return this.mNegativeSum;
    }

    public float getPositiveSum() {
        return this.mPositiveSum;
    }

    public j[] getRanges() {
        return this.mRanges;
    }

    public float getSumBelow(int i11) {
        float[] fArr = this.mYVals;
        float f11 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        while (length > i11 && length >= 0) {
            f11 += this.mYVals[length];
            length--;
        }
        return f11;
    }

    public float getY() {
        return super.getY();
    }

    public float[] getYVals() {
        return this.mYVals;
    }

    public boolean isStacked() {
        return this.mYVals != null;
    }

    public void setVals(float[] fArr) {
        setY(calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f11, float f12, Object obj) {
        super(f11, f12, obj);
    }

    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.mYVals);
        return barEntry;
    }

    public BarEntry(float f11, float f12, Drawable drawable) {
        super(f11, f12, drawable);
    }

    public BarEntry(float f11, float f12, Drawable drawable, Object obj) {
        super(f11, f12, drawable, obj);
    }

    public BarEntry(float f11, float[] fArr) {
        super(f11, calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f11, float[] fArr, Object obj) {
        super(f11, calcSum(fArr), obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f11, float[] fArr, Drawable drawable) {
        super(f11, calcSum(fArr), drawable);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f11, float[] fArr, Drawable drawable, Object obj) {
        super(f11, calcSum(fArr), drawable, obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }
}
