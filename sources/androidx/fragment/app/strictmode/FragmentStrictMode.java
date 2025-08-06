package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import n1.b;

public final class FragmentStrictMode {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentStrictMode f9783a = new FragmentStrictMode();

    /* renamed from: b  reason: collision with root package name */
    public static Policy f9784b = Policy.f9786e;

    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public static final class Policy {

        /* renamed from: d  reason: collision with root package name */
        public static final a f9785d = new a((r) null);

        /* renamed from: e  reason: collision with root package name */
        public static final Policy f9786e = new Policy(SetsKt__SetsKt.d(), (a) null, MapsKt__MapsKt.h());

        /* renamed from: a  reason: collision with root package name */
        public final Set<Flag> f9787a;

        /* renamed from: b  reason: collision with root package name */
        public final a f9788b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, Set<Class<? extends Violation>>> f9789c;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public final Set<Flag> f9790a = new LinkedHashSet();

            /* renamed from: b  reason: collision with root package name */
            public final Map<String, Set<Class<? extends Violation>>> f9791b = new LinkedHashMap();
        }

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public Policy(Set<? extends Flag> set, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> map) {
            this.f9787a = set;
            this.f9788b = aVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), (Set) next.getValue());
            }
            this.f9789c = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.f9787a;
        }

        public final a b() {
            return this.f9788b;
        }

        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f9789c;
        }
    }

    public interface a {
        void a(Violation violation);
    }

    public static final void e(Policy policy, Violation violation) {
        policy.b().a(violation);
    }

    public static final void f(String str, Violation violation) {
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void h(Fragment fragment, String str) {
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(fragmentReuseViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.s(c11, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.d(c11, fragmentReuseViolation);
        }
    }

    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(fragmentTagUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, fragmentTagUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(getRetainInstanceUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, getRetainInstanceUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(getTargetFragmentRequestCodeUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void l(Fragment fragment) {
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(getTargetFragmentUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, getTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment) {
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(setRetainInstanceUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, setRetainInstanceUsageViolation);
        }
    }

    public static final void n(Fragment fragment, Fragment fragment2, int i11) {
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i11);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(setTargetFragmentUsageViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c11, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c11, setTargetFragmentUsageViolation);
        }
    }

    public static final void o(Fragment fragment, boolean z11) {
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z11);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(setUserVisibleHintViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.s(c11, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.d(c11, setUserVisibleHintViolation);
        }
    }

    public static final void p(Fragment fragment, ViewGroup viewGroup) {
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(wrongFragmentContainerViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.s(c11, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.d(c11, wrongFragmentContainerViolation);
        }
    }

    public static final void q(Fragment fragment, Fragment fragment2, int i11) {
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, fragment2, i11);
        FragmentStrictMode fragmentStrictMode = f9783a;
        fragmentStrictMode.g(wrongNestedHierarchyViolation);
        Policy c11 = fragmentStrictMode.c(fragment);
        if (c11.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && fragmentStrictMode.s(c11, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            fragmentStrictMode.d(c11, wrongNestedHierarchyViolation);
        }
    }

    public final Policy c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                if (parentFragmentManager.I0() != null) {
                    return parentFragmentManager.I0();
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f9784b;
    }

    public final void d(Policy policy, Violation violation) {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (policy.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        if (policy.b() != null) {
            r(fragment, new n1.a(policy, violation));
        }
        if (policy.a().contains(Flag.PENALTY_DEATH)) {
            r(fragment, new b(name, violation));
        }
    }

    public final void g(Violation violation) {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public final void r(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler g11 = fragment.getParentFragmentManager().C0().g();
            if (x.b(g11.getLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                g11.post(runnable);
            }
        } else {
            runnable.run();
        }
    }

    public final boolean s(Policy policy, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set set = policy.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (x.b(cls2.getSuperclass(), Violation.class) || !CollectionsKt___CollectionsKt.R(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
