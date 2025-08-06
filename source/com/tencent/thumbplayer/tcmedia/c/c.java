package com.tencent.thumbplayer.tcmedia.c;

import android.os.Looper;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.tplayer.a;

public class c {
    public static a a(Looper looper, a aVar) {
        return TPPlayerConfig.getNewReportEnable() ? (a) new d(new e(aVar.a(), looper), aVar).a() : new e(aVar.a(), looper);
    }
}
