package androidx.lifecycle;

import kotlinx.coroutines.channels.k;

public final /* synthetic */ class m implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f10026b;

    public /* synthetic */ m(k kVar) {
        this.f10026b = kVar;
    }

    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f10026b, obj);
    }
}
