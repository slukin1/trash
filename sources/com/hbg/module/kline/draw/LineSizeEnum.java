package com.hbg.module.kline.draw;

import com.hbg.lib.common.utils.PixelUtils;

public enum LineSizeEnum {
    LINE_SIZE_1(1, 0.5f),
    LINE_SIZE_2(2, 1.0f),
    LINE_SIZE_3(3, 1.5f),
    LINE_SIZE_4(4, 2.0f);
    
    private int index;
    private int size;

    private LineSizeEnum(int i11, float f11) {
        this.index = i11;
        this.size = PixelUtils.a(f11);
    }

    public static LineSizeEnum getLineSize(int i11) {
        LineSizeEnum[] values = values();
        for (int i12 = 0; i12 < values.length; i12++) {
            if (values[i12].index == i11) {
                return values[i12];
            }
        }
        return LINE_SIZE_1;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSize() {
        return this.size;
    }
}
