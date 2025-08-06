package fe;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.constants.KlineUIConstants;
import com.hbg.module.kline.draw.LineColorEnum;
import com.hbg.module.kline.draw.LineSizeEnum;
import com.hbg.module.kline.draw.LineStyleEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import yd.b;
import yd.c;

public class y extends PopupWindow {

    /* renamed from: v  reason: collision with root package name */
    public static final int f25248v = PixelUtils.a(7.0f);

    /* renamed from: a  reason: collision with root package name */
    public Activity f25249a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f25250b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f25251c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f25252d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f25253e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25254f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f25255g;

    /* renamed from: h  reason: collision with root package name */
    public View f25256h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f25257i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f25258j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f25259k;

    /* renamed from: l  reason: collision with root package name */
    public LineColorEnum f25260l = LineColorEnum.LINE_COLOR_1;

    /* renamed from: m  reason: collision with root package name */
    public LineStyleEnum f25261m = LineStyleEnum.SOLID_LINE;

    /* renamed from: n  reason: collision with root package name */
    public LineSizeEnum f25262n = LineSizeEnum.LINE_SIZE_2;

    /* renamed from: o  reason: collision with root package name */
    public int f25263o;

    /* renamed from: p  reason: collision with root package name */
    public int f25264p;

    /* renamed from: q  reason: collision with root package name */
    public float f25265q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    public float f25266r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    public float f25267s;

    /* renamed from: t  reason: collision with root package name */
    public float f25268t;

    /* renamed from: u  reason: collision with root package name */
    public a f25269u;

    public interface a {
        void D5(b bVar);

        void G2(c cVar);

        void I9();

        void j8(yd.a aVar);

        void m9(boolean z11);
    }

