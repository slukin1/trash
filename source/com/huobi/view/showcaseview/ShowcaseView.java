package com.huobi.view.showcaseview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.huobi.R$styleable;
import com.huobi.view.showcaseview.AnimationFactory;
import com.huobi.view.showcaseview.targets.Target;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import pro.huobi.R;

public class ShowcaseView extends RelativeLayout implements View.OnTouchListener, ShowcaseViewApi {
    public static final int ABOVE_SHOWCASE = 1;
    public static final int BELOW_SHOWCASE = 3;
    private static final int HOLO_BLUE = Color.parseColor("#33B5E5");
    public static final int LEFT_OF_SHOWCASE = 0;
    public static final int RIGHT_OF_SHOWCASE = 2;
    public static final int UNDEFINED = -1;
    /* access modifiers changed from: private */
    public final AnimationFactory animationFactory;
    private int backgroundColor;
    private Bitmap bitmapBuffer;
    private boolean blockAllTouches;
    private boolean blockTouches;
    private long fadeInMillis;
    private long fadeOutMillis;
    private boolean hasAlteredText;
    private boolean hasCustomClickListener;
    /* access modifiers changed from: private */
    public boolean hasNoTarget;
    private View.OnClickListener hideOnClickListener;
    private boolean hideOnTouch;
    /* access modifiers changed from: private */
    public boolean isShowing;
    private Button mEndButton;
    /* access modifiers changed from: private */
    public OnShowcaseEventListener mEventListener;
    private OnAddCustomViewListener onAddCustomViewListener;
    private final int[] positionInWindow;
    private float scaleMultiplier;
    /* access modifiers changed from: private */
    public final ShotStateStore shotStateStore;
    private boolean shouldCentreText;
    private final ShowcaseAreaCalculator showcaseAreaCalculator;
    private int showcaseColor;
    private ShowcaseDrawer showcaseDrawer;
    private int showcaseX;
    private int showcaseY;
    private final TextDrawer textDrawer;

    public static class Builder {
        private final Activity activity;
        private ViewGroup parent;
        private int parentIndex;
        private final ShowcaseView showcaseView;

        public Builder(Activity activity2) {
            this(activity2, false);
        }

        public Builder addCustomView(View view) {
            this.showcaseView.addView(view);
            return this;
        }

        public Builder blockAllTouches() {
            this.showcaseView.setBlockAllTouches(true);
            return this;
        }

        public ShowcaseView build() {
            ShowcaseView.insertShowcaseView(this.showcaseView, this.parent, this.parentIndex);
            return this.showcaseView;
        }

        public Builder doNotBlockTouches() {
            this.showcaseView.setBlocksTouches(false);
            return this;
        }

        public Builder hideOnTouchOutside() {
            this.showcaseView.setBlocksTouches(true);
            this.showcaseView.setHideOnTouchOutside(true);
            return this;
        }

        public Builder replaceEndButton(Button button) {
            this.showcaseView.setEndButton(button);
            return this;
        }

        public Builder setContentText(int i11) {
            return setContentText((CharSequence) this.activity.getString(i11));
        }

        public Builder setContentTextPaint(TextPaint textPaint) {
            this.showcaseView.setContentTextPaint(textPaint);
            return this;
        }

        public Builder setContentTitle(int i11) {
            return setContentTitle((CharSequence) this.activity.getString(i11));
        }

        public Builder setContentTitlePaint(TextPaint textPaint) {
            this.showcaseView.setContentTitlePaint(textPaint);
            return this;
        }

        public Builder setOnClickListener(View.OnClickListener onClickListener) {
            this.showcaseView.overrideButtonClick(onClickListener);
            return this;
        }

        public Builder setParent(ViewGroup viewGroup, int i11) {
            this.parent = viewGroup;
            this.parentIndex = i11;
            return this;
        }

        public Builder setShowcaseDrawer(ShowcaseDrawer showcaseDrawer) {
            this.showcaseView.setShowcaseDrawer(showcaseDrawer);
            return this;
        }

        public Builder setShowcaseEventListener(OnShowcaseEventListener onShowcaseEventListener) {
            this.showcaseView.setOnShowcaseEventListener(onShowcaseEventListener);
            return this;
        }

        public Builder setStyle(int i11) {
            this.showcaseView.setStyle(i11);
            return this;
        }

        public Builder setTarget(Target target) {
            this.showcaseView.setTarget(target);
            return this;
        }

