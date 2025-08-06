package com.tencent.qcloud.tuikit.tuicallkit.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class DisplayUtils {
    public static int dip2px(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static ArrayList<RelativeLayout.LayoutParams> initFloatParamList(Context context, int i11, int i12) {
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(new RelativeLayout.LayoutParams(-1, -1));
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 15.0f);
        int dip2px3 = dip2px(context, 50.0f);
        int dip2px4 = dip2px(context, 120.0f);
        int dip2px5 = dip2px(context, 180.0f);
        for (int i13 = 2; i13 >= 0; i13--) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px4, dip2px5);
            layoutParams.leftMargin = (i11 - dip2px2) - dip2px4;
            layoutParams.topMargin = (i12 - ((((i13 + 1) * dip2px) + dip2px3) + (dip2px5 * i13))) - dip2px5;
            arrayList.add(layoutParams);
        }
        for (int i14 = 2; i14 >= 0; i14--) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dip2px4, dip2px5);
            layoutParams2.leftMargin = dip2px2;
            layoutParams2.topMargin = (i12 - ((((i14 + 1) * dip2px) + dip2px3) + (dip2px5 * i14))) - dip2px5;
            arrayList.add(layoutParams2);
        }
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> initGrid1Param(Context context, int i11, int i12) {
        int dip2px = dip2px(context, 10.0f) * 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((i11 - dip2px) / 2, (i12 - dip2px) / 2);
        layoutParams.addRule(13);
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(layoutParams);
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> initGrid2Param(Context context, int i11, int i12) {
        int dip2px = dip2px(context, 10.0f);
        int i13 = dip2px * 2;
        int i14 = (i11 - i13) / 2;
        int i15 = (i12 - i13) / 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = dip2px;
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> initGrid3Param(Context context, int i11, int i12) {
        int dip2px = dip2px(context, 10.0f);
        int i13 = dip2px * 2;
        int i14 = (i11 - i13) / 2;
        int i15 = (i12 - i13) / 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = dip2px;
        layoutParams3.topMargin = dip2px + i15;
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        arrayList.add(layoutParams3);
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> initGrid4Param(Context context, int i11, int i12) {
        int dip2px = dip2px(context, 10.0f);
        int i13 = dip2px * 2;
        int i14 = (i11 - i13) / 2;
        int i15 = (i12 - i13) / 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams3.addRule(9);
        layoutParams3.bottomMargin = dip2px;
        int i16 = dip2px + i15;
        layoutParams3.topMargin = i16;
        layoutParams3.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams4.addRule(11);
        layoutParams4.bottomMargin = dip2px;
        layoutParams4.topMargin = i16;
        layoutParams4.rightMargin = dip2px;
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        arrayList.add(layoutParams3);
        arrayList.add(layoutParams4);
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> initGrid9Param(Context context, int i11, int i12) {
        int dip2px = dip2px(context, 10.0f);
        int i13 = dip2px * 2;
        int i14 = (i11 - i13) / 3;
        int i15 = (i12 - i13) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = dip2px;
        int i16 = dip2px + i14;
        layoutParams2.leftMargin = i16;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams3.addRule(11);
        layoutParams3.addRule(10);
        layoutParams3.topMargin = dip2px;
        layoutParams3.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams4.addRule(9);
        layoutParams4.leftMargin = dip2px;
        int i17 = dip2px + i15;
        layoutParams4.topMargin = i17;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams5.topMargin = i17;
        layoutParams5.leftMargin = i16;
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams6.addRule(11);
        layoutParams6.topMargin = i17;
        layoutParams6.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams7.addRule(9);
        layoutParams7.bottomMargin = dip2px;
        layoutParams7.leftMargin = dip2px;
        int i18 = (i15 * 2) + dip2px;
        layoutParams7.topMargin = i18;
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams8.bottomMargin = dip2px;
        layoutParams8.topMargin = i18;
        layoutParams8.leftMargin = i16;
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(i14, i15);
        layoutParams9.addRule(11);
        layoutParams9.bottomMargin = dip2px;
        layoutParams9.topMargin = i18;
        layoutParams9.rightMargin = dip2px;
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        arrayList.add(layoutParams3);
        arrayList.add(layoutParams4);
        arrayList.add(layoutParams5);
        arrayList.add(layoutParams6);
        arrayList.add(layoutParams7);
        arrayList.add(layoutParams8);
        arrayList.add(layoutParams9);
        return arrayList;
    }
}
