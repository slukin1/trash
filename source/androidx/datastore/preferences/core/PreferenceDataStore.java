package androidx.datastore.preferences.core;

import androidx.datastore.core.d;
import d10.p;
import kotlin.Metadata;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0007\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStore;", "Landroidx/datastore/core/d;", "Landroidx/datastore/preferences/core/Preferences;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "transform", "a", "(Ld10/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/datastore/core/d;", "delegate", "Lkotlinx/coroutines/flow/d;", "getData", "()Lkotlinx/coroutines/flow/d;", "data", "<init>", "(Landroidx/datastore/core/d;)V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStore implements d<Preferences> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Preferences> f8965a;

    public PreferenceDataStore(d<Preferences> dVar) {
        this.f8965a = dVar;
    }

    public Object a(p<? super Preferences, ? super c<? super Preferences>, ? extends Object> pVar, c<? super Preferences> cVar) {
        return this.f8965a.a(new PreferenceDataStore$updateData$2(pVar, (c<? super PreferenceDataStore$updateData$2>) null), cVar);
    }

    public kotlinx.coroutines.flow.d<Preferences> getData() {
        return this.f8965a.getData();
    }
}
