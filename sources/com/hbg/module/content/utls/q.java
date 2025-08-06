package com.hbg.module.content.utls;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.content.R$style;
import com.hbg.module.content.ui.activity.d;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.base.ext.c;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import rj.b;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f18949a = new q();

    public static /* synthetic */ PopupWindow d(q qVar, FragmentActivity fragmentActivity, View view, View view2, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return qVar.c(fragmentActivity, view, view2, z11);
    }

    public static final void e(FragmentActivity fragmentActivity) {
        f18949a.b(fragmentActivity, 1.0f);
    }

    public final void b(FragmentActivity fragmentActivity, float f11) {
        WindowManager.LayoutParams attributes = fragmentActivity.getWindow().getAttributes();
        attributes.alpha = f11;
        fragmentActivity.getWindow().setAttributes(attributes);
    }

    public final PopupWindow c(FragmentActivity fragmentActivity, View view, View view2, boolean z11) {
        if (view2 == null) {
            return null;
        }
        int i11 = R$style.RedpacketGrapWindowAnimation;
        if (z11) {
            i11 = R$style.GrapFullScreenAnimation;
        }
        d dVar = new d(fragmentActivity, view2, i11, !z11);
        dVar.setOnDismissListener(new p(fragmentActivity));
        dVar.showAtLocation(view, 17, 0, 0);
        return dVar;
    }

    public final void f(LiveDetailActivity liveDetailActivity, l lVar, ViewGroup viewGroup, View view) {
        b k11;
        b k12;
        HbgBaseProvider fg2 = liveDetailActivity.fg();
        if (fg2 != null && fg2.j(liveDetailActivity)) {
            if (!(lVar == null || (k12 = lVar.k()) == null)) {
                k12.I("redPacket.initWithLiveId(" + liveDetailActivity.Sj() + ')');
            }
            if (!liveDetailActivity.Qj()) {
                liveDetailActivity.Bl(true);
                View D = (lVar == null || (k11 = lVar.k()) == null) ? null : k11.D("send.xml", liveDetailActivity);
                float c11 = (((float) c.c()) * 456.0f) / 375.0f;
                if (D != null) {
                    D.setLayoutParams(new LinearLayout.LayoutParams(c.c(), (int) c11));
                }
                viewGroup.addView(D);
            }
            view.setVisibility(0);
        }
    }
}
