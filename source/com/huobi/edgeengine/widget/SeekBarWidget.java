package com.huobi.edgeengine.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.view.seekbar.MultiConfigBuilder;
import com.tencent.android.tpush.common.MessageKey;
import fk.k;
import fk.l;
import fk.m;
import fk.o;
import fk.p;
import fk.q;
import fk.r;
import fk.s;
import fk.t;
import java.util.Map;
import rj.n;
import yj.i;

public class SeekBarWidget extends Widget {
    public String A0;
    public String B0;
    public String C0;
    public String D0;
    public String E0 = "%";
    public String F0;
    public int G0 = 1;
    public String H0;

    /* renamed from: h0  reason: collision with root package name */
    public float f44411h0 = ((float) PixelUtils.j(14.0f));

    /* renamed from: i0  reason: collision with root package name */
    public String f44412i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44413j0;

    /* renamed from: k0  reason: collision with root package name */
    public float f44414k0 = 0.0f;

    /* renamed from: l0  reason: collision with root package name */
    public float f44415l0 = 100.0f;

    /* renamed from: m0  reason: collision with root package name */
    public String f44416m0;

    /* renamed from: n0  reason: collision with root package name */
    public Float f44417n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44418o0;

    /* renamed from: p0  reason: collision with root package name */
    public String f44419p0;

    /* renamed from: q0  reason: collision with root package name */
    public String f44420q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f44421r0 = PixelUtils.a(2.0f);

    /* renamed from: s0  reason: collision with root package name */
    public int f44422s0;

    /* renamed from: t0  reason: collision with root package name */
    public String f44423t0;

    /* renamed from: u0  reason: collision with root package name */
    public String f44424u0;

    /* renamed from: v0  reason: collision with root package name */
    public int f44425v0 = 4;

    /* renamed from: w0  reason: collision with root package name */
    public String f44426w0;

    /* renamed from: x0  reason: collision with root package name */
    public String f44427x0;

    /* renamed from: y0  reason: collision with root package name */
    public float f44428y0;

    /* renamed from: z0  reason: collision with root package name */
    public float f44429z0;

    public class a extends com.huobi.edgeengine.template.widget.c<MultiConfigBuilder> {
        public a(MultiConfigBuilder multiConfigBuilder) {
            super(multiConfigBuilder);
        }

        /* renamed from: c */
        public void b(MultiConfigBuilder multiConfigBuilder, String str) {
            try {
                float unused = SeekBarWidget.this.f44415l0 = Float.parseFloat(str);
                multiConfigBuilder.max(SeekBarWidget.this.f44415l0);
                if (SeekBarWidget.this.f44417n0 == null) {
                    multiConfigBuilder.setDanger(SeekBarWidget.this.f44415l0 + 0.1f);
                }
                multiConfigBuilder.build();
            } catch (Throwable unused2) {
            }
        }
    }

