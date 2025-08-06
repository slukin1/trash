package com.hbg.lib.network.uc.retrofit.service;

import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfigWrapper;
import com.hbg.lib.network.uc.retrofit.bean.MessageNoReadNum;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface MessageService {
    @POST("uc/open/letter/v3/list_by_code")
    Observable<UcIntCodeResponse<MessageNoReadNum>> getUCListByCode(@Body Map<String, Object> map);

    @POST("uc/open/proxy/mc/user/template_label/save")
    Observable<UcIntCodeResponse<String>> modifySwitchConfig(@Body Map<String, Object> map);

    @POST("uc/open/letter/v3/state/batch/read")
    Observable<UcIntCodeResponse<Integer>> requestClearReadNum(@Body Map<String, Object> map);

    @POST("uc/open/proxy/mc/user/unsub/label/list")
    Observable<UcIntCodeResponse<List<MessageConfigWrapper>>> requestSwitchConfig(@Body Map<String, Object> map);
}
