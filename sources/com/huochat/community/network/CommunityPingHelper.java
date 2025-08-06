package com.huochat.community.network;

import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;

public final class CommunityPingHelper {
    private List<String> domainList;

    public interface OnPingListener {
        Observable<?> createPingObservable(Retrofit retrofit);

        void onPreferredDomain(String str);
    }

    public final void CommunityPingHelper(List<String> list) {
        this.domainList = list;
    }

    public final void ping(OnPingListener onPingListener) {
    }
}
