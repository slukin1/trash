package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class PictureCommonDialog extends Dialog implements View.OnClickListener {
    private OnDialogEventListener eventListener;

    public interface OnDialogEventListener {
        void onConfirm();
    }

    public PictureCommonDialog(Context context, String str, String str2) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(R.layout.ps_common_dialog);
        ((TextView) findViewById(R.id.tvTitle)).setText(str);
        ((TextView) findViewById(R.id.tv_content)).setText(str2);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_commit)).setOnClickListener(this);
        setDialogSize();
    }

    private void setDialogSize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        getWindow().setWindowAnimations(R.style.PictureThemeDialogWindowStyle);
        getWindow().setAttributes(attributes);
    }

    public static PictureCommonDialog showDialog(Context context, String str, String str2) {
        PictureCommonDialog pictureCommonDialog = new PictureCommonDialog(context, str, str2);
        pictureCommonDialog.show();
        return pictureCommonDialog;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_cancel) {
            dismiss();
        } else if (id2 == R.id.btn_commit) {
            dismiss();
            OnDialogEventListener onDialogEventListener = this.eventListener;
            if (onDialogEventListener != null) {
                onDialogEventListener.onConfirm();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setOnDialogEventListener(OnDialogEventListener onDialogEventListener) {
        this.eventListener = onDialogEventListener;
    }
}
