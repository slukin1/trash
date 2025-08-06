package androidx.datastore.preferences.core;

import androidx.datastore.core.c;
import androidx.datastore.core.d;
import androidx.datastore.core.e;
import h1.a;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\u0011"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "Lh1/a;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "", "Landroidx/datastore/core/c;", "migrations", "Lkotlinx/coroutines/h0;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/d;", "a", "<init>", "()V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final PreferenceDataStoreFactory f8966a = new PreferenceDataStoreFactory();

    public final d<Preferences> a(a<Preferences> aVar, List<? extends c<Preferences>> list, h0 h0Var, d10.a<? extends File> aVar2) {
        return new PreferenceDataStore(e.f8948a.a(c.f8970a, aVar, list, h0Var, new PreferenceDataStoreFactory$create$delegate$1(aVar2)));
    }
}
