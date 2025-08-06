package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.h;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.ImageElementName;
import com.sumsub.sns.internal.core.theme.b;
import com.sumsub.sns.internal.core.theme.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSToolbarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "closeButton", "Landroid/widget/ImageButton;", "getCloseButton", "()Landroid/widget/ImageButton;", "optionButton", "getOptionButton", "setCloseButtonDrawable", "", "icon", "Landroid/graphics/drawable/Drawable;", "setIconTintList", "colorStateList", "Landroid/content/res/ColorStateList;", "setOnCloseButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnOptionButtonClickListener", "setOptionButtonDrawable", "setOptionButtonVisible", "visible", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SNSToolbarView extends ConstraintLayout {
    public SNSToolbarView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final ImageButton getCloseButton() {
        return (ImageButton) findViewById(R.id.sns_button_close);
    }

    private final ImageButton getOptionButton() {
        return (ImageButton) findViewById(R.id.sns_button_option);
    }

    public final void setCloseButtonDrawable(Drawable drawable) {
        ImageButton closeButton = getCloseButton();
        if (closeButton != null) {
            closeButton.setImageDrawable(drawable);
        }
    }

    public final void setIconTintList(ColorStateList colorStateList) {
        ImageButton closeButton = getCloseButton();
        if (closeButton != null) {
            h.c(closeButton, colorStateList);
        }
        ImageButton optionButton = getOptionButton();
        if (optionButton != null) {
            h.c(optionButton, colorStateList);
        }
    }

    public final void setOnCloseButtonClickListener(View.OnClickListener onClickListener) {
        ImageButton closeButton = getCloseButton();
        if (closeButton != null) {
            closeButton.setOnClickListener(onClickListener);
        }
    }

    public final void setOnOptionButtonClickListener(View.OnClickListener onClickListener) {
        ImageButton optionButton = getOptionButton();
        if (optionButton != null) {
            optionButton.setOnClickListener(onClickListener);
        }
    }

    public final void setOptionButtonDrawable(Drawable drawable) {
        ImageButton optionButton = getOptionButton();
        if (optionButton != null) {
            optionButton.setImageDrawable(drawable);
        }
    }

    public final void setOptionButtonVisible(boolean z11) {
        ImageButton optionButton = getOptionButton();
        if (optionButton != null) {
            optionButton.setVisibility(z11 ? 0 : 8);
        }
    }

    public SNSToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSToolbarView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSToolbarView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_ToolbarViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSToolbarView : i12);
    }

    public SNSToolbarView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        Integer a11;
        Bitmap e11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSToolbarView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSToolbarView_sns_toolbarViewLayout, 0), this, true);
        int i13 = R.styleable.SNSToolbarView_sns_toolbarIconTint;
        if (obtainStyledAttributes.hasValue(i13)) {
            setIconTintList(i.a(obtainStyledAttributes, context, i13));
        }
        int i14 = R.styleable.SNSToolbarView_sns_iconClose;
        if (obtainStyledAttributes.hasValue(i14)) {
            setCloseButtonDrawable(obtainStyledAttributes.getDrawable(i14));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        d a12 = aVar.a();
        if (a12 != null) {
            Map<String, b> b11 = a12.b();
            b.c cVar = null;
            b bVar = b11 != null ? b11.get(ImageElementName.ICON_CLOSE.getValue()) : null;
            cVar = bVar instanceof b.c ? (b.c) bVar : cVar;
            if (!(cVar == null || (e11 = cVar.e()) == null)) {
                setCloseButtonDrawable(new BitmapDrawable(e11));
            }
            SNSColorElement sNSColorElement = SNSColorElement.NAVIGATION_BAR_ITEM;
            d a13 = aVar.a();
            if (a13 != null && (a11 = aVar.a(a13, sNSColorElement, aVar.a((View) this))) != null) {
                setIconTintList(ColorStateList.valueOf(a11.intValue()));
            }
        }
    }
}
