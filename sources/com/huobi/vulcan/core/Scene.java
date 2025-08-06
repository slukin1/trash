package com.huobi.vulcan.core;

import com.google.common.math.DoubleMath;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.android.tpush.common.Constants;

public enum Scene {
    None("none", -1),
    Init(ZendeskBlipsProvider.ACTION_CORE_INIT, 0),
    Register(Constants.SHARED_PREFS_KEY_REGISTER, 100),
    Login(FirebaseAnalytics.Event.LOGIN, 110),
    OrderSpot("order_spot", 120),
    OrderLoan("order_loan", 121),
    OrderDm("order_dm", 122),
    OtcOrder("otc_order", 123),
    Withdraw("withdraw", 130),
    Transfer("transfer", 140),
    GlobalBasicAuth("global_basic_auth", 150),
    OtcBasicAuth("otc_basic_auth", 151),
    OtcAdvanceAuth("otc_advance_auth", 152),
    PasswordChange("password_change", 160),
    GAGen("ga_gen", 161),
    GAChange("ga_change", 162),
    SubAccountGen("subaccount_gen", 163),
    SubAccountLock("subaccount_lock", 164),
    SubAccountDel("subaccount_del", 165),
    ApiGen("api_gen", DoubleMath.MAX_FACTORIAL),
    ApiDel("api_del", 171),
    RedPocket("redpocket", 180),
    FlashExchage("flash_exchage", 181),
    IMAssetPasswordSet("im_asset_password_set", 182),
    IMAssetPasswordChange("im_asset_password_change", 183);
    
    public String key;
    public int val;

    private Scene(String str, int i11) {
        this.key = str;
        this.val = i11;
    }

    public static boolean isInit(int i11) {
        return i11 == Init.val;
    }

    @Deprecated
    public static Scene valueOF(int i11) {
        for (Scene scene : values()) {
            if (scene.val == i11) {
                return scene;
            }
        }
        return null;
    }

    public int getVal() {
        return this.val;
    }
}
