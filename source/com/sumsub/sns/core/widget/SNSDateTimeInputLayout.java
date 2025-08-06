package com.sumsub.sns.core.widget;

import android.content.Context;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.internal.core.common.i;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\rH\u0002J+\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSDateTimeInputLayout;", "Lcom/sumsub/sns/core/widget/SNSTextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dateFormat", "Ljava/text/DateFormat;", "addView", "", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "setDateFormatter", "format", "showCalendar", "showTime", "cal", "Ljava/util/Calendar;", "hours", "minutes", "(Ljava/util/Calendar;Ljava/lang/Integer;Ljava/lang/Integer;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSDateTimeInputLayout extends SNSTextInputLayout {
    private DateFormat dateFormat;

    public SNSDateTimeInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: addView$lambda-0  reason: not valid java name */
    public static final void m21addView$lambda0(SNSDateTimeInputLayout sNSDateTimeInputLayout, View view, boolean z11) {
        if (z11) {
            sNSDateTimeInputLayout.showCalendar();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addView$lambda-1  reason: not valid java name */
    public static final void m22addView$lambda1(SNSDateTimeInputLayout sNSDateTimeInputLayout, View view) {
        sNSDateTimeInputLayout.showCalendar();
    }

    private final void showCalendar() {
        FragmentManager supportFragmentManager;
        Editable text;
        String obj;
        Date parse;
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC));
        DateFormat dateFormat2 = this.dateFormat;
        if (dateFormat2 == null) {
            dateFormat2 = DateFormat.getDateInstance();
        }
        DateFormat dateFormat3 = this.dateFormat;
        if (dateFormat3 != null) {
            dateFormat3.setTimeZone(instance.getTimeZone());
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        try {
            EditText editText = getEditText();
            if (!(editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null || (parse = dateFormat2.parse(obj)) == null)) {
                instance.setTime(parse);
                ref$ObjectRef.element = Integer.valueOf(instance.get(12));
                ref$ObjectRef2.element = Integer.valueOf(instance.get(10));
            }
        } catch (Exception unused) {
        }
        FragmentActivity a11 = i.a(getContext());
        if (a11 != null && (supportFragmentManager = a11.getSupportFragmentManager()) != null) {
            MaterialDatePicker<Long> build = MaterialDatePicker.Builder.datePicker().setSelection(Long.valueOf(instance.getTimeInMillis())).build();
            build.addOnPositiveButtonClickListener(new j(instance, this, ref$ObjectRef2, ref$ObjectRef));
            build.show(supportFragmentManager, (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCalendar$lambda-5$lambda-4  reason: not valid java name */
    public static final void m23showCalendar$lambda5$lambda4(Calendar calendar, SNSDateTimeInputLayout sNSDateTimeInputLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Long l11) {
        calendar.setTimeInMillis(l11.longValue());
        sNSDateTimeInputLayout.showTime(calendar, (Integer) ref$ObjectRef.element, (Integer) ref$ObjectRef2.element);
    }

    private final void showTime(Calendar calendar, Integer num, Integer num2) {
        FragmentManager supportFragmentManager;
        MaterialTimePicker.Builder timeFormat = new MaterialTimePicker.Builder().setTimeFormat(1);
        if (num2 != null) {
            timeFormat.setMinute(num2.intValue());
        }
        if (num != null) {
            timeFormat.setHour(num.intValue());
        }
        MaterialTimePicker build = timeFormat.build();
        build.addOnPositiveButtonClickListener(new h(calendar, build, this));
        FragmentActivity a11 = i.a(getContext());
        if (a11 != null && (supportFragmentManager = a11.getSupportFragmentManager()) != null) {
            build.show(supportFragmentManager, (String) null);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: showTime$lambda-8  reason: not valid java name */
    public static final void m24showTime$lambda8(Calendar calendar, MaterialTimePicker materialTimePicker, SNSDateTimeInputLayout sNSDateTimeInputLayout, View view) {
        Date time;
        EditText editText;
        if (calendar != null) {
            calendar.set(10, materialTimePicker.getHour());
        }
        if (calendar != null) {
            calendar.set(12, materialTimePicker.getMinute());
        }
        if (!(calendar == null || (time = calendar.getTime()) == null)) {
            DateFormat dateFormat2 = sNSDateTimeInputLayout.dateFormat;
            String format = dateFormat2 != null ? dateFormat2.format(time) : null;
            if (!(format == null || (editText = sNSDateTimeInputLayout.getEditText()) == null)) {
                editText.setText(format);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (view instanceof EditText) {
            EditText editText = getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new i(this));
            }
            EditText editText2 = getEditText();
            if (editText2 != null) {
                editText2.setOnClickListener(new g(this));
            }
            EditText editText3 = getEditText();
            if (editText3 != null) {
                editText3.setKeyListener((KeyListener) null);
            }
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public final void setDateFormatter(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public SNSDateTimeInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSDateTimeInputLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSDateTimeInputLayout(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_DateTimeInputLayoutStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSDateTimeInputLayout : i12);
    }

    public SNSDateTimeInputLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        EditText editText = getEditText();
        if (editText != null) {
            editText.setKeyListener((KeyListener) null);
        }
        setStartIconDrawable(a.f31095a.a(context, SNSIconHandler.SNSCommonIcons.CALENDAR.getImageName()));
    }
}
