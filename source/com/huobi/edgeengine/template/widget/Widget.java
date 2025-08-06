package com.huobi.edgeengine.template.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.KeyboardUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.pop.EngineAndroidXDialogFragment;
import com.huobi.edgeengine.util.IdentifierUtil;
import com.huobi.edgeengine.util.Utils;
import com.huobi.edgeengine.util.ViewUtils;
import com.huobi.points.entity.PointsPack;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rj.n;

public abstract class Widget {

    /* renamed from: g0  reason: collision with root package name */
    public static final Pattern f44144g0 = Pattern.compile("\\{\\{\\s*(?:@((?:[a-zA-Z0-9])+)((?:\\.[a-zA-Z0-9\\.]\\w*)+)\\s*(?:\\|\\s*(?:@i18n\\/([a-zA-Z]\\w*)|(.+?))\\s*)?|(?:@i18n\\/([a-zA-Z]\\w*))\\s*|(?:@color\\/([a-zA-Z]\\w*))\\s*)\\}\\}");
    public float A;
    public float B;
    public float C;
    public Float D;
    public String E;
    public String F;
    public int G = 0;
    public String H;
    public String I;
    public String J;
    public float K;
    public float L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public float S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public com.cpiz.android.bubbleview.b Z;

    /* renamed from: a  reason: collision with root package name */
    public String f44145a;

    /* renamed from: a0  reason: collision with root package name */
    public EngineAndroidXDialogFragment f44146a0;

    /* renamed from: b  reason: collision with root package name */
    public String f44147b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f44148b0 = false;

    /* renamed from: c  reason: collision with root package name */
    public String f44149c;

    /* renamed from: c0  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44150c0;

    /* renamed from: d  reason: collision with root package name */
    public String f44151d;

    /* renamed from: d0  reason: collision with root package name */
    public rj.b f44152d0;

    /* renamed from: e  reason: collision with root package name */
    public String f44153e;

    /* renamed from: e0  reason: collision with root package name */
    public rj.n f44154e0;

    /* renamed from: f  reason: collision with root package name */
    public String f44155f;

    /* renamed from: f0  reason: collision with root package name */
    public List<TraceMap.a> f44156f0 = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public String f44157g;

    /* renamed from: h  reason: collision with root package name */
    public String f44158h;

    /* renamed from: i  reason: collision with root package name */
    public String f44159i;

    /* renamed from: j  reason: collision with root package name */
    public int f44160j;

    /* renamed from: k  reason: collision with root package name */
    public int f44161k;

    /* renamed from: l  reason: collision with root package name */
    public int f44162l;

    /* renamed from: m  reason: collision with root package name */
    public int f44163m;

    /* renamed from: n  reason: collision with root package name */
    public int f44164n = Integer.MIN_VALUE;

    /* renamed from: o  reason: collision with root package name */
    public int f44165o = Integer.MIN_VALUE;

    /* renamed from: p  reason: collision with root package name */
    public String f44166p;

    /* renamed from: q  reason: collision with root package name */
    public String f44167q;

    /* renamed from: r  reason: collision with root package name */
    public String f44168r;

    /* renamed from: s  reason: collision with root package name */
    public int f44169s = 0;

    /* renamed from: t  reason: collision with root package name */
    public String f44170t;

    /* renamed from: u  reason: collision with root package name */
    public String f44171u;

    /* renamed from: v  reason: collision with root package name */
    public int f44172v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f44173w;

    /* renamed from: x  reason: collision with root package name */
    public float f44174x;

    /* renamed from: y  reason: collision with root package name */
    public float f44175y;

    /* renamed from: z  reason: collision with root package name */
    public float f44176z;

    public class a extends c<View> {
        public a(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            try {
                view.setAlpha(Float.parseFloat(str));
            } catch (Exception unused) {
            }
        }
    }

    public class b extends b {
        public b(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if ("gone".equals(str)) {
                view.setVisibility(8);
            } else if ("visible".equals(str)) {
                view.setVisibility(0);
            } else if (PointsPack.STATE_INVISIBLE.equals(str)) {
                view.setVisibility(4);
            }
        }
    }

