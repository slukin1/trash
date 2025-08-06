package com.huobi.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$font;

public final class EditTextUtil {
    public static void a(EditText editText) {
        Context context = editText.getContext();
        Typeface h11 = ResourcesCompat.h(context, R$font.roboto_medium);
        Typeface h12 = ResourcesCompat.h(context, R$font.roboto_regular);
        if (TextUtils.isEmpty(editText.getText())) {
            h11 = h12;
        }
        editText.setTypeface(h11);
    }
}
