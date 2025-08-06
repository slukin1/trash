package com.google.android.exoplayer2.offline;

import android.util.SparseArray;
import androidx.profileinstaller.f;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.dash.offline.DashDownloader;
import com.google.android.exoplayer2.source.hls.offline.HlsDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

public class DefaultDownloaderFactory implements DownloaderFactory {
    private static final SparseArray<Constructor<? extends Downloader>> CONSTRUCTORS = createDownloaderConstructors();
    private final CacheDataSource.Factory cacheDataSourceFactory;
    private final Executor executor;

    @Deprecated
    public DefaultDownloaderFactory(CacheDataSource.Factory factory) {
        this(factory, f.f10497b);
    }

    private static SparseArray<Constructor<? extends Downloader>> createDownloaderConstructors() {
        SparseArray<Constructor<? extends Downloader>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, getDownloaderConstructor(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, getDownloaderConstructor(HlsDownloader.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, getDownloaderConstructor(SsDownloader.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private static Constructor<? extends Downloader> getDownloaderConstructor(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(new Class[]{MediaItem.class, CacheDataSource.Factory.class, Executor.class});
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException("Downloader constructor missing", e11);
        }
    }

    public Downloader createDownloader(DownloadRequest downloadRequest) {
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(downloadRequest.uri, downloadRequest.mimeType);
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 1 || inferContentTypeForUriAndMimeType == 2) {
            return createDownloader(downloadRequest, inferContentTypeForUriAndMimeType);
        }
        if (inferContentTypeForUriAndMimeType == 4) {
            return new ProgressiveDownloader(new MediaItem.Builder().setUri(downloadRequest.uri).setCustomCacheKey(downloadRequest.customCacheKey).build(), this.cacheDataSourceFactory, this.executor);
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Unsupported type: ");
        sb2.append(inferContentTypeForUriAndMimeType);
        throw new IllegalArgumentException(sb2.toString());
    }

    public DefaultDownloaderFactory(CacheDataSource.Factory factory, Executor executor2) {
        this.cacheDataSourceFactory = (CacheDataSource.Factory) Assertions.checkNotNull(factory);
        this.executor = (Executor) Assertions.checkNotNull(executor2);
    }

    private Downloader createDownloader(DownloadRequest downloadRequest, int i11) {
        Constructor constructor = CONSTRUCTORS.get(i11);
        if (constructor != null) {
            try {
                return (Downloader) constructor.newInstance(new Object[]{new MediaItem.Builder().setUri(downloadRequest.uri).setStreamKeys(downloadRequest.streamKeys).setCustomCacheKey(downloadRequest.customCacheKey).setDrmKeySetId(downloadRequest.keySetId).build(), this.cacheDataSourceFactory, this.executor});
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder(61);
                sb2.append("Failed to instantiate downloader for content type ");
                sb2.append(i11);
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("Module missing for content type ");
            sb3.append(i11);
            throw new IllegalStateException(sb3.toString());
        }
    }
}
