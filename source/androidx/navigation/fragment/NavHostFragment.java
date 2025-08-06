package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.R$styleable;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.h;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;

public class NavHostFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f10411f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final i f10412b = LazyKt__LazyJVMKt.a(new NavHostFragment$navHostController$2(this));

    /* renamed from: c  reason: collision with root package name */
    public View f10413c;

    /* renamed from: d  reason: collision with root package name */
    public int f10414d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10415e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ NavHostFragment b(a aVar, int i11, Bundle bundle, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                bundle = null;
            }
            return aVar.a(i11, bundle);
        }

        public final NavHostFragment a(int i11, Bundle bundle) {
            Bundle bundle2;
            if (i11 != 0) {
                bundle2 = new Bundle();
                bundle2.putInt("android-support-nav:fragment:graphId", i11);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle("android-support-nav:fragment:startDestinationArgs", bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        public final NavController c(Fragment fragment) {
            Dialog dialog;
            Window window;
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
                if (fragment2 instanceof NavHostFragment) {
                    return ((NavHostFragment) fragment2).vh();
                }
                Fragment G0 = fragment2.getParentFragmentManager().G0();
                if (G0 instanceof NavHostFragment) {
                    return ((NavHostFragment) G0).vh();
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.b(view);
            }
            View view2 = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (!(dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || (window = dialog.getWindow()) == null)) {
                view2 = window.getDecorView();
            }
            if (view2 != null) {
                return Navigation.b(view2);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }
    }

    public static final NavController sh(Fragment fragment) {
        return f10411f.c(fragment);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f10415e) {
            getParentFragmentManager().q().y(this).j();
        }
    }

    public void onCreate(Bundle bundle) {
        vh();
        if (bundle != null && bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
            this.f10415e = true;
            getParentFragmentManager().q().y(this).j();
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(th());
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f10413c;
        if (view != null && Navigation.b(view) == vh()) {
            Navigation.e(view, (NavController) null);
        }
        this.f10413c = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f10414d = resourceId;
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.f10415e = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10415e) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            Navigation.e(view, vh());
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.f10413c = view2;
                if (view2.getId() == getId()) {
                    Navigation.e(this.f10413c, vh());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
    }

    public Navigator<? extends FragmentNavigator.b> rh() {
        return new FragmentNavigator(requireContext(), getChildFragmentManager(), th());
    }

    public final int th() {
        int id2 = getId();
        return (id2 == 0 || id2 == -1) ? R$id.nav_host_fragment_container : id2;
    }

    public final NavController uh() {
        return vh();
    }

    public final h vh() {
        return (h) this.f10412b.getValue();
    }

    public void wh(NavController navController) {
        navController.I().b(new b(requireContext(), getChildFragmentManager()));
        navController.I().b(rh());
    }

    public void xh(h hVar) {
        wh(hVar);
    }
}
