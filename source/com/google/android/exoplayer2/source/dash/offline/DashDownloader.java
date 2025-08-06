package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import androidx.profileinstaller.f;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class DashDownloader extends SegmentDownloader<DashManifest> {
    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory) {
        this(uri, list, factory, (Executor) f.f10497b);
    }

    private static void addSegment(long j11, String str, RangedUri rangedUri, ArrayList<SegmentDownloader.Segment> arrayList) {
        arrayList.add(new SegmentDownloader.Segment(j11, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addSegmentsForAdaptationSet(com.google.android.exoplayer2.upstream.DataSource r20, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r21, long r22, long r24, boolean r26, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> r27) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r19 = this;
            r1 = r21
            r2 = r22
            r4 = r26
            r5 = r27
            r0 = 0
            r6 = r0
        L_0x000a:
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r1.representations
            int r0 = r0.size()
            if (r6 >= r0) goto L_0x0087
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r1.representations
            java.lang.Object r0 = r0.get(r6)
            com.google.android.exoplayer2.source.dash.manifest.Representation r0 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r0
            int r7 = r1.type     // Catch:{ IOException -> 0x007c }
            r8 = r19
            r9 = r20
            com.google.android.exoplayer2.source.dash.DashSegmentIndex r7 = r8.getSegmentIndex(r9, r7, r0, r4)     // Catch:{ IOException -> 0x007c }
            if (r7 == 0) goto L_0x0070
            r10 = r24
            long r12 = r7.getSegmentCount(r10)
            r14 = -1
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 == 0) goto L_0x0068
            java.lang.String r14 = r0.baseUrl
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r15 = r0.getInitializationUri()
            if (r15 == 0) goto L_0x003d
            addSegment(r2, r14, r15, r5)
        L_0x003d:
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r0 = r0.getIndexUri()
            if (r0 == 0) goto L_0x0046
            addSegment(r2, r14, r0, r5)
        L_0x0046:
            long r15 = r7.getFirstSegmentNum()
            long r12 = r12 + r15
            r17 = 1
            long r12 = r12 - r17
            r0 = r15
        L_0x0050:
            int r15 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r15 > 0) goto L_0x0081
            long r15 = r7.getTimeUs(r0)
            long r8 = r2 + r15
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r15 = r7.getSegmentUrl(r0)
            addSegment(r8, r14, r15, r5)
            long r0 = r0 + r17
            r8 = r19
            r9 = r20
            goto L_0x0050
        L_0x0068:
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0070:
            r10 = r24
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException     // Catch:{ IOException -> 0x007a }
            java.lang.String r1 = "Missing segment index"
            r0.<init>((java.lang.String) r1)     // Catch:{ IOException -> 0x007a }
            throw r0     // Catch:{ IOException -> 0x007a }
        L_0x007a:
            r0 = move-exception
            goto L_0x007f
        L_0x007c:
            r0 = move-exception
            r10 = r24
        L_0x007f:
            if (r4 == 0) goto L_0x0086
        L_0x0081:
            int r6 = r6 + 1
            r1 = r21
            goto L_0x000a
        L_0x0086:
            throw r0
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.offline.DashDownloader.addSegmentsForAdaptationSet(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet, long, long, boolean, java.util.ArrayList):void");
    }

    private DashSegmentIndex getSegmentIndex(final DataSource dataSource, final int i11, final Representation representation, boolean z11) throws IOException, InterruptedException {
        DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        ChunkIndex chunkIndex = (ChunkIndex) execute(new RunnableFutureTask<ChunkIndex, IOException>(this) {
            public ChunkIndex doWork() throws IOException {
                return DashUtil.loadChunkIndex(dataSource, i11, representation);
            }
        }, z11);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor) f.f10497b);
    }

    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z11) throws IOException, InterruptedException {
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < dashManifest.getPeriodCount(); i11++) {
            Period period = dashManifest2.getPeriod(i11);
            long msToUs = C.msToUs(period.startMs);
            long periodDurationUs = dashManifest2.getPeriodDurationUs(i11);
            int i12 = 0;
            for (List<AdaptationSet> list = period.adaptationSets; i12 < list.size(); list = list) {
                addSegmentsForAdaptationSet(dataSource, list.get(i12), msToUs, periodDurationUs, z11, arrayList);
                i12++;
            }
        }
        return arrayList;
    }

    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, (ParsingLoadable.Parser<DashManifest>) new DashManifestParser(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
    }
}