        public Builder singleShot(long j11) {
            this.showcaseView.setSingleShot(j11);
            return this;
        }

        public Builder useDecorViewAsParent() {
            this.parent = (ViewGroup) this.activity.getWindow().getDecorView();
            this.parentIndex = -1;
            return this;
        }

        public Builder withHoloShowcase() {
            return setShowcaseDrawer(new StandardShowcaseDrawer(this.activity.getResources(), this.activity.getTheme()));
        }

        public Builder withMaterialShowcase() {
            return setShowcaseDrawer(new MaterialShowcaseDrawer(this.activity.getResources()));
        }

        public Builder withNewStyleShowcase() {
            return setShowcaseDrawer(new NewShowcaseDrawer(this.activity.getResources(), this.activity.getTheme()));
        }

        @Deprecated
        public Builder(Activity activity2, boolean z11) {
            this.activity = activity2;
            ShowcaseView showcaseView2 = new ShowcaseView(activity2, z11);
            this.showcaseView = showcaseView2;
            showcaseView2.setId(R.id.showcase_view);
            showcaseView2.setTarget(Target.NONE);
            ViewGroup viewGroup = (ViewGroup) activity2.findViewById(16908290);
            this.parent = viewGroup;
            this.parentIndex = viewGroup.getChildCount();
        }

        public Builder addCustomView(int i11) {
            View.inflate(this.activity, i11, this.showcaseView);
            return this;
        }

        public Builder replaceEndButton(int i11) {
            View inflate = LayoutInflater.from(this.activity).inflate(i11, this.showcaseView, false);
            if (inflate instanceof Button) {
                return replaceEndButton((Button) inflate);
            }
            throw new IllegalArgumentException("Attempted to replace showcase button with a layout which isn't a button");
        }

        public Builder setContentText(CharSequence charSequence) {
            this.showcaseView.setContentText(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.showcaseView.setContentTitle(charSequence);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextPosition {
    }

    public ShowcaseView(Context context, boolean z11) {
        this(context, (AttributeSet) null, 0, z11);
    }

    /* access modifiers changed from: private */
    public boolean canUpdateBitmap() {
        return getMeasuredHeight() > 0 && getMeasuredWidth() > 0;
    }

    /* access modifiers changed from: private */
    public void clearBitmap() {
        Bitmap bitmap = this.bitmapBuffer;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmapBuffer.recycle();
            this.bitmapBuffer = null;
        }
    }

    private void fadeInShowcase() {
        this.animationFactory.fadeInView(this, this.fadeInMillis, new AnimationFactory.AnimationStartListener() {
            public void onAnimationStart() {
                ShowcaseView.this.setVisibility(0);
            }
        });
    }

    private void fadeOutShowcase() {
        this.animationFactory.fadeOutView(this, this.fadeOutMillis, new AnimationFactory.AnimationEndListener() {
            public void onAnimationEnd() {
                ShowcaseView.this.setVisibility(8);
                ShowcaseView.this.clearBitmap();
                boolean unused = ShowcaseView.this.isShowing = false;
                ShowcaseView.this.mEventListener.onShowcaseViewDidHide(ShowcaseView.this);
            }
        });
    }

    private boolean hasShot() {
        return this.shotStateStore.hasShot();
    }

    private boolean haveBoundsChanged() {
        return (getMeasuredWidth() == this.bitmapBuffer.getWidth() && getMeasuredHeight() == this.bitmapBuffer.getHeight()) ? false : true;
    }

    private void hideImmediate() {
        this.isShowing = false;
        setVisibility(8);
    }

    private void init() {
        setOnTouchListener(this);
        if (this.mEndButton.getParent() == null) {
            int dimension = (int) getResources().getDimension(R.dimen.dimen_12);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) generateDefaultLayoutParams();
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            this.mEndButton.setLayoutParams(layoutParams);
            this.mEndButton.setText(17039370);
            if (!this.hasCustomClickListener) {
                this.mEndButton.setOnClickListener(this.hideOnClickListener);
            }
            addView(this.mEndButton);
        }
    }

    /* access modifiers changed from: private */
    public static void insertShowcaseView(ShowcaseView showcaseView, ViewGroup viewGroup, int i11) {
        viewGroup.addView(showcaseView, i11);
        if (!showcaseView.hasShot()) {
            showcaseView.show();
        } else {
            showcaseView.hideImmediate();
        }
    }

