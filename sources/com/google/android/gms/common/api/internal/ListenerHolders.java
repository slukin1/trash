package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> zaa = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l11, Looper looper, String str) {
        Preconditions.checkNotNull(l11, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l11, str);
    }

    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l11, String str) {
        Preconditions.checkNotNull(l11, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l11, str);
    }

    public final <L> ListenerHolder<L> zaa(L l11, Looper looper, String str) {
        ListenerHolder<L> createListenerHolder = createListenerHolder(l11, looper, "NO_TYPE");
        this.zaa.add(createListenerHolder);
        return createListenerHolder;
    }

    public final void zab() {
        for (ListenerHolder<?> clear : this.zaa) {
            clear.clear();
        }
        this.zaa.clear();
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l11, Executor executor, String str) {
        Preconditions.checkNotNull(l11, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l11, str);
    }
}
