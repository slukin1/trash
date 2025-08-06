package com.huobi.view.pickerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huobi.view.pickerview.listener.CustomListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import pro.huobi.R;

public class TimePickerView extends BasePickerView implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private WheelTime wheelTime;

    public TimePickerView(PickerOptions pickerOptions) {
        super(pickerOptions.context);
        this.mPickerOptions = pickerOptions;
        initView(pickerOptions.context);
    }

    private void initDefaultSelectedDate() {
        PickerOptions pickerOptions = this.mPickerOptions;
        Calendar calendar = pickerOptions.startDate;
        if (calendar != null && pickerOptions.endDate != null) {
            Calendar calendar2 = pickerOptions.date;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.mPickerOptions.startDate.getTimeInMillis() || this.mPickerOptions.date.getTimeInMillis() > this.mPickerOptions.endDate.getTimeInMillis()) {
                PickerOptions pickerOptions2 = this.mPickerOptions;
                pickerOptions2.date = pickerOptions2.startDate;
            }
        } else if (calendar != null) {
            pickerOptions.date = calendar;
        } else {
            Calendar calendar3 = pickerOptions.endDate;
            if (calendar3 != null) {
                pickerOptions.date = calendar3;
            }
        }
    }

    private void initView(Context context) {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        CustomListener customListener = this.mPickerOptions.customListener;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(R.layout.layout_pickerview_time, this.contentContainer);
            TextView textView = (TextView) findViewById(R.id.id_picker_view_title_text);
            View findViewById = findViewById(R.id.id_picker_view_title_layout);
            TextView textView2 = (TextView) findViewById(R.id.id_picker_view_title_btn_right);
            TextView textView3 = (TextView) findViewById(R.id.id_picker_view_title_btn_left);
            textView2.setTag(TAG_SUBMIT);
            textView3.setTag(TAG_CANCEL);
            textView2.setOnClickListener(this);
            textView3.setOnClickListener(this);
            textView2.setText(this.mPickerOptions.textContentConfirm);
            textView3.setText(this.mPickerOptions.textContentCancel);
            textView.setText(this.mPickerOptions.textContentTitle);
            textView2.setTextColor(this.mPickerOptions.textColorConfirm);
            textView3.setTextColor(this.mPickerOptions.textColorCancel);
            textView.setTextColor(this.mPickerOptions.textColorTitle);
            findViewById.setBackgroundColor(this.mPickerOptions.bgColorTitle);
            textView2.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            textView3.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            textView.setTextSize((float) this.mPickerOptions.textSizeTitle);
        } else {
            customListener.customLayout(LayoutInflater.from(context).inflate(this.mPickerOptions.layoutRes, this.contentContainer));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.mPickerOptions.bgColorWheel);
        initWheelTime(linearLayout);
    }

    private void initWheelTime(LinearLayout linearLayout) {
        int i11;
        PickerOptions pickerOptions = this.mPickerOptions;
        WheelTime wheelTime2 = new WheelTime(linearLayout, pickerOptions.type, pickerOptions.textGravity, pickerOptions.textSizeContent);
        this.wheelTime = wheelTime2;
        if (this.mPickerOptions.timeSelectChangeListener != null) {
            wheelTime2.setSelectChangeCallback(new f(this));
        }
        PickerOptions pickerOptions2 = this.mPickerOptions;
        int i12 = pickerOptions2.startYear;
        if (!(i12 == 0 || (i11 = pickerOptions2.endYear) == 0 || i12 > i11)) {
            setRange();
        }
        PickerOptions pickerOptions3 = this.mPickerOptions;
        Calendar calendar = pickerOptions3.startDate;
        if (calendar == null || pickerOptions3.endDate == null) {
            if (calendar == null) {
                Calendar calendar2 = pickerOptions3.endDate;
                if (calendar2 == null) {
                    setRangDate();
                } else if (calendar2.get(1) <= 2100) {
                    setRangDate();
                } else {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
            } else if (calendar.get(1) >= 1900) {
                setRangDate();
            } else {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
        } else if (calendar.getTimeInMillis() <= this.mPickerOptions.endDate.getTimeInMillis()) {
            setRangDate();
        } else {
            throw new IllegalArgumentException("startDate can't be later than endDate");
        }
        setTime();
        WheelTime wheelTime3 = this.wheelTime;
        PickerOptions pickerOptions4 = this.mPickerOptions;
        wheelTime3.setLabels(pickerOptions4.label_year, pickerOptions4.label_month, pickerOptions4.label_day, pickerOptions4.label_hours, pickerOptions4.label_minutes, pickerOptions4.label_seconds);
        WheelTime wheelTime4 = this.wheelTime;
        PickerOptions pickerOptions5 = this.mPickerOptions;
        wheelTime4.setTextXOffset(pickerOptions5.x_offset_year, pickerOptions5.x_offset_month, pickerOptions5.x_offset_day, pickerOptions5.x_offset_hours, pickerOptions5.x_offset_minutes, pickerOptions5.x_offset_seconds);
        setOutSideCancelable(this.mPickerOptions.cancelable);
        this.wheelTime.setCyclic(this.mPickerOptions.cyclic);
        this.wheelTime.setDividerColor(this.mPickerOptions.dividerColor);
        this.wheelTime.setDividerType(this.mPickerOptions.dividerType);
        this.wheelTime.setTypeface(this.mPickerOptions.typeface);
        this.wheelTime.setLineSpacingMultiplier(this.mPickerOptions.lineSpacingMultiplier);
        this.wheelTime.setTextColorOut(this.mPickerOptions.textColorOut);
        this.wheelTime.setTextColorCenter(this.mPickerOptions.textColorCenter);
        this.wheelTime.isCenterLabel(this.mPickerOptions.isCenterLabel);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initWheelTime$0() {
        try {
            this.mPickerOptions.timeSelectChangeListener.onTimeSelectChanged(this.dateFormat.parse(this.wheelTime.getTime()));
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
    }

    private void setRangDate() {
        WheelTime wheelTime2 = this.wheelTime;
        PickerOptions pickerOptions = this.mPickerOptions;
        wheelTime2.setRangDate(pickerOptions.startDate, pickerOptions.endDate);
        initDefaultSelectedDate();
    }

    private void setRange() {
        this.wheelTime.setStartYear(this.mPickerOptions.startYear);
        this.wheelTime.setEndYear(this.mPickerOptions.endYear);
    }

    private void setTime() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Calendar instance = Calendar.getInstance();
        Calendar calendar = this.mPickerOptions.date;
        if (calendar == null) {
            instance.setTimeInMillis(System.currentTimeMillis());
            i15 = instance.get(1);
            i11 = instance.get(2);
            i12 = instance.get(5);
            i13 = instance.get(11);
            i14 = instance.get(12);
            i16 = instance.get(13);
        } else {
            i15 = calendar.get(1);
            i11 = this.mPickerOptions.date.get(2);
            i12 = this.mPickerOptions.date.get(5);
            i13 = this.mPickerOptions.date.get(11);
            i14 = this.mPickerOptions.date.get(12);
            i16 = this.mPickerOptions.date.get(13);
        }
        int i17 = i13;
        int i18 = i12;
        int i19 = i11;
        WheelTime wheelTime2 = this.wheelTime;
        wheelTime2.setPicker(i15, i19, i18, i17, i14, i16);
    }

    public boolean isDialog() {
        return this.mPickerOptions.isDialog;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (((String) view.getTag()).equals(TAG_SUBMIT)) {
            returnData();
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void returnData() {
        if (this.mPickerOptions.timeSelectListener != null) {
            try {
                this.mPickerOptions.timeSelectListener.onTimeSelect(this.dateFormat.parse(this.wheelTime.getTime()), this.clickView);
            } catch (ParseException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setDate(Calendar calendar) {
        this.mPickerOptions.date = calendar;
        setTime();
    }

    public void setLunarCalendar(boolean z11) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(this.dateFormat.parse(this.wheelTime.getTime()));
            int i11 = instance.get(1);
            int i12 = instance.get(2);
            int i13 = instance.get(5);
            int i14 = instance.get(11);
            int i15 = instance.get(12);
            int i16 = instance.get(13);
            WheelTime wheelTime2 = this.wheelTime;
            PickerOptions pickerOptions = this.mPickerOptions;
            wheelTime2.setLabels(pickerOptions.label_year, pickerOptions.label_month, pickerOptions.label_day, pickerOptions.label_hours, pickerOptions.label_minutes, pickerOptions.label_seconds);
            this.wheelTime.setPicker(i11, i12, i13, i14, i15, i16);
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
    }

    public void setTitleText(String str) {
        TextView textView = (TextView) findViewById(R.id.id_picker_view_title_text);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
