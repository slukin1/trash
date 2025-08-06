package com.huobi.account.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.account.presenter.SubscribeAllPresenter;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import ky.j;
import ny.d;
import pg.c;
import pro.huobi.R;

@Route(path = "/account/mySubscribes")
public class SubscribeAllActivity extends BaseActivity<SubscribeAllPresenter, SubscribeAllPresenter.b> implements SubscribeAllPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<c> f41577b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f41578c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroupContainer f41579d;

    /* renamed from: e  reason: collision with root package name */
    public int f41580e = 0;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (SubscribeAllActivity.this.getUI().isCanBeSeen()) {
                ((SubscribeAllPresenter) SubscribeAllActivity.this.getPresenter()).Y();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Og(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        Pg(i12);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ke(List<String> list, List<c> list2) {
        this.f41578c.finishRefresh();
        Qg(list);
        int i11 = this.f41580e;
        if (i11 == 0 || i11 >= this.f41579d.getChildCount()) {
            if (this.f41579d.getChildCount() > 0) {
                this.f41579d.setCheckedPosition(0);
            }
            this.f41577b.setData(list2);
            return;
        }
        this.f41579d.setCheckedPosition(this.f41580e);
    }

    public final void Pg(int i11) {
        ((SubscribeAllPresenter) getPresenter()).c0(i11);
        this.f41580e = i11;
    }

    public final void Qg(List<String> list) {
        this.f41579d.removeAllViews();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_subscribe_all_tab, this.f41579d, false);
            if (i11 != 0) {
                ((ViewGroup.MarginLayoutParams) inflate.getLayoutParams()).setMarginStart(PixelUtils.a(16.0f));
            }
            ((TextView) inflate.findViewById(R.id.tv_text)).setText(str);
            this.f41579d.addView(inflate);
        }
    }

    public void W7(List<c> list) {
        this.f41577b.setData(list);
    }

    public void addEvent() {
        this.viewFinder.b(R.id.back).setOnClickListener(new x5(this));
        this.f41578c.i(true);
        this.f41578c.g(false);
        this.f41578c.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(this);
        smartRefreshHeader.setBackgroundColor(ContextCompat.getColor(this, R.color.baseColorContentBackground));
        this.f41578c.j0(smartRefreshHeader);
        this.f41578c.e0(new a());
        this.f41579d.setOnSelelctChangeListner(new y5(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    /* renamed from: fg */
    public SubscribeAllPresenter createPresenter() {
        return new SubscribeAllPresenter();
    }

    public int getContentView() {
        return R.layout.activity_subscribe_all;
    }

    /* renamed from: gg */
    public SubscribeAllPresenter.b getUI() {
        return this;
    }

    public void initView() {
        TextView textView = (TextView) this.viewFinder.b(R.id.title);
        this.f41579d = (RadioGroupContainer) this.viewFinder.b(R.id.tab_container);
        this.f41577b = (EasyRecyclerView) this.viewFinder.b(R.id.recyclerView);
        this.f41578c = (SmartRefreshLayout) this.viewFinder.b(R.id.refresh_layout);
        this.f41577b.setLayoutManager(new StableLinearLayoutManager(this));
        textView.setText(getIntent() == null ? "" : getIntent().getStringExtra("title"));
    }

    public void onResume() {
        super.onResume();
        ((SubscribeAllPresenter) getPresenter()).Y();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
