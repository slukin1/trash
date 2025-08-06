package kotlinx.serialization.json;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.json.internal.i0;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.e;

public final class l extends a {
    public l(JsonConfiguration jsonConfiguration, d dVar) {
        super(jsonConfiguration, dVar, (r) null);
        h();
    }

    public final void h() {
        if (!x.b(a(), e.a())) {
            a().a(new i0(f().l(), f().c()));
        }
    }
}
