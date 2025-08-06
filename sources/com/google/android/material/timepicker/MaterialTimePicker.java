package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    public static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    public static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    public static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    public static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    public static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private TimePickerPresenter activePresenter;
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    /* access modifiers changed from: private */
    public int inputMode = 0;
    private int keyboardIcon;
    /* access modifiers changed from: private */
    public MaterialButton modeButton;
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private int overrideThemeResId = 0;
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private ViewStub textInputStub;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    /* access modifiers changed from: private */
    public TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId = 0;
    private String titleText;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int inputMode;
        /* access modifiers changed from: private */
        public int overrideThemeResId = 0;
        /* access modifiers changed from: private */
        public TimeModel time = new TimeModel();
        /* access modifiers changed from: private */
        public CharSequence titleText;
        /* access modifiers changed from: private */
        public int titleTextResId = 0;

        public MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }

        public Builder setHour(int i11) {
            this.time.setHourOfDay(i11);
            return this;
        }

        public Builder setInputMode(int i11) {
            this.inputMode = i11;
            return this;
        }

        public Builder setMinute(int i11) {
            this.time.setMinute(i11);
            return this;
        }

        public Builder setTheme(int i11) {
            this.overrideThemeResId = i11;
            return this;
        }

        public Builder setTimeFormat(int i11) {
            TimeModel timeModel = this.time;
            int i12 = timeModel.hour;
            int i13 = timeModel.minute;
            TimeModel timeModel2 = new TimeModel(i11);
            this.time = timeModel2;
            timeModel2.setMinute(i13);
            this.time.setHourOfDay(i12);
            return this;
        }

        public Builder setTitleText(int i11) {
            this.titleTextResId = i11;
            return this;
        }

        public Builder setTitleText(CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }
    }

    private Pair<Integer, Integer> dataForMode(int i11) {
        if (i11 == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i11 == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i11);
    }

    private int getThemeResId() {
        int i11 = this.overrideThemeResId;
        if (i11 != 0) {
            return i11;
        }
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int i11) {
        if (i11 == 0) {
            TimePickerClockPresenter timePickerClockPresenter2 = this.timePickerClockPresenter;
            if (timePickerClockPresenter2 == null) {
                timePickerClockPresenter2 = new TimePickerClockPresenter(this.timePickerView, this.time);
            }
            this.timePickerClockPresenter = timePickerClockPresenter2;
            return timePickerClockPresenter2;
        }
        if (this.timePickerTextInputPresenter == null) {
            this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) this.textInputStub.inflate(), this.time);
        }
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    /* access modifiers changed from: private */
    public static MaterialTimePicker newInstance(Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, builder.time);
        bundle.putInt(INPUT_MODE_EXTRA, builder.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, builder.titleTextResId);
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        if (builder.titleText != null) {
            bundle.putString(TITLE_TEXT_EXTRA, builder.titleText.toString());
        }
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void restoreState(Bundle bundle) {
        if (bundle != null) {
            TimeModel timeModel = (TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
            this.time = timeModel;
            if (timeModel == null) {
                this.time = new TimeModel();
            }
            this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, 0);
            this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
            this.titleText = bundle.getString(TITLE_TEXT_EXTRA);
            this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID, 0);
        }
    }

    /* access modifiers changed from: private */
    public void updateInputMode(MaterialButton materialButton) {
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            timePickerPresenter.hide();
        }
        TimePickerPresenter initializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = initializeOrRetrieveActivePresenterForMode;
        initializeOrRetrieveActivePresenterForMode.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> dataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((Integer) dataForMode.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) dataForMode.second).intValue()));
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    public int getMinute() {
        return this.time.minute;
    }

    public TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancel : this.cancelListeners) {
            onCancel.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId());
        Context context = dialog.getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i11 = R.attr.materialTimePickerStyle;
        int i12 = R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, (AttributeSet) null, i11, i12);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MaterialTimePicker, i11, i12);
        this.clockIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView2 = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.timePickerView = timePickerView2;
        timePickerView2.setOnDoubleTapListener(new TimePickerView.OnDoubleTapListener() {
            public void onDoubleTap() {
                int unused = MaterialTimePicker.this.inputMode = 1;
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.updateInputMode(materialTimePicker.modeButton);
                MaterialTimePicker.this.timePickerTextInputPresenter.resetChecked();
            }
        });
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        int i11 = this.titleResId;
        if (i11 != 0) {
            textView.setText(i11);
        }
        updateInputMode(this.modeButton);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.positiveButtonListeners) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.negativeButtonListeners) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        this.modeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                int unused = materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
            }
        });
        return viewGroup2;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismiss : this.dismissListeners) {
            onDismiss.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putString(TITLE_TEXT_EXTRA, this.titleText);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    public void onStop() {
        super.onStop();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        this.timePickerView = null;
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }
}
