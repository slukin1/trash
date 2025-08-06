package com.hbg.module.livesquare.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.network.hbg.core.bean.LiveWiningInfo;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$style;
import com.hbg.module.livesquare.ui.LiveMyAwardFragment;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import i6.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import rd.s;

public final class LiveSelfAwardDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f26509b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f26510c;

    /* renamed from: d  reason: collision with root package name */
    public TabLayout f26511d;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager2 f26512e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayoutMediator f26513f;

    /* renamed from: g  reason: collision with root package name */
    public RoundTextView f26514g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f26515h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<Fragment> f26516i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public LiveWiningInfo f26517j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f26518k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public he.a f26519l;

    /* renamed from: m  reason: collision with root package name */
    public d10.a<Unit> f26520m;

    /* renamed from: n  reason: collision with root package name */
    public l<? super String, Unit> f26521n;

    /* renamed from: o  reason: collision with root package name */
    public d10.a<Unit> f26522o;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26524c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSelfAwardDialog f26525d;

        public a(View view, long j11, LiveSelfAwardDialog liveSelfAwardDialog) {
            this.f26523b = view;
            this.f26524c = j11;
            this.f26525d = liveSelfAwardDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26523b) > this.f26524c || (this.f26523b instanceof Checkable)) {
                sVar.e(this.f26523b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26523b;
                this.f26525d.dismissAllowingStateLoss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26526b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26527c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSelfAwardDialog f26528d;

        public b(View view, long j11, LiveSelfAwardDialog liveSelfAwardDialog) {
            this.f26526b = view;
            this.f26527c = j11;
            this.f26528d = liveSelfAwardDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26526b) > this.f26527c || (this.f26526b instanceof Checkable)) {
                sVar.e(this.f26526b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26526b;
                l<String, Unit> vh2 = this.f26528d.vh();
                if (vh2 != null) {
                    LiveWiningInfo th2 = this.f26528d.th();
                    vh2.invoke(th2 != null ? th2.getRuleContent() : null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26530c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSelfAwardDialog f26531d;

        public c(View view, long j11, LiveSelfAwardDialog liveSelfAwardDialog) {
            this.f26529b = view;
            this.f26530c = j11;
            this.f26531d = liveSelfAwardDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26529b) > this.f26530c || (this.f26529b instanceof Checkable)) {
                sVar.e(this.f26529b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f26529b;
                d10.a<Unit> wh2 = this.f26531d.wh();
                if (wh2 != null) {
                    wh2.invoke();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveSelfAwardDialog f26532a;

        public d(LiveSelfAwardDialog liveSelfAwardDialog) {
            this.f26532a = liveSelfAwardDialog;
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            Bundle arguments = this.f26532a.xh().get(i11).getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("LiveWiningInfo") : null;
            if (serializable != null) {
                LiveWiningInfo.QueryAwardDrawResult queryAwardDrawResult = (LiveWiningInfo.QueryAwardDrawResult) serializable;
                if (queryAwardDrawResult.getDrawDetailList() == null) {
                    LinearLayout uh2 = this.f26532a.uh();
                    if (uh2 != null) {
                        uh2.setVisibility(4);
                    }
                } else if (queryAwardDrawResult.getDrawDetailList().size() == 0) {
                    LinearLayout uh3 = this.f26532a.uh();
                    if (uh3 != null) {
                        uh3.setVisibility(4);
                    }
                } else {
                    LinearLayout uh4 = this.f26532a.uh();
                    if (uh4 != null) {
                        uh4.setVisibility(0);
                    }
                }
            } else {
                LinearLayout uh5 = this.f26532a.uh();
                if (uh5 != null) {
                    uh5.setVisibility(4);
                }
            }
        }
    }

    public static final void zh(LiveSelfAwardDialog liveSelfAwardDialog, TabLayout.Tab tab, int i11) {
        tab.setText((CharSequence) liveSelfAwardDialog.f26518k.get(i11));
    }

    public final void Ah(LiveWiningInfo liveWiningInfo) {
        this.f26517j = liveWiningInfo;
    }

    public final void Bh(l<? super String, Unit> lVar) {
        this.f26521n = lVar;
    }

    public final void Ch(d10.a<Unit> aVar) {
        this.f26520m = aVar;
    }

    public final void Dh(d10.a<Unit> aVar) {
        this.f26522o = aVar;
    }

    public void addEvent(r rVar) {
        LinearLayout linearLayout = this.f26509b;
        if (linearLayout != null) {
            s sVar = s.f23381a;
            linearLayout.setOnClickListener(new a(linearLayout, 800, this));
        }
        LinearLayout linearLayout2 = this.f26510c;
        if (linearLayout2 != null) {
            s sVar2 = s.f23381a;
            linearLayout2.setOnClickListener(new b(linearLayout2, 800, this));
        }
        RoundTextView roundTextView = this.f26514g;
        if (roundTextView != null) {
            s sVar3 = s.f23381a;
            roundTextView.setOnClickListener(new c(roundTextView, 800, this));
        }
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_live_self_award;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Resources resources7;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        String str = null;
        this.f26509b = rVar != null ? (LinearLayout) rVar.b(R$id.llClose) : null;
        this.f26510c = rVar != null ? (LinearLayout) rVar.b(R$id.llProblem) : null;
        this.f26511d = rVar != null ? (TabLayout) rVar.b(R$id.tabLayout) : null;
        this.f26512e = rVar != null ? (ViewPager2) rVar.b(R$id.vpAward) : null;
        this.f26514g = rVar != null ? (RoundTextView) rVar.b(R$id.tvReciver) : null;
        this.f26515h = rVar != null ? (LinearLayout) rVar.b(R$id.llBottomReceiver) : null;
        List<String> list = this.f26518k;
        Context context = getContext();
        list.add((context == null || (resources7 = context.getResources()) == null) ? null : resources7.getString(R$string.n_content_live_token));
        List<String> list2 = this.f26518k;
        Context context2 = getContext();
        list2.add((context2 == null || (resources6 = context2.getResources()) == null) ? null : resources6.getString(R$string.n_content_live_exp_gold));
        List<String> list3 = this.f26518k;
        Context context3 = getContext();
        list3.add((context3 == null || (resources5 = context3.getResources()) == null) ? null : resources5.getString(R$string.n_content_live_card));
        List<String> list4 = this.f26518k;
        Context context4 = getContext();
        list4.add((context4 == null || (resources4 = context4.getResources()) == null) ? null : resources4.getString(R$string.n_content_live_rate_coupon));
        List<String> list5 = this.f26518k;
        Context context5 = getContext();
        list5.add((context5 == null || (resources3 = context5.getResources()) == null) ? null : resources3.getString(R$string.n_live_drop_cash_coupon));
        List<String> list6 = this.f26518k;
        Context context6 = getContext();
        list6.add((context6 == null || (resources2 = context6.getResources()) == null) ? null : resources2.getString(R$string.n_live_drop_experience_coupon));
        List<String> list7 = this.f26518k;
        Context context7 = getContext();
        if (!(context7 == null || (resources = context7.getResources()) == null)) {
            str = resources.getString(R$string.n_live_drop_coupon);
        }
        list7.add(str);
        yh();
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onActivityCreated(r3)
            android.app.Dialog r3 = r2.getDialog()
            android.view.Window r3 = r3.getWindow()
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L_0x0023
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0023
            int r1 = com.hbg.module.content.R$dimen.dimen_469
            float r0 = r0.getDimension(r1)
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            int r0 = r0.intValue()
            r1 = -1
            r3.setLayout(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.livesquare.dialog.LiveSelfAwardDialog.onActivityCreated(android.os.Bundle):void");
    }

    public void onDestroyView() {
        TabLayoutMediator tabLayoutMediator = this.f26513f;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
        super.onDestroyView();
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public final LiveWiningInfo th() {
        return this.f26517j;
    }

    public final LinearLayout uh() {
        return this.f26515h;
    }

    public final l<String, Unit> vh() {
        return this.f26521n;
    }

    public final d10.a<Unit> wh() {
        return this.f26520m;
    }

    public final ArrayList<Fragment> xh() {
        return this.f26516i;
    }

    public final void yh() {
        TabLayoutMediator tabLayoutMediator;
        List<LiveWiningInfo.QueryAwardDrawResult> queryAwardDrawResultList;
        Integer type;
        Integer type2;
        Integer type3;
        Integer type4;
        Integer type5;
        ViewPager2 viewPager2 = this.f26512e;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(this.f26518k.size());
        }
        List<String> list = this.f26518k;
        if (list != null) {
            int i11 = 0;
            for (T next : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                String str = (String) next;
                LiveMyAwardFragment liveMyAwardFragment = new LiveMyAwardFragment();
                LiveWiningInfo liveWiningInfo = this.f26517j;
                if (!(liveWiningInfo == null || (queryAwardDrawResultList = liveWiningInfo.getQueryAwardDrawResultList()) == null)) {
                    for (LiveWiningInfo.QueryAwardDrawResult queryAwardDrawResult : queryAwardDrawResultList) {
                        if (queryAwardDrawResult != null) {
                            if (i11 < 4 && i11 != 1 && (type5 = queryAwardDrawResult.getType()) != null && type5.intValue() == i12) {
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("LiveWiningInfo", queryAwardDrawResult);
                                liveMyAwardFragment.setArguments(bundle);
                            } else if ((i11 == 1 && (type4 = queryAwardDrawResult.getType()) != null && type4.intValue() == 14) || ((i11 == 4 && (type3 = queryAwardDrawResult.getType()) != null && type3.intValue() == 12) || ((i11 == 5 && (type2 = queryAwardDrawResult.getType()) != null && type2.intValue() == 15) || (i11 == 6 && (type = queryAwardDrawResult.getType()) != null && type.intValue() == 16)))) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putSerializable("LiveWiningInfo", queryAwardDrawResult);
                                liveMyAwardFragment.setArguments(bundle2);
                            }
                        }
                    }
                }
                this.f26516i.add(liveMyAwardFragment);
                i11 = i12;
            }
        }
        he.a aVar = new he.a((Fragment) this);
        this.f26519l = aVar;
        ViewPager2 viewPager22 = this.f26512e;
        if (viewPager22 != null) {
            viewPager22.setAdapter(aVar);
        }
        he.a aVar2 = this.f26519l;
        if (aVar2 != null) {
            aVar2.a(this.f26516i);
        }
        ViewPager2 viewPager23 = this.f26512e;
        if (viewPager23 != null) {
            viewPager23.setCurrentItem(0, false);
        }
        TabLayoutMediator tabLayoutMediator2 = new TabLayoutMediator(this.f26511d, this.f26512e, false, true, new af.d(this));
        this.f26513f = tabLayoutMediator2;
        if (!Boolean.valueOf(tabLayoutMediator2.isAttached()).booleanValue() && (tabLayoutMediator = this.f26513f) != null) {
            tabLayoutMediator.attach();
        }
        ViewPager2 viewPager24 = this.f26512e;
        if (viewPager24 != null) {
            viewPager24.registerOnPageChangeCallback(new d(this));
        }
    }
}
