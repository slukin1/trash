package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

public class RenderOptions {

    /* renamed from: a  reason: collision with root package name */
    public CSSParser.n f64393a = null;

    /* renamed from: b  reason: collision with root package name */
    public PreserveAspectRatio f64394b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f64395c = null;

    /* renamed from: d  reason: collision with root package name */
    public SVG.b f64396d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f64397e = null;

    /* renamed from: f  reason: collision with root package name */
    public SVG.b f64398f = null;

    public RenderOptions() {
    }

    public RenderOptions a(String str) {
        this.f64393a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.n nVar = this.f64393a;
        return nVar != null && nVar.f() > 0;
    }

    public boolean c() {
        return this.f64394b != null;
    }

    public boolean d() {
        return this.f64395c != null;
    }

    public boolean e() {
        return this.f64397e != null;
    }

    public boolean f() {
        return this.f64396d != null;
    }

    public boolean g() {
        return this.f64398f != null;
    }

    public RenderOptions h(float f11, float f12, float f13, float f14) {
        this.f64398f = new SVG.b(f11, f12, f13, f14);
        return this;
    }

    public RenderOptions(RenderOptions renderOptions) {
        if (renderOptions != null) {
            this.f64393a = renderOptions.f64393a;
            this.f64394b = renderOptions.f64394b;
            this.f64396d = renderOptions.f64396d;
            this.f64397e = renderOptions.f64397e;
            this.f64398f = renderOptions.f64398f;
        }
    }
}
