package com.caverock.androidsvg;

public class PreserveAspectRatio {

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f64382c = new PreserveAspectRatio((Alignment) null, (Scale) null);

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f64383d = new PreserveAspectRatio(Alignment.none, (Scale) null);

    /* renamed from: e  reason: collision with root package name */
    public static final PreserveAspectRatio f64384e;

    /* renamed from: f  reason: collision with root package name */
    public static final PreserveAspectRatio f64385f;

    /* renamed from: g  reason: collision with root package name */
    public static final PreserveAspectRatio f64386g;

    /* renamed from: h  reason: collision with root package name */
    public static final PreserveAspectRatio f64387h;

    /* renamed from: i  reason: collision with root package name */
    public static final PreserveAspectRatio f64388i;

    /* renamed from: j  reason: collision with root package name */
    public static final PreserveAspectRatio f64389j;

    /* renamed from: k  reason: collision with root package name */
    public static final PreserveAspectRatio f64390k;

    /* renamed from: a  reason: collision with root package name */
    public Alignment f64391a;

    /* renamed from: b  reason: collision with root package name */
    public Scale f64392b;

    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        f64384e = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        f64385f = new PreserveAspectRatio(alignment2, scale);
        f64386g = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        f64387h = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        f64388i = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        f64389j = new PreserveAspectRatio(alignment, scale2);
        f64390k = new PreserveAspectRatio(alignment2, scale2);
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f64391a = alignment;
        this.f64392b = scale;
    }

    public Alignment a() {
        return this.f64391a;
    }

    public Scale b() {
        return this.f64392b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        if (this.f64391a == preserveAspectRatio.f64391a && this.f64392b == preserveAspectRatio.f64392b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f64391a + " " + this.f64392b;
    }
}
