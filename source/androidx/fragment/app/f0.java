package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f9726a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, d0> f9727b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Bundle> f9728c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public z f9729d;

    public void A(z zVar) {
        this.f9729d = zVar;
    }

    public Bundle B(String str, Bundle bundle) {
        if (bundle != null) {
            return this.f9728c.put(str, bundle);
        }
        return this.f9728c.remove(str);
    }

    public void a(Fragment fragment) {
        if (!this.f9726a.contains(fragment)) {
            synchronized (this.f9726a) {
                this.f9726a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.f9727b.values().removeAll(Collections.singleton((Object) null));
    }

    public boolean c(String str) {
        return this.f9727b.get(str) != null;
    }

    public void d(int i11) {
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                next.t(i11);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f9727b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d0 next : this.f9727b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k11 = next.k();
                    printWriter.println(k11);
                    k11.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(OptionsBridge.NULL_VALUE);
                }
            }
        }
        int size = this.f9726a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i11 = 0; i11 < size; i11++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(l.f34627b);
                printWriter.println(this.f9726a.get(i11).toString());
            }
        }
    }

    public Fragment f(String str) {
        d0 d0Var = this.f9727b.get(str);
        if (d0Var != null) {
            return d0Var.k();
        }
        return null;
    }

    public Fragment g(int i11) {
        for (int size = this.f9726a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f9726a.get(size);
            if (fragment != null && fragment.mFragmentId == i11) {
                return fragment;
            }
        }
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                Fragment k11 = next.k();
                if (k11.mFragmentId == i11) {
                    return k11;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f9726a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f9726a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                Fragment k11 = next.k();
                if (str.equals(k11.mTag)) {
                    return k11;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (d0 next : this.f9727b.values()) {
            if (next != null && (findFragmentByWho = next.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f9726a.indexOf(fragment);
        for (int i11 = indexOf - 1; i11 >= 0; i11--) {
            Fragment fragment2 = this.f9726a.get(i11);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f9726a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f9726a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List<d0> k() {
        ArrayList arrayList = new ArrayList();
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                arrayList.add(next.k());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    public HashMap<String, Bundle> m() {
        return this.f9728c;
    }

    public d0 n(String str) {
        return this.f9727b.get(str);
    }

    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f9726a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f9726a) {
            arrayList = new ArrayList(this.f9726a);
        }
        return arrayList;
    }

    public z p() {
        return this.f9729d;
    }

    public Bundle q(String str) {
        return this.f9728c.get(str);
    }

    public void r(d0 d0Var) {
        Fragment k11 = d0Var.k();
        if (!c(k11.mWho)) {
            this.f9727b.put(k11.mWho, d0Var);
            if (k11.mRetainInstanceChangedWhileDetached) {
                if (k11.mRetainInstance) {
                    this.f9729d.b(k11);
                } else {
                    this.f9729d.k0(k11);
                }
                k11.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k11);
            }
        }
    }

    public void s(d0 d0Var) {
        Fragment k11 = d0Var.k();
        if (k11.mRetainInstance) {
            this.f9729d.k0(k11);
        }
        if (this.f9727b.get(k11.mWho) == d0Var && this.f9727b.put(k11.mWho, (Object) null) != null && FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k11);
        }
    }

    public void t() {
        Iterator<Fragment> it2 = this.f9726a.iterator();
        while (it2.hasNext()) {
            d0 d0Var = this.f9727b.get(it2.next().mWho);
            if (d0Var != null) {
                d0Var.m();
            }
        }
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                next.m();
                Fragment k11 = next.k();
                if (k11.mRemoving && !k11.isInBackStack()) {
                    if (k11.mBeingSaved && !this.f9728c.containsKey(k11.mWho)) {
                        B(k11.mWho, next.r());
                    }
                    s(next);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f9726a) {
            this.f9726a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void v() {
        this.f9727b.clear();
    }

    public void w(List<String> list) {
        this.f9726a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f11 = f(next);
                if (f11 != null) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f11);
                    }
                    a(f11);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    public void x(HashMap<String, Bundle> hashMap) {
        this.f9728c.clear();
        this.f9728c.putAll(hashMap);
    }

    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f9727b.size());
        for (d0 next : this.f9727b.values()) {
            if (next != null) {
                Fragment k11 = next.k();
                B(k11.mWho, next.r());
                arrayList.add(k11.mWho);
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k11 + l.f34627b + k11.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> z() {
        synchronized (this.f9726a) {
            if (this.f9726a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f9726a.size());
            Iterator<Fragment> it2 = this.f9726a.iterator();
            while (it2.hasNext()) {
                Fragment next = it2.next();
                arrayList.add(next.mWho);
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
