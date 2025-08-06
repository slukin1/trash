package com.huochat.community.util;

import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import kotlin.jvm.internal.r;

public final class LottieViewTool {
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final int loadAutoLoanA() {
            if (CommunityManager.Companion.getInstance().isNightModel()) {
                return R.raw.skeleton_community_a_night;
            }
            return R.raw.skeleton_community_a;
        }

        public final int loadAutoLoanB() {
            if (CommunityManager.Companion.getInstance().isNightModel()) {
                return R.raw.skeleton_community_b_night;
            }
            return R.raw.skeleton_community_b;
        }
    }

    private LottieViewTool() {
    }
}
