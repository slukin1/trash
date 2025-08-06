package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

final class zah extends Drawable.ConstantState {
    public int zaa;
    public int zab;

    public zah(zah zah) {
        if (zah != null) {
            this.zaa = zah.zaa;
            this.zab = zah.zab;
        }
    }

    public final int getChangingConfigurations() {
        return this.zaa;
    }

    public final Drawable newDrawable() {
        return new zai(this);
    }
}
