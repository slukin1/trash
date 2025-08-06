package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final WeakReference<Context> mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i11, int i12, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = new WeakReference<>(context);
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i11;
        this.mRequiredHeight = i12;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadFile(android.net.Uri r5, android.net.Uri r6) throws java.lang.NullPointerException, java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = "BitmapWorkerTask"
            java.lang.String r1 = "downloadFile"
            android.util.Log.d(r0, r1)
            java.lang.String r0 = "Output Uri is null - cannot download image"
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.ref.WeakReference<android.content.Context> r0 = r4.mContext
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = "Context is null"
            java.util.Objects.requireNonNull(r0, r1)
            com.yalantis.ucrop.OkHttpClientStore r1 = com.yalantis.ucrop.OkHttpClientStore.INSTANCE
            okhttp3.OkHttpClient r1 = r1.getClient()
            r2 = 0
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch:{ all -> 0x007c }
            r3.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007c }
            okhttp3.Request$Builder r5 = r3.url((java.lang.String) r5)     // Catch:{ all -> 0x007c }
            okhttp3.Request r5 = r5.build()     // Catch:{ all -> 0x007c }
            okhttp3.Call r5 = r1.newCall(r5)     // Catch:{ all -> 0x007c }
            okhttp3.Response r5 = r5.execute()     // Catch:{ all -> 0x007c }
            okhttp3.ResponseBody r3 = r5.body()     // Catch:{ all -> 0x0078 }
            okio.BufferedSource r3 = r3.source()     // Catch:{ all -> 0x0078 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x0073 }
            java.io.OutputStream r6 = r0.openOutputStream(r6)     // Catch:{ all -> 0x0073 }
            if (r6 == 0) goto L_0x006b
            okio.Sink r2 = okio.Okio.sink((java.io.OutputStream) r6)     // Catch:{ all -> 0x0073 }
            r3.readAll(r2)     // Catch:{ all -> 0x0073 }
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r3)
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r2)
            okhttp3.ResponseBody r5 = r5.body()
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
            okhttp3.Dispatcher r5 = r1.dispatcher()
            r5.cancelAll()
            android.net.Uri r5 = r4.mOutputUri
            r4.mInputUri = r5
            return
        L_0x006b:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = "OutputStream for given output Uri is null"
            r6.<init>(r0)     // Catch:{ all -> 0x0073 }
            throw r6     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r6 = move-exception
            r0 = r5
            r5 = r2
            r2 = r3
            goto L_0x007f
        L_0x0078:
            r6 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x007f
        L_0x007c:
            r6 = move-exception
            r5 = r2
            r0 = r5
        L_0x007f:
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r2)
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
            if (r0 == 0) goto L_0x008e
            okhttp3.ResponseBody r5 = r0.body()
            com.yalantis.ucrop.util.BitmapLoadUtils.close(r5)
        L_0x008e:
            okhttp3.Dispatcher r5 = r1.dispatcher()
            r5.cancelAll()
            android.net.Uri r5 = r4.mOutputUri
            r4.mInputUri = r5
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.downloadFile(android.net.Uri, android.net.Uri):void");
    }

    private void processInputUri() throws NullPointerException, IOException {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if ("http".equals(scheme) || Constants.SCHEME.equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
            } catch (IOException | NullPointerException e11) {
                Log.e(TAG, "Downloading failed", e11);
                throw e11;
            }
        } else if (!"file".equals(scheme) && !"content".equals(scheme)) {
            Log.e(TAG, "Invalid Uri scheme " + scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream openInputStream;
        Context context = (Context) this.mContext.get();
        if (context == null) {
            return new BitmapWorkerResult(new NullPointerException("context is null"));
        }
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeStream(context.getContentResolver().openInputStream(this.mInputUri), (Rect) null, options);
                options.inSampleSize = BitmapLoadUtils.computeSize(options.outWidth, options.outHeight);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            boolean z11 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z11) {
                try {
                    openInputStream = context.getContentResolver().openInputStream(this.mInputUri);
                    bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                        BitmapLoadUtils.close(openInputStream);
                        return bitmapWorkerResult;
                    }
                    BitmapLoadUtils.close(openInputStream);
                    if (!BitmapLoadUtils.checkSize(bitmap, options)) {
                        z11 = true;
                    }
                } catch (OutOfMemoryError e12) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e12);
                    options.inSampleSize *= 2;
                } catch (IOException e13) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e13);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e13));
                } catch (Throwable th2) {
                    BitmapLoadUtils.close(openInputStream);
                    throw th2;
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(context, this.mInputUri);
            int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
            Matrix matrix = new Matrix();
            if (exifToDegrees != 0) {
                matrix.preRotate((float) exifToDegrees);
            }
            if (exifToTranslation != 1) {
                matrix.postScale((float) exifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
            }
            return new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e14) {
            return new BitmapWorkerResult(e14);
        }
    }

    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc == null) {
            this.mBitmapLoadCallback.onBitmapLoaded(bitmapWorkerResult.mBitmapResult, bitmapWorkerResult.mExifInfo, this.mInputUri, this.mOutputUri);
        } else {
            this.mBitmapLoadCallback.onFailure(exc);
        }
    }

    public static class BitmapWorkerResult {
        public Bitmap mBitmapResult;
        public Exception mBitmapWorkerException;
        public ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
