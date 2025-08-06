package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"T", "Landroidx/datastore/preferences/core/MutablePreferences;", "preferences", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SettingsCache$updateConfigValue$2 extends SuspendLambda implements p<MutablePreferences, c<? super Unit>, Object> {
    public final /* synthetic */ Preferences.a<T> $key;
    public final /* synthetic */ T $value;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SettingsCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$2(T t11, Preferences.a<T> aVar, SettingsCache settingsCache, c<? super SettingsCache$updateConfigValue$2> cVar) {
        super(2, cVar);
        this.$value = t11;
        this.$key = aVar;
        this.this$0 = settingsCache;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(this.$value, this.$key, this.this$0, cVar);
        settingsCache$updateConfigValue$2.L$0 = obj;
        return settingsCache$updateConfigValue$2;
    }

    public final Object invoke(MutablePreferences mutablePreferences, c<? super Unit> cVar) {
        return ((SettingsCache$updateConfigValue$2) create(mutablePreferences, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            T t11 = this.$value;
            if (t11 != null) {
                mutablePreferences.j(this.$key, t11);
            } else {
                mutablePreferences.i(this.$key);
            }
            this.this$0.updateSessionConfigs(mutablePreferences);
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
