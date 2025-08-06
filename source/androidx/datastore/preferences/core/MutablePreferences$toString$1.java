package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import d10.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n"}, d2 = {"", "Landroidx/datastore/preferences/core/Preferences$a;", "", "entry", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class MutablePreferences$toString$1 extends Lambda implements l<Map.Entry<Preferences.a<?>, Object>, CharSequence> {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    public MutablePreferences$toString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<Preferences.a<?>, Object> entry) {
        return "  " + entry.getKey().a() + " = " + entry.getValue();
    }
}
