package com.huobi.tradingbot.bean;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class BotDetailTabInfo implements Serializable {

    /* renamed from: js  reason: collision with root package name */
    private final String f83571js;
    private final String xml;

    public BotDetailTabInfo(String str, String str2) {
        this.f83571js = str;
        this.xml = str2;
    }

    public static /* synthetic */ BotDetailTabInfo copy$default(BotDetailTabInfo botDetailTabInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = botDetailTabInfo.f83571js;
        }
        if ((i11 & 2) != 0) {
            str2 = botDetailTabInfo.xml;
        }
        return botDetailTabInfo.copy(str, str2);
    }

    public final String component1() {
        return this.f83571js;
    }

    public final String component2() {
        return this.xml;
    }

    public final BotDetailTabInfo copy(String str, String str2) {
        return new BotDetailTabInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BotDetailTabInfo)) {
            return false;
        }
        BotDetailTabInfo botDetailTabInfo = (BotDetailTabInfo) obj;
        return x.b(this.f83571js, botDetailTabInfo.f83571js) && x.b(this.xml, botDetailTabInfo.xml);
    }

    public final String getJs() {
        return this.f83571js;
    }

    public final String getXml() {
        return this.xml;
    }

    public int hashCode() {
        String str = this.f83571js;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.xml;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "BotDetailTabInfo(js=" + this.f83571js + ", xml=" + this.xml + ')';
    }
}
