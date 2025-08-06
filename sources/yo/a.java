package yo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huobi.order.ui.OrderListFragment;
import java.util.List;
import yg.b;

public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public List<OrderListFragment> f85067f;

    public a(FragmentManager fragmentManager, List<OrderListFragment> list) {
        super(fragmentManager);
        this.f85067f = list;
    }

    public String a(int i11) {
        return String.valueOf(i11);
    }

    public int getCount() {
        return this.f85067f.size();
    }

    public Fragment getItem(int i11) {
        return this.f85067f.get(i11);
    }
}
