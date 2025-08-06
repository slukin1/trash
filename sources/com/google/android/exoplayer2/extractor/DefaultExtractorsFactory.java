package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};
    private static final Constructor<? extends Extractor> FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private int flacFlags;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;
    private int tsTimestampSearchBytes = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    static {
        Constructor<? extends U> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[]{Integer.TYPE});
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating FLAC extension", e11);
        }
        FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    private void addExtractorsForFileType(int i11, List<Extractor> list) {
        switch (i11) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                list.add(new AdtsExtractor(this.adtsFlags | this.constantBitrateSeekingEnabled ? 1 : 0));
                return;
            case 3:
                list.add(new AmrExtractor(this.amrFlags | this.constantBitrateSeekingEnabled ? 1 : 0));
                return;
            case 4:
                Constructor<? extends Extractor> constructor = FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
                if (constructor != null) {
                    try {
                        list.add((Extractor) constructor.newInstance(new Object[]{Integer.valueOf(this.flacFlags)}));
                        return;
                    } catch (Exception e11) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e11);
                    }
                } else {
                    list.add(new FlacExtractor(this.flacFlags));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.matroskaFlags));
                return;
            case 7:
                list.add(new Mp3Extractor(this.mp3Flags | this.constantBitrateSeekingEnabled ? 1 : 0));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(this.fragmentedMp4Flags));
                list.add(new Mp4Extractor(this.mp4Flags));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(this.tsMode, this.tsFlags, this.tsTimestampSearchBytes));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 14:
                list.add(new JpegExtractor());
                return;
            default:
                return;
        }
    }

    public synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int i11) {
        this.adtsFlags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int i11) {
        this.amrFlags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z11) {
        this.constantBitrateSeekingEnabled = z11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFlacExtractorFlags(int i11) {
        this.flacFlags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i11) {
        this.fragmentedMp4Flags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i11) {
        this.matroskaFlags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i11) {
        this.mp3Flags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i11) {
        this.mp4Flags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i11) {
        this.tsFlags = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i11) {
        this.tsMode = i11;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i11) {
        this.tsTimestampSearchBytes = i11;
        return this;
    }

    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        if (inferFileTypeFromResponseHeaders != -1) {
            addExtractorsForFileType(inferFileTypeFromResponseHeaders, arrayList);
        }
        int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        if (!(inferFileTypeFromUri == -1 || inferFileTypeFromUri == inferFileTypeFromResponseHeaders)) {
            addExtractorsForFileType(inferFileTypeFromUri, arrayList);
        }
        for (int i11 : DEFAULT_EXTRACTOR_ORDER) {
            if (!(i11 == inferFileTypeFromResponseHeaders || i11 == inferFileTypeFromUri)) {
                addExtractorsForFileType(i11, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }
}
