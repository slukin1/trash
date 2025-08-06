package androidx.datastore.preferences;

import androidx.datastore.migrations.b;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import d10.q;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Landroidx/datastore/migrations/b;", "sharedPrefs", "Landroidx/datastore/preferences/core/Preferences;", "currentData", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@d(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends SuspendLambda implements q<b, Preferences, c<? super Preferences>, Object> {
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    public SharedPreferencesMigrationKt$getMigrationFunction$1(c<? super SharedPreferencesMigrationKt$getMigrationFunction$1> cVar) {
        super(3, cVar);
    }

    public final Object invoke(b bVar, Preferences preferences, c<? super Preferences> cVar) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(cVar);
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$0 = bVar;
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$1 = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            b bVar = (b) this.L$0;
            Preferences preferences = (Preferences) this.L$1;
            Set<Preferences.a<?>> keySet = preferences.a().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(keySet, 10));
            for (Preferences.a a11 : keySet) {
                arrayList.add(a11.a());
            }
            Map<String, Object> a12 = bVar.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : a12.entrySet()) {
                if (a.a(!arrayList.contains((String) next.getKey())).booleanValue()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            MutablePreferences c11 = preferences.c();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    c11.j(androidx.datastore.preferences.core.b.a(str), value);
                } else if (value instanceof Float) {
                    c11.j(androidx.datastore.preferences.core.b.c(str), value);
                } else if (value instanceof Integer) {
                    c11.j(androidx.datastore.preferences.core.b.d(str), value);
                } else if (value instanceof Long) {
                    c11.j(androidx.datastore.preferences.core.b.e(str), value);
                } else if (value instanceof String) {
                    c11.j(androidx.datastore.preferences.core.b.f(str), value);
                } else if (value instanceof Set) {
                    Preferences.a<Set<String>> g11 = androidx.datastore.preferences.core.b.g(str);
                    Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    c11.j(g11, (Set) value);
                }
            }
            return c11.d();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
