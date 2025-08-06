package bp;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.secure.android.common.ssl.util.f;
import java.util.ArrayList;
import java.util.List;

public abstract class d extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f77010a;

    /* renamed from: b  reason: collision with root package name */
    public final int f77011b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTransaction f77012c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f77013d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f77014e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f77015f;

    @Deprecated
    public d(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public abstract int a(Fragment fragment);

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f77012c == null) {
            this.f77012c = this.f77010a.q();
        }
        while (this.f77013d.size() <= i11) {
            this.f77013d.add((Object) null);
        }
        this.f77013d.set(i11, fragment.isAdded() ? this.f77010a.D1(fragment) : null);
        this.f77014e.set(i11, (Object) null);
        this.f77012c.s(fragment);
        if (fragment == this.f77015f) {
            this.f77015f = null;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f77012c;
        if (fragmentTransaction != null) {
            fragmentTransaction.m();
            this.f77012c = null;
        }
    }

    public abstract Fragment getItem(int i11);

    public final int getItemPosition(Object obj) {
        Fragment fragment = (Fragment) obj;
        int indexOf = this.f77014e.indexOf(fragment);
        int a11 = a(fragment);
        if (a11 >= 0) {
            while (this.f77014e.size() <= a11) {
                this.f77014e.add((Object) null);
            }
            if (indexOf != -1) {
                this.f77014e.set(indexOf, (Object) null);
            }
            this.f77014e.set(a11, fragment);
        }
        return a11;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f77014e.size() > i11 && (fragment = this.f77014e.get(i11)) != null) {
            return fragment;
        }
        if (this.f77012c == null) {
            this.f77012c = this.f77010a.q();
        }
        Fragment item = getItem(i11);
        if (this.f77013d.size() > i11 && (savedState = this.f77013d.get(i11)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f77014e.size() <= i11) {
            this.f77014e.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.f77011b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f77014e.set(i11, item);
        this.f77012c.b(viewGroup.getId(), item);
        if (this.f77011b == 1) {
            this.f77012c.x(item, Lifecycle.State.STARTED);
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
            this.f77013d.clear();
            this.f77014e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f77013d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.f38658a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    List<Fragment> B0 = this.f77010a.B0();
                    if (B0 != null && !B0.isEmpty()) {
                        try {
                            Fragment x02 = this.f77010a.x0(bundle, str);
                            if (x02 != null) {
                                while (this.f77014e.size() <= parseInt) {
                                    this.f77014e.add((Object) null);
                                }
                                x02.setMenuVisibility(false);
                                this.f77014e.set(parseInt, x02);
                            } else {
                                Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                            }
                        } catch (Exception unused) {
                            Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                        }
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f77013d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f77013d.size()];
            this.f77013d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i11 = 0; i11 < this.f77014e.size(); i11++) {
            Fragment fragment = this.f77014e.get(i11);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f77010a.q1(bundle, f.f38658a + i11, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f77015f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f77011b == 1) {
                    if (this.f77012c == null) {
                        this.f77012c = this.f77010a.q();
                    }
                    this.f77012c.x(this.f77015f, Lifecycle.State.STARTED);
                } else {
                    this.f77015f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f77011b == 1) {
                if (this.f77012c == null) {
                    this.f77012c = this.f77010a.q();
                }
                this.f77012c.x(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f77015f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public d(FragmentManager fragmentManager, int i11) {
        this.f77012c = null;
        this.f77013d = new ArrayList<>();
        this.f77014e = new ArrayList<>();
        this.f77015f = null;
        this.f77010a = fragmentManager;
        this.f77011b = i11;
    }
}
