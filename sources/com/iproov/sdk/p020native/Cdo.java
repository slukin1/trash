package com.iproov.sdk.p020native;

import android.graphics.Rect;
import android.util.Size;

/* renamed from: com.iproov.sdk.native.do  reason: invalid class name and invalid package */
public class Cdo {

    /* renamed from: do  reason: not valid java name */
    private float f1004do = 1.0f;

    /* renamed from: for  reason: not valid java name */
    private float f1005for = 0.5f;

    /* renamed from: if  reason: not valid java name */
    private float f1006if = 1.0f;

    /* renamed from: new  reason: not valid java name */
    private float f1007new = 0.5f;

    /* renamed from: do  reason: not valid java name */
    private float m1130do(float f11, float f12, float f13, float f14) {
        return (((f11 / f12) * f13) - f14) / (f13 - 1.0f);
    }

    /* renamed from: case  reason: not valid java name */
    public float m1134case() {
        return this.f1006if;
    }

    /* renamed from: do  reason: not valid java name */
    public float m1135do() {
        return this.f1005for;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1138for(float f11) {
        this.f1007new = f11;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1140if(float f11) {
        this.f1005for = f11;
    }

    /* renamed from: new  reason: not valid java name */
    public void m1141new(float f11) {
        this.f1004do = f11;
    }

    /* renamed from: try  reason: not valid java name */
    public float m1142try() {
        return this.f1004do;
    }

    /* renamed from: for  reason: not valid java name */
    private int m1132for() {
        return com.iproov.sdk.p029super.Cdo.m1852do();
    }

    /* renamed from: new  reason: not valid java name */
    private int m1133new() {
        return com.iproov.sdk.p029super.Cdo.m1856if();
    }

    /* renamed from: do  reason: not valid java name */
    public void m1136do(int i11, int i12) {
        float f11 = ((float) i11) / ((float) i12);
        m1141new(f11);
        m1143try(f11);
    }

    /* renamed from: if  reason: not valid java name */
    public float m1139if() {
        return this.f1007new;
    }

    /* renamed from: try  reason: not valid java name */
    public void m1143try(float f11) {
        this.f1006if = f11;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1137do(Rect rect, Size size) {
        float f11;
        float f12;
        float f13;
        size.getHeight();
        rect.height();
        float width = ((float) size.getWidth()) / ((float) size.getHeight());
        float f14 = ((float) m1133new()) / ((float) m1132for());
        if (f14 < width) {
            Size size2 = new Size(m1133new(), (int) (((float) m1133new()) / width));
            int width2 = (int) (((float) size2.getWidth()) * (((float) rect.width()) / ((float) size.getWidth())));
            f13 = ((float) m1132for()) / ((float) new Size(width2, (int) (((float) width2) / f14)).getHeight());
            float width3 = ((float) rect.left) * ((((float) size2.getWidth()) * 1.0f) / ((float) size.getWidth()));
            float f15 = (((float) (m1132for() - size2.getHeight())) / 2.0f) + (((float) (size.getHeight() - rect.bottom)) * ((((float) size2.getHeight()) * 1.0f) / ((float) size.getHeight())));
            f12 = m1130do(width3, (float) m1133new(), f13, 0.0f);
            f11 = m1130do(f15, (float) m1132for(), f13, 0.0f);
        } else {
            Size size3 = new Size((int) (((float) m1132for()) * width), m1132for());
            int height = (int) (((float) size3.getHeight()) * (((float) rect.height()) / ((float) size.getHeight())));
            f13 = ((float) m1132for()) / ((float) new Size((int) (((float) height) * f14), height).getHeight());
            float f16 = m1130do((((float) (m1133new() - size3.getWidth())) / 2.0f) + (((float) rect.left) * ((((float) size3.getWidth()) * 1.0f) / ((float) size.getWidth()))), (float) m1133new(), f13, 0.0f);
            f11 = m1130do(((float) (size.getHeight() - rect.bottom)) * ((((float) size3.getHeight()) * 1.0f) / ((float) size.getHeight())), (float) m1132for(), f13, 0.0f);
            f12 = f16;
        }
        m1131do(f13);
        m1138for(f11);
        m1140if(f12);
    }

    /* renamed from: do  reason: not valid java name */
    private void m1131do(float f11) {
        this.f1004do = f11;
        this.f1006if = f11;
    }
}
