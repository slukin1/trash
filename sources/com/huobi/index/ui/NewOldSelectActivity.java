package com.huobi.index.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.main.ui.HuobiMainActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

@Route(path = "/Launch/new_old_select")
public class NewOldSelectActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public View f73788b;

    /* renamed from: c  reason: collision with root package name */
    public View f73789c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f73790d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f73791e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fg(View view) {
        this.f73788b.setSelected(false);
        this.f73789c.setSelected(true);
        this.f73790d.setImageResource(R.drawable.rookie);
        this.f73791e.setImageResource(R.drawable.veteran_ed);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        this.f73788b.setSelected(true);
        this.f73789c.setSelected(false);
        this.f73790d.setImageResource(R.drawable.rookie_ed);
        this.f73791e.setImageResource(R.drawable.veteran);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        SP.y("SP_KEY_NEW_OLD_SELECT", true);
        HashMap hashMap = new HashMap();
        if (this.f73788b.isSelected()) {
            startActivity(new Intent(this, LiteReMainActivity.class));
            hashMap.put("user_type", ChainInfo.CHAIN_TYPE_NEW);
        } else {
            startActivity(new Intent(this, HuobiMainActivity.class));
            hashMap.put("user_type", ChainInfo.CHAIN_TYPE_OLD);
        }
        g.i("New_and_old_user_start_click", hashMap);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        super.addEvent();
        this.f73788b.setOnClickListener(new m1(this));
        this.f73789c.setOnClickListener(new l1(this));
        this.viewFinder.b(R.id.id_new_old_select_btn).setOnClickListener(new k1(this));
    }

    public void afterInit() {
        super.afterInit();
        this.f73788b.setSelected(true);
        g.i("New_and_old_user_view", (HashMap) null);
    }

    public int getContentView() {
        return R.layout.activity_new_old_select;
    }

    public void initView() {
        super.initView();
        this.f73788b = this.viewFinder.b(R.id.id_new_old_select_layout1);
        this.f73789c = this.viewFinder.b(R.id.id_new_old_select_layout2);
        this.f73790d = (ImageView) this.viewFinder.b(R.id.id_new_old_select_layout1_img);
        this.f73791e = (ImageView) this.viewFinder.b(R.id.id_new_old_select_layout2_img);
    }
}
