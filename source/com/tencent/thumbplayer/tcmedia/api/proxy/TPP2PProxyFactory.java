package com.tencent.thumbplayer.tcmedia.api.proxy;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.c.g;

public class TPP2PProxyFactory {
    public static ITPPreloadProxy createPreloadManager(Context context, int i11) {
        return new g(context, i11);
    }
}
