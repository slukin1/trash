package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.core.view.e0;
import androidx.core.widget.p;

public class AppCompatImageButton extends ImageButton implements e0, p {
    private final c mBackgroundTintHelper;
    private boolean mHasLevel;
    private final i mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.b();
        }
        i iVar = this.mImageHelper;
        if (iVar != null) {
            iVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        i iVar = this.mImageHelper;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        i iVar = this.mImageHelper;
        if (iVar != null) {
            return iVar.e();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.f() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        i iVar = this.mImageHelper;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        i iVar = this.mImageHelper;
        if (!(iVar == null || drawable == null || this.mHasLevel)) {
            iVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        i iVar2 = this.mImageHelper;
        if (iVar2 != null) {
            iVar2.c();
            if (!this.mHasLevel) {
                this.mImageHelper.b();
            }
        }
    }

    public void setImageLevel(int i11) {
        super.setImageLevel(i11);
        this.mHasLevel = true;
    }

    public void setImageResource(int i11) {
        this.mImageHelper.i(i11);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        i iVar = this.mImageHelper;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        i iVar = this.mImageHelper;
        if (iVar != null) {
            iVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        i iVar = this.mImageHelper;
        if (iVar != null) {
            iVar.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        this.mHasLevel = false;
        z.a(this, getContext());
        c cVar = new c(this);
        this.mBackgroundTintHelper = cVar;
        cVar.e(attributeSet, i11);
        i iVar = new i(this);
        this.mImageHelper = iVar;
        iVar.g(attributeSet, i11);
    }
}
