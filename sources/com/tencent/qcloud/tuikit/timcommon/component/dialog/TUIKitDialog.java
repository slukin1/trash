package com.tencent.qcloud.tuikit.timcommon.component.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.method.MovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.lang.ref.WeakReference;

public class TUIKitDialog {
    public Dialog dialog;
    private float dialogWidth = 0.7f;
    private LinearLayout mBackgroundLayout;
    private Button mCancelButton;
    private TextView mContentTv;
    private Context mContext;
    private Display mDisplay;
    private ImageView mLineImg;
    private LinearLayout mMainLayout;
    private Button mSureButton;
    public TextView mTitleTv;
    private boolean showContent = false;
    private boolean showNegBtn = false;
    private boolean showPosBtn = false;
    private boolean showTitle = false;

    public static class TUIIMUpdateDialog {
        public static final String KEY_NEVER_SHOW = "neverShow";
        private String dialogFeatureName;
        private boolean isNeverShow;
        private boolean isShowOnlyDebug;
        private WeakReference<TUIKitDialog> tuiKitDialog;

        public static final class TUIIMUpdateDialogHolder {
            /* access modifiers changed from: private */
            public static final TUIIMUpdateDialog instance = new TUIIMUpdateDialog();

            private TUIIMUpdateDialogHolder() {
            }
        }

        private String getDialogFeatureName() {
            return this.dialogFeatureName;
        }

        public static TUIIMUpdateDialog getInstance() {
            return TUIIMUpdateDialogHolder.instance;
        }

        public TUIIMUpdateDialog createDialog(Context context) {
            WeakReference<TUIKitDialog> weakReference = new WeakReference<>(new TUIKitDialog(context));
            this.tuiKitDialog = weakReference;
            ((TUIKitDialog) weakReference.get()).builder();
            return this;
        }

        public void dismiss() {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                ((TUIKitDialog) this.tuiKitDialog.get()).dismiss();
            }
        }

