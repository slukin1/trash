package androidx.datastore.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "Landroid/content/SharedPreferences;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SharedPreferencesMigration$4 extends Lambda implements a<SharedPreferences> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $sharedPreferencesName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration$4(Context context, String str) {
        super(0);
        this.$context = context;
        this.$sharedPreferencesName = str;
    }

    public final SharedPreferences invoke() {
        return this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
    }
}
