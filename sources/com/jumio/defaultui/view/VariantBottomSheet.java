package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumio.defaultui.R;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.document.JumioPhysicalDocument;

public final class VariantBottomSheet extends JumioBottomSheet<String> {
    private final JumioPhysicalDocument toJumioPhysicalDocument(JumioDocumentVariant jumioDocumentVariant) {
        JumioDocumentType jumioDocumentType = (JumioDocumentType) getJumioViewModel$jumio_defaultui_release().f56353a.f("selectedDocumentType");
        if (jumioDocumentType != null) {
            return new JumioPhysicalDocument(jumioDocumentType, jumioDocumentVariant);
        }
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setTitle(getString(R.string.jumio_idtype_format_title));
        setPrimaryActionButtonText(getString(R.string.jumio_idtype_format_option_plastic));
        setSecondaryActionButtonText(getString(R.string.jumio_idtype_format_option_other));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onPrimaryAction() {
        getJumioViewModel$jumio_defaultui_release().a(getJumioViewModel$jumio_defaultui_release().k(), toJumioPhysicalDocument(JumioDocumentVariant.PLASTIC));
    }

    public void onSecondaryAction() {
        getJumioViewModel$jumio_defaultui_release().a(getJumioViewModel$jumio_defaultui_release().k(), toJumioPhysicalDocument(JumioDocumentVariant.PAPER));
    }
}
