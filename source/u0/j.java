package u0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

public final class j extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f16597a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable.ConstantState f16598b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f16599c = null;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f16600d = h.f16589h;

    public j(j jVar) {
        if (jVar != null) {
            this.f16597a = jVar.f16597a;
            this.f16598b = jVar.f16598b;
            this.f16599c = jVar.f16599c;
            this.f16600d = jVar.f16600d;
        }
    }

    public boolean a() {
        return this.f16598b != null;
    }

    public int getChangingConfigurations() {
        int i11 = this.f16597a;
        Drawable.ConstantState constantState = this.f16598b;
        return i11 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new i(this, resources);
        }
        return new h(this, resources);
    }
}
