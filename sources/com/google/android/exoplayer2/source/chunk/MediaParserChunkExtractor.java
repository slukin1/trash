package com.google.android.exoplayer2.source.chunk;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class MediaParserChunkExtractor implements ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = b.f66001a;
    private static final String TAG = "MediaPrsrChunkExtractor";
    /* access modifiers changed from: private */
    public final DummyTrackOutput dummyTrackOutput;
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    /* access modifiers changed from: private */
    public final OutputConsumerAdapterV30 outputConsumerAdapter;
    private long pendingSeekUs;
    /* access modifiers changed from: private */
    public Format[] sampleFormats;
    /* access modifiers changed from: private */
    public ChunkExtractor.TrackOutputProvider trackOutputProvider;
    private final TrackOutputProviderAdapter trackOutputProviderAdapter;

    public class TrackOutputProviderAdapter implements ExtractorOutput {
        private TrackOutputProviderAdapter() {
        }

        public void endTracks() {
            MediaParserChunkExtractor mediaParserChunkExtractor = MediaParserChunkExtractor.this;
            Format[] unused = mediaParserChunkExtractor.sampleFormats = mediaParserChunkExtractor.outputConsumerAdapter.getSampleFormats();
        }

        public void seekMap(SeekMap seekMap) {
        }

        public TrackOutput track(int i11, int i12) {
            return MediaParserChunkExtractor.this.trackOutputProvider != null ? MediaParserChunkExtractor.this.trackOutputProvider.track(i11, i12) : MediaParserChunkExtractor.this.dummyTrackOutput;
        }
    }

    @SuppressLint({"WrongConstant"})
    public MediaParserChunkExtractor(int i11, Format format, List<Format> list) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i11, true);
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        String str = MimeTypes.isMatroska((String) Assertions.checkNotNull(format.containerMimeType)) ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        outputConsumerAdapterV30.setSelectedParserName(str);
        MediaParser createByName = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.mediaParser = createByName;
        Boolean bool = Boolean.TRUE;
        createByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_DUMMY_SEEK_MAP, bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CHUNK_INDEX_AS_MEDIA_FORMAT, bool);
        createByName.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, bool);
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(MediaParserUtil.toCaptionsMediaFormat(list.get(i12)));
        }
        this.mediaParser.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, arrayList);
        this.outputConsumerAdapter.setMuxedCaptionFormats(list);
        this.trackOutputProviderAdapter = new TrackOutputProviderAdapter();
        this.dummyTrackOutput = new DummyTrackOutput();
        this.pendingSeekUs = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ChunkExtractor lambda$static$0(int i11, Format format, boolean z11, List list, TrackOutput trackOutput) {
        if (!MimeTypes.isText(format.containerMimeType)) {
            return new MediaParserChunkExtractor(i11, format, list);
        }
        Log.w(TAG, "Ignoring an unsupported text track.");
        return null;
    }

    private void maybeExecutePendingSeek() {
        MediaParser.SeekMap dummySeekMap = this.outputConsumerAdapter.getDummySeekMap();
        long j11 = this.pendingSeekUs;
        if (j11 != -9223372036854775807L && dummySeekMap != null) {
            this.mediaParser.seek((MediaParser.SeekPoint) dummySeekMap.getSeekPoints(j11).first);
            this.pendingSeekUs = -9223372036854775807L;
        }
    }

    public ChunkIndex getChunkIndex() {
        return this.outputConsumerAdapter.getChunkIndex();
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j11, long j12) {
        this.trackOutputProvider = trackOutputProvider2;
        this.outputConsumerAdapter.setSampleTimestampUpperLimitFilterUs(j12);
        this.outputConsumerAdapter.setExtractorOutput(this.trackOutputProviderAdapter);
        this.pendingSeekUs = j11;
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        maybeExecutePendingSeek();
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    public void release() {
        this.mediaParser.release();
    }
}