    public class b extends i<MultiConfigBuilder> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiConfigBuilder f44431b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MultiConfigBuilder multiConfigBuilder, MultiConfigBuilder multiConfigBuilder2) {
            super(multiConfigBuilder);
            this.f44431b = multiConfigBuilder2;
        }

        /* renamed from: b */
        public void a(MultiConfigBuilder multiConfigBuilder, Object obj) {
            if (obj != null) {
                try {
                    this.f44431b.progress(Float.parseFloat(obj.toString())).build();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class c implements MultiColorSeekBar.OnProgressChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f44433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n.c f44434b;

        public c(n nVar, n.c cVar) {
            this.f44433a = nVar;
            this.f44434b = cVar;
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (!TextUtils.isEmpty(SeekBarWidget.this.H0)) {
                String k02 = SeekBarWidget.this.H0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("true".equals(SeekBarWidget.this.F0) ? f11 : (float) i11);
                sb2.append("");
                boolean unused = SeekBarWidget.this.z(k02.replace("@eventParams", sb2.toString()), this.f44433a);
            }
            n.c cVar = this.f44434b;
            if (cVar != null) {
                StringBuilder sb3 = new StringBuilder();
                if (!"true".equals(SeekBarWidget.this.F0)) {
                    f11 = (float) i11;
                }
                sb3.append(f11);
                sb3.append("");
                cVar.a(sb3.toString());
            }
        }
    }

    public class d implements Widget.u {
        public d() {
        }

        public void a(String str) {
            float unused = SeekBarWidget.this.f44415l0 = Float.parseFloat(str);
        }
    }

    public static /* synthetic */ void n0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.bubbleColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.bubbleColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void o0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.bubbleTextColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.bubbleTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void p0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.setDangerColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.setDangerColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void q0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.setCircleColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.setCircleColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void r0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.secondTrackColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.secondTrackColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void s0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.trackColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.trackColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void t0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.sectionTextColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.sectionTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void u0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.thumbColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.thumbColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void v0(MultiConfigBuilder multiConfigBuilder, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("#")) {
                try {
                    multiConfigBuilder.thumbTextColor(Color.parseColor(str)).build();
                } catch (Throwable unused) {
                }
            } else {
                multiConfigBuilder.thumbTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName()))).build();
            }
            multiConfigBuilder.build();
        }
    }

    public static /* synthetic */ void w0(MultiConfigBuilder multiConfigBuilder, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                multiConfigBuilder.progress(Float.parseFloat(str)).build();
            } catch (Throwable unused) {
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        try {
            this.f44411h0 = (float) A(context, Float.parseFloat(map.get("bubbleTextSize")));
        } catch (Throwable unused) {
        }
        this.f44412i0 = map.get("bubbleTextColor");
        this.f44413j0 = map.get("bubbleColor");
        try {
            this.f44414k0 = Float.parseFloat(map.get(MessageKey.MSG_ACCEPT_TIME_MIN));
        } catch (Throwable unused2) {
        }
        this.f44416m0 = map.get("max");
        try {
            w(context, map.get("max"), new d(), this.f44154e0);
        } catch (Throwable unused3) {
        }
        try {
            this.f44417n0 = Float.valueOf(Float.parseFloat(map.get("danger")));
        } catch (Throwable unused4) {
        }
        this.f44418o0 = map.get("dangerColor");
        this.f44419p0 = map.get("circleColor");
        this.f44420q0 = map.get("progress");
        try {
            this.f44421r0 = A(context, Float.parseFloat(map.get("trackSize")));
        } catch (Throwable unused5) {
        }
        this.f44422s0 = this.f44421r0;
        try {
            this.f44422s0 = A(context, Float.parseFloat(map.get("secondTrackSize")));
        } catch (Throwable unused6) {
        }
        this.f44423t0 = map.get("secondTrackColor");
        this.f44424u0 = map.get("trackColor");
        try {
            this.f44425v0 = Integer.parseInt(map.get("sectionCount"));
        } catch (Throwable unused7) {
        }
        this.f44426w0 = map.get("sectionTextColor");
        this.f44427x0 = map.get("sectionTextPosition");
        this.f44428y0 = (float) PixelUtils.a(5.0f);
        try {
            this.f44428y0 = Float.parseFloat(map.get("thumbRadius"));
        } catch (Throwable unused8) {
        }
        this.f44429z0 = (float) PixelUtils.a(7.0f);
        try {
            this.f44429z0 = Float.parseFloat(map.get("thumbRadiusOnDragging"));
        } catch (Throwable unused9) {
        }
        this.A0 = map.get("thumbColor");
        this.B0 = map.get("thumbTextColor");
        this.C0 = map.get("touchToSeek");
        this.H0 = map.get("onValueChange");
        this.D0 = map.get("bindProgress");
        this.E0 = map.get("unit");
        this.F0 = map.get("showProgressInFloat");
        String str = map.get("precision");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.G0 = Integer.parseInt(str);
            } catch (Throwable unused10) {
            }
        }
    }

    public View Q(Context context, n nVar) {
        MultiColorSeekBar multiColorSeekBar = (MultiColorSeekBar) super.Q(context, nVar);
        String str = this.E0;
        if (str == null) {
            str = "%";
        }
        multiColorSeekBar.setUnit(str);
        MultiConfigBuilder configBuilder = multiColorSeekBar.getConfigBuilder();
        int i11 = 1;
        configBuilder.colorConfig(context, NightHelper.e().g(), true);
        configBuilder.precision(this.G0);
        u(this.f44413j0, new m(configBuilder, context));
        if ("true".equals(this.F0)) {
            configBuilder.showProgressInFloat();
        }
        u(this.f44412i0, new p(configBuilder, context));
        u(this.f44418o0, new q(configBuilder, context));
        u(this.f44419p0, new fk.n(configBuilder, context));
        u(this.f44423t0, new r(configBuilder, context));
        u(this.f44424u0, new l(configBuilder, context));
        u(this.f44426w0, new s(configBuilder, context));
        u(this.A0, new t(configBuilder, context));
        u(this.B0, new o(configBuilder, context));
        w(context, this.f44416m0, new a(configBuilder), nVar);
        if ("sides".equals(this.f44427x0)) {
            i11 = 0;
        } else if (!"bottom_sides".equals(this.f44427x0)) {
            "below_section_mark".equals(this.f44427x0);
            i11 = 2;
        }
        MultiConfigBuilder min = configBuilder.bubbleTextSize(PixelUtils.i(this.f44411h0)).max(this.f44415l0).min(this.f44414k0);
        Float f11 = this.f44417n0;
        min.setDanger(f11 == null ? this.f44415l0 + 0.1f : f11.floatValue()).progress(this.f44414k0).sectionTextSize(0).thumbTextSize(0).trackSize(PixelUtils.h((float) this.f44421r0)).secondTrackSize(PixelUtils.h((float) this.f44422s0)).sectionCount(this.f44425v0).sectionTextPosition(i11).thumbRadius(PixelUtils.h(this.f44428y0)).thumbRadiusOnDragging(PixelUtils.h(this.f44429z0)).touchToSeek();
        if ("true".equals(this.C0)) {
            configBuilder.touchToSeek();
        }
        configBuilder.build();
        n.c cVar = null;
        if (!TextUtils.isEmpty(this.f44420q0)) {
            w(context, this.f44420q0, new k(configBuilder), nVar);
        } else if (!TextUtils.isEmpty(this.D0)) {
            cVar = p(nVar, this.D0, new b(configBuilder, configBuilder));
        }
        multiColorSeekBar.setOnProgressChangedListener(new c(nVar, cVar));
        return multiColorSeekBar;
    }

    public View q(Context context) {
        return new MultiColorSeekBar(context);
    }
}
