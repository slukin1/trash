package com.sumsub.sns.core.widget.pincode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\r\n\u0002\b\u000f\b\u0007\u0018\u0000 g2\u00020\u0001:\u0004fghiB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020DH\u0014J\u0010\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020\u001dH\u0002J\b\u0010G\u001a\u00020\u001dH\u0016J\b\u0010H\u001a\u00020?H\u0002J\b\u0010I\u001a\u00020?H\u0002J\b\u0010J\u001a\u00020?H\u0014J\b\u0010K\u001a\u00020?H\u0014J\u0010\u0010L\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0014J\"\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010;H\u0014J\u0018\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0014J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0007H\u0016J\u0018\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0014J(\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007H\u0014J\b\u0010_\u001a\u00020?H\u0002J\u000e\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u0014J\u0010\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020\u0007H\u0002J\b\u0010d\u001a\u00020\u001dH\u0002J\b\u0010e\u001a\u00020?H\u0002R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0018\u000103R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "Landroid/content/res/ColorStateList;", "boxBackgroundColor", "getBoxBackgroundColor", "()Landroid/content/res/ColorStateList;", "setBoxBackgroundColor", "(Landroid/content/res/ColorStateList;)V", "boxStrokeColor", "getBoxStrokeColor", "setBoxStrokeColor", "", "boxStrokeWidth", "getBoxStrokeWidth", "()Ljava/lang/Float;", "setBoxStrokeWidth", "(Ljava/lang/Float;)V", "cursorDrawable", "Landroid/graphics/drawable/Drawable;", "drawCursor", "", "isCursorVisible", "isError", "()Z", "setError", "(Z)V", "isPassword", "setPassword", "itemBackground", "getItemBackground", "()Landroid/graphics/drawable/Drawable;", "setItemBackground", "(Landroid/graphics/drawable/Drawable;)V", "count", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "itemPadding", "itemSpacing", "mBlink", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView$Blink;", "onTextCompleteListener", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView$OnTextCompleteListener;", "getOnTextCompleteListener", "()Lcom/sumsub/sns/core/widget/pincode/SNSPinView$OnTextCompleteListener;", "setOnTextCompleteListener", "(Lcom/sumsub/sns/core/widget/pincode/SNSPinView$OnTextCompleteListener;)V", "rect", "Landroid/graphics/Rect;", "shapeAppearance", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "disableSelectionMenu", "", "drawPinView", "canvas", "Landroid/graphics/Canvas;", "getDefaultMovementMethod", "Landroid/text/method/MovementMethod;", "invalidateCursor", "showCursor", "isSuggestionsEnabled", "makeBlink", "moveSelectionToEnd", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScreenStateChanged", "screenState", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "resumeBlink", "setCornerSize", "radius", "setMaxLength", "maxLength", "shouldBlink", "suspendBlink", "Blink", "Companion", "DefaultActionModeCallback", "OnTextCompleteListener", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public final class SNSPinView extends EditText {
    private static final int BLINK = 500;
    public static final Companion Companion = new Companion((r) null);
    private static final int DEFAULT_COUNT = 6;
    private static final int[] ERROR_STATE = {R.attr.sns_stateRejected};
    private static final int[] HIGHLIGHT_STATE = {16842913};
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private Drawable cursorDrawable;
    /* access modifiers changed from: private */
    public boolean drawCursor;
    private boolean isCursorVisible;
    private boolean isError;
    private boolean isPassword;
    private Drawable itemBackground;
    private int itemCount;
    private int itemPadding;
    private int itemSpacing;
    private Blink mBlink;
    private OnTextCompleteListener onTextCompleteListener;
    private final Rect rect;
    private final ShapeAppearanceModel shapeAppearance;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/widget/pincode/SNSPinView$Blink;", "Ljava/lang/Runnable;", "(Lcom/sumsub/sns/core/widget/pincode/SNSPinView;)V", "mCancelled", "", "cancel", "", "run", "uncancel", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Blink implements Runnable {
        private boolean mCancelled;

        public Blink() {
        }

        public final void cancel() {
            if (!this.mCancelled) {
                SNSPinView.this.removeCallbacks(this);
                this.mCancelled = true;
            }
        }

        public void run() {
            if (!this.mCancelled) {
                SNSPinView.this.removeCallbacks(this);
                if (SNSPinView.this.shouldBlink()) {
                    SNSPinView sNSPinView = SNSPinView.this;
                    sNSPinView.invalidateCursor(!sNSPinView.drawCursor);
                    SNSPinView.this.postDelayed(this, 500);
                }
            }
        }

        public final void uncancel() {
            this.mCancelled = false;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/pincode/SNSPinView$Companion;", "", "()V", "BLINK", "", "DEFAULT_COUNT", "ERROR_STATE", "", "HIGHLIGHT_STATE", "NO_FILTERS", "", "Landroid/text/InputFilter;", "[Landroid/text/InputFilter;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/pincode/SNSPinView$DefaultActionModeCallback;", "Landroid/view/ActionMode$Callback;", "()V", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class DefaultActionModeCallback implements ActionMode.Callback {
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/pincode/SNSPinView$OnTextCompleteListener;", "", "onTextComplete", "", "enteredText", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnTextCompleteListener {
        boolean onTextComplete(String str);
    }

    public SNSPinView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final void disableSelectionMenu() {
        setCustomSelectionActionModeCallback(new DefaultActionModeCallback());
        if (Build.VERSION.SDK_INT >= 26) {
            setCustomInsertionActionModeCallback(new SNSPinView$disableSelectionMenu$1());
        }
    }

    private final void drawPinView(Canvas canvas) {
        boolean z11;
        boolean z12;
        Drawable drawable;
        int[] iArr;
        Canvas canvas2 = canvas;
        Editable text = getText();
        boolean z13 = false;
        int length = text != null ? text.length() : 0;
        int d11 = RangesKt___RangesKt.d((getHeight() - getPaddingTop()) - getPaddingBottom(), 0);
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int i11 = this.itemCount;
        int j11 = RangesKt___RangesKt.j((width - ((i11 - 1) * this.itemSpacing)) / i11, 0, d11);
        int paddingStart = getPaddingStart();
        int width2 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int i12 = this.itemCount;
        boolean z14 = true;
        int i13 = paddingStart + (((width2 - (j11 * i12)) - ((i12 - 1) * this.itemSpacing)) / 2);
        int paddingTop = getPaddingTop() + ((((getHeight() - d11) - getPaddingTop()) - getPaddingBottom()) / 2);
        int i14 = this.itemCount;
        int i15 = 0;
        while (i15 < i14) {
            boolean z15 = (!isFocused() || length != i15) ? z13 : z14;
            int i16 = ((this.itemSpacing + j11) * i15) + i13;
            int i17 = i16 + j11;
            Drawable drawable2 = this.itemBackground;
            if (drawable2 != null) {
                if (this.isError) {
                    iArr = ERROR_STATE;
                } else if (z15) {
                    iArr = HIGHLIGHT_STATE;
                } else {
                    iArr = getDrawableState();
                }
                drawable2.setState(iArr);
                drawable2.setBounds(i16, paddingTop, i17, paddingTop + d11);
                canvas.save();
                drawable2.draw(canvas2);
                canvas.restore();
            }
            if (z15 && this.drawCursor && (drawable = this.cursorDrawable) != null) {
                int intrinsicWidth = (((i17 - i16) - drawable.getIntrinsicWidth()) / 2) + i16;
                int textSize = ((d11 - ((int) getTextSize())) / 2) + paddingTop;
                drawable.setBounds(intrinsicWidth, textSize, intrinsicWidth + drawable.getIntrinsicWidth(), ((int) getTextSize()) + textSize);
                canvas.save();
                drawable.draw(canvas2);
                canvas.restore();
            }
            Editable text2 = getText();
            if (i15 < (text2 != null ? text2.length() : 0)) {
                if (this.isPassword) {
                    float f11 = (float) (i17 - i16);
                    getPaint().setColor(getCurrentTextColor());
                    canvas2.drawCircle(((float) i16) + (f11 / 2.0f), ((float) (paddingTop + d11)) - (((float) d11) / 2.0f), f11 / 9.0f, getPaint());
                } else {
                    String obj = getText().subSequence(i15, i15 + 1).toString();
                    z12 = false;
                    z11 = true;
                    getPaint().getTextBounds(obj, 0, 1, this.rect);
                    float width3 = ((float) i16) + (((float) ((i17 - i16) - this.rect.width())) / 2.0f);
                    float height = ((float) (paddingTop + d11)) - (((float) (d11 - this.rect.height())) / 2.0f);
                    getPaint().setColor(getCurrentTextColor());
                    canvas2.drawText(obj, width3, height, getPaint());
                    i15++;
                    z13 = z12;
                    z14 = z11;
                }
            }
            z12 = false;
            z11 = true;
            i15++;
            z13 = z12;
            z14 = z11;
        }
    }

    /* access modifiers changed from: private */
    public final void invalidateCursor(boolean z11) {
        if (this.drawCursor != z11) {
            this.drawCursor = z11;
            invalidate();
        }
    }

    private final void makeBlink() {
        if (shouldBlink()) {
            if (this.mBlink == null) {
                this.mBlink = new Blink();
            }
            removeCallbacks(this.mBlink);
            this.drawCursor = false;
            postDelayed(this.mBlink, 500);
            return;
        }
        Blink blink = this.mBlink;
        if (blink != null) {
            removeCallbacks(blink);
        }
    }

    private final void moveSelectionToEnd() {
        Editable text = getText();
        setSelection(text != null ? text.length() : 0);
    }

    private final void resumeBlink() {
        Blink blink = this.mBlink;
        if (blink != null) {
            blink.uncancel();
            makeBlink();
        }
    }

    private final void setMaxLength(int i11) {
        setFilters(i11 >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(i11)} : NO_FILTERS);
    }

    /* access modifiers changed from: private */
    public final boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private final void suspendBlink() {
        Blink blink = this.mBlink;
        if (blink != null) {
            blink.cancel();
            invalidateCursor(false);
        }
    }

    public final ColorStateList getBoxBackgroundColor() {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            return materialShapeDrawable.getFillColor();
        }
        return null;
    }

    public final ColorStateList getBoxStrokeColor() {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            return materialShapeDrawable.getStrokeColor();
        }
        return null;
    }

    public final Float getBoxStrokeWidth() {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            return Float.valueOf(materialShapeDrawable.getStrokeWidth());
        }
        return null;
    }

    public MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.INSTANCE;
    }

    public final Drawable getItemBackground() {
        return this.itemBackground;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final OnTextCompleteListener getOnTextCompleteListener() {
        return this.onTextCompleteListener;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    public boolean isSuggestionsEnabled() {
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        drawPinView(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect2) {
        super.onFocusChanged(z11, i11, rect2);
        if (z11) {
            moveSelectionToEnd();
            makeBlink();
        }
    }

    public void onMeasure(int i11, int i12) {
        getPaint().getTextBounds("8", 0, 1, this.rect);
        int height = this.itemPadding + this.rect.height();
        int i13 = this.itemPadding;
        int i14 = height + i13;
        int width = i13 + this.rect.width() + this.itemPadding;
        int paddingTop = getPaddingTop() + i14 + getPaddingBottom();
        int paddingStart = getPaddingStart();
        int i15 = this.itemCount;
        setMeasuredDimension(View.resolveSizeAndState(paddingStart + (width * i15) + (this.itemSpacing * (i15 - 1)), i11, 0), View.resolveSizeAndState(paddingTop, i12, 0));
    }

    public void onScreenStateChanged(int i11) {
        super.onScreenStateChanged(i11);
        if (i11 == 0) {
            suspendBlink();
        } else if (i11 == 1) {
            resumeBlink();
        }
    }

    public void onSelectionChanged(int i11, int i12) {
        super.onSelectionChanged(i11, i12);
        Editable text = getText();
        if (!(text != null && i12 == text.length())) {
            moveSelectionToEnd();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (i11 != charSequence.length()) {
            moveSelectionToEnd();
        }
        makeBlink();
        if (charSequence.length() == this.itemCount) {
            OnTextCompleteListener onTextCompleteListener2 = this.onTextCompleteListener;
            if (onTextCompleteListener2 != null ? onTextCompleteListener2.onTextComplete(charSequence.toString()) : false) {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    public final void setBoxBackgroundColor(ColorStateList colorStateList) {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    public final void setBoxStrokeColor(ColorStateList colorStateList) {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStrokeColor(colorStateList);
        }
    }

    public final void setBoxStrokeWidth(Float f11) {
        if (f11 != null) {
            float floatValue = f11.floatValue();
            Drawable drawable = this.itemBackground;
            MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setStrokeWidth(floatValue);
            }
        }
    }

    public final void setCornerSize(float f11) {
        Drawable drawable = this.itemBackground;
        MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setCornerSize(f11);
        }
    }

    public final void setError(boolean z11) {
        this.isError = z11;
        invalidate();
    }

    public final void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
    }

    public final void setItemCount(int i11) {
        this.itemCount = i11;
        setMaxLength(i11);
        requestLayout();
    }

    public final void setOnTextCompleteListener(OnTextCompleteListener onTextCompleteListener2) {
        this.onTextCompleteListener = onTextCompleteListener2;
    }

    public final void setPassword(boolean z11) {
        this.isPassword = z11;
    }

    public SNSPinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSPinView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSPinView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_pinViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSPinView : i12);
    }

    public SNSPinView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Float a11;
        Float a12;
        Integer a13;
        Integer a14;
        this.rect = new Rect();
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build();
        this.shapeAppearance = build;
        this.itemBackground = new MaterialShapeDrawable(build);
        this.itemCount = 6;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSPinView, i11, i12);
        int i13 = R.styleable.SNSPinView_android_itemBackground;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.itemBackground = obtainStyledAttributes.getDrawable(i13);
        } else {
            int i14 = R.styleable.SNSPinView_boxBackgroundColor;
            if (obtainStyledAttributes.hasValue(i14)) {
                Drawable drawable = this.itemBackground;
                MaterialShapeDrawable materialShapeDrawable = drawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable : null;
                if (materialShapeDrawable != null) {
                    materialShapeDrawable.setFillColor(obtainStyledAttributes.getColorStateList(i14));
                }
            }
            int i15 = R.styleable.SNSPinView_boxStrokeColor;
            if (obtainStyledAttributes.hasValue(i15)) {
                Drawable drawable2 = this.itemBackground;
                MaterialShapeDrawable materialShapeDrawable2 = drawable2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable2 : null;
                if (materialShapeDrawable2 != null) {
                    materialShapeDrawable2.setStrokeColor(obtainStyledAttributes.getColorStateList(i15));
                }
            }
            int i16 = R.styleable.SNSPinView_boxStrokeWidth;
            if (obtainStyledAttributes.hasValue(i16)) {
                Drawable drawable3 = this.itemBackground;
                MaterialShapeDrawable materialShapeDrawable3 = drawable3 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) drawable3 : null;
                if (materialShapeDrawable3 != null) {
                    materialShapeDrawable3.setStrokeWidth(obtainStyledAttributes.getDimension(i16, 0.0f));
                }
            }
        }
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSPinView_sns_itemSpacing, getResources().getDimensionPixelSize(R.dimen.sns_pin_view_item_spacing));
        this.itemPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSPinView_sns_itemPadding, getResources().getDimensionPixelSize(R.dimen.sns_pin_view_item_padding));
        this.isCursorVisible = obtainStyledAttributes.getBoolean(R.styleable.SNSPinView_android_cursorVisible, true);
        this.cursorDrawable = obtainStyledAttributes.getDrawable(R.styleable.SNSPinView_sns_cursorDrawable);
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        setTransformationMethod((TransformationMethod) null);
        disableSelectionMenu();
        setMaxLength(6);
        a aVar = a.f31095a;
        aVar.a((TextView) this, SNSTypographyElement.HEADLINE1, SNSColorElement.FIELD_CONTENT);
        SNSColorElement sNSColorElement = SNSColorElement.FIELD_BACKGROUND;
        d a15 = aVar.a();
        if (!(a15 == null || (a14 = aVar.a(a15, sNSColorElement, aVar.a((View) this))) == null)) {
            setBoxBackgroundColor(ColorStateList.valueOf(a14.intValue()));
        }
        SNSColorElement sNSColorElement2 = SNSColorElement.FIELD_BORDER;
        d a16 = aVar.a();
        if (!(a16 == null || (a13 = aVar.a(a16, sNSColorElement2, aVar.a((View) this))) == null)) {
            setBoxStrokeColor(ColorStateList.valueOf(a13.intValue()));
        }
        SNSMetricElement sNSMetricElement = SNSMetricElement.FIELD_CORNER_RADIUS;
        d a17 = aVar.a();
        if (!(a17 == null || (a12 = aVar.a(a17, sNSMetricElement)) == null)) {
            setCornerSize(a12.floatValue());
        }
        SNSMetricElement sNSMetricElement2 = SNSMetricElement.FIELD_BORDER_WIDTH;
        d a18 = aVar.a();
        if (a18 != null && (a11 = aVar.a(a18, sNSMetricElement2)) != null) {
            setBoxStrokeWidth(Float.valueOf(a11.floatValue()));
        }
    }
}
