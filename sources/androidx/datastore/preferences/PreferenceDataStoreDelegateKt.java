package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.d;
import androidx.datastore.preferences.core.Preferences;
import d10.l;
import h1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.properties.c;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00070\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"", "name", "Lh1/a;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/c;", "produceMigrations", "Lkotlinx/coroutines/h0;", "scope", "Lkotlin/properties/c;", "Landroidx/datastore/core/d;", "a", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1})
public final class PreferenceDataStoreDelegateKt {
    public static final c<Context, d<Preferences>> a(String str, a<Preferences> aVar, l<? super Context, ? extends List<? extends androidx.datastore.core.c<Preferences>>> lVar, h0 h0Var) {
        return new PreferenceDataStoreSingletonDelegate(str, aVar, lVar, h0Var);
    }

    public static /* synthetic */ c b(String str, a aVar, l lVar, h0 h0Var, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = null;
        }
        if ((i11 & 4) != 0) {
            lVar = PreferenceDataStoreDelegateKt$preferencesDataStore$1.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            v0 v0Var = v0.f57570a;
            h0Var = i0.a(v0.b().plus(e2.b((n1) null, 1, (Object) null)));
        }
        return a(str, aVar, lVar, h0Var);
    }
}
