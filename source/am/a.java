package am;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.huobi.index.ui.BaseRankingFragment;
import i6.d;
import i6.k;
import java.util.List;

public class a extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f70954a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTransaction f70955b = null;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f70956c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70957d;

    /* renamed from: e  reason: collision with root package name */
    public List<? extends BaseRankingFragment> f70958e;

    public a(FragmentManager fragmentManager) {
        this.f70954a = fragmentManager;
    }

    public static String makeFragmentName(int i11, long j11) {
        return "android:switcher:" + i11 + ":" + j11;
    }

    public final int a(int i11) {
        return ((BaseRankingFragment) this.f70958e.get(i11)).ph();
    }

    public void b(List<? extends BaseRankingFragment> list) {
        this.f70958e = list;
    }

    public void c(boolean z11) {
        this.f70957d = z11;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        if (this.f70955b == null) {
            this.f70955b = this.f70954a.q();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Detaching item #");
        sb2.append(getItemId(i11));
        sb2.append(": f=");
        sb2.append(obj);
        sb2.append(" v=");
        Fragment fragment = (Fragment) obj;
        sb2.append(fragment.getView());
        d.m("FragmentPagerAdapter", sb2.toString());
        if (this.f70957d) {
            this.f70955b.s(fragment);
        } else {
            this.f70955b.n(fragment);
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        try {
            FragmentTransaction fragmentTransaction = this.f70955b;
            if (fragmentTransaction != null) {
                fragmentTransaction.m();
                this.f70955b = null;
            }
        } catch (Exception unused) {
            k.e("ContentPagerAdapter finishUpdate");
        }
    }

    public int getCount() {
        List<? extends BaseRankingFragment> list = this.f70958e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Fragment getItem(int i11) {
        List<? extends BaseRankingFragment> list = this.f70958e;
        if (list == null) {
            return null;
        }
        return (Fragment) list.get(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public CharSequence getPageTitle(int i11) {
        List<? extends BaseRankingFragment> list = this.f70958e;
        if (list == null) {
            return "";
        }
        return ((BaseRankingFragment) list.get(i11)).rh();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        if (this.f70955b == null) {
            this.f70955b = this.f70954a.q();
        }
        long itemId = getItemId(i11);
        Fragment m02 = this.f70954a.m0(makeFragmentName(viewGroup.getId(), (long) a(i11)));
        if (m02 != null) {
            d.m("FragmentPagerAdapter", "Attaching item #" + itemId + ": f=" + m02);
            this.f70955b.i(m02);
        } else {
            m02 = getItem(i11);
            d.m("FragmentPagerAdapter", "Adding item #" + itemId + ": f=" + m02);
            this.f70955b.c(viewGroup.getId(), m02, makeFragmentName(viewGroup.getId(), (long) a(i11)));
        }
        if (m02 != this.f70956c) {
            m02.setMenuVisibility(false);
            m02.setUserVisibleHint(false);
        }
        return m02;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f70956c;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f70956c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f70956c = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
