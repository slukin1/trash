package com.google.android.play.core.integrity;

import android.content.Context;

public class IntegrityManagerFactory {
    private IntegrityManagerFactory() {
    }

    public static IntegrityManager create(Context context) {
        return v.a(context).a();
    }

    public static StandardIntegrityManager createStandard(Context context) {
        return aj.a(context).a();
    }
}
