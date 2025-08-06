package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int i11) {
            this(i11, new Random());
        }

        private static int[] createShuffledList(int i11, Random random2) {
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                int nextInt = random2.nextInt(i13);
                iArr[i12] = iArr[nextInt];
                iArr[nextInt] = i12;
                i12 = i13;
            }
            return iArr;
        }

        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        public ShuffleOrder cloneAndInsert(int i11, int i12) {
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int i13 = 0;
            int i14 = 0;
            while (i14 < i12) {
                iArr[i14] = this.random.nextInt(this.shuffled.length + 1);
                int i15 = i14 + 1;
                int nextInt = this.random.nextInt(i15);
                iArr2[i14] = iArr2[nextInt];
                iArr2[nextInt] = i14 + i11;
                i14 = i15;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[(this.shuffled.length + i12)];
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.shuffled;
                if (i13 >= iArr4.length + i12) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
                }
                if (i16 >= i12 || i17 != iArr[i16]) {
                    int i18 = i17 + 1;
                    iArr3[i13] = iArr4[i17];
                    if (iArr3[i13] >= i11) {
                        iArr3[i13] = iArr3[i13] + i12;
                    }
                    i17 = i18;
                } else {
                    iArr3[i13] = iArr2[i16];
                    i16++;
                }
                i13++;
            }
        }

        public ShuffleOrder cloneAndRemove(int i11, int i12) {
            int i13 = i12 - i11;
            int[] iArr = new int[(this.shuffled.length - i13)];
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i14 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
                if (iArr2[i14] < i11 || iArr2[i14] >= i12) {
                    iArr[i14 - i15] = iArr2[i14] >= i11 ? iArr2[i14] - i13 : iArr2[i14];
                } else {
                    i15++;
                }
                i14++;
            }
        }

        public int getFirstIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        public int getLastIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        public int getLength() {
            return this.shuffled.length;
        }

        public int getNextIndex(int i11) {
            int i12 = this.indexInShuffled[i11] + 1;
            int[] iArr = this.shuffled;
            if (i12 < iArr.length) {
                return iArr[i12];
            }
            return -1;
        }

        public int getPreviousIndex(int i11) {
            int i12 = this.indexInShuffled[i11] - 1;
            if (i12 >= 0) {
                return this.shuffled[i12];
            }
            return -1;
        }

        public DefaultShuffleOrder(int i11, long j11) {
            this(i11, new Random(j11));
        }

        public DefaultShuffleOrder(int[] iArr, long j11) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j11));
        }

        private DefaultShuffleOrder(int i11, Random random2) {
            this(createShuffledList(i11, random2), random2);
        }

        private DefaultShuffleOrder(int[] iArr, Random random2) {
            this.shuffled = iArr;
            this.random = random2;
            this.indexInShuffled = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.indexInShuffled[iArr[i11]] = i11;
            }
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        public UnshuffledShuffleOrder(int i11) {
            this.length = i11;
        }

        public ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        public ShuffleOrder cloneAndInsert(int i11, int i12) {
            return new UnshuffledShuffleOrder(this.length + i12);
        }

        public ShuffleOrder cloneAndRemove(int i11, int i12) {
            return new UnshuffledShuffleOrder((this.length - i12) + i11);
        }

        public int getFirstIndex() {
            return this.length > 0 ? 0 : -1;
        }

        public int getLastIndex() {
            int i11 = this.length;
            if (i11 > 0) {
                return i11 - 1;
            }
            return -1;
        }

        public int getLength() {
            return this.length;
        }

        public int getNextIndex(int i11) {
            int i12 = i11 + 1;
            if (i12 < this.length) {
                return i12;
            }
            return -1;
        }

        public int getPreviousIndex(int i11) {
            int i12 = i11 - 1;
            if (i12 >= 0) {
                return i12;
            }
            return -1;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int i11, int i12);

    ShuffleOrder cloneAndRemove(int i11, int i12);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i11);

    int getPreviousIndex(int i11);
}
