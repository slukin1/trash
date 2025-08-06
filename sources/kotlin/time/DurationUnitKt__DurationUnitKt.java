package kotlin.time;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import e7.s;

class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    public static final DurationUnit d(char c11, boolean z11) {
        if (!z11) {
            if (c11 == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c11);
        } else if (c11 == 'H') {
            return DurationUnit.HOURS;
        } else {
            if (c11 == 'M') {
                return DurationUnit.MINUTES;
            }
            if (c11 == 'S') {
                return DurationUnit.SECONDS;
            }
            throw new IllegalArgumentException("Invalid duration ISO time unit: " + c11);
        }
    }

    public static final DurationUnit e(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && str.equals("us")) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (str.equals("ns")) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (str.equals("ms")) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (str.equals(s.f70071a)) {
                        return DurationUnit.SECONDS;
                    }
                } else if (str.equals("m")) {
                    return DurationUnit.MINUTES;
                }
            } else if (str.equals("h")) {
                return DurationUnit.HOURS;
            }
        } else if (str.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
            return DurationUnit.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + str);
    }
}
