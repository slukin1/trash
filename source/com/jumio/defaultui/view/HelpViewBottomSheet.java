package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.defaultui.R;
import com.jumio.sdk.scanpart.JumioScanPart;
import kotlin.jvm.internal.r;
import zendesk.support.request.DocumentRenderer;

public final class HelpViewBottomSheet extends JumioBottomSheet<String[]> {
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ HelpViewBottomSheet newInstance$default(Companion companion, String str, String[] strArr, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = "";
            }
            if ((i11 & 2) != 0) {
                strArr = new String[0];
            }
            if ((i11 & 4) != 0) {
                str2 = "";
            }
            if ((i11 & 8) != 0) {
                str3 = "";
            }
            return companion.newInstance(str, strArr, str2, str3);
        }

        public final HelpViewBottomSheet newInstance(String str, String[] strArr, String str2, String str3) {
            HelpViewBottomSheet helpViewBottomSheet = new HelpViewBottomSheet();
            helpViewBottomSheet.setTitle(str);
            helpViewBottomSheet.setDescriptions(strArr);
            helpViewBottomSheet.setPrimaryActionButtonText(str2);
            helpViewBottomSheet.setSecondaryActionButtonText(str3);
            return helpViewBottomSheet;
        }
    }

    private final void initDescription(RecyclerView recyclerView, String[] strArr) {
        recyclerView.setAdapter(new BulletPointAdapter(DocumentRenderer.Style.Li.UNICODE_BULLET, strArr, R.layout.jumio_fragment_bottom_sheet_help_item));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            setDescriptions(bundle.getStringArray("JUMIO_BOTTOM_SHEET_DESCRIPTION"));
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDismiss() {
        getJumioViewModel$jumio_defaultui_release().f56364l.setValue(Boolean.FALSE);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArray("JUMIO_BOTTOM_SHEET_DESCRIPTION", (String[]) getDescriptions());
    }

    public void onSecondaryAction() {
        JumioScanPart j11 = getJumioViewModel$jumio_defaultui_release().j();
        if (j11 != null) {
            j11.fallback();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.tv_description_container);
        String[] strArr = (String[]) getDescriptions();
        if (strArr != null) {
            initDescription(recyclerView, strArr);
        }
        getJumioViewModel$jumio_defaultui_release().f56364l.setValue(Boolean.TRUE);
    }
}
