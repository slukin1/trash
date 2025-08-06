package he;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class a extends FragmentStateAdapter {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Fragment> f25273b = new ArrayList<>();

    public a(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public final void a(ArrayList<Fragment> arrayList) {
        this.f25273b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final ArrayList<Fragment> c() {
        return this.f25273b;
    }

    public Fragment createFragment(int i11) {
        return this.f25273b.get(i11);
    }

    public int getItemCount() {
        return this.f25273b.size();
    }

    public a(Fragment fragment) {
        super(fragment);
    }
}
