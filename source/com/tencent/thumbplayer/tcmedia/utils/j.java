package com.tencent.thumbplayer.tcmedia.utils;

import com.tencent.thumbplayer.tcmedia.api.TPAudioAttributes;
import com.tencent.thumbplayer.tcmedia.api.TPJitterBufferConfig;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import java.util.HashMap;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, Class> f49714a;

    static {
        HashMap<Integer, Class> hashMap = new HashMap<>();
        f49714a = hashMap;
        hashMap.put(414, TPAudioAttributes.class);
        hashMap.put(Integer.valueOf(TPOptionalID.OPTION_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS), TPSubtitleRenderModel.class);
        hashMap.put(140, TPJitterBufferConfig.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = f49714a.get(java.lang.Integer.valueOf(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(@com.tencent.thumbplayer.tcmedia.api.TPCommonEnum.TPOptionalId int r2, java.lang.Object r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.HashMap<java.lang.Integer, java.lang.Class> r1 = f49714a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r1.get(r2)
            java.lang.Class r2 = (java.lang.Class) r2
            if (r2 != 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.Class r3 = r3.getClass()
            if (r3 == r2) goto L_0x001a
            return r0
        L_0x001a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.j.a(int, java.lang.Object):boolean");
    }
}
