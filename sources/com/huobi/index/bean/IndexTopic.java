package com.huobi.index.bean;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import java.io.Serializable;
import java.util.List;

public class IndexTopic implements Serializable {
    public List<NewFeed.TopicItem> topics;
}
