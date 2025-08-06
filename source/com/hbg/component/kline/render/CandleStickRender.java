package com.hbg.component.kline.render;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.constants.KLineConstants;
import com.hbg.component.kline.render.buffer.DataBuffer;
import com.hbg.component.kline.shape.BSTShape;
import com.hbg.component.kline.utils.CalculateKLineUtils;
import com.hbg.component.kline.utils.DateTimeKlineUtils;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.view.RenderView;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$styleable;
import com.hbg.module.kline.ui.MarketInfoActivity;
import com.huobi.framework.im.common.GenerateUserSig;
import com.iproov.sdk.bridge.OptionsBridge;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import s5.d;
import v5.c0;
import v5.d0;
import v5.j;
import v5.k;
import v5.l;
import v5.m;
import v5.q;
import v5.y;

public class CandleStickRender extends BaseSimpleRender implements GestureDetector.OnGestureListener, ValueAnimator.AnimatorUpdateListener {
    public static int A2 = (300 << 2);
    public static int B2 = 48;
    public static int C2 = (48 << 1);
    public static int D2 = (48 >> 1);
    public static int E2;
    public static int F2;
    public static final DataBuffer.BufferType G2 = DataBuffer.BufferType.INCLUDE_EXCLUDE;

    /* renamed from: u2  reason: collision with root package name */
    public static final String f67205u2 = CandleStickRender.class.getName();

    /* renamed from: v2  reason: collision with root package name */
    public static final int f67206v2 = DimenUtils.a(1.0f);

    /* renamed from: w2  reason: collision with root package name */
    public static final int f67207w2 = DimenUtils.a(1.0f);

    /* renamed from: x2  reason: collision with root package name */
    public static final int f67208x2 = DimenUtils.a(0.6f);

    /* renamed from: y2  reason: collision with root package name */
    public static final int f67209y2 = DimenUtils.a(0.5f);

    /* renamed from: z2  reason: collision with root package name */
    public static int f67210z2 = 300;
    public List<?> A;
    public float A0;
    public int A1 = Color.parseColor("#14395B");
    public List<?> B;
    public double B0 = -9.223372036854776E18d;
    public int B1 = Color.parseColor("#000000");
    public List<?> C;
    public double C0 = 9.223372036854776E18d;
    public int C1 = Color.parseColor("#36CFD3E9");
    public List<?> D;
    public int D0 = Integer.MIN_VALUE;
    public int D1 = Color.parseColor("#E61E1E1F");
    public boolean E;
    public int E0 = Integer.MAX_VALUE;
    public Drawable E1;
    public boolean F;
    public double F0 = -9.223372036854776E18d;
    public int F1;
    public String G;
    public double G0 = 9.223372036854776E18d;
    public int G1;
    public int H = 8;
    public double H0 = -9.223372036854776E18d;
    public int H1;
    public int I = 8;
    public boolean I0 = false;
    public int I1;
    public int J = KLineConstants.f67183a;
    public boolean J0 = false;
    public int J1 = Color.parseColor("#E6E6E6");
    public int K = KLineConstants.f67184b;
    public boolean K0 = false;
    public int K1 = Color.parseColor("#E6E6E6");
    public int L = KLineConstants.f67185c;
    public s5.a L0;
    public int L1 = Color.parseColor("#8C8C93");
    public int M = KLineConstants.f67186d;
    public s5.b M0;
    public int M1 = Color.parseColor("#5E5E61");
    public boolean N;
    public long N0 = 0;
    public int N1 = Color.parseColor("#4C4C4E");
    public Matrix O = new Matrix();
    public long O0 = 30;
    public int O1;
    public Matrix P = new Matrix();
    public List<DataSetIndex> P0 = new ArrayList();
    public Drawable P1;
    public Matrix Q = new Matrix();
    public List<DataSetIndex> Q0 = new ArrayList();
    public Drawable Q1;
    public GestureDetector R;
    public List<DataSetIndex> R0 = new ArrayList();
    public Drawable R1;
    public KLineType S;
    public List<DataSetIndex> S0 = new ArrayList();
    public KlineInfo S1;
    public boolean T = false;
    public List<DataSetIndex> T0 = new ArrayList();
    public KlineInfo T1;
    public InteractionMode U = InteractionMode.NONE;
    public List<DataSetIndex> U0 = new ArrayList();
    public KlineInfo U1;
    public ReqDataStatus V = ReqDataStatus.IDLE;
    public List<DataSetIndex> V0 = new ArrayList();
    public ValueAnimator V1;
    public d W;
    public List<DataSetIndex> W0 = new ArrayList();
    public ValueAnimator W1;
    public DragStatus X = DragStatus.NONE;
    public Map<Long, KlineFixInfo> X0;
    public float X1;
    public Fingers Y = Fingers.NONE;
    public List<KlineInfo> Y0;
    public boolean Y1 = false;
    public OverScroller Z;
    public List<HashMap<Integer, Double>> Z0 = new ArrayList();
    public Runnable Z1 = new f(this);

    /* renamed from: a0  reason: collision with root package name */
    public j f67211a0;

    /* renamed from: a1  reason: collision with root package name */
    public List<HashMap<Integer, Double>> f67212a1 = new ArrayList();

    /* renamed from: a2  reason: collision with root package name */
    public Runnable f67213a2 = new h(this);

    /* renamed from: b0  reason: collision with root package name */
    public c0 f67214b0;

    /* renamed from: b1  reason: collision with root package name */
    public List<HashMap<Integer, Double>> f67215b1 = new ArrayList();

    /* renamed from: b2  reason: collision with root package name */
    public Runnable f67216b2 = new i(this);

    /* renamed from: c0  reason: collision with root package name */
    public j f67217c0;

    /* renamed from: c1  reason: collision with root package name */
    public List<HashMap<Integer, Double>> f67218c1 = new ArrayList();

    /* renamed from: c2  reason: collision with root package name */
    public Runnable f67219c2 = new g(this);

    /* renamed from: d0  reason: collision with root package name */
    public j f67220d0;

    /* renamed from: d1  reason: collision with root package name */
    public List<HashMap<Integer, Double>> f67221d1 = new ArrayList();

    /* renamed from: d2  reason: collision with root package name */
    public Runnable f67222d2 = new k(this);

    /* renamed from: e0  reason: collision with root package name */
    public y f67223e0;

    /* renamed from: e1  reason: collision with root package name */
    public List<HashMap<String, Double>> f67224e1 = new ArrayList();

    /* renamed from: e2  reason: collision with root package name */
    public Runnable f67225e2 = new e(this);

    /* renamed from: f0  reason: collision with root package name */
    public k f67226f0;

    /* renamed from: f1  reason: collision with root package name */
    public List<Long> f67227f1;

    /* renamed from: f2  reason: collision with root package name */
    public SmartRefreshLayout f67228f2;

    /* renamed from: g0  reason: collision with root package name */
    public j f67229g0;

    /* renamed from: g1  reason: collision with root package name */
    public int[] f67230g1 = {Color.parseColor("#6D87A8"), Color.parseColor("#F6DC93"), Color.parseColor("#61D1C0"), Color.parseColor("#CB92FE"), Color.parseColor("#CB92FE"), Color.parseColor("#CB92FE"), Color.parseColor("#CB92FE"), Color.parseColor("#CB92FE"), Color.parseColor("#CB92FE")};

    /* renamed from: g2  reason: collision with root package name */
    public MotionEvent f67231g2;

    /* renamed from: h0  reason: collision with root package name */
    public RenderView f67232h0;

    /* renamed from: h1  reason: collision with root package name */
    public int f67233h1 = Color.parseColor("#131F30");

    /* renamed from: h2  reason: collision with root package name */
    public PointF f67234h2 = new PointF();

    /* renamed from: i0  reason: collision with root package name */
    public m f67235i0;

    /* renamed from: i1  reason: collision with root package name */
    public int f67236i1 = Color.parseColor("#33000000");

    /* renamed from: i2  reason: collision with root package name */
    public PointF f67237i2 = new PointF();

    /* renamed from: j0  reason: collision with root package name */
    public int f67238j0 = 0;

    /* renamed from: j1  reason: collision with root package name */
    public int f67239j1 = Color.parseColor("#3CBC6C");

    /* renamed from: j2  reason: collision with root package name */
    public KlineInfo f67240j2;

    /* renamed from: k0  reason: collision with root package name */
    public String f67241k0 = "";

    /* renamed from: k1  reason: collision with root package name */
    public int f67242k1 = Color.parseColor("#E76D42");

    /* renamed from: k2  reason: collision with root package name */
    public PointF f67243k2 = new PointF();

    /* renamed from: l  reason: collision with root package name */
    public boolean f67244l = false;

    /* renamed from: l0  reason: collision with root package name */
    public LinkedHashSet<String> f67245l0;

    /* renamed from: l1  reason: collision with root package name */
    public int f67246l1 = Color.parseColor("#333333");

    /* renamed from: l2  reason: collision with root package name */
    public Handler f67247l2 = new b();

    /* renamed from: m  reason: collision with root package name */
    public boolean f67248m = false;

    /* renamed from: m0  reason: collision with root package name */
    public float f67249m0;

    /* renamed from: m1  reason: collision with root package name */
    public int f67250m1 = Color.parseColor("#5E5E61");

    /* renamed from: m2  reason: collision with root package name */
    public MotionEvent f67251m2;

    /* renamed from: n  reason: collision with root package name */
    public int f67252n;

    /* renamed from: n0  reason: collision with root package name */
    public int f67253n0 = B2;

    /* renamed from: n1  reason: collision with root package name */
    public int f67254n1 = Color.parseColor("#FFFFFF");

    /* renamed from: n2  reason: collision with root package name */
    public MotionEvent f67255n2;

    /* renamed from: o  reason: collision with root package name */
    public int f67256o;

    /* renamed from: o1  reason: collision with root package name */
    public int f67257o1 = Color.parseColor("#CFD3E9");

    /* renamed from: o2  reason: collision with root package name */
    public boolean f67258o2 = false;

    /* renamed from: p  reason: collision with root package name */
    public int f67259p;

    /* renamed from: p1  reason: collision with root package name */
    public int f67260p1 = Color.parseColor("#CFD3E9");

    /* renamed from: p2  reason: collision with root package name */
    public String f67261p2 = "";

    /* renamed from: q  reason: collision with root package name */
    public int f67262q;

    /* renamed from: q1  reason: collision with root package name */
    public int f67263q1 = Color.parseColor("#E6081724");

    /* renamed from: q2  reason: collision with root package name */
    public long f67264q2;

    /* renamed from: r  reason: collision with root package name */
    public int f67265r;

    /* renamed from: r1  reason: collision with root package name */
    public int f67266r1 = Color.parseColor("#5E5E61");

    /* renamed from: r2  reason: collision with root package name */
    public long f67267r2;

    /* renamed from: s  reason: collision with root package name */
    public boolean f67268s;

    /* renamed from: s1  reason: collision with root package name */
    public int f67269s1 = Color.parseColor("#CFD3E9");

    /* renamed from: s2  reason: collision with root package name */
    public KLineType f67270s2;

    /* renamed from: t  reason: collision with root package name */
    public int f67271t;

    /* renamed from: t0  reason: collision with root package name */
    public int f67272t0;

    /* renamed from: t1  reason: collision with root package name */
    public int f67273t1 = Color.parseColor("#CFD3E9");

    /* renamed from: t2  reason: collision with root package name */
    public Runnable f67274t2 = new j(this);

    /* renamed from: u  reason: collision with root package name */
    public int f67275u;

    /* renamed from: u0  reason: collision with root package name */
    public int f67276u0;

    /* renamed from: u1  reason: collision with root package name */
    public int f67277u1 = Color.parseColor("#13161E");

    /* renamed from: v  reason: collision with root package name */
    public int f67278v;

    /* renamed from: v0  reason: collision with root package name */
    public int f67279v0;

    /* renamed from: v1  reason: collision with root package name */
    public int f67280v1 = Color.parseColor("#F0F1F4");

    /* renamed from: w  reason: collision with root package name */
    public List<BSTShape> f67281w;

    /* renamed from: w0  reason: collision with root package name */
    public float f67282w0;

    /* renamed from: w1  reason: collision with root package name */
    public int f67283w1 = Color.parseColor("#4B85D6");

    /* renamed from: x  reason: collision with root package name */
    public List<BSTShape> f67284x;

    /* renamed from: x0  reason: collision with root package name */
    public float f67285x0;

    /* renamed from: x1  reason: collision with root package name */
    public int f67286x1 = Color.parseColor("#4B85D6");

    /* renamed from: y  reason: collision with root package name */
    public List<BSTShape> f67287y;

    /* renamed from: y0  reason: collision with root package name */
    public float f67288y0;

    /* renamed from: y1  reason: collision with root package name */
    public int[] f67289y1 = new int[4];

    /* renamed from: z  reason: collision with root package name */
    public List<?> f67290z;

    /* renamed from: z0  reason: collision with root package name */
    public float f67291z0;

    /* renamed from: z1  reason: collision with root package name */
    public float[] f67292z1 = {0.0f, 0.18f, 0.62f, 1.0f};

    public enum DragStatus {
        NONE,
        DRAGGING,
        DRAGGED_TO_LEFT_EDGE,
        DRAGGED_TO_RIGHT_EDGE
    }

    public enum Fingers {
        NONE,
        ONE,
        TWO
    }

    public enum InteractionMode {
        NONE,
        SCALE,
        PREPARE_DRAG,
        DRAG_KLINE,
        DRAG_HIGH_LIGHT,
        TOUCH_HIGH_LIGHT,
        LONG_PRESS,
        SHOT_CLICK,
        ACTION_DOWN;

        public boolean interceptEvent() {
            return this == DRAG_KLINE || this == LONG_PRESS || this == DRAG_HIGH_LIGHT;
        }

        public boolean isHighLight() {
            return this == DRAG_HIGH_LIGHT || this == TOUCH_HIGH_LIGHT;
        }
    }

    public enum KLineType {
        MIN_1("1min"),
        MIN_5("5min"),
        MIN_15("15min"),
        MIN_30("30min"),
        MIN_60("60min"),
        HOUR_4("4hour"),
        DAY_1("1day"),
        WEEK_1("1week"),
        MON_1("1mon"),
        TIME_LINE("tl"),
        EXPAND_TIME_LINE("expand_tl");
        
        public String value;

        private KLineType(String str) {
            this.value = str;
        }

        public static long getKlineTimePerUnit(KLineType kLineType) {
            switch (a.f67293a[kLineType.ordinal()]) {
                case 1:
                case 2:
                    return 60;
                case 3:
                    return 300;
                case 4:
                    return 900;
                case 5:
                case 6:
                    return 1800;
                case 7:
                    return 3600;
                case 8:
                    return 14400;
                case 9:
                    return 86400;
                case 10:
                    return GenerateUserSig.EXPIRETIME;
                case 11:
                    return 2592000;
                default:
                    return 0;
            }
        }

