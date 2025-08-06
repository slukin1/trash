package com.tencent.qcloud.tuikit.tuicallkit.view.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;

public class TUICallingSwitchAudioView extends RelativeLayout {
    /* access modifiers changed from: private */
    public final Context mContext;

    public TUICallingSwitchAudioView(Context context) {
        super(context);
        this.mContext = context.getApplicationContext();
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_switch_audio_view, this);
        ((LinearLayout) findViewById(R.id.ll_switch_audio)).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                new TUICallingAction(TUICallingSwitchAudioView.this.mContext).switchCallMediaType(TUICallDefine.MediaType.Audio);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }
}
