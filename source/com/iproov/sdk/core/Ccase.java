package com.iproov.sdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ToneGenerator;
import android.util.Size;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p017implements.Cnative;
import com.iproov.sdk.p019interface.Cif;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.utils.Cfor;
import java.util.Objects;

/* renamed from: com.iproov.sdk.core.case  reason: invalid class name */
public class Ccase {

    /* renamed from: return  reason: not valid java name */
    private static final Cfor.Cdo f234return = Cfor.Cdo.FIT;

    /* renamed from: static  reason: not valid java name */
    private static final Cnative f235static = new Cnative(0.0d, 0.0d, 0.0d);

    /* renamed from: break  reason: not valid java name */
    private Csuper f236break;

    /* renamed from: case  reason: not valid java name */
    private final int f237case;

    /* renamed from: catch  reason: not valid java name */
    private Rect f238catch;

    /* renamed from: class  reason: not valid java name */
    private Rect f239class;

    /* renamed from: const  reason: not valid java name */
    private Cnative f240const;

    /* renamed from: do  reason: not valid java name */
    private final Cif f241do;

    /* renamed from: else  reason: not valid java name */
    private final ToneGenerator f242else;

    /* renamed from: final  reason: not valid java name */
    private Cnative f243final;

    /* renamed from: for  reason: not valid java name */
    private final Rect f244for;

    /* renamed from: goto  reason: not valid java name */
    private Rect f245goto;

    /* renamed from: if  reason: not valid java name */
    private final Rect f246if;

    /* renamed from: import  reason: not valid java name */
    private double f247import;

    /* renamed from: native  reason: not valid java name */
    private int f248native = 0;

    /* renamed from: new  reason: not valid java name */
    private final Cdo f249new;

    /* renamed from: public  reason: not valid java name */
    private double f250public = 0.0d;

    /* renamed from: super  reason: not valid java name */
    private Cnative f251super;

    /* renamed from: this  reason: not valid java name */
    private Cnative f252this;

    /* renamed from: throw  reason: not valid java name */
    private Cnative f253throw;

    /* renamed from: try  reason: not valid java name */
    private final Celse f254try;

    /* renamed from: while  reason: not valid java name */
    private Cnative f255while;

    /* renamed from: com.iproov.sdk.core.case$do  reason: invalid class name */
    public interface Cdo {
        /* renamed from: do  reason: not valid java name */
        com.iproov.sdk.p015goto.Cif m326do(com.iproov.sdk.p021new.Cfor forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, com.iproov.sdk.p015goto.Cif ifVar, int i11, int i12, int i13);

        /* renamed from: do  reason: not valid java name */
        void m327do(Rect rect, Rect rect2, Rect rect3, Rect rect4);

        /* renamed from: do  reason: not valid java name */
        void m328do(Rect rect, RectF rectF);

        /* renamed from: do  reason: not valid java name */
        void m329do(Double d11, Double d12);
    }

    public Ccase(Context context, Cnew newR, Size size, Size size2, Celse elseR, Cdo doVar, Orientation orientation) {
        this.f241do = new Cif(context.getApplicationContext());
        boolean z11 = !orientation.isPortrait();
        this.f246if = new Rect(0, 0, z11 ? size.getHeight() : size.getWidth(), z11 ? size.getWidth() : size.getHeight());
        this.f244for = new Rect(0, 0, size2.getWidth(), size2.getHeight());
        this.f249new = doVar;
        newR.m1205for();
        this.f254try = elseR;
        this.f242else = m318do();
        this.f237case = Math.max(1, elseR.m375goto());
    }

