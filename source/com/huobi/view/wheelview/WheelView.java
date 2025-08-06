package com.huobi.view.wheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.huobi.R$styleable;
import com.huobi.view.wheelview.adapter.WheelAdapter;
import com.huobi.view.wheelview.interfaces.IPickerViewData;
import com.huobi.view.wheelview.listener.LoopViewGestureListener;
import com.huobi.view.wheelview.listener.OnItemSelectedListener;
import com.huobi.view.wheelview.timer.InertiaTimerTask;
import com.huobi.view.wheelview.timer.MessageHandler;
import com.huobi.view.wheelview.timer.SmoothScrollTimerTask;
import hu.a;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView extends View {
    private static final float DEFAULT_TEXT_TARGET_SKEWX = 0.5f;
    private static final float SCALE_CONTENT = 0.8f;
    private static final int VELOCITY_FLING = 5;
    private float CENTER_CONTENT_OFFSET;
    private WheelAdapter adapter;
    private float centerY;
    private int change;
    private Context context;
    private int dividerColor;
    private DividerType dividerType;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private Handler handler;
    private int initPosition;
    private boolean isCenterLabel;
    private boolean isLoop;
    private boolean isOptions;
    private float itemHeight;
    private int itemsVisible;
    private String label;
    private float lineSpacingMultiplier;
    private ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private OnItemSelectedListener onItemSelectedListener;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedItem;
    private long startTime;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private int textXOffset;
    private float totalScrollY;
    private Typeface typeface;
    private int widthMeasureSpec;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context2) {
        this(context2, (AttributeSet) null);
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (!(obj instanceof Integer)) {
            return obj.toString();
        }
        return String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(((Integer) obj).intValue())});
    }

    private int getLoopMappingIndex(int i11) {
        if (i11 < 0) {
            return getLoopMappingIndex(i11 + this.adapter.getItemsCount());
        }
        return i11 > this.adapter.getItemsCount() + -1 ? getLoopMappingIndex(i11 - this.adapter.getItemsCount()) : i11;
    }

    private void initLoopView(Context context2) {
        this.context = context2;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector2 = new GestureDetector(context2, new LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector2;
        gestureDetector2.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize((float) this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize((float) this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    private void judgeLineSpace() {
        float f11 = this.lineSpacingMultiplier;
        if (f11 < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (f11 > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$0() {
        this.onItemSelectedListener.onItemSelected(getCurrentItem());
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i11 = 0; i11 < this.adapter.getItemsCount(); i11++) {
            String contentText = getContentText(this.adapter.getItem(i11));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
            this.paintCenterText.getTextBounds("星期", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
        }
        this.itemHeight = this.lineSpacingMultiplier * ((float) this.maxTextHeight);
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.mGravity;
        if (i11 == 3) {
            this.drawCenterContentStart = 0;
        } else if (i11 == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
        } else if (i11 == 17) {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
            } else {
                this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
            }
        }
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.mGravity;
        if (i11 == 3) {
            this.drawOutContentStart = 0;
        } else if (i11 == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
        } else if (i11 == 17) {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
            } else {
                this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
            }
        }
    }

    private void reMeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i11--;
            this.paintCenterText.setTextSize((float) i11);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize((float) i11);
    }

    private void remeasure() {
        if (this.adapter != null) {
            measureTextWidthHeight();
            int i11 = (int) (this.itemHeight * ((float) (this.itemsVisible - 1)));
            this.measuredHeight = (int) (((double) (i11 * 2)) / 3.141592653589793d);
            this.radius = (int) (((double) i11) / 3.141592653589793d);
            this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
            int i12 = this.measuredHeight;
            float f11 = this.itemHeight;
            this.firstLineY = (((float) i12) - f11) / 2.0f;
            float f12 = (((float) i12) + f11) / 2.0f;
            this.secondLineY = f12;
            this.centerY = (f12 - ((f11 - ((float) this.maxTextHeight)) / 2.0f)) - this.CENTER_CONTENT_OFFSET;
            if (this.initPosition == -1) {
                if (this.isLoop) {
                    this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
                } else {
                    this.initPosition = 0;
                }
            }
            this.preCurrentIndex = this.initPosition;
        }
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.mFuture.cancel(true);
            this.mFuture = null;
        }
    }

    public final WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        return this.selectedItem;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11 += (int) Math.ceil((double) fArr[i12]);
        }
        return i11;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public void isCenterLabel(boolean z11) {
        this.isCenterLabel = z11;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public void onDraw(Canvas canvas) {
        boolean z11;
        boolean z12;
        String str;
        float f11;
        float f12;
        Canvas canvas2 = canvas;
        if (this.adapter != null) {
            boolean z13 = false;
            int min = Math.min(Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
            this.initPosition = min;
            Object[] objArr = new Object[this.itemsVisible];
            int i11 = (int) (this.totalScrollY / this.itemHeight);
            this.change = i11;
            try {
                this.preCurrentIndex = min + (i11 % this.adapter.getItemsCount());
            } catch (ArithmeticException unused) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.isLoop) {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = 0;
                }
                if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                    this.preCurrentIndex = this.adapter.getItemsCount() - 1;
                }
            } else {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
                }
                if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                    this.preCurrentIndex -= this.adapter.getItemsCount();
                }
            }
            float f13 = this.totalScrollY % this.itemHeight;
            int i12 = 0;
            while (true) {
                int i13 = this.itemsVisible;
                if (i12 >= i13) {
                    break;
                }
                int i14 = this.preCurrentIndex - ((i13 / 2) - i12);
                if (this.isLoop) {
                    objArr[i12] = this.adapter.getItem(getLoopMappingIndex(i14));
                } else if (i14 < 0) {
                    objArr[i12] = "";
                } else if (i14 > this.adapter.getItemsCount() - 1) {
                    objArr[i12] = "";
                } else {
                    objArr[i12] = this.adapter.getItem(i14);
                }
                i12++;
            }
            boolean z14 = false;
            if (this.dividerType == DividerType.WRAP) {
                if (TextUtils.isEmpty(this.label)) {
                    f12 = (float) (this.measuredWidth - this.maxTextWidth);
                    f11 = 2.0f;
                } else {
                    f12 = (float) (this.measuredWidth - this.maxTextWidth);
                    f11 = 4.0f;
                }
                float f14 = (f12 / f11) - 12.0f;
                if (f14 <= 0.0f) {
                    f14 = 10.0f;
                }
                float f15 = f14;
                float f16 = ((float) this.measuredWidth) - f15;
                float f17 = this.firstLineY;
                Canvas canvas3 = canvas;
                float f18 = f15;
                float f19 = f16;
                canvas3.drawLine(f18, f17, f19, f17, this.paintIndicator);
                float f21 = this.secondLineY;
                canvas3.drawLine(f18, f21, f19, f21, this.paintIndicator);
            } else {
                float f22 = this.firstLineY;
                canvas.drawLine(0.0f, f22, (float) this.measuredWidth, f22, this.paintIndicator);
                float f23 = this.secondLineY;
                canvas.drawLine(0.0f, f23, (float) this.measuredWidth, f23, this.paintIndicator);
            }
            if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
                canvas2.drawText(this.label, ((float) (this.measuredWidth - getTextWidth(this.paintCenterText, this.label))) - this.CENTER_CONTENT_OFFSET, this.centerY, this.paintCenterText);
            }
            int i15 = 0;
            while (i15 < this.itemsVisible) {
                canvas.save();
                double d11 = (double) (((this.itemHeight * ((float) i15)) - f13) / ((float) this.radius));
                float f24 = (float) (90.0d - ((d11 / 3.141592653589793d) * 180.0d));
                if (f24 >= 90.0f || f24 <= -90.0f) {
                    z12 = z14;
                    z11 = z13;
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow((double) (Math.abs(f24) / 90.0f), 2.2d);
                    if (this.isCenterLabel || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(getContentText(objArr[i15]))) {
                        str = getContentText(objArr[i15]);
                    } else {
                        str = getContentText(objArr[i15]) + this.label;
                    }
                    reMeasureTextSize(str);
                    measuredCenterContentStart(str);
                    measuredOutContentStart(str);
                    float cos = (float) ((((double) this.radius) - (Math.cos(d11) * ((double) this.radius))) - ((Math.sin(d11) * ((double) this.maxTextHeight)) / 2.0d));
                    canvas2.translate(0.0f, cos);
                    float f25 = this.firstLineY;
                    if (cos > f25 || ((float) this.maxTextHeight) + cos < f25) {
                        float f26 = this.secondLineY;
                        if (cos > f26 || ((float) this.maxTextHeight) + cos < f26) {
                            if (cos >= f25) {
                                int i16 = this.maxTextHeight;
                                if (((float) i16) + cos <= f26) {
                                    canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) i16) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                                    this.selectedItem = this.adapter.indexOf(objArr[i15]);
                                }
                            }
                            canvas.save();
                            z11 = false;
                            canvas2.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                            canvas2.scale(1.0f, ((float) Math.sin(d11)) * 0.8f);
                            Paint paint = this.paintOuterText;
                            int i17 = this.textXOffset;
                            int i18 = -1;
                            int i19 = i17 == 0 ? 0 : i17 > 0 ? 1 : -1;
                            z12 = false;
                            if (f24 <= 0.0f) {
                                i18 = 1;
                            }
                            paint.setTextSkewX(((float) (i19 * i18)) * 0.5f * pow);
                            this.paintOuterText.setAlpha((int) ((1.0f - pow) * 255.0f));
                            canvas2.drawText(str, ((float) this.drawOutContentStart) + (((float) this.textXOffset) * pow), (float) this.maxTextHeight, this.paintOuterText);
                            canvas.restore();
                            canvas.restore();
                            this.paintCenterText.setTextSize((float) this.textSize);
                        } else {
                            canvas.save();
                            canvas2.clipRect(0.0f, 0.0f, (float) this.measuredWidth, this.secondLineY - cos);
                            canvas2.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                            canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) this.maxTextHeight) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                            canvas.restore();
                            canvas.save();
                            canvas2.clipRect(0.0f, this.secondLineY - cos, (float) this.measuredWidth, (float) ((int) this.itemHeight));
                            canvas2.scale(1.0f, ((float) Math.sin(d11)) * 0.8f);
                            canvas2.drawText(str, (float) this.drawOutContentStart, (float) this.maxTextHeight, this.paintOuterText);
                            canvas.restore();
                        }
                    } else {
                        canvas.save();
                        canvas2.clipRect(0.0f, 0.0f, (float) this.measuredWidth, this.firstLineY - cos);
                        canvas2.scale(1.0f, ((float) Math.sin(d11)) * 0.8f);
                        canvas2.drawText(str, (float) this.drawOutContentStart, (float) this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.save();
                        canvas2.clipRect(0.0f, this.firstLineY - cos, (float) this.measuredWidth, (float) ((int) this.itemHeight));
                        canvas2.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                        canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) this.maxTextHeight) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                        canvas.restore();
                    }
                    z12 = false;
                    z11 = false;
                    canvas.restore();
                    this.paintCenterText.setTextSize((float) this.textSize);
                }
                i15++;
                z13 = z11;
                z14 = z12;
            }
        }
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new a(this), 200);
        }
    }

    public void onMeasure(int i11, int i12) {
        this.widthMeasureSpec = i11;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            this.totalScrollY += rawY;
            if (!this.isLoop) {
                float f11 = ((float) (-this.initPosition)) * this.itemHeight;
                float f12 = this.itemHeight;
                float itemsCount = ((float) ((this.adapter.getItemsCount() - 1) - this.initPosition)) * f12;
                float f13 = this.totalScrollY;
                if ((f12 * 0.5f) + f13 < f11) {
                    f11 = f13 - rawY;
                } else if (f13 - (f12 * 0.5f) > itemsCount) {
                    itemsCount = f13 - rawY;
                }
                if (f13 < f11) {
                    this.totalScrollY = (float) ((int) f11);
                } else if (f13 > itemsCount) {
                    this.totalScrollY = (float) ((int) itemsCount);
                }
            }
        } else if (!onTouchEvent) {
            float y11 = motionEvent.getY();
            int i11 = this.radius;
            float f14 = this.itemHeight;
            this.mOffset = (int) (((((double) ((int) (((Math.acos((double) ((((float) i11) - y11) / ((float) i11))) * ((double) this.radius)) + ((double) (f14 / 2.0f))) / ((double) f14)))) - (((double) this.itemsVisible) / 2.0d)) * ((double) f14)) - ((double) (((this.totalScrollY % f14) + f14) % f14)));
            if (System.currentTimeMillis() - this.startTime > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void scrollBy(float f11) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f11), 0, 5, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        remeasure();
        invalidate();
    }

    public final void setCurrentItem(int i11) {
        this.selectedItem = i11;
        this.initPosition = i11;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z11) {
        this.isLoop = z11;
    }

    public void setDividerColor(int i11) {
        if (i11 != 0) {
            this.dividerColor = i11;
            this.paintIndicator.setColor(i11);
        }
    }

    public void setDividerType(DividerType dividerType2) {
        this.dividerType = dividerType2;
    }

    public void setGravity(int i11) {
        this.mGravity = i11;
    }

    public void setInitPosition(int i11) {
        this.initPosition = i11;
    }

    public void setIsOptions(boolean z11) {
        this.isOptions = z11;
    }

    public void setItemHeight(float f11) {
        this.itemHeight = f11;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLineSpacingMultiplier(float f11) {
        if (f11 != 0.0f) {
            this.lineSpacingMultiplier = f11;
            judgeLineSpace();
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener2) {
        this.onItemSelectedListener = onItemSelectedListener2;
    }

    public void setTextColorCenter(int i11) {
        if (i11 != 0) {
            this.textColorCenter = i11;
            this.paintCenterText.setColor(i11);
        }
    }

    public void setTextColorOut(int i11) {
        if (i11 != 0) {
            this.textColorOut = i11;
            this.paintOuterText.setColor(i11);
        }
    }

    public final void setTextSize(float f11) {
        if (f11 > 0.0f) {
            int i11 = (int) f11;
            this.textSize = i11;
            this.paintOuterText.setTextSize((float) i11);
            this.paintCenterText.setTextSize((float) this.textSize);
        }
    }

    public void setTextXOffset(int i11) {
        this.textXOffset = i11;
        if (i11 != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f11) {
        this.totalScrollY = f11;
    }

    public final void setTypeface(Typeface typeface2) {
        if (typeface2 != null) {
            this.typeface = typeface2;
            this.paintOuterText.setTypeface(typeface2);
            this.paintCenterText.setTypeface(this.typeface);
        }
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f11 = this.totalScrollY;
            float f12 = this.itemHeight;
            int i11 = (int) (((f11 % f12) + f12) % f12);
            this.mOffset = i11;
            if (((float) i11) > f12 / 2.0f) {
                this.mOffset = (int) (f12 - ((float) i11));
            } else {
                this.mOffset = -i11;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0, 10, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textSize = 20;
        float f11 = getResources().getDisplayMetrics().density;
        if (f11 < 1.0f) {
            this.CENTER_CONTENT_OFFSET = 2.4f;
        } else if (1.0f <= f11 && f11 < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 3.6f;
        } else if (2.0f <= f11 && f11 < 3.0f) {
            this.CENTER_CONTENT_OFFSET = 6.0f;
        } else if (f11 >= 3.0f) {
            this.CENTER_CONTENT_OFFSET = f11 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.WheelView, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(1, 17);
            this.textColorOut = obtainStyledAttributes.getColor(4, -5723992);
            this.textColorCenter = obtainStyledAttributes.getColor(3, -14013910);
            this.dividerColor = obtainStyledAttributes.getColor(0, 0);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(5, this.textSize);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(2, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context2);
    }
}
