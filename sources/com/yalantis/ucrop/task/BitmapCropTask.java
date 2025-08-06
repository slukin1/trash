package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import m1.a;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    private static final String CONTENT_SCHEME = "content";
    private static final int MIN_CROPPED_HEIGHT = 1;
    private static final String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private final Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContext;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final ExifInfo mExifInfo;
    private final String mImageInputPath;
    private final Uri mImageInputUri;
    private final String mImageOutputPath;
    private final Uri mImageOutputUri;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mContext = new WeakReference<>(context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mImageInputUri = cropParameters.getContentImageInputUri();
        this.mImageOutputUri = cropParameters.getContentImageOutputUri();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    private void checkValidityCropBounds() {
        if (this.cropOffsetX < 0) {
            this.cropOffsetX = 0;
            this.mCroppedImageWidth = this.mViewBitmap.getWidth();
        }
        if (this.cropOffsetY < 0) {
            this.cropOffsetY = 0;
            this.mCroppedImageHeight = this.mViewBitmap.getHeight();
        }
    }

    private void copyExifForOutputFile(Context context) throws IOException {
        boolean hasContentScheme = BitmapLoadUtils.hasContentScheme(this.mImageInputUri);
        boolean hasContentScheme2 = BitmapLoadUtils.hasContentScheme(this.mImageOutputUri);
        if (!hasContentScheme || !hasContentScheme2) {
            if (hasContentScheme) {
                ImageHeaderParser.copyExif(context, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageInputUri, this.mImageOutputPath);
            } else if (!hasContentScheme2) {
                ImageHeaderParser.copyExif(new a(this.mImageInputPath), this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
            } else if (Build.VERSION.SDK_INT >= 21) {
                ImageHeaderParser.copyExif(context, new a(this.mImageInputPath), this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputUri);
            } else {
                Log.e(TAG, "It is not possible to write exif info into file represented by \"content\" Uri if Android < LOLLIPOP");
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            ImageHeaderParser.copyExif(context, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageInputUri, this.mImageOutputUri);
        } else {
            Log.e(TAG, "It is not possible to write exif info into file represented by \"content\" Uri if Android < LOLLIPOP");
        }
    }

    private boolean crop() throws IOException {
        Context context = (Context) this.mContext.get();
        if (context == null) {
            return false;
        }
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float width = this.mCropRect.width() / this.mCurrentScale;
            float height = this.mCropRect.height() / this.mCurrentScale;
            int i11 = this.mMaxResultImageSizeX;
            if (width > ((float) i11) || height > ((float) this.mMaxResultImageSizeY)) {
                float min = Math.min(((float) i11) / width, ((float) this.mMaxResultImageSizeY) / height);
                Bitmap bitmap = this.mViewBitmap;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * min), Math.round(((float) this.mViewBitmap.getHeight()) * min), false);
                Bitmap bitmap2 = this.mViewBitmap;
                if (bitmap2 != createScaledBitmap) {
                    bitmap2.recycle();
                }
                this.mViewBitmap = createScaledBitmap;
                this.mCurrentScale /= min;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.mCurrentAngle, (float) (this.mViewBitmap.getWidth() / 2), (float) (this.mViewBitmap.getHeight() / 2));
            Bitmap bitmap3 = this.mViewBitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.mViewBitmap.getHeight(), matrix, true);
            Bitmap bitmap4 = this.mViewBitmap;
            if (bitmap4 != createBitmap) {
                bitmap4.recycle();
            }
            this.mViewBitmap = createBitmap;
        }
        this.cropOffsetX = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        this.cropOffsetY = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        this.mCroppedImageWidth = Math.round(this.mCropRect.width() / this.mCurrentScale);
        int round = Math.round(this.mCropRect.height() / this.mCurrentScale);
        this.mCroppedImageHeight = round;
        boolean shouldCrop = shouldCrop(this.mCroppedImageWidth, round);
        Log.i(TAG, "Should crop: " + shouldCrop);
        if (shouldCrop) {
            checkValidityCropBounds();
            saveImage(Bitmap.createBitmap(this.mViewBitmap, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight));
            if (!this.mCompressFormat.equals(Bitmap.CompressFormat.JPEG)) {
                return true;
            }
            copyExifForOutputFile(context);
            return true;
        }
        if (Build.VERSION.SDK_INT < 29 || !FileUtils.isContent(this.mImageInputPath)) {
            FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        } else {
            FileUtils.writeFileFromIS(context.getContentResolver().openInputStream(Uri.parse(this.mImageInputPath)), new FileOutputStream(this.mImageOutputPath));
        }
        return false;
    }

    private void saveImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        Context context = (Context) this.mContext.get();
        if (context != null) {
            OutputStream outputStream = null;
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(this.mImageOutputUri);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e11) {
                    e = e11;
                    byteArrayOutputStream = null;
                    outputStream = openOutputStream;
                    try {
                        Log.e(TAG, e.getLocalizedMessage());
                        BitmapLoadUtils.close(outputStream);
                        BitmapLoadUtils.close(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        BitmapLoadUtils.close(outputStream);
                        BitmapLoadUtils.close(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    outputStream = openOutputStream;
                    BitmapLoadUtils.close(outputStream);
                    BitmapLoadUtils.close(byteArrayOutputStream);
                    throw th;
                }
                try {
                    bitmap.compress(this.mCompressFormat, this.mCompressQuality, byteArrayOutputStream);
                    openOutputStream.write(byteArrayOutputStream.toByteArray());
                    bitmap.recycle();
                    BitmapLoadUtils.close(openOutputStream);
                } catch (IOException e12) {
                    e = e12;
                    outputStream = openOutputStream;
                    Log.e(TAG, e.getLocalizedMessage());
                    BitmapLoadUtils.close(outputStream);
                    BitmapLoadUtils.close(byteArrayOutputStream);
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = openOutputStream;
                    BitmapLoadUtils.close(outputStream);
                    BitmapLoadUtils.close(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                byteArrayOutputStream = null;
                Log.e(TAG, e.getLocalizedMessage());
                BitmapLoadUtils.close(outputStream);
                BitmapLoadUtils.close(byteArrayOutputStream);
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                BitmapLoadUtils.close(outputStream);
                BitmapLoadUtils.close(byteArrayOutputStream);
                throw th;
            }
            BitmapLoadUtils.close(byteArrayOutputStream);
        }
    }

    private boolean shouldCrop(int i11, int i12) {
        int round = Math.round(((float) Math.max(i11, i12)) / 1000.0f) + 1;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            return true;
        }
        float f11 = (float) round;
        if (Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) > f11 || Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > f11 || Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > f11 || Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > f11 || this.mCurrentAngle != 0.0f) {
            return true;
        }
        return false;
    }

    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        if (this.mImageOutputUri == null) {
            return new NullPointerException("ImageOutputUri is null");
        }
        try {
            crop();
            this.mViewBitmap = null;
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }

    public void onPostExecute(Throwable th2) {
        Uri uri;
        BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback == null) {
            return;
        }
        if (th2 == null) {
            if (BitmapLoadUtils.hasContentScheme(this.mImageOutputUri)) {
                uri = this.mImageOutputUri;
            } else {
                uri = Uri.fromFile(new File(this.mImageOutputPath));
            }
            this.mCropCallback.onBitmapCropped(uri, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
            return;
        }
        bitmapCropCallback.onCropFailure(th2);
    }
}
