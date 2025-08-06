package com.hbg.lib.network.content.service;

import com.hbg.lib.network.content.core.bean.WorkOrderConfig;
import com.hbg.lib.network.content.response.MgtContentCodeResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface MgtContentService {
    @POST("v1/public/uc/login")
    Observable<MgtContentCodeResponse<String>> userLogin(@Body Map<String, Object> map);

    @GET("v1/public/workorder/config/get")
    Observable<MgtContentCodeResponse<WorkOrderConfig>> workOrderConfigGet();
}
