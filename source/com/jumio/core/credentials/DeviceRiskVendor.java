package com.jumio.core.credentials;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public enum DeviceRiskVendor {
    NONE,
    SARDINE;
    
    public static final Companion Companion = null;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DeviceRiskVendor fromString(String str) {
            DeviceRiskVendor deviceRiskVendor;
            DeviceRiskVendor[] values = DeviceRiskVendor.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    deviceRiskVendor = null;
                    break;
                }
                deviceRiskVendor = values[i11];
                if (x.b(deviceRiskVendor.name(), str)) {
                    break;
                }
                i11++;
            }
            return deviceRiskVendor == null ? DeviceRiskVendor.NONE : deviceRiskVendor;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }
}