    public class c extends ViewOutlineProvider {
        public c() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), Widget.this.C);
        }
    }

    public class d extends b {
        public d(View view) {
            super(view);
        }

        public void b(View view, String str) {
            try {
                int A = Widget.this.A(view.getContext(), Float.parseFloat(str));
                Widget widget = Widget.this;
                if (A != widget.f44173w) {
                    widget.f44173w = A;
                    widget.R(view);
                    Widget widget2 = Widget.this;
                    int i11 = widget2.f44173w;
                    if (i11 > 0) {
                        int i12 = widget2.f44164n;
                        if (i12 != Integer.MIN_VALUE) {
                            i12 += i11;
                        }
                        int i13 = widget2.f44165o;
                        if (i13 != Integer.MIN_VALUE) {
                            i13 += i11;
                        }
                        int i14 = widget2.f44162l + i11;
                        int i15 = widget2.f44163m + i11;
                        view.setPadding(widget2.f44160j + i11, i14, widget2.f44161k + i11, i15);
                        if (i12 != Integer.MIN_VALUE || i13 != Integer.MIN_VALUE) {
                            view.setPaddingRelative(Math.max(i12, 0), i14, Math.max(i13, 0), i15);
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.e("EdgeEngine.Widget", "borderWidth parse error!", th2);
            }
        }
    }

    public class e extends b {
        public e(View view) {
            super(view);
        }

        public void b(View view, String str) {
            try {
                float parseFloat = Float.parseFloat(str);
                Widget widget = Widget.this;
                if (parseFloat != widget.S) {
                    widget.S = parseFloat;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).weight = Widget.this.S;
                        view.requestLayout();
                    }
                }
            } catch (Throwable th2) {
                Log.e("EdgeEngine.Widget", "weight parse error!", th2);
            }
        }
    }

    public class f extends c<View> {
        public f(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            try {
                if (com.sumsub.sns.internal.core.analytics.d.f31895b.equals(str)) {
                    view.setEnabled(false);
                } else {
                    view.setEnabled(true);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class g extends b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ rj.n f44183b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(View view, rj.n nVar) {
            super(view);
            this.f44183b = nVar;
        }

        public void b(View view, String str) {
            Context context = view.getContext();
            if ((context instanceof Activity) && context == Utils.f44364b.get()) {
                if ("true".equals(str)) {
                    Widget.this.V(context, view, this.f44183b);
                } else if (com.sumsub.sns.internal.core.analytics.d.f31895b.equals(str)) {
                    Widget.this.r();
                }
            }
        }
    }

    public class h extends b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f44185b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(View view, t tVar) {
            super(view);
            this.f44185b = tVar;
        }

        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("#")) {
                    try {
                        this.f44185b.a(Color.parseColor(str));
                    } catch (Throwable th2) {
                        Log.e("EdgeEngine.Widget", "getColor Error:" + str);
                        th2.printStackTrace();
                    }
                } else {
                    try {
                        if (str.startsWith("@color/")) {
                            str = str.substring(7);
                        }
                        this.f44185b.a(ContextCompat.getColor(view.getContext(), IdentifierUtil.a(view.getContext(), str, "color")));
                    } catch (Throwable th3) {
                        Log.e("EdgeEngine.Widget", "getColor form id Error:" + str);
                        th3.printStackTrace();
                    }
                }
                Widget.this.R(view);
            }
        }
    }

    public class i extends b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f44187b;

        public class a extends b {
            public a(View view) {
                super(view);
            }

            public void b(View view, String str) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("#")) {
                        try {
                            i.this.f44187b.a(Color.parseColor(str));
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } else {
                        try {
                            if (str.startsWith("@color/")) {
                                str = str.substring(7);
                            }
                            i.this.f44187b.a(ContextCompat.getColor(view.getContext(), IdentifierUtil.a(view.getContext(), str, "color")));
                        } catch (Throwable th3) {
                            Log.e("EdgeEngine.Widget", "getColor form id Error:" + str);
                            th3.printStackTrace();
                        }
                    }
                    Widget.this.R(view);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(View view, t tVar) {
            super(view);
            this.f44187b = tVar;
        }

        public void b(View view, String str) {
            Widget.this.u(str, new a(view));
        }
    }

    public static /* synthetic */ class j {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44190a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection[] r0 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44190a = r0
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f44190a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f44190a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Left     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f44190a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Right     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.template.widget.Widget.j.<clinit>():void");
        }
    }

    public class k extends c<View> {
        public k(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                view.setTag(str);
            }
        }
    }

    public class l extends c<View> {
        public l(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            int i11;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            try {
                if ("match_parent".equals(str)) {
                    i11 = -1;
                } else if ("wrap_content".equals(str)) {
                    i11 = -2;
                } else {
                    try {
                        i11 = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    } catch (Exception unused) {
                        i11 = 0;
                    }
                }
                layoutParams.width = i11;
                view.setLayoutParams(layoutParams);
            } catch (Throwable unused2) {
            }
        }
    }

    public class m extends c<View> {
        public m(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            int i11;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            try {
                if ("match_parent".equals(str)) {
                    i11 = -1;
                } else if ("wrap_content".equals(str)) {
                    i11 = -2;
                } else {
                    try {
                        i11 = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    } catch (Exception unused) {
                        i11 = 0;
                    }
                }
                layoutParams.height = i11;
                view.setLayoutParams(layoutParams);
            } catch (Throwable unused2) {
            }
        }
    }

    public class n extends c<View> {
        public n(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class o extends c<View> {
        public o(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class p extends c<View> {
        public p(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class q extends c<View> {
        public q(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = Widget.this.A(view.getContext(), Float.parseFloat(str));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class r extends c<View> {
        public r(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(Widget.this.A(view.getContext(), Float.parseFloat(str)));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class s extends c<View> {
        public s(View view) {
            super(view);
        }

        /* renamed from: c */
        public void b(View view, String str) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                try {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(Widget.this.A(view.getContext(), Float.parseFloat(str)));
                    view.setLayoutParams(layoutParams);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public interface t {
        void a(int i11);
    }

    public interface u {
        void a(String str);
    }

    public static /* synthetic */ void D(List list, int i11, String str, u uVar, StringBuffer stringBuffer, Object obj) {
        String str2;
        if (obj == null) {
            list.set(i11, str);
            uVar.a(String.format(stringBuffer.toString(), list.toArray()));
            return;
        }
        if ((obj instanceof List) || (obj instanceof Map)) {
            str2 = JSON.toJSON(obj).toString();
        } else {
            str2 = obj.toString();
        }
        list.set(i11, str2);
        uVar.a(String.format(stringBuffer.toString(), list.toArray()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(String str) {
        this.f44152d0.I(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(int i11) {
        this.f44172v = i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(int i11) {
        this.f44169s = i11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H(rj.n nVar, View view) {
        z(this.f44166p, nVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(Widget widget) {
        if (widget != null) {
            try {
                widget.O();
            } catch (Throwable th2) {
                this.f44148b0 = false;
                throw th2;
            }
        }
        if (TextUtils.isEmpty(this.U)) {
            this.f44148b0 = false;
            return;
        }
        z(this.U, this.f44154e0);
        this.f44148b0 = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view, Context context, rj.n nVar) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44150c0);
        view.postDelayed(new yj.t(this, context, view, nVar), 100);
    }

    public static /* synthetic */ boolean L(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(Widget widget, WindowManager.LayoutParams layoutParams, Window window, rj.n nVar) {
        if (widget != null) {
            widget.O();
        }
        layoutParams.alpha = 1.0f;
        window.setAttributes(layoutParams);
        if (!TextUtils.isEmpty(this.U)) {
            z(this.U, nVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Widget widget, rj.n nVar) {
        if (widget != null) {
            widget.O();
        }
        if (!TextUtils.isEmpty(this.U)) {
            z(this.U, nVar);
        }
    }

    public int A(Context context, float f11) {
        return (int) ((f11 * ((float) ViewUtils.a(context))) / 375.0f);
    }

    public float B(Context context, float f11) {
        return (f11 * ((float) ViewUtils.a(context))) / 375.0f;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|(3:31|32|34)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|(3:31|32|34)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|34) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0200 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x020a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0214 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x021e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0229 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0234 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x023f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x024a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0255 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x01d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x01e2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x01ec */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x01f6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(android.content.Context r19, java.util.Map<java.lang.String, java.lang.String> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "width"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44145a = r3
            java.lang.String r3 = "height"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44147b = r3
            java.lang.String r3 = "marginStart"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44151d = r3
            java.lang.String r3 = "marginEnd"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44153e = r3
            java.lang.String r3 = "marginLeft"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44157g = r3
            java.lang.String r3 = "marginTop"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44149c = r3
            java.lang.String r3 = "marginBottom"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44159i = r3
            java.lang.String r3 = "marginRight"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.f44158h = r3
            java.lang.String r3 = "enable"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.W = r3
            java.lang.String r3 = "paddingLeft"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "paddingTop"
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "paddingBottom"
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "paddingRight"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "paddingStart"
            java.lang.Object r7 = r2.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "paddingEnd"
            java.lang.Object r8 = r2.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "weight"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            r0.Q = r9
            java.lang.String r9 = "borderWidth"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            r0.R = r9
            java.lang.String r9 = "cornerRadius"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = "topLeftRadius"
            java.lang.Object r10 = r2.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r11 = "topRightRadius"
            java.lang.Object r11 = r2.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "bottomLeftRadius"
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "bottomRightRadius"
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "clipRadius"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = "onClick"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.f44166p = r15
            java.lang.String r15 = "background"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.f44167q = r15
            java.lang.String r15 = "gravity"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.E = r15
            java.lang.String r15 = "layout_gravity"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.F = r15
            java.lang.String r15 = "visibility"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.H = r15
            java.lang.String r15 = "layoutDirection"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.f44155f = r15
            java.lang.String r15 = "borderColor"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.f44170t = r15
            java.lang.String r15 = "opacity"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r0.f44171u = r15
            java.lang.String r15 = "popArrowDirection"
            java.lang.Object r16 = r2.get(r15)
            r17 = r14
            r14 = r16
            java.lang.String r14 = (java.lang.String) r14
            r0.J = r14
            java.lang.String r14 = "popCancelOnTouch"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.X = r14
            java.lang.String r14 = "popCancelOnTouchOutside"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.Y = r14
            java.lang.String r14 = "popTemplate"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.I = r14
            java.lang.String r14 = "popShow"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.M = r14
            java.lang.String r14 = "popShowMode"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.N = r14
            java.lang.String r14 = "popModalPositon"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.O = r14
            java.lang.String r14 = "popModalFullScreen"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            r0.P = r14
            java.lang.Object r14 = r2.get(r15)
            java.lang.String r14 = (java.lang.String) r14
            r0.J = r14
            java.lang.String r14 = "popArrowWidth"
            java.lang.Object r14 = r2.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = "popArrowHeight"
            java.lang.Object r15 = r2.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            r16 = r13
            r13 = 1092616192(0x41200000, float:10.0)
            int r13 = com.huobi.edgeengine.util.Utils.a(r1, r13)
            float r13 = (float) r13
            r0.K = r13
            r13 = 1086324736(0x40c00000, float:6.0)
            int r13 = com.huobi.edgeengine.util.Utils.a(r1, r13)
            float r13 = (float) r13
            r0.L = r13
            java.lang.String r13 = "popBackgroundDimmed"
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            r0.T = r13
            java.lang.String r13 = "onPopDismiss"
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            r0.U = r13
            java.lang.String r13 = "tag"
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            r0.V = r13
            java.lang.String r13 = "clipChildren"
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            r0.f44168r = r13
            float r13 = java.lang.Float.parseFloat(r14)     // Catch:{ Exception -> 0x01d7 }
            int r13 = r0.A(r1, r13)     // Catch:{ Exception -> 0x01d7 }
            float r13 = (float) r13     // Catch:{ Exception -> 0x01d7 }
            r0.K = r13     // Catch:{ Exception -> 0x01d7 }
        L_0x01d7:
            float r13 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x01e2 }
            int r13 = r0.A(r1, r13)     // Catch:{ Exception -> 0x01e2 }
            float r13 = (float) r13     // Catch:{ Exception -> 0x01e2 }
            r0.L = r13     // Catch:{ Exception -> 0x01e2 }
        L_0x01e2:
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x01ec }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x01ec }
            r0.f44160j = r3     // Catch:{ Exception -> 0x01ec }
        L_0x01ec:
            float r3 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x01f6 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x01f6 }
            r0.f44161k = r3     // Catch:{ Exception -> 0x01f6 }
        L_0x01f6:
            float r3 = java.lang.Float.parseFloat(r4)     // Catch:{ Exception -> 0x0200 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0200 }
            r0.f44162l = r3     // Catch:{ Exception -> 0x0200 }
        L_0x0200:
            float r3 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x020a }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x020a }
            r0.f44163m = r3     // Catch:{ Exception -> 0x020a }
        L_0x020a:
            float r3 = java.lang.Float.parseFloat(r7)     // Catch:{ Exception -> 0x0214 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0214 }
            r0.f44164n = r3     // Catch:{ Exception -> 0x0214 }
        L_0x0214:
            float r3 = java.lang.Float.parseFloat(r8)     // Catch:{ Exception -> 0x021e }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x021e }
            r0.f44165o = r3     // Catch:{ Exception -> 0x021e }
        L_0x021e:
            float r3 = java.lang.Float.parseFloat(r9)     // Catch:{ Exception -> 0x0229 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0229 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x0229 }
            r0.f44174x = r3     // Catch:{ Exception -> 0x0229 }
        L_0x0229:
            float r3 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x0234 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0234 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x0234 }
            r0.f44175y = r3     // Catch:{ Exception -> 0x0234 }
        L_0x0234:
            float r3 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x023f }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x023f }
            float r3 = (float) r3     // Catch:{ Exception -> 0x023f }
            r0.f44176z = r3     // Catch:{ Exception -> 0x023f }
        L_0x023f:
            float r3 = java.lang.Float.parseFloat(r12)     // Catch:{ Exception -> 0x024a }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x024a }
            float r3 = (float) r3     // Catch:{ Exception -> 0x024a }
            r0.A = r3     // Catch:{ Exception -> 0x024a }
        L_0x024a:
            float r3 = java.lang.Float.parseFloat(r16)     // Catch:{ Exception -> 0x0255 }
            int r3 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0255 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x0255 }
            r0.B = r3     // Catch:{ Exception -> 0x0255 }
        L_0x0255:
            float r3 = java.lang.Float.parseFloat(r17)     // Catch:{ Exception -> 0x0260 }
            int r1 = r0.A(r1, r3)     // Catch:{ Exception -> 0x0260 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x0260 }
            r0.C = r1     // Catch:{ Exception -> 0x0260 }
        L_0x0260:
            java.lang.String r1 = "popBackgroundAlpha"
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0272 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0272 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x0272 }
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ Exception -> 0x0272 }
            r0.D = r1     // Catch:{ Exception -> 0x0272 }
        L_0x0272:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.template.widget.Widget.C(android.content.Context, java.util.Map):void");
    }

    public void O() {
        for (TraceMap.a next : this.f44156f0) {
            if (next != null) {
                next.destroy();
            }
        }
        this.f44156f0.clear();
    }

    @Deprecated
    public View P(Context context) {
        return Q(context, this.f44154e0);
    }

    public View Q(Context context, rj.n nVar) {
        int i11;
        View q11 = q(context);
        w(context, this.V, new k(q11), nVar);
        q11.setLayoutParams(new ViewGroup.MarginLayoutParams(0, 0));
        if ("ltr".equals(this.f44155f)) {
            q11.setLayoutDirection(0);
        } else if ("rtl".equals(this.f44155f)) {
            q11.setLayoutDirection(1);
        }
        w(context, this.f44145a, new l(q11), nVar);
        w(context, this.f44147b, new m(q11), nVar);
        w(context, this.f44149c, new n(q11), nVar);
        w(context, this.f44159i, new o(q11), nVar);
        w(context, this.f44157g, new p(q11), nVar);
        w(context, this.f44158h, new q(q11), nVar);
        w(context, this.f44151d, new r(q11), nVar);
        w(context, this.f44153e, new s(q11), nVar);
        w(context, this.f44171u, new a(q11), nVar);
        q11.setPadding(this.f44160j, this.f44162l, this.f44161k, this.f44163m);
        int i12 = this.f44164n;
        if (!(i12 == Integer.MIN_VALUE && this.f44165o == Integer.MIN_VALUE)) {
            q11.setPaddingRelative(Math.max(i12, 0), this.f44162l, Math.max(this.f44165o, 0), this.f44163m);
        }
        w(context, this.H, new b(q11), nVar);
        if (this.C > 0.0f) {
            q11.setOutlineProvider(new c());
            q11.setClipToOutline(true);
        }
        View view = q11;
        Context context2 = context;
        rj.n nVar2 = nVar;
        v(view, this.f44170t, context2, new yj.r(this), nVar2);
        v(view, this.f44167q, context2, new yj.q(this), nVar2);
        w(context, this.R, new d(q11), nVar);
        w(context, this.Q, new e(q11), nVar);
        w(context, this.W, new f(q11), nVar);
        if (!TextUtils.isEmpty(this.f44166p)) {
            boolean isEnabled = q11.isEnabled();
            q11.setOnClickListener(new yj.j(this, nVar));
            if (!isEnabled) {
                q11.setEnabled(false);
            }
        }
        if (!TextUtils.isEmpty(this.F)) {
            int i13 = 0;
            for (String str : this.F.split("\\|")) {
                if (TtmlNode.CENTER.equals(str)) {
                    i13 |= 17;
                } else if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(str)) {
                    i13 |= 48;
                } else if ("bottom".equals(str)) {
                    i13 |= 80;
                } else if ("left".equals(str)) {
                    i13 |= 3;
                } else if (TtmlNode.RIGHT.equals(str)) {
                    i13 |= 5;
                } else if ("centerVertical".equals(str)) {
                    i13 |= 16;
                } else if ("centerHorizontal".equals(str)) {
                    i13 |= 1;
                } else {
                    if ("start".equals(str)) {
                        i11 = 8388611;
                    } else if ("end".equals(str)) {
                        i11 = 8388613;
                    }
                    i13 |= i11;
                }
            }
            if (i13 != 0) {
                this.G = i13;
            }
        }
        w(context, this.M, new g(q11, nVar), nVar);
        return q11;
    }

    public final void R(View view) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f11 = this.f44175y;
        if (f11 <= 0.0f) {
            f11 = this.f44174x;
        }
        float f12 = this.f44176z;
        if (f12 <= 0.0f) {
            f12 = this.f44174x;
        }
        float f13 = this.A;
        if (f13 <= 0.0f) {
            f13 = this.f44174x;
        }
        float f14 = this.B;
        if (f14 <= 0.0f) {
            f14 = this.f44174x;
        }
        gradientDrawable.setCornerRadii(new float[]{f11, f11, f12, f12, f14, f14, f13, f13});
        gradientDrawable.setColor(this.f44169s);
        gradientDrawable.setStroke(this.f44173w, this.f44172v);
        view.setBackground(gradientDrawable);
    }

    public void S(rj.b bVar) {
        this.f44152d0 = bVar;
    }

    public void T(rj.n nVar) {
        this.f44154e0 = nVar;
    }

    public final void U(Context context, View view, Widget widget) {
        int i11;
        int i12;
        if (TtmlNode.CENTER.equals(this.O)) {
            i11 = 1;
        } else {
            if ("left".equals(this.O)) {
                i12 = 2;
            } else if (TtmlNode.RIGHT.equals(this.O)) {
                i12 = 3;
            } else {
                i11 = 0;
            }
            i11 = i12;
        }
        boolean z11 = "1".equals(this.P) || "true".equals(this.P);
        if (this.f44146a0 == null || !this.f44148b0) {
            this.f44148b0 = true;
            this.f44146a0 = EngineAndroidXDialogFragment.f44298h.a(((FragmentActivity) context).getSupportFragmentManager(), view, i11, z11, new yj.n(this, widget), "true".equals(this.Y));
        }
    }

    public final void V(Context context, View view, rj.n nVar) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (!(context instanceof Activity) || !KeyboardUtils.l((Activity) context)) {
            J(context, view, nVar);
            return;
        }
        if (this.f44150c0 != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44150c0);
        }
        this.f44150c0 = new yj.m(this, view, context, nVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f44150c0);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0136  */
    /* renamed from: W */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void J(android.content.Context r17, android.view.View r18, rj.n r19) {
        /*
            r16 = this;
            r6 = r16
            r0 = r17
            r5 = r19
            java.lang.String r1 = r6.N
            java.lang.String r2 = "modal"
            boolean r1 = r2.equals(r1)
            r7 = 0
            if (r1 == 0) goto L_0x0021
            rj.b r1 = r6.f44152d0
            java.lang.String r2 = r6.I
            com.huobi.edgeengine.template.widget.Widget r1 = r1.G(r2, r0, r7, r5)
            android.view.View r2 = r1.Q(r0, r5)
            r6.U(r0, r2, r1)
            return
        L_0x0021:
            com.cpiz.android.bubbleview.b r1 = r6.Z
            if (r1 == 0) goto L_0x002c
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto L_0x002c
            return
        L_0x002c:
            float r1 = r6.L
            float r2 = r6.K
            com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r3 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down
            java.lang.String r4 = r6.J
            java.lang.String r8 = "up"
            boolean r4 = r8.equals(r4)
            r8 = 0
            if (r4 == 0) goto L_0x0044
            com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r3 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up
        L_0x003f:
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r7
            goto L_0x0065
        L_0x0044:
            java.lang.String r4 = r6.J
            java.lang.String r9 = "none"
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x0052
            r10 = r3
            r11 = r7
            r9 = r8
            goto L_0x0065
        L_0x0052:
            java.lang.String r4 = r6.J
            java.lang.String r8 = "down"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x003f
            int r4 = com.cpiz.android.bubbleview.Utils.d(r18)
            int r4 = -r4
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
        L_0x0065:
            com.cpiz.android.bubbleview.BubbleFrameLayout r12 = new com.cpiz.android.bubbleview.BubbleFrameLayout
            r12.<init>(r0)
            rj.b r1 = r6.f44152d0
            java.lang.String r2 = r6.I
            com.huobi.edgeengine.template.widget.Widget r2 = r1.G(r2, r0, r7, r5)
            android.view.View r1 = r2.Q(r0, r5)
            r12.addView(r1)
            com.cpiz.android.bubbleview.b r1 = new com.cpiz.android.bubbleview.b
            r1.<init>(r12, r12)
            r6.Z = r1
            r13 = 1
            r1.setTouchable(r13)
            com.cpiz.android.bubbleview.b r1 = r6.Z
            yj.l r3 = yj.l.f61762b
            r1.setTouchInterceptor(r3)
            com.cpiz.android.bubbleview.b r1 = r6.Z
            java.lang.String r3 = r6.X
            java.lang.String r4 = "true"
            boolean r3 = r4.equals(r3)
            r1.j(r3)
            com.cpiz.android.bubbleview.b r1 = r6.Z
            java.lang.String r3 = r6.Y
            java.lang.String r14 = "false"
            boolean r3 = r14.equals(r3)
            r3 = r3 ^ r13
            r1.k(r3)
            boolean r1 = r0 instanceof android.app.Activity
            r14 = 2
            if (r1 == 0) goto L_0x00f6
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            android.view.Window r15 = r1.getWindow()
            android.view.WindowManager$LayoutParams r3 = r15.getAttributes()
            java.lang.Float r1 = r6.D
            if (r1 == 0) goto L_0x00c1
            float r0 = r1.floatValue()
            r3.alpha = r0
            goto L_0x00dd
        L_0x00c1:
            java.lang.String r1 = r6.T
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00dd
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources r0 = r17.getResources()
            int r4 = com.huobi.edgeengine.R$dimen.engine_window_dimamount
            r0.getValue(r4, r1, r13)
            float r0 = r1.getFloat()
            r3.alpha = r0
        L_0x00dd:
            r15.setAttributes(r3)
            r15.addFlags(r14)
            com.cpiz.android.bubbleview.b r4 = r6.Z
            yj.o r1 = new yj.o
            r0 = r1
            r7 = r1
            r1 = r16
            r14 = r4
            r4 = r15
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            r14.setOnDismissListener(r7)
            goto L_0x0100
        L_0x00f6:
            com.cpiz.android.bubbleview.b r0 = r6.Z
            yj.p r1 = new yj.p
            r1.<init>(r6, r2, r5)
            r0.setOnDismissListener(r1)
        L_0x0100:
            r12.setArrowWidth(r9)
            r12.setArrowHeight(r8)
            int[] r0 = com.huobi.edgeengine.template.widget.Widget.j.f44190a
            int r1 = r10.ordinal()
            r0 = r0[r1]
            if (r0 == r13) goto L_0x0136
            r1 = 2
            if (r0 == r1) goto L_0x012f
            r1 = 3
            if (r0 == r1) goto L_0x0127
            r1 = 4
            if (r0 == r1) goto L_0x0120
            com.cpiz.android.bubbleview.d r0 = new com.cpiz.android.bubbleview.d
            r1 = 0
            r0.<init>(r1, r1)
            goto L_0x013d
        L_0x0120:
            r1 = 0
            com.cpiz.android.bubbleview.d r0 = new com.cpiz.android.bubbleview.d
            r0.<init>(r13, r1)
            goto L_0x013d
        L_0x0127:
            r1 = 0
            com.cpiz.android.bubbleview.d r0 = new com.cpiz.android.bubbleview.d
            r2 = 2
            r0.<init>(r2, r1)
            goto L_0x013d
        L_0x012f:
            r1 = 0
            com.cpiz.android.bubbleview.d r0 = new com.cpiz.android.bubbleview.d
            r0.<init>(r1, r13)
            goto L_0x013d
        L_0x0136:
            r1 = 0
            r2 = 2
            com.cpiz.android.bubbleview.d r0 = new com.cpiz.android.bubbleview.d
            r0.<init>(r1, r2)
        L_0x013d:
            com.cpiz.android.bubbleview.b r2 = r6.Z
            r3 = r18
            r2.m(r3, r0, r1, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.template.widget.Widget.J(android.content.Context, android.view.View, rj.n):void");
    }

    public n.c p(rj.n nVar, String str, vj.a aVar) {
        return nVar.k(str, aVar, this.f44156f0);
    }

    public abstract View q(Context context);

    public final void r() {
        com.cpiz.android.bubbleview.b bVar = this.Z;
        if (bVar != null && bVar.isShowing()) {
            this.Z.dismiss();
        }
        EngineAndroidXDialogFragment engineAndroidXDialogFragment = this.f44146a0;
        if (engineAndroidXDialogFragment != null) {
            engineAndroidXDialogFragment.dismiss();
        }
    }

    public rj.n s() {
        return this.f44154e0;
    }

    public float[] t() {
        float f11 = this.f44175y;
        if (f11 <= 0.0f) {
            f11 = this.f44174x;
        }
        float f12 = this.f44176z;
        if (f12 <= 0.0f) {
            f12 = this.f44174x;
        }
        float f13 = this.A;
        if (f13 <= 0.0f) {
            f13 = this.f44174x;
        }
        float f14 = this.B;
        if (f14 <= 0.0f) {
            f14 = this.f44174x;
        }
        return new float[]{f11, f11, f12, f12, f14, f14, f13, f13};
    }

    public boolean u(String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("#")) {
            uVar.a(str);
            return true;
        }
        Matcher matcher = Pattern.compile("^@color\\/([a-zA-Z]\\w*)").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        uVar.a(matcher.group(1));
        return true;
    }

    public void v(View view, String str, Context context, t tVar, rj.n nVar) {
        if (tVar != null && !u(str, new h(view, tVar))) {
            w(context, str, new i(view, tVar), nVar);
        }
    }

    public TraceMap.a w(Context context, String str, u uVar, rj.n nVar) {
        return x(context, str, uVar, false, nVar);
    }

    public TraceMap.a x(Context context, String str, u uVar, boolean z11, rj.n nVar) {
        TraceMap.a aVar;
        String str2;
        Context context2 = context;
        String str3 = str;
        u uVar2 = uVar;
        rj.n nVar2 = nVar;
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = f44144g0.matcher(str3);
            StringBuffer stringBuffer = new StringBuffer();
            boolean z12 = false;
            int i11 = 1;
            int i12 = 0;
            TraceMap.a aVar2 = null;
            while (matcher.find()) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                String group = matcher.group(i11);
                String group2 = matcher.group(2);
                String group3 = matcher.group(3);
                String group4 = matcher.group(4);
                String group5 = matcher.group(5);
                String group6 = matcher.group(6);
                String str4 = group;
                String str5 = "";
                if (TextUtils.isEmpty(group) || TextUtils.isEmpty(group2)) {
                    aVar = aVar2;
                    if (!TextUtils.isEmpty(group5)) {
                        try {
                            str5 = context2.getString(IdentifierUtil.a(context2, group5, "string"));
                        } catch (Exception unused) {
                        }
                        arrayList2.add(str5);
                        matcher.appendReplacement(stringBuffer, "%s");
                    } else if (!TextUtils.isEmpty(group6)) {
                        try {
                            str5 = String.valueOf(ContextCompat.getColor(context2, IdentifierUtil.a(context2, group6, "color")));
                        } catch (Exception unused2) {
                        }
                        arrayList2.add(str5);
                        matcher.appendReplacement(stringBuffer, "%s");
                    }
                } else {
                    aVar = aVar2;
                    String substring = group2.substring(1);
                    if (!TextUtils.isEmpty(group3)) {
                        try {
                            str5 = context2.getString(IdentifierUtil.a(context2, group3, "string"));
                        } catch (Exception unused3) {
                        }
                        str2 = str5;
                        arrayList2.add(str2);
                    } else {
                        str2 = group4 == null ? str5 : group4;
                        if (group4 == null) {
                            group4 = str5;
                        }
                        arrayList2.add(group4);
                    }
                    String str6 = str2;
                    matcher.appendReplacement(stringBuffer, "%s");
                    String str7 = substring;
                    String str8 = str4;
                    yj.k kVar = new yj.k(arrayList2, i12, str6, uVar, stringBuffer);
                    if (nVar2 == null) {
                        Log.e("EdgeEngine.Widget", "handleDataOrI18n engineContext null");
                    } else if (z11) {
                        arrayList2.set(i12, nVar2.t(str7, str8));
                    } else {
                        TraceMap.a F2 = nVar2.F(str7, kVar, str8);
                        if (F2 != null) {
                            this.f44156f0.add(F2);
                        }
                        aVar2 = F2;
                        i12++;
                        String str9 = str;
                        arrayList = arrayList2;
                        z12 = true;
                        i11 = 1;
                    }
                }
                aVar2 = aVar;
                i12++;
                String str92 = str;
                arrayList = arrayList2;
                z12 = true;
                i11 = 1;
            }
            TraceMap.a aVar3 = aVar2;
            if (z12) {
                matcher.appendTail(stringBuffer);
                uVar2.a(String.format(stringBuffer.toString(), arrayList.toArray()));
            } else {
                uVar2.a(str);
            }
            return aVar3;
        }
        return null;
    }

    public boolean y(String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("^@drawable\\/([a-zA-Z]\\w*)").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        uVar.a(matcher.group(1));
        return true;
    }

    public boolean z(String str, rj.n nVar) {
        if (this.f44152d0 == null || !str.startsWith("@event.")) {
            return false;
        }
        x(nVar.o(), str.substring(7), new yj.s(this), true, nVar);
        return true;
    }
}
