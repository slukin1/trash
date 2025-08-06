package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        public TimeModel[] newArray(int i11) {
            return new TimeModel[i11];
        }
    };
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    public final int format;
    public int hour;
    private final MaxInputValidator hourInputValidator;
    public int minute;
    private final MaxInputValidator minuteInputValidator;
    public int period;
    public int selection;

    public TimeModel() {
        this(0);
    }

    public static String formatText(Resources resources, CharSequence charSequence) {
        return formatText(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    private static int getPeriod(int i11) {
        return i11 >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.hour == timeModel.hour && this.minute == timeModel.minute && this.format == timeModel.format && this.selection == timeModel.selection) {
            return true;
        }
        return false;
    }

    public int getHourForDisplay() {
        if (this.format == 1) {
            return this.hour % 24;
        }
        int i11 = this.hour;
        if (i11 % 12 == 0) {
            return 12;
        }
        return this.period == 1 ? i11 - 12 : i11;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int i11) {
        if (this.format == 1) {
            this.hour = i11;
            return;
        }
        int i12 = 12;
        int i13 = i11 % 12;
        if (this.period != 1) {
            i12 = 0;
        }
        this.hour = i13 + i12;
    }

    public void setHourOfDay(int i11) {
        this.period = getPeriod(i11);
        this.hour = i11;
    }

    public void setMinute(int i11) {
        this.minute = i11 % 60;
    }

    public void setPeriod(int i11) {
        if (i11 != this.period) {
            this.period = i11;
            int i12 = this.hour;
            if (i12 < 12 && i11 == 1) {
                this.hour = i12 + 12;
            } else if (i12 >= 12 && i11 == 0) {
                this.hour = i12 - 12;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.selection);
        parcel.writeInt(this.format);
    }

    public TimeModel(int i11) {
        this(0, 0, 10, i11);
    }

    public static String formatText(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
    }

    public TimeModel(int i11, int i12, int i13, int i14) {
        this.hour = i11;
        this.minute = i12;
        this.selection = i13;
        this.format = i14;
        this.period = getPeriod(i11);
        this.minuteInputValidator = new MaxInputValidator(59);
        this.hourInputValidator = new MaxInputValidator(i14 == 1 ? 24 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
