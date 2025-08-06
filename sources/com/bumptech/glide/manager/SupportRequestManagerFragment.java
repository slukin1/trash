package com.bumptech.glide.manager;

import a4.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public final a4.a f64153b;

    /* renamed from: c  reason: collision with root package name */
    public final h f64154c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<SupportRequestManagerFragment> f64155d;

    /* renamed from: e  reason: collision with root package name */
    public SupportRequestManagerFragment f64156e;

    /* renamed from: f  reason: collision with root package name */
    public d f64157f;

    /* renamed from: g  reason: collision with root package name */
    public Fragment f64158g;

    public class a implements h {
        public a() {
        }

        public Set<d> a() {
            Set<SupportRequestManagerFragment> qh2 = SupportRequestManagerFragment.this.qh();
            HashSet hashSet = new HashSet(qh2.size());
            for (SupportRequestManagerFragment next : qh2) {
                if (next.th() != null) {
                    hashSet.add(next.th());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new a4.a());
    }

    public static FragmentManager vh(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    public void Ah(d dVar) {
        this.f64157f = dVar;
    }

    public final void Bh() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f64156e;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.yh(this);
            this.f64156e = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager vh2 = vh(this);
        if (vh2 != null) {
            try {
                xh(getContext(), vh2);
            } catch (IllegalStateException e11) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e11);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f64153b.c();
        Bh();
    }

    public void onDetach() {
        super.onDetach();
        this.f64158g = null;
        Bh();
    }

    public void onStart() {
        super.onStart();
        this.f64153b.d();
    }

    public void onStop() {
        super.onStop();
        this.f64153b.e();
    }

    public final void ph(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f64155d.add(supportRequestManagerFragment);
    }

    public Set<SupportRequestManagerFragment> qh() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f64156e;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f64155d);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.f64156e.qh()) {
            if (wh(next.sh())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public a4.a rh() {
        return this.f64153b;
    }

    public final Fragment sh() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f64158g;
    }

    public d th() {
        return this.f64157f;
    }

    public String toString() {
        return super.toString() + "{parent=" + sh() + "}";
    }

    public h uh() {
        return this.f64154c;
    }

    public final boolean wh(Fragment fragment) {
        Fragment sh2 = sh();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(sh2)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void xh(Context context, FragmentManager fragmentManager) {
        Bh();
        SupportRequestManagerFragment r11 = com.bumptech.glide.a.d(context).l().r(context, fragmentManager);
        this.f64156e = r11;
        if (!equals(r11)) {
            this.f64156e.ph(this);
        }
    }

    public final void yh(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f64155d.remove(supportRequestManagerFragment);
    }

    public void zh(Fragment fragment) {
        FragmentManager vh2;
        this.f64158g = fragment;
        if (fragment != null && fragment.getContext() != null && (vh2 = vh(fragment)) != null) {
            xh(fragment.getContext(), vh2);
        }
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(a4.a aVar) {
        this.f64154c = new a();
        this.f64155d = new HashSet();
        this.f64153b = aVar;
    }
}
