package com.huobi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class CommonFingerprintDialog extends Dialog {
    private CommonDialogClickListener mCancelListener;
    private String mCancelText;
    private CommonDialogClickListener mConfirmListener;
    private TextView mDialogCancelBtn;
    private TextView mDialogMessageTv;
    private String mMessage;

    public interface CommonDialogClickListener {
        void onCommonDialogClick(Dialog dialog, int i11);
    }

    public CommonFingerprintDialog(Context context, int i11) {
        super(context, i11);
    }

    private void addEvent() {
        this.mDialogCancelBtn.setOnClickListener(new z(this));
    }

    private void initView() {
        this.mDialogMessageTv = (TextView) findViewById(R.id.dialog_message_tv);
        this.mDialogCancelBtn = (TextView) findViewById(R.id.dialog_cancel_tv);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        CommonDialogClickListener commonDialogClickListener = this.mCancelListener;
        if (commonDialogClickListener != null) {
            commonDialogClickListener.onCommonDialogClick(this, -2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void refreshView() {
        if (!TextUtils.isEmpty(this.mMessage)) {
            this.mDialogMessageTv.setText(this.mMessage);
        }
        if (!TextUtils.isEmpty(this.mCancelText)) {
            this.mDialogCancelBtn.setText(this.mCancelText);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_fingerprint_dialog);
        setCanceledOnTouchOutside(false);
        initView();
        addEvent();
    }

    public void setCancelListener(CommonDialogClickListener commonDialogClickListener) {
        this.mCancelListener = commonDialogClickListener;
    }

    public void setCancelText(String str) {
        this.mCancelText = str;
    }

    public void setConfirmListener(CommonDialogClickListener commonDialogClickListener) {
        this.mConfirmListener = commonDialogClickListener;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void show() {
        super.show();
        refreshView();
    }

    public CommonFingerprintDialog(Context context) {
        super(context, R.style.FingerprintDialogStyle);
    }

    public void setCancelText(int i11) {
        this.mCancelText = getContext().getString(i11);
    }

    public void setMessage(int i11) {
        this.mMessage = getContext().getString(i11);
    }
}
