package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumio.defaultui.R;
import com.jumio.sdk.document.JumioDocumentType;
import kotlin.NoWhenBranchMatchedException;

public final class DocumentSelectionAdapterKt {
    private static final String TAG = "DocumentSelectionAdapter";

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.DRIVING_LICENSE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.ID_CARD     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.sdk.document.JumioDocumentType r1 = com.jumio.sdk.document.JumioDocumentType.VISA     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.DocumentSelectionAdapterKt.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final int getIconForDocumentType(JumioDocumentType jumioDocumentType) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[jumioDocumentType.ordinal()];
        if (i11 == 1) {
            return R.drawable.jumio_ic_passport;
        }
        if (i11 == 2) {
            return R.drawable.jumio_ic_driver_license;
        }
        if (i11 == 3) {
            return R.drawable.jumio_ic_id_card;
        }
        if (i11 == 4) {
            return R.drawable.jumio_ic_visa;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final View inflate(ViewGroup viewGroup, int i11, boolean z11) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, z11);
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return inflate(viewGroup, i11, z11);
    }

    /* access modifiers changed from: private */
    public static final int resolveItemBackground(int i11) {
        if (i11 == -1) {
            return R.drawable.jumio_rounded_top_list_item;
        }
        if (i11 == 0) {
            return R.drawable.jumio_list_item;
        }
        if (i11 == 1) {
            return R.drawable.jumio_rounded_bottom_list_item;
        }
        if (i11 != 2) {
            return R.drawable.jumio_list_item;
        }
        return R.drawable.jumio_rounded_list_item;
    }
}
