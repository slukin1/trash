package com.tencent.qcloud.tuikit.timcommon.classicui.widget.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonLog;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectTextHelper {
    private static int DEFAULT_SELECTION_LENGTH = 2;
    /* access modifiers changed from: private */
    public static int DEFAULT_SHOW_DURATION = 100;
    private static int STATUS_HEIGHT = 0;
    private static final String TAG = "SelectTextHelper";
    /* access modifiers changed from: private */
    public boolean isHide = true;
    /* access modifiers changed from: private */
    public boolean isHideWhenScroll;
    private List<Builder.onSeparateItemClickListener> itemListenerList = new LinkedList();
    private List<Pair<Integer, String>> itemTextList;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mCursorHandleColor;
    /* access modifiers changed from: private */
    public int mCursorHandleSize;
    /* access modifiers changed from: private */
    public CursorHandle mEndHandle;
    private boolean mIsEmoji = false;
    /* access modifiers changed from: private */
    public Magnifier mMagnifier;
    /* access modifiers changed from: private */
    public boolean mMagnifierShow;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private int mPopArrowImg;
    private int mPopBgResource;
    private int mPopSpanCount;
    /* access modifiers changed from: private */
    public View.OnTouchListener mRootTouchListener;
    /* access modifiers changed from: private */
    public boolean mScrollShow;
    /* access modifiers changed from: private */
    public boolean mSelectAll;
    /* access modifiers changed from: private */
    public OnSelectListener mSelectListener;
    private boolean mSelectedAllNoPop;
    private int mSelectedColor;
    /* access modifiers changed from: private */
    public SelectionInfo mSelectionInfo = new SelectionInfo();
    private final Runnable mShowSelectViewRunnable = new Runnable() {
        public void run() {
            if (!SelectTextHelper.this.isHide) {
                if (SelectTextHelper.this.mStartHandle != null) {
                    SelectTextHelper selectTextHelper = SelectTextHelper.this;
                    selectTextHelper.showCursorHandle(selectTextHelper.mStartHandle);
                }
                if (SelectTextHelper.this.mEndHandle != null) {
                    SelectTextHelper selectTextHelper2 = SelectTextHelper.this;
                    selectTextHelper2.showCursorHandle(selectTextHelper2.mEndHandle);
                }
            }
        }
    };
    private BackgroundColorSpan mSpan;
    private Spannable mSpannable;
    /* access modifiers changed from: private */
    public CursorHandle mStartHandle;
    /* access modifiers changed from: private */
    public TextView mTextView;
    /* access modifiers changed from: private */
    public int mTextViewMarginStart = 0;
    /* access modifiers changed from: private */
    public int mTouchX;
    /* access modifiers changed from: private */
    public int mTouchY;
    /* access modifiers changed from: private */
    public boolean usedClickListener = false;

    public class CursorHandle extends View {
        /* access modifiers changed from: private */
        public boolean isLeft;
        private int mAdjustX;
        private int mAdjustY;
        private int mBeforeDragEnd;
        private int mBeforeDragStart;
        private int mCircleRadius;
        private int mHeight;
        private int mPadding = 32;
        private Paint mPaint;
        private PopupWindow mPopupWindow;
        private int[] mTempCoors = new int[2];
        private int mWidth;

        public CursorHandle(boolean z11) {
            super(SelectTextHelper.this.mContext);
            this.mCircleRadius = SelectTextHelper.this.mCursorHandleSize / 2;
            this.mWidth = SelectTextHelper.this.mCursorHandleSize;
            this.mHeight = SelectTextHelper.this.mCursorHandleSize;
            this.isLeft = z11;
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setColor(SelectTextHelper.this.mCursorHandleColor);
            PopupWindow popupWindow = new PopupWindow(this);
            this.mPopupWindow = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.mPadding * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.mPadding / 2));
            invalidate();
        }

        private void changeDirection() {
            this.isLeft = !this.isLeft;
            invalidate();
        }

        private void updateCursorHandle() {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            Layout layout = SelectTextHelper.this.mTextView.getLayout();
            if (this.isLeft) {
                this.mPopupWindow.update((((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mStart)) - this.mWidth) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mStart)) + getExtraY(), -1, -1);
            } else {
                this.mPopupWindow.update(((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraY(), -1, -1);
            }
        }

        public void dismiss() {
            this.mPopupWindow.dismiss();
        }

        public int getExtraX() {
            return (this.mTempCoors[0] - this.mPadding) + SelectTextHelper.this.mTextView.getPaddingLeft();
        }

        public int getExtraY() {
            return this.mTempCoors[1] + SelectTextHelper.this.mTextView.getPaddingTop();
        }

        public void onDraw(Canvas canvas) {
            int i11 = this.mCircleRadius;
            canvas.drawCircle((float) (this.mPadding + i11), (float) i11, (float) i11, this.mPaint);
            if (this.isLeft) {
                int i12 = this.mCircleRadius;
                int i13 = this.mPadding;
                canvas.drawRect((float) (i12 + i13), 0.0f, (float) ((i12 * 2) + i13), (float) i12, this.mPaint);
                return;
            }
            int i14 = this.mPadding;
            int i15 = this.mCircleRadius;
            canvas.drawRect((float) i14, 0.0f, (float) (i14 + i15), (float) i15, this.mPaint);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            if (r0 != 3) goto L_0x00e6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                int r0 = r8.getAction()
                r1 = 1
                if (r0 == 0) goto L_0x00c4
                r2 = 28
                if (r0 == r1) goto L_0x00a6
                r3 = 2
                if (r0 == r3) goto L_0x0013
                r8 = 3
                if (r0 == r8) goto L_0x00a6
                goto L_0x00e6
            L_0x0013:
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper$OnSelectListener r0 = r0.mSelectListener
                if (r0 == 0) goto L_0x0024
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper$OnSelectListener r0 = r0.mSelectListener
                r0.onDismissCustomPop()
            L_0x0024:
                float r0 = r8.getRawX()
                int r0 = (int) r0
                float r8 = r8.getRawY()
                int r8 = (int) r8
                int r4 = r7.mAdjustX
                int r4 = r4 + r0
                int r5 = r7.mWidth
                int r4 = r4 - r5
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r5 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                int r5 = r5.mTextViewMarginStart
                int r4 = r4 - r5
                int r5 = r7.mAdjustY
                int r5 = r5 + r8
                int r6 = r7.mHeight
                int r5 = r5 - r6
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r6 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.TextView r6 = r6.mTextView
                float r6 = r6.getTextSize()
                int r6 = (int) r6
                int r5 = r5 - r6
                r7.update(r4, r5)
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r4 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                boolean r4 = r4.mMagnifierShow
                if (r4 == 0) goto L_0x00e6
                int r4 = android.os.Build.VERSION.SDK_INT
                if (r4 < r2) goto L_0x00e6
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r2 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r2 = r2.mMagnifier
                if (r2 != 0) goto L_0x007d
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r2 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r4 = new android.widget.Magnifier
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r5 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.TextView r5 = r5.mTextView
                r4.<init>(r5)
                android.widget.Magnifier unused = r2.mMagnifier = r4
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r2 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r2 = r2.mMagnifier
                r2.getWidth()
            L_0x007d:
                int[] r2 = new int[r3]
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r3 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.TextView r3 = r3.mTextView
                r3.getLocationOnScreen(r2)
                r3 = 0
                r4 = r2[r3]
                int r0 = r0 - r4
                r2 = r2[r1]
                int r8 = r8 - r2
                r2 = 1107296256(0x42000000, float:32.0)
                int r2 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.dp2px(r2)
                int r8 = r8 - r2
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r2 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r2 = r2.mMagnifier
                float r0 = (float) r0
                int r8 = java.lang.Math.max(r8, r3)
                float r8 = (float) r8
                r2.show(r0, r8)
                goto L_0x00e6
            L_0x00a6:
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r8 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                boolean r8 = r8.mMagnifierShow
                if (r8 == 0) goto L_0x00e6
                int r8 = android.os.Build.VERSION.SDK_INT
                if (r8 < r2) goto L_0x00e6
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r8 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r8 = r8.mMagnifier
                if (r8 == 0) goto L_0x00e6
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r8 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                android.widget.Magnifier r8 = r8.mMagnifier
                r8.dismiss()
                goto L_0x00e6
            L_0x00c4:
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper$SelectionInfo r0 = r0.mSelectionInfo
                int r0 = r0.mStart
                r7.mBeforeDragStart = r0
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper r0 = com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.this
                com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper$SelectionInfo r0 = r0.mSelectionInfo
                int r0 = r0.mEnd
                r7.mBeforeDragEnd = r0
                float r0 = r8.getX()
                int r0 = (int) r0
                r7.mAdjustX = r0
                float r8 = r8.getY()
                int r8 = (int) r8
                r7.mAdjustY = r8
            L_0x00e6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper.CursorHandle.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void show(int i11, int i12) {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            this.mPopupWindow.showAtLocation(SelectTextHelper.this.mTextView, 0, (i11 - (this.isLeft ? this.mWidth : 0)) + getExtraX(), i12 + getExtraY());
        }

        public void update(int i11, int i12) {
            int i13;
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            if (this.isLeft) {
                i13 = SelectTextHelper.this.mSelectionInfo.mStart;
            } else {
                i13 = SelectTextHelper.this.mSelectionInfo.mEnd;
            }
            int hysteresisOffset = SelectTextHelper.getHysteresisOffset(SelectTextHelper.this.mTextView, i11, i12 - this.mTempCoors[1], i13);
            if (hysteresisOffset != i13) {
                SelectTextHelper.this.resetSelectionInfo();
                if (this.isLeft) {
                    if (hysteresisOffset > this.mBeforeDragEnd) {
                        CursorHandle access$4300 = SelectTextHelper.this.getCursorHandle(false);
                        changeDirection();
                        access$4300.changeDirection();
                        int i14 = this.mBeforeDragEnd;
                        this.mBeforeDragStart = i14;
                        SelectTextHelper.this.selectText(i14, hysteresisOffset);
                        access$4300.updateCursorHandle();
                    } else {
                        SelectTextHelper.this.selectText(hysteresisOffset, -1);
                    }
                    updateCursorHandle();
                    return;
                }
                int i15 = this.mBeforeDragStart;
                if (hysteresisOffset < i15) {
                    CursorHandle access$43002 = SelectTextHelper.this.getCursorHandle(true);
                    access$43002.changeDirection();
                    changeDirection();
                    int i16 = this.mBeforeDragStart;
                    this.mBeforeDragEnd = i16;
                    SelectTextHelper.this.selectText(hysteresisOffset, i16);
                    access$43002.updateCursorHandle();
                } else {
                    SelectTextHelper.this.selectText(i15, hysteresisOffset);
                }
                updateCursorHandle();
            }
        }
    }

    public class LinkMovementMethodInterceptor extends LinkMovementMethod {
        private long downLinkTime;

        private LinkMovementMethodInterceptor() {
        }

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x11 + textView.getScrollX();
                int scrollY = y11 + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 1) {
                        if (this.downLinkTime + ((long) ViewConfiguration.getLongPressTimeout()) < System.currentTimeMillis()) {
                            return false;
                        }
                        if (clickableSpanArr[0] instanceof URLSpan) {
                            URLSpan uRLSpan = (URLSpan) clickableSpanArr[0];
                            if (!TextUtils.isEmpty(uRLSpan.getURL())) {
                                if (SelectTextHelper.this.mSelectListener != null) {
                                    boolean unused = SelectTextHelper.this.usedClickListener = true;
                                    SelectTextHelper.this.mSelectListener.onClickUrl(uRLSpan.getURL());
                                }
                                return true;
                            }
                            clickableSpanArr[0].onClick(textView);
                        }
                    } else if (action == 0) {
                        this.downLinkTime = System.currentTimeMillis();
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public interface OnSelectListener {
        void onClick(View view);

        void onClickUrl(String str);

        void onDismiss();

        void onDismissCustomPop();

        void onLongClick(View view);

        void onReset();

        void onScrolling();

        void onSelectAllShowCustomPop();

        void onTextSelected(CharSequence charSequence);
    }

    public class SelectionInfo {
        public int mEnd;
        public String mSelectionContent;
        public int mStart;

        private SelectionInfo() {
        }
    }

    public SelectTextHelper(Builder builder) {
        TextView access$100 = builder.mTextView;
        this.mTextView = access$100;
        this.mContext = access$100.getContext();
        this.mSelectedColor = builder.mSelectedColor;
        this.mCursorHandleColor = builder.mCursorHandleColor;
        this.mSelectAll = builder.mSelectAll;
        this.mIsEmoji = builder.mIsEmoji;
        this.mScrollShow = builder.mScrollShow;
        this.mMagnifierShow = builder.mMagnifierShow;
        this.mPopSpanCount = builder.mPopSpanCount;
        this.mPopBgResource = builder.mPopBgResource;
        this.mPopArrowImg = builder.mPopArrowImg;
        this.mSelectedAllNoPop = builder.mSelectedAllNoPop;
        this.itemTextList = builder.itemTextList;
        this.itemListenerList = builder.itemListenerList;
        this.mCursorHandleSize = dp2px(builder.mCursorHandleSizeInDp);
        init();
    }

    public static int dp2px(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: private */
    public CursorHandle getCursorHandle(boolean z11) {
        if (this.mStartHandle.isLeft == z11) {
            return this.mStartHandle;
        }
        return this.mEndHandle;
    }

    public static int getDisplayHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getHysteresisOffset(TextView textView, int i11, int i12, int i13) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return -1;
        }
        int lineForVertical = layout.getLineForVertical(i12);
        if (isEndOfLineOffset(layout, i13)) {
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if (i11 > lineRight - ((lineRight - ((int) layout.getPrimaryHorizontal(i13 - 1))) / 2)) {
                i13--;
            }
        }
        int lineForOffset = layout.getLineForOffset(i13);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineBottom = layout.getLineBottom(lineForOffset);
        int i14 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && i12 - lineBottom < i14) || (lineForVertical == lineForOffset - 1 && lineTop - i12 < i14)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i11);
        if (offsetForHorizontal >= textView.getText().length() - 1) {
            return offsetForHorizontal;
        }
        int i15 = offsetForHorizontal + 1;
        if (!isEndOfLineOffset(layout, i15)) {
            return offsetForHorizontal;
        }
        int lineRight2 = (int) layout.getLineRight(lineForVertical);
        return i11 > lineRight2 - ((lineRight2 - ((int) layout.getPrimaryHorizontal(offsetForHorizontal))) / 2) ? i15 : offsetForHorizontal;
    }

    public static int getPreciseOffset(TextView textView, int i11, int i12) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return -1;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i12), (float) i11);
        return ((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > i11 ? layout.getOffsetToLeftOf(offsetForHorizontal) : offsetForHorizontal;
    }

    public static int getStatusHeight() {
        int i11 = STATUS_HEIGHT;
        if (i11 != 0) {
            return i11;
        }
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return -1;
        }
        int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(identifier);
        STATUS_HEIGHT = dimensionPixelSize;
        return dimensionPixelSize;
    }

    private void handlerEmojiSelectText() {
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(this.mSelectionInfo.mSelectionContent);
        while (matcher.find()) {
            Bitmap emoji = FaceManager.getEmoji(matcher.group());
            if (emoji != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(emoji);
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.getPaint().setColor(this.mTextView.getContext().getResources().getColor(R.color.text_select_color));
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, bitmapDrawable});
                layerDrawable.setBounds(0, 0, 64, 64);
                ImageSpan imageSpan = new ImageSpan(layerDrawable, 1);
                Spannable spannable = this.mSpannable;
                SelectionInfo selectionInfo = this.mSelectionInfo;
                spannable.setSpan(imageSpan, selectionInfo.mStart, selectionInfo.mEnd, 17);
            }
        }
    }

    private void hideSelectView() {
        this.isHide = true;
        this.usedClickListener = false;
        if (this.mStartHandle != null) {
            TIMCommonLog.d(TAG, "mStartHandle.dismiss();");
            this.mStartHandle.dismiss();
        }
        if (this.mEndHandle != null) {
            TIMCommonLog.d(TAG, "mEndHandle.dismiss();");
            this.mEndHandle.dismiss();
        }
    }

    private void init() {
        TextView textView = this.mTextView;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        this.mTextView.setOnTouchListener(new b(this));
        this.mTextView.setOnClickListener(new a(this));
        this.mTextView.setOnLongClickListener(new View.OnLongClickListener() {
            private void onLongTextViewClick() {
                SelectTextHelper.this.mTextView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    public void onViewAttachedToWindow(View view) {
                    }

                    public void onViewDetachedFromWindow(View view) {
                        SelectTextHelper.this.destroy();
                    }
                });
                ViewTreeObserver.OnPreDrawListener unused = SelectTextHelper.this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        if (SelectTextHelper.this.isHideWhenScroll) {
                            boolean unused = SelectTextHelper.this.isHideWhenScroll = false;
                            SelectTextHelper.this.postShowSelectView(SelectTextHelper.DEFAULT_SHOW_DURATION);
                        }
                        if (SelectTextHelper.this.mTextViewMarginStart != 0) {
                            return true;
                        }
                        int[] iArr = new int[2];
                        SelectTextHelper.this.mTextView.getLocationInWindow(iArr);
                        int unused2 = SelectTextHelper.this.mTextViewMarginStart = iArr[0];
                        return true;
                    }
                };
                SelectTextHelper.this.mTextView.getViewTreeObserver().addOnPreDrawListener(SelectTextHelper.this.mOnPreDrawListener);
                View.OnTouchListener unused2 = SelectTextHelper.this.mRootTouchListener = new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        SelectTextHelper.this.reset();
                        SelectTextHelper.this.mTextView.getRootView().setOnTouchListener((View.OnTouchListener) null);
                        return false;
                    }
                };
                SelectTextHelper.this.mTextView.getRootView().setOnTouchListener(SelectTextHelper.this.mRootTouchListener);
                ViewTreeObserver.OnScrollChangedListener unused3 = SelectTextHelper.this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
                    public void onScrollChanged() {
                        if (SelectTextHelper.this.mScrollShow) {
                            if (!SelectTextHelper.this.isHideWhenScroll && !SelectTextHelper.this.isHide) {
                                boolean unused = SelectTextHelper.this.isHideWhenScroll = true;
                                if (SelectTextHelper.this.mStartHandle != null) {
                                    SelectTextHelper.this.mStartHandle.dismiss();
                                }
                                if (SelectTextHelper.this.mEndHandle != null) {
                                    SelectTextHelper.this.mEndHandle.dismiss();
                                }
                            }
                            if (SelectTextHelper.this.mSelectListener != null) {
                                SelectTextHelper.this.mSelectListener.onScrolling();
                                return;
                            }
                            return;
                        }
                        SelectTextHelper.this.reset();
                    }
                };
                SelectTextHelper.this.mTextView.getViewTreeObserver().addOnScrollChangedListener(SelectTextHelper.this.mOnScrollChangedListener);
                if (SelectTextHelper.this.mSelectAll) {
                    SelectTextHelper.this.showAllView();
                } else {
                    SelectTextHelper selectTextHelper = SelectTextHelper.this;
                    selectTextHelper.showSelectView(selectTextHelper.mTouchX, SelectTextHelper.this.mTouchY);
                }
                if (SelectTextHelper.this.mSelectListener != null) {
                    SelectTextHelper.this.mSelectListener.onLongClick(SelectTextHelper.this.mTextView);
                }
            }

            public boolean onLongClick(View view) {
                onLongTextViewClick();
                return true;
            }
        });
        this.mTextView.setMovementMethod(new LinkMovementMethodInterceptor());
    }

    private static boolean isEndOfLineOffset(Layout layout, int i11) {
        return i11 > 0 && layout.getLineForOffset(i11) == layout.getLineForOffset(i11 - 1) + 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$0(View view, MotionEvent motionEvent) {
        this.mTouchX = (int) motionEvent.getX();
        this.mTouchY = (int) motionEvent.getY();
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$init$1(View view) {
        if (this.usedClickListener) {
            this.usedClickListener = false;
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onDismiss();
        }
        reset();
        OnSelectListener onSelectListener2 = this.mSelectListener;
        if (onSelectListener2 != null) {
            onSelectListener2.onClick(this.mTextView);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void postShowSelectView(int i11) {
        this.mTextView.removeCallbacks(this.mShowSelectViewRunnable);
        if (i11 <= 0) {
            this.mShowSelectViewRunnable.run();
        } else {
            this.mTextView.postDelayed(this.mShowSelectViewRunnable, (long) i11);
        }
    }

    /* access modifiers changed from: private */
    public void resetSelectionInfo() {
        this.mSelectionInfo.mSelectionContent = null;
        if (this.mSpannable != null && this.mSpan != null) {
            TIMCommonLog.d(TAG, "mSpannable.removeSpan(mSpan);");
            this.mSpannable.removeSpan(this.mSpan);
            this.mSpan = null;
        }
    }

    /* access modifiers changed from: private */
    public void selectText(int i11, int i12) {
        if (i11 != -1) {
            this.mSelectionInfo.mStart = i11;
        }
        if (i12 != -1) {
            this.mSelectionInfo.mEnd = i12;
        }
        SelectionInfo selectionInfo = this.mSelectionInfo;
        int i13 = selectionInfo.mStart;
        int i14 = selectionInfo.mEnd;
        if (i13 > i14) {
            selectionInfo.mStart = i14;
            selectionInfo.mEnd = i13;
        }
        if (this.mSpannable != null) {
            if (this.mSpan == null) {
                this.mSpan = new BackgroundColorSpan(this.mSelectedColor);
            }
            SelectionInfo selectionInfo2 = this.mSelectionInfo;
            selectionInfo2.mSelectionContent = this.mSpannable.subSequence(selectionInfo2.mStart, selectionInfo2.mEnd).toString();
            Spannable spannable = this.mSpannable;
            BackgroundColorSpan backgroundColorSpan = this.mSpan;
            SelectionInfo selectionInfo3 = this.mSelectionInfo;
            spannable.setSpan(backgroundColorSpan, selectionInfo3.mStart, selectionInfo3.mEnd, 17);
            OnSelectListener onSelectListener = this.mSelectListener;
            if (onSelectListener != null) {
                onSelectListener.onTextSelected(this.mSelectionInfo.mSelectionContent);
            }
        }
    }

    public static void setWidthHeight(View view, int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i12;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void showAllView() {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable != null) {
            selectText(0, this.mTextView.getText().length());
            showCursorHandle(this.mStartHandle);
            showCursorHandle(this.mEndHandle);
        }
    }

    /* access modifiers changed from: private */
    public void showCursorHandle(CursorHandle cursorHandle) {
        Layout layout = this.mTextView.getLayout();
        if (layout != null) {
            int i11 = cursorHandle.isLeft ? this.mSelectionInfo.mStart : this.mSelectionInfo.mEnd;
            cursorHandle.show((int) layout.getPrimaryHorizontal(i11), layout.getLineBottom(layout.getLineForOffset(i11)));
        }
    }

    /* access modifiers changed from: private */
    public void showSelectView(int i11, int i12) {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        int preciseOffset = getPreciseOffset(this.mTextView, i11, i12);
        int i13 = DEFAULT_SELECTION_LENGTH + preciseOffset;
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable != null && i13 - 1 < this.mTextView.getText().length()) {
            selectText(preciseOffset, i13);
            showCursorHandle(this.mStartHandle);
            showCursorHandle(this.mEndHandle);
        }
    }

    public void destroy() {
        this.mTextView.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mTextView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.mTextView.getRootView().setOnTouchListener((View.OnTouchListener) null);
        reset();
        this.mStartHandle = null;
        this.mEndHandle = null;
    }

    public void reset() {
        TIMCommonLog.d(TAG, "reset");
        hideSelectView();
        resetSelectionInfo();
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onReset();
        }
    }

    public void selectAll() {
        showAllView();
    }

    public void setSelectListener(OnSelectListener onSelectListener) {
        this.mSelectListener = onSelectListener;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public List<onSeparateItemClickListener> itemListenerList = new LinkedList();
        /* access modifiers changed from: private */
        public List<Pair<Integer, String>> itemTextList = new LinkedList();
        /* access modifiers changed from: private */
        public int mCursorHandleColor = -15500842;
        /* access modifiers changed from: private */
        public float mCursorHandleSizeInDp = 24.0f;
        /* access modifiers changed from: private */
        public boolean mIsEmoji = false;
        /* access modifiers changed from: private */
        public boolean mMagnifierShow = true;
        /* access modifiers changed from: private */
        public int mPopArrowImg = 0;
        /* access modifiers changed from: private */
        public int mPopBgResource = 0;
        /* access modifiers changed from: private */
        public int mPopSpanCount = 5;
        /* access modifiers changed from: private */
        public boolean mScrollShow = true;
        /* access modifiers changed from: private */
        public boolean mSelectAll = true;
        /* access modifiers changed from: private */
        public boolean mSelectedAllNoPop = false;
        /* access modifiers changed from: private */
        public int mSelectedColor = -5250572;
        /* access modifiers changed from: private */
        public TextView mTextView;

        public interface onSeparateItemClickListener {
            void onClick();
        }

        public Builder(TextView textView) {
            this.mTextView = textView;
        }

        public Builder addItem(int i11, int i12, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair(Integer.valueOf(i11), this.mTextView.getContext().getResources().getString(i12)));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }

        public SelectTextHelper build() {
            return new SelectTextHelper(this);
        }

        public Builder setCursorHandleColor(int i11) {
            this.mCursorHandleColor = i11;
            return this;
        }

        public Builder setCursorHandleSizeInDp(float f11) {
            this.mCursorHandleSizeInDp = f11;
            return this;
        }

        public Builder setIsEmoji(boolean z11) {
            this.mIsEmoji = z11;
            return this;
        }

        public Builder setMagnifierShow(boolean z11) {
            this.mMagnifierShow = z11;
            return this;
        }

        public Builder setPopSpanCount(int i11) {
            this.mPopSpanCount = i11;
            return this;
        }

        public Builder setPopStyle(int i11, int i12) {
            this.mPopBgResource = i11;
            this.mPopArrowImg = i12;
            return this;
        }

        public Builder setScrollShow(boolean z11) {
            this.mScrollShow = z11;
            return this;
        }

        public Builder setSelectAll(boolean z11) {
            this.mSelectAll = z11;
            return this;
        }

        public Builder setSelectedAllNoPop(boolean z11) {
            this.mSelectedAllNoPop = z11;
            return this;
        }

        public Builder setSelectedColor(int i11) {
            this.mSelectedColor = i11;
            return this;
        }

        public Builder addItem(int i11, String str, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair(Integer.valueOf(i11), str));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }
    }
}
