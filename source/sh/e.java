package sh;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import com.huobi.asset.feature.summary.AssetSummaryFragment;
import hh.f;
import java.util.ArrayList;
import java.util.List;

public class e extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public List<Fragment> f47817a = new ArrayList();

    public e(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        List<f.a<?>> f11 = f.h().f();
        this.f47817a.add(new AssetSummaryFragment());
        for (f.a<?> a11 : f11) {
            this.f47817a.add(a11.a());
        }
    }

    public int getCount() {
        return this.f47817a.size();
    }

    public Fragment getItem(int i11) {
        return this.f47817a.get(i11);
    }
}
