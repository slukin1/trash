package com.sumsub.sns.internal.util;

public enum DataUnit {
    KILOBYTES {
        public long toBytes(long j11) {
            return j11 * 1000;
        }
    },
    MEGABYTES {
        public long toBytes(long j11) {
            return j11 * 1000000;
        }
    },
    GIGABYTES {
        public long toBytes(long j11) {
            return j11 * 1000000000;
        }
    },
    TERABYTES {
        public long toBytes(long j11) {
            return j11 * 1000000000000L;
        }
    },
    KIBIBYTES {
        public long toBytes(long j11) {
            return j11 * 1024;
        }
    },
    MEBIBYTES {
        public long toBytes(long j11) {
            return j11 * 1048576;
        }
    },
    GIBIBYTES {
        public long toBytes(long j11) {
            return j11 * 1073741824;
        }
    },
    TEBIBYTES {
        public long toBytes(long j11) {
            return j11 * 1099511627776L;
        }
    };

    public long toBytes(long j11) {
        throw new AbstractMethodError();
    }
}
