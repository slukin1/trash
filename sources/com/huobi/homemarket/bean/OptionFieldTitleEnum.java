package com.huobi.homemarket.bean;

import com.hbg.module.market.R$string;

public enum OptionFieldTitleEnum {
    OPTION_FIELD_TITLE_1(R$string.n_option_market_execl_type, 0),
    OPTION_FIELD_TITLE_2(R$string.n_option_market_execl_buy_price, 1),
    OPTION_FIELD_TITLE_3(R$string.n_option_market_execl_mark_price, 2),
    OPTION_FIELD_TITLE_4(R$string.n_option_market_execl_implicit_fluctuate_rate, 3),
    OPTION_FIELD_TITLE_5(R$string.n_option_market_execl_sell_price, 4),
    OPTION_FIELD_TITLE_6(R$string.n_option_market_execl_Delta, 5),
    OPTION_FIELD_TITLE_7(R$string.n_option_market_list_setting_mulriple, 6),
    OPTION_FIELD_TITLE_8(R$string.n_option_market_list_setting_c_p, 7),
    OPTION_FIELD_TITLE_9(R$string.n_option_market_list_setting_position_volume, 8),
    OPTION_FIELD_TITLE_10(R$string.n_option_market_list_setting_24H_volume, 9),
    OPTION_FIELD_TITLE_11(R$string.n_option_market_list_setting_index_price, 10),
    OPTION_FIELD_TITLE_12(R$string.n_option_market_execl_deal_new_price, 11);
    
    private int index;
    private int titleRes;

    private OptionFieldTitleEnum(int i11, int i12) {
        this.titleRes = i11;
        this.index = i12;
    }

    public int getIndex() {
        return this.index;
    }

    public int getTitleRes() {
        return this.titleRes;
    }
}
