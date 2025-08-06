package com.jumio.defaultui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.defaultui.R;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;

public final class StartStepsViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final Companion Companion = new Companion((r) null);
    private static String TAG = "StartStepsViewAdapter";
    private final List<JumioCredentialCategory> credentialCategoryList;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryDescription;

        public ViewHolder(View view) {
            super(view);
            this.categoryDescription = (TextView) view.findViewById(R.id.item_name);
        }

        public final TextView getCategoryDescription() {
            return this.categoryDescription;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.jumio.sdk.credentials.JumioCredentialCategory[] r0 = com.jumio.sdk.credentials.JumioCredentialCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.ID     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.FACE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.DATA     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.StartStepsViewAdapter.WhenMappings.<clinit>():void");
        }
    }

    public StartStepsViewAdapter(List<? extends JumioCredentialCategory> list) {
        this.credentialCategoryList = list;
    }

    private final String getDescriptionForCategory(JumioCredentialCategory jumioCredentialCategory, Context context) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[jumioCredentialCategory.ordinal()];
        if (i11 == 1) {
            return context.getString(R.string.jumio_start_step_id);
        }
        if (i11 == 2) {
            return context.getString(R.string.jumio_start_step_doc);
        }
        if (i11 == 3) {
            return context.getString(R.string.jumio_start_step_identity);
        }
        if (i11 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("Data credentials should not be displayed!");
    }

    public int getItemCount() {
        return this.credentialCategoryList.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i11) {
        viewHolder.getCategoryDescription().setText(getDescriptionForCategory(this.credentialCategoryList.get(i11), viewHolder.getCategoryDescription().getContext()));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ViewHolder(StartStepsViewAdapterKt.inflate(viewGroup, R.layout.jumio_fragment_start_item, false));
    }
}