    private void recalculateText() {
        if (this.showcaseAreaCalculator.calculateShowcaseRect((float) this.showcaseX, (float) this.showcaseY, this.showcaseDrawer) || this.hasAlteredText) {
            this.textDrawer.calculateTextPosition(getMeasuredWidth(), getMeasuredHeight(), this.shouldCentreText, hasShowcaseView() ? this.showcaseAreaCalculator.getShowcaseRect() : new Rect());
        }
        this.hasAlteredText = false;
    }

    /* access modifiers changed from: private */
    public void setBlockAllTouches(boolean z11) {
        this.blockAllTouches = z11;
    }

    /* access modifiers changed from: private */
    public void setContentTextPaint(TextPaint textPaint) {
        this.textDrawer.setContentPaint(textPaint);
        this.hasAlteredText = true;
        invalidate();
    }

    /* access modifiers changed from: private */
    public void setContentTitlePaint(TextPaint textPaint) {
        this.textDrawer.setTitlePaint(textPaint);
        this.hasAlteredText = true;
        invalidate();
    }

    /* access modifiers changed from: private */
    public void setEndButton(Button button) {
        this.mEndButton.setOnClickListener((View.OnClickListener) null);
        removeView(this.mEndButton);
        this.mEndButton = button;
        button.setOnClickListener(this.hideOnClickListener);
        button.setLayoutParams((RelativeLayout.LayoutParams) this.mEndButton.getLayoutParams());
        addView(button);
    }

    private void setScaleMultiplier(float f11) {
        this.scaleMultiplier = f11;
    }

    /* access modifiers changed from: private */
    public void setShowcaseDrawer(ShowcaseDrawer showcaseDrawer2) {
        this.showcaseDrawer = showcaseDrawer2;
        showcaseDrawer2.setBackgroundColour(this.backgroundColor);
        this.showcaseDrawer.setShowcaseColour(this.showcaseColor);
        this.hasAlteredText = true;
        invalidate();
    }

    /* access modifiers changed from: private */
    public void setSingleShot(long j11) {
        this.shotStateStore.setSingleShot(j11);
    }

    private void tintButton(int i11, boolean z11) {
        if (z11) {
            this.mEndButton.getBackground().setColorFilter(i11, PorterDuff.Mode.MULTIPLY);
        } else {
            this.mEndButton.getBackground().setColorFilter(HOLO_BLUE, PorterDuff.Mode.MULTIPLY);
        }
    }

    /* access modifiers changed from: private */
    public void updateBitmap() {
        if (this.bitmapBuffer == null || haveBoundsChanged()) {
            Bitmap bitmap = this.bitmapBuffer;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.bitmapBuffer = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        }
    }

