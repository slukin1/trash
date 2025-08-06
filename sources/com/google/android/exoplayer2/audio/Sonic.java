package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int BYTES_PER_SAMPLE = 2;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int i11, int i12, float f11, float f12, int i13) {
        this.inputSampleRateHz = i11;
        this.channelCount = i12;
        this.speed = f11;
        this.pitch = f12;
        this.rate = ((float) i11) / ((float) i13);
        this.minPeriod = i11 / 400;
        int i14 = i11 / 65;
        this.maxPeriod = i14;
        int i15 = i14 * 2;
        this.maxRequiredFrameCount = i15;
        this.downSampleBuffer = new short[i15];
        this.inputBuffer = new short[(i15 * i12)];
        this.outputBuffer = new short[(i15 * i12)];
        this.pitchBuffer = new short[(i15 * i12)];
    }

    private void adjustRate(float f11, int i11) {
        int i12;
        int i13;
        if (this.outputFrameCount != i11) {
            int i14 = this.inputSampleRateHz;
            int i15 = (int) (((float) i14) / f11);
            while (true) {
                if (i15 <= 16384 && i14 <= 16384) {
                    break;
                }
                i15 /= 2;
                i14 /= 2;
            }
            moveNewSamplesToPitchBuffer(i11);
            int i16 = 0;
            while (true) {
                int i17 = this.pitchFrameCount;
                boolean z11 = true;
                if (i16 < i17 - 1) {
                    while (true) {
                        i12 = this.oldRatePosition;
                        int i18 = (i12 + 1) * i15;
                        i13 = this.newRatePosition;
                        if (i18 <= i13 * i14) {
                            break;
                        }
                        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                        int i19 = 0;
                        while (true) {
                            int i21 = this.channelCount;
                            if (i19 >= i21) {
                                break;
                            }
                            this.outputBuffer[(this.outputFrameCount * i21) + i19] = interpolate(this.pitchBuffer, (i21 * i16) + i19, i14, i15);
                            i19++;
                        }
                        this.newRatePosition++;
                        this.outputFrameCount++;
                    }
                    int i22 = i12 + 1;
                    this.oldRatePosition = i22;
                    if (i22 == i14) {
                        this.oldRatePosition = 0;
                        if (i13 != i15) {
                            z11 = false;
                        }
                        Assertions.checkState(z11);
                        this.newRatePosition = 0;
                    }
                    i16++;
                } else {
                    removePitchFrames(i17 - 1);
                    return;
                }
            }
        }
    }

    private void changeSpeed(float f11) {
        int insertPitchPeriod;
        int i11 = this.inputFrameCount;
        if (i11 >= this.maxRequiredFrameCount) {
            int i12 = 0;
            do {
                if (this.remainingInputToCopyFrameCount > 0) {
                    insertPitchPeriod = copyInputToOutput(i12);
                } else {
                    int findPitchPeriod = findPitchPeriod(this.inputBuffer, i12);
                    if (((double) f11) > 1.0d) {
                        insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i12, f11, findPitchPeriod);
                    } else {
                        insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i12, f11, findPitchPeriod);
                    }
                }
                i12 += insertPitchPeriod;
            } while (this.maxRequiredFrameCount + i12 <= i11);
            removeProcessedInputFrames(i12);
        }
    }

    private int copyInputToOutput(int i11) {
        int min = Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        copyToOutput(this.inputBuffer, i11, min);
        this.remainingInputToCopyFrameCount -= min;
        return min;
    }

    private void copyToOutput(short[] sArr, int i11, int i12) {
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i12);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i13 = this.channelCount;
        System.arraycopy(sArr, i11 * i13, ensureSpaceForAdditionalFrames, this.outputFrameCount * i13, i13 * i12);
        this.outputFrameCount += i12;
    }

    private void downSampleInput(short[] sArr, int i11, int i12) {
        int i13 = this.maxRequiredFrameCount / i12;
        int i14 = this.channelCount;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.downSampleBuffer[i17] = (short) (i18 / i15);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.channelCount;
        int i14 = length / i13;
        if (i11 + i12 <= i14) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    private int findPitchPeriod(short[] sArr, int i11) {
        int i12;
        int i13 = this.inputSampleRateHz;
        int i14 = i13 > 4000 ? i13 / 4000 : 1;
        if (this.channelCount == 1 && i14 == 1) {
            i12 = findPitchPeriodInRange(sArr, i11, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i11, i14);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i14, this.maxPeriod / i14);
            if (i14 != 1) {
                int i15 = findPitchPeriodInRange * i14;
                int i16 = i14 * 4;
                int i17 = i15 - i16;
                int i18 = i15 + i16;
                int i19 = this.minPeriod;
                if (i17 < i19) {
                    i17 = i19;
                }
                int i21 = this.maxPeriod;
                if (i18 > i21) {
                    i18 = i21;
                }
                if (this.channelCount == 1) {
                    i12 = findPitchPeriodInRange(sArr, i11, i17, i18);
                } else {
                    downSampleInput(sArr, i11, 1);
                    i12 = findPitchPeriodInRange(this.downSampleBuffer, 0, i17, i18);
                }
            } else {
                i12 = findPitchPeriodInRange;
            }
        }
        int i22 = previousPeriodBetter(this.minDiff, this.maxDiff) ? this.prevPeriod : i12;
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i12;
        return i22;
    }

    private int findPitchPeriodInRange(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.channelCount;
        int i15 = 1;
        int i16 = 255;
        int i17 = 0;
        int i18 = 0;
        while (i12 <= i13) {
            int i19 = 0;
            for (int i21 = 0; i21 < i12; i21++) {
                i19 += Math.abs(sArr[i14 + i21] - sArr[(i14 + i12) + i21]);
            }
            if (i19 * i17 < i15 * i12) {
                i17 = i12;
                i15 = i19;
            }
            if (i19 * i16 > i18 * i12) {
                i16 = i12;
                i18 = i19;
            }
            i12++;
        }
        this.minDiff = i15 / i17;
        this.maxDiff = i18 / i16;
        return i17;
    }

    private int insertPitchPeriod(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((((float) i12) * f11) / (1.0f - f11));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i12) * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i14);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i15 = this.channelCount;
        System.arraycopy(sArr, i11 * i15, ensureSpaceForAdditionalFrames, this.outputFrameCount * i15, i15 * i12);
        overlapAdd(i13, this.channelCount, this.outputBuffer, this.outputFrameCount + i12, sArr, i11 + i12, sArr, i11);
        this.outputFrameCount += i14;
        return i13;
    }

    private short interpolate(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.channelCount];
        int i14 = this.newRatePosition * i12;
        int i15 = this.oldRatePosition;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    private void moveNewSamplesToPitchBuffer(int i11) {
        int i12 = this.outputFrameCount - i11;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, i12);
        this.pitchBuffer = ensureSpaceForAdditionalFrames;
        short[] sArr = this.outputBuffer;
        int i13 = this.channelCount;
        System.arraycopy(sArr, i11 * i13, ensureSpaceForAdditionalFrames, this.pitchFrameCount * i13, i13 * i12);
        this.outputFrameCount = i11;
        this.pitchFrameCount += i12;
    }

    private static void overlapAdd(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = (i13 * i12) + i16;
            int i18 = (i15 * i12) + i16;
            int i19 = (i14 * i12) + i16;
            for (int i21 = 0; i21 < i11; i21++) {
                sArr[i17] = (short) (((sArr2[i19] * (i11 - i21)) + (sArr3[i18] * i21)) / i11);
                i17 += i12;
                i19 += i12;
                i18 += i12;
            }
        }
    }

    private boolean previousPeriodBetter(int i11, int i12) {
        if (i11 == 0 || this.prevPeriod == 0 || i12 > i11 * 3 || i11 * 2 <= this.prevMinDiff * 3) {
            return false;
        }
        return true;
    }

    private void processStreamInput() {
        int i11 = this.outputFrameCount;
        float f11 = this.speed;
        float f12 = this.pitch;
        float f13 = f11 / f12;
        float f14 = this.rate * f12;
        double d11 = (double) f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            changeSpeed(f13);
        } else {
            copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if (f14 != 1.0f) {
            adjustRate(f14, i11);
        }
    }

    private void removePitchFrames(int i11) {
        if (i11 != 0) {
            short[] sArr = this.pitchBuffer;
            int i12 = this.channelCount;
            System.arraycopy(sArr, i11 * i12, sArr, 0, (this.pitchFrameCount - i11) * i12);
            this.pitchFrameCount -= i11;
        }
    }

    private void removeProcessedInputFrames(int i11) {
        int i12 = this.inputFrameCount - i11;
        short[] sArr = this.inputBuffer;
        int i13 = this.channelCount;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.inputFrameCount = i12;
    }

    private int skipPitchPeriod(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (((float) i12) / (f11 - 1.0f));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i12) * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i13);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        overlapAdd(i13, this.channelCount, ensureSpaceForAdditionalFrames, this.outputFrameCount, sArr, i11, sArr, i11 + i12);
        this.outputFrameCount += i13;
        return i13;
    }

    public void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer.put(this.outputBuffer, 0, this.channelCount * min);
        int i11 = this.outputFrameCount - min;
        this.outputFrameCount = i11;
        short[] sArr = this.outputBuffer;
        int i12 = this.channelCount;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public int getOutputSize() {
        return this.outputFrameCount * this.channelCount * 2;
    }

    public int getPendingInputBytes() {
        return this.inputFrameCount * this.channelCount * 2;
    }

    public void queueEndOfStream() {
        int i11;
        int i12 = this.inputFrameCount;
        float f11 = this.speed;
        float f12 = this.pitch;
        int i13 = this.outputFrameCount + ((int) ((((((float) i12) / (f11 / f12)) + ((float) this.pitchFrameCount)) / (this.rate * f12)) + 0.5f));
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, i12, (this.maxRequiredFrameCount * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.maxRequiredFrameCount;
            int i15 = this.channelCount;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.inputBuffer[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.inputFrameCount += i11 * 2;
        processStreamInput();
        if (this.outputFrameCount > i13) {
            this.outputFrameCount = i13;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.channelCount;
        int i12 = remaining / i11;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, i12);
        this.inputBuffer = ensureSpaceForAdditionalFrames;
        shortBuffer.get(ensureSpaceForAdditionalFrames, this.inputFrameCount * this.channelCount, ((i11 * i12) * 2) / 2);
        this.inputFrameCount += i12;
        processStreamInput();
    }
}
