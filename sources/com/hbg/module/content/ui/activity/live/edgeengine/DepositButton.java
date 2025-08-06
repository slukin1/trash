package com.hbg.module.content.ui.activity.live.edgeengine;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.huobi.edgeengine.template.widget.Widget;

public final class DepositButton extends Widget {
    public View P(Context context) {
        TextView textView = (TextView) super.P(context);
        textView.setTextSize(0, (float) A(context, 12.0f));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        Typeface typeface = textView.getTypeface();
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setTypeface(Typeface.create(typeface, 400, false));
        }
        textView.setText(context.getString(R$string.n_otc_deposit));
        int A = A(context, 12.0f);
        textView.setPadding(A, 0, A, 0);
        textView.setBackground(context.getDrawable(R$drawable.bg_deposit_btn));
        textView.setTextColor(Color.parseColor("#0173E5"));
        return textView;
    }

    /* renamed from: X */
    public TextView q(Context context) {
        return new TextView(context);
    }
}
