package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class UnifyTransferGuide extends LinearLayout {
    private View mIvUnifyTransferGuide;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void guideClick();

        void historyClick();
    }

    public UnifyTransferGuide(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_unify_transfer_guide_title, this, true);
        findViewById(R.id.iv_unify_transfer_histroy).setOnClickListener(new o2(this));
        View findViewById = findViewById(R.id.iv_unify_transfer_guide);
        this.mIvUnifyTransferGuide = findViewById;
        findViewById.setOnClickListener(new n2(this));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$init$0(View view) {
        onItemClickListener onitemclicklistener = this.mListener;
        if (onitemclicklistener != null) {
            onitemclicklistener.historyClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$init$1(View view) {
        onItemClickListener onitemclicklistener = this.mListener;
        if (onitemclicklistener != null) {
            onitemclicklistener.guideClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setOnItemClickListener(onItemClickListener onitemclicklistener) {
        this.mListener = onitemclicklistener;
    }

    public void setTransferGuideVisible(boolean z11) {
        ViewUtil.m(this.mIvUnifyTransferGuide, z11);
    }

    public UnifyTransferGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public UnifyTransferGuide(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }

    public UnifyTransferGuide(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init();
    }
}
