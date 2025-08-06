package androidx.datastore.preferences;

import androidx.datastore.preferences.core.Preferences;
import d10.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "prefs", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@d(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends SuspendLambda implements p<Preferences, c<? super Boolean>, Object> {
    public final /* synthetic */ Set<String> $keysToMigrate;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, c<? super SharedPreferencesMigrationKt$getShouldRunMigration$1> cVar) {
        super(2, cVar);
        this.$keysToMigrate = set;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.$keysToMigrate, cVar);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.L$0 = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }

    public final Object invoke(Preferences preferences, c<? super Boolean> cVar) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) create(preferences, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            Set<Preferences.a<?>> keySet = ((Preferences) this.L$0).a().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(keySet, 10));
            for (Preferences.a a11 : keySet) {
                arrayList.add(a11.a());
            }
            boolean z11 = false;
            if (this.$keysToMigrate == e.a()) {
                z11 = true;
            } else {
                Set<String> set = this.$keysToMigrate;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it2 = set.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (a.a(!arrayList.contains((String) it2.next())).booleanValue()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    z11 = true;
                }
            }
            return a.a(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
