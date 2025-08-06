package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import androidx.core.widget.l;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = new a(Float.class, "thumbPos");
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private g mAppCompatEmojiTextHelper;
    private c mEmojiCompatInitCallback;
    private boolean mEnforceSwitchWidth;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final n mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOffTransformed;
    private CharSequence mTextOn;
    private CharSequence mTextOnTransformed;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    public float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    public class a extends Property<SwitchCompat, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f11) {
            switchCompat.setThumbPosition(f11.floatValue());
        }
    }

    public static class b {
        public static void a(ObjectAnimator objectAnimator, boolean z11) {
            objectAnimator.setAutoCancel(z11);
        }
    }

    public static class c extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Reference<SwitchCompat> f4519a;

        public c(SwitchCompat switchCompat) {
            this.f4519a = new WeakReference(switchCompat);
        }

        public void a(Throwable th2) {
            SwitchCompat switchCompat = this.f4519a.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }

        public void b() {
            SwitchCompat switchCompat = this.f4519a.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }
    }

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateThumbToCheckedState(boolean z11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{z11 ? 1.0f : 0.0f});
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(this.mPositionAnimator, true);
        }
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            Drawable mutate = u0.a.r(drawable).mutate();
            this.mThumbDrawable = mutate;
            if (this.mHasThumbTint) {
                u0.a.o(mutate, this.mThumbTintList);
            }
            if (this.mHasThumbTintMode) {
                u0.a.p(this.mThumbDrawable, this.mThumbTintMode);
            }
            if (this.mThumbDrawable.isStateful()) {
                this.mThumbDrawable.setState(getDrawableState());
            }
        }
    }

    private void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            Drawable mutate = u0.a.r(drawable).mutate();
            this.mTrackDrawable = mutate;
            if (this.mHasTrackTint) {
                u0.a.o(mutate, this.mTrackTintList);
            }
            if (this.mHasTrackTintMode) {
                u0.a.p(this.mTrackDrawable, this.mTrackTintMode);
            }
            if (this.mTrackDrawable.isStateful()) {
                this.mTrackDrawable.setState(getDrawableState());
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float constrain(float f11, float f12, float f13) {
        return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
    }

    private CharSequence doTransformForOnOffText(CharSequence charSequence) {
        TransformationMethod f11 = getEmojiTextViewHelper().f(this.mSwitchTransformationMethod);
        return f11 != null ? f11.getTransformation(charSequence, this) : charSequence;
    }

    private g getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private int getThumbOffset() {
        float f11;
        if (o0.b(this)) {
            f11 = 1.0f - this.mThumbPosition;
        } else {
            f11 = this.mThumbPosition;
        }
        return (int) ((f11 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.mTempRect;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            rect = r.d(drawable2);
        } else {
            rect = r.f4672c;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    private boolean hitThumb(float f11, float f12) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i11 = this.mSwitchTop;
        int i12 = this.mTouchSlop;
        int i13 = i11 - i12;
        int i14 = (this.mSwitchLeft + thumbOffset) - i12;
        Rect rect = this.mTempRect;
        int i15 = this.mThumbWidth + i14 + rect.left + rect.right + i12;
        int i16 = this.mSwitchBottom + i12;
        if (f11 <= ((float) i14) || f11 >= ((float) i15) || f12 <= ((float) i13) || f12 >= ((float) i16)) {
            return false;
        }
        return true;
    }

    private Layout makeLayout(CharSequence charSequence) {
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOff;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_off);
            }
            h0.T0(this, charSequence);
        }
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOn;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_on);
            }
            h0.T0(this, charSequence);
        }
    }

    private void setSwitchTypefaceByIndex(int i11, int i12) {
        Typeface typeface;
        if (i11 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i11 != 2) {
            typeface = i11 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        setSwitchTypeface(typeface, i12);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.mTextOff = charSequence;
        this.mTextOffTransformed = doTransformForOnOffText(charSequence);
        this.mOffLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.mTextOn = charSequence;
        this.mTextOnTransformed = doTransformForOnOffText(charSequence);
        this.mOnLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    private void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null && this.mAppCompatEmojiTextHelper.b() && EmojiCompat.h()) {
            EmojiCompat b11 = EmojiCompat.b();
            int d11 = b11.d();
            if (d11 == 3 || d11 == 0) {
                c cVar = new c(this);
                this.mEmojiCompatInitCallback = cVar;
                b11.s(cVar);
            }
        }
    }

    private void stopDrag(MotionEvent motionEvent) {
        this.mTouchMode = 0;
        boolean z11 = true;
        boolean z12 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z12) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.mMinFlingVelocity)) {
                z11 = getTargetCheckedState();
            } else if (!o0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z11 = false;
            }
        } else {
            z11 = isChecked;
        }
        if (z11 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z11);
        cancelSuperTouch(motionEvent);
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i11;
        int i12;
        Rect rect2 = this.mTempRect;
        int i13 = this.mSwitchLeft;
        int i14 = this.mSwitchTop;
        int i15 = this.mSwitchRight;
        int i16 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i13;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = r.d(drawable);
        } else {
            rect = r.f4672c;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i17 = rect2.left;
            thumbOffset += i17;
            if (rect != null) {
                int i18 = rect.left;
                if (i18 > i17) {
                    i13 += i18 - i17;
                }
                int i19 = rect.top;
                int i21 = rect2.top;
                i11 = i19 > i21 ? (i19 - i21) + i14 : i14;
                int i22 = rect.right;
                int i23 = rect2.right;
                if (i22 > i23) {
                    i15 -= i22 - i23;
                }
                int i24 = rect.bottom;
                int i25 = rect2.bottom;
                if (i24 > i25) {
                    i12 = i16 - (i24 - i25);
                    this.mTrackDrawable.setBounds(i13, i11, i15, i12);
                }
            } else {
                i11 = i14;
            }
            i12 = i16;
            this.mTrackDrawable.setBounds(i13, i11, i15, i12);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i26 = thumbOffset - rect2.left;
            int i27 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(i26, i14, i27, i16);
            Drawable background = getBackground();
            if (background != null) {
                u0.a.l(background, i26, i14, i27, i16);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f11, f12);
        }
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            u0.a.k(drawable, f11, f12);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            u0.a.k(drawable2, f11, f12);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean z11 = false;
        if (drawable != null && drawable.isStateful()) {
            z11 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z11 |= drawable2.setState(drawableState);
        }
        if (z11) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!o0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (o0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public final float getThumbPosition() {
        return this.mThumbPosition;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        int i11;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i12 = this.mSwitchTop;
        int i13 = this.mSwitchBottom;
        int i14 = i12 + rect.top;
        int i15 = i13 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (!this.mSplitTrack || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d11 = r.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d11.left;
                rect.right -= d11.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i11 = bounds.left + bounds.right;
            } else {
                i11 = getWidth();
            }
            canvas.translate((float) ((i11 / 2) - (layout.getWidth() / 2)), (float) (((i14 + i15) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(text);
                sb2.append(' ');
                sb2.append(charSequence);
                accessibilityNodeInfo.setText(sb2);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        super.onLayout(z11, i11, i12, i13, i14);
        int i22 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d11 = r.d(this.mThumbDrawable);
            i15 = Math.max(0, d11.left - rect.left);
            i22 = Math.max(0, d11.right - rect.right);
        } else {
            i15 = 0;
        }
        if (o0.b(this)) {
            i17 = getPaddingLeft() + i15;
            i16 = ((this.mSwitchWidth + i17) - i15) - i22;
        } else {
            i16 = (getWidth() - getPaddingRight()) - i22;
            i17 = (i16 - this.mSwitchWidth) + i15 + i22;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i21 = this.mSwitchHeight;
            i19 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i21 / 2);
        } else if (gravity != 80) {
            i19 = getPaddingTop();
            i21 = this.mSwitchHeight;
        } else {
            i18 = getHeight() - getPaddingBottom();
            i19 = i18 - this.mSwitchHeight;
            this.mSwitchLeft = i17;
            this.mSwitchTop = i19;
            this.mSwitchBottom = i18;
            this.mSwitchRight = i16;
        }
        i18 = i21 + i19;
        this.mSwitchLeft = i17;
        this.mSwitchTop = i19;
        this.mSwitchBottom = i18;
        this.mSwitchRight = i16;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOnTransformed);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOffTransformed);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int i16 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i14 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            i13 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            i14 = 0;
            i13 = 0;
        }
        this.mThumbWidth = Math.max(this.mShowText ? Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2) : 0, i14);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i16 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i17 = rect.left;
        int i18 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect d11 = r.d(drawable3);
            i17 = Math.max(i17, d11.left);
            i18 = Math.max(i18, d11.right);
        }
        if (this.mEnforceSwitchWidth) {
            i15 = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i17 + i18);
        } else {
            i15 = this.mSwitchMinWidth;
        }
        int max = Math.max(i16, i13);
        this.mSwitchWidth = i15;
        this.mSwitchHeight = max;
        super.onMeasure(i11, i12);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009d
            r2 = 2
            if (r0 == r1) goto L_0x0089
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x0089
            goto L_0x00b7
        L_0x0016:
            int r0 = r6.mTouchMode
            if (r0 == r1) goto L_0x0055
            if (r0 == r2) goto L_0x001e
            goto L_0x00b7
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003b
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            r2 = r3
            goto L_0x003b
        L_0x0038:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L_0x003b:
            boolean r0 = androidx.appcompat.widget.o0.b(r6)
            if (r0 == 0) goto L_0x0042
            float r2 = -r2
        L_0x0042:
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = constrain(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0054
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L_0x0054:
            return r1
        L_0x0055:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007b
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b7
        L_0x007b:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L_0x0089:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L_0x0094
            r6.stopDrag(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0094:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto L_0x00b7
        L_0x009d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r6.hitThumb(r0, r2)
            if (r3 == 0) goto L_0x00b7
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        L_0x00b7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().d(z11);
    }

    public void setChecked(boolean z11) {
        super.setChecked(z11);
        boolean isChecked = isChecked();
        if (isChecked) {
            setOnStateDescriptionOnRAndAbove();
        } else {
            setOffStateDescriptionOnRAndAbove();
        }
        if (getWindowToken() == null || !h0.a0(this)) {
            cancelPositionAnimator();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        animateThumbToCheckedState(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().e(z11);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z11) {
        this.mEnforceSwitchWidth = z11;
        invalidate();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z11) {
        if (this.mShowText != z11) {
            this.mShowText = z11;
            requestLayout();
            if (z11) {
                setupEmojiCompatLoadCallback();
            }
        }
    }

    public void setSplitTrack(boolean z11) {
        this.mSplitTrack = z11;
        invalidate();
    }

    public void setSwitchMinWidth(int i11) {
        this.mSwitchMinWidth = i11;
        requestLayout();
    }

    public void setSwitchPadding(int i11) {
        this.mSwitchPadding = i11;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i11) {
        d0 t11 = d0.t(context, i11, R$styleable.TextAppearance);
        ColorStateList c11 = t11.c(R$styleable.TextAppearance_android_textColor);
        if (c11 != null) {
            this.mTextColors = c11;
        } else {
            this.mTextColors = getTextColors();
        }
        int f11 = t11.f(R$styleable.TextAppearance_android_textSize, 0);
        if (f11 != 0) {
            float f12 = (float) f11;
            if (f12 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f12);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(t11.k(R$styleable.TextAppearance_android_typeface, -1), t11.k(R$styleable.TextAppearance_android_textStyle, -1));
        if (t11.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new f.a(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        t11.w();
    }

    public void setSwitchTypeface(Typeface typeface, int i11) {
        Typeface typeface2;
        float f11 = 0.0f;
        boolean z11 = false;
        if (i11 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i11);
            } else {
                typeface2 = Typeface.create(typeface, i11);
            }
            setSwitchTypeface(typeface2);
            int i12 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i11;
            TextPaint textPaint = this.mTextPaint;
            if ((i12 & 1) != 0) {
                z11 = true;
            }
            textPaint.setFakeBoldText(z11);
            TextPaint textPaint2 = this.mTextPaint;
            if ((i12 & 2) != 0) {
                f11 = -0.25f;
            }
            textPaint2.setTextSkewX(f11);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            setOffStateDescriptionOnRAndAbove();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            setOnStateDescriptionOnRAndAbove();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f11) {
        this.mThumbPosition = f11;
        invalidate();
    }

    public void setThumbResource(int i11) {
        setThumbDrawable(c.a.b(getContext(), i11));
    }

    public void setThumbTextPadding(int i11) {
        this.mThumbTextPadding = i11;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i11) {
        setTrackDrawable(c.a.b(getContext(), i11));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mEnforceSwitchWidth = true;
        this.mTempRect = new Rect();
        z.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.SwitchCompat;
        d0 v11 = d0.v(context, attributeSet, iArr, i11, 0);
        h0.v0(this, context, iArr, attributeSet, v11.r(), i11, 0);
        Drawable g11 = v11.g(R$styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        Drawable g12 = v11.g(R$styleable.SwitchCompat_track);
        this.mTrackDrawable = g12;
        if (g12 != null) {
            g12.setCallback(this);
        }
        setTextOnInternal(v11.p(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(v11.p(R$styleable.SwitchCompat_android_textOff));
        this.mShowText = v11.a(R$styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = v11.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = v11.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = v11.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = v11.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList c11 = v11.c(R$styleable.SwitchCompat_thumbTint);
        if (c11 != null) {
            this.mThumbTintList = c11;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode e11 = r.e(v11.k(R$styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.mThumbTintMode != e11) {
            this.mThumbTintMode = e11;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList c12 = v11.c(R$styleable.SwitchCompat_trackTint);
        if (c12 != null) {
            this.mTrackTintList = c12;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode e12 = r.e(v11.k(R$styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.mTrackTintMode != e12) {
            this.mTrackTintMode = e12;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int n11 = v11.n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (n11 != 0) {
            setSwitchTextAppearance(context, n11);
        }
        n nVar = new n(this);
        this.mTextHelper = nVar;
        nVar.m(attributeSet, i11);
        v11.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i11);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
