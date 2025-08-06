package com.google.zxing.client.android.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hbg.lib.common.BaseApplication;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.Hashtable;

public class CodeUtils {
    public static final String LAYOUT_ID = "layout_id";
    public static final int RESULT_FAILED = 2;
    public static final String RESULT_STRING = "result_string";
    public static final int RESULT_SUCCESS = 1;
    public static final String RESULT_TYPE = "result_type";

    public interface AnalyzeCallback {
        void onAnalyzeFailed();

        void onAnalyzeSuccess(Bitmap bitmap, String str);
    }

    public static Result analyzeBitmap(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i11 = 1;
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        int i12 = (int) (((float) options.outHeight) / 400.0f);
        if (i12 > 0) {
            i11 = i12;
        }
        options.inSampleSize = i11;
        return decodeBitmap(BitmapFactory.decodeFile(str, options));
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i11, int i12) {
        int i13 = options.outWidth;
        int i14 = options.outHeight;
        int i15 = 1;
        if (i14 > i12 || i13 > i11) {
            int i16 = i13 / 2;
            int i17 = i14 / 2;
            while (i16 / i15 >= i11 && i17 / i15 >= i12) {
                i15 *= 2;
            }
        }
        return i15;
    }

    public static Bitmap createImage(String str, int i11, int i12, Bitmap bitmap) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i11;
        int i18 = i12;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Bitmap scaleLogo = getScaleLogo(bitmap, i17, i18);
            int i19 = i17 / 2;
            int i21 = i18 / 2;
            int i22 = 0;
            if (scaleLogo != null) {
                int width = scaleLogo.getWidth();
                int height = scaleLogo.getHeight();
                i15 = width;
                i13 = height;
                i16 = (i17 - width) / 2;
                i14 = (i18 - height) / 2;
            } else {
                i16 = i19;
                i14 = i21;
                i15 = 0;
                i13 = 0;
            }
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i11, i12, hashtable);
            int[] iArr = new int[(i17 * i18)];
            int i23 = 0;
            while (i23 < i18) {
                for (int i24 = i22; i24 < i17; i24++) {
                    int i25 = RoundedDrawable.DEFAULT_BORDER_COLOR;
                    if (i24 >= i16 && i24 < i16 + i15 && i23 >= i14 && i23 < i14 + i13) {
                        int pixel = scaleLogo.getPixel(i24 - i16, i23 - i14);
                        if (pixel != 0) {
                            i25 = pixel;
                        } else if (!encode.get(i24, i23)) {
                            i25 = -1;
                        }
                        iArr[(i23 * i17) + i24] = i25;
                    } else if (encode.get(i24, i23)) {
                        iArr[(i23 * i17) + i24] = -16777216;
                    } else {
                        iArr[(i23 * i17) + i24] = -1;
                    }
                }
                i23++;
                i22 = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i11, 0, 0, i11, i12);
            return createBitmap;
        } catch (WriterException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static Result decodeBitmap(Bitmap bitmap) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        hashtable.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i11 = 0; i11 < width; i11++) {
            bArr[i11] = (byte) iArr[i11];
        }
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(bArr, bitmap.getWidth(), bitmap.getHeight(), 0, 0, bitmap.getWidth(), bitmap.getHeight(), false))), hashtable);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        } finally {
            bitmap.recycle();
        }
    }

    public static String decodeBitmapToString(Bitmap bitmap) {
        Result decodeBitmap = decodeBitmap(bitmap);
        if (decodeBitmap == null) {
            bitmap.recycle();
            return null;
        }
        bitmap.recycle();
        return decodeBitmap.getText();
    }

    public static Bitmap drawableToBitmap(int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Resources resources = BaseApplication.b().getResources();
        BitmapFactory.decodeResource(resources, i11, options);
        options.inSampleSize = calculateInSampleSize(options, 100, 100);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        BitmapFactory.decodeResource(resources, i11, options);
        Drawable drawable = resources.getDrawable(i11);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return drawableToBitmapViaCanvas(drawable);
    }

    private static Bitmap drawableToBitmapViaCanvas(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static Bitmap getScaleLogo(Bitmap bitmap, int i11, int i12) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        float min = Math.min(((((float) i11) * 1.0f) / 5.0f) / ((float) bitmap.getWidth()), ((((float) i12) * 1.0f) / 5.0f) / ((float) bitmap.getHeight()));
        matrix.postScale(min, min);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
