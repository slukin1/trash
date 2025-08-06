package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import rj.n;

public class LinearWidget extends NodeSequenceWidget {

    /* renamed from: k0  reason: collision with root package name */
    public String f44086k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44087l0;

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44086k0 = map.get("orientation");
        this.f44087l0 = map.get("layoutMode");
    }

    public void Z(ViewGroup viewGroup, NodeSequence nodeSequence) {
        int i11;
        int i12;
        ViewGroup viewGroup2 = viewGroup;
        viewGroup.removeAllViews();
        Context context = viewGroup.getContext();
        boolean equals = "vertical".equals(this.f44086k0);
        boolean equals2 = "equalSpacing".equals(this.f44087l0);
        boolean equals3 = "fillEqually".equals(this.f44087l0);
        for (Pair next : nodeSequence.g()) {
            View Q = ((Widget) next.first).Q(context, (n) next.second);
            int i13 = 0;
            boolean z11 = Q.getVisibility() == 0 && equals2;
            int i14 = -1;
            if (z11) {
                if (equals) {
                    i11 = 0;
                    i12 = -1;
                } else {
                    i12 = 0;
                    i11 = -1;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i11);
                layoutParams.weight = 1.0f;
                Space space = new Space(context);
                space.setLayoutParams(layoutParams);
                viewGroup2.addView(space);
            } else if (equals3) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Q.getLayoutParams());
                if (equals) {
                    layoutParams2.height = 0;
                } else {
                    layoutParams2.width = 0;
                }
                layoutParams2.weight = 1.0f;
                Q.setLayoutParams(layoutParams2);
            } else if (((Widget) next.first).S > 0.0f) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) Q.getLayoutParams());
                layoutParams3.weight = ((Widget) next.first).S;
                Q.setLayoutParams(layoutParams3);
            }
            if (((Widget) next.first).G != 0) {
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) Q.getLayoutParams());
                layoutParams4.gravity = ((Widget) next.first).G;
                Q.setLayoutParams(layoutParams4);
            }
            viewGroup2.addView(Q);
            if (z11) {
                if (equals) {
                    i14 = 0;
                    i13 = -1;
                }
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i13, i14);
                layoutParams5.weight = 1.0f;
                Space space2 = new Space(context);
                space2.setLayoutParams(layoutParams5);
                viewGroup2.addView(space2);
            }
        }
    }

    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        int i11;
        LinearLayout linearLayout = (LinearLayout) super.Q(context, nVar);
        if ("vertical".equals(this.f44086k0)) {
            linearLayout.setOrientation(1);
        } else {
            linearLayout.setOrientation(0);
        }
        c0(linearLayout, this.f44094j0);
        if (!TextUtils.isEmpty(this.E)) {
            int i12 = 0;
            for (String str : this.E.split("\\|")) {
                if (TtmlNode.CENTER.equals(str)) {
                    i12 |= 17;
                } else if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(str)) {
                    i12 |= 48;
                } else if ("bottom".equals(str)) {
                    i12 |= 80;
                } else if ("left".equals(str)) {
                    i12 |= 3;
                } else if (TtmlNode.RIGHT.equals(str)) {
                    i12 |= 5;
                } else if ("centerVertical".equals(str)) {
                    i12 |= 16;
                } else if ("centerHorizontal".equals(str)) {
                    i12 |= 1;
                } else {
                    if ("start".equals(str)) {
                        i11 = 8388611;
                    } else if ("end".equals(str)) {
                        i11 = 8388613;
                    }
                    i12 |= i11;
                }
            }
            if (i12 != 0) {
                linearLayout.setGravity(i12);
            }
        }
        return linearLayout;
    }

    public View q(Context context) {
        return new LinearLayout(context);
    }
}
