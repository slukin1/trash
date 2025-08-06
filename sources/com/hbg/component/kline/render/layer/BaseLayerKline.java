package com.hbg.component.kline.render.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.SparseArray;
import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.render.buffer.DataBuffer;
import com.hbg.component.kline.render.buffer.DataBufferManager;
import com.hbg.component.kline.shape.BSTShape;
import com.hbg.component.kline.utils.CalculateKLineUtils;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import java.util.HashMap;
import java.util.List;
import v5.b;
import v5.c;
import v5.d;
import v5.e;
import v5.f;
import v5.g;
import v5.h;
import v5.i;
import v5.q;

public abstract class BaseLayerKline extends q {

    /* renamed from: f0  reason: collision with root package name */
    public DataBuffer.c f67319f0;

    /* renamed from: g0  reason: collision with root package name */
    public DataBuffer.c f67320g0;

    /* renamed from: h0  reason: collision with root package name */
    public SparseArray<Path> f67321h0 = new SparseArray<>();

    /* renamed from: i0  reason: collision with root package name */
    public SparseArray<Path> f67322i0 = new SparseArray<>();

    /* renamed from: j0  reason: collision with root package name */
    public SparseArray<Path> f67323j0 = new SparseArray<>();

    /* renamed from: k0  reason: collision with root package name */
    public SparseArray<Path> f67324k0 = new SparseArray<>();

    /* renamed from: l0  reason: collision with root package name */
    public SparseArray<Path> f67325l0 = new SparseArray<>();

    /* renamed from: m0  reason: collision with root package name */
    public HashMap<String, Path> f67326m0 = new HashMap<>();

    /* renamed from: n0  reason: collision with root package name */
    public Path f67327n0 = new Path();

    /* renamed from: t0  reason: collision with root package name */
    public Path f67328t0 = new Path();

    /* renamed from: u0  reason: collision with root package name */
    public Path f67329u0 = new Path();

    /* renamed from: v0  reason: collision with root package name */
    public DataBuffer.c f67330v0;

    /* renamed from: w0  reason: collision with root package name */
    public DataBuffer.c f67331w0;

    /* renamed from: x0  reason: collision with root package name */
    public Path f67332x0 = new Path();

    /* renamed from: y0  reason: collision with root package name */
    public Path f67333y0 = new Path();

