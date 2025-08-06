package com.jumio.sdk.enums;

import java.util.Locale;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public enum JumioConsentType {
    ACTIVE,
    PASSIVE;
    
    public static final Companion Companion = null;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final JumioConsentType fromString(String str) {
            JumioConsentType jumioConsentType;
            JumioConsentType[] values = JumioConsentType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    jumioConsentType = null;
                    break;
                }
                jumioConsentType = values[i11];
                if (x.b(jumioConsentType.name(), str.toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i11++;
            }
            return jumioConsentType == null ? JumioConsentType.ACTIVE : jumioConsentType;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }
}
