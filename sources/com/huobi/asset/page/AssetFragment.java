package com.huobi.asset.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import com.huobi.asset.widget.AssetTabLayout;
import hh.f;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import sh.b;
import sh.c;
import sh.d;
import sh.e;
import uh.o0;

public class AssetFragment extends BaseFragment<c, d> implements d {

    /* renamed from: l  reason: collision with root package name */
    public AssetTabLayout f42413l;

    /* renamed from: m  reason: collision with root package name */
    public ViewPager f42414m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f42415n = true;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            AssetFragment.this.f42413l.getTitleLayout().setIndex(i11);
            AssetFragment.this.f42413l.d();
            f.h().u(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(int i11) {
        f.h().u(i11);
        this.f42414m.setCurrentItem(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(Boolean bool) {
        this.f42413l.b();
        this.f42414m.setAdapter(new e(getChildFragmentManager()));
        Hh();
    }

    public void Ah() {
        super.Ah();
        this.f42413l.setOnTabChangedListener(new sh.a(this));
        this.f42414m.addOnPageChangeListener(new a());
    }

    /* renamed from: Fh */
    public c xh() {
        return new c();
    }

    /* renamed from: Gh */
    public d zh() {
        return this;
    }

    public final void Hh() {
        if (!Ih()) {
            Mh(f.h().i());
        }
    }

    public final boolean Ih() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        String string = arguments.getString("total_balance_type");
        if (string == null) {
            string = null;
        }
        arguments.clear();
        i6.d.j("initJumpParams-->", string);
        if ("total_balance_type_margin".equals(string)) {
            Mh(AssetAccountType.MARGIN);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.SINGLE_MARGIN;
        } else if ("total_balance_type_super_margin".equals(string)) {
            Mh(AssetAccountType.MARGIN);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.SUPER_MARGIN;
        } else if ("total_balance_type_balance".equals(string)) {
            Mh(AssetAccountType.SPOT);
        } else if ("total_balance_type_legal".equals(string)) {
            Mh(AssetAccountType.OTC);
        } else if ("total_balance_type_contract".equals(string)) {
            Mh(AssetAccountType.FUTURE);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.CONTRACT;
        } else if ("total_balance_type_swap".equals(string)) {
            Mh(AssetAccountType.FUTURE);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.SWAP;
        } else if ("total_balance_type_option".equals(string)) {
            Mh(AssetAccountType.FUTURE);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.OPTION;
        } else if ("total_balance_type_linear_swap".equals(string)) {
            Mh(AssetAccountType.FUTURE);
            AssetSubTypesContainerFragment.f42318q = AssetSummaryAccountType.LINEAR_SWAP;
        } else if ("total_balance_type_grid".equals(string)) {
            Mh(AssetAccountType.QUANT);
        } else if ("total_balance_type_mine".equals(string)) {
            Mh(AssetAccountType.POOL);
        } else if ("total_balance_type_mining".equals(string)) {
            Mh(AssetAccountType.HUOBI_EARN);
        } else if (!"total_balance_type_otc_option".equals(string)) {
            return false;
        } else {
            Mh(AssetAccountType.WARRANT);
        }
        return true;
    }

    public final void Jh() {
        View b11 = this.f67460i.b(R$id.asset_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        b11.setLayoutParams(layoutParams);
    }

    public void Mh(AssetAccountType assetAccountType) {
        f.a<?> g11;
        int indexOf;
        if (assetAccountType != null && (g11 = f.h().g(assetAccountType)) != null && (indexOf = f.h().f().indexOf(g11)) >= 0) {
            int i11 = indexOf + 1;
            try {
                this.f42413l.getTitleLayout().setIndex(i11);
                this.f42413l.d();
                this.f42414m.setCurrentItem(i11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void afterInit() {
        super.afterInit();
        f.h().k().compose(RxJavaHelper.t(zh())).subscribe(q6.d.c(zh(), new b(this)));
    }

    public void initViews() {
        super.initViews();
        Jh();
        this.f42413l = (AssetTabLayout) this.f67460i.b(R$id.asset_tab_layout);
        this.f42414m = (ViewPager) this.f67460i.b(R$id.vp_tab);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNavigationEvent(th.a aVar) {
        AssetSummaryAccountType c11 = aVar.c();
        if (c11 != null) {
            AssetSubTypesContainerFragment.f42318q = c11;
        }
        AssetSummaryAccountType b11 = aVar.b();
        if (b11 != null && b11.getAssetAccountType() != null) {
            Mh(b11.getAssetAccountType());
        }
    }

    public void onPause() {
        super.onPause();
        EventBus.d().r(this);
    }

    public void onResume() {
        super.onResume();
        EventBus.d().p(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (zh() != null && getActivity() != null && zh().isCanBeSeen()) {
            AssetModuleConfig.a().g(getActivity());
            getActivity().recreate();
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_asset, viewGroup, false);
    }

    public void th(boolean z11) {
        super.th(z11);
        if (z11) {
            o0.G().t0(getActivity());
            o0.G().u0(zh());
            o0.G().J();
            if (!this.f42415n) {
                f.h().s();
                Hh();
            }
            this.f42415n = false;
        }
        AssetModuleConfig.a().i0(z11);
    }
}
