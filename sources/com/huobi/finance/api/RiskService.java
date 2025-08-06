package com.huobi.finance.api;

import com.hbg.lib.core.network.response.RiskIntCodeResponse;
import com.huobi.finance.bean.ExamInfo;
import com.huobi.finance.bean.TsvMsg;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RiskService {
    @POST("examination/withdraw_front_msg")
    Observable<RiskIntCodeResponse<ExamInfo>> getTsvExamMsg(@Body Map<String, Object> map);

    @POST("api/x/tsv/get_tsv_msg")
    Observable<RiskIntCodeResponse<TsvMsg>> getTsvMsg(@Body Map<String, Object> map);

    @POST("api/x/tsv/resend_tsv_message")
    Observable<RiskIntCodeResponse<Object>> resendTsvMessage(@Body Map<String, Object> map);
}
