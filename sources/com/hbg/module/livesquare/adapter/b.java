package com.hbg.module.livesquare.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import he.c;
import lc.c5;

public final class b extends c<String, c.a<c5>> {
    public b(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /* renamed from: k */
    public void onBindViewHolder(c.a<c5> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        String str = (String) g().get(i11);
        if (i11 == 0) {
            aVar.e().C.setVisibility(0);
            aVar.e().B.setVisibility(8);
            aVar.e().C.setText(str);
            return;
        }
        aVar.e().C.setVisibility(8);
        aVar.e().B.setVisibility(0);
        com.hbg.module.libkt.base.ext.b.L(aVar.e().B, str, 0.0f);
    }

    /* renamed from: l */
    public c.a<c5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(c5.K(h(), viewGroup, false));
    }
}
