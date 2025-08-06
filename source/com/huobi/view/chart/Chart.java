package com.huobi.view.chart;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.huobi.view.chart.animation.ChartAnimator;
import com.huobi.view.chart.animation.Easing;
import com.huobi.view.chart.components.Description;
import com.huobi.view.chart.components.IMarker;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.components.XAxis;
import com.huobi.view.chart.data.ChartData;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.formatter.DefaultValueFormatter;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.highlight.ChartHighlighter;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.highlight.IHighlighter;
import com.huobi.view.chart.interfaces.dataprovider.ChartInterface;
import com.huobi.view.chart.interfaces.datasets.IDataSet;
import com.huobi.view.chart.listener.ChartTouchListener;
import com.huobi.view.chart.listener.OnChartGestureListener;
import com.huobi.view.chart.listener.OnChartValueSelectedListener;
import com.huobi.view.chart.renderer.DataRenderer;
import com.huobi.view.chart.renderer.LegendRenderer;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    public ChartAnimator mAnimator;
    public ChartTouchListener mChartTouchListener;
    public T mData = null;
    public DefaultValueFormatter mDefaultValueFormatter = new DefaultValueFormatter(0);
    public Paint mDescPaint;
    public Description mDescription;
    private boolean mDragDecelerationEnabled = true;
    private float mDragDecelerationFrictionCoef = 0.9f;
    public boolean mDrawMarkers = true;
    private float mExtraBottomOffset = 0.0f;
    private float mExtraLeftOffset = 0.0f;
    private float mExtraRightOffset = 0.0f;
    private float mExtraTopOffset = 0.0f;
    private OnChartGestureListener mGestureListener;
    public boolean mHighLightPerTapEnabled = true;
    public IHighlighter mHighlighter;
    public Highlight[] mIndicesToHighlight;
    public Paint mInfoPaint;
    public ArrayList<Runnable> mJobs = new ArrayList<>();
    public Legend mLegend;
    public LegendRenderer mLegendRenderer;
    public boolean mLogEnabled = false;
    public IMarker mMarker;
    public float mMaxHighlightDistance = 0.0f;
    private String mNoDataText = "No chart data available.";
    private boolean mOffsetsCalculated = false;
    public DataRenderer mRenderer;
    public OnChartValueSelectedListener mSelectionListener;
    public boolean mTouchEnabled = true;
    private boolean mUnbind = false;
    public ViewPortHandler mViewPortHandler = new ViewPortHandler();
    public XAxis mXAxis;

    /* renamed from: com.huobi.view.chart.Chart$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.graphics.Bitmap$CompressFormat[] r0 = android.graphics.Bitmap.CompressFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$graphics$Bitmap$CompressFormat = r0
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$CompressFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$CompressFormat     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.Chart.AnonymousClass2.<clinit>():void");
        }
    }

    public Chart(Context context) {
        super(context);
        init();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    unbindDrawables(viewGroup.getChildAt(i11));
                    i11++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.hasChartDimens()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    public void animateX(int i11, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateX(i11, easingFunction);
    }

    public void animateXY(int i11, int i12, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        this.mAnimator.animateXY(i11, i12, easingFunction, easingFunction2);
    }

    public void animateY(int i11, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateY(i11, easingFunction);
    }

    public abstract void calcMinMax();

    public abstract void calculateOffsets();

    public void clear() {
        this.mData = null;
        this.mOffsetsCalculated = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.setLastHighlighted((Highlight) null);
        invalidate();
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void drawDescription(Canvas canvas) {
        float f11;
        float f12;
        Description description = this.mDescription;
        if (description != null && description.isEnabled()) {
            MPPointF position = this.mDescription.getPosition();
            this.mDescPaint.setTypeface(this.mDescription.getTypeface());
            this.mDescPaint.setTextSize(this.mDescription.getTextSize());
            this.mDescPaint.setColor(this.mDescription.getTextColor());
            this.mDescPaint.setTextAlign(this.mDescription.getTextAlign());
            if (position == null) {
                f12 = (((float) getWidth()) - this.mViewPortHandler.offsetRight()) - this.mDescription.getXOffset();
                f11 = (((float) getHeight()) - this.mViewPortHandler.offsetBottom()) - this.mDescription.getYOffset();
            } else {
                float f13 = position.f19016x;
                f11 = position.f19017y;
                f12 = f13;
            }
            canvas.drawText(this.mDescription.getText(), f12, f11, this.mDescPaint);
        }
    }

    public void drawMarkers(Canvas canvas) {
        if (this.mMarker != null && isDrawMarkersEnabled() && valuesToHighlight()) {
            int i11 = 0;
            while (true) {
                Highlight[] highlightArr = this.mIndicesToHighlight;
                if (i11 < highlightArr.length) {
                    Highlight highlight = highlightArr[i11];
                    IDataSet dataSetByIndex = this.mData.getDataSetByIndex(highlight.getDataSetIndex());
                    Entry entryForHighlight = this.mData.getEntryForHighlight(this.mIndicesToHighlight[i11]);
                    int entryIndex = dataSetByIndex.getEntryIndex(entryForHighlight);
                    if (entryForHighlight != null && ((float) entryIndex) <= ((float) dataSetByIndex.getEntryCount()) * this.mAnimator.getPhaseX()) {
                        float[] markerPosition = getMarkerPosition(highlight);
                        if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                            this.mMarker.refreshContent(entryForHighlight, highlight);
                            this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                        }
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public MPPointF getCenter() {
        return MPPointF.getInstance(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public MPPointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public T getData() {
        return this.mData;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public Highlight getHighlightByTouchPoint(float f11, float f12) {
        if (this.mData != null) {
            return getHighlighter().getHighlight(f11, f12);
        }
        Log.e(LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    public float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.getDrawX(), highlight.getDrawY()};
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    public Paint getPaint(int i11) {
        if (i11 == 7) {
            return this.mInfoPaint;
        }
        if (i11 != 11) {
            return null;
        }
        return this.mDescPaint;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public float getXChartMax() {
        return this.mXAxis.mAxisMaximum;
    }

    public float getXChartMin() {
        return this.mXAxis.mAxisMinimum;
    }

    public float getXRange() {
        return this.mXAxis.mAxisRange;
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    public void highlightValue(float f11, int i11) {
        highlightValue(f11, i11, true);
    }

    public void highlightValues(Highlight[] highlightArr) {
        this.mIndicesToHighlight = highlightArr;
        setLastHighlighted(highlightArr);
        invalidate();
    }

    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.init(getContext());
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        this.mDescription = new Description();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mInfoPaint = paint;
        paint.setColor(Color.rgb(TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, PsExtractor.PRIVATE_STREAM_1, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        if (this.mLogEnabled) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public boolean isEmpty() {
        T t11 = this.mData;
        if (t11 != null && t11.getEntryCount() > 0) {
            return false;
        }
        return true;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public abstract void notifyDataSetChanged();

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind) {
            unbindDrawables(this);
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if (!TextUtils.isEmpty(this.mNoDataText)) {
                MPPointF center = getCenter();
                canvas.drawText(this.mNoDataText, center.f19016x, center.f19017y, this.mInfoPaint);
            }
        } else if (!this.mOffsetsCalculated) {
            calculateOffsets();
            this.mOffsetsCalculated = true;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            getChildAt(i15).layout(i11, i12, i13, i14);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int convertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(convertDpToPixel, i11)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(convertDpToPixel, i12)));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "OnSizeChanged()");
        }
        if (i11 > 0 && i12 > 0 && i11 < 10000 && i12 < 10000) {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Setting chart dimens, width: " + i11 + ", height: " + i12);
            }
            this.mViewPortHandler.setChartDimens((float) i11, (float) i12);
        } else if (this.mLogEnabled) {
            Log.w(LOG_TAG, "*Avoiding* setting chart dimens! width: " + i11 + ", height: " + i12);
        }
        notifyDataSetChanged();
        Iterator<Runnable> it2 = this.mJobs.iterator();
        while (it2.hasNext()) {
            post(it2.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i11) {
        if (i11 < 0 || i11 > 100) {
            i11 = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i12 = AnonymousClass2.$SwitchMap$android$graphics$Bitmap$CompressFormat[compressFormat.ordinal()];
        String str4 = PictureMimeType.PNG_Q;
        if (i12 != 1) {
            if (i12 != 2) {
                if (!str.endsWith(PictureMimeType.JPG) && !str.endsWith(".jpeg")) {
                    str = str + PictureMimeType.JPG;
                }
                str4 = "image/jpeg";
            } else {
                if (!str.endsWith(".webp")) {
                    str = str + ".webp";
                }
                str4 = "image/webp";
            }
        } else if (!str.endsWith(PictureMimeType.PNG)) {
            str = str + PictureMimeType.PNG;
        }
        String str5 = file.getAbsolutePath() + "/" + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i11, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("mime_type", str4);
            contentValues.put("description", str3);
            contentValues.put("orientation", 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            if (getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null) {
                return true;
            }
            return false;
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + "/" + str + PictureMimeType.PNG);
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public void setData(T t11) {
        this.mData = t11;
        this.mOffsetsCalculated = false;
        if (t11 != null) {
            setupDefaultFormatter(t11.getYMin(), t11.getYMax());
            for (IDataSet iDataSet : this.mData.getDataSets()) {
                if (iDataSet.needsFormatter() || iDataSet.getValueFormatter() == this.mDefaultValueFormatter) {
                    iDataSet.setValueFormatter(this.mDefaultValueFormatter);
                }
            }
            notifyDataSetChanged();
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Data is set.");
            }
        }
    }

    public void setDescription(Description description) {
        this.mDescription = description;
    }

    public void setDragDecelerationEnabled(boolean z11) {
        this.mDragDecelerationEnabled = z11;
    }

    public void setDragDecelerationFrictionCoef(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 >= 1.0f) {
            f11 = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f11;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z11) {
        setDrawMarkers(z11);
    }

    public void setDrawMarkers(boolean z11) {
        this.mDrawMarkers = z11;
    }

    public void setExtraBottomOffset(float f11) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(f11);
    }

    public void setExtraLeftOffset(float f11) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(f11);
    }

    public void setExtraOffsets(float f11, float f12, float f13, float f14) {
        setExtraLeftOffset(f11);
        setExtraTopOffset(f12);
        setExtraRightOffset(f13);
        setExtraBottomOffset(f14);
    }

    public void setExtraRightOffset(float f11) {
        this.mExtraRightOffset = Utils.convertDpToPixel(f11);
    }

    public void setExtraTopOffset(float f11) {
        this.mExtraTopOffset = Utils.convertDpToPixel(f11);
    }

    public void setHardwareAccelerationEnabled(boolean z11) {
        if (z11) {
            setLayerType(2, (Paint) null);
        } else {
            setLayerType(1, (Paint) null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z11) {
        this.mHighLightPerTapEnabled = z11;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    public void setLastHighlighted(Highlight[] highlightArr) {
        if (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) {
            this.mChartTouchListener.setLastHighlighted((Highlight) null);
        } else {
            this.mChartTouchListener.setLastHighlighted(highlightArr[0]);
        }
    }

    public void setLogEnabled(boolean z11) {
        this.mLogEnabled = z11;
    }

    public void setMarker(IMarker iMarker) {
        this.mMarker = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f11) {
        this.mMaxHighlightDistance = Utils.convertDpToPixel(f11);
    }

    public void setNoDataText(String str) {
        this.mNoDataText = str;
    }

    public void setNoDataTextColor(int i11) {
        this.mInfoPaint.setColor(i11);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.mGestureListener = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setPaint(Paint paint, int i11) {
        if (i11 == 7) {
            this.mInfoPaint = paint;
        } else if (i11 == 11) {
            this.mDescPaint = paint;
        }
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z11) {
        this.mTouchEnabled = z11;
    }

    public void setUnbindEnabled(boolean z11) {
        this.mUnbind = z11;
    }

    public void setupDefaultFormatter(float f11, float f12) {
        float f13;
        T t11 = this.mData;
        if (t11 == null || t11.getEntryCount() < 2) {
            f13 = Math.max(Math.abs(f11), Math.abs(f12));
        } else {
            f13 = Math.abs(f12 - f11);
        }
        this.mDefaultValueFormatter.setup(Utils.getDecimals(f13));
    }

    public boolean valuesToHighlight() {
        Highlight[] highlightArr = this.mIndicesToHighlight;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    public void animateX(int i11) {
        this.mAnimator.animateX(i11);
    }

    public void animateXY(int i11, int i12, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateXY(i11, i12, easingFunction);
    }

    public void animateY(int i11) {
        this.mAnimator.animateY(i11);
    }

    public void highlightValue(float f11, float f12, int i11) {
        highlightValue(f11, f12, i11, true);
    }

    public void animateXY(int i11, int i12) {
        this.mAnimator.animateXY(i11, i12);
    }

    public void highlightValue(float f11, int i11, boolean z11) {
        highlightValue(f11, Float.NaN, i11, z11);
    }

    public void highlightValue(float f11, float f12, int i11, boolean z11) {
        if (i11 < 0 || i11 >= this.mData.getDataSetCount()) {
            highlightValue((Highlight) null, z11);
        } else {
            highlightValue(new Highlight(f11, f12, i11), z11);
        }
    }

    public void highlightValue(Highlight highlight) {
        highlightValue(highlight, false);
    }

    public void highlightValue(Highlight highlight, boolean z11) {
        Entry entry = null;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Highlighted: " + highlight.toString());
            }
            Entry entryForHighlight = this.mData.getEntryForHighlight(highlight);
            if (entryForHighlight == null) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = entryForHighlight;
        }
        setLastHighlighted(this.mIndicesToHighlight);
        if (z11 && this.mSelectionListener != null) {
            if (!valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entry, highlight);
            }
        }
        invalidate();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public boolean saveToGallery(String str, int i11) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i11);
    }

    public boolean saveToGallery(String str) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public Chart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
