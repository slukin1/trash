package v5;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.BreathingLightShape;
import com.hbg.component.kline.shape.FloatPriceShape;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.hbg.module.kline.R$string;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentTriggerOrderInfo;
import com.huobi.contract.entity.ContractPosition;
import java.util.List;
import s5.c;

public class k extends q implements ValueAnimator.AnimatorUpdateListener {
    public Rect A0 = new Rect();
    public Rect B0 = new Rect();
    public float[] C0 = new float[2];
    public String D0;
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public String J0;
    public String K0;
    public String L0;
    public int M0 = -1;
    public float N0 = ((float) DimenUtils.a(2.0f));
    public float O0 = (this.L * 4.0f);
    public ShapeDrawable P0;

    /* renamed from: f0  reason: collision with root package name */
    public float[] f68332f0 = new float[2];

    /* renamed from: g0  reason: collision with root package name */
    public RadialGradient f68333g0;

    /* renamed from: h0  reason: collision with root package name */
    public ValueAnimator f68334h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f68335i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f68336j0;

    /* renamed from: k0  reason: collision with root package name */
    public FloatPriceShape f68337k0 = new FloatPriceShape();

    /* renamed from: l0  reason: collision with root package name */
    public BreathingLightShape f68338l0 = new BreathingLightShape();

    /* renamed from: m0  reason: collision with root package name */
    public c f68339m0;

    /* renamed from: n0  reason: collision with root package name */
    public RectF f68340n0 = new RectF();

    /* renamed from: t0  reason: collision with root package name */
    public Rect f68341t0 = new Rect();

    /* renamed from: u0  reason: collision with root package name */
    public Rect f68342u0 = new Rect();

    /* renamed from: v0  reason: collision with root package name */
    public Rect f68343v0 = new Rect();

    /* renamed from: w0  reason: collision with root package name */
    public Rect f68344w0 = new Rect();

    /* renamed from: x0  reason: collision with root package name */
    public Rect f68345x0 = new Rect();

    /* renamed from: y0  reason: collision with root package name */
    public Rect f68346y0 = new Rect();

    /* renamed from: z0  reason: collision with root package name */
    public Rect f68347z0 = new Rect();

    public k(CandleStickRender candleStickRender, Resources resources) {
        super(candleStickRender, resources);
        this.F0 = resources.getString(R$string.n_asset_future_buy);
        this.G0 = resources.getString(R$string.n_asset_future_sell);
        this.D0 = resources.getString(R$string.kline_position_all);
        this.E0 = resources.getString(R$string.kline_position_single);
        this.H0 = resources.getString(R$string.currency_detail_contract_status_force_flat);
        this.I0 = resources.getString(R$string.n_contract_trade_order_type_limit);
        this.J0 = resources.getString(R$string.n_contract_trade_order_type_plan);
        this.K0 = resources.getString(R$string.n_kline_grid_min_price);
        this.L0 = resources.getString(R$string.n_kline_grid_max_price);
        PaintUtils.h(this.f68317n, Paint.Align.CENTER, this.M0, (float) this.N);
        Paint paint = this.f68317n;
        String str = this.D0;
        paint.getTextBounds(str, 0, str.length(), this.f68341t0);
        Paint paint2 = this.f68317n;
        String str2 = this.E0;
        paint2.getTextBounds(str2, 0, str2.length(), this.f68342u0);
        Paint paint3 = this.f68317n;
        String str3 = this.F0;
        paint3.getTextBounds(str3, 0, str3.length(), this.f68343v0);
        Paint paint4 = this.f68317n;
        String str4 = this.G0;
        paint4.getTextBounds(str4, 0, str4.length(), this.f68344w0);
        Paint paint5 = this.f68317n;
        String str5 = this.H0;
        paint5.getTextBounds(str5, 0, str5.length(), this.f68345x0);
        Paint paint6 = this.f68317n;
        String str6 = this.I0;
        paint6.getTextBounds(str6, 0, str6.length(), this.f68346y0);
        Paint paint7 = this.f68317n;
        String str7 = this.J0;
        paint7.getTextBounds(str7, 0, str7.length(), this.f68347z0);
        Paint paint8 = this.f68317n;
        String str8 = this.K0;
        paint8.getTextBounds(str8, 0, str8.length(), this.A0);
        Paint paint9 = this.f68317n;
        String str9 = this.L0;
        paint9.getTextBounds(str9, 0, str9.length(), this.B0);
        A0(this.f68341t0, this.f68342u0, this.f68343v0, this.f68344w0, this.f68345x0, this.f68346y0, this.f68347z0, this.A0, this.B0);
    }

    public final void A0(Rect... rectArr) {
        for (Rect rect : rectArr) {
            rect.top = 0;
            rect.bottom = (int) FloatPriceShape.f67368y;
        }
    }

