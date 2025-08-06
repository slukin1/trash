package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.videobase.videobase.e;

public interface c {
    void notifyEvent(e.b bVar, Object obj, String str);

    void notifyWarning(e.c cVar, String str);

    void updateStatus(f fVar, int i11, Object obj);

    void updateStatus(f fVar, Object obj);
}
