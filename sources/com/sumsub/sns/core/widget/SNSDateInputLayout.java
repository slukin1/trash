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
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.internal.core.common.i;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u000fH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSDateInputLayout;", "Lcom/sumsub/sns/core/widget/SNSTextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "constraints", "Lcom/google/android/material/datepicker/CalendarConstraints;", "dateFormat", "Ljava/text/DateFormat;", "addView", "", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "setConstraints", "c", "setDateFormatter", "format", "showCalendar", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSDateInputLayout extends SNSTextInputLayout {
    private CalendarConstraints constraints;
    private DateFormat dateFormat;

    public SNSDateInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: addView$lambda-0  reason: not valid java name */
    public static final void m18addView$lambda0(SNSDateInputLayout sNSDateInputLayout, View view, boolean z11) {
        if (z11) {
            sNSDateInputLayout.showCalendar();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addView$lambda-1  reason: not valid java name */
    public static final void m19addView$lambda1(SNSDateInputLayout sNSDateInputLayout, View view) {
        sNSDateInputLayout.showCalendar();
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
        dateFormat2.setTimeZone(instance.getTimeZone());
        try {
            EditText editText = getEditText();
            if (!(editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null || (parse = dateFormat2.parse(obj)) == null)) {
                instance.setTime(parse);
            }
        } catch (Exception unused) {
        }
        FragmentActivity a11 = i.a(getContext());
        if (a11 != null && (supportFragmentManager = a11.getSupportFragmentManager()) != null) {
            MaterialDatePicker.Builder<Long> selection = MaterialDatePicker.Builder.datePicker().setSelection(Long.valueOf(instance.getTimeInMillis()));
            CalendarConstraints calendarConstraints = this.constraints;
            if (calendarConstraints != null) {
                selection.setCalendarConstraints(calendarConstraints);
            }
            MaterialDatePicker<Long> build = selection.build();
            build.addOnPositiveButtonClickListener(new f(instance, this, dateFormat2));
            build.show(supportFragmentManager, (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCalendar$lambda-7$lambda-6  reason: not valid java name */
    public static final void m20showCalendar$lambda7$lambda6(Calendar calendar, SNSDateInputLayout sNSDateInputLayout, DateFormat dateFormat2, Long l11) {
        calendar.setTimeInMillis(l11.longValue());
        EditText editText = sNSDateInputLayout.getEditText();
        if (editText != null) {
            editText.setText(dateFormat2.format(calendar.getTime()));
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (view instanceof EditText) {
            EditText editText = getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new e(this));
            }
            EditText editText2 = getEditText();
            if (editText2 != null) {
                editText2.setOnClickListener(new d(this));
            }
            EditText editText3 = getEditText();
            if (editText3 != null) {
                editText3.setKeyListener((KeyListener) null);
            }
        }
    }

    public final void setConstraints(CalendarConstraints calendarConstraints) {
        this.constraints = calendarConstraints;
    }

    public final void setDateFormatter(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public SNSDateInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSDateInputLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSDateInputLayout(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_DateInputLayoutStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSDateInputLayout : i12);
    }

    public SNSDateInputLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        setStartIconDrawable(a.f31095a.a(context, SNSIconHandler.SNSCommonIcons.CALENDAR.getImageName()));
    }
}
