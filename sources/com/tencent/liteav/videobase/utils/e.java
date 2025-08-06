package com.tencent.liteav.videobase.utils;

import android.content.Intent;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import java.nio.ByteBuffer;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f22270a = new a(1000);

    public static byte[] a(int i11) {
        try {
            return new byte[i11];
        } catch (OutOfMemoryError e11) {
            a(e11.getMessage());
            return null;
        }
    }

    public static ByteBuffer b(int i11) {
        try {
            return ByteBuffer.allocateDirect(i11);
        } catch (OutOfMemoryError e11) {
            a(e11.getMessage());
            return null;
        }
    }

    private static synchronized void a(String str) {
        synchronized (e.class) {
            if (f22270a.a()) {
                LiteavLog.e("MemoryAllocator", "allocate buffer failed with oom error, msg:".concat(String.valueOf(str)));
                d.a().a(new Intent(MemoryAllocator.OUT_OF_MEMORY_ACTION));
            }
        }
    }
}
