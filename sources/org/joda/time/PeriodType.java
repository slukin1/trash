package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.field.e;

public class PeriodType implements Serializable {
    public static int DAY_INDEX = 3;
    public static int HOUR_INDEX = 4;
    public static int MILLI_INDEX = 7;
    public static int MINUTE_INDEX = 5;
    public static int MONTH_INDEX = 1;
    public static int SECOND_INDEX = 6;
    public static int WEEK_INDEX = 2;
    public static int YEAR_INDEX = 0;
    private static PeriodType cDTime = null;
    private static PeriodType cDays = null;
    private static PeriodType cHours = null;
    private static PeriodType cMillis = null;
    private static PeriodType cMinutes = null;
    private static PeriodType cMonths = null;
    private static PeriodType cSeconds = null;
    private static PeriodType cStandard = null;
    private static PeriodType cTime = null;
    private static final Map<PeriodType, Object> cTypes = new HashMap(32);
    private static PeriodType cWeeks = null;
    private static PeriodType cYD = null;
    private static PeriodType cYDTime = null;
    private static PeriodType cYMD = null;
    private static PeriodType cYMDTime = null;
    private static PeriodType cYWD = null;
    private static PeriodType cYWDTime = null;
    private static PeriodType cYears = null;
    private static final long serialVersionUID = 2274324892792009998L;
    private final int[] iIndices;
    private final String iName;
    private final DurationFieldType[] iTypes;

    public PeriodType(String str, DurationFieldType[] durationFieldTypeArr, int[] iArr) {
        this.iName = str;
        this.iTypes = durationFieldTypeArr;
        this.iIndices = iArr;
    }

