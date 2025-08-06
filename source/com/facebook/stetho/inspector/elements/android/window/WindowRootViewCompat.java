package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.facebook.stetho.common.Util;
import java.util.List;

public abstract class WindowRootViewCompat {
    private static WindowRootViewCompat sInstance;

    public static WindowRootViewCompat get(Context context) {
        WindowRootViewCompat windowRootViewCompat = sInstance;
        if (windowRootViewCompat != null) {
            return windowRootViewCompat;
        }
        Util.throwIfNull(context);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            sInstance = new WindowRootViewCompactV19Impl();
        } else if (i11 == 17 || i11 == 18) {
            sInstance = new WindowRootViewCompactV18Impl();
        } else {
            sInstance = new WindowRootViewCompactV16Impl(context.getApplicationContext());
        }
        return sInstance;
    }

    public abstract List<View> getRootViews();
}
