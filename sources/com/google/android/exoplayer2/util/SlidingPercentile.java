package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    private static final Comparator<Sample> INDEX_COMPARATOR = d.f66089b;
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator<Sample> VALUE_COMPARATOR = e.f66090b;
    private int currentSortOrder = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int totalWeight;

    public static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }

    public SlidingPercentile(int i11) {
        this.maxWeight = i11;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Sample sample, Sample sample2) {
        return sample.index - sample2.index;
    }

    public void addSample(int i11, float f11) {
        Sample sample;
        ensureSortedByIndex();
        int i12 = this.recycledSampleCount;
        if (i12 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i13 = i12 - 1;
            this.recycledSampleCount = i13;
            sample = sampleArr[i13];
        } else {
            sample = new Sample();
        }
        int i14 = this.nextSampleIndex;
        this.nextSampleIndex = i14 + 1;
        sample.index = i14;
        sample.weight = i11;
        sample.value = f11;
        this.samples.add(sample);
        this.totalWeight += i11;
        while (true) {
            int i15 = this.totalWeight;
            int i16 = this.maxWeight;
            if (i15 > i16) {
                int i17 = i15 - i16;
                Sample sample2 = this.samples.get(0);
                int i18 = sample2.weight;
                if (i18 <= i17) {
                    this.totalWeight -= i18;
                    this.samples.remove(0);
                    int i19 = this.recycledSampleCount;
                    if (i19 < 5) {
                        Sample[] sampleArr2 = this.recycledSamples;
                        this.recycledSampleCount = i19 + 1;
                        sampleArr2[i19] = sample2;
                    }
                } else {
                    sample2.weight = i18 - i17;
                    this.totalWeight -= i17;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f11) {
        ensureSortedByValue();
        float f12 = f11 * ((float) this.totalWeight);
        int i11 = 0;
        for (int i12 = 0; i12 < this.samples.size(); i12++) {
            Sample sample = this.samples.get(i12);
            i11 += sample.weight;
            if (((float) i11) >= f12) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.samples;
        return arrayList.get(arrayList.size() - 1).value;
    }

    public void reset() {
        this.samples.clear();
        this.currentSortOrder = -1;
        this.nextSampleIndex = 0;
        this.totalWeight = 0;
    }
}