    private void updateStyle(TypedArray typedArray, boolean z11) {
        this.backgroundColor = typedArray.getColor(0, Color.argb(128, 80, 80, 80));
        this.showcaseColor = typedArray.getColor(6, HOLO_BLUE);
        String string = typedArray.getString(3);
        if (TextUtils.isEmpty(string)) {
            string = getResources().getString(17039370);
        }
        boolean z12 = typedArray.getBoolean(7, true);
        int resourceId = typedArray.getResourceId(8, 2132083271);
        int resourceId2 = typedArray.getResourceId(4, 2132083269);
        typedArray.recycle();
        this.showcaseDrawer.setShowcaseColour(this.showcaseColor);
        this.showcaseDrawer.setBackgroundColour(this.backgroundColor);
        tintButton(this.showcaseColor, z12);
        this.mEndButton.setText(string);
        this.textDrawer.setTitleStyling(resourceId);
        this.textDrawer.setDetailStyling(resourceId2);
        this.hasAlteredText = true;
        if (z11) {
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        if (this.showcaseX < 0 || this.showcaseY < 0 || this.shotStateStore.hasShot() || (bitmap = this.bitmapBuffer) == null) {
            super.dispatchDraw(canvas);
            return;
        }
        this.showcaseDrawer.erase(bitmap);
        if (!this.hasNoTarget) {
            this.showcaseDrawer.drawShowcase(this.bitmapBuffer, (float) this.showcaseX, (float) this.showcaseY, this.scaleMultiplier);
            this.showcaseDrawer.drawToCanvas(canvas, this.bitmapBuffer);
        }
        this.textDrawer.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public void forceTextPosition(int i11) {
        this.textDrawer.forceTextPosition(i11);
        this.hasAlteredText = true;
        invalidate();
    }

    public OnAddCustomViewListener getOnAddCustomViewListener() {
        return this.onAddCustomViewListener;
    }

    public int getShowcaseX() {
        getLocationInWindow(this.positionInWindow);
        return this.showcaseX + this.positionInWindow[0];
    }

    public int getShowcaseY() {
        getLocationInWindow(this.positionInWindow);
        return this.showcaseY + this.positionInWindow[1];
    }

    public boolean hasShowcaseView() {
        return (this.showcaseX == 1000000 || this.showcaseY == 1000000 || this.hasNoTarget) ? false : true;
    }

    public void hide() {
        this.shotStateStore.storeShot();
        this.mEventListener.onShowcaseViewHide(this);
        fadeOutShowcase();
    }

    public void hideButton() {
        this.mEndButton.setVisibility(8);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11 = true;
        if (this.blockAllTouches) {
            this.mEventListener.onShowcaseViewTouchBlocked(motionEvent);
            return true;
        }
        double sqrt = Math.sqrt(Math.pow((double) Math.abs(motionEvent.getRawX() - ((float) this.showcaseX)), 2.0d) + Math.pow((double) Math.abs(motionEvent.getRawY() - ((float) this.showcaseY)), 2.0d));
        if (1 != motionEvent.getAction() || !this.hideOnTouch || sqrt <= ((double) this.showcaseDrawer.getBlockedRadius())) {
            if (!this.blockTouches || sqrt <= ((double) this.showcaseDrawer.getBlockedRadius())) {
                z11 = false;
            }
            if (z11) {
                this.mEventListener.onShowcaseViewTouchBlocked(motionEvent);
            }
            return z11;
        }
        hide();
        return true;
    }

    public void overrideButtonClick(View.OnClickListener onClickListener) {
        if (!this.shotStateStore.hasShot()) {
            Button button = this.mEndButton;
            if (button != null) {
                if (onClickListener != null) {
                    button.setOnClickListener(onClickListener);
                } else {
                    button.setOnClickListener(this.hideOnClickListener);
                }
            }
            this.hasCustomClickListener = true;
        }
    }

    public void setBlocksTouches(boolean z11) {
        this.blockTouches = z11;
    }

    public void setButtonPosition(RelativeLayout.LayoutParams layoutParams) {
        this.mEndButton.setLayoutParams(layoutParams);
    }

    public void setButtonText(CharSequence charSequence) {
        Button button = this.mEndButton;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setContentText(CharSequence charSequence) {
        this.textDrawer.setContentText(charSequence);
        invalidate();
    }

    public void setContentTitle(CharSequence charSequence) {
        this.textDrawer.setContentTitle(charSequence);
        invalidate();
    }

    public void setDetailTextAlignment(Layout.Alignment alignment) {
        this.textDrawer.setDetailTextAlignment(alignment);
        this.hasAlteredText = true;
        invalidate();
    }

    public void setFadeDurations(long j11, long j12) {
        this.fadeInMillis = j11;
        this.fadeOutMillis = j12;
    }

    public void setHideOnTouchOutside(boolean z11) {
        this.hideOnTouch = z11;
    }

    public void setOnAddCustomViewListener(OnAddCustomViewListener onAddCustomViewListener2) {
        this.onAddCustomViewListener = onAddCustomViewListener2;
    }

    public void setOnShowcaseEventListener(OnShowcaseEventListener onShowcaseEventListener) {
        if (onShowcaseEventListener != null) {
            this.mEventListener = onShowcaseEventListener;
        } else {
            this.mEventListener = OnShowcaseEventListener.NONE;
        }
    }

    public void setShouldCentreText(boolean z11) {
        this.shouldCentreText = z11;
        this.hasAlteredText = true;
        invalidate();
    }

    public void setShowcase(final Target target, final boolean z11) {
        postDelayed(new Runnable() {
            public void run() {
                if (!ShowcaseView.this.shotStateStore.hasShot()) {
                    if (ShowcaseView.this.canUpdateBitmap()) {
                        ShowcaseView.this.updateBitmap();
                    }
                    Point point = target.getPoint();
                    if (point != null) {
                        boolean unused = ShowcaseView.this.hasNoTarget = false;
                        if (z11) {
                            ShowcaseView.this.animationFactory.animateTargetToPoint(ShowcaseView.this, point);
                        } else {
                            ShowcaseView.this.setShowcasePosition(point);
                        }
                    } else {
                        boolean unused2 = ShowcaseView.this.hasNoTarget = true;
                        ShowcaseView.this.invalidate();
                    }
                }
            }
        }, 100);
    }

    public void setShowcasePosition(Point point) {
        setShowcasePosition(point.x, point.y);
    }

    public void setShowcaseX(int i11) {
        setShowcasePosition(i11, getShowcaseY());
    }

    public void setShowcaseY(int i11) {
        setShowcasePosition(getShowcaseX(), i11);
    }

    public void setStyle(int i11) {
        updateStyle(getContext().obtainStyledAttributes(i11, R$styleable.ShowcaseView), true);
    }

    public void setTarget(Target target) {
        setShowcase(target, false);
    }

    public void setTitleTextAlignment(Layout.Alignment alignment) {
        this.textDrawer.setTitleTextAlignment(alignment);
        this.hasAlteredText = true;
        invalidate();
    }

    public void show() {
        this.isShowing = true;
        if (canUpdateBitmap()) {
            updateBitmap();
        }
        this.mEventListener.onShowcaseViewShow(this);
        fadeInShowcase();
    }

    public void showButton() {
        this.mEndButton.setVisibility(0);
    }

    public ShowcaseView(Context context, AttributeSet attributeSet, int i11, boolean z11) {
        super(context, attributeSet, i11);
        this.showcaseX = -1;
        this.showcaseY = -1;
        this.scaleMultiplier = 1.0f;
        this.hasCustomClickListener = false;
        this.blockTouches = true;
        this.hideOnTouch = false;
        this.mEventListener = OnShowcaseEventListener.NONE;
        this.hasAlteredText = false;
        this.hasNoTarget = false;
        this.positionInWindow = new int[2];
        this.hideOnClickListener = new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ShowcaseView.this.hide();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        };
        if (new ApiUtils().isCompatWithHoneycomb()) {
            this.animationFactory = new AnimatorAnimationFactory();
        } else {
            this.animationFactory = new NoAnimationFactory();
        }
        this.showcaseAreaCalculator = new ShowcaseAreaCalculator();
        this.shotStateStore = new ShotStateStore(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ShowcaseView, R.attr.showcaseViewStyle, R.style.ShowcaseView);
        this.fadeInMillis = (long) getResources().getInteger(17694721);
        this.fadeOutMillis = (long) getResources().getInteger(17694721);
        this.mEndButton = (Button) LayoutInflater.from(context).inflate(R.layout.showcase_button, (ViewGroup) null);
        if (z11) {
            this.showcaseDrawer = new NewShowcaseDrawer(getResources(), context.getTheme());
        } else {
            this.showcaseDrawer = new StandardShowcaseDrawer(getResources(), context.getTheme());
        }
        this.textDrawer = new TextDrawer(getResources(), getContext());
        updateStyle(obtainStyledAttributes, false);
        init();
    }

    public void setShowcasePosition(int i11, int i12) {
        if (!this.shotStateStore.hasShot()) {
            getLocationInWindow(this.positionInWindow);
            int[] iArr = this.positionInWindow;
            this.showcaseX = i11 - iArr[0];
            this.showcaseY = i12 - iArr[1];
            recalculateText();
            invalidate();
            if (hasShowcaseView()) {
                View view = new View(getContext());
                view.setId(R.id.showcase_replace_view);
                int showcaseWidth = this.showcaseDrawer.getShowcaseWidth();
                int showcaseHeight = this.showcaseDrawer.getShowcaseHeight();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(showcaseWidth, showcaseHeight);
                int i13 = showcaseWidth / 2;
                int i14 = showcaseHeight / 2;
                layoutParams.setMargins(this.showcaseX - i13, this.showcaseY - i14, 0, 0);
                view.setLayoutParams(layoutParams);
                addView(view);
                OnAddCustomViewListener onAddCustomViewListener2 = this.onAddCustomViewListener;
                if (onAddCustomViewListener2 != null) {
                    int id2 = view.getId();
                    int i15 = this.showcaseX;
                    int i16 = this.showcaseY;
                    onAddCustomViewListener2.onAddCustomView(this, id2, i15 - i13, i16 - i14, i15 + i13, i16 + i14);
                }
                invalidate();
            }
        }
    }
}
