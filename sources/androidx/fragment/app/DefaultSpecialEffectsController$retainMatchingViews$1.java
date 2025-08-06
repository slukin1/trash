package androidx.fragment.app;

import android.view.View;
import androidx.core.view.h0;
import d10.l;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Lambda;

public final class DefaultSpecialEffectsController$retainMatchingViews$1 extends Lambda implements l<Map.Entry<String, View>, Boolean> {
    public final /* synthetic */ Collection<String> $names;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$retainMatchingViews$1(Collection<String> collection) {
        super(1);
        this.$names = collection;
    }

    public final Boolean invoke(Map.Entry<String, View> entry) {
        return Boolean.valueOf(CollectionsKt___CollectionsKt.R(this.$names, h0.P(entry.getValue())));
    }
}
