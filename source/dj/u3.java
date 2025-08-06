package dj;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.contract.ui.ContractTradeView;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class u3 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContractTradeView f53766a;

    public /* synthetic */ u3(ContractTradeView contractTradeView) {
        this.f53766a = contractTradeView;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        this.f53766a.v2(dialogFragment, view);
    }
}
