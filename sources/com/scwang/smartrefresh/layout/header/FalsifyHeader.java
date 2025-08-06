package com.scwang.smartrefresh.layout.header;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R$string;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.g;
import ky.i;
import ky.j;

public class FalsifyHeader extends View implements g {

    /* renamed from: b  reason: collision with root package name */
    public i f29890b;

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            int b11 = DensityUtil.b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(1157627903);
            paint.setStrokeWidth((float) DensityUtil.b(1.0f));
            float f11 = (float) b11;
            paint.setPathEffect(new DashPathEffect(new float[]{f11, f11, f11, f11}, 1.0f));
            canvas.drawRect(f11, f11, (float) (getWidth() - b11), (float) (getBottom() - b11), paint);
            TextView textView = new TextView(getContext());
            textView.setText(R$string.srl_component_falsify);
            textView.setText(String.format(textView.getText().toString(), new Object[]{getClass().getSimpleName(), Float.valueOf(DensityUtil.c(getHeight()))}));
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    public int onFinish(j jVar, boolean z11) {
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29890b = iVar;
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
        i iVar = this.f29890b;
        if (iVar != null) {
            iVar.g(RefreshState.None);
            this.f29890b.g(RefreshState.RefreshFinish);
        }
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
