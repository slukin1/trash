package com.huobi.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.Field;
import java.util.Calendar;

public final class DatePickerDialog extends Dialog {
    private Builder builder;

    public static class Builder {
        public float dimAmount;
        public boolean hideDate = false;
        public long initDate;
        public long maxDate;
        public long minDate;
        public ResultListener resultListener;
        public int title;
        public String titleStr;

        public DatePickerDialog build(Context context) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(context);
            datePickerDialog.setBuilder(this);
            return datePickerDialog;
        }

        public Builder setDimAmountBehind(float f11) {
            this.dimAmount = f11;
            return this;
        }

        public Builder setHideDate(boolean z11) {
            this.hideDate = z11;
            return this;
        }

        public Builder setInitDate(long j11) {
            this.initDate = j11;
            return this;
        }

        public Builder setMaxDate(long j11) {
            this.maxDate = j11;
            return this;
        }

        public Builder setMinDate(long j11) {
            this.minDate = j11;
            return this;
        }

        public Builder setResultListener(ResultListener resultListener2) {
            this.resultListener = resultListener2;
            return this;
        }

        public Builder setTitle(int i11) {
            this.title = i11;
            return this;
        }

        public Builder setTitleText(String str) {
            this.titleStr = str;
            return this;
        }

        public void show(Context context) {
            build(context).show();
        }
    }

    public interface ResultListener {
        void onCancel();

        void onResult(DatePickerDialog datePickerDialog, long j11);
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R$id.tv_title);
        TextView textView2 = (TextView) findViewById(R$id.tv_cancel);
        DatePicker datePicker = (DatePicker) findViewById(R$id.date_picker);
        StatusButton statusButton = (StatusButton) findViewById(R$id.btn_confirm);
        if (this.builder.hideDate) {
            hideDateView();
        }
        setOnDismissListener(new b0(this));
        Builder builder2 = this.builder;
        int i11 = builder2.title;
        if (i11 == 0) {
            textView.setText(builder2.titleStr);
        } else {
            textView.setText(i11);
        }
        textView2.setOnClickListener(new c0(this));
        statusButton.setOnClickListener(new d0(this, datePicker));
        Calendar instance = Calendar.getInstance();
        long j11 = this.builder.initDate;
        if (j11 != 0) {
            instance.setTimeInMillis(j11);
        }
        datePicker.updateDate(instance.get(1), instance.get(2), instance.get(5));
        long j12 = this.builder.minDate;
        if (j12 != 0) {
            datePicker.setMinDate(j12);
        }
        long j13 = this.builder.maxDate;
        if (j13 != 0) {
            datePicker.setMaxDate(j13);
        }
    }

    private void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = PixelUtils.g();
            if (this.builder.dimAmount != 0.0f) {
                getWindow().addFlags(2);
                attributes.dimAmount = this.builder.dimAmount;
            }
            window.setAttributes(attributes);
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(DialogInterface dialogInterface) {
        ResultListener resultListener = this.builder.resultListener;
        if (resultListener != null) {
            resultListener.onCancel();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$2(DatePicker datePicker, View view) {
        if (this.builder.resultListener != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            this.builder.resultListener.onResult(this, instance.getTime().getTime());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public DatePickerDialog hideDateView() {
        View findViewById;
        DatePicker datePicker = (DatePicker) findViewById(R$id.date_picker);
        if (datePicker != null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    int identifier = Resources.getSystem().getIdentifier(MTPushConstants.NotificationTime.KEY_DAYS, "id", "android");
                    if (!(identifier == 0 || (findViewById = datePicker.findViewById(identifier)) == null)) {
                        findViewById.setVisibility(8);
                    }
                } else {
                    for (Field field : datePicker.getClass().getDeclaredFields()) {
                        if ("mDaySpinner".equals(field.getName()) || "mDayPicker".equals(field.getName())) {
                            field.setAccessible(true);
                            Object obj = new Object();
                            try {
                                obj = field.get(datePicker);
                            } catch (IllegalAccessException e11) {
                                e11.printStackTrace();
                            } catch (IllegalArgumentException e12) {
                                e12.printStackTrace();
                            }
                            ((View) obj).setVisibility(8);
                        }
                    }
                }
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        }
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_date_picker);
        initWindow();
        initView();
    }

    public void setBuilder(Builder builder2) {
        this.builder = builder2;
    }

    private DatePickerDialog(Context context) {
        super(context, R$style.DatePickerDialogStyle);
    }
}
