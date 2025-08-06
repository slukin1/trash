package com.iproov.sdk.p003case;

/* renamed from: com.iproov.sdk.case.do  reason: invalid class name and invalid package */
public enum Cdo {
    GENUINE_PRESENCE_ASSURANCE {
        public String toString() {
            return "genuine_presence";
        }
    },
    LIVENESS {
        public String toString() {
            return "liveness";
        }
    };

    /* renamed from: do  reason: not valid java name */
    public static Cdo m227do(String str) {
        if (str != null && !str.isEmpty()) {
            for (Cdo doVar : values()) {
                if (doVar.toString().equalsIgnoreCase(str)) {
                    return doVar;
                }
            }
        }
        return null;
    }
}
