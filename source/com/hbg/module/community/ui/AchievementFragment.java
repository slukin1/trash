package com.hbg.module.community.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.MedalHomePageShare;
import com.hbg.module.community.adapter.AchievementItemBinder;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.r;
import ky.j;
import lc.w0;
import v7.b;

public final class AchievementFragment extends BaseFragment<w0> {

    /* renamed from: r  reason: collision with root package name */
    public static final a f17251r = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public List<MedalHomePageShare.ShowMedalsBean> f17252p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public MultiTypeAdapter f17253q;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final /* synthetic */ w0 Th(AchievementFragment achievementFragment) {
        return (w0) achievementFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void Yh(AchievementFragment achievementFragment, View view) {
        HBBaseWebActivity.showWebView(achievementFragment.getActivity(), BaseModuleConfig.a().k("welfare/?taskType=MedalWall"), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Wh();
    }

    public final void Wh() {
        Lh();
        RequestExtKt.d(b.a().getMedalHomePageShare(), new AchievementFragment$getDynamicListInfo$1(this), new AchievementFragment$getDynamicListInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Xh */
    public w0 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return w0.K(layoutInflater, viewGroup, false);
    }

    public final void Zh(int i11) {
        String valueOf = String.valueOf(i11);
        SpannableString spannableString = new SpannableString(getString(R$string.n_account_achievement_count, valueOf));
        Matcher matcher = Pattern.compile(valueOf).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(com.hbg.module.libkt.base.ext.b.h(R$color.baseColorMajorTheme100)), matcher.start(), matcher.end(), 33);
        }
        ((w0) uh()).B.setText(spannableString);
    }

    public void bf(j jVar) {
        super.bf(jVar);
        Wh();
    }

    public void initView() {
    }

    public void zh() {
        super.zh();
        ((w0) uh()).C.setOnClickListener(new a(this));
        ((w0) uh()).E.setLayoutManager(com.hbg.module.libkt.base.ext.b.k(getActivity(), 3));
        this.f17253q = new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null);
        AchievementItemBinder achievementItemBinder = new AchievementItemBinder();
        MultiTypeAdapter multiTypeAdapter = this.f17253q;
        MultiTypeAdapter multiTypeAdapter2 = null;
        if (multiTypeAdapter == null) {
            multiTypeAdapter = null;
        }
        multiTypeAdapter.h(MedalHomePageShare.ShowMedalsBean.class, achievementItemBinder);
        ((w0) uh()).F.j0(new SmartRefreshHeader(getActivity()));
        ((w0) uh()).F.e0(this);
        ((w0) uh()).E.setHasFixedSize(true);
        ((w0) uh()).E.setItemAnimator((RecyclerView.ItemAnimator) null);
        RecyclerView recyclerView = ((w0) uh()).E;
        MultiTypeAdapter multiTypeAdapter3 = this.f17253q;
        if (multiTypeAdapter3 != null) {
            multiTypeAdapter2 = multiTypeAdapter3;
        }
        recyclerView.setAdapter(multiTypeAdapter2);
        ((w0) uh()).E.setNestedScrollingEnabled(true);
        ((w0) uh()).F.setNoMoreData(true);
        Wh();
    }
}
