package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public static final class Factory implements DataSource.Factory {
        private TransferListener listener;

        public Factory setListener(TransferListener transferListener) {
            this.listener = transferListener;
            return this;
        }

        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.listener;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }
    }

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile openLocalFile(Uri uri2) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) Assertions.checkNotNull(uri2.getPath()), "r");
        } catch (FileNotFoundException e11) {
            if (!TextUtils.isEmpty(uri2.getQuery()) || !TextUtils.isEmpty(uri2.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri2.getPath(), uri2.getQuery(), uri2.getFragment()}), e11);
            }
            throw new FileDataSourceException(e11);
        }
    }

    public void close() throws FileDataSourceException {
        this.uri = null;
        try {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e11) {
            throw new FileDataSourceException(e11);
        } catch (Throwable th2) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th2;
        }
    }

    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            RandomAccessFile openLocalFile = openLocalFile(uri2);
            this.file = openLocalFile;
            openLocalFile.seek(dataSpec.position);
            long j11 = dataSpec.length;
            if (j11 == -1) {
                j11 = this.file.length() - dataSpec.position;
            }
            this.bytesRemaining = j11;
            if (j11 >= 0) {
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new DataSourceException(0);
        } catch (IOException e11) {
            throw new FileDataSourceException(e11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws FileDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.castNonNull(this.file)).read(bArr, i11, (int) Math.min(this.bytesRemaining, (long) i12));
            if (read > 0) {
                this.bytesRemaining -= (long) read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11);
        }
    }
}
