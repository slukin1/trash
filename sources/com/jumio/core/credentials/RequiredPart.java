package com.jumio.core.credentials;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public enum RequiredPart {
    NONE,
    DEVICE_RISK,
    FRONT,
    BACK;
    
    public static final Companion Companion = null;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final RequiredPart fromString(String str) {
            RequiredPart requiredPart;
            RequiredPart[] values = RequiredPart.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    requiredPart = null;
                    break;
                }
                requiredPart = values[i11];
                if (x.b(requiredPart.name(), str)) {
                    break;
                }
                i11++;
            }
            return requiredPart == null ? RequiredPart.NONE : requiredPart;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }
}
