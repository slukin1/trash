package ts;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.swap.ui.SwapTradeTogetherView;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class g2 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeTogetherView f60358a;

    public /* synthetic */ g2(SwapTradeTogetherView swapTradeTogetherView) {
        this.f60358a = swapTradeTogetherView;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        this.f60358a.p2(dialogFragment, view);
    }
}
