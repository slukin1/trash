package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class cb {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return 0;
        }
    }
}
