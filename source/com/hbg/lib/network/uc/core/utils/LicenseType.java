package com.hbg.lib.network.uc.core.utils;

public enum LicenseType {
    MARGIN("MARGIN"),
    MAIN_ZONE("MAIN_ZONE"),
    NEW_ZONE("NEW_ZONE"),
    PRO_ZONE("PRO_ZONE"),
    FORK_ZONE("FORK_ZONE"),
    PRO_POINT("PRO_POINT"),
    PRO_POINT_TRANSFER("PRO_POINT_TRANSFER"),
    SUPER_MARGIN("SUPER_MARGIN"),
    TR_KYC("TR_KYC"),
    WITHDRAWAL_RISK_NOTIFICATIONS("WITHDRAWAL_RISK_NOTIFICATIONS"),
    POTENTIALS("POTENTIALS"),
    HUO_PAY_AUTH("SIGN_AUTHORIZATION"),
    PIONEER("PIONEER"),
    GRID_TRADING("GRID_TRADING");
    
    public String type;

    private LicenseType(String str) {
        this.type = str;
    }
}
