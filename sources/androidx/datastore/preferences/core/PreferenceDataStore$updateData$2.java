package androidx.datastore.preferences.core;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStore$updateData$2 extends SuspendLambda implements p<Preferences, c<? super Preferences>, Object> {
    public final /* synthetic */ p<Preferences, c<? super Preferences>, Object> $transform;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStore$updateData$2(p<? super Preferences, ? super c<? super Preferences>, ? extends Object> pVar, c<? super PreferenceDataStore$updateData$2> cVar) {
        super(2, cVar);
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.$transform, cVar);
        preferenceDataStore$updateData$2.L$0 = obj;
        return preferenceDataStore$updateData$2;
    }

    public final Object invoke(Preferences preferences, c<? super Preferences> cVar) {
        return ((PreferenceDataStore$updateData$2) create(preferences, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            p<Preferences, c<? super Preferences>, Object> pVar = this.$transform;
            this.label = 1;
            obj = pVar.invoke((Preferences) this.L$0, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Preferences preferences = (Preferences) obj;
        ((MutablePreferences) preferences).g();
        return preferences;
    }
}
