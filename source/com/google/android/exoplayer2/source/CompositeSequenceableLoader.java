package com.google.android.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader {
    public final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    public boolean continueLoading(long j11) {
        long j12 = j11;
        boolean z11 = false;
        while (true) {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                boolean z12 = false;
                for (SequenceableLoader sequenceableLoader : this.loaders) {
                    long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                    boolean z13 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j12;
                    if (nextLoadPositionUs2 == nextLoadPositionUs || z13) {
                        z12 |= sequenceableLoader.continueLoading(j12);
                    }
                }
                z11 |= z12;
                if (!z12) {
                    break;
                }
            } else {
                break;
            }
        }
        return z11;
    }

    public final long getBufferedPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (SequenceableLoader bufferedPositionUs : this.loaders) {
            long bufferedPositionUs2 = bufferedPositionUs.getBufferedPositionUs();
            if (bufferedPositionUs2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, bufferedPositionUs2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final long getNextLoadPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (SequenceableLoader nextLoadPositionUs : this.loaders) {
            long nextLoadPositionUs2 = nextLoadPositionUs.getNextLoadPositionUs();
            if (nextLoadPositionUs2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, nextLoadPositionUs2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public boolean isLoading() {
        for (SequenceableLoader isLoading : this.loaders) {
            if (isLoading.isLoading()) {
                return true;
            }
        }
        return false;
    }

    public final void reevaluateBuffer(long j11) {
        for (SequenceableLoader reevaluateBuffer : this.loaders) {
            reevaluateBuffer.reevaluateBuffer(j11);
        }
    }
}
