package androidx.activity;

import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class OnBackPressedDispatcher$addCallback$1 extends FunctionReferenceImpl implements a<Unit> {
    public OnBackPressedDispatcher$addCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final void invoke() {
        ((OnBackPressedDispatcher) this.receiver).q();
    }
}