        public TUIIMUpdateDialog setCancelOutside(boolean z11) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setCancelOutside(z11);
            }
            return this;
        }

        public TUIIMUpdateDialog setCancelable(boolean z11) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setCancelable(z11);
            }
            return this;
        }

        public TUIIMUpdateDialog setDialogFeatureName(String str) {
            this.dialogFeatureName = str;
            return this;
        }

        public TUIIMUpdateDialog setDialogWidth(float f11) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setDialogWidth(f11);
            }
            return this;
        }

        public TUIIMUpdateDialog setHighlightColor(int i11) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).mTitleTv.setHighlightColor(i11);
            }
            return this;
        }

        public TUIIMUpdateDialog setMovementMethod(MovementMethod movementMethod) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).mTitleTv.setMovementMethod(movementMethod);
            }
            return this;
        }

        public TUIIMUpdateDialog setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setNegativeButton(charSequence, onClickListener);
            }
            return this;
        }

        public void setNeverShow(boolean z11) {
            this.isNeverShow = z11;
            SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).put(getDialogFeatureName(), z11);
        }

        public TUIIMUpdateDialog setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setPositiveButton(charSequence, onClickListener);
            }
            return this;
        }

        public TUIIMUpdateDialog setShowOnlyDebug(boolean z11) {
            this.isShowOnlyDebug = z11;
            return this;
        }

        public TUIIMUpdateDialog setTitle(CharSequence charSequence) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((TUIKitDialog) this.tuiKitDialog.get()).setTitle(charSequence);
            }
            return this;
        }

        public void show() {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.isNeverShow = SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).getBoolean(getDialogFeatureName(), false);
                Dialog dialog = ((TUIKitDialog) this.tuiKitDialog.get()).dialog;
                if (dialog != null && !dialog.isShowing() && !this.isNeverShow && !this.isShowOnlyDebug) {
                    ((TUIKitDialog) this.tuiKitDialog.get()).show();
                }
            }
        }

        private TUIIMUpdateDialog() {
            this.isShowOnlyDebug = false;
            this.isNeverShow = SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).getBoolean(getDialogFeatureName(), false);
        }
    }

    public TUIKitDialog(Context context) {
        this.mContext = context;
        this.mDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void setLayout() {
        if (!this.showTitle) {
            this.mTitleTv.setVisibility(8);
        }
        if (this.showTitle) {
            this.mTitleTv.setVisibility(0);
        }
        if (this.showContent) {
            this.mContentTv.setVisibility(0);
        } else {
            this.mContentTv.setVisibility(8);
        }
        if (!this.showPosBtn && !this.showNegBtn) {
            this.mSureButton.setVisibility(8);
            this.mSureButton.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    TUIKitDialog.this.dialog.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
        if (this.showPosBtn && this.showNegBtn) {
            this.mSureButton.setVisibility(0);
            this.mCancelButton.setVisibility(0);
            this.mLineImg.setVisibility(0);
        }
        if (this.showPosBtn && !this.showNegBtn) {
            this.mSureButton.setVisibility(0);
        }
        if (!this.showPosBtn && this.showNegBtn) {
            this.mCancelButton.setVisibility(0);
        }
    }

    public TUIKitDialog builder() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.view_dialog, (ViewGroup) null);
        this.mBackgroundLayout = (LinearLayout) inflate.findViewById(R.id.ll_background);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_alert);
        this.mMainLayout = linearLayout;
        linearLayout.setVerticalGravity(8);
        this.mTitleTv = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        this.mContentTv = textView;
        textView.setVisibility(8);
        this.mTitleTv.setVisibility(8);
        Button button = (Button) inflate.findViewById(R.id.btn_neg);
        this.mCancelButton = button;
        button.setVisibility(8);
        Button button2 = (Button) inflate.findViewById(R.id.btn_pos);
        this.mSureButton = button2;
        button2.setVisibility(8);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_line);
        this.mLineImg = imageView;
        imageView.setVisibility(8);
        Dialog dialog2 = new Dialog(this.mContext, R.style.TUIKit_AlertDialogStyle);
        this.dialog = dialog2;
        dialog2.setContentView(inflate);
        this.mBackgroundLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.mDisplay.getWidth()) * this.dialogWidth), -2));
        return this;
    }

    public void dismiss() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public TextView getTxt_content() {
        return this.mContentTv;
    }

    public boolean isShowing() {
        Dialog dialog2 = this.dialog;
        return dialog2 != null && dialog2.isShowing();
    }

    public TUIKitDialog setCancelOutside(boolean z11) {
        this.dialog.setCanceledOnTouchOutside(z11);
        return this;
    }

    public TUIKitDialog setCancelable(boolean z11) {
        this.dialog.setCancelable(z11);
        return this;
    }

    public TUIKitDialog setContent(String str) {
        this.showContent = true;
        this.mContentTv.setText(str);
        return this;
    }

    public TUIKitDialog setDialogWidth(float f11) {
        LinearLayout linearLayout = this.mBackgroundLayout;
        if (linearLayout != null) {
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.mDisplay.getWidth()) * f11), -2));
        }
        this.dialogWidth = f11;
        return this;
    }

    public TUIKitDialog setNegativeButton(CharSequence charSequence, final View.OnClickListener onClickListener) {
        this.showNegBtn = true;
        this.mCancelButton.setText(charSequence);
        this.mCancelButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                onClickListener.onClick(view);
                TUIKitDialog.this.dialog.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        return this;
    }

    public TUIKitDialog setPositiveButton(CharSequence charSequence, final View.OnClickListener onClickListener) {
        this.showPosBtn = true;
        this.mSureButton.setText(charSequence);
        this.mSureButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                onClickListener.onClick(view);
                TUIKitDialog.this.dialog.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        return this;
    }

    public TUIKitDialog setTitle(CharSequence charSequence) {
        this.showTitle = true;
        this.mTitleTv.setText(charSequence);
        return this;
    }

    public void setTitleGravity(int i11) {
        this.mTitleTv.setGravity(i11);
    }

    public TUIKitDialog setTitleSize(float f11) {
        this.mTitleTv.setTextSize(2, f11);
        return this;
    }

    public void show() {
        setLayout();
        this.dialog.show();
    }

    public TUIKitDialog setNegativeButton(View.OnClickListener onClickListener) {
        setNegativeButton(TUIConfig.getAppContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), onClickListener);
        return this;
    }

    public TUIKitDialog setPositiveButton(View.OnClickListener onClickListener) {
        setPositiveButton(TUIConfig.getAppContext().getString(com.tencent.qcloud.tuicore.R.string.sure), onClickListener);
        return this;
    }
}
