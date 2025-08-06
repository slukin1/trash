package com.bumptech.glide.manager;

import a4.h;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public final a4.a f64143b;

    /* renamed from: c  reason: collision with root package name */
    public final h f64144c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<RequestManagerFragment> f64145d;

    /* renamed from: e  reason: collision with root package name */
    public d f64146e;

    /* renamed from: f  reason: collision with root package name */
    public RequestManagerFragment f64147f;

    /* renamed from: g  reason: collision with root package name */
    public Fragment f64148g;

    public class a implements h {
        public a() {
        }

        public Set<d> a() {
            Set<RequestManagerFragment> b11 = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(b11.size());
            for (RequestManagerFragment next : b11) {
                if (next.e() != null) {
                    hashSet.add(next.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new a4.a());
    }

    public final void a(RequestManagerFragment requestManagerFragment) {
        this.f64145d.add(requestManagerFragment);
    }

    @TargetApi(17)
    public Set<RequestManagerFragment> b() {
        if (equals(this.f64147f)) {
            return Collections.unmodifiableSet(this.f64145d);
        }
        if (this.f64147f == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.f64147f.b()) {
            if (g(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public a4.a c() {
        return this.f64143b;
    }

    @TargetApi(17)
    public final Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f64148g;
    }

    public d e() {
        return this.f64146e;
    }

    public h f() {
        return this.f64144c;
    }

    @TargetApi(17)
    public final boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void h(Activity activity) {
        l();
        RequestManagerFragment p11 = com.bumptech.glide.a.d(activity).l().p(activity);
        this.f64147f = p11;
        if (!equals(p11)) {
            this.f64147f.a(this);
        }
    }

    public final void i(RequestManagerFragment requestManagerFragment) {
        this.f64145d.remove(requestManagerFragment);
    }

    public void j(Fragment fragment) {
        this.f64148g = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(d dVar) {
        this.f64146e = dVar;
    }

    public final void l() {
        RequestManagerFragment requestManagerFragment = this.f64147f;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            this.f64147f = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e11) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e11);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f64143b.c();
        l();
    }

    public void onDetach() {
        super.onDetach();
        l();
    }

    public void onStart() {
        super.onStart();
        this.f64143b.d();
    }

    public void onStop() {
        super.onStop();
        this.f64143b.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public RequestManagerFragment(a4.a aVar) {
        this.f64144c = new a();
        this.f64145d = new HashSet();
        this.f64143b = aVar;
    }
}
