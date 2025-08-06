package androidx.navigation;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateViewModelFactory;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class NavBackStackEntry$defaultFactory$2 extends Lambda implements a<SavedStateViewModelFactory> {
    public final /* synthetic */ NavBackStackEntry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$defaultFactory$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.this$0 = navBackStackEntry;
    }

    public final SavedStateViewModelFactory invoke() {
        Context a11 = this.this$0.f10236b;
        Application application = null;
        Context applicationContext = a11 != null ? a11.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        }
        NavBackStackEntry navBackStackEntry = this.this$0;
        return new SavedStateViewModelFactory(application, navBackStackEntry, navBackStackEntry.c());
    }
}
