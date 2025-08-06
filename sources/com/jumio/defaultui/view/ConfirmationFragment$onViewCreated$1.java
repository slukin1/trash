package com.jumio.defaultui.view;

import androidx.activity.o;
import jumio.dui.b;

public final class ConfirmationFragment$onViewCreated$1 extends o {
    public final /* synthetic */ ConfirmationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmationFragment$onViewCreated$1(ConfirmationFragment confirmationFragment) {
        super(true);
        this.this$0 = confirmationFragment;
    }

    public void handleOnBackPressed() {
        if (this.this$0.getJumioViewModel().f56361i.getValue() == b.C0659b.CONFIRMATION) {
            this.this$0.retakeImage();
        }
    }
}
