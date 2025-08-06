package com.huobi.invite.api;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.invite.bean.InviteRecordListItem;
import com.huobi.invite.bean.InviterInfo;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface InviteReturnUcService {
    @GET("uc/open/invite/invitee/list")
    Observable<UcIntCodeResponse<List<InviteRecordListItem>>> getInviteRecordList(@QueryMap Map<String, Object> map);

    @GET("uc/open/invite/inviter/get")
    Observable<UcIntCodeResponse<InviterInfo>> getInviterInfo();
}
