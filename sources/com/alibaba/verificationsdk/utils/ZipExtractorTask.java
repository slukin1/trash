package com.alibaba.verificationsdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipExtractorTask extends AsyncTask<Void, Integer, Long> {
    private int BUFFER_SIZE = 8192;
    private final String TAG = "ZipExtractorTask";
    private final Context context;
    private final File inputFile;
    private final File outputFile;
    /* access modifiers changed from: private */
    public int progress = 0;
    private final ProgressDialog progressDialog;
    private boolean replaceAll;
    private ZIPExtracListener zipExtracListener;

    public final class ProgressReportingOutputStream extends FileOutputStream {
        public ProgressReportingOutputStream(File file) throws IOException {
            super(file);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            super.write(bArr, i11, i12);
            ZipExtractorTask zipExtractorTask = ZipExtractorTask.this;
            int unused = zipExtractorTask.progress = zipExtractorTask.progress + i12;
            ZipExtractorTask zipExtractorTask2 = ZipExtractorTask.this;
            zipExtractorTask2.publishProgress(new Integer[]{Integer.valueOf(zipExtractorTask2.progress)});
        }
    }

    public ZipExtractorTask(String str, String str2, Context context2, boolean z11, ZIPExtracListener zIPExtracListener) {
        this.inputFile = new File(str);
        File file = new File(str2);
        this.outputFile = file;
        this.zipExtracListener = zIPExtracListener;
        if (!file.exists() && !file.mkdirs()) {
            Log.e("ZipExtractorTask", "Failed to make directories:" + file.getAbsolutePath());
        }
        this.context = context2;
        if (context2 != null) {
            this.progressDialog = new ProgressDialog(context2);
        } else {
            this.progressDialog = null;
        }
        this.replaceAll = z11;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x002d=Splitter:B:10:0x002d, B:20:0x003f=Splitter:B:20:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int copy(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
            r5 = this;
            int r0 = r5.BUFFER_SIZE
            byte[] r0 = new byte[r0]
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            int r2 = r5.BUFFER_SIZE
            r1.<init>(r6, r2)
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream
            int r2 = r5.BUFFER_SIZE
            r6.<init>(r7, r2)
            r7 = 0
            r2 = r7
        L_0x0014:
            int r3 = r5.BUFFER_SIZE     // Catch:{ IOException -> 0x0033 }
            int r3 = r1.read(r0, r7, r3)     // Catch:{ IOException -> 0x0033 }
            r4 = -1
            if (r3 == r4) goto L_0x0022
            r6.write(r0, r7, r3)     // Catch:{ IOException -> 0x0033 }
            int r2 = r2 + r3
            goto L_0x0014
        L_0x0022:
            r6.flush()     // Catch:{ IOException -> 0x0033 }
            r6.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r6 = move-exception
            r6.printStackTrace()
        L_0x002d:
            r1.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0031:
            r7 = move-exception
            goto L_0x0048
        L_0x0033:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x0031 }
            r6.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003f:
            r1.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0047:
            return r2
        L_0x0048:
            r6.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0050:
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0058:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.utils.ZipExtractorTask.copy(java.io.InputStream, java.io.OutputStream):int");
    }

    private long getOriginalSize(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        long j11 = 0;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getSize() >= 0) {
                j11 += zipEntry.getSize();
            }
        }
        return j11;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x00c3=Splitter:B:36:0x00c3, B:30:0x00b8=Splitter:B:30:0x00b8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long unzip() {
        /*
            r10 = this;
            r0 = 0
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x00bf, IOException -> 0x00b4, all -> 0x00b2 }
            java.io.File r4 = r10.inputFile     // Catch:{ ZipException -> 0x00bf, IOException -> 0x00b4, all -> 0x00b2 }
            r3.<init>(r4)     // Catch:{ ZipException -> 0x00bf, IOException -> 0x00b4, all -> 0x00b2 }
            long r4 = r10.getOriginalSize(r3)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r2 = 2
            java.lang.Integer[] r2 = new java.lang.Integer[r2]     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r2[r6] = r7     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r6 = 1
            int r4 = (int) r4     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r2[r6] = r4     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r10.publishProgress(r2)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.util.Enumeration r2 = r3.entries()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
        L_0x0027:
            boolean r4 = r2.hasMoreElements()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            if (r4 == 0) goto L_0x00a5
            java.lang.Object r4 = r2.nextElement()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            boolean r5 = r4.isDirectory()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            if (r5 == 0) goto L_0x003a
            goto L_0x0027
        L_0x003a:
            java.io.File r5 = new java.io.File     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.File r6 = r10.outputFile     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.String r7 = r4.getName()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r5.<init>(r6, r7)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.File r6 = r5.getParentFile()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            boolean r6 = r6.exists()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            if (r6 != 0) goto L_0x0074
            java.lang.String r6 = "ZipExtractorTask"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r7.<init>()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.String r8 = "make="
            r7.append(r8)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.File r8 = r5.getParentFile()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r7.append(r8)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.String r7 = r7.toString()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            com.alibaba.verificationsdk.utils.Log.e(r6, r7)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.File r6 = r5.getParentFile()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r6.mkdirs()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
        L_0x0074:
            boolean r6 = r5.exists()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            if (r6 == 0) goto L_0x007c
            android.content.Context r6 = r10.context     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
        L_0x007c:
            java.lang.String r6 = r5.getCanonicalPath()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.File r7 = r10.outputFile     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.lang.String r7 = r7.getPath()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            boolean r6 = r6.startsWith(r7)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            if (r6 == 0) goto L_0x009f
            com.alibaba.verificationsdk.utils.ZipExtractorTask$ProgressReportingOutputStream r6 = new com.alibaba.verificationsdk.utils.ZipExtractorTask$ProgressReportingOutputStream     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r6.<init>(r5)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            java.io.InputStream r4 = r3.getInputStream(r4)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            int r4 = r10.copy(r4, r6)     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            long r4 = (long) r4     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            long r0 = r0 + r4
            r6.close()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            goto L_0x0027
        L_0x009f:
            java.lang.SecurityException r2 = new java.lang.SecurityException     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            r2.<init>()     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
            throw r2     // Catch:{ ZipException -> 0x00b0, IOException -> 0x00ae }
        L_0x00a5:
            r3.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00c9
        L_0x00a9:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x00c9
        L_0x00ae:
            r2 = move-exception
            goto L_0x00b8
        L_0x00b0:
            r2 = move-exception
            goto L_0x00c3
        L_0x00b2:
            r0 = move-exception
            goto L_0x00cc
        L_0x00b4:
            r3 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
        L_0x00b8:
            r2.printStackTrace()     // Catch:{ all -> 0x00ca }
            r3.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00c9
        L_0x00bf:
            r3 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
        L_0x00c3:
            r2.printStackTrace()     // Catch:{ all -> 0x00ca }
            r3.close()     // Catch:{ IOException -> 0x00a9 }
        L_0x00c9:
            return r0
        L_0x00ca:
            r0 = move-exception
            r2 = r3
        L_0x00cc:
            r2.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00d4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.utils.ZipExtractorTask.unzip():long");
    }

    public void onPreExecute() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.setTitle("Extracting");
            this.progressDialog.setMessage(this.inputFile.getName());
            this.progressDialog.setProgressStyle(1);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    ZipExtractorTask.this.cancel(true);
                }
            });
            this.progressDialog.show();
        }
        ZIPExtracListener zIPExtracListener = this.zipExtracListener;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipStart();
        }
    }

    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(unzip());
    }

    public void onPostExecute(Long l11) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
        ZIPExtracListener zIPExtracListener = this.zipExtracListener;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipFinished(this.inputFile, this.outputFile);
        }
        isCancelled();
    }

    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            if (numArr.length > 1) {
                this.progressDialog.setMax(numArr[1].intValue());
                return;
            }
            progressDialog2.setProgress(numArr[0].intValue());
        }
    }
}
