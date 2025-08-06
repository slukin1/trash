package com.huobi.guide.ui;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.huobi.guide.ui.ContractGuideContentFragment;
import he.a;
import i6.n;
import i6.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kl.g;
import kl.h;
import kl.i;
import ne.b;
import pro.huobi.R;
import rx.Observable;

public class TradeLoanRepayGuideFragment extends BaseDialogFragment implements ContractGuideContentFragment.a {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TabData> f72466b = new ArrayList<>();

    public static /* synthetic */ void vh(int i11) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(Void voidR) {
        doDismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(Void voidR) {
        doDismiss();
    }

    public static TradeLoanRepayGuideFragment yh(int i11) {
        TradeLoanRepayGuideFragment tradeLoanRepayGuideFragment = new TradeLoanRepayGuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", i11);
        tradeLoanRepayGuideFragment.setArguments(bundle);
        return tradeLoanRepayGuideFragment;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void callback() {
        doDismiss();
    }

    public void doDismiss() {
        super.doDismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.contract_guide_container_new;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        r rVar2 = rVar;
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("tabIndex", 1);
            this.f72466b.add(new TabData(getContext().getResources().getString(R.string.n_trade_margin_auto_borrow), 1, 1));
            this.f72466b.add(new TabData(getContext().getResources().getString(R.string.n_trade_margin_auto_repay), 2, 2));
            this.f72466b.add(new TabData(getContext().getResources().getString(R.string.n_user_center_setting_theme_normal), 0, 0));
            ViewPager2 viewPager2 = (ViewPager2) rVar2.b(R.id.vp_contract_guide);
            CoIndicator coIndicator = (CoIndicator) rVar2.b(R.id.indicator_contract_guide_container);
            ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
            layoutParams.height = (int) (((double) n.f(getContext())) * 0.3d);
            viewPager2.setLayoutParams(layoutParams);
            ArrayList arrayList = new ArrayList();
            Iterator<TabData> it2 = this.f72466b.iterator();
            while (it2.hasNext()) {
                int type = it2.next().getType();
                if (type == 0) {
                    arrayList.add(TradeLoanRepayChildFragment.Eh(0));
                } else if (type == 1) {
                    arrayList.add(TradeLoanRepayChildFragment.Eh(1));
                } else if (type == 2) {
                    arrayList.add(TradeLoanRepayChildFragment.Eh(2));
                }
            }
            a aVar = new a((Fragment) this);
            aVar.a(arrayList);
            viewPager2.setAdapter(aVar);
            b.k(getActivity(), this.f72466b, coIndicator, viewPager2, 1, 16.0f, 16.0f, g.f56592a);
            viewPager2.setOffscreenPageLimit(arrayList.size());
            viewPager2.setCurrentItem(i11, false);
            Observable<Void> a11 = dw.a.a(rVar2.b(R.id.close_contract_guide_container));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            a11.throttleFirst(1, timeUnit).subscribe(new h(this));
            dw.a.a(rVar2.b(R.id.cl_contract_guide_root)).throttleFirst(1, timeUnit).subscribe(new i(this));
        }
    }

    public boolean isTransparent() {
        return false;
    }
}
