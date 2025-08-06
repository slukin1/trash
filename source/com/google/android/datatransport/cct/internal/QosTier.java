package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

public enum QosTier {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<QosTier> valueMap = null;
    private final int value;

    /* access modifiers changed from: public */
    static {
        QosTier qosTier;
        QosTier qosTier2;
        QosTier qosTier3;
        QosTier qosTier4;
        QosTier qosTier5;
        QosTier qosTier6;
        SparseArray<QosTier> sparseArray = new SparseArray<>();
        valueMap = sparseArray;
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier2);
        sparseArray.put(2, qosTier3);
        sparseArray.put(3, qosTier4);
        sparseArray.put(4, qosTier5);
        sparseArray.put(-1, qosTier6);
    }

    private QosTier(int i11) {
        this.value = i11;
    }

    public static QosTier forNumber(int i11) {
        if (i11 == 0) {
            return DEFAULT;
        }
        if (i11 == 1) {
            return UNMETERED_ONLY;
        }
        if (i11 == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i11 == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i11 != 4) {
            return null;
        }
        return NEVER;
    }

    public final int getNumber() {
        return this.value;
    }
}
