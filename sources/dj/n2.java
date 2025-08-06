package dj;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.contract.ui.ContractTradeTogetherView;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class n2 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTogetherView f53721a;

    public /* synthetic */ n2(ContractTradeTogetherView contractTradeTogetherView) {
        this.f53721a = contractTradeTogetherView;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        this.f53721a.h2(dialogFragment, view);
    }
}
