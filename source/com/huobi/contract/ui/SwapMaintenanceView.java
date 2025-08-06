package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.contract.entity.ContractHeartBeat;

public class SwapMaintenanceView extends AbstractMaintenanceView {
    public SwapMaintenanceView(Context context) {
        super(context);
    }

    public long g(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.getSwapEstimatedRecoveryTime();
    }

    public boolean i(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.isSwapSafeguard();
    }

    public SwapMaintenanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwapMaintenanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
