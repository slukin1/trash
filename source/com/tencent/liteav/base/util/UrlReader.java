package com.tencent.liteav.base.util;

import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@JNINamespace("liteav")
public class UrlReader {
    private static final int AVSEEK_SIZE = 65536;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "UrlReader";
    private int mFileSize;
    private long mOffset;
    private InputStream mStream;
    private Uri mUri;

    public UrlReader(String str) {
        this.mUri = Uri.parse(str);
        open();
    }

    private void open() {
        try {
            InputStream openInputStream = ContextUtils.getApplicationContext().getContentResolver().openInputStream(this.mUri);
            this.mStream = openInputStream;
            this.mFileSize = openInputStream.available();
        } catch (FileNotFoundException unused) {
            Log.e(TAG, "Fail to open uri " + this.mUri.toString(), new Object[0]);
            this.mStream = null;
        } catch (IOException e11) {
            Log.e(TAG, "Fail to get file size " + e11.getMessage(), new Object[0]);
            this.mStream = null;
        }
    }

    private long seekFromBegin(long j11) {
        if (j11 < 0) {
            return -1;
        }
        close();
        open();
        InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            long skip = inputStream.skip(j11);
            this.mOffset = skip;
            return skip;
        } catch (IOException e11) {
            Log.e(TAG, "Fail to seek " + j11 + " exception " + e11.getMessage(), new Object[0]);
            return -1;
        }
    }

    private long seekFromCurrent(long j11) {
        if (j11 < 0) {
            return seekFromBegin(this.mOffset + j11);
        }
        try {
            long skip = this.mOffset + this.mStream.skip(j11);
            this.mOffset = skip;
            return skip;
        } catch (IOException e11) {
            Log.e(TAG, "Fail to seek " + j11 + " exception " + e11.getMessage(), new Object[0]);
            return -1;
        }
    }

    private long seekFromEnd(long j11) {
        if (j11 > 0) {
            return -1;
        }
        long j12 = ((long) this.mFileSize) + j11;
        if (j12 < 0) {
            return -1;
        }
        long j13 = this.mOffset;
        if (j12 < j13) {
            return seekFromBegin(j12);
        }
        try {
            long skip = j13 + this.mStream.skip(j12 - j13);
            this.mOffset = skip;
            return skip;
        } catch (IOException e11) {
            Log.e(TAG, "Fail to seek " + j11 + " exception " + e11.getMessage(), new Object[0]);
            return -1;
        }
    }

    public void close() {
        InputStream inputStream = this.mStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                Log.e(TAG, "Close exception " + e11.getMessage(), new Object[0]);
            }
        }
        this.mStream = null;
        this.mOffset = 0;
        this.mFileSize = 0;
    }

    public int read(byte[] bArr, int i11) {
        InputStream inputStream = this.mStream;
        int i12 = -1;
        if (inputStream == null) {
            return -1;
        }
        try {
            i12 = inputStream.read(bArr, 0, i11);
            this.mOffset += (long) i12;
            return i12;
        } catch (IOException e11) {
            Log.e(TAG, "Read exception " + e11.getMessage(), new Object[0]);
            return i12;
        }
    }

    public long seek(long j11, int i11) {
        if (this.mStream == null) {
            return -1;
        }
        if (i11 == 0) {
            return seekFromBegin(j11);
        }
        if (i11 == 1) {
            return seekFromCurrent(j11);
        }
        if (i11 == 2) {
            return seekFromEnd(j11);
        }
        if (i11 != 65536) {
            return -1;
        }
        return (long) this.mFileSize;
    }
}
