package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class SilenceMediaSource extends BaseMediaSource {
    private static final int CHANNEL_COUNT = 2;
    /* access modifiers changed from: private */
    public static final Format FORMAT;
    public static final String MEDIA_ID = "SilenceMediaSource";
    /* access modifiers changed from: private */
    public static final MediaItem MEDIA_ITEM;
    private static final int PCM_ENCODING = 2;
    private static final int SAMPLE_RATE_HZ = 44100;
    /* access modifiers changed from: private */
    public static final byte[] SILENCE_SAMPLE = new byte[(Util.getPcmFrameSize(2, 2) * 1024)];
    private final long durationUs;
    private final MediaItem mediaItem;

    public static final class Factory {
        private long durationUs;
        private Object tag;

        public SilenceMediaSource createMediaSource() {
            Assertions.checkState(this.durationUs > 0);
            return new SilenceMediaSource(this.durationUs, SilenceMediaSource.MEDIA_ITEM.buildUpon().setTag(this.tag).build());
        }

        public Factory setDurationUs(long j11) {
            this.durationUs = j11;
            return this;
        }

        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }
    }

    public static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray TRACKS = new TrackGroupArray(new TrackGroup(SilenceMediaSource.FORMAT));
        private final long durationUs;
        private final ArrayList<SampleStream> sampleStreams = new ArrayList<>();

        public SilenceMediaPeriod(long j11) {
            this.durationUs = j11;
        }

        private long constrainSeekPosition(long j11) {
            return Util.constrainValue(j11, 0, this.durationUs);
        }

        public boolean continueLoading(long j11) {
            return false;
        }

        public void discardBuffer(long j11, boolean z11) {
        }

        public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
            return constrainSeekPosition(j11);
        }

        public long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        public long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        public /* synthetic */ List getStreamKeys(List list) {
            return d.a(this, list);
        }

        public TrackGroupArray getTrackGroups() {
            return TRACKS;
        }

        public boolean isLoading() {
            return false;
        }

        public void maybeThrowPrepareError() {
        }

        public void prepare(MediaPeriod.Callback callback, long j11) {
            callback.onPrepared(this);
        }

        public long readDiscontinuity() {
            return -9223372036854775807L;
        }

        public void reevaluateBuffer(long j11) {
        }

        public long seekToUs(long j11) {
            long constrainSeekPosition = constrainSeekPosition(j11);
            for (int i11 = 0; i11 < this.sampleStreams.size(); i11++) {
                ((SilenceSampleStream) this.sampleStreams.get(i11)).seekTo(constrainSeekPosition);
            }
            return constrainSeekPosition;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r5, boolean[] r6, com.google.android.exoplayer2.source.SampleStream[] r7, boolean[] r8, long r9) {
            /*
                r4 = this;
                long r9 = r4.constrainSeekPosition(r9)
                r0 = 0
            L_0x0005:
                int r1 = r5.length
                if (r0 >= r1) goto L_0x003d
                r1 = r7[r0]
                if (r1 == 0) goto L_0x001e
                r1 = r5[r0]
                if (r1 == 0) goto L_0x0014
                boolean r1 = r6[r0]
                if (r1 != 0) goto L_0x001e
            L_0x0014:
                java.util.ArrayList<com.google.android.exoplayer2.source.SampleStream> r1 = r4.sampleStreams
                r2 = r7[r0]
                r1.remove(r2)
                r1 = 0
                r7[r0] = r1
            L_0x001e:
                r1 = r7[r0]
                if (r1 != 0) goto L_0x003a
                r1 = r5[r0]
                if (r1 == 0) goto L_0x003a
                com.google.android.exoplayer2.source.SilenceMediaSource$SilenceSampleStream r1 = new com.google.android.exoplayer2.source.SilenceMediaSource$SilenceSampleStream
                long r2 = r4.durationUs
                r1.<init>(r2)
                r1.seekTo(r9)
                java.util.ArrayList<com.google.android.exoplayer2.source.SampleStream> r2 = r4.sampleStreams
                r2.add(r1)
                r7[r0] = r1
                r1 = 1
                r8[r0] = r1
            L_0x003a:
                int r0 = r0 + 1
                goto L_0x0005
            L_0x003d:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SilenceMediaSource.SilenceMediaPeriod.selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
        }
    }

    public static final class SilenceSampleStream implements SampleStream {
        private final long durationBytes;
        private long positionBytes;
        private boolean sentFormat;

        public SilenceSampleStream(long j11) {
            this.durationBytes = SilenceMediaSource.getAudioByteCount(j11);
            seekTo(0);
        }

        public boolean isReady() {
            return true;
        }

        public void maybeThrowError() {
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (!this.sentFormat || (i11 & 2) != 0) {
                formatHolder.format = SilenceMediaSource.FORMAT;
                this.sentFormat = true;
                return -5;
            }
            long j11 = this.durationBytes;
            long j12 = this.positionBytes;
            long j13 = j11 - j12;
            if (j13 == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            decoderInputBuffer.timeUs = SilenceMediaSource.getAudioPositionUs(j12);
            decoderInputBuffer.addFlag(1);
            int min = (int) Math.min((long) SilenceMediaSource.SILENCE_SAMPLE.length, j13);
            if ((i11 & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(min);
                decoderInputBuffer.data.put(SilenceMediaSource.SILENCE_SAMPLE, 0, min);
            }
            if ((i11 & 1) == 0) {
                this.positionBytes += (long) min;
            }
            return -4;
        }

        public void seekTo(long j11) {
            this.positionBytes = Util.constrainValue(SilenceMediaSource.getAudioByteCount(j11), 0, this.durationBytes);
        }

        public int skipData(long j11) {
            long j12 = this.positionBytes;
            seekTo(j11);
            return (int) ((this.positionBytes - j12) / ((long) SilenceMediaSource.SILENCE_SAMPLE.length));
        }
    }

    static {
        Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(2).setSampleRate(44100).setPcmEncoding(2).build();
        FORMAT = build;
        MEDIA_ITEM = new MediaItem.Builder().setMediaId(MEDIA_ID).setUri(Uri.EMPTY).setMimeType(build.sampleMimeType).build();
    }

    /* access modifiers changed from: private */
    public static long getAudioByteCount(long j11) {
        return ((long) Util.getPcmFrameSize(2, 2)) * ((j11 * 44100) / 1000000);
    }

    /* access modifiers changed from: private */
    public static long getAudioPositionUs(long j11) {
        return ((j11 / ((long) Util.getPcmFrameSize(2, 2))) * 1000000) / 44100;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        return new SilenceMediaPeriod(this.durationUs);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Deprecated
    public Object getTag() {
        return ((MediaItem.PlaybackProperties) Assertions.checkNotNull(this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        refreshSourceInfo(new SinglePeriodTimeline(this.durationUs, true, false, false, (Object) null, this.mediaItem));
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    public void releaseSourceInternal() {
    }

    public SilenceMediaSource(long j11) {
        this(j11, MEDIA_ITEM);
    }

    private SilenceMediaSource(long j11, MediaItem mediaItem2) {
        Assertions.checkArgument(j11 >= 0);
        this.durationUs = j11;
        this.mediaItem = mediaItem2;
    }
}
