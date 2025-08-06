package com.huobi.finance.utils;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import i6.m;

public class UiFillUtil {
    public static void a(TextView textView, String str) {
        b(textView, str, false);
    }

    public static void b(TextView textView, String str, boolean z11) {
        if (textView != null) {
            CharSequence text = textView.getText();
            boolean z12 = true;
            boolean z13 = TextUtils.isEmpty(text) && !TextUtils.isEmpty(str);
            if (text == null || text.equals(str)) {
                z12 = false;
            }
            if (z13 || z12) {
                textView.setText(str);
                if (z11 && (textView instanceof EditText)) {
                    ((EditText) textView).setSelection(textView.getText().toString().length());
                }
            }
        }
    }

    public static String c(String str) {
        return m.u0(str, 12, 8);
    }

    public static String d(String str) {
        return m.u0(str, 12, 8);
    }
}
