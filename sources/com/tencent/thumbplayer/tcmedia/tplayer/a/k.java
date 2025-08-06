package com.tencent.thumbplayer.tcmedia.tplayer.a;

import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class k {
    public static a a(int i11) {
        if (i11 == 0) {
            return new n();
        }
        if (i11 == 1) {
            return new e();
        }
        if (i11 == 2) {
            return new f();
        }
        TPLogUtil.e("TPReporterFactory", "Type is not match ReporterType, return null");
        return null;
    }
}
