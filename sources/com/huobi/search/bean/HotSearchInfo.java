package com.huobi.search.bean;

import java.io.Serializable;
import java.util.List;

public class HotSearchInfo implements Serializable {
    private static final long serialVersionUID = -49062535169462131L;
    public List<String> currencyList;
    public HotWordContext hotWordContext;
    public List<String> hotWords;

    public class HotWordContext implements Serializable {
        public List<String> extra;
        public List<HotWord> hotWords;
        public String traceId;

        public class HotWord implements Serializable {
            public String extra;
            public String strategy;
            public String type;
            public String word;

            public HotWord() {
            }
        }

        public HotWordContext() {
        }
    }
}
