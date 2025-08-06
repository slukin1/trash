package com.sumsub.sns.internal.core.common;

import android.os.Build;
import android.os.Bundle;
import java.util.List;
import kotlin.jvm.internal.x;

public final class g {
    public static final /* synthetic */ <T> List<T> b(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelableArrayList(str);
        }
        x.f(4, "T");
        return bundle.getParcelableArrayList(str, Object.class);
    }
}
