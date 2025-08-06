package com.alibaba.verificationsdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownLoaderTask extends AsyncTask<Void, Integer, Long> {
    private int BUFFER_SIZE = 8192;
    private final String TAG = "DownLoaderTask";
    private Context context;
    private File file;
    /* access modifiers changed from: private */
    public int progress = 0;
    private ProgressDialog progressDialog;
    private ProgressReportingOutputStream progressReportingOutputStream;
    private DownloadListener resGetListener;
    private URL url;

    public final class ProgressReportingOutputStream extends FileOutputStream {
        public ProgressReportingOutputStream(File file) throws FileNotFoundException {
            super(file);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            super.write(bArr, i11, i12);
            DownLoaderTask downLoaderTask = DownLoaderTask.this;
            int unused = downLoaderTask.progress = downLoaderTask.progress + i12;
            DownLoaderTask downLoaderTask2 = DownLoaderTask.this;
            downLoaderTask2.publishProgress(new Integer[]{Integer.valueOf(downLoaderTask2.progress)});
        }
    }

    public DownLoaderTask(String str, String str2, Context context2, DownloadListener downloadListener) {
        this.context = context2;
        this.resGetListener = downloadListener;
        if (context2 != null) {
            this.progressDialog = new ProgressDialog(this.context);
        } else {
            this.progressDialog = null;
        }
        try {
            this.url = new URL(str);
            String name = new File(this.url.getFile()).getName();
            this.file = new File(str2, name);
            Log.i("DownLoaderTask", "out=" + str2 + ", name=" + name + ",mUrl.getFile()=" + this.url.getFile());
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.utils.DownLoaderTask.copy(java.io.InputStream, java.io.OutputStream):int");
    }

    private long download() {
        int i11 = 0;
        try {
            URLConnection openConnection = this.url.openConnection();
            int contentLength = openConnection.getContentLength();
            if (this.file.exists()) {
                if (((long) contentLength) == this.file.length()) {
                    Log.i("DownLoaderTask", "file " + this.file.getName() + " already exits!!");
                    return 0;
                }
            }
            this.progressReportingOutputStream = new ProgressReportingOutputStream(this.file);
            publishProgress(new Integer[]{0, Integer.valueOf(contentLength)});
            i11 = copy(openConnection.getInputStream(), this.progressReportingOutputStream);
            if (!(i11 == contentLength || contentLength == -1)) {
                Log.e("DownLoaderTask", "Download incomplete bytesCopied=" + i11 + ", length" + contentLength);
            }
            this.progressReportingOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return (long) i11;
    }

    public void onPreExecute() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.setTitle("Downloading...");
            this.progressDialog.setMessage(this.file.getName());
            this.progressDialog.setProgressStyle(1);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    DownLoaderTask.this.cancel(true);
                }
            });
            this.progressDialog.show();
        }
        DownloadListener downloadListener = this.resGetListener;
        if (downloadListener != null) {
            downloadListener.downloadStart();
        }
    }

    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(download());
    }

    public void onPostExecute(Long l11) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
        DownloadListener downloadListener = this.resGetListener;
        if (downloadListener != null) {
            downloadListener.downloadFinished(this.file);
        }
        isCancelled();
    }

    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            if (numArr.length > 1) {
                int intValue = numArr[1].intValue();
                if (intValue == -1) {
                    this.progressDialog.setIndeterminate(true);
                } else {
                    this.progressDialog.setMax(intValue);
                }
            } else {
                progressDialog2.setProgress(numArr[0].intValue());
            }
        }
    }
}
