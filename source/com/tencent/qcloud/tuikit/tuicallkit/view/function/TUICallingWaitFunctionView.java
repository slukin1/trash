package com.tencent.qcloud.tuikit.tuicallkit.view.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;

public class TUICallingWaitFunctionView extends BaseFunctionView {
    private LinearLayout mLayoutDialing;
    private LinearLayout mLayoutReject;
    private TextView mTextDialing;
    private TextView mTextReject;

    public TUICallingWaitFunctionView(Context context) {
        super(context);
        initView();
        initListener();
    }

    private void initListener() {
        this.mLayoutReject.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICallingWaitFunctionView.this.mCallingAction.reject((TUICommonDefine.Callback) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutDialing.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICallingWaitFunctionView.this.mCallingAction.accept((TUICommonDefine.Callback) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_funcation_view_audio_waiting, this);
        this.mLayoutReject = (LinearLayout) findViewById(R.id.ll_decline);
        this.mLayoutDialing = (LinearLayout) findViewById(R.id.ll_answer);
        this.mTextReject = (TextView) findViewById(R.id.tv_reject);
        this.mTextDialing = (TextView) findViewById(R.id.tv_dialing);
    }

    public void updateTextColor(int i11) {
        this.mTextReject.setTextColor(i11);
        this.mTextDialing.setTextColor(i11);
    }
}
