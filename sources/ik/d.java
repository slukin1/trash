package ik;

import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.view.BottomAlterCostDialogFragment;

public final /* synthetic */ class d implements BottomAlterCostDialogFragment.DialogCloseCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f55108a;

    public /* synthetic */ d(AbilityFunction.a aVar) {
        this.f55108a = aVar;
    }

    public final void onDialogClose(String str) {
        this.f55108a.a(true, (Object) null);
    }
}
