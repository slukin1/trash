package com.huobi.homemarket.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.community.ui.CommunityKLineFragment;
import com.hbg.module.kline.KLineHelper;
import com.huobi.homemarket.ui.MarketPlateDetailFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import u6.g;

public class MarketPlateDetailActivityPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f72854a;

    /* renamed from: b  reason: collision with root package name */
    public List<Fragment> f72855b;

    public class a extends b0 {
        public a(FragmentManager fragmentManager, int i11) {
            super(fragmentManager, i11);
        }

        public int getCount() {
            return MarketPlateDetailActivityPresenter.this.f72855b.size();
        }

        public Fragment getItem(int i11) {
            return (Fragment) MarketPlateDetailActivityPresenter.this.f72855b.get(i11);
        }
    }

    public interface b extends g {
        ViewPager g3();

        View getRootView();
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        this.f72854a = baseCoreActivity.getIntent().getStringExtra("plateId");
        ArrayList arrayList = new ArrayList();
        this.f72855b = arrayList;
        arrayList.add(MarketPlateDetailFragment.Rh(this.f72854a));
        List<Fragment> list = this.f72855b;
        CommunityKLineFragment.a aVar = CommunityKLineFragment.F;
        String str = this.f72854a;
        list.add(aVar.a("", "", false, str, str));
        ((b) getUI()).g3().setAdapter(new a(getActivity().getSupportFragmentManager(), 1));
    }

    public void S() {
        KLineHelper.e().a(getActivity(), ((b) getUI()).getRootView(), "plate_detail");
        HashMap hashMap = new HashMap();
        hashMap.put("plate_name", this.f72854a);
        BaseModuleConfig.a().w("plate_details_share_click", hashMap);
    }
}
