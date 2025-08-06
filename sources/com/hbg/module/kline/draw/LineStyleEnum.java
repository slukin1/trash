package com.hbg.module.kline.draw;

import android.content.Context;
import com.hbg.module.kline.R$drawable;

public enum LineStyleEnum {
    DOT_LINE_BIG(1, R$drawable.kline_edit_line_style_dot_line_big),
    DOT_LINE(2, R$drawable.kline_edit_line_style_dot_line),
    SOLID_LINE(3, R$drawable.kline_edit_line_style_solid_line);
    
    private int resId;
    private int styleId;

    private LineStyleEnum(int i11, int i12) {
        this.styleId = i11;
        this.resId = i12;
    }

    public static int getIconResourceId(Context context, LineStyleEnum lineStyleEnum) {
        return lineStyleEnum.getResId();
    }

    public static LineStyleEnum getLineStyle(int i11) {
        LineStyleEnum[] values = values();
        for (int i12 = 0; i12 < values.length; i12++) {
            if (values[i12].getStyleId() == i11) {
                return values[i12];
            }
        }
        return SOLID_LINE;
    }

    public int getResId() {
        return this.resId;
    }

    public int getStyleId() {
        return this.styleId;
    }
}
