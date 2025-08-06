package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.credentials.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class GetGoogleIdOption extends m {
    public static final Companion Companion = new Companion((r) null);
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private final String zzd;
    private final List zze;
    private final boolean zzf;
    private final boolean zzg;

    public static final class Builder {
        private String zza = "";
        private String zzb;
        private String zzc;
        private boolean zzd = true;
        private boolean zze;
        private boolean zzf;
        private List zzg;

        public final Builder associateLinkedAccounts(String str, List<String> list) {
            if (str.length() > 0) {
                this.zzb = str;
                this.zzg = list != null ? CollectionsKt___CollectionsKt.I0(list) : null;
                return this;
            }
            throw new IllegalArgumentException("linkedServiceId must be provided if you want to associate linked accounts.");
        }

        public final GetGoogleIdOption build() {
            return new GetGoogleIdOption(this.zza, this.zzc, this.zzd, this.zzb, this.zzg, this.zze, this.zzf);
        }

        public final Builder setAutoSelectEnabled(boolean z11) {
            this.zzf = z11;
            return this;
        }

        public final Builder setFilterByAuthorizedAccounts(boolean z11) {
            this.zzd = z11;
            return this;
        }

        public final Builder setNonce(String str) {
            this.zzc = str;
            return this;
        }

        public final Builder setRequestVerifiedPhoneNumber(boolean z11) {
            this.zze = z11;
            return this;
        }

        public final Builder setServerClientId(String str) {
            if (str.length() > 0) {
                this.zza = str;
                return this;
            }
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
        }

        public static final Bundle zza(String str, String str2, boolean z11, String str3, List list, boolean z12, boolean z13) {
            ArrayList arrayList;
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID", str);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE", str2);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", z11);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID", str3);
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list);
            }
            bundle.putStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES", arrayList);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", z12);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", z13);
            return bundle;
        }

        public final GetGoogleIdOption createFrom(Bundle bundle) {
            try {
                return new GetGoogleIdOption(bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID"), bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE"), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", true), bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID"), bundle.getStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES"), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", false), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", false));
            } catch (Exception e11) {
                throw new GoogleIdTokenParsingException(e11);
            }
        }
    }

    public GetGoogleIdOption(String str, String str2, boolean z11, String str3, List<String> list, boolean z12, boolean z13) {
        super(GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL, Companion.zza(str, str2, z11, str3, list, z12, z13), Companion.zza(str, str2, z11, str3, list, z12, z13), true, true);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z11;
        this.zzd = str3;
        this.zze = list;
        this.zzf = z12;
        this.zzg = z13;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        } else if (z11 && z12) {
            throw new IllegalArgumentException("filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true;  the Verified Phone Number feature only works in sign-ups.");
        }
    }

    public static final GetGoogleIdOption createFrom(Bundle bundle) {
        return Companion.createFrom(bundle);
    }

    public final boolean getAutoSelectEnabled() {
        return this.zzg;
    }

    public final boolean getFilterByAuthorizedAccounts() {
        return this.zzc;
    }

    public final List<String> getIdTokenDepositionScopes() {
        return this.zze;
    }

    public final String getLinkedServiceId() {
        return this.zzd;
    }

    public final String getNonce() {
        return this.zzb;
    }

    public final boolean getRequestVerifiedPhoneNumber() {
        return this.zzf;
    }

    public final String getServerClientId() {
        return this.zza;
    }
}
