package com.sumsub.sns.internal.ff;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.sumsub.sns.internal.ff.core.a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/internal/ff/FeatureBridge;", "", "", "Lcom/sumsub/sns/internal/ff/core/a;", "Landroid/os/Bundle;", "serialize", "getLocalFeatures", "getRemoteFeatures", "", "name", "", "isEnabled", "value", "", "overrideFeature", "clearOverride", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@Keep
public final class FeatureBridge {
    public static final FeatureBridge INSTANCE = new FeatureBridge();

    private FeatureBridge() {
    }

    private final Bundle serialize(Collection<a> collection) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : collection) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("name", aVar.e());
            bundle.putBoolean("local_only", aVar.d());
            bundle.putCharSequence("human_readable_description", aVar.c());
            bundle.putBoolean("default_enabled", aVar.b().d());
            if (aVar.b().c() != null) {
                bundle.putCharSequence("default_value", aVar.b().c());
            }
            arrayList.add(bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(SettingsJsonConstants.FEATURES_KEY, arrayList);
        return bundle2;
    }

    public final void clearOverride(String str) {
        a.f34215a.a(str);
    }

    public final Bundle getLocalFeatures() {
        return serialize(a.f34215a.r().a());
    }

    public final Bundle getRemoteFeatures() {
        return serialize(a.f34215a.r().b());
    }

    public final void overrideFeature(String str, boolean z11, String str2) {
        a.f34215a.a(str, z11, str2);
    }
}
