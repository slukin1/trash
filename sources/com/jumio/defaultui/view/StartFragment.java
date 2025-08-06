package com.jumio.defaultui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.jumio.defaultui.R;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioConsentType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jumio.dui.b;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;

public final class StartFragment extends BaseFragment implements View.OnClickListener {
    private MaterialButton btnStart;
    private ConsentListAdapter consentAdapter;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new StartFragment$special$$inlined$activityViewModels$default$1(this), new StartFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new StartFragment$special$$inlined$activityViewModels$default$3(this));
    private AppCompatTextView tvConsent;

    public /* synthetic */ class a extends FunctionReferenceImpl implements p<JumioConsentItem, Boolean, Unit> {
        public a(Object obj) {
            super(2, obj, StartFragment.class, "setUserConsent", "setUserConsent(Lcom/jumio/sdk/consent/JumioConsentItem;Z)V", 0);
        }

        public final Object invoke(Object obj, Object obj2) {
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            ((StartFragment) this.receiver).setUserConsent((JumioConsentItem) obj, booleanValue);
            return Unit.f56620a;
        }
    }

    private final List<JumioCredentialCategory> getCategoriesToDisplay() {
        List<JumioCredentialInfo> list = getJumioViewModel().f56357e;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (JumioCredentialInfo category : list) {
            arrayList.add(category.getCategory());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (((JumioCredentialCategory) next) != JumioCredentialCategory.DATA) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getUnconsentedItems();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.jumio.sdk.consent.JumioConsentItem> getUnconsentedItems() {
        /*
            r1 = this;
            jumio.dui.b r0 = r1.getJumioViewModel()
            com.jumio.sdk.controller.JumioController r0 = r0.f56356d
            if (r0 == 0) goto L_0x000e
            java.util.List r0 = r0.getUnconsentedItems()
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.StartFragment.getUnconsentedItems():java.util.List");
    }

    private final boolean getUserConsentedAll() {
        return getUnconsentedItems().isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initConsentItems(android.view.View r7) {
        /*
            r6 = this;
            jumio.dui.b r0 = r6.getJumioViewModel()
            androidx.lifecycle.SavedStateHandle r0 = r0.f56353a
            java.lang.String r1 = "consentItems"
            java.lang.Object r0 = r0.f(r1)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            com.google.android.material.button.MaterialButton r1 = r6.btnStart
            r2 = 0
            if (r1 != 0) goto L_0x0017
            goto L_0x001a
        L_0x0017:
            r1.setEnabled(r2)
        L_0x001a:
            int r1 = r0.size()
            r3 = 1
            if (r1 != r3) goto L_0x0065
            java.lang.Object r1 = r0.get(r2)
            com.jumio.sdk.consent.JumioConsentItem r1 = (com.jumio.sdk.consent.JumioConsentItem) r1
            com.jumio.sdk.enums.JumioConsentType r1 = r1.getType()
            com.jumio.sdk.enums.JumioConsentType r4 = com.jumio.sdk.enums.JumioConsentType.PASSIVE
            if (r1 != r4) goto L_0x0065
            int r1 = com.jumio.defaultui.R.id.tv_consent
            android.view.View r1 = r7.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            r6.tvConsent = r1
            r1 = 16843827(0x1010433, float:2.369657E-38)
            int r7 = com.google.android.material.color.MaterialColors.getColor(r7, r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r6.tvConsent
            if (r1 == 0) goto L_0x005b
            java.lang.Object r0 = r0.get(r2)
            com.jumio.sdk.consent.JumioConsentItem r0 = (com.jumio.sdk.consent.JumioConsentItem) r0
            android.text.Spanned r7 = r0.spannedTextWithLinkColor(r7)
            r1.setText(r7)
            android.text.method.MovementMethod r7 = android.text.method.LinkMovementMethod.getInstance()
            r1.setMovementMethod(r7)
            r1.setVisibility(r2)
        L_0x005b:
            com.google.android.material.button.MaterialButton r7 = r6.btnStart
            if (r7 != 0) goto L_0x0061
            goto L_0x00c8
        L_0x0061:
            r7.setEnabled(r3)
            goto L_0x00c8
        L_0x0065:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x006c
            goto L_0x008b
        L_0x006c:
            java.util.Iterator r1 = r0.iterator()
        L_0x0070:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r1.next()
            com.jumio.sdk.consent.JumioConsentItem r4 = (com.jumio.sdk.consent.JumioConsentItem) r4
            com.jumio.sdk.enums.JumioConsentType r4 = r4.getType()
            com.jumio.sdk.enums.JumioConsentType r5 = com.jumio.sdk.enums.JumioConsentType.ACTIVE
            if (r4 != r5) goto L_0x0086
            r4 = r3
            goto L_0x0087
        L_0x0086:
            r4 = r2
        L_0x0087:
            if (r4 == 0) goto L_0x0070
            r1 = r2
            goto L_0x008c
        L_0x008b:
            r1 = r3
        L_0x008c:
            if (r1 == 0) goto L_0x0096
            com.google.android.material.button.MaterialButton r1 = r6.btnStart
            if (r1 != 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r1.setEnabled(r3)
        L_0x0096:
            int r1 = com.jumio.defaultui.R.id.rv_consent_list
            android.view.View r7 = r7.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r7.setVisibility(r2)
            android.content.Context r1 = r6.getContext()
            if (r1 == 0) goto L_0x00c8
            com.jumio.defaultui.view.ConsentListAdapter r1 = new com.jumio.defaultui.view.ConsentListAdapter
            java.util.List r2 = r6.getUnconsentedItems()
            com.jumio.defaultui.view.StartFragment$a r3 = new com.jumio.defaultui.view.StartFragment$a
            r3.<init>(r6)
            r1.<init>(r0, r2, r3)
            r6.consentAdapter = r1
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r7.getContext()
            r0.<init>(r1)
            r7.setLayoutManager(r0)
            com.jumio.defaultui.view.ConsentListAdapter r0 = r6.consentAdapter
            r7.setAdapter(r0)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.StartFragment.initConsentItems(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public final void setUserConsent(JumioConsentItem jumioConsentItem, boolean z11) {
        boolean z12;
        JumioController jumioController = getJumioViewModel().f56356d;
        if (jumioController != null) {
            jumioController.userConsented(jumioConsentItem, z11);
        }
        MaterialButton materialButton = this.btnStart;
        if (materialButton != null) {
            List<JumioConsentItem> unconsentedItems = getUnconsentedItems();
            boolean z13 = false;
            if (!(unconsentedItems instanceof Collection) || !unconsentedItems.isEmpty()) {
                Iterator<T> it2 = unconsentedItems.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((JumioConsentItem) it2.next()).getType() == JumioConsentType.ACTIVE) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                    if (z12) {
                        break;
                    }
                }
                materialButton.setEnabled(z13);
            }
            z13 = true;
            materialButton.setEnabled(z13);
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_start, viewGroup, false);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.btn_start);
        this.btnStart = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tv_title);
        Context context = getContext();
        appCompatTextView.setText(context != null ? context.getString(R.string.jumio_start_steps_title) : null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_category_list);
        if ((!getJumioViewModel().f56357e.isEmpty()) && getContext() != null) {
            List<JumioCredentialCategory> categoriesToDisplay = getCategoriesToDisplay();
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setAdapter(new StartStepsViewAdapter(categoriesToDisplay));
            }
        }
        initConsentItems(inflate);
        return inflate;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        JumioFragmentCallback callback;
        if (view != null && view.getId() == R.id.btn_start) {
            List list = (List) getJumioViewModel().f56353a.f("consentItems");
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object next : list) {
                    if (((JumioConsentItem) next).getType() == JumioConsentType.PASSIVE) {
                        arrayList.add(next);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    setUserConsent((JumioConsentItem) it2.next(), true);
                }
            }
            if (getUserConsentedAll() && (callback = getCallback()) != null) {
                callback.startUserJourney();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroyView() {
        this.tvConsent = null;
        this.btnStart = null;
        super.onDestroyView();
    }
}
