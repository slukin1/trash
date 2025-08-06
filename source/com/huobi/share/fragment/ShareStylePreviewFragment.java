package com.huobi.share.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.share.bean.PreviewItem;
import com.huobi.share.view.RiseDownProgressBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import pro.huobi.R;

public class ShareStylePreviewFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public int f80992b;

    /* renamed from: c  reason: collision with root package name */
    public PreviewItem f80993c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f80994d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f80995e;

    /* renamed from: f  reason: collision with root package name */
    public NestedScrollView f80996f;

    public static ShareStylePreviewFragment ph(int i11, PreviewItem previewItem) {
        ShareStylePreviewFragment shareStylePreviewFragment = new ShareStylePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("arg_index", i11);
        bundle.putSerializable("arg_item", previewItem);
        shareStylePreviewFragment.setArguments(bundle);
        return shareStylePreviewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f80992b = arguments.getInt("arg_index");
            this.f80993c = (PreviewItem) arguments.getSerializable("arg_item");
        }
        View inflate2 = layoutInflater.inflate(R.layout.fragment_share_style_preview, (ViewGroup) null);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.preview_root_container);
        if (!(this.f80993c.getLayoutRes() == 0 || (inflate = layoutInflater.inflate(this.f80993c.getLayoutRes(), (ViewGroup) null)) == null)) {
            viewGroup2.addView(inflate);
        }
        TextView textView = (TextView) inflate2.findViewById(R.id.share_issue_time_tv);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.share_title);
        TextView textView3 = (TextView) inflate2.findViewById(R.id.share_content);
        this.f80994d = (ImageView) inflate2.findViewById(R.id.share_content_img);
        RiseDownProgressBar riseDownProgressBar = (RiseDownProgressBar) inflate2.findViewById(R.id.id_share_progressBar);
        this.f80995e = (ViewGroup) inflate2.findViewById(R.id.share_page_mask);
        this.f80996f = (NestedScrollView) inflate2.findViewById(R.id.preview_scroll_container);
        String i11 = DateTimeUtils.i(this.f80993c.getIssueTime(), "EEEE MM-dd HH:mm", AppLanguageHelper.getInstance().getCurAppLocale());
        if (textView != null) {
            textView.setText(i11);
        }
        if (textView2 != null && !TextUtils.isEmpty(this.f80993c.getTitle())) {
            textView2.setText(this.f80993c.getTitle());
        }
        if (textView3 != null) {
            if (!TextUtils.isEmpty(this.f80993c.getContent())) {
                textView3.setText(this.f80993c.getContent());
            } else {
                textView3.setVisibility(8);
            }
        }
        if (riseDownProgressBar != null) {
            riseDownProgressBar.b(this.f80993c.getRaiseNumber(), this.f80993c.getDownNumber());
        }
        if (!(this.f80994d == null || this.f80993c.getContentBmp() == null)) {
            this.f80994d.setImageBitmap(this.f80993c.getContentBmp());
        }
        return inflate2;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void qh(boolean z11) {
        NestedScrollView nestedScrollView;
        this.f80995e.setVisibility(z11 ? 0 : 8);
        if (!z11 && (nestedScrollView = this.f80996f) != null) {
            nestedScrollView.scrollTo(0, 0);
        }
    }

    public void rh(PreviewItem previewItem) {
        this.f80993c = previewItem;
        if (this.f80994d != null && previewItem.getContentBmp() != null) {
            this.f80994d.setImageBitmap(previewItem.getContentBmp());
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
