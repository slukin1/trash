package com.google.android.exoplayer2.video;

import java.util.Arrays;

final class FixedFrameRateEstimator {
    public static final int CONSECUTIVE_MATCHING_FRAME_DURATIONS_FOR_SYNC = 15;
    public static final long MAX_MATCHING_FRAME_DIFFERENCE_NS = 1000000;
    private Matcher candidateMatcher = new Matcher();
    private boolean candidateMatcherActive;
    private Matcher currentMatcher = new Matcher();
    private int framesWithoutSyncCount;
    private long lastFramePresentationTimeNs = -9223372036854775807L;
    private boolean switchToCandidateMatcherWhenSynced;

    public static final class Matcher {
        private long firstFrameDurationNs;
        private long firstFramePresentationTimeNs;
        private long frameCount;
        private long lastFramePresentationTimeNs;
        private long matchingFrameCount;
        private long matchingFrameDurationSumNs;
        private int recentFrameOutlierCount;
        private final boolean[] recentFrameOutlierFlags = new boolean[15];

        private static int getRecentFrameOutlierIndex(long j11) {
            return (int) (j11 % 15);
        }

        public long getFrameDurationNs() {
            long j11 = this.matchingFrameCount;
            if (j11 == 0) {
                return 0;
            }
            return this.matchingFrameDurationSumNs / j11;
        }

        public long getMatchingFrameDurationSumNs() {
            return this.matchingFrameDurationSumNs;
        }

        public boolean isLastFrameOutlier() {
            long j11 = this.frameCount;
            if (j11 == 0) {
                return false;
            }
            return this.recentFrameOutlierFlags[getRecentFrameOutlierIndex(j11 - 1)];
        }

        public boolean isSynced() {
            return this.frameCount > 15 && this.recentFrameOutlierCount == 0;
        }

        public void onNextFrame(long j11) {
            long j12 = this.frameCount;
            if (j12 == 0) {
                this.firstFramePresentationTimeNs = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.firstFramePresentationTimeNs;
                this.firstFrameDurationNs = j13;
                this.matchingFrameDurationSumNs = j13;
                this.matchingFrameCount = 1;
            } else {
                long j14 = j11 - this.lastFramePresentationTimeNs;
                int recentFrameOutlierIndex = getRecentFrameOutlierIndex(j12);
                if (Math.abs(j14 - this.firstFrameDurationNs) <= 1000000) {
                    this.matchingFrameCount++;
                    this.matchingFrameDurationSumNs += j14;
                    boolean[] zArr = this.recentFrameOutlierFlags;
                    if (zArr[recentFrameOutlierIndex]) {
                        zArr[recentFrameOutlierIndex] = false;
                        this.recentFrameOutlierCount--;
                    }
                } else {
                    boolean[] zArr2 = this.recentFrameOutlierFlags;
                    if (!zArr2[recentFrameOutlierIndex]) {
                        zArr2[recentFrameOutlierIndex] = true;
                        this.recentFrameOutlierCount++;
                    }
                }
            }
            this.frameCount++;
            this.lastFramePresentationTimeNs = j11;
        }

        public void reset() {
            this.frameCount = 0;
            this.matchingFrameCount = 0;
            this.matchingFrameDurationSumNs = 0;
            this.recentFrameOutlierCount = 0;
            Arrays.fill(this.recentFrameOutlierFlags, false);
        }
    }

    public long getFrameDurationNs() {
        if (isSynced()) {
            return this.currentMatcher.getFrameDurationNs();
        }
        return -9223372036854775807L;
    }

    public float getFrameRate() {
        if (isSynced()) {
            return (float) (1.0E9d / ((double) this.currentMatcher.getFrameDurationNs()));
        }
        return -1.0f;
    }

    public int getFramesWithoutSyncCount() {
        return this.framesWithoutSyncCount;
    }

    public long getMatchingFrameDurationSumNs() {
        if (isSynced()) {
            return this.currentMatcher.getMatchingFrameDurationSumNs();
        }
        return -9223372036854775807L;
    }

    public boolean isSynced() {
        return this.currentMatcher.isSynced();
    }

    public void onNextFrame(long j11) {
        this.currentMatcher.onNextFrame(j11);
        int i11 = 0;
        if (this.currentMatcher.isSynced() && !this.switchToCandidateMatcherWhenSynced) {
            this.candidateMatcherActive = false;
        } else if (this.lastFramePresentationTimeNs != -9223372036854775807L) {
            if (!this.candidateMatcherActive || this.candidateMatcher.isLastFrameOutlier()) {
                this.candidateMatcher.reset();
                this.candidateMatcher.onNextFrame(this.lastFramePresentationTimeNs);
            }
            this.candidateMatcherActive = true;
            this.candidateMatcher.onNextFrame(j11);
        }
        if (this.candidateMatcherActive && this.candidateMatcher.isSynced()) {
            Matcher matcher = this.currentMatcher;
            this.currentMatcher = this.candidateMatcher;
            this.candidateMatcher = matcher;
            this.candidateMatcherActive = false;
            this.switchToCandidateMatcherWhenSynced = false;
        }
        this.lastFramePresentationTimeNs = j11;
        if (!this.currentMatcher.isSynced()) {
            i11 = this.framesWithoutSyncCount + 1;
        }
        this.framesWithoutSyncCount = i11;
    }

    public void reset() {
        this.currentMatcher.reset();
        this.candidateMatcher.reset();
        this.candidateMatcherActive = false;
        this.lastFramePresentationTimeNs = -9223372036854775807L;
        this.framesWithoutSyncCount = 0;
    }
}
