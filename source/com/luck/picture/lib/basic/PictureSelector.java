package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public final class PictureSelector {
    private final SoftReference<Activity> mActivity;
    private final SoftReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, (Fragment) null);
    }

    public static PictureSelector create(Context context) {
        return new PictureSelector((Activity) context);
    }

    public static ArrayList<LocalMedia> obtainSelectorList(Intent intent) {
        if (intent == null) {
            return new ArrayList<>();
        }
        ArrayList<LocalMedia> parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION);
        return parcelableArrayListExtra != null ? parcelableArrayListExtra : new ArrayList<>();
    }

    public static Intent putIntentResult(ArrayList<LocalMedia> arrayList) {
        return new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, arrayList);
    }

    public PictureSelectionQueryModel dataSource(int i11) {
        return new PictureSelectionQueryModel(this, i11);
    }

    public Activity getActivity() {
        return this.mActivity.get();
    }

    public Fragment getFragment() {
        SoftReference<Fragment> softReference = this.mFragment;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public PictureSelectionCameraModel openCamera(int i11) {
        return new PictureSelectionCameraModel(this, i11);
    }

    public PictureSelectionModel openGallery(int i11) {
        return new PictureSelectionModel(this, i11);
    }

    public PictureSelectionPreviewModel openPreview() {
        return new PictureSelectionPreviewModel(this);
    }

    public PictureSelectionSystemModel openSystemGallery(int i11) {
        return new PictureSelectionSystemModel(this, i11);
    }

    private PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static PictureSelector create(AppCompatActivity appCompatActivity) {
        return new PictureSelector((Activity) appCompatActivity);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new SoftReference<>(activity);
        this.mFragment = new SoftReference<>(fragment);
    }

    public static PictureSelector create(FragmentActivity fragmentActivity) {
        return new PictureSelector((Activity) fragmentActivity);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }
}
