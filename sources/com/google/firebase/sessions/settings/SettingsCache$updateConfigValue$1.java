package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {112}, m = "updateConfigValue")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SettingsCache$updateConfigValue$1<T> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SettingsCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$1(SettingsCache settingsCache, c<? super SettingsCache$updateConfigValue$1> cVar) {
        super(cVar);
        this.this$0 = settingsCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateConfigValue((Preferences.a) null, null, this);
    }
}
