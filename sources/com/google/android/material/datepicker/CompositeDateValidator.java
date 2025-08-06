package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.h;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    /* access modifiers changed from: private */
    public static final Operator ALL_OPERATOR = new Operator() {
        public int getId() {
            return 2;
        }

        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j11) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && !next.isValid(j11)) {
                    return false;
                }
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public static final Operator ANY_OPERATOR = new Operator() {
        public int getId() {
            return 1;
        }

        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j11) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && next.isValid(j11)) {
                    return true;
                }
            }
            return false;
        }
    };
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            Operator operator;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                operator = CompositeDateValidator.ALL_OPERATOR;
            } else if (readInt == 1) {
                operator = CompositeDateValidator.ANY_OPERATOR;
            } else {
                operator = CompositeDateValidator.ALL_OPERATOR;
            }
            return new CompositeDateValidator((List) h.g(readArrayList), operator);
        }

        public CompositeDateValidator[] newArray(int i11) {
            return new CompositeDateValidator[i11];
        }
    };
    private final Operator operator;
    private final List<CalendarConstraints.DateValidator> validators;

    public interface Operator {
        int getId();

        boolean isValid(List<CalendarConstraints.DateValidator> list, long j11);
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    public static CalendarConstraints.DateValidator anyOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        if (!this.validators.equals(compositeDateValidator.validators) || this.operator.getId() != compositeDateValidator.operator.getId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    public boolean isValid(long j11) {
        return this.operator.isValid(this.validators, j11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, Operator operator2) {
        this.validators = list;
        this.operator = operator2;
    }
}
