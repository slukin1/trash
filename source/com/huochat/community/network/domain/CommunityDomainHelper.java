package com.huochat.community.network.domain;

import com.hbg.lib.common.utils.SystemUtils;
import kotlin.jvm.internal.r;
import v7.b;

public final class CommunityDomainHelper {
    public static final Companion Companion = new Companion((r) null);
    private static final boolean ENABLE = true;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final void getGlobalCommunityUrls() {
            if (SystemUtils.c()) {
                b.a().appUrlGet("huobichat").d(new CommunityDomainHelper$Companion$getGlobalCommunityUrls$1());
            }
        }

        public final void getGlobalCommunityWebUrls() {
            if (SystemUtils.c()) {
                b.a().appUrlGet("huobichatWeb").d(new CommunityDomainHelper$Companion$getGlobalCommunityWebUrls$1());
            }
        }
    }
}
