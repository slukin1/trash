package androidx.datastore.preferences.core;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferencesKt$edit$2 extends SuspendLambda implements p<Preferences, c<? super Preferences>, Object> {
    public final /* synthetic */ p<MutablePreferences, c<? super Unit>, Object> $transform;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferencesKt$edit$2(p<? super MutablePreferences, ? super c<? super Unit>, ? extends Object> pVar, c<? super PreferencesKt$edit$2> cVar) {
        super(2, cVar);
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.$transform, cVar);
        preferencesKt$edit$2.L$0 = obj;
        return preferencesKt$edit$2;
    }

    public final Object invoke(Preferences preferences, c<? super Preferences> cVar) {
        return ((PreferencesKt$edit$2) create(preferences, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            MutablePreferences c11 = ((Preferences) this.L$0).c();
            p<MutablePreferences, c<? super Unit>, Object> pVar = this.$transform;
            this.L$0 = c11;
            this.label = 1;
            return pVar.invoke(c11, this) == d11 ? d11 : c11;
        } else if (i11 == 1) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            k.b(obj);
            return mutablePreferences;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
