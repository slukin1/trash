package com.tencent.thumbplayer.tcmedia.adapter;

import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.e.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a;

public class e {
    public static a a(b bVar, a aVar) {
        return TPPlayerConfig.getNewReportEnable() ? (a) new f(new d(aVar.a(), bVar), aVar).a() : new d(aVar.a(), bVar);
    }
}
