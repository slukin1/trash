package ts;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.swap.ui.SwapTradeView;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class l3 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60386a;

    public /* synthetic */ l3(SwapTradeView swapTradeView) {
        this.f60386a = swapTradeView;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        this.f60386a.s2(dialogFragment, view);
    }
}
