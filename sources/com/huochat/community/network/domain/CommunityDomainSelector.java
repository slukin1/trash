package com.huochat.community.network.domain;

import com.hbg.lib.common.BaseApplication;
import com.huochat.community.util.CollectionTool;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class CommunityDomainSelector {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final i<CommunityDomainSelector> instance$delegate = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.SYNCHRONIZED, CommunityDomainSelector$Companion$instance$2.INSTANCE);
    private final String KEY_CN_DOMAINS;
    private final String KEY_OVERSEAS_DOMAINS;
    private final String LOG_TAG;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CommunityDomainSelector getInstance() {
            return (CommunityDomainSelector) CommunityDomainSelector.instance$delegate.getValue();
        }
    }

    public interface OnDomainResolutionCallback {
        void callback(String str);
    }

    private CommunityDomainSelector() {
        this.KEY_OVERSEAS_DOMAINS = "overseas";
        this.KEY_CN_DOMAINS = "cn";
        this.LOG_TAG = DomainTool.LOG_TAG;
    }

    public /* synthetic */ CommunityDomainSelector(r rVar) {
        this();
    }

    private final void domainResolution(Map<String, List<String>> map, OnDomainResolutionCallback onDomainResolutionCallback) {
        List<String> newDomainListFromDomainMap = DomainTool.Companion.getNewDomainListFromDomainMap(BaseApplication.b().getApplicationContext(), this.KEY_CN_DOMAINS, this.KEY_OVERSEAS_DOMAINS, map);
        if (CollectionTool.Companion.hasItem(newDomainListFromDomainMap) && onDomainResolutionCallback != null) {
            onDomainResolutionCallback.callback(newDomainListFromDomainMap.get(0));
        }
    }

    public final void setApiDomains(Map<String, List<String>> map) {
        domainResolution(map, new CommunityDomainSelector$setApiDomains$1());
    }

    public final void setWebUrlDomains(Map<String, List<String>> map) {
        domainResolution(map, new CommunityDomainSelector$setWebUrlDomains$1());
    }
}
