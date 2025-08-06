package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.o;
import androidx.core.view.h0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.R$styleable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public abstract class AbstractListDetailFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public o f10391b;

    /* renamed from: c  reason: collision with root package name */
    public NavHostFragment f10392c;

    /* renamed from: d  reason: collision with root package name */
    public int f10393d;

    public static final class a extends o implements SlidingPaneLayout.e {

        /* renamed from: a  reason: collision with root package name */
        public final SlidingPaneLayout f10394a;

        public a(SlidingPaneLayout slidingPaneLayout) {
            super(true);
            this.f10394a = slidingPaneLayout;
            slidingPaneLayout.a(this);
        }

        public void a(View view) {
            setEnabled(true);
        }

        public void b(View view) {
            setEnabled(false);
        }

        public void c(View view, float f11) {
        }

        public void handleOnBackPressed() {
            this.f10394a.b();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbstractListDetailFragment f10395b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f10396c;

        public b(AbstractListDetailFragment abstractListDetailFragment, SlidingPaneLayout slidingPaneLayout) {
            this.f10395b = abstractListDetailFragment;
            this.f10396c = slidingPaneLayout;
        }

        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            view.removeOnLayoutChangeListener(this);
            this.f10395b.f10391b.setEnabled(this.f10396c.n() && this.f10396c.m());
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NavHostFragment navHostFragment;
        if (bundle != null) {
            this.f10393d = bundle.getInt("android-support-nav:fragment:graphId");
        }
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R$id.sliding_pane_layout);
        View sh2 = sh(layoutInflater, slidingPaneLayout, bundle);
        if (!x.b(sh2, slidingPaneLayout) && !x.b(sh2.getParent(), slidingPaneLayout)) {
            slidingPaneLayout.addView(sh2);
        }
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        int i11 = R$id.sliding_pane_detail_container;
        fragmentContainerView.setId(i11);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(layoutInflater.getContext().getResources().getDimensionPixelSize(R$dimen.sliding_pane_detail_pane_width), -1);
        layoutParams.f10982a = 1.0f;
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        Fragment l02 = getChildFragmentManager().l0(i11);
        boolean z11 = true;
        if (l02 != null) {
            navHostFragment = (NavHostFragment) l02;
        } else {
            navHostFragment = rh();
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.z(true);
            q11.b(i11, navHostFragment);
            q11.j();
        }
        this.f10392c = navHostFragment;
        this.f10391b = new a(slidingPaneLayout);
        if (!h0.a0(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new b(this, slidingPaneLayout));
        } else {
            o ph2 = this.f10391b;
            if (!slidingPaneLayout.n() || !slidingPaneLayout.m()) {
                z11 = false;
            }
            ph2.setEnabled(z11);
        }
        requireActivity().getOnBackPressedDispatcher().i(getViewLifecycleOwner(), this.f10391b);
        return slidingPaneLayout;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f10393d = resourceId;
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i11 = this.f10393d;
        if (i11 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i11);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        th(qh().getChildAt(0), bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.f10391b.setEnabled(qh().n() && qh().m());
    }

    public final SlidingPaneLayout qh() {
        return (SlidingPaneLayout) requireView();
    }

    public NavHostFragment rh() {
        int i11 = this.f10393d;
        if (i11 != 0) {
            return NavHostFragment.a.b(NavHostFragment.f10411f, i11, (Bundle) null, 2, (Object) null);
        }
        return new NavHostFragment();
    }

    public abstract View sh(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void th(View view, Bundle bundle) {
    }
}
