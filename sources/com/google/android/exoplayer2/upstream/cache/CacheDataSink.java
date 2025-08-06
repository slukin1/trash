package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public static final long DEFAULT_FRAGMENT_SIZE = 5242880;
    private static final long MIN_RECOMMENDED_FRAGMENT_SIZE = 2097152;
    private static final String TAG = "CacheDataSink";
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private long dataSpecFragmentSize;
    private File file;
    private final long fragmentSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static final class Factory implements DataSink.Factory {
        private int bufferSize = CacheDataSink.DEFAULT_BUFFER_SIZE;
        private Cache cache;
        private long fragmentSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;

        public DataSink createDataSink() {
            return new CacheDataSink((Cache) Assertions.checkNotNull(this.cache), this.fragmentSize, this.bufferSize);
        }

        public Factory setBufferSize(int i11) {
            this.bufferSize = i11;
            return this;
        }

        public Factory setCache(Cache cache2) {
            this.cache = cache2;
            return this;
        }

        public Factory setFragmentSize(long j11) {
            this.fragmentSize = j11;
            return this;
        }
    }

    public CacheDataSink(Cache cache2, long j11) {
        this(cache2, j11, DEFAULT_BUFFER_SIZE);
    }

    private void closeCurrentOutputStream() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 != null) {
            try {
                outputStream2.flush();
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                this.file = null;
                this.cache.commitFile((File) Util.castNonNull(this.file), this.outputStreamBytesWritten);
            } catch (Throwable th2) {
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                this.file = null;
                ((File) Util.castNonNull(this.file)).delete();
                throw th2;
            }
        }
    }

    private void openNextOutputStream(DataSpec dataSpec2) throws IOException {
        long j11 = dataSpec2.length;
        long j12 = -1;
        if (j11 != -1) {
            j12 = Math.min(j11 - this.dataSpecBytesWritten, this.dataSpecFragmentSize);
        }
        this.file = this.cache.startFile((String) Util.castNonNull(dataSpec2.key), dataSpec2.position + this.dataSpecBytesWritten, j12);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        if (this.bufferSize > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(fileOutputStream, this.bufferSize);
            } else {
                reusableBufferedOutputStream.reset(fileOutputStream);
            }
            this.outputStream = this.bufferedOutputStream;
        } else {
            this.outputStream = fileOutputStream;
        }
        this.outputStreamBytesWritten = 0;
    }

    public void close() throws CacheDataSinkException {
        if (this.dataSpec != null) {
            try {
                closeCurrentOutputStream();
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        }
    }

    public void open(DataSpec dataSpec2) throws CacheDataSinkException {
        Assertions.checkNotNull(dataSpec2.key);
        if (dataSpec2.length != -1 || !dataSpec2.isFlagSet(2)) {
            this.dataSpec = dataSpec2;
            this.dataSpecFragmentSize = dataSpec2.isFlagSet(4) ? this.fragmentSize : Long.MAX_VALUE;
            this.dataSpecBytesWritten = 0;
            try {
                openNextOutputStream(dataSpec2);
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        } else {
            this.dataSpec = null;
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws CacheDataSinkException {
        DataSpec dataSpec2 = this.dataSpec;
        if (dataSpec2 != null) {
            int i13 = 0;
            while (i13 < i12) {
                try {
                    if (this.outputStreamBytesWritten == this.dataSpecFragmentSize) {
                        closeCurrentOutputStream();
                        openNextOutputStream(dataSpec2);
                    }
                    int min = (int) Math.min((long) (i12 - i13), this.dataSpecFragmentSize - this.outputStreamBytesWritten);
                    ((OutputStream) Util.castNonNull(this.outputStream)).write(bArr, i11 + i13, min);
                    i13 += min;
                    long j11 = (long) min;
                    this.outputStreamBytesWritten += j11;
                    this.dataSpecBytesWritten += j11;
                } catch (IOException e11) {
                    throw new CacheDataSinkException(e11);
                }
            }
        }
    }

    public CacheDataSink(Cache cache2, long j11, int i11) {
        Assertions.checkState(j11 > 0 || j11 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i12 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
        if (i12 != 0 && j11 < 2097152) {
            Log.w(TAG, "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.cache = (Cache) Assertions.checkNotNull(cache2);
        this.fragmentSize = i12 == 0 ? Long.MAX_VALUE : j11;
        this.bufferSize = i11;
    }
}
