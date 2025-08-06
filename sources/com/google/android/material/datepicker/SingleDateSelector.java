package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.c;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        public SingleDateSelector[] newArray(int i11) {
            return new SingleDateSelector[i11];
        }
    };
    /* access modifiers changed from: private */
    public Long selectedItem;

    /* access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l11 = this.selectedItem;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    public Collection<c<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l11 = this.selectedItem;
        if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String yearMonthDay = DateStrings.getYearMonthDay(l11.longValue());
        return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[]{yearMonthDay});
    }

    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        Long l11 = this.selectedItem;
        if (l11 != null) {
            editText.setText(textInputFormat.format(l11));
        }
        final OnSelectionChangedListener<Long> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout, calendarConstraints) {
            public void onInvalidDate() {
                onSelectionChangedListener2.onIncompleteSelectionChanged();
            }

            public void onValidDate(Long l11) {
                if (l11 == null) {
                    SingleDateSelector.this.clearSelection();
                } else {
                    SingleDateSelector.this.select(l11.longValue());
                }
                onSelectionChangedListener2.onSelectionChanged(SingleDateSelector.this.getSelection());
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j11) {
        this.selectedItem = Long.valueOf(j11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeValue(this.selectedItem);
    }

    public Long getSelection() {
        return this.selectedItem;
    }

    public void setSelection(Long l11) {
        this.selectedItem = l11 == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l11.longValue()));
    }
}
