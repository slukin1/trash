package com.huobi.copytrading.engine;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import com.xiaomi.mipush.sdk.Constants;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import oa.a;
import rj.b;

@d(c = "com.huobi.copytrading.engine.CopytradingNativeAbility$call$1$1", f = "CopytradingNativeAbility.kt", l = {}, m = "invokeSuspend")
public final class CopytradingNativeAbility$call$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ b $edgeEngine;
    public final /* synthetic */ String $symbolList;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopytradingNativeAbility$call$1$1(String str, b bVar, c<? super CopytradingNativeAbility$call$1$1> cVar) {
        super(2, cVar);
        this.$symbolList = str;
        this.$edgeEngine = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CopytradingNativeAbility$call$1$1(this.$symbolList, this.$edgeEngine, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((CopytradingNativeAbility$call$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            List L0 = StringsKt__StringsKt.L0(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(this.$symbolList, "\"", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null), new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
            SymbolSelectionFragment symbolSelectionFragment = new SymbolSelectionFragment();
            symbolSelectionFragment.Lh(L0);
            symbolSelectionFragment.Mh(this.$edgeEngine);
            symbolSelectionFragment.Oh(((FragmentActivity) a.g().b()).getSupportFragmentManager(), "copyTrading", TradeType.COPY_TRADING);
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
