package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {
    private final DataHolder zaa;

    @KeepForSdk
    public DataHolderNotifier(DataHolder dataHolder) {
        this.zaa = dataHolder;
    }

    @KeepForSdk
    public final void notifyListener(L l11) {
        notifyListener(l11, this.zaa);
    }

    @KeepForSdk
    public abstract void notifyListener(L l11, DataHolder dataHolder);

    @KeepForSdk
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.zaa;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
