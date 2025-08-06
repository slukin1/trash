package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400;
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private long currentDataSourceBytesRead;
    private DataSpec currentDataSpec;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final EventListener eventListener;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private long readPosition;
    private DataSpec requestDataSpec;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i11);

        void onCachedBytesRead(long j11, long j12);
    }

    public static final class Factory implements DataSource.Factory {
        private Cache cache;
        private boolean cacheIsReadOnly;
        private CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;
        private DataSource.Factory cacheReadDataSourceFactory = new FileDataSource.Factory();
        private DataSink.Factory cacheWriteDataSinkFactory;
        private EventListener eventListener;
        private int flags;
        private DataSource.Factory upstreamDataSourceFactory;
        private int upstreamPriority;
        private PriorityTaskManager upstreamPriorityTaskManager;

        private CacheDataSource createDataSourceInternal(DataSource dataSource, int i11, int i12) {
            DataSink dataSink;
            Cache cache2 = (Cache) Assertions.checkNotNull(this.cache);
            if (this.cacheIsReadOnly || dataSource == null) {
                dataSink = null;
            } else {
                DataSink.Factory factory = this.cacheWriteDataSinkFactory;
                dataSink = factory != null ? factory.createDataSink() : new CacheDataSink.Factory().setCache(cache2).createDataSink();
            }
            return new CacheDataSource(cache2, dataSource, this.cacheReadDataSourceFactory.createDataSource(), dataSink, this.cacheKeyFactory, i11, this.upstreamPriorityTaskManager, i12, this.eventListener);
        }

        public CacheDataSource createDataSourceForDownloading() {
            DataSource.Factory factory = this.upstreamDataSourceFactory;
            return createDataSourceInternal(factory != null ? factory.createDataSource() : null, this.flags | 1, -1000);
        }

        public CacheDataSource createDataSourceForRemovingDownload() {
            return createDataSourceInternal((DataSource) null, this.flags | 1, -1000);
        }

        public Cache getCache() {
            return this.cache;
        }

        public CacheKeyFactory getCacheKeyFactory() {
            return this.cacheKeyFactory;
        }

        public PriorityTaskManager getUpstreamPriorityTaskManager() {
            return this.upstreamPriorityTaskManager;
        }

        public Factory setCache(Cache cache2) {
            this.cache = cache2;
            return this;
        }

        public Factory setCacheKeyFactory(CacheKeyFactory cacheKeyFactory2) {
            this.cacheKeyFactory = cacheKeyFactory2;
            return this;
        }

        public Factory setCacheReadDataSourceFactory(DataSource.Factory factory) {
            this.cacheReadDataSourceFactory = factory;
            return this;
        }

        public Factory setCacheWriteDataSinkFactory(DataSink.Factory factory) {
            this.cacheWriteDataSinkFactory = factory;
            this.cacheIsReadOnly = factory == null;
            return this;
        }

        public Factory setEventListener(EventListener eventListener2) {
            this.eventListener = eventListener2;
            return this;
        }

        public Factory setFlags(int i11) {
            this.flags = i11;
            return this;
        }

        public Factory setUpstreamDataSourceFactory(DataSource.Factory factory) {
            this.upstreamDataSourceFactory = factory;
            return this;
        }

        public Factory setUpstreamPriority(int i11) {
            this.upstreamPriority = i11;
            return this;
        }

        public Factory setUpstreamPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
            this.upstreamPriorityTaskManager = priorityTaskManager;
            return this;
        }

        public CacheDataSource createDataSource() {
            DataSource.Factory factory = this.upstreamDataSourceFactory;
            return createDataSourceInternal(factory != null ? factory.createDataSource() : null, this.flags, this.upstreamPriority);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.currentDataSpec = null;
                this.currentDataSource = null;
                CacheSpan cacheSpan = this.currentHoleSpan;
                if (cacheSpan != null) {
                    this.cache.releaseHoleSpan(cacheSpan);
                    this.currentHoleSpan = null;
                }
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache2, String str, Uri uri) {
        Uri b11 = c.b(cache2.getContentMetadata(str));
        return b11 != null ? b11 : uri;
    }

    private void handleBeforeThrow(Throwable th2) {
        if (isReadingFromCache() || (th2 instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    private void notifyBytesRead() {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null && this.totalCachedBytesRead > 0) {
            eventListener2.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0;
        }
    }

    private void notifyCacheIgnored(int i11) {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null) {
            eventListener2.onCacheIgnored(i11);
        }
    }

    private void openNextSource(DataSpec dataSpec, boolean z11) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec2;
        DataSource dataSource;
        long j11;
        DataSpec dataSpec3 = dataSpec;
        String str = (String) Util.castNonNull(dataSpec3.key);
        Uri uri = null;
        if (this.currentRequestIgnoresCache) {
            cacheSpan = null;
        } else if (this.blockOnCache) {
            try {
                cacheSpan = this.cache.startReadWrite(str, this.readPosition, this.bytesRemaining);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.cache.startReadWriteNonBlocking(str, this.readPosition, this.bytesRemaining);
        }
        if (cacheSpan == null) {
            dataSource = this.upstreamDataSource;
            dataSpec2 = dataSpec.buildUpon().setPosition(this.readPosition).setLength(this.bytesRemaining).build();
        } else if (cacheSpan.isCached) {
            Uri fromFile = Uri.fromFile((File) Util.castNonNull(cacheSpan.file));
            long j12 = cacheSpan.position;
            long j13 = this.readPosition - j12;
            long j14 = cacheSpan.length - j13;
            long j15 = this.bytesRemaining;
            if (j15 != -1) {
                j14 = Math.min(j14, j15);
            }
            dataSpec2 = dataSpec.buildUpon().setUri(fromFile).setUriPositionOffset(j12).setPosition(j13).setLength(j14).build();
            dataSource = this.cacheReadDataSource;
        } else {
            if (cacheSpan.isOpenEnded()) {
                j11 = this.bytesRemaining;
            } else {
                j11 = cacheSpan.length;
                long j16 = this.bytesRemaining;
                if (j16 != -1) {
                    j11 = Math.min(j11, j16);
                }
            }
            dataSpec2 = dataSpec.buildUpon().setPosition(this.readPosition).setLength(j11).build();
            dataSource = this.cacheWriteDataSource;
            if (dataSource == null) {
                dataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(cacheSpan);
                cacheSpan = null;
            }
        }
        this.checkCachePosition = (this.currentRequestIgnoresCache || dataSource != this.upstreamDataSource) ? Long.MAX_VALUE : this.readPosition + MIN_READ_BEFORE_CHECKING_CACHE;
        if (z11) {
            Assertions.checkState(isBypassingCache());
            if (dataSource != this.upstreamDataSource) {
                try {
                    closeCurrentSource();
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    if (((CacheSpan) Util.castNonNull(cacheSpan)).isHoleSpan()) {
                        this.cache.releaseHoleSpan(cacheSpan);
                    }
                    throw th3;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.isHoleSpan()) {
            this.currentHoleSpan = cacheSpan;
        }
        this.currentDataSource = dataSource;
        this.currentDataSpec = dataSpec2;
        this.currentDataSourceBytesRead = 0;
        long open = dataSource.open(dataSpec2);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpec2.length == -1 && open != -1) {
            this.bytesRemaining = open;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition + open);
        }
        if (isReadingFromUpstream()) {
            Uri uri2 = dataSource.getUri();
            this.actualUri = uri2;
            if (!dataSpec3.uri.equals(uri2)) {
                uri = this.actualUri;
            }
            ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, uri);
        }
        if (isWritingToCache()) {
            this.cache.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    private void setNoBytesRemainingAndMaybeStoreLength(String str) throws IOException {
        this.bytesRemaining = 0;
        if (isWritingToCache()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition);
            this.cache.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        if (!this.ignoreCacheOnError || !this.seenCacheError) {
            return (!this.ignoreCacheForUnsetLengthRequests || dataSpec.length != -1) ? -1 : 1;
        }
        return 0;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.cacheReadDataSource.addTransferListener(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    public void close() throws IOException {
        this.requestDataSpec = null;
        this.actualUri = null;
        this.readPosition = 0;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (Throwable th2) {
            handleBeforeThrow(th2);
            throw th2;
        }
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public Map<String, List<String>> getResponseHeaders() {
        if (isReadingFromUpstream()) {
            return this.upstreamDataSource.getResponseHeaders();
        }
        return Collections.emptyMap();
    }

    public Uri getUri() {
        return this.actualUri;
    }

    public long open(DataSpec dataSpec) throws IOException {
        try {
            String buildCacheKey = this.cacheKeyFactory.buildCacheKey(dataSpec);
            DataSpec build = dataSpec.buildUpon().setKey(buildCacheKey).build();
            this.requestDataSpec = build;
            this.actualUri = getRedirectedUriOrDefault(this.cache, buildCacheKey, build.uri);
            this.readPosition = dataSpec.position;
            int shouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            boolean z11 = shouldIgnoreCacheForRequest != -1;
            this.currentRequestIgnoresCache = z11;
            if (z11) {
                notifyCacheIgnored(shouldIgnoreCacheForRequest);
            }
            if (this.currentRequestIgnoresCache) {
                this.bytesRemaining = -1;
            } else {
                long a11 = c.a(this.cache.getContentMetadata(buildCacheKey));
                this.bytesRemaining = a11;
                if (a11 != -1) {
                    long j11 = a11 - dataSpec.position;
                    this.bytesRemaining = j11;
                    if (j11 < 0) {
                        throw new DataSourceException(0);
                    }
                }
            }
            long j12 = dataSpec.length;
            if (j12 != -1) {
                long j13 = this.bytesRemaining;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.bytesRemaining = j12;
            }
            long j14 = this.bytesRemaining;
            if (j14 > 0 || j14 == -1) {
                openNextSource(build, false);
            }
            long j15 = dataSpec.length;
            return j15 != -1 ? j15 : this.bytesRemaining;
        } catch (Throwable th2) {
            handleBeforeThrow(th2);
            throw th2;
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        int i14 = i12;
        DataSpec dataSpec = (DataSpec) Assertions.checkNotNull(this.requestDataSpec);
        DataSpec dataSpec2 = (DataSpec) Assertions.checkNotNull(this.currentDataSpec);
        if (i14 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(dataSpec, true);
            }
            int read = ((DataSource) Assertions.checkNotNull(this.currentDataSource)).read(bArr, i11, i14);
            if (read != -1) {
                if (isReadingFromCache()) {
                    this.totalCachedBytesRead += (long) read;
                }
                long j11 = (long) read;
                this.readPosition += j11;
                this.currentDataSourceBytesRead += j11;
                long j12 = this.bytesRemaining;
                if (j12 != -1) {
                    this.bytesRemaining = j12 - j11;
                }
                return read;
            }
            if (isReadingFromUpstream()) {
                long j13 = dataSpec2.length;
                if (j13 != -1) {
                    i13 = read;
                    if (this.currentDataSourceBytesRead < j13) {
                    }
                } else {
                    i13 = read;
                }
                setNoBytesRemainingAndMaybeStoreLength((String) Util.castNonNull(dataSpec.key));
                return i13;
            }
            i13 = read;
            long j14 = this.bytesRemaining;
            if (j14 <= 0) {
                if (j14 != -1) {
                    return i13;
                }
            }
            closeCurrentSource();
            openNextSource(dataSpec, false);
            return read(bArr, i11, i12);
        } catch (Throwable th2) {
            handleBeforeThrow(th2);
            throw th2;
        }
    }

    public CacheDataSource(Cache cache2, DataSource dataSource) {
        this(cache2, dataSource, 0);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, int i11) {
        this(cache2, dataSource, new FileDataSource(), new CacheDataSink(cache2, CacheDataSink.DEFAULT_FRAGMENT_SIZE), i11, (EventListener) null);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i11, EventListener eventListener2) {
        this(cache2, dataSource, dataSource2, dataSink, i11, eventListener2, (CacheKeyFactory) null);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i11, EventListener eventListener2, CacheKeyFactory cacheKeyFactory2) {
        this(cache2, dataSource, dataSource2, dataSink, cacheKeyFactory2, i11, (PriorityTaskManager) null, 0, eventListener2);
    }

    private CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory2, int i11, PriorityTaskManager priorityTaskManager, int i12, EventListener eventListener2) {
        this.cache = cache2;
        this.cacheReadDataSource = dataSource2;
        this.cacheKeyFactory = cacheKeyFactory2 == null ? CacheKeyFactory.DEFAULT : cacheKeyFactory2;
        boolean z11 = false;
        this.blockOnCache = (i11 & 1) != 0;
        this.ignoreCacheOnError = (i11 & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i11 & 4) != 0 ? true : z11;
        TeeDataSource teeDataSource = null;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i12) : dataSource;
            this.upstreamDataSource = dataSource;
            this.cacheWriteDataSource = dataSink != null ? new TeeDataSource(dataSource, dataSink) : teeDataSource;
        } else {
            this.upstreamDataSource = DummyDataSource.INSTANCE;
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener2;
    }
}
