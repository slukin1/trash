package com.hbg.module.kline.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.BSTInfo;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$font;
import com.hbg.module.kline.R$id;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import i6.m;
import java.util.List;

public class KlineTopBSTView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24377b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24378c;

    /* renamed from: d  reason: collision with root package name */
    public int f24379d;

    /* renamed from: e  reason: collision with root package name */
    public int f24380e;

    public KlineTopBSTView(Context context) {
        this(context, (AttributeSet) null);
    }

    public int a(int i11) {
        if (getContext() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public int b(int i11) {
        if (getContext() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public final void c(Context context) {
        setBackgroundColor(a(R$attr.kline_content_background_color));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f24377b = linearLayout;
        linearLayout.setId(R$id.divider3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        layoutParams.leftMargin = (int) getContext().getResources().getDimension(R$dimen.dimen_16);
        Resources resources = getContext().getResources();
        int i11 = R$dimen.dimen_31;
        layoutParams.rightMargin = (int) resources.getDimension(i11);
        addView(this.f24377b, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(R$id.divider2);
        imageView.setImageResource(b(R$attr.kline_bst_arrow));
        Resources resources2 = getContext().getResources();
        int i12 = R$dimen.dimen_14;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) resources2.getDimension(i12), (int) getContext().getResources().getDimension(i12));
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = (int) getContext().getResources().getDimension(R$dimen.dimen_6);
        addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(b(R$attr.kline_bst_shadow));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) getContext().getResources().getDimension(R$dimen.dimen_12), (int) getContext().getResources().getDimension(R$dimen.dimen_30));
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = (int) getContext().getResources().getDimension(i11);
        addView(imageView2, layoutParams3);
        View view = new View(getContext());
        view.setBackgroundColor(a(R$attr.kline_primary_separator_color));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(R$dimen.dimen_0_5));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }

    public final void d(TextView textView, BSTInfo.Trade trade) {
        if ("B".equalsIgnoreCase(trade.getType())) {
            textView.setText("Buy");
            if (w.l()) {
                textView.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.shape_kline_bst_red));
            } else {
                textView.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.shape_kline_bst_green));
            }
        } else {
            textView.setText("Sell");
            if (w.l()) {
                textView.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.shape_kline_bst_green));
            } else {
                textView.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.shape_kline_bst_red));
            }
        }
    }

    public void setContract(boolean z11) {
        this.f24378c = z11;
    }

    public void setData(List<BSTInfo.Trade> list) {
        int i11;
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f24377b.removeAllViews();
        setVisibility(0);
        for (int i12 = 0; i12 < list.size(); i12++) {
            BSTInfo.Trade trade = list.get(i12);
            TextView textView = new TextView(getContext());
            textView.setTextSize(1, 10.0f);
            Context context = getContext();
            int i13 = R$font.roboto_regular;
            textView.setTypeface(ResourcesCompat.h(context, i13));
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            Resources resources = getContext().getResources();
            int i14 = R$dimen.dimen_2;
            textView.setPadding((int) resources.getDimension(i14), (int) getContext().getResources().getDimension(i14), (int) getContext().getResources().getDimension(i14), (int) getContext().getResources().getDimension(i14));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            if (i12 == 0) {
                i11 = 0;
            } else {
                i11 = (int) getContext().getResources().getDimension(R$dimen.dimen_16);
            }
            layoutParams.leftMargin = i11;
            this.f24377b.addView(textView, layoutParams);
            TextView textView2 = new TextView(getContext());
            textView2.setTextSize(1, 10.0f);
            textView2.setTypeface(ResourcesCompat.h(getContext(), i13));
            textView2.setGravity(17);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(a(R$attr.kline_primary_text_color));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = (int) getContext().getResources().getDimension(i14);
            this.f24377b.addView(textView2, layoutParams2);
            TextView textView3 = new TextView(getContext());
            textView3.setTextSize(1, 10.0f);
            textView3.setTypeface(ResourcesCompat.h(getContext(), i13));
            textView3.setGravity(17);
            textView3.setSingleLine();
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setTextColor(a(R$attr.kline_three_level_text_color));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 16;
            this.f24377b.addView(textView3, layoutParams3);
            d(textView, trade);
            textView2.setText(m.q(trade.getNum(), this.f24380e));
            textView3.setText(TIMMentionEditText.TIM_MENTION_TAG + m.k(trade.getPrice(), this.f24379d, true));
        }
    }

    public void setNumPrecision(int i11) {
        this.f24380e = i11;
    }

    public void setPricePrecision(int i11) {
        this.f24379d = i11;
    }

    public KlineTopBSTView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KlineTopBSTView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
