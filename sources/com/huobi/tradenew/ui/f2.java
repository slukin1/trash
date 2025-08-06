package com.huobi.tradenew.ui;

import android.view.View;
import com.cpiz.android.bubbleview.b;
import com.huobi.tradenew.ui.TradeSpotPopUtil;

public final /* synthetic */ class f2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeSpotPopUtil.c f83398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f83399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f83400d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f83401e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f83402f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ b f83403g;

    public /* synthetic */ f2(TradeSpotPopUtil.c cVar, String str, String str2, String str3, String str4, b bVar) {
        this.f83398b = cVar;
        this.f83399c = str;
        this.f83400d = str2;
        this.f83401e = str3;
        this.f83402f = str4;
        this.f83403g = bVar;
    }

    public final void onClick(View view) {
        TradeSpotPopUtil.f(this.f83398b, this.f83399c, this.f83400d, this.f83401e, this.f83402f, this.f83403g, view);
    }
}
