package com.huobi.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.input.ClearEditText;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class CommonCaptchaDialog extends Dialog {
    private View divider;
    private String imageData;
    private boolean isSingButton;
    private CommonDialogClickListener mCancelListener;
    private String mCancelText;
    private int mConfirmBtnColor;
    private CommonDialogClickListener mConfirmListener;
    private String mConfirmText;
    private View mDialogBtnDivider;
    private Button mDialogCancelBtn;
    private Button mDialogConfirmBtn;
    private TextView mDialogMessageTv;
    private TextView mDialogTitleTv;
    private ClearEditText mEditText;
    private ImageView mImageView;
    private String mMessage;
    private String mTitle;

    public interface CommonDialogClickListener {
        void onCommonDialogClick(Dialog dialog, int i11);
    }

    public CommonCaptchaDialog(Context context, int i11) {
        super(context, i11);
    }

    private void addEvent() {
        this.mDialogCancelBtn.setOnClickListener(new w(this));
        this.mDialogConfirmBtn.setOnClickListener(new x(this));
        this.mEditText.setOnFocusChangeListener(new y(this));
    }

    private void initView() {
        this.mDialogTitleTv = (TextView) findViewById(R$id.dialog_title_tv);
        this.mDialogConfirmBtn = (Button) findViewById(R$id.dialog_confirm_btn);
        this.mDialogCancelBtn = (Button) findViewById(R$id.dialog_cancel_btn);
        this.mEditText = (ClearEditText) findViewById(R$id.captcha_edit);
        this.mImageView = (ImageView) findViewById(R$id.captcha_input_image);
        this.divider = findViewById(R$id.divider1);
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

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        CommonDialogClickListener commonDialogClickListener = this.mConfirmListener;
        if (commonDialogClickListener != null) {
            commonDialogClickListener.onCommonDialogClick(this, -1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addEvent$2(View view, boolean z11) {
        if (z11) {
            this.divider.setBackgroundColor(getContext().getResources().getColor(R$color.global_button_end_color));
        } else {
            this.divider.setBackgroundColor(getContext().getResources().getColor(R$color.global_divider_color));
        }
    }

    private void refreshView() {
        if (TextUtils.isEmpty(this.mTitle)) {
            this.mDialogTitleTv.setVisibility(8);
        } else {
            this.mDialogTitleTv.setVisibility(0);
            this.mDialogTitleTv.setText(this.mTitle);
        }
        if (!TextUtils.isEmpty(this.mMessage)) {
            this.mDialogMessageTv.setText(this.mMessage);
        }
        if (!TextUtils.isEmpty(this.mCancelText)) {
            this.mDialogCancelBtn.setText(this.mCancelText);
        }
        if (!TextUtils.isEmpty(this.mConfirmText)) {
            this.mDialogConfirmBtn.setText(this.mConfirmText);
        }
        int i11 = this.mConfirmBtnColor;
        if (i11 != 0) {
            this.mDialogConfirmBtn.setTextColor(i11);
        }
        if (this.isSingButton) {
            this.mDialogCancelBtn.setVisibility(8);
        } else {
            this.mDialogCancelBtn.setVisibility(0);
        }
        this.mImageView.setImageBitmap(stringToBitmap(this.imageData));
    }

    public EditText getCaptchaEdit() {
        return this.mEditText;
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public Button getRightBtn() {
        return this.mDialogConfirmBtn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_common_captcha_dialog);
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

    public void setCaptchaImage(String str) {
        this.imageData = str;
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageBitmap(stringToBitmap(str));
        }
    }

    public void setConfirmBtnColor(int i11) {
        this.mConfirmBtnColor = i11;
    }

    public void setConfirmListner(CommonDialogClickListener commonDialogClickListener) {
        this.mConfirmListener = commonDialogClickListener;
    }

    public void setConfirmText(String str) {
        this.mConfirmText = str;
    }

    public void setIsSingleButton(boolean z11) {
        this.isSingButton = z11;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void show() {
        super.show();
        refreshView();
    }

    public Bitmap stringToBitmap(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public CommonCaptchaDialog(Context context) {
        super(context, R$style.CustomDialog_DayTheme);
    }

    public void setCancelText(int i11) {
        this.mCancelText = getContext().getString(i11);
    }

    public void setConfirmText(int i11) {
        this.mConfirmText = getContext().getString(i11);
    }

    public void setMessage(int i11) {
        this.mMessage = getContext().getString(i11);
    }

    public void setTitle(int i11) {
        this.mTitle = getContext().getString(i11);
    }
}
