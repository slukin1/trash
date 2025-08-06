package com.hbg.lib.network.linear.swap.core.bean;

import java.io.Serializable;

public class LinearSwapPositionModeQueryRespInfo implements Serializable {
    private int single_side;

    public boolean isPositionModeSingle() {
        return this.single_side == 1;
    }
}