    /* renamed from: do  reason: not valid java name */
    private void m320do(com.iproov.sdk.p021new.Cfor forR, RectF rectF) {
        this.f248native++;
        int i11 = this.f248native;
        if (this.f242else == null) {
            return;
        }
        if (i11 == this.f254try.m372else()) {
            this.f242else.startTone(0, 50);
        } else {
            this.f242else.startTone(10, 50);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m322if(Rect rect) {
        this.f249new.m327do(m317do(this.f245goto), m317do(this.f239class), m317do(rect), m317do(this.f238catch));
    }

    /* renamed from: do  reason: not valid java name */
    private Rect m317do(Rect rect) {
        return Cfor.m2237do(rect, this.f246if, this.f244for, f234return);
    }

    /* renamed from: if  reason: not valid java name */
    public int m325if() {
        return this.f254try.m372else();
    }

    /* renamed from: do  reason: not valid java name */
    private ToneGenerator m318do() {
        if (this.f241do.m1105catch()) {
            try {
                return new ToneGenerator(3, 100);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: do  reason: not valid java name */
    public void m324do(Size size) {
        this.f244for.right = size.getWidth();
        this.f244for.bottom = size.getHeight();
    }

    /* renamed from: do  reason: not valid java name */
    public com.iproov.sdk.p015goto.Cif m323do(com.iproov.sdk.p021new.Cfor forR, Bitmap bitmap, FaceFeature faceFeature, Rect rect) {
        RectF rectF = faceFeature != null ? new RectF(faceFeature.getFaceBounds().left / ((float) rect.width()), faceFeature.getFaceBounds().top / ((float) rect.height()), faceFeature.getFaceBounds().right / ((float) rect.width()), faceFeature.getFaceBounds().bottom / ((float) rect.height())) : null;
        com.iproov.sdk.p015goto.Cif ifVar = m319do(forR, faceFeature, rect, rectF);
        if (rectF == null || ifVar == com.iproov.sdk.p015goto.Cif.NO_FACE_PATH) {
            return ifVar;
        }
        return this.f249new.m326do(forR, bitmap, faceFeature, rectF, ifVar, this.f248native, m325if(), this.f237case);
    }

    /* renamed from: do  reason: not valid java name */
    private com.iproov.sdk.p015goto.Cif m319do(com.iproov.sdk.p021new.Cfor forR, FaceFeature faceFeature, Rect rect, RectF rectF) {
        com.iproov.sdk.p021new.Cfor forR2 = forR;
        RectF rectF2 = rectF;
        Double valueOf = Double.valueOf(0.0d);
        Double valueOf2 = Double.valueOf(1.0d);
        if (faceFeature == null) {
            m322if((Rect) null);
            if (this.f248native != this.f254try.m372else()) {
                return this.f245goto == null ? com.iproov.sdk.p015goto.Cif.NO_FACE_PATH : com.iproov.sdk.p015goto.Cif.FACE_PATH;
            }
            this.f249new.m329do(valueOf2, valueOf);
            return com.iproov.sdk.p015goto.Cif.END_FACE_PATH;
        }
        Rect rect2 = Cfor.m2237do(Cfor.m2238do(faceFeature.getFaceBounds()), rect, this.f246if, f234return);
        m322if(rect2);
        if (this.f245goto == null) {
            if (m321do(rectF)) {
                return com.iproov.sdk.p015goto.Cif.NO_FACE_PATH;
            }
            this.f245goto = rect2;
            this.f252this = Cfor.m2243if(rect2);
            Csuper superR = new Csuper(this.f245goto, this.f246if, this.f254try, rectF2);
            this.f236break = superR;
            Rect rect3 = superR.m442do(this.f244for);
            this.f238catch = rect3;
            RectF rectF3 = Cfor.m2239do(rect3, this.f246if);
            Objects.toString(this.f238catch);
            Objects.toString(this.f246if);
            Objects.toString(rectF3);
            this.f249new.m328do(this.f238catch, rectF3);
            m320do(forR2, rectF2);
            Rect rect4 = Cfor.m2235do(this.f238catch, (float) this.f254try.m371do());
            this.f239class = rect4;
            rect4.offset(0, (int) (((double) this.f238catch.height()) * -0.05d));
            Cnative nativeR = Cfor.m2243if(this.f239class);
            this.f240const = nativeR;
            Cnative nativeR2 = nativeR.m1027new(this.f252this).m1028try(this.f254try.m378super());
            this.f243final = nativeR2;
            Cnative nativeR3 = f235static;
            this.f251super = nativeR2.m1024for(nativeR3);
            this.f253throw = this.f243final.m1026if(nativeR3);
            double d11 = this.f243final.m1025if();
            this.f247import = d11;
            this.f255while = this.f243final.m1022do(1.0d / d11);
            this.f245goto.toShortString();
            this.f238catch.toShortString();
            this.f239class.toShortString();
            faceFeature.getFaceBounds().toShortString();
            this.f246if.toShortString();
            this.f244for.toShortString();
            this.f249new.m329do(valueOf, Double.valueOf(Cfor.m2242if(Cfor.m2241for(rect2), Cfor.m2241for(this.f239class)) / ((double) this.f246if.width())));
            return com.iproov.sdk.p015goto.Cif.FACE_PATH;
        } else if (this.f236break == null) {
            return com.iproov.sdk.p015goto.Cif.NO_FACE_PATH;
        } else {
            if (this.f248native >= this.f254try.m372else()) {
                this.f249new.m329do(valueOf2, valueOf);
                return com.iproov.sdk.p015goto.Cif.END_FACE_PATH;
            }
            this.f250public = Cfor.m2243if(rect2).m1027new(this.f252this).m1028try(this.f254try.m378super()).m1023do(this.f251super, this.f253throw).m1020do(this.f255while) / this.f247import;
            double d12 = (this.f254try.m373final() * ((double) this.f248native)) / ((double) (this.f254try.m372else() - 1));
            double width = (((double) rect2.width()) * 1.0d) / ((double) this.f239class.width());
            double abs = Math.abs(1.0d - width);
            double d13 = width;
            double max = Math.max((((double) rect2.width()) * 1.0d) / ((double) this.f245goto.width()), (((double) this.f245goto.width()) * 1.0d) / ((double) rect2.width()));
            double d14 = Cfor.m2242if(Cfor.m2241for(rect2), Cfor.m2241for(this.f239class)) / ((double) this.f246if.width());
            Double d15 = valueOf2;
            this.f249new.m329do(Double.valueOf(Math.min(this.f250public, 0.8999999761581421d)), Double.valueOf(d14));
            if (this.f248native < this.f254try.m372else() - 1 && this.f250public > d12) {
                m320do(forR2, rectF2);
            } else if (this.f248native == this.f254try.m372else() - 1 && d14 < this.f254try.m377new() && abs < this.f254try.m381try() && max > this.f254try.m367case()) {
                m320do(forR2, rectF2);
            }
            if (this.f248native == this.f254try.m372else()) {
                this.f249new.m329do(d15, Double.valueOf(d14));
                return com.iproov.sdk.p015goto.Cif.END_FACE_PATH;
            } else if (d14 > this.f254try.m377new()) {
                return com.iproov.sdk.p015goto.Cif.FACE_PATH;
            } else {
                return d13 < 1.0d ? com.iproov.sdk.p015goto.Cif.TOO_FAR_FACE_PATH : com.iproov.sdk.p015goto.Cif.TOO_CLOSE_FACE_PATH;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static boolean m321do(RectF rectF) {
        return rectF.left <= 0.0f || rectF.top <= 0.0f || rectF.right >= 1.0f || rectF.bottom >= 1.0f;
    }
}
