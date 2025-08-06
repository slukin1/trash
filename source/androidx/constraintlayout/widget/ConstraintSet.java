package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f7986h = {0, 4, 8};

    /* renamed from: i  reason: collision with root package name */
    public static SparseIntArray f7987i = new SparseIntArray();

    /* renamed from: j  reason: collision with root package name */
    public static SparseIntArray f7988j = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7989a;

    /* renamed from: b  reason: collision with root package name */
    public String f7990b;

    /* renamed from: c  reason: collision with root package name */
    public String f7991c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f7992d = 0;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f7993e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f7994f = true;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Integer, Constraint> f7995g = new HashMap<>();

    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        public int f7996a;

        /* renamed from: b  reason: collision with root package name */
        public String f7997b;

        /* renamed from: c  reason: collision with root package name */
        public final PropertySet f7998c = new PropertySet();

        /* renamed from: d  reason: collision with root package name */
        public final Motion f7999d = new Motion();

        /* renamed from: e  reason: collision with root package name */
        public final Layout f8000e = new Layout();

        /* renamed from: f  reason: collision with root package name */
        public final Transform f8001f = new Transform();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f8002g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public a f8003h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int[] f8004a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            public int[] f8005b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            public int f8006c = 0;

            /* renamed from: d  reason: collision with root package name */
            public int[] f8007d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            public float[] f8008e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            public int f8009f = 0;

            /* renamed from: g  reason: collision with root package name */
            public int[] f8010g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            public String[] f8011h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            public int f8012i = 0;

            /* renamed from: j  reason: collision with root package name */
            public int[] f8013j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            public boolean[] f8014k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            public int f8015l = 0;

            public void a(int i11, float f11) {
                int i12 = this.f8009f;
                int[] iArr = this.f8007d;
                if (i12 >= iArr.length) {
                    this.f8007d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f8008e;
                    this.f8008e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f8007d;
                int i13 = this.f8009f;
                iArr2[i13] = i11;
                float[] fArr2 = this.f8008e;
                this.f8009f = i13 + 1;
                fArr2[i13] = f11;
            }

            public void b(int i11, int i12) {
                int i13 = this.f8006c;
                int[] iArr = this.f8004a;
                if (i13 >= iArr.length) {
                    this.f8004a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f8005b;
                    this.f8005b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f8004a;
                int i14 = this.f8006c;
                iArr3[i14] = i11;
                int[] iArr4 = this.f8005b;
                this.f8006c = i14 + 1;
                iArr4[i14] = i12;
            }

            public void c(int i11, String str) {
                int i12 = this.f8012i;
                int[] iArr = this.f8010g;
                if (i12 >= iArr.length) {
                    this.f8010g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f8011h;
                    this.f8011h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f8010g;
                int i13 = this.f8012i;
                iArr2[i13] = i11;
                String[] strArr2 = this.f8011h;
                this.f8012i = i13 + 1;
                strArr2[i13] = str;
            }

            public void d(int i11, boolean z11) {
                int i12 = this.f8015l;
                int[] iArr = this.f8013j;
                if (i12 >= iArr.length) {
                    this.f8013j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f8014k;
                    this.f8014k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f8013j;
                int i13 = this.f8015l;
                iArr2[i13] = i11;
                boolean[] zArr2 = this.f8014k;
                this.f8015l = i13 + 1;
                zArr2[i13] = z11;
            }

            public void e(Constraint constraint) {
                for (int i11 = 0; i11 < this.f8006c; i11++) {
                    ConstraintSet.O(constraint, this.f8004a[i11], this.f8005b[i11]);
                }
                for (int i12 = 0; i12 < this.f8009f; i12++) {
                    ConstraintSet.N(constraint, this.f8007d[i12], this.f8008e[i12]);
                }
                for (int i13 = 0; i13 < this.f8012i; i13++) {
                    ConstraintSet.P(constraint, this.f8010g[i13], this.f8011h[i13]);
                }
                for (int i14 = 0; i14 < this.f8015l; i14++) {
                    ConstraintSet.Q(constraint, this.f8013j[i14], this.f8014k[i14]);
                }
            }
        }

        public void d(Constraint constraint) {
            a aVar = this.f8003h;
            if (aVar != null) {
                aVar.e(constraint);
            }
        }

        public void e(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.f8000e;
            layoutParams.f7934d = layout.f8033i;
            layoutParams.f7936e = layout.f8035j;
            layoutParams.f7938f = layout.f8037k;
            layoutParams.f7940g = layout.f8039l;
            layoutParams.f7942h = layout.f8041m;
            layoutParams.f7944i = layout.f8043n;
            layoutParams.f7946j = layout.f8045o;
            layoutParams.f7948k = layout.f8047p;
            layoutParams.f7950l = layout.f8049q;
            layoutParams.f7952m = layout.f8050r;
            layoutParams.f7954n = layout.f8051s;
            layoutParams.f7962r = layout.f8052t;
            layoutParams.f7964s = layout.f8053u;
            layoutParams.f7966t = layout.f8054v;
            layoutParams.f7968u = layout.f8055w;
            layoutParams.leftMargin = layout.G;
            layoutParams.rightMargin = layout.H;
            layoutParams.topMargin = layout.I;
            layoutParams.bottomMargin = layout.J;
            layoutParams.f7975z = layout.S;
            layoutParams.A = layout.R;
            layoutParams.f7972w = layout.O;
            layoutParams.f7974y = layout.Q;
            layoutParams.F = layout.f8056x;
            layoutParams.G = layout.f8057y;
            layoutParams.f7956o = layout.A;
            layoutParams.f7958p = layout.B;
            layoutParams.f7960q = layout.C;
            layoutParams.H = layout.f8058z;
            layoutParams.W = layout.D;
            layoutParams.X = layout.E;
            layoutParams.L = layout.U;
            layoutParams.K = layout.V;
            layoutParams.N = layout.X;
            layoutParams.M = layout.W;
            layoutParams.Z = layout.f8042m0;
            layoutParams.f7929a0 = layout.f8044n0;
            layoutParams.O = layout.Y;
            layoutParams.P = layout.Z;
            layoutParams.S = layout.f8018a0;
            layoutParams.T = layout.f8020b0;
            layoutParams.Q = layout.f8022c0;
            layoutParams.R = layout.f8024d0;
            layoutParams.U = layout.f8026e0;
            layoutParams.V = layout.f8028f0;
            layoutParams.Y = layout.F;
            layoutParams.f7932c = layout.f8031h;
            layoutParams.f7928a = layout.f8027f;
            layoutParams.f7930b = layout.f8029g;
            layoutParams.width = layout.f8023d;
            layoutParams.height = layout.f8025e;
            String str = layout.f8040l0;
            if (str != null) {
                layoutParams.f7931b0 = str;
            }
            layoutParams.f7933c0 = layout.f8048p0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layout.L);
                layoutParams.setMarginEnd(this.f8000e.K);
            }
            layoutParams.c();
        }

        /* renamed from: f */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f8000e.a(this.f8000e);
            constraint.f7999d.a(this.f7999d);
            constraint.f7998c.a(this.f7998c);
            constraint.f8001f.a(this.f8001f);
            constraint.f7996a = this.f7996a;
            constraint.f8003h = this.f8003h;
            return constraint;
        }

        public final void g(int i11, ConstraintLayout.LayoutParams layoutParams) {
            this.f7996a = i11;
            Layout layout = this.f8000e;
            layout.f8033i = layoutParams.f7934d;
            layout.f8035j = layoutParams.f7936e;
            layout.f8037k = layoutParams.f7938f;
            layout.f8039l = layoutParams.f7940g;
            layout.f8041m = layoutParams.f7942h;
            layout.f8043n = layoutParams.f7944i;
            layout.f8045o = layoutParams.f7946j;
            layout.f8047p = layoutParams.f7948k;
            layout.f8049q = layoutParams.f7950l;
            layout.f8050r = layoutParams.f7952m;
            layout.f8051s = layoutParams.f7954n;
            layout.f8052t = layoutParams.f7962r;
            layout.f8053u = layoutParams.f7964s;
            layout.f8054v = layoutParams.f7966t;
            layout.f8055w = layoutParams.f7968u;
            layout.f8056x = layoutParams.F;
            layout.f8057y = layoutParams.G;
            layout.f8058z = layoutParams.H;
            layout.A = layoutParams.f7956o;
            layout.B = layoutParams.f7958p;
            layout.C = layoutParams.f7960q;
            layout.D = layoutParams.W;
            layout.E = layoutParams.X;
            layout.F = layoutParams.Y;
            layout.f8031h = layoutParams.f7932c;
            layout.f8027f = layoutParams.f7928a;
            layout.f8029g = layoutParams.f7930b;
            layout.f8023d = layoutParams.width;
            layout.f8025e = layoutParams.height;
            layout.G = layoutParams.leftMargin;
            layout.H = layoutParams.rightMargin;
            layout.I = layoutParams.topMargin;
            layout.J = layoutParams.bottomMargin;
            layout.M = layoutParams.C;
            layout.U = layoutParams.L;
            layout.V = layoutParams.K;
            layout.X = layoutParams.N;
            layout.W = layoutParams.M;
            layout.f8042m0 = layoutParams.Z;
            layout.f8044n0 = layoutParams.f7929a0;
            layout.Y = layoutParams.O;
            layout.Z = layoutParams.P;
            layout.f8018a0 = layoutParams.S;
            layout.f8020b0 = layoutParams.T;
            layout.f8022c0 = layoutParams.Q;
            layout.f8024d0 = layoutParams.R;
            layout.f8026e0 = layoutParams.U;
            layout.f8028f0 = layoutParams.V;
            layout.f8040l0 = layoutParams.f7931b0;
            layout.O = layoutParams.f7972w;
            layout.Q = layoutParams.f7974y;
            layout.N = layoutParams.f7970v;
            layout.P = layoutParams.f7973x;
            layout.S = layoutParams.f7975z;
            layout.R = layoutParams.A;
            layout.T = layoutParams.B;
            layout.f8048p0 = layoutParams.f7933c0;
            if (Build.VERSION.SDK_INT >= 17) {
                layout.K = layoutParams.getMarginEnd();
                this.f8000e.L = layoutParams.getMarginStart();
            }
        }

        public final void h(int i11, Constraints.LayoutParams layoutParams) {
            g(i11, layoutParams);
            this.f7998c.f8077d = layoutParams.f8095w0;
            Transform transform = this.f8001f;
            transform.f8081b = layoutParams.f8098z0;
            transform.f8082c = layoutParams.A0;
            transform.f8083d = layoutParams.B0;
            transform.f8084e = layoutParams.C0;
            transform.f8085f = layoutParams.D0;
            transform.f8086g = layoutParams.E0;
            transform.f8087h = layoutParams.F0;
            transform.f8089j = layoutParams.G0;
            transform.f8090k = layoutParams.H0;
            transform.f8091l = layoutParams.I0;
            transform.f8093n = layoutParams.f8097y0;
            transform.f8092m = layoutParams.f8096x0;
        }

        public final void i(ConstraintHelper constraintHelper, int i11, Constraints.LayoutParams layoutParams) {
            h(i11, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.f8000e;
                layout.f8034i0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.f8030g0 = barrier.getType();
                this.f8000e.f8036j0 = barrier.getReferencedIds();
                this.f8000e.f8032h0 = barrier.getMargin();
            }
        }
    }

    public static class Layout {

        /* renamed from: q0  reason: collision with root package name */
        public static SparseIntArray f8016q0;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8017a = false;

        /* renamed from: a0  reason: collision with root package name */
        public int f8018a0 = -1;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8019b = false;

        /* renamed from: b0  reason: collision with root package name */
        public int f8020b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8021c = false;

        /* renamed from: c0  reason: collision with root package name */
        public int f8022c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f8023d;

        /* renamed from: d0  reason: collision with root package name */
        public int f8024d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f8025e;

        /* renamed from: e0  reason: collision with root package name */
        public float f8026e0 = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f8027f = -1;

        /* renamed from: f0  reason: collision with root package name */
        public float f8028f0 = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public int f8029g = -1;

        /* renamed from: g0  reason: collision with root package name */
        public int f8030g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f8031h = -1.0f;

        /* renamed from: h0  reason: collision with root package name */
        public int f8032h0 = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f8033i = -1;

        /* renamed from: i0  reason: collision with root package name */
        public int f8034i0 = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f8035j = -1;

        /* renamed from: j0  reason: collision with root package name */
        public int[] f8036j0;

        /* renamed from: k  reason: collision with root package name */
        public int f8037k = -1;

        /* renamed from: k0  reason: collision with root package name */
        public String f8038k0;

        /* renamed from: l  reason: collision with root package name */
        public int f8039l = -1;

        /* renamed from: l0  reason: collision with root package name */
        public String f8040l0;

        /* renamed from: m  reason: collision with root package name */
        public int f8041m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public boolean f8042m0 = false;

        /* renamed from: n  reason: collision with root package name */
        public int f8043n = -1;

        /* renamed from: n0  reason: collision with root package name */
        public boolean f8044n0 = false;

        /* renamed from: o  reason: collision with root package name */
        public int f8045o = -1;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f8046o0 = true;

        /* renamed from: p  reason: collision with root package name */
        public int f8047p = -1;

        /* renamed from: p0  reason: collision with root package name */
        public int f8048p0 = 0;

        /* renamed from: q  reason: collision with root package name */
        public int f8049q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f8050r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f8051s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f8052t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f8053u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f8054v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f8055w = -1;

        /* renamed from: x  reason: collision with root package name */
        public float f8056x = 0.5f;

        /* renamed from: y  reason: collision with root package name */
        public float f8057y = 0.5f;

        /* renamed from: z  reason: collision with root package name */
        public String f8058z = null;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8016q0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f8016q0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f8016q0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f8016q0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f8016q0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f8016q0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f8016q0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f8016q0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f8016q0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f8016q0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f8016q0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f8016q0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f8016q0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f8016q0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            f8016q0.append(R$styleable.Layout_android_orientation, 26);
            f8016q0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f8016q0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f8016q0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f8016q0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f8016q0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f8016q0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f8016q0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f8016q0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f8016q0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f8016q0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f8016q0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f8016q0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f8016q0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f8016q0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f8016q0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f8016q0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f8016q0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f8016q0.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
            f8016q0.append(R$styleable.Layout_layout_constraintTop_creator, 76);
            f8016q0.append(R$styleable.Layout_layout_constraintRight_creator, 76);
            f8016q0.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
            f8016q0.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
            f8016q0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f8016q0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f8016q0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f8016q0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f8016q0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f8016q0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f8016q0.append(R$styleable.Layout_android_layout_width, 22);
            f8016q0.append(R$styleable.Layout_android_layout_height, 21);
            f8016q0.append(R$styleable.Layout_layout_constraintWidth, 41);
            f8016q0.append(R$styleable.Layout_layout_constraintHeight, 42);
            f8016q0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            f8016q0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            f8016q0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 97);
            f8016q0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f8016q0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f8016q0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f8016q0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f8016q0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f8016q0.append(R$styleable.Layout_chainUseRtl, 71);
            f8016q0.append(R$styleable.Layout_barrierDirection, 72);
            f8016q0.append(R$styleable.Layout_barrierMargin, 73);
            f8016q0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f8016q0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Layout layout) {
            this.f8017a = layout.f8017a;
            this.f8023d = layout.f8023d;
            this.f8019b = layout.f8019b;
            this.f8025e = layout.f8025e;
            this.f8027f = layout.f8027f;
            this.f8029g = layout.f8029g;
            this.f8031h = layout.f8031h;
            this.f8033i = layout.f8033i;
            this.f8035j = layout.f8035j;
            this.f8037k = layout.f8037k;
            this.f8039l = layout.f8039l;
            this.f8041m = layout.f8041m;
            this.f8043n = layout.f8043n;
            this.f8045o = layout.f8045o;
            this.f8047p = layout.f8047p;
            this.f8049q = layout.f8049q;
            this.f8050r = layout.f8050r;
            this.f8051s = layout.f8051s;
            this.f8052t = layout.f8052t;
            this.f8053u = layout.f8053u;
            this.f8054v = layout.f8054v;
            this.f8055w = layout.f8055w;
            this.f8056x = layout.f8056x;
            this.f8057y = layout.f8057y;
            this.f8058z = layout.f8058z;
            this.A = layout.A;
            this.B = layout.B;
            this.C = layout.C;
            this.D = layout.D;
            this.E = layout.E;
            this.F = layout.F;
            this.G = layout.G;
            this.H = layout.H;
            this.I = layout.I;
            this.J = layout.J;
            this.K = layout.K;
            this.L = layout.L;
            this.M = layout.M;
            this.N = layout.N;
            this.O = layout.O;
            this.P = layout.P;
            this.Q = layout.Q;
            this.R = layout.R;
            this.S = layout.S;
            this.T = layout.T;
            this.U = layout.U;
            this.V = layout.V;
            this.W = layout.W;
            this.X = layout.X;
            this.Y = layout.Y;
            this.Z = layout.Z;
            this.f8018a0 = layout.f8018a0;
            this.f8020b0 = layout.f8020b0;
            this.f8022c0 = layout.f8022c0;
            this.f8024d0 = layout.f8024d0;
            this.f8026e0 = layout.f8026e0;
            this.f8028f0 = layout.f8028f0;
            this.f8030g0 = layout.f8030g0;
            this.f8032h0 = layout.f8032h0;
            this.f8034i0 = layout.f8034i0;
            this.f8040l0 = layout.f8040l0;
            int[] iArr = layout.f8036j0;
            if (iArr != null) {
                this.f8036j0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f8036j0 = null;
            }
            this.f8038k0 = layout.f8038k0;
            this.f8042m0 = layout.f8042m0;
            this.f8044n0 = layout.f8044n0;
            this.f8046o0 = layout.f8046o0;
            this.f8048p0 = layout.f8048p0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.f8019b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = f8016q0.get(index);
                if (i12 == 80) {
                    this.f8042m0 = obtainStyledAttributes.getBoolean(index, this.f8042m0);
                } else if (i12 == 81) {
                    this.f8044n0 = obtainStyledAttributes.getBoolean(index, this.f8044n0);
                } else if (i12 != 97) {
                    switch (i12) {
                        case 1:
                            this.f8049q = ConstraintSet.F(obtainStyledAttributes, index, this.f8049q);
                            break;
                        case 2:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 3:
                            this.f8047p = ConstraintSet.F(obtainStyledAttributes, index, this.f8047p);
                            break;
                        case 4:
                            this.f8045o = ConstraintSet.F(obtainStyledAttributes, index, this.f8045o);
                            break;
                        case 5:
                            this.f8058z = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                            break;
                        case 7:
                            this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                            break;
                        case 8:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                                break;
                            }
                        case 9:
                            this.f8055w = ConstraintSet.F(obtainStyledAttributes, index, this.f8055w);
                            break;
                        case 10:
                            this.f8054v = ConstraintSet.F(obtainStyledAttributes, index, this.f8054v);
                            break;
                        case 11:
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        case 12:
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        case 13:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 14:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        case 15:
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        case 16:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 17:
                            this.f8027f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8027f);
                            break;
                        case 18:
                            this.f8029g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8029g);
                            break;
                        case 19:
                            this.f8031h = obtainStyledAttributes.getFloat(index, this.f8031h);
                            break;
                        case 20:
                            this.f8056x = obtainStyledAttributes.getFloat(index, this.f8056x);
                            break;
                        case 21:
                            this.f8025e = obtainStyledAttributes.getLayoutDimension(index, this.f8025e);
                            break;
                        case 22:
                            this.f8023d = obtainStyledAttributes.getLayoutDimension(index, this.f8023d);
                            break;
                        case 23:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 24:
                            this.f8033i = ConstraintSet.F(obtainStyledAttributes, index, this.f8033i);
                            break;
                        case 25:
                            this.f8035j = ConstraintSet.F(obtainStyledAttributes, index, this.f8035j);
                            break;
                        case 26:
                            this.F = obtainStyledAttributes.getInt(index, this.F);
                            break;
                        case 27:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            break;
                        case 28:
                            this.f8037k = ConstraintSet.F(obtainStyledAttributes, index, this.f8037k);
                            break;
                        case 29:
                            this.f8039l = ConstraintSet.F(obtainStyledAttributes, index, this.f8039l);
                            break;
                        case 30:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                break;
                            }
                        case 31:
                            this.f8052t = ConstraintSet.F(obtainStyledAttributes, index, this.f8052t);
                            break;
                        case 32:
                            this.f8053u = ConstraintSet.F(obtainStyledAttributes, index, this.f8053u);
                            break;
                        case 33:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            break;
                        case 34:
                            this.f8043n = ConstraintSet.F(obtainStyledAttributes, index, this.f8043n);
                            break;
                        case 35:
                            this.f8041m = ConstraintSet.F(obtainStyledAttributes, index, this.f8041m);
                            break;
                        case 36:
                            this.f8057y = obtainStyledAttributes.getFloat(index, this.f8057y);
                            break;
                        case 37:
                            this.V = obtainStyledAttributes.getFloat(index, this.V);
                            break;
                        case 38:
                            this.U = obtainStyledAttributes.getFloat(index, this.U);
                            break;
                        case 39:
                            this.W = obtainStyledAttributes.getInt(index, this.W);
                            break;
                        case 40:
                            this.X = obtainStyledAttributes.getInt(index, this.X);
                            break;
                        case 41:
                            ConstraintSet.G(this, obtainStyledAttributes, index, 0);
                            break;
                        case 42:
                            ConstraintSet.G(this, obtainStyledAttributes, index, 1);
                            break;
                        default:
                            switch (i12) {
                                case 54:
                                    this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                    break;
                                case 55:
                                    this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                    break;
                                case 56:
                                    this.f8018a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8018a0);
                                    break;
                                case 57:
                                    this.f8020b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8020b0);
                                    break;
                                case 58:
                                    this.f8022c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8022c0);
                                    break;
                                case 59:
                                    this.f8024d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8024d0);
                                    break;
                                default:
                                    switch (i12) {
                                        case 61:
                                            this.A = ConstraintSet.F(obtainStyledAttributes, index, this.A);
                                            break;
                                        case 62:
                                            this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                            break;
                                        case 63:
                                            this.C = obtainStyledAttributes.getFloat(index, this.C);
                                            break;
                                        default:
                                            switch (i12) {
                                                case 69:
                                                    this.f8026e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f8028f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f8030g0 = obtainStyledAttributes.getInt(index, this.f8030g0);
                                                    break;
                                                case 73:
                                                    this.f8032h0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8032h0);
                                                    break;
                                                case 74:
                                                    this.f8038k0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f8046o0 = obtainStyledAttributes.getBoolean(index, this.f8046o0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8016q0.get(index));
                                                    break;
                                                case 77:
                                                    this.f8040l0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    switch (i12) {
                                                        case 91:
                                                            this.f8050r = ConstraintSet.F(obtainStyledAttributes, index, this.f8050r);
                                                            break;
                                                        case 92:
                                                            this.f8051s = ConstraintSet.F(obtainStyledAttributes, index, this.f8051s);
                                                            break;
                                                        case 93:
                                                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                                                            break;
                                                        case 94:
                                                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                                            break;
                                                        default:
                                                            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8016q0.get(index));
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.f8048p0 = obtainStyledAttributes.getInt(index, this.f8048p0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {

        /* renamed from: o  reason: collision with root package name */
        public static SparseIntArray f8059o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8060a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f8061b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f8062c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f8063d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f8064e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f8065f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f8066g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f8067h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f8068i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f8069j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f8070k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f8071l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f8072m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f8073n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8059o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f8059o.append(R$styleable.Motion_pathMotionArc, 2);
            f8059o.append(R$styleable.Motion_transitionEasing, 3);
            f8059o.append(R$styleable.Motion_drawPath, 4);
            f8059o.append(R$styleable.Motion_animateRelativeTo, 5);
            f8059o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f8059o.append(R$styleable.Motion_motionStagger, 7);
            f8059o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f8059o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f8059o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(Motion motion) {
            this.f8060a = motion.f8060a;
            this.f8061b = motion.f8061b;
            this.f8063d = motion.f8063d;
            this.f8064e = motion.f8064e;
            this.f8065f = motion.f8065f;
            this.f8068i = motion.f8068i;
            this.f8066g = motion.f8066g;
            this.f8067h = motion.f8067h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.f8060a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (f8059o.get(index)) {
                    case 1:
                        this.f8068i = obtainStyledAttributes.getFloat(index, this.f8068i);
                        break;
                    case 2:
                        this.f8064e = obtainStyledAttributes.getInt(index, this.f8064e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.f8063d = Easing.f6847c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.f8063d = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.f8065f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f8061b = ConstraintSet.F(obtainStyledAttributes, index, this.f8061b);
                        break;
                    case 6:
                        this.f8062c = obtainStyledAttributes.getInteger(index, this.f8062c);
                        break;
                    case 7:
                        this.f8066g = obtainStyledAttributes.getFloat(index, this.f8066g);
                        break;
                    case 8:
                        this.f8070k = obtainStyledAttributes.getInteger(index, this.f8070k);
                        break;
                    case 9:
                        this.f8069j = obtainStyledAttributes.getFloat(index, this.f8069j);
                        break;
                    case 10:
                        int i12 = obtainStyledAttributes.peekValue(index).type;
                        if (i12 != 1) {
                            if (i12 != 3) {
                                this.f8072m = obtainStyledAttributes.getInteger(index, this.f8073n);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.f8071l = string;
                                if (string.indexOf("/") <= 0) {
                                    this.f8072m = -1;
                                    break;
                                } else {
                                    this.f8073n = obtainStyledAttributes.getResourceId(index, -1);
                                    this.f8072m = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f8073n = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.f8072m = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8074a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f8075b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f8076c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f8077d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f8078e = Float.NaN;

        public void a(PropertySet propertySet) {
            this.f8074a = propertySet.f8074a;
            this.f8075b = propertySet.f8075b;
            this.f8077d = propertySet.f8077d;
            this.f8078e = propertySet.f8078e;
            this.f8076c = propertySet.f8076c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.f8074a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f8077d = obtainStyledAttributes.getFloat(index, this.f8077d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.f8075b = obtainStyledAttributes.getInt(index, this.f8075b);
                    this.f8075b = ConstraintSet.f7986h[this.f8075b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.f8076c = obtainStyledAttributes.getInt(index, this.f8076c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f8078e = obtainStyledAttributes.getFloat(index, this.f8078e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {

        /* renamed from: o  reason: collision with root package name */
        public static SparseIntArray f8079o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8080a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f8081b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f8082c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f8083d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f8084e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f8085f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f8086g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f8087h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f8088i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f8089j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f8090k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f8091l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f8092m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f8093n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8079o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            f8079o.append(R$styleable.Transform_android_rotationX, 2);
            f8079o.append(R$styleable.Transform_android_rotationY, 3);
            f8079o.append(R$styleable.Transform_android_scaleX, 4);
            f8079o.append(R$styleable.Transform_android_scaleY, 5);
            f8079o.append(R$styleable.Transform_android_transformPivotX, 6);
            f8079o.append(R$styleable.Transform_android_transformPivotY, 7);
            f8079o.append(R$styleable.Transform_android_translationX, 8);
            f8079o.append(R$styleable.Transform_android_translationY, 9);
            f8079o.append(R$styleable.Transform_android_translationZ, 10);
            f8079o.append(R$styleable.Transform_android_elevation, 11);
            f8079o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(Transform transform) {
            this.f8080a = transform.f8080a;
            this.f8081b = transform.f8081b;
            this.f8082c = transform.f8082c;
            this.f8083d = transform.f8083d;
            this.f8084e = transform.f8084e;
            this.f8085f = transform.f8085f;
            this.f8086g = transform.f8086g;
            this.f8087h = transform.f8087h;
            this.f8088i = transform.f8088i;
            this.f8089j = transform.f8089j;
            this.f8090k = transform.f8090k;
            this.f8091l = transform.f8091l;
            this.f8092m = transform.f8092m;
            this.f8093n = transform.f8093n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.f8080a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (f8079o.get(index)) {
                    case 1:
                        this.f8081b = obtainStyledAttributes.getFloat(index, this.f8081b);
                        break;
                    case 2:
                        this.f8082c = obtainStyledAttributes.getFloat(index, this.f8082c);
                        break;
                    case 3:
                        this.f8083d = obtainStyledAttributes.getFloat(index, this.f8083d);
                        break;
                    case 4:
                        this.f8084e = obtainStyledAttributes.getFloat(index, this.f8084e);
                        break;
                    case 5:
                        this.f8085f = obtainStyledAttributes.getFloat(index, this.f8085f);
                        break;
                    case 6:
                        this.f8086g = obtainStyledAttributes.getDimension(index, this.f8086g);
                        break;
                    case 7:
                        this.f8087h = obtainStyledAttributes.getDimension(index, this.f8087h);
                        break;
                    case 8:
                        this.f8089j = obtainStyledAttributes.getDimension(index, this.f8089j);
                        break;
                    case 9:
                        this.f8090k = obtainStyledAttributes.getDimension(index, this.f8090k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f8091l = obtainStyledAttributes.getDimension(index, this.f8091l);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f8092m = true;
                            this.f8093n = obtainStyledAttributes.getDimension(index, this.f8093n);
                            break;
                        }
                    case 12:
                        this.f8088i = ConstraintSet.F(obtainStyledAttributes, index, this.f8088i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f7987i.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f7987i.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f7987i.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f7987i.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f7987i.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f7987i.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f7987i.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f7987i.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f7987i.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f7987i.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f7987i.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f7987i.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f7987i.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f7987i.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f7987i.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f7987i.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f7987i.append(R$styleable.Constraint_android_orientation, 27);
        f7987i.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f7987i.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f7987i.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f7987i.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f7987i.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f7987i.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f7987i.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f7987i.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f7987i.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f7987i.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f7987i.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f7987i.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f7987i.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f7987i.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f7987i.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f7987i.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f7987i.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f7987i.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f7987i.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f7987i.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f7987i.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f7987i.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f7987i.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f7987i.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f7987i.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f7987i.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f7987i.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f7987i.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f7987i.append(R$styleable.Constraint_android_layout_width, 23);
        f7987i.append(R$styleable.Constraint_android_layout_height, 21);
        f7987i.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f7987i.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f7987i.append(R$styleable.Constraint_android_visibility, 22);
        f7987i.append(R$styleable.Constraint_android_alpha, 43);
        f7987i.append(R$styleable.Constraint_android_elevation, 44);
        f7987i.append(R$styleable.Constraint_android_rotationX, 45);
        f7987i.append(R$styleable.Constraint_android_rotationY, 46);
        f7987i.append(R$styleable.Constraint_android_rotation, 60);
        f7987i.append(R$styleable.Constraint_android_scaleX, 47);
        f7987i.append(R$styleable.Constraint_android_scaleY, 48);
        f7987i.append(R$styleable.Constraint_android_transformPivotX, 49);
        f7987i.append(R$styleable.Constraint_android_transformPivotY, 50);
        f7987i.append(R$styleable.Constraint_android_translationX, 51);
        f7987i.append(R$styleable.Constraint_android_translationY, 52);
        f7987i.append(R$styleable.Constraint_android_translationZ, 53);
        f7987i.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f7987i.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f7987i.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f7987i.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f7987i.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f7987i.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f7987i.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f7987i.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f7987i.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f7987i.append(R$styleable.Constraint_animateRelativeTo, 64);
        f7987i.append(R$styleable.Constraint_transitionEasing, 65);
        f7987i.append(R$styleable.Constraint_drawPath, 66);
        f7987i.append(R$styleable.Constraint_transitionPathRotate, 67);
        f7987i.append(R$styleable.Constraint_motionStagger, 79);
        f7987i.append(R$styleable.Constraint_android_id, 38);
        f7987i.append(R$styleable.Constraint_motionProgress, 68);
        f7987i.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f7987i.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f7987i.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f7987i.append(R$styleable.Constraint_chainUseRtl, 71);
        f7987i.append(R$styleable.Constraint_barrierDirection, 72);
        f7987i.append(R$styleable.Constraint_barrierMargin, 73);
        f7987i.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f7987i.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f7987i.append(R$styleable.Constraint_pathMotionArc, 76);
        f7987i.append(R$styleable.Constraint_layout_constraintTag, 77);
        f7987i.append(R$styleable.Constraint_visibilityMode, 78);
        f7987i.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f7987i.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f7987i.append(R$styleable.Constraint_polarRelativeTo, 82);
        f7987i.append(R$styleable.Constraint_transformPivotTarget, 83);
        f7987i.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f7987i.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f7987i.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f7988j;
        int i11 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i11, 6);
        f7988j.append(i11, 7);
        f7988j.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f7988j.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f7988j.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f7988j.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f7988j.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f7988j.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f7988j.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f7988j.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f7988j.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f7988j.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f7988j.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f7988j.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f7988j.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f7988j.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f7988j.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f7988j.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f7988j.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f7988j.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f7988j.append(R$styleable.ConstraintOverride_drawPath, 66);
        f7988j.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f7988j.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f7988j.append(R$styleable.ConstraintOverride_android_id, 38);
        f7988j.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f7988j.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f7988j.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f7988j.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f7988j.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f7988j.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f7988j.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f7988j.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f7988j.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f7988j.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f7988j.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f7988j.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f7988j.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f7988j.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f7988j.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f7988j.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f7988j.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f7988j.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int F(TypedArray typedArray, int i11, int i12) {
        int resourceId = typedArray.getResourceId(i11, i12);
        return resourceId == -1 ? typedArray.getInt(i11, -1) : resourceId;
    }

    public static void G(Object obj, TypedArray typedArray, int i11, int i12) {
        if (obj != null) {
            int i13 = typedArray.peekValue(i11).type;
            if (i13 != 3) {
                int i14 = -2;
                boolean z11 = false;
                if (i13 != 5) {
                    int i15 = typedArray.getInt(i11, 0);
                    if (i15 != -4) {
                        i14 = (i15 == -3 || !(i15 == -2 || i15 == -1)) ? 0 : i15;
                    } else {
                        z11 = true;
                    }
                } else {
                    i14 = typedArray.getDimensionPixelSize(i11, 0);
                }
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i12 == 0) {
                        layoutParams.width = i14;
                        layoutParams.Z = z11;
                        return;
                    }
                    layoutParams.height = i14;
                    layoutParams.f7929a0 = z11;
                } else if (obj instanceof Layout) {
                    Layout layout = (Layout) obj;
                    if (i12 == 0) {
                        layout.f8023d = i14;
                        layout.f8042m0 = z11;
                        return;
                    }
                    layout.f8025e = i14;
                    layout.f8044n0 = z11;
                } else if (obj instanceof Constraint.a) {
                    Constraint.a aVar = (Constraint.a) obj;
                    if (i12 == 0) {
                        aVar.b(23, i14);
                        aVar.d(80, z11);
                        return;
                    }
                    aVar.b(21, i14);
                    aVar.d(81, z11);
                }
            } else {
                H(obj, typedArray.getString(i11), i12);
            }
        }
    }

    public static void H(Object obj, String str, int i11) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if ("ratio".equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i11 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            I(layoutParams, trim2);
                        } else if (obj instanceof Layout) {
                            ((Layout) obj).f8058z = trim2;
                        } else if (obj instanceof Constraint.a) {
                            ((Constraint.a) obj).c(5, trim2);
                        }
                    } else if ("weight".equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i11 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.K = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.L = parseFloat;
                            } else if (obj instanceof Layout) {
                                Layout layout = (Layout) obj;
                                if (i11 == 0) {
                                    layout.f8023d = 0;
                                    layout.V = parseFloat;
                                    return;
                                }
                                layout.f8025e = 0;
                                layout.U = parseFloat;
                            } else if (obj instanceof Constraint.a) {
                                Constraint.a aVar = (Constraint.a) obj;
                                if (i11 == 0) {
                                    aVar.b(23, 0);
                                    aVar.a(39, parseFloat);
                                    return;
                                }
                                aVar.b(21, 0);
                                aVar.a(40, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if ("parent".equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i11 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.U = max;
                                layoutParams3.O = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.V = max;
                            layoutParams3.P = 2;
                        } else if (obj instanceof Layout) {
                            Layout layout2 = (Layout) obj;
                            if (i11 == 0) {
                                layout2.f8023d = 0;
                                layout2.f8026e0 = max;
                                layout2.Y = 2;
                                return;
                            }
                            layout2.f8025e = 0;
                            layout2.f8028f0 = max;
                            layout2.Z = 2;
                        } else if (obj instanceof Constraint.a) {
                            Constraint.a aVar2 = (Constraint.a) obj;
                            if (i11 == 0) {
                                aVar2.b(23, 0);
                                aVar2.b(54, 2);
                                return;
                            }
                            aVar2.b(21, 0);
                            aVar2.b(55, 2);
                        }
                    }
                }
            }
        }
    }

    public static void I(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f11 = Float.NaN;
        int i11 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i12 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i11 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i11 = 1;
                }
                i12 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i12);
                if (substring2.length() > 0) {
                    f11 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i12, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f11 = i11 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.H = str;
        layoutParams.I = f11;
        layoutParams.J = i11;
    }

    public static void K(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.a aVar = new Constraint.a();
        constraint.f8003h = aVar;
        constraint.f7999d.f8060a = false;
        constraint.f8000e.f8019b = false;
        constraint.f7998c.f8074a = false;
        constraint.f8001f.f8080a = false;
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            switch (f7988j.get(index)) {
                case 2:
                    aVar.b(2, typedArray.getDimensionPixelSize(index, constraint.f8000e.J));
                    break;
                case 5:
                    aVar.c(5, typedArray.getString(index));
                    break;
                case 6:
                    aVar.b(6, typedArray.getDimensionPixelOffset(index, constraint.f8000e.D));
                    break;
                case 7:
                    aVar.b(7, typedArray.getDimensionPixelOffset(index, constraint.f8000e.E));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        aVar.b(8, typedArray.getDimensionPixelSize(index, constraint.f8000e.K));
                        break;
                    }
                case 11:
                    aVar.b(11, typedArray.getDimensionPixelSize(index, constraint.f8000e.Q));
                    break;
                case 12:
                    aVar.b(12, typedArray.getDimensionPixelSize(index, constraint.f8000e.R));
                    break;
                case 13:
                    aVar.b(13, typedArray.getDimensionPixelSize(index, constraint.f8000e.N));
                    break;
                case 14:
                    aVar.b(14, typedArray.getDimensionPixelSize(index, constraint.f8000e.P));
                    break;
                case 15:
                    aVar.b(15, typedArray.getDimensionPixelSize(index, constraint.f8000e.S));
                    break;
                case 16:
                    aVar.b(16, typedArray.getDimensionPixelSize(index, constraint.f8000e.O));
                    break;
                case 17:
                    aVar.b(17, typedArray.getDimensionPixelOffset(index, constraint.f8000e.f8027f));
                    break;
                case 18:
                    aVar.b(18, typedArray.getDimensionPixelOffset(index, constraint.f8000e.f8029g));
                    break;
                case 19:
                    aVar.a(19, typedArray.getFloat(index, constraint.f8000e.f8031h));
                    break;
                case 20:
                    aVar.a(20, typedArray.getFloat(index, constraint.f8000e.f8056x));
                    break;
                case 21:
                    aVar.b(21, typedArray.getLayoutDimension(index, constraint.f8000e.f8025e));
                    break;
                case 22:
                    aVar.b(22, f7986h[typedArray.getInt(index, constraint.f7998c.f8075b)]);
                    break;
                case 23:
                    aVar.b(23, typedArray.getLayoutDimension(index, constraint.f8000e.f8023d));
                    break;
                case 24:
                    aVar.b(24, typedArray.getDimensionPixelSize(index, constraint.f8000e.G));
                    break;
                case 27:
                    aVar.b(27, typedArray.getInt(index, constraint.f8000e.F));
                    break;
                case 28:
                    aVar.b(28, typedArray.getDimensionPixelSize(index, constraint.f8000e.H));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        aVar.b(31, typedArray.getDimensionPixelSize(index, constraint.f8000e.L));
                        break;
                    }
                case 34:
                    aVar.b(34, typedArray.getDimensionPixelSize(index, constraint.f8000e.I));
                    break;
                case 37:
                    aVar.a(37, typedArray.getFloat(index, constraint.f8000e.f8057y));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f7996a);
                    constraint.f7996a = resourceId;
                    aVar.b(38, resourceId);
                    break;
                case 39:
                    aVar.a(39, typedArray.getFloat(index, constraint.f8000e.V));
                    break;
                case 40:
                    aVar.a(40, typedArray.getFloat(index, constraint.f8000e.U));
                    break;
                case 41:
                    aVar.b(41, typedArray.getInt(index, constraint.f8000e.W));
                    break;
                case 42:
                    aVar.b(42, typedArray.getInt(index, constraint.f8000e.X));
                    break;
                case 43:
                    aVar.a(43, typedArray.getFloat(index, constraint.f7998c.f8077d));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.d(44, true);
                        aVar.a(44, typedArray.getDimension(index, constraint.f8001f.f8093n));
                        break;
                    }
                case 45:
                    aVar.a(45, typedArray.getFloat(index, constraint.f8001f.f8082c));
                    break;
                case 46:
                    aVar.a(46, typedArray.getFloat(index, constraint.f8001f.f8083d));
                    break;
                case 47:
                    aVar.a(47, typedArray.getFloat(index, constraint.f8001f.f8084e));
                    break;
                case 48:
                    aVar.a(48, typedArray.getFloat(index, constraint.f8001f.f8085f));
                    break;
                case 49:
                    aVar.a(49, typedArray.getDimension(index, constraint.f8001f.f8086g));
                    break;
                case 50:
                    aVar.a(50, typedArray.getDimension(index, constraint.f8001f.f8087h));
                    break;
                case 51:
                    aVar.a(51, typedArray.getDimension(index, constraint.f8001f.f8089j));
                    break;
                case 52:
                    aVar.a(52, typedArray.getDimension(index, constraint.f8001f.f8090k));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.a(53, typedArray.getDimension(index, constraint.f8001f.f8091l));
                        break;
                    }
                case 54:
                    aVar.b(54, typedArray.getInt(index, constraint.f8000e.Y));
                    break;
                case 55:
                    aVar.b(55, typedArray.getInt(index, constraint.f8000e.Z));
                    break;
                case 56:
                    aVar.b(56, typedArray.getDimensionPixelSize(index, constraint.f8000e.f8018a0));
                    break;
                case 57:
                    aVar.b(57, typedArray.getDimensionPixelSize(index, constraint.f8000e.f8020b0));
                    break;
                case 58:
                    aVar.b(58, typedArray.getDimensionPixelSize(index, constraint.f8000e.f8022c0));
                    break;
                case 59:
                    aVar.b(59, typedArray.getDimensionPixelSize(index, constraint.f8000e.f8024d0));
                    break;
                case 60:
                    aVar.a(60, typedArray.getFloat(index, constraint.f8001f.f8081b));
                    break;
                case 62:
                    aVar.b(62, typedArray.getDimensionPixelSize(index, constraint.f8000e.B));
                    break;
                case 63:
                    aVar.a(63, typedArray.getFloat(index, constraint.f8000e.C));
                    break;
                case 64:
                    aVar.b(64, F(typedArray, index, constraint.f7999d.f8061b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        aVar.c(65, Easing.f6847c[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        aVar.c(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    aVar.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    aVar.a(67, typedArray.getFloat(index, constraint.f7999d.f8068i));
                    break;
                case 68:
                    aVar.a(68, typedArray.getFloat(index, constraint.f7998c.f8078e));
                    break;
                case 69:
                    aVar.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    aVar.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    aVar.b(72, typedArray.getInt(index, constraint.f8000e.f8030g0));
                    break;
                case 73:
                    aVar.b(73, typedArray.getDimensionPixelSize(index, constraint.f8000e.f8032h0));
                    break;
                case 74:
                    aVar.c(74, typedArray.getString(index));
                    break;
                case 75:
                    aVar.d(75, typedArray.getBoolean(index, constraint.f8000e.f8046o0));
                    break;
                case 76:
                    aVar.b(76, typedArray.getInt(index, constraint.f7999d.f8064e));
                    break;
                case 77:
                    aVar.c(77, typedArray.getString(index));
                    break;
                case 78:
                    aVar.b(78, typedArray.getInt(index, constraint.f7998c.f8076c));
                    break;
                case 79:
                    aVar.a(79, typedArray.getFloat(index, constraint.f7999d.f8066g));
                    break;
                case 80:
                    aVar.d(80, typedArray.getBoolean(index, constraint.f8000e.f8042m0));
                    break;
                case 81:
                    aVar.d(81, typedArray.getBoolean(index, constraint.f8000e.f8044n0));
                    break;
                case 82:
                    aVar.b(82, typedArray.getInteger(index, constraint.f7999d.f8062c));
                    break;
                case 83:
                    aVar.b(83, F(typedArray, index, constraint.f8001f.f8088i));
                    break;
                case 84:
                    aVar.b(84, typedArray.getInteger(index, constraint.f7999d.f8070k));
                    break;
                case 85:
                    aVar.a(85, typedArray.getFloat(index, constraint.f7999d.f8069j));
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            Motion motion = constraint.f7999d;
                            motion.f8072m = typedArray.getInteger(index, motion.f8073n);
                            aVar.b(88, constraint.f7999d.f8072m);
                            break;
                        } else {
                            constraint.f7999d.f8071l = typedArray.getString(index);
                            aVar.c(90, constraint.f7999d.f8071l);
                            if (constraint.f7999d.f8071l.indexOf("/") <= 0) {
                                constraint.f7999d.f8072m = -1;
                                aVar.b(88, -1);
                                break;
                            } else {
                                constraint.f7999d.f8073n = typedArray.getResourceId(index, -1);
                                aVar.b(89, constraint.f7999d.f8073n);
                                constraint.f7999d.f8072m = -2;
                                aVar.b(88, -2);
                                break;
                            }
                        }
                    } else {
                        constraint.f7999d.f8073n = typedArray.getResourceId(index, -1);
                        aVar.b(89, constraint.f7999d.f8073n);
                        Motion motion2 = constraint.f7999d;
                        if (motion2.f8073n == -1) {
                            break;
                        } else {
                            motion2.f8072m = -2;
                            aVar.b(88, -2);
                            break;
                        }
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7987i.get(index));
                    break;
                case 93:
                    aVar.b(93, typedArray.getDimensionPixelSize(index, constraint.f8000e.M));
                    break;
                case 94:
                    aVar.b(94, typedArray.getDimensionPixelSize(index, constraint.f8000e.T));
                    break;
                case 95:
                    G(aVar, typedArray, index, 0);
                    break;
                case 96:
                    G(aVar, typedArray, index, 1);
                    break;
                case 97:
                    aVar.b(97, typedArray.getInt(index, constraint.f8000e.f8048p0));
                    break;
                case 98:
                    if (!MotionLayout.K0) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.f7996a = typedArray.getResourceId(index, constraint.f7996a);
                            break;
                        } else {
                            constraint.f7997b = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f7996a);
                        constraint.f7996a = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            constraint.f7997b = typedArray.getString(index);
                            break;
                        }
                    }
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7987i.get(index));
                    break;
            }
        }
    }

    public static void N(Constraint constraint, int i11, float f11) {
        if (i11 == 19) {
            constraint.f8000e.f8031h = f11;
        } else if (i11 == 20) {
            constraint.f8000e.f8056x = f11;
        } else if (i11 == 37) {
            constraint.f8000e.f8057y = f11;
        } else if (i11 == 60) {
            constraint.f8001f.f8081b = f11;
        } else if (i11 == 63) {
            constraint.f8000e.C = f11;
        } else if (i11 == 79) {
            constraint.f7999d.f8066g = f11;
        } else if (i11 == 85) {
            constraint.f7999d.f8069j = f11;
        } else if (i11 == 87) {
        } else {
            if (i11 == 39) {
                constraint.f8000e.V = f11;
            } else if (i11 != 40) {
                switch (i11) {
                    case 43:
                        constraint.f7998c.f8077d = f11;
                        return;
                    case 44:
                        Transform transform = constraint.f8001f;
                        transform.f8093n = f11;
                        transform.f8092m = true;
                        return;
                    case 45:
                        constraint.f8001f.f8082c = f11;
                        return;
                    case 46:
                        constraint.f8001f.f8083d = f11;
                        return;
                    case 47:
                        constraint.f8001f.f8084e = f11;
                        return;
                    case 48:
                        constraint.f8001f.f8085f = f11;
                        return;
                    case 49:
                        constraint.f8001f.f8086g = f11;
                        return;
                    case 50:
                        constraint.f8001f.f8087h = f11;
                        return;
                    case 51:
                        constraint.f8001f.f8089j = f11;
                        return;
                    case 52:
                        constraint.f8001f.f8090k = f11;
                        return;
                    case 53:
                        constraint.f8001f.f8091l = f11;
                        return;
                    default:
                        switch (i11) {
                            case 67:
                                constraint.f7999d.f8068i = f11;
                                return;
                            case 68:
                                constraint.f7998c.f8078e = f11;
                                return;
                            case 69:
                                constraint.f8000e.f8026e0 = f11;
                                return;
                            case 70:
                                constraint.f8000e.f8028f0 = f11;
                                return;
                            default:
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.f8000e.U = f11;
            }
        }
    }

    public static void O(Constraint constraint, int i11, int i12) {
        if (i11 == 6) {
            constraint.f8000e.D = i12;
        } else if (i11 == 7) {
            constraint.f8000e.E = i12;
        } else if (i11 == 8) {
            constraint.f8000e.K = i12;
        } else if (i11 == 27) {
            constraint.f8000e.F = i12;
        } else if (i11 == 28) {
            constraint.f8000e.H = i12;
        } else if (i11 == 41) {
            constraint.f8000e.W = i12;
        } else if (i11 == 42) {
            constraint.f8000e.X = i12;
        } else if (i11 == 61) {
            constraint.f8000e.A = i12;
        } else if (i11 == 62) {
            constraint.f8000e.B = i12;
        } else if (i11 == 72) {
            constraint.f8000e.f8030g0 = i12;
        } else if (i11 != 73) {
            switch (i11) {
                case 2:
                    constraint.f8000e.J = i12;
                    return;
                case 11:
                    constraint.f8000e.Q = i12;
                    return;
                case 12:
                    constraint.f8000e.R = i12;
                    return;
                case 13:
                    constraint.f8000e.N = i12;
                    return;
                case 14:
                    constraint.f8000e.P = i12;
                    return;
                case 15:
                    constraint.f8000e.S = i12;
                    return;
                case 16:
                    constraint.f8000e.O = i12;
                    return;
                case 17:
                    constraint.f8000e.f8027f = i12;
                    return;
                case 18:
                    constraint.f8000e.f8029g = i12;
                    return;
                case 31:
                    constraint.f8000e.L = i12;
                    return;
                case 34:
                    constraint.f8000e.I = i12;
                    return;
                case 38:
                    constraint.f7996a = i12;
                    return;
                case 64:
                    constraint.f7999d.f8061b = i12;
                    return;
                case 66:
                    constraint.f7999d.f8065f = i12;
                    return;
                case 76:
                    constraint.f7999d.f8064e = i12;
                    return;
                case 78:
                    constraint.f7998c.f8076c = i12;
                    return;
                case 93:
                    constraint.f8000e.M = i12;
                    return;
                case 94:
                    constraint.f8000e.T = i12;
                    return;
                case 97:
                    constraint.f8000e.f8048p0 = i12;
                    return;
                default:
                    switch (i11) {
                        case 21:
                            constraint.f8000e.f8025e = i12;
                            return;
                        case 22:
                            constraint.f7998c.f8075b = i12;
                            return;
                        case 23:
                            constraint.f8000e.f8023d = i12;
                            return;
                        case 24:
                            constraint.f8000e.G = i12;
                            return;
                        default:
                            switch (i11) {
                                case 54:
                                    constraint.f8000e.Y = i12;
                                    return;
                                case 55:
                                    constraint.f8000e.Z = i12;
                                    return;
                                case 56:
                                    constraint.f8000e.f8018a0 = i12;
                                    return;
                                case 57:
                                    constraint.f8000e.f8020b0 = i12;
                                    return;
                                case 58:
                                    constraint.f8000e.f8022c0 = i12;
                                    return;
                                case 59:
                                    constraint.f8000e.f8024d0 = i12;
                                    return;
                                default:
                                    switch (i11) {
                                        case 82:
                                            constraint.f7999d.f8062c = i12;
                                            return;
                                        case 83:
                                            constraint.f8001f.f8088i = i12;
                                            return;
                                        case 84:
                                            constraint.f7999d.f8070k = i12;
                                            return;
                                        default:
                                            switch (i11) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.f7999d.f8072m = i12;
                                                    return;
                                                case 89:
                                                    constraint.f7999d.f8073n = i12;
                                                    return;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.f8000e.f8032h0 = i12;
        }
    }

    public static void P(Constraint constraint, int i11, String str) {
        if (i11 == 5) {
            constraint.f8000e.f8058z = str;
        } else if (i11 == 65) {
            constraint.f7999d.f8063d = str;
        } else if (i11 == 74) {
            constraint.f8000e.f8038k0 = str;
        } else if (i11 == 77) {
            constraint.f8000e.f8040l0 = str;
        } else if (i11 == 87) {
        } else {
            if (i11 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.f7999d.f8071l = str;
            }
        }
    }

    public static void Q(Constraint constraint, int i11, boolean z11) {
        if (i11 == 44) {
            constraint.f8001f.f8092m = z11;
        } else if (i11 == 75) {
            constraint.f8000e.f8046o0 = z11;
        } else if (i11 == 87) {
        } else {
            if (i11 == 80) {
                constraint.f8000e.f8042m0 = z11;
            } else if (i11 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.f8000e.f8044n0 = z11;
            }
        }
    }

    public static Constraint m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R$styleable.ConstraintOverride);
        K(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public int A(int i11) {
        return v(i11).f7998c.f8075b;
    }

    public int B(int i11) {
        return v(i11).f7998c.f8076c;
    }

    public int C(int i11) {
        return v(i11).f8000e.f8023d;
    }

    public void D(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint u11 = u(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        u11.f8000e.f8017a = true;
                    }
                    this.f7995g.put(Integer.valueOf(u11.f7996a), u11);
                }
            }
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        } catch (IOException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01da
            if (r0 == 0) goto L_0x01c8
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0015
            goto L_0x01cb
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r7
            goto L_0x004e
        L_0x0031:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r6
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r3
            goto L_0x004e
        L_0x0045:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r5) goto L_0x0058
            goto L_0x01cb
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r0 = r9.f7995g     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r3 = r2.f7996a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2 = r1
            goto L_0x01cb
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r7
            goto L_0x00d9
        L_0x007e:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r5
            goto L_0x00d9
        L_0x0093:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r6
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r3
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cb
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.f8002g     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintAttribute.i(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.ConstraintSet$Motion r0 = r2.f7999d     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.f8000e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.ConstraintSet$Transform r0 = r2.f8001f     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r0 = r2.f7998c     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.f8000e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f8034i0 = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.f8000e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f8017a = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f8019b = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01b5:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.u(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01be:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01c6:
            r2 = r0
            goto L_0x01cb
        L_0x01c8:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01cb:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x0006
        L_0x01d1:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01da
        L_0x01d6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.E(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void J(Context context, Constraint constraint, TypedArray typedArray, boolean z11) {
        if (z11) {
            K(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (!(index == R$styleable.Constraint_android_id || R$styleable.Constraint_android_layout_marginStart == index || R$styleable.Constraint_android_layout_marginEnd == index)) {
                constraint.f7999d.f8060a = true;
                constraint.f8000e.f8019b = true;
                constraint.f7998c.f8074a = true;
                constraint.f8001f.f8080a = true;
            }
            switch (f7987i.get(index)) {
                case 1:
                    Layout layout = constraint.f8000e;
                    layout.f8049q = F(typedArray, index, layout.f8049q);
                    break;
                case 2:
                    Layout layout2 = constraint.f8000e;
                    layout2.J = typedArray.getDimensionPixelSize(index, layout2.J);
                    break;
                case 3:
                    Layout layout3 = constraint.f8000e;
                    layout3.f8047p = F(typedArray, index, layout3.f8047p);
                    break;
                case 4:
                    Layout layout4 = constraint.f8000e;
                    layout4.f8045o = F(typedArray, index, layout4.f8045o);
                    break;
                case 5:
                    constraint.f8000e.f8058z = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.f8000e;
                    layout5.D = typedArray.getDimensionPixelOffset(index, layout5.D);
                    break;
                case 7:
                    Layout layout6 = constraint.f8000e;
                    layout6.E = typedArray.getDimensionPixelOffset(index, layout6.E);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        Layout layout7 = constraint.f8000e;
                        layout7.K = typedArray.getDimensionPixelSize(index, layout7.K);
                        break;
                    }
                case 9:
                    Layout layout8 = constraint.f8000e;
                    layout8.f8055w = F(typedArray, index, layout8.f8055w);
                    break;
                case 10:
                    Layout layout9 = constraint.f8000e;
                    layout9.f8054v = F(typedArray, index, layout9.f8054v);
                    break;
                case 11:
                    Layout layout10 = constraint.f8000e;
                    layout10.Q = typedArray.getDimensionPixelSize(index, layout10.Q);
                    break;
                case 12:
                    Layout layout11 = constraint.f8000e;
                    layout11.R = typedArray.getDimensionPixelSize(index, layout11.R);
                    break;
                case 13:
                    Layout layout12 = constraint.f8000e;
                    layout12.N = typedArray.getDimensionPixelSize(index, layout12.N);
                    break;
                case 14:
                    Layout layout13 = constraint.f8000e;
                    layout13.P = typedArray.getDimensionPixelSize(index, layout13.P);
                    break;
                case 15:
                    Layout layout14 = constraint.f8000e;
                    layout14.S = typedArray.getDimensionPixelSize(index, layout14.S);
                    break;
                case 16:
                    Layout layout15 = constraint.f8000e;
                    layout15.O = typedArray.getDimensionPixelSize(index, layout15.O);
                    break;
                case 17:
                    Layout layout16 = constraint.f8000e;
                    layout16.f8027f = typedArray.getDimensionPixelOffset(index, layout16.f8027f);
                    break;
                case 18:
                    Layout layout17 = constraint.f8000e;
                    layout17.f8029g = typedArray.getDimensionPixelOffset(index, layout17.f8029g);
                    break;
                case 19:
                    Layout layout18 = constraint.f8000e;
                    layout18.f8031h = typedArray.getFloat(index, layout18.f8031h);
                    break;
                case 20:
                    Layout layout19 = constraint.f8000e;
                    layout19.f8056x = typedArray.getFloat(index, layout19.f8056x);
                    break;
                case 21:
                    Layout layout20 = constraint.f8000e;
                    layout20.f8025e = typedArray.getLayoutDimension(index, layout20.f8025e);
                    break;
                case 22:
                    PropertySet propertySet = constraint.f7998c;
                    propertySet.f8075b = typedArray.getInt(index, propertySet.f8075b);
                    PropertySet propertySet2 = constraint.f7998c;
                    propertySet2.f8075b = f7986h[propertySet2.f8075b];
                    break;
                case 23:
                    Layout layout21 = constraint.f8000e;
                    layout21.f8023d = typedArray.getLayoutDimension(index, layout21.f8023d);
                    break;
                case 24:
                    Layout layout22 = constraint.f8000e;
                    layout22.G = typedArray.getDimensionPixelSize(index, layout22.G);
                    break;
                case 25:
                    Layout layout23 = constraint.f8000e;
                    layout23.f8033i = F(typedArray, index, layout23.f8033i);
                    break;
                case 26:
                    Layout layout24 = constraint.f8000e;
                    layout24.f8035j = F(typedArray, index, layout24.f8035j);
                    break;
                case 27:
                    Layout layout25 = constraint.f8000e;
                    layout25.F = typedArray.getInt(index, layout25.F);
                    break;
                case 28:
                    Layout layout26 = constraint.f8000e;
                    layout26.H = typedArray.getDimensionPixelSize(index, layout26.H);
                    break;
                case 29:
                    Layout layout27 = constraint.f8000e;
                    layout27.f8037k = F(typedArray, index, layout27.f8037k);
                    break;
                case 30:
                    Layout layout28 = constraint.f8000e;
                    layout28.f8039l = F(typedArray, index, layout28.f8039l);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        Layout layout29 = constraint.f8000e;
                        layout29.L = typedArray.getDimensionPixelSize(index, layout29.L);
                        break;
                    }
                case 32:
                    Layout layout30 = constraint.f8000e;
                    layout30.f8052t = F(typedArray, index, layout30.f8052t);
                    break;
                case 33:
                    Layout layout31 = constraint.f8000e;
                    layout31.f8053u = F(typedArray, index, layout31.f8053u);
                    break;
                case 34:
                    Layout layout32 = constraint.f8000e;
                    layout32.I = typedArray.getDimensionPixelSize(index, layout32.I);
                    break;
                case 35:
                    Layout layout33 = constraint.f8000e;
                    layout33.f8043n = F(typedArray, index, layout33.f8043n);
                    break;
                case 36:
                    Layout layout34 = constraint.f8000e;
                    layout34.f8041m = F(typedArray, index, layout34.f8041m);
                    break;
                case 37:
                    Layout layout35 = constraint.f8000e;
                    layout35.f8057y = typedArray.getFloat(index, layout35.f8057y);
                    break;
                case 38:
                    constraint.f7996a = typedArray.getResourceId(index, constraint.f7996a);
                    break;
                case 39:
                    Layout layout36 = constraint.f8000e;
                    layout36.V = typedArray.getFloat(index, layout36.V);
                    break;
                case 40:
                    Layout layout37 = constraint.f8000e;
                    layout37.U = typedArray.getFloat(index, layout37.U);
                    break;
                case 41:
                    Layout layout38 = constraint.f8000e;
                    layout38.W = typedArray.getInt(index, layout38.W);
                    break;
                case 42:
                    Layout layout39 = constraint.f8000e;
                    layout39.X = typedArray.getInt(index, layout39.X);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.f7998c;
                    propertySet3.f8077d = typedArray.getFloat(index, propertySet3.f8077d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        Transform transform = constraint.f8001f;
                        transform.f8092m = true;
                        transform.f8093n = typedArray.getDimension(index, transform.f8093n);
                        break;
                    }
                case 45:
                    Transform transform2 = constraint.f8001f;
                    transform2.f8082c = typedArray.getFloat(index, transform2.f8082c);
                    break;
                case 46:
                    Transform transform3 = constraint.f8001f;
                    transform3.f8083d = typedArray.getFloat(index, transform3.f8083d);
                    break;
                case 47:
                    Transform transform4 = constraint.f8001f;
                    transform4.f8084e = typedArray.getFloat(index, transform4.f8084e);
                    break;
                case 48:
                    Transform transform5 = constraint.f8001f;
                    transform5.f8085f = typedArray.getFloat(index, transform5.f8085f);
                    break;
                case 49:
                    Transform transform6 = constraint.f8001f;
                    transform6.f8086g = typedArray.getDimension(index, transform6.f8086g);
                    break;
                case 50:
                    Transform transform7 = constraint.f8001f;
                    transform7.f8087h = typedArray.getDimension(index, transform7.f8087h);
                    break;
                case 51:
                    Transform transform8 = constraint.f8001f;
                    transform8.f8089j = typedArray.getDimension(index, transform8.f8089j);
                    break;
                case 52:
                    Transform transform9 = constraint.f8001f;
                    transform9.f8090k = typedArray.getDimension(index, transform9.f8090k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        Transform transform10 = constraint.f8001f;
                        transform10.f8091l = typedArray.getDimension(index, transform10.f8091l);
                        break;
                    }
                case 54:
                    Layout layout40 = constraint.f8000e;
                    layout40.Y = typedArray.getInt(index, layout40.Y);
                    break;
                case 55:
                    Layout layout41 = constraint.f8000e;
                    layout41.Z = typedArray.getInt(index, layout41.Z);
                    break;
                case 56:
                    Layout layout42 = constraint.f8000e;
                    layout42.f8018a0 = typedArray.getDimensionPixelSize(index, layout42.f8018a0);
                    break;
                case 57:
                    Layout layout43 = constraint.f8000e;
                    layout43.f8020b0 = typedArray.getDimensionPixelSize(index, layout43.f8020b0);
                    break;
                case 58:
                    Layout layout44 = constraint.f8000e;
                    layout44.f8022c0 = typedArray.getDimensionPixelSize(index, layout44.f8022c0);
                    break;
                case 59:
                    Layout layout45 = constraint.f8000e;
                    layout45.f8024d0 = typedArray.getDimensionPixelSize(index, layout45.f8024d0);
                    break;
                case 60:
                    Transform transform11 = constraint.f8001f;
                    transform11.f8081b = typedArray.getFloat(index, transform11.f8081b);
                    break;
                case 61:
                    Layout layout46 = constraint.f8000e;
                    layout46.A = F(typedArray, index, layout46.A);
                    break;
                case 62:
                    Layout layout47 = constraint.f8000e;
                    layout47.B = typedArray.getDimensionPixelSize(index, layout47.B);
                    break;
                case 63:
                    Layout layout48 = constraint.f8000e;
                    layout48.C = typedArray.getFloat(index, layout48.C);
                    break;
                case 64:
                    Motion motion = constraint.f7999d;
                    motion.f8061b = F(typedArray, index, motion.f8061b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        constraint.f7999d.f8063d = Easing.f6847c[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        constraint.f7999d.f8063d = typedArray.getString(index);
                        break;
                    }
                case 66:
                    constraint.f7999d.f8065f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.f7999d;
                    motion2.f8068i = typedArray.getFloat(index, motion2.f8068i);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.f7998c;
                    propertySet4.f8078e = typedArray.getFloat(index, propertySet4.f8078e);
                    break;
                case 69:
                    constraint.f8000e.f8026e0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.f8000e.f8028f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.f8000e;
                    layout49.f8030g0 = typedArray.getInt(index, layout49.f8030g0);
                    break;
                case 73:
                    Layout layout50 = constraint.f8000e;
                    layout50.f8032h0 = typedArray.getDimensionPixelSize(index, layout50.f8032h0);
                    break;
                case 74:
                    constraint.f8000e.f8038k0 = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.f8000e;
                    layout51.f8046o0 = typedArray.getBoolean(index, layout51.f8046o0);
                    break;
                case 76:
                    Motion motion3 = constraint.f7999d;
                    motion3.f8064e = typedArray.getInt(index, motion3.f8064e);
                    break;
                case 77:
                    constraint.f8000e.f8040l0 = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.f7998c;
                    propertySet5.f8076c = typedArray.getInt(index, propertySet5.f8076c);
                    break;
                case 79:
                    Motion motion4 = constraint.f7999d;
                    motion4.f8066g = typedArray.getFloat(index, motion4.f8066g);
                    break;
                case 80:
                    Layout layout52 = constraint.f8000e;
                    layout52.f8042m0 = typedArray.getBoolean(index, layout52.f8042m0);
                    break;
                case 81:
                    Layout layout53 = constraint.f8000e;
                    layout53.f8044n0 = typedArray.getBoolean(index, layout53.f8044n0);
                    break;
                case 82:
                    Motion motion5 = constraint.f7999d;
                    motion5.f8062c = typedArray.getInteger(index, motion5.f8062c);
                    break;
                case 83:
                    Transform transform12 = constraint.f8001f;
                    transform12.f8088i = F(typedArray, index, transform12.f8088i);
                    break;
                case 84:
                    Motion motion6 = constraint.f7999d;
                    motion6.f8070k = typedArray.getInteger(index, motion6.f8070k);
                    break;
                case 85:
                    Motion motion7 = constraint.f7999d;
                    motion7.f8069j = typedArray.getFloat(index, motion7.f8069j);
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            Motion motion8 = constraint.f7999d;
                            motion8.f8072m = typedArray.getInteger(index, motion8.f8073n);
                            break;
                        } else {
                            constraint.f7999d.f8071l = typedArray.getString(index);
                            if (constraint.f7999d.f8071l.indexOf("/") <= 0) {
                                constraint.f7999d.f8072m = -1;
                                break;
                            } else {
                                constraint.f7999d.f8073n = typedArray.getResourceId(index, -1);
                                constraint.f7999d.f8072m = -2;
                                break;
                            }
                        }
                    } else {
                        constraint.f7999d.f8073n = typedArray.getResourceId(index, -1);
                        Motion motion9 = constraint.f7999d;
                        if (motion9.f8073n == -1) {
                            break;
                        } else {
                            motion9.f8072m = -2;
                            break;
                        }
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7987i.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.f8000e;
                    layout54.f8050r = F(typedArray, index, layout54.f8050r);
                    break;
                case 92:
                    Layout layout55 = constraint.f8000e;
                    layout55.f8051s = F(typedArray, index, layout55.f8051s);
                    break;
                case 93:
                    Layout layout56 = constraint.f8000e;
                    layout56.M = typedArray.getDimensionPixelSize(index, layout56.M);
                    break;
                case 94:
                    Layout layout57 = constraint.f8000e;
                    layout57.T = typedArray.getDimensionPixelSize(index, layout57.T);
                    break;
                case 95:
                    G(constraint.f8000e, typedArray, index, 0);
                    break;
                case 96:
                    G(constraint.f8000e, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.f8000e;
                    layout58.f8048p0 = typedArray.getInt(index, layout58.f8048p0);
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7987i.get(index));
                    break;
            }
        }
    }

    public void L(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f7994f || id2 != -1) {
                if (!this.f7995g.containsKey(Integer.valueOf(id2))) {
                    this.f7995g.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.f7995g.get(Integer.valueOf(id2));
                if (constraint != null) {
                    if (!constraint.f8000e.f8019b) {
                        constraint.g(id2, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint.f8000e.f8036j0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint.f8000e.f8046o0 = barrier.getAllowsGoneWidget();
                                constraint.f8000e.f8030g0 = barrier.getType();
                                constraint.f8000e.f8032h0 = barrier.getMargin();
                            }
                        }
                        constraint.f8000e.f8019b = true;
                    }
                    PropertySet propertySet = constraint.f7998c;
                    if (!propertySet.f8074a) {
                        propertySet.f8075b = childAt.getVisibility();
                        constraint.f7998c.f8077d = childAt.getAlpha();
                        constraint.f7998c.f8074a = true;
                    }
                    int i12 = Build.VERSION.SDK_INT;
                    if (i12 >= 17) {
                        Transform transform = constraint.f8001f;
                        if (!transform.f8080a) {
                            transform.f8080a = true;
                            transform.f8081b = childAt.getRotation();
                            constraint.f8001f.f8082c = childAt.getRotationX();
                            constraint.f8001f.f8083d = childAt.getRotationY();
                            constraint.f8001f.f8084e = childAt.getScaleX();
                            constraint.f8001f.f8085f = childAt.getScaleY();
                            float pivotX = childAt.getPivotX();
                            float pivotY = childAt.getPivotY();
                            if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                                Transform transform2 = constraint.f8001f;
                                transform2.f8086g = pivotX;
                                transform2.f8087h = pivotY;
                            }
                            constraint.f8001f.f8089j = childAt.getTranslationX();
                            constraint.f8001f.f8090k = childAt.getTranslationY();
                            if (i12 >= 21) {
                                constraint.f8001f.f8091l = childAt.getTranslationZ();
                                Transform transform3 = constraint.f8001f;
                                if (transform3.f8092m) {
                                    transform3.f8093n = childAt.getElevation();
                                }
                            }
                        }
                    }
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void M(ConstraintSet constraintSet) {
        for (Integer next : constraintSet.f7995g.keySet()) {
            int intValue = next.intValue();
            Constraint constraint = constraintSet.f7995g.get(next);
            if (!this.f7995g.containsKey(Integer.valueOf(intValue))) {
                this.f7995g.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.f7995g.get(Integer.valueOf(intValue));
            if (constraint2 != null) {
                Layout layout = constraint2.f8000e;
                if (!layout.f8019b) {
                    layout.a(constraint.f8000e);
                }
                PropertySet propertySet = constraint2.f7998c;
                if (!propertySet.f8074a) {
                    propertySet.a(constraint.f7998c);
                }
                Transform transform = constraint2.f8001f;
                if (!transform.f8080a) {
                    transform.a(constraint.f8001f);
                }
                Motion motion = constraint2.f7999d;
                if (!motion.f8060a) {
                    motion.a(constraint.f7999d);
                }
                for (String next2 : constraint.f8002g.keySet()) {
                    if (!constraint2.f8002g.containsKey(next2)) {
                        constraint2.f8002g.put(next2, constraint.f8002g.get(next2));
                    }
                }
            }
        }
    }

    public void R(int i11, String str) {
        v(i11).f8000e.f8058z = str;
    }

    public void S(boolean z11) {
        this.f7994f = z11;
    }

    public void T(boolean z11) {
        this.f7989a = z11;
    }

    public void g(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7995g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else if (this.f7994f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f7995g.containsKey(Integer.valueOf(id2)) && (constraint = this.f7995g.get(Integer.valueOf(id2))) != null) {
                ConstraintAttribute.j(childAt, constraint.f8002g);
            }
        }
    }

    public void h(ConstraintSet constraintSet) {
        for (Constraint next : constraintSet.f7995g.values()) {
            if (next.f8003h != null) {
                if (next.f7997b != null) {
                    for (Integer intValue : this.f7995g.keySet()) {
                        Constraint w11 = w(intValue.intValue());
                        String str = w11.f8000e.f8040l0;
                        if (str != null && next.f7997b.matches(str)) {
                            next.f8003h.e(w11);
                            w11.f8002g.putAll((HashMap) next.f8002g.clone());
                        }
                    }
                } else {
                    next.f8003h.e(w(next.f7996a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id2 = constraintHelper.getId();
        if (this.f7995g.containsKey(Integer.valueOf(id2)) && (constraint = this.f7995g.get(Integer.valueOf(id2))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.l(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void k(ConstraintLayout constraintLayout, boolean z11) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f7995g.keySet());
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7995g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else if (this.f7994f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.f7995g.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    Constraint constraint = this.f7995g.get(Integer.valueOf(id2));
                    if (constraint != null) {
                        if (childAt instanceof Barrier) {
                            constraint.f8000e.f8034i0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(constraint.f8000e.f8030g0);
                            barrier.setMargin(constraint.f8000e.f8032h0);
                            barrier.setAllowsGoneWidget(constraint.f8000e.f8046o0);
                            Layout layout = constraint.f8000e;
                            int[] iArr = layout.f8036j0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.f8038k0;
                                if (str != null) {
                                    layout.f8036j0 = t(barrier, str);
                                    barrier.setReferencedIds(constraint.f8000e.f8036j0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.c();
                        constraint.e(layoutParams);
                        if (z11) {
                            ConstraintAttribute.j(childAt, constraint.f8002g);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.f7998c;
                        if (propertySet.f8076c == 0) {
                            childAt.setVisibility(propertySet.f8075b);
                        }
                        int i12 = Build.VERSION.SDK_INT;
                        if (i12 >= 17) {
                            childAt.setAlpha(constraint.f7998c.f8077d);
                            childAt.setRotation(constraint.f8001f.f8081b);
                            childAt.setRotationX(constraint.f8001f.f8082c);
                            childAt.setRotationY(constraint.f8001f.f8083d);
                            childAt.setScaleX(constraint.f8001f.f8084e);
                            childAt.setScaleY(constraint.f8001f.f8085f);
                            Transform transform = constraint.f8001f;
                            if (transform.f8088i != -1) {
                                View findViewById = ((View) childAt.getParent()).findViewById(constraint.f8001f.f8088i);
                                if (findViewById != null) {
                                    float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                    float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - ((float) childAt.getLeft()));
                                        childAt.setPivotY(top - ((float) childAt.getTop()));
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.f8086g)) {
                                    childAt.setPivotX(constraint.f8001f.f8086g);
                                }
                                if (!Float.isNaN(constraint.f8001f.f8087h)) {
                                    childAt.setPivotY(constraint.f8001f.f8087h);
                                }
                            }
                            childAt.setTranslationX(constraint.f8001f.f8089j);
                            childAt.setTranslationY(constraint.f8001f.f8090k);
                            if (i12 >= 21) {
                                childAt.setTranslationZ(constraint.f8001f.f8091l);
                                Transform transform2 = constraint.f8001f;
                                if (transform2.f8092m) {
                                    childAt.setElevation(transform2.f8093n);
                                }
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            Constraint constraint2 = this.f7995g.get(num);
            if (constraint2 != null) {
                if (constraint2.f8000e.f8034i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.f8000e;
                    int[] iArr2 = layout2.f8036j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.f8038k0;
                        if (str2 != null) {
                            layout2.f8036j0 = t(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.f8000e.f8036j0);
                        }
                    }
                    barrier2.setType(constraint2.f8000e.f8030g0);
                    barrier2.setMargin(constraint2.f8000e.f8032h0);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.s();
                    constraint2.e(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.f8000e.f8017a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.e(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = constraintLayout.getChildAt(i13);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).f(constraintLayout);
            }
        }
    }

    public void l(int i11, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (this.f7995g.containsKey(Integer.valueOf(i11)) && (constraint = this.f7995g.get(Integer.valueOf(i11))) != null) {
            constraint.e(layoutParams);
        }
    }

    public void n(int i11, int i12) {
        Constraint constraint;
        if (this.f7995g.containsKey(Integer.valueOf(i11)) && (constraint = this.f7995g.get(Integer.valueOf(i11))) != null) {
            switch (i12) {
                case 1:
                    Layout layout = constraint.f8000e;
                    layout.f8035j = -1;
                    layout.f8033i = -1;
                    layout.G = -1;
                    layout.N = Integer.MIN_VALUE;
                    return;
                case 2:
                    Layout layout2 = constraint.f8000e;
                    layout2.f8039l = -1;
                    layout2.f8037k = -1;
                    layout2.H = -1;
                    layout2.P = Integer.MIN_VALUE;
                    return;
                case 3:
                    Layout layout3 = constraint.f8000e;
                    layout3.f8043n = -1;
                    layout3.f8041m = -1;
                    layout3.I = 0;
                    layout3.O = Integer.MIN_VALUE;
                    return;
                case 4:
                    Layout layout4 = constraint.f8000e;
                    layout4.f8045o = -1;
                    layout4.f8047p = -1;
                    layout4.J = 0;
                    layout4.Q = Integer.MIN_VALUE;
                    return;
                case 5:
                    Layout layout5 = constraint.f8000e;
                    layout5.f8049q = -1;
                    layout5.f8050r = -1;
                    layout5.f8051s = -1;
                    layout5.M = 0;
                    layout5.T = Integer.MIN_VALUE;
                    return;
                case 6:
                    Layout layout6 = constraint.f8000e;
                    layout6.f8052t = -1;
                    layout6.f8053u = -1;
                    layout6.L = 0;
                    layout6.S = Integer.MIN_VALUE;
                    return;
                case 7:
                    Layout layout7 = constraint.f8000e;
                    layout7.f8054v = -1;
                    layout7.f8055w = -1;
                    layout7.K = 0;
                    layout7.R = Integer.MIN_VALUE;
                    return;
                case 8:
                    Layout layout8 = constraint.f8000e;
                    layout8.C = -1.0f;
                    layout8.B = -1;
                    layout8.A = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void o(Context context, int i11) {
        p((ConstraintLayout) LayoutInflater.from(context).inflate(i11, (ViewGroup) null));
    }

    public void p(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f7995g.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f7994f || id2 != -1) {
                if (!this.f7995g.containsKey(Integer.valueOf(id2))) {
                    this.f7995g.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.f7995g.get(Integer.valueOf(id2));
                if (constraint != null) {
                    constraint.f8002g = ConstraintAttribute.c(this.f7993e, childAt);
                    constraint.g(id2, layoutParams);
                    constraint.f7998c.f8075b = childAt.getVisibility();
                    int i12 = Build.VERSION.SDK_INT;
                    if (i12 >= 17) {
                        constraint.f7998c.f8077d = childAt.getAlpha();
                        constraint.f8001f.f8081b = childAt.getRotation();
                        constraint.f8001f.f8082c = childAt.getRotationX();
                        constraint.f8001f.f8083d = childAt.getRotationY();
                        constraint.f8001f.f8084e = childAt.getScaleX();
                        constraint.f8001f.f8085f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform = constraint.f8001f;
                            transform.f8086g = pivotX;
                            transform.f8087h = pivotY;
                        }
                        constraint.f8001f.f8089j = childAt.getTranslationX();
                        constraint.f8001f.f8090k = childAt.getTranslationY();
                        if (i12 >= 21) {
                            constraint.f8001f.f8091l = childAt.getTranslationZ();
                            Transform transform2 = constraint.f8001f;
                            if (transform2.f8092m) {
                                transform2.f8093n = childAt.getElevation();
                            }
                        }
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.f8000e.f8046o0 = barrier.getAllowsGoneWidget();
                        constraint.f8000e.f8036j0 = barrier.getReferencedIds();
                        constraint.f8000e.f8030g0 = barrier.getType();
                        constraint.f8000e.f8032h0 = barrier.getMargin();
                    }
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void q(ConstraintSet constraintSet) {
        this.f7995g.clear();
        for (Integer next : constraintSet.f7995g.keySet()) {
            Constraint constraint = constraintSet.f7995g.get(next);
            if (constraint != null) {
                this.f7995g.put(next, constraint.clone());
            }
        }
    }

    public void r(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f7995g.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraints.getChildAt(i11);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f7994f || id2 != -1) {
                if (!this.f7995g.containsKey(Integer.valueOf(id2))) {
                    this.f7995g.put(Integer.valueOf(id2), new Constraint());
                }
                Constraint constraint = this.f7995g.get(Integer.valueOf(id2));
                if (constraint != null) {
                    if (childAt instanceof ConstraintHelper) {
                        constraint.i((ConstraintHelper) childAt, id2, layoutParams);
                    }
                    constraint.h(id2, layoutParams);
                }
                i11++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void s(int i11, int i12, int i13, float f11) {
        Layout layout = v(i11).f8000e;
        layout.A = i12;
        layout.B = i13;
        layout.C = f11;
    }

    public final int[] t(View view, String str) {
        int i11;
        Object designInformation;
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i12 = 0;
        int i13 = 0;
        while (i12 < split.length) {
            String trim = split[i12].trim();
            try {
                i11 = R$id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i11 = 0;
            }
            if (i11 == 0) {
                i11 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i11 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i11 = ((Integer) designInformation).intValue();
            }
            iArr[i13] = i11;
            i12++;
            i13++;
        }
        return i13 != split.length ? Arrays.copyOf(iArr, i13) : iArr;
    }

    public final Constraint u(Context context, AttributeSet attributeSet, boolean z11) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z11 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        J(context, constraint, obtainStyledAttributes, z11);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public final Constraint v(int i11) {
        if (!this.f7995g.containsKey(Integer.valueOf(i11))) {
            this.f7995g.put(Integer.valueOf(i11), new Constraint());
        }
        return this.f7995g.get(Integer.valueOf(i11));
    }

    public Constraint w(int i11) {
        if (this.f7995g.containsKey(Integer.valueOf(i11))) {
            return this.f7995g.get(Integer.valueOf(i11));
        }
        return null;
    }

    public int x(int i11) {
        return v(i11).f8000e.f8025e;
    }

    public int[] y() {
        Integer[] numArr = (Integer[]) this.f7995g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
        return iArr;
    }

    public Constraint z(int i11) {
        return v(i11);
    }
}
