package com.tencent.thumbplayer.tcmedia.adapter.a;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.adapter.a.a.e;
import com.tencent.thumbplayer.tcmedia.e.b;

public final class d {
    public static b a(Context context, b bVar) {
        return new com.tencent.thumbplayer.tcmedia.adapter.a.b.b(context, bVar);
    }

    public static b a(Context context, boolean z11, b bVar) {
        return z11 ? new com.tencent.thumbplayer.tcmedia.adapter.a.a.d(context, bVar) : new e(context, bVar);
    }
}
