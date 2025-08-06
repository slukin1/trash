package com.tencent.liteav.txcplayer;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.thumbplayer.ThumbMediaPlayer;
import java.lang.reflect.Constructor;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21753a = "com.tencent.liteav.txcplayer.f";

    public static ITXVCubePlayer a(Context context) {
        return b(context);
    }

    private static ITXVCubePlayer b(Context context) {
        Class<ThumbMediaPlayer> cls = ThumbMediaPlayer.class;
        try {
            int i11 = ThumbMediaPlayer.f21673a;
            Constructor<ThumbMediaPlayer> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class});
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[]{context});
        } catch (Exception e11) {
            String str = f21753a;
            LiteavLog.e(str, "create thumbplayer exception: " + e11.getMessage());
            return null;
        }
    }
}
