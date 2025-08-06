package com.tencent.qcloud.tuikit.timcommon.component;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.util.SoftKeyBoardUtil;
import java.util.regex.Pattern;

public class PopupInputCard {
    private View closeBtn;
    private TextView descriptionTv;
    /* access modifiers changed from: private */
    public EditText editText;
    private ByteLengthFilter lengthFilter = new ByteLengthFilter();
    /* access modifiers changed from: private */
    public int maxLimit = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public int minLimit = 0;
    /* access modifiers changed from: private */
    public String notMachRuleTip;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow;
    /* access modifiers changed from: private */
    public Button positiveBtn;
    /* access modifiers changed from: private */
    public OnClickListener positiveOnClickListener;
    /* access modifiers changed from: private */
    public String rule;
    /* access modifiers changed from: private */
    public OnTextExceedListener textExceedListener;
    private TextView titleTv;

    public class ByteLengthFilter implements InputFilter {
        private int length = Integer.MAX_VALUE;

        public ByteLengthFilter() {
        }

        private CharSequence getSource(CharSequence charSequence, int i11, int i12) {
            int length2 = charSequence.length();
            int i13 = 1;
            int i14 = 0;
            while (i13 <= length2 && charSequence.subSequence(0, i13).toString().getBytes().length <= i12) {
                i14 = i13;
                i13++;
            }
            if (i14 <= 0 || !Character.isHighSurrogate(charSequence.charAt(i14 - 1)) || i14 - 1 != i11) {
                return charSequence.subSequence(i11, i14);
            }
            return "";
        }

        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            int i15;
            int i16;
            int i17 = 0;
            if (!TextUtils.isEmpty(spanned)) {
                i16 = spanned.toString().getBytes().length;
                i15 = spanned.subSequence(i13, i14).toString().getBytes().length;
            } else {
                i15 = 0;
                i16 = 0;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                i17 = charSequence.subSequence(i11, i12).toString().getBytes().length;
            }
            int i18 = this.length - (i16 - i15);
            if (i18 <= 0) {
                if (PopupInputCard.this.textExceedListener == null) {
                    return "";
                }
                PopupInputCard.this.textExceedListener.onTextExceedMax();
                return "";
            } else if (i18 >= i17) {
                return null;
            } else {
                if (PopupInputCard.this.textExceedListener != null) {
                    PopupInputCard.this.textExceedListener.onTextExceedMax();
                }
                return getSource(charSequence, i11, i18);
            }
        }

        public void setLength(int i11) {
            this.length = i11;
        }
    }

    @FunctionalInterface
    public interface OnClickListener {
        void onClick(String str);
    }

    public interface OnTextExceedListener {
        void onTextExceedMax();
    }

    public PopupInputCard(final Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_popup_card, (ViewGroup) null);
        this.titleTv = (TextView) inflate.findViewById(R.id.popup_card_title);
        this.editText = (EditText) inflate.findViewById(R.id.popup_card_edit);
        this.descriptionTv = (TextView) inflate.findViewById(R.id.popup_card_description);
        this.positiveBtn = (Button) inflate.findViewById(R.id.popup_card_positive_btn);
        this.closeBtn = inflate.findViewById(R.id.close_btn);
        final Activity activity2 = activity;
        AnonymousClass1 r42 = new PopupWindow(inflate, -1, -2, true) {
            public void dismiss() {
                Activity activity = activity2;
                if (activity != null && !activity.isFinishing()) {
                    PopupInputCard.this.startAnimation(activity2.getWindow(), false);
                }
                super.dismiss();
            }

            public void showAtLocation(View view, int i11, int i12, int i13) {
                Activity activity = activity2;
                if (activity != null && !activity.isFinishing()) {
                    PopupInputCard.this.startAnimation(activity2.getWindow(), true);
                }
                PopupInputCard.this.editText.requestFocus();
                if (activity2.getWindow() != null) {
                    SoftKeyBoardUtil.showKeyBoard(activity2.getWindow());
                }
                super.showAtLocation(view, i11, i12, i13);
            }
        };
        this.popupWindow = r42;
        r42.setBackgroundDrawable(new ColorDrawable());
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setAnimationStyle(R.style.PopupInputCardAnim);
        this.popupWindow.setInputMethodMode(1);
        this.popupWindow.setSoftInputMode(16);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (activity.getWindow() != null) {
                    SoftKeyBoardUtil.hideKeyBoard(activity.getWindow());
                }
            }
        });
        this.positiveBtn.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                String obj = PopupInputCard.this.editText.getText().toString();
                if (obj.length() < PopupInputCard.this.minLimit || obj.length() > PopupInputCard.this.maxLimit) {
                    ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                } else if (TextUtils.isEmpty(PopupInputCard.this.rule) || Pattern.matches(PopupInputCard.this.rule, obj)) {
                    if (PopupInputCard.this.positiveOnClickListener != null) {
                        PopupInputCard.this.positiveOnClickListener.onClick(PopupInputCard.this.editText.getText().toString());
                    }
                    PopupInputCard.this.popupWindow.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                } else {
                    ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }
        });
        this.closeBtn.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PopupInputCard.this.popupWindow.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.editText.setFilters(new InputFilter[]{this.lengthFilter});
        this.editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(PopupInputCard.this.rule)) {
                    return;
                }
                if (!Pattern.matches(PopupInputCard.this.rule, editable.toString())) {
                    PopupInputCard.this.positiveBtn.setEnabled(false);
                } else {
                    PopupInputCard.this.positiveBtn.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void startAnimation(final Window window, boolean z11) {
        ValueAnimator valueAnimator;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z11) {
            valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
        } else {
            valueAnimator = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                window.setAttributes(attributes);
            }
        });
        valueAnimator.setDuration(200);
        valueAnimator.setInterpolator(linearInterpolator);
        valueAnimator.start();
    }

    public void setContent(String str) {
        this.editText.setText(str);
    }

    public void setDescription(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.descriptionTv.setVisibility(0);
            this.descriptionTv.setText(str);
        }
    }

    public void setMaxLimit(int i11) {
        this.maxLimit = i11;
        this.lengthFilter.setLength(i11);
    }

    public void setMinLimit(int i11) {
        this.minLimit = i11;
    }

    public void setNotMachRuleTip(String str) {
        this.notMachRuleTip = str;
    }

    public void setOnPositive(OnClickListener onClickListener) {
        this.positiveOnClickListener = onClickListener;
    }

    public void setRule(String str) {
        if (TextUtils.isEmpty(str)) {
            this.rule = "";
        } else {
            this.rule = str;
        }
    }

    public void setSingleLine(boolean z11) {
        this.editText.setSingleLine(z11);
    }

    public void setTextExceedListener(OnTextExceedListener onTextExceedListener) {
        this.textExceedListener = onTextExceedListener;
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void show(View view, int i11) {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(view, i11, 0, 0);
        }
    }
}
