package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
public abstract class b0 extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public b0(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String makeFragmentName(int i11, long j11) {
        return "android:switcher:" + i11 + ":" + j11;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.q();
        }
        this.mCurTransaction.n(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    fragmentTransaction.m();
                    this.mExecutingFinishUpdate = false;
                } catch (Throwable th2) {
                    this.mExecutingFinishUpdate = false;
                    throw th2;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i11);

    public long getItemId(int i11) {
        return (long) i11;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.q();
        }
        long itemId = getItemId(i11);
        Fragment m02 = this.mFragmentManager.m0(makeFragmentName(viewGroup.getId(), itemId));
        if (m02 != null) {
            this.mCurTransaction.i(m02);
        } else {
            m02 = getItem(i11);
            this.mCurTransaction.c(viewGroup.getId(), m02, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (m02 != this.mCurrentPrimaryItem) {
            m02.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.x(m02, Lifecycle.State.STARTED);
            } else {
                m02.setUserVisibleHint(false);
            }
        }
        return m02;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.q();
                    }
                    this.mCurTransaction.x(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.q();
                }
                this.mCurTransaction.x(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public b0(FragmentManager fragmentManager, int i11) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i11;
    }
}
