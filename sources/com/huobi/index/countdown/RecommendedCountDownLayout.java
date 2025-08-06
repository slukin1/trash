package com.huobi.index.countdown;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.PrimeCountDownAnimView;
import pro.huobi.R;

public class RecommendedCountDownLayout extends CountDownLayout {

    /* renamed from: q  reason: collision with root package name */
    public final IndexCountDownManager f73265q = new IndexCountDownManager();

    public RecommendedCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrimeCountDownAnimView a(Context context) {
        PrimeCountDownAnimView primeCountDownAnimView = new PrimeCountDownAnimView(context);
        primeCountDownAnimView.setPadding(0);
        primeCountDownAnimView.setLayoutParams(new LinearLayout.LayoutParams(this.f73247j, this.f73248k));
        primeCountDownAnimView.setBackgroundDrawable(this.f73249l);
        primeCountDownAnimView.setTextSize(this.f73250m);
        primeCountDownAnimView.setTextColor(this.f73251n);
        int a11 = PixelUtils.a(2.0f);
        int a12 = PixelUtils.a(1.0f);
        primeCountDownAnimView.setPadding(a11, a12, a11, a12);
        return primeCountDownAnimView;
    }

    public ImageView d(Context context, int i11) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(PixelUtils.a(8.0f), i11));
        imageView.setImageResource(R.drawable.ic_recommended_time_dash);
        return imageView;
    }

    public void g() {
        getCountDownManager().s(this);
    }

    public IndexCountDownManager getCountDownManager() {
        return this.f73265q;
    }

    public long getInitTime() {
        return getCountDownManager().j();
    }

    public void h() {
        getCountDownManager().v(this);
    }

    public RecommendedCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
