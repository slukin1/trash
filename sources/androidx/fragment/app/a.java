package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.android.tpush.stat.ServiceStat;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class a extends FragmentTransaction implements FragmentManager.n {

    /* renamed from: t  reason: collision with root package name */
    public final FragmentManager f9692t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f9693u;

    /* renamed from: v  reason: collision with root package name */
    public int f9694v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f9695w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(FragmentManager fragmentManager) {
        super(fragmentManager.z0(), fragmentManager.C0() != null ? fragmentManager.C0().f().getClassLoader() : null);
        this.f9694v = -1;
        this.f9695w = false;
        this.f9692t = fragmentManager;
    }

    public FragmentTransaction A(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9692t) {
            return super.A(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void B(int i11) {
        if (this.f9630i) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i11);
            }
            int size = this.f9624c.size();
            for (int i12 = 0; i12 < size; i12++) {
                FragmentTransaction.a aVar = this.f9624c.get(i12);
                Fragment fragment = aVar.f9642b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i11;
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f9642b + " to " + aVar.f9642b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void C() {
        int size = this.f9624c.size() - 1;
        while (size >= 0) {
            FragmentTransaction.a aVar = this.f9624c.get(size);
            if (aVar.f9643c) {
                if (aVar.f9641a == 8) {
                    aVar.f9643c = false;
                    this.f9624c.remove(size - 1);
                    size--;
                } else {
                    int i11 = aVar.f9642b.mContainerId;
                    aVar.f9641a = 2;
                    aVar.f9643c = false;
                    for (int i12 = size - 1; i12 >= 0; i12--) {
                        FragmentTransaction.a aVar2 = this.f9624c.get(i12);
                        if (aVar2.f9643c && aVar2.f9642b.mContainerId == i11) {
                            this.f9624c.remove(i12);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public int D(boolean z11) {
        if (!this.f9693u) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
                E("  ", printWriter);
                printWriter.close();
            }
            this.f9693u = true;
            if (this.f9630i) {
                this.f9694v = this.f9692t.n();
            } else {
                this.f9694v = -1;
            }
            this.f9692t.c0(this, z11);
            return this.f9694v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void E(String str, PrintWriter printWriter) {
        F(str, printWriter, true);
    }

    public void F(String str, PrintWriter printWriter, boolean z11) {
        String str2;
        if (z11) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f9632k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f9694v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f9693u);
            if (this.f9629h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f9629h));
            }
            if (!(this.f9625d == 0 && this.f9626e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9625d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9626e));
            }
            if (!(this.f9627f == 0 && this.f9628g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9627f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9628g));
            }
            if (!(this.f9633l == 0 && this.f9634m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9633l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f9634m);
            }
            if (!(this.f9635n == 0 && this.f9636o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9635n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f9636o);
            }
        }
        if (!this.f9624c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f9624c.size();
            for (int i11 = 0; i11 < size; i11++) {
                FragmentTransaction.a aVar = this.f9624c.get(i11);
                switch (aVar.f9641a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = ServiceStat.SHOW_EVENT_ID;
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f9641a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i11);
                printWriter.print(l.f34627b);
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f9642b);
                if (z11) {
                    if (!(aVar.f9644d == 0 && aVar.f9645e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f9644d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f9645e));
                    }
                    if (aVar.f9646f != 0 || aVar.f9647g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f9646f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f9647g));
                    }
                }
            }
        }
    }

    public void G() {
        int size = this.f9624c.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransaction.a aVar = this.f9624c.get(i11);
            Fragment fragment = aVar.f9642b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f9695w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f9629h);
                fragment.setSharedElementNames(this.f9637p, this.f9638q);
            }
            switch (aVar.f9641a) {
                case 1:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, false);
                    this.f9692t.j(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.s1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.M0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, false);
                    this.f9692t.L1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.A(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, false);
                    this.f9692t.p(fragment);
                    break;
                case 8:
                    this.f9692t.J1(fragment);
                    break;
                case 9:
                    this.f9692t.J1((Fragment) null);
                    break;
                case 10:
                    this.f9692t.I1(fragment, aVar.f9649i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9641a);
            }
        }
    }

    public void H() {
        for (int size = this.f9624c.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.f9624c.get(size);
            Fragment fragment = aVar.f9642b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f9695w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.z1(this.f9629h));
                fragment.setSharedElementNames(this.f9638q, this.f9637p);
            }
            switch (aVar.f9641a) {
                case 1:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, true);
                    this.f9692t.s1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.L1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, true);
                    this.f9692t.M0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.p(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9644d, aVar.f9645e, aVar.f9646f, aVar.f9647g);
                    this.f9692t.F1(fragment, true);
                    this.f9692t.A(fragment);
                    break;
                case 8:
                    this.f9692t.J1((Fragment) null);
                    break;
                case 9:
                    this.f9692t.J1(fragment);
                    break;
                case 10:
                    this.f9692t.I1(fragment, aVar.f9648h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9641a);
            }
        }
    }

    public Fragment I(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i11 = 0;
        while (i11 < this.f9624c.size()) {
            FragmentTransaction.a aVar = this.f9624c.get(i11);
            int i12 = aVar.f9641a;
            if (i12 != 1) {
                if (i12 == 2) {
                    Fragment fragment3 = aVar.f9642b;
                    int i13 = fragment3.mContainerId;
                    boolean z11 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i13) {
                            if (fragment4 == fragment3) {
                                z11 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f9624c.add(i11, new FragmentTransaction.a(9, fragment4, true));
                                    i11++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.a aVar2 = new FragmentTransaction.a(3, fragment4, true);
                                aVar2.f9644d = aVar.f9644d;
                                aVar2.f9646f = aVar.f9646f;
                                aVar2.f9645e = aVar.f9645e;
                                aVar2.f9647g = aVar.f9647g;
                                this.f9624c.add(i11, aVar2);
                                arrayList2.remove(fragment4);
                                i11++;
                            }
                        }
                    }
                    if (z11) {
                        this.f9624c.remove(i11);
                        i11--;
                    } else {
                        aVar.f9641a = 1;
                        aVar.f9643c = true;
                        arrayList2.add(fragment3);
                    }
                } else if (i12 == 3 || i12 == 6) {
                    arrayList2.remove(aVar.f9642b);
                    Fragment fragment5 = aVar.f9642b;
                    if (fragment5 == fragment2) {
                        this.f9624c.add(i11, new FragmentTransaction.a(9, fragment5));
                        i11++;
                        fragment2 = null;
                    }
                } else if (i12 != 7) {
                    if (i12 == 8) {
                        this.f9624c.add(i11, new FragmentTransaction.a(9, fragment2, true));
                        aVar.f9643c = true;
                        i11++;
                        fragment2 = aVar.f9642b;
                    }
                }
                i11++;
            }
            arrayList2.add(aVar.f9642b);
            i11++;
        }
        return fragment2;
    }

    public String J() {
        return this.f9632k;
    }

    public void K() {
        if (this.f9640s != null) {
            for (int i11 = 0; i11 < this.f9640s.size(); i11++) {
                this.f9640s.get(i11).run();
            }
            this.f9640s = null;
        }
    }

    public Fragment L(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f9624c.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.f9624c.get(size);
            int i11 = aVar.f9641a;
            if (i11 != 1) {
                if (i11 != 3) {
                    switch (i11) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f9642b;
                            break;
                        case 10:
                            aVar.f9649i = aVar.f9648h;
                            break;
                    }
                }
                arrayList.add(aVar.f9642b);
            }
            arrayList.remove(aVar.f9642b);
        }
        return fragment;
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f9630i) {
            return true;
        }
        this.f9692t.i(this);
        return true;
    }

    public int j() {
        return D(false);
    }

    public int k() {
        return D(true);
    }

    public void l() {
        o();
        this.f9692t.f0(this, false);
    }

    public void m() {
        o();
        this.f9692t.f0(this, true);
    }

    public FragmentTransaction n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9692t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void p(int i11, Fragment fragment, String str, int i12) {
        super.p(i11, fragment, str, i12);
        fragment.mFragmentManager = this.f9692t;
    }

    public FragmentTransaction q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9692t) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public boolean r() {
        return this.f9624c.isEmpty();
    }

    public FragmentTransaction s(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f9692t) {
            return super.s(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f9694v >= 0) {
            sb2.append(" #");
            sb2.append(this.f9694v);
        }
        if (this.f9632k != null) {
            sb2.append(" ");
            sb2.append(this.f9632k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public FragmentTransaction x(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f9692t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f9692t);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.x(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public FragmentTransaction y(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f9692t) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        super(aVar.f9692t.z0(), aVar.f9692t.C0() != null ? aVar.f9692t.C0().f().getClassLoader() : null, aVar);
        this.f9694v = -1;
        this.f9695w = false;
        this.f9692t = aVar.f9692t;
        this.f9693u = aVar.f9693u;
        this.f9694v = aVar.f9694v;
        this.f9695w = aVar.f9695w;
    }
}
