package bp;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import java.util.ArrayList;
import java.util.List;

public class e extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<Class> f77016a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f77017b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<Bundle> f77018c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Fragment f77019d;

    public e(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(List<Class> list, List<String> list2, List<Bundle> list3) {
        b(list, list2, list3, true);
    }

    public void b(List<Class> list, List<String> list2, List<Bundle> list3, boolean z11) {
        this.f77016a.addAll(list);
        this.f77017b.addAll(list2);
        if (list3 != null) {
            this.f77018c.addAll(list3);
        }
        if (z11) {
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f77017b.size();
    }

    public Fragment getItem(int i11) {
        try {
            Fragment fragment = (Fragment) ((Class) (this.f77016a.size() > i11 ? this.f77016a.get(i11) : this.f77016a.get(0))).getConstructor(new Class[0]).newInstance(new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putInt("position", i11);
            bundle.putString("pageTitle", this.f77017b.get(i11));
            if (!this.f77018c.isEmpty()) {
                bundle.putAll(this.f77018c.get(i11));
            }
            fragment.setArguments(bundle);
            return fragment;
        } catch (Exception e11) {
            throw new RuntimeException(e11.fillInStackTrace());
        }
    }

    public CharSequence getPageTitle(int i11) {
        return this.f77017b.get(i11);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        super.setPrimaryItem(viewGroup, i11, obj);
        if (obj instanceof Fragment) {
            this.f77019d = (Fragment) obj;
        }
    }
}
