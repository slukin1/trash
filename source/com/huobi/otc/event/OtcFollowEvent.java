package com.huobi.otc.event;

import java.io.Serializable;
import java.util.Map;

public class OtcFollowEvent implements Serializable {
    public Object object;
    public Map<String, String> params;
}
