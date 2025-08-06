package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.google.android.material.button.MaterialButton;
import com.jumio.defaultui.R;
import d10.a;
import jumio.dui.b;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import pw.o;
import pw.p;

public final class MethodSelectionFragment extends BaseFragment {
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new MethodSelectionFragment$special$$inlined$activityViewModels$default$1(this), new MethodSelectionFragment$special$$inlined$activityViewModels$default$2((a) null, this), new MethodSelectionFragment$special$$inlined$activityViewModels$default$3(this));

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void createLayout$lambda$0(com.jumio.defaultui.view.MethodSelectionFragment r3, android.view.View r4) {
        /*
            jumio.dui.b r3 = r3.getJumioViewModel()
            com.jumio.sdk.enums.JumioAcquireMode r4 = com.jumio.sdk.enums.JumioAcquireMode.CAMERA
            r3.getClass()
            com.jumio.sdk.credentials.JumioCredential r0 = r3.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioDocumentCredential
            r2 = 0
            if (r1 == 0) goto L_0x0013
            com.jumio.sdk.credentials.JumioDocumentCredential r0 = (com.jumio.sdk.credentials.JumioDocumentCredential) r0
            goto L_0x0014
        L_0x0013:
            r0 = r2
        L_0x0014:
            if (r0 == 0) goto L_0x0038
            r0.setConfiguration(r4)
            com.jumio.sdk.credentials.JumioCredential r4 = r3.f56358f
            if (r4 == 0) goto L_0x002a
            java.util.List r4 = r4.getCredentialParts()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r4)
            r2 = r4
            com.jumio.sdk.enums.JumioCredentialPart r2 = (com.jumio.sdk.enums.JumioCredentialPart) r2
        L_0x002a:
            androidx.lifecycle.SavedStateHandle r4 = r3.f56353a
            java.lang.String r0 = "currentCredentialPart"
            r4.k(r0, r2)
            com.jumio.sdk.enums.JumioCredentialPart r4 = r3.e()
            r3.a((com.jumio.sdk.enums.JumioCredentialPart) r4)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.MethodSelectionFragment.createLayout$lambda$0(com.jumio.defaultui.view.MethodSelectionFragment, android.view.View):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void createLayout$lambda$1(com.jumio.defaultui.view.MethodSelectionFragment r3, android.view.View r4) {
        /*
            jumio.dui.b r3 = r3.getJumioViewModel()
            com.jumio.sdk.enums.JumioAcquireMode r4 = com.jumio.sdk.enums.JumioAcquireMode.FILE
            r3.getClass()
            com.jumio.sdk.credentials.JumioCredential r0 = r3.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioDocumentCredential
            r2 = 0
            if (r1 == 0) goto L_0x0013
            com.jumio.sdk.credentials.JumioDocumentCredential r0 = (com.jumio.sdk.credentials.JumioDocumentCredential) r0
            goto L_0x0014
        L_0x0013:
            r0 = r2
        L_0x0014:
            if (r0 == 0) goto L_0x0038
            r0.setConfiguration(r4)
            com.jumio.sdk.credentials.JumioCredential r4 = r3.f56358f
            if (r4 == 0) goto L_0x002a
            java.util.List r4 = r4.getCredentialParts()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r4)
            r2 = r4
            com.jumio.sdk.enums.JumioCredentialPart r2 = (com.jumio.sdk.enums.JumioCredentialPart) r2
        L_0x002a:
            androidx.lifecycle.SavedStateHandle r4 = r3.f56353a
            java.lang.String r0 = "currentCredentialPart"
            r4.k(r0, r2)
            com.jumio.sdk.enums.JumioCredentialPart r4 = r3.e()
            r3.a((com.jumio.sdk.enums.JumioCredentialPart) r4)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.MethodSelectionFragment.createLayout$lambda$1(com.jumio.defaultui.view.MethodSelectionFragment, android.view.View):void");
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_method_selection, viewGroup, false);
        ((MaterialButton) inflate.findViewById(R.id.button_take_photo)).setOnClickListener(new o(this));
        ((MaterialButton) inflate.findViewById(R.id.button_upload_pdf_file)).setOnClickListener(new p(this));
        return inflate;
    }
}
