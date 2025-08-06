package com.mob.mgs;

import android.content.Context;
import com.mob.tools.proguard.EverythingKeeper;

public interface OnAppActiveListener extends EverythingKeeper {
    void onAppActive(Context context, int i11);
}
