package com.huobi.finance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class SavingMigrationNoticeView extends FrameLayout {

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            AssetModuleConfig.a().l1(view.getContext());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public SavingMigrationNoticeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SavingMigrationNoticeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.layout_saving_migration_notice, this);
        findViewById(R$id.tv_view_more).setOnClickListener(new a());
    }
}
