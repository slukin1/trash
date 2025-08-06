package com.huobi.invite.helper;

import com.hbg.lib.common.utils.SP;
import com.huobi.invite.api.InviteReturnPhpService;
import com.huobi.invite.api.InviteReturnProService;
import com.huobi.invite.api.InviteReturnUcService;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InviteRecordListItem;
import com.huobi.invite.bean.InviteReturnRank;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.invite.bean.InviteReturnSum;
import com.huobi.invite.bean.InviterInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Observable;
import tq.p;

public class InviteReturnHelper {
    public static Observable<ArrayList<InvitePosterItem>> a() {
        return ((InviteReturnPhpService) p.V(InviteReturnPhpService.class)).getInvitePoster().compose(p.E());
    }

    public static Observable<List<InviteRecordListItem>> b(Map<String, Object> map) {
        return ((InviteReturnUcService) p.b0(InviteReturnUcService.class)).getInviteRecordList(map).compose(p.c0());
    }

    public static Observable<InviteReturnRank> c(Map<String, Object> map) {
        return ((InviteReturnProService) p.W(InviteReturnProService.class)).getInviteReturnRank(map).compose(p.a0());
    }

    public static Observable<InviteReturnSum> d() {
        return ((InviteReturnProService) p.W(InviteReturnProService.class)).getInviteReturnSum().compose(p.a0());
    }

    public static Observable<InviterInfo> e() {
        return ((InviteReturnUcService) p.b0(InviteReturnUcService.class)).getInviterInfo().compose(p.c0());
    }

    public static Observable<List<InviteReturnRecordListItem>> f(Map<String, Object> map) {
        return ((InviteReturnProService) p.W(InviteReturnProService.class)).getReturnRecordList(map).compose(p.a0());
    }

    public static boolean g() {
        return SP.l("sp_key_invite_return_has_used_share_friend", false);
    }

    public static void h(boolean z11) {
        SP.y("sp_key_invite_return_has_used_share_friend", z11);
    }
}
