package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.UUID;

public final /* synthetic */ class w implements ExoMediaDrm.Provider {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ w f65885a = new w();

    public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
        return FrameworkMediaDrm.lambda$static$0(uuid);
    }
}
