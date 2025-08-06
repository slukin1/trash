package com.huochat.community.enums;

import kotlin.jvm.internal.r;

public enum SymbolParamType {
    SYMBOL(1, "交易对，eg. BTCUSDT"),
    BASE_CURRENCY(2, "基础币种(左币)，eg. BTC");
    
    public static final Companion Companion = null;
    private String desc;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final SymbolParamType getType(int i11) {
            for (SymbolParamType symbolParamType : SymbolParamType.values()) {
                if (symbolParamType.getType() == i11) {
                    return symbolParamType;
                }
            }
            return SymbolParamType.SYMBOL;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private SymbolParamType(int i11, String str) {
        this.type = i11;
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getType() {
        return this.type;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }
}
