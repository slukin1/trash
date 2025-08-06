package com.huochat.community.util;

import com.huochat.community.R;

public class BadgeConfig {
    public static int getGroupCertBadgeLogo(int i11) {
        if (i11 == 1) {
            return R.drawable.ic_group_bofficial;
        }
        if (i11 == 2) {
            return R.drawable.ic_group_bofficial;
        }
        if (i11 != 3) {
            return -1;
        }
        return R.drawable.ic_group_bofficial;
    }

    public static int getUserAuthBadgeLogo(int i11) {
        if (i11 == 0) {
            return R.drawable.ic_vip_badge;
        }
        if (i11 == 1) {
            return R.drawable.ic_auth_golden;
        }
        if (i11 == 2) {
            return R.drawable.ic_auth_diamond;
        }
        if (i11 == 3) {
            return R.drawable.ic_auth_blackgold;
        }
        if (i11 == 4) {
            return R.drawable.ic_auth_fire;
        }
        if (i11 == 7) {
            return R.drawable.ic_customer_huobichat;
        }
        if (i11 != 8) {
            return 0;
        }
        return R.drawable.ic_customer_huobi;
    }

    public static String getUserAuthTypeStr(int i11, int i12) {
        if (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) {
            return "火币员工";
        }
        if (i11 == 2 || i11 == 3) {
            return i12 != 0 ? i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? i12 != 7 ? i12 != 8 ? "" : "火币客服" : "火信客服" : "火信小火苗" : "黑金V" : "钻石V" : "黄金V" : "火信认证";
        }
    }

    public static int getUserCrownLogo(int i11) {
        if (i11 == 0) {
            return R.drawable.ic_champ_cs;
        }
        if (i11 == 1) {
            return R.drawable.ic_champ_ky;
        }
        if (i11 == 2) {
            return R.drawable.ic_champ_zz;
        }
        if (i11 == 3) {
            return R.drawable.ic_champ_gz;
        }
        if (i11 != 4) {
            return 0;
        }
        return R.drawable.ic_champ_gold;
    }

    public static boolean isGroupCertification(int i11) {
        return i11 == 1 || i11 == 2 || i11 == 3;
    }

    public static boolean isPersonalCertification(int i11) {
        switch (i11) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }
}
