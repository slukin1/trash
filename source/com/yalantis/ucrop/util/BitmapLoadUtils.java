package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    private static final String CONTENT_SCHEME = "content";
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapLoadUtils";

    @Deprecated
    public static int calculateInSampleSize(BitmapFactory.Options options, int i11, int i12) {
        int i13 = options.outHeight;
        int i14 = options.outWidth;
        int i15 = 1;
        if (i13 > i12 || i14 > i11) {
            while (true) {
                if (i13 / i15 <= i12 && i14 / i15 <= i11) {
                    break;
                }
                i15 *= 2;
            }
        }
        return i15;
    }

    public static int calculateMaxBitmapSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow((double) point.x, 2.0d) + Math.pow((double) point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int maxTextureSize = EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            sqrt = Math.min(sqrt, maxTextureSize);
        }
        Log.d(TAG, "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if (((long) (bitmap != null ? bitmap.getByteCount() : 0)) <= getTotalMemory()) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int computeSize(int i11, int i12) {
        if (i11 % 2 == 1) {
            i11++;
        }
        if (i12 % 2 == 1) {
            i12++;
        }
        int max = Math.max(i11, i12);
        float min = ((float) Math.min(i11, i12)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d11 = (double) min;
            if (d11 > 0.5625d || d11 <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d11));
            }
            int i13 = max / 1280;
            if (i13 == 0) {
                return 1;
            }
            return i13;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max <= 4990 || max >= 10240) {
                return max / 1280;
            }
            return 4;
        }
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int i11, int i12, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i11, i12, bitmapLoadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int exifToDegrees(int i11) {
        switch (i11) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i11) {
        return (i11 == 2 || i11 == 7 || i11 == 4 || i11 == 5) ? -1 : 1;
    }

    public static int getExifOrientation(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            int orientation = new ImageHeaderParser(openInputStream).getOrientation();
            close(openInputStream);
            return orientation;
        } catch (IOException e11) {
            Log.e(TAG, "getExifOrientation: " + uri.toString(), e11);
            return 0;
        }
    }

    public static int[] getMaxImageSize(Context context, Uri uri) {
        InputStream openInputStream;
        if (FileUtils.isHasHttp(uri.toString())) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), (Rect) null, options);
            options.inSampleSize = computeSize(options.outWidth, options.outHeight);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        boolean z11 = false;
        while (!z11) {
            try {
                openInputStream = context.getContentResolver().openInputStream(uri);
                bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                close(openInputStream);
                if (!checkSize(bitmap, options)) {
                    z11 = true;
                }
            } catch (OutOfMemoryError e12) {
                Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e12);
                options.inSampleSize *= 2;
            } catch (IOException e13) {
                Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e13);
            } catch (Throwable th2) {
                close(openInputStream);
                throw th2;
            }
        }
        if (bitmap == null) {
            return new int[]{0, 0};
        }
        return new int[]{bitmap.getWidth(), bitmap.getHeight()};
    }

    public static long getTotalMemory() {
        long j11 = Runtime.getRuntime().totalMemory();
        if (j11 > 104857600) {
            return 104857600;
        }
        return j11;
    }

    public static boolean hasContentScheme(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (!bitmap.sameAs(createBitmap)) {
                return createBitmap;
            }
            return bitmap;
        } catch (OutOfMemoryError e11) {
            Log.e(TAG, "transformBitmap: ", e11);
            return bitmap;
        }
    }
}
