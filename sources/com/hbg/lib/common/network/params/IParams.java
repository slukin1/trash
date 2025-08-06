package com.hbg.lib.common.network.params;

import java.io.Serializable;
import java.util.Map;
import okhttp3.CacheControl;

public interface IParams extends Serializable {
    CacheControl getCacheControl();

    Map<String, Object> getHeaders();

    Map<String, Object> getParams();

    String getRequestBuilderClazz();

    Object getTag();

    String getUrl();
}
