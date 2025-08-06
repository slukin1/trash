package com.sumsub.sns.core.widget.pincode;

import android.view.ActionMode;
import android.view.Menu;
import com.sumsub.sns.core.widget.pincode.SNSPinView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/sumsub/sns/core/widget/pincode/SNSPinView$disableSelectionMenu$1", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView$DefaultActionModeCallback;", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSPinView$disableSelectionMenu$1 extends SNSPinView.DefaultActionModeCallback {
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        menu.removeItem(16908355);
        return true;
    }
}