    public void B0() {
        FloatPriceShape floatPriceShape = this.f68337k0;
        boolean z11 = false;
        if (!this.f68327x.M4() && this.f68332f0[0] + this.f68340n0.width() + this.O0 > ((float) this.f67202g)) {
            z11 = true;
        }
        floatPriceShape.j(z11);
    }

    public final Drawable C0(int i11) {
        if (this.P0 == null) {
            float f11 = this.N0;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f11, f11, 0.0f, 0.0f, 0.0f, 0.0f, f11, f11}, (RectF) null, (float[]) null));
            this.P0 = shapeDrawable;
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        }
        this.P0.getPaint().setColor(i11);
        return this.P0;
    }

    public final void D0(Canvas canvas) {
        String costOpen;
        double parseDouble;
        String volume;
        String direction;
        int i11;
        Resources resources;
        float f11;
        Canvas canvas2 = canvas;
        List<?> Z0 = this.f68327x.Z0();
        if (Z0 != null && Z0.size() != 0) {
            int i12 = 0;
            String str = "";
            int i13 = 0;
            while (i13 < Z0.size()) {
                Object obj = Z0.get(i13);
                if (obj instanceof ContractPosition) {
                    ContractPosition contractPosition = (ContractPosition) obj;
                    costOpen = contractPosition.costOpen;
                    try {
                        parseDouble = Double.parseDouble(costOpen);
                        volume = contractPosition.volume;
                        direction = contractPosition.direction;
                    } catch (Throwable unused) {
                    }
                } else if (obj instanceof LinearSwapPosition) {
                    LinearSwapPosition linearSwapPosition = (LinearSwapPosition) obj;
                    costOpen = linearSwapPosition.getAvgCostPrice();
                    parseDouble = Double.parseDouble(costOpen);
                    volume = linearSwapPosition.volume;
                    str = linearSwapPosition.marginMode;
                    direction = linearSwapPosition.direction;
                } else if (obj instanceof SwapPosition) {
                    SwapPosition swapPosition = (SwapPosition) obj;
                    costOpen = swapPosition.getCostOpen();
                    parseDouble = Double.parseDouble(costOpen);
                    volume = swapPosition.getVolume();
                    direction = swapPosition.getDirection();
                } else {
                    i13++;
                    i12 = 0;
                }
                String str2 = str;
                String str3 = volume;
                CandleStickRender candleStickRender = this.f68327x;
                if (parseDouble <= candleStickRender.B0 && parseDouble >= candleStickRender.C0) {
                    boolean equalsIgnoreCase = OptionDirection.BUY.direction.equalsIgnoreCase(direction);
                    float[] fArr = this.C0;
                    fArr[1] = (float) parseDouble;
                    this.f68327x.O.mapPoints(fArr);
                    canvas.save();
                    PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.f68327x.E1(), (float) this.N);
                    this.f68317n.getTextBounds(costOpen, i12, costOpen.length(), this.f68318o);
                    if (equalsIgnoreCase) {
                        resources = this.f67200e;
                        i11 = w.h();
                    } else {
                        resources = this.f67200e;
                        i11 = w.d();
                    }
                    int color = resources.getColor(i11);
                    canvas2.translate(0.0f, this.C0[1]);
                    float centerY = (float) (0 - this.f68318o.centerY());
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF = this.f68319p;
                    Rect rect = this.f68346y0;
                    rectF.top = (float) rect.top;
                    rectF.bottom = (float) rect.bottom;
                    rectF.left = 0.0f;
                    rectF.right = ((float) this.f68318o.width()) + 0.0f + (this.L * 4.0f);
                    RectF rectF2 = this.f68319p;
                    rectF2.offset((this.f68331z.right - rectF2.width()) - this.O0, -this.f68319p.centerY());
                    RectF rectF3 = this.f68319p;
                    float f12 = this.N0;
                    canvas2.drawRoundRect(rectF3, f12, f12, this.f68317n);
                    Paint paint = this.f68317n;
                    int i14 = CandleStickRender.f67208x2;
                    PaintUtils.d(paint, color, (float) i14);
                    RectF rectF4 = this.f68319p;
                    float f13 = this.N0;
                    canvas2.drawRoundRect(rectF4, f13, f13, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                    canvas2.drawText(costOpen, this.f68319p.centerX(), centerY, this.f68317n);
                    float f14 = this.f68319p.left;
                    float f15 = this.L * 6.0f;
                    if (!TextUtils.isEmpty(str2)) {
                        f15 = f15 + ((float) (FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0).width()) + (this.L * 6.0f);
                    }
                    this.f68317n.getTextBounds(str3, i12, str3.length(), this.f68318o);
                    float width = f15 + ((float) this.f68318o.width());
                    RectF rectF5 = this.f68319p;
                    Rect rect2 = this.f68346y0;
                    rectF5.top = (float) rect2.top;
                    rectF5.bottom = (float) rect2.bottom;
                    float f16 = this.L * 4.0f;
                    rectF5.left = f16;
                    rectF5.right = f16 + width;
                    rectF5.offset(0.0f, -rectF5.centerY());
                    PaintUtils.b(this.f68317n, color, (float) i14);
                    float f17 = this.f68319p.right;
                    Paint paint2 = this.f68317n;
                    String str4 = FutureContractInfo.MARGIN_CROSS;
                    canvas.drawLine(f17, 0.0f, f14, 0.0f, paint2);
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF6 = this.f68319p;
                    float f18 = this.N0;
                    canvas2.drawRoundRect(rectF6, f18, f18, this.f68317n);
                    PaintUtils.d(this.f68317n, color, (float) i14);
                    RectF rectF7 = this.f68319p;
                    float f19 = this.N0;
                    canvas2.drawRoundRect(rectF7, f19, f19, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.LEFT, -1, (float) this.N);
                    float f21 = this.f68319p.left + (this.L * 3.0f);
                    if (!TextUtils.isEmpty(str2)) {
                        Drawable C02 = C0(color);
                        RectF rectF8 = this.f68319p;
                        float f22 = rectF8.left;
                        C02.setBounds((int) f22, (int) rectF8.top, (int) (f22 + ((float) (str4.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0).width()) + (this.L * 6.0f)), (int) this.f68319p.bottom);
                        C02.draw(canvas2);
                        canvas2.drawText(str4.equalsIgnoreCase(str2) ? this.D0 : this.E0, f21, centerY, this.f68317n);
                        Rect rect3 = str4.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0;
                        float f23 = this.L;
                        f11 = f21 + ((float) rect3.width()) + (f23 * 3.0f) + (f23 * 3.0f);
                        PaintUtils.h(this.f68317n, Paint.Align.LEFT, color, (float) this.N);
                    } else {
                        PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                        f11 = this.f68319p.centerX();
                    }
                    canvas2.drawText(str3, f11, centerY, this.f68317n);
                    canvas.restore();
                }
                str = str2;
                i13++;
                i12 = 0;
            }
        }
    }

    public final void E0(Canvas canvas) {
        List<?> D1 = this.f68327x.D1();
        if (D1 != null && D1.size() == 2) {
            int i11 = 0;
            while (i11 < D1.size()) {
                Object obj = D1.get(i11);
                if (obj instanceof String) {
                    String str = (String) obj;
                    try {
                        double parseDouble = Double.parseDouble(str);
                        CandleStickRender candleStickRender = this.f68327x;
                        if (parseDouble <= candleStickRender.B0 && parseDouble >= candleStickRender.C0) {
                            boolean z11 = i11 == 0;
                            float[] fArr = this.C0;
                            fArr[1] = (float) parseDouble;
                            candleStickRender.O.mapPoints(fArr);
                            canvas.save();
                            PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.f68327x.E1(), (float) this.N);
                            this.f68317n.getTextBounds(str, 0, str.length(), this.f68318o);
                            int color = this.f67200e.getColor(z11 ? w.h() : w.d());
                            canvas.translate(0.0f, this.C0[1]);
                            float centerY = (float) (0 - this.f68318o.centerY());
                            PaintUtils.c(this.f68317n, this.f68327x.W0());
                            RectF rectF = this.f68319p;
                            Rect rect = this.f68346y0;
                            rectF.top = (float) rect.top;
                            rectF.bottom = (float) rect.bottom;
                            rectF.left = 0.0f;
                            rectF.right = ((float) this.f68318o.width()) + 0.0f + (this.L * 4.0f);
                            RectF rectF2 = this.f68319p;
                            rectF2.offset((this.f68331z.right - rectF2.width()) - this.O0, -this.f68319p.centerY());
                            RectF rectF3 = this.f68319p;
                            float f11 = this.N0;
                            canvas.drawRoundRect(rectF3, f11, f11, this.f68317n);
                            Paint paint = this.f68317n;
                            int i12 = CandleStickRender.f67208x2;
                            PaintUtils.d(paint, color, (float) i12);
                            RectF rectF4 = this.f68319p;
                            float f12 = this.N0;
                            canvas.drawRoundRect(rectF4, f12, f12, this.f68317n);
                            PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                            canvas.drawText(str, this.f68319p.centerX(), centerY, this.f68317n);
                            RectF rectF5 = this.f68319p;
                            float f13 = rectF5.left;
                            Rect rect2 = this.f68346y0;
                            rectF5.top = (float) rect2.top;
                            rectF5.bottom = (float) rect2.bottom;
                            float f14 = this.L;
                            float f15 = f14 * 4.0f;
                            rectF5.left = f15;
                            rectF5.right = f15 + (f14 * 4.0f) + ((float) (i11 == 0 ? this.A0 : this.B0).width());
                            RectF rectF6 = this.f68319p;
                            rectF6.offset(0.0f, -rectF6.centerY());
                            PaintUtils.b(this.f68317n, color, (float) i12);
                            canvas.drawLine(this.f68319p.right, 0.0f, f13, 0.0f, this.f68317n);
                            PaintUtils.c(this.f68317n, this.f68327x.W0());
                            RectF rectF7 = this.f68319p;
                            float f16 = this.N0;
                            canvas.drawRoundRect(rectF7, f16, f16, this.f68317n);
                            PaintUtils.d(this.f68317n, color, (float) i12);
                            RectF rectF8 = this.f68319p;
                            float f17 = this.N0;
                            canvas.drawRoundRect(rectF8, f17, f17, this.f68317n);
                            PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                            canvas.drawText(i11 == 0 ? this.K0 : this.L0, this.f68319p.centerX(), centerY, this.f68317n);
                            canvas.restore();
                        }
                    } catch (Throwable unused) {
                    }
                }
                i11++;
            }
        }
    }

    public void F() {
        ValueAnimator valueAnimator;
        super.F();
        if (this.f68327x.V1() != null) {
            this.f68335i0 = V(this.f68327x.V1().getClose());
            this.f68332f0[0] = D(this.f68327x.z1().size() - 1);
            if (this.f68327x.N1() != CandleStickRender.KLineType.TIME_LINE) {
                float[] fArr = this.f68332f0;
                fArr[0] = fArr[0] + (this.f68327x.C0() / 2.0f);
            }
            this.f68332f0[1] = (float) this.f68327x.V1().getClose();
            this.f68327x.O.mapPoints(this.f68332f0);
            float[] fArr2 = this.f68332f0;
            float f11 = fArr2[1];
            RectF rectF = this.f68331z;
            float f12 = rectF.top;
            if (f11 <= f12) {
                fArr2[1] = f12;
            } else {
                float f13 = fArr2[1];
                float f14 = rectF.bottom;
                if (f13 >= f14) {
                    fArr2[1] = f14;
                }
            }
            PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.f68327x.I0(), (float) this.N);
            if (!this.f68327x.L3() || TextUtils.isEmpty(this.f68327x.a1())) {
                Paint paint = this.f68317n;
                String str = this.f68335i0;
                paint.getTextBounds(str, 0, str.length(), this.f68318o);
                this.f68336j0 = (float) (0 - this.f68318o.centerY());
                RectF rectF2 = this.f68340n0;
                rectF2.left = 0.0f;
                rectF2.right = ((float) this.f68318o.width()) + 0.0f + (this.L * 4.0f);
                RectF rectF3 = this.f68340n0;
                rectF3.top = 0.0f;
                rectF3.bottom = FloatPriceShape.f67368y;
            } else {
                Paint paint2 = this.f68317n;
                String str2 = this.f68335i0;
                paint2.getTextBounds(str2, 0, str2.length(), this.f68318o);
                int max = Math.max(0, this.f68318o.width());
                this.f68317n.getTextBounds(this.f68327x.a1(), 0, this.f68327x.a1().length(), this.f68318o);
                int max2 = Math.max(max, this.f68318o.width());
                this.f68336j0 = (float) (0 - this.f68318o.centerY());
                RectF rectF4 = this.f68340n0;
                rectF4.left = 0.0f;
                rectF4.right = ((float) max2) + 0.0f + (this.L * 4.0f);
                rectF4.top = 0.0f;
                rectF4.bottom = (float) DimenUtils.a(22.0f);
            }
            RectF rectF5 = this.f68340n0;
            rectF5.offset(((this.f68331z.right - rectF5.width()) - this.f68332f0[0]) - this.O0, -this.f68340n0.centerY());
            if (this.f68337k0.g()) {
                this.f68337k0.m(this.f68335i0, this.f68327x.a1(), this.f68327x.L3(), (float) this.N, this.f68327x.u1(), this.f68327x.w1(), this.f68327x.w1(), this.D + (this.L * 16.0f), this.f68327x.v1(), this.f68327x.I0(), this.f68332f0[1], this.f68317n, this.f68327x.J3());
            }
        }
        if (this.f68327x.K4()) {
            if (this.f68333g0 == null) {
                this.f68333g0 = new RadialGradient(0.0f, 0.0f, (float) DimenUtils.a(10.0f), this.f68327x.A0(), this.f68327x.B0(), Shader.TileMode.MIRROR);
                this.f68338l0.i(this.f68317n);
                this.f68338l0.v(this.f68327x.z0());
                this.f68338l0.t(this.f68327x.y0());
                this.f68338l0.u(this.Z);
                this.f68338l0.w(this.f68370a0);
                this.f68338l0.y(this.f68333g0);
                this.f68338l0.z(0.0f);
                this.f68338l0.k(0.0f);
            }
            if (this.f68327x.N1() == CandleStickRender.KLineType.TIME_LINE && (valueAnimator = this.f68334h0) != null && !valueAnimator.isStarted()) {
                this.f68334h0.start();
                return;
            }
            return;
        }
        ValueAnimator valueAnimator2 = this.f68334h0;
        if (valueAnimator2 != null && valueAnimator2.isStarted()) {
            this.f68334h0.cancel();
        }
    }

    public final void F0(Canvas canvas) {
        List<?> C1 = this.f68327x.C1();
        if (C1 != null && C1.size() > 1) {
            double d11 = 0.0d;
            Object obj = C1.get(C1.size() - 1);
            if (obj instanceof Number) {
                d11 = ((Number) obj).doubleValue();
            }
            for (int i11 = 0; i11 < C1.size() - 1; i11++) {
                Object obj2 = C1.get(i11);
                if (obj2 instanceof Number) {
                    double doubleValue = ((Number) obj2).doubleValue();
                    CandleStickRender candleStickRender = this.f68327x;
                    if (doubleValue <= candleStickRender.B0 && doubleValue >= candleStickRender.C0) {
                        boolean z11 = doubleValue < d11;
                        float[] fArr = this.C0;
                        fArr[1] = (float) doubleValue;
                        candleStickRender.O.mapPoints(fArr);
                        canvas.save();
                        int color = this.f67200e.getColor(z11 ? w.h() : w.d());
                        canvas.translate(0.0f, this.C0[1]);
                        PaintUtils.b(this.f68317n, color, (float) CandleStickRender.f67208x2);
                        canvas.drawLine(this.L * 4.0f, 0.0f, this.f68331z.right - this.O0, 0.0f, this.f68317n);
                        canvas.restore();
                    }
                }
            }
        }
    }

    public final void G0(Canvas canvas) {
        String liquidationPrice;
        double parseDouble;
        String direction;
        int i11;
        Resources resources;
        float f11;
        Canvas canvas2 = canvas;
        List<?> Z0 = this.f68327x.Z0();
        if (Z0 != null && Z0.size() != 0) {
            int i12 = 0;
            String str = "";
            int i13 = 0;
            while (i13 < Z0.size()) {
                Object obj = Z0.get(i13);
                if (obj instanceof ContractPosition) {
                    ContractPosition contractPosition = (ContractPosition) obj;
                    liquidationPrice = contractPosition.liquidationPrice;
                    try {
                        parseDouble = Double.parseDouble(liquidationPrice);
                        direction = contractPosition.direction;
                    } catch (Throwable unused) {
                    }
                } else if (obj instanceof LinearSwapPosition) {
                    LinearSwapPosition linearSwapPosition = (LinearSwapPosition) obj;
                    liquidationPrice = linearSwapPosition.liquidationPrice;
                    parseDouble = Double.parseDouble(liquidationPrice);
                    str = linearSwapPosition.marginMode;
                    direction = linearSwapPosition.direction;
                } else if (obj instanceof SwapPosition) {
                    SwapPosition swapPosition = (SwapPosition) obj;
                    liquidationPrice = swapPosition.getLiquidationPrice();
                    parseDouble = Double.parseDouble(liquidationPrice);
                    direction = swapPosition.getDirection();
                } else {
                    i13++;
                    i12 = 0;
                }
                String str2 = str;
                CandleStickRender candleStickRender = this.f68327x;
                if (parseDouble <= candleStickRender.B0 && parseDouble >= candleStickRender.C0) {
                    boolean equalsIgnoreCase = OptionDirection.BUY.direction.equalsIgnoreCase(direction);
                    float[] fArr = this.C0;
                    fArr[1] = (float) parseDouble;
                    this.f68327x.O.mapPoints(fArr);
                    canvas.save();
                    PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.M0, (float) this.N);
                    this.f68317n.getTextBounds(liquidationPrice, i12, liquidationPrice.length(), this.f68318o);
                    if (equalsIgnoreCase) {
                        resources = this.f67200e;
                        i11 = w.d();
                    } else {
                        resources = this.f67200e;
                        i11 = w.h();
                    }
                    int color = resources.getColor(i11);
                    canvas2.translate(0.0f, this.C0[1]);
                    float centerY = (float) (0 - this.f68318o.centerY());
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF = this.f68319p;
                    Rect rect = this.f68346y0;
                    rectF.top = (float) rect.top;
                    rectF.bottom = (float) rect.bottom;
                    rectF.left = 0.0f;
                    rectF.right = ((float) this.f68318o.width()) + 0.0f + (this.L * 4.0f);
                    RectF rectF2 = this.f68319p;
                    rectF2.offset((this.f68331z.right - rectF2.width()) - this.O0, -this.f68319p.centerY());
                    RectF rectF3 = this.f68319p;
                    float f12 = this.N0;
                    canvas2.drawRoundRect(rectF3, f12, f12, this.f68317n);
                    Paint paint = this.f68317n;
                    int i14 = CandleStickRender.f67208x2;
                    PaintUtils.d(paint, color, (float) i14);
                    RectF rectF4 = this.f68319p;
                    float f13 = this.N0;
                    canvas2.drawRoundRect(rectF4, f13, f13, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                    canvas2.drawText(liquidationPrice, this.f68319p.centerX(), centerY, this.f68317n);
                    float f14 = this.f68319p.left;
                    float f15 = this.L * 6.0f;
                    if (!TextUtils.isEmpty(str2)) {
                        f15 = f15 + ((float) (FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0).width()) + (this.L * 6.0f);
                    }
                    float width = f15 + ((float) this.f68345x0.width());
                    RectF rectF5 = this.f68319p;
                    Rect rect2 = this.f68346y0;
                    rectF5.top = (float) rect2.top;
                    rectF5.bottom = (float) rect2.bottom;
                    float f16 = this.L * 4.0f;
                    rectF5.left = f16;
                    rectF5.right = f16 + width;
                    rectF5.offset(0.0f, -rectF5.centerY());
                    PaintUtils.b(this.f68317n, color, (float) i14);
                    float f17 = this.f68319p.right;
                    Paint paint2 = this.f68317n;
                    String str3 = FutureContractInfo.MARGIN_CROSS;
                    canvas.drawLine(f17, 0.0f, f14, 0.0f, paint2);
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF6 = this.f68319p;
                    float f18 = this.N0;
                    canvas2.drawRoundRect(rectF6, f18, f18, this.f68317n);
                    PaintUtils.d(this.f68317n, color, (float) i14);
                    RectF rectF7 = this.f68319p;
                    float f19 = this.N0;
                    canvas2.drawRoundRect(rectF7, f19, f19, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.LEFT, -1, (float) this.N);
                    float f21 = this.f68319p.left + (this.L * 3.0f);
                    if (!TextUtils.isEmpty(str2)) {
                        Drawable C02 = C0(color);
                        RectF rectF8 = this.f68319p;
                        float f22 = rectF8.left;
                        C02.setBounds((int) f22, (int) rectF8.top, (int) (f22 + ((float) (str3.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0).width()) + (this.L * 6.0f)), (int) this.f68319p.bottom);
                        C02.draw(canvas2);
                        canvas2.drawText(str3.equalsIgnoreCase(str2) ? this.D0 : this.E0, f21, centerY, this.f68317n);
                        Rect rect3 = str3.equalsIgnoreCase(str2) ? this.f68341t0 : this.f68342u0;
                        float f23 = this.L;
                        f11 = f21 + ((float) rect3.width()) + (f23 * 3.0f) + (f23 * 3.0f);
                        PaintUtils.h(this.f68317n, Paint.Align.LEFT, color, (float) this.N);
                    } else {
                        PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                        f11 = this.f68319p.centerX();
                    }
                    canvas2.drawText(this.H0, f11, centerY, this.f68317n);
                    canvas.restore();
                }
                str = str2;
                i13++;
                i12 = 0;
            }
        }
    }

    public final void H0(Canvas canvas, List<?> list, boolean z11) {
        String triggerPrice;
        double parseDouble;
        String volume;
        boolean isBuy;
        int i11;
        Resources resources;
        Canvas canvas2 = canvas;
        List<?> list2 = list;
        if (list2 != null && list.size() != 0) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                Object obj = list2.get(i12);
                if (obj instanceof LinearSwapTriggerOrderInfo) {
                    LinearSwapTriggerOrderInfo linearSwapTriggerOrderInfo = (LinearSwapTriggerOrderInfo) obj;
                    triggerPrice = linearSwapTriggerOrderInfo.getTriggerPrice();
                    try {
                        parseDouble = Double.parseDouble(triggerPrice);
                        volume = linearSwapTriggerOrderInfo.getVolume();
                        isBuy = linearSwapTriggerOrderInfo.isBuy();
                    } catch (Throwable unused) {
                    }
                } else if (obj instanceof LinearSwapCurrentOrderInfo) {
                    LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo = (LinearSwapCurrentOrderInfo) obj;
                    triggerPrice = linearSwapCurrentOrderInfo.getPrice();
                    parseDouble = Double.parseDouble(triggerPrice);
                    volume = linearSwapCurrentOrderInfo.getVolume();
                    isBuy = linearSwapCurrentOrderInfo.isBuy();
                } else if (obj instanceof SwapCurrentOrderInfo) {
                    SwapCurrentOrderInfo swapCurrentOrderInfo = (SwapCurrentOrderInfo) obj;
                    triggerPrice = swapCurrentOrderInfo.getPrice();
                    parseDouble = Double.parseDouble(triggerPrice);
                    volume = swapCurrentOrderInfo.getVolume();
                    isBuy = swapCurrentOrderInfo.isBuy();
                } else if (obj instanceof SwapTriggerOrderInfo) {
                    SwapTriggerOrderInfo swapTriggerOrderInfo = (SwapTriggerOrderInfo) obj;
                    triggerPrice = swapTriggerOrderInfo.getTriggerPrice();
                    parseDouble = Double.parseDouble(triggerPrice);
                    volume = swapTriggerOrderInfo.getVolume();
                    isBuy = swapTriggerOrderInfo.isBuy();
                } else if (obj instanceof ContractCurrentOrderInfo) {
                    ContractCurrentOrderInfo contractCurrentOrderInfo = (ContractCurrentOrderInfo) obj;
                    triggerPrice = contractCurrentOrderInfo.getPrice();
                    parseDouble = Double.parseDouble(triggerPrice);
                    volume = contractCurrentOrderInfo.getVolume();
                    isBuy = contractCurrentOrderInfo.isBuy();
                } else if (obj instanceof ContractCurrentTriggerOrderInfo) {
                    ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo = (ContractCurrentTriggerOrderInfo) obj;
                    triggerPrice = contractCurrentTriggerOrderInfo.getTriggerPrice();
                    parseDouble = Double.parseDouble(triggerPrice);
                    volume = contractCurrentTriggerOrderInfo.getVolume();
                    isBuy = contractCurrentTriggerOrderInfo.isBuy();
                }
                String str = volume;
                CandleStickRender candleStickRender = this.f68327x;
                if (parseDouble <= candleStickRender.B0 && parseDouble >= candleStickRender.C0) {
                    float[] fArr = this.C0;
                    fArr[1] = (float) parseDouble;
                    candleStickRender.O.mapPoints(fArr);
                    canvas.save();
                    PaintUtils.h(this.f68317n, Paint.Align.CENTER, this.M0, (float) this.N);
                    this.f68317n.getTextBounds(triggerPrice, 0, triggerPrice.length(), this.f68318o);
                    if (isBuy) {
                        resources = this.f67200e;
                        i11 = w.h();
                    } else {
                        resources = this.f67200e;
                        i11 = w.d();
                    }
                    int color = resources.getColor(i11);
                    canvas2.translate(0.0f, this.C0[1]);
                    float centerY = (float) (0 - this.f68318o.centerY());
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF = this.f68319p;
                    Rect rect = this.f68346y0;
                    rectF.top = (float) rect.top;
                    rectF.bottom = (float) rect.bottom;
                    rectF.left = 0.0f;
                    rectF.right = ((float) this.f68318o.width()) + 0.0f + (this.L * 4.0f);
                    RectF rectF2 = this.f68319p;
                    rectF2.offset((this.f68331z.right - rectF2.width()) - this.O0, -this.f68319p.centerY());
                    RectF rectF3 = this.f68319p;
                    float f11 = this.N0;
                    canvas2.drawRoundRect(rectF3, f11, f11, this.f68317n);
                    Paint paint = this.f68317n;
                    int i13 = CandleStickRender.f67208x2;
                    PaintUtils.d(paint, color, (float) i13);
                    RectF rectF4 = this.f68319p;
                    float f12 = this.N0;
                    canvas2.drawRoundRect(rectF4, f12, f12, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.CENTER, color, (float) this.N);
                    canvas2.drawText(triggerPrice, this.f68319p.centerX(), centerY, this.f68317n);
                    float f13 = this.f68319p.left;
                    this.f68317n.getTextBounds(str, 0, str.length(), this.f68318o);
                    int width = this.f68318o.width();
                    RectF rectF5 = this.f68319p;
                    Rect rect2 = this.f68346y0;
                    rectF5.top = (float) rect2.top;
                    rectF5.bottom = (float) rect2.bottom;
                    int width2 = z11 ? rect2.width() : this.f68347z0.width();
                    float f14 = this.L;
                    float f15 = (float) width;
                    float f16 = ((float) width2) + (9.0f * f14) + f15;
                    RectF rectF6 = this.f68319p;
                    float f17 = (f13 - f16) - (f14 * 24.0f);
                    rectF6.left = f17;
                    rectF6.right = f17 + f16;
                    rectF6.offset(0.0f, -rectF6.centerY());
                    PaintUtils.b(this.f68317n, color, (float) i13);
                    canvas.drawLine(this.f68319p.right, 0.0f, f13, 0.0f, this.f68317n);
                    PaintUtils.c(this.f68317n, this.f68327x.W0());
                    RectF rectF7 = this.f68319p;
                    float f18 = this.N0;
                    canvas2.drawRoundRect(rectF7, f18, f18, this.f68317n);
                    PaintUtils.d(this.f68317n, color, (float) i13);
                    RectF rectF8 = this.f68319p;
                    float f19 = this.N0;
                    canvas2.drawRoundRect(rectF8, f19, f19, this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.LEFT, color, (float) this.N);
                    canvas2.drawText(z11 ? this.I0 : this.J0, this.f68319p.left + (this.L * 3.0f), centerY, this.f68317n);
                    canvas2.drawText(str, (this.f68319p.right - f15) - (this.L * 3.0f), centerY, this.f68317n);
                    canvas.restore();
                }
            }
        }
    }

    public void I0(c cVar) {
        this.f68339m0 = cVar;
    }

    public void N() {
        super.N();
        this.f68332f0[0] = (float) DimenUtils.a(-100.0f);
        this.f68332f0[1] = (float) DimenUtils.a(-100.0f);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f68338l0.x(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f68327x.m();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        N();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
        this.f68334h0 = ofFloat;
        ofFloat.setDuration(1100);
        this.f68334h0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f68334h0.setRepeatMode(1);
        this.f68334h0.setRepeatCount(-1);
        this.f68334h0.addUpdateListener(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f68334h0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68334h0 = null;
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.f68337k0.g() || !this.f68337k0.b().contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        c cVar = this.f68339m0;
        if (cVar == null) {
            return true;
        }
        cVar.a(motionEvent);
        return true;
    }

    public void y(Canvas canvas) {
        if (this.f68327x.V1() != null && !TextUtils.isEmpty(this.f68335i0)) {
            if (!this.f68337k0.g()) {
                canvas.save();
                float[] fArr = this.f68332f0;
                canvas.translate(fArr[0], fArr[1]);
                float width = ((this.f68331z.right - this.f68332f0[0]) - this.f68340n0.width()) - this.O0;
                if (width > 0.0f) {
                    PaintUtils.b(this.f68317n, this.f68327x.I0(), (float) CandleStickRender.f67208x2);
                    canvas.drawLine(0.0f, 0.0f, width, 0.0f, this.f68317n);
                }
                if (this.f68327x.N1() == CandleStickRender.KLineType.TIME_LINE) {
                    this.f68338l0.l(canvas);
                }
                PaintUtils.c(this.f68317n, this.f68327x.v1());
                RectF rectF = this.f68340n0;
                float f11 = this.L;
                canvas.drawRoundRect(rectF, f11 * 2.0f, f11 * 2.0f, this.f68317n);
                PaintUtils.d(this.f68317n, this.f68327x.w1(), (float) CandleStickRender.f67208x2);
                RectF rectF2 = this.f68340n0;
                float f12 = this.L;
                canvas.drawRoundRect(rectF2, f12 * 2.0f, f12 * 2.0f, this.f68317n);
                if (!this.f68327x.L3() || TextUtils.isEmpty(this.f68327x.a1())) {
                    PaintUtils.h(this.f68317n, Paint.Align.CENTER, this.f68327x.w1(), (float) this.N);
                    canvas.drawText(this.f68335i0, this.f68340n0.centerX(), this.f68336j0, this.f68317n);
                } else {
                    PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.f68327x.w1(), (float) this.N);
                    canvas.drawText(this.f68335i0, this.f68340n0.right - (this.L * 2.0f), this.f68336j0 - ((float) DimenUtils.a(5.0f)), this.f68317n);
                    PaintUtils.h(this.f68317n, Paint.Align.RIGHT, this.f68327x.w1(), (float) this.N);
                    canvas.drawText(this.f68327x.a1(), this.f68340n0.right - (this.L * 2.0f), this.f68336j0 + ((float) DimenUtils.a(5.0f)), this.f68317n);
                }
                canvas.restore();
            } else {
                this.f68337k0.j(true);
                this.f68337k0.l(canvas);
            }
        }
        D0(canvas);
        G0(canvas);
        H0(canvas, this.f68327x.Y0(), false);
        H0(canvas, this.f68327x.X0(), true);
        F0(canvas);
        E0(canvas);
    }
}
