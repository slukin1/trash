package com.huobi.otc.enums;

public class OtcRunMode {

    public enum Balance {
        RUB_BALANCE(9),
        EUR_BALANCE(11),
        GBP_BALANCE(13),
        NO_BOTTOM_WAREHOUSE(29),
        SMALL_COIN_BALANCE(16),
        BRL_BALANCE(19),
        KZT_BALANCE(15),
        UAH_BALANCE(14),
        TRY_BALANCE(22);
        
        public int code;

        private Balance(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum BlockTrade {
        BLOCK_TRADE_RUN_MODE(24);
        
        public int code;

        private BlockTrade(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum C2C {
        HBC2C(1),
        HBC2C_HK(2);
        
        public int code;

        private C2C(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum Card {
        BIND_CARD(5);
        
        public int code;

        private Card(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum CardThird {
        SIMPLEX_THIRD(4);
        
        public int code;

        private CardThird(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum Exchange {
        EXCHANGE(3),
        EXCHANGE_NO_BOTTOM(17);
        
        public int code;

        private Exchange(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum Third {
        NEOFI_THIRD(21);
        
        public int code;

        private Third(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }
}
