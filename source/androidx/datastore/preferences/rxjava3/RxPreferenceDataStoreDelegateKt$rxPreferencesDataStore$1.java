package androidx.datastore.preferences.rxjava3;

import android.content.Context;
import androidx.datastore.core.c;
import androidx.datastore.preferences.core.Preferences;
import d10.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/content/Context;", "it", "", "Landroidx/datastore/core/c;", "Landroidx/datastore/preferences/core/Preferences;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1 extends Lambda implements l<Context, List<? extends c<Preferences>>> {
    public static final RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1 INSTANCE = new RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1();

    public RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1() {
        super(1);
    }

    public final List<c<Preferences>> invoke(Context context) {
        return CollectionsKt__CollectionsKt.k();
    }
}
