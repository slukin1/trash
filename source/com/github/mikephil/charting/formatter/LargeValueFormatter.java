package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import d5.c;
import d5.e;
import java.text.DecimalFormat;

public class LargeValueFormatter implements e, c {

    /* renamed from: c  reason: collision with root package name */
    public static String[] f65496c = {"", "k", "m", "b", "t"};

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f65497a = new DecimalFormat("###E00");

    /* renamed from: b  reason: collision with root package name */
    public String f65498b = "";

    public String a(float f11, AxisBase axisBase) {
        return c((double) f11) + this.f65498b;
    }

    public String b(float f11, Entry entry, int i11, ViewPortHandler viewPortHandler) {
        return c((double) f11) + this.f65498b;
    }

    public final String c(double d11) {
        String format = this.f65497a.format(d11);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", f65496c[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= 5 && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }
}
