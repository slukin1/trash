package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {167, 75, 92}, m = "updateSettings")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RemoteSettings$updateSettings$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$1(RemoteSettings remoteSettings, c<? super RemoteSettings$updateSettings$1> cVar) {
        super(cVar);
        this.this$0 = remoteSettings;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSettings(this);
    }
}
