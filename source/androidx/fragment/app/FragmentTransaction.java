package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentTransaction {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentFactory f9622a;

    /* renamed from: b  reason: collision with root package name */
    public final ClassLoader f9623b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a> f9624c;

    /* renamed from: d  reason: collision with root package name */
    public int f9625d;

    /* renamed from: e  reason: collision with root package name */
    public int f9626e;

    /* renamed from: f  reason: collision with root package name */
    public int f9627f;

    /* renamed from: g  reason: collision with root package name */
    public int f9628g;

    /* renamed from: h  reason: collision with root package name */
    public int f9629h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9630i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f9631j;

    /* renamed from: k  reason: collision with root package name */
    public String f9632k;

    /* renamed from: l  reason: collision with root package name */
    public int f9633l;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f9634m;

    /* renamed from: n  reason: collision with root package name */
    public int f9635n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f9636o;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<String> f9637p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<String> f9638q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9639r;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<Runnable> f9640s;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9641a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f9642b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9643c;

        /* renamed from: d  reason: collision with root package name */
        public int f9644d;

        /* renamed from: e  reason: collision with root package name */
        public int f9645e;

        /* renamed from: f  reason: collision with root package name */
        public int f9646f;

        /* renamed from: g  reason: collision with root package name */
        public int f9647g;

        /* renamed from: h  reason: collision with root package name */
        public Lifecycle.State f9648h;

        /* renamed from: i  reason: collision with root package name */
        public Lifecycle.State f9649i;

        public a() {
        }

        public a(int i11, Fragment fragment) {
            this.f9641a = i11;
            this.f9642b = fragment;
            this.f9643c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9648h = state;
            this.f9649i = state;
        }

        public a(int i11, Fragment fragment, boolean z11) {
            this.f9641a = i11;
            this.f9642b = fragment;
            this.f9643c = z11;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9648h = state;
            this.f9649i = state;
        }

        public a(int i11, Fragment fragment, Lifecycle.State state) {
            this.f9641a = i11;
            this.f9642b = fragment;
            this.f9643c = false;
            this.f9648h = fragment.mMaxState;
            this.f9649i = state;
        }

        public a(a aVar) {
            this.f9641a = aVar.f9641a;
            this.f9642b = aVar.f9642b;
            this.f9643c = aVar.f9643c;
            this.f9644d = aVar.f9644d;
            this.f9645e = aVar.f9645e;
            this.f9646f = aVar.f9646f;
            this.f9647g = aVar.f9647g;
            this.f9648h = aVar.f9648h;
            this.f9649i = aVar.f9649i;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.f9624c = new ArrayList<>();
        this.f9631j = true;
        this.f9639r = false;
        this.f9622a = null;
        this.f9623b = null;
    }

    public FragmentTransaction A(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }

    public FragmentTransaction b(int i11, Fragment fragment) {
        p(i11, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction c(int i11, Fragment fragment, String str) {
        p(i11, fragment, str, 1);
        return this;
    }

    public FragmentTransaction d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public FragmentTransaction e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f9624c.add(aVar);
        aVar.f9644d = this.f9625d;
        aVar.f9645e = this.f9626e;
        aVar.f9646f = this.f9627f;
        aVar.f9647g = this.f9628g;
    }

    public FragmentTransaction g(View view, String str) {
        if (g0.f()) {
            String P = h0.P(view);
            if (P != null) {
                if (this.f9637p == null) {
                    this.f9637p = new ArrayList<>();
                    this.f9638q = new ArrayList<>();
                } else if (this.f9638q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.f9637p.contains(P)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + P + "' has already been added to the transaction.");
                }
                this.f9637p.add(P);
                this.f9638q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public FragmentTransaction h(String str) {
        if (this.f9631j) {
            this.f9630i = true;
            this.f9632k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction i(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public FragmentTransaction n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public FragmentTransaction o() {
        if (!this.f9630i) {
            this.f9631j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void p(int i11, Fragment fragment, String str, int i12) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 == null || str.equals(str3)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i11 != 0) {
            if (i11 != -1) {
                int i13 = fragment.mFragmentId;
                if (i13 == 0 || i13 == i11) {
                    fragment.mFragmentId = i11;
                    fragment.mContainerId = i11;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i11);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new a(i12, fragment));
    }

    public FragmentTransaction q(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public boolean r() {
        return this.f9624c.isEmpty();
    }

    public FragmentTransaction s(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public FragmentTransaction t(int i11, Fragment fragment) {
        return u(i11, fragment, (String) null);
    }

    public FragmentTransaction u(int i11, Fragment fragment, String str) {
        if (i11 != 0) {
            p(i11, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public FragmentTransaction v(int i11, int i12) {
        return w(i11, i12, 0, 0);
    }

    public FragmentTransaction w(int i11, int i12, int i13, int i14) {
        this.f9625d = i11;
        this.f9626e = i12;
        this.f9627f = i13;
        this.f9628g = i14;
        return this;
    }

    public FragmentTransaction x(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public FragmentTransaction y(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public FragmentTransaction z(boolean z11) {
        this.f9639r = z11;
        return this;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.f9624c = new ArrayList<>();
        this.f9631j = true;
        this.f9639r = false;
        this.f9622a = fragmentFactory;
        this.f9623b = classLoader;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader, FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        Iterator<a> it2 = fragmentTransaction.f9624c.iterator();
        while (it2.hasNext()) {
            this.f9624c.add(new a(it2.next()));
        }
        this.f9625d = fragmentTransaction.f9625d;
        this.f9626e = fragmentTransaction.f9626e;
        this.f9627f = fragmentTransaction.f9627f;
        this.f9628g = fragmentTransaction.f9628g;
        this.f9629h = fragmentTransaction.f9629h;
        this.f9630i = fragmentTransaction.f9630i;
        this.f9631j = fragmentTransaction.f9631j;
        this.f9632k = fragmentTransaction.f9632k;
        this.f9635n = fragmentTransaction.f9635n;
        this.f9636o = fragmentTransaction.f9636o;
        this.f9633l = fragmentTransaction.f9633l;
        this.f9634m = fragmentTransaction.f9634m;
        if (fragmentTransaction.f9637p != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.f9637p = arrayList;
            arrayList.addAll(fragmentTransaction.f9637p);
        }
        if (fragmentTransaction.f9638q != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.f9638q = arrayList2;
            arrayList2.addAll(fragmentTransaction.f9638q);
        }
        this.f9639r = fragmentTransaction.f9639r;
    }
}
