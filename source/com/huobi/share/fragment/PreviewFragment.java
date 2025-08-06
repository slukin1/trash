package com.huobi.share.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.huobi.invite.bean.InvitePosterListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import pro.huobi.R;

public class PreviewFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public InvitePosterListItem f80984b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f80985c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f80986d;

    /* renamed from: e  reason: collision with root package name */
    public int f80987e;

    /* renamed from: f  reason: collision with root package name */
    public c f80988f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f80989g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            PreviewFragment.this.f80985c.setChecked(!PreviewFragment.this.f80985c.isChecked());
            if (!PreviewFragment.this.f80985c.isChecked()) {
                PreviewFragment.this.f80985c.setVisibility(4);
            } else {
                PreviewFragment.this.f80985c.setVisibility(0);
            }
            PreviewFragment.this.f80988f.a(PreviewFragment.this.f80987e, PreviewFragment.this.f80985c.isChecked(), PreviewFragment.this.f80984b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            PreviewFragment.this.f80985c.setChecked(!PreviewFragment.this.f80985c.isChecked());
            if (!PreviewFragment.this.f80985c.isChecked()) {
                PreviewFragment.this.f80985c.setVisibility(4);
            } else {
                PreviewFragment.this.f80985c.setVisibility(0);
            }
            PreviewFragment.this.f80988f.a(PreviewFragment.this.f80987e, PreviewFragment.this.f80985c.isChecked(), PreviewFragment.this.f80984b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface c {
        void a(int i11, boolean z11, InvitePosterListItem invitePosterListItem);
    }

    public static PreviewFragment th(int i11) {
        PreviewFragment previewFragment = new PreviewFragment();
        previewFragment.f80987e = i11;
        return previewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.item_share_poster, (ViewGroup) null);
        this.f80986d = (ImageView) inflate.findViewById(R.id.poster_image);
        this.f80985c = (CheckBox) inflate.findViewById(R.id.checked_poster);
        this.f80989g = (ViewGroup) inflate.findViewById(R.id.poster_mask);
        this.f80985c.setChecked(false);
        this.f80986d.setOnClickListener(new a());
        InvitePosterListItem invitePosterListItem = this.f80984b;
        if (!(invitePosterListItem == null || invitePosterListItem.d() == null || this.f80984b.d().getImg() == null || this.f80984b.d().getImg().isEmpty())) {
            g6.b.c().h(this.f80986d, this.f80984b.d().getImg());
        }
        this.f80985c.setOnClickListener(new b());
        return inflate;
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

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void uh(c cVar) {
        this.f80988f = cVar;
    }

    public void vh(boolean z11) {
        this.f80985c.setChecked(z11);
    }

    public void wh(boolean z11) {
        this.f80989g.setVisibility(z11 ? 0 : 4);
    }

    public void xh(InvitePosterListItem invitePosterListItem) {
        this.f80984b = invitePosterListItem;
    }
}
