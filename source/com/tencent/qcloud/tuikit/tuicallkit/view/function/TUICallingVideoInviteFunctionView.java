package com.tencent.qcloud.tuikit.tuicallkit.view.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;

public class TUICallingVideoInviteFunctionView extends BaseFunctionView {
    private ImageView mImageSwitchCamera;
    private LinearLayout mLayoutCancel;

    public TUICallingVideoInviteFunctionView(Context context) {
        super(context);
        initView();
        initClickListener();
    }

    private void initClickListener() {
        this.mLayoutCancel.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICallingVideoInviteFunctionView.this.mCallingAction.hangup((TUICommonDefine.Callback) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mImageSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICommonDefine.Camera frontCamera = TUICallingStatusManager.sharedInstance(TUICallingVideoInviteFunctionView.this.mContext).getFrontCamera();
                TUICallingAction tUICallingAction = TUICallingVideoInviteFunctionView.this.mCallingAction;
                TUICommonDefine.Camera camera = TUICommonDefine.Camera.Front;
                if (camera.equals(frontCamera)) {
                    camera = TUICommonDefine.Camera.Back;
                }
                tUICallingAction.switchCamera(camera);
                ToastUtil.toastShortMessage(TUICallingVideoInviteFunctionView.this.mContext.getString(R.string.tuicalling_toast_switch_camera));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_funcation_view_video_inviting, this);
        this.mLayoutCancel = (LinearLayout) findViewById(R.id.ll_cancel);
        this.mImageSwitchCamera = (ImageView) findViewById(R.id.img_switch_camera);
    }
}
