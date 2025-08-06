package com.jumio.defaultui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.commons.log.Log;
import com.jumio.core.data.country.Country;
import com.jumio.defaultui.R;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDigitalDocument;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioPhysicalDocument;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import jumio.dui.b;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import pw.h;

public final class DocumentSelectionFragment extends BaseFragment {
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new DocumentSelectionFragment$special$$inlined$activityViewModels$default$1(this), new DocumentSelectionFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new DocumentSelectionFragment$special$$inlined$activityViewModels$default$3(this));
    private AppCompatTextView tvCountrySelection;

    public static final class a extends Lambda implements l<JumioDocumentType, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DocumentSelectionFragment f70826a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DocumentSelectionFragment documentSelectionFragment) {
            super(1);
            this.f70826a = documentSelectionFragment;
        }

        public final Object invoke(Object obj) {
            this.f70826a.adapterOnClick((JumioDocumentType) obj);
            return Unit.f56620a;
        }
    }

    /* access modifiers changed from: private */
    public final void adapterOnClick(JumioDocumentType jumioDocumentType) {
        List<JumioPhysicalDocument> physicalDocumentsForCountry;
        boolean z11;
        if (getContext() != null && jumioDocumentType != null) {
            JumioCredential d11 = getJumioViewModel().d();
            JumioIDCredential jumioIDCredential = d11 instanceof JumioIDCredential ? (JumioIDCredential) d11 : null;
            if (jumioIDCredential != null && (physicalDocumentsForCountry = jumioIDCredential.getPhysicalDocumentsForCountry(getJumioViewModel().k())) != null) {
                for (JumioPhysicalDocument jumioPhysicalDocument : physicalDocumentsForCountry) {
                    int i11 = 0;
                    if (jumioPhysicalDocument.getType() == jumioDocumentType) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        if (!physicalDocumentsForCountry.isEmpty()) {
                            int i12 = 0;
                            for (JumioPhysicalDocument type : physicalDocumentsForCountry) {
                                if ((type.getType() == jumioPhysicalDocument.getType()) && (i12 = i12 + 1) < 0) {
                                    CollectionsKt__CollectionsKt.s();
                                }
                            }
                            i11 = i12;
                        }
                        if (i11 > 1) {
                            getJumioViewModel().a(jumioPhysicalDocument.getType());
                        } else {
                            getJumioViewModel().a(getJumioViewModel().k(), jumioPhysicalDocument);
                        }
                        Log.d("DocumentSelectionFragment", "onClick: document " + jumioDocumentType.name() + " triggered");
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void setupCountrySelection(View view, List<String> list) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_country_selection);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
        this.tvCountrySelection = (AppCompatTextView) view.findViewById(R.id.tv_country_selection_value);
        if (getJumioViewModel().k().length() > 0) {
            AppCompatTextView appCompatTextView = this.tvCountrySelection;
            if (appCompatTextView != null) {
                appCompatTextView.setText(new Country(getJumioViewModel().k(), false, 2, (r) null).getName());
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.tvCountrySelection;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(new Country((String) CollectionsKt___CollectionsKt.a0(list), false, 2, (r) null).getName());
            }
        }
        if (list.size() > 1) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            linearLayout.setOnClickListener(new pw.i(this));
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void setupCountrySelection$lambda$1(DocumentSelectionFragment documentSelectionFragment, View view) {
        JumioFragmentCallback callback = documentSelectionFragment.getCallback();
        if (callback != null) {
            callback.startCountrySelection();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void setupDigitalDocumentSelection(View view, List<JumioDigitalDocument> list) {
        String str;
        if (getContext() != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_digital_doc_container);
            if (list.isEmpty()) {
                linearLayout.setVisibility(8);
                return;
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.item_name);
            if (textView != null) {
                if (list.size() == 1) {
                    str = ((JumioDigitalDocument) CollectionsKt___CollectionsKt.a0(list)).getTitle();
                } else {
                    str = getString(R.string.jumio_idtype_di);
                }
                textView.setText(str);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.item_icon);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.jumio_ic_di);
            }
            linearLayout.setClickable(true);
            linearLayout.setBackgroundResource(R.drawable.jumio_rounded_list_item);
            linearLayout.setOnClickListener(new h(this));
            linearLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void setupDigitalDocumentSelection$lambda$7$lambda$6(DocumentSelectionFragment documentSelectionFragment, View view) {
        List<JumioDigitalDocument> digitalDocumentsForCountry;
        String k11 = documentSelectionFragment.getJumioViewModel().k();
        JumioCredential jumioCredential = documentSelectionFragment.getJumioViewModel().f56358f;
        JumioIDCredential jumioIDCredential = jumioCredential instanceof JumioIDCredential ? (JumioIDCredential) jumioCredential : null;
        if (jumioIDCredential == null || (digitalDocumentsForCountry = jumioIDCredential.getDigitalDocumentsForCountry(k11)) == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (digitalDocumentsForCountry.size() == 1) {
            documentSelectionFragment.getJumioViewModel().a(k11, (JumioDocument) CollectionsKt___CollectionsKt.a0(digitalDocumentsForCountry));
        } else {
            b jumioViewModel = documentSelectionFragment.getJumioViewModel();
            jumioViewModel.getClass();
            jumioViewModel.f56353a.k("selectedDigitalDocuments", digitalDocumentsForCountry);
            jumioViewModel.f56361i.setValue(b.C0659b.SELECTION_DI_DOCUMENT);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void setupPhysicalDocumentSelection(View view, List<JumioPhysicalDocument> list) {
        RecyclerView recyclerView;
        if (getContext() != null && (recyclerView = (RecyclerView) view.findViewById(R.id.rv_document_list)) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (JumioPhysicalDocument type : list) {
                arrayList.add(type.getType());
            }
            recyclerView.setAdapter(new DocumentSelectionAdapter(arrayList, new a(this)));
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View createLayout(android.view.LayoutInflater r8, android.view.ViewGroup r9) {
        /*
            r7 = this;
            int r0 = com.jumio.defaultui.R.layout.jumio_fragment_document_selection
            r1 = 0
            android.view.View r8 = r8.inflate(r0, r9, r1)
            jumio.dui.b r9 = r7.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r9 = r9.f56358f
            boolean r0 = r9 instanceof com.jumio.sdk.credentials.JumioIDCredential
            r1 = 0
            if (r0 == 0) goto L_0x0015
            com.jumio.sdk.credentials.JumioIDCredential r9 = (com.jumio.sdk.credentials.JumioIDCredential) r9
            goto L_0x0016
        L_0x0015:
            r9 = r1
        L_0x0016:
            if (r9 == 0) goto L_0x001e
            java.util.List r0 = r9.getSupportedCountries()
            if (r0 != 0) goto L_0x0022
        L_0x001e:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0022:
            r7.setupCountrySelection(r8, r0)
            jumio.dui.b r0 = r7.getJumioViewModel()
            java.lang.String r0 = r0.k()
            if (r9 == 0) goto L_0x005e
            java.util.List r2 = r9.getPhysicalDocumentsForCountry(r0)
            if (r2 == 0) goto L_0x005e
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0043:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r2.next()
            r6 = r5
            com.jumio.sdk.document.JumioPhysicalDocument r6 = (com.jumio.sdk.document.JumioPhysicalDocument) r6
            com.jumio.sdk.document.JumioDocumentType r6 = r6.getType()
            boolean r6 = r3.add(r6)
            if (r6 == 0) goto L_0x0043
            r4.add(r5)
            goto L_0x0043
        L_0x005e:
            r4 = r1
        L_0x005f:
            if (r4 != 0) goto L_0x0065
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0065:
            r7.setupPhysicalDocumentSelection(r8, r4)
            if (r9 == 0) goto L_0x006e
            java.util.List r1 = r9.getDigitalDocumentsForCountry(r0)
        L_0x006e:
            if (r1 != 0) goto L_0x0074
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0074:
            r7.setupDigitalDocumentSelection(r8, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.DocumentSelectionFragment.createLayout(android.view.LayoutInflater, android.view.ViewGroup):android.view.View");
    }

    public void onDestroyView() {
        this.tvCountrySelection = null;
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        AppCompatTextView appCompatTextView = this.tvCountrySelection;
        if (appCompatTextView != null) {
            appCompatTextView.setText(new Country(getJumioViewModel().k(), false, 2, (r) null).getName());
        }
    }
}
