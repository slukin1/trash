package com.huobi.utils;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public final class SpannableUtils {
    public static SpannableStringBuilder a(final Activity activity, CharSequence charSequence, String str, final View.OnClickListener onClickListener) {
        int indexOf;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(str) && (indexOf = charSequence.toString().indexOf(str)) >= 0 && str.length() + indexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ContextCompat.getColor(activity, R.color.baseColorMajorTheme100));
                    textPaint.setUnderlineText(false);
                }
            }, indexOf, str.length() + indexOf, 17);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder b(final Activity activity, String str, final View.OnClickListener onClickListener) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (TextUtils.isEmpty(str)) {
            return spannableStringBuilder;
        }
        spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
            @SensorsDataInstrumented
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(activity, R.color.baseColorMajorTheme100));
                textPaint.setUnderlineText(false);
            }
        }, 0, str.length(), 17);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Activity activity, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (TextUtils.isEmpty(str)) {
            return spannableStringBuilder;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.baseColorThreeLevelText)), 0, str.length(), 33);
        return spannableStringBuilder;
    }

    public static void d(final Activity activity, SpannableStringBuilder spannableStringBuilder, String str, final View.OnClickListener onClickListener) {
        int indexOf;
        if (spannableStringBuilder != null && (indexOf = spannableStringBuilder.toString().indexOf(str)) >= 0 && str.length() + indexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ContextCompat.getColor(activity, R.color.baseColorMajorTheme100));
                    textPaint.setUnderlineText(false);
                }
            }, indexOf, str.length() + indexOf, 17);
        }
    }
}
