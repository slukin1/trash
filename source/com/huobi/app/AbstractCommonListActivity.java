package com.huobi.app;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bh.b;
import bh.c;
import bh.d;
import bh.e;
import bh.f;
import bh.g;
import bh.h;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import rx.Observable;
import s9.a;

public abstract class AbstractCommonListActivity extends EmptyMVPActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<a> f42119b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42120c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42121d;

    /* renamed from: e  reason: collision with root package name */
    public View f42122e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingLayout f42123f;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(int i11) {
        EasyRecyclerView<a> easyRecyclerView = this.f42119b;
        if (easyRecyclerView != null) {
            easyRecyclerView.getAdapter().notifyItemChanged(i11);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Dh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(List list) {
        if (!isFinishing()) {
            setData(list);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(List list) {
        EasyRecyclerView<a> easyRecyclerView = this.f42119b;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
        F0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh() {
        this.f42123f.g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh() {
        this.f42123f.p();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh() {
        EasyRecyclerView<a> easyRecyclerView = this.f42119b;
        if (easyRecyclerView != null) {
            easyRecyclerView.c();
        }
    }

    public abstract void Bh();

    public abstract void Ch();

    public void Dh() {
        showLoading();
        Observable.just(new ArrayList()).map(new h(this)).compose(RxJavaHelper.t(this)).doOnNext(new g(this)).subscribe();
    }

    public void Eh() {
        runOnUiThread(new c(this));
    }

    public void F0() {
        if (Gh() && this.f42123f != null) {
            runOnUiThread(new d(this));
        }
    }

    public void Fh(int i11) {
        runOnUiThread(new e(this, i11));
    }

    public boolean Gh() {
        return false;
    }

    public abstract String Qg();

    public void addEvent() {
        this.f42123f.setOnRetryClickListener(new bh.a(this));
    }

    public void afterInit() {
        Dh();
    }

    public int getContentView() {
        return R.layout.activity_common_list;
    }

    public void initView() {
        this.f42123f = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        removeWinBg();
        sh();
        rh();
        this.f42122e = this.viewFinder.b(R.id.id_common_list_ll);
        this.f42120c = (TextView) this.viewFinder.b(R.id.id_common_list_bottom_btn);
        this.f42121d = (TextView) this.viewFinder.b(R.id.id_common_list_change_btn);
        ph();
    }

    public abstract String oh();

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_common_list_bottom_btn:
                Bh();
                break;
            case R.id.id_common_list_change_btn:
                Ch();
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void ph() {
        boolean th2 = th();
        if (th2) {
            this.f42120c.setText(Qg());
            this.f42120c.setOnClickListener(this);
        }
        boolean uh2 = uh();
        if (uh2) {
            this.f42121d.setOnClickListener(this);
        }
        int i11 = 8;
        this.f42120c.setVisibility(th2 ? 0 : 8);
        this.f42121d.setVisibility(uh2 ? 0 : 8);
        boolean z11 = true;
        boolean z12 = th2 && uh2;
        if (!th2 && !uh2) {
            z11 = false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f42123f.getLayoutParams();
        if (z12) {
            layoutParams.bottomMargin = PixelUtils.a(128.0f);
        } else if (z11) {
            layoutParams.bottomMargin = PixelUtils.a(69.0f);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.f42123f.setLayoutParams(layoutParams);
        View view = this.f42122e;
        if (z11) {
            i11 = 0;
        }
        view.setVisibility(i11);
    }

    public abstract List<a> qh(List<a> list);

    public final void rh() {
        EasyRecyclerView<a> easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R.id.id_common_list_recyclerView);
        this.f42119b = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new StableLinearLayoutManager(this));
    }

    public void setData(List<a> list) {
        runOnUiThread(new f(this, list));
    }

    public final void sh() {
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        if (oh() != null) {
            hbTitleBar.setTitle(oh());
        }
    }

    public void showLoading() {
        if (Gh() && this.f42123f != null) {
            runOnUiThread(new b(this));
        }
    }

    public abstract boolean th();

    public abstract boolean uh();

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
