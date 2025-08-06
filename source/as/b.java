package as;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huobi.staring.ui.RemindSearchListFragment;
import java.util.List;

public class b extends yg.b {

    /* renamed from: f  reason: collision with root package name */
    public List<RemindSearchListFragment> f76997f;

    public b(FragmentManager fragmentManager, List<RemindSearchListFragment> list) {
        super(fragmentManager);
        this.f76997f = list;
    }

    public String a(int i11) {
        return String.valueOf(i11);
    }

    public int getCount() {
        return this.f76997f.size();
    }

    public Fragment getItem(int i11) {
        return this.f76997f.get(i11);
    }
}
