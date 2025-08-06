package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER = {8, 13, 11, 2, 0, 1, 7};
    private final boolean exposeCea608WhenMissingDeclarations;
    private final int payloadReaderFactoryFlags;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    private static void addFileTypeIfValidAndNotPresent(int i11, List<Integer> list) {
        if (Ints.indexOf(DEFAULT_EXTRACTOR_ORDER, i11) != -1 && !list.contains(Integer.valueOf(i11))) {
            list.add(Integer.valueOf(i11));
        }
    }

    @SuppressLint({"SwitchIntDef"})
    private Extractor createExtractorByFileType(int i11, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        if (i11 == 0) {
            return new Ac3Extractor();
        }
        if (i11 == 1) {
            return new Ac4Extractor();
        }
        if (i11 == 2) {
            return new AdtsExtractor();
        }
        if (i11 == 7) {
            return new Mp3Extractor(0, 0);
        }
        if (i11 == 8) {
            return createFragmentedMp4Extractor(timestampAdjuster, format, list);
        }
        if (i11 == 11) {
            return createTsExtractor(this.payloadReaderFactoryFlags, this.exposeCea608WhenMissingDeclarations, format, list, timestampAdjuster);
        }
        if (i11 != 13) {
            return null;
        }
        return new WebvttExtractor(format.language, timestampAdjuster);
    }

    private static FragmentedMp4Extractor createFragmentedMp4Extractor(TimestampAdjuster timestampAdjuster, Format format, List<Format> list) {
        int i11 = isFmp4Variant(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(i11, timestampAdjuster, (Track) null, list);
    }

    private static TsExtractor createTsExtractor(int i11, boolean z11, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        int i12 = i11 | 16;
        if (list != null) {
            i12 |= 32;
        } else if (z11) {
            list = Collections.singletonList(new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).build());
        } else {
            list = Collections.emptyList();
        }
        String str = format.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.containsCodecsCorrespondingToMimeType(str, MimeTypes.AUDIO_AAC)) {
                i12 |= 2;
            }
            if (!MimeTypes.containsCodecsCorrespondingToMimeType(str, "video/avc")) {
                i12 |= 4;
            }
        }
        return new TsExtractor(2, timestampAdjuster, (TsPayloadReader.Factory) new DefaultTsPayloadReaderFactory(i12, list));
    }

    private static boolean isFmp4Variant(Format format) {
        Metadata metadata = format.metadata;
        if (metadata == null) {
            return false;
        }
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) entry).variantInfos.isEmpty();
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static boolean sniffQuietly(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            boolean sniff = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
            return sniff;
        } catch (EOFException unused) {
            extractorInput.resetPeekPosition();
            return false;
        } catch (Throwable th2) {
            extractorInput.resetPeekPosition();
            throw th2;
        }
    }

    public DefaultHlsExtractorFactory(int i11, boolean z11) {
        this.payloadReaderFactoryFlags = i11;
        this.exposeCea608WhenMissingDeclarations = z11;
    }

    public BundledHlsMediaChunkExtractor createExtractor(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput) throws IOException {
        int inferFileTypeFromMimeType = FileTypes.inferFileTypeFromMimeType(format.sampleMimeType);
        int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        int[] iArr = DEFAULT_EXTRACTOR_ORDER;
        ArrayList arrayList = new ArrayList(iArr.length);
        addFileTypeIfValidAndNotPresent(inferFileTypeFromMimeType, arrayList);
        addFileTypeIfValidAndNotPresent(inferFileTypeFromResponseHeaders, arrayList);
        addFileTypeIfValidAndNotPresent(inferFileTypeFromUri, arrayList);
        for (int addFileTypeIfValidAndNotPresent : iArr) {
            addFileTypeIfValidAndNotPresent(addFileTypeIfValidAndNotPresent, arrayList);
        }
        Extractor extractor = null;
        extractorInput.resetPeekPosition();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            int intValue = ((Integer) arrayList.get(i11)).intValue();
            Extractor extractor2 = (Extractor) Assertions.checkNotNull(createExtractorByFileType(intValue, format, list, timestampAdjuster));
            if (sniffQuietly(extractor2, extractorInput)) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster);
            }
            if (extractor == null && (intValue == inferFileTypeFromMimeType || intValue == inferFileTypeFromResponseHeaders || intValue == inferFileTypeFromUri || intValue == 11)) {
                extractor = extractor2;
            }
        }
        return new BundledHlsMediaChunkExtractor((Extractor) Assertions.checkNotNull(extractor), format, timestampAdjuster);
    }
}
