package ko;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.hbg.module.libkt.custom.indicator.TabData;
import java.util.ArrayList;
import java.util.List;

public final class r extends FragmentStateAdapter {

    /* renamed from: b  reason: collision with root package name */
    public final List<TabData> f84422b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment> f84423c;

    public r(FragmentActivity fragmentActivity, List<TabData> list, ArrayList<Fragment> arrayList) {
        super(fragmentActivity);
        this.f84422b = list;
        this.f84423c = arrayList;
    }

    public Fragment createFragment(int i11) {
        return this.f84423c.get(i11);
    }

    public int getItemCount() {
        return this.f84422b.size();
    }
}
