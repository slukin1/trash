package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.secure.android.common.ssl.util.f;
import java.util.ArrayList;

@Deprecated
public abstract class e0 extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f9715a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9716b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTransaction f9717c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f9718d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f9719e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f9720f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9721g;

    @Deprecated
    public e0(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f9717c == null) {
            this.f9717c = this.f9715a.q();
        }
        while (this.f9718d.size() <= i11) {
            this.f9718d.add((Object) null);
        }
        this.f9718d.set(i11, fragment.isAdded() ? this.f9715a.D1(fragment) : null);
        this.f9719e.set(i11, (Object) null);
        this.f9717c.s(fragment);
        if (fragment.equals(this.f9720f)) {
            this.f9720f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f9717c;
        if (fragmentTransaction != null) {
            if (!this.f9721g) {
                try {
                    this.f9721g = true;
                    fragmentTransaction.m();
                    this.f9721g = false;
                } catch (Throwable th2) {
                    this.f9721g = false;
                    throw th2;
                }
            }
            this.f9717c = null;
        }
    }

    public abstract Fragment getItem(int i11);

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f9719e.size() > i11 && (fragment = this.f9719e.get(i11)) != null) {
            return fragment;
        }
        if (this.f9717c == null) {
            this.f9717c = this.f9715a.q();
        }
        Fragment item = getItem(i11);
        if (this.f9718d.size() > i11 && (savedState = this.f9718d.get(i11)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f9719e.size() <= i11) {
            this.f9719e.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.f9716b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f9719e.set(i11, item);
        this.f9717c.b(viewGroup.getId(), item);
        if (this.f9716b == 1) {
            this.f9717c.x(item, Lifecycle.State.STARTED);
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
            this.f9718d.clear();
            this.f9719e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f9718d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.f38658a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment x02 = this.f9715a.x0(bundle, str);
                    if (x02 != null) {
                        while (this.f9719e.size() <= parseInt) {
                            this.f9719e.add((Object) null);
                        }
                        x02.setMenuVisibility(false);
                        this.f9719e.set(parseInt, x02);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f9718d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f9718d.size()];
            this.f9718d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i11 = 0; i11 < this.f9719e.size(); i11++) {
            Fragment fragment = this.f9719e.get(i11);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f9715a.q1(bundle, f.f38658a + i11, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f9720f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f9716b == 1) {
                    if (this.f9717c == null) {
                        this.f9717c = this.f9715a.q();
                    }
                    this.f9717c.x(this.f9720f, Lifecycle.State.STARTED);
                } else {
                    this.f9720f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f9716b == 1) {
                if (this.f9717c == null) {
                    this.f9717c = this.f9715a.q();
                }
                this.f9717c.x(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f9720f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public e0(FragmentManager fragmentManager, int i11) {
        this.f9717c = null;
        this.f9718d = new ArrayList<>();
        this.f9719e = new ArrayList<>();
        this.f9720f = null;
        this.f9715a = fragmentManager;
        this.f9716b = i11;
    }
}
