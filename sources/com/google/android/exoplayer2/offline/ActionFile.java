package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Deprecated
final class ActionFile {
    private static final String DOWNLOAD_TYPE_DASH = "dash";
    private static final String DOWNLOAD_TYPE_HLS = "hls";
    private static final String DOWNLOAD_TYPE_PROGRESSIVE = "progressive";
    private static final String DOWNLOAD_TYPE_SS = "ss";
    private static final int VERSION = 0;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.atomicFile = new AtomicFile(file);
    }

    private static String generateDownloadId(Uri uri, String str) {
        return str != null ? str : uri.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String inferMimeType(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3680(0xe60, float:5.157E-42)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x0038
            r1 = 103407(0x193ef, float:1.44904E-40)
            if (r0 == r1) goto L_0x002e
            r1 = 3075986(0x2eef92, float:4.310374E-39)
            if (r0 == r1) goto L_0x0024
            r1 = 1131547531(0x43720b8b, float:242.04509)
            if (r0 == r1) goto L_0x001a
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "progressive"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0043
            r4 = 3
            goto L_0x0044
        L_0x0024:
            java.lang.String r0 = "dash"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0043
            r4 = 0
            goto L_0x0044
        L_0x002e:
            java.lang.String r0 = "hls"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0043
            r4 = r3
            goto L_0x0044
        L_0x0038:
            java.lang.String r0 = "ss"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0043
            r4 = r2
            goto L_0x0044
        L_0x0043:
            r4 = -1
        L_0x0044:
            if (r4 == 0) goto L_0x0054
            if (r4 == r3) goto L_0x0051
            if (r4 == r2) goto L_0x004e
            java.lang.String r4 = "video/x-unknown"
            return r4
        L_0x004e:
            java.lang.String r4 = "application/vnd.ms-sstr+xml"
            return r4
        L_0x0051:
            java.lang.String r4 = "application/x-mpegURL"
            return r4
        L_0x0054:
            java.lang.String r4 = "application/dash+xml"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.ActionFile.inferMimeType(java.lang.String):java.lang.String");
    }

    private static DownloadRequest readDownloadRequest(DataInputStream dataInputStream) throws IOException {
        byte[] bArr;
        String readUTF = dataInputStream.readUTF();
        int readInt = dataInputStream.readInt();
        Uri parse = Uri.parse(dataInputStream.readUTF());
        boolean readBoolean = dataInputStream.readBoolean();
        int readInt2 = dataInputStream.readInt();
        String str = null;
        if (readInt2 != 0) {
            bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
        } else {
            bArr = null;
        }
        boolean z11 = true;
        boolean z12 = readInt == 0 && DOWNLOAD_TYPE_PROGRESSIVE.equals(readUTF);
        ArrayList arrayList = new ArrayList();
        if (!z12) {
            int readInt3 = dataInputStream.readInt();
            for (int i11 = 0; i11 < readInt3; i11++) {
                arrayList.add(readKey(readUTF, readInt, dataInputStream));
            }
        }
        if (readInt >= 2 || (!DOWNLOAD_TYPE_DASH.equals(readUTF) && !DOWNLOAD_TYPE_HLS.equals(readUTF) && !DOWNLOAD_TYPE_SS.equals(readUTF))) {
            z11 = false;
        }
        if (!z11 && dataInputStream.readBoolean()) {
            str = dataInputStream.readUTF();
        }
        String generateDownloadId = readInt < 3 ? generateDownloadId(parse, str) : dataInputStream.readUTF();
        if (!readBoolean) {
            return new DownloadRequest.Builder(generateDownloadId, parse).setMimeType(inferMimeType(readUTF)).setStreamKeys(arrayList).setCustomCacheKey(str).setData(bArr).build();
        }
        throw new DownloadRequest.UnsupportedRequestException();
    }

    private static StreamKey readKey(String str, int i11, DataInputStream dataInputStream) throws IOException {
        int i12;
        int i13;
        int i14;
        if ((DOWNLOAD_TYPE_HLS.equals(str) || DOWNLOAD_TYPE_SS.equals(str)) && i11 == 0) {
            i14 = 0;
            i13 = dataInputStream.readInt();
            i12 = dataInputStream.readInt();
        } else {
            i14 = dataInputStream.readInt();
            i13 = dataInputStream.readInt();
            i12 = dataInputStream.readInt();
        }
        return new StreamKey(i14, i13, i12);
    }

    public void delete() {
        this.atomicFile.delete();
    }

    public boolean exists() {
        return this.atomicFile.exists();
    }

    public DownloadRequest[] load() throws IOException {
        if (!exists()) {
            return new DownloadRequest[0];
        }
        InputStream inputStream = null;
        try {
            inputStream = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt <= 0) {
                int readInt2 = dataInputStream.readInt();
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < readInt2; i11++) {
                    try {
                        arrayList.add(readDownloadRequest(dataInputStream));
                    } catch (DownloadRequest.UnsupportedRequestException unused) {
                    }
                }
                return (DownloadRequest[]) arrayList.toArray(new DownloadRequest[0]);
            }
            StringBuilder sb2 = new StringBuilder(44);
            sb2.append("Unsupported action file version: ");
            sb2.append(readInt);
            throw new IOException(sb2.toString());
        } finally {
            Util.closeQuietly((Closeable) inputStream);
        }
    }
}
