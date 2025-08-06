package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import java.util.Map;

public class ARouter$$Root$$hbg_content implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("content", ARouter$$Group$$content.class);
        map.put(ChainInfo.CHAIN_TYPE_LIVE, ARouter$$Group$$live.class);
    }
}
