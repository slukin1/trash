package pw;

import android.widget.CompoundButton;
import com.jumio.defaultui.view.ConsentListAdapter;
import com.jumio.sdk.consent.JumioConsentItem;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConsentListAdapter.ConsentViewHolder f53275b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JumioConsentItem f53276c;

    public /* synthetic */ b(ConsentListAdapter.ConsentViewHolder consentViewHolder, JumioConsentItem jumioConsentItem) {
        this.f53275b = consentViewHolder;
        this.f53276c = jumioConsentItem;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        ConsentListAdapter.ConsentViewHolder.showConsent$lambda$1(this.f53275b, this.f53276c, compoundButton, z11);
    }
}
