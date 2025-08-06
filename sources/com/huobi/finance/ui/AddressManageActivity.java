package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;

public class AddressManageActivity extends AbsDwActivity {
    public static void xj(Context context) {
        context.startActivity(new Intent(context, AddressManageActivity.class));
    }

    public String Nh() {
        return "withdraw_address_manage";
    }
}
