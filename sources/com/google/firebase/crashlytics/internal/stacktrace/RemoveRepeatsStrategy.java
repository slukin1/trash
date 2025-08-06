package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i11, int i12) {
        int i13 = i12 - i11;
        if (i12 + i13 > stackTraceElementArr.length) {
            return false;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if (!stackTraceElementArr[i11 + i14].equals(stackTraceElementArr[i12 + i14])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i11) {
        int i12;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i13 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i13];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i13)) {
                stackTraceElementArr2[i14] = stackTraceElementArr[i13];
                i14++;
                i15 = 1;
                i12 = i13;
            } else {
                int intValue = i13 - num.intValue();
                if (i15 < i11) {
                    System.arraycopy(stackTraceElementArr, i13, stackTraceElementArr2, i14, intValue);
                    i14 += intValue;
                    i15++;
                }
                i12 = (intValue - 1) + i13;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i13));
            i13 = i12 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i14];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i14);
        return stackTraceElementArr3;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] trimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return trimRepeats.length < stackTraceElementArr.length ? trimRepeats : stackTraceElementArr;
    }

    public RemoveRepeatsStrategy(int i11) {
        this.maxRepetitions = i11;
    }
}
