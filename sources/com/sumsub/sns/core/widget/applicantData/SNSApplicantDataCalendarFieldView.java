package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.google.android.material.datepicker.CalendarConstraints;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.SNSDateInputLayout;
import java.text.DateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010'\u001a\u0004\u0018\u00010\u0018*\u00020\u001eH\u0002R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00188F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u000e\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u001e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataCalendarFieldView;", "Lcom/sumsub/sns/core/widget/SNSApplicantDataFieldView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dateInput", "Lcom/sumsub/sns/core/widget/SNSDateInputLayout;", "getDateInput", "()Lcom/sumsub/sns/core/widget/SNSDateInputLayout;", "value", "", "error", "getError", "()Ljava/lang/CharSequence;", "setError", "(Ljava/lang/CharSequence;)V", "printDateFormat", "Ljava/text/DateFormat;", "kotlin.jvm.PlatformType", "Ljava/util/Date;", "selectedDate", "getSelectedDate", "()Ljava/util/Date;", "setSelectedDate", "(Ljava/util/Date;)V", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "setConstraints", "", "constraints", "Lcom/google/android/material/datepicker/CalendarConstraints;", "parseAsPrintFormat", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSApplicantDataCalendarFieldView extends SNSApplicantDataFieldView {
    private final DateFormat printDateFormat;
    private Date selectedDate;

    public SNSApplicantDataCalendarFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final SNSDateInputLayout getDateInput() {
        return (SNSDateInputLayout) findViewById(R.id.sns_data_date);
    }

    private final Date parseAsPrintFormat(String str) {
        try {
            return this.printDateFormat.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public CharSequence getError() {
        SNSDateInputLayout dateInput = getDateInput();
        if (dateInput != null) {
            return dateInput.getError();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getEditText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Date getSelectedDate() {
        /*
            r1 = this;
            com.sumsub.sns.core.widget.SNSDateInputLayout r0 = r1.getDateInput()
            if (r0 == 0) goto L_0x0011
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x0011
            android.text.Editable r0 = r0.getText()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.util.Date r0 = r1.parseAsPrintFormat(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView.getSelectedDate():java.util.Date");
    }

    public String getValue() {
        Date selectedDate2 = getSelectedDate();
        String format = selectedDate2 != null ? this.printDateFormat.format(selectedDate2) : null;
        return format == null ? "" : format;
    }

    public final void setConstraints(CalendarConstraints calendarConstraints) {
        SNSDateInputLayout dateInput = getDateInput();
        if (dateInput != null) {
            dateInput.setConstraints(calendarConstraints);
        }
    }

    public void setError(CharSequence charSequence) {
        SNSDateInputLayout dateInput = getDateInput();
        if (dateInput != null) {
            dateInput.setError(charSequence);
        }
    }

    public final void setSelectedDate(Date date) {
        EditText editText;
        SNSDateInputLayout dateInput = getDateInput();
        if (!(dateInput == null || (editText = dateInput.getEditText()) == null)) {
            String format = date != null ? this.printDateFormat.format(date) : null;
            if (format == null) {
                format = "";
            }
            editText.setText(format);
        }
        this.selectedDate = date;
    }

    public void setValue(String str) {
        setSelectedDate(parseAsPrintFormat(str));
    }

    public SNSApplicantDataCalendarFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataCalendarFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataCalendarFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFieldView_Date : i12);
    }

    public SNSApplicantDataCalendarFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        EditText editText;
        DateFormat dateInstance = DateFormat.getDateInstance();
        this.printDateFormat = dateInstance;
        setFocusable(true);
        setFocusableInTouchMode(true);
        SNSDateInputLayout dateInput = getDateInput();
        if (dateInput != null) {
            dateInput.setDateFormatter(dateInstance);
        }
        SNSDateInputLayout dateInput2 = getDateInput();
        if (!(dateInput2 == null || (editText = dateInput2.getEditText()) == null)) {
            editText.addTextChangedListener(new SNSApplicantDataCalendarFieldView$special$$inlined$addTextChangedListener$default$1(this));
        }
        onInitializationFinished();
    }
}