    public enum Boll {
        HIGH,
        MID,
        LOW
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67334a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.component.kline.render.layer.BaseLayerKline$Boll[] r0 = com.hbg.component.kline.render.layer.BaseLayerKline.Boll.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f67334a = r0
                com.hbg.component.kline.render.layer.BaseLayerKline$Boll r1 = com.hbg.component.kline.render.layer.BaseLayerKline.Boll.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f67334a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.component.kline.render.layer.BaseLayerKline$Boll r1 = com.hbg.component.kline.render.layer.BaseLayerKline.Boll.MID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f67334a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.component.kline.render.layer.BaseLayerKline$Boll r1 = com.hbg.component.kline.render.layer.BaseLayerKline.Boll.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.component.kline.render.layer.BaseLayerKline.a.<clinit>():void");
        }
    }

    public BaseLayerKline(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        int z22 = candleStickRender.z2() << 2;
        Class cls = DataBuffer.c.class;
        DataBuffer.BufferType bufferType = CandleStickRender.G2;
        this.f67319f0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.f67320g0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.f67330v0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
        this.f67331w0 = (DataBuffer.c) DataBufferManager.d(z22, bufferType, cls);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(int i11, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            K0(d1(dataSetIndex.d()), this.f68327x.f67221d1, dataSetIndex.d(), this.f68327x.P);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(int i11, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            K0(Z0(dataSetIndex.d()), this.f68327x.f67212a1, dataSetIndex.d(), this.f68327x.O);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(int i11, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            K0(b1(dataSetIndex.d()), this.f68327x.Z0, dataSetIndex.d(), this.f68327x.O);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(int i11, int i12, int i13, DataSetIndex dataSetIndex) {
        Path a12 = a1(dataSetIndex.c() + dataSetIndex.d());
        a12.reset();
        boolean z11 = false;
        while (i11 <= i12) {
            Double d11 = (Double) this.f68327x.f67224e1.get(i11).get(dataSetIndex.c() + dataSetIndex.d());
            this.f68320q[0] = D(i11);
            this.f68320q[1] = d11 == null ? 0.0f : d11.floatValue();
            float[] fArr = this.f68320q;
            if (fArr[1] != 0.0f || z11) {
                this.f68327x.Q.mapPoints(fArr);
                if (!z11) {
                    float[] fArr2 = this.f68320q;
                    a12.moveTo(fArr2[0], fArr2[1]);
                    z11 = true;
                } else {
                    float[] fArr3 = this.f68320q;
                    a12.lineTo(fArr3[0], fArr3[1]);
                }
            }
            i11++;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j1(int i11, int i12, int i13, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            Path c12 = c1(dataSetIndex.d());
            c12.reset();
            boolean z11 = false;
            while (i11 <= i12) {
                Double d11 = (Double) this.f68327x.f67215b1.get(i11).get(Integer.valueOf(dataSetIndex.d()));
                this.f68320q[0] = D(i11);
                this.f68320q[1] = d11 == null ? 0.0f : d11.floatValue();
                float[] fArr = this.f68320q;
                if (fArr[1] != 0.0f || z11) {
                    this.f68327x.Q.mapPoints(fArr);
                    if (!z11) {
                        float[] fArr2 = this.f68320q;
                        c12.moveTo(fArr2[0], fArr2[1]);
                        z11 = true;
                    } else {
                        float[] fArr3 = this.f68320q;
                        c12.lineTo(fArr3[0], fArr3[1]);
                    }
                }
                i11++;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(int i11, int i12, int i13, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            Path e12 = e1(dataSetIndex.d());
            e12.reset();
            boolean z11 = false;
            while (i11 <= i12) {
                Double d11 = (Double) this.f68327x.f67218c1.get(i11).get(Integer.valueOf(dataSetIndex.d()));
                this.f68320q[0] = D(i11);
                this.f68320q[1] = d11 == null ? 0.0f : d11.floatValue();
                float[] fArr = this.f68320q;
                if (fArr[1] != 0.0f || z11) {
                    this.f68327x.Q.mapPoints(fArr);
                    if (!z11) {
                        float[] fArr2 = this.f68320q;
                        e12.moveTo(fArr2[0], fArr2[1]);
                        z11 = true;
                    } else {
                        float[] fArr3 = this.f68320q;
                        e12.lineTo(fArr3[0], fArr3[1]);
                    }
                }
                i11++;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1() {
        this.f67319f0.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(int i11, KlineInfo klineInfo) {
        double d11;
        float[] fArr = this.f68320q;
        float D = D(i11);
        fArr[0] = D;
        float open = (float) klineInfo.getOpen();
        float close = (float) klineInfo.getClose();
        if (this.f68327x.V4()) {
            d11 = klineInfo.getVol();
        } else {
            d11 = klineInfo.getAmount();
        }
        float f11 = (float) d11;
        if (close >= open) {
            this.f67319f0.d(new float[]{D, 0.0f, D, f11});
            return;
        }
        this.f67319f0.e(new float[]{D, 0.0f, D, f11});
    }

    public void F() {
        super.F();
        J0();
    }

    public final void I0(Path path, Boll boll) {
        CandleStickRender candleStickRender = this.f68327x;
        int i11 = candleStickRender.f67272t0;
        int i12 = candleStickRender.f67276u0;
        if (E(i11) || E(i12)) {
            path.reset();
            float[] fArr = new float[2];
            boolean z11 = false;
            while (i11 <= i12) {
                KlineInfo klineInfo = this.f68327x.Y0.get(i11);
                fArr[0] = D(i11);
                int i13 = a.f67334a[boll.ordinal()];
                if (i13 == 1) {
                    fArr[1] = (float) klineInfo.getBollLow();
                } else if (i13 == 2) {
                    fArr[1] = (float) klineInfo.getBollMid();
                } else if (i13 == 3) {
                    fArr[1] = (float) klineInfo.getBollHigh();
                }
                if (fArr[1] != 0.0f) {
                    this.f68327x.O.mapPoints(fArr);
                    if (!z11) {
                        path.moveTo(fArr[0], fArr[1]);
                        z11 = true;
                    } else {
                        path.lineTo(fArr[0], fArr[1]);
                    }
                }
                i11++;
            }
        }
    }

    public void J0() {
        int i11;
        if (this.f68327x.B3()) {
            if (((float) this.f68327x.d1()) > ((float) this.f68327x.i1()) * 1.5f) {
                i11 = CandleStickRender.f67206v2 + 2;
            } else {
                i11 = CandleStickRender.f67206v2 + 4;
            }
            CandleStickRender candleStickRender = this.f68327x;
            candleStickRender.A0 = candleStickRender.f67282w0 - ((float) i11);
            candleStickRender.u(candleStickRender.O);
            this.f68327x.O.preTranslate(0.0f, this.f68315l.height() - this.f68331z.bottom);
            Matrix matrix = this.f68327x.O;
            CandleStickRender candleStickRender2 = this.f68327x;
            matrix.preScale(1.0f, (float) (((double) this.f68331z.height()) / (candleStickRender2.B0 - candleStickRender2.C0)));
            CandleStickRender candleStickRender3 = this.f68327x;
            candleStickRender3.O.preTranslate(0.0f, (float) (-candleStickRender3.C0));
            if (this.W) {
                O0();
            }
            if (this.f68327x.e3() != null && this.f68327x.e3().size() > 0) {
                P0();
            }
            if ((this.f68327x.f67238j0 & 1) == 1) {
                N0();
            }
            if ((this.f68327x.f67238j0 & 2) == 2) {
                M0();
            }
            if ((this.f68327x.f67238j0 & 4) == 4) {
                L0();
            }
            if (this.f68327x.N1() != CandleStickRender.KLineType.TIME_LINE) {
                UtilCollections.c(this.f68327x.o3(), new c(this));
            }
        }
    }

    public final void K0(Path path, List<HashMap<Integer, Double>> list, int i11, Matrix matrix) {
        CandleStickRender candleStickRender = this.f68327x;
        int i12 = candleStickRender.f67272t0;
        int i13 = candleStickRender.f67276u0;
        if (E(i12) || E(i13)) {
            path.reset();
            boolean z11 = false;
            while (i12 <= i13) {
                this.f68320q[0] = D(i12);
                Double d11 = (Double) list.get(i12).get(Integer.valueOf(i11));
                this.f68320q[1] = d11 == null ? 0.0f : d11.floatValue();
                float[] fArr = this.f68320q;
                if (fArr[1] != 0.0f) {
                    matrix.mapPoints(fArr);
                    if (!z11) {
                        float[] fArr2 = this.f68320q;
                        path.moveTo(fArr2[0], fArr2[1]);
                        z11 = true;
                    } else {
                        float[] fArr3 = this.f68320q;
                        path.lineTo(fArr3[0], fArr3[1]);
                    }
                }
                i12++;
            }
            path.rLineTo(0.0f, 0.0f);
        }
    }

    public final void L0() {
        I0(this.f67327n0, Boll.HIGH);
        I0(this.f67328t0, Boll.MID);
        I0(this.f67329u0, Boll.LOW);
    }

    public final void M0() {
        if (!UtilCollections.f(this.f68327x.p1())) {
            UtilCollections.c(this.f68327x.p1(), new e(this));
        }
    }

    public void N() {
        super.N();
        this.f67321h0.clear();
        this.f67322i0.clear();
        this.f67323j0.clear();
        this.f67325l0.clear();
        this.f67324k0.clear();
        this.f67326m0.clear();
        this.f67319f0.a();
        this.f67320g0.a();
        this.f67319f0.a();
        this.f67320g0.a();
        this.f67330v0.a();
        this.f67331w0.a();
    }

    public final void N0() {
        if (!UtilCollections.f(this.f68327x.P2())) {
            UtilCollections.c(this.f68327x.P2(), new d(this));
        }
    }

    public final void O0() {
        CandleStickRender candleStickRender = this.f68327x;
        candleStickRender.u(candleStickRender.P);
        this.f68327x.P.preTranslate(0.0f, this.f68315l.height() - this.E.bottom);
        this.f68327x.P.preScale(1.0f, (float) (((double) (this.E.height() - this.R)) / this.f68327x.F0));
        Q0();
    }

    public final void P0() {
        CandleStickRender candleStickRender = this.f68327x;
        int i11 = candleStickRender.f67272t0;
        int i12 = candleStickRender.f67276u0;
        if (E(i11) && E(i12)) {
            if (this.f68327x.e3().contains("MACD")) {
                double[] A = CalculateKLineUtils.A(this.f68327x.Y0, i11, i12, "MACD");
                CandleStickRender candleStickRender2 = this.f68327x;
                candleStickRender2.u(candleStickRender2.Q);
                this.f68327x.Q.preTranslate(0.0f, this.f68315l.height() - this.F.bottom);
                this.f68327x.Q.preScale(1.0f, (float) (((double) (this.F.height() - this.R)) / (A[0] - A[1])));
                this.f68327x.Q.preTranslate(0.0f, (float) (-A[1]));
                this.f67332x0.reset();
                this.f67333y0.reset();
                this.f67330v0.a();
                boolean z11 = false;
                boolean z12 = false;
                for (int i13 = i11; i13 <= i12; i13++) {
                    KlineInfo klineInfo = this.f68327x.Y0.get(i13);
                    this.f68320q[0] = D(i13);
                    if (klineInfo.getDif() != 0.0d) {
                        this.f68320q[1] = (float) klineInfo.getDif();
                        this.f68327x.Q.mapPoints(this.f68320q);
                        if (!z11) {
                            Path path = this.f67332x0;
                            float[] fArr = this.f68320q;
                            path.moveTo(fArr[0], fArr[1]);
                            z11 = true;
                        } else {
                            Path path2 = this.f67332x0;
                            float[] fArr2 = this.f68320q;
                            path2.lineTo(fArr2[0], fArr2[1]);
                        }
                    }
                    if (klineInfo.getDea() != 0.0d) {
                        this.f68320q[1] = (float) klineInfo.getDea();
                        this.f68327x.Q.mapPoints(this.f68320q);
                        if (!z12) {
                            Path path3 = this.f67333y0;
                            float[] fArr3 = this.f68320q;
                            path3.moveTo(fArr3[0], fArr3[1]);
                            z12 = true;
                        } else {
                            Path path4 = this.f67333y0;
                            float[] fArr4 = this.f68320q;
                            path4.lineTo(fArr4[0], fArr4[1]);
                        }
                    }
                    float[] fArr5 = new float[4];
                    float[] fArr6 = this.f68320q;
                    fArr5[0] = fArr6[0];
                    fArr5[2] = fArr6[0];
                    fArr5[1] = (float) klineInfo.getMacd();
                    fArr5[3] = 0.0f;
                    if (klineInfo.getMacd() > 0.0d) {
                        this.f67330v0.d(fArr5);
                    } else {
                        this.f67330v0.e(fArr5);
                    }
                }
                this.f68327x.Q.mapPoints(this.f67331w0.f67303e, this.f67330v0.f67303e);
                this.f67331w0.f(this.f67330v0);
            }
            if (this.f68327x.e3().contains("KDJ")) {
                double[] z13 = CalculateKLineUtils.z(this.f68327x.f67224e1, i11, i12);
                CandleStickRender candleStickRender3 = this.f68327x;
                candleStickRender3.u(candleStickRender3.Q);
                this.f68327x.Q.preTranslate(0.0f, this.f68315l.height() - this.G.bottom);
                this.f68327x.Q.preScale(1.0f, (float) (((double) (this.G.height() - this.R)) / (z13[0] - z13[1])));
                this.f68327x.Q.preTranslate(0.0f, (float) (-z13[1]));
                UtilCollections.c(this.f68327x.P1(), new g(this, i11, i12));
            }
            if (this.f68327x.e3().contains("RSI")) {
                double[] y11 = CalculateKLineUtils.y(this.f68327x.f67215b1, i11, i12);
                CandleStickRender candleStickRender4 = this.f68327x;
                candleStickRender4.u(candleStickRender4.Q);
                this.f68327x.Q.preTranslate(0.0f, this.f68315l.height() - this.H.bottom);
                this.f68327x.Q.preScale(1.0f, (float) (((double) (this.H.height() - this.R)) / (y11[0] - y11[1])));
                this.f68327x.Q.preTranslate(0.0f, (float) (-y11[1]));
                UtilCollections.c(this.f68327x.V2(), new i(this, i11, i12));
            }
            if (this.f68327x.e3().contains("WR")) {
                double[] y12 = CalculateKLineUtils.y(this.f68327x.f67218c1, i11, i12);
                CandleStickRender candleStickRender5 = this.f68327x;
                candleStickRender5.u(candleStickRender5.Q);
                this.f68327x.Q.preTranslate(0.0f, this.f68315l.height() - this.I.bottom);
                this.f68327x.Q.preScale(1.0f, (float) (((double) (this.I.height() - this.R)) / (y12[0] - y12[1])));
                this.f68327x.Q.preTranslate(0.0f, (float) (-y12[1]));
                UtilCollections.c(this.f68327x.t3(), new h(this, i11, i12));
            }
        }
    }

    public final void Q0() {
        A(new b(this), new f(this));
        this.f68327x.P.mapPoints(this.f67320g0.f67303e, this.f67319f0.f67303e);
        this.f67320g0.f(this.f67319f0);
    }

    public void R0(Canvas canvas) {
        List<BSTShape> list;
        int i11;
        int i12;
        List<BSTShape> list2;
        int i13;
        int i14;
        List<BSTShape> list3;
        int i15;
        int i16;
        if (!this.f68327x.q2().isIdentity()) {
            int Y2 = this.f68327x.Y2();
            int Z2 = this.f68327x.Z2();
            KlineInfo klineInfo = this.f68327x.z1().get(Y2);
            KlineInfo klineInfo2 = this.f68327x.z1().get(Z2);
            long id2 = klineInfo.getId();
            long id3 = klineInfo2.getId();
            List<BSTShape> W2 = this.f68327x.W2();
            if (W2 != null && W2.size() > 0) {
                int size = W2.size();
                int i17 = 0;
                while (i17 < size) {
                    BSTShape bSTShape = W2.get(i17);
                    long time = bSTShape.getTime();
                    if (time < id2 || time > id3) {
                        i16 = i17;
                        i15 = size;
                        list3 = W2;
                    } else {
                        i16 = i17;
                        i15 = size;
                        list3 = W2;
                        V0(canvas, bSTShape, klineInfo, klineInfo2, Y2, Z2, true);
                    }
                    i17 = i16 + 1;
                    size = i15;
                    W2 = list3;
                }
            }
            List<BSTShape> r02 = this.f68327x.r0();
            if (r02 != null && r02.size() > 0) {
                int size2 = r02.size();
                int i18 = 0;
                while (i18 < size2) {
                    BSTShape bSTShape2 = r02.get(i18);
                    long time2 = bSTShape2.getTime();
                    if (time2 < id2 || time2 > id3) {
                        i14 = i18;
                        i13 = size2;
                        list2 = r02;
                    } else {
                        i14 = i18;
                        i13 = size2;
                        list2 = r02;
                        V0(canvas, bSTShape2, klineInfo, klineInfo2, Y2, Z2, false);
                    }
                    i18 = i14 + 1;
                    size2 = i13;
                    r02 = list2;
                }
            }
            List<BSTShape> j32 = this.f68327x.j3();
            if (j32 != null && j32.size() > 0) {
                int size3 = j32.size();
                int i19 = 0;
                while (i19 < size3) {
                    BSTShape bSTShape3 = j32.get(i19);
                    long time3 = bSTShape3.getTime();
                    if (time3 < id2 || time3 > id3) {
                        i12 = i19;
                        i11 = size3;
                        list = j32;
                    } else {
                        Canvas canvas2 = canvas;
                        BSTShape bSTShape4 = bSTShape3;
                        KlineInfo klineInfo3 = klineInfo;
                        KlineInfo klineInfo4 = klineInfo2;
                        i12 = i19;
                        int i21 = Y2;
                        i11 = size3;
                        int i22 = Z2;
                        list = j32;
                        V0(canvas2, bSTShape4, klineInfo3, klineInfo4, i21, i22, true);
                        V0(canvas2, bSTShape4, klineInfo3, klineInfo4, i21, i22, false);
                    }
                    i19 = i12 + 1;
                    size3 = i11;
                    j32 = list;
                }
            }
        }
    }

    public void S0(Canvas canvas, DataBuffer.c cVar) {
        this.f68317n.setColor(this.f68327x.Q0());
        canvas.drawLines(cVar.f67303e, 0, cVar.g() + 1, this.f68317n);
        this.f68317n.setColor(this.f68327x.J0());
        canvas.drawLines(cVar.f67303e, cVar.h(), cVar.c() - cVar.h(), this.f68317n);
    }

    public void T0(Canvas canvas) {
        if ((this.f68327x.f67238j0 & 1) == 1) {
            for (int i11 = 0; i11 < this.f67321h0.size(); i11++) {
                Path valueAt = this.f67321h0.valueAt(i11);
                int keyAt = this.f67321h0.keyAt(i11);
                if (valueAt != null) {
                    PaintUtils.f(this.f68317n, this.f68327x.O2(keyAt), (float) CandleStickRender.f67208x2);
                    canvas.drawPath(valueAt, this.f68317n);
                }
            }
        }
        if ((this.f68327x.f67238j0 & 2) == 2) {
            for (int i12 = 0; i12 < this.f67322i0.size(); i12++) {
                Path valueAt2 = this.f67322i0.valueAt(i12);
                int keyAt2 = this.f67322i0.keyAt(i12);
                if (valueAt2 != null) {
                    PaintUtils.f(this.f68317n, this.f68327x.o1(keyAt2), (float) CandleStickRender.f67208x2);
                    canvas.drawPath(valueAt2, this.f68317n);
                }
            }
        }
        if ((this.f68327x.f67238j0 & 4) == 4) {
            PaintUtils.d(this.f68317n, 0, (float) CandleStickRender.f67208x2);
            this.f68317n.setColor(this.f68327x.K1()[1]);
            canvas.drawPath(this.f67328t0, this.f68317n);
            this.f68317n.setColor(this.f68327x.K1()[2]);
            canvas.drawPath(this.f67327n0, this.f68317n);
            this.f68317n.setColor(this.f68327x.K1()[3]);
            canvas.drawPath(this.f67329u0, this.f68317n);
        }
    }

    public final void U0(Canvas canvas) {
        if (this.f68327x.e3() != null && this.f68327x.e3().size() > 0) {
            PaintUtils.d(this.f68317n, this.f68327x.K1()[0], (float) CandleStickRender.f67208x2);
            if (this.f68327x.e3().contains("MACD")) {
                S0(canvas, this.f67331w0);
                this.f68317n.setColor(this.f68327x.K1()[1]);
                canvas.drawPath(this.f67332x0, this.f68317n);
                this.f68317n.setColor(this.f68327x.K1()[2]);
                canvas.drawPath(this.f67333y0, this.f68317n);
            }
            if (this.f68327x.e3().contains("KDJ")) {
                for (String next : this.f67326m0.keySet()) {
                    Path path = this.f67326m0.get(next);
                    int Y0 = Y0(this.f68327x.P1(), next);
                    if (path != null) {
                        PaintUtils.f(this.f68317n, Y0, (float) CandleStickRender.f67208x2);
                        canvas.drawPath(path, this.f68317n);
                    }
                }
            }
            if (this.f68327x.e3().contains("RSI")) {
                for (int i11 = 0; i11 < this.f67325l0.size(); i11++) {
                    Path valueAt = this.f67325l0.valueAt(i11);
                    int X0 = X0(this.f68327x.V2(), this.f67325l0.keyAt(i11));
                    if (valueAt != null) {
                        PaintUtils.f(this.f68317n, X0, (float) CandleStickRender.f67208x2);
                        canvas.drawPath(valueAt, this.f68317n);
                    }
                }
            }
            if (this.f68327x.e3().contains("WR")) {
                for (int i12 = 0; i12 < this.f67324k0.size(); i12++) {
                    Path valueAt2 = this.f67324k0.valueAt(i12);
                    int X02 = X0(this.f68327x.t3(), this.f67324k0.keyAt(i12));
                    if (valueAt2 != null) {
                        PaintUtils.f(this.f68317n, X02, (float) CandleStickRender.f67208x2);
                        canvas.drawPath(valueAt2, this.f68317n);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V0(android.graphics.Canvas r18, com.hbg.component.kline.shape.BSTShape r19, com.hbg.lib.network.pro.socket.bean.KlineInfo r20, com.hbg.lib.network.pro.socket.bean.KlineInfo r21, int r22, int r23, boolean r24) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r22
            float[] r4 = r19.getPoints()
            long r5 = r21.getTime()
            long r7 = r20.getTime()
            long r5 = r5 - r7
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r8 = 0
            if (r7 == 0) goto L_0x002e
            long r9 = (long) r3
            int r3 = r23 - r3
            long r11 = (long) r3
            long r13 = r19.getTime()
            long r15 = r20.getTime()
            long r13 = r13 - r15
            long r11 = r11 * r13
            long r11 = r11 / r5
            long r9 = r9 + r11
            int r3 = (int) r9
            goto L_0x002f
        L_0x002e:
            r3 = r8
        L_0x002f:
            com.hbg.component.kline.render.CandleStickRender r5 = r0.f68327x
            java.util.List<com.hbg.lib.network.pro.socket.bean.KlineInfo> r5 = r5.Y0
            java.lang.Object r5 = r5.get(r3)
            com.hbg.lib.network.pro.socket.bean.KlineInfo r5 = (com.hbg.lib.network.pro.socket.bean.KlineInfo) r5
            float r3 = r0.D(r3)
            r4[r8] = r3
            com.hbg.lib.network.hbg.core.bean.BSTInfo$BSTInfoBean r3 = r2.bstInfoBean
            r5.extraInfoBean = r3
            r3 = 1
            if (r24 == 0) goto L_0x004e
            double r5 = r5.getHigh()
            float r5 = (float) r5
            r4[r3] = r5
            goto L_0x0055
        L_0x004e:
            double r5 = r5.getLow()
            float r5 = (float) r5
            r4[r3] = r5
        L_0x0055:
            com.hbg.component.kline.render.CandleStickRender r5 = r0.f68327x
            android.graphics.Matrix r5 = r5.q2()
            r5.mapPoints(r4)
            if (r24 == 0) goto L_0x006d
            r5 = r4[r3]
            android.graphics.RectF r6 = r0.f68331z
            float r6 = r6.top
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x006d
            r4[r3] = r6
            goto L_0x007b
        L_0x006d:
            if (r24 != 0) goto L_0x007b
            r5 = r4[r3]
            android.graphics.RectF r6 = r0.f68331z
            float r6 = r6.bottom
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x007b
            r4[r3] = r6
        L_0x007b:
            if (r24 == 0) goto L_0x0081
            r2.drawTopSell(r1)
            goto L_0x0084
        L_0x0081:
            r2.drawBottomBuy(r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.component.kline.render.layer.BaseLayerKline.V0(android.graphics.Canvas, com.hbg.component.kline.shape.BSTShape, com.hbg.lib.network.pro.socket.bean.KlineInfo, com.hbg.lib.network.pro.socket.bean.KlineInfo, int, int, boolean):void");
    }

    public void W0(Canvas canvas) {
        for (int i11 = 0; i11 < this.f67323j0.size(); i11++) {
            Path valueAt = this.f67323j0.valueAt(i11);
            int keyAt = this.f67323j0.keyAt(i11);
            if (valueAt != null) {
                PaintUtils.f(this.f68317n, this.f68327x.n3(keyAt), (float) CandleStickRender.f67208x2);
                canvas.drawPath(valueAt, this.f68317n);
            }
        }
    }

    public final int X0(List<DataSetIndex> list, int i11) {
        for (DataSetIndex next : list) {
            if (next.d() == i11) {
                return next.b();
            }
        }
        return 0;
    }

    public final int Y0(List<DataSetIndex> list, String str) {
        for (DataSetIndex next : list) {
            if (str.equals(next.c() + next.d())) {
                return next.b();
            }
        }
        return 0;
    }

    public final Path Z0(int i11) {
        if (this.f67322i0.get(i11) == null) {
            this.f67322i0.put(i11, new Path());
        }
        return this.f67322i0.get(i11);
    }

    public final Path a1(String str) {
        if (this.f67326m0.get(str) == null) {
            this.f67326m0.put(str, new Path());
        }
        return this.f67326m0.get(str);
    }

    public final Path b1(int i11) {
        if (this.f67321h0.get(i11) == null) {
            this.f67321h0.put(i11, new Path());
        }
        return this.f67321h0.get(i11);
    }

    public final Path c1(int i11) {
        if (this.f67325l0.get(i11) == null) {
            this.f67325l0.put(i11, new Path());
        }
        return this.f67325l0.get(i11);
    }

    public final Path d1(int i11) {
        if (this.f67323j0.get(i11) == null) {
            this.f67323j0.put(i11, new Path());
        }
        return this.f67323j0.get(i11);
    }

    public final Path e1(int i11) {
        if (this.f67324k0.get(i11) == null) {
            this.f67324k0.put(i11, new Path());
        }
        return this.f67324k0.get(i11);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DataBufferManager.e(this.f67319f0);
        DataBufferManager.e(this.f67320g0);
        DataBufferManager.e(this.f67330v0);
        DataBufferManager.e(this.f67331w0);
    }

    public void y(Canvas canvas) {
        U0(canvas);
    }
}
