package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    /* access modifiers changed from: private */
    public OnDoubleTapListener onDoubleTapListener;
    /* access modifiers changed from: private */
    public OnPeriodChangeListener onPeriodChangeListener;
    /* access modifiers changed from: private */
    public OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int i11);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int i11);
    }

    public TimePickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setUpDisplay() {
        Chip chip = this.minuteView;
        int i11 = R.id.selection_type;
        chip.setTag(i11, 12);
        this.hourView.setTag(i11, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                if (TimePickerView.this.onDoubleTapListener != null) {
                    TimePickerView.this.onDoubleTapListener.onDoubleTap();
                }
                return onDoubleTap;
            }
        });
        AnonymousClass4 r12 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(r12);
        this.hourView.setOnTouchListener(r12);
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.p(this);
            int i11 = 1;
            if (h0.F(this) == 0) {
                i11 = 2;
            }
            constraintSet.n(R.id.material_clock_display, i11);
            constraintSet.i(this);
        }
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (view == this && i11 == 0) {
            updateToggleConstraints();
        }
    }

    public void setActiveSelection(int i11) {
        boolean z11 = true;
        this.minuteView.setChecked(i11 == 12);
        Chip chip = this.hourView;
        if (i11 != 10) {
            z11 = false;
        }
        chip.setChecked(z11);
    }

    public void setAnimateOnTouchUp(boolean z11) {
        this.clockHandView.setAnimateOnTouchUp(z11);
    }

    public void setHandRotation(float f11) {
        this.clockHandView.setHandRotation(f11);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        h0.x0(this.minuteView, accessibilityDelegateCompat);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        h0.x0(this.hourView, accessibilityDelegateCompat);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener2) {
        this.onDoubleTapListener = onDoubleTapListener2;
    }

    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener2) {
        this.onPeriodChangeListener = onPeriodChangeListener2;
    }

    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    public void setValues(String[] strArr, int i11) {
        this.clockFace.setValues(strArr, i11);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTime(int i11, int i12, int i13) {
        this.toggle.check(i11 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i13)});
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i12)});
        this.minuteView.setText(format);
        this.hourView.setText(format2);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHandRotation(float f11, boolean z11) {
        this.clockHandView.setHandRotation(f11, z11);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.selectionListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z11) {
                int i12 = i11 == R.id.material_clock_period_pm_button ? 1 : 0;
                if (TimePickerView.this.onPeriodChangeListener != null && z11) {
                    TimePickerView.this.onPeriodChangeListener.onPeriodChange(i12);
                }
            }
        });
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }
}
