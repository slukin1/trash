package com.hbg.module.content.ui.activity.live.edgeengine;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.content.R$drawable;
import com.huobi.edgeengine.template.widget.TextWidget;
import pc.a;

public final class CornerView extends TextWidget {
    public static final void j0(GradientDrawable gradientDrawable, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (StringsKt__StringsJVMKt.M(str, "#", false, 2, (Object) null)) {
            try {
                gradientDrawable.setColor(Color.parseColor(str));
            } catch (Throwable unused) {
            }
        } else {
            gradientDrawable.setColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName())));
        }
    }

    public View P(Context context) {
        TextView textView = (TextView) super.P(context);
        GradientDrawable gradientDrawable = (GradientDrawable) context.getDrawable(R$drawable.bg_corner_view);
        u(this.f44167q, new a(gradientDrawable, context));
        textView.setBackground(gradientDrawable);
        return textView;
    }
}
