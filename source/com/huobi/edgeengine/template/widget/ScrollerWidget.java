package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;
import rj.n;
import yj.g;

public class ScrollerWidget extends NodeSequenceWidget {

    /* renamed from: k0  reason: collision with root package name */
    public String f44099k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44100l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44101m0;

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            View findViewWithTag;
            if (((view instanceof HorizontalScrollView) || (view instanceof NestedScrollView)) && (findViewWithTag = view.findViewWithTag(str)) != null) {
                view.postDelayed(new g(view, findViewWithTag), 100);
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44099k0 = map.get("orientation");
        this.f44100l0 = map.get("scrollbars");
        this.f44101m0 = map.get("scrollToTag");
    }

    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        ViewGroup b02 = super.Q(context, nVar);
        c0(b02, this.f44094j0);
        w(context, this.f44101m0, new a(b02), nVar);
        return b02;
    }

    /* renamed from: d0 */
    public ViewGroup q(Context context) {
        boolean equals = "yes".equals(this.f44100l0);
        if (MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL.equals(this.f44099k0)) {
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
            horizontalScrollView.setHorizontalScrollBarEnabled(equals);
            return horizontalScrollView;
        }
        NestedScrollView nestedScrollView = new NestedScrollView(context);
        nestedScrollView.setVerticalScrollBarEnabled(equals);
        return nestedScrollView;
    }
}
