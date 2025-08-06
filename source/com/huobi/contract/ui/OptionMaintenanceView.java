package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.contract.entity.ContractHeartBeat;

public class OptionMaintenanceView extends AbstractMaintenanceView {
    public OptionMaintenanceView(Context context) {
        super(context);
    }

    public long g(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.getOptionEstimatedRecoveryTime();
    }

    public boolean i(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.isOptionSafeguard();
    }

    public OptionMaintenanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OptionMaintenanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
