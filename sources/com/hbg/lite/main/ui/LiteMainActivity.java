package com.hbg.lite.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.base.LiteBaseFragment;
import com.hbg.lite.index.ui.LiteIndexFragment;
import com.hbg.lite.main.presenter.LiteMainPresenter;
import com.hbg.lite.wallet.ui.WalletFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fb.a;
import fb.b;
import java.util.Map;
import ra.c;

public class LiteMainActivity extends LiteBaseActivity<LiteMainPresenter, LiteMainPresenter.a> implements LiteMainPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public LoadingView f77177b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77178c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingView f77179d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77180e;

    /* renamed from: f  reason: collision with root package name */
    public LiteIndexFragment f77181f;

    /* renamed from: g  reason: collision with root package name */
    public WalletFragment f77182g;

    /* renamed from: h  reason: collision with root package name */
    public LiteBaseFragment f77183h;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        c.b().j(this);
        c.c().l("181", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        E6("INDEX", new Bundle());
        c.c().l("180", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void E6(String str, Bundle bundle) {
        LiteBaseFragment fg2 = fg(str);
        LiteBaseFragment liteBaseFragment = this.f77183h;
        if (liteBaseFragment == null || liteBaseFragment != fg2) {
            ph(str);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction q11 = supportFragmentManager.q();
            if (supportFragmentManager.B0() != null) {
                for (Fragment next : supportFragmentManager.B0()) {
                    if (next != null && !(next instanceof DialogFragment)) {
                        q11.q(next);
                    }
                }
            }
            if (!fg2.isAdded()) {
                q11.c(R$id.id_lite_main_fragment_container, fg2, fg2.getClass().getName());
            }
            this.f77183h = fg2;
            q11.A(fg2).k();
            Pg();
        }
    }

    public final void Pg() {
        c.c().z(this, this.f77183h instanceof WalletFragment);
    }

    public void Qg() {
    }

    /* renamed from: Zf */
    public LiteMainPresenter createPresenter() {
        return new LiteMainPresenter();
    }

    public void addEvent() {
        this.viewFinder.b(R$id.id_lite_main_tab_index_layout).setOnClickListener(new b(this));
        this.viewFinder.b(R$id.id_lite_main_tab_balance_layout).setOnClickListener(new a(this));
    }

    public final LiteBaseFragment fg(String str) {
        if ("WALLET".equalsIgnoreCase(str)) {
            if (this.f77182g == null) {
                this.f77182g = new WalletFragment();
            }
            return this.f77182g;
        }
        if (this.f77181f == null) {
            this.f77181f = new LiteIndexFragment();
        }
        return this.f77181f;
    }

    public int getContentView() {
        return R$layout.lite_activity_main;
    }

    /* renamed from: gg */
    public LiteMainPresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f77177b = (LoadingView) this.viewFinder.b(R$id.id_lite_main_tab_index_json);
        this.f77178c = (TextView) this.viewFinder.b(R$id.id_lite_main_tab_index_tv);
        this.f77179d = (LoadingView) this.viewFinder.b(R$id.id_lite_main_tab_wallet_json);
        this.f77180e = (TextView) this.viewFinder.b(R$id.id_lite_main_tab_wallet_tv);
        E6("INDEX", new Bundle());
        c.c().q(this);
    }

    public void kd() {
    }

    public void oh() {
        this.f77182g = null;
    }

    public void onBackPressed() {
        if (!c.c().h(this)) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable) null);
        }
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        c.b().n();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((LiteMainPresenter) getPresenter()).T(intent);
    }

    public void onResume() {
        super.onResume();
        if (c.c().p()) {
            this.f77180e.setText(getResources().getString(R$string.wallet_tab_name));
        } else {
            this.f77180e.setText(getResources().getString(R$string.lite_main_tab_title_login));
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f77183h != null) {
            c.c().z(this, this.f77183h instanceof WalletFragment);
        }
    }

    public void onStop() {
        super.onStop();
        c.c().z(this, false);
    }

    public final void ph(String str) {
        this.f77177b.d();
        this.f77179d.d();
        this.f77177b.setProgress(0.0f);
        this.f77179d.setProgress(0.0f);
        if ("WALLET".equalsIgnoreCase(str)) {
            this.f77178c.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
            this.f77180e.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
            this.f77179d.c();
            return;
        }
        this.f77178c.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
        this.f77180e.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        this.f77177b.c();
    }

    public void recreate() {
        if (!NightHelper.e().f()) {
            c.b().d(this);
            super.recreate();
        } else if (isCanBeSeen()) {
            NightHelper.e().i(this, LiteMainActivity.class, db.a.b().a());
            finish();
        } else {
            super.recreate();
        }
    }
}
