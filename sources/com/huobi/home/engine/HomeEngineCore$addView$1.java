package com.huobi.home.engine;

import android.util.Log;
import android.view.View;
import com.huobi.home.ui.HomeModuleBaseView;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import rj.b;

public final class HomeEngineCore$addView$1 extends Lambda implements p<View, Boolean, Unit> {
    public final /* synthetic */ HomeModuleBaseView $homeModuleView;
    public final /* synthetic */ b $mEdgeEngine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeEngineCore$addView$1(HomeModuleBaseView homeModuleBaseView, b bVar) {
        super(2);
        this.$homeModuleView = homeModuleBaseView;
        this.$mEdgeEngine = bVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, ((Boolean) obj2).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(View view, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        HomeModuleBaseView homeModuleBaseView = this.$homeModuleView;
        String str = null;
        sb2.append(homeModuleBaseView != null ? homeModuleBaseView.getModuleName() : null);
        sb2.append(" :[view(balance), isVisible(");
        sb2.append(z11);
        sb2.append(")]");
        Log.d("Console", sb2.toString());
        if (z11) {
            b bVar = this.$mEdgeEngine;
            if (bVar != null) {
                StringBuilder sb3 = new StringBuilder();
                HomeModuleBaseView homeModuleBaseView2 = this.$homeModuleView;
                if (homeModuleBaseView2 != null) {
                    str = homeModuleBaseView2.getModuleName();
                }
                sb3.append(str);
                sb3.append(".moduleAppear()");
                bVar.I(sb3.toString());
                return;
            }
            return;
        }
        b bVar2 = this.$mEdgeEngine;
        if (bVar2 != null) {
            StringBuilder sb4 = new StringBuilder();
            HomeModuleBaseView homeModuleBaseView3 = this.$homeModuleView;
            if (homeModuleBaseView3 != null) {
                str = homeModuleBaseView3.getModuleName();
            }
            sb4.append(str);
            sb4.append(".moduleDisappear()");
            bVar2.I(sb4.toString());
        }
    }
}
