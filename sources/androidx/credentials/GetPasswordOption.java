package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.r;

public final class GetPasswordOption extends i {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8752b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8753a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GetPasswordOption a(Bundle bundle) {
            return new GetPasswordOption(false, 1, (r) null);
        }
    }

    public GetPasswordOption() {
        this(false, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPasswordOption(boolean z11, int i11, r rVar) {
        this((i11 & 1) != 0 ? false : z11);
    }

    public boolean isAutoSelectAllowed() {
        return this.f8753a;
    }

    public GetPasswordOption(boolean z11) {
        super("android.credentials.TYPE_PASSWORD_CREDENTIAL", new Bundle(), new Bundle(), false, z11);
        this.f8753a = z11;
    }
}
