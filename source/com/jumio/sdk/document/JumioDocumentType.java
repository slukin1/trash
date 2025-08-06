package com.jumio.sdk.document;

import android.content.Context;
import com.jumio.core.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public enum JumioDocumentType {
    PASSPORT,
    VISA,
    DRIVING_LICENSE,
    ID_CARD;
    
    public static final Companion Companion = null;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final JumioDocumentType fromLocalizedName(String str, Context context) {
            if (x.b(str, context.getString(R.string.jumio_idtype_pp))) {
                return JumioDocumentType.PASSPORT;
            }
            if (x.b(str, context.getString(R.string.jumio_idtype_dl))) {
                return JumioDocumentType.DRIVING_LICENSE;
            }
            if (x.b(str, context.getString(R.string.jumio_idtype_visa))) {
                return JumioDocumentType.VISA;
            }
            if (x.b(str, context.getString(R.string.jumio_idtype_id))) {
                return JumioDocumentType.ID_CARD;
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
            if (r2.equals("DRIVING_LICENSE") == false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r2.equals("DRIVER_LICENSE") == false) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.jumio.sdk.document.JumioDocumentType fromString(java.lang.String r2) {
            /*
                r1 = this;
                int r0 = r2.hashCode()
                switch(r0) {
                    case -1895130188: goto L_0x0035;
                    case -1808062583: goto L_0x0029;
                    case -1302291702: goto L_0x0020;
                    case 2634817: goto L_0x0014;
                    case 1999404050: goto L_0x0008;
                    default: goto L_0x0007;
                }
            L_0x0007:
                goto L_0x0041
            L_0x0008:
                java.lang.String r0 = "PASSPORT"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0011
                goto L_0x0041
            L_0x0011:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.PASSPORT
                goto L_0x0042
            L_0x0014:
                java.lang.String r0 = "VISA"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x001d
                goto L_0x0041
            L_0x001d:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.VISA
                goto L_0x0042
            L_0x0020:
                java.lang.String r0 = "DRIVER_LICENSE"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0032
                goto L_0x0041
            L_0x0029:
                java.lang.String r0 = "DRIVING_LICENSE"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0032
                goto L_0x0041
            L_0x0032:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE
                goto L_0x0042
            L_0x0035:
                java.lang.String r0 = "ID_CARD"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x003e
                goto L_0x0041
            L_0x003e:
                com.jumio.sdk.document.JumioDocumentType r2 = com.jumio.sdk.document.JumioDocumentType.ID_CARD
                goto L_0x0042
            L_0x0041:
                r2 = 0
            L_0x0042:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.document.JumioDocumentType.Companion.fromString(java.lang.String):com.jumio.sdk.document.JumioDocumentType");
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.jumio.sdk.document.JumioDocumentType[] r0 = com.jumio.sdk.document.JumioDocumentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.PASSPORT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.VISA     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.ID_CARD     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.document.JumioDocumentType.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    public final String getLocalizedName(Context context) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i11 == 1) {
            return context.getString(R.string.jumio_idtype_pp);
        }
        if (i11 == 2) {
            return context.getString(R.string.jumio_idtype_visa);
        }
        if (i11 == 3) {
            return context.getString(R.string.jumio_idtype_dl);
        }
        if (i11 == 4) {
            return context.getString(R.string.jumio_idtype_id);
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i11 == 1) {
            return "PASSPORT";
        }
        if (i11 == 2) {
            return "VISA";
        }
        if (i11 == 3) {
            return "DRIVING_LICENSE";
        }
        if (i11 == 4) {
            return "ID_CARD";
        }
        throw new NoWhenBranchMatchedException();
    }
}
