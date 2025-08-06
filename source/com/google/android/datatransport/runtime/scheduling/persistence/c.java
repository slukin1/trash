package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65634a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65635b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f65636c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f65637d;

    public /* synthetic */ c(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f65634a = sQLiteEventStore;
        this.f65635b = str;
        this.f65636c = map;
        this.f65637d = builder;
    }

    public final Object apply(Object obj) {
        return this.f65634a.lambda$loadClientMetrics$20(this.f65635b, this.f65636c, this.f65637d, (SQLiteDatabase) obj);
    }
}
