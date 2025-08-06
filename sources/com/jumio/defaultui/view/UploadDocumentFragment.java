package com.jumio.defaultui.view;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioFileAttacher;
import d10.a;
import d10.l;
import java.util.Arrays;
import jumio.dui.b;
import jumio.dui.f;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import pw.w;
import pw.x;
import pw.y;
import zendesk.support.request.DocumentRenderer;

public final class UploadDocumentFragment extends BaseFragment {
    public static final Companion Companion = new Companion((r) null);
    private static String TAG = "UploadDocumentFragment";
    private final z<ActivityResult> activityResultObserver = new x(this);
    private MaterialButton chooseFileButton;
    private AppCompatTextView descriptionTextView;
    private final JumioFileAttacher fileAttacher = new JumioFileAttacher();
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new UploadDocumentFragment$special$$inlined$activityViewModels$default$1(this), new UploadDocumentFragment$special$$inlined$activityViewModels$default$2((a) null, this), new UploadDocumentFragment$special$$inlined$activityViewModels$default$3(this));
    private JumioRetryReason retryReason;
    private View rootLayout;
    private final z<JumioScanStep> scanStepObserver = new y(this);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JumioScanStep.values().length];
            try {
                iArr[JumioScanStep.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final void activityResultObserver$lambda$2(UploadDocumentFragment uploadDocumentFragment, ActivityResult activityResult) {
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        if (activityResult.getResultCode() == -1) {
            try {
                Intent data = activityResult.getData();
                if (data != null) {
                    Uri data2 = data.getData();
                    if (data2 != null) {
                        FragmentActivity activity = uploadDocumentFragment.getActivity();
                        if (activity == null || (contentResolver = activity.getContentResolver()) == null || (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r")) == null) {
                            throw new Exception("Could not open file descriptor");
                        }
                        uploadDocumentFragment.fileAttacher.setFileDescriptor(openFileDescriptor);
                        try {
                            int fd2 = openFileDescriptor.getFd();
                            uploadDocumentFragment.getJumioViewModel().c(StringsKt__StringsKt.a1(Os.readlink("/proc/self/fd/" + fd2), "/", (String) null, 2, (Object) null));
                        } catch (Exception e11) {
                            Log.printStackTrace(e11);
                        }
                    } else {
                        throw new Exception("Could not get Uri");
                    }
                }
            } catch (Exception e12) {
                AppCompatTextView appCompatTextView = uploadDocumentFragment.descriptionTextView;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(uploadDocumentFragment.getString(R.string.jumio_dv_retry_not_readable));
                }
                Toast.makeText(uploadDocumentFragment.getContext(), e12.getMessage(), 0).show();
            }
        } else {
            View view = uploadDocumentFragment.rootLayout;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void createLayout$lambda$5(UploadDocumentFragment uploadDocumentFragment, JumioFileAttacher.JumioFileRequirements jumioFileRequirements, View view) {
        ActivityResultLauncher<Intent> launcher;
        View view2 = uploadDocumentFragment.rootLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) jumioFileRequirements.getMimeTypes().toArray(new String[0]));
        try {
            JumioFragmentCallback callback = uploadDocumentFragment.getCallback();
            if (callback != null && (launcher = callback.getLauncher()) != null) {
                launcher.a(intent);
            }
        } catch (Exception unused) {
            AppCompatTextView appCompatTextView = uploadDocumentFragment.descriptionTextView;
            if (appCompatTextView != null) {
                appCompatTextView.setText(uploadDocumentFragment.getString(R.string.jumio_dv_retry_not_readable));
            }
        }
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        f<ActivityResult> lastActivityResult;
        getJumioViewModel().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
        JumioFragmentCallback callback = getCallback();
        if (callback != null && (lastActivityResult = callback.getLastActivityResult()) != null) {
            lastActivityResult.observe(getViewLifecycleOwner(), this.activityResultObserver);
        }
    }

    /* access modifiers changed from: private */
    public static final void scanStepObserver$lambda$0(UploadDocumentFragment uploadDocumentFragment, JumioScanStep jumioScanStep) {
        int i11;
        String str = TAG;
        String str2 = null;
        String name = jumioScanStep != null ? jumioScanStep.name() : null;
        Log.i(str, "Event " + name + " received");
        if (jumioScanStep == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()];
        }
        if (i11 == 1) {
            View view = uploadDocumentFragment.rootLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            if (uploadDocumentFragment.getJumioViewModel().i() != null) {
                JumioRetryReason i12 = uploadDocumentFragment.getJumioViewModel().i();
                uploadDocumentFragment.retryReason = i12;
                AppCompatTextView appCompatTextView = uploadDocumentFragment.descriptionTextView;
                if (appCompatTextView != null) {
                    if (i12 != null) {
                        str2 = i12.getMessage();
                    }
                    appCompatTextView.setText(str2);
                }
            }
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_upload_document, viewGroup, false);
        MaterialButton materialButton = null;
        this.rootLayout = inflate != null ? inflate.findViewById(R.id.upload_document_layout) : null;
        this.descriptionTextView = inflate != null ? (AppCompatTextView) inflate.findViewById(R.id.descriptionTextView) : null;
        if (inflate != null) {
            materialButton = (MaterialButton) inflate.findViewById(R.id.chooseFileButton);
        }
        this.chooseFileButton = materialButton;
        getJumioViewModel().c("");
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            this.fileAttacher.attach(j11);
        }
        JumioFileAttacher.JumioFileRequirements requirements = this.fileAttacher.getRequirements();
        MaterialButton materialButton2 = this.chooseFileButton;
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new w(this, requirements));
        }
        AppCompatTextView appCompatTextView = this.descriptionTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setText(CollectionsKt___CollectionsKt.k0(CollectionsKt__CollectionsKt.n(getString(R.string.jumio_dv_upload_tips_file_size, String.format("%dMB", Arrays.copyOf(new Object[]{Integer.valueOf(requirements.getMaxFileSize() / 1048576)}, 1))), getString(R.string.jumio_dv_upload_tips_page_size, Integer.valueOf(requirements.getPdfMaxPages())), getString(R.string.jumio_dv_upload_tips_protected)), "\n" + DocumentRenderer.Style.Li.UNICODE_BULLET + " ", DocumentRenderer.Style.Li.UNICODE_BULLET + " ", (CharSequence) null, 0, (CharSequence) null, (l) null, 60, (Object) null));
        }
        return inflate;
    }

    public void onDestroyView() {
        f<ActivityResult> lastActivityResult;
        super.onDestroyView();
        JumioFragmentCallback callback = getCallback();
        if (!(callback == null || (lastActivityResult = callback.getLastActivityResult()) == null)) {
            lastActivityResult.removeObserver(this.activityResultObserver);
        }
        this.descriptionTextView = null;
        this.chooseFileButton = null;
        this.rootLayout = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initObservers();
    }
}
