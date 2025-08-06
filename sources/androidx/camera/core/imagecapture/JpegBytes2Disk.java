package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.google.auto.value.AutoValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    @AutoValue
    public static abstract class In {
        public static In of(Packet<byte[]> packet, ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }

        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        public abstract Packet<byte[]> getPacket();
    }

    private static Uri copyFileToFile(File file, File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Uri copyFileToMediaStore(java.io.File r6, androidx.camera.core.ImageCapture.OutputFileOptions r7) throws androidx.camera.core.ImageCaptureException {
        /*
            android.content.ContentResolver r0 = r7.getContentResolver()
            java.util.Objects.requireNonNull(r0)
            r1 = r0
            android.content.ContentResolver r1 = (android.content.ContentResolver) r1
            android.content.ContentValues r1 = r7.getContentValues()
            if (r1 == 0) goto L_0x001a
            android.content.ContentValues r1 = new android.content.ContentValues
            android.content.ContentValues r2 = r7.getContentValues()
            r1.<init>(r2)
            goto L_0x001f
        L_0x001a:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
        L_0x001f:
            r2 = 1
            setContentValuePendingFlag(r1, r2)
            r3 = 0
            r4 = 0
            android.net.Uri r7 = r7.getSaveCollection()     // Catch:{ IOException -> 0x004a, SecurityException -> 0x0048 }
            android.net.Uri r7 = r0.insert(r7, r1)     // Catch:{ IOException -> 0x004a, SecurityException -> 0x0048 }
            if (r7 == 0) goto L_0x003e
            copyTempFileToUri(r6, r7, r0)     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0039, all -> 0x0036 }
            updateUriPendingStatus(r7, r0, r3)
            return r7
        L_0x0036:
            r6 = move-exception
            r4 = r7
            goto L_0x0062
        L_0x0039:
            r6 = move-exception
            goto L_0x003c
        L_0x003b:
            r6 = move-exception
        L_0x003c:
            r4 = r7
            goto L_0x004b
        L_0x003e:
            androidx.camera.core.ImageCaptureException r6 = new androidx.camera.core.ImageCaptureException     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0039, all -> 0x0036 }
            java.lang.String r1 = "Failed to insert a MediaStore URI."
            r6.<init>(r2, r1, r4)     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0039, all -> 0x0036 }
            throw r6     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0039, all -> 0x0036 }
        L_0x0046:
            r6 = move-exception
            goto L_0x0062
        L_0x0048:
            r6 = move-exception
            goto L_0x004b
        L_0x004a:
            r6 = move-exception
        L_0x004b:
            androidx.camera.core.ImageCaptureException r7 = new androidx.camera.core.ImageCaptureException     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r1.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "Failed to write to MediaStore URI: "
            r1.append(r5)     // Catch:{ all -> 0x0046 }
            r1.append(r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0046 }
            r7.<init>(r2, r1, r6)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0046 }
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            updateUriPendingStatus(r4, r0, r3)
        L_0x0067:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.JpegBytes2Disk.copyFileToMediaStore(java.io.File, androidx.camera.core.ImageCapture$OutputFileOptions):android.net.Uri");
    }

    private static void copyFileToOutputStream(File file, OutputStream outputStream) throws IOException {
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

    private static void copyTempFileToUri(File file, Uri uri, ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        if (openOutputStream != null) {
            try {
                copyFileToOutputStream(file, openOutputStream);
                openOutputStream.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw new FileNotFoundException(uri + " cannot be resolved.");
        }
        throw th;
    }

    private static File createTempFile(ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File file = outputFileOptions.getFile();
            if (file == null) {
                return File.createTempFile("CameraX", TEMP_FILE_SUFFIX);
            }
            String parent = file.getParent();
            return new File(parent, "CameraX" + UUID.randomUUID().toString() + getFileExtensionWithDot(file));
        } catch (IOException e11) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e11);
        }
    }

    private static String getFileExtensionWithDot(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(lastIndexOf) : "";
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.getFile() != null;
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions outputFileOptions) {
        return (outputFileOptions.getSaveCollection() == null || outputFileOptions.getContentResolver() == null || outputFileOptions.getContentValues() == null) ? false : true;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.getOutputStream() != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        throw new androidx.camera.core.ImageCaptureException(1, "Failed to write to OutputStream.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r3.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri moveFileToTarget(java.io.File r3, androidx.camera.core.ImageCapture.OutputFileOptions r4) throws androidx.camera.core.ImageCaptureException {
        /*
            r0 = 0
            boolean r1 = isSaveToMediaStore(r4)     // Catch:{ IOException -> 0x003a }
            if (r1 == 0) goto L_0x000c
            android.net.Uri r0 = copyFileToMediaStore(r3, r4)     // Catch:{ IOException -> 0x003a }
            goto L_0x0034
        L_0x000c:
            boolean r1 = isSaveToOutputStream(r4)     // Catch:{ IOException -> 0x003a }
            if (r1 == 0) goto L_0x0020
            java.io.OutputStream r4 = r4.getOutputStream()     // Catch:{ IOException -> 0x003a }
            java.util.Objects.requireNonNull(r4)     // Catch:{ IOException -> 0x003a }
            r1 = r4
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ IOException -> 0x003a }
            copyFileToOutputStream(r3, r4)     // Catch:{ IOException -> 0x003a }
            goto L_0x0034
        L_0x0020:
            boolean r1 = isSaveToFile(r4)     // Catch:{ IOException -> 0x003a }
            if (r1 == 0) goto L_0x0034
            java.io.File r4 = r4.getFile()     // Catch:{ IOException -> 0x003a }
            java.util.Objects.requireNonNull(r4)     // Catch:{ IOException -> 0x003a }
            r1 = r4
            java.io.File r1 = (java.io.File) r1     // Catch:{ IOException -> 0x003a }
            android.net.Uri r0 = copyFileToFile(r3, r4)     // Catch:{ IOException -> 0x003a }
        L_0x0034:
            r3.delete()
            return r0
        L_0x0038:
            r4 = move-exception
            goto L_0x0043
        L_0x003a:
            androidx.camera.core.ImageCaptureException r4 = new androidx.camera.core.ImageCaptureException     // Catch:{ all -> 0x0038 }
            r1 = 1
            java.lang.String r2 = "Failed to write to OutputStream."
            r4.<init>(r1, r2, r0)     // Catch:{ all -> 0x0038 }
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0043:
            r3.delete()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.JpegBytes2Disk.moveFileToTarget(java.io.File, androidx.camera.core.ImageCapture$OutputFileOptions):android.net.Uri");
    }

    private static void setContentValuePendingFlag(ContentValues contentValues, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i11));
        }
    }

    private static void updateFileExif(File file, Exif exif, ImageCapture.OutputFileOptions outputFileOptions, int i11) throws ImageCaptureException {
        try {
            Exif createFromFile = Exif.createFromFile(file);
            exif.copyToCroppedImage(createFromFile);
            if (createFromFile.getRotation() == 0 && i11 != 0) {
                createFromFile.rotate(i11);
            }
            ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
            if (metadata.isReversedHorizontal()) {
                createFromFile.flipHorizontally();
            }
            if (metadata.isReversedVertical()) {
                createFromFile.flipVertically();
            }
            if (metadata.getLocation() != null) {
                createFromFile.attachLocation(metadata.getLocation());
            }
            createFromFile.save();
        } catch (IOException e11) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e11);
        }
    }

    private static void updateUriPendingStatus(Uri uri, ContentResolver contentResolver, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePendingFlag(contentValues, i11);
            contentResolver.update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    private static void writeBytesToFile(File file, byte[] bArr) throws ImageCaptureException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr, 0, new InvalidJpegDataParser().getValidDataLength(bArr));
            fileOutputStream.close();
            return;
        } catch (IOException e11) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public ImageCapture.OutputFileResults apply(In in2) throws ImageCaptureException {
        Packet<byte[]> packet = in2.getPacket();
        ImageCapture.OutputFileOptions outputFileOptions = in2.getOutputFileOptions();
        File createTempFile = createTempFile(outputFileOptions);
        writeBytesToFile(createTempFile, packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        updateFileExif(createTempFile, exif, outputFileOptions, packet.getRotationDegrees());
        return new ImageCapture.OutputFileResults(moveFileToTarget(createTempFile, outputFileOptions));
    }
}
