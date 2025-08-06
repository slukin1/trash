package com.huobi.view.pickerview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.huobi.view.pickerview.listener.CustomListener;
import com.huobi.view.pickerview.listener.OnTimeSelectChangeListener;
import com.huobi.view.pickerview.listener.OnTimeSelectListener;
import com.huobi.view.wheelview.WheelView;
import java.util.Calendar;

public class TimePickerBuilder {
    private PickerOptions mPickerOptions;

    public TimePickerBuilder(Context context, OnTimeSelectListener onTimeSelectListener) {
        PickerOptions pickerOptions = new PickerOptions(2);
        this.mPickerOptions = pickerOptions;
        pickerOptions.context = context;
        pickerOptions.timeSelectListener = onTimeSelectListener;
    }

    public TimePickerView build() {
        return new TimePickerView(this.mPickerOptions);
    }

    public TimePickerBuilder isCenterLabel(boolean z11) {
        this.mPickerOptions.isCenterLabel = z11;
        return this;
    }

    public TimePickerBuilder isCyclic(boolean z11) {
        this.mPickerOptions.cyclic = z11;
        return this;
    }

    public TimePickerBuilder isDialog(boolean z11) {
        this.mPickerOptions.isDialog = z11;
        return this;
    }

    public TimePickerBuilder setBackgroundId(int i11) {
        this.mPickerOptions.backgroundId = i11;
        return this;
    }

    public TimePickerBuilder setBgColor(int i11) {
        this.mPickerOptions.bgColorWheel = i11;
        return this;
    }

    public TimePickerBuilder setCancelColor(int i11) {
        this.mPickerOptions.textColorCancel = i11;
        return this;
    }

    public TimePickerBuilder setCancelText(String str) {
        this.mPickerOptions.textContentCancel = str;
        return this;
    }

    public TimePickerBuilder setContentTextSize(int i11) {
        this.mPickerOptions.textSizeContent = i11;
        return this;
    }

    public TimePickerBuilder setDate(Calendar calendar) {
        this.mPickerOptions.date = calendar;
        return this;
    }

    public TimePickerBuilder setDecorView(ViewGroup viewGroup) {
        this.mPickerOptions.decorView = viewGroup;
        return this;
    }

    public TimePickerBuilder setDividerColor(int i11) {
        this.mPickerOptions.dividerColor = i11;
        return this;
    }

    public TimePickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.mPickerOptions.dividerType = dividerType;
        return this;
    }

    public TimePickerBuilder setGravity(int[] iArr) {
        this.mPickerOptions.textGravity = iArr;
        return this;
    }

    public TimePickerBuilder setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
        PickerOptions pickerOptions = this.mPickerOptions;
        pickerOptions.label_year = str;
        pickerOptions.label_month = str2;
        pickerOptions.label_day = str3;
        pickerOptions.label_hours = str4;
        pickerOptions.label_minutes = str5;
        pickerOptions.label_seconds = str6;
        return this;
    }

    public TimePickerBuilder setLayoutRes(int i11, CustomListener customListener) {
        PickerOptions pickerOptions = this.mPickerOptions;
        pickerOptions.layoutRes = i11;
        pickerOptions.customListener = customListener;
        return this;
    }

    public TimePickerBuilder setLineSpacingMultiplier(float f11) {
        this.mPickerOptions.lineSpacingMultiplier = f11;
        return this;
    }

    public TimePickerBuilder setOutSideCancelable(boolean z11) {
        this.mPickerOptions.cancelable = z11;
        return this;
    }

    public TimePickerBuilder setRangDate(Calendar calendar, Calendar calendar2) {
        PickerOptions pickerOptions = this.mPickerOptions;
        pickerOptions.startDate = calendar;
        pickerOptions.endDate = calendar2;
        return this;
    }

    public TimePickerBuilder setSubCalSize(int i11) {
        this.mPickerOptions.textSizeSubmitCancel = i11;
        return this;
    }

    public TimePickerBuilder setSubmitColor(int i11) {
        this.mPickerOptions.textColorConfirm = i11;
        return this;
    }

    public TimePickerBuilder setSubmitText(String str) {
        this.mPickerOptions.textContentConfirm = str;
        return this;
    }

    public TimePickerBuilder setTextColorCenter(int i11) {
        this.mPickerOptions.textColorCenter = i11;
        return this;
    }

    public TimePickerBuilder setTextColorOut(int i11) {
        this.mPickerOptions.textColorOut = i11;
        return this;
    }

    public TimePickerBuilder setTextXOffset(int i11, int i12, int i13, int i14, int i15, int i16) {
        PickerOptions pickerOptions = this.mPickerOptions;
        pickerOptions.x_offset_year = i11;
        pickerOptions.x_offset_month = i12;
        pickerOptions.x_offset_day = i13;
        pickerOptions.x_offset_hours = i14;
        pickerOptions.x_offset_minutes = i15;
        pickerOptions.x_offset_seconds = i16;
        return this;
    }

    public TimePickerBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener onTimeSelectChangeListener) {
        this.mPickerOptions.timeSelectChangeListener = onTimeSelectChangeListener;
        return this;
    }

    public TimePickerBuilder setTitleBgColor(int i11) {
        this.mPickerOptions.bgColorTitle = i11;
        return this;
    }

    public TimePickerBuilder setTitleColor(int i11) {
        this.mPickerOptions.textColorTitle = i11;
        return this;
    }

    public TimePickerBuilder setTitleSize(int i11) {
        this.mPickerOptions.textSizeTitle = i11;
        return this;
    }

    public TimePickerBuilder setTitleText(String str) {
        this.mPickerOptions.textContentTitle = str;
        return this;
    }

    public TimePickerBuilder setType(boolean[] zArr) {
        this.mPickerOptions.type = zArr;
        return this;
    }

    public TimePickerBuilder setTypeface(Typeface typeface) {
        this.mPickerOptions.typeface = typeface;
        return this;
    }
}
