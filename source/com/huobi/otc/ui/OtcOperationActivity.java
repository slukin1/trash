package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.Operation1000uItemData;
import com.huobi.otc.bean.OtcU1000DetailBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import u6.g;

public class OtcOperationActivity extends BaseActivity<ActivityPresenter<g>, g> {

    /* renamed from: b  reason: collision with root package name */
    public List<s9.a> f79498b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f79499c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView f79500d;

    /* renamed from: e  reason: collision with root package name */
    public OtcU1000DetailBean f79501e;

    /* renamed from: f  reason: collision with root package name */
    public Toolbar f79502f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            OtcOperationActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends ActivityPresenter {
        public b() {
        }

        public void onUIReady(BaseCoreActivity baseCoreActivity, h6.a aVar) {
            super.onUIReady(baseCoreActivity, aVar);
        }
    }

    public static void Xf(Activity activity, Serializable serializable) {
        Intent intent = new Intent(activity, OtcOperationActivity.class);
        intent.putExtra("data", serializable);
        BaseActivity.start(activity, intent);
    }

    public void addEvent() {
    }

    public ActivityPresenter createPresenter() {
        return new b();
    }

    public int getContentView() {
        return R$layout.activity_opertion_container;
    }

    public g getUI() {
        return this;
    }

    public void initView() {
        this.f79499c = (LoadingLayout) this.viewFinder.b(R$id.otc_order_loading_layout);
        this.f79500d = (EasyRecyclerView) this.viewFinder.b(R$id.list_view);
        this.f79502f = (Toolbar) this.viewFinder.b(R$id.toolbar);
        findViewById(R$id.operation_back).setOnClickListener(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OtcU1000DetailBean otcU1000DetailBean = (OtcU1000DetailBean) getIntent().getSerializableExtra("data");
        this.f79501e = otcU1000DetailBean;
        if (otcU1000DetailBean == null || CollectionsUtils.b(otcU1000DetailBean.getActivityRecordList())) {
            findViewById(R$id.list_view).setVisibility(8);
            findViewById(R$id.u1000_empty).setVisibility(0);
            return;
        }
        for (int i11 = 0; i11 < this.f79501e.getActivityRecordList().size(); i11++) {
            Operation1000uItemData operation1000uItemData = new Operation1000uItemData();
            String valueOf = String.valueOf(this.f79501e.getActivityRecordList().get(i11).getDate());
            String valueOf2 = String.valueOf(this.f79501e.getActivityRecordList().get(i11).getItemTag());
            String valueOf3 = String.valueOf(this.f79501e.getActivityRecordList().get(i11).getAdvertiseDays());
            operation1000uItemData.setTime(valueOf);
            operation1000uItemData.setType(valueOf2);
            operation1000uItemData.setAdvertiseDays(valueOf3);
            this.f79498b.add(operation1000uItemData);
        }
        findViewById(R$id.list_view).setVisibility(0);
        findViewById(R$id.u1000_empty).setVisibility(8);
        this.f79500d.setData(this.f79498b);
    }

    public void setTitle(int i11) {
        super.setTitle(i11);
    }
}
