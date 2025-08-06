package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import rj.b;
import rj.n;

public class RootContainerWidget extends ContainerWidget {

    /* renamed from: i0  reason: collision with root package name */
    public Widget f44097i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44098j0;

    public View Q(Context context, n nVar) {
        ViewGroup viewGroup = (ViewGroup) super.Q(context, nVar);
        View Q = this.f44097i0.Q(context, nVar);
        viewGroup.addView(Q);
        ViewGroup.LayoutParams layoutParams = Q.getLayoutParams();
        int i11 = -2;
        int i12 = layoutParams.height == -1 ? -1 : -2;
        if (layoutParams.width == -1) {
            i11 = -1;
        }
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(i11, i12));
        return viewGroup;
    }

    public void Y(String str) {
        this.f44098j0 = str;
    }

    public void Z(Widget widget) {
        this.f44097i0 = widget;
    }

    public View q(Context context) {
        RootContainerView rootContainerView = new RootContainerView(context);
        rootContainerView.f44095b = this.f44098j0;
        rootContainerView.f44096c = this.f44154e0;
        if (b.i() != null) {
            b.i().a(this.f44152d0, rootContainerView);
        }
        return rootContainerView;
    }
}
