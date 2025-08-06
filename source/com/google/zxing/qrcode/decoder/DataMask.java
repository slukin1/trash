package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask {
    DATA_MASK_000 {
        public boolean isMasked(int i11, int i12) {
            return ((i11 + i12) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        public boolean isMasked(int i11, int i12) {
            return (i11 & 1) == 0;
        }
    },
    DATA_MASK_010 {
        public boolean isMasked(int i11, int i12) {
            return i12 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        public boolean isMasked(int i11, int i12) {
            return (i11 + i12) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        public boolean isMasked(int i11, int i12) {
            return (((i11 / 2) + (i12 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        public boolean isMasked(int i11, int i12) {
            return (i11 * i12) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        public boolean isMasked(int i11, int i12) {
            return (i11 * i12) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        public boolean isMasked(int i11, int i12) {
            return (((i11 + i12) + ((i11 * i12) % 3)) & 1) == 0;
        }
    };

    public abstract boolean isMasked(int i11, int i12);

    public final void unmaskBitMatrix(BitMatrix bitMatrix, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = 0; i13 < i11; i13++) {
                if (isMasked(i12, i13)) {
                    bitMatrix.flip(i13, i12);
                }
            }
        }
    }
}
