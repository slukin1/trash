package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;

class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES = {"00", "2", "4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, "8", CouponReturn.TYPE_EXPERIENCE, "12", "14", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN, "18", "20", "22"};
    private static final String[] HOUR_CLOCK_VALUES = {"12", "1", "2", "3", "4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "8", "9", CouponReturn.TYPE_EXPERIENCE, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP};
    private static final String[] MINUTE_CLOCK_VALUES = {"00", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, CouponReturn.TYPE_EXPERIENCE, "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    private boolean broadcasting = false;
    private float hourRotation;
    private float minuteRotation;
    private TimeModel time;
    private TimePickerView timePickerView;

    public TimePickerClockPresenter(TimePickerView timePickerView2, TimeModel timeModel) {
        this.timePickerView = timePickerView2;
        this.time = timeModel;
        initialize();
    }

    private int getDegreesPerHour() {
        return this.time.format == 1 ? 15 : 30;
    }

    private String[] getHourClockValues() {
        return this.time.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
    }

    private void performHapticFeedback(int i11, int i12) {
        TimeModel timeModel = this.time;
        if (timeModel.minute != i12 || timeModel.hour != i11) {
            this.timePickerView.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
        }
    }

    private void updateTime() {
        TimePickerView timePickerView2 = this.timePickerView;
        TimeModel timeModel = this.time;
        timePickerView2.updateTime(timeModel.period, timeModel.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(HOUR_CLOCK_24_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    public void initialize() {
        if (this.time.format == 0) {
            this.timePickerView.showToggle();
        }
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    public void invalidate() {
        this.hourRotation = (float) (this.time.getHourForDisplay() * getDegreesPerHour());
        TimeModel timeModel = this.time;
        this.minuteRotation = (float) (timeModel.minute * 6);
        setSelection(timeModel.selection, false);
        updateTime();
    }

    public void onActionUp(float f11, boolean z11) {
        this.broadcasting = true;
        TimeModel timeModel = this.time;
        int i11 = timeModel.minute;
        int i12 = timeModel.hour;
        if (timeModel.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                setSelection(12, true);
            }
        } else {
            int round = Math.round(f11);
            if (!z11) {
                this.time.setMinute(((round + 15) / 30) * 5);
                this.minuteRotation = (float) (this.time.minute * 6);
            }
            this.timePickerView.setHandRotation(this.minuteRotation, z11);
        }
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(i12, i11);
    }

    public void onPeriodChange(int i11) {
        this.time.setPeriod(i11);
    }

    public void onRotate(float f11, boolean z11) {
        if (!this.broadcasting) {
            TimeModel timeModel = this.time;
            int i11 = timeModel.hour;
            int i12 = timeModel.minute;
            int round = Math.round(f11);
            TimeModel timeModel2 = this.time;
            if (timeModel2.selection == 12) {
                timeModel2.setMinute((round + 3) / 6);
                this.minuteRotation = (float) Math.floor((double) (this.time.minute * 6));
            } else {
                this.time.setHour((round + (getDegreesPerHour() / 2)) / getDegreesPerHour());
                this.hourRotation = (float) (this.time.getHourForDisplay() * getDegreesPerHour());
            }
            if (!z11) {
                updateTime();
                performHapticFeedback(i11, i12);
            }
        }
    }

    public void onSelectionChanged(int i11) {
        setSelection(i11, true);
    }

    public void setSelection(int i11, boolean z11) {
        String[] strArr;
        boolean z12 = i11 == 12;
        this.timePickerView.setAnimateOnTouchUp(z12);
        this.time.selection = i11;
        TimePickerView timePickerView2 = this.timePickerView;
        if (z12) {
            strArr = MINUTE_CLOCK_VALUES;
        } else {
            strArr = getHourClockValues();
        }
        timePickerView2.setValues(strArr, z12 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.timePickerView.setHandRotation(z12 ? this.minuteRotation : this.hourRotation, z11);
        this.timePickerView.setActiveSelection(i11);
        this.timePickerView.setMinuteHourDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_hour_selection));
        this.timePickerView.setHourClickDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_minute_selection));
    }

    public void show() {
        this.timePickerView.setVisibility(0);
    }

    private void updateValues(String[] strArr, String str) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr[i11] = TimeModel.formatText(this.timePickerView.getResources(), strArr[i11], str);
        }
    }
}
