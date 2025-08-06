package zg;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.secure.android.common.ssl.util.f;
import i6.m;
import java.util.ArrayList;

public abstract class a extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f48120a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f48121b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f48122c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f48123d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f48124e = null;

    public a(Fragment fragment) {
        this.f48120a = fragment;
    }

    public abstract String a(int i11);

    public final FragmentManager b() {
        return this.f48120a.getChildFragmentManager();
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f48121b == null) {
            this.f48121b = b().q();
        }
        while (this.f48122c.size() <= i11) {
            this.f48122c.add((Object) null);
        }
        this.f48122c.set(i11, fragment.isAdded() ? b().D1(fragment) : null);
        this.f48123d.set(i11, (Object) null);
        this.f48121b.s(fragment);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f48121b;
        if (fragmentTransaction != null) {
            fragmentTransaction.m();
            this.f48121b = null;
        }
    }

    public abstract Fragment getItem(int i11);

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f48123d.size() > i11 && (fragment = this.f48123d.get(i11)) != null) {
            return fragment;
        }
        if (this.f48121b == null) {
            this.f48121b = b().q();
        }
        Fragment item = getItem(i11);
        if (this.f48122c.size() > i11 && (savedState = this.f48122c.get(i11)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f48123d.size() <= i11) {
            this.f48123d.add((Object) null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.f48123d.set(i11, item);
        if (TextUtils.isEmpty(a(i11))) {
            this.f48121b.b(viewGroup.getId(), item);
        } else {
            Fragment m02 = b().m0(a(i11));
            if (m02 != null) {
                this.f48121b.s(m02);
            }
            this.f48121b.c(viewGroup.getId(), item, a(i11));
        }
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f48122c.clear();
            this.f48123d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f48122c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.f38658a)) {
                    int k02 = m.k0(str.substring(1));
                    Fragment x02 = b().x0(bundle, str);
                    if (x02 != null) {
                        while (this.f48123d.size() <= k02) {
                            this.f48123d.add((Object) null);
                        }
                        x02.setMenuVisibility(false);
                        this.f48123d.set(k02, x02);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f48122c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f48122c.size()];
            this.f48122c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i11 = 0; i11 < this.f48123d.size(); i11++) {
            Fragment fragment = this.f48123d.get(i11);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                b().q1(bundle, f.f38658a + i11, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f48124e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f48124e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f48124e = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
