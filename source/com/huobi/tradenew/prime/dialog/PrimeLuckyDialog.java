package com.huobi.tradenew.prime.dialog;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import i6.r;
import pro.huobi.R;

public class PrimeLuckyDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f83000b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83001c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83002d;

    /* renamed from: e  reason: collision with root package name */
    public String f83003e;

    /* renamed from: f  reason: collision with root package name */
    public View f83004f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingView f83005g;

    /* renamed from: h  reason: collision with root package name */
    public View f83006h;

    /* renamed from: i  reason: collision with root package name */
    public View f83007i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PrimeLuckyDialog.this.f83005g.getLayoutParams();
            layoutParams.height = (PrimeLuckyDialog.this.f83007i.getWidth() * TUIMessageBean.MSG_STATUS_REVOKE) / 325;
            layoutParams.width = PrimeLuckyDialog.this.f83007i.getWidth();
            PrimeLuckyDialog.this.f83005g.setLayoutParams(layoutParams);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f83009b;

        /* renamed from: c  reason: collision with root package name */
        public float f83010c;

        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f83009b = floatValue;
                this.f83010c = (floatValue * 0.2f) + 0.8f;
                PrimeLuckyDialog.this.f83006h.setAlpha(this.f83009b);
                PrimeLuckyDialog.this.f83006h.setScaleX(this.f83010c);
                PrimeLuckyDialog.this.f83006h.setScaleY(this.f83010c);
            }
        }
    }

    public class c extends ReplacementSpan {

        /* renamed from: b  reason: collision with root package name */
        public int f83012b;

        /* renamed from: c  reason: collision with root package name */
        public int f83013c;

        /* renamed from: d  reason: collision with root package name */
        public int f83014d;

        public c(int i11, int i12) {
            this.f83013c = i11;
            this.f83014d = i12;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, paint.descent() - paint.ascent(), this.f83013c, this.f83014d, Shader.TileMode.REPEAT));
            canvas.drawText(charSequence, i11, i12, f11, (float) i14, paint);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
            this.f83012b = (int) paint.measureText(charSequence, i11, i12);
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            if (fontMetricsInt != null) {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            }
            return this.f83012b;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        this.f83005g.d();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh() {
        this.f83005g.c();
    }

    public void addEvent(r rVar) {
        this.f83004f.setOnClickListener(new tt.a(this));
        this.f83005g.postDelayed(new tt.b(this), 150);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new b());
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.start();
    }

    public void afterInit() {
        this.f83002d.setText(this.f83003e);
        this.f83000b.setText(xh(getString(R.string.prime_congratulation_title_tips_1), -1446404, -9536837));
        this.f83001c.setText(xh(getString(R.string.prime_congratulation_title_tips_2), -1446404, -9536837));
    }

    public void doDismiss() {
        super.doDismiss();
    }

    public int getContentViewResId() {
        return R.layout.prime_lucky_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f83000b = (TextView) rVar.b(R.id.title);
        this.f83002d = (TextView) rVar.b(R.id.number);
        this.f83004f = rVar.b(R.id.close);
        this.f83007i = rVar.b(R.id.root);
        this.f83005g = (LoadingView) rVar.b(R.id.loading_view);
        this.f83001c = (TextView) rVar.b(R.id.subtitle);
        this.f83006h = rVar.b(R.id.chart_root);
        this.f83000b.post(new a());
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return false;
    }

    public SpannableStringBuilder xh(String str, int i11, int i12) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new c(i11, i12), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void zh(String str) {
        this.f83003e = str;
    }
}
