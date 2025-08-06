package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.TIMCommonConfig;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TeamHeadSynthesizer implements Synthesizer {
    public Callback callback = new Callback() {
        public void onCall(Bitmap bitmap, String str) {
            if (TextUtils.equals(TeamHeadSynthesizer.this.getImageId(), str)) {
                GlideEngine.loadUserIcon(TeamHeadSynthesizer.this.imageView, bitmap);
            }
        }
    };
    private String currentImageId = "";
    public ImageView imageView;
    public Context mContext;
    public MultiImageData multiImageData;

    public interface Callback {
        void onCall(Bitmap bitmap, String str);
    }

    public TeamHeadSynthesizer(Context context, ImageView imageView2) {
        this.mContext = context;
        this.imageView = imageView2;
        init();
    }

    private Bitmap asyncLoadImage(Object obj, int i11) throws ExecutionException, InterruptedException {
        return GlideEngine.loadBitmap(obj, i11);
    }

    private void init() {
        this.multiImageData = new MultiImageData();
    }

    public boolean asyncLoadImageList(MultiImageData multiImageData2) {
        List<Object> imageUrls = multiImageData2.getImageUrls();
        for (int i11 = 0; i11 < imageUrls.size(); i11++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), TIMCommonConfig.getDefaultAvatarImage());
            try {
                multiImageData2.putBitmap(asyncLoadImage(imageUrls.get(i11), multiImageData2.targetImageSize), i11);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                multiImageData2.putBitmap(decodeResource, i11);
            } catch (ExecutionException e12) {
                e12.printStackTrace();
                multiImageData2.putBitmap(decodeResource, i11);
            }
        }
        return true;
    }

    public int[] calculateGridParam(int i11) {
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

    public void clearImage() {
        GlideEngine.clear(this.imageView);
    }

    public void drawBitmapAtPosition(Canvas canvas, int i11, int i12, int i13, int i14, Bitmap bitmap) {
        if (bitmap == null && this.multiImageData.getDefaultImageResId() > 0) {
            bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), this.multiImageData.getDefaultImageResId());
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i11, i12, i13, i14), (Paint) null);
        }
    }

    public void drawDrawable(Canvas canvas, MultiImageData multiImageData2) {
        char c11;
        int i11;
        MultiImageData multiImageData3 = multiImageData2;
        canvas.drawColor(multiImageData3.bgColor);
        int size = multiImageData2.size();
        int i12 = multiImageData3.maxHeight;
        int i13 = multiImageData3.gap;
        int i14 = (i12 + i13) / 2;
        int i15 = (i12 - i13) / 2;
        int i16 = multiImageData3.maxWidth;
        int i17 = (i16 + i13) / 2;
        int i18 = (i16 - i13) / 2;
        int i19 = (i12 - multiImageData3.targetImageSize) / 2;
        int i21 = 0;
        while (i21 < size) {
            int i22 = multiImageData3.columnCount;
            int i23 = i21 / i22;
            int i24 = i21 % i22;
            int i25 = multiImageData3.targetImageSize;
            int i26 = i14;
            double d11 = ((double) i25) * (i22 == 1 ? ((double) i24) + 0.5d : (double) i24);
            int i27 = multiImageData3.gap;
            int i28 = i15;
            int i29 = (int) (d11 + ((double) ((i24 + 1) * i27)));
            int i30 = (int) ((((double) i25) * (i22 == 1 ? ((double) i23) + 0.5d : (double) i23)) + ((double) (i27 * (i23 + 1))));
            int i31 = i29 + i25;
            int i32 = i30 + i25;
            Bitmap bitmap = multiImageData3.getBitmap(i21);
            if (size == 1) {
                i11 = i21;
                drawBitmapAtPosition(canvas, i29, i30, i31, i32, bitmap);
                c11 = 2;
            } else {
                i11 = i21;
                if (size == 2) {
                    c11 = 2;
                    drawBitmapAtPosition(canvas, i29, i19, i31, i19 + multiImageData3.targetImageSize, bitmap);
                } else {
                    c11 = 2;
                    if (size == 3) {
                        if (i11 == 0) {
                            drawBitmapAtPosition(canvas, i19, i30, i19 + multiImageData3.targetImageSize, i32, bitmap);
                        } else {
                            int i33 = multiImageData3.gap;
                            int i34 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 1) * i34) + (i33 * i11), i26, (i33 * i11) + (i34 * i11), i26 + i34, bitmap);
                        }
                    } else if (size == 4) {
                        drawBitmapAtPosition(canvas, i29, i30, i31, i32, bitmap);
                    } else if (size == 5) {
                        if (i11 == 0) {
                            int i35 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, i18 - i35, i18 - i35, i18, i18, bitmap);
                        } else if (i11 == 1) {
                            int i36 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, i17, i18 - i36, i17 + i36, i18, bitmap);
                        } else {
                            int i37 = multiImageData3.gap;
                            int i38 = i11 - 1;
                            int i39 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 2) * i39) + (i37 * i38), i26, (i37 * i38) + (i38 * i39), i26 + i39, bitmap);
                        }
                    } else if (size == 6) {
                        if (i11 < 3) {
                            int i40 = multiImageData3.gap;
                            int i41 = i11 + 1;
                            int i42 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, (i42 * i11) + (i40 * i41), i28 - i42, (i40 * i41) + (i42 * i41), i28, bitmap);
                        } else {
                            int i43 = multiImageData3.gap;
                            int i44 = i11 - 2;
                            int i45 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 3) * i45) + (i43 * i44), i26, (i43 * i44) + (i44 * i45), i26 + i45, bitmap);
                        }
                    } else if (size == 7) {
                        if (i11 == 0) {
                            int i46 = multiImageData3.gap;
                            int i47 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, i19, i46, i19 + i47, i46 + i47, bitmap);
                        } else if (i11 <= 0 || i11 >= 4) {
                            int i48 = multiImageData3.gap;
                            int i49 = i11 - 3;
                            int i50 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 4) * i50) + (i48 * i49), i26 + (i50 / 2), (i48 * i49) + (i49 * i50), i26 + (i50 / 2) + i50, bitmap);
                        } else {
                            int i51 = multiImageData3.gap;
                            int i52 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 1) * i52) + (i51 * i11), i19, (i51 * i11) + (i52 * i11), i19 + i52, bitmap);
                        }
                    } else if (size == 8) {
                        if (i11 == 0) {
                            int i53 = multiImageData3.targetImageSize;
                            int i54 = multiImageData3.gap;
                            drawBitmapAtPosition(canvas, i18 - i53, i54, i18, i54 + i53, bitmap);
                        } else if (i11 == 1) {
                            int i55 = multiImageData3.gap;
                            int i56 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, i17, i55, i17 + i56, i55 + i56, bitmap);
                        } else if (i11 <= 1 || i11 >= 5) {
                            int i57 = multiImageData3.gap;
                            int i58 = i11 - 4;
                            int i59 = multiImageData3.targetImageSize;
                            drawBitmapAtPosition(canvas, ((i11 - 5) * i59) + (i57 * i58), i26 + (i59 / 2), (i57 * i58) + (i58 * i59), i26 + (i59 / 2) + i59, bitmap);
                        } else {
                            int i60 = multiImageData3.gap;
                            int i61 = i11 - 1;
                            int i62 = multiImageData3.targetImageSize;
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

    public int getDefaultImage() {
        return this.multiImageData.getDefaultImageResId();
    }

    public String getImageId() {
        return this.currentImageId;
    }

    public MultiImageData getMultiImageData() {
        return this.multiImageData;
    }

    public void load(final String str) {
        final MultiImageData multiImageData2;
        if (this.multiImageData.size() == 0) {
            if (str == null || TextUtils.equals(str, this.currentImageId)) {
                GlideEngine.loadUserIcon(this.imageView, Integer.valueOf(getDefaultImage()));
            }
        } else if (this.multiImageData.size() != 1) {
            clearImage();
            try {
                multiImageData2 = this.multiImageData.clone();
            } catch (CloneNotSupportedException e11) {
                e11.printStackTrace();
                ArrayList arrayList = new ArrayList();
                List<Object> list = this.multiImageData.imageUrls;
                if (list != null) {
                    arrayList.addAll(list);
                }
                multiImageData2 = new MultiImageData(arrayList, this.multiImageData.defaultImageResId);
            }
            int[] calculateGridParam = calculateGridParam(this.multiImageData.size());
            multiImageData2.rowCount = calculateGridParam[0];
            int i11 = calculateGridParam[1];
            multiImageData2.columnCount = i11;
            int i12 = multiImageData2.maxWidth - ((i11 + 1) * multiImageData2.gap);
            if (i11 == 1) {
                i11 = 2;
            }
            multiImageData2.targetImageSize = i12 / i11;
            ThreadUtils.execute(new Runnable() {
                public void run() {
                    final Bitmap bitmap;
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
                        TeamHeadSynthesizer.this.asyncLoadImageList(multiImageData2);
                        final Bitmap synthesizeImageList = TeamHeadSynthesizer.this.synthesizeImageList(multiImageData2);
                        ImageUtil.storeBitmap(file, synthesizeImageList);
                        ImageUtil.setGroupConversationAvatar(str, file.getAbsolutePath());
                        ThreadUtils.postOnUiThread(new Runnable() {
                            public void run() {
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                TeamHeadSynthesizer.this.callback.onCall(synthesizeImageList, str);
                            }
                        });
                        return;
                    }
                    ThreadUtils.postOnUiThread(new Runnable() {
                        public void run() {
                            AnonymousClass2 r02 = AnonymousClass2.this;
                            TeamHeadSynthesizer.this.callback.onCall(bitmap, str);
                        }
                    });
                }
            });
        } else if (str == null || TextUtils.equals(str, this.currentImageId)) {
            GlideEngine.loadUserIcon(this.imageView, this.multiImageData.getImageUrls().get(0));
        }
    }

    public void setBgColor(int i11) {
        this.multiImageData.bgColor = i11;
    }

    public void setDefaultImage(int i11) {
        this.multiImageData.setDefaultImageResId(i11);
    }

    public void setGap(int i11) {
        this.multiImageData.gap = i11;
    }

    public void setImageId(String str) {
        this.currentImageId = str;
    }

    public void setMaxWidthHeight(int i11, int i12) {
        MultiImageData multiImageData2 = this.multiImageData;
        multiImageData2.maxWidth = i11;
        multiImageData2.maxHeight = i12;
    }

    public Bitmap synthesizeImageList(MultiImageData multiImageData2) {
        Bitmap createBitmap = Bitmap.createBitmap(multiImageData2.maxWidth, multiImageData2.maxHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawDrawable(canvas, multiImageData2);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
