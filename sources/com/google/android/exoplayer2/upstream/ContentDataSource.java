package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    public void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11);
            } catch (Throwable th2) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12);
        } catch (Throwable th3) {
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor3 = this.assetFileDescriptor;
                if (assetFileDescriptor3 != null) {
                    assetFileDescriptor3.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th3;
            } catch (IOException e13) {
                throw new ContentDataSourceException(e13);
            } catch (Throwable th4) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th4;
            }
        }
    }

    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws ContentDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            AssetFileDescriptor openAssetFileDescriptor = this.resolver.openAssetFileDescriptor(uri2, "r");
            this.assetFileDescriptor = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.inputStream = fileInputStream;
                int i11 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i11 != 0) {
                    if (dataSpec.position > length) {
                        throw new DataSourceException(0);
                    }
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    if (i11 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.bytesRemaining = -1;
                        } else {
                            long position = size - channel.position();
                            this.bytesRemaining = position;
                            if (position < 0) {
                                throw new DataSourceException(0);
                            }
                        }
                    } else {
                        long j11 = length - skip;
                        this.bytesRemaining = j11;
                        if (j11 < 0) {
                            throw new DataSourceException(0);
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
                    this.opened = true;
                    transferStarted(dataSpec);
                    long j14 = dataSpec.length;
                    return j14 != -1 ? j14 : this.bytesRemaining;
                }
                throw new DataSourceException(0);
            }
            String valueOf = String.valueOf(uri2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 36);
            sb2.append("Could not open file descriptor for: ");
            sb2.append(valueOf);
            throw new FileNotFoundException(sb2.toString());
        } catch (IOException e11) {
            throw new ContentDataSourceException(e11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws ContentDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesRemaining;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, (long) i12);
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.bytesRemaining;
        if (j12 != -1) {
            this.bytesRemaining = j12 - ((long) read);
        }
        bytesTransferred(read);
        return read;
    }
}
