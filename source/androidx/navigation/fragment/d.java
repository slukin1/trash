package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a0;
import androidx.navigation.NavigatorState;

public final /* synthetic */ class d implements a0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavigatorState f10426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentNavigator f10427c;

    public /* synthetic */ d(NavigatorState navigatorState, FragmentNavigator fragmentNavigator) {
        this.f10426b = navigatorState;
        this.f10427c = fragmentNavigator;
    }

    public final void a(FragmentManager fragmentManager, Fragment fragment) {
        FragmentNavigator.w(this.f10426b, this.f10427c, fragmentManager, fragment);
    }
}
