package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.contract.entity.ContractHeartBeat;

public class ContractMaintenanceView extends AbstractMaintenanceView {
    public ContractMaintenanceView(Context context) {
        super(context);
    }

    public long g(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.getTime();
    }

    public boolean i(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.isSysSafeguard();
    }

    public ContractMaintenanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContractMaintenanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
