package com.hbg.module.livesquare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.livesquare.ui.LiveCategoryChildFragment;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import lc.q1;
import ne.c;

public final class LiveCategoryFragment extends BaseFragment<q1> {

    /* renamed from: r  reason: collision with root package name */
    public static final a f26570r = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public int f26571p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f26572q = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveCategoryFragment a(int i11, int i12) {
            LiveCategoryFragment liveCategoryFragment = new LiveCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("selCategoryId", i11);
            bundle.putInt("liveStatus", i12);
            liveCategoryFragment.setArguments(bundle);
            return liveCategoryFragment;
        }
    }

    public static final class b implements c {
        public void a(int i11) {
        }
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f26571p = arguments != null ? arguments.getInt("selCategoryId") : -1;
        Bundle arguments2 = getArguments();
        this.f26572q = arguments2 != null ? arguments2.getInt("liveStatus") : 1;
    }

    /* renamed from: Rh */
    public q1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return q1.K(layoutInflater, viewGroup, false);
    }

    public void initView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TabData(getResources().getString(R$string.n_live), 0, 2, 2, (r) null));
        arrayList.add(new TabData(getResources().getString(R$string.n_live_appointment), 0, 1, 2, (r) null));
        arrayList.add(new TabData(getResources().getString(R$string.n_live_playback), 0, 3, 2, (r) null));
        ArrayList arrayList2 = new ArrayList();
        LiveCategoryChildFragment.a aVar = LiveCategoryChildFragment.f26562u;
        arrayList2.add(aVar.a(this.f26571p, 2));
        arrayList2.add(aVar.a(this.f26571p, 1));
        arrayList2.add(aVar.a(this.f26571p, 3));
        he.a aVar2 = new he.a((Fragment) this);
        aVar2.a(arrayList2);
        ((q1) uh()).E.setAdapter(aVar2);
        ((q1) uh()).E.setOffscreenPageLimit(arrayList.size());
        ne.b.f(requireContext(), arrayList, ((q1) uh()).B, ((q1) uh()).E, 12.0f, new b(), R$color.baseColorSecondaryTextNew, R$color.baseColorPrimaryText, R$color.transparent, R$drawable.bg_sel_live_category, 0.0f, 0.0f, 0.0f, 0.0f, 15360, (Object) null);
        ViewPager2 viewPager2 = ((q1) uh()).E;
        int i11 = this.f26572q;
        int i12 = 1;
        if (i11 != 1) {
            i12 = i11 != 2 ? 2 : 0;
        }
        viewPager2.setCurrentItem(i12, false);
    }
}
