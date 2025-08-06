package com.huochat.community;

import kotlin.jvm.internal.r;

public final class CommunityModuleConfig {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static CommunityModuleCallback moduleCallback;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CommunityModuleCallback getModuleCallback() {
            return CommunityModuleConfig.moduleCallback;
        }

        public final void setModuleCallback(CommunityModuleCallback communityModuleCallback) {
            CommunityModuleConfig.moduleCallback = communityModuleCallback;
        }
    }
}
