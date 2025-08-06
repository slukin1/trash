package com.tencent.thumbplayer.tcmedia.adapter;

import com.tencent.thumbplayer.tcmedia.adapter.a.b;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.adapter.a.e;
import com.tencent.thumbplayer.tcmedia.api.TPVideoInfo;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaSynchronizer;
import java.util.Map;

public interface a extends b {
    int a();

    void a(c.k kVar);

    void a(e eVar);

    void a(e eVar, int i11, long j11);

    void a(e eVar, Map<String, String> map);

    void a(e eVar, Map<String, String> map, int i11, long j11);

    void a(TPVideoInfo tPVideoInfo);

    void a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    int b();

    void b(TPVideoInfo tPVideoInfo);

    boolean c();

    int d();

    b e();

    void f();
}
