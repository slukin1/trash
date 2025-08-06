package com.huobi.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class InputView extends ConstraintLayout implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener {
    public static final int INPUT_TYPE_ALL = 1000;
    public static final int INPUT_TYPE_FLOAT = 1002;
    public static final int INPUT_TYPE_INTEGER = 1001;
    public static final int INPUT_TYPE_LETTER = 1003;
    private static final String NUMBER_POINT = ".";
    private boolean clearEnable;
    private DecimalWatcher decimalWatcher;
    /* access modifiers changed from: private */
    public EditText editTextInput;
    private ImageView imageViewInputClear;
    private ImageView imageViewInputHelpIcon;
    private ImageView imageViewInputLabelTipIcon;
    private LinearLayout linearLayoutInputEditRowBox;
    private TextView textViewInputLabelHelp;
    private TextView textViewInputLabelTip;
    private TextView textViewInputOperationEndText;
    private TextView textViewInputOperationRight;
    private View viewHbUnable;
    private View viewInputOperationDividing;

    public class DecimalWatcher implements TextWatcher {
        private final int floatDecimal;
        private final int integerDecimal;
        private final int maxLength;

        public DecimalWatcher(int i11, int i12, int i13) {
            this.maxLength = i11 == 0 ? Integer.MAX_VALUE : i11;
            this.integerDecimal = i12 == 0 ? Integer.MAX_VALUE : i12;
            this.floatDecimal = i13 == 0 ? Integer.MAX_VALUE : i13;
        }

        private void numberLength(String str) {
            int length = str.length();
            if (length > this.maxLength) {
                InputView.this.editTextInput.setText(str.substring(0, length - 1));
            } else if (str.contains(".")) {
                int lastIndexOf = str.lastIndexOf(".");
                if (lastIndexOf != str.indexOf(".")) {
                    InputView.this.editTextInput.setText(str.substring(0, length - 1));
                } else if (length - (lastIndexOf + 1) > this.floatDecimal) {
                    InputView.this.editTextInput.setText(str.substring(0, length - 1));
                }
            } else if (length > this.integerDecimal) {
                InputView.this.editTextInput.setText(str.substring(0, length - 1));
            }
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                try {
                    InputView.this.editTextInput.setSelection(editable.toString().length());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (!TextUtils.isEmpty(charSequence)) {
                String replace = charSequence.toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".");
                if (charSequence.equals(".")) {
                    InputView.this.editTextInput.setText("0.");
                } else if (charSequence.equals("00")) {
                    InputView.this.editTextInput.setText("0");
                } else {
                    numberLength(replace);
                }
            }
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface INPUT_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public InputView(Context context) {
        super(context);
        initView(context, (AttributeSet) null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R$layout.widget_hb_input, this, true);
        this.editTextInput = (EditText) findViewById(R$id.edit_text_input);
        this.textViewInputLabelTip = (TextView) findViewById(R$id.text_view_input_label_tip);
        this.textViewInputOperationEndText = (TextView) findViewById(R$id.text_view_input_operation_end_text);
        this.textViewInputOperationRight = (TextView) findViewById(R$id.text_view_input_operation_right);
        this.viewInputOperationDividing = findViewById(R$id.view_hb_input_operation_dividing);
        this.textViewInputLabelHelp = (TextView) findViewById(R$id.text_view_input_label_help);
        this.imageViewInputHelpIcon = (ImageView) findViewById(R$id.image_view_input_help_icon);
        this.imageViewInputClear = (ImageView) findViewById(R$id.image_view_input_clear);
        this.linearLayoutInputEditRowBox = (LinearLayout) findViewById(R$id.linear_layout_input_edit_row_box);
        this.viewHbUnable = findViewById(R$id.view_input_unable);
        this.imageViewInputLabelTipIcon = (ImageView) findViewById(R$id.image_view_input_label_tip_icon);
        this.editTextInput.addTextChangedListener(this);
        this.editTextInput.setLongClickable(false);
        this.imageViewInputClear.setOnClickListener(this);
        this.editTextInput.setOnFocusChangeListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.InputView);
        setInputType(obtainStyledAttributes.getInt(R$styleable.InputView_inputType, 1001), obtainStyledAttributes.getIndex(R$styleable.InputView_textMaxLength), obtainStyledAttributes.getIndex(R$styleable.InputView_integerDecimal), obtainStyledAttributes.getIndex(R$styleable.InputView_floatDecimal));
        setTextViewInputLabelTipVisibility(obtainStyledAttributes.getInt(R$styleable.InputView_labelTipVisible, 8));
        setTextViewInputLabelHelpVisibility(obtainStyledAttributes.getInt(R$styleable.InputView_labelHelpVisible, 8));
        setImageViewInputHelpIconVisibility(obtainStyledAttributes.getInt(R$styleable.InputView_iconHelpVisible, 8));
        setTextViewInputOperationRightVisibility(obtainStyledAttributes.getInt(R$styleable.InputView_rightOperatorVisible, 8));
        setTextViewInputOperationEndTextVisibility(obtainStyledAttributes.getInt(R$styleable.InputView_endTextOperatorVisible, 8));
        setViewInputOperationDividingColor(obtainStyledAttributes.getColor(R$styleable.InputView_operatorDividingColor, getResources().getColor(R$color.baseColorPrimarySeparator)));
        setViewInputOperationDividingVisibility(obtainStyledAttributes.getColor(R$styleable.InputView_operatorDividingVisible, 8));
        int i11 = R$styleable.InputView_labelTipTextSize;
        Resources resources = getResources();
        int i12 = R$dimen.global_text_size_12;
        setTextViewInputLabelTipTextSize(obtainStyledAttributes.getDimension(i11, resources.getDimension(i12)));
        setTextViewInputLabelHelpTextSize(obtainStyledAttributes.getDimension(R$styleable.InputView_labelHelpTextSize, getResources().getDimension(i12)));
        setInputTextSizePx(obtainStyledAttributes.getDimension(R$styleable.InputView_inputTextSize, getResources().getDimension(R$dimen.global_text_size_16)));
        int i13 = R$styleable.InputView_endTextOperatorTextSize;
        Resources resources2 = getResources();
        int i14 = R$dimen.global_text_size_14;
        setEndTextOperatorTextSize(obtainStyledAttributes.getDimension(i13, resources2.getDimension(i14)));
        setRightOperatorTextSize(obtainStyledAttributes.getDimension(R$styleable.InputView_rightOperatorTextSize, getResources().getDimension(i14)));
        setRightOperatorTextColor(obtainStyledAttributes.getColorStateList(R$styleable.InputView_rightOperatorTextColor));
        setEndTextOperatorTextColor(obtainStyledAttributes.getColorStateList(R$styleable.InputView_endTextOperatorTextColor));
        setInputTextColor(obtainStyledAttributes.getColorStateList(R$styleable.InputView_inputTextColor));
        setLabelTipTextColor(obtainStyledAttributes.getColorStateList(R$styleable.InputView_labelTipTextColor));
        setLabelHelpTextColor(obtainStyledAttributes.getColorStateList(R$styleable.InputView_labelHelpTextColor));
        setLabelHelpText(obtainStyledAttributes.getString(R$styleable.InputView_labelHelpText));
        setEndTextOperatorIcon(obtainStyledAttributes.getResourceId(R$styleable.InputView_endTextOperatorIcon, 0));
        setRightOperatorIcon(obtainStyledAttributes.getResourceId(R$styleable.InputView_rightOperatorIcon, 0));
        setClearIcon(obtainStyledAttributes.getResourceId(R$styleable.InputView_clearTextIcon, R$drawable.btn_clear_input));
        setHelpIcon(obtainStyledAttributes.getResourceId(R$styleable.InputView_labelHelpIcon, 0));
        setClearEnable(obtainStyledAttributes.getBoolean(R$styleable.InputView_clearEnable, true));
        setRightOperatorText(obtainStyledAttributes.getString(R$styleable.InputView_rightOperatorText));
        setEndTextOperatorText(obtainStyledAttributes.getString(R$styleable.InputView_endTextOperatorText));
        setLabelTipText(obtainStyledAttributes.getString(R$styleable.InputView_labelTipText));
        setInputText(obtainStyledAttributes.getString(R$styleable.InputView_inputText));
        setInputHintText(obtainStyledAttributes.getString(R$styleable.InputView_inputHint));
        setInputHintTextColor(obtainStyledAttributes.getColor(R$styleable.InputView_inputHintTextColor, getResources().getColor(R$color.baseColorThreeLevelText)));
        setInputEnable(obtainStyledAttributes.getBoolean(R$styleable.InputView_inputEnable, true));
        setInputStyle(obtainStyledAttributes.getInt(R$styleable.InputView_inputStyle, 1));
        setInputLongClickEnable(obtainStyledAttributes.getBoolean(R$styleable.InputView_inputLongClickEnable, false));
        setLabelTipIconVisible(obtainStyledAttributes.getIndex(R$styleable.InputView_labelTipIconVisible));
        setLabelTipIcon(obtainStyledAttributes.getResourceId(R$styleable.InputView_labelTipIcon, 0));
        setInputHeight(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.InputView_inputRowHeight, getResources().getDimensionPixelOffset(R$dimen.dimen_35)));
        obtainStyledAttributes.recycle();
    }

    private void setClearEnable(boolean z11) {
        this.clearEnable = z11;
    }

    private void setClearIcon(int i11) {
        this.imageViewInputClear.setImageResource(i11);
    }

    private void setEndTextOperatorIcon(int i11) {
        setTextViewIcon(i11, this.textViewInputOperationEndText);
    }

    private void setEndTextOperatorTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.textViewInputOperationEndText.setTextColor(colorStateList);
        } else {
            this.textViewInputOperationEndText.setTextColor(getResources().getColor(R$color.baseColorSecondaryIconButton));
        }
    }

    private void setEndTextOperatorTextSize(float f11) {
        this.textViewInputOperationEndText.setTextSize(0, f11);
    }

    private void setHelpIcon(int i11) {
        this.imageViewInputHelpIcon.setImageResource(i11);
        if (i11 != 0) {
            this.imageViewInputHelpIcon.setVisibility(0);
        }
    }

    private void setInputEnable(boolean z11) {
        this.viewHbUnable.setVisibility(z11 ? 8 : 0);
        this.editTextInput.setEnabled(z11);
        this.editTextInput.setClickable(z11);
    }

    private void setInputHeight(int i11) {
        ViewGroup.LayoutParams layoutParams = this.editTextInput.getLayoutParams();
        layoutParams.height = i11;
        this.editTextInput.setLayoutParams(layoutParams);
    }

    private void setInputHintText(String str) {
        this.editTextInput.setHint(str);
    }

    private void setInputHintTextColor(int i11) {
        this.editTextInput.setHintTextColor(i11);
    }

    private void setInputStyle(int i11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.textViewInputLabelTip.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.textViewInputLabelHelp.getLayoutParams();
        if (i11 == 0) {
            Resources resources = getResources();
            int i12 = R$dimen.dimen_14;
            layoutParams.bottomMargin = resources.getDimensionPixelSize(i12);
            layoutParams2.topMargin = getResources().getDimensionPixelSize(i12);
            this.linearLayoutInputEditRowBox.setBackgroundResource(R$drawable.selector_input_background_line_under);
        } else {
            Resources resources2 = getResources();
            int i13 = R$dimen.dimen_14;
            layoutParams.bottomMargin = resources2.getDimensionPixelSize(i13);
            layoutParams2.topMargin = getResources().getDimensionPixelSize(i13);
            this.linearLayoutInputEditRowBox.setBackgroundResource(R$drawable.selector_input_background_line_frame);
        }
        this.textViewInputLabelTip.setLayoutParams(layoutParams);
        this.textViewInputLabelHelp.setLayoutParams(layoutParams2);
    }

    private void setInputTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.editTextInput.setTextColor(colorStateList);
        } else {
            this.editTextInput.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        }
    }

    private void setLabelHelpTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.textViewInputLabelTip.setTextColor(colorStateList);
        } else {
            this.textViewInputLabelHelp.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
        }
    }

    private void setLabelTipIcon(int i11) {
        this.imageViewInputLabelTipIcon.setImageResource(i11);
        if (i11 != 0) {
            this.imageViewInputLabelTipIcon.setVisibility(0);
        }
    }

    private void setLabelTipIconVisible(int i11) {
        this.imageViewInputLabelTipIcon.setVisibility(i11);
    }

    private void setLabelTipText(String str) {
        this.textViewInputLabelTip.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.textViewInputLabelTip.setVisibility(0);
        }
    }

    private void setLabelTipTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.textViewInputLabelTip.setTextColor(colorStateList);
        } else {
            this.textViewInputLabelTip.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
        }
    }

    private void setRightOperatorIcon(int i11) {
        setTextViewIcon(i11, this.textViewInputOperationRight);
    }

    private void setRightOperatorTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.textViewInputOperationRight.setTextColor(colorStateList);
        } else {
            this.textViewInputOperationRight.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        }
    }

    private void setRightOperatorTextSize(float f11) {
        this.textViewInputOperationRight.setTextSize(0, f11);
    }

    private void setTextViewIcon(int i11, TextView textView) {
        if (i11 != 0) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), i11);
            if (drawable != null) {
                drawable.setBounds(new Rect(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()));
            }
            textView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setText("");
            textView.setVisibility(0);
        }
    }

    private void setTextViewInputLabelHelpTextSize(float f11) {
        this.textViewInputLabelHelp.setTextSize(0, f11);
    }

    private void setTextViewInputLabelTipTextSize(float f11) {
        this.textViewInputLabelTip.setTextSize(0, f11);
    }

    public void addEditTextListener(TextWatcher textWatcher) {
        this.editTextInput.addTextChangedListener(textWatcher);
    }

    public void afterTextChanged(Editable editable) {
        if (editable == null || TextUtils.isEmpty(editable)) {
            if (this.clearEnable && this.imageViewInputClear.getVisibility() == 0) {
                this.imageViewInputClear.setVisibility(8);
            }
        } else if (this.clearEnable && this.imageViewInputClear.getVisibility() == 8) {
            this.imageViewInputClear.setVisibility(0);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void cancelFocus() {
        this.editTextInput.clearFocus();
    }

    public EditText getEditTextInput() {
        return this.editTextInput;
    }

    public String getInputText() {
        Editable editableText = this.editTextInput.getEditableText();
        if (editableText != null) {
            return editableText.toString();
        }
        return null;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        EditText editText = this.editTextInput;
        if (editText != null) {
            editText.setText("");
            if (this.clearEnable && this.imageViewInputClear.getVisibility() == 0) {
                this.imageViewInputClear.setVisibility(8);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onFocusChange(View view, boolean z11) {
        this.linearLayoutInputEditRowBox.setSelected(z11);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void setEndTextOperatorText(String str) {
        this.textViewInputOperationEndText.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.textViewInputOperationEndText.setVisibility(0);
        }
    }

    public void setImageViewInputHelpIconOnClickListener(View.OnClickListener onClickListener) {
        this.imageViewInputHelpIcon.setOnClickListener(onClickListener);
    }

    public void setImageViewInputHelpIconVisibility(int i11) {
        this.imageViewInputHelpIcon.setVisibility(i11);
    }

    public void setInputLongClickEnable(boolean z11) {
        this.editTextInput.setLongClickable(z11);
    }

    public void setInputText(String str) {
        this.editTextInput.setText(str);
    }

    public void setInputTextSizeDp(float f11) {
        this.editTextInput.setTextSize(1, f11);
        this.viewInputOperationDividing.setMinimumHeight((int) this.editTextInput.getTextSize());
    }

    public void setInputTextSizePx(float f11) {
        this.editTextInput.setTextSize(0, f11);
        this.viewInputOperationDividing.setMinimumHeight((int) (((double) f11) + 0.5d));
    }

    public void setInputType(int i11, int i12, int i13, int i14) {
        if (i11 != 0) {
            setTextMaxLength(i11);
        }
        switch (i14) {
            case 1001:
                this.editTextInput.setInputType(2);
                this.editTextInput.addTextChangedListener(new DecimalWatcher(-1, -1, 0));
                this.editTextInput.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                return;
            case 1002:
                this.editTextInput.setInputType(8192);
                DecimalWatcher decimalWatcher2 = this.decimalWatcher;
                if (decimalWatcher2 != null) {
                    this.editTextInput.removeTextChangedListener(decimalWatcher2);
                }
                DecimalWatcher decimalWatcher3 = new DecimalWatcher(i11, i12, i13);
                this.decimalWatcher = decimalWatcher3;
                this.editTextInput.addTextChangedListener(decimalWatcher3);
                this.editTextInput.setKeyListener(DigitsKeyListener.getInstance("0123456789.,"));
                return;
            case 1003:
                this.editTextInput.setKeyListener(DigitsKeyListener.getInstance("abcdefghigklmnopqrstuvwxyz0123456789"));
                return;
            default:
                return;
        }
    }

    public void setLabelHelpText(CharSequence charSequence) {
        this.textViewInputLabelHelp.setText(charSequence);
        if (!TextUtils.isEmpty(charSequence)) {
            this.textViewInputLabelHelp.setVisibility(0);
        }
    }

    public void setRightOperatorText(String str) {
        this.textViewInputOperationRight.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.textViewInputOperationRight.setVisibility(0);
        }
    }

    public void setTextMaxLength(int i11) {
        this.editTextInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11) {
        }});
    }

    public void setTextViewInputLabelHelpVisibility(int i11) {
        this.textViewInputLabelHelp.setVisibility(i11);
    }

    public void setTextViewInputLabelTipVisibility(int i11) {
        this.textViewInputLabelTip.setVisibility(i11);
    }

    public void setTextViewInputOperationEndTextOnClickListener(View.OnClickListener onClickListener) {
        this.textViewInputOperationEndText.setOnClickListener(onClickListener);
    }

    public void setTextViewInputOperationEndTextVisibility(int i11) {
        this.textViewInputOperationEndText.setVisibility(i11);
    }

    public void setTextViewInputOperationRightOnClickListener(View.OnClickListener onClickListener) {
        this.textViewInputOperationRight.setOnClickListener(onClickListener);
    }

    public void setTextViewInputOperationRightVisibility(int i11) {
        this.textViewInputOperationRight.setVisibility(i11);
    }

    public void setViewInputOperationDividingColor(int i11) {
        this.viewInputOperationDividing.setBackgroundColor(i11);
    }

    public void setViewInputOperationDividingVisibility(int i11) {
        this.viewInputOperationDividing.setVisibility(i11);
    }

    public void setInputText(int i11) {
        this.editTextInput.setText(i11);
    }

    public InputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public InputView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet);
    }
}
