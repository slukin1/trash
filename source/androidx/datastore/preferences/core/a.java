package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "a", "()Landroidx/datastore/preferences/core/Preferences;", "", "Landroidx/datastore/preferences/core/Preferences$b;", "pairs", "Landroidx/datastore/preferences/core/MutablePreferences;", "b", "([Landroidx/datastore/preferences/core/Preferences$b;)Landroidx/datastore/preferences/core/MutablePreferences;", "datastore-preferences-core"}, k = 2, mv = {1, 5, 1})
public final class a {
    public static final Preferences a() {
        return new MutablePreferences((Map) null, true, 1, (r) null);
    }

    public static final MutablePreferences b(Preferences.b<?>... bVarArr) {
        MutablePreferences mutablePreferences = new MutablePreferences((Map) null, false, 1, (r) null);
        mutablePreferences.h((Preferences.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return mutablePreferences;
    }
}
