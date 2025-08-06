package com.huobi.asset.feature.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.ui.AssetSmartRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import gh.b;
import hh.f;
import i6.d;
import java.util.HashMap;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ph.h;

public abstract class BaseAssetFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public SmartRefreshLayout f42324l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f42325m = true;

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(j jVar) {
        Jh();
        f.h().s();
    }

    public void Ah() {
        this.f42324l.d0(new h(this));
    }

    public abstract int Fh();

    public String Gh() {
        return null;
    }

    public void Ih(boolean z11) {
    }

    public abstract void Jh();

    public void Kh() {
        this.f42324l.finishRefresh();
    }

    public View getContentView() {
        if (Fh() != 0) {
            return LayoutInflater.from(getActivity()).inflate(Fh(), (ViewGroup) null, false);
        }
        throw new IllegalStateException("The content view of " + getClass().getName() + " is NULL.");
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(b bVar) {
        d.i("onHideAmountChange show=" + bVar.b());
        Ih(bVar.b());
    }

    public void initViews() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R$id.refresh_layout);
        this.f42324l = smartRefreshLayout;
        smartRefreshLayout.g(false).j0(new AssetSmartRefreshHeader(getActivity()));
        ((FrameLayout) this.f67460i.b(R$id.fl_content)).addView(getContentView(), new LinearLayout.LayoutParams(-1, -1));
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventBus.d().p(this);
        return layoutInflater.inflate(R$layout.fragment_asset_base, viewGroup, false);
    }

    public void th(boolean z11) {
        super.th(z11);
        if (z11) {
            if (!this.f42325m && BaseModuleConfig.a().a()) {
                Jh();
            }
            this.f42325m = false;
            if (Gh() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Page_name", Gh());
                BaseModuleConfig.a().w("app_assets_all_view", hashMap);
            }
        }
    }
}
