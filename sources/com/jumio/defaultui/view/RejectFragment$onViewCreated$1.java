package com.jumio.defaultui.view;

import androidx.activity.o;
import jumio.dui.b;

public final class RejectFragment$onViewCreated$1 extends o {
    public final /* synthetic */ RejectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RejectFragment$onViewCreated$1(RejectFragment rejectFragment) {
        super(true);
        this.this$0 = rejectFragment;
    }

    public void handleOnBackPressed() {
        if (this.this$0.getJumioViewModel().f56361i.getValue() == b.C0659b.REJECT) {
            this.this$0.retakeImage();
        }
    }
}
