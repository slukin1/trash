package com.caverock.androidsvg;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import com.google.android.exoplayer2.C;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class c {

    /* renamed from: i  reason: collision with root package name */
    public static HashSet<String> f64621i;

    /* renamed from: a  reason: collision with root package name */
    public Canvas f64622a;

    /* renamed from: b  reason: collision with root package name */
    public float f64623b;

    /* renamed from: c  reason: collision with root package name */
    public SVG f64624c;

    /* renamed from: d  reason: collision with root package name */
    public h f64625d;

    /* renamed from: e  reason: collision with root package name */
    public Stack<h> f64626e;

    /* renamed from: f  reason: collision with root package name */
    public Stack<SVG.h0> f64627f;

    /* renamed from: g  reason: collision with root package name */
    public Stack<Matrix> f64628g;

    /* renamed from: h  reason: collision with root package name */
    public CSSParser.m f64629h = null;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64630a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f64631b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f64632c;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009e */
        static {
            /*
                com.caverock.androidsvg.SVG$Style$LineJoin[] r0 = com.caverock.androidsvg.SVG.Style.LineJoin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64632c = r0
                r1 = 1
                com.caverock.androidsvg.SVG$Style$LineJoin r2 = com.caverock.androidsvg.SVG.Style.LineJoin.Miter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f64632c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Style$LineJoin r3 = com.caverock.androidsvg.SVG.Style.LineJoin.Round     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f64632c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Style$LineJoin r4 = com.caverock.androidsvg.SVG.Style.LineJoin.Bevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.caverock.androidsvg.SVG$Style$LineCap[] r3 = com.caverock.androidsvg.SVG.Style.LineCap.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f64631b = r3
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Butt     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f64631b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Round     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f64631b     // Catch:{ NoSuchFieldError -> 0x004d }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Square     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.caverock.androidsvg.PreserveAspectRatio$Alignment[] r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f64630a = r3
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r4 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMin     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r1 = f64630a     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMid     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMax     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMin     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMid     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMax     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMid     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f64630a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMax     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.a.<clinit>():void");
        }
    }

    public class b implements SVG.w {

        /* renamed from: a  reason: collision with root package name */
        public List<C0708c> f64633a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public float f64634b;

        /* renamed from: c  reason: collision with root package name */
        public float f64635c;

        /* renamed from: d  reason: collision with root package name */
        public C0708c f64636d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64637e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64638f = true;

        /* renamed from: g  reason: collision with root package name */
        public int f64639g = -1;

        /* renamed from: h  reason: collision with root package name */
        public boolean f64640h;

        public b(SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
                if (this.f64640h) {
                    this.f64636d.b(this.f64633a.get(this.f64639g));
                    this.f64633a.set(this.f64639g, this.f64636d);
                    this.f64640h = false;
                }
                C0708c cVar = this.f64636d;
                if (cVar != null) {
                    this.f64633a.add(cVar);
                }
            }
        }

        public void a(float f11, float f12) {
            if (this.f64640h) {
                this.f64636d.b(this.f64633a.get(this.f64639g));
                this.f64633a.set(this.f64639g, this.f64636d);
                this.f64640h = false;
            }
            C0708c cVar = this.f64636d;
            if (cVar != null) {
                this.f64633a.add(cVar);
            }
            this.f64634b = f11;
            this.f64635c = f12;
            this.f64636d = new C0708c(f11, f12, 0.0f, 0.0f);
            this.f64639g = this.f64633a.size();
        }

        public void b(float f11, float f12) {
            this.f64636d.a(f11, f12);
            this.f64633a.add(this.f64636d);
            c cVar = c.this;
            C0708c cVar2 = this.f64636d;
            this.f64636d = new C0708c(f11, f12, f11 - cVar2.f64642a, f12 - cVar2.f64643b);
            this.f64640h = false;
        }

        public void c(float f11, float f12, float f13, float f14) {
            this.f64636d.a(f11, f12);
            this.f64633a.add(this.f64636d);
            this.f64636d = new C0708c(f13, f14, f13 - f11, f14 - f12);
            this.f64640h = false;
        }

        public void close() {
            this.f64633a.add(this.f64636d);
            b(this.f64634b, this.f64635c);
            this.f64640h = true;
        }

        public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
            if (this.f64638f || this.f64637e) {
                this.f64636d.a(f11, f12);
                this.f64633a.add(this.f64636d);
                this.f64637e = false;
            }
            this.f64636d = new C0708c(f15, f16, f15 - f13, f16 - f14);
            this.f64640h = false;
        }

        public void e(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            this.f64637e = true;
            this.f64638f = false;
            C0708c cVar = this.f64636d;
            c.m(cVar.f64642a, cVar.f64643b, f11, f12, f13, z11, z12, f14, f15, this);
            this.f64638f = true;
            this.f64640h = false;
        }

        public List<C0708c> f() {
            return this.f64633a;
        }
    }

    /* renamed from: com.caverock.androidsvg.c$c  reason: collision with other inner class name */
    public class C0708c {

        /* renamed from: a  reason: collision with root package name */
        public float f64642a;

        /* renamed from: b  reason: collision with root package name */
        public float f64643b;

        /* renamed from: c  reason: collision with root package name */
        public float f64644c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f64645d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64646e = false;

        public C0708c(float f11, float f12, float f13, float f14) {
            this.f64642a = f11;
            this.f64643b = f12;
            double sqrt = Math.sqrt((double) ((f13 * f13) + (f14 * f14)));
            if (sqrt != 0.0d) {
                this.f64644c = (float) (((double) f13) / sqrt);
                this.f64645d = (float) (((double) f14) / sqrt);
            }
        }

        public void a(float f11, float f12) {
            float f13 = f11 - this.f64642a;
            float f14 = f12 - this.f64643b;
            double sqrt = Math.sqrt((double) ((f13 * f13) + (f14 * f14)));
            if (sqrt != 0.0d) {
                f13 = (float) (((double) f13) / sqrt);
                f14 = (float) (((double) f14) / sqrt);
            }
            float f15 = this.f64644c;
            if (f13 == (-f15) && f14 == (-this.f64645d)) {
                this.f64646e = true;
                this.f64644c = -f14;
                this.f64645d = f13;
                return;
            }
            this.f64644c = f15 + f13;
            this.f64645d += f14;
        }

        public void b(C0708c cVar) {
            float f11 = cVar.f64644c;
            float f12 = this.f64644c;
            if (f11 == (-f12)) {
                float f13 = cVar.f64645d;
                if (f13 == (-this.f64645d)) {
                    this.f64646e = true;
                    this.f64644c = -f13;
                    this.f64645d = cVar.f64644c;
                    return;
                }
            }
            this.f64644c = f12 + f11;
            this.f64645d += cVar.f64645d;
        }

        public String toString() {
            return "(" + this.f64642a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f64643b + " " + this.f64644c + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f64645d + ")";
        }
    }

    public class d implements SVG.w {

        /* renamed from: a  reason: collision with root package name */
        public Path f64648a = new Path();

        /* renamed from: b  reason: collision with root package name */
        public float f64649b;

        /* renamed from: c  reason: collision with root package name */
        public float f64650c;

        public d(SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
            }
        }

        public void a(float f11, float f12) {
            this.f64648a.moveTo(f11, f12);
            this.f64649b = f11;
            this.f64650c = f12;
        }

        public void b(float f11, float f12) {
            this.f64648a.lineTo(f11, f12);
            this.f64649b = f11;
            this.f64650c = f12;
        }

        public void c(float f11, float f12, float f13, float f14) {
            this.f64648a.quadTo(f11, f12, f13, f14);
            this.f64649b = f13;
            this.f64650c = f14;
        }

        public void close() {
            this.f64648a.close();
        }

        public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
            this.f64648a.cubicTo(f11, f12, f13, f14, f15, f16);
            this.f64649b = f15;
            this.f64650c = f16;
        }

        public void e(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            c.m(this.f64649b, this.f64650c, f11, f12, f13, z11, z12, f14, f15, this);
            this.f64649b = f14;
            this.f64650c = f15;
        }

        public Path f() {
            return this.f64648a;
        }
    }

    public class e extends f {

        /* renamed from: e  reason: collision with root package name */
        public Path f64652e;

        public e(Path path, float f11, float f12) {
            super(f11, f12);
            this.f64652e = path;
        }

        public void b(String str) {
            if (c.this.e1()) {
                if (c.this.f64625d.f64662b) {
                    c.this.f64622a.drawTextOnPath(str, this.f64652e, this.f64654b, this.f64655c, c.this.f64625d.f64664d);
                }
                if (c.this.f64625d.f64663c) {
                    c.this.f64622a.drawTextOnPath(str, this.f64652e, this.f64654b, this.f64655c, c.this.f64625d.f64665e);
                }
            }
            this.f64654b += c.this.f64625d.f64664d.measureText(str);
        }
    }

    public class f extends j {

        /* renamed from: b  reason: collision with root package name */
        public float f64654b;

        /* renamed from: c  reason: collision with root package name */
        public float f64655c;

        public f(float f11, float f12) {
            super(c.this, (a) null);
            this.f64654b = f11;
            this.f64655c = f12;
        }

        public void b(String str) {
            c.F("TextSequence render", new Object[0]);
            if (c.this.e1()) {
                if (c.this.f64625d.f64662b) {
                    c.this.f64622a.drawText(str, this.f64654b, this.f64655c, c.this.f64625d.f64664d);
                }
                if (c.this.f64625d.f64663c) {
                    c.this.f64622a.drawText(str, this.f64654b, this.f64655c, c.this.f64625d.f64665e);
                }
            }
            this.f64654b += c.this.f64625d.f64664d.measureText(str);
        }
    }

    public class g extends j {

        /* renamed from: b  reason: collision with root package name */
        public float f64657b;

        /* renamed from: c  reason: collision with root package name */
        public float f64658c;

        /* renamed from: d  reason: collision with root package name */
        public Path f64659d;

        public g(float f11, float f12, Path path) {
            super(c.this, (a) null);
            this.f64657b = f11;
            this.f64658c = f12;
            this.f64659d = path;
        }

        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            c.f1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        public void b(String str) {
            if (c.this.e1()) {
                Path path = new Path();
                c.this.f64625d.f64664d.getTextPath(str, 0, str.length(), this.f64657b, this.f64658c, path);
                this.f64659d.addPath(path);
            }
            this.f64657b += c.this.f64625d.f64664d.measureText(str);
        }
    }

    public class i extends j {

        /* renamed from: b  reason: collision with root package name */
        public float f64670b;

        /* renamed from: c  reason: collision with root package name */
        public float f64671c;

        /* renamed from: d  reason: collision with root package name */
        public RectF f64672d = new RectF();

        public i(float f11, float f12) {
            super(c.this, (a) null);
            this.f64670b = f11;
            this.f64671c = f12;
        }

        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            SVG.x0 x0Var = (SVG.x0) w0Var;
            SVG.l0 q11 = w0Var.f64508a.q(x0Var.f64561o);
            if (q11 == null) {
                c.M("TextPath path reference '%s' not found", x0Var.f64561o);
                return false;
            }
            SVG.u uVar = (SVG.u) q11;
            Path f11 = new d(uVar.f64546o).f();
            Matrix matrix = uVar.f64502n;
            if (matrix != null) {
                f11.transform(matrix);
            }
            RectF rectF = new RectF();
            f11.computeBounds(rectF, true);
            this.f64672d.union(rectF);
            return false;
        }

        public void b(String str) {
            if (c.this.e1()) {
                Rect rect = new Rect();
                c.this.f64625d.f64664d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f64670b, this.f64671c);
                this.f64672d.union(rectF);
            }
            this.f64670b += c.this.f64625d.f64664d.measureText(str);
        }
    }

    public abstract class j {
        public j() {
        }

        public boolean a(SVG.w0 w0Var) {
            return true;
        }

        public abstract void b(String str);

        public /* synthetic */ j(c cVar, a aVar) {
            this();
        }
    }

    public c(Canvas canvas, float f11) {
        this.f64622a = canvas;
        this.f64623b = f11;
    }

    public static int B(float f11) {
        int i11 = (int) (f11 * 256.0f);
        if (i11 < 0) {
            return 0;
        }
        if (i11 > 255) {
            return 255;
        }
        return i11;
    }

    public static int E(int i11, float f11) {
        int i12 = 255;
        int round = Math.round(((float) ((i11 >> 24) & 255)) * f11);
        if (round < 0) {
            i12 = 0;
        } else if (round <= 255) {
            i12 = round;
        }
        return (i11 & FlexItem.MAX_SIZE) | (i12 << 24);
    }

    public static void F(String str, Object... objArr) {
    }

    public static void M(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static synchronized void c0() {
        synchronized (c.class) {
            HashSet<String> hashSet = new HashSet<>();
            f64621i = hashSet;
            hashSet.add("Structure");
            f64621i.add("BasicStructure");
            f64621i.add("ConditionalProcessing");
            f64621i.add("Image");
            f64621i.add("Style");
            f64621i.add("ViewportAttribute");
            f64621i.add("Shape");
            f64621i.add("BasicText");
            f64621i.add("PaintAttribute");
            f64621i.add("BasicPaintAttribute");
            f64621i.add("OpacityAttribute");
            f64621i.add("BasicGraphicsAttribute");
            f64621i.add("Marker");
            f64621i.add("Gradient");
            f64621i.add("Pattern");
            f64621i.add("Clip");
            f64621i.add("BasicClip");
            f64621i.add("Mask");
            f64621i.add("View");
        }
    }

    public static void f1(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static void m(float f11, float f12, float f13, float f14, float f15, boolean z11, boolean z12, float f16, float f17, SVG.w wVar) {
        float f18;
        double d11;
        float f19 = f15;
        boolean z13 = z12;
        float f21 = f16;
        float f22 = f17;
        if (f11 != f21 || f12 != f22) {
            if (f13 == 0.0f || f14 == 0.0f) {
                wVar.b(f21, f22);
                return;
            }
            float abs = Math.abs(f13);
            float abs2 = Math.abs(f14);
            double radians = (double) ((float) Math.toRadians(((double) f19) % 360.0d));
            float cos = (float) Math.cos(radians);
            float sin = (float) Math.sin(radians);
            float f23 = (f11 - f21) / 2.0f;
            float f24 = (f12 - f22) / 2.0f;
            float f25 = (cos * f23) + (sin * f24);
            float f26 = ((-sin) * f23) + (f24 * cos);
            float f27 = abs * abs;
            float f28 = abs2 * abs2;
            float f29 = f25 * f25;
            float f31 = f26 * f26;
            float f32 = (f29 / f27) + (f31 / f28);
            if (f32 > 1.0f) {
                double d12 = (double) f32;
                f18 = cos;
                abs *= (float) Math.sqrt(d12);
                abs2 *= (float) Math.sqrt(d12);
                f27 = abs * abs;
                f28 = abs2 * abs2;
            } else {
                f18 = cos;
            }
            float f33 = z11 == z13 ? -1.0f : 1.0f;
            float f34 = f27 * f28;
            float f35 = f27 * f31;
            float f36 = f28 * f29;
            float f37 = ((f34 - f35) - f36) / (f35 + f36);
            if (f37 < 0.0f) {
                f37 = 0.0f;
            }
            float sqrt = (float) (((double) f33) * Math.sqrt((double) f37));
            float f38 = ((abs * f26) / abs2) * sqrt;
            float f39 = sqrt * (-((abs2 * f25) / abs));
            float f40 = ((f11 + f21) / 2.0f) + ((f18 * f38) - (sin * f39));
            float f41 = ((f12 + f22) / 2.0f) + (sin * f38) + (f18 * f39);
            float f42 = (f25 - f38) / abs;
            float f43 = (f26 - f39) / abs2;
            float f44 = ((-f25) - f38) / abs;
            float f45 = ((-f26) - f39) / abs2;
            float f46 = (f42 * f42) + (f43 * f43);
            float f47 = abs;
            float f48 = f46;
            float degrees = (float) Math.toDegrees(((double) (f43 < 0.0f ? -1.0f : 1.0f)) * Math.acos((double) (f42 / ((float) Math.sqrt((double) f46)))));
            double degrees2 = Math.toDegrees(((double) ((f42 * f45) - (f43 * f44) < 0.0f ? -1.0f : 1.0f)) * Math.acos((double) (((f42 * f44) + (f43 * f45)) / ((float) Math.sqrt((double) (f48 * ((f44 * f44) + (f45 * f45))))))));
            if (z13 || degrees2 <= 0.0d) {
                d11 = 360.0d;
                if (z13 && degrees2 < 0.0d) {
                    degrees2 += 360.0d;
                }
            } else {
                d11 = 360.0d;
                degrees2 -= 360.0d;
            }
            float[] n11 = n((double) (degrees % 360.0f), degrees2 % d11);
            Matrix matrix = new Matrix();
            matrix.postScale(f47, abs2);
            matrix.postRotate(f19);
            matrix.postTranslate(f40, f41);
            matrix.mapPoints(n11);
            n11[n11.length - 2] = f21;
            n11[n11.length - 1] = f22;
            for (int i11 = 0; i11 < n11.length; i11 += 6) {
                wVar.d(n11[i11], n11[i11 + 1], n11[i11 + 2], n11[i11 + 3], n11[i11 + 4], n11[i11 + 5]);
            }
        }
    }

    public static float[] n(double d11, double d12) {
        int ceil = (int) Math.ceil(Math.abs(d12) / 90.0d);
        double radians = Math.toRadians(d11);
        float radians2 = (float) (Math.toRadians(d12) / ((double) ceil));
        double d13 = (double) radians2;
        double d14 = d13 / 2.0d;
        double sin = (Math.sin(d14) * 1.3333333333333333d) / (Math.cos(d14) + 1.0d);
        float[] fArr = new float[(ceil * 6)];
        int i11 = 0;
        int i12 = 0;
        while (i11 < ceil) {
            double d15 = ((double) (((float) i11) * radians2)) + radians;
            double cos = Math.cos(d15);
            double sin2 = Math.sin(d15);
            int i13 = i12 + 1;
            int i14 = ceil;
            double d16 = radians;
            fArr[i12] = (float) (cos - (sin * sin2));
            int i15 = i13 + 1;
            fArr[i13] = (float) (sin2 + (cos * sin));
            double d17 = d15 + d13;
            double cos2 = Math.cos(d17);
            double sin3 = Math.sin(d17);
            int i16 = i15 + 1;
            fArr[i15] = (float) ((sin * sin3) + cos2);
            int i17 = i16 + 1;
            fArr[i16] = (float) (sin3 - (sin * cos2));
            int i18 = i17 + 1;
            fArr[i17] = (float) cos2;
            fArr[i18] = (float) sin3;
            i11++;
            radians = d16;
            i12 = i18 + 1;
            ceil = i14;
        }
        return fArr;
    }

    public final void A(SVG.l0 l0Var) {
        Boolean bool;
        if ((l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).f64498d) != null) {
            this.f64625d.f64668h = bool.booleanValue();
        }
    }

    public final void A0(SVG.y yVar) {
        F("PolyLine render", new Object[0]);
        c1(this.f64625d, yVar);
        if (H() && e1()) {
            h hVar = this.f64625d;
            if (hVar.f64663c || hVar.f64662b) {
                Matrix matrix = yVar.f64502n;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                if (yVar.f64564o.length >= 2) {
                    Path i02 = i0(yVar);
                    a1(yVar);
                    i02.setFillType(b0());
                    x(yVar);
                    u(yVar);
                    boolean s02 = s0();
                    if (this.f64625d.f64662b) {
                        I(yVar, i02);
                    }
                    if (this.f64625d.f64663c) {
                        J(i02);
                    }
                    O0(yVar);
                    if (s02) {
                        q0(yVar);
                    }
                }
            }
        }
    }

    public final void B0(SVG.z zVar) {
        F("Polygon render", new Object[0]);
        c1(this.f64625d, zVar);
        if (H() && e1()) {
            h hVar = this.f64625d;
            if (hVar.f64663c || hVar.f64662b) {
                Matrix matrix = zVar.f64502n;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                if (zVar.f64564o.length >= 2) {
                    Path i02 = i0(zVar);
                    a1(zVar);
                    x(zVar);
                    u(zVar);
                    boolean s02 = s0();
                    if (this.f64625d.f64662b) {
                        I(zVar, i02);
                    }
                    if (this.f64625d.f64663c) {
                        J(i02);
                    }
                    O0(zVar);
                    if (s02) {
                        q0(zVar);
                    }
                }
            }
        }
    }

    public final void C() {
        this.f64622a.restore();
        this.f64625d = this.f64626e.pop();
    }

    public final void C0(SVG.a0 a0Var) {
        F("Rect render", new Object[0]);
        SVG.o oVar = a0Var.f64443q;
        if (oVar != null && a0Var.f64444r != null && !oVar.i() && !a0Var.f64444r.i()) {
            c1(this.f64625d, a0Var);
            if (H() && e1()) {
                Matrix matrix = a0Var.f64502n;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                Path j02 = j0(a0Var);
                a1(a0Var);
                x(a0Var);
                u(a0Var);
                boolean s02 = s0();
                if (this.f64625d.f64662b) {
                    I(a0Var, j02);
                }
                if (this.f64625d.f64663c) {
                    J(j02);
                }
                if (s02) {
                    q0(a0Var);
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void D() {
        this.f64622a.save(1);
        this.f64626e.push(this.f64625d);
        this.f64625d = new h(this.f64625d);
    }

    public final void D0(SVG.d0 d0Var) {
        F0(d0Var, m0(d0Var.f64466q, d0Var.f64467r, d0Var.f64468s, d0Var.f64469t), d0Var.f64528p, d0Var.f64516o);
    }

    public final void E0(SVG.d0 d0Var, SVG.b bVar) {
        F0(d0Var, bVar, d0Var.f64528p, d0Var.f64516o);
    }

    public final void F0(SVG.d0 d0Var, SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        F("Svg render", new Object[0]);
        if (bVar.f64451c != 0.0f && bVar.f64452d != 0.0f) {
            if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.f64516o) == null) {
                preserveAspectRatio = PreserveAspectRatio.f64384e;
            }
            c1(this.f64625d, d0Var);
            if (H()) {
                h hVar = this.f64625d;
                hVar.f64666f = bVar;
                if (!hVar.f64661a.f64428w.booleanValue()) {
                    SVG.b bVar3 = this.f64625d.f64666f;
                    U0(bVar3.f64449a, bVar3.f64450b, bVar3.f64451c, bVar3.f64452d);
                }
                v(d0Var, this.f64625d.f64666f);
                if (bVar2 != null) {
                    this.f64622a.concat(t(this.f64625d.f64666f, bVar2, preserveAspectRatio));
                    this.f64625d.f64667g = d0Var.f64528p;
                } else {
                    Canvas canvas = this.f64622a;
                    SVG.b bVar4 = this.f64625d.f64666f;
                    canvas.translate(bVar4.f64449a, bVar4.f64450b);
                }
                boolean s02 = s0();
                d1();
                L0(d0Var, true);
                if (s02) {
                    q0(d0Var);
                }
                a1(d0Var);
            }
        }
    }

    public final void G(boolean z11, SVG.b bVar, SVG.t tVar) {
        SVG.l0 q11 = this.f64624c.q(tVar.f64543b);
        if (q11 == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z11 ? "Fill" : "Stroke";
            objArr[1] = tVar.f64543b;
            M("%s reference '%s' not found", objArr);
            SVG.m0 m0Var = tVar.f64544c;
            if (m0Var != null) {
                V0(this.f64625d, z11, m0Var);
            } else if (z11) {
                this.f64625d.f64662b = false;
            } else {
                this.f64625d.f64663c = false;
            }
        } else if (q11 instanceof SVG.k0) {
            e0(z11, bVar, (SVG.k0) q11);
        } else if (q11 instanceof SVG.o0) {
            l0(z11, bVar, (SVG.o0) q11);
        } else if (q11 instanceof SVG.b0) {
            W0(z11, (SVG.b0) q11);
        }
    }

    public final void G0(SVG.l0 l0Var) {
        if (!(l0Var instanceof SVG.s)) {
            Y0();
            A(l0Var);
            if (l0Var instanceof SVG.d0) {
                D0((SVG.d0) l0Var);
            } else if (l0Var instanceof SVG.b1) {
                K0((SVG.b1) l0Var);
            } else if (l0Var instanceof SVG.q0) {
                H0((SVG.q0) l0Var);
            } else if (l0Var instanceof SVG.l) {
                w0((SVG.l) l0Var);
            } else if (l0Var instanceof SVG.n) {
                x0((SVG.n) l0Var);
            } else if (l0Var instanceof SVG.u) {
                z0((SVG.u) l0Var);
            } else if (l0Var instanceof SVG.a0) {
                C0((SVG.a0) l0Var);
            } else if (l0Var instanceof SVG.d) {
                u0((SVG.d) l0Var);
            } else if (l0Var instanceof SVG.i) {
                v0((SVG.i) l0Var);
            } else if (l0Var instanceof SVG.p) {
                y0((SVG.p) l0Var);
            } else if (l0Var instanceof SVG.z) {
                B0((SVG.z) l0Var);
            } else if (l0Var instanceof SVG.y) {
                A0((SVG.y) l0Var);
            } else if (l0Var instanceof SVG.u0) {
                J0((SVG.u0) l0Var);
            }
            X0();
        }
    }

    public final boolean H() {
        Boolean bool = this.f64625d.f64661a.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void H0(SVG.q0 q0Var) {
        F("Switch render", new Object[0]);
        c1(this.f64625d, q0Var);
        if (H()) {
            Matrix matrix = q0Var.f64507o;
            if (matrix != null) {
                this.f64622a.concat(matrix);
            }
            u(q0Var);
            boolean s02 = s0();
            Q0(q0Var);
            if (s02) {
                q0(q0Var);
            }
            a1(q0Var);
        }
    }

    public final void I(SVG.i0 i0Var, Path path) {
        SVG.m0 m0Var = this.f64625d.f64661a.f64408c;
        if (m0Var instanceof SVG.t) {
            SVG.l0 q11 = this.f64624c.q(((SVG.t) m0Var).f64543b);
            if (q11 instanceof SVG.x) {
                S(i0Var, path, (SVG.x) q11);
                return;
            }
        }
        this.f64622a.drawPath(path, this.f64625d.f64664d);
    }

    public final void I0(SVG.r0 r0Var, SVG.b bVar) {
        F("Symbol render", new Object[0]);
        if (bVar.f64451c != 0.0f && bVar.f64452d != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = r0Var.f64516o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f64384e;
            }
            c1(this.f64625d, r0Var);
            h hVar = this.f64625d;
            hVar.f64666f = bVar;
            if (!hVar.f64661a.f64428w.booleanValue()) {
                SVG.b bVar2 = this.f64625d.f64666f;
                U0(bVar2.f64449a, bVar2.f64450b, bVar2.f64451c, bVar2.f64452d);
            }
            SVG.b bVar3 = r0Var.f64528p;
            if (bVar3 != null) {
                this.f64622a.concat(t(this.f64625d.f64666f, bVar3, preserveAspectRatio));
                this.f64625d.f64667g = r0Var.f64528p;
            } else {
                Canvas canvas = this.f64622a;
                SVG.b bVar4 = this.f64625d.f64666f;
                canvas.translate(bVar4.f64449a, bVar4.f64450b);
            }
            boolean s02 = s0();
            L0(r0Var, true);
            if (s02) {
                q0(r0Var);
            }
            a1(r0Var);
        }
    }

    public final void J(Path path) {
        h hVar = this.f64625d;
        if (hVar.f64661a.M == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.f64622a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f64622a.setMatrix(new Matrix());
            Shader shader = this.f64625d.f64665e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f64622a.drawPath(path2, this.f64625d.f64665e);
            this.f64622a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f64622a.drawPath(path, hVar.f64665e);
    }

    public final void J0(SVG.u0 u0Var) {
        F("Text render", new Object[0]);
        c1(this.f64625d, u0Var);
        if (H()) {
            Matrix matrix = u0Var.f64548s;
            if (matrix != null) {
                this.f64622a.concat(matrix);
            }
            List<SVG.o> list = u0Var.f64565o;
            float f11 = 0.0f;
            float f12 = (list == null || list.size() == 0) ? 0.0f : u0Var.f64565o.get(0).f(this);
            List<SVG.o> list2 = u0Var.f64566p;
            float g11 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.f64566p.get(0).g(this);
            List<SVG.o> list3 = u0Var.f64567q;
            float f13 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.f64567q.get(0).f(this);
            List<SVG.o> list4 = u0Var.f64568r;
            if (!(list4 == null || list4.size() == 0)) {
                f11 = u0Var.f64568r.get(0).g(this);
            }
            SVG.Style.TextAnchor V = V();
            if (V != SVG.Style.TextAnchor.Start) {
                float s11 = s(u0Var);
                if (V == SVG.Style.TextAnchor.Middle) {
                    s11 /= 2.0f;
                }
                f12 -= s11;
            }
            if (u0Var.f64491h == null) {
                i iVar = new i(f12, g11);
                L(u0Var, iVar);
                RectF rectF = iVar.f64672d;
                u0Var.f64491h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f64672d.height());
            }
            a1(u0Var);
            x(u0Var);
            u(u0Var);
            boolean s02 = s0();
            L(u0Var, new f(f12 + f13, g11 + f11));
            if (s02) {
                q0(u0Var);
            }
        }
    }

    public final float K(float f11, float f12, float f13, float f14) {
        return (f11 * f13) + (f12 * f14);
    }

    public final void K0(SVG.b1 b1Var) {
        F("Use render", new Object[0]);
        SVG.o oVar = b1Var.f64456s;
        if (oVar == null || !oVar.i()) {
            SVG.o oVar2 = b1Var.f64457t;
            if (oVar2 == null || !oVar2.i()) {
                c1(this.f64625d, b1Var);
                if (H()) {
                    SVG.l0 q11 = b1Var.f64508a.q(b1Var.f64453p);
                    if (q11 == null) {
                        M("Use reference '%s' not found", b1Var.f64453p);
                        return;
                    }
                    Matrix matrix = b1Var.f64507o;
                    if (matrix != null) {
                        this.f64622a.concat(matrix);
                    }
                    SVG.o oVar3 = b1Var.f64454q;
                    float f11 = 0.0f;
                    float f12 = oVar3 != null ? oVar3.f(this) : 0.0f;
                    SVG.o oVar4 = b1Var.f64455r;
                    if (oVar4 != null) {
                        f11 = oVar4.g(this);
                    }
                    this.f64622a.translate(f12, f11);
                    u(b1Var);
                    boolean s02 = s0();
                    p0(b1Var);
                    if (q11 instanceof SVG.d0) {
                        SVG.b m02 = m0((SVG.o) null, (SVG.o) null, b1Var.f64456s, b1Var.f64457t);
                        Y0();
                        E0((SVG.d0) q11, m02);
                        X0();
                    } else if (q11 instanceof SVG.r0) {
                        SVG.o oVar5 = b1Var.f64456s;
                        if (oVar5 == null) {
                            oVar5 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        SVG.o oVar6 = b1Var.f64457t;
                        if (oVar6 == null) {
                            oVar6 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        SVG.b m03 = m0((SVG.o) null, (SVG.o) null, oVar5, oVar6);
                        Y0();
                        I0((SVG.r0) q11, m03);
                        X0();
                    } else {
                        G0(q11);
                    }
                    o0();
                    if (s02) {
                        q0(b1Var);
                    }
                    a1(b1Var);
                }
            }
        }
    }

    public final void L(SVG.w0 w0Var, j jVar) {
        if (H()) {
            Iterator<SVG.l0> it2 = w0Var.f64475i.iterator();
            boolean z11 = true;
            while (it2.hasNext()) {
                SVG.l0 next = it2.next();
                if (next instanceof SVG.a1) {
                    jVar.b(Z0(((SVG.a1) next).f64447c, z11, !it2.hasNext()));
                } else {
                    r0(next, jVar);
                }
                z11 = false;
            }
        }
    }

    public final void L0(SVG.h0 h0Var, boolean z11) {
        if (z11) {
            p0(h0Var);
        }
        for (SVG.l0 G0 : h0Var.getChildren()) {
            G0(G0);
        }
        if (z11) {
            o0();
        }
    }

    public void M0(SVG svg, RenderOptions renderOptions) {
        SVG.b bVar;
        PreserveAspectRatio preserveAspectRatio;
        Objects.requireNonNull(renderOptions, "renderOptions shouldn't be null");
        this.f64624c = svg;
        SVG.d0 l11 = svg.l();
        if (l11 == null) {
            f1("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.e()) {
            SVG.j0 f11 = this.f64624c.f(renderOptions.f64397e);
            if (f11 == null || !(f11 instanceof SVG.c1)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", new Object[]{renderOptions.f64397e}));
                return;
            }
            SVG.c1 c1Var = (SVG.c1) f11;
            bVar = c1Var.f64528p;
            if (bVar == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[]{renderOptions.f64397e}));
                return;
            }
            preserveAspectRatio = c1Var.f64516o;
        } else {
            bVar = renderOptions.f() ? renderOptions.f64396d : l11.f64528p;
            preserveAspectRatio = renderOptions.c() ? renderOptions.f64394b : l11.f64516o;
        }
        if (renderOptions.b()) {
            svg.a(renderOptions.f64393a);
        }
        if (renderOptions.d()) {
            CSSParser.m mVar = new CSSParser.m();
            this.f64629h = mVar;
            mVar.f64374a = svg.f(renderOptions.f64395c);
        }
        T0();
        A(l11);
        Y0();
        SVG.b bVar2 = new SVG.b(renderOptions.f64398f);
        SVG.o oVar = l11.f64468s;
        if (oVar != null) {
            bVar2.f64451c = oVar.e(this, bVar2.f64451c);
        }
        SVG.o oVar2 = l11.f64469t;
        if (oVar2 != null) {
            bVar2.f64452d = oVar2.e(this, bVar2.f64452d);
        }
        F0(l11, bVar2, bVar, preserveAspectRatio);
        X0();
        if (renderOptions.b()) {
            svg.b();
        }
    }

    public final void N(SVG.w0 w0Var, StringBuilder sb2) {
        Iterator<SVG.l0> it2 = w0Var.f64475i.iterator();
        boolean z11 = true;
        while (it2.hasNext()) {
            SVG.l0 next = it2.next();
            if (next instanceof SVG.w0) {
                N((SVG.w0) next, sb2);
            } else if (next instanceof SVG.a1) {
                sb2.append(Z0(((SVG.a1) next).f64447c, z11, !it2.hasNext()));
            }
            z11 = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        r0 = 0.0f - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e4, code lost:
        r7 = r8[r7.a().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ef, code lost:
        if (r7 == 2) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f2, code lost:
        if (r7 == 3) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        if (r7 == 5) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f8, code lost:
        if (r7 == 6) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if (r7 == 7) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        if (r7 == 8) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        r13 = r4 - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        r13 = (r4 - r13) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0108, code lost:
        r1 = 0.0f - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0113, code lost:
        if (r11.f64625d.f64661a.f64428w.booleanValue() != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0115, code lost:
        U0(r0, r1, r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0118, code lost:
        r3.reset();
        r3.preScale(r6, r5);
        r11.f64622a.concat(r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N0(com.caverock.androidsvg.SVG.q r12, com.caverock.androidsvg.c.C0708c r13) {
        /*
            r11 = this;
            r11.Y0()
            java.lang.Float r0 = r12.f64534v
            r1 = 0
            if (r0 == 0) goto L_0x0033
            float r0 = r0.floatValue()
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x002c
            float r0 = r13.f64644c
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x001e
            float r2 = r13.f64645d
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0033
        L_0x001e:
            float r2 = r13.f64645d
            double r2 = (double) r2
            double r4 = (double) r0
            double r2 = java.lang.Math.atan2(r2, r4)
            double r2 = java.lang.Math.toDegrees(r2)
            float r0 = (float) r2
            goto L_0x0034
        L_0x002c:
            java.lang.Float r0 = r12.f64534v
            float r0 = r0.floatValue()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            boolean r2 = r12.f64529q
            if (r2 == 0) goto L_0x003b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0047
        L_0x003b:
            com.caverock.androidsvg.c$h r2 = r11.f64625d
            com.caverock.androidsvg.SVG$Style r2 = r2.f64661a
            com.caverock.androidsvg.SVG$o r2 = r2.f64413h
            float r3 = r11.f64623b
            float r2 = r2.c(r3)
        L_0x0047:
            com.caverock.androidsvg.c$h r3 = r11.T(r12)
            r11.f64625d = r3
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            float r4 = r13.f64642a
            float r13 = r13.f64643b
            r3.preTranslate(r4, r13)
            r3.preRotate(r0)
            r3.preScale(r2, r2)
            com.caverock.androidsvg.SVG$o r13 = r12.f64530r
            if (r13 == 0) goto L_0x0068
            float r13 = r13.f(r11)
            goto L_0x0069
        L_0x0068:
            r13 = r1
        L_0x0069:
            com.caverock.androidsvg.SVG$o r0 = r12.f64531s
            if (r0 == 0) goto L_0x0072
            float r0 = r0.g(r11)
            goto L_0x0073
        L_0x0072:
            r0 = r1
        L_0x0073:
            com.caverock.androidsvg.SVG$o r2 = r12.f64532t
            r4 = 1077936128(0x40400000, float:3.0)
            if (r2 == 0) goto L_0x007e
            float r2 = r2.f(r11)
            goto L_0x007f
        L_0x007e:
            r2 = r4
        L_0x007f:
            com.caverock.androidsvg.SVG$o r5 = r12.f64533u
            if (r5 == 0) goto L_0x0087
            float r4 = r5.g(r11)
        L_0x0087:
            com.caverock.androidsvg.SVG$b r5 = r12.f64528p
            if (r5 == 0) goto L_0x0124
            float r6 = r5.f64451c
            float r6 = r2 / r6
            float r5 = r5.f64452d
            float r5 = r4 / r5
            com.caverock.androidsvg.PreserveAspectRatio r7 = r12.f64516o
            if (r7 == 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            com.caverock.androidsvg.PreserveAspectRatio r7 = com.caverock.androidsvg.PreserveAspectRatio.f64384e
        L_0x009a:
            com.caverock.androidsvg.PreserveAspectRatio r8 = com.caverock.androidsvg.PreserveAspectRatio.f64383d
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00b5
            com.caverock.androidsvg.PreserveAspectRatio$Scale r8 = r7.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r9 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r8 != r9) goto L_0x00af
            float r5 = java.lang.Math.max(r6, r5)
            goto L_0x00b3
        L_0x00af:
            float r5 = java.lang.Math.min(r6, r5)
        L_0x00b3:
            r6 = r5
            r5 = r6
        L_0x00b5:
            float r13 = -r13
            float r13 = r13 * r6
            float r0 = -r0
            float r0 = r0 * r5
            r3.preTranslate(r13, r0)
            android.graphics.Canvas r13 = r11.f64622a
            r13.concat(r3)
            com.caverock.androidsvg.SVG$b r13 = r12.f64528p
            float r0 = r13.f64451c
            float r0 = r0 * r6
            float r13 = r13.f64452d
            float r13 = r13 * r5
            int[] r8 = com.caverock.androidsvg.c.a.f64630a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r9 = r7.a()
            int r9 = r9.ordinal()
            r9 = r8[r9]
            r10 = 1073741824(0x40000000, float:2.0)
            switch(r9) {
                case 1: goto L_0x00df;
                case 2: goto L_0x00df;
                case 3: goto L_0x00df;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00dc;
                default: goto L_0x00da;
            }
        L_0x00da:
            r0 = r1
            goto L_0x00e4
        L_0x00dc:
            float r0 = r2 - r0
            goto L_0x00e2
        L_0x00df:
            float r0 = r2 - r0
            float r0 = r0 / r10
        L_0x00e2:
            float r0 = r1 - r0
        L_0x00e4:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r7.a()
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 2
            if (r7 == r8) goto L_0x0105
            r8 = 3
            if (r7 == r8) goto L_0x0102
            r8 = 5
            if (r7 == r8) goto L_0x0105
            r8 = 6
            if (r7 == r8) goto L_0x0102
            r8 = 7
            if (r7 == r8) goto L_0x0105
            r8 = 8
            if (r7 == r8) goto L_0x0102
            goto L_0x0109
        L_0x0102:
            float r13 = r4 - r13
            goto L_0x0108
        L_0x0105:
            float r13 = r4 - r13
            float r13 = r13 / r10
        L_0x0108:
            float r1 = r1 - r13
        L_0x0109:
            com.caverock.androidsvg.c$h r13 = r11.f64625d
            com.caverock.androidsvg.SVG$Style r13 = r13.f64661a
            java.lang.Boolean r13 = r13.f64428w
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0118
            r11.U0(r0, r1, r2, r4)
        L_0x0118:
            r3.reset()
            r3.preScale(r6, r5)
            android.graphics.Canvas r13 = r11.f64622a
            r13.concat(r3)
            goto L_0x013d
        L_0x0124:
            float r13 = -r13
            float r0 = -r0
            r3.preTranslate(r13, r0)
            android.graphics.Canvas r13 = r11.f64622a
            r13.concat(r3)
            com.caverock.androidsvg.c$h r13 = r11.f64625d
            com.caverock.androidsvg.SVG$Style r13 = r13.f64661a
            java.lang.Boolean r13 = r13.f64428w
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x013d
            r11.U0(r1, r1, r2, r4)
        L_0x013d:
            boolean r13 = r11.s0()
            r0 = 0
            r11.L0(r12, r0)
            if (r13 == 0) goto L_0x014a
            r11.q0(r12)
        L_0x014a:
            r11.X0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.N0(com.caverock.androidsvg.SVG$q, com.caverock.androidsvg.c$c):void");
    }

    public final void O(SVG.j jVar, String str) {
        SVG.l0 q11 = jVar.f64508a.q(str);
        if (q11 == null) {
            f1("Gradient reference '%s' not found", str);
        } else if (!(q11 instanceof SVG.j)) {
            M("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (q11 == jVar) {
            M("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.j jVar2 = (SVG.j) q11;
            if (jVar.f64493i == null) {
                jVar.f64493i = jVar2.f64493i;
            }
            if (jVar.f64494j == null) {
                jVar.f64494j = jVar2.f64494j;
            }
            if (jVar.f64495k == null) {
                jVar.f64495k = jVar2.f64495k;
            }
            if (jVar.f64492h.isEmpty()) {
                jVar.f64492h = jVar2.f64492h;
            }
            try {
                if (jVar instanceof SVG.k0) {
                    P((SVG.k0) jVar, (SVG.k0) q11);
                } else {
                    Q((SVG.o0) jVar, (SVG.o0) q11);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = jVar2.f64496l;
            if (str2 != null) {
                O(jVar, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O0(com.caverock.androidsvg.SVG.k r10) {
        /*
            r9 = this;
            com.caverock.androidsvg.c$h r0 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r0 = r0.f64661a
            java.lang.String r1 = r0.f64430y
            if (r1 != 0) goto L_0x0011
            java.lang.String r2 = r0.f64431z
            if (r2 != 0) goto L_0x0011
            java.lang.String r0 = r0.A
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.String r0 = "Marker reference '%s' not found"
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0030
            com.caverock.androidsvg.SVG r5 = r10.f64508a
            com.caverock.androidsvg.SVG$l0 r1 = r5.q(r1)
            if (r1 == 0) goto L_0x0023
            com.caverock.androidsvg.SVG$q r1 = (com.caverock.androidsvg.SVG.q) r1
            goto L_0x0031
        L_0x0023:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.caverock.androidsvg.c$h r5 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r5 = r5.f64661a
            java.lang.String r5 = r5.f64430y
            r1[r3] = r5
            M(r0, r1)
        L_0x0030:
            r1 = r2
        L_0x0031:
            com.caverock.androidsvg.c$h r5 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r5 = r5.f64661a
            java.lang.String r5 = r5.f64431z
            if (r5 == 0) goto L_0x0051
            com.caverock.androidsvg.SVG r6 = r10.f64508a
            com.caverock.androidsvg.SVG$l0 r5 = r6.q(r5)
            if (r5 == 0) goto L_0x0044
            com.caverock.androidsvg.SVG$q r5 = (com.caverock.androidsvg.SVG.q) r5
            goto L_0x0052
        L_0x0044:
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.caverock.androidsvg.c$h r6 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r6 = r6.f64661a
            java.lang.String r6 = r6.f64431z
            r5[r3] = r6
            M(r0, r5)
        L_0x0051:
            r5 = r2
        L_0x0052:
            com.caverock.androidsvg.c$h r6 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r6 = r6.f64661a
            java.lang.String r6 = r6.A
            if (r6 == 0) goto L_0x0072
            com.caverock.androidsvg.SVG r7 = r10.f64508a
            com.caverock.androidsvg.SVG$l0 r6 = r7.q(r6)
            if (r6 == 0) goto L_0x0065
            com.caverock.androidsvg.SVG$q r6 = (com.caverock.androidsvg.SVG.q) r6
            goto L_0x0073
        L_0x0065:
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.caverock.androidsvg.c$h r7 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r7 = r7.f64661a
            java.lang.String r7 = r7.A
            r6[r3] = r7
            M(r0, r6)
        L_0x0072:
            r6 = r2
        L_0x0073:
            boolean r0 = r10 instanceof com.caverock.androidsvg.SVG.u
            if (r0 == 0) goto L_0x0085
            com.caverock.androidsvg.c$b r0 = new com.caverock.androidsvg.c$b
            com.caverock.androidsvg.SVG$u r10 = (com.caverock.androidsvg.SVG.u) r10
            com.caverock.androidsvg.SVG$v r10 = r10.f64546o
            r0.<init>(r10)
            java.util.List r10 = r0.f()
            goto L_0x0096
        L_0x0085:
            boolean r0 = r10 instanceof com.caverock.androidsvg.SVG.p
            if (r0 == 0) goto L_0x0090
            com.caverock.androidsvg.SVG$p r10 = (com.caverock.androidsvg.SVG.p) r10
            java.util.List r10 = r9.p(r10)
            goto L_0x0096
        L_0x0090:
            com.caverock.androidsvg.SVG$y r10 = (com.caverock.androidsvg.SVG.y) r10
            java.util.List r10 = r9.q(r10)
        L_0x0096:
            if (r10 != 0) goto L_0x0099
            return
        L_0x0099:
            int r0 = r10.size()
            if (r0 != 0) goto L_0x00a0
            return
        L_0x00a0:
            com.caverock.androidsvg.c$h r7 = r9.f64625d
            com.caverock.androidsvg.SVG$Style r7 = r7.f64661a
            r7.A = r2
            r7.f64431z = r2
            r7.f64430y = r2
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r2 = r10.get(r3)
            com.caverock.androidsvg.c$c r2 = (com.caverock.androidsvg.c.C0708c) r2
            r9.N0(r1, r2)
        L_0x00b5:
            if (r5 == 0) goto L_0x00e6
            int r1 = r10.size()
            r2 = 2
            if (r1 <= r2) goto L_0x00e6
            java.lang.Object r1 = r10.get(r3)
            com.caverock.androidsvg.c$c r1 = (com.caverock.androidsvg.c.C0708c) r1
            java.lang.Object r2 = r10.get(r4)
            com.caverock.androidsvg.c$c r2 = (com.caverock.androidsvg.c.C0708c) r2
            r3 = r4
        L_0x00cb:
            int r7 = r0 + -1
            if (r3 >= r7) goto L_0x00e6
            int r3 = r3 + 1
            java.lang.Object r7 = r10.get(r3)
            com.caverock.androidsvg.c$c r7 = (com.caverock.androidsvg.c.C0708c) r7
            boolean r8 = r2.f64646e
            if (r8 == 0) goto L_0x00e0
            com.caverock.androidsvg.c$c r1 = r9.t0(r1, r2, r7)
            goto L_0x00e1
        L_0x00e0:
            r1 = r2
        L_0x00e1:
            r9.N0(r5, r1)
            r2 = r7
            goto L_0x00cb
        L_0x00e6:
            if (r6 == 0) goto L_0x00f2
            int r0 = r0 - r4
            java.lang.Object r10 = r10.get(r0)
            com.caverock.androidsvg.c$c r10 = (com.caverock.androidsvg.c.C0708c) r10
            r9.N0(r6, r10)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.O0(com.caverock.androidsvg.SVG$k):void");
    }

    public final void P(SVG.k0 k0Var, SVG.k0 k0Var2) {
        if (k0Var.f64503m == null) {
            k0Var.f64503m = k0Var2.f64503m;
        }
        if (k0Var.f64504n == null) {
            k0Var.f64504n = k0Var2.f64504n;
        }
        if (k0Var.f64505o == null) {
            k0Var.f64505o = k0Var2.f64505o;
        }
        if (k0Var.f64506p == null) {
            k0Var.f64506p = k0Var2.f64506p;
        }
    }

    public final void P0(SVG.r rVar, SVG.i0 i0Var) {
        float f11;
        float f12;
        F("Mask render", new Object[0]);
        Boolean bool = rVar.f64535o;
        boolean z11 = true;
        if (bool != null && bool.booleanValue()) {
            SVG.o oVar = rVar.f64539s;
            f12 = oVar != null ? oVar.f(this) : i0Var.f64491h.f64451c;
            SVG.o oVar2 = rVar.f64540t;
            f11 = oVar2 != null ? oVar2.g(this) : i0Var.f64491h.f64452d;
        } else {
            SVG.o oVar3 = rVar.f64539s;
            float f13 = 1.2f;
            float e11 = oVar3 != null ? oVar3.e(this, 1.0f) : 1.2f;
            SVG.o oVar4 = rVar.f64540t;
            if (oVar4 != null) {
                f13 = oVar4.e(this, 1.0f);
            }
            SVG.b bVar = i0Var.f64491h;
            f12 = e11 * bVar.f64451c;
            f11 = f13 * bVar.f64452d;
        }
        if (f12 != 0.0f && f11 != 0.0f) {
            Y0();
            h T = T(rVar);
            this.f64625d = T;
            T.f64661a.f64419n = Float.valueOf(1.0f);
            Boolean bool2 = rVar.f64536p;
            if (bool2 != null && !bool2.booleanValue()) {
                z11 = false;
            }
            if (!z11) {
                Canvas canvas = this.f64622a;
                SVG.b bVar2 = i0Var.f64491h;
                canvas.translate(bVar2.f64449a, bVar2.f64450b);
                Canvas canvas2 = this.f64622a;
                SVG.b bVar3 = i0Var.f64491h;
                canvas2.scale(bVar3.f64451c, bVar3.f64452d);
            }
            L0(rVar, false);
            X0();
        }
    }

    public final void Q(SVG.o0 o0Var, SVG.o0 o0Var2) {
        if (o0Var.f64519m == null) {
            o0Var.f64519m = o0Var2.f64519m;
        }
        if (o0Var.f64520n == null) {
            o0Var.f64520n = o0Var2.f64520n;
        }
        if (o0Var.f64521o == null) {
            o0Var.f64521o = o0Var2.f64521o;
        }
        if (o0Var.f64522p == null) {
            o0Var.f64522p = o0Var2.f64522p;
        }
        if (o0Var.f64523q == null) {
            o0Var.f64523q = o0Var2.f64523q;
        }
    }

    public final void Q0(SVG.q0 q0Var) {
        Set<String> f11;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver g11 = SVG.g();
        for (SVG.l0 next : q0Var.getChildren()) {
            if (next instanceof SVG.e0) {
                SVG.e0 e0Var = (SVG.e0) next;
                if (e0Var.a() == null && ((f11 = e0Var.f()) == null || (!f11.isEmpty() && f11.contains(language)))) {
                    Set<String> requiredFeatures = e0Var.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (f64621i == null) {
                            c0();
                        }
                        if (requiredFeatures.isEmpty()) {
                            continue;
                        } else if (!f64621i.containsAll(requiredFeatures)) {
                            continue;
                        }
                    }
                    Set<String> e11 = e0Var.e();
                    if (e11 != null) {
                        if (!e11.isEmpty() && g11 != null) {
                            Iterator<String> it2 = e11.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!g11.a(it2.next())) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> l11 = e0Var.l();
                    if (l11 != null) {
                        if (!l11.isEmpty() && g11 != null) {
                            for (String c11 : l11) {
                                if (g11.c(c11, this.f64625d.f64661a.f64423r.intValue(), String.valueOf(this.f64625d.f64661a.f64424s)) == null) {
                                }
                            }
                        }
                    }
                    G0(next);
                    return;
                }
            }
        }
    }

    public final void R(SVG.x xVar, String str) {
        SVG.l0 q11 = xVar.f64508a.q(str);
        if (q11 == null) {
            f1("Pattern reference '%s' not found", str);
        } else if (!(q11 instanceof SVG.x)) {
            M("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (q11 == xVar) {
            M("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.x xVar2 = (SVG.x) q11;
            if (xVar.f64553q == null) {
                xVar.f64553q = xVar2.f64553q;
            }
            if (xVar.f64554r == null) {
                xVar.f64554r = xVar2.f64554r;
            }
            if (xVar.f64555s == null) {
                xVar.f64555s = xVar2.f64555s;
            }
            if (xVar.f64556t == null) {
                xVar.f64556t = xVar2.f64556t;
            }
            if (xVar.f64557u == null) {
                xVar.f64557u = xVar2.f64557u;
            }
            if (xVar.f64558v == null) {
                xVar.f64558v = xVar2.f64558v;
            }
            if (xVar.f64559w == null) {
                xVar.f64559w = xVar2.f64559w;
            }
            if (xVar.f64475i.isEmpty()) {
                xVar.f64475i = xVar2.f64475i;
            }
            if (xVar.f64528p == null) {
                xVar.f64528p = xVar2.f64528p;
            }
            if (xVar.f64516o == null) {
                xVar.f64516o = xVar2.f64516o;
            }
            String str2 = xVar2.f64560x;
            if (str2 != null) {
                R(xVar, str2);
            }
        }
    }

    public final void R0(SVG.x0 x0Var) {
        F("TextPath render", new Object[0]);
        c1(this.f64625d, x0Var);
        if (H() && e1()) {
            SVG.l0 q11 = x0Var.f64508a.q(x0Var.f64561o);
            if (q11 == null) {
                M("TextPath reference '%s' not found", x0Var.f64561o);
                return;
            }
            SVG.u uVar = (SVG.u) q11;
            Path f11 = new d(uVar.f64546o).f();
            Matrix matrix = uVar.f64502n;
            if (matrix != null) {
                f11.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(f11, false);
            SVG.o oVar = x0Var.f64562p;
            float e11 = oVar != null ? oVar.e(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor V = V();
            if (V != SVG.Style.TextAnchor.Start) {
                float s11 = s(x0Var);
                if (V == SVG.Style.TextAnchor.Middle) {
                    s11 /= 2.0f;
                }
                e11 -= s11;
            }
            x((SVG.i0) x0Var.c());
            boolean s02 = s0();
            L(x0Var, new e(f11, e11, 0.0f));
            if (s02) {
                q0(x0Var);
            }
        }
    }

    public final void S(SVG.i0 i0Var, Path path, SVG.x xVar) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        SVG.i0 i0Var2 = i0Var;
        SVG.x xVar2 = xVar;
        Boolean bool = xVar2.f64553q;
        boolean z11 = bool != null && bool.booleanValue();
        String str = xVar2.f64560x;
        if (str != null) {
            R(xVar2, str);
        }
        if (z11) {
            SVG.o oVar = xVar2.f64556t;
            f14 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = xVar2.f64557u;
            f13 = oVar2 != null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = xVar2.f64558v;
            f12 = oVar3 != null ? oVar3.f(this) : 0.0f;
            SVG.o oVar4 = xVar2.f64559w;
            f11 = oVar4 != null ? oVar4.g(this) : 0.0f;
        } else {
            SVG.o oVar5 = xVar2.f64556t;
            float e11 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
            SVG.o oVar6 = xVar2.f64557u;
            float e12 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
            SVG.o oVar7 = xVar2.f64558v;
            float e13 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.0f;
            SVG.o oVar8 = xVar2.f64559w;
            float e14 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
            SVG.b bVar = i0Var2.f64491h;
            float f16 = bVar.f64449a;
            float f17 = bVar.f64451c;
            f14 = (e11 * f17) + f16;
            float f18 = bVar.f64450b;
            float f19 = bVar.f64452d;
            float f21 = e13 * f17;
            f11 = e14 * f19;
            f13 = (e12 * f19) + f18;
            f12 = f21;
        }
        if (f12 != 0.0f && f11 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = xVar2.f64516o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f64384e;
            }
            Y0();
            this.f64622a.clipPath(path);
            h hVar = new h();
            b1(hVar, SVG.Style.b());
            hVar.f64661a.f64428w = Boolean.FALSE;
            this.f64625d = U(xVar2, hVar);
            SVG.b bVar2 = i0Var2.f64491h;
            Matrix matrix = xVar2.f64555s;
            if (matrix != null) {
                this.f64622a.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (xVar2.f64555s.invert(matrix2)) {
                    SVG.b bVar3 = i0Var2.f64491h;
                    SVG.b bVar4 = i0Var2.f64491h;
                    SVG.b bVar5 = i0Var2.f64491h;
                    float[] fArr = {bVar3.f64449a, bVar3.f64450b, bVar3.b(), bVar4.f64450b, bVar4.b(), i0Var2.f64491h.c(), bVar5.f64449a, bVar5.c()};
                    matrix2.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i11 = 2; i11 <= 6; i11 += 2) {
                        if (fArr[i11] < rectF.left) {
                            rectF.left = fArr[i11];
                        }
                        if (fArr[i11] > rectF.right) {
                            rectF.right = fArr[i11];
                        }
                        int i12 = i11 + 1;
                        if (fArr[i12] < rectF.top) {
                            rectF.top = fArr[i12];
                        }
                        if (fArr[i12] > rectF.bottom) {
                            rectF.bottom = fArr[i12];
                        }
                    }
                    float f22 = rectF.left;
                    float f23 = rectF.top;
                    bVar2 = new SVG.b(f22, f23, rectF.right - f22, rectF.bottom - f23);
                }
            }
            float floor = f14 + (((float) Math.floor((double) ((bVar2.f64449a - f14) / f12))) * f12);
            float b11 = bVar2.b();
            float c11 = bVar2.c();
            SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f12, f11);
            boolean s02 = s0();
            for (float floor2 = f13 + (((float) Math.floor((double) ((bVar2.f64450b - f13) / f11))) * f11); floor2 < c11; floor2 += f11) {
                float f24 = floor;
                while (f24 < b11) {
                    bVar6.f64449a = f24;
                    bVar6.f64450b = floor2;
                    Y0();
                    if (!this.f64625d.f64661a.f64428w.booleanValue()) {
                        f15 = floor;
                        U0(bVar6.f64449a, bVar6.f64450b, bVar6.f64451c, bVar6.f64452d);
                    } else {
                        f15 = floor;
                    }
                    SVG.b bVar7 = xVar2.f64528p;
                    if (bVar7 != null) {
                        this.f64622a.concat(t(bVar6, bVar7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = xVar2.f64554r;
                        boolean z12 = bool2 == null || bool2.booleanValue();
                        this.f64622a.translate(f24, floor2);
                        if (!z12) {
                            Canvas canvas = this.f64622a;
                            SVG.b bVar8 = i0Var2.f64491h;
                            canvas.scale(bVar8.f64451c, bVar8.f64452d);
                        }
                    }
                    for (SVG.l0 G0 : xVar2.f64475i) {
                        G0(G0);
                    }
                    X0();
                    f24 += f12;
                    floor = f15;
                }
                float f25 = floor;
            }
            if (s02) {
                q0(xVar2);
            }
            X0();
        }
    }

    public final boolean S0() {
        return this.f64625d.f64661a.f64419n.floatValue() < 1.0f || this.f64625d.f64661a.H != null;
    }

    public final h T(SVG.l0 l0Var) {
        h hVar = new h();
        b1(hVar, SVG.Style.b());
        return U(l0Var, hVar);
    }

    public final void T0() {
        this.f64625d = new h();
        this.f64626e = new Stack<>();
        b1(this.f64625d, SVG.Style.b());
        h hVar = this.f64625d;
        hVar.f64666f = null;
        hVar.f64668h = false;
        this.f64626e.push(new h(hVar));
        this.f64628g = new Stack<>();
        this.f64627f = new Stack<>();
    }

    public final h U(SVG.l0 l0Var, h hVar) {
        ArrayList<SVG.j0> arrayList = new ArrayList<>();
        while (true) {
            if (l0Var instanceof SVG.j0) {
                arrayList.add(0, (SVG.j0) l0Var);
            }
            SVG.h0 h0Var = l0Var.f64509b;
            if (h0Var == null) {
                break;
            }
            l0Var = (SVG.l0) h0Var;
        }
        for (SVG.j0 c12 : arrayList) {
            c1(hVar, c12);
        }
        h hVar2 = this.f64625d;
        hVar.f64667g = hVar2.f64667g;
        hVar.f64666f = hVar2.f64666f;
        return hVar;
    }

    public final void U0(float f11, float f12, float f13, float f14) {
        float f15 = f13 + f11;
        float f16 = f14 + f12;
        SVG.c cVar = this.f64625d.f64661a.f64429x;
        if (cVar != null) {
            f11 += cVar.f64461d.f(this);
            f12 += this.f64625d.f64661a.f64429x.f64458a.g(this);
            f15 -= this.f64625d.f64661a.f64429x.f64459b.f(this);
            f16 -= this.f64625d.f64661a.f64429x.f64460c.g(this);
        }
        this.f64622a.clipRect(f11, f12, f15, f16);
    }

    public final SVG.Style.TextAnchor V() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.f64625d.f64661a;
        if (style.f64426u == SVG.Style.TextDirection.LTR || (textAnchor = style.f64427v) == SVG.Style.TextAnchor.Middle) {
            return style.f64427v;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
    }

    public final void V0(h hVar, boolean z11, SVG.m0 m0Var) {
        int i11;
        SVG.Style style = hVar.f64661a;
        float floatValue = (z11 ? style.f64410e : style.f64412g).floatValue();
        if (m0Var instanceof SVG.f) {
            i11 = ((SVG.f) m0Var).f64474b;
        } else if (m0Var instanceof SVG.g) {
            i11 = hVar.f64661a.f64420o.f64474b;
        } else {
            return;
        }
        int E = E(i11, floatValue);
        if (z11) {
            hVar.f64664d.setColor(E);
        } else {
            hVar.f64665e.setColor(E);
        }
    }

    public final Path.FillType W() {
        SVG.Style.FillRule fillRule = this.f64625d.f64661a.G;
        if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    public final void W0(boolean z11, SVG.b0 b0Var) {
        boolean z12 = true;
        if (z11) {
            if (d0(b0Var.f64499e, 2147483648L)) {
                h hVar = this.f64625d;
                SVG.Style style = hVar.f64661a;
                SVG.m0 m0Var = b0Var.f64499e.I;
                style.f64408c = m0Var;
                if (m0Var == null) {
                    z12 = false;
                }
                hVar.f64662b = z12;
            }
            if (d0(b0Var.f64499e, 4294967296L)) {
                this.f64625d.f64661a.f64410e = b0Var.f64499e.J;
            }
            if (d0(b0Var.f64499e, 6442450944L)) {
                h hVar2 = this.f64625d;
                V0(hVar2, z11, hVar2.f64661a.f64408c);
                return;
            }
            return;
        }
        if (d0(b0Var.f64499e, 2147483648L)) {
            h hVar3 = this.f64625d;
            SVG.Style style2 = hVar3.f64661a;
            SVG.m0 m0Var2 = b0Var.f64499e.I;
            style2.f64411f = m0Var2;
            if (m0Var2 == null) {
                z12 = false;
            }
            hVar3.f64663c = z12;
        }
        if (d0(b0Var.f64499e, 4294967296L)) {
            this.f64625d.f64661a.f64412g = b0Var.f64499e.J;
        }
        if (d0(b0Var.f64499e, 6442450944L)) {
            h hVar4 = this.f64625d;
            V0(hVar4, z11, hVar4.f64661a.f64411f);
        }
    }

    public float X() {
        return this.f64625d.f64664d.getTextSize();
    }

    public final void X0() {
        this.f64622a.restore();
        this.f64625d = this.f64626e.pop();
    }

    public float Y() {
        return this.f64625d.f64664d.getTextSize() / 2.0f;
    }

    public final void Y0() {
        this.f64622a.save();
        this.f64626e.push(this.f64625d);
        this.f64625d = new h(this.f64625d);
    }

    public SVG.b Z() {
        h hVar = this.f64625d;
        SVG.b bVar = hVar.f64667g;
        if (bVar != null) {
            return bVar;
        }
        return hVar.f64666f;
    }

    public final String Z0(String str, boolean z11, boolean z12) {
        if (this.f64625d.f64668h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z11) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z12) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    public float a0() {
        return this.f64623b;
    }

    public final void a1(SVG.i0 i0Var) {
        if (i0Var.f64509b != null && i0Var.f64491h != null) {
            Matrix matrix = new Matrix();
            if (this.f64628g.peek().invert(matrix)) {
                SVG.b bVar = i0Var.f64491h;
                SVG.b bVar2 = i0Var.f64491h;
                SVG.b bVar3 = i0Var.f64491h;
                float[] fArr = {bVar.f64449a, bVar.f64450b, bVar.b(), bVar2.f64450b, bVar2.b(), i0Var.f64491h.c(), bVar3.f64449a, bVar3.c()};
                matrix.preConcat(this.f64622a.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i11 = 2; i11 <= 6; i11 += 2) {
                    if (fArr[i11] < rectF.left) {
                        rectF.left = fArr[i11];
                    }
                    if (fArr[i11] > rectF.right) {
                        rectF.right = fArr[i11];
                    }
                    int i12 = i11 + 1;
                    if (fArr[i12] < rectF.top) {
                        rectF.top = fArr[i12];
                    }
                    if (fArr[i12] > rectF.bottom) {
                        rectF.bottom = fArr[i12];
                    }
                }
                SVG.i0 i0Var2 = (SVG.i0) this.f64627f.peek();
                SVG.b bVar4 = i0Var2.f64491h;
                if (bVar4 == null) {
                    i0Var2.f64491h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    bVar4.d(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    public final Path.FillType b0() {
        SVG.Style.FillRule fillRule = this.f64625d.f64661a.f64409d;
        if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    public final void b1(h hVar, SVG.Style style) {
        if (d0(style, 4096)) {
            hVar.f64661a.f64420o = style.f64420o;
        }
        if (d0(style, 2048)) {
            hVar.f64661a.f64419n = style.f64419n;
        }
        boolean z11 = false;
        if (d0(style, 1)) {
            hVar.f64661a.f64408c = style.f64408c;
            SVG.m0 m0Var = style.f64408c;
            hVar.f64662b = (m0Var == null || m0Var == SVG.f.f64473d) ? false : true;
        }
        if (d0(style, 4)) {
            hVar.f64661a.f64410e = style.f64410e;
        }
        if (d0(style, 6149)) {
            V0(hVar, true, hVar.f64661a.f64408c);
        }
        if (d0(style, 2)) {
            hVar.f64661a.f64409d = style.f64409d;
        }
        if (d0(style, 8)) {
            hVar.f64661a.f64411f = style.f64411f;
            SVG.m0 m0Var2 = style.f64411f;
            hVar.f64663c = (m0Var2 == null || m0Var2 == SVG.f.f64473d) ? false : true;
        }
        if (d0(style, 16)) {
            hVar.f64661a.f64412g = style.f64412g;
        }
        if (d0(style, 6168)) {
            V0(hVar, false, hVar.f64661a.f64411f);
        }
        if (d0(style, 34359738368L)) {
            hVar.f64661a.M = style.M;
        }
        if (d0(style, 32)) {
            SVG.Style style2 = hVar.f64661a;
            SVG.o oVar = style.f64413h;
            style2.f64413h = oVar;
            hVar.f64665e.setStrokeWidth(oVar.d(this));
        }
        if (d0(style, 64)) {
            hVar.f64661a.f64414i = style.f64414i;
            int i11 = a.f64631b[style.f64414i.ordinal()];
            if (i11 == 1) {
                hVar.f64665e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i11 == 2) {
                hVar.f64665e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i11 == 3) {
                hVar.f64665e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (d0(style, 128)) {
            hVar.f64661a.f64415j = style.f64415j;
            int i12 = a.f64632c[style.f64415j.ordinal()];
            if (i12 == 1) {
                hVar.f64665e.setStrokeJoin(Paint.Join.MITER);
            } else if (i12 == 2) {
                hVar.f64665e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i12 == 3) {
                hVar.f64665e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (d0(style, 256)) {
            hVar.f64661a.f64416k = style.f64416k;
            hVar.f64665e.setStrokeMiter(style.f64416k.floatValue());
        }
        if (d0(style, 512)) {
            hVar.f64661a.f64417l = style.f64417l;
        }
        if (d0(style, 1024)) {
            hVar.f64661a.f64418m = style.f64418m;
        }
        Typeface typeface = null;
        if (d0(style, 1536)) {
            SVG.o[] oVarArr = hVar.f64661a.f64417l;
            if (oVarArr == null) {
                hVar.f64665e.setPathEffect((PathEffect) null);
            } else {
                int length = oVarArr.length;
                int i13 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i13];
                float f11 = 0.0f;
                for (int i14 = 0; i14 < i13; i14++) {
                    fArr[i14] = hVar.f64661a.f64417l[i14 % length].d(this);
                    f11 += fArr[i14];
                }
                if (f11 == 0.0f) {
                    hVar.f64665e.setPathEffect((PathEffect) null);
                } else {
                    float d11 = hVar.f64661a.f64418m.d(this);
                    if (d11 < 0.0f) {
                        d11 = (d11 % f11) + f11;
                    }
                    hVar.f64665e.setPathEffect(new DashPathEffect(fArr, d11));
                }
            }
        }
        if (d0(style, 16384)) {
            float X = X();
            hVar.f64661a.f64422q = style.f64422q;
            hVar.f64664d.setTextSize(style.f64422q.e(this, X));
            hVar.f64665e.setTextSize(style.f64422q.e(this, X));
        }
        if (d0(style, 8192)) {
            hVar.f64661a.f64421p = style.f64421p;
        }
        if (d0(style, 32768)) {
            if (style.f64423r.intValue() == -1 && hVar.f64661a.f64423r.intValue() > 100) {
                SVG.Style style3 = hVar.f64661a;
                style3.f64423r = Integer.valueOf(style3.f64423r.intValue() - 100);
            } else if (style.f64423r.intValue() != 1 || hVar.f64661a.f64423r.intValue() >= 900) {
                hVar.f64661a.f64423r = style.f64423r;
            } else {
                SVG.Style style4 = hVar.f64661a;
                style4.f64423r = Integer.valueOf(style4.f64423r.intValue() + 100);
            }
        }
        if (d0(style, 65536)) {
            hVar.f64661a.f64424s = style.f64424s;
        }
        if (d0(style, 106496)) {
            if (hVar.f64661a.f64421p != null && this.f64624c != null) {
                SVGExternalFileResolver g11 = SVG.g();
                for (String next : hVar.f64661a.f64421p) {
                    SVG.Style style5 = hVar.f64661a;
                    Typeface z12 = z(next, style5.f64423r, style5.f64424s);
                    if (z12 != null || g11 == null) {
                        typeface = z12;
                        continue;
                    } else {
                        typeface = g11.c(next, hVar.f64661a.f64423r.intValue(), String.valueOf(hVar.f64661a.f64424s));
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.f64661a;
                typeface = z(C.SERIF_NAME, style6.f64423r, style6.f64424s);
            }
            hVar.f64664d.setTypeface(typeface);
            hVar.f64665e.setTypeface(typeface);
        }
        if (d0(style, 131072)) {
            hVar.f64661a.f64425t = style.f64425t;
            Paint paint = hVar.f64664d;
            SVG.Style.TextDecoration textDecoration = style.f64425t;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = hVar.f64664d;
            SVG.Style.TextDecoration textDecoration3 = style.f64425t;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                hVar.f64665e.setStrikeThruText(style.f64425t == textDecoration2);
                Paint paint3 = hVar.f64665e;
                if (style.f64425t == textDecoration4) {
                    z11 = true;
                }
                paint3.setUnderlineText(z11);
            }
        }
        if (d0(style, 68719476736L)) {
            hVar.f64661a.f64426u = style.f64426u;
        }
        if (d0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            hVar.f64661a.f64427v = style.f64427v;
        }
        if (d0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            hVar.f64661a.f64428w = style.f64428w;
        }
        if (d0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            hVar.f64661a.f64430y = style.f64430y;
        }
        if (d0(style, 4194304)) {
            hVar.f64661a.f64431z = style.f64431z;
        }
        if (d0(style, 8388608)) {
            hVar.f64661a.A = style.A;
        }
        if (d0(style, 16777216)) {
            hVar.f64661a.B = style.B;
        }
        if (d0(style, 33554432)) {
            hVar.f64661a.C = style.C;
        }
        if (d0(style, 1048576)) {
            hVar.f64661a.f64429x = style.f64429x;
        }
        if (d0(style, 268435456)) {
            hVar.f64661a.F = style.F;
        }
        if (d0(style, 536870912)) {
            hVar.f64661a.G = style.G;
        }
        if (d0(style, 1073741824)) {
            hVar.f64661a.H = style.H;
        }
        if (d0(style, 67108864)) {
            hVar.f64661a.D = style.D;
        }
        if (d0(style, 134217728)) {
            hVar.f64661a.E = style.E;
        }
        if (d0(style, 8589934592L)) {
            hVar.f64661a.K = style.K;
        }
        if (d0(style, 17179869184L)) {
            hVar.f64661a.L = style.L;
        }
        if (d0(style, 137438953472L)) {
            hVar.f64661a.N = style.N;
        }
    }

    public final void c1(h hVar, SVG.j0 j0Var) {
        hVar.f64661a.c(j0Var.f64509b == null);
        SVG.Style style = j0Var.f64499e;
        if (style != null) {
            b1(hVar, style);
        }
        if (this.f64624c.m()) {
            for (CSSParser.l next : this.f64624c.d()) {
                if (CSSParser.l(this.f64629h, next.f64371a, j0Var)) {
                    b1(hVar, next.f64372b);
                }
            }
        }
        SVG.Style style2 = j0Var.f64500f;
        if (style2 != null) {
            b1(hVar, style2);
        }
    }

    public final boolean d0(SVG.Style style, long j11) {
        return (style.f64407b & j11) != 0;
    }

    public final void d1() {
        int i11;
        SVG.Style style = this.f64625d.f64661a;
        SVG.m0 m0Var = style.K;
        if (m0Var instanceof SVG.f) {
            i11 = ((SVG.f) m0Var).f64474b;
        } else if (m0Var instanceof SVG.g) {
            i11 = style.f64420o.f64474b;
        } else {
            return;
        }
        Float f11 = style.L;
        if (f11 != null) {
            i11 = E(i11, f11.floatValue());
        }
        this.f64622a.drawColor(i11);
    }

    public final void e0(boolean z11, SVG.b bVar, SVG.k0 k0Var) {
        float f11;
        float f12;
        float f13;
        float f14;
        SVG.b bVar2 = bVar;
        SVG.k0 k0Var2 = k0Var;
        String str = k0Var2.f64496l;
        if (str != null) {
            O(k0Var2, str);
        }
        Boolean bool = k0Var2.f64493i;
        int i11 = 0;
        boolean z12 = bool != null && bool.booleanValue();
        h hVar = this.f64625d;
        Paint paint = z11 ? hVar.f64664d : hVar.f64665e;
        if (z12) {
            SVG.b Z = Z();
            SVG.o oVar = k0Var2.f64503m;
            float f15 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = k0Var2.f64504n;
            float g11 = oVar2 != null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = k0Var2.f64505o;
            float f16 = oVar3 != null ? oVar3.f(this) : Z.f64451c;
            SVG.o oVar4 = k0Var2.f64506p;
            f12 = f16;
            f14 = f15;
            f13 = g11;
            f11 = oVar4 != null ? oVar4.g(this) : 0.0f;
        } else {
            SVG.o oVar5 = k0Var2.f64503m;
            float e11 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
            SVG.o oVar6 = k0Var2.f64504n;
            float e12 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
            SVG.o oVar7 = k0Var2.f64505o;
            float e13 = oVar7 != null ? oVar7.e(this, 1.0f) : 1.0f;
            SVG.o oVar8 = k0Var2.f64506p;
            f14 = e11;
            f11 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
            f13 = e12;
            f12 = e13;
        }
        Y0();
        this.f64625d = T(k0Var2);
        Matrix matrix = new Matrix();
        if (!z12) {
            matrix.preTranslate(bVar2.f64449a, bVar2.f64450b);
            matrix.preScale(bVar2.f64451c, bVar2.f64452d);
        }
        Matrix matrix2 = k0Var2.f64494j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = k0Var2.f64492h.size();
        if (size == 0) {
            X0();
            if (z11) {
                this.f64625d.f64662b = false;
            } else {
                this.f64625d.f64663c = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f17 = -1.0f;
            Iterator<SVG.l0> it2 = k0Var2.f64492h.iterator();
            while (it2.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it2.next();
                Float f18 = c0Var.f64462h;
                float floatValue = f18 != null ? f18.floatValue() : 0.0f;
                if (i11 == 0 || floatValue >= f17) {
                    fArr[i11] = floatValue;
                    f17 = floatValue;
                } else {
                    fArr[i11] = f17;
                }
                Y0();
                c1(this.f64625d, c0Var);
                SVG.Style style = this.f64625d.f64661a;
                SVG.f fVar = (SVG.f) style.D;
                if (fVar == null) {
                    fVar = SVG.f.f64472c;
                }
                iArr[i11] = E(fVar.f64474b, style.E.floatValue());
                i11++;
                X0();
            }
            if ((f14 == f12 && f13 == f11) || size == 1) {
                X0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var2.f64495k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            X0();
            LinearGradient linearGradient = new LinearGradient(f14, f13, f12, f11, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            paint.setAlpha(B(this.f64625d.f64661a.f64410e.floatValue()));
        }
    }

    public final boolean e1() {
        Boolean bool = this.f64625d.f64661a.C;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final Path f0(SVG.d dVar) {
        SVG.d dVar2 = dVar;
        SVG.o oVar = dVar2.f64463o;
        float f11 = 0.0f;
        float f12 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = dVar2.f64464p;
        if (oVar2 != null) {
            f11 = oVar2.g(this);
        }
        float d11 = dVar2.f64465q.d(this);
        float f13 = f12 - d11;
        float f14 = f11 - d11;
        float f15 = f12 + d11;
        float f16 = f11 + d11;
        if (dVar2.f64491h == null) {
            float f17 = 2.0f * d11;
            dVar2.f64491h = new SVG.b(f13, f14, f17, f17);
        }
        float f18 = 0.5522848f * d11;
        Path path = new Path();
        path.moveTo(f12, f14);
        float f19 = f12 + f18;
        float f21 = f11 - f18;
        Path path2 = path;
        path2.cubicTo(f19, f14, f15, f21, f15, f11);
        float f22 = f11 + f18;
        path2.cubicTo(f15, f22, f19, f16, f12, f16);
        float f23 = f12 - f18;
        path2.cubicTo(f23, f16, f13, f22, f13, f11);
        path2.cubicTo(f13, f21, f23, f14, f12, f14);
        path.close();
        return path;
    }

    public final Path g0(SVG.i iVar) {
        SVG.i iVar2 = iVar;
        SVG.o oVar = iVar2.f64487o;
        float f11 = 0.0f;
        float f12 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = iVar2.f64488p;
        if (oVar2 != null) {
            f11 = oVar2.g(this);
        }
        float f13 = iVar2.f64489q.f(this);
        float g11 = iVar2.f64490r.g(this);
        float f14 = f12 - f13;
        float f15 = f11 - g11;
        float f16 = f12 + f13;
        float f17 = f11 + g11;
        if (iVar2.f64491h == null) {
            iVar2.f64491h = new SVG.b(f14, f15, f13 * 2.0f, 2.0f * g11);
        }
        float f18 = f13 * 0.5522848f;
        float f19 = 0.5522848f * g11;
        Path path = new Path();
        path.moveTo(f12, f15);
        float f21 = f12 + f18;
        float f22 = f11 - f19;
        Path path2 = path;
        path.cubicTo(f21, f15, f16, f22, f16, f11);
        float f23 = f19 + f11;
        Path path3 = path2;
        path3.cubicTo(f16, f23, f21, f17, f12, f17);
        float f24 = f12 - f18;
        path3.cubicTo(f24, f17, f14, f23, f14, f11);
        path3.cubicTo(f14, f22, f24, f15, f12, f15);
        path2.close();
        return path2;
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path path2;
        c1(this.f64625d, kVar);
        if (H() && e1()) {
            Matrix matrix2 = kVar.f64502n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (kVar instanceof SVG.a0) {
                path2 = j0((SVG.a0) kVar);
            } else if (kVar instanceof SVG.d) {
                path2 = f0((SVG.d) kVar);
            } else if (kVar instanceof SVG.i) {
                path2 = g0((SVG.i) kVar);
            } else if (kVar instanceof SVG.y) {
                path2 = i0((SVG.y) kVar);
            } else {
                return;
            }
            u(kVar);
            path.setFillType(W());
            path.addPath(path2, matrix);
        }
    }

    public final Path h0(SVG.p pVar) {
        SVG.o oVar = pVar.f64524o;
        float f11 = 0.0f;
        float f12 = oVar == null ? 0.0f : oVar.f(this);
        SVG.o oVar2 = pVar.f64525p;
        float g11 = oVar2 == null ? 0.0f : oVar2.g(this);
        SVG.o oVar3 = pVar.f64526q;
        float f13 = oVar3 == null ? 0.0f : oVar3.f(this);
        SVG.o oVar4 = pVar.f64527r;
        if (oVar4 != null) {
            f11 = oVar4.g(this);
        }
        if (pVar.f64491h == null) {
            pVar.f64491h = new SVG.b(Math.min(f12, f13), Math.min(g11, f11), Math.abs(f13 - f12), Math.abs(f11 - g11));
        }
        Path path = new Path();
        path.moveTo(f12, g11);
        path.lineTo(f13, f11);
        return path;
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        c1(this.f64625d, uVar);
        if (H() && e1()) {
            Matrix matrix2 = uVar.f64502n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path f11 = new d(uVar.f64546o).f();
            if (uVar.f64491h == null) {
                uVar.f64491h = r(f11);
            }
            u(uVar);
            path.setFillType(W());
            path.addPath(f11, matrix);
        }
    }

    public final Path i0(SVG.y yVar) {
        Path path = new Path();
        float[] fArr = yVar.f64564o;
        path.moveTo(fArr[0], fArr[1]);
        int i11 = 2;
        while (true) {
            float[] fArr2 = yVar.f64564o;
            if (i11 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i11], fArr2[i11 + 1]);
            i11 += 2;
        }
        if (yVar instanceof SVG.z) {
            path.close();
        }
        if (yVar.f64491h == null) {
            yVar.f64491h = r(path);
        }
        return path;
    }

    public final void j(SVG.l0 l0Var, boolean z11, Path path, Matrix matrix) {
        if (H()) {
            D();
            if (l0Var instanceof SVG.b1) {
                if (z11) {
                    l((SVG.b1) l0Var, path, matrix);
                } else {
                    M("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (l0Var instanceof SVG.u) {
                i((SVG.u) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.u0) {
                k((SVG.u0) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.k) {
                h((SVG.k) l0Var, path, matrix);
            } else {
                M("Invalid %s element found in clipPath definition", l0Var.getClass().getSimpleName());
            }
            C();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Path j0(com.caverock.androidsvg.SVG.a0 r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            com.caverock.androidsvg.SVG$o r2 = r1.f64445s
            r3 = 0
            if (r2 != 0) goto L_0x000f
            com.caverock.androidsvg.SVG$o r4 = r1.f64446t
            if (r4 != 0) goto L_0x000f
            r2 = r3
            goto L_0x0017
        L_0x000f:
            if (r2 != 0) goto L_0x0019
            com.caverock.androidsvg.SVG$o r2 = r1.f64446t
            float r2 = r2.g(r0)
        L_0x0017:
            r4 = r2
            goto L_0x002c
        L_0x0019:
            com.caverock.androidsvg.SVG$o r4 = r1.f64446t
            if (r4 != 0) goto L_0x0022
            float r2 = r2.f(r0)
            goto L_0x0017
        L_0x0022:
            float r2 = r2.f(r0)
            com.caverock.androidsvg.SVG$o r4 = r1.f64446t
            float r4 = r4.g(r0)
        L_0x002c:
            com.caverock.androidsvg.SVG$o r5 = r1.f64443q
            float r5 = r5.f(r0)
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r2 = java.lang.Math.min(r2, r5)
            com.caverock.androidsvg.SVG$o r5 = r1.f64444r
            float r5 = r5.g(r0)
            float r5 = r5 / r6
            float r4 = java.lang.Math.min(r4, r5)
            com.caverock.androidsvg.SVG$o r5 = r1.f64441o
            if (r5 == 0) goto L_0x004d
            float r5 = r5.f(r0)
            goto L_0x004e
        L_0x004d:
            r5 = r3
        L_0x004e:
            com.caverock.androidsvg.SVG$o r6 = r1.f64442p
            if (r6 == 0) goto L_0x0058
            float r6 = r6.g(r0)
            r13 = r6
            goto L_0x0059
        L_0x0058:
            r13 = r3
        L_0x0059:
            com.caverock.androidsvg.SVG$o r6 = r1.f64443q
            float r6 = r6.f(r0)
            com.caverock.androidsvg.SVG$o r7 = r1.f64444r
            float r7 = r7.g(r0)
            com.caverock.androidsvg.SVG$b r8 = r1.f64491h
            if (r8 != 0) goto L_0x0070
            com.caverock.androidsvg.SVG$b r8 = new com.caverock.androidsvg.SVG$b
            r8.<init>(r5, r13, r6, r7)
            r1.f64491h = r8
        L_0x0070:
            float r15 = r5 + r6
            float r1 = r13 + r7
            android.graphics.Path r14 = new android.graphics.Path
            r14.<init>()
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00dd
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0083
            goto L_0x00dd
        L_0x0083:
            r3 = 1057841801(0x3f0d6289, float:0.5522848)
            float r16 = r2 * r3
            float r3 = r3 * r4
            float r12 = r13 + r4
            r14.moveTo(r5, r12)
            float r17 = r12 - r3
            float r11 = r5 + r2
            float r21 = r11 - r16
            r6 = r14
            r7 = r5
            r8 = r17
            r9 = r21
            r10 = r13
            r24 = r11
            r22 = r12
            r12 = r13
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            float r2 = r15 - r2
            r14.lineTo(r2, r13)
            float r6 = r2 + r16
            r7 = r14
            r8 = r6
            r9 = r13
            r10 = r15
            r11 = r17
            r12 = r15
            r13 = r22
            r7.cubicTo(r8, r9, r10, r11, r12, r13)
            float r12 = r1 - r4
            r14.lineTo(r15, r12)
            float r10 = r12 + r3
            r3 = r14
            r16 = r10
            r17 = r6
            r18 = r1
            r19 = r2
            r20 = r1
            r14.cubicTo(r15, r16, r17, r18, r19, r20)
            r2 = r24
            r3.lineTo(r2, r1)
            r6 = r3
            r7 = r21
            r8 = r1
            r9 = r5
            r11 = r5
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            r3.lineTo(r5, r13)
            goto L_0x00ed
        L_0x00dd:
            r3 = r14
            r3.moveTo(r5, r13)
            r3.lineTo(r15, r13)
            r3.lineTo(r15, r1)
            r3.lineTo(r5, r1)
            r3.lineTo(r5, r13)
        L_0x00ed:
            r3.close()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.j0(com.caverock.androidsvg.SVG$a0):android.graphics.Path");
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        c1(this.f64625d, u0Var);
        if (H()) {
            Matrix matrix2 = u0Var.f64548s;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.o> list = u0Var.f64565o;
            float f11 = 0.0f;
            float f12 = (list == null || list.size() == 0) ? 0.0f : u0Var.f64565o.get(0).f(this);
            List<SVG.o> list2 = u0Var.f64566p;
            float g11 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.f64566p.get(0).g(this);
            List<SVG.o> list3 = u0Var.f64567q;
            float f13 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.f64567q.get(0).f(this);
            List<SVG.o> list4 = u0Var.f64568r;
            if (!(list4 == null || list4.size() == 0)) {
                f11 = u0Var.f64568r.get(0).g(this);
            }
            if (this.f64625d.f64661a.f64427v != SVG.Style.TextAnchor.Start) {
                float s11 = s(u0Var);
                if (this.f64625d.f64661a.f64427v == SVG.Style.TextAnchor.Middle) {
                    s11 /= 2.0f;
                }
                f12 -= s11;
            }
            if (u0Var.f64491h == null) {
                i iVar = new i(f12, g11);
                L(u0Var, iVar);
                RectF rectF = iVar.f64672d;
                u0Var.f64491h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f64672d.height());
            }
            u(u0Var);
            Path path2 = new Path();
            L(u0Var, new g(f12 + f13, g11 + f11, path2));
            path.setFillType(W());
            path.addPath(path2, matrix);
        }
    }

    public final Path k0(SVG.u0 u0Var) {
        List<SVG.o> list = u0Var.f64565o;
        float f11 = 0.0f;
        float f12 = (list == null || list.size() == 0) ? 0.0f : u0Var.f64565o.get(0).f(this);
        List<SVG.o> list2 = u0Var.f64566p;
        float g11 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.f64566p.get(0).g(this);
        List<SVG.o> list3 = u0Var.f64567q;
        float f13 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.f64567q.get(0).f(this);
        List<SVG.o> list4 = u0Var.f64568r;
        if (!(list4 == null || list4.size() == 0)) {
            f11 = u0Var.f64568r.get(0).g(this);
        }
        if (this.f64625d.f64661a.f64427v != SVG.Style.TextAnchor.Start) {
            float s11 = s(u0Var);
            if (this.f64625d.f64661a.f64427v == SVG.Style.TextAnchor.Middle) {
                s11 /= 2.0f;
            }
            f12 -= s11;
        }
        if (u0Var.f64491h == null) {
            i iVar = new i(f12, g11);
            L(u0Var, iVar);
            RectF rectF = iVar.f64672d;
            u0Var.f64491h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f64672d.height());
        }
        Path path = new Path();
        L(u0Var, new g(f12 + f13, g11 + f11, path));
        return path;
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        c1(this.f64625d, b1Var);
        if (H() && e1()) {
            Matrix matrix2 = b1Var.f64507o;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.l0 q11 = b1Var.f64508a.q(b1Var.f64453p);
            if (q11 == null) {
                M("Use reference '%s' not found", b1Var.f64453p);
                return;
            }
            u(b1Var);
            j(q11, false, path, matrix);
        }
    }

    public final void l0(boolean z11, SVG.b bVar, SVG.o0 o0Var) {
        float f11;
        float f12;
        float f13;
        SVG.b bVar2 = bVar;
        SVG.o0 o0Var2 = o0Var;
        String str = o0Var2.f64496l;
        if (str != null) {
            O(o0Var2, str);
        }
        Boolean bool = o0Var2.f64493i;
        int i11 = 0;
        boolean z12 = bool != null && bool.booleanValue();
        h hVar = this.f64625d;
        Paint paint = z11 ? hVar.f64664d : hVar.f64665e;
        if (z12) {
            SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
            SVG.o oVar2 = o0Var2.f64519m;
            float f14 = oVar2 != null ? oVar2.f(this) : oVar.f(this);
            SVG.o oVar3 = o0Var2.f64520n;
            float g11 = oVar3 != null ? oVar3.g(this) : oVar.g(this);
            SVG.o oVar4 = o0Var2.f64521o;
            f11 = oVar4 != null ? oVar4.d(this) : oVar.d(this);
            f13 = f14;
            f12 = g11;
        } else {
            SVG.o oVar5 = o0Var2.f64519m;
            float e11 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.5f;
            SVG.o oVar6 = o0Var2.f64520n;
            float e12 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.5f;
            SVG.o oVar7 = o0Var2.f64521o;
            f13 = e11;
            f11 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.5f;
            f12 = e12;
        }
        Y0();
        this.f64625d = T(o0Var2);
        Matrix matrix = new Matrix();
        if (!z12) {
            matrix.preTranslate(bVar2.f64449a, bVar2.f64450b);
            matrix.preScale(bVar2.f64451c, bVar2.f64452d);
        }
        Matrix matrix2 = o0Var2.f64494j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = o0Var2.f64492h.size();
        if (size == 0) {
            X0();
            if (z11) {
                this.f64625d.f64662b = false;
            } else {
                this.f64625d.f64663c = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f15 = -1.0f;
            Iterator<SVG.l0> it2 = o0Var2.f64492h.iterator();
            while (true) {
                float f16 = 0.0f;
                if (!it2.hasNext()) {
                    break;
                }
                SVG.c0 c0Var = (SVG.c0) it2.next();
                Float f17 = c0Var.f64462h;
                if (f17 != null) {
                    f16 = f17.floatValue();
                }
                if (i11 == 0 || f16 >= f15) {
                    fArr[i11] = f16;
                    f15 = f16;
                } else {
                    fArr[i11] = f15;
                }
                Y0();
                c1(this.f64625d, c0Var);
                SVG.Style style = this.f64625d.f64661a;
                SVG.f fVar = (SVG.f) style.D;
                if (fVar == null) {
                    fVar = SVG.f.f64472c;
                }
                iArr[i11] = E(fVar.f64474b, style.E.floatValue());
                i11++;
                X0();
            }
            if (f11 == 0.0f || size == 1) {
                X0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = o0Var2.f64495k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            X0();
            RadialGradient radialGradient = new RadialGradient(f13, f12, f11, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(B(this.f64625d.f64661a.f64410e.floatValue()));
        }
    }

    public final SVG.b m0(SVG.o oVar, SVG.o oVar2, SVG.o oVar3, SVG.o oVar4) {
        float f11 = 0.0f;
        float f12 = oVar != null ? oVar.f(this) : 0.0f;
        if (oVar2 != null) {
            f11 = oVar2.g(this);
        }
        SVG.b Z = Z();
        return new SVG.b(f12, f11, oVar3 != null ? oVar3.f(this) : Z.f64451c, oVar4 != null ? oVar4.g(this) : Z.f64452d);
    }

    @TargetApi(19)
    public final Path n0(SVG.i0 i0Var, boolean z11) {
        Path path;
        Path o11;
        this.f64626e.push(this.f64625d);
        h hVar = new h(this.f64625d);
        this.f64625d = hVar;
        c1(hVar, i0Var);
        if (!H() || !e1()) {
            this.f64625d = this.f64626e.pop();
            return null;
        }
        if (i0Var instanceof SVG.b1) {
            if (!z11) {
                M("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.b1 b1Var = (SVG.b1) i0Var;
            SVG.l0 q11 = i0Var.f64508a.q(b1Var.f64453p);
            if (q11 == null) {
                M("Use reference '%s' not found", b1Var.f64453p);
                this.f64625d = this.f64626e.pop();
                return null;
            } else if (!(q11 instanceof SVG.i0)) {
                this.f64625d = this.f64626e.pop();
                return null;
            } else {
                path = n0((SVG.i0) q11, false);
                if (path == null) {
                    return null;
                }
                if (b1Var.f64491h == null) {
                    b1Var.f64491h = r(path);
                }
                Matrix matrix = b1Var.f64507o;
                if (matrix != null) {
                    path.transform(matrix);
                }
            }
        } else if (i0Var instanceof SVG.k) {
            SVG.k kVar = (SVG.k) i0Var;
            if (i0Var instanceof SVG.u) {
                path = new d(((SVG.u) i0Var).f64546o).f();
                if (i0Var.f64491h == null) {
                    i0Var.f64491h = r(path);
                }
            } else {
                path = i0Var instanceof SVG.a0 ? j0((SVG.a0) i0Var) : i0Var instanceof SVG.d ? f0((SVG.d) i0Var) : i0Var instanceof SVG.i ? g0((SVG.i) i0Var) : i0Var instanceof SVG.y ? i0((SVG.y) i0Var) : null;
            }
            if (path == null) {
                return null;
            }
            if (kVar.f64491h == null) {
                kVar.f64491h = r(path);
            }
            Matrix matrix2 = kVar.f64502n;
            if (matrix2 != null) {
                path.transform(matrix2);
            }
            path.setFillType(W());
        } else if (i0Var instanceof SVG.u0) {
            SVG.u0 u0Var = (SVG.u0) i0Var;
            path = k0(u0Var);
            if (path == null) {
                return null;
            }
            Matrix matrix3 = u0Var.f64548s;
            if (matrix3 != null) {
                path.transform(matrix3);
            }
            path.setFillType(W());
        } else {
            M("Invalid %s element found in clipPath definition", i0Var.getClass().getSimpleName());
            return null;
        }
        if (!(this.f64625d.f64661a.F == null || (o11 = o(i0Var, i0Var.f64491h)) == null)) {
            path.op(o11, Path.Op.INTERSECT);
        }
        this.f64625d = this.f64626e.pop();
        return path;
    }

    @TargetApi(19)
    public final Path o(SVG.i0 i0Var, SVG.b bVar) {
        Path n02;
        SVG.l0 q11 = i0Var.f64508a.q(this.f64625d.f64661a.F);
        boolean z11 = false;
        if (q11 == null) {
            M("ClipPath reference '%s' not found", this.f64625d.f64661a.F);
            return null;
        }
        SVG.e eVar = (SVG.e) q11;
        this.f64626e.push(this.f64625d);
        this.f64625d = T(eVar);
        Boolean bool = eVar.f64471p;
        if (bool == null || bool.booleanValue()) {
            z11 = true;
        }
        Matrix matrix = new Matrix();
        if (!z11) {
            matrix.preTranslate(bVar.f64449a, bVar.f64450b);
            matrix.preScale(bVar.f64451c, bVar.f64452d);
        }
        Matrix matrix2 = eVar.f64507o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.l0 next : eVar.f64475i) {
            if ((next instanceof SVG.i0) && (n02 = n0((SVG.i0) next, true)) != null) {
                path.op(n02, Path.Op.UNION);
            }
        }
        if (this.f64625d.f64661a.F != null) {
            if (eVar.f64491h == null) {
                eVar.f64491h = r(path);
            }
            Path o11 = o(eVar, eVar.f64491h);
            if (o11 != null) {
                path.op(o11, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f64625d = this.f64626e.pop();
        return path;
    }

    public final void o0() {
        this.f64627f.pop();
        this.f64628g.pop();
    }

    public final List<C0708c> p(SVG.p pVar) {
        SVG.o oVar = pVar.f64524o;
        float f11 = 0.0f;
        float f12 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = pVar.f64525p;
        float g11 = oVar2 != null ? oVar2.g(this) : 0.0f;
        SVG.o oVar3 = pVar.f64526q;
        float f13 = oVar3 != null ? oVar3.f(this) : 0.0f;
        SVG.o oVar4 = pVar.f64527r;
        if (oVar4 != null) {
            f11 = oVar4.g(this);
        }
        float f14 = f11;
        ArrayList arrayList = new ArrayList(2);
        float f15 = f13 - f12;
        float f16 = f14 - g11;
        arrayList.add(new C0708c(f12, g11, f15, f16));
        arrayList.add(new C0708c(f13, f14, f15, f16));
        return arrayList;
    }

    public final void p0(SVG.h0 h0Var) {
        this.f64627f.push(h0Var);
        this.f64628g.push(this.f64622a.getMatrix());
    }

    public final List<C0708c> q(SVG.y yVar) {
        SVG.y yVar2 = yVar;
        int length = yVar2.f64564o.length;
        int i11 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = yVar2.f64564o;
        C0708c cVar = new C0708c(fArr[0], fArr[1], 0.0f, 0.0f);
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (i11 < length) {
            float[] fArr2 = yVar2.f64564o;
            float f13 = fArr2[i11];
            float f14 = fArr2[i11 + 1];
            cVar.a(f13, f14);
            arrayList.add(cVar);
            i11 += 2;
            cVar = new C0708c(f13, f14, f13 - cVar.f64642a, f14 - cVar.f64643b);
            float f15 = f13;
            f12 = f14;
            f11 = f15;
        }
        if (yVar2 instanceof SVG.z) {
            float[] fArr3 = yVar2.f64564o;
            if (!(f11 == fArr3[0] || f12 == fArr3[1])) {
                float f16 = fArr3[0];
                float f17 = fArr3[1];
                cVar.a(f16, f17);
                arrayList.add(cVar);
                C0708c cVar2 = new C0708c(f16, f17, f16 - cVar.f64642a, f17 - cVar.f64643b);
                cVar2.b((C0708c) arrayList.get(0));
                arrayList.add(cVar2);
                arrayList.set(0, cVar2);
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public final void q0(SVG.i0 i0Var) {
        if (this.f64625d.f64661a.H != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f64622a.saveLayer((RectF) null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.f64622a.saveLayer((RectF) null, paint2, 31);
            SVG.r rVar = (SVG.r) this.f64624c.q(this.f64625d.f64661a.H);
            P0(rVar, i0Var);
            this.f64622a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f64622a.saveLayer((RectF) null, paint3, 31);
            P0(rVar, i0Var);
            this.f64622a.restore();
            this.f64622a.restore();
        }
        X0();
    }

    public final SVG.b r(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public final void r0(SVG.l0 l0Var, j jVar) {
        float f11;
        float f12;
        float f13;
        SVG.Style.TextAnchor V;
        if (jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                Y0();
                R0((SVG.x0) l0Var);
                X0();
                return;
            }
            boolean z11 = true;
            if (l0Var instanceof SVG.t0) {
                F("TSpan render", new Object[0]);
                Y0();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                c1(this.f64625d, t0Var);
                if (H()) {
                    List<SVG.o> list = t0Var.f64565o;
                    if (list == null || list.size() <= 0) {
                        z11 = false;
                    }
                    boolean z12 = jVar instanceof f;
                    float f14 = 0.0f;
                    if (z12) {
                        float f15 = !z11 ? ((f) jVar).f64654b : t0Var.f64565o.get(0).f(this);
                        List<SVG.o> list2 = t0Var.f64566p;
                        f12 = (list2 == null || list2.size() == 0) ? ((f) jVar).f64655c : t0Var.f64566p.get(0).g(this);
                        List<SVG.o> list3 = t0Var.f64567q;
                        f11 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.f64567q.get(0).f(this);
                        List<SVG.o> list4 = t0Var.f64568r;
                        if (!(list4 == null || list4.size() == 0)) {
                            f14 = t0Var.f64568r.get(0).g(this);
                        }
                        f13 = f14;
                        f14 = f15;
                    } else {
                        f13 = 0.0f;
                        f12 = 0.0f;
                        f11 = 0.0f;
                    }
                    if (z11 && (V = V()) != SVG.Style.TextAnchor.Start) {
                        float s11 = s(t0Var);
                        if (V == SVG.Style.TextAnchor.Middle) {
                            s11 /= 2.0f;
                        }
                        f14 -= s11;
                    }
                    x((SVG.i0) t0Var.c());
                    if (z12) {
                        f fVar = (f) jVar;
                        fVar.f64654b = f14 + f11;
                        fVar.f64655c = f12 + f13;
                    }
                    boolean s02 = s0();
                    L(t0Var, jVar);
                    if (s02) {
                        q0(t0Var);
                    }
                }
                X0();
            } else if (l0Var instanceof SVG.s0) {
                Y0();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                c1(this.f64625d, s0Var);
                if (H()) {
                    x((SVG.i0) s0Var.c());
                    SVG.l0 q11 = l0Var.f64508a.q(s0Var.f64541o);
                    if (q11 == null || !(q11 instanceof SVG.w0)) {
                        M("Tref reference '%s' not found", s0Var.f64541o);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        N((SVG.w0) q11, sb2);
                        if (sb2.length() > 0) {
                            jVar.b(sb2.toString());
                        }
                    }
                }
                X0();
            }
        }
    }

    public final float s(SVG.w0 w0Var) {
        k kVar = new k(this, (a) null);
        L(w0Var, kVar);
        return kVar.f64675b;
    }

    public final boolean s0() {
        SVG.l0 q11;
        if (!S0()) {
            return false;
        }
        this.f64622a.saveLayerAlpha((RectF) null, B(this.f64625d.f64661a.f64419n.floatValue()), 31);
        this.f64626e.push(this.f64625d);
        h hVar = new h(this.f64625d);
        this.f64625d = hVar;
        String str = hVar.f64661a.H;
        if (str != null && ((q11 = this.f64624c.q(str)) == null || !(q11 instanceof SVG.r))) {
            M("Mask reference '%s' not found", this.f64625d.f64661a.H);
            this.f64625d.f64661a.H = null;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r3 = r3 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        if (r12 != 8) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Matrix t(com.caverock.androidsvg.SVG.b r10, com.caverock.androidsvg.SVG.b r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L_0x009b
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.a()
            if (r1 != 0) goto L_0x000f
            goto L_0x009b
        L_0x000f:
            float r1 = r10.f64451c
            float r2 = r11.f64451c
            float r1 = r1 / r2
            float r2 = r10.f64452d
            float r3 = r11.f64452d
            float r2 = r2 / r3
            float r3 = r11.f64449a
            float r3 = -r3
            float r4 = r11.f64450b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.f64383d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0035
            float r11 = r10.f64449a
            float r10 = r10.f64450b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L_0x0035:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L_0x0042
            float r1 = java.lang.Math.max(r1, r2)
            goto L_0x0046
        L_0x0042:
            float r1 = java.lang.Math.min(r1, r2)
        L_0x0046:
            float r2 = r10.f64451c
            float r2 = r2 / r1
            float r5 = r10.f64452d
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.c.a.f64630a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L_0x0062;
                case 2: goto L_0x0062;
                case 3: goto L_0x0062;
                case 4: goto L_0x005e;
                case 5: goto L_0x005e;
                case 6: goto L_0x005e;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x0067
        L_0x005e:
            float r7 = r11.f64451c
            float r7 = r7 - r2
            goto L_0x0066
        L_0x0062:
            float r7 = r11.f64451c
            float r7 = r7 - r2
            float r7 = r7 / r8
        L_0x0066:
            float r3 = r3 - r7
        L_0x0067:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L_0x0089
            r2 = 3
            if (r12 == r2) goto L_0x0085
            r2 = 5
            if (r12 == r2) goto L_0x0089
            r2 = 6
            if (r12 == r2) goto L_0x0085
            r2 = 7
            if (r12 == r2) goto L_0x0089
            r2 = 8
            if (r12 == r2) goto L_0x0085
            goto L_0x008e
        L_0x0085:
            float r11 = r11.f64452d
            float r11 = r11 - r5
            goto L_0x008d
        L_0x0089:
            float r11 = r11.f64452d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L_0x008d:
            float r4 = r4 - r11
        L_0x008e:
            float r11 = r10.f64449a
            float r10 = r10.f64450b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.t(com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    public final C0708c t0(C0708c cVar, C0708c cVar2, C0708c cVar3) {
        float K = K(cVar2.f64644c, cVar2.f64645d, cVar2.f64642a - cVar.f64642a, cVar2.f64643b - cVar.f64643b);
        if (K == 0.0f) {
            K = K(cVar2.f64644c, cVar2.f64645d, cVar3.f64642a - cVar2.f64642a, cVar3.f64643b - cVar2.f64643b);
        }
        int i11 = (K > 0.0f ? 1 : (K == 0.0f ? 0 : -1));
        if (i11 > 0) {
            return cVar2;
        }
        if (i11 == 0 && (cVar2.f64644c > 0.0f || cVar2.f64645d >= 0.0f)) {
            return cVar2;
        }
        cVar2.f64644c = -cVar2.f64644c;
        cVar2.f64645d = -cVar2.f64645d;
        return cVar2;
    }

    public final void u(SVG.i0 i0Var) {
        v(i0Var, i0Var.f64491h);
    }

    public final void u0(SVG.d dVar) {
        F("Circle render", new Object[0]);
        SVG.o oVar = dVar.f64465q;
        if (oVar != null && !oVar.i()) {
            c1(this.f64625d, dVar);
            if (H() && e1()) {
                Matrix matrix = dVar.f64502n;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                Path f02 = f0(dVar);
                a1(dVar);
                x(dVar);
                u(dVar);
                boolean s02 = s0();
                if (this.f64625d.f64662b) {
                    I(dVar, f02);
                }
                if (this.f64625d.f64663c) {
                    J(f02);
                }
                if (s02) {
                    q0(dVar);
                }
            }
        }
    }

    public final void v(SVG.i0 i0Var, SVG.b bVar) {
        if (this.f64625d.f64661a.F != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                Path o11 = o(i0Var, bVar);
                if (o11 != null) {
                    this.f64622a.clipPath(o11);
                    return;
                }
                return;
            }
            w(i0Var, bVar);
        }
    }

    public final void v0(SVG.i iVar) {
        F("Ellipse render", new Object[0]);
        SVG.o oVar = iVar.f64489q;
        if (oVar != null && iVar.f64490r != null && !oVar.i() && !iVar.f64490r.i()) {
            c1(this.f64625d, iVar);
            if (H() && e1()) {
                Matrix matrix = iVar.f64502n;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                Path g02 = g0(iVar);
                a1(iVar);
                x(iVar);
                u(iVar);
                boolean s02 = s0();
                if (this.f64625d.f64662b) {
                    I(iVar, g02);
                }
                if (this.f64625d.f64663c) {
                    J(g02);
                }
                if (s02) {
                    q0(iVar);
                }
            }
        }
    }

    public final void w(SVG.i0 i0Var, SVG.b bVar) {
        SVG.l0 q11 = i0Var.f64508a.q(this.f64625d.f64661a.F);
        if (q11 == null) {
            M("ClipPath reference '%s' not found", this.f64625d.f64661a.F);
            return;
        }
        SVG.e eVar = (SVG.e) q11;
        if (eVar.f64475i.isEmpty()) {
            this.f64622a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = eVar.f64471p;
        boolean z11 = bool == null || bool.booleanValue();
        if (!(i0Var instanceof SVG.l) || z11) {
            D();
            if (!z11) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(bVar.f64449a, bVar.f64450b);
                matrix.preScale(bVar.f64451c, bVar.f64452d);
                this.f64622a.concat(matrix);
            }
            Matrix matrix2 = eVar.f64507o;
            if (matrix2 != null) {
                this.f64622a.concat(matrix2);
            }
            this.f64625d = T(eVar);
            u(eVar);
            Path path = new Path();
            for (SVG.l0 j11 : eVar.f64475i) {
                j(j11, true, path, new Matrix());
            }
            this.f64622a.clipPath(path);
            C();
            return;
        }
        f1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.getClass().getSimpleName());
    }

    public final void w0(SVG.l lVar) {
        F("Group render", new Object[0]);
        c1(this.f64625d, lVar);
        if (H()) {
            Matrix matrix = lVar.f64507o;
            if (matrix != null) {
                this.f64622a.concat(matrix);
            }
            u(lVar);
            boolean s02 = s0();
            L0(lVar, true);
            if (s02) {
                q0(lVar);
            }
            a1(lVar);
        }
    }

    public final void x(SVG.i0 i0Var) {
        SVG.m0 m0Var = this.f64625d.f64661a.f64408c;
        if (m0Var instanceof SVG.t) {
            G(true, i0Var.f64491h, (SVG.t) m0Var);
        }
        SVG.m0 m0Var2 = this.f64625d.f64661a.f64411f;
        if (m0Var2 instanceof SVG.t) {
            G(false, i0Var.f64491h, (SVG.t) m0Var2);
        }
    }

    public final void x0(SVG.n nVar) {
        SVG.o oVar;
        String str;
        int i11 = 0;
        F("Image render", new Object[0]);
        SVG.o oVar2 = nVar.f64513s;
        if (oVar2 != null && !oVar2.i() && (oVar = nVar.f64514t) != null && !oVar.i() && (str = nVar.f64510p) != null) {
            PreserveAspectRatio preserveAspectRatio = nVar.f64516o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f64384e;
            }
            Bitmap y11 = y(str);
            if (y11 == null) {
                SVGExternalFileResolver g11 = SVG.g();
                if (g11 != null) {
                    y11 = g11.d(nVar.f64510p);
                } else {
                    return;
                }
            }
            if (y11 == null) {
                M("Could not locate image '%s'", nVar.f64510p);
                return;
            }
            SVG.b bVar = new SVG.b(0.0f, 0.0f, (float) y11.getWidth(), (float) y11.getHeight());
            c1(this.f64625d, nVar);
            if (H() && e1()) {
                Matrix matrix = nVar.f64515u;
                if (matrix != null) {
                    this.f64622a.concat(matrix);
                }
                SVG.o oVar3 = nVar.f64511q;
                float f11 = oVar3 != null ? oVar3.f(this) : 0.0f;
                SVG.o oVar4 = nVar.f64512r;
                this.f64625d.f64666f = new SVG.b(f11, oVar4 != null ? oVar4.g(this) : 0.0f, nVar.f64513s.f(this), nVar.f64514t.f(this));
                if (!this.f64625d.f64661a.f64428w.booleanValue()) {
                    SVG.b bVar2 = this.f64625d.f64666f;
                    U0(bVar2.f64449a, bVar2.f64450b, bVar2.f64451c, bVar2.f64452d);
                }
                nVar.f64491h = this.f64625d.f64666f;
                a1(nVar);
                u(nVar);
                boolean s02 = s0();
                d1();
                this.f64622a.save();
                this.f64622a.concat(t(this.f64625d.f64666f, bVar, preserveAspectRatio));
                if (this.f64625d.f64661a.N != SVG.Style.RenderQuality.optimizeSpeed) {
                    i11 = 2;
                }
                this.f64622a.drawBitmap(y11, 0.0f, 0.0f, new Paint(i11));
                this.f64622a.restore();
                if (s02) {
                    q0(nVar);
                }
            }
        }
    }

    public final Bitmap y(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) == -1 || indexOf < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public final void y0(SVG.p pVar) {
        F("Line render", new Object[0]);
        c1(this.f64625d, pVar);
        if (H() && e1() && this.f64625d.f64663c) {
            Matrix matrix = pVar.f64502n;
            if (matrix != null) {
                this.f64622a.concat(matrix);
            }
            Path h02 = h0(pVar);
            a1(pVar);
            x(pVar);
            u(pVar);
            boolean s02 = s0();
            J(h02);
            O0(pVar);
            if (s02) {
                q0(pVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r6.equals("monospace") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Typeface z(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.SVG.Style.FontStyle r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r0 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L_0x0008
            r8 = r1
            goto L_0x0009
        L_0x0008:
            r8 = r2
        L_0x0009:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L_0x0019
            if (r8 == 0) goto L_0x0017
            r7 = r3
            goto L_0x001e
        L_0x0017:
            r7 = r1
            goto L_0x001e
        L_0x0019:
            if (r8 == 0) goto L_0x001d
            r7 = r4
            goto L_0x001e
        L_0x001d:
            r7 = r2
        L_0x001e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L_0x0055;
                case -1431958525: goto L_0x004c;
                case -1081737434: goto L_0x0041;
                case 109326717: goto L_0x0036;
                case 1126973893: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r1 = r8
            goto L_0x005f
        L_0x002b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r1 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r1 = r3
            goto L_0x005f
        L_0x0041:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r1 = r4
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r1 = r2
        L_0x005f:
            switch(r1) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0079;
                case 2: goto L_0x0072;
                case 3: goto L_0x006b;
                case 4: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6 = 0
            goto L_0x0086
        L_0x0064:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x006b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0072:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0079:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0080:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L_0x0086:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.c.z(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    public final void z0(SVG.u uVar) {
        F("Path render", new Object[0]);
        if (uVar.f64546o != null) {
            c1(this.f64625d, uVar);
            if (H() && e1()) {
                h hVar = this.f64625d;
                if (hVar.f64663c || hVar.f64662b) {
                    Matrix matrix = uVar.f64502n;
                    if (matrix != null) {
                        this.f64622a.concat(matrix);
                    }
                    Path f11 = new d(uVar.f64546o).f();
                    if (uVar.f64491h == null) {
                        uVar.f64491h = r(f11);
                    }
                    a1(uVar);
                    x(uVar);
                    u(uVar);
                    boolean s02 = s0();
                    if (this.f64625d.f64662b) {
                        f11.setFillType(b0());
                        I(uVar, f11);
                    }
                    if (this.f64625d.f64663c) {
                        J(f11);
                    }
                    O0(uVar);
                    if (s02) {
                        q0(uVar);
                    }
                }
            }
        }
    }

    public class k extends j {

        /* renamed from: b  reason: collision with root package name */
        public float f64675b;

        public k() {
            super(c.this, (a) null);
            this.f64675b = 0.0f;
        }

        public void b(String str) {
            this.f64675b += c.this.f64625d.f64664d.measureText(str);
        }

        public /* synthetic */ k(c cVar, a aVar) {
            this();
        }
    }

    public class h {

        /* renamed from: a  reason: collision with root package name */
        public SVG.Style f64661a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64662b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64663c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f64664d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f64665e;

        /* renamed from: f  reason: collision with root package name */
        public SVG.b f64666f;

        /* renamed from: g  reason: collision with root package name */
        public SVG.b f64667g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f64668h;

        public h() {
            Paint paint = new Paint();
            this.f64664d = paint;
            paint.setFlags(385);
            this.f64664d.setStyle(Paint.Style.FILL);
            this.f64664d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f64665e = paint2;
            paint2.setFlags(385);
            this.f64665e.setStyle(Paint.Style.STROKE);
            this.f64665e.setTypeface(Typeface.DEFAULT);
            this.f64661a = SVG.Style.b();
        }

        public h(h hVar) {
            this.f64662b = hVar.f64662b;
            this.f64663c = hVar.f64663c;
            this.f64664d = new Paint(hVar.f64664d);
            this.f64665e = new Paint(hVar.f64665e);
            SVG.b bVar = hVar.f64666f;
            if (bVar != null) {
                this.f64666f = new SVG.b(bVar);
            }
            SVG.b bVar2 = hVar.f64667g;
            if (bVar2 != null) {
                this.f64667g = new SVG.b(bVar2);
            }
            this.f64668h = hVar.f64668h;
            try {
                this.f64661a = (SVG.Style) hVar.f64661a.clone();
            } catch (CloneNotSupportedException e11) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e11);
                this.f64661a = SVG.Style.b();
            }
        }
    }
}
