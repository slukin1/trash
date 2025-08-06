package com.iproov.sdk.p003case;

/* renamed from: com.iproov.sdk.case.for  reason: invalid class name and invalid package */
public enum Cfor {
    ENROL {
        public String toString() {
            return "enrol";
        }
    },
    VERIFY {
        public String toString() {
            return "verify";
        }
    },
    ID_MATCH {
        public String toString() {
            return "id_match";
        }
    };

    /* renamed from: do  reason: not valid java name */
    public static Cfor m228do(String str) {
        for (Cfor forR : values()) {
            if (forR.toString().equalsIgnoreCase(str)) {
                return forR;
            }
        }
        return VERIFY;
    }
}
