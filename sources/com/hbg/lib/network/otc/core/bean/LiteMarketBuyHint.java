package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class LiteMarketBuyHint implements Serializable {
    private String content;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteMarketBuyHint;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteMarketBuyHint)) {
            return false;
        }
        LiteMarketBuyHint liteMarketBuyHint = (LiteMarketBuyHint) obj;
        if (!liteMarketBuyHint.canEqual(this) || getType() != liteMarketBuyHint.getType()) {
            return false;
        }
        String content2 = getContent();
        String content3 = liteMarketBuyHint.getContent();
        return content2 != null ? content2.equals(content3) : content3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String content2 = getContent();
        return ((getType() + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "LiteMarketBuyHint(type=" + getType() + ", content=" + getContent() + ")";
    }
}
