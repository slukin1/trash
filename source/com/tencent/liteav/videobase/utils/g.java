package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.Deque;
import java.util.LinkedList;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Deque<PixelFrame> f22273a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public int f22274b = 1;

    public final PixelFrame a() {
        PixelFrame pollFirst;
        synchronized (this) {
            pollFirst = this.f22273a.pollFirst();
        }
        return pollFirst;
    }
}
