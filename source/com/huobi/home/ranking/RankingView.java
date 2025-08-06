package com.huobi.home.ranking;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import y9.b;

public final class RankingView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final String f72513b = "SP_KEY_NEW_OLD_SELECT";

    /* renamed from: c  reason: collision with root package name */
    public boolean f72514c = true;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f72515d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<RankingFragment> f72516e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Integer, Integer> f72517f = new HashMap<>();

    public RankingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.home_module_ranking_view, this);
    }

    public RankingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
