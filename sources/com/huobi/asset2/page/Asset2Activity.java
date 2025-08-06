package com.huobi.asset2.page;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.margin.AssetMarginContainerFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.feature.base.BaseAssetFragment;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import com.huobi.asset2.page.presenter.Asset2Presenter;
import com.huobi.view.title.HbTitleBar;
import hh.f;
import hi.a;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class Asset2Activity extends BaseActivity<Asset2Presenter, Asset2Presenter.a> implements Asset2Presenter.a {

    /* renamed from: b  reason: collision with root package name */
    public BaseAssetFragment f42780b;

    /* renamed from: c  reason: collision with root package name */
    public HbTitleBar f42781c;

    /* access modifiers changed from: private */
    public /* synthetic */ void gg(AssetAccountType assetAccountType, String str, Boolean bool) {
        Yf(assetAccountType, str);
    }

    public final void Og() {
        if (this.f42780b != null) {
            FragmentTransaction q11 = getSupportFragmentManager().q();
            int i11 = R$id.rlyt_container;
            BaseAssetFragment baseAssetFragment = this.f42780b;
            q11.c(i11, baseAssetFragment, baseAssetFragment.getClass().getName());
            q11.k();
        }
    }

    public final void Yf(AssetAccountType assetAccountType, String str) {
        AssetSummaryAccountType assetSummaryAccountType;
        f.a<?> g11 = f.h().g(assetAccountType);
        if (g11 != null) {
            this.f42780b = (BaseAssetFragment) g11.a();
            this.f42781c.setTitle(g11.c(this));
            if (this.f42780b instanceof AssetSubTypesContainerFragment) {
                if (!TextUtils.isEmpty(str)) {
                    assetSummaryAccountType = AssetSummaryAccountType.valueOf(str);
                } else if (this.f42780b instanceof AssetMarginContainerFragment) {
                    assetSummaryAccountType = AssetSummaryAccountType.SUPER_MARGIN;
                } else {
                    assetSummaryAccountType = AssetSummaryAccountType.LINEAR_SWAP;
                }
                AssetSubTypesContainerFragment assetSubTypesContainerFragment = (AssetSubTypesContainerFragment) this.f42780b;
                AssetSubTypesContainerFragment.f42318q = assetSummaryAccountType;
            }
            Og();
            return;
        }
        finish();
    }

    /* renamed from: Zf */
    public Asset2Presenter createPresenter() {
        return new Asset2Presenter();
    }

    public void addEvent() {
    }

    public void afterInit() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("ASSET_ACCOUNT_TYPE");
            String stringExtra2 = getIntent().getStringExtra("ASSET_SUMMARY_ACCOUNT_TYPE");
            if (!TextUtils.isEmpty(stringExtra)) {
                AssetAccountType valueOf = AssetAccountType.valueOf(stringExtra);
                if (f.h().f() == null || f.h().f().isEmpty()) {
                    f.h().k().compose(RxJavaHelper.t(getUI())).subscribe(new a(this, valueOf, stringExtra2));
                } else {
                    Yf(valueOf, stringExtra2);
                }
            }
        }
    }

    /* renamed from: fg */
    public Asset2Presenter.a getUI() {
        return this;
    }

    public int getContentView() {
        return R$layout.activity_asset2;
    }

    public void initView() {
        this.f42781c = (HbTitleBar) this.viewFinder.b(R$id.flyt_title_bar);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        AssetModuleConfig.a().I0(this);
    }
}
