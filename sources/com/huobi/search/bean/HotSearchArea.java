package com.huobi.search.bean;

import com.huobi.search.viewhandler.HotSearchAreaHandler;
import java.io.Serializable;
import s9.a;

public class HotSearchArea implements a, Serializable {
    private static final long serialVersionUID = 130677528478714907L;

    public String getViewHandlerName() {
        return HotSearchAreaHandler.class.getName();
    }
}
