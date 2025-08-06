package or;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bp.d;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.fragment.NewPreviewFragment;
import java.util.List;

public class a extends d {

    /* renamed from: g  reason: collision with root package name */
    public ShareInfo.ShareType f84541g;

    /* renamed from: h  reason: collision with root package name */
    public List<NewPreviewFragment> f84542h;

    /* renamed from: i  reason: collision with root package name */
    public List<InvitePosterListItem> f84543i;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager);
        Log.d("SharePosterPagerAdapter", "SharePosterPagerAdapter");
    }

    public int a(Fragment fragment) {
        Log.d("SharePosterPagerAdapter", "getFragmentPosition:" + fragment);
        return 0;
    }

    public void b(ShareInfo.ShareType shareType, List<NewPreviewFragment> list, List<InvitePosterListItem> list2) {
        Log.d("SharePosterPagerAdapter", "setData");
        this.f84541g = shareType;
        this.f84542h = list;
        this.f84543i = list2;
    }

    public int getCount() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCount:");
        List<NewPreviewFragment> list = this.f84542h;
        sb2.append(list != null ? list.size() : 0);
        Log.d("SharePosterPagerAdapter", sb2.toString());
        List<NewPreviewFragment> list2 = this.f84542h;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public Fragment getItem(int i11) {
        Log.d("SharePosterPagerAdapter", "getItem:" + i11);
        NewPreviewFragment newPreviewFragment = this.f84542h.get(i11);
        newPreviewFragment.vh(this.f84541g, this.f84543i.get(i11), this.f84543i.size());
        return newPreviewFragment;
    }
}
