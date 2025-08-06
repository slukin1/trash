package com.huochat.community;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huochat.community.listener.CheckStateCallback;
import com.huochat.community.model.CommunityResultBean;

public final class CommunityManager$checkCommunityState$1 extends RequestCallback1<CommunityResultBean> {
    public final /* synthetic */ CheckStateCallback $callback;

    public CommunityManager$checkCommunityState$1(CheckStateCallback checkStateCallback) {
        this.$callback = checkStateCallback;
    }

    public void onRequestFailure(Throwable th2) {
        this.$callback.onState(false);
    }

    public void onRequestStart() {
    }

    public void onRequestSuccess(CommunityResultBean communityResultBean) {
        if (communityResultBean != null) {
            this.$callback.onState(true);
        } else {
            this.$callback.onState(false);
        }
    }
}
