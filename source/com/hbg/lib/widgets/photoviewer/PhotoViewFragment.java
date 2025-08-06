package com.hbg.lib.widgets.photoviewer;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hbg.lib.widgets.R$anim;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.photoviewer.DragPhotoView;
import com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import ia.e;
import ia.g;
import java.io.File;

public class PhotoViewFragment extends Fragment implements DragPhotoView.f {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f72134b;

    /* renamed from: c  reason: collision with root package name */
    public DragPhotoView f72135c;

    /* renamed from: d  reason: collision with root package name */
    public SubsamplingScaleImageView.DefaultOnImageEventListener f72136d = new a();

    public class a extends SubsamplingScaleImageView.DefaultOnImageEventListener {
        public a() {
        }

        public void onImageLoadError(Exception exc) {
            super.onImageLoadError(exc);
            PhotoViewFragment.this.f72134b.setVisibility(8);
        }

        public void onImageLoaded() {
            super.onImageLoaded();
            PhotoViewFragment.this.f72134b.setVisibility(8);
        }
    }

    public class b extends SimpleTarget<File> {
        public b() {
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
        }

        public void onResourceReady(File file, com.bumptech.glide.request.transition.a<? super File> aVar) {
            PhotoViewFragment.this.f72135c.setImage(e.m(Uri.fromFile(file)));
            PhotoViewFragment.this.f72135c.F0(1.5f, new PointF(0.0f, 0.0f));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean sh(ImageData imageData, View view) {
        PhotoViewConfig.a().a(requireActivity(), imageData.getImage());
        return true;
    }

    public static PhotoViewFragment uh(ImageData imageData) {
        PhotoViewFragment photoViewFragment = new PhotoViewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("argumens-image", imageData);
        photoViewFragment.setArguments(bundle);
        return photoViewFragment;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        onDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_raw_imageview_item, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f72135c.setDismissListener((DragPhotoView.f) null);
    }

    public void onDismiss() {
        this.f72136d = null;
        this.f72135c.u1();
        if (getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    public boolean onLongClick(View view) {
        return true;
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
        DragPhotoView dragPhotoView = (DragPhotoView) view.findViewById(R$id.siv_raw_imageview);
        this.f72135c = dragPhotoView;
        dragPhotoView.setDismissListener(this);
        this.f72135c.setDoubleTapZoomScale(4.0f);
        this.f72135c.setMaxScale(8.0f);
        this.f72135c.setOnImageEventListener(this.f72136d);
        this.f72134b = (ProgressBar) view.findViewById(R$id.progressbar);
        th();
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void th() {
        ImageData imageData = (ImageData) getArguments().getParcelable("argumens-image");
        this.f72135c.setOnLongClickListener(new g(this, imageData));
        com.bumptech.glide.a.x(this).h().M0(imageData.getImage()).A0(new b());
    }
}