        public static boolean isTimeLine(KLineType kLineType) {
            return kLineType == TIME_LINE || kLineType == EXPAND_TIME_LINE;
        }

        public static KLineType parse(String str) {
            KLineType kLineType = MIN_1;
            if (kLineType.value.equalsIgnoreCase(str)) {
                return kLineType;
            }
            KLineType kLineType2 = MIN_5;
            if (kLineType2.value.equalsIgnoreCase(str)) {
                return kLineType2;
            }
            KLineType kLineType3 = MIN_15;
            if (kLineType3.value.equalsIgnoreCase(str)) {
                return kLineType3;
            }
            KLineType kLineType4 = MIN_30;
            if (kLineType4.value.equalsIgnoreCase(str)) {
                return kLineType4;
            }
            KLineType kLineType5 = MIN_60;
            if (kLineType5.value.equalsIgnoreCase(str)) {
                return kLineType5;
            }
            KLineType kLineType6 = HOUR_4;
            if (kLineType6.value.equalsIgnoreCase(str)) {
                return kLineType6;
            }
            KLineType kLineType7 = DAY_1;
            if (kLineType7.value.equalsIgnoreCase(str)) {
                return kLineType7;
            }
            KLineType kLineType8 = WEEK_1;
            if (kLineType8.value.equalsIgnoreCase(str)) {
                return kLineType8;
            }
            KLineType kLineType9 = MON_1;
            if (kLineType9.value.equalsIgnoreCase(str)) {
                return kLineType9;
            }
            KLineType kLineType10 = TIME_LINE;
            if (kLineType10.value.equalsIgnoreCase(str)) {
                return kLineType10;
            }
            KLineType kLineType11 = EXPAND_TIME_LINE;
            return kLineType11.value.equalsIgnoreCase(str) ? kLineType11 : kLineType10;
        }
    }

    public enum ReqDataStatus {
        IDLE,
        LOADING,
        NO_MORE_DATA
    }

