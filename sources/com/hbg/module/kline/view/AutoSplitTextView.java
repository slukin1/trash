package com.hbg.module.kline.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class AutoSplitTextView extends AppCompatTextView {
    public AutoSplitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSourceText(String str) {
        if (!TextUtils.isEmpty(str)) {
            int maxWidth = getMaxWidth();
            String[] split = str.split(" ");
            if (maxWidth <= 0 || split.length <= 1) {
                setText(str);
                return;
            }
            TextPaint paint = getPaint();
            float measureText = paint.measureText(" ");
            StringBuilder sb2 = new StringBuilder();
            float f11 = 0.0f;
            for (int i11 = 0; i11 < split.length; i11++) {
                String str2 = split[i11];
                float measureText2 = paint.measureText(str2);
                if (i11 == 0) {
                    sb2.append(str2);
                    sb2.append(" ");
                } else if (i11 == split.length - 1) {
                    f11 += measureText2;
                    if (f11 <= ((float) maxWidth)) {
                        sb2.append(str2);
                    } else {
                        if (sb2.toString().endsWith(" ")) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        sb2.append("\n");
                        sb2.append(str2);
                        sb2.append(" ");
                    }
                } else {
                    float f12 = f11 + measureText2;
                    float f13 = (float) maxWidth;
                    if (f12 + measureText <= f13) {
                        sb2.append(str2);
                        sb2.append(" ");
                        f11 += measureText2 + measureText;
                    } else if (f12 <= f13) {
                        sb2.append(str2);
                        f11 = f12;
                    } else {
                        if (sb2.toString().endsWith(" ")) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        sb2.append("\n");
                        sb2.append(str2);
                        sb2.append(" ");
                    }
                }
                f11 = measureText2 + measureText;
            }
            setText(sb2.toString());
            return;
        }
        setText(str);
    }

    public AutoSplitTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
