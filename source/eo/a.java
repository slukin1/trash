package eo;

import com.alibaba.fastjson.JSONObject;
import com.huobi.main.trade.ui.SymbolSelectionAbility;
import com.huobi.main.trade.ui.SymbolSelectionFragment;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONObject f54361b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SymbolSelectionFragment f54362c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54363d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f54364e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f54365f;

    public /* synthetic */ a(JSONObject jSONObject, SymbolSelectionFragment symbolSelectionFragment, String str, boolean z11, String str2) {
        this.f54361b = jSONObject;
        this.f54362c = symbolSelectionFragment;
        this.f54363d = str;
        this.f54364e = z11;
        this.f54365f = str2;
    }

    public final void run() {
        SymbolSelectionAbility.e(this.f54361b, this.f54362c, this.f54363d, this.f54364e, this.f54365f);
    }
}
