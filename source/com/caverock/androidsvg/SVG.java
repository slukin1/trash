package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.caverock.androidsvg.CSSParser;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.imsdk.v2.V2TIMConversation;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SVG {

    /* renamed from: g  reason: collision with root package name */
    public static SVGExternalFileResolver f64399g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f64400h = true;

    /* renamed from: a  reason: collision with root package name */
    public d0 f64401a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f64402b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f64403c = "";

    /* renamed from: d  reason: collision with root package name */
    public float f64404d = 96.0f;

    /* renamed from: e  reason: collision with root package name */
    public CSSParser.n f64405e = new CSSParser.n();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, j0> f64406f = new HashMap();

    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    public static class Style implements Cloneable {
        public String A;
        public Boolean B;
        public Boolean C;
        public m0 D;
        public Float E;
        public String F;
        public FillRule G;
        public String H;
        public m0 I;
        public Float J;
        public m0 K;
        public Float L;
        public VectorEffect M;
        public RenderQuality N;

        /* renamed from: b  reason: collision with root package name */
        public long f64407b = 0;

        /* renamed from: c  reason: collision with root package name */
        public m0 f64408c;

        /* renamed from: d  reason: collision with root package name */
        public FillRule f64409d;

        /* renamed from: e  reason: collision with root package name */
        public Float f64410e;

        /* renamed from: f  reason: collision with root package name */
        public m0 f64411f;

        /* renamed from: g  reason: collision with root package name */
        public Float f64412g;

        /* renamed from: h  reason: collision with root package name */
        public o f64413h;

        /* renamed from: i  reason: collision with root package name */
        public LineCap f64414i;

        /* renamed from: j  reason: collision with root package name */
        public LineJoin f64415j;

        /* renamed from: k  reason: collision with root package name */
        public Float f64416k;

        /* renamed from: l  reason: collision with root package name */
        public o[] f64417l;

        /* renamed from: m  reason: collision with root package name */
        public o f64418m;

        /* renamed from: n  reason: collision with root package name */
        public Float f64419n;

        /* renamed from: o  reason: collision with root package name */
        public f f64420o;

        /* renamed from: p  reason: collision with root package name */
        public List<String> f64421p;

        /* renamed from: q  reason: collision with root package name */
        public o f64422q;

        /* renamed from: r  reason: collision with root package name */
        public Integer f64423r;

        /* renamed from: s  reason: collision with root package name */
        public FontStyle f64424s;

        /* renamed from: t  reason: collision with root package name */
        public TextDecoration f64425t;

        /* renamed from: u  reason: collision with root package name */
        public TextDirection f64426u;

        /* renamed from: v  reason: collision with root package name */
        public TextAnchor f64427v;

        /* renamed from: w  reason: collision with root package name */
        public Boolean f64428w;

        /* renamed from: x  reason: collision with root package name */
        public c f64429x;

        /* renamed from: y  reason: collision with root package name */
        public String f64430y;

        /* renamed from: z  reason: collision with root package name */
        public String f64431z;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCap {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style b() {
            Style style = new Style();
            style.f64407b = -1;
            f fVar = f.f64472c;
            style.f64408c = fVar;
            FillRule fillRule = FillRule.NonZero;
            style.f64409d = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.f64410e = valueOf;
            style.f64411f = null;
            style.f64412g = valueOf;
            style.f64413h = new o(1.0f);
            style.f64414i = LineCap.Butt;
            style.f64415j = LineJoin.Miter;
            style.f64416k = Float.valueOf(4.0f);
            style.f64417l = null;
            style.f64418m = new o(0.0f);
            style.f64419n = valueOf;
            style.f64420o = fVar;
            style.f64421p = null;
            style.f64422q = new o(12.0f, Unit.pt);
            style.f64423r = 400;
            style.f64424s = FontStyle.Normal;
            style.f64425t = TextDecoration.None;
            style.f64426u = TextDirection.LTR;
            style.f64427v = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.f64428w = bool;
            style.f64429x = null;
            style.f64430y = null;
            style.f64431z = null;
            style.A = null;
            style.B = bool;
            style.C = bool;
            style.D = fVar;
            style.E = valueOf;
            style.F = null;
            style.G = fillRule;
            style.H = null;
            style.I = null;
            style.J = valueOf;
            style.K = null;
            style.L = valueOf;
            style.M = VectorEffect.None;
            style.N = RenderQuality.auto;
            return style;
        }

        public void c(boolean z11) {
            Boolean bool = Boolean.TRUE;
            this.B = bool;
            if (!z11) {
                bool = Boolean.FALSE;
            }
            this.f64428w = bool;
            this.f64429x = null;
            this.F = null;
            this.f64419n = Float.valueOf(1.0f);
            this.D = f.f64472c;
            this.E = Float.valueOf(1.0f);
            this.H = null;
            this.I = null;
            this.J = Float.valueOf(1.0f);
            this.K = null;
            this.L = Float.valueOf(1.0f);
            this.M = VectorEffect.None;
        }

        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            o[] oVarArr = this.f64417l;
            if (oVarArr != null) {
                style.f64417l = (o[]) oVarArr.clone();
            }
            return style;
        }
    }

    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64440a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.caverock.androidsvg.SVG$Unit[] r0 = com.caverock.androidsvg.SVG.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64440a = r0
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.px     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.em     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.ex     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.in     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.cm     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.mm     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pt     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pc     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f64440a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.percent     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVG.a.<clinit>():void");
        }
    }

    public static class a0 extends k {

        /* renamed from: o  reason: collision with root package name */
        public o f64441o;

        /* renamed from: p  reason: collision with root package name */
        public o f64442p;

        /* renamed from: q  reason: collision with root package name */
        public o f64443q;

        /* renamed from: r  reason: collision with root package name */
        public o f64444r;

        /* renamed from: s  reason: collision with root package name */
        public o f64445s;

        /* renamed from: t  reason: collision with root package name */
        public o f64446t;

        public String m() {
            return "rect";
        }
    }

    public static class a1 extends l0 implements v0 {

        /* renamed from: c  reason: collision with root package name */
        public String f64447c;

        /* renamed from: d  reason: collision with root package name */
        public z0 f64448d;

        public a1(String str) {
            this.f64447c = str;
        }

        public z0 c() {
            return this.f64448d;
        }

        public String toString() {
            return getClass().getSimpleName() + " '" + this.f64447c + "'";
        }
    }

    public static class b0 extends j0 implements h0 {
        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        public void h(l0 l0Var) throws SVGParseException {
        }

        public String m() {
            return "solidColor";
        }
    }

    public static class b1 extends l {

        /* renamed from: p  reason: collision with root package name */
        public String f64453p;

        /* renamed from: q  reason: collision with root package name */
        public o f64454q;

        /* renamed from: r  reason: collision with root package name */
        public o f64455r;

        /* renamed from: s  reason: collision with root package name */
        public o f64456s;

        /* renamed from: t  reason: collision with root package name */
        public o f64457t;

        public String m() {
            return "use";
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public o f64458a;

        /* renamed from: b  reason: collision with root package name */
        public o f64459b;

        /* renamed from: c  reason: collision with root package name */
        public o f64460c;

        /* renamed from: d  reason: collision with root package name */
        public o f64461d;

        public c(o oVar, o oVar2, o oVar3, o oVar4) {
            this.f64458a = oVar;
            this.f64459b = oVar2;
            this.f64460c = oVar3;
            this.f64461d = oVar4;
        }
    }

    public static class c0 extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        public Float f64462h;

        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        public void h(l0 l0Var) throws SVGParseException {
        }

        public String m() {
            return "stop";
        }
    }

    public static class c1 extends p0 implements s {
        public String m() {
            return "view";
        }
    }

    public static class d extends k {

        /* renamed from: o  reason: collision with root package name */
        public o f64463o;

        /* renamed from: p  reason: collision with root package name */
        public o f64464p;

        /* renamed from: q  reason: collision with root package name */
        public o f64465q;

        public String m() {
            return TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
        }
    }

    public static class d0 extends p0 {

        /* renamed from: q  reason: collision with root package name */
        public o f64466q;

        /* renamed from: r  reason: collision with root package name */
        public o f64467r;

        /* renamed from: s  reason: collision with root package name */
        public o f64468s;

        /* renamed from: t  reason: collision with root package name */
        public o f64469t;

        /* renamed from: u  reason: collision with root package name */
        public String f64470u;

        public String m() {
            return "svg";
        }
    }

    public static class e extends l implements s {

        /* renamed from: p  reason: collision with root package name */
        public Boolean f64471p;

        public String m() {
            return "clipPath";
        }
    }

    public interface e0 {
        String a();

        void b(Set<String> set);

        void d(Set<String> set);

        Set<String> e();

        Set<String> f();

        void g(Set<String> set);

        Set<String> getRequiredFeatures();

        void i(Set<String> set);

        void j(String str);

        Set<String> l();
    }

    public static class f extends m0 {

        /* renamed from: c  reason: collision with root package name */
        public static final f f64472c = new f(RoundedDrawable.DEFAULT_BORDER_COLOR);

        /* renamed from: d  reason: collision with root package name */
        public static final f f64473d = new f(0);

        /* renamed from: b  reason: collision with root package name */
        public int f64474b;

        public f(int i11) {
            this.f64474b = i11;
        }

        public String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.f64474b)});
        }
    }

    public static abstract class f0 extends i0 implements h0, e0 {

        /* renamed from: i  reason: collision with root package name */
        public List<l0> f64475i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        public Set<String> f64476j = null;

        /* renamed from: k  reason: collision with root package name */
        public String f64477k = null;

        /* renamed from: l  reason: collision with root package name */
        public Set<String> f64478l = null;

        /* renamed from: m  reason: collision with root package name */
        public Set<String> f64479m = null;

        /* renamed from: n  reason: collision with root package name */
        public Set<String> f64480n = null;

        public String a() {
            return this.f64477k;
        }

        public void b(Set<String> set) {
            this.f64480n = set;
        }

        public void d(Set<String> set) {
            this.f64478l = set;
        }

        public Set<String> e() {
            return this.f64479m;
        }

        public Set<String> f() {
            return null;
        }

        public void g(Set<String> set) {
            this.f64476j = set;
        }

        public List<l0> getChildren() {
            return this.f64475i;
        }

        public Set<String> getRequiredFeatures() {
            return this.f64476j;
        }

        public void h(l0 l0Var) throws SVGParseException {
            this.f64475i.add(l0Var);
        }

        public void i(Set<String> set) {
            this.f64479m = set;
        }

        public void j(String str) {
            this.f64477k = str;
        }

        public Set<String> l() {
            return this.f64480n;
        }
    }

    public static class g extends m0 {

        /* renamed from: b  reason: collision with root package name */
        public static g f64481b = new g();

        public static g b() {
            return f64481b;
        }
    }

    public static abstract class g0 extends i0 implements e0 {

        /* renamed from: i  reason: collision with root package name */
        public Set<String> f64482i = null;

        /* renamed from: j  reason: collision with root package name */
        public String f64483j = null;

        /* renamed from: k  reason: collision with root package name */
        public Set<String> f64484k = null;

        /* renamed from: l  reason: collision with root package name */
        public Set<String> f64485l = null;

        /* renamed from: m  reason: collision with root package name */
        public Set<String> f64486m = null;

        public String a() {
            return this.f64483j;
        }

        public void b(Set<String> set) {
            this.f64486m = set;
        }

        public void d(Set<String> set) {
            this.f64484k = set;
        }

        public Set<String> e() {
            return this.f64485l;
        }

        public Set<String> f() {
            return this.f64484k;
        }

        public void g(Set<String> set) {
            this.f64482i = set;
        }

        public Set<String> getRequiredFeatures() {
            return this.f64482i;
        }

        public void i(Set<String> set) {
            this.f64485l = set;
        }

        public void j(String str) {
            this.f64483j = str;
        }

        public Set<String> l() {
            return this.f64486m;
        }
    }

    public static class h extends l implements s {
        public String m() {
            return "defs";
        }
    }

    public interface h0 {
        List<l0> getChildren();

        void h(l0 l0Var) throws SVGParseException;
    }

    public static class i extends k {

        /* renamed from: o  reason: collision with root package name */
        public o f64487o;

        /* renamed from: p  reason: collision with root package name */
        public o f64488p;

        /* renamed from: q  reason: collision with root package name */
        public o f64489q;

        /* renamed from: r  reason: collision with root package name */
        public o f64490r;

        public String m() {
            return "ellipse";
        }
    }

    public static abstract class i0 extends j0 {

        /* renamed from: h  reason: collision with root package name */
        public b f64491h = null;
    }

    public static abstract class j extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        public List<l0> f64492h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public Boolean f64493i;

        /* renamed from: j  reason: collision with root package name */
        public Matrix f64494j;

        /* renamed from: k  reason: collision with root package name */
        public GradientSpread f64495k;

        /* renamed from: l  reason: collision with root package name */
        public String f64496l;

        public List<l0> getChildren() {
            return this.f64492h;
        }

        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof c0) {
                this.f64492h.add(l0Var);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + l0Var + " elements.");
        }
    }

    public static abstract class j0 extends l0 {

        /* renamed from: c  reason: collision with root package name */
        public String f64497c = null;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f64498d = null;

        /* renamed from: e  reason: collision with root package name */
        public Style f64499e = null;

        /* renamed from: f  reason: collision with root package name */
        public Style f64500f = null;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f64501g = null;

        public abstract String m();
    }

    public static abstract class k extends g0 implements m {

        /* renamed from: n  reason: collision with root package name */
        public Matrix f64502n;

        public void k(Matrix matrix) {
            this.f64502n = matrix;
        }
    }

    public static class k0 extends j {

        /* renamed from: m  reason: collision with root package name */
        public o f64503m;

        /* renamed from: n  reason: collision with root package name */
        public o f64504n;

        /* renamed from: o  reason: collision with root package name */
        public o f64505o;

        /* renamed from: p  reason: collision with root package name */
        public o f64506p;

        public String m() {
            return "linearGradient";
        }
    }

    public static class l extends f0 implements m {

        /* renamed from: o  reason: collision with root package name */
        public Matrix f64507o;

        public void k(Matrix matrix) {
            this.f64507o = matrix;
        }

        public String m() {
            return V2TIMConversation.CONVERSATION_GROUP_TYPE;
        }
    }

    public static class l0 {

        /* renamed from: a  reason: collision with root package name */
        public SVG f64508a;

        /* renamed from: b  reason: collision with root package name */
        public h0 f64509b;

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    public interface m {
        void k(Matrix matrix);
    }

    public static abstract class m0 implements Cloneable {
    }

    public static class n extends n0 implements m {

        /* renamed from: p  reason: collision with root package name */
        public String f64510p;

        /* renamed from: q  reason: collision with root package name */
        public o f64511q;

        /* renamed from: r  reason: collision with root package name */
        public o f64512r;

        /* renamed from: s  reason: collision with root package name */
        public o f64513s;

        /* renamed from: t  reason: collision with root package name */
        public o f64514t;

        /* renamed from: u  reason: collision with root package name */
        public Matrix f64515u;

        public void k(Matrix matrix) {
            this.f64515u = matrix;
        }

        public String m() {
            return "image";
        }
    }

    public static abstract class n0 extends f0 {

        /* renamed from: o  reason: collision with root package name */
        public PreserveAspectRatio f64516o = null;
    }

    public static class o0 extends j {

        /* renamed from: m  reason: collision with root package name */
        public o f64519m;

        /* renamed from: n  reason: collision with root package name */
        public o f64520n;

        /* renamed from: o  reason: collision with root package name */
        public o f64521o;

        /* renamed from: p  reason: collision with root package name */
        public o f64522p;

        /* renamed from: q  reason: collision with root package name */
        public o f64523q;

        public String m() {
            return "radialGradient";
        }
    }

    public static class p extends k {

        /* renamed from: o  reason: collision with root package name */
        public o f64524o;

        /* renamed from: p  reason: collision with root package name */
        public o f64525p;

        /* renamed from: q  reason: collision with root package name */
        public o f64526q;

        /* renamed from: r  reason: collision with root package name */
        public o f64527r;

        public String m() {
            return Constants.LINE;
        }
    }

    public static abstract class p0 extends n0 {

        /* renamed from: p  reason: collision with root package name */
        public b f64528p;
    }

    public static class q extends p0 implements s {

        /* renamed from: q  reason: collision with root package name */
        public boolean f64529q;

        /* renamed from: r  reason: collision with root package name */
        public o f64530r;

        /* renamed from: s  reason: collision with root package name */
        public o f64531s;

        /* renamed from: t  reason: collision with root package name */
        public o f64532t;

        /* renamed from: u  reason: collision with root package name */
        public o f64533u;

        /* renamed from: v  reason: collision with root package name */
        public Float f64534v;

        public String m() {
            return "marker";
        }
    }

    public static class q0 extends l {
        public String m() {
            return "switch";
        }
    }

    public static class r extends f0 implements s {

        /* renamed from: o  reason: collision with root package name */
        public Boolean f64535o;

        /* renamed from: p  reason: collision with root package name */
        public Boolean f64536p;

        /* renamed from: q  reason: collision with root package name */
        public o f64537q;

        /* renamed from: r  reason: collision with root package name */
        public o f64538r;

        /* renamed from: s  reason: collision with root package name */
        public o f64539s;

        /* renamed from: t  reason: collision with root package name */
        public o f64540t;

        public String m() {
            return "mask";
        }
    }

    public static class r0 extends p0 implements s {
        public String m() {
            return "symbol";
        }
    }

    public interface s {
    }

    public static class s0 extends w0 implements v0 {

        /* renamed from: o  reason: collision with root package name */
        public String f64541o;

        /* renamed from: p  reason: collision with root package name */
        public z0 f64542p;

        public z0 c() {
            return this.f64542p;
        }

        public String m() {
            return "tref";
        }

        public void n(z0 z0Var) {
            this.f64542p = z0Var;
        }
    }

    public static class t extends m0 {

        /* renamed from: b  reason: collision with root package name */
        public String f64543b;

        /* renamed from: c  reason: collision with root package name */
        public m0 f64544c;

        public t(String str, m0 m0Var) {
            this.f64543b = str;
            this.f64544c = m0Var;
        }

        public String toString() {
            return this.f64543b + " " + this.f64544c;
        }
    }

    public static class t0 extends y0 implements v0 {

        /* renamed from: s  reason: collision with root package name */
        public z0 f64545s;

        public z0 c() {
            return this.f64545s;
        }

        public String m() {
            return "tspan";
        }

        public void n(z0 z0Var) {
            this.f64545s = z0Var;
        }
    }

    public static class u extends k {

        /* renamed from: o  reason: collision with root package name */
        public v f64546o;

        /* renamed from: p  reason: collision with root package name */
        public Float f64547p;

        public String m() {
            return "path";
        }
    }

    public static class u0 extends y0 implements z0, m {

        /* renamed from: s  reason: collision with root package name */
        public Matrix f64548s;

        public void k(Matrix matrix) {
            this.f64548s = matrix;
        }

        public String m() {
            return "text";
        }
    }

    public static class v implements w {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f64549a;

        /* renamed from: b  reason: collision with root package name */
        public int f64550b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f64551c;

        /* renamed from: d  reason: collision with root package name */
        public int f64552d;

        public v() {
            this.f64549a = null;
            this.f64550b = 0;
            this.f64551c = null;
            this.f64552d = 0;
            this.f64549a = new byte[8];
            this.f64551c = new float[16];
        }

        public void a(float f11, float f12) {
            f((byte) 0);
            g(2);
            float[] fArr = this.f64551c;
            int i11 = this.f64552d;
            int i12 = i11 + 1;
            this.f64552d = i12;
            fArr[i11] = f11;
            this.f64552d = i12 + 1;
            fArr[i12] = f12;
        }

        public void b(float f11, float f12) {
            f((byte) 1);
            g(2);
            float[] fArr = this.f64551c;
            int i11 = this.f64552d;
            int i12 = i11 + 1;
            this.f64552d = i12;
            fArr[i11] = f11;
            this.f64552d = i12 + 1;
            fArr[i12] = f12;
        }

        public void c(float f11, float f12, float f13, float f14) {
            f((byte) 3);
            g(4);
            float[] fArr = this.f64551c;
            int i11 = this.f64552d;
            int i12 = i11 + 1;
            this.f64552d = i12;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            this.f64552d = i13;
            fArr[i12] = f12;
            int i14 = i13 + 1;
            this.f64552d = i14;
            fArr[i13] = f13;
            this.f64552d = i14 + 1;
            fArr[i14] = f14;
        }

        public void close() {
            f((byte) 8);
        }

        public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
            f((byte) 2);
            g(6);
            float[] fArr = this.f64551c;
            int i11 = this.f64552d;
            int i12 = i11 + 1;
            this.f64552d = i12;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            this.f64552d = i13;
            fArr[i12] = f12;
            int i14 = i13 + 1;
            this.f64552d = i14;
            fArr[i13] = f13;
            int i15 = i14 + 1;
            this.f64552d = i15;
            fArr[i14] = f14;
            int i16 = i15 + 1;
            this.f64552d = i16;
            fArr[i15] = f15;
            this.f64552d = i16 + 1;
            fArr[i16] = f16;
        }

        public void e(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            f(((z11 ? (char) 2 : 0) | true) | z12 ? (byte) 1 : 0);
            g(5);
            float[] fArr = this.f64551c;
            int i11 = this.f64552d;
            int i12 = i11 + 1;
            this.f64552d = i12;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            this.f64552d = i13;
            fArr[i12] = f12;
            int i14 = i13 + 1;
            this.f64552d = i14;
            fArr[i13] = f13;
            int i15 = i14 + 1;
            this.f64552d = i15;
            fArr[i14] = f14;
            this.f64552d = i15 + 1;
            fArr[i15] = f15;
        }

        public final void f(byte b11) {
            int i11 = this.f64550b;
            byte[] bArr = this.f64549a;
            if (i11 == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 2)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f64549a = bArr2;
            }
            byte[] bArr3 = this.f64549a;
            int i12 = this.f64550b;
            this.f64550b = i12 + 1;
            bArr3[i12] = b11;
        }

        public final void g(int i11) {
            float[] fArr = this.f64551c;
            if (fArr.length < this.f64552d + i11) {
                float[] fArr2 = new float[(fArr.length * 2)];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f64551c = fArr2;
            }
        }

        public void h(w wVar) {
            int i11;
            int i12 = 0;
            for (int i13 = 0; i13 < this.f64550b; i13++) {
                byte b11 = this.f64549a[i13];
                if (b11 == 0) {
                    float[] fArr = this.f64551c;
                    int i14 = i12 + 1;
                    i11 = i14 + 1;
                    wVar.a(fArr[i12], fArr[i14]);
                } else if (b11 != 1) {
                    if (b11 == 2) {
                        float[] fArr2 = this.f64551c;
                        int i15 = i12 + 1;
                        float f11 = fArr2[i12];
                        int i16 = i15 + 1;
                        float f12 = fArr2[i15];
                        int i17 = i16 + 1;
                        float f13 = fArr2[i16];
                        int i18 = i17 + 1;
                        float f14 = fArr2[i17];
                        int i19 = i18 + 1;
                        float f15 = fArr2[i18];
                        i12 = i19 + 1;
                        wVar.d(f11, f12, f13, f14, f15, fArr2[i19]);
                    } else if (b11 == 3) {
                        float[] fArr3 = this.f64551c;
                        int i21 = i12 + 1;
                        int i22 = i21 + 1;
                        int i23 = i22 + 1;
                        wVar.c(fArr3[i12], fArr3[i21], fArr3[i22], fArr3[i23]);
                        i12 = i23 + 1;
                    } else if (b11 != 8) {
                        boolean z11 = (b11 & 2) != 0;
                        boolean z12 = (b11 & 1) != 0;
                        float[] fArr4 = this.f64551c;
                        int i24 = i12 + 1;
                        float f16 = fArr4[i12];
                        int i25 = i24 + 1;
                        float f17 = fArr4[i24];
                        int i26 = i25 + 1;
                        float f18 = fArr4[i25];
                        int i27 = i26 + 1;
                        wVar.e(f16, f17, f18, z11, z12, fArr4[i26], fArr4[i27]);
                        i12 = i27 + 1;
                    } else {
                        wVar.close();
                    }
                } else {
                    float[] fArr5 = this.f64551c;
                    int i28 = i12 + 1;
                    i11 = i28 + 1;
                    wVar.b(fArr5[i12], fArr5[i28]);
                }
                i12 = i11;
            }
        }

        public boolean i() {
            return this.f64550b == 0;
        }
    }

    public interface v0 {
        z0 c();
    }

    public interface w {
        void a(float f11, float f12);

        void b(float f11, float f12);

        void c(float f11, float f12, float f13, float f14);

        void close();

        void d(float f11, float f12, float f13, float f14, float f15, float f16);

        void e(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15);
    }

    public static abstract class w0 extends f0 {
        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof v0) {
                this.f64475i.add(l0Var);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + l0Var + " elements.");
        }
    }

    public static class x extends p0 implements s {

        /* renamed from: q  reason: collision with root package name */
        public Boolean f64553q;

        /* renamed from: r  reason: collision with root package name */
        public Boolean f64554r;

        /* renamed from: s  reason: collision with root package name */
        public Matrix f64555s;

        /* renamed from: t  reason: collision with root package name */
        public o f64556t;

        /* renamed from: u  reason: collision with root package name */
        public o f64557u;

        /* renamed from: v  reason: collision with root package name */
        public o f64558v;

        /* renamed from: w  reason: collision with root package name */
        public o f64559w;

        /* renamed from: x  reason: collision with root package name */
        public String f64560x;

        public String m() {
            return "pattern";
        }
    }

    public static class x0 extends w0 implements v0 {

        /* renamed from: o  reason: collision with root package name */
        public String f64561o;

        /* renamed from: p  reason: collision with root package name */
        public o f64562p;

        /* renamed from: q  reason: collision with root package name */
        public z0 f64563q;

        public z0 c() {
            return this.f64563q;
        }

        public String m() {
            return "textPath";
        }

        public void n(z0 z0Var) {
            this.f64563q = z0Var;
        }
    }

    public static class y extends k {

        /* renamed from: o  reason: collision with root package name */
        public float[] f64564o;

        public String m() {
            return "polyline";
        }
    }

    public static abstract class y0 extends w0 {

        /* renamed from: o  reason: collision with root package name */
        public List<o> f64565o;

        /* renamed from: p  reason: collision with root package name */
        public List<o> f64566p;

        /* renamed from: q  reason: collision with root package name */
        public List<o> f64567q;

        /* renamed from: r  reason: collision with root package name */
        public List<o> f64568r;
    }

    public static class z extends y {
        public String m() {
            return "polygon";
        }
    }

    public interface z0 {
    }

    public static SVGExternalFileResolver g() {
        return f64399g;
    }

    public static SVG h(InputStream inputStream) throws SVGParseException {
        return new SVGParser().z(inputStream, f64400h);
    }

    public static SVG i(Context context, int i11) throws SVGParseException {
        return j(context.getResources(), i11);
    }

    public static SVG j(Resources resources, int i11) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i11);
        try {
            return sVGParser.z(openRawResource, f64400h);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG k(String str) throws SVGParseException {
        return new SVGParser().z(new ByteArrayInputStream(str.getBytes()), f64400h);
    }

    public void a(CSSParser.n nVar) {
        this.f64405e.b(nVar);
    }

    public void b() {
        this.f64405e.e(CSSParser.Source.RenderOptions);
    }

    public final String c(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    public List<CSSParser.l> d() {
        return this.f64405e.c();
    }

    public final j0 e(h0 h0Var, String str) {
        j0 e11;
        j0 j0Var = (j0) h0Var;
        if (str.equals(j0Var.f64497c)) {
            return j0Var;
        }
        for (l0 next : h0Var.getChildren()) {
            if (next instanceof j0) {
                j0 j0Var2 = (j0) next;
                if (str.equals(j0Var2.f64497c)) {
                    return j0Var2;
                }
                if ((next instanceof h0) && (e11 = e((h0) next, str)) != null) {
                    return e11;
                }
            }
        }
        return null;
    }

    public j0 f(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f64401a.f64497c)) {
            return this.f64401a;
        }
        if (this.f64406f.containsKey(str)) {
            return this.f64406f.get(str);
        }
        j0 e11 = e(this.f64401a, str);
        this.f64406f.put(str, e11);
        return e11;
    }

    public d0 l() {
        return this.f64401a;
    }

    public boolean m() {
        return !this.f64405e.d();
    }

    public Picture n() {
        return p((RenderOptions) null);
    }

    public Picture o(int i11, int i12, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i11, i12);
        if (renderOptions == null || renderOptions.f64398f == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.h(0.0f, 0.0f, (float) i11, (float) i12);
        }
        new c(beginRecording, this.f64404d).M0(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public Picture p(RenderOptions renderOptions) {
        Unit unit;
        o oVar;
        b bVar = (renderOptions == null || !renderOptions.f()) ? this.f64401a.f64528p : renderOptions.f64396d;
        if (renderOptions == null || !renderOptions.g()) {
            d0 d0Var = this.f64401a;
            o oVar2 = d0Var.f64468s;
            if (oVar2 != null && oVar2.f64518c != (unit = Unit.percent) && (oVar = d0Var.f64469t) != null && oVar.f64518c != unit) {
                return o((int) Math.ceil((double) oVar2.c(this.f64404d)), (int) Math.ceil((double) this.f64401a.f64469t.c(this.f64404d)), renderOptions);
            } else if (oVar2 == null || bVar == null) {
                o oVar3 = d0Var.f64469t;
                if (oVar3 == null || bVar == null) {
                    return o(512, 512, renderOptions);
                }
                float c11 = oVar3.c(this.f64404d);
                return o((int) Math.ceil((double) ((bVar.f64451c * c11) / bVar.f64452d)), (int) Math.ceil((double) c11), renderOptions);
            } else {
                float c12 = oVar2.c(this.f64404d);
                return o((int) Math.ceil((double) c12), (int) Math.ceil((double) ((bVar.f64452d * c12) / bVar.f64451c)), renderOptions);
            }
        } else {
            return o((int) Math.ceil((double) renderOptions.f64398f.b()), (int) Math.ceil((double) renderOptions.f64398f.c()), renderOptions);
        }
    }

    public l0 q(String str) {
        if (str == null) {
            return null;
        }
        String c11 = c(str);
        if (c11.length() <= 1 || !c11.startsWith("#")) {
            return null;
        }
        return f(c11.substring(1));
    }

    public void r(String str) {
        this.f64403c = str;
    }

    public void s(d0 d0Var) {
        this.f64401a = d0Var;
    }

    public void t(String str) {
        this.f64402b = str;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f64449a;

        /* renamed from: b  reason: collision with root package name */
        public float f64450b;

        /* renamed from: c  reason: collision with root package name */
        public float f64451c;

        /* renamed from: d  reason: collision with root package name */
        public float f64452d;

        public b(float f11, float f12, float f13, float f14) {
            this.f64449a = f11;
            this.f64450b = f12;
            this.f64451c = f13;
            this.f64452d = f14;
        }

        public static b a(float f11, float f12, float f13, float f14) {
            return new b(f11, f12, f13 - f11, f14 - f12);
        }

        public float b() {
            return this.f64449a + this.f64451c;
        }

        public float c() {
            return this.f64450b + this.f64452d;
        }

        public void d(b bVar) {
            float f11 = bVar.f64449a;
            if (f11 < this.f64449a) {
                this.f64449a = f11;
            }
            float f12 = bVar.f64450b;
            if (f12 < this.f64450b) {
                this.f64450b = f12;
            }
            if (bVar.b() > b()) {
                this.f64451c = bVar.b() - this.f64449a;
            }
            if (bVar.c() > c()) {
                this.f64452d = bVar.c() - this.f64450b;
            }
        }

        public String toString() {
            return "[" + this.f64449a + " " + this.f64450b + " " + this.f64451c + " " + this.f64452d + "]";
        }

        public b(b bVar) {
            this.f64449a = bVar.f64449a;
            this.f64450b = bVar.f64450b;
            this.f64451c = bVar.f64451c;
            this.f64452d = bVar.f64452d;
        }
    }

    public static class o implements Cloneable {

        /* renamed from: b  reason: collision with root package name */
        public float f64517b;

        /* renamed from: c  reason: collision with root package name */
        public Unit f64518c;

        public o(float f11, Unit unit) {
            this.f64517b = 0.0f;
            this.f64518c = Unit.px;
            this.f64517b = f11;
            this.f64518c = unit;
        }

        public float b() {
            return this.f64517b;
        }

        public float c(float f11) {
            int i11 = a.f64440a[this.f64518c.ordinal()];
            if (i11 == 1) {
                return this.f64517b;
            }
            switch (i11) {
                case 4:
                    return this.f64517b * f11;
                case 5:
                    return (this.f64517b * f11) / 2.54f;
                case 6:
                    return (this.f64517b * f11) / 25.4f;
                case 7:
                    return (this.f64517b * f11) / 72.0f;
                case 8:
                    return (this.f64517b * f11) / 6.0f;
                default:
                    return this.f64517b;
            }
        }

        public float d(c cVar) {
            if (this.f64518c != Unit.percent) {
                return f(cVar);
            }
            b Z = cVar.Z();
            if (Z == null) {
                return this.f64517b;
            }
            float f11 = Z.f64451c;
            float f12 = Z.f64452d;
            if (f11 == f12) {
                return (this.f64517b * f11) / 100.0f;
            }
            return (this.f64517b * ((float) (Math.sqrt((double) ((f11 * f11) + (f12 * f12))) / 1.414213562373095d))) / 100.0f;
        }

        public float e(c cVar, float f11) {
            if (this.f64518c == Unit.percent) {
                return (this.f64517b * f11) / 100.0f;
            }
            return f(cVar);
        }

        public float f(c cVar) {
            switch (a.f64440a[this.f64518c.ordinal()]) {
                case 1:
                    return this.f64517b;
                case 2:
                    return this.f64517b * cVar.X();
                case 3:
                    return this.f64517b * cVar.Y();
                case 4:
                    return this.f64517b * cVar.a0();
                case 5:
                    return (this.f64517b * cVar.a0()) / 2.54f;
                case 6:
                    return (this.f64517b * cVar.a0()) / 25.4f;
                case 7:
                    return (this.f64517b * cVar.a0()) / 72.0f;
                case 8:
                    return (this.f64517b * cVar.a0()) / 6.0f;
                case 9:
                    b Z = cVar.Z();
                    if (Z == null) {
                        return this.f64517b;
                    }
                    return (this.f64517b * Z.f64451c) / 100.0f;
                default:
                    return this.f64517b;
            }
        }

        public float g(c cVar) {
            if (this.f64518c != Unit.percent) {
                return f(cVar);
            }
            b Z = cVar.Z();
            if (Z == null) {
                return this.f64517b;
            }
            return (this.f64517b * Z.f64452d) / 100.0f;
        }

        public boolean h() {
            return this.f64517b < 0.0f;
        }

        public boolean i() {
            return this.f64517b == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.f64517b) + this.f64518c;
        }

        public o(float f11) {
            this.f64517b = 0.0f;
            Unit unit = Unit.px;
            this.f64518c = unit;
            this.f64517b = f11;
            this.f64518c = unit;
        }
    }
}
