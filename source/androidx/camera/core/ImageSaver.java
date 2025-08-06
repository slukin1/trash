package androidx.camera.core;

import android.content.ContentValues;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mJpegQuality;
    private final int mOrientation;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    /* renamed from: androidx.camera.core.ImageSaver$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType[] r0 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = r0
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.DECODE_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.AnonymousClass1.<clinit>():void");
        }
    }

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String str, Throwable th2);

        void onImageSaved(ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    public ImageSaver(ImageProxy imageProxy, ImageCapture.OutputFileOptions outputFileOptions, int i11, int i12, Executor executor, Executor executor2, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i11;
        this.mJpegQuality = i12;
        this.mCallback = onImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    private void copyTempFileToOutputStream(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private boolean copyTempFileToUri(File file, Uri uri) throws IOException {
        OutputStream openOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, openOutputStream);
            openOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static String getFileExtensionWithDot(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(lastIndexOf) : "";
    }

    private byte[] imageToJpegByteArray(ImageProxy imageProxy, int i11) throws ImageUtil.CodecFailedException {
        boolean shouldCropImage = ImageUtil.shouldCropImage(imageProxy);
        int format = imageProxy.getFormat();
        if (format != 256) {
            Rect rect = null;
            if (format == 35) {
                if (shouldCropImage) {
                    rect = imageProxy.getCropRect();
                }
                return ImageUtil.yuvImageToJpegByteArray(imageProxy, rect, i11, 0);
            }
            Logger.w(TAG, "Unrecognized image format: " + format);
            return null;
        } else if (!shouldCropImage) {
            return ImageUtil.jpegImageToJpegByteArray(imageProxy);
        } else {
            return ImageUtil.jpegImageToJpegByteArray(imageProxy, imageProxy.getCropRect(), i11);
        }
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postError$2(SaveError saveError, String str, Throwable th2) {
        this.mCallback.onError(saveError, str, th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postSuccess$1(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    private void postError(SaveError saveError, String str, Throwable th2) {
        try {
            this.mUserCallbackExecutor.execute(new g0(this, saveError, str, th2));
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void postSuccess(Uri uri) {
        try {
            this.mUserCallbackExecutor.execute(new f0(this, uri));
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    private File saveImageToTempFile() {
        File file;
        String str;
        SaveError saveError;
        ImageUtil.CodecFailedException codecFailedException;
        FileOutputStream fileOutputStream;
        try {
            if (isSaveToFile()) {
                file = new File(this.mOutputFileOptions.getFile().getParent(), "CameraX" + UUID.randomUUID().toString() + getFileExtensionWithDot(this.mOutputFileOptions.getFile()));
            } else {
                file = File.createTempFile("CameraX", TEMP_FILE_SUFFIX);
            }
            try {
                ImageProxy imageProxy = this.mImage;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(imageToJpegByteArray(this.mImage, this.mJpegQuality));
                    Exif createFromFile = Exif.createFromFile(file);
                    Exif.createFromImageProxy(this.mImage).copyToCroppedImage(createFromFile);
                    if (!new ExifRotationAvailability().shouldUseExifOrientation(this.mImage)) {
                        createFromFile.rotate(this.mOrientation);
                    }
                    ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                    if (metadata.isReversedHorizontal()) {
                        createFromFile.flipHorizontally();
                    }
                    if (metadata.isReversedVertical()) {
                        createFromFile.flipVertically();
                    }
                    if (metadata.getLocation() != null) {
                        createFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                    }
                    createFromFile.save();
                    fileOutputStream.close();
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    codecFailedException = null;
                    saveError = null;
                    str = null;
                    if (saveError == null) {
                        return file;
                    }
                    postError(saveError, str, codecFailedException);
                    file.delete();
                    return null;
                } catch (Throwable th2) {
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    throw th2;
                }
                throw th;
            } catch (OutOfMemoryError e11) {
                saveError = SaveError.UNKNOWN;
                str = "Processing failed due to low memory.";
                codecFailedException = e11;
            } catch (IOException | IllegalArgumentException e12) {
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                codecFailedException = e12;
            } catch (ImageUtil.CodecFailedException e13) {
                int i11 = AnonymousClass1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[e13.getFailureType().ordinal()];
                if (i11 == 1) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    codecFailedException = e13;
                } else if (i11 != 2) {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    codecFailedException = e13;
                } else {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    codecFailedException = e13;
                }
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
        } catch (IOException e14) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e14);
            return null;
        }
    }

    private void setContentValuePending(ContentValues contentValues, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i11));
        }
    }

    private void setUriNotPending(Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePending(contentValues, 0);
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a8  */
    /* renamed from: copyTempFileToDestination */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void lambda$run$0(java.io.File r6) {
        /*
            r5 = this;
            androidx.core.util.h.g(r6)
            r0 = 0
            boolean r1 = r5.isSaveToMediaStore()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r1 == 0) goto L_0x0056
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            android.content.ContentValues r1 = r1.getContentValues()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r1 == 0) goto L_0x001e
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            android.content.ContentValues r2 = r2.getContentValues()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            goto L_0x0023
        L_0x001e:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            r1.<init>()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
        L_0x0023:
            r2 = 1
            r5.setContentValuePending(r1, r2)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            androidx.camera.core.ImageCapture$OutputFileOptions r3 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            android.net.Uri r3 = r3.getSaveCollection()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            android.net.Uri r1 = r2.insert(r3, r1)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r1 != 0) goto L_0x003f
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0054, IllegalArgumentException -> 0x0052, SecurityException -> 0x0050 }
            java.lang.String r3 = "Failed to insert URI."
            goto L_0x009f
        L_0x003f:
            boolean r2 = r5.copyTempFileToUri(r6, r1)     // Catch:{ IOException -> 0x0054, IllegalArgumentException -> 0x0052, SecurityException -> 0x0050 }
            if (r2 != 0) goto L_0x004a
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0054, IllegalArgumentException -> 0x0052, SecurityException -> 0x0050 }
            java.lang.String r3 = "Failed to save to URI."
            goto L_0x004c
        L_0x004a:
            r2 = r0
            r3 = r2
        L_0x004c:
            r5.setUriNotPending(r1)     // Catch:{ IOException -> 0x0054, IllegalArgumentException -> 0x0052, SecurityException -> 0x0050 }
            goto L_0x009f
        L_0x0050:
            r0 = move-exception
            goto L_0x009b
        L_0x0052:
            r0 = move-exception
            goto L_0x009b
        L_0x0054:
            r0 = move-exception
            goto L_0x009b
        L_0x0056:
            boolean r1 = r5.isSaveToOutputStream()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r1 == 0) goto L_0x0066
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            r5.copyTempFileToOutputStream(r6, r1)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            goto L_0x008d
        L_0x0066:
            boolean r1 = r5.isSaveToFile()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r1 == 0) goto L_0x008d
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            java.io.File r1 = r1.getFile()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r2 == 0) goto L_0x007b
            r1.delete()     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
        L_0x007b:
            boolean r2 = r6.renameTo(r1)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            if (r2 != 0) goto L_0x0086
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            java.lang.String r3 = "Failed to rename file."
            goto L_0x0088
        L_0x0086:
            r2 = r0
            r3 = r2
        L_0x0088:
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ IOException -> 0x0097, IllegalArgumentException -> 0x0095, SecurityException -> 0x0093 }
            goto L_0x009f
        L_0x008d:
            r1 = r0
            r2 = r1
            r3 = r2
            goto L_0x009f
        L_0x0091:
            r0 = move-exception
            goto L_0x00ac
        L_0x0093:
            r1 = move-exception
            goto L_0x0098
        L_0x0095:
            r1 = move-exception
            goto L_0x0098
        L_0x0097:
            r1 = move-exception
        L_0x0098:
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x009b:
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "Failed to write destination file."
        L_0x009f:
            r6.delete()
            if (r2 == 0) goto L_0x00a8
            r5.postError(r2, r3, r0)
            goto L_0x00ab
        L_0x00a8:
            r5.postSuccess(r1)
        L_0x00ab:
            return
        L_0x00ac:
            r6.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.lambda$run$0(java.io.File):void");
    }

    public void run() {
        File saveImageToTempFile = saveImageToTempFile();
        if (saveImageToTempFile != null) {
            this.mSequentialIoExecutor.execute(new h0(this, saveImageToTempFile));
        }
    }
}
