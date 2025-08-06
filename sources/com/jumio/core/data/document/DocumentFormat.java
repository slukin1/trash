package com.jumio.core.data.document;

public enum DocumentFormat {
    NONE(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d),
    ID1(0.136d, 0.136d, 0.0675d, 0.0675d, 1.585185185185185d, 0.24000000000000002d, 0.09546296296296297d),
    ID2(0.0936d, 0.0936d, 0.0675d, 0.0675d, 1.4189189189189189d, 0.17162162162162162d, 0.08412162162162162d),
    ID3(0.022d, 0.022d, 0.022d, 0.022d, 1.4119318181818181d, 0.2353181818181818d, 0.0d);
    

    /* renamed from: a  reason: collision with root package name */
    public final double f39107a;

    /* renamed from: b  reason: collision with root package name */
    public final double f39108b;

    /* renamed from: c  reason: collision with root package name */
    public final double f39109c;

    /* renamed from: d  reason: collision with root package name */
    public final double f39110d;

    /* renamed from: e  reason: collision with root package name */
    public final double f39111e;

    /* renamed from: f  reason: collision with root package name */
    public final double f39112f;

    /* renamed from: g  reason: collision with root package name */
    public final double f39113g;

    /* access modifiers changed from: public */
    DocumentFormat(double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        this.f39107a = d11;
        this.f39108b = d12;
        this.f39109c = d13;
        this.f39110d = d14;
        this.f39111e = d15;
        this.f39112f = d16;
        this.f39113g = d17;
    }

    public double getMarginBottom() {
        return this.f39113g;
    }

    public double getOverlayBottom() {
        return this.f39108b;
    }

    public int getOverlayBottomInPx(int i11) {
        return (int) (((double) i11) * this.f39108b);
    }

    public double getOverlayLeft() {
        return this.f39109c;
    }

    public int getOverlayLeftInPx(int i11) {
        return (int) (((double) i11) * this.f39109c);
    }

    public double getOverlayRatio() {
        return this.f39111e;
    }

    public double getOverlayRight() {
        return this.f39110d;
    }

    public int getOverlayRightInPx(int i11) {
        return (int) (((double) i11) * this.f39110d);
    }

    public double getOverlayTop() {
        return this.f39107a;
    }

    public int getOverlayTopInPx(int i11) {
        return (int) (((double) i11) * this.f39107a);
    }

    public double getRoiHeight() {
        return this.f39112f;
    }

    public int getRoiHeightInPx(int i11) {
        return (int) (((double) (i11 - (getOverlayTopInPx(i11) * 2))) * this.f39112f);
    }

    public int getRoiMarginBottomPx(int i11) {
        return (int) (((double) (i11 - (getOverlayTopInPx(i11) * 2))) * this.f39113g);
    }
}
