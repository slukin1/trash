package com.tencent.qcloud.tuikit.tuicallkit.view.common.gridimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GridImageSynthesizer {
    private Context mContext;
    private String mCurrentImageId = "";
    private GridImageData mGridImageData;
    private ImageView mImageView;

    public GridImageSynthesizer(Context context, ImageView imageView) {
        this.mContext = context;
        this.mImageView = imageView;
        init();
    }

    private Bitmap asyncLoadImage(Object obj, int i11) throws ExecutionException, InterruptedException {
        return ImageLoader.loadBitmap(this.mContext, obj, i11);
    }

    /* access modifiers changed from: private */
    public boolean asyncLoadImageList(GridImageData gridImageData) {
        List<Object> imageUrlList = gridImageData.getImageUrlList();
        for (int i11 = 0; i11 < imageUrlList.size(); i11++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.tuicalling_ic_avatar);
            try {
                gridImageData.putBitmap(asyncLoadImage(imageUrlList.get(i11), gridImageData.targetImageSize), i11);
            } catch (InterruptedException | ExecutionException e11) {
                e11.printStackTrace();
                gridImageData.putBitmap(decodeResource, i11);
            }
        }
        return true;
    }

    private int[] calculateGridParam(int i11) {
        int[] iArr = new int[2];
        if (i11 < 3) {
            iArr[0] = 1;
            iArr[1] = i11;
        } else if (i11 <= 4) {
            iArr[0] = 2;
            iArr[1] = 2;
        } else {
            iArr[0] = (i11 / 3) + (i11 % 3 == 0 ? 0 : 1);
            iArr[1] = 3;
        }
        return iArr;
    }

    private void drawBitmapAtPosition(Canvas canvas, int i11, int i12, int i13, int i14, Bitmap bitmap) {
        if (bitmap == null && this.mGridImageData.getDefaultImageResId() > 0) {
            bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), this.mGridImageData.getDefaultImageResId());
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i11, i12, i13, i14), (Paint) null);
        }
    }

    private void drawDrawable(Canvas canvas, GridImageData gridImageData) {
        char c11;
        int i11;
        GridImageData gridImageData2 = gridImageData;
        canvas.drawColor(gridImageData2.bgColor);
        int size = gridImageData.size();
        int i12 = gridImageData2.maxHeight;
        int i13 = gridImageData2.gap;
        int i14 = (i12 + i13) / 2;
        int i15 = (i12 - i13) / 2;
        int i16 = gridImageData2.maxWidth;
        int i17 = (i16 + i13) / 2;
        int i18 = (i16 - i13) / 2;
        int i19 = (i12 - gridImageData2.targetImageSize) / 2;
        int i21 = 0;
        while (i21 < size) {
            int i22 = gridImageData2.columnCount;
            int i23 = i21 / i22;
            int i24 = i21 % i22;
            int i25 = gridImageData2.targetImageSize;
            int i26 = i14;
            double d11 = ((double) i25) * (i22 == 1 ? ((double) i24) + 0.5d : (double) i24);
            int i27 = gridImageData2.gap;
            int i28 = i15;
            int i29 = (int) (d11 + ((double) ((i24 + 1) * i27)));
            int i30 = (int) ((((double) i25) * (i22 == 1 ? ((double) i23) + 0.5d : (double) i23)) + ((double) (i27 * (i23 + 1))));
            int i31 = i29 + i25;
            int i32 = i30 + i25;
            Bitmap bitmap = gridImageData2.getBitmap(i21);
            if (size == 1) {
                i11 = i21;
                drawBitmapAtPosition(canvas, i29, i30, i31, i32, bitmap);
                c11 = 2;
            } else {
                i11 = i21;
                if (size == 2) {
                    c11 = 2;
                    drawBitmapAtPosition(canvas, i29, i19, i31, i19 + gridImageData2.targetImageSize, bitmap);
                } else {
                    c11 = 2;
                    if (size == 3) {
                        if (i11 == 0) {
                            drawBitmapAtPosition(canvas, i19, i30, i19 + gridImageData2.targetImageSize, i32, bitmap);
                        } else {
                            int i33 = gridImageData2.gap;
                            int i34 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 1) * i34) + (i33 * i11), i26, (i33 * i11) + (i34 * i11), i26 + i34, bitmap);
                        }
                    } else if (size == 4) {
                        drawBitmapAtPosition(canvas, i29, i30, i31, i32, bitmap);
                    } else if (size == 5) {
                        if (i11 == 0) {
                            int i35 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, i18 - i35, i18 - i35, i18, i18, bitmap);
                        } else if (i11 == 1) {
                            int i36 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, i17, i18 - i36, i17 + i36, i18, bitmap);
                        } else {
                            int i37 = gridImageData2.gap;
                            int i38 = i11 - 1;
                            int i39 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 2) * i39) + (i37 * i38), i26, (i37 * i38) + (i38 * i39), i26 + i39, bitmap);
                        }
                    } else if (size == 6) {
                        if (i11 < 3) {
                            int i40 = gridImageData2.gap;
                            int i41 = i11 + 1;
                            int i42 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, (i42 * i11) + (i40 * i41), i28 - i42, (i40 * i41) + (i42 * i41), i28, bitmap);
                        } else {
                            int i43 = gridImageData2.gap;
                            int i44 = i11 - 2;
                            int i45 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 3) * i45) + (i43 * i44), i26, (i43 * i44) + (i44 * i45), i26 + i45, bitmap);
                        }
                    } else if (size == 7) {
                        if (i11 == 0) {
                            int i46 = gridImageData2.gap;
                            int i47 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, i19, i46, i19 + i47, i46 + i47, bitmap);
                        } else if (i11 <= 0 || i11 >= 4) {
                            int i48 = gridImageData2.gap;
                            int i49 = i11 - 3;
                            int i50 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 4) * i50) + (i48 * i49), i26 + (i50 / 2), (i48 * i49) + (i49 * i50), i26 + (i50 / 2) + i50, bitmap);
                        } else {
                            int i51 = gridImageData2.gap;
                            int i52 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 1) * i52) + (i51 * i11), i19, (i51 * i11) + (i52 * i11), i19 + i52, bitmap);
                        }
                    } else if (size == 8) {
                        if (i11 == 0) {
                            int i53 = gridImageData2.targetImageSize;
                            int i54 = gridImageData2.gap;
                            drawBitmapAtPosition(canvas, i18 - i53, i54, i18, i54 + i53, bitmap);
                        } else if (i11 == 1) {
                            int i55 = gridImageData2.gap;
                            int i56 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, i17, i55, i17 + i56, i55 + i56, bitmap);
                        } else if (i11 <= 1 || i11 >= 5) {
                            int i57 = gridImageData2.gap;
                            int i58 = i11 - 4;
                            int i59 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 5) * i59) + (i57 * i58), i26 + (i59 / 2), (i57 * i58) + (i58 * i59), i26 + (i59 / 2) + i59, bitmap);
                        } else {
                            int i60 = gridImageData2.gap;
                            int i61 = i11 - 1;
                            int i62 = gridImageData2.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 2) * i62) + (i60 * i61), i19, (i60 * i61) + (i61 * i62), i19 + i62, bitmap);
                        }
                    } else if (size == 9) {
                        drawBitmapAtPosition(canvas, i29, i30, i31, i32, bitmap);
                    }
                }
            }
            i21 = i11 + 1;
            char c12 = c11;
            i14 = i26;
            i15 = i28;
        }
    }

    private void init() {
        this.mGridImageData = new GridImageData();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImage$0(String str, Bitmap bitmap) {
        if (TextUtils.equals(getImageId(), str)) {
            ImageLoader.loadImage(this.mContext, this.mImageView, (Object) bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void loadImage(Bitmap bitmap, String str) {
        ThreadUtils.runOnUIThread(new a(this, str, bitmap));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|14|17|18|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        r0.printStackTrace();
        r4.deleteOnExit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC, Splitter:B:25:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void storeBitmap(java.io.File r4, android.graphics.Bitmap r5) {
        /*
            r3 = this;
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r4.isDirectory()
            if (r0 == 0) goto L_0x0013
        L_0x000c:
            java.io.File r0 = r4.getParentFile()
            r0.mkdirs()
        L_0x0013:
            r0 = 0
            r4.deleteOnExit()     // Catch:{ IOException -> 0x0034 }
            r4.createNewFile()     // Catch:{ IOException -> 0x0034 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0034 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r2 = 100
            r5.compress(r0, r2, r1)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r1.flush()     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0044
        L_0x002d:
            r5 = move-exception
            r0 = r1
            goto L_0x0045
        L_0x0030:
            r0 = r1
            goto L_0x0034
        L_0x0032:
            r5 = move-exception
            goto L_0x0045
        L_0x0034:
            r4.deleteOnExit()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0044
        L_0x003d:
            r5 = move-exception
            r5.printStackTrace()
            r4.deleteOnExit()
        L_0x0044:
            return
        L_0x0045:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
            r4.deleteOnExit()
        L_0x0052:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallkit.view.common.gridimage.GridImageSynthesizer.storeBitmap(java.io.File, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public Bitmap synthesizeImageList(GridImageData gridImageData) {
        Bitmap createBitmap = Bitmap.createBitmap(gridImageData.maxWidth, gridImageData.maxHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawDrawable(canvas, gridImageData);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public void clearImage() {
        ImageLoader.clear(this.mContext, this.mImageView);
    }

    public int getDefaultImage() {
        return this.mGridImageData.getDefaultImageResId();
    }

    public String getImageId() {
        return this.mCurrentImageId;
    }

    public void load(final String str) {
        final GridImageData gridImageData;
        if (this.mGridImageData.size() == 0) {
            if (str == null || TextUtils.equals(str, this.mCurrentImageId)) {
                ImageLoader.loadImage(this.mContext, this.mImageView, Integer.valueOf(getDefaultImage()));
            }
        } else if (this.mGridImageData.size() != 1) {
            clearImage();
            try {
                gridImageData = this.mGridImageData.clone();
            } catch (CloneNotSupportedException e11) {
                e11.printStackTrace();
                ArrayList arrayList = new ArrayList();
                List<Object> list = this.mGridImageData.imageUrlList;
                if (list != null) {
                    arrayList.addAll(list);
                }
                gridImageData = new GridImageData(arrayList, this.mGridImageData.defaultImageResId);
            }
            int[] calculateGridParam = calculateGridParam(this.mGridImageData.size());
            gridImageData.rowCount = calculateGridParam[0];
            int i11 = calculateGridParam[1];
            gridImageData.columnCount = i11;
            int i12 = gridImageData.maxWidth - ((i11 + 1) * gridImageData.gap);
            if (i11 == 1) {
                i11 = 2;
            }
            gridImageData.targetImageSize = i12 / i11;
            ThreadUtils.execute(new Runnable() {
                public void run() {
                    Bitmap bitmap;
                    File file = new File(TUIConfig.getImageBaseDir() + str);
                    boolean z11 = false;
                    if (!file.exists() || !file.isFile()) {
                        bitmap = null;
                    } else {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        bitmap = BitmapFactory.decodeFile(file.getPath(), options);
                        if (options.outWidth > 0 && options.outHeight > 0) {
                            z11 = true;
                        }
                    }
                    if (!z11) {
                        boolean unused = GridImageSynthesizer.this.asyncLoadImageList(gridImageData);
                        bitmap = GridImageSynthesizer.this.synthesizeImageList(gridImageData);
                        GridImageSynthesizer.this.storeBitmap(file, bitmap);
                    }
                    GridImageSynthesizer.this.loadImage(bitmap, str);
                }
            });
        } else if (str == null || TextUtils.equals(str, this.mCurrentImageId)) {
            ImageLoader.loadImage(this.mContext, this.mImageView, this.mGridImageData.getImageUrlList().get(0));
        }
    }

    public void setBgColor(int i11) {
        this.mGridImageData.bgColor = i11;
    }

    public void setDefaultImage(int i11) {
        this.mGridImageData.setDefaultImageResId(i11);
    }

    public void setGap(int i11) {
        this.mGridImageData.gap = i11;
    }

    public void setImageId(String str) {
        this.mCurrentImageId = str;
    }

    public void setImageUrls(List<Object> list) {
        this.mGridImageData.setImageUrlList(list);
    }

    public void setMaxSize(int i11, int i12) {
        GridImageData gridImageData = this.mGridImageData;
        gridImageData.maxWidth = i11;
        gridImageData.maxHeight = i12;
    }
}
