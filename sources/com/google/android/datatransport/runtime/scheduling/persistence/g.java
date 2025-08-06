package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f65651a;

    public /* synthetic */ g(Map map) {
        this.f65651a = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$16(this.f65651a, (Cursor) obj);
    }
}
