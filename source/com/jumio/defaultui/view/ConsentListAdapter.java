package com.jumio.defaultui.view;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.MaterialColors;
import com.jumio.defaultui.R;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.enums.JumioConsentType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import java.util.List;
import kotlin.Unit;
import pw.b;

public final class ConsentListAdapter extends RecyclerView.Adapter<ConsentViewHolder> {
    private final List<JumioConsentItem> consentItems;
    private final int layout = R.layout.jumio_fragment_consent_item;
    private final p<JumioConsentItem, Boolean, Unit> onCheckedChange;
    private final List<JumioConsentItem> unconsentedItems;

    public static final class ConsentViewHolder extends RecyclerView.ViewHolder {
        private SwitchCompat consentSwitch;
        private TextView consentText;
        private final p<JumioConsentItem, Boolean, Unit> onCheckedChange;

        public ConsentViewHolder(View view, p<? super JumioConsentItem, ? super Boolean, Unit> pVar) {
            super(view);
            this.onCheckedChange = pVar;
            this.consentText = (TextView) view.findViewById(R.id.tv_consent_item);
            this.consentSwitch = (SwitchCompat) view.findViewById(R.id.btn_consent_switch);
        }

        private final void showConsent(TextView textView, SwitchCompat switchCompat, JumioConsentItem jumioConsentItem, List<JumioConsentItem> list) {
            Spanned spannedTextWithLinkColor = jumioConsentItem.spannedTextWithLinkColor(MaterialColors.getColor(this.itemView, 16843827));
            int i11 = 0;
            if (spannedTextWithLinkColor.length() == 0) {
                textView.setVisibility(8);
                switchCompat.setVisibility(8);
                return;
            }
            textView.setText(spannedTextWithLinkColor);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setVisibility(0);
            if (jumioConsentItem.getType() == JumioConsentType.ACTIVE) {
                if (list.isEmpty()) {
                    switchCompat.setChecked(true);
                    this.onCheckedChange.invoke(jumioConsentItem, Boolean.TRUE);
                }
                switchCompat.setOnCheckedChangeListener(new b(this, jumioConsentItem));
            } else {
                i11 = 8;
            }
            switchCompat.setVisibility(i11);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void showConsent$lambda$1(ConsentViewHolder consentViewHolder, JumioConsentItem jumioConsentItem, CompoundButton compoundButton, boolean z11) {
            consentViewHolder.onCheckedChange.invoke(jumioConsentItem, Boolean.valueOf(z11));
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        public final void bind(JumioConsentItem jumioConsentItem, List<JumioConsentItem> list) {
            showConsent(this.consentText, this.consentSwitch, jumioConsentItem, list);
        }

        public final SwitchCompat getConsentSwitch() {
            return this.consentSwitch;
        }

        public final void setConsentSwitch(SwitchCompat switchCompat) {
            this.consentSwitch = switchCompat;
        }
    }

    public ConsentListAdapter(List<JumioConsentItem> list, List<JumioConsentItem> list2, p<? super JumioConsentItem, ? super Boolean, Unit> pVar) {
        this.consentItems = list;
        this.unconsentedItems = list2;
        this.onCheckedChange = pVar;
    }

    public int getItemCount() {
        return this.consentItems.size();
    }

    public void onBindViewHolder(ConsentViewHolder consentViewHolder, int i11) {
        consentViewHolder.bind(this.consentItems.get(i11), this.unconsentedItems);
    }

    public ConsentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ConsentViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.layout, viewGroup, false), this.onCheckedChange);
    }
}