    public static PeriodType dayTime() {
        PeriodType periodType = cDTime;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("DayTime", new DurationFieldType[]{DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{-1, -1, -1, 0, 1, 2, 3, 4});
        cDTime = periodType2;
        return periodType2;
    }

    public static PeriodType days() {
        PeriodType periodType = cDays;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Days", new DurationFieldType[]{DurationFieldType.days()}, new int[]{-1, -1, -1, 0, -1, -1, -1, -1});
        cDays = periodType2;
        return periodType2;
    }

    public static synchronized PeriodType forFields(DurationFieldType[] durationFieldTypeArr) {
        synchronized (PeriodType.class) {
            if (durationFieldTypeArr != null) {
                if (durationFieldTypeArr.length != 0) {
                    int i11 = 0;
                    while (i11 < durationFieldTypeArr.length) {
                        if (durationFieldTypeArr[i11] != null) {
                            i11++;
                        } else {
                            throw new IllegalArgumentException("Types array must not contain null");
                        }
                    }
                    Map<PeriodType, Object> map = cTypes;
                    if (map.isEmpty()) {
                        map.put(standard(), standard());
                        map.put(yearMonthDayTime(), yearMonthDayTime());
                        map.put(yearMonthDay(), yearMonthDay());
                        map.put(yearWeekDayTime(), yearWeekDayTime());
                        map.put(yearWeekDay(), yearWeekDay());
                        map.put(yearDayTime(), yearDayTime());
                        map.put(yearDay(), yearDay());
                        map.put(dayTime(), dayTime());
                        map.put(time(), time());
                        map.put(years(), years());
                        map.put(months(), months());
                        map.put(weeks(), weeks());
                        map.put(days(), days());
                        map.put(hours(), hours());
                        map.put(minutes(), minutes());
                        map.put(seconds(), seconds());
                        map.put(millis(), millis());
                    }
                    PeriodType periodType = new PeriodType((String) null, durationFieldTypeArr, (int[]) null);
                    Object obj = map.get(periodType);
                    if (obj instanceof PeriodType) {
                        PeriodType periodType2 = (PeriodType) obj;
                        return periodType2;
                    } else if (obj == null) {
                        PeriodType standard = standard();
                        ArrayList arrayList = new ArrayList(Arrays.asList(durationFieldTypeArr));
                        if (!arrayList.remove(DurationFieldType.years())) {
                            standard = standard.withYearsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.months())) {
                            standard = standard.withMonthsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.weeks())) {
                            standard = standard.withWeeksRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.days())) {
                            standard = standard.withDaysRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.hours())) {
                            standard = standard.withHoursRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.minutes())) {
                            standard = standard.withMinutesRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.seconds())) {
                            standard = standard.withSecondsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.millis())) {
                            standard = standard.withMillisRemoved();
                        }
                        if (arrayList.size() <= 0) {
                            PeriodType periodType3 = new PeriodType((String) null, standard.iTypes, (int[]) null);
                            PeriodType periodType4 = (PeriodType) map.get(periodType3);
                            if (periodType4 != null) {
                                map.put(periodType3, periodType4);
                                return periodType4;
                            }
                            map.put(periodType3, standard);
                            return standard;
                        }
                        map.put(periodType, arrayList);
                        throw new IllegalArgumentException("PeriodType does not support fields: " + arrayList);
                    } else {
                        throw new IllegalArgumentException("PeriodType does not support fields: " + obj);
                    }
                }
            }
            throw new IllegalArgumentException("Types array must not be null or empty");
        }
    }

    public static PeriodType hours() {
        PeriodType periodType = cHours;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Hours", new DurationFieldType[]{DurationFieldType.hours()}, new int[]{-1, -1, -1, -1, 0, -1, -1, -1});
        cHours = periodType2;
        return periodType2;
    }

    public static PeriodType millis() {
        PeriodType periodType = cMillis;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Millis", new DurationFieldType[]{DurationFieldType.millis()}, new int[]{-1, -1, -1, -1, -1, -1, -1, 0});
        cMillis = periodType2;
        return periodType2;
    }

    public static PeriodType minutes() {
        PeriodType periodType = cMinutes;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Minutes", new DurationFieldType[]{DurationFieldType.minutes()}, new int[]{-1, -1, -1, -1, -1, 0, -1, -1});
        cMinutes = periodType2;
        return periodType2;
    }

    public static PeriodType months() {
        PeriodType periodType = cMonths;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Months", new DurationFieldType[]{DurationFieldType.months()}, new int[]{-1, 0, -1, -1, -1, -1, -1, -1});
        cMonths = periodType2;
        return periodType2;
    }

    public static PeriodType seconds() {
        PeriodType periodType = cSeconds;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Seconds", new DurationFieldType[]{DurationFieldType.seconds()}, new int[]{-1, -1, -1, -1, -1, -1, 0, -1});
        cSeconds = periodType2;
        return periodType2;
    }

    public static PeriodType standard() {
        PeriodType periodType = cStandard;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Standard", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        cStandard = periodType2;
        return periodType2;
    }

    public static PeriodType time() {
        PeriodType periodType = cTime;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Time", new DurationFieldType[]{DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{-1, -1, -1, -1, 0, 1, 2, 3});
        cTime = periodType2;
        return periodType2;
    }

    public static PeriodType weeks() {
        PeriodType periodType = cWeeks;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Weeks", new DurationFieldType[]{DurationFieldType.weeks()}, new int[]{-1, -1, 0, -1, -1, -1, -1, -1});
        cWeeks = periodType2;
        return periodType2;
    }

    private PeriodType withFieldRemoved(int i11, String str) {
        int i12 = this.iIndices[i11];
        if (i12 == -1) {
            return this;
        }
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[(size() - 1)];
        int i13 = 0;
        while (true) {
            DurationFieldType[] durationFieldTypeArr2 = this.iTypes;
            if (i13 >= durationFieldTypeArr2.length) {
                break;
            }
            if (i13 < i12) {
                durationFieldTypeArr[i13] = durationFieldTypeArr2[i13];
            } else if (i13 > i12) {
                durationFieldTypeArr[i13 - 1] = durationFieldTypeArr2[i13];
            }
            i13++;
        }
        int[] iArr = new int[8];
        for (int i14 = 0; i14 < 8; i14++) {
            if (i14 < i11) {
                iArr[i14] = this.iIndices[i14];
            } else if (i14 > i11) {
                int[] iArr2 = this.iIndices;
                iArr[i14] = iArr2[i14] == -1 ? -1 : iArr2[i14] - 1;
            } else {
                iArr[i14] = -1;
            }
        }
        return new PeriodType(getName() + str, durationFieldTypeArr, iArr);
    }

    public static PeriodType yearDay() {
        PeriodType periodType = cYD;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.days()}, new int[]{0, -1, -1, 1, -1, -1, -1, -1});
        cYD = periodType2;
        return periodType2;
    }

    public static PeriodType yearDayTime() {
        PeriodType periodType = cYDTime;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, -1, -1, 1, 2, 3, 4, 5});
        cYDTime = periodType2;
        return periodType2;
    }

    public static PeriodType yearMonthDay() {
        PeriodType periodType = cYMD;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearMonthDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days()}, new int[]{0, 1, -1, 2, -1, -1, -1, -1});
        cYMD = periodType2;
        return periodType2;
    }

    public static PeriodType yearMonthDayTime() {
        PeriodType periodType = cYMDTime;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearMonthDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, 1, -1, 2, 3, 4, 5, 6});
        cYMDTime = periodType2;
        return periodType2;
    }

    public static PeriodType yearWeekDay() {
        PeriodType periodType = cYWD;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearWeekDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days()}, new int[]{0, -1, 1, 2, -1, -1, -1, -1});
        cYWD = periodType2;
        return periodType2;
    }

    public static PeriodType yearWeekDayTime() {
        PeriodType periodType = cYWDTime;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearWeekDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, -1, 1, 2, 3, 4, 5, 6});
        cYWDTime = periodType2;
        return periodType2;
    }

    public static PeriodType years() {
        PeriodType periodType = cYears;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Years", new DurationFieldType[]{DurationFieldType.years()}, new int[]{0, -1, -1, -1, -1, -1, -1, -1});
        cYears = periodType2;
        return periodType2;
    }

    public boolean addIndexedField(i iVar, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            return false;
        }
        int i13 = this.iIndices[i11];
        if (i13 != -1) {
            iArr[i13] = e.d(iArr[i13], i12);
            return true;
        }
        throw new UnsupportedOperationException("Field is not supported");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PeriodType)) {
            return false;
        }
        return Arrays.equals(this.iTypes, ((PeriodType) obj).iTypes);
    }

    public DurationFieldType getFieldType(int i11) {
        return this.iTypes[i11];
    }

    public int getIndexedField(i iVar, int i11) {
        int i12 = this.iIndices[i11];
        if (i12 == -1) {
            return 0;
        }
        return iVar.getValue(i12);
    }

    public String getName() {
        return this.iName;
    }

    public int hashCode() {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            DurationFieldType[] durationFieldTypeArr = this.iTypes;
            if (i11 >= durationFieldTypeArr.length) {
                return i12;
            }
            i12 += durationFieldTypeArr[i11].hashCode();
            i11++;
        }
    }

    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.iTypes[i11] == durationFieldType) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return indexOf(durationFieldType) >= 0;
    }

    public boolean setIndexedField(i iVar, int i11, int[] iArr, int i12) {
        int i13 = this.iIndices[i11];
        if (i13 != -1) {
            iArr[i13] = i12;
            return true;
        }
        throw new UnsupportedOperationException("Field is not supported");
    }

    public int size() {
        return this.iTypes.length;
    }

    public String toString() {
        return "PeriodType[" + getName() + "]";
    }

    public PeriodType withDaysRemoved() {
        return withFieldRemoved(3, "NoDays");
    }

    public PeriodType withHoursRemoved() {
        return withFieldRemoved(4, "NoHours");
    }

    public PeriodType withMillisRemoved() {
        return withFieldRemoved(7, "NoMillis");
    }

    public PeriodType withMinutesRemoved() {
        return withFieldRemoved(5, "NoMinutes");
    }

    public PeriodType withMonthsRemoved() {
        return withFieldRemoved(1, "NoMonths");
    }

    public PeriodType withSecondsRemoved() {
        return withFieldRemoved(6, "NoSeconds");
    }

    public PeriodType withWeeksRemoved() {
        return withFieldRemoved(2, "NoWeeks");
    }

    public PeriodType withYearsRemoved() {
        return withFieldRemoved(0, "NoYears");
    }
}
