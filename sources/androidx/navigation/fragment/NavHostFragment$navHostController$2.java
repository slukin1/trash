package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.e;
import androidx.navigation.h;
import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

public final class NavHostFragment$navHostController$2 extends Lambda implements a<h> {
    public final /* synthetic */ NavHostFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostFragment$navHostController$2(NavHostFragment navHostFragment) {
        super(0);
        this.this$0 = navHostFragment;
    }

    /* access modifiers changed from: private */
    public static final Bundle invoke$lambda$5$lambda$2(h hVar) {
        Bundle h02 = hVar.h0();
        return h02 == null ? Bundle.EMPTY : h02;
    }

    /* access modifiers changed from: private */
    public static final Bundle invoke$lambda$5$lambda$4(NavHostFragment navHostFragment) {
        if (navHostFragment.f10414d == 0) {
            return Bundle.EMPTY;
        }
        return e.a(l.a("android-support-nav:fragment:graphId", Integer.valueOf(navHostFragment.f10414d)));
    }

    public final h invoke() {
        Context context = this.this$0.getContext();
        if (context != null) {
            h hVar = new h(context);
            NavHostFragment navHostFragment = this.this$0;
            hVar.l0(navHostFragment);
            hVar.m0(navHostFragment.getViewModelStore());
            navHostFragment.xh(hVar);
            Bundle b11 = navHostFragment.getSavedStateRegistry().b("android-support-nav:fragment:navControllerState");
            if (b11 != null) {
                hVar.f0(b11);
            }
            navHostFragment.getSavedStateRegistry().h("android-support-nav:fragment:navControllerState", new g(hVar));
            Bundle b12 = navHostFragment.getSavedStateRegistry().b("android-support-nav:fragment:graphId");
            if (b12 != null) {
                navHostFragment.f10414d = b12.getInt("android-support-nav:fragment:graphId");
            }
            navHostFragment.getSavedStateRegistry().h("android-support-nav:fragment:graphId", new h(navHostFragment));
            if (navHostFragment.f10414d != 0) {
                hVar.i0(navHostFragment.f10414d);
            } else {
                Bundle arguments = navHostFragment.getArguments();
                int i11 = arguments != null ? arguments.getInt("android-support-nav:fragment:graphId") : 0;
                Bundle bundle = arguments != null ? arguments.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
                if (i11 != 0) {
                    hVar.j0(i11, bundle);
                }
            }
            return hVar;
        }
        throw new IllegalStateException("NavController cannot be created before the fragment is attached".toString());
    }
}
