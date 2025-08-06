package com.huobi.invite.bean;

import com.huobi.invite.viewhandler.InviteRankingListItemHandler;
import java.io.Serializable;
import s9.a;

public class InviteRankingListItem implements a, Serializable {
    private static final long serialVersionUID = 5391218002913236385L;
    public dm.a callback;
    public InviteReturnDetail inviteReturnDetail;

    public String getViewHandlerName() {
        return InviteRankingListItemHandler.class.getName();
    }
}
