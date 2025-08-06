package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import androidx.profileinstaller.f;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class HlsDownloader extends SegmentDownloader<HlsPlaylist> {
    @Deprecated
    public HlsDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory) {
        this(uri, list, factory, (Executor) f.f10497b);
    }

    private void addMediaPlaylistDataSpecs(List<Uri> list, List<DataSpec> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            list2.add(SegmentDownloader.getCompressibleDataSpec(list.get(i11)));
        }
    }

    private void addSegment(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment, HashSet<Uri> hashSet, ArrayList<SegmentDownloader.Segment> arrayList) {
        String str = hlsMediaPlaylist.baseUri;
        long j11 = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
        String str2 = segment.fullSegmentEncryptionKeyUri;
        if (str2 != null) {
            Uri resolveToUri = UriUtil.resolveToUri(str, str2);
            if (hashSet.add(resolveToUri)) {
                arrayList.add(new SegmentDownloader.Segment(j11, SegmentDownloader.getCompressibleDataSpec(resolveToUri)));
            }
        }
        arrayList.add(new SegmentDownloader.Segment(j11, new DataSpec(UriUtil.resolveToUri(str, segment.url), segment.byteRangeOffset, segment.byteRangeLength)));
    }

    public HlsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor) f.f10497b);
    }

    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, HlsPlaylist hlsPlaylist, boolean z11) throws IOException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        if (hlsPlaylist instanceof HlsMasterPlaylist) {
            addMediaPlaylistDataSpecs(((HlsMasterPlaylist) hlsPlaylist).mediaPlaylistUrls, arrayList);
        } else {
            arrayList.add(SegmentDownloader.getCompressibleDataSpec(Uri.parse(hlsPlaylist.baseUri)));
        }
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DataSpec dataSpec = (DataSpec) it2.next();
            arrayList2.add(new SegmentDownloader.Segment(0, dataSpec));
            try {
                HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) getManifest(dataSource, dataSpec, z11);
                HlsMediaPlaylist.Segment segment = null;
                List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    HlsMediaPlaylist.Segment segment2 = list.get(i11);
                    HlsMediaPlaylist.Segment segment3 = segment2.initializationSegment;
                    if (!(segment3 == null || segment3 == segment)) {
                        addSegment(hlsMediaPlaylist, segment3, hashSet, arrayList2);
                        segment = segment3;
                    }
                    addSegment(hlsMediaPlaylist, segment2, hashSet, arrayList2);
                }
            } catch (IOException e11) {
                if (!z11) {
                    throw e11;
                }
            }
        }
        return arrayList2;
    }

    @Deprecated
    public HlsDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public HlsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, (ParsingLoadable.Parser<HlsPlaylist>) new HlsPlaylistParser(), factory, executor);
    }

    public HlsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<HlsPlaylist> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
    }
}
