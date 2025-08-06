package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class f implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3674a;

    public /* synthetic */ f(ComponentActivity componentActivity) {
        this.f3674a = componentActivity;
    }

    public final Bundle saveState() {
        return this.f3674a.lambda$new$1();
    }
}
