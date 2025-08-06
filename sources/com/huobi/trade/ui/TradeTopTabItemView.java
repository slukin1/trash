package com.huobi.trade.ui;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.data.symbol.TradeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class TradeTopTabItemView extends AppCompatTextView implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TradeType f82475b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f82476c;

    /* renamed from: d  reason: collision with root package name */
    public a f82477d;

    public interface a {
        void a(TradeType tradeType);
    }

    public TradeTopTabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public void c(boolean z11, boolean z12) {
        this.f82476c = z11;
        setSelected(z11);
        int color = getResources().getColor(R.color.baseColorSecondaryText);
        int color2 = getResources().getColor(R.color.baseColorMajorTheme100);
        if (z12) {
            if (!z11) {
                int i11 = color2;
                color2 = color;
                color = i11;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(color2)});
            ofObject.addUpdateListener(new l2(this));
            ofObject.setDuration(100);
            ofObject.setInterpolator(new DecelerateInterpolator());
            ofObject.start();
        } else if (z11) {
            setTextColor(color2);
        } else {
            setTextColor(color);
        }
    }

    public TradeType getTradeType() {
        return this.f82475b;
    }

    public final void init(Context context) {
        setGravity(17);
        setBackgroundResource(R.drawable.selector_blue_corner_bg);
        setTextSize(0, (float) getResources().getDimensionPixelOffset(R.dimen.global_text_size_14));
        setOnClickListener(this);
        setChecked(this.f82476c);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f82477d;
        if (aVar != null) {
            aVar.a(this.f82475b);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallback(a aVar) {
        this.f82477d = aVar;
    }

    public void setChecked(boolean z11) {
        c(z11, false);
    }

    public void setTradeType(TradeType tradeType) {
        this.f82475b = tradeType;
    }

    public TradeTopTabItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
