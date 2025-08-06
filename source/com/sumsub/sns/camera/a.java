package com.sumsub.sns.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.appcompat.app.AlertDialog;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.view.y;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.camera.c;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.analytics.PermissionPayload;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.t0;
import com.sumsub.sns.internal.core.data.model.l;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0001\rB\t¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J.\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J2\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u001c\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004H$J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020#H\u0015J\b\u0010%\u001a\u00020\u0006H\u0004J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0004J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0014J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010'\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020\u0006H\u0014J#\u0010)\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0004\b)\u00101J\u0010\u0010\r\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0014J\u0010\u00106\u001a\u00020\f2\u0006\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J#\u0010<\u001a\u0004\u0018\u00010\f2\u0006\u0010:\u001a\u0002022\b\u0010\u001a\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b<\u0010=J,\u0010\r\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010?H\u0004R*\u0010F\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010A8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\r\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\r\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010HR\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010W\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0T\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010]\u001a\u00020X8\u0014X\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010`\u001a\u0004\u0018\u00010\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010bR\u0014\u0010f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010bR\u0014\u0010i\u001a\u0002028DX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR \u0010l\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR \u0010n\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bm\u0010kR \u0010p\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bo\u0010kR \u0010r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010kR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e8PX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010kR\u0016\u0010v\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0006\u001a\u0004\bu\u0010_R\u0016\u0010x\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0006\u001a\u0004\bw\u0010_R\u0016\u0010z\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0006\u001a\u0004\by\u0010_R\u0016\u0010|\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0006\u001a\u0004\b{\u0010_R\u0016\u0010~\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0006\u001a\u0004\b}\u0010_R\u0019\u0010\u0001\u001a\u0004\u0018\u000108$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010_R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u001e8$X¤\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010_R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/camera/a;", "Lcom/sumsub/sns/internal/camera/c;", "VM", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/camera/c$b;", "Lcom/sumsub/sns/internal/core/common/t0;", "", "D", "Lcom/sumsub/sns/internal/core/presentation/intro/f;", "stepInfo", "", "countryCode", "", "a", "", "", "instructionsData", "", "title", "brief", "details", "k", "G", "grantResults", "handlePermissionResults", "Lcom/sumsub/sns/core/presentation/base/a$n;", "event", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "onViewModelPrepared", "state", "Lcom/sumsub/sns/core/presentation/base/a$j;", "handleEvent", "H", "Ljava/io/File;", "file", "d", "b", "c", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX$c;", "F", "Landroidx/camera/core/ImageProxy;", "image", "Lcom/sumsub/sns/internal/core/domain/camera/c;", "exposure", "(Landroidx/camera/core/ImageProxy;Lcom/sumsub/sns/internal/core/domain/camera/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "peekHeight", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "onStart", "onStop", "onDestroyView", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "(ILandroid/view/KeyEvent;)Ljava/lang/Boolean;", "appear", "Lkotlin/Function0;", "onEnd", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "t", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "helperViewBehavior", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog;", "lackOfPermissionDialog", "Z", "waitingForReturnFromSettings", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "cameraX", "Lcom/sumsub/sns/internal/core/presentation/helper/camera/b;", "e", "Lcom/sumsub/sns/internal/core/presentation/helper/camera/b;", "helperState", "Landroidx/activity/result/ActivityResultLauncher;", "", "f", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "g", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "l", "()Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "cameraMode", "getPhotoMadeIndicator", "()Landroid/view/View;", "photoMadeIndicator", "isTransparentStatusBar", "()Z", "y", "shouldShowFlash", "E", "isFrontFacingCamera", "n", "()I", "fadeAnimationDuration", "getOpenPayload", "()Ljava/util/Map;", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "u", "permissionsPayload", "x", "rootView", "B", "takePictureViewContainer", "z", "takePictureProgressView", "A", "takePictureView", "w", "progressBar", "Lcom/sumsub/sns/core/widget/SNSToolbarView;", "C", "()Lcom/sumsub/sns/core/widget/SNSToolbarView;", "toolbar", "s", "helperView", "Landroid/widget/TextView;", "r", "()Landroid/widget/TextView;", "helperTitle", "Landroid/view/ViewGroup;", "q", "()Landroid/view/ViewGroup;", "helperDetailsFrame", "o", "helperBrief", "p", "helperDetails", "m", "darkOverlay", "Landroidx/camera/view/PreviewView;", "v", "()Landroidx/camera/view/PreviewView;", "previewView", "<init>", "()V", "h", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class a<VM extends com.sumsub.sns.internal.camera.c> extends com.sumsub.sns.core.presentation.b<c.b, VM> implements t0 {

    /* renamed from: h  reason: collision with root package name */
    public static final C0270a f30555h = new C0270a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final float f30556i = 0.7f;

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior<View> f30557a;

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f30558b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30559c;

    /* renamed from: d  reason: collision with root package name */
    public CameraX f30560d;

    /* renamed from: e  reason: collision with root package name */
    public com.sumsub.sns.internal.core.presentation.helper.camera.b f30561e;

    /* renamed from: f  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f30562f;

    /* renamed from: g  reason: collision with root package name */
    public final CameraX.Mode f30563g = CameraX.Mode.PHOTO;

    /* renamed from: com.sumsub.sns.camera.a$a  reason: collision with other inner class name */
    public static final class C0270a {
        public /* synthetic */ C0270a(r rVar) {
            this();
        }

        public C0270a() {
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f30564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f30565b;

        public b(View view, a aVar) {
            this.f30564a = view;
            this.f30565b = aVar;
        }

        public final void run() {
            int i11;
            ViewGroup.LayoutParams layoutParams;
            View s11 = this.f30565b.s();
            if (s11 != null) {
                i11 = RangesKt___RangesKt.g(s11.getHeight(), this.f30565b.getResources().getDimensionPixelSize(R.dimen.sns_collapsed_intro_height));
            } else {
                i11 = this.f30565b.getResources().getDimensionPixelSize(R.dimen.sns_collapsed_intro_height);
            }
            View view = this.f30565b.getView();
            int i12 = 0;
            int height = view != null ? view.getHeight() : 0;
            View B = this.f30565b.B();
            Integer valueOf = Integer.valueOf(height - (B != null ? B.getBottom() : 0));
            ViewGroup.LayoutParams layoutParams2 = null;
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            int intValue = valueOf != null ? valueOf.intValue() : Integer.MAX_VALUE;
            int min = Math.min(i11, intValue);
            BottomSheetBehavior<View> t11 = this.f30565b.t();
            int peekHeight = t11 != null ? t11.getPeekHeight() : 0;
            BottomSheetBehavior<View> t12 = this.f30565b.t();
            if (t12 != null) {
                t12.setPeekHeight(min, true);
            }
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "adjustPickHeight: viewHeight=" + min + " spaceUnderTakePictureButton=" + intValue, (Throwable) null, 4, (Object) null);
            if (peekHeight != min) {
                this.f30565b.a(min);
            }
            View B2 = this.f30565b.B();
            if (B2 != null) {
                View B3 = this.f30565b.B();
                if (!(B3 == null || (layoutParams = B3.getLayoutParams()) == null)) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        BottomSheetBehavior<View> t13 = this.f30565b.t();
                        if (t13 != null) {
                            i12 = t13.getPeekHeight();
                        }
                        marginLayoutParams.bottomMargin = i12 + this.f30565b.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
                    }
                    layoutParams2 = layoutParams;
                }
                B2.setLayoutParams(layoutParams2);
            }
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f30566a;

        public c(d10.a<Unit> aVar) {
            this.f30566a = aVar;
        }

        public void onAnimationEnd(Animation animation) {
            d10.a<Unit> aVar = this.f30566a;
            if (aVar != null) {
                aVar.invoke();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30567a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a<VM> aVar) {
            super(0);
            this.f30567a = aVar;
        }

        public final void a() {
            View B = this.f30567a.B();
            if (B != null) {
                B.setVisibility(0);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30568a;

        public e(a<VM> aVar) {
            this.f30568a = aVar;
        }

        public void onSlide(View view, float f11) {
            View m11 = this.f30568a.m();
            if (m11 != null) {
                m11.setAlpha(f11 * 0.7f);
            }
        }

        public void onStateChanged(View view, int i11) {
            if (i11 == 4) {
                View m11 = this.f30568a.m();
                if (m11 != null) {
                    m11.setVisibility(8);
                    return;
                }
                return;
            }
            View m12 = this.f30568a.m();
            if (m12 != null) {
                m12.setVisibility(0);
            }
        }
    }

    public static final class f extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30569a;

        public f(a<VM> aVar) {
            this.f30569a = aVar;
        }

        public void onSlide(View view, float f11) {
        }

        public void onStateChanged(View view, int i11) {
            TextView p11 = this.f30569a.p();
            CharSequence text = p11 != null ? p11.getText() : null;
            if (!(text == null || text.length() == 0)) {
                if (i11 == 3) {
                    com.sumsub.sns.internal.core.analytics.c.b(this.f30569a.getAnalyticsDelegate(), Screen.CameraScreen, (Map) null, 2, (Object) null);
                    TextView o11 = this.f30569a.o();
                    if (o11 != null) {
                        o11.setVisibility(4);
                    }
                    TextView p12 = this.f30569a.p();
                    if (p12 != null) {
                        p12.setVisibility(0);
                    }
                    SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
                    if (eventHandler != null) {
                        eventHandler.onEvent(SNSEvent.ShowMoreGuidance.INSTANCE);
                    }
                } else if (i11 == 4) {
                    com.sumsub.sns.internal.core.analytics.c.a(this.f30569a.getAnalyticsDelegate(), Screen.CameraScreen, (Map) null, 2, (Object) null);
                    TextView o12 = this.f30569a.o();
                    if (o12 != null) {
                        o12.setVisibility(0);
                    }
                    TextView p13 = this.f30569a.p();
                    if (p13 != null) {
                        p13.setVisibility(4);
                    }
                }
            }
        }
    }

    public static final class g extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30570a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a<VM> aVar) {
            super(0);
            this.f30570a = aVar;
        }

        public final void a() {
            a.a((a) this.f30570a).x();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class h implements com.sumsub.sns.internal.core.domain.camera.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30571a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.camera.SNSCameraFragment$onViewModelPrepared$1", f = "SNSCameraFragment.kt", l = {183}, m = "processFrame")
        /* renamed from: com.sumsub.sns.camera.a$h$a  reason: collision with other inner class name */
        public static final class C0271a extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            public Object f30572a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f30573b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ h f30574c;

            /* renamed from: d  reason: collision with root package name */
            public int f30575d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0271a(h hVar, kotlin.coroutines.c<? super C0271a> cVar) {
                super(cVar);
                this.f30574c = hVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f30573b = obj;
                this.f30575d |= Integer.MIN_VALUE;
                return this.f30574c.a((ImageProxy) null, (com.sumsub.sns.internal.core.domain.camera.c) null, this);
            }
        }

        public h(a<VM> aVar) {
            this.f30571a = aVar;
        }

        public void a(CameraX.c cVar) {
            this.f30571a.a(cVar);
        }

        public void b(File file) {
            this.f30571a.b(file);
        }

        public void c() {
            this.f30571a.F();
        }

        public /* synthetic */ void onError(Exception exc) {
            com.sumsub.sns.internal.core.domain.camera.h.f(this, exc);
        }

        public void a(File file) {
            a.a((a) this.f30571a).a(file);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(androidx.camera.core.ImageProxy r5, com.sumsub.sns.internal.core.domain.camera.c r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
            /*
                r4 = this;
                boolean r0 = r7 instanceof com.sumsub.sns.camera.a.h.C0271a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                com.sumsub.sns.camera.a$h$a r0 = (com.sumsub.sns.camera.a.h.C0271a) r0
                int r1 = r0.f30575d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f30575d = r1
                goto L_0x0018
            L_0x0013:
                com.sumsub.sns.camera.a$h$a r0 = new com.sumsub.sns.camera.a$h$a
                r0.<init>(r4, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f30573b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f30575d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r5 = r0.f30572a
                androidx.camera.core.ImageProxy r5 = (androidx.camera.core.ImageProxy) r5
                kotlin.k.b(r7)
                goto L_0x0045
            L_0x002d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0035:
                kotlin.k.b(r7)
                com.sumsub.sns.camera.a<VM> r7 = r4.f30571a
                r0.f30572a = r5
                r0.f30575d = r3
                java.lang.Object r6 = r7.b(r5, r6, r0)
                if (r6 != r1) goto L_0x0045
                return r1
            L_0x0045:
                r5.close()
                kotlin.Unit r5 = kotlin.Unit.f56620a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.a.h.a(androidx.camera.core.ImageProxy, com.sumsub.sns.internal.core.domain.camera.c, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public /* synthetic */ class i extends AdaptedFunctionReference implements d10.a<Unit> {
        public i(Object obj) {
            super(0, obj, a.class, "finish", "finish(Lcom/sumsub/sns/internal/core/common/FinishReason;Ljava/lang/Object;Ljava/lang/Long;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }

        public final void a() {
            com.sumsub.sns.core.presentation.b.finish$default((a) this.receiver, (q) null, (Object) null, (Long) null, 7, (Object) null);
        }
    }

    public static final class j extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<VM> f30576a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a<VM> aVar) {
            super(0);
            this.f30576a = aVar;
        }

        public final void a() {
            this.f30576a.f30559c = true;
            FragmentActivity activity = this.f30576a.getActivity();
            if (activity != null) {
                com.sumsub.sns.internal.core.common.i.a((Activity) activity);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final /* synthetic */ com.sumsub.sns.internal.camera.c a(a aVar) {
        return (com.sumsub.sns.internal.camera.c) aVar.getViewModel();
    }

    public static final void c(a aVar, View view) {
        ((com.sumsub.sns.internal.camera.c) aVar.getViewModel()).y();
    }

    public abstract View A();

    public abstract View B();

    public abstract SNSToolbarView C();

    public final void D() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        View s11 = s();
        if (s11 != null) {
            bottomSheetBehavior = BottomSheetBehavior.from(s11);
            bottomSheetBehavior.setHideable(false);
            bottomSheetBehavior.setPeekHeight(s11.getResources().getDimensionPixelSize(R.dimen.sns_collapsed_intro_height));
        } else {
            bottomSheetBehavior = null;
        }
        this.f30557a = bottomSheetBehavior;
        View m11 = m();
        if (m11 != null) {
            m11.setOnClickListener(new c(this));
            m11.setAlpha(0.0f);
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.f30557a;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.addBottomSheetCallback(new e(this));
        }
    }

    public abstract boolean E();

    public void F() {
    }

    public final void G() {
        ActivityResultLauncher<String[]> activityResultLauncher;
        this.f30559c = false;
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == -1 && (activityResultLauncher = this.f30562f) != null) {
            activityResultLauncher.a(new String[]{"android.permission.CAMERA"});
        }
    }

    public final void H() {
        CameraX cameraX = this.f30560d;
        if (cameraX != null) {
            cameraX.h();
        }
    }

    public void a(int i11) {
    }

    public abstract void a(c.b bVar);

    public void a(CameraX.c cVar) {
    }

    public Object b(ImageProxy imageProxy, com.sumsub.sns.internal.core.domain.camera.c cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return Unit.f56620a;
    }

    public void b(File file) {
    }

    public void c(File file) {
    }

    public final void d(File file) {
        CameraX cameraX = this.f30560d;
        if (cameraX != null) {
            cameraX.a(file);
        }
    }

    public Map<String, Object> getAppearPayload() {
        return u();
    }

    public Map<String, Object> getCancelPayload() {
        return u();
    }

    public Map<String, Object> getClosePayload() {
        return u();
    }

    public Map<String, Object> getOpenPayload() {
        return u();
    }

    public final View getPhotoMadeIndicator() {
        View view = getView();
        if (view != null) {
            return view.findViewById(R.id.photo_made_indicator);
        }
        return null;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.n) {
            a((a.n) jVar);
        } else if (jVar instanceof c.a.C0302a) {
            CameraX cameraX = this.f30560d;
            if (cameraX != null) {
                cameraX.a(((c.a.C0302a) jVar).b());
            }
        } else if (jVar instanceof a.e) {
            a.e eVar = (a.e) jVar;
            Object e11 = eVar.e();
            n nVar = e11 instanceof n ? (n) e11 : null;
            Object e12 = eVar.e();
            l lVar = e12 instanceof l ? (l) e12 : null;
            if (nVar != null && !nVar.r()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(n0.d.f32148b, nVar);
                Unit unit = Unit.f56620a;
                com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 0, bundle, 1, (Object) null);
            } else if (lVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(n0.d.f32149c, lVar);
                Unit unit2 = Unit.f56620a;
                com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 0, bundle2, 1, (Object) null);
            } else {
                com.sumsub.sns.core.presentation.b.finish$default(this, (q) null, (Object) null, (Long) null, 7, (Object) null);
            }
        } else {
            super.handleEvent(jVar);
        }
    }

    public final void handlePermissionResults(Map<String, Boolean> map) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, "CameraFragment", "handlePermissionResults: " + map, (Throwable) null, 4, (Object) null);
        if (!x.b(map.get("android.permission.CAMERA"), Boolean.TRUE)) {
            ((com.sumsub.sns.internal.camera.c) getViewModel()).w();
        }
    }

    public boolean isTransparentStatusBar() {
        return com.sumsub.sns.internal.ff.a.f34215a.o().g();
    }

    public final void k() {
        View s11 = s();
        if (s11 != null) {
            y.a(s11, new b(s11, this));
        }
    }

    public CameraX.Mode l() {
        return this.f30563g;
    }

    public abstract View m();

    public final int n() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getInteger(17694721);
    }

    public abstract TextView o();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f30562f = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new f(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f30557a = null;
        CameraX cameraX = this.f30560d;
        if (cameraX != null) {
            cameraX.g();
        }
        this.f30560d = null;
    }

    public boolean onFinishCalled(q qVar) {
        BottomSheetBehavior<View> bottomSheetBehavior = this.f30557a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 3) {
            return super.onFinishCalled(qVar);
        }
        bottomSheetBehavior.setState(4);
        return false;
    }

    public Boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 24 && i11 != 25) {
            return null;
        }
        ((com.sumsub.sns.internal.camera.c) getViewModel()).x();
        return Boolean.TRUE;
    }

    public void onStart() {
        super.onStart();
        if (this.f30559c) {
            G();
        }
    }

    public void onStop() {
        AlertDialog alertDialog = this.f30558b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f30558b = null;
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        Integer a11;
        super.onViewCreated(view, bundle);
        SNSToolbarView C = C();
        ImageView imageView = null;
        if (C != null) {
            C.setOnCloseButtonClickListener(new d(this));
            C.setOnOptionButtonClickListener(new e(this));
            C.setOptionButtonDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.TORCH_OFF.getImageName()));
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            SNSColorElement sNSColorElement = SNSColorElement.CAMERA_CONTENT;
            com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
            if (a12 == null || (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) C))) == null) {
                unit = null;
            } else {
                C.setIconTintList(ColorStateList.valueOf(a11.intValue()));
                unit = Unit.f56620a;
            }
            if (unit == null) {
                C.setIconTintList(ColorStateList.valueOf(ContextCompat.getColor(C.getContext(), R.color.sns_camera_content)));
            }
        }
        View A = A();
        if (A != null) {
            com.sumsub.sns.internal.core.common.l.a(A, (d10.a<Unit>) new g(this));
            if (A instanceof ImageView) {
                imageView = (ImageView) A;
            }
            if (imageView != null) {
                imageView.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.TAKE_PHOTO.getImageName()));
            }
        }
        D();
    }

    public void onViewModelPrepared(Bundle bundle) {
        CameraSelector cameraSelector;
        super.onViewModelPrepared(bundle);
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String logTag = getLogTag();
        com.sumsub.log.logger.a.d(aVar, logTag, "cameraX mode " + l(), (Throwable) null, 4, (Object) null);
        CameraX.Mode l11 = l();
        Size t11 = ((com.sumsub.sns.internal.camera.c) getViewModel()).t();
        CameraX.b v11 = ((com.sumsub.sns.internal.camera.c) getViewModel()).v();
        if (E()) {
            cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA;
        } else {
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        }
        CameraX cameraX = new CameraX(l11, t11, v11, cameraSelector, new h(this));
        this.f30560d = cameraX;
        cameraX.a(getViewLifecycleOwner(), v());
        SNSToolbarView C = C();
        if (C != null) {
            C.setOptionButtonVisible(y());
        }
        G();
    }

    public abstract TextView p();

    public abstract ViewGroup q();

    public abstract TextView r();

    public abstract View s();

    public final BottomSheetBehavior<View> t() {
        return this.f30557a;
    }

    public Map<String, Object> u() {
        Context context = getContext();
        if (context == null) {
            return MapsKt__MapsKt.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PermissionPayload.CAMERA_PERMISSION.toString(), Boolean.valueOf(com.sumsub.sns.internal.core.common.j.a(context, "android.permission.CAMERA")));
        return linkedHashMap;
    }

    public abstract PreviewView v();

    public abstract View w();

    public abstract View x();

    public abstract boolean y();

    public abstract View z();

    public static final void b(a aVar, View view) {
        com.sumsub.sns.core.presentation.b.finish$default(aVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }

    public final void a(BottomSheetBehavior<View> bottomSheetBehavior) {
        this.f30557a = bottomSheetBehavior;
    }

    public static final void a(a aVar, Map map) {
        aVar.handlePermissionResults(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleState(com.sumsub.sns.internal.camera.c.b r8, android.os.Bundle r9) {
        /*
            r7 = this;
            boolean r9 = r8.h()
            androidx.camera.view.PreviewView r0 = r7.v()
            r1 = 8
            r2 = 0
            if (r0 != 0) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            boolean r3 = r8.j()
            if (r3 == 0) goto L_0x0016
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            r0.setVisibility(r3)
        L_0x001a:
            com.sumsub.sns.internal.core.domain.camera.CameraX r0 = r7.f30560d
            if (r0 == 0) goto L_0x0025
            boolean r3 = r8.h()
            r0.a((boolean) r3)
        L_0x0025:
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r3 = r7.requireContext()
            if (r9 != 0) goto L_0x0038
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r9 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.TORCH_OFF
            java.lang.String r9 = r9.getImageName()
            goto L_0x003e
        L_0x0038:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r9 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.TORCH_ON
            java.lang.String r9 = r9.getImageName()
        L_0x003e:
            android.graphics.drawable.Drawable r9 = r0.onResolveIcon(r3, r9)
            com.sumsub.sns.core.widget.SNSToolbarView r0 = r7.C()
            if (r0 == 0) goto L_0x004b
            r0.setOptionButtonDrawable(r9)
        L_0x004b:
            android.view.View r9 = r7.A()
            if (r9 != 0) goto L_0x0052
            goto L_0x0059
        L_0x0052:
            boolean r0 = r8.g()
            r9.setEnabled(r0)
        L_0x0059:
            android.view.View r9 = r7.z()
            if (r9 != 0) goto L_0x0060
            goto L_0x006c
        L_0x0060:
            boolean r0 = r8.l()
            if (r0 == 0) goto L_0x0068
            r0 = r2
            goto L_0x0069
        L_0x0068:
            r0 = r1
        L_0x0069:
            r9.setVisibility(r0)
        L_0x006c:
            android.view.View r9 = r7.B()
            r0 = 1
            if (r9 == 0) goto L_0x0080
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x007b
            r9 = r0
            goto L_0x007c
        L_0x007b:
            r9 = r2
        L_0x007c:
            if (r9 != r0) goto L_0x0080
            r9 = r0
            goto L_0x0081
        L_0x0080:
            r9 = r2
        L_0x0081:
            if (r9 != 0) goto L_0x0096
            boolean r9 = r8.k()
            if (r9 == 0) goto L_0x0096
            android.view.View r9 = r7.B()
            com.sumsub.sns.camera.a$d r1 = new com.sumsub.sns.camera.a$d
            r1.<init>(r7)
            r7.a((boolean) r0, (android.view.View) r9, (d10.a<kotlin.Unit>) r1)
            goto L_0x00a7
        L_0x0096:
            android.view.View r9 = r7.B()
            if (r9 != 0) goto L_0x009d
            goto L_0x00a7
        L_0x009d:
            boolean r0 = r8.k()
            if (r0 == 0) goto L_0x00a4
            r1 = r2
        L_0x00a4:
            r9.setVisibility(r1)
        L_0x00a7:
            com.sumsub.sns.internal.core.presentation.helper.camera.b r9 = r8.i()
            com.sumsub.sns.internal.core.presentation.helper.camera.b r0 = r7.f30561e
            boolean r0 = kotlin.jvm.internal.x.b(r0, r9)
            if (r0 != 0) goto L_0x00ee
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.presentation.helper.camera.b.C0380b
            if (r0 == 0) goto L_0x00ca
            r0 = r9
            com.sumsub.sns.internal.core.presentation.helper.camera.b$b r0 = (com.sumsub.sns.internal.core.presentation.helper.camera.b.C0380b) r0
            com.sumsub.sns.internal.core.presentation.intro.f r1 = r0.f()
            java.util.Map r2 = r0.e()
            java.lang.String r0 = r0.d()
            r7.a((com.sumsub.sns.internal.core.presentation.intro.f) r1, (java.util.Map<java.lang.String, ? extends java.lang.Object>) r2, (java.lang.String) r0)
            goto L_0x00ec
        L_0x00ca:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.presentation.helper.camera.b.a
            if (r0 == 0) goto L_0x00ea
            r0 = r9
            com.sumsub.sns.internal.core.presentation.helper.camera.b$a r0 = (com.sumsub.sns.internal.core.presentation.helper.camera.b.a) r0
            java.lang.CharSequence r2 = r0.j()
            java.lang.CharSequence r3 = r0.f()
            java.lang.CharSequence r4 = r0.h()
            com.sumsub.sns.internal.core.presentation.intro.f r5 = r0.i()
            java.lang.String r6 = r0.g()
            r1 = r7
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x00ec
        L_0x00ea:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.presentation.helper.camera.b.c
        L_0x00ec:
            r7.f30561e = r9
        L_0x00ee:
            r7.a((com.sumsub.sns.internal.camera.c.b) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.a.handleState(com.sumsub.sns.internal.camera.c$b, android.os.Bundle):void");
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        BottomSheetBehavior<View> bottomSheetBehavior = aVar.f30557a;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 3) {
            bottomSheetBehavior.setState(4);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final boolean a(com.sumsub.sns.internal.core.presentation.intro.f fVar, String str) {
        SNSInstructionsViewHandler instructionsViewHandler = e0.f32018a.getInstructionsViewHandler();
        ViewGroup viewGroup = null;
        View onVerificationStep = instructionsViewHandler != null ? instructionsViewHandler.onVerificationStep(requireContext(), fVar.c(), fVar.a(), fVar.b(), SNSInstructionsViewHandler.Position.BOTTOMSHEET.getValue(), str) : null;
        if (onVerificationStep == null) {
            return false;
        }
        View view = getView();
        View findViewById = view != null ? view.findViewById(R.id.sns_brief_details) : null;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View view2 = getView();
        if (view2 != null) {
            viewGroup = (ViewGroup) view2.findViewById(R.id.sns_intro_content);
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (viewGroup == null) {
            return true;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        marginLayoutParams.setMarginEnd(dimensionPixelSize);
        marginLayoutParams.bottomMargin = dimensionPixelSize;
        Unit unit = Unit.f56620a;
        viewGroup.addView(onVerificationStep, marginLayoutParams);
        return true;
    }

    public final void a(com.sumsub.sns.internal.core.presentation.intro.f fVar, Map<String, ? extends Object> map, String str) {
        View view = getView();
        View findViewById = view != null ? view.findViewById(R.id.sns_brief_details) : null;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View view2 = getView();
        if (view2 != null) {
            if (!a(fVar, str)) {
                int i11 = R.id.sns_intro_content;
                ViewGroup viewGroup = (ViewGroup) view2.findViewById(i11);
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                new com.sumsub.sns.core.presentation.intro.b(getServiceLocator().q(), false).a(view2, map, i11, -1);
            }
            k();
        }
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, com.sumsub.sns.internal.core.presentation.intro.f fVar, String str) {
        if (s() != null) {
            if (!a(fVar, str)) {
                View view = getView();
                View view2 = null;
                View findViewById = view != null ? view.findViewById(R.id.sns_brief_details) : null;
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
                View view3 = getView();
                if (view3 != null) {
                    view2 = view3.findViewById(R.id.sns_intro_content);
                }
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView r11 = r();
                if (r11 != null) {
                    r11.setText(charSequence);
                }
                TextView o11 = o();
                if (o11 != null) {
                    o11.setText(charSequence2);
                }
                TextView p11 = p();
                if (p11 != null) {
                    p11.setText(charSequence3);
                }
                BottomSheetBehavior<View> bottomSheetBehavior = this.f30557a;
                if (bottomSheetBehavior != null) {
                    bottomSheetBehavior.setHideable(false);
                    bottomSheetBehavior.addBottomSheetCallback(new f(this));
                }
            }
            k();
        }
    }

    public final void a(a.n nVar) {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, "CameraFragment", "showLackOfCameraPermissionsDialog:", (Throwable) null, 4, (Object) null);
        AlertDialog a11 = com.sumsub.sns.internal.core.android.c.f31946a.a(requireActivity(), nVar.f(), nVar.h(), nVar.g(), new i(this), new j(this));
        this.f30558b = a11;
        if (a11 != null) {
            a11.show();
        }
    }

    public static /* synthetic */ void a(a aVar, boolean z11, View view, d10.a aVar2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                aVar2 = null;
            }
            aVar.a(z11, view, (d10.a<Unit>) aVar2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateAlpha");
    }

    public final void a(boolean z11, View view, d10.a<Unit> aVar) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        if (!z11) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        alphaAnimation.setDuration((long) n());
        alphaAnimation.setAnimationListener(new c(aVar));
        if (view != null) {
            view.startAnimation(alphaAnimation);
        }
    }
}
