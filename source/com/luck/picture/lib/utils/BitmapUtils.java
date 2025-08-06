package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.InputStream;
import m1.a;

public class BitmapUtils {
    private static final int ARGB_8888_MEMORY_BYTE = 4;
    private static final int MAX_BITMAP_SIZE = 104857600;

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

    public static int[] getMaxImageSize(int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return new int[]{-1, -1};
        }
        int computeSize = computeSize(i11, i12);
        long totalMemory = getTotalMemory();
        int i13 = -1;
        boolean z11 = false;
        int i14 = -1;
        while (!z11) {
            i13 = i11 / computeSize;
            i14 = i12 / computeSize;
            if (((long) (i13 * i14 * 4)) > totalMemory) {
                computeSize *= 2;
            } else {
                z11 = true;
            }
        }
        return new int[]{i13, i14};
    }

    public static long getTotalMemory() {
        long j11 = Runtime.getRuntime().totalMemory();
        if (j11 > 104857600) {
            return 104857600;
        }
        return j11;
    }

    public static int readPictureDegree(Context context, String str) {
        a aVar;
        int i11;
        InputStream inputStream = null;
        try {
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                aVar = new a(inputStream);
            } else {
                aVar = new a(str);
            }
            int i12 = aVar.i("Orientation", 1);
            if (i12 == 3) {
                i11 = 180;
            } else if (i12 == 6) {
                i11 = 90;
            } else if (i12 != 8) {
                return 0;
            } else {
                i11 = 270;
            }
            PictureFileUtils.close(inputStream);
            return i11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        } finally {
            PictureFileUtils.close(inputStream);
        }
    }

    public static void rotateImage(Context context, String str) {
        Closeable closeable;
        Bitmap bitmap;
        Closeable closeable2;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Bitmap bitmap2;
        FileOutputStream fileOutputStream2;
        InputStream inputStream2 = null;
        try {
            int readPictureDegree = readPictureDegree(context, str);
            if (readPictureDegree > 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.isContent(str)) {
                    inputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    try {
                        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    } catch (Exception e11) {
                        e = e11;
                        closeable2 = null;
                        bitmap = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        bitmap = null;
                        inputStream2 = inputStream;
                        PictureFileUtils.close(inputStream2);
                        PictureFileUtils.close(closeable);
                        bitmap.recycle();
                        throw th;
                    }
                } else {
                    BitmapFactory.decodeFile(str, options);
                    inputStream = null;
                }
                options.inSampleSize = computeSize(options.outWidth, options.outHeight);
                options.inJustDecodeBounds = false;
                if (PictureMimeType.isContent(str)) {
                    inputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    bitmap2 = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                } else {
                    bitmap2 = BitmapFactory.decodeFile(str, options);
                }
                if (bitmap2 != null) {
                    try {
                        bitmap = rotatingImage(bitmap2, readPictureDegree);
                        try {
                            if (PictureMimeType.isContent(str)) {
                                fileOutputStream2 = (FileOutputStream) PictureContentResolver.openOutputStream(context, Uri.parse(str));
                            } else {
                                fileOutputStream2 = new FileOutputStream(str);
                            }
                            FileOutputStream fileOutputStream3 = fileOutputStream2;
                            saveBitmapFile(bitmap, fileOutputStream3);
                            fileOutputStream = fileOutputStream3;
                        } catch (Exception e12) {
                            e = e12;
                            closeable2 = null;
                            inputStream2 = inputStream;
                            try {
                                e.printStackTrace();
                                PictureFileUtils.close(inputStream2);
                                PictureFileUtils.close(closeable);
                                if (bitmap == null || bitmap.isRecycled()) {
                                    return;
                                }
                                bitmap.recycle();
                            } catch (Throwable th3) {
                                th = th3;
                                PictureFileUtils.close(inputStream2);
                                PictureFileUtils.close(closeable);
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            closeable = null;
                            inputStream2 = inputStream;
                            PictureFileUtils.close(inputStream2);
                            PictureFileUtils.close(closeable);
                            bitmap.recycle();
                            throw th;
                        }
                    } catch (Exception e13) {
                        e = e13;
                        closeable2 = null;
                        bitmap = bitmap2;
                        inputStream2 = inputStream;
                        e.printStackTrace();
                        PictureFileUtils.close(inputStream2);
                        PictureFileUtils.close(closeable);
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = null;
                        bitmap = bitmap2;
                        inputStream2 = inputStream;
                        PictureFileUtils.close(inputStream2);
                        PictureFileUtils.close(closeable);
                        bitmap.recycle();
                        throw th;
                    }
                } else {
                    fileOutputStream = null;
                    bitmap = bitmap2;
                }
                inputStream2 = inputStream;
            } else {
                fileOutputStream = null;
                bitmap = null;
            }
            PictureFileUtils.close(inputStream2);
            PictureFileUtils.close(fileOutputStream);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
        } catch (Exception e14) {
            e = e14;
            closeable2 = null;
            bitmap = null;
            e.printStackTrace();
            PictureFileUtils.close(inputStream2);
            PictureFileUtils.close(closeable);
            return;
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            bitmap = null;
            PictureFileUtils.close(inputStream2);
            PictureFileUtils.close(closeable);
            bitmap.recycle();
            throw th;
        }
        bitmap.recycle();
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int i11) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveBitmapFile(Bitmap bitmap, FileOutputStream fileOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                PictureFileUtils.close(fileOutputStream);
                PictureFileUtils.close(byteArrayOutputStream2);
            } catch (Exception e11) {
                e = e11;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e.printStackTrace();
                    PictureFileUtils.close(fileOutputStream);
                    PictureFileUtils.close(byteArrayOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    PictureFileUtils.close(fileOutputStream);
                    PictureFileUtils.close(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                PictureFileUtils.close(fileOutputStream);
                PictureFileUtils.close(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            PictureFileUtils.close(fileOutputStream);
            PictureFileUtils.close(byteArrayOutputStream);
        }
    }
}