    public y(Context context) {
        super(context);
        o(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.f25253e.setSelected(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(b bVar, c cVar) {
        bVar.dismiss();
        L(cVar.c());
        a aVar = this.f25269u;
        if (aVar != null) {
            aVar.G2(cVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.f25251c.setSelected(false);
    }

    public static /* synthetic */ boolean q(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 4;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        K();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        I();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        J();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        boolean z11 = !this.f25254f.isSelected();
        a aVar = this.f25269u;
        if (aVar != null) {
            aVar.m9(z11);
        }
        this.f25254f.setSelected(z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        a aVar = this.f25269u;
        if (aVar != null) {
            aVar.I9();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean w(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f25267s = motionEvent.getRawX() - ((float) this.f25263o);
            this.f25268t = motionEvent.getRawY() - ((float) this.f25264p);
        } else if (action == 1) {
            this.f25265q = 0.0f;
            this.f25266r = 0.0f;
        } else if (action == 2) {
            motionEvent.getRawX();
            motionEvent.getRawY();
            D(motionEvent.getRawX(), motionEvent.getRawY());
            this.f25265q = motionEvent.getRawX();
            this.f25266r = motionEvent.getRawY();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.f25252d.setSelected(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(d dVar, yd.a aVar) {
        dVar.dismiss();
        N(aVar.d());
        a aVar2 = this.f25269u;
        if (aVar2 != null) {
            aVar2.j8(aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(e eVar, b bVar) {
        eVar.dismiss();
        O(bVar.d());
        a aVar = this.f25269u;
        if (aVar != null) {
            aVar.D5(bVar);
        }
    }

    public final void D(float f11, float f12) {
        int i11 = (int) (f11 - this.f25267s);
        this.f25263o = i11;
        this.f25264p = (int) (f12 - this.f25268t);
        if (i11 + getWidth() > PixelUtils.g()) {
            this.f25263o = PixelUtils.g() - getWidth();
        }
        if (this.f25263o < 0) {
            this.f25263o = 0;
        }
        if (this.f25264p + getHeight() > PixelUtils.f()) {
            this.f25264p = PixelUtils.f() - getHeight();
        }
        if (this.f25264p < 0) {
            this.f25264p = 0;
        }
        update(this.f25263o, this.f25264p, getWidth(), getHeight());
    }

    public void E(boolean z11) {
        this.f25255g.setEnabled(z11);
    }

    public void F(boolean z11) {
        this.f25254f.setEnabled(z11);
    }

    public void G(a aVar) {
        this.f25269u = aVar;
    }

    public final boolean H() {
        return this.f25264p <= KlineUIConstants.f23523a;
    }

    public final void I() {
        d dVar = new d(this.f25249a);
        dVar.d(new n(this, dVar));
        dVar.c(this.f25262n);
        dVar.setOnDismissListener(new w(this));
        int[] iArr = new int[2];
        this.f25252d.getLocationInWindow(iArr);
        this.f25252d.setSelected(true);
        dVar.showAtLocation(this.f25249a.getWindow().peekDecorView(), 51, (this.f25263o + iArr[0]) - ((dVar.getWidth() - this.f25252d.getWidth()) / 2), n(dVar.getHeight()));
    }

    public final void J() {
        e eVar = new e(this.f25249a);
        eVar.d(new o(this, eVar));
        eVar.c(this.f25261m);
        eVar.setOnDismissListener(new x(this));
        int[] iArr = new int[2];
        this.f25253e.getLocationInWindow(iArr);
        this.f25253e.setSelected(true);
        eVar.showAtLocation(this.f25249a.getWindow().peekDecorView(), 51, (this.f25263o + iArr[0]) - ((eVar.getWidth() - this.f25253e.getWidth()) / 2), n(eVar.getHeight()));
    }

    public final void K() {
        b bVar = new b(this.f25249a);
        bVar.d(new m(this, bVar));
        bVar.c(this.f25260l);
        bVar.setOnDismissListener(new v(this));
        int[] iArr = new int[2];
        this.f25251c.getLocationInWindow(iArr);
        this.f25251c.setSelected(true);
        int n11 = n(bVar.getHeight());
        int i11 = 0;
        int a11 = (this.f25263o + iArr[0]) - PixelUtils.a(5.0f);
        if (a11 >= 0) {
            i11 = a11;
        }
        bVar.showAtLocation(this.f25249a.getWindow().peekDecorView(), 51, i11, n11);
    }

    public void L(LineColorEnum lineColorEnum) {
        this.f25260l = lineColorEnum;
        this.f25257i.setImageResource(lineColorEnum.getDrawableId());
    }

    public void M(boolean z11) {
        F(true);
        this.f25254f.setSelected(z11);
    }

    public void N(LineSizeEnum lineSizeEnum) {
        this.f25262n = lineSizeEnum;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25258j.getLayoutParams();
        layoutParams.height = lineSizeEnum.getSize();
        this.f25258j.setLayoutParams(layoutParams);
    }

    public void O(LineStyleEnum lineStyleEnum) {
        this.f25261m = lineStyleEnum;
        this.f25259k.setImageResource(LineStyleEnum.getIconResourceId(this.f25249a, lineStyleEnum));
    }

    public final int n(int i11) {
        if (H()) {
            return (this.f25264p + getHeight()) - f25248v;
        }
        return f25248v + (this.f25264p - i11);
    }

    public final void o(Context context) {
        this.f25249a = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.kline_draw_line_edit_tool_window_layout, (ViewGroup) null);
        this.f25250b = (ImageView) inflate.findViewById(R$id.dragIcon);
        this.f25251c = (RelativeLayout) inflate.findViewById(R$id.editColorLayout);
        this.f25257i = (ImageView) inflate.findViewById(R$id.paletteColorImage);
        this.f25252d = (RelativeLayout) inflate.findViewById(R$id.editLineSizeLayout);
        this.f25258j = (ImageView) inflate.findViewById(R$id.lineSizeImage);
        this.f25253e = (RelativeLayout) inflate.findViewById(R$id.editLineTypeLayout);
        this.f25259k = (ImageView) inflate.findViewById(R$id.lineTypeImage);
        this.f25254f = (RelativeLayout) inflate.findViewById(R$id.editLockLayout);
        this.f25255g = (RelativeLayout) inflate.findViewById(R$id.editDeleteLayout);
        this.f25256h = inflate;
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R$dimen.dimen_248_5));
        setHeight(-2);
        setTouchInterceptor(u.f54507b);
        setBackgroundDrawable((Drawable) null);
        setOutsideTouchable(false);
        setFocusable(false);
        setTouchable(true);
        p();
        setAnimationStyle(R$style.klineDrawEditToolWindowAnimation);
    }

    public final void p() {
        this.f25251c.setOnClickListener(new p(this));
        this.f25252d.setOnClickListener(new l(this));
        this.f25253e.setOnClickListener(new s(this));
        this.f25254f.setOnClickListener(new r(this));
        this.f25255g.setOnClickListener(new q(this));
        this.f25250b.setOnTouchListener(new t(this));
    }

    public void showAtLocation(View view, int i11, int i12, int i13) {
        super.showAtLocation(view, i11, i12, i13);
        this.f25263o = i12;
        this.f25264p = i13;
    }
}
