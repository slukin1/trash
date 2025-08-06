package com.luck.picture.lib;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;
import java.util.ArrayList;
import java.util.List;

public class PictureSelectorSystemFragment extends PictureCommonFragment {
    public static final String TAG = PictureSelectorSystemFragment.class.getSimpleName();
    private ActivityResultLauncher<String> mContentLauncher;
    private ActivityResultLauncher<String> mContentsLauncher;
    private ActivityResultLauncher<String> mDocMultipleLauncher;
    private ActivityResultLauncher<String> mDocSingleLauncher;

    private void createContent() {
        this.mContentLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() {
            public Intent createIntent(Context context, String str) {
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                }
                if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                }
                return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }

            public Uri parseResult(int i11, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() {
            public void onActivityResult(Uri uri) {
                if (uri == null) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                LocalMedia access$900 = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                access$900.setPath(SdkVersionUtils.isQ() ? access$900.getPath() : access$900.getRealPath());
                if (PictureSelectorSystemFragment.this.confirmSelect(access$900, false) == 0) {
                    PictureSelectorSystemFragment.this.dispatchTransformResult();
                } else {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                }
            }
        });
    }

    private void createMultipleContents() {
        this.mContentsLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() {
            public Intent createIntent(Context context, String str) {
                Intent intent;
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                } else if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                return intent;
            }

            public List<Uri> parseResult(int i11, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i12 = 0; i12 < itemCount; i12++) {
                        arrayList.add(clipData.getItemAt(i12).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() {
            public void onActivityResult(List<Uri> list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                for (int i11 = 0; i11 < list.size(); i11++) {
                    LocalMedia access$600 = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i11).toString());
                    access$600.setPath(SdkVersionUtils.isQ() ? access$600.getPath() : access$600.getRealPath());
                    PictureSelectorSystemFragment.this.selectorConfig.addSelectResult(access$600);
                }
                PictureSelectorSystemFragment.this.dispatchTransformResult();
            }
        });
    }

    private void createMultipleDocuments() {
        this.mDocMultipleLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() {
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType(str);
                return intent;
            }

            public List<Uri> parseResult(int i11, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i12 = 0; i12 < itemCount; i12++) {
                        arrayList.add(clipData.getItemAt(i12).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() {
            public void onActivityResult(List<Uri> list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                for (int i11 = 0; i11 < list.size(); i11++) {
                    LocalMedia access$100 = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i11).toString());
                    access$100.setPath(SdkVersionUtils.isQ() ? access$100.getPath() : access$100.getRealPath());
                    PictureSelectorSystemFragment.this.selectorConfig.addSelectResult(access$100);
                }
                PictureSelectorSystemFragment.this.dispatchTransformResult();
            }
        });
    }

    private void createSingleDocuments() {
        this.mDocSingleLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() {
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(str);
                return intent;
            }

            public Uri parseResult(int i11, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() {
            public void onActivityResult(Uri uri) {
                if (uri == null) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                LocalMedia access$400 = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                access$400.setPath(SdkVersionUtils.isQ() ? access$400.getPath() : access$400.getRealPath());
                if (PictureSelectorSystemFragment.this.confirmSelect(access$400, false) == 0) {
                    PictureSelectorSystemFragment.this.dispatchTransformResult();
                } else {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                }
            }
        });
    }

    private void createSystemContracts() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1) {
            if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                createSingleDocuments();
            } else {
                createContent();
            }
        } else if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            createMultipleDocuments();
        } else {
            createMultipleContents();
        }
    }

    private String getInput() {
        if (this.selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            return SelectMimeType.SYSTEM_VIDEO;
        }
        return this.selectorConfig.chooseMode == SelectMimeType.ofAudio() ? SelectMimeType.SYSTEM_AUDIO : SelectMimeType.SYSTEM_IMAGE;
    }

    public static PictureSelectorSystemFragment newInstance() {
        return new PictureSelectorSystemFragment();
    }

    /* access modifiers changed from: private */
    public void openSystemAlbum() {
        onPermissionExplainEvent(false, (String[]) null);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1) {
            if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                this.mDocSingleLauncher.a(SelectMimeType.SYSTEM_ALL);
            } else {
                this.mContentLauncher.a(getInput());
            }
        } else if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            this.mDocMultipleLauncher.a(SelectMimeType.SYSTEM_ALL);
        } else {
            this.mContentsLauncher.a(getInput());
        }
    }

    public String getFragmentTag() {
        return TAG;
    }

    public int getResourceId() {
        return R.layout.ps_empty;
    }

    public void handlePermissionSettingResult(String[] strArr) {
        boolean z11;
        onPermissionExplainEvent(false, (String[]) null);
        SelectorConfig selectorConfig = this.selectorConfig;
        OnPermissionsInterceptListener onPermissionsInterceptListener = selectorConfig.onPermissionsEventListener;
        if (onPermissionsInterceptListener != null) {
            z11 = onPermissionsInterceptListener.hasPermissions(this, strArr);
        } else {
            z11 = PermissionChecker.isCheckReadStorage(selectorConfig.chooseMode, getContext());
        }
        if (z11) {
            openSystemAlbum();
        } else {
            ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 0) {
            onKeyBackFragmentFinish();
        }
    }

    public void onApplyPermissionsEvent(int i11, String[] strArr) {
        if (i11 == -2) {
            this.selectorConfig.onPermissionsEventListener.requestPermission(this, PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode), new OnRequestPermissionListener() {
                public void onCall(String[] strArr, boolean z11) {
                    if (z11) {
                        PictureSelectorSystemFragment.this.openSystemAlbum();
                    } else {
                        PictureSelectorSystemFragment.this.handlePermissionDenied(strArr);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityResultLauncher<String> activityResultLauncher = this.mDocMultipleLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
        }
        ActivityResultLauncher<String> activityResultLauncher2 = this.mDocSingleLauncher;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.c();
        }
        ActivityResultLauncher<String> activityResultLauncher3 = this.mContentsLauncher;
        if (activityResultLauncher3 != null) {
            activityResultLauncher3.c();
        }
        ActivityResultLauncher<String> activityResultLauncher4 = this.mContentLauncher;
        if (activityResultLauncher4 != null) {
            activityResultLauncher4.c();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        createSystemContracts();
        if (PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext())) {
            openSystemAlbum();
            return;
        }
        final String[] readPermissionArray = PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode);
        onPermissionExplainEvent(true, readPermissionArray);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(-2, readPermissionArray);
        } else {
            PermissionChecker.getInstance().requestPermissions((Fragment) this, readPermissionArray, (PermissionResultCallback) new PermissionResultCallback() {
                public void onDenied() {
                    PictureSelectorSystemFragment.this.handlePermissionDenied(readPermissionArray);
                }

                public void onGranted() {
                    PictureSelectorSystemFragment.this.openSystemAlbum();
                }
            });
        }
    }
}
