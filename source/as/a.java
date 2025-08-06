package as;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huobi.staring.ui.AllRemindNewFragment;
import java.util.List;
import yg.b;

public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public List<AllRemindNewFragment> f76996f;

    public a(FragmentManager fragmentManager, List<AllRemindNewFragment> list) {
        super(fragmentManager);
        this.f76996f = list;
    }

    public String a(int i11) {
        return String.valueOf(i11);
    }

    public int getCount() {
        return this.f76996f.size();
    }

    public Fragment getItem(int i11) {
        return this.f76996f.get(i11);
    }
}
