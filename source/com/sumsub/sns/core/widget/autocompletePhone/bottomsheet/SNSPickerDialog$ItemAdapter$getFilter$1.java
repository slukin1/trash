package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.widget.Filter;
import androidx.recyclerview.widget.DiffUtil;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\t"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$ItemAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSPickerDialog$ItemAdapter$getFilter$1 extends Filter {
    public final /* synthetic */ SNSPickerDialog.ItemAdapter this$0;
    public final /* synthetic */ SNSPickerDialog this$1;

    public SNSPickerDialog$ItemAdapter$getFilter$1(SNSPickerDialog.ItemAdapter itemAdapter, SNSPickerDialog sNSPickerDialog) {
        this.this$0 = itemAdapter;
        this.this$1 = sNSPickerDialog;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r10 == null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r10) {
        /*
            r9 = this;
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog$ItemAdapter r1 = r9.this$0
            com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog r2 = r9.this$1
            com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog$Item[] r3 = r1.items
            if (r3 == 0) goto L_0x0034
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            int r6 = r3.length
        L_0x0016:
            if (r5 >= r6) goto L_0x002e
            r7 = r3[r5]
            if (r10 == 0) goto L_0x0021
            java.lang.CharSequence r8 = kotlin.text.StringsKt__StringsKt.i1(r10)
            goto L_0x0022
        L_0x0021:
            r8 = 0
        L_0x0022:
            boolean r8 = r2.isEligibleForQuery$idensic_mobile_sdk_aar_release(r7, r8)
            if (r8 == 0) goto L_0x002b
            r4.add(r7)
        L_0x002b:
            int r5 = r5 + 1
            goto L_0x0016
        L_0x002e:
            java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r4)
            if (r10 != 0) goto L_0x0039
        L_0x0034:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0039:
            boolean r2 = r2.getSortAlphabetically()
            if (r2 == 0) goto L_0x0046
            java.util.Comparator r1 = r1.itemComparator
            java.util.Collections.sort(r10, r1)
        L_0x0046:
            r0.values = r10
            int r10 = r10.size()
            r0.count = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog$ItemAdapter$getFilter$1.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        List list = null;
        Object obj = filterResults != null ? filterResults.values : null;
        if (obj instanceof List) {
            list = (List) obj;
        }
        if (list != null) {
            SNSPickerDialog.ItemAdapter itemAdapter = this.this$0;
            DiffUtil.d b11 = DiffUtil.b(new SNSPickerDialog.DiffCallBack(itemAdapter.filteredItems, list));
            itemAdapter.filteredItems.clear();
            itemAdapter.filteredItems.addAll(list);
            b11.c(itemAdapter);
        }
    }
}
