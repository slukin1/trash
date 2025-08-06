package org.bouncycastle.math.ec;

import java.math.BigInteger;

public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = {13, 41, 121, 337, 897, 2305};
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int[] EMPTY_INTS = new int[0];
    /* access modifiers changed from: private */
    public static final ECPoint[] EMPTY_POINTS = new ECPoint[0];
    private static final int MAX_WIDTH = 16;
    public static final String PRECOMP_NAME = "bc_wnaf";

    public static void configureBasepoint(ECPoint eCPoint) {
        ECCurve curve = eCPoint.getCurve();
        if (curve != null) {
            BigInteger order = curve.getOrder();
            final int min = Math.min(16, getWindowSize(order == null ? curve.getFieldSize() + 1 : order.bitLength()) + 3);
            curve.precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
                public PreCompInfo precompute(PreCompInfo preCompInfo) {
                    WNafPreCompInfo wNafPreCompInfo = preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo) preCompInfo : null;
                    if (wNafPreCompInfo == null || wNafPreCompInfo.getConfWidth() != min) {
                        WNafPreCompInfo wNafPreCompInfo2 = new WNafPreCompInfo();
                        wNafPreCompInfo2.setPromotionCountdown(0);
                        wNafPreCompInfo2.setConfWidth(min);
                        if (wNafPreCompInfo != null) {
                            wNafPreCompInfo2.setPreComp(wNafPreCompInfo.getPreComp());
                            wNafPreCompInfo2.setPreCompNeg(wNafPreCompInfo.getPreCompNeg());
                            wNafPreCompInfo2.setTwice(wNafPreCompInfo.getTwice());
                            wNafPreCompInfo2.setWidth(wNafPreCompInfo.getWidth());
                        }
                        return wNafPreCompInfo2;
                    }
                    wNafPreCompInfo.setPromotionCountdown(0);
                    return wNafPreCompInfo;
                }
            });
        }
    }

    public static int[] generateCompactNaf(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return EMPTY_INTS;
        } else {
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength();
            int i11 = bitLength >> 1;
            int[] iArr = new int[i11];
            BigInteger xor = add.xor(bigInteger);
            int i12 = bitLength - 1;
            int i13 = 0;
            int i14 = 1;
            int i15 = 0;
            while (i14 < i12) {
                if (!xor.testBit(i14)) {
                    i15++;
                } else {
                    iArr[i13] = i15 | ((bigInteger.testBit(i14) ? -1 : 1) << 16);
                    i14++;
                    i15 = 1;
                    i13++;
                }
                i14++;
            }
            int i16 = i13 + 1;
            iArr[i13] = 65536 | i15;
            return i11 > i16 ? trim(iArr, i16) : iArr;
        }
    }

    public static int[] generateCompactWindowNaf(int i11, BigInteger bigInteger) {
        if (i11 == 2) {
            return generateCompactNaf(bigInteger);
        }
        if (i11 < 2 || i11 > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        } else if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return EMPTY_INTS;
        } else {
            int bitLength = (bigInteger.bitLength() / i11) + 1;
            int[] iArr = new int[bitLength];
            int i12 = 1 << i11;
            int i13 = i12 - 1;
            int i14 = i12 >>> 1;
            int i15 = 0;
            int i16 = 0;
            boolean z11 = false;
            while (i15 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i15) == z11) {
                    i15++;
                } else {
                    bigInteger = bigInteger.shiftRight(i15);
                    int intValue = bigInteger.intValue() & i13;
                    if (z11) {
                        intValue++;
                    }
                    z11 = (intValue & i14) != 0;
                    if (z11) {
                        intValue -= i12;
                    }
                    if (i16 > 0) {
                        i15--;
                    }
                    iArr[i16] = i15 | (intValue << 16);
                    i15 = i11;
                    i16++;
                }
            }
            return bitLength > i16 ? trim(iArr, i16) : iArr;
        }
    }

    public static byte[] generateJSF(BigInteger bigInteger, BigInteger bigInteger2) {
        int max = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[max];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if ((i11 | i12) == 0 && bigInteger.bitLength() <= i13 && bigInteger2.bitLength() <= i13) {
                break;
            }
            int intValue = ((bigInteger.intValue() >>> i13) + i11) & 7;
            int intValue2 = ((bigInteger2.intValue() >>> i13) + i12) & 7;
            int i15 = intValue & 1;
            if (i15 != 0) {
                i15 -= intValue & 2;
                if (intValue + i15 == 4 && (intValue2 & 3) == 2) {
                    i15 = -i15;
                }
            }
            int i16 = intValue2 & 1;
            if (i16 != 0) {
                i16 -= intValue2 & 2;
                if (intValue2 + i16 == 4 && (intValue & 3) == 2) {
                    i16 = -i16;
                }
            }
            if ((i11 << 1) == i15 + 1) {
                i11 ^= 1;
            }
            if ((i12 << 1) == i16 + 1) {
                i12 ^= 1;
            }
            i13++;
            if (i13 == 30) {
                bigInteger = bigInteger.shiftRight(30);
                bigInteger2 = bigInteger2.shiftRight(30);
                i13 = 0;
            }
            bArr[i14] = (byte) ((i15 << 4) | (i16 & 15));
            i14++;
        }
        return max > i14 ? trim(bArr, i14) : bArr;
    }

    public static byte[] generateNaf(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return EMPTY_BYTES;
        }
        BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
        int bitLength = add.bitLength() - 1;
        byte[] bArr = new byte[bitLength];
        BigInteger xor = add.xor(bigInteger);
        int i11 = 1;
        while (i11 < bitLength) {
            if (xor.testBit(i11)) {
                bArr[i11 - 1] = (byte) (bigInteger.testBit(i11) ? -1 : 1);
                i11++;
            }
            i11++;
        }
        bArr[bitLength - 1] = 1;
        return bArr;
    }

    public static byte[] generateWindowNaf(int i11, BigInteger bigInteger) {
        if (i11 == 2) {
            return generateNaf(bigInteger);
        }
        if (i11 < 2 || i11 > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        } else if (bigInteger.signum() == 0) {
            return EMPTY_BYTES;
        } else {
            int bitLength = bigInteger.bitLength() + 1;
            byte[] bArr = new byte[bitLength];
            int i12 = 1 << i11;
            int i13 = i12 - 1;
            int i14 = i12 >>> 1;
            int i15 = 0;
            int i16 = 0;
            boolean z11 = false;
            while (i15 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i15) == z11) {
                    i15++;
                } else {
                    bigInteger = bigInteger.shiftRight(i15);
                    int intValue = bigInteger.intValue() & i13;
                    if (z11) {
                        intValue++;
                    }
                    z11 = (intValue & i14) != 0;
                    if (z11) {
                        intValue -= i12;
                    }
                    if (i16 > 0) {
                        i15--;
                    }
                    int i17 = i16 + i15;
                    bArr[i17] = (byte) intValue;
                    i16 = i17 + 1;
                    i15 = i11;
                }
            }
            return bitLength > i16 ? trim(bArr, i16) : bArr;
        }
    }

    public static int getNafWeight(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static WNafPreCompInfo getWNafPreCompInfo(ECPoint eCPoint) {
        return getWNafPreCompInfo(eCPoint.getCurve().getPreCompInfo(eCPoint, PRECOMP_NAME));
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof WNafPreCompInfo) {
            return (WNafPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static int getWindowSize(int i11) {
        return getWindowSize(i11, DEFAULT_WINDOW_SIZE_CUTOFFS, 16);
    }

    public static int getWindowSize(int i11, int i12) {
        return getWindowSize(i11, DEFAULT_WINDOW_SIZE_CUTOFFS, i12);
    }

    public static int getWindowSize(int i11, int[] iArr) {
        return getWindowSize(i11, iArr, 16);
    }

    public static int getWindowSize(int i11, int[] iArr, int i12) {
        int i13 = 0;
        while (i13 < iArr.length && i11 >= iArr[i13]) {
            i13++;
        }
        return Math.max(2, Math.min(i12, i13 + 2));
    }

    public static WNafPreCompInfo precompute(final ECPoint eCPoint, final int i11, final boolean z11) {
        final ECCurve curve = eCPoint.getCurve();
        return (WNafPreCompInfo) curve.precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
            private boolean checkExisting(WNafPreCompInfo wNafPreCompInfo, int i11, int i12, boolean z11) {
                return wNafPreCompInfo != null && wNafPreCompInfo.getWidth() >= Math.max(wNafPreCompInfo.getConfWidth(), i11) && checkTable(wNafPreCompInfo.getPreComp(), i12) && (!z11 || checkTable(wNafPreCompInfo.getPreCompNeg(), i12));
            }

            private boolean checkTable(ECPoint[] eCPointArr, int i11) {
                return eCPointArr != null && eCPointArr.length >= i11;
            }

            /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2 A[LOOP:0: B:43:0x00f0->B:44:0x00f2, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0117 A[LOOP:1: B:54:0x0115->B:55:0x0117, LOOP_END] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public org.bouncycastle.math.ec.PreCompInfo precompute(org.bouncycastle.math.ec.PreCompInfo r14) {
                /*
                    r13 = this;
                    boolean r0 = r14 instanceof org.bouncycastle.math.ec.WNafPreCompInfo
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    org.bouncycastle.math.ec.WNafPreCompInfo r14 = (org.bouncycastle.math.ec.WNafPreCompInfo) r14
                    goto L_0x0009
                L_0x0008:
                    r14 = r1
                L_0x0009:
                    int r0 = r3
                    r2 = 16
                    int r0 = java.lang.Math.min(r2, r0)
                    r3 = 2
                    int r0 = java.lang.Math.max(r3, r0)
                    int r4 = r0 + -2
                    r5 = 1
                    int r4 = r5 << r4
                    boolean r6 = r4
                    boolean r4 = r13.checkExisting(r14, r0, r4, r6)
                    if (r4 == 0) goto L_0x0027
                    r14.decrementPromotionCountdown()
                    return r14
                L_0x0027:
                    org.bouncycastle.math.ec.WNafPreCompInfo r4 = new org.bouncycastle.math.ec.WNafPreCompInfo
                    r4.<init>()
                    if (r14 == 0) goto L_0x0049
                    int r6 = r14.decrementPromotionCountdown()
                    r4.setPromotionCountdown(r6)
                    int r6 = r14.getConfWidth()
                    r4.setConfWidth(r6)
                    org.bouncycastle.math.ec.ECPoint[] r6 = r14.getPreComp()
                    org.bouncycastle.math.ec.ECPoint[] r7 = r14.getPreCompNeg()
                    org.bouncycastle.math.ec.ECPoint r14 = r14.getTwice()
                    goto L_0x004c
                L_0x0049:
                    r14 = r1
                    r6 = r14
                    r7 = r6
                L_0x004c:
                    int r8 = r4.getConfWidth()
                    int r0 = java.lang.Math.max(r8, r0)
                    int r0 = java.lang.Math.min(r2, r0)
                    int r2 = r0 + -2
                    int r2 = r5 << r2
                    r8 = 0
                    if (r6 != 0) goto L_0x0065
                    org.bouncycastle.math.ec.ECPoint[] r6 = org.bouncycastle.math.ec.WNafUtil.EMPTY_POINTS
                    r9 = r8
                    goto L_0x0066
                L_0x0065:
                    int r9 = r6.length
                L_0x0066:
                    if (r9 >= r2) goto L_0x0103
                    org.bouncycastle.math.ec.ECPoint[] r6 = org.bouncycastle.math.ec.WNafUtil.resizeTable(r6, r2)
                    if (r2 != r5) goto L_0x0078
                    org.bouncycastle.math.ec.ECPoint r1 = r2
                    org.bouncycastle.math.ec.ECPoint r1 = r1.normalize()
                    r6[r8] = r1
                    goto L_0x0103
                L_0x0078:
                    if (r9 != 0) goto L_0x0080
                    org.bouncycastle.math.ec.ECPoint r10 = r2
                    r6[r8] = r10
                    r10 = r5
                    goto L_0x0081
                L_0x0080:
                    r10 = r9
                L_0x0081:
                    if (r2 != r3) goto L_0x008d
                    org.bouncycastle.math.ec.ECPoint r3 = r2
                    org.bouncycastle.math.ec.ECPoint r3 = r3.threeTimes()
                    r6[r5] = r3
                    goto L_0x00fc
                L_0x008d:
                    int r5 = r10 + -1
                    r5 = r6[r5]
                    if (r14 != 0) goto L_0x00ef
                    r14 = r6[r8]
                    org.bouncycastle.math.ec.ECPoint r14 = r14.twice()
                    boolean r11 = r14.isInfinity()
                    if (r11 != 0) goto L_0x00ef
                    org.bouncycastle.math.ec.ECCurve r11 = r0
                    boolean r11 = org.bouncycastle.math.ec.ECAlgorithms.isFpCurve(r11)
                    if (r11 == 0) goto L_0x00ef
                    org.bouncycastle.math.ec.ECCurve r11 = r0
                    int r11 = r11.getFieldSize()
                    r12 = 64
                    if (r11 < r12) goto L_0x00ef
                    org.bouncycastle.math.ec.ECCurve r11 = r0
                    int r11 = r11.getCoordinateSystem()
                    if (r11 == r3) goto L_0x00c0
                    r3 = 3
                    if (r11 == r3) goto L_0x00c0
                    r3 = 4
                    if (r11 == r3) goto L_0x00c0
                    goto L_0x00ef
                L_0x00c0:
                    org.bouncycastle.math.ec.ECFieldElement r1 = r14.getZCoord(r8)
                    org.bouncycastle.math.ec.ECCurve r3 = r0
                    org.bouncycastle.math.ec.ECFieldElement r11 = r14.getXCoord()
                    java.math.BigInteger r11 = r11.toBigInteger()
                    org.bouncycastle.math.ec.ECFieldElement r12 = r14.getYCoord()
                    java.math.BigInteger r12 = r12.toBigInteger()
                    org.bouncycastle.math.ec.ECPoint r3 = r3.createPoint(r11, r12)
                    org.bouncycastle.math.ec.ECFieldElement r11 = r1.square()
                    org.bouncycastle.math.ec.ECFieldElement r12 = r11.multiply(r1)
                    org.bouncycastle.math.ec.ECPoint r5 = r5.scaleX(r11)
                    org.bouncycastle.math.ec.ECPoint r5 = r5.scaleY(r12)
                    if (r9 != 0) goto L_0x00f0
                    r6[r8] = r5
                    goto L_0x00f0
                L_0x00ef:
                    r3 = r14
                L_0x00f0:
                    if (r10 >= r2) goto L_0x00fc
                    int r11 = r10 + 1
                    org.bouncycastle.math.ec.ECPoint r5 = r5.add(r3)
                    r6[r10] = r5
                    r10 = r11
                    goto L_0x00f0
                L_0x00fc:
                    org.bouncycastle.math.ec.ECCurve r3 = r0
                    int r5 = r2 - r9
                    r3.normalizeAll(r6, r9, r5, r1)
                L_0x0103:
                    boolean r1 = r4
                    if (r1 == 0) goto L_0x0122
                    if (r7 != 0) goto L_0x010d
                    org.bouncycastle.math.ec.ECPoint[] r1 = new org.bouncycastle.math.ec.ECPoint[r2]
                L_0x010b:
                    r7 = r1
                    goto L_0x0115
                L_0x010d:
                    int r8 = r7.length
                    if (r8 >= r2) goto L_0x0115
                    org.bouncycastle.math.ec.ECPoint[] r1 = org.bouncycastle.math.ec.WNafUtil.resizeTable(r7, r2)
                    goto L_0x010b
                L_0x0115:
                    if (r8 >= r2) goto L_0x0122
                    r1 = r6[r8]
                    org.bouncycastle.math.ec.ECPoint r1 = r1.negate()
                    r7[r8] = r1
                    int r8 = r8 + 1
                    goto L_0x0115
                L_0x0122:
                    r4.setPreComp(r6)
                    r4.setPreCompNeg(r7)
                    r4.setTwice(r14)
                    r4.setWidth(r0)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.WNafUtil.AnonymousClass2.precompute(org.bouncycastle.math.ec.PreCompInfo):org.bouncycastle.math.ec.PreCompInfo");
            }
        });
    }

    public static WNafPreCompInfo precomputeWithPointMap(ECPoint eCPoint, final ECPointMap eCPointMap, final WNafPreCompInfo wNafPreCompInfo, final boolean z11) {
        return (WNafPreCompInfo) eCPoint.getCurve().precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
            private boolean checkExisting(WNafPreCompInfo wNafPreCompInfo, int i11, int i12, boolean z11) {
                return wNafPreCompInfo != null && wNafPreCompInfo.getWidth() >= i11 && checkTable(wNafPreCompInfo.getPreComp(), i12) && (!z11 || checkTable(wNafPreCompInfo.getPreCompNeg(), i12));
            }

            private boolean checkTable(ECPoint[] eCPointArr, int i11) {
                return eCPointArr != null && eCPointArr.length >= i11;
            }

            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                WNafPreCompInfo wNafPreCompInfo = preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo) preCompInfo : null;
                int width = wNafPreCompInfo.getWidth();
                if (checkExisting(wNafPreCompInfo, width, wNafPreCompInfo.getPreComp().length, z11)) {
                    wNafPreCompInfo.decrementPromotionCountdown();
                    return wNafPreCompInfo;
                }
                WNafPreCompInfo wNafPreCompInfo2 = new WNafPreCompInfo();
                wNafPreCompInfo2.setPromotionCountdown(wNafPreCompInfo.getPromotionCountdown());
                ECPoint twice = wNafPreCompInfo.getTwice();
                if (twice != null) {
                    wNafPreCompInfo2.setTwice(eCPointMap.map(twice));
                }
                ECPoint[] preComp = wNafPreCompInfo.getPreComp();
                int length = preComp.length;
                ECPoint[] eCPointArr = new ECPoint[length];
                for (int i11 = 0; i11 < preComp.length; i11++) {
                    eCPointArr[i11] = eCPointMap.map(preComp[i11]);
                }
                wNafPreCompInfo2.setPreComp(eCPointArr);
                wNafPreCompInfo2.setWidth(width);
                if (z11) {
                    ECPoint[] eCPointArr2 = new ECPoint[length];
                    for (int i12 = 0; i12 < length; i12++) {
                        eCPointArr2[i12] = eCPointArr[i12].negate();
                    }
                    wNafPreCompInfo2.setPreCompNeg(eCPointArr2);
                }
                return wNafPreCompInfo2;
            }
        });
    }

    /* access modifiers changed from: private */
    public static ECPoint[] resizeTable(ECPoint[] eCPointArr, int i11) {
        ECPoint[] eCPointArr2 = new ECPoint[i11];
        System.arraycopy(eCPointArr, 0, eCPointArr2, 0, eCPointArr.length);
        return eCPointArr2;
    }

    private static byte[] trim(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        return bArr2;
    }

    private static int[] trim(int[] iArr, int i11) {
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, i11);
        return iArr2;
    }
}
