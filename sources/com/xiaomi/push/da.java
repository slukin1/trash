package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class da {

    /* renamed from: a  reason: collision with root package name */
    private static cz f51567a;

    public static File a(Context context) {
        if (context == null) {
            b.d("ERROR: Context cannot be null.");
            return null;
        }
        cz czVar = f51567a;
        if (czVar != null) {
            return czVar.a(context);
        }
        b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
