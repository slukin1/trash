package zg;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.List;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    public List<Fragment> f48125f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f48126g;

    /* renamed from: h  reason: collision with root package name */
    public String f48127h;

    public b(Fragment fragment, List<Fragment> list, List<String> list2, String str) {
        super(fragment);
        this.f48125f = list;
        this.f48126g = list2;
        this.f48127h = str;
    }

    public String a(int i11) {
        String charSequence = getPageTitle(i11).toString();
        if (TextUtils.isEmpty(this.f48127h)) {
            return charSequence;
        }
        return this.f48127h + charSequence;
    }

    public int getCount() {
        List<Fragment> list = this.f48125f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Fragment getItem(int i11) {
        List<Fragment> list = this.f48125f;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f48125f.get(i11);
    }

    public CharSequence getPageTitle(int i11) {
        List<String> list = this.f48126g;
        String str = (list == null || i11 < 0 || i11 >= list.size()) ? null : this.f48126g.get(i11);
        return str == null ? "" : str;
    }
}