    public static class SlaveChartIndex {
        public static boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.equals("VOL") || str.equals("MACD") || str.equals("KDJ") || str.equals("RSI") || str.equals("WR"));
        }

        public static LinkedHashSet<String> b(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null) {
                return new LinkedHashSet<>();
            }
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            for (int i11 = 0; i11 < split.length; i11++) {
                if (a(split[i11])) {
                    linkedHashSet.add(split[i11]);
                }
            }
            return linkedHashSet;
        }

        public static String c(LinkedHashSet<String> linkedHashSet) {
            if (linkedHashSet == null || linkedHashSet.size() == 0) {
                return "";
            }
            Iterator it2 = linkedHashSet.iterator();
            if (!it2.hasNext()) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                sb2.append((String) it2.next());
                if (!it2.hasNext()) {
                    return sb2.toString();
                }
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67293a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.component.kline.render.CandleStickRender$KLineType[] r0 = com.hbg.component.kline.render.CandleStickRender.KLineType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f67293a = r0
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.TIME_LINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_5     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_15     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_30     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.EXPAND_TIME_LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_60     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.HOUR_4     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.DAY_1     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.WEEK_1     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f67293a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MON_1     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.component.kline.render.CandleStickRender.a.<clinit>():void");
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            if (message.what == 200) {
                CandleStickRender candleStickRender = CandleStickRender.this;
                candleStickRender.onLongPress(candleStickRender.f67231g2);
            }
        }
    }

    static {
        int i11 = 48 << 1;
        E2 = i11;
        F2 = i11 << 2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O3(int i11, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            CalculateKLineUtils.n(this.Y0, this.f67215b1, dataSetIndex.d());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P3(int i11, DataSetIndex dataSetIndex) {
        if (dataSetIndex.d() > 0) {
            CalculateKLineUtils.q(this.Y0, this.f67218c1, dataSetIndex.d());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q3() {
        ValueAnimator valueAnimator;
        if (this.S1 != null && this.U1 != null && (valueAnimator = this.V1) != null) {
            if (valueAnimator.isRunning()) {
                this.V1.cancel();
            }
            this.V1.start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R3() {
        ValueAnimator valueAnimator = this.W1;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.W1.cancel();
            }
            this.X1 = 0.0f;
            this.W1.start();
            return;
        }
        this.X1 = this.f67282w0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S3() {
        if (this.f67258o2) {
            Y();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T3() {
        this.Y1 = !B3();
        if (B3()) {
            this.f67214b0.n();
            this.f67217c0.n();
            this.f67211a0.n();
            this.f67223e0.n();
            this.f67220d0.n();
            if (this.I0) {
                this.f67235i0.n();
            }
            this.f67226f0.n();
            LinkedHashSet<String> linkedHashSet = this.f67245l0;
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                try {
                    Q();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            T();
            m();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U3() {
        if (B3()) {
            if (this.f67238j0 != 0) {
                Q();
            }
            T();
            m();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V3() {
        if (!this.Z.isFinished()) {
            this.Z.abortAnimation();
        }
        if (KLineType.isTimeLine(this.S)) {
            this.f67229g0 = this.f67217c0;
        } else {
            this.f67229g0 = this.f67214b0;
        }
        j4();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X3(MotionEvent motionEvent) {
        if (!this.Z.isFinished()) {
            this.Z.abortAnimation();
        }
        int h11 = h() - this.f67204i;
        T4(InteractionMode.NONE, 1);
        this.f67223e0.Y0((KlineInfo) null, true);
        s5.a aVar = this.L0;
        if (aVar != null) {
            aVar.a((KlineInfo) null, false);
        }
        l0(h11 * 3, 0, k());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y3(List list) {
        boolean z11 = false;
        if (B3() && !UtilCollections.f(list)) {
            List<KlineInfo> list2 = this.Y0;
            if (list2.get(list2.size() - 1).getTimeMs() < ((KlineInfo) list.get(0)).getTimeMs()) {
                j4();
            } else {
                z11 = true;
            }
        }
        if (!UtilCollections.f(list)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                L((KlineInfo) it2.next());
            }
            l4();
            if (z11) {
                this.f67225e2.run();
            } else {
                i4(this.f67225e2, 10);
            }
        }
        this.V = ReqDataStatus.IDLE;
        if (this.f67232h0.getContext() instanceof MarketInfoActivity) {
            BaseModuleConfig.a().z("huobiapp_market_kline_end", "huobiapp_market_kline_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z3(List list) {
        if (!UtilCollections.f(list)) {
            int i11 = this.f67204i;
            for (int size = list.size() - 1; size >= 0; size--) {
                this.Y0.add(0, (KlineInfo) list.get(size));
                this.f67227f1.add(0, Long.valueOf(((KlineInfo) list.get(size)).getId()));
                v3(0, 1);
            }
            this.f67204i = (int) (((float) i11) + (((float) list.size()) * this.f67282w0));
            N();
            this.f67225e2.run();
        }
        this.V = ReqDataStatus.IDLE;
    }

    public int A0() {
        return this.H1;
    }

    public List<Long> A1() {
        return this.f67227f1;
    }

    public int A2() {
        return this.f67256o;
    }

    public boolean A3() {
        return this.f67248m;
    }

    public void A4(int i11) {
        if (this.f67238j0 != i11) {
            i4(this.f67219c2, 10);
        }
        this.f67238j0 = i11;
    }

    public int B0() {
        return this.I1;
    }

    public float B1() {
        return this.f67249m0;
    }

    public int B2() {
        return this.f67259p;
    }

    public boolean B3() {
        return !UtilCollections.f(this.Y0);
    }

    public synchronized void B4(List<? extends KlineInfo> list) {
        v(new l(this, list));
    }

    public float C0() {
        return this.f67282w0;
    }

    public List<?> C1() {
        return this.C;
    }

    public int C2() {
        return this.f67279v0;
    }

    public boolean C3() {
        return this.I0;
    }

    public void C4(d dVar) {
        this.W = dVar;
    }

    public float D0() {
        return this.f67285x0;
    }

    public List<?> D1() {
        return this.D;
    }

    public int D2() {
        return this.f67272t0;
    }

    public final boolean D3(PointF pointF, PointF pointF2) {
        return pointF2.x - pointF.x < 0.0f;
    }

    public void D4(q5.b bVar) {
        m mVar = this.f67235i0;
        if (mVar != null) {
            mVar.Y0(bVar);
        }
    }

    public float E0() {
        return this.f67291z0;
    }

    public int E1() {
        return this.f67280v1;
    }

    public int E2() {
        return this.f67276u0;
    }

    public boolean E3() {
        return this.J0;
    }

    public void E4(int i11) {
        this.H = i11;
    }

    public float F0() {
        return this.f67288y0;
    }

    public int F1() {
        return this.f67277u1;
    }

    public d F2() {
        return this.W;
    }

    public boolean F3() {
        return this.K0;
    }

    public void F4(RenderView renderView) {
        this.f67232h0 = renderView;
    }

    public float G0() {
        return this.A0;
    }

    public int G1() {
        return this.f67273t1;
    }

    public int G2() {
        return this.f67271t;
    }

    public boolean G3() {
        return this.E;
    }

    public void G4(String str) {
        if (!TextUtils.equals(this.f67241k0, str)) {
            i4(this.f67216b2, 10);
            RenderView renderView = this.f67232h0;
            if (renderView != null) {
                renderView.requestLayout();
            }
        }
        this.f67241k0 = str;
    }

    public final float H0(MotionEvent motionEvent) {
        return (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
    }

    public int H1() {
        return this.f67269s1;
    }

    public int H2() {
        return this.f67275u;
    }

    public boolean H3() {
        return this.T;
    }

    public void H4(LinkedHashSet<String> linkedHashSet) {
        i4(this.f67216b2, 10);
        this.f67245l0 = linkedHashSet;
    }

    public int I0() {
        return this.f67266r1;
    }

    public s5.a I1() {
        return this.L0;
    }

    public List<?> I2() {
        return this.B;
    }

    public final boolean I3(MotionEvent motionEvent) {
        return this.f67211a0.J().contains(motionEvent.getX(), motionEvent.getY());
    }

    public void I4(String str) {
        this.G = str;
    }

    public int J0() {
        return this.f67242k1;
    }

    public s5.b J1() {
        return this.M0;
    }

    public List<?> J2() {
        return this.f67290z;
    }

    public boolean J3() {
        return this.N;
    }

    public void J4(int i11) {
        this.I = i11;
    }

    public int K0() {
        return this.f67246l1;
    }

    public int[] K1() {
        return this.f67230g1;
    }

    public MotionEvent K2() {
        return this.f67251m2;
    }

    public boolean K3() {
        return this.Y1;
    }

    public boolean K4() {
        return B3() && this.f67276u0 == this.Y0.size() - 1;
    }

    public final synchronized boolean L(KlineInfo klineInfo) {
        boolean z11;
        z11 = false;
        if (klineInfo != null) {
            if (UtilCollections.f(this.Y0)) {
                this.Y0 = Collections.synchronizedList(new LinkedList());
                this.f67227f1 = Collections.synchronizedList(new LinkedList());
            }
            if (!this.f67227f1.contains(Long.valueOf(klineInfo.getId()))) {
                int L12 = L1(klineInfo);
                this.Y0.add(L12, klineInfo);
                O4(L12, klineInfo.getId());
                v3(L12, 1);
                z11 = true;
            } else {
                int indexOf = this.f67227f1.indexOf(Long.valueOf(klineInfo.getId()));
                this.Y0.remove(indexOf);
                this.Y0.add(indexOf, klineInfo);
            }
        }
        return z11;
    }

    public int L0() {
        return this.f67260p1;
    }

    public final int L1(KlineInfo klineInfo) {
        KlineInfo V12 = V1();
        KlineInfo t12 = t1();
        if (V12 == null || t12 == null || t12.getTimeMs() > klineInfo.getTimeMs()) {
            return 0;
        }
        if (V12.getTimeMs() < klineInfo.getTimeMs()) {
            return this.Y0.size();
        }
        int size = this.Y0.size();
        while (true) {
            size--;
            if (size <= 0) {
                size = -1;
                break;
            }
            KlineInfo klineInfo2 = this.Y0.get(size);
            if (this.Y0.get(size - 1).getTimeMs() < klineInfo.getTimeMs() && klineInfo2.getTimeMs() > klineInfo.getTimeMs()) {
                break;
            }
        }
        return size == -1 ? this.Y0.size() : size;
    }

    public ValueAnimator L2() {
        return this.V1;
    }

    public boolean L3() {
        return this.f67258o2;
    }

    public final boolean L4(MotionEvent motionEvent, boolean z11) {
        boolean z12 = false;
        if (!B3()) {
            return false;
        }
        if (KLineType.isTimeLine(this.S)) {
            this.f67279v0 = g0(((int) motionEvent.getX()) + this.f67204i, true);
        } else {
            this.f67279v0 = g0(((int) motionEvent.getX()) + this.f67204i, false);
        }
        int i11 = this.f67272t0;
        int i12 = this.f67279v0;
        if (i11 > i12 || i12 > this.f67276u0) {
            return false;
        }
        if (z11) {
            T4(InteractionMode.DRAG_HIGH_LIGHT, 5);
        } else {
            T4(InteractionMode.TOUCH_HIGH_LIGHT, 6);
        }
        KlineInfo klineInfo = this.Y0.get(this.f67279v0);
        if (j0(this.f67279v0) < this.f67202g / 2) {
            z12 = true;
        }
        this.f67243k2.set(motionEvent.getX(), motionEvent.getY());
        this.f67223e0.U0(this.U, this.f67243k2);
        this.f67223e0.Y0(klineInfo, z12);
        s5.a aVar = this.L0;
        if (aVar != null) {
            aVar.a(klineInfo, true);
        }
        KlineInfo klineInfo2 = this.f67240j2;
        if (klineInfo2 == null || klineInfo2.getId() != klineInfo.getId()) {
            if (!KLineType.isTimeLine(this.S)) {
                VibrateManager.a(this.f67232h0);
            } else if (motionEvent.getAction() != 2) {
                VibrateManager.a(this.f67232h0);
            }
        }
        this.f67240j2 = klineInfo;
        m();
        return true;
    }

    public synchronized void M(KlineInfo klineInfo) {
        KlineInfo klineInfo2;
        if (!UtilCollections.f(this.Y0)) {
            if (this.W1 != null) {
                List<KlineInfo> list = this.Y0;
                KlineInfo klineInfo3 = list.get(list.size() - 1);
                if (klineInfo.getId() < klineInfo3.getId()) {
                    L(klineInfo);
                    return;
                }
                this.S1 = klineInfo3;
                boolean L2 = L(klineInfo);
                if (L2) {
                    this.f67213a2.run();
                }
                P(M4());
                if (L2 && (klineInfo2 = this.U1) != null) {
                    Q4(klineInfo2);
                }
                List<KlineInfo> list2 = this.Y0;
                this.U1 = list2.get(list2.size() - 1);
                if (this.S1.getId() != this.U1.getId()) {
                    double close = this.S1.getClose();
                    KlineInfo clone = this.U1.clone();
                    this.S1 = clone;
                    clone.setId(this.U1.getId());
                    this.S1.setClose(close);
                }
                this.Z1.run();
                return;
            }
        }
        L(klineInfo);
        this.f67225e2.run();
    }

    public int M0() {
        return this.f67257o1;
    }

    public InteractionMode M1() {
        return this.U;
    }

    public Double M2(int i11, int i12) {
        if (UtilCollections.h(this.Y0, i11)) {
            return (Double) this.Z0.get(i11).get(Integer.valueOf(i12));
        }
        return null;
    }

    public final boolean M3(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent == null || motionEvent2 == null || Math.abs(motionEvent.getX() - motionEvent2.getX()) >= Math.abs(motionEvent.getY() - motionEvent2.getY())) ? false : true;
    }

    public boolean M4() {
        return O() == this.f67204i;
    }

    public final boolean N() {
        int i11 = this.f67204i;
        int i12 = i() + i11;
        int i13 = this.f67272t0;
        int i14 = this.f67276u0;
        this.f67272t0 = g0(i11, false);
        this.f67276u0 = g0(i12, true);
        this.f67272t0 = Math.max(0, this.f67272t0 - 1);
        this.f67276u0 = Math.min(this.Y0.size() - 1, this.f67276u0 + 1);
        this.f67226f0.B0();
        if (i13 == this.f67272t0 && i14 == this.f67276u0) {
            return false;
        }
        return true;
    }

    public int N0() {
        return this.f67263q1;
    }

    public KLineType N1() {
        return this.S;
    }

    public List<HashMap<Integer, Double>> N2() {
        return this.Z0;
    }

    /* renamed from: N3 */
    public final void W3() {
        if (B3()) {
            if (this.f67282w0 == 0.0f) {
                R();
            }
            if (!(this.T || this.f67202g == 0 || this.f67201f == 0)) {
                S();
            }
            if (this.T) {
                Q();
                T();
            }
        }
    }

    public void N4(boolean z11) {
        this.K0 = z11;
        m mVar = this.f67235i0;
        if (mVar != null && this.I0) {
            mVar.a1(z11);
        }
    }

    public final int O() {
        return k() + this.f67278v;
    }

    public int O0() {
        return this.f67250m1;
    }

    public List<HashMap<String, Double>> O1() {
        return this.f67224e1;
    }

    public int O2(int i11) {
        for (DataSetIndex next : this.P0) {
            if (next.d() == i11) {
                return next.b();
            }
        }
        return 0;
    }

    public final void O4(int i11, long j11) {
        this.f67227f1.add(i11, Long.valueOf(j11));
    }

    public final void P(boolean z11) {
        if (z11) {
            l4();
        } else {
            N();
        }
    }

    public int P0() {
        return this.f67254n1;
    }

    public List<DataSetIndex> P1() {
        return this.U0;
    }

    public List<DataSetIndex> P2() {
        return this.P0;
    }

    public final boolean P4(MotionEvent motionEvent) {
        this.N0 = System.currentTimeMillis();
        T4(InteractionMode.SCALE, 7);
        if (this.f67251m2 == null) {
            this.f67251m2 = MotionEvent.obtain(motionEvent);
        } else {
            this.f67255n2 = MotionEvent.obtain(motionEvent);
            float H02 = H0(motionEvent);
            float f02 = f0(((float) this.f67204i) + H02);
            float x11 = (((float) this.f67204i) + this.f67251m2.getX(0)) - (((float) this.f67204i) + this.f67251m2.getX(1));
            float x12 = (((float) this.f67204i) + this.f67255n2.getX(0)) - (((float) this.f67204i) + this.f67255n2.getX(1));
            float f11 = this.f67282w0;
            float f12 = (x12 / x11) * f11;
            this.f67282w0 = f12;
            float max = Math.max(this.f67288y0, Math.min(f12, this.f67291z0));
            this.f67282w0 = max;
            int i11 = (int) ((((float) this.f67271t) + (max * f02)) - H02);
            this.f67204i = i11;
            this.f67204i = Math.max(0, Math.min(i11, k()));
            float f13 = this.f67282w0;
            if (f11 != f13) {
                if (f11 == this.X1) {
                    this.X1 = f13;
                }
                g4();
            }
            this.f67251m2 = this.f67255n2;
        }
        return true;
    }

    public final void Q() {
        if (!KLineType.isTimeLine(this.S)) {
            if ((this.f67238j0 & 1) == 1 && !UtilCollections.f(this.P0)) {
                for (DataSetIndex d11 : this.P0) {
                    CalculateKLineUtils.k(this.Y0, this.Z0, d11.d(), true, false);
                }
            }
            if ((this.f67238j0 & 2) == 2 && !UtilCollections.f(this.Q0)) {
                for (DataSetIndex d12 : this.Q0) {
                    CalculateKLineUtils.h(this.Y0, this.f67212a1, d12.d());
                }
            }
            if ((this.f67238j0 & 4) == 4 && !UtilCollections.f(this.S0)) {
                CalculateKLineUtils.c(this.Y0, this.S0.get(0).d(), this.S0.get(1).d());
            }
        }
        LinkedHashSet<String> linkedHashSet = this.f67245l0;
        if (linkedHashSet != null && linkedHashSet.contains("KDJ") && !UtilCollections.f(this.U0)) {
            CalculateKLineUtils.j(this.Y0, this.f67224e1, this.U0.get(0), this.U0.get(1), this.U0.get(2));
        }
        LinkedHashSet<String> linkedHashSet2 = this.f67245l0;
        if (linkedHashSet2 != null && linkedHashSet2.contains("WR") && !UtilCollections.f(this.W0)) {
            UtilCollections.c(this.W0, new a(this));
        }
        LinkedHashSet<String> linkedHashSet3 = this.f67245l0;
        if (linkedHashSet3 != null && linkedHashSet3.contains("RSI") && !UtilCollections.f(this.V0)) {
            UtilCollections.c(this.V0, new d(this));
        }
        LinkedHashSet<String> linkedHashSet4 = this.f67245l0;
        if (linkedHashSet4 != null && linkedHashSet4.contains("MACD") && !UtilCollections.f(this.T0)) {
            CalculateKLineUtils.l(this.Y0, this.T0.get(0).d(), this.T0.get(1).d(), this.T0.get(2).d());
        }
        if (!KLineType.isTimeLine(this.S)) {
            CalculateKLineUtils.k(this.Y0, this.f67221d1, 5, false, V4());
            CalculateKLineUtils.k(this.Y0, this.f67221d1, 10, false, V4());
        }
    }

    public int Q0() {
        return this.f67239j1;
    }

    public Runnable Q1() {
        return this.f67225e2;
    }

    public int Q2() {
        return this.H;
    }

    public final void Q4(KlineInfo klineInfo) {
        L(klineInfo);
        this.f67225e2.run();
    }

    public void R() {
        if (KLineType.isTimeLine(this.S)) {
            this.f67285x0 = (float) (this.f67202g / (j1() - 1));
        } else {
            this.f67285x0 = (float) ((this.f67202g / i1()) + f67206v2);
        }
        float f11 = this.f67285x0;
        this.f67282w0 = f11;
        this.X1 = f11;
        int i11 = this.f67202g;
        int i12 = f67206v2;
        this.f67288y0 = (float) ((i11 / this.f67256o) + i12);
        this.f67291z0 = (float) ((i11 / this.f67259p) + i12);
    }

    public int R0() {
        return this.f67283w1;
    }

    public Runnable R1() {
        return this.f67222d2;
    }

    public int R2() {
        return this.K1;
    }

    public final void R4(float f11) {
        boolean M4 = M4();
        float f12 = this.f67282w0;
        this.X1 = Math.max(0.0f, Math.min(f12, f11 * f12));
        if (M4) {
            P(true);
        }
    }

    public final synchronized void S() {
        if (B3()) {
            l4();
            this.T = true;
        }
    }

    public int[] S0() {
        return this.f67289y1;
    }

    public long S1() {
        return this.f67267r2;
    }

    public RenderView S2() {
        return this.f67232h0;
    }

    public void S4(Map<Long, KlineFixInfo> map) {
        this.X0 = map;
        if (B3()) {
            T();
            m();
        }
    }

    public final void T() {
        double d11;
        if (B3()) {
            k4();
            int i11 = this.f67272t0;
            int i12 = this.f67276u0;
            if ((this.f67238j0 & 1) == 1) {
                double[] v11 = CalculateKLineUtils.v(this.Y0, this.Z0, i11, i12, this.X0);
                this.B0 = Math.max(v11[0], this.B0);
                this.C0 = Math.min(v11[1], this.C0);
            }
            if ((this.f67238j0 & 2) == 2) {
                double[] v12 = CalculateKLineUtils.v(this.Y0, this.f67212a1, i11, i12, this.X0);
                this.B0 = Math.max(v12[0], this.B0);
                this.C0 = Math.min(v12[1], this.C0);
            }
            if ((this.f67238j0 & 4) == 4) {
                double[] B3 = CalculateKLineUtils.B(this.Y0, i11, i12, this.X0);
                this.B0 = Math.max(B3[0], this.B0);
                this.C0 = Math.min(B3[1], this.C0);
            }
            if (this.f67238j0 == 0) {
                double[] v13 = CalculateKLineUtils.v(this.Y0, (List<HashMap<Integer, Double>>) null, i11, i12, this.X0);
                this.B0 = Math.max(v13[0], this.B0);
                this.C0 = Math.min(v13[1], this.C0);
            }
            int[] w11 = CalculateKLineUtils.w(this.Y0, Y2(), Z2());
            this.D0 = w11[0];
            this.E0 = w11[1];
            double[] x11 = CalculateKLineUtils.x(this.Y0, this.f67221d1, i11, i12, V4());
            this.H0 = CalculateKLineUtils.u(this.Y0, i11, i12, V4());
            this.F0 = x11[0];
            this.G0 = 0.0d;
            if (this.B0 - this.C0 < Double.parseDouble("1E-" + this.H)) {
                d11 = this.C0;
            } else {
                d11 = Math.abs(this.C0 - this.B0);
            }
            double d12 = d11 * 0.02d;
            this.B0 += d12;
            this.C0 -= d12;
            this.F0 = Math.max(0.0d, this.F0);
            this.H0 = Math.max(0.0d, this.H0);
            c4();
        }
    }

    public float[] T0() {
        return this.f67292z1;
    }

    public float T1() {
        return this.X1;
    }

    public ReqDataStatus T2() {
        return this.V;
    }

    public final void T4(InteractionMode interactionMode, int i11) {
        this.U = interactionMode;
    }

    public boolean U(Object obj) {
        return obj instanceof CandleStickRender;
    }

    public int U0() {
        return this.f67286x1;
    }

    public KLineType U1() {
        return this.f67270s2;
    }

    public List<HashMap<Integer, Double>> U2() {
        return this.f67215b1;
    }

    public final void U4(float f11) {
        KlineInfo klineInfo;
        if (this.S1 != null && (klineInfo = this.U1) != null && this.V1 != null) {
            this.T1 = klineInfo.clone();
            double close = this.U1.getClose() - this.S1.getClose();
            double high = this.U1.getHigh() - this.S1.getHigh();
            double low = this.U1.getLow() - this.S1.getLow();
            double vol = this.U1.getVol() - this.S1.getVol();
            double amount = this.U1.getAmount() - this.S1.getAmount();
            double d11 = (double) f11;
            double close2 = this.S1.getClose() + (close * d11);
            double high2 = this.S1.getHigh() + (high * d11);
            double low2 = this.S1.getLow() + (low * d11);
            double vol2 = this.S1.getVol() + (vol * d11);
            this.T1.setClose(close2);
            this.T1.setHigh(high2);
            this.T1.setLow(low2);
            this.T1.setVol(vol2);
            this.T1.setAmount(this.S1.getAmount() + (amount * d11));
            Q4(this.T1);
        }
    }

    public void V(boolean z11) {
        m mVar;
        this.J0 = z11;
        u3();
        if (!z11 && (mVar = this.f67235i0) != null && this.I0) {
            mVar.J0();
        }
    }

    public int V0() {
        return this.A1;
    }

    public KlineInfo V1() {
        if (UtilCollections.f(this.Y0)) {
            return null;
        }
        List<KlineInfo> list = this.Y0;
        return list.get(list.size() - 1);
    }

    public List<DataSetIndex> V2() {
        return this.V0;
    }

    public boolean V4() {
        return A3() && !y3();
    }

    public boolean W() {
        int size;
        if (z1() == null || z1().size() == 0 || i2() > (size = z1().size() - 1) || k2() > size || z1().get(i2()).getHigh() == z1().get(k2()).getLow()) {
            return false;
        }
        return true;
    }

    public int W0() {
        return this.J1;
    }

    public long W1() {
        return this.N0;
    }

    public List<BSTShape> W2() {
        return this.f67284x;
    }

    public void X() {
        m mVar = this.f67235i0;
        if (mVar != null && this.I0) {
            mVar.D0();
        }
    }

    public List<?> X0() {
        return this.A;
    }

    public k X1() {
        return this.f67226f0;
    }

    public long X2() {
        return this.O0;
    }

    public final void Y() {
        s(this.f67274t2);
        if (V1() != null) {
            long id2 = V1().getId() * 1000;
            if (this.f67267r2 == id2 && this.f67270s2 == N1()) {
                long j11 = this.f67264q2 - 1000;
                this.f67264q2 = j11;
                if (j11 < 0) {
                    this.f67264q2 = 0;
                }
            } else {
                this.f67267r2 = id2;
                this.f67270s2 = N1();
                this.f67264q2 = DateTimeKlineUtils.a(N1(), id2, System.currentTimeMillis());
            }
            String c11 = DateTimeKlineUtils.c(N1(), this.f67264q2);
            if (!c11.equals(this.f67261p2)) {
                this.f67261p2 = c11;
                this.f67226f0.F();
                m();
            }
            i4(this.f67274t2, 1000);
        }
    }

    public List<?> Y0() {
        return this.B;
    }

    public j Y1() {
        return this.f67220d0;
    }

    public int Y2() {
        for (int i11 = this.f67272t0; i11 <= this.f67276u0; i11++) {
            if (i0(i11) > 0) {
                return i11;
            }
        }
        return this.f67272t0;
    }

    public void Z(boolean z11) {
        this.f67258o2 = z11;
        if (z11) {
            p(this.f67274t2);
            return;
        }
        this.f67226f0.F();
        m();
        s(this.f67274t2);
    }

    public List<?> Z0() {
        return this.f67290z;
    }

    public m Z1() {
        return this.f67235i0;
    }

    public int Z2() {
        for (int i11 = this.f67276u0; i11 >= this.f67272t0; i11--) {
            if (i0(i11) < this.f67202g) {
                return i11;
            }
        }
        return this.f67276u0;
    }

    public void a(Canvas canvas) {
        super.a(canvas);
        this.f67211a0.y(canvas);
        if (B3()) {
            this.f67229g0.y(canvas);
            this.f67220d0.y(canvas);
            if (this.I0) {
                this.f67235i0.a(canvas);
            }
            if (!this.J0) {
                this.f67226f0.y(canvas);
            }
            this.f67223e0.y(canvas);
        }
    }

    public j a0() {
        return new l(this, this.f67200e);
    }

    public String a1() {
        return this.f67261p2;
    }

    public j a2() {
        return this.f67211a0;
    }

    public int a3() {
        return this.L1;
    }

    public final void a4() {
        d dVar;
        if (this.V == ReqDataStatus.IDLE && this.Y0.size() < 1000 && (dVar = this.W) != null) {
            dVar.c();
            this.V = ReqDataStatus.LOADING;
        }
    }

    public boolean b(MotionEvent motionEvent) {
        boolean z11;
        if (!B3()) {
            return false;
        }
        if (this.I0) {
            if (this.K0) {
                t(true);
                this.f67235i0.b(motionEvent);
                return true;
            } else if (this.J0 && this.f67235i0.b(motionEvent)) {
                t(true);
                return true;
            }
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            this.Y = Fingers.ONE;
            z11 = h4(motionEvent);
        } else if (pointerCount == 2 && !this.J0) {
            this.Y = Fingers.TWO;
            z11 = P4(motionEvent);
        } else {
            z11 = false;
        }
        if (!this.J0 && this.U == InteractionMode.DRAG_HIGH_LIGHT && motionEvent.getAction() == 2) {
            z11 = L4(motionEvent, true);
        }
        if ((this.Y == Fingers.TWO && z11) || this.U.interceptEvent()) {
            t(z11 || this.U.interceptEvent());
        }
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (!this.U.isHighLight()) {
                T4(InteractionMode.NONE, 3);
            }
            t(false);
            this.f67251m2 = null;
        }
        return z11;
    }

    public j b0() {
        return new q(this, this.f67200e);
    }

    public Runnable b1() {
        return this.f67274t2;
    }

    public y b2() {
        return this.f67223e0;
    }

    public PointF b3() {
        return this.f67237i2;
    }

    public boolean b4(boolean z11) {
        m mVar = this.f67235i0;
        if (mVar == null || !this.I0) {
            return false;
        }
        return mVar.Q0(z11);
    }

    public j c0() {
        return new d0(this, this.f67200e);
    }

    public long c1() {
        return this.f67264q2;
    }

    public c0 c2() {
        return this.f67214b0;
    }

    public PointF c3() {
        return this.f67234h2;
    }

    public final void c4() {
        this.f67229g0.F();
        this.f67223e0.F();
        this.f67220d0.F();
        if (this.I0) {
            this.f67235i0.F();
        }
        this.f67226f0.F();
        if (this.Y1) {
            this.Y1 = false;
            i4(this.f67216b2, 10);
        }
        q();
    }

    public boolean d0() {
        m mVar = this.f67235i0;
        if (mVar == null || !this.I0) {
            return false;
        }
        return mVar.F0();
    }

    public int d1() {
        return this.f67253n0;
    }

    public j d2() {
        return this.f67217c0;
    }

    public String d3() {
        return this.f67241k0;
    }

    public void d4() {
        m mVar = this.f67235i0;
        if (mVar != null && this.I0) {
            mVar.R0();
        }
    }

    public final void e0(boolean z11, boolean z12) {
        if (h() > i()) {
            boolean z13 = true;
            boolean z14 = !z11 && this.f67204i == 0;
            if (!z11 || this.f67204i != k()) {
                z13 = false;
            }
            if (z14 || z13) {
                if (!z12) {
                    if (z11) {
                        this.X = DragStatus.DRAGGED_TO_RIGHT_EDGE;
                    } else {
                        this.X = DragStatus.DRAGGED_TO_LEFT_EDGE;
                    }
                }
            } else if (N()) {
                T();
            } else {
                c4();
            }
            if (this.f67272t0 < 10) {
                a4();
            }
            s5.b bVar = this.M0;
            if (bVar != null) {
                bVar.a(this.f67272t0, this.f67276u0, this.Y0);
            }
        }
    }

    public MotionEvent e1() {
        return this.f67255n2;
    }

    public List<?> e2() {
        return this.A;
    }

    public LinkedHashSet<String> e3() {
        return this.f67245l0;
    }

    public void e4(List<?> list, int i11) {
        if (i11 == 2) {
            this.f67290z = list;
        } else if (i11 == 0) {
            this.A = list;
        }
        if (i11 == 1) {
            this.B = list;
        }
        q();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CandleStickRender)) {
            return false;
        }
        CandleStickRender candleStickRender = (CandleStickRender) obj;
        if (!candleStickRender.U(this) || y3() != candleStickRender.y3() || A3() != candleStickRender.A3() || z2() != candleStickRender.z2() || A2() != candleStickRender.A2() || B2() != candleStickRender.B2() || i1() != candleStickRender.i1() || j1() != candleStickRender.j1() || x3() != candleStickRender.x3() || G2() != candleStickRender.G2() || H2() != candleStickRender.H2() || s1() != candleStickRender.s1()) {
            return false;
        }
        List<BSTShape> r02 = r0();
        List<BSTShape> r03 = candleStickRender.r0();
        if (r02 != null ? !r02.equals(r03) : r03 != null) {
            return false;
        }
        List<BSTShape> W2 = W2();
        List<BSTShape> W22 = candleStickRender.W2();
        if (W2 != null ? !W2.equals(W22) : W22 != null) {
            return false;
        }
        List<BSTShape> j32 = j3();
        List<BSTShape> j33 = candleStickRender.j3();
        if (j32 != null ? !j32.equals(j33) : j33 != null) {
            return false;
        }
        List<?> J2 = J2();
        List<?> J22 = candleStickRender.J2();
        if (J2 != null ? !J2.equals(J22) : J22 != null) {
            return false;
        }
        List<?> e22 = e2();
        List<?> e23 = candleStickRender.e2();
        if (e22 != null ? !e22.equals(e23) : e23 != null) {
            return false;
        }
        List<?> I2 = I2();
        List<?> I22 = candleStickRender.I2();
        if (I2 != null ? !I2.equals(I22) : I22 != null) {
            return false;
        }
        List<?> C12 = C1();
        List<?> C13 = candleStickRender.C1();
        if (C12 != null ? !C12.equals(C13) : C13 != null) {
            return false;
        }
        List<?> D12 = D1();
        List<?> D13 = candleStickRender.D1();
        if (D12 != null ? !D12.equals(D13) : D13 != null) {
            return false;
        }
        if (G3() != candleStickRender.G3() || z3() != candleStickRender.z3()) {
            return false;
        }
        String i32 = i3();
        String i33 = candleStickRender.i3();
        if (i32 != null ? !i32.equals(i33) : i33 != null) {
            return false;
        }
        if (Q2() != candleStickRender.Q2() || p3() != candleStickRender.p3() || o0() != candleStickRender.o0() || p0() != candleStickRender.p0() || q0() != candleStickRender.q0() || n0() != candleStickRender.n0() || J3() != candleStickRender.J3()) {
            return false;
        }
        Matrix q22 = q2();
        Matrix q23 = candleStickRender.q2();
        if (q22 != null ? !q22.equals(q23) : q23 != null) {
            return false;
        }
        Matrix t22 = t2();
        Matrix t23 = candleStickRender.t2();
        if (t22 != null ? !t22.equals(t23) : t23 != null) {
            return false;
        }
        Matrix p22 = p2();
        Matrix p23 = candleStickRender.p2();
        if (p22 != null ? !p22.equals(p23) : p23 != null) {
            return false;
        }
        GestureDetector k12 = k1();
        GestureDetector k13 = candleStickRender.k1();
        if (k12 != null ? !k12.equals(k13) : k13 != null) {
            return false;
        }
        KLineType N12 = N1();
        KLineType N13 = candleStickRender.N1();
        if (N12 != null ? !N12.equals(N13) : N13 != null) {
            return false;
        }
        if (H3() != candleStickRender.H3()) {
            return false;
        }
        InteractionMode M12 = M1();
        InteractionMode M13 = candleStickRender.M1();
        if (M12 != null ? !M12.equals(M13) : M13 != null) {
            return false;
        }
        ReqDataStatus T2 = T2();
        ReqDataStatus T22 = candleStickRender.T2();
        if (T2 != null ? !T2.equals(T22) : T22 != null) {
            return false;
        }
        d F22 = F2();
        d F23 = candleStickRender.F2();
        if (F22 != null ? !F22.equals(F23) : F23 != null) {
            return false;
        }
        DragStatus l12 = l1();
        DragStatus l13 = candleStickRender.l1();
        if (l12 != null ? !l12.equals(l13) : l13 != null) {
            return false;
        }
        Fingers r12 = r1();
        Fingers r13 = candleStickRender.r1();
        if (r12 != null ? !r12.equals(r13) : r13 != null) {
            return false;
        }
        OverScroller s22 = s2();
        OverScroller s23 = candleStickRender.s2();
        if (s22 != null ? !s22.equals(s23) : s23 != null) {
            return false;
        }
        j a22 = a2();
        j a23 = candleStickRender.a2();
        if (a22 != null ? !a22.equals(a23) : a23 != null) {
            return false;
        }
        c0 c22 = c2();
        c0 c23 = candleStickRender.c2();
        if (c22 != null ? !c22.equals(c23) : c23 != null) {
            return false;
        }
        j d22 = d2();
        j d23 = candleStickRender.d2();
        if (d22 != null ? !d22.equals(d23) : d23 != null) {
            return false;
        }
        j Y12 = Y1();
        j Y13 = candleStickRender.Y1();
        if (Y12 != null ? !Y12.equals(Y13) : Y13 != null) {
            return false;
        }
        y b22 = b2();
        y b23 = candleStickRender.b2();
        if (b22 != null ? !b22.equals(b23) : b23 != null) {
            return false;
        }
        k X12 = X1();
        k X13 = candleStickRender.X1();
        if (X12 != null ? !X12.equals(X13) : X13 != null) {
            return false;
        }
        j s02 = s0();
        j s03 = candleStickRender.s0();
        if (s02 != null ? !s02.equals(s03) : s03 != null) {
            return false;
        }
        RenderView S2 = S2();
        RenderView S22 = candleStickRender.S2();
        if (S2 != null ? !S2.equals(S22) : S22 != null) {
            return false;
        }
        m Z12 = Z1();
        m Z13 = candleStickRender.Z1();
        if (Z12 != null ? !Z12.equals(Z13) : Z13 != null) {
            return false;
        }
        if (x2() != candleStickRender.x2()) {
            return false;
        }
        String d32 = d3();
        String d33 = candleStickRender.d3();
        if (d32 != null ? !d32.equals(d33) : d33 != null) {
            return false;
        }
        LinkedHashSet<String> e32 = e3();
        LinkedHashSet<String> e33 = candleStickRender.e3();
        if (e32 != null ? !e32.equals(e33) : e33 != null) {
            return false;
        }
        if (Float.compare(B1(), candleStickRender.B1()) != 0 || d1() != candleStickRender.d1() || D2() != candleStickRender.D2() || E2() != candleStickRender.E2() || C2() != candleStickRender.C2() || Float.compare(C0(), candleStickRender.C0()) != 0 || Float.compare(D0(), candleStickRender.D0()) != 0 || Float.compare(F0(), candleStickRender.F0()) != 0 || Float.compare(E0(), candleStickRender.E0()) != 0 || Float.compare(G0(), candleStickRender.G0()) != 0 || Double.compare(j2(), candleStickRender.j2()) != 0 || Double.compare(l2(), candleStickRender.l2()) != 0 || i2() != candleStickRender.i2() || k2() != candleStickRender.k2() || Double.compare(g2(), candleStickRender.g2()) != 0 || Double.compare(h2(), candleStickRender.h2()) != 0 || Double.compare(f2(), candleStickRender.f2()) != 0 || C3() != candleStickRender.C3() || E3() != candleStickRender.E3() || F3() != candleStickRender.F3()) {
            return false;
        }
        s5.a I12 = I1();
        s5.a I13 = candleStickRender.I1();
        if (I12 != null ? !I12.equals(I13) : I13 != null) {
            return false;
        }
        s5.b J12 = J1();
        s5.b J13 = candleStickRender.J1();
        if (J12 != null ? !J12.equals(J13) : J13 != null) {
            return false;
        }
        if (W1() != candleStickRender.W1() || X2() != candleStickRender.X2()) {
            return false;
        }
        List<DataSetIndex> P2 = P2();
        List<DataSetIndex> P22 = candleStickRender.P2();
        if (P2 != null ? !P2.equals(P22) : P22 != null) {
            return false;
        }
        List<DataSetIndex> p12 = p1();
        List<DataSetIndex> p13 = candleStickRender.p1();
        if (p12 != null ? !p12.equals(p13) : p13 != null) {
            return false;
        }
        List<DataSetIndex> o32 = o3();
        List<DataSetIndex> o33 = candleStickRender.o3();
        if (o32 != null ? !o32.equals(o33) : o33 != null) {
            return false;
        }
        List<DataSetIndex> x02 = x0();
        List<DataSetIndex> x03 = candleStickRender.x0();
        if (x02 != null ? !x02.equals(x03) : x03 != null) {
            return false;
        }
        List<DataSetIndex> u22 = u2();
        List<DataSetIndex> u23 = candleStickRender.u2();
        if (u22 != null ? !u22.equals(u23) : u23 != null) {
            return false;
        }
        List<DataSetIndex> P12 = P1();
        List<DataSetIndex> P13 = candleStickRender.P1();
        if (P12 != null ? !P12.equals(P13) : P13 != null) {
            return false;
        }
        List<DataSetIndex> V2 = V2();
        List<DataSetIndex> V22 = candleStickRender.V2();
        if (V2 != null ? !V2.equals(V22) : V22 != null) {
            return false;
        }
        List<DataSetIndex> t32 = t3();
        List<DataSetIndex> t33 = candleStickRender.t3();
        if (t32 != null ? !t32.equals(t33) : t33 != null) {
            return false;
        }
        Map<Long, KlineFixInfo> r22 = r2();
        Map<Long, KlineFixInfo> r23 = candleStickRender.r2();
        if (r22 != null ? !r22.equals(r23) : r23 != null) {
            return false;
        }
        List<KlineInfo> z12 = z1();
        List<KlineInfo> z13 = candleStickRender.z1();
        if (z12 != null ? !z12.equals(z13) : z13 != null) {
            return false;
        }
        List<HashMap<Integer, Double>> N2 = N2();
        List<HashMap<Integer, Double>> N22 = candleStickRender.N2();
        if (N2 != null ? !N2.equals(N22) : N22 != null) {
            return false;
        }
        List<HashMap<Integer, Double>> n12 = n1();
        List<HashMap<Integer, Double>> n13 = candleStickRender.n1();
        if (n12 != null ? !n12.equals(n13) : n13 != null) {
            return false;
        }
        List<HashMap<Integer, Double>> U2 = U2();
        List<HashMap<Integer, Double>> U22 = candleStickRender.U2();
        if (U2 != null ? !U2.equals(U22) : U22 != null) {
            return false;
        }
        List<HashMap<Integer, Double>> s32 = s3();
        List<HashMap<Integer, Double>> s33 = candleStickRender.s3();
        if (s32 != null ? !s32.equals(s33) : s33 != null) {
            return false;
        }
        List<HashMap<Integer, Double>> m32 = m3();
        List<HashMap<Integer, Double>> m33 = candleStickRender.m3();
        if (m32 != null ? !m32.equals(m33) : m33 != null) {
            return false;
        }
        List<HashMap<String, Double>> O12 = O1();
        List<HashMap<String, Double>> O13 = candleStickRender.O1();
        if (O12 != null ? !O12.equals(O13) : O13 != null) {
            return false;
        }
        List<Long> A12 = A1();
        List<Long> A13 = candleStickRender.A1();
        if (A12 != null ? !A12.equals(A13) : A13 != null) {
            return false;
        }
        if (!Arrays.equals(K1(), candleStickRender.K1()) || v2() != candleStickRender.v2() || w2() != candleStickRender.w2() || Q0() != candleStickRender.Q0() || J0() != candleStickRender.J0() || K0() != candleStickRender.K0() || O0() != candleStickRender.O0() || P0() != candleStickRender.P0() || M0() != candleStickRender.M0() || L0() != candleStickRender.L0() || N0() != candleStickRender.N0() || I0() != candleStickRender.I0() || H1() != candleStickRender.H1() || G1() != candleStickRender.G1() || F1() != candleStickRender.F1() || E1() != candleStickRender.E1() || R0() != candleStickRender.R0() || U0() != candleStickRender.U0() || !Arrays.equals(S0(), candleStickRender.S0()) || !Arrays.equals(T0(), candleStickRender.T0()) || V0() != candleStickRender.V0() || w1() != candleStickRender.w1() || x1() != candleStickRender.x1() || v1() != candleStickRender.v1()) {
            return false;
        }
        Drawable u12 = u1();
        Drawable u13 = candleStickRender.u1();
        if (u12 != null ? !u12.equals(u13) : u13 != null) {
            return false;
        }
        if (y0() != candleStickRender.y0() || z0() != candleStickRender.z0() || A0() != candleStickRender.A0() || B0() != candleStickRender.B0() || W0() != candleStickRender.W0() || R2() != candleStickRender.R2() || a3() != candleStickRender.a3() || l3() != candleStickRender.l3() || y1() != candleStickRender.y1() || h1() != candleStickRender.h1()) {
            return false;
        }
        Drawable u02 = u0();
        Drawable u03 = candleStickRender.u0();
        if (u02 != null ? !u02.equals(u03) : u03 != null) {
            return false;
        }
        Drawable v02 = v0();
        Drawable v03 = candleStickRender.v0();
        if (v02 != null ? !v02.equals(v03) : v03 != null) {
            return false;
        }
        Drawable q32 = q3();
        Drawable q33 = candleStickRender.q3();
        if (q32 != null ? !q32.equals(q33) : q33 != null) {
            return false;
        }
        KlineInfo t02 = t0();
        KlineInfo t03 = candleStickRender.t0();
        if (t02 != null ? !t02.equals(t03) : t03 != null) {
            return false;
        }
        KlineInfo f12 = f1();
        KlineInfo f13 = candleStickRender.f1();
        if (f12 != null ? !f12.equals(f13) : f13 != null) {
            return false;
        }
        KlineInfo q12 = q1();
        KlineInfo q13 = candleStickRender.q1();
        if (q12 != null ? !q12.equals(q13) : q13 != null) {
            return false;
        }
        ValueAnimator L2 = L2();
        ValueAnimator L22 = candleStickRender.L2();
        if (L2 != null ? !L2.equals(L22) : L22 != null) {
            return false;
        }
        ValueAnimator m02 = m0();
        ValueAnimator m03 = candleStickRender.m0();
        if (m02 != null ? !m02.equals(m03) : m03 != null) {
            return false;
        }
        if (Float.compare(T1(), candleStickRender.T1()) != 0 || K3() != candleStickRender.K3()) {
            return false;
        }
        Runnable h32 = h3();
        Runnable h33 = candleStickRender.h3();
        if (h32 != null ? !h32.equals(h33) : h33 != null) {
            return false;
        }
        Runnable g32 = g3();
        Runnable g33 = candleStickRender.g3();
        if (g32 != null ? !g32.equals(g33) : g33 != null) {
            return false;
        }
        Runnable f32 = f3();
        Runnable f33 = candleStickRender.f3();
        if (f32 != null ? !f32.equals(f33) : f33 != null) {
            return false;
        }
        Runnable y22 = y2();
        Runnable y23 = candleStickRender.y2();
        if (y22 != null ? !y22.equals(y23) : y23 != null) {
            return false;
        }
        Runnable R12 = R1();
        Runnable R13 = candleStickRender.R1();
        if (R12 != null ? !R12.equals(R13) : R13 != null) {
            return false;
        }
        Runnable Q12 = Q1();
        Runnable Q13 = candleStickRender.Q1();
        if (Q12 != null ? !Q12.equals(Q13) : Q13 != null) {
            return false;
        }
        SmartRefreshLayout n22 = n2();
        SmartRefreshLayout n23 = candleStickRender.n2();
        if (n22 != null ? !n22.equals(n23) : n23 != null) {
            return false;
        }
        MotionEvent m22 = m2();
        MotionEvent m23 = candleStickRender.m2();
        if (m22 != null ? !m22.equals(m23) : m23 != null) {
            return false;
        }
        PointF c32 = c3();
        PointF c33 = candleStickRender.c3();
        if (c32 != null ? !c32.equals(c33) : c33 != null) {
            return false;
        }
        PointF b32 = b3();
        PointF b33 = candleStickRender.b3();
        if (b32 != null ? !b32.equals(b33) : b33 != null) {
            return false;
        }
        KlineInfo g12 = g1();
        KlineInfo g13 = candleStickRender.g1();
        if (g12 != null ? !g12.equals(g13) : g13 != null) {
            return false;
        }
        PointF k32 = k3();
        PointF k33 = candleStickRender.k3();
        if (k32 != null ? !k32.equals(k33) : k33 != null) {
            return false;
        }
        Handler o22 = o2();
        Handler o23 = candleStickRender.o2();
        if (o22 != null ? !o22.equals(o23) : o23 != null) {
            return false;
        }
        MotionEvent K2 = K2();
        MotionEvent K22 = candleStickRender.K2();
        if (K2 != null ? !K2.equals(K22) : K22 != null) {
            return false;
        }
        MotionEvent e12 = e1();
        MotionEvent e13 = candleStickRender.e1();
        if (e12 != null ? !e12.equals(e13) : e13 != null) {
            return false;
        }
        if (L3() != candleStickRender.L3()) {
            return false;
        }
        String a12 = a1();
        String a13 = candleStickRender.a1();
        if (a12 != null ? !a12.equals(a13) : a13 != null) {
            return false;
        }
        if (c1() != candleStickRender.c1() || S1() != candleStickRender.S1()) {
            return false;
        }
        KLineType U12 = U1();
        KLineType U13 = candleStickRender.U1();
        if (U12 != null ? !U12.equals(U13) : U13 != null) {
            return false;
        }
        Runnable b12 = b1();
        Runnable b13 = candleStickRender.b1();
        return b12 != null ? b12.equals(b13) : b13 == null;
    }

    public void f() {
        super.f();
        if (this.Z.computeScrollOffset()) {
            boolean z11 = this.f67204i - this.Z.getCurrX() < 0;
            x(this.Z.getCurrX(), this.Z.getCurrY());
            e0(z11, true);
            q();
        }
    }

    public final float f0(float f11) {
        return Math.max(0.0f, Math.min((float) (this.Y0.size() - 1), (f11 - ((float) this.f67271t)) / this.f67282w0));
    }

    public KlineInfo f1() {
        return this.T1;
    }

    public double f2() {
        return this.H0;
    }

    public Runnable f3() {
        return this.f67216b2;
    }

    public void f4(boolean z11) {
        m mVar = this.f67235i0;
        if (mVar != null && this.I0) {
            mVar.A0(z11);
        }
    }

    public void g(int i11, int i12, int i13, int i14) {
        if (this.f67201f != i12 || this.f67202g != i11) {
            this.f67201f = i12;
            this.f67202g = i11;
            if (this.f67282w0 == 0.0f || i11 != i13) {
                R();
            }
            int i15 = this.f67202g;
            this.f67275u = (i15 / 5) * 4;
            this.f67278v = ((-i15) / 5) * 3;
            this.f67271t = (i15 / 5) * 4;
            this.f67223e0.G(new Rect(0, 0, i11, i12));
            this.f67214b0.G(new Rect(0, 0, i11, i12));
            this.f67217c0.G(new Rect(0, 0, i11, i12));
            this.f67211a0.G(new Rect(0, 0, i11, i12));
            this.f67220d0.G(new Rect(0, 0, i11, i12));
            if (this.I0) {
                this.f67235i0.G(new Rect(0, 0, i11, i12));
            }
            this.f67226f0.G(new Rect(0, 0, i11, i12));
            if (B3()) {
                if (k() == this.f67204i) {
                    l4();
                }
                W3();
            }
        }
    }

    public final int g0(int i11, boolean z11) {
        double max;
        if (!z11) {
            max = Math.max(0.0d, Math.min((double) (this.Y0.size() - 1), Math.floor((double) (((float) (i11 - this.f67271t)) / this.f67282w0))));
        } else {
            max = Math.max(0.0d, Math.min((double) (this.Y0.size() - 1), Math.ceil((double) (((float) (i11 - this.f67271t)) / this.f67282w0))));
        }
        return (int) max;
    }

    public KlineInfo g1() {
        return this.f67240j2;
    }

    public double g2() {
        return this.F0;
    }

    public Runnable g3() {
        return this.f67213a2;
    }

    public final void g4() {
        if (B3()) {
            N();
            T();
            m();
        }
    }

    public int h() {
        List<KlineInfo> list = this.Y0;
        int size = list == null ? 0 : list.size();
        if (KLineType.isTimeLine(this.S)) {
            size = Math.max(0, size - 1);
        }
        return Math.max(this.f67202g, (int) ((((float) Math.max(0, size - 1)) * this.f67282w0) + this.X1 + ((float) this.f67271t) + ((float) this.f67275u)));
    }

    public int h0(int i11, boolean z11) {
        double ceil;
        if (!z11) {
            ceil = Math.floor((double) (((float) ((this.f67204i + i11) - this.f67271t)) / this.f67282w0));
        } else {
            ceil = Math.ceil((double) (((float) ((this.f67204i + i11) - this.f67271t)) / this.f67282w0));
        }
        return (int) ceil;
    }

    public int h1() {
        return this.O1;
    }

    public double h2() {
        return this.G0;
    }

    public Runnable h3() {
        return this.Z1;
    }

    public final boolean h4(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f67231g2 = MotionEvent.obtain(motionEvent);
            this.f67247l2.removeMessages(200);
            if (!this.J0) {
                this.f67247l2.sendEmptyMessageAtTime(200, this.f67231g2.getDownTime() + 250);
            }
        } else if (action == 1 || action == 3) {
            this.f67247l2.removeMessages(200);
        }
        return this.R.onTouchEvent(motionEvent);
    }

    public int hashCode() {
        int i11 = 79;
        int z22 = (((((((((((((((((((((y3() ? 79 : 97) + 59) * 59) + (A3() ? 79 : 97)) * 59) + z2()) * 59) + A2()) * 59) + B2()) * 59) + i1()) * 59) + j1()) * 59) + (x3() ? 79 : 97)) * 59) + G2()) * 59) + H2()) * 59) + s1();
        List<BSTShape> r02 = r0();
        int i12 = 43;
        int hashCode = (z22 * 59) + (r02 == null ? 43 : r02.hashCode());
        List<BSTShape> W2 = W2();
        int hashCode2 = (hashCode * 59) + (W2 == null ? 43 : W2.hashCode());
        List<BSTShape> j32 = j3();
        int hashCode3 = (hashCode2 * 59) + (j32 == null ? 43 : j32.hashCode());
        List<?> J2 = J2();
        int hashCode4 = (hashCode3 * 59) + (J2 == null ? 43 : J2.hashCode());
        List<?> e22 = e2();
        int hashCode5 = (hashCode4 * 59) + (e22 == null ? 43 : e22.hashCode());
        List<?> I2 = I2();
        int hashCode6 = (hashCode5 * 59) + (I2 == null ? 43 : I2.hashCode());
        List<?> C12 = C1();
        int hashCode7 = (hashCode6 * 59) + (C12 == null ? 43 : C12.hashCode());
        List<?> D12 = D1();
        int hashCode8 = (((((hashCode7 * 59) + (D12 == null ? 43 : D12.hashCode())) * 59) + (G3() ? 79 : 97)) * 59) + (z3() ? 79 : 97);
        String i32 = i3();
        int hashCode9 = (((((((((((((((hashCode8 * 59) + (i32 == null ? 43 : i32.hashCode())) * 59) + Q2()) * 59) + p3()) * 59) + o0()) * 59) + p0()) * 59) + q0()) * 59) + n0()) * 59) + (J3() ? 79 : 97);
        Matrix q22 = q2();
        int hashCode10 = (hashCode9 * 59) + (q22 == null ? 43 : q22.hashCode());
        Matrix t22 = t2();
        int hashCode11 = (hashCode10 * 59) + (t22 == null ? 43 : t22.hashCode());
        Matrix p22 = p2();
        int hashCode12 = (hashCode11 * 59) + (p22 == null ? 43 : p22.hashCode());
        GestureDetector k12 = k1();
        int hashCode13 = (hashCode12 * 59) + (k12 == null ? 43 : k12.hashCode());
        KLineType N12 = N1();
        int hashCode14 = (((hashCode13 * 59) + (N12 == null ? 43 : N12.hashCode())) * 59) + (H3() ? 79 : 97);
        InteractionMode M12 = M1();
        int hashCode15 = (hashCode14 * 59) + (M12 == null ? 43 : M12.hashCode());
        ReqDataStatus T2 = T2();
        int hashCode16 = (hashCode15 * 59) + (T2 == null ? 43 : T2.hashCode());
        d F22 = F2();
        int hashCode17 = (hashCode16 * 59) + (F22 == null ? 43 : F22.hashCode());
        DragStatus l12 = l1();
        int hashCode18 = (hashCode17 * 59) + (l12 == null ? 43 : l12.hashCode());
        Fingers r12 = r1();
        int hashCode19 = (hashCode18 * 59) + (r12 == null ? 43 : r12.hashCode());
        OverScroller s22 = s2();
        int hashCode20 = (hashCode19 * 59) + (s22 == null ? 43 : s22.hashCode());
        j a22 = a2();
        int hashCode21 = (hashCode20 * 59) + (a22 == null ? 43 : a22.hashCode());
        c0 c22 = c2();
        int hashCode22 = (hashCode21 * 59) + (c22 == null ? 43 : c22.hashCode());
        j d22 = d2();
        int hashCode23 = (hashCode22 * 59) + (d22 == null ? 43 : d22.hashCode());
        j Y12 = Y1();
        int hashCode24 = (hashCode23 * 59) + (Y12 == null ? 43 : Y12.hashCode());
        y b22 = b2();
        int hashCode25 = (hashCode24 * 59) + (b22 == null ? 43 : b22.hashCode());
        k X12 = X1();
        int hashCode26 = (hashCode25 * 59) + (X12 == null ? 43 : X12.hashCode());
        j s02 = s0();
        int hashCode27 = (hashCode26 * 59) + (s02 == null ? 43 : s02.hashCode());
        RenderView S2 = S2();
        int hashCode28 = (hashCode27 * 59) + (S2 == null ? 43 : S2.hashCode());
        m Z12 = Z1();
        int hashCode29 = (((hashCode28 * 59) + (Z12 == null ? 43 : Z12.hashCode())) * 59) + x2();
        String d32 = d3();
        int hashCode30 = (hashCode29 * 59) + (d32 == null ? 43 : d32.hashCode());
        LinkedHashSet<String> e32 = e3();
        int i13 = hashCode30 * 59;
        int hashCode31 = e32 == null ? 43 : e32.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(j2());
        int floatToIntBits = ((((((((((((((((((((((i13 + hashCode31) * 59) + Float.floatToIntBits(B1())) * 59) + d1()) * 59) + D2()) * 59) + E2()) * 59) + C2()) * 59) + Float.floatToIntBits(C0())) * 59) + Float.floatToIntBits(D0())) * 59) + Float.floatToIntBits(F0())) * 59) + Float.floatToIntBits(E0())) * 59) + Float.floatToIntBits(G0())) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(l2());
        int i22 = (((((floatToIntBits * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + i2()) * 59) + k2();
        long doubleToLongBits3 = Double.doubleToLongBits(g2());
        int i14 = (i22 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(h2());
        int i15 = (i14 * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(f2());
        int i16 = (((((((i15 * 59) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 59) + (C3() ? 79 : 97)) * 59) + (E3() ? 79 : 97)) * 59) + (F3() ? 79 : 97);
        s5.a I12 = I1();
        int hashCode32 = (i16 * 59) + (I12 == null ? 43 : I12.hashCode());
        s5.b J12 = J1();
        int hashCode33 = (hashCode32 * 59) + (J12 == null ? 43 : J12.hashCode());
        long W12 = W1();
        int i17 = (hashCode33 * 59) + ((int) (W12 ^ (W12 >>> 32)));
        long X2 = X2();
        int i18 = (i17 * 59) + ((int) (X2 ^ (X2 >>> 32)));
        List<DataSetIndex> P2 = P2();
        int hashCode34 = (i18 * 59) + (P2 == null ? 43 : P2.hashCode());
        List<DataSetIndex> p12 = p1();
        int hashCode35 = (hashCode34 * 59) + (p12 == null ? 43 : p12.hashCode());
        List<DataSetIndex> o32 = o3();
        int hashCode36 = (hashCode35 * 59) + (o32 == null ? 43 : o32.hashCode());
        List<DataSetIndex> x02 = x0();
        int hashCode37 = (hashCode36 * 59) + (x02 == null ? 43 : x02.hashCode());
        List<DataSetIndex> u22 = u2();
        int hashCode38 = (hashCode37 * 59) + (u22 == null ? 43 : u22.hashCode());
        List<DataSetIndex> P12 = P1();
        int hashCode39 = (hashCode38 * 59) + (P12 == null ? 43 : P12.hashCode());
        List<DataSetIndex> V2 = V2();
        int hashCode40 = (hashCode39 * 59) + (V2 == null ? 43 : V2.hashCode());
        List<DataSetIndex> t32 = t3();
        int hashCode41 = (hashCode40 * 59) + (t32 == null ? 43 : t32.hashCode());
        Map<Long, KlineFixInfo> r22 = r2();
        int hashCode42 = (hashCode41 * 59) + (r22 == null ? 43 : r22.hashCode());
        List<KlineInfo> z12 = z1();
        int hashCode43 = (hashCode42 * 59) + (z12 == null ? 43 : z12.hashCode());
        List<HashMap<Integer, Double>> N2 = N2();
        int hashCode44 = (hashCode43 * 59) + (N2 == null ? 43 : N2.hashCode());
        List<HashMap<Integer, Double>> n12 = n1();
        int hashCode45 = (hashCode44 * 59) + (n12 == null ? 43 : n12.hashCode());
        List<HashMap<Integer, Double>> U2 = U2();
        int hashCode46 = (hashCode45 * 59) + (U2 == null ? 43 : U2.hashCode());
        List<HashMap<Integer, Double>> s32 = s3();
        int hashCode47 = (hashCode46 * 59) + (s32 == null ? 43 : s32.hashCode());
        List<HashMap<Integer, Double>> m32 = m3();
        int hashCode48 = (hashCode47 * 59) + (m32 == null ? 43 : m32.hashCode());
        List<HashMap<String, Double>> O12 = O1();
        int hashCode49 = (hashCode48 * 59) + (O12 == null ? 43 : O12.hashCode());
        List<Long> A12 = A1();
        int hashCode50 = (((((((((((((((((((((((((((((((((((((((((((((((((hashCode49 * 59) + (A12 == null ? 43 : A12.hashCode())) * 59) + Arrays.hashCode(K1())) * 59) + v2()) * 59) + w2()) * 59) + Q0()) * 59) + J0()) * 59) + K0()) * 59) + O0()) * 59) + P0()) * 59) + M0()) * 59) + L0()) * 59) + N0()) * 59) + I0()) * 59) + H1()) * 59) + G1()) * 59) + F1()) * 59) + E1()) * 59) + R0()) * 59) + U0()) * 59) + Arrays.hashCode(S0())) * 59) + Arrays.hashCode(T0())) * 59) + V0()) * 59) + w1()) * 59) + x1()) * 59) + v1();
        Drawable u12 = u1();
        int hashCode51 = (((((((((((((((((((((hashCode50 * 59) + (u12 == null ? 43 : u12.hashCode())) * 59) + y0()) * 59) + z0()) * 59) + A0()) * 59) + B0()) * 59) + W0()) * 59) + R2()) * 59) + a3()) * 59) + l3()) * 59) + y1()) * 59) + h1();
        Drawable u02 = u0();
        int hashCode52 = (hashCode51 * 59) + (u02 == null ? 43 : u02.hashCode());
        Drawable v02 = v0();
        int hashCode53 = (hashCode52 * 59) + (v02 == null ? 43 : v02.hashCode());
        Drawable q32 = q3();
        int hashCode54 = (hashCode53 * 59) + (q32 == null ? 43 : q32.hashCode());
        KlineInfo t02 = t0();
        int hashCode55 = (hashCode54 * 59) + (t02 == null ? 43 : t02.hashCode());
        KlineInfo f12 = f1();
        int hashCode56 = (hashCode55 * 59) + (f12 == null ? 43 : f12.hashCode());
        KlineInfo q12 = q1();
        int hashCode57 = (hashCode56 * 59) + (q12 == null ? 43 : q12.hashCode());
        ValueAnimator L2 = L2();
        int hashCode58 = (hashCode57 * 59) + (L2 == null ? 43 : L2.hashCode());
        ValueAnimator m02 = m0();
        int hashCode59 = (((((hashCode58 * 59) + (m02 == null ? 43 : m02.hashCode())) * 59) + Float.floatToIntBits(T1())) * 59) + (K3() ? 79 : 97);
        Runnable h32 = h3();
        int hashCode60 = (hashCode59 * 59) + (h32 == null ? 43 : h32.hashCode());
        Runnable g32 = g3();
        int hashCode61 = (hashCode60 * 59) + (g32 == null ? 43 : g32.hashCode());
        Runnable f32 = f3();
        int hashCode62 = (hashCode61 * 59) + (f32 == null ? 43 : f32.hashCode());
        Runnable y22 = y2();
        int hashCode63 = (hashCode62 * 59) + (y22 == null ? 43 : y22.hashCode());
        Runnable R12 = R1();
        int hashCode64 = (hashCode63 * 59) + (R12 == null ? 43 : R12.hashCode());
        Runnable Q12 = Q1();
        int hashCode65 = (hashCode64 * 59) + (Q12 == null ? 43 : Q12.hashCode());
        SmartRefreshLayout n22 = n2();
        int hashCode66 = (hashCode65 * 59) + (n22 == null ? 43 : n22.hashCode());
        MotionEvent m22 = m2();
        int hashCode67 = (hashCode66 * 59) + (m22 == null ? 43 : m22.hashCode());
        PointF c32 = c3();
        int hashCode68 = (hashCode67 * 59) + (c32 == null ? 43 : c32.hashCode());
        PointF b32 = b3();
        int hashCode69 = (hashCode68 * 59) + (b32 == null ? 43 : b32.hashCode());
        KlineInfo g12 = g1();
        int hashCode70 = (hashCode69 * 59) + (g12 == null ? 43 : g12.hashCode());
        PointF k32 = k3();
        int hashCode71 = (hashCode70 * 59) + (k32 == null ? 43 : k32.hashCode());
        Handler o22 = o2();
        int hashCode72 = (hashCode71 * 59) + (o22 == null ? 43 : o22.hashCode());
        MotionEvent K2 = K2();
        int hashCode73 = (hashCode72 * 59) + (K2 == null ? 43 : K2.hashCode());
        MotionEvent e12 = e1();
        int hashCode74 = ((hashCode73 * 59) + (e12 == null ? 43 : e12.hashCode())) * 59;
        if (!L3()) {
            i11 = 97;
        }
        int i19 = hashCode74 + i11;
        String a12 = a1();
        int hashCode75 = (i19 * 59) + (a12 == null ? 43 : a12.hashCode());
        long c12 = c1();
        int i21 = (hashCode75 * 59) + ((int) (c12 ^ (c12 >>> 32)));
        long S12 = S1();
        int i23 = (i21 * 59) + ((int) (S12 ^ (S12 >>> 32)));
        KLineType U12 = U1();
        int hashCode76 = (i23 * 59) + (U12 == null ? 43 : U12.hashCode());
        Runnable b12 = b1();
        int i24 = hashCode76 * 59;
        if (b12 != null) {
            i12 = b12.hashCode();
        }
        return i24 + i12;
    }

    public int i0(int i11) {
        float k02;
        if (KLineType.isTimeLine(this.S)) {
            k02 = ((float) (k0(i11) - this.f67204i)) - (this.f67282w0 / 2.0f);
        } else {
            k02 = ((float) (k0(i11) - this.f67204i)) + (this.f67282w0 / 2.0f);
        }
        return (int) k02;
    }

    public int i1() {
        return this.f67262q;
    }

    public int i2() {
        return this.D0;
    }

    public String i3() {
        return this.G;
    }

    public void i4(Runnable runnable, long j11) {
        this.f67247l2.removeCallbacks(runnable);
        this.f67247l2.postDelayed(runnable, j11);
    }

    public void j(View view, Context context, AttributeSet attributeSet, int i11) {
        super.j(view, context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CandleStickRender, i11, 0);
        this.L = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CandleStickRender_axisMarginTop, 0);
        this.M = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CandleStickRender_axisMarginBottom, 0);
        this.J = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CandleStickRender_axisMarginLeft, 0);
        this.K = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CandleStickRender_axisMarginRight, 0);
        this.f67252n = obtainStyledAttributes.getInteger(R$styleable.CandleStickRender_maxDisplayNum, f67210z2);
        this.f67262q = obtainStyledAttributes.getInteger(R$styleable.CandleStickRender_defaultScreenNum, B2);
        this.f67265r = obtainStyledAttributes.getInteger(R$styleable.CandleStickRender_defaultTLScreenNum, C2);
        this.f67268s = obtainStyledAttributes.getBoolean(R$styleable.CandleStickRender_axisInBottom, true);
        this.f67256o = obtainStyledAttributes.getInteger(R$styleable.CandleStickRender_maxScreenNum, E2);
        this.f67259p = obtainStyledAttributes.getInteger(R$styleable.CandleStickRender_minScreenNum, D2);
        this.f67233h1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_magnifierBgColor, this.f67233h1);
        this.f67236i1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_magnifierBgShadowColor, this.f67236i1);
        this.f67242k1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_downColor, this.f67242k1);
        this.f67239j1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_raiseColor, this.f67239j1);
        this.f67246l1 = KLineHelper.b(0.6f, obtainStyledAttributes.getColor(R$styleable.CandleStickRender_gridColor, this.f67246l1));
        this.f67250m1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_laimbColor, this.f67250m1);
        this.f67254n1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_maxMinPriceColor, this.f67254n1);
        this.f67257o1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightCrossXColor, this.f67257o1);
        this.f67260p1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightCrossXBgColor, this.f67260p1);
        this.f67277u1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightRightKlastTextColor, this.f67277u1);
        this.f67280v1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightRightKlastBgColor, this.f67280v1);
        this.f67269s1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightTagTextColor, this.f67269s1);
        this.f67273t1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightTagBorderColor, this.f67273t1);
        this.f67283w1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineColor, this.f67257o1);
        this.f67286x1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineTodayColor, this.f67257o1);
        this.A1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineVolColor, this.A1);
        this.f67289y1[0] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineShaderColor1, 0);
        this.f67289y1[1] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineShaderColor2, 0);
        this.f67289y1[2] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineShaderColor3, 0);
        this.f67289y1[3] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_timeLineShaderColor4, 0);
        this.f67266r1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_floatCrossDashLineColor, this.f67266r1);
        this.f67263q1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_highLightRectBgColor, this.f67263q1);
        this.B1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_floatBoxEdgeColor, this.B1);
        this.C1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_floatBoxEdgeShadowColor, this.C1);
        this.D1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_floatBoxBgColor, this.D1);
        this.E1 = obtainStyledAttributes.getDrawable(R$styleable.CandleStickRender_floatBoxArrow);
        this.P1 = obtainStyledAttributes.getDrawable(R$styleable.CandleStickRender_bgMaster);
        this.Q1 = obtainStyledAttributes.getDrawable(R$styleable.CandleStickRender_bgSlave);
        this.R1 = obtainStyledAttributes.getDrawable(R$styleable.CandleStickRender_water_logo);
        if (p.h(context) && !p.i(context)) {
            this.R1 = context.getDrawable(R$drawable.kline_water_logo_zh_cn);
        }
        int[] iArr = this.f67230g1;
        iArr[0] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexLabelColor, iArr[0]);
        int[] iArr2 = this.f67230g1;
        iArr2[1] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor1, iArr2[1]);
        int[] iArr3 = this.f67230g1;
        iArr3[2] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor2, iArr3[2]);
        int[] iArr4 = this.f67230g1;
        iArr4[3] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor3, iArr4[3]);
        int[] iArr5 = this.f67230g1;
        iArr5[4] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor4, iArr5[4]);
        int[] iArr6 = this.f67230g1;
        iArr6[5] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor5, iArr6[5]);
        int[] iArr7 = this.f67230g1;
        iArr7[6] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor6, iArr7[6]);
        int[] iArr8 = this.f67230g1;
        iArr8[7] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor7, iArr8[7]);
        int[] iArr9 = this.f67230g1;
        iArr9[8] = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_indexColor8, iArr9[8]);
        this.J1 = KLineHelper.c(context, R$attr.kline_content_background_color);
        this.K1 = KLineHelper.c(context, R$attr.kline_primary_text_color);
        this.L1 = KLineHelper.c(context, R$attr.kline_secondary_text_color);
        this.M1 = KLineHelper.c(context, R$attr.kline_three_level_text_color);
        this.N1 = KLineHelper.c(context, R$attr.kline_four_level_text_color);
        this.F1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_breathing_center_color, 0);
        this.G1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_breathing_edge_color, 0);
        this.H1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_breathing_shadow_center_color, 0);
        this.I1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_breathing_shadow_edge_color, 0);
        this.O1 = obtainStyledAttributes.getColor(R$styleable.CandleStickRender_deathLightCenterColor, 0);
        this.f67253n0 = this.f67262q;
        this.N = obtainStyledAttributes.getBoolean(R$styleable.CandleStickRender_landscape, false);
        obtainStyledAttributes.recycle();
        this.R = new GestureDetector(context, this);
        this.Z = new OverScroller(context);
        j b02 = b0();
        this.f67211a0 = b02;
        b02.P(this.N);
        c0 c0Var = new c0(this, this.f67200e);
        this.f67214b0 = c0Var;
        c0Var.P(this.N);
        j c02 = c0();
        this.f67217c0 = c02;
        c02.P(this.N);
        j a02 = a0();
        this.f67220d0 = a02;
        a02.P(this.N);
        m mVar = new m(this, this.f67200e);
        this.f67235i0 = mVar;
        mVar.P(this.N);
        y yVar = new y(this, this.f67200e);
        this.f67223e0 = yVar;
        yVar.P(this.N);
        this.f67223e0.j(view, context, attributeSet, i11);
        k kVar = new k(this, this.f67200e);
        this.f67226f0 = kVar;
        kVar.P(this.N);
        this.f67226f0.I0(new c(this));
    }

    public int j0(int i11) {
        if (KLineType.isTimeLine(this.S)) {
            return (int) (((float) (k0(i11) - this.f67204i)) - (this.f67282w0 / 2.0f));
        }
        return k0(i11) - this.f67204i;
    }

    public int j1() {
        return this.f67265r;
    }

    public double j2() {
        return this.B0;
    }

    public List<BSTShape> j3() {
        return this.f67287y;
    }

    public void j4() {
        if (!UtilCollections.f(this.Y0)) {
            this.Y0.clear();
        }
        if (!UtilCollections.f(this.f67227f1)) {
            this.f67227f1.clear();
        }
        if (!UtilCollections.f(this.Z0)) {
            this.Z0.clear();
        }
        if (!UtilCollections.f(this.f67212a1)) {
            this.f67212a1.clear();
        }
        if (!UtilCollections.f(this.f67221d1)) {
            this.f67221d1.clear();
        }
        if (!UtilCollections.f(this.f67218c1)) {
            this.f67218c1.clear();
        }
        if (!UtilCollections.f(this.f67215b1)) {
            this.f67215b1.clear();
        }
        if (!UtilCollections.f(this.f67224e1)) {
            this.f67224e1.clear();
        }
        this.S1 = null;
        this.T1 = null;
        this.U1 = null;
        this.T = false;
        this.f67272t0 = -1;
        this.f67276u0 = -1;
        this.f67279v0 = -1;
        T4(InteractionMode.NONE, 2);
        k4();
        R();
        this.f67220d0.N();
        if (this.I0) {
            this.f67235i0.N();
        }
        this.f67217c0.N();
        this.f67214b0.N();
        this.f67211a0.N();
        this.f67226f0.N();
        ValueAnimator valueAnimator = this.V1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.V1.cancel();
        }
        ValueAnimator valueAnimator2 = this.W1;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.W1.cancel();
        }
        this.S1 = null;
        this.T1 = null;
        this.U1 = null;
    }

    public final int k0(int i11) {
        float f11;
        if (i11 == this.Y0.size() - 1) {
            f11 = ((float) this.f67271t) + (this.f67282w0 * ((float) Math.max(0, i11 - 1))) + this.X1;
        } else {
            f11 = ((float) this.f67271t) + (this.f67282w0 * ((float) i11));
        }
        return (int) f11;
    }

    public GestureDetector k1() {
        return this.R;
    }

    public int k2() {
        return this.E0;
    }

    public PointF k3() {
        return this.f67243k2;
    }

    public final void k4() {
        this.B0 = -9.223372036854776E18d;
        this.C0 = 9.223372036854776E18d;
        this.D0 = Integer.MIN_VALUE;
        this.E0 = Integer.MAX_VALUE;
        this.F0 = -9.223372036854776E18d;
        this.H0 = -9.223372036854776E18d;
        this.G0 = 9.223372036854776E18d;
    }

    public final void l0(int i11, int i12, int i13) {
        this.Z.fling(this.f67204i, this.f67203h, i11, i12, 0, i13, 0, 0);
        T4(InteractionMode.NONE, 10);
        r();
    }

    public DragStatus l1() {
        return this.X;
    }

    public double l2() {
        return this.C0;
    }

    public int l3() {
        return this.M1;
    }

    public final void l4() {
        this.f67204i = Math.max(0, O());
        N();
    }

    public ValueAnimator m0() {
        return this.W1;
    }

    public Double m1(int i11, int i12) {
        if (UtilCollections.h(this.Y0, i11)) {
            return (Double) this.f67212a1.get(i11).get(Integer.valueOf(i12));
        }
        return null;
    }

    public MotionEvent m2() {
        return this.f67231g2;
    }

    public List<HashMap<Integer, Double>> m3() {
        return this.f67221d1;
    }

    public void m4(List<BSTShape> list, List<BSTShape> list2, List<BSTShape> list3) {
        this.f67281w = list;
        this.f67284x = list2;
        this.f67287y = list3;
        m();
    }

    public int n0() {
        return this.M;
    }

    public List<HashMap<Integer, Double>> n1() {
        return this.f67212a1;
    }

    public SmartRefreshLayout n2() {
        return this.f67228f2;
    }

    public int n3(int i11) {
        for (DataSetIndex next : this.R0) {
            if (next.d() == i11) {
                return next.b();
            }
        }
        return 0;
    }

    public void n4(c6.b<RectF> bVar) {
        j jVar = this.f67211a0;
        if (jVar != null) {
            jVar.O(bVar);
        }
    }

    public void o(boolean z11) {
        m mVar;
        super.o(z11);
        if (this.I0 && (mVar = this.f67235i0) != null) {
            mVar.o(z11);
        }
    }

    public int o0() {
        return this.J;
    }

    public int o1(int i11) {
        for (DataSetIndex next : this.Q0) {
            if (next.d() == i11) {
                return next.b();
            }
        }
        return 0;
    }

    public Handler o2() {
        return this.f67247l2;
    }

    public List<DataSetIndex> o3() {
        return this.R0;
    }

    public void o4(int i11) {
        this.f67242k1 = i11;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == this.V1) {
            U4(((Float) valueAnimator.getAnimatedValue()).floatValue());
        } else if (valueAnimator == this.W1) {
            R4(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f67220d0.onAttachedToWindow();
        this.f67235i0.onAttachedToWindow();
        this.f67217c0.onAttachedToWindow();
        this.f67214b0.onAttachedToWindow();
        this.f67211a0.onAttachedToWindow();
        this.f67226f0.onAttachedToWindow();
        w3();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f67220d0.onDetachedFromWindow();
        this.f67235i0.onDetachedFromWindow();
        this.f67217c0.onDetachedFromWindow();
        this.f67214b0.onDetachedFromWindow();
        this.f67211a0.onDetachedFromWindow();
        this.f67226f0.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.V1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.V1 = null;
        }
        ValueAnimator valueAnimator2 = this.W1;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.W1 = null;
        }
        if (this.f67258o2) {
            this.f67258o2 = false;
            s(this.f67274t2);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.Z.isFinished()) {
            this.Z.abortAnimation();
        }
        if (this.U.isHighLight()) {
            return true;
        }
        T4(InteractionMode.PREPARE_DRAG, 8);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        i6.d.b("onFling");
        boolean z11 = false;
        if (this.U != InteractionMode.DRAG_KLINE) {
            return false;
        }
        if (this.f67282w0 * ((float) this.Y0.size()) > ((float) this.f67202g)) {
            z11 = true;
        }
        if (z11) {
            l0((int) (-f11), (int) f12, k());
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        InteractionMode interactionMode;
        if (!this.J0 && (interactionMode = this.U) != InteractionMode.SCALE && interactionMode != InteractionMode.DRAG_HIGH_LIGHT && this.Y == Fingers.ONE) {
            L4(motionEvent, true);
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        this.f67247l2.removeMessages(200);
        if (this.U != InteractionMode.SCALE || System.currentTimeMillis() - this.N0 >= this.O0) {
            InteractionMode interactionMode = this.U;
            if (interactionMode == InteractionMode.DRAG_HIGH_LIGHT) {
                return false;
            }
            if (interactionMode == InteractionMode.TOUCH_HIGH_LIGHT) {
                u3();
            }
            InteractionMode interactionMode2 = this.U;
            InteractionMode interactionMode3 = InteractionMode.DRAG_KLINE;
            if (interactionMode2 != interactionMode3 && !M3(motionEvent, motionEvent2)) {
                T4(interactionMode3, 9);
                if (motionEvent != null) {
                    this.f67237i2.x = motionEvent.getX();
                    this.f67237i2.y = motionEvent.getY();
                }
            }
            if (this.U != interactionMode3) {
                return false;
            }
            PointF pointF = this.f67234h2;
            PointF pointF2 = this.f67237i2;
            pointF.x = pointF2.x;
            pointF.y = pointF2.y;
            pointF2.x = motionEvent2.getX();
            this.f67237i2.y = motionEvent2.getY();
            w((int) (this.f67234h2.x - this.f67237i2.x), 0);
            e0(D3(this.f67237i2, this.f67234h2), false);
            return true;
        }
        i6.d.b("onScroll 刚结束完缩放，不能滚动");
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.J0) {
            u3();
            return true;
        } else if (this.f67226f0.onSingleTapUp(motionEvent)) {
            return true;
        } else {
            if (this.U == InteractionMode.DRAG_HIGH_LIGHT) {
                u3();
                this.f67247l2.removeMessages(200);
            } else if (I3(motionEvent)) {
                L4(motionEvent, false);
            } else {
                u3();
            }
            return true;
        }
    }

    public int p0() {
        return this.K;
    }

    public List<DataSetIndex> p1() {
        return this.Q0;
    }

    public Matrix p2() {
        return this.Q;
    }

    public int p3() {
        return this.I;
    }

    public void p4(int i11) {
        this.f67239j1 = i11;
    }

    public int q0() {
        return this.L;
    }

    public KlineInfo q1() {
        return this.U1;
    }

    public Matrix q2() {
        return this.O;
    }

    public Drawable q3() {
        return this.R1;
    }

    public void q4(boolean z11) {
        this.f67248m = z11;
    }

    public List<BSTShape> r0() {
        return this.f67281w;
    }

    public Fingers r1() {
        return this.Y;
    }

    public Map<Long, KlineFixInfo> r2() {
        return this.X0;
    }

    public int r3() {
        return this.f67211a0.L();
    }

    public void r4(boolean z11) {
        this.F = z11;
    }

    public j s0() {
        return this.f67229g0;
    }

    public int s1() {
        return this.f67278v;
    }

    public OverScroller s2() {
        return this.Z;
    }

    public List<HashMap<Integer, Double>> s3() {
        return this.f67218c1;
    }

    public void s4(boolean z11) {
        this.I0 = z11;
    }

    public void t(boolean z11) {
        super.t(z11);
        if (this.f67228f2 == null && (this.f67232h0.getContext() instanceof MarketInfoActivity)) {
            this.f67228f2 = (SmartRefreshLayout) ((Activity) this.f67232h0.getContext()).findViewById(R$id.market_info_refresh);
        }
        SmartRefreshLayout smartRefreshLayout = this.f67228f2;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setEnabled(!z11);
        }
    }

    public KlineInfo t0() {
        return this.S1;
    }

    public KlineInfo t1() {
        if (!UtilCollections.f(this.Y0)) {
            return this.Y0.get(0);
        }
        return null;
    }

    public Matrix t2() {
        return this.P;
    }

    public List<DataSetIndex> t3() {
        return this.W0;
    }

    public void t4(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.Q0.clear();
        List<DataSetIndex> list = this.Q0;
        int i19 = this.f67230g1[1];
        list.add(new DataSetIndex(i11, i19, "EMA" + i11));
        List<DataSetIndex> list2 = this.Q0;
        int i21 = this.f67230g1[2];
        list2.add(new DataSetIndex(i12, i21, "EMA" + i12));
        List<DataSetIndex> list3 = this.Q0;
        int i22 = this.f67230g1[3];
        list3.add(new DataSetIndex(i13, i22, "EMA" + i13));
        List<DataSetIndex> list4 = this.Q0;
        int i23 = this.f67230g1[4];
        list4.add(new DataSetIndex(i14, i23, "EMA" + i14));
        List<DataSetIndex> list5 = this.Q0;
        int i24 = this.f67230g1[5];
        list5.add(new DataSetIndex(i15, i24, "EMA" + i15));
        List<DataSetIndex> list6 = this.Q0;
        int i25 = this.f67230g1[6];
        list6.add(new DataSetIndex(i16, i25, "EMA" + i16));
        List<DataSetIndex> list7 = this.Q0;
        int i26 = this.f67230g1[7];
        list7.add(new DataSetIndex(i17, i26, "EMA" + i17));
        List<DataSetIndex> list8 = this.Q0;
        int i27 = this.f67230g1[8];
        list8.add(new DataSetIndex(i18, i27, "EMA" + i18));
    }

    public String toString() {
        return "CandleStickRender(isCoin=" + y3() + ", isContracts=" + A3() + ", maxDisplayNum=" + z2() + ", maxScreenNum=" + A2() + ", minScreenNum=" + B2() + ", defScreenNum=" + i1() + ", defTLScreenNum=" + j1() + ", axisInBottom=" + x3() + ", overScrollLeftWidth=" + G2() + ", overScrollRightWidth=" + H2() + ", firstFrameXOffset=" + s1() + ", bShapes=" + r0() + ", sShapes=" + W2() + ", tShapes=" + j3() + ", positions=" + J2() + ", limits=" + e2() + ", plans=" + I2() + ", gridPriceDatas=" + C1() + ", gridPriceMinMax=" + D1() + ", isIndexSymbol=" + G3() + ", isContractIndex=" + z3() + ", symbolId=" + i3() + ", pricePrecision=" + Q2() + ", volPrecision=" + p3() + ", axisMarginLeft=" + o0() + ", axisMarginRight=" + p0() + ", axisMarginTop=" + q0() + ", axisMarginBottom=" + n0() + ", landscape=" + J3() + ", mKMatrix=" + q2() + ", mVolMatrix=" + t2() + ", mIndexMatrix=" + p2() + ", detector=" + k1() + ", kLineType=" + N1() + ", initThisKlineTypeData=" + H3() + ", interactionMode=" + M1() + ", reqDataStatus=" + T2() + ", onLoadMoreDataListener=" + F2() + ", dragStatus=" + l1() + ", fingers=" + r1() + ", mScroller=" + s2() + ", layerGrid=" + a2() + ", layerKline=" + c2() + ", layerTimeLine=" + d2() + ", layerCoordinateLabel=" + Y1() + ", layerHighLight=" + b2() + ", layerBreathingLight=" + X1() + ", baseKline=" + s0() + ", renderView=" + S2() + ", layerDrawLine=" + Z1() + ", masterIndex=" + x2() + ", slaveIndex1=" + d3() + ", slaveIndex2=" + e3() + ", gridBoxWidth=" + B1() + ", curScreenNum=" + d1() + ", offsetLeft=" + D2() + ", offsetRight=" + E2() + ", offsetHighLight=" + C2() + ", candleAndSpaceWidth=" + C0() + ", candleAndSpaceWidthDefault=" + D0() + ", candleAndSpaceWidthMin=" + F0() + ", candleAndSpaceWidthMax=" + E0() + ", candleWidth=" + G0() + ", localMaxValue=" + j2() + ", localMinValue=" + l2() + ", localMaxIndex=" + i2() + ", localMinIndex=" + k2() + ", localAmountMaxValue=" + g2() + ", localAmountMinValue=" + h2() + ", localAmountMax=" + f2() + ", drawLineLayerEnable=" + C3() + ", inDrawMode=" + E3() + ", inDrawing=" + F3() + ", iHighLightVisiableChangeListerner=" + I1() + ", iKlineDragLeftOrRightListerner=" + J1() + ", lastScaleTime=" + W1() + ", scaleTrans2DragGapTime=" + X2() + ", priceMaDataSetIndex=" + P2() + ", eMaDataSetIndex=" + p1() + ", volMaDataSetIndex=" + o3() + ", bollDataSetIndex=" + x0() + ", macdDataSetIndex=" + u2() + ", kdjDataSetIndex=" + P1() + ", rsiDataSetIndex=" + V2() + ", wrDataSetIndex=" + t3() + ", mProFixPriceMap=" + r2() + ", globalKlineInfoList=" + z1() + ", priceMaArray=" + N2() + ", eMaArray=" + n1() + ", rsiArray=" + U2() + ", wrArray=" + s3() + ", volMaArray=" + m3() + ", kdjArray=" + O1() + ", globalKlineInfoTSList=" + A1() + ", indexColors=" + Arrays.toString(K1()) + ", magnifierBgColor=" + v2() + ", magnifierBgShadowColor=" + w2() + ", colorRaise=" + Q0() + ", colorDown=" + J0() + ", colorGrid=" + K0() + ", colorLaimb=" + O0() + ", colorMaxMinPrice=" + P0() + ", colorHighLightCrossTextColor=" + M0() + ", colorHighLightCrossBg=" + L0() + ", colorHighLightRectBg=" + N0() + ", colorCrossDashLine=" + I0() + ", highLightTagTextColor=" + H1() + ", highLightTagBorderColor=" + G1() + ", highLightRightKlastTextColor=" + F1() + ", highLightRightKlastBgColor=" + E1() + ", colorTimeLine=" + R0() + ", colorTimeLineToday=" + U0() + ", colorTimeLineShadowArray=" + Arrays.toString(S0()) + ", colorTimeLineShadowPosition=" + Arrays.toString(T0()) + ", colorTimeLineVol=" + V0() + ", floatBoxEdgeColor=" + w1() + ", floatBoxEdgeShadowColor=" + x1() + ", floatBoxBgColor=" + v1() + ", floatBoxArrow=" + u1() + ", breathingCenterColor=" + y0() + ", breathingEdgeColor=" + z0() + ", breathingShadowCenterColor=" + A0() + ", breathingShadowEdgeColor=" + B0() + ", contentBackgroundColor=" + W0() + ", primaryTextColor=" + R2() + ", secondaryTextColor=" + a3() + ", threeTextColor=" + l3() + ", fourTextColor=" + y1() + ", deathLightCenterColor=" + h1() + ", bgMaster=" + u0() + ", bgSlave=" + v0() + ", waterLogo=" + q3() + ", begUpdateLastKlineInfo=" + t0() + ", curUpdateLastKlineInfo=" + f1() + ", endUpdateLastKlineInfo=" + q1() + ", priceChangeAnimator=" + L2() + ", appendKLineAnimator=" + m0() + ", lastKLineCandleAndSpaceWidth=" + T1() + ", needResizeWhenDataReady=" + K3() + ", startUpdateLastKlineRunnable=" + h3() + ", startAppendDataAnimation=" + g3() + ", slaveIndexChangeRunnable=" + f3() + ", masterIndexChangeRunnable=" + y2() + ", klineTypeChangeRunnable=" + R1() + ", klineDataChangeRunnable=" + Q1() + ", mFragmentMarketRootView=" + n2() + ", mCurrentDownEvent=" + m2() + ", singlePreMovePoint=" + c3() + ", singleCurMovePoint=" + b3() + ", currentInfo=" + g1() + ", tempMovePoint=" + k3() + ", mHandler=" + o2() + ", preTwoFingerEvent=" + K2() + ", curTwoFingerEvent=" + e1() + ", isOpenCountDown=" + L3() + ", countDownLabel=" + a1() + ", countDownTime=" + c1() + ", lastId=" + S1() + ", lastKLineType=" + U1() + ", countDownRunnable=" + b1() + ")";
    }

    public Drawable u0() {
        return this.P1;
    }

    public Drawable u1() {
        return this.E1;
    }

    public List<DataSetIndex> u2() {
        return this.T0;
    }

    public void u3() {
        this.f67279v0 = -1;
        y yVar = this.f67223e0;
        if (yVar != null) {
            yVar.Y0((KlineInfo) null, true);
        }
        T4(InteractionMode.NONE, 4);
        s5.a aVar = this.L0;
        if (aVar != null) {
            aVar.a((KlineInfo) null, false);
        }
        m();
    }

    public synchronized void u4(List<? extends KlineInfo> list, boolean z11) {
        v(new b(this, list));
    }

    public Drawable v0() {
        return this.Q1;
    }

    public int v1() {
        return this.D1;
    }

    public int v2() {
        return this.f67233h1;
    }

    public final void v3(int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            this.Z0.add(i11, new HashMap(0));
            this.f67212a1.add(i11, new HashMap(0));
            this.f67221d1.add(i11, new HashMap(0));
            this.f67218c1.add(i11, new HashMap(0));
            this.f67215b1.add(i11, new HashMap(0));
            this.f67224e1.add(i11, new HashMap(0));
        }
    }

    public void v4(List<?> list, int i11) {
        if (i11 == 3) {
            this.C = list;
        } else if (i11 == 4) {
            this.D = list;
        }
        q();
    }

    public Bitmap w0() {
        int measuredWidth = this.f67232h0.getMeasuredWidth();
        int measuredHeight = this.f67232h0.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        this.f67232h0.draw(canvas);
        canvas.save();
        return createBitmap;
    }

    public int w1() {
        return this.B1;
    }

    public int w2() {
        return this.f67236i1;
    }

    public void w3() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.V1 = ofFloat;
        ofFloat.setDuration(300);
        this.V1.addUpdateListener(this);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.W1 = ofFloat2;
        ofFloat2.setDuration(300);
        this.W1.addUpdateListener(this);
    }

    public void w4(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33) {
        int i34 = i11;
        int i35 = i12;
        int i36 = i13;
        int i37 = i14;
        int i38 = i15;
        int i39 = i16;
        int i40 = i17;
        int i41 = i18;
        int i42 = i28;
        int i43 = i29;
        int i44 = i30;
        int i45 = i31;
        int i46 = i32;
        int i47 = i33;
        this.P0.clear();
        List<DataSetIndex> list = this.P0;
        int i48 = this.f67230g1[1];
        list.add(new DataSetIndex(i34, i48, "MA" + i34));
        List<DataSetIndex> list2 = this.P0;
        int i49 = this.f67230g1[2];
        list2.add(new DataSetIndex(i35, i49, "MA" + i35));
        List<DataSetIndex> list3 = this.P0;
        int i50 = this.f67230g1[3];
        list3.add(new DataSetIndex(i36, i50, "MA" + i36));
        List<DataSetIndex> list4 = this.P0;
        int i51 = this.f67230g1[4];
        list4.add(new DataSetIndex(i37, i51, "MA" + i37));
        List<DataSetIndex> list5 = this.P0;
        int i52 = this.f67230g1[5];
        list5.add(new DataSetIndex(i38, i52, "MA" + i38));
        List<DataSetIndex> list6 = this.P0;
        int i53 = this.f67230g1[6];
        list6.add(new DataSetIndex(i39, i53, "MA" + i39));
        List<DataSetIndex> list7 = this.P0;
        int i54 = this.f67230g1[7];
        list7.add(new DataSetIndex(i40, i54, "MA" + i40));
        List<DataSetIndex> list8 = this.P0;
        int i55 = this.f67230g1[8];
        list8.add(new DataSetIndex(i41, i55, "MA" + i41));
        this.R0.clear();
        this.R0.add(new DataSetIndex(5, this.f67230g1[1], "MA5"));
        this.R0.add(new DataSetIndex(10, this.f67230g1[2], "MA10"));
        this.S0.clear();
        this.S0.add(new DataSetIndex(i19, this.f67230g1[1], ""));
        this.S0.add(new DataSetIndex(i21, this.f67230g1[2], ""));
        this.T0.clear();
        this.T0.add(new DataSetIndex(i22, this.f67230g1[0], "MACD"));
        this.T0.add(new DataSetIndex(i23, this.f67230g1[1], "DIF"));
        this.T0.add(new DataSetIndex(i24, this.f67230g1[2], "DEA"));
        this.U0.clear();
        this.U0.add(new DataSetIndex(i25, this.f67230g1[1], "K"));
        this.U0.add(new DataSetIndex(i26, this.f67230g1[2], "D"));
        this.U0.add(new DataSetIndex(i27, this.f67230g1[3], "J"));
        this.V0.clear();
        List<DataSetIndex> list9 = this.V0;
        int i56 = this.f67230g1[1];
        list9.add(new DataSetIndex(i42, i56, "RSI(" + i42 + ")"));
        List<DataSetIndex> list10 = this.V0;
        int i57 = this.f67230g1[2];
        list10.add(new DataSetIndex(i43, i57, "RSI(" + i43 + ")"));
        List<DataSetIndex> list11 = this.V0;
        int i58 = this.f67230g1[3];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RSI(");
        int i59 = i30;
        sb2.append(i59);
        sb2.append(")");
        list11.add(new DataSetIndex(i59, i58, sb2.toString()));
        this.W0.clear();
        List<DataSetIndex> list12 = this.W0;
        int i60 = this.f67230g1[1];
        StringBuilder sb3 = new StringBuilder();
        sb3.append("WR(");
        int i61 = i31;
        sb3.append(i61);
        sb3.append(")");
        list12.add(new DataSetIndex(i61, i60, sb3.toString()));
        List<DataSetIndex> list13 = this.W0;
        int i62 = this.f67230g1[2];
        StringBuilder sb4 = new StringBuilder();
        sb4.append("WR(");
        int i63 = i32;
        sb4.append(i63);
        sb4.append(")");
        list13.add(new DataSetIndex(i63, i62, sb4.toString()));
        List<DataSetIndex> list14 = this.W0;
        int i64 = this.f67230g1[3];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WR(");
        int i65 = i33;
        sb5.append(i65);
        sb5.append(")");
        list14.add(new DataSetIndex(i65, i64, sb5.toString()));
        if (B3()) {
            i4(this.f67225e2, 10);
        }
    }

    public List<DataSetIndex> x0() {
        return this.S0;
    }

    public int x1() {
        return this.C1;
    }

    public int x2() {
        return this.f67238j0;
    }

    public boolean x3() {
        return this.f67268s;
    }

    public void x4(boolean z11) {
        this.E = z11;
    }

    public int y0() {
        return this.F1;
    }

    public int y1() {
        return this.N1;
    }

    public Runnable y2() {
        return this.f67219c2;
    }

    public boolean y3() {
        return this.f67244l;
    }

    public void y4(boolean z11) {
        this.f67244l = z11;
    }

    public int z0() {
        return this.G1;
    }

    public List<KlineInfo> z1() {
        return this.Y0;
    }

    public int z2() {
        return this.f67252n;
    }

    public boolean z3() {
        return this.F;
    }

    public void z4(KLineType kLineType) {
        KLineType kLineType2 = this.S;
        this.S = kLineType;
        if (kLineType2 == kLineType) {
            return;
        }
        if (kLineType == null) {
            this.f67222d2.run();
        } else {
            i4(this.f67222d2, 10);
        }
    }
}
