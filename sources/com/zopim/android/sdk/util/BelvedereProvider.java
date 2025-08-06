package com.zopim.android.sdk.util;

import android.content.Context;
import com.luck.picture.lib.config.SelectMimeType;
import com.zendesk.belvedere.Belvedere;
import com.zendesk.logger.Logger;

public enum BelvedereProvider {
    INSTANCE;
    
    private Belvedere belvedere;

    private Belvedere initBelvedere(Context context) {
        return Belvedere.b(context).j(false).k(SelectMimeType.SYSTEM_IMAGE).l(Logger.h()).i();
    }

    public Belvedere getInstance(Context context) {
        synchronized (INSTANCE) {
            if (this.belvedere == null) {
                this.belvedere = initBelvedere(context);
            }
        }
        return this.belvedere;
    }
}
