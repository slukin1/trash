package io.flutter.plugins.imagepicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ImageResizer {
    private final ExifDataCopier exifDataCopier;
    private final File externalFilesDirectory;

    public ImageResizer(File file, ExifDataCopier exifDataCopier2) {
        this.externalFilesDirectory = file;
        this.exifDataCopier = exifDataCopier2;
    }

    private void copyExif(String str, String str2) {
        this.exifDataCopier.copyExif(str, str2);
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i11) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
        File createFile = createFile(this.externalFilesDirectory, str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i11, int i12, boolean z11) {
        return Bitmap.createScaledBitmap(bitmap, i11, i12, z11);
    }

    private Bitmap decodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    private boolean isImageQualityValid(Integer num) {
        return num != null && num.intValue() > 0 && num.intValue() < 100;
    }

    private File resizedImage(Bitmap bitmap, Double d11, Double d12, Integer num, String str) throws IOException {
        double width = ((double) bitmap.getWidth()) * 1.0d;
        double height = ((double) bitmap.getHeight()) * 1.0d;
        Integer num2 = num;
        if (!isImageQualityValid(num2)) {
            num2 = 100;
        }
        boolean z11 = true;
        boolean z12 = d11 != null;
        boolean z13 = d12 != null;
        Double valueOf = Double.valueOf(z12 ? Math.min(width, d11.doubleValue()) : width);
        Double valueOf2 = Double.valueOf(z13 ? Math.min(height, d12.doubleValue()) : height);
        boolean z14 = z12 && d11.doubleValue() < width;
        boolean z15 = z13 && d12.doubleValue() < height;
        if (!z14 && !z15) {
            z11 = false;
        }
        if (z11) {
            double doubleValue = (valueOf2.doubleValue() / height) * width;
            double doubleValue2 = (valueOf.doubleValue() / width) * height;
            if (valueOf.doubleValue() < valueOf2.doubleValue()) {
                if (!z12) {
                    valueOf = Double.valueOf(doubleValue);
                } else {
                    valueOf2 = Double.valueOf(doubleValue2);
                }
            } else if (valueOf2.doubleValue() < valueOf.doubleValue()) {
                if (!z13) {
                    valueOf2 = Double.valueOf(doubleValue2);
                } else {
                    valueOf = Double.valueOf(doubleValue);
                }
            } else if (width < height) {
                valueOf = Double.valueOf(doubleValue);
            } else if (height < width) {
                valueOf2 = Double.valueOf(doubleValue2);
            }
        }
        return createImageOnExternalDirectory("/scaled_" + str, createScaledBitmap(bitmap, valueOf.intValue(), valueOf2.intValue(), false), num2.intValue());
    }

    public String resizeImageIfNeeded(String str, Double d11, Double d12, Integer num) {
        Bitmap decodeFile = decodeFile(str);
        if (decodeFile == null) {
            return null;
        }
        if (!((d11 == null && d12 == null && !isImageQualityValid(num)) ? false : true)) {
            return str;
        }
        try {
            String[] split = str.split("/");
            File resizedImage = resizedImage(decodeFile, d11, d12, num, split[split.length - 1]);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
