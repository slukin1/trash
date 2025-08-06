package com.huobi.invite.api;

import com.hbg.lib.core.network.response.IntStatusResponse;
import com.huobi.invite.bean.InvitePosterItem;
import java.util.ArrayList;
import retrofit2.http.GET;
import rx.Observable;

public interface InviteReturnPhpService {
    @GET("p/api/contents/invitePicturesWithLang")
    Observable<IntStatusResponse<ArrayList<InvitePosterItem>>> getInvitePoster();
}
