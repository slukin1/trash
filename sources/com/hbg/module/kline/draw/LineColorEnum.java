package com.hbg.module.kline.draw;

import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$drawable;

public enum LineColorEnum {
    LINE_COLOR_1(1, R$drawable.kline_edit_color_palette_1, R$color.kline_drawing1_color),
    LINE_COLOR_2(2, R$drawable.kline_edit_color_palette_2, R$color.kline_drawing2_color),
    LINE_COLOR_3(3, R$drawable.kline_edit_color_palette_3, R$color.kline_drawing3_color),
    LINE_COLOR_4(4, R$drawable.kline_edit_color_palette_4, R$color.kline_drawing4_color),
    LINE_COLOR_5(5, R$drawable.kline_edit_color_palette_5, R$color.kline_drawing5_color),
    LINE_COLOR_6(6, R$drawable.kline_edit_color_palette_6, R$color.kline_drawing6_color),
    LINE_COLOR_7(7, R$drawable.kline_edit_color_palette_7, R$color.kline_drawing7_color),
    LINE_COLOR_8(8, R$drawable.kline_edit_color_palette_8, R$color.kline_drawing8_color);
    
    private int colorId;
    private int drawableId;
    private int index;

    private LineColorEnum(int i11, int i12, int i13) {
        this.index = i11;
        this.drawableId = i12;
        this.colorId = i13;
    }

    public static LineColorEnum getLineColor(int i11) {
        LineColorEnum[] values = values();
        for (int i12 = 0; i12 < values.length; i12++) {
            if (values[i12].index == i11) {
                return values[i12];
            }
        }
        return LINE_COLOR_1;
    }

    public int getColorId() {
        return this.colorId;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public int getIndex() {
        return this.index;
    }
}
