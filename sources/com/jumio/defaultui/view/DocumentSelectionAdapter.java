package com.jumio.defaultui.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.sdk.document.JumioDocumentType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.List;
import kotlin.Unit;

public final class DocumentSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<JumioDocumentType> documentTypes;
    private final l<JumioDocumentType, Unit> onclick;

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView documentIcon;
        private final TextView documentName;
        private final l<JumioDocumentType, Unit> onclick;

        public ViewHolder(View view, l<? super JumioDocumentType, Unit> lVar) {
            super(view);
            this.onclick = lVar;
            this.documentName = (TextView) view.findViewById(R.id.item_name);
            this.documentIcon = (ImageView) view.findViewById(R.id.item_icon);
            view.setOnClickListener(this);
        }

        public final ImageView getDocumentIcon() {
            return this.documentIcon;
        }

        public final TextView getDocumentName() {
            return this.documentName;
        }

        public final l<JumioDocumentType, Unit> getOnclick() {
            return this.onclick;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CharSequence text = this.documentName.getText();
            if (!(text == null || text.length() == 0)) {
                this.onclick.invoke(JumioDocumentType.Companion.fromLocalizedName(this.documentName.getText().toString(), this.documentName.getContext()));
            }
            Log.d("DocumentSelectionAdapter", "Click received");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public String toString() {
            String viewHolder = super.toString();
            CharSequence text = this.documentName.getText();
            return viewHolder + " '" + text + "'";
        }
    }

    public DocumentSelectionAdapter(List<? extends JumioDocumentType> list, l<? super JumioDocumentType, Unit> lVar) {
        this.documentTypes = list;
        this.onclick = lVar;
    }

    public int getItemCount() {
        return this.documentTypes.size();
    }

    public int getItemViewType(int i11) {
        if (this.documentTypes.size() == 1) {
            return 2;
        }
        if (i11 == 0) {
            return -1;
        }
        if (i11 == CollectionsKt__CollectionsKt.m(this.documentTypes)) {
            return 1;
        }
        return 0;
    }

    public final l<JumioDocumentType, Unit> getOnclick() {
        return this.onclick;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i11) {
        JumioDocumentType jumioDocumentType = this.documentTypes.get(i11);
        viewHolder.getDocumentName().setText(jumioDocumentType.getLocalizedName(viewHolder.getDocumentName().getContext()));
        viewHolder.getDocumentIcon().setImageResource(DocumentSelectionAdapterKt.getIconForDocumentType(jumioDocumentType));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View access$inflate = DocumentSelectionAdapterKt.inflate(viewGroup, R.layout.jumio_fragment_document_selection_item, false);
        access$inflate.setBackgroundResource(DocumentSelectionAdapterKt.resolveItemBackground(i11));
        return new ViewHolder(access$inflate, this.onclick);
    }
}
