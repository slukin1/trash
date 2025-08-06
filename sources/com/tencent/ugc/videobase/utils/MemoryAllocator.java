package com.tencent.ugc.videobase.utils;

import android.content.Intent;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

public class MemoryAllocator {
    public static final String OUT_OF_MEMORY_ACTION = "com.tencent.liteav.video.action.OUT_OF_MEMORY";
    private static final String TAG = "MemoryAllocator";
    private static final a THROTTLER = new a(1000);

    public static byte[] allocateByteArray(int i11) {
        try {
            return new byte[i11];
        } catch (OutOfMemoryError e11) {
            notifyOutOfMemory(e11.getMessage());
            return null;
        }
    }

    public static ByteBuffer allocateDirectBuffer(int i11) {
        try {
            return ByteBuffer.allocateDirect(i11);
        } catch (OutOfMemoryError e11) {
            notifyOutOfMemory(e11.getMessage());
            return null;
        }
    }

    private static synchronized void notifyOutOfMemory(String str) {
        synchronized (MemoryAllocator.class) {
            if (THROTTLER.a()) {
                LiteavLog.e(TAG, "allocate buffer failed with oom error, msg:".concat(String.valueOf(str)));
                LocalBroadcastManager.getInstance().sendBroadcast(new Intent(OUT_OF_MEMORY_ACTION));
            }
        }
    }
}
