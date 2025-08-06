package com.hbg.module.exchange.grid.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import cd.q0;
import com.hbg.lib.common.utils.ViewPager;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$raw;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.R$style;
import com.hbg.module.exchange.grid.bean.GridUserGuideInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u6.g;
import yc.c;

public class GridUserGuideFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f19590b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19591c;

    /* renamed from: d  reason: collision with root package name */
    public SafeLottieView f19592d;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f19593e;

    /* renamed from: f  reason: collision with root package name */
    public List<GridUserGuideInfo> f19594f;

    /* renamed from: g  reason: collision with root package name */
    public int f19595g = -1;

    /* renamed from: h  reason: collision with root package name */
    public b f19596h;

    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public final List<Fragment> f19597a;

        public a(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.f19597a = list;
        }

        public int getCount() {
            return this.f19597a.size();
        }

        public Fragment getItem(int i11) {
            return this.f19597a.get(i11);
        }
    }

    public interface b {
        void onDismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(GridUserGuideInfo gridUserGuideInfo) {
        this.f19592d.setAnimation(gridUserGuideInfo.getImageId());
        this.f19592d.playAnimation();
    }

    public static GridUserGuideFragment yh() {
        return new GridUserGuideFragment();
    }

    public void Ah(b bVar) {
        this.f19596h = bVar;
    }

    public final void Bh() {
        int size = this.f19594f.size();
        int i11 = this.f19595g + 1;
        this.f19595g = i11;
        if (i11 < size - 1) {
            this.f19590b.setVisibility(0);
            this.f19591c.setText(getString(R$string.n_grid_user_guide_next));
        } else {
            this.f19590b.setVisibility(8);
            this.f19591c.setText(getString(R$string.n_grid_user_guide_complete));
        }
        int i12 = this.f19595g;
        if (i12 < size) {
            this.f19593e.setCurrentItem(i12);
            this.f19592d.postDelayed(new q0(this, this.f19594f.get(this.f19595g)), this.f19595g == 0 ? getDuration() : 0);
        }
    }

    public void addEvent(r rVar) {
        this.f19590b.setOnClickListener(this);
        this.f19591c.setOnClickListener(this);
    }

    public void afterInit() {
        setCanDismissOnBackPress(false);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        vc.b.a().l("5914", "1005373", (Map<String, Object>) null);
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_grid_user_guide_container;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        int i11;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            i11 = R$drawable.grid_user_guide_title_cn;
        } else {
            i11 = R$drawable.grid_user_guide_title_us;
        }
        rVar.c(R$id.user_guide_title).setImageDrawable(getResources().getDrawable(i11));
        SafeLottieView safeLottieView = (SafeLottieView) rVar.b(R$id.lottie_container);
        this.f19592d = safeLottieView;
        ViewGroup.LayoutParams layoutParams = safeLottieView.getLayoutParams();
        layoutParams.height = (int) ((((float) n.g(this.f19592d.getContext())) / 750.0f) * 554.0f);
        this.f19592d.setLayoutParams(layoutParams);
        this.f19592d.setImageAssetsFolder("images/");
        this.f19590b = rVar.e(R$id.guide_skip);
        this.f19591c = rVar.e(R$id.guide_next);
        List<GridUserGuideInfo> wh2 = wh();
        this.f19594f = wh2;
        int size = wh2.size();
        ArrayList arrayList = new ArrayList();
        for (GridUserGuideInfo Gh : this.f19594f) {
            arrayList.add(GridUserGuideContentFragment.Gh(Gh, size));
        }
        ViewPager viewPager = (ViewPager) rVar.b(R$id.content_container);
        this.f19593e = viewPager;
        viewPager.setOffscreenPageLimit(size);
        this.f19593e.setAdapter(new a(getChildFragmentManager(), arrayList));
        Bh();
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.guide_skip) {
            th(false);
            vc.b.a().d("5917", (Map<String, Object>) null, "1005373");
        } else if (id2 == R$id.guide_next) {
            if (this.f19590b.getVisibility() == 8) {
                th(true);
                vc.b.a().d("5915", (Map<String, Object>) null, "1005373");
            } else {
                Bh();
                vc.b.a().d("5918", (Map<String, Object>) null, "1005373");
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void th(boolean z11) {
        if (!c.f()) {
            c.d((Integer) null, 1).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
        }
        doDismiss();
        b bVar = this.f19596h;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    public final String uh(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 1) {
            sb2.append(context.getString(R$string.n_grid_user_guide_set_up_bot_detail_k1));
            sb2.append(context.getString(R$string.n_grid_user_guide_set_up_bot_detail_v1));
        } else if (i11 == 2) {
            int d11 = w.d();
            String string = context.getString(R$string.n_grid_user_guide_run_bot_detail_k1);
            String string2 = context.getString(R$string.n_grid_user_guide_run_bot_detail_v1);
            sb2.append(string.replaceAll(string2, "<font color='#" + zh(context, d11) + "'>" + string2 + "</font>"));
        } else if (i11 == 3) {
            sb2.append(context.getString(R$string.n_grid_user_guide_close_bot_detail_v1));
        }
        return sb2.toString();
    }

    public final String vh(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 1) {
            sb2.append(context.getString(R$string.n_grid_user_guide_set_up_bot_detail_k2));
            sb2.append(context.getString(R$string.n_grid_user_guide_set_up_bot_detail_v2));
        } else if (i11 == 2) {
            int h11 = w.h();
            String string = context.getString(R$string.n_grid_user_guide_run_bot_detail_k2);
            String string2 = context.getString(R$string.n_grid_user_guide_run_bot_detail_v2);
            sb2.append(string.replaceAll(string2, "<font color='#" + zh(context, h11) + "'>" + string2 + "</font>"));
        } else if (i11 == 3) {
            sb2.append(context.getString(R$string.n_grid_user_guide_close_bot_detail_v2));
        }
        return sb2.toString();
    }

    public final List<GridUserGuideInfo> wh() {
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        if (context == null) {
            return arrayList;
        }
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        String m11 = vc.b.a().m();
        arrayList.add(new GridUserGuideInfo(1, isChineseLanguage ? R$raw.grid_trading_tutorial_p1_cn : R$raw.grid_trading_tutorial_p1_en, context.getString(R$string.n_grid_user_guide_set_up_bot), uh(context, 1), vh(context, 1), m11));
        arrayList.add(new GridUserGuideInfo(2, isChineseLanguage ? R$raw.grid_trading_tutorial_p2_cn : R$raw.grid_trading_tutorial_p2_en, context.getString(R$string.n_grid_user_guide_run_bot), uh(context, 2), vh(context, 2), m11));
        arrayList.add(new GridUserGuideInfo(3, isChineseLanguage ? R$raw.grid_trading_tutorial_p3_cn : R$raw.grid_trading_tutorial_p3_en, context.getString(R$string.n_grid_user_guide_close_bot), uh(context, 3), vh(context, 3), m11));
        return arrayList;
    }

    public String zh(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        int color = context.getResources().getColor(i11);
        sb2.append(Integer.toHexString((16711680 & color) >> 16));
        sb2.append(Integer.toHexString((65280 & color) >> 8));
        sb2.append(Integer.toHexString(color & 255));
        return sb2.toString();
    }
}
