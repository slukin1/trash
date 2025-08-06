package com.huobi.view.pickerview.adapter;

import com.huobi.view.wheelview.adapter.WheelAdapter;

public class NumericWheelAdapter implements WheelAdapter {
    private int maxValue;
    private int minValue;

    public NumericWheelAdapter(int i11, int i12) {
        this.minValue = i11;
        this.maxValue = i12;
    }

    public Object getItem(int i11) {
        if (i11 < 0 || i11 >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.minValue + i11);
    }

    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }

    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.minValue;
        } catch (Exception unused) {
            return -1;
        }
    }
}
