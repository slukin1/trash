package com.hbg.lite.market.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$font;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hb.f;
import hb.g;
import java.util.ArrayList;

public class RectTabLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TextView> f77321b;

    /* renamed from: c  reason: collision with root package name */
    public a f77322c;

    /* renamed from: d  reason: collision with root package name */
    public int f77323d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f77324e;

    /* renamed from: f  reason: collision with root package name */
    public View f77325f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f77326g;

    /* renamed from: h  reason: collision with root package name */
    public int f77327h;

    public interface a {
        void Wb(View view, int i11);
    }

    public RectTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(TextView textView) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f77325f.getLayoutParams();
        layoutParams.width = textView.getWidth() + 6 + 6;
        this.f77325f.setLayoutParams(layoutParams);
        int left = (textView.getLeft() - 6) + this.f77327h;
        if (this.f77326g == null) {
            this.f77325f.setTranslationX((float) left);
        } else {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f77325f, FrameLayout.TRANSLATION_X.getName(), new float[]{(float) this.f77326g.intValue(), (float) left});
            ofFloat.setDuration(270);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
        this.f77326g = Integer.valueOf(left);
    }

    private View getDivider() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R$drawable.lite_shape_trade_info_tab_column_divider);
        return imageView;
    }

    private TextView getTabTextView() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        return textView;
    }

    public final void c(TextView textView) {
        textView.post(new g(this, textView));
    }

    public final void d(Context context) {
        this.f77321b = new ArrayList<>();
        this.f77327h = PixelUtils.a(2.5f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f77324e = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int i11 = this.f77327h;
        layoutParams.setMargins(i11, i11, i11, i11);
        this.f77324e.setGravity(16);
        this.f77324e.setLayoutParams(layoutParams);
        View view = new View(context);
        this.f77325f = view;
        view.setBackgroundResource(R$drawable.bg_lite_market_info_tab_selected);
        addView(this.f77325f);
        addView(this.f77324e);
    }

    @SensorsDataInstrumented
    public final void f(View view) {
        setCurrentItem(((Integer) view.getTag()).intValue());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getMCurrentIndex() {
        return this.f77323d;
    }

    public void setCurrentItem(int i11) {
        this.f77323d = i11;
        a aVar = this.f77322c;
        if (aVar != null) {
            aVar.Wb(this.f77321b.get(i11), i11);
        }
        c(this.f77321b.get(i11));
        for (int i12 = 0; i12 < this.f77321b.size(); i12++) {
            TextView textView = this.f77321b.get(i12);
            if (i12 == i11) {
                textView.setTypeface(ResourcesCompat.h(textView.getContext(), R$font.roboto_medium));
            } else {
                textView.setTypeface(ResourcesCompat.h(textView.getContext(), R$font.roboto_regular));
            }
        }
    }

    public void setOnItemSelectedListener(a aVar) {
        this.f77322c = aVar;
    }

    public void setTabNames(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                String str = strArr[i11];
                TextView tabTextView = getTabTextView();
                tabTextView.setText(str);
                tabTextView.setTag(Integer.valueOf(i11));
                tabTextView.setOnClickListener(new f(this));
                this.f77324e.addView(tabTextView);
                this.f77321b.add(tabTextView);
            }
        }
    }

    public RectTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77326g = null;
        d(context);
    }
}
