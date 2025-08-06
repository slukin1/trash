package com.google.android.exoplayer2.source.smoothstreaming.offline;

import android.net.Uri;
import androidx.profileinstaller.f;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class SsDownloader extends SegmentDownloader<SsManifest> {
    @Deprecated
    public SsDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory) {
        this(uri, list, factory, (Executor) f.f10497b);
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor) f.f10497b);
    }

    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, SsManifest ssManifest, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (SsManifest.StreamElement streamElement : ssManifest.streamElements) {
            for (int i11 = 0; i11 < streamElement.formats.length; i11++) {
                for (int i12 = 0; i12 < streamElement.chunkCount; i12++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.getStartTimeUs(i12), new DataSpec(streamElement.buildRequestUri(i11, i12))));
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public SsDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem.buildUpon().setUri(Util.fixSmoothStreamingIsmManifestUri(((MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties)).uri)).build(), (ParsingLoadable.Parser<SsManifest>) new SsManifestParser(), factory, executor);
    }

    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
    }
}
