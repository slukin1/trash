package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.contract.entity.ContractHeartBeat;

public class LinearSwapMaintenanceView extends AbstractMaintenanceView {
    public LinearSwapMaintenanceView(Context context) {
        super(context);
    }

    public long g(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.getLinearSwapEstimatedRecoveryTime();
    }

    public boolean i(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.isLinearSwapSafeguard();
    }

    public LinearSwapMaintenanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearSwapMaintenanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
