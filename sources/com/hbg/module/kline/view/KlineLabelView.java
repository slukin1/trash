package com.hbg.module.kline.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.network.hbg.core.bean.KlineLabel;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$font;
import java.util.List;

public class KlineLabelView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public List<KlineLabel.LabelBean> f24376b;

    public KlineLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int a(int i11) {
        if (getContext() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public void setData(List<KlineLabel.LabelBean> list) {
        this.f24376b = list;
        removeAllViews();
        setOrientation(0);
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) getContext().getResources().getDimension(R$dimen.dimen_14));
        layoutParams.gravity = 17;
        layoutParams.rightMargin = (int) getContext().getResources().getDimension(R$dimen.dimen_8);
        for (KlineLabel.LabelBean label : this.f24376b) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(1, 10.0f);
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
            textView.setGravity(17);
            Resources resources = getContext().getResources();
            int i11 = R$dimen.dimen_4;
            textView.setPadding((int) resources.getDimension(i11), 0, (int) getContext().getResources().getDimension(i11), 0);
            textView.setTextColor(a(R$attr.kline_index_selector_focus_text_color));
            textView.setBackgroundResource(R$drawable.kline_label_item_bg);
            textView.setText(label.getLabel());
            addView(textView, layoutParams);
        }
    }

    public KlineLabelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
