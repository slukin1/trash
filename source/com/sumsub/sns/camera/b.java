package com.sumsub.sns.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.internal.camera.b;
import com.sumsub.sns.internal.camera.c;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.h;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.j;
import com.sumsub.sns.internal.core.common.l;
import d10.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\r\b&\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0013B\u0007¢\u0006\u0004\b-\u0010.J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010\r8$X¤\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/sumsub/sns/camera/b;", "Lcom/sumsub/sns/internal/camera/b;", "VM", "Lcom/sumsub/sns/camera/a;", "", "", "", "grantResults", "", "handlePermissionResults", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "onDestroy", "Lcom/sumsub/sns/internal/camera/c$b;", "state", "a", "outState", "onSaveInstanceState", "Landroid/net/Uri;", "uri", "K", "L", "Lcom/sumsub/sns/internal/core/android/a;", "j", "Lcom/sumsub/sns/internal/core/android/a;", "pickerLifecycleObserver", "Landroidx/appcompat/app/AlertDialog;", "k", "Landroidx/appcompat/app/AlertDialog;", "lackOfPermissionsDialog", "Landroidx/activity/result/ActivityResultLauncher;", "", "l", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "J", "()Landroid/view/View;", "takeGalleryView", "I", "()Ljava/lang/String;", "pickerMimeType", "<init>", "()V", "m", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class b<VM extends com.sumsub.sns.internal.camera.b> extends a<VM> {

    /* renamed from: m  reason: collision with root package name */
    public static final a f30577m = new a((r) null);

    /* renamed from: n  reason: collision with root package name */
    public static final String f30578n = "last_picker_request_id";

    /* renamed from: j  reason: collision with root package name */
    public com.sumsub.sns.internal.core.android.a f30579j;

    /* renamed from: k  reason: collision with root package name */
    public AlertDialog f30580k;

    /* renamed from: l  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f30581l;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: com.sumsub.sns.camera.b$b  reason: collision with other inner class name */
    public static final class C0272b extends Lambda implements p<String, Uri, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<VM> f30582a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0272b(b<VM> bVar) {
            super(2);
            this.f30582a = bVar;
        }

        public final void a(String str, Uri uri) {
            this.f30582a.a(uri);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (Uri) obj2);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<VM> f30583a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b<VM> bVar) {
            super(0);
            this.f30583a = bVar;
        }

        public final void a() {
            this.f30583a.L();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.camera.SNSCameraPhotoFragment$onViewCreated$2", f = "SNSCameraPhotoFragment.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30584a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30585b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b<VM> f30586c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b<VM> bVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f30586c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f30586c, cVar);
            dVar.f30585b = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30584a == 0) {
                k.b(obj);
                b.a aVar = (b.a) this.f30585b;
                this.f30586c.f30580k = new SNSAlertDialogBuilder(this.f30586c.requireContext()).setMessage(aVar.f()).setPositiveButton(aVar.e(), (DialogInterface.OnClickListener) null).setNeutralButton(aVar.d(), (DialogInterface.OnClickListener) new h(this.f30586c)).create();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static final void a(b bVar, DialogInterface dialogInterface, int i11) {
            i.a((Activity) bVar.requireActivity());
        }
    }

    private final void handlePermissionResults(Map<String, Boolean> map) {
        AlertDialog alertDialog;
        if (x.b(map.get(PermissionConfig.READ_EXTERNAL_STORAGE), Boolean.TRUE)) {
            K();
        } else if (x.b(map.get(PermissionConfig.READ_EXTERNAL_STORAGE), Boolean.FALSE) && (alertDialog = this.f30580k) != null) {
            alertDialog.show();
        }
    }

    public final String I() {
        return getResources().getString(R.string.sns_gallery_type);
    }

    public abstract View J();

    public final void K() {
        com.sumsub.sns.internal.core.android.a aVar = this.f30579j;
        if (aVar != null && !aVar.a(String.valueOf(System.currentTimeMillis()))) {
            ((com.sumsub.sns.internal.camera.b) getViewModel()).B();
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void L() {
        if (Build.VERSION.SDK_INT > 28 || j.a(requireContext(), PermissionConfig.READ_EXTERNAL_STORAGE)) {
            K();
            return;
        }
        ActivityResultLauncher<String[]> activityResultLauncher = this.f30581l;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(new String[]{PermissionConfig.READ_EXTERNAL_STORAGE});
        }
    }

    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        com.sumsub.sns.internal.core.android.a aVar = new com.sumsub.sns.internal.core.android.a(requireActivity().getActivityResultRegistry(), (String) null, h.a(I()), new C0272b(this), (p) null, 18, (r) null);
        if (!(bundle == null || (string = bundle.getString(f30578n)) == null)) {
            aVar.c(string);
        }
        getLifecycle().a(aVar);
        this.f30579j = aVar;
    }

    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f30580k;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f30580k = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        String b11;
        com.sumsub.sns.internal.core.android.a aVar = this.f30579j;
        if (!(aVar == null || (b11 = aVar.b()) == null)) {
            bundle.putString(f30578n, b11);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        Integer a11;
        super.onViewCreated(view, bundle);
        View J = J();
        if (J != null) {
            J.setVisibility(((com.sumsub.sns.internal.camera.b) getViewModel()).z() ? 0 : 8);
            Drawable onResolveIcon = e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.GALLERY.getImageName());
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            SNSColorElement sNSColorElement = SNSColorElement.CAMERA_CONTENT;
            com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
            if (a12 == null || (a11 = aVar.a(a12, sNSColorElement, aVar.a(J))) == null) {
                unit = null;
            } else {
                int intValue = a11.intValue();
                if (onResolveIcon != null) {
                    onResolveIcon.setColorFilter(new PorterDuffColorFilter(intValue, PorterDuff.Mode.SRC_IN));
                }
                unit = Unit.f56620a;
            }
            if (unit == null) {
                int color = ContextCompat.getColor(J.getContext(), R.color.sns_camera_content);
                if (onResolveIcon != null) {
                    onResolveIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
                }
            }
            ImageView imageView = J instanceof ImageView ? (ImageView) J : null;
            if (imageView != null) {
                imageView.setImageDrawable(onResolveIcon);
            }
            l.a(J, (d10.a<Unit>) new c(this));
        }
        b0.b(((com.sumsub.sns.internal.camera.b) getViewModel()).A(), (LifecycleOwner) this, new d(this, (kotlin.coroutines.c<? super d>) null));
        this.f30581l = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new g(this));
    }

    public static final void a(b bVar, Map map) {
        bVar.handlePermissionResults(map);
    }

    public void a(c.b bVar) {
        View J = J();
        if (J != null) {
            int i11 = 0;
            if (!(bVar.j() && ((com.sumsub.sns.internal.camera.b) getViewModel()).z())) {
                i11 = 8;
            }
            J.setVisibility(i11);
        }
    }

    public final void a(Uri uri) {
        if (uri != null) {
            try {
                ((com.sumsub.sns.internal.camera.b) getViewModel()).a(requireContext().getApplicationContext(), I(), uri);
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a(this);
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                aVar.e(a11, message, e11);
            }
        }
    }
}
