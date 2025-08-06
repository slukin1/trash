package com.sumsub.sns.camera.photo.presentation.document;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SizeF;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.common.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001UB1\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0002\u0012\b\b\u0002\u0010R\u001a\u00020\u0002¢\u0006\u0004\bS\u0010TJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R.\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010/\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020(8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0017R\u0014\u00102\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010#R$\u0010:\u001a\u0002052\u0006\u0010\u001a\u001a\u0002058\u0002@BX\u000e¢\u0006\f\n\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010@\u001a\u00020;2\u0006\u0010\u001a\u001a\u00020;8\u0002@BX\u000e¢\u0006\f\n\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010G\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010J\u001a\u0002052\u0006\u0010\u001a\u001a\u0002058\u0002@BX\u000e¢\u0006\f\n\u0004\bH\u00107\"\u0004\bI\u00109R\u0014\u0010L\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010D¨\u0006V"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground;", "Landroid/view/View;", "", "w", "h", "oldw", "oldh", "", "onSizeChanged", "Landroid/graphics/Canvas;", "canvas", "onDraw", "Landroid/graphics/RectF;", "b", "a", "frameRect", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "canvasBitmap", "Landroid/graphics/Canvas;", "drawCanvas", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "canvasPaint", "Landroid/util/SizeF;", "value", "d", "Landroid/util/SizeF;", "getFrameSize", "()Landroid/util/SizeF;", "setFrameSize", "(Landroid/util/SizeF;)V", "frameSize", "e", "Landroid/graphics/RectF;", "getFrameRect", "()Landroid/graphics/RectF;", "setFrameRect", "(Landroid/graphics/RectF;)V", "Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground$State;", "f", "Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground$State;", "getState", "()Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground$State;", "setState", "(Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground$State;)V", "state", "g", "rectPaint", "strokedRectPaint", "i", "strokedRect", "", "j", "F", "setStateFrameWidth", "(F)V", "stateFrameWidth", "Landroid/content/res/ColorStateList;", "k", "Landroid/content/res/ColorStateList;", "setStateFrameColors", "(Landroid/content/res/ColorStateList;)V", "stateFrameColors", "l", "I", "getFrameBackgroundColor", "()I", "setFrameBackgroundColor", "(I)V", "frameBackgroundColor", "m", "setStateFrameRadius", "stateFrameRadius", "getStateFrameColor", "stateFrameColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "State", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSFrameViewWithBackground extends View {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f30625a;

    /* renamed from: b  reason: collision with root package name */
    public Canvas f30626b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f30627c;

    /* renamed from: d  reason: collision with root package name */
    public SizeF f30628d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f30629e;

    /* renamed from: f  reason: collision with root package name */
    public State f30630f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f30631g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f30632h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f30633i;

    /* renamed from: j  reason: collision with root package name */
    public float f30634j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f30635k;

    /* renamed from: l  reason: collision with root package name */
    public int f30636l;

    /* renamed from: m  reason: collision with root package name */
    public float f30637m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground$State;", "", "(Ljava/lang/String;I)V", "DEFAULT", "RED", "YELLOW", "GREEN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum State {
        DEFAULT,
        RED,
        YELLOW,
        GREEN
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30638a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.YELLOW.ordinal()] = 1;
            iArr[State.GREEN.ordinal()] = 2;
            iArr[State.RED.ordinal()] = 3;
            f30638a = iArr;
        }
    }

    public SNSFrameViewWithBackground(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final int getStateFrameColor() {
        int i11 = a.f30638a[this.f30630f.ordinal()];
        int colorForState = this.f30635k.getColorForState(i11 != 1 ? i11 != 2 ? i11 != 3 ? new int[]{R.attr.sns_stateInit} : new int[]{R.attr.sns_stateRejected} : new int[]{R.attr.sns_stateApproved} : new int[]{R.attr.sns_statePending}, -65281);
        return Color.rgb(Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState));
    }

    private final void setFrameBackgroundColor(int i11) {
        this.f30636l = i11;
        invalidate();
    }

    private final void setFrameRect(RectF rectF) {
        this.f30629e = rectF;
        if (rectF != null) {
            a(rectF);
        }
    }

    private final void setStateFrameColors(ColorStateList colorStateList) {
        this.f30635k = colorStateList;
        invalidate();
    }

    private final void setStateFrameRadius(float f11) {
        this.f30637m = f11;
        invalidate();
    }

    private final void setStateFrameWidth(float f11) {
        this.f30634j = f11;
        this.f30632h.setStrokeWidth(f11);
        invalidate();
    }

    public final void a() {
        int i11;
        int i12;
        int i13;
        int i14;
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        Integer a11 = aVar.a((View) this, SNSColorElement.CONTENT_WARNING);
        if (a11 != null) {
            i11 = a11.intValue();
        } else {
            i11 = this.f30635k.getColorForState(new int[]{R.attr.sns_statePending}, -65281);
        }
        Integer a12 = aVar.a((View) this, SNSColorElement.CONTENT_SUCCESS);
        if (a12 != null) {
            i12 = a12.intValue();
        } else {
            i12 = this.f30635k.getColorForState(new int[]{R.attr.sns_stateApproved}, -65281);
        }
        SNSColorElement sNSColorElement = SNSColorElement.CONTENT_CRITICAL;
        Integer a13 = aVar.a((View) this, sNSColorElement);
        if (a13 != null) {
            i13 = a13.intValue();
        } else {
            i13 = this.f30635k.getColorForState(new int[]{R.attr.sns_stateRejected}, -65281);
        }
        Integer a14 = aVar.a((View) this, sNSColorElement);
        if (a14 != null) {
            i14 = a14.intValue();
        } else {
            i14 = this.f30635k.getColorForState(new int[]{R.attr.sns_stateInit}, -65281);
        }
        setStateFrameColors(new ColorStateList(new int[][]{new int[]{R.attr.sns_statePending}, new int[]{R.attr.sns_stateApproved}, new int[]{R.attr.sns_stateRejected}, new int[]{R.attr.sns_stateInit}}, new int[]{i11, i12, i13, i14}));
    }

    public final RectF b() {
        SizeF sizeF;
        if (getWidth() == 0 || getHeight() == 0 || (sizeF = this.f30628d) == null) {
            return null;
        }
        float f11 = (float) 2;
        float width = (((float) getWidth()) - sizeF.getWidth()) / f11;
        float height = (((float) getHeight()) - sizeF.getHeight()) / f11;
        RectF rectF = new RectF(width, height, sizeF.getWidth() + width, sizeF.getHeight() + height);
        setFrameRect(rectF);
        return rectF;
    }

    public final int getFrameBackgroundColor() {
        return this.f30636l;
    }

    public final RectF getFrameRect() {
        return this.f30629e;
    }

    public final SizeF getFrameSize() {
        return this.f30628d;
    }

    public final State getState() {
        return this.f30630f;
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        if (this.f30625a != null && (canvas2 = this.f30626b) != null) {
            a(canvas2);
            Bitmap bitmap = this.f30625a;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f30627c);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        Bitmap bitmap;
        super.onSizeChanged(i11, i12, i13, i14);
        Bitmap bitmap2 = this.f30625a;
        if ((bitmap2 != null && !bitmap2.isRecycled()) && (bitmap = this.f30625a) != null) {
            bitmap.recycle();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        this.f30626b = new Canvas(createBitmap);
        this.f30625a = createBitmap;
    }

    public final void setFrameSize(SizeF sizeF) {
        setFrameRect((RectF) null);
        this.f30628d = sizeF;
        invalidate();
    }

    public final void setState(State state) {
        this.f30630f = state;
        RectF rectF = this.f30629e;
        if (rectF != null) {
            a(rectF);
            this.f30632h.setColor(getStateFrameColor());
        }
        invalidate();
    }

    public SNSFrameViewWithBackground(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSFrameViewWithBackground(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFrameViewWithBackground(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.snsFrameViewWithBackgroundStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSFrameViewWithBackground : i12);
    }

    public SNSFrameViewWithBackground(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f30627c = new Paint(4);
        this.f30630f = State.RED;
        Paint paint = new Paint();
        this.f30631g = paint;
        Paint paint2 = new Paint();
        this.f30632h = paint2;
        this.f30633i = new RectF();
        this.f30635k = ColorStateList.valueOf(-65281);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSFrameViewWithBackground, i11, i12);
        int i13 = R.styleable.SNSFrameViewWithBackground_sns_stateFrameColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            setStateFrameColors(i.a(obtainStyledAttributes, context, i13));
        }
        int i14 = R.styleable.SNSFrameViewWithBackground_sns_stateFrameRadius;
        if (obtainStyledAttributes.hasValue(i14)) {
            setStateFrameRadius((float) obtainStyledAttributes.getDimensionPixelSize(i14, context.getResources().getDimensionPixelSize(R.dimen.sns_state_frame_radius)));
        }
        int i15 = R.styleable.SNSFrameViewWithBackground_sns_stateFrameWidth;
        if (obtainStyledAttributes.hasValue(i15)) {
            setStateFrameWidth((float) obtainStyledAttributes.getDimensionPixelSize(i15, context.getResources().getDimensionPixelSize(R.dimen.sns_frame_stroke_width)));
        }
        int i16 = R.styleable.SNSFrameViewWithBackground_sns_frameBackgroundColor;
        if (obtainStyledAttributes.hasValue(i16)) {
            setFrameBackgroundColor(obtainStyledAttributes.getColor(i16, ContextCompat.getColor(context, R.color.sns_auto_capture_frame_background)));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a();
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        Float a11 = aVar.a(SNSMetricElement.DOCUMENT_FRAME_BORDER_WIDTH);
        if (a11 != null) {
            setStateFrameWidth(a11.floatValue());
        }
        Float a12 = aVar.a(SNSMetricElement.DOCUMENT_FRAME_CORNER_RADIUS);
        if (a12 != null) {
            setStateFrameRadius(a12.floatValue());
        }
        Integer a13 = aVar.a((View) this, SNSColorElement.CAMERA_BACKGROUND_OVERLAY);
        if (a13 != null) {
            setFrameBackgroundColor(a13.intValue());
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setDither(true);
        paint.setColor(0);
        paint2.setColor(getStateFrameColor());
        paint2.setStyle(Paint.Style.STROKE);
        Resources resources = context.getResources();
        int i17 = R.dimen.sns_frame_stroke_interval;
        paint2.setPathEffect(new DashPathEffect(new float[]{(float) resources.getDimensionPixelSize(i17), (float) context.getResources().getDimensionPixelSize(i17)}, 0.0f));
    }

    public final void a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        RectF rectF = this.f30629e;
        if (rectF != null || (rectF = b()) != null) {
            canvas.drawColor(this.f30636l);
            float f11 = this.f30637m;
            canvas.drawRoundRect(rectF, f11, f11, this.f30631g);
            RectF rectF2 = this.f30633i;
            float f12 = this.f30637m;
            canvas.drawRoundRect(rectF2, f12, f12, this.f30632h);
        }
    }

    public final void a(RectF rectF) {
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.dimen.sns_frame_stroke_width);
        this.f30633i = new RectF(rectF.left - dimensionPixelSize, rectF.top - dimensionPixelSize, rectF.right + dimensionPixelSize, rectF.bottom + dimensionPixelSize);
    }
}
