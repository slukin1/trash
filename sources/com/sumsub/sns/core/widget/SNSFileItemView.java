package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.squareup.picasso.Picasso;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0018\u0012\b\b\u0002\u00109\u001a\u00020\u0018¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0014\u0010(\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0000X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006<"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSFileItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/sumsub/sns/internal/core/widget/a;", "", "text", "", "setText", "Landroid/graphics/drawable/Drawable;", "icon", "setStartIcon", "", "url", "loadImage", "setEndIcon", "Landroid/view/View$OnClickListener;", "listener", "setEndIconClickListener", "", "visible", "setProgressVisibility", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "setSNSStepState", "", "extraSpace", "", "onCreateDrawableState", "Landroid/widget/ImageView;", "ivStartIcon", "Landroid/widget/ImageView;", "ivEndIcon", "Landroid/widget/TextView;", "tvText", "Landroid/widget/TextView;", "Landroid/view/View;", "endProgressBar", "Landroid/view/View;", "ivPreview", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "shapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "boxBackground", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "getBoxBackground$idensic_mobile_sdk_aar_release", "()Lcom/google/android/material/shape/MaterialShapeDrawable;", "Lcom/squareup/picasso/Picasso;", "picasso", "Lcom/squareup/picasso/Picasso;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public class SNSFileItemView extends ConstraintLayout implements a {
    private final MaterialShapeDrawable boxBackground;
    private final View endProgressBar;
    private final ImageView ivEndIcon;
    private final ImageView ivPreview;
    private final ImageView ivStartIcon;
    private final Picasso picasso;
    private final ShapeAppearanceModel shapeAppearanceModel;
    private SNSStepState stepState;
    private final TextView tvText;

    public SNSFileItemView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public final MaterialShapeDrawable getBoxBackground$idensic_mobile_sdk_aar_release() {
        return this.boxBackground;
    }

    public SNSStepState getSNSStepState() {
        SNSStepState sNSStepState = this.stepState;
        return sNSStepState == null ? SNSStepState.INIT : sNSStepState;
    }

    public final void loadImage(String str) {
        com.squareup.picasso.r l11;
        com.squareup.picasso.r m11;
        Picasso picasso2;
        if (str == null) {
            ImageView imageView = this.ivPreview;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.ivStartIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.ivPreview;
            if (imageView3 != null && (picasso2 = this.picasso) != null) {
                picasso2.b(imageView3);
                return;
            }
            return;
        }
        ImageView imageView4 = this.ivPreview;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.ivStartIcon;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.sns_icon_size_normal_large);
        Picasso picasso3 = this.picasso;
        if (picasso3 != null && (l11 = picasso3.l(str)) != null && (m11 = l11.m(dimensionPixelSize, dimensionPixelSize)) != null) {
            m11.g(this.ivPreview);
        }
    }

    public int[] onCreateDrawableState(int i11) {
        return View.mergeDrawableStates(super.onCreateDrawableState(i11 + 1), this.stepState != null ? SNSStepViewExtensionsKt.getSnsStepStateDrawable(this) : new int[]{R.attr.sns_stateInit});
    }

    public final void setEndIcon(Drawable drawable) {
        ImageView imageView = this.ivEndIcon;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            imageView.setVisibility(drawable != null ? 0 : 8);
        }
    }

    public final void setEndIconClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.ivEndIcon;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setProgressVisibility(boolean z11) {
        View view = this.endProgressBar;
        int i11 = 0;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
        ImageView imageView = this.ivEndIcon;
        if (imageView != null) {
            if (!(!z11)) {
                i11 = 8;
            }
            imageView.setVisibility(i11);
        }
    }

    public void setSNSStepState(SNSStepState sNSStepState) {
        if (sNSStepState != this.stepState) {
            this.stepState = sNSStepState;
            getBackground().setState(SNSStepViewExtensionsKt.getSnsStepStateDrawable(this));
            refreshDrawableState();
        }
    }

    public final void setStartIcon(Drawable drawable) {
        ImageView imageView = this.ivStartIcon;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setText(CharSequence charSequence) {
        TextView textView = this.tvText;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public SNSFileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSFileItemView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFileItemView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_fileItemViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSFileItemView : i12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSFileItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        Integer a11;
        float f11;
        Context context2 = context;
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build();
        this.shapeAppearanceModel = build;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        this.boxBackground = materialShapeDrawable;
        this.picasso = b.a(context);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SNSFileItemView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSFileItemView_sns_fileItemViewLayout, R.layout.sns_layout_questionnaire_file), this, true);
        this.endProgressBar = findViewById(R.id.sns_progress_bar);
        ImageView imageView = (ImageView) findViewById(R.id.sns_end_icon);
        this.ivEndIcon = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.sns_start_icon);
        this.ivStartIcon = imageView2;
        TextView textView = (TextView) findViewById(R.id.sns_text);
        this.tvText = textView;
        ImageView imageView3 = (ImageView) findViewById(R.id.sns_image);
        this.ivPreview = imageView3;
        int i13 = R.styleable.SNSFileItemView_sns_startIconTint;
        if (obtainStyledAttributes.hasValue(i13) && imageView2 != null) {
            imageView2.setImageTintList(i.a(obtainStyledAttributes, context2, i13));
        }
        int i14 = R.styleable.SNSFileItemView_sns_endIconTint;
        if (obtainStyledAttributes.hasValue(i14) && imageView != null) {
            imageView.setImageTintList(i.a(obtainStyledAttributes, context2, i14));
        }
        int i15 = R.styleable.SNSFileItemView_android_textColor;
        if (obtainStyledAttributes.hasValue(i15) && textView != null) {
            textView.setTextColor(i.a(obtainStyledAttributes, context2, i15));
        }
        int i16 = R.styleable.SNSFileItemView_boxBackgroundColor;
        if (obtainStyledAttributes.hasValue(i16)) {
            materialShapeDrawable.setFillColor(i.a(obtainStyledAttributes, context2, i16));
        }
        int i17 = R.styleable.SNSFileItemView_boxStrokeColor;
        if (obtainStyledAttributes.hasValue(i17)) {
            materialShapeDrawable.setStrokeColor(i.a(obtainStyledAttributes, context2, i17));
        }
        int i18 = R.styleable.SNSFileItemView_boxStrokeWidth;
        if (obtainStyledAttributes.hasValue(i18)) {
            materialShapeDrawable.setStrokeWidth(obtainStyledAttributes.getDimension(i18, 0.0f));
        }
        int i19 = R.styleable.SNSFileItemView_background;
        setBackground(obtainStyledAttributes.hasValue(i19) ? obtainStyledAttributes.getDrawable(i19) : materialShapeDrawable);
        int i21 = R.styleable.SNSFileItemView_previewCornerRadius;
        if (obtainStyledAttributes.hasValue(i21)) {
            ShapeableImageView shapeableImageView = imageView3 instanceof ShapeableImageView ? (ShapeableImageView) imageView3 : null;
            if (shapeableImageView != null) {
                shapeableImageView.setShapeAppearanceModel(new ShapeAppearanceModel.Builder().setAllCornerSizes(obtainStyledAttributes.getDimension(i21, 0.0f)).build());
            }
        }
        obtainStyledAttributes.recycle();
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        d a12 = aVar.a();
        if (a12 != null) {
            Integer a13 = aVar.a((View) this, SNSColorElement.FIELD_BACKGROUND);
            Integer a14 = aVar.a((View) this, SNSColorElement.FIELD_BACKGROUND_INVALID);
            a14 = a14 == null ? aVar.a((View) this, SNSColorElement.BACKGROUND_CRITICAL) : a14;
            Integer a15 = aVar.a((View) this, SNSColorElement.CONTENT_WEAK);
            Float a16 = aVar.a(a12, SNSMetricElement.FIELD_CORNER_RADIUS);
            if (!(a13 == null && a15 == null && a16 == null)) {
                int[][] iArr = {new int[]{R.attr.sns_stateInit}, new int[]{R.attr.sns_stateRejected}, new int[0]};
                int a17 = i.a(context2, 16842801);
                int a18 = i.a(context2, R.attr.sns_colorRejected);
                GradientDrawable gradientDrawable = new GradientDrawable();
                setBackground(gradientDrawable);
                int[] iArr2 = new int[3];
                iArr2[0] = a13 != null ? a13.intValue() : a17;
                iArr2[1] = a14 != null ? a14.intValue() : a18;
                iArr2[2] = a13 != null ? a13.intValue() : a17;
                gradientDrawable.setColor(new ColorStateList(iArr, iArr2));
                if (a16 != null) {
                    f11 = a16.floatValue();
                } else {
                    f11 = (float) context.getResources().getDimensionPixelSize(R.dimen.sns_file_attachment_corner_radius);
                }
                gradientDrawable.setCornerRadius(f11);
                if (a15 != null) {
                    int a19 = i.a(1);
                    float a21 = (float) i.a(4);
                    gradientDrawable.setStroke(a19, ColorStateList.valueOf(a15.intValue()), a21, a21);
                }
            }
            if (a15 != null) {
                int intValue = a15.intValue();
                if (imageView2 != null) {
                    imageView2.setImageTintList(ColorStateList.valueOf(intValue));
                }
            }
            SNSColorElement sNSColorElement = SNSColorElement.CONTENT_LINK;
            d a22 = aVar.a();
            if (a22 != null && (a11 = aVar.a(a22, sNSColorElement, aVar.a((View) this))) != null) {
                int intValue2 = a11.intValue();
                if (textView != null) {
                    textView.setTextColor(intValue2);
                }
            }
        }
    }
}
