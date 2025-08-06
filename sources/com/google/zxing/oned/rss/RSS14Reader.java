package com.google.zxing.oned.rss;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private static final int[] INSIDE_GSUM = {0, 336, AnalyticsListener.EVENT_PLAYER_RELEASED, 1516};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, TXLiveConstants.PLAY_EVT_STREAM_SWITCH_SUCC, 2715};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair != null) {
            boolean z11 = false;
            Iterator<Pair> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Pair next = it2.next();
                if (next.getValue() == pair.getValue()) {
                    next.incrementCount();
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                collection.add(pair);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r1 < 4) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        r5 = false;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r2 = false;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r1 < 4) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adjustOddEvenCounts(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            r9 = this;
            int[] r0 = r9.getOddCounts()
            int r0 = com.google.zxing.common.detector.MathUtils.sum(r0)
            int[] r1 = r9.getEvenCounts()
            int r1 = com.google.zxing.common.detector.MathUtils.sum(r1)
            r2 = 4
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0029
            r5 = 12
            if (r0 <= r5) goto L_0x001c
            r6 = r3
            r7 = r4
            goto L_0x0023
        L_0x001c:
            if (r0 >= r2) goto L_0x0021
            r7 = r3
            r6 = r4
            goto L_0x0023
        L_0x0021:
            r6 = r3
            r7 = r6
        L_0x0023:
            if (r1 <= r5) goto L_0x0026
            goto L_0x003c
        L_0x0026:
            if (r1 >= r2) goto L_0x0044
            goto L_0x0041
        L_0x0029:
            r5 = 11
            if (r0 <= r5) goto L_0x0030
            r6 = r3
            r7 = r4
            goto L_0x0038
        L_0x0030:
            r5 = 5
            if (r0 >= r5) goto L_0x0036
            r7 = r3
            r6 = r4
            goto L_0x0038
        L_0x0036:
            r6 = r3
            r7 = r6
        L_0x0038:
            r5 = 10
            if (r1 <= r5) goto L_0x003f
        L_0x003c:
            r2 = r3
            r5 = r4
            goto L_0x0046
        L_0x003f:
            if (r1 >= r2) goto L_0x0044
        L_0x0041:
            r5 = r3
            r2 = r4
            goto L_0x0046
        L_0x0044:
            r2 = r3
            r5 = r2
        L_0x0046:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r10) goto L_0x004f
            r10 = r4
            goto L_0x0050
        L_0x004f:
            r10 = r3
        L_0x0050:
            r11 = r1 & 1
            if (r11 != r4) goto L_0x0055
            r3 = r4
        L_0x0055:
            if (r8 != r4) goto L_0x006c
            if (r10 == 0) goto L_0x0062
            if (r3 != 0) goto L_0x005d
            r7 = r4
            goto L_0x0065
        L_0x005d:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0062:
            if (r3 == 0) goto L_0x0067
            r5 = r4
        L_0x0065:
            r4 = r6
            goto L_0x0097
        L_0x0067:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x006c:
            r11 = -1
            if (r8 != r11) goto L_0x0082
            if (r10 == 0) goto L_0x0079
            if (r3 != 0) goto L_0x0074
            goto L_0x0097
        L_0x0074:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0079:
            if (r3 == 0) goto L_0x007d
            r2 = r4
            goto L_0x0065
        L_0x007d:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0082:
            if (r8 != 0) goto L_0x00e1
            if (r10 == 0) goto L_0x0094
            if (r3 == 0) goto L_0x008f
            if (r0 >= r1) goto L_0x008c
            r5 = r4
            goto L_0x0097
        L_0x008c:
            r2 = r4
            r7 = r2
            goto L_0x0065
        L_0x008f:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x0094:
            if (r3 != 0) goto L_0x00dc
            goto L_0x0065
        L_0x0097:
            if (r4 == 0) goto L_0x00ac
            if (r7 != 0) goto L_0x00a7
            int[] r10 = r9.getOddCounts()
            float[] r11 = r9.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.increment(r10, r11)
            goto L_0x00ac
        L_0x00a7:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00ac:
            if (r7 == 0) goto L_0x00b9
            int[] r10 = r9.getOddCounts()
            float[] r11 = r9.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.decrement(r10, r11)
        L_0x00b9:
            if (r2 == 0) goto L_0x00ce
            if (r5 != 0) goto L_0x00c9
            int[] r10 = r9.getEvenCounts()
            float[] r11 = r9.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.increment(r10, r11)
            goto L_0x00ce
        L_0x00c9:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00ce:
            if (r5 == 0) goto L_0x00db
            int[] r10 = r9.getEvenCounts()
            float[] r11 = r9.getEvenRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.decrement(r10, r11)
        L_0x00db:
            return
        L_0x00dc:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x00e1:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSS14Reader.adjustOddEvenCounts(boolean, int):void");
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(valueOf);
        int i11 = 0;
        for (int i12 = 0; i12 < 13; i12++) {
            int charAt = sb2.charAt(i12) - '0';
            if ((i12 & 1) == 0) {
                charAt *= 3;
            }
            i11 += charAt;
        }
        int i13 = 10 - (i11 % 10);
        if (i13 == 10) {
            i13 = 0;
        }
        sb2.append(i13);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(sb2.toString(), (byte[]) null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z11) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i11 = 0; i11 < dataCharacterCounters.length; i11++) {
            dataCharacterCounters[i11] = 0;
        }
        if (z11) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i12 = 0;
            for (int length = dataCharacterCounters.length - 1; i12 < length; length--) {
                int i13 = dataCharacterCounters[i12];
                dataCharacterCounters[i12] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i13;
                i12++;
            }
        }
        int i14 = z11 ? 16 : 15;
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / ((float) i14);
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i15 = 0; i15 < dataCharacterCounters.length; i15++) {
            float f11 = ((float) dataCharacterCounters[i15]) / sum;
            int i16 = (int) (0.5f + f11);
            if (i16 <= 0) {
                i16 = 1;
            } else if (i16 > 8) {
                i16 = 8;
            }
            int i17 = i15 / 2;
            if ((i15 & 1) == 0) {
                oddCounts[i17] = i16;
                oddRoundingErrors[i17] = f11 - ((float) i16);
            } else {
                evenCounts[i17] = i16;
                evenRoundingErrors[i17] = f11 - ((float) i16);
            }
        }
        adjustOddEvenCounts(z11, i14);
        int i18 = 0;
        int i19 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            i18 = (i18 * 9) + oddCounts[length2];
            i19 += oddCounts[length2];
        }
        int i21 = 0;
        int i22 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i21 = (i21 * 9) + evenCounts[length3];
            i22 += evenCounts[length3];
        }
        int i23 = i18 + (i21 * 3);
        if (z11) {
            if ((i19 & 1) != 0 || i19 > 12 || i19 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i24 = (12 - i19) / 2;
            int i25 = OUTSIDE_ODD_WIDEST[i24];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i25, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i24]) + RSSUtils.getRSSvalue(evenCounts, 9 - i25, true) + OUTSIDE_GSUM[i24], i23);
        } else if ((i22 & 1) != 0 || i22 > 10 || i22 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i26 = (10 - i22) / 2;
            int i27 = INSIDE_ODD_WIDEST[i26];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i27, false) * INSIDE_ODD_TOTAL_SUBSET[i26]) + RSSUtils.getRSSvalue(oddCounts, i27, true) + INSIDE_GSUM[i26], i23);
        }
    }

    private Pair decodePair(BitArray bitArray, boolean z11, int i11, Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, z11);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i11, z11, findFinderPattern);
            if (map == null) {
                resultPointCallback = null;
            } else {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (resultPointCallback != null) {
                float f11 = ((float) (findFinderPattern[0] + findFinderPattern[1])) / 2.0f;
                if (z11) {
                    f11 = ((float) (bitArray.getSize() - 1)) - f11;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f11, (float) i11));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, boolean z11) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i11 = 0;
        boolean z12 = false;
        while (i11 < size) {
            z12 = !bitArray.get(i11);
            if (z11 == z12) {
                break;
            }
            i11++;
        }
        int i12 = 0;
        int i13 = i11;
        while (i11 < size) {
            if (bitArray.get(i11) != z12) {
                decodeFinderCounters[i12] = decodeFinderCounters[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i13, i11};
                } else {
                    i13 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i12--;
                }
                decodeFinderCounters[i12] = 1;
                z12 = !z12;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i11, boolean z11, int[] iArr) throws NotFoundException {
        int i12;
        int i13;
        boolean z12 = bitArray.get(iArr[0]);
        int i14 = iArr[0] - 1;
        while (i14 >= 0 && z12 != bitArray.get(i14)) {
            i14--;
        }
        int i15 = i14 + 1;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = iArr[0] - i15;
        int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i16 = iArr[1];
        if (z11) {
            i12 = (bitArray.getSize() - 1) - i16;
            i13 = (bitArray.getSize() - 1) - i15;
        } else {
            i12 = i16;
            i13 = i15;
        }
        return new FinderPattern(parseFinderValue, new int[]{i15, iArr[1]}, i13, i12, i11);
    }

    public Result decodeRow(int i11, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i11, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i11, map));
        bitArray.reverse();
        for (Pair next : this.possibleLeftPairs) {
            if (next.getCount() > 1) {
                for (Pair next2 : this.possibleRightPairs) {
                    if (next2.getCount() > 1 && checkChecksum(next, next2)) {
                        return constructResult(next, next2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
