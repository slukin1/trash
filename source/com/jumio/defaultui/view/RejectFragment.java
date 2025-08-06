package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.handler.JumioRejectHandler;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioRejectView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.Map;
import jumio.dui.e;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import zendesk.support.request.DocumentRenderer;

public final class RejectFragment extends BaseFragment implements View.OnClickListener {
    private AppCompatTextView descriptionTextView;
    private IndicatorView indicatorView;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(jumio.dui.b.class), new RejectFragment$special$$inlined$activityViewModels$default$1(this), new RejectFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new RejectFragment$special$$inlined$activityViewModels$default$3(this));
    private MaterialButton rejectButton;
    private JumioRejectHandler rejectHandler = new JumioRejectHandler();
    private e rejectHandlerAdapter = new e(b.f70841a);
    private AppCompatTextView rejectTitle;
    private ViewPager2 rejectView;
    private RecyclerView tipsView;

    public final class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        public final void onPageSelected(int i11) {
            RejectFragment.this.updateUiWithReasonFromPosition(i11);
        }
    }

    public static final class b extends Lambda implements l<Context, JumioRejectView> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f70841a = new b();

        public b() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Context context = (Context) obj;
            JumioRejectView jumioRejectView = new JumioRejectView(context, (AttributeSet) null, 0, 0, 14, (r) null);
            jumioRejectView.setCornerRadius(ScreenUtil.dpToPx(context, 8));
            jumioRejectView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return jumioRejectView;
        }
    }

    /* access modifiers changed from: private */
    public final jumio.dui.b getJumioViewModel() {
        return (jumio.dui.b) this.jumioViewModel$delegate.getValue();
    }

    private final String[] getTipsText(ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
        for (Number intValue : arrayList) {
            arrayList2.add(getString(intValue.intValue()));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    /* access modifiers changed from: private */
    public final void retakeImage() {
        this.rejectHandler.retake();
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.retakeImage();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r3.equals(com.jumio.sdk.reject.JumioRejectReason.HIDDEN_PART_DOC) == false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r3.equals(com.jumio.sdk.reject.JumioRejectReason.MISSING_PART_DOC) == false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_part_doc_title;
        r0.add(java.lang.Integer.valueOf(com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_tip_whole_document));
        r0.add(java.lang.Integer.valueOf(com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_tip_hand));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateUiWithReason(java.lang.String r3) {
        /*
            r2 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0145
            int r1 = r3.hashCode()
            switch(r1) {
                case 48627: goto L_0x0127;
                case 48628: goto L_0x0112;
                case 48629: goto L_0x00fd;
                case 49586: goto L_0x00d6;
                case 49587: goto L_0x00bf;
                case 49592: goto L_0x00a8;
                case 49621: goto L_0x0091;
                case 1537215: goto L_0x0071;
                case 1537217: goto L_0x0051;
                case 1537218: goto L_0x0047;
                case 1537219: goto L_0x0030;
                case 1537220: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0145
        L_0x0010:
            java.lang.String r1 = "2006"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x001a
            goto L_0x0145
        L_0x001a:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_glare_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_glare_tip_lighting
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_glare_tip_glare
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0030:
            java.lang.String r1 = "2005"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003a
            goto L_0x0145
        L_0x003a:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_damaged_doc_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_damaged_doc_tip_different_doc
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0047:
            java.lang.String r1 = "2004"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x005b
            goto L_0x0145
        L_0x0051:
            java.lang.String r1 = "2003"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x005b
            goto L_0x0145
        L_0x005b:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_part_doc_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_tip_whole_document
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_tip_hand
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0071:
            java.lang.String r1 = "2001"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x007b
            goto L_0x0145
        L_0x007b:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_blurry_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_blurry_tip_hold_steady
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_blurry_tip_readable
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0091:
            java.lang.String r1 = "214"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x009b
            goto L_0x0145
        L_0x009b:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_front_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_front_tip_front_side_doc
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x00a8:
            java.lang.String r1 = "206"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00b2
            goto L_0x0145
        L_0x00b2:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_back_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_missing_back_tip_back_side_doc
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x00bf:
            java.lang.String r1 = "201"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00c9
            goto L_0x0145
        L_0x00c9:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_no_doc_tip_gov_id
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x00d6:
            java.lang.String r1 = "200"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00df
            goto L_0x0145
        L_0x00df:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_not_readable_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_glare_tip_lighting
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_glare_tip_glare
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_blurry_tip_focus
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x00fd:
            java.lang.String r1 = "104"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0106
            goto L_0x0145
        L_0x0106:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_digital_copy_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_digital_copy_tip
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0112:
            java.lang.String r1 = "103"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x011b
            goto L_0x0145
        L_0x011b:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_color_photocopy_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_digital_copy_tip
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0127:
            java.lang.String r1 = "102"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0130
            goto L_0x0145
        L_0x0130:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_bw_copy_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_digital_copy_tip
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_bw_copy_tip_color_image
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0150
        L_0x0145:
            int r3 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_generic_title
            int r1 = com.jumio.defaultui.R.string.jumio_error_instant_feedback_generic_tip_genuine_doc
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
        L_0x0150:
            r2.updateUiWithReason(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.RejectFragment.updateUiWithReason(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void updateUiWithReasonFromPosition(int i11) {
        Map<JumioCredentialPart, String> h11;
        String str;
        JumioCredentialPart jumioCredentialPart = (JumioCredentialPart) CollectionsKt___CollectionsKt.d0(this.rejectHandler.getParts(), i11);
        if (jumioCredentialPart != null && (h11 = getJumioViewModel().h()) != null && (str = h11.get(jumioCredentialPart)) != null) {
            updateUiWithReason(str);
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_reject, viewGroup, false);
        this.rejectTitle = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_title);
        this.rejectView = (ViewPager2) inflate.findViewById(R.id.reject_fragment_reject_view);
        this.indicatorView = (IndicatorView) inflate.findViewById(R.id.reject_fragment_indicator_view);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.reject_fragment_retry_button);
        this.rejectButton = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        this.descriptionTextView = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_details_description);
        this.tipsView = (RecyclerView) inflate.findViewById(R.id.reject_fragment_details_tips);
        MaterialButton materialButton2 = this.rejectButton;
        if (materialButton2 != null) {
            materialButton2.setVisibility(0);
        }
        ViewPager2 viewPager2 = this.rejectView;
        if (viewPager2 != null) {
            AppCompatTextView appCompatTextView = this.descriptionTextView;
            viewPager2.setContentDescription(appCompatTextView != null ? appCompatTextView.getText() : null);
        }
        return inflate;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R.id.reject_fragment_retry_button;
        if (valueOf != null && valueOf.intValue() == i11) {
            retakeImage();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.rejectTitle = null;
        ViewPager2 viewPager2 = this.rejectView;
        if (viewPager2 != null) {
            viewPager2.setAdapter((RecyclerView.Adapter) null);
        }
        ViewPager2 viewPager22 = this.rejectView;
        if (viewPager22 != null) {
            viewPager22.removeAllViews();
        }
        this.rejectView = null;
        this.rejectButton = null;
        this.descriptionTextView = null;
        this.tipsView = null;
        this.indicatorView = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        IndicatorView indicatorView2;
        OnBackPressedDispatcher onBackPressedDispatcher;
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
            onBackPressedDispatcher.i(getViewLifecycleOwner(), new RejectFragment$onViewCreated$1(this));
        }
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            this.rejectHandler.attach(j11);
        }
        e eVar = this.rejectHandlerAdapter;
        eVar.f56392b = this.rejectHandler;
        ViewPager2 viewPager2 = this.rejectView;
        if (viewPager2 != null) {
            viewPager2.setAdapter(eVar);
            viewPager2.setOffscreenPageLimit(2);
            viewPager2.setPageTransformer(new MarginPageTransformer(ScreenUtil.dpToPx(viewPager2.getContext(), 16)));
            viewPager2.registerOnPageChangeCallback(new a());
        }
        ViewPager2 viewPager22 = this.rejectView;
        if (!(viewPager22 == null || (indicatorView2 = this.indicatorView) == null)) {
            indicatorView2.setupWithViewpager(viewPager22);
        }
        if (this.rejectHandlerAdapter.getItemCount() == 1) {
            AppCompatTextView appCompatTextView = this.rejectTitle;
            if (appCompatTextView != null) {
                appCompatTextView.setText(R.string.jumio_error_instant_feedback_one_image_retaken);
            }
            MaterialButton materialButton = this.rejectButton;
            if (materialButton != null) {
                materialButton.setText(R.string.jumio_error_button_retake_one);
            }
            ViewPager2 viewPager23 = this.rejectView;
            View childAt = viewPager23 != null ? viewPager23.getChildAt(0) : null;
            if (childAt != null) {
                childAt.setOverScrollMode(2);
            }
            IndicatorView indicatorView3 = this.indicatorView;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(4);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.rejectTitle;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(R.string.jumio_error_instant_feedback_both_images_retaken);
            }
            MaterialButton materialButton2 = this.rejectButton;
            if (materialButton2 != null) {
                materialButton2.setText(R.string.jumio_error_button_retake_both);
            }
        }
        updateUiWithReasonFromPosition(0);
    }

    private final void updateUiWithReason(int i11, ArrayList<Integer> arrayList) {
        AppCompatTextView appCompatTextView = this.descriptionTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(i11));
        }
        RecyclerView recyclerView = this.tipsView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(new BulletPointAdapter(DocumentRenderer.Style.Li.UNICODE_BULLET, getTipsText(arrayList), 0, 4, (r) null));
        }
    }
}
