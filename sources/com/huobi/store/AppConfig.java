package com.huobi.store;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class AppConfig implements Serializable {
    private static final long serialVersionUID = 4785565284094642289L;
    public BusinessLine data;
    public int number;

    public BusinessLine getLine() {
        return this.data;
    }

    public int getNumber() {
        return this.number;
    }

    public void setLine(BusinessLine businessLine) {
        this.data = businessLine;
    }

    public void setNumber(int i11) {
        this.number = i11;
    }

    public String toString() {
        return GsonHelper.a().toJson((Object) this);
    }
}
