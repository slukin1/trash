package com.sumsub.sns.internal.core.common;

import android.content.res.Resources;
import com.sumsub.sns.internal.log.a;
import com.sumsub.sns.internal.log.c;
import java.lang.ref.WeakReference;

public final class y0 extends Resources {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<x0> f32321a;

    public y0(Resources resources, WeakReference<x0> weakReference) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f32321a = weakReference;
    }

    public CharSequence getText(int i11) throws Resources.NotFoundException {
        String resourceEntryName = super.getResourceEntryName(i11);
        x0 x0Var = this.f32321a.get();
        CharSequence a11 = x0Var != null ? x0Var.a(resourceEntryName) : null;
        if (a11 != null) {
            return a11;
        }
        CharSequence text = super.getText(i11);
        a aVar = a.f34862a;
        String a12 = c.a(this);
        com.sumsub.log.logger.a.b(aVar, a12, "StringResources.getText for " + resourceEntryName + " = " + super.getText(i11) + " is not found", (Throwable) null, 4, (Object) null);
        return text;
    }

    public CharSequence getText(int i11, CharSequence charSequence) {
        String resourceEntryName = super.getResourceEntryName(i11);
        x0 x0Var = this.f32321a.get();
        CharSequence a11 = x0Var != null ? x0Var.a(resourceEntryName) : null;
        if (a11 != null) {
            return a11;
        }
        CharSequence text = super.getText(i11, charSequence);
        a aVar = a.f34862a;
        String a12 = c.a(this);
        com.sumsub.log.logger.a.b(aVar, a12, "StringResources.getText with def=" + charSequence + " for " + resourceEntryName + " = " + super.getText(i11) + " is not found", (Throwable) null, 4, (Object) null);
        return text;
    }
}
