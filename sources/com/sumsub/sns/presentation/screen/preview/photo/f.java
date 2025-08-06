package com.sumsub.sns.presentation.screen.preview.photo;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.y;
import androidx.lifecycle.v;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.camera.photo.presentation.document.a;
import com.sumsub.sns.camera.photo.presentation.selfie.a;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.b;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.core.widget.SNSImageView;
import com.sumsub.sns.core.widget.SNSRotationZoomableImageView;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.d1;
import com.sumsub.sns.internal.core.common.f0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.ml.core.e;
import com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import d10.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\f\b&\u0018\u0000 4*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\bB\u0007¢\u0006\u0004\b|\u0010}J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010!\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\"\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0014J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0014J\b\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b0\u00101R\u001d\u00106\u001a\u0004\u0018\u0001038BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010?\u001a\u0004\u0018\u00010;8BX\u0002¢\u0006\f\n\u0004\b<\u0010/\u001a\u0004\b=\u0010>R\u001d\u0010D\u001a\u0004\u0018\u00010@8BX\u0002¢\u0006\f\n\u0004\bA\u0010/\u001a\u0004\bB\u0010CR\u001d\u0010I\u001a\u0004\u0018\u00010E8BX\u0002¢\u0006\f\n\u0004\bF\u0010/\u001a\u0004\bG\u0010HR\u001d\u0010L\u001a\u0004\u0018\u00010E8BX\u0002¢\u0006\f\n\u0004\bJ\u0010/\u001a\u0004\bK\u0010HR\u001d\u0010Q\u001a\u0004\u0018\u00010M8BX\u0002¢\u0006\f\n\u0004\bN\u0010/\u001a\u0004\bO\u0010PR\u001d\u0010V\u001a\u0004\u0018\u00010R8BX\u0002¢\u0006\f\n\u0004\bS\u0010/\u001a\u0004\bT\u0010UR\u001d\u0010Y\u001a\u0004\u0018\u00010R8BX\u0002¢\u0006\f\n\u0004\bW\u0010/\u001a\u0004\bX\u0010UR\u001d\u0010[\u001a\u0004\u0018\u00010R8BX\u0002¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\bZ\u0010UR\u001d\u0010`\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\f\n\u0004\b]\u0010/\u001a\u0004\b^\u0010_R\u001d\u0010d\u001a\u0004\u0018\u00010a8BX\u0002¢\u0006\f\n\u0004\bb\u0010/\u001a\u0004\bb\u0010cR\u001d\u0010e\u001a\u0004\u0018\u00010a8BX\u0002¢\u0006\f\n\u0004\bK\u0010/\u001a\u0004\b]\u0010cR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010jR\u0016\u0010m\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010lR\u0016\u0010o\u001a\u0004\u0018\u00010R8TX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010UR \u0010u\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0p8VX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0p8VX\u0004¢\u0006\u0006\u001a\u0004\bv\u0010tR \u0010y\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0p8VX\u0004¢\u0006\u0006\u001a\u0004\bx\u0010tR \u0010{\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0p8VX\u0004¢\u0006\u0006\u001a\u0004\bz\u0010t¨\u0006~"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/f;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel;", "VM", "Lcom/sumsub/sns/presentation/screen/preview/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$g;", "", "clockWise", "", "a", "Lcom/sumsub/sns/internal/ml/core/e$a;", "Lcom/sumsub/sns/internal/ml/badphotos/models/a;", "res", "state", "", "Landroid/graphics/Bitmap;", "photoBitmaps", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$Content$ButtonAction;", "action", "z", "x", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$k;", "warning", "b", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "success", "Landroid/os/Parcelable;", "payload", "onViewModelPrepared", "y", "outState", "onSaveInstanceState", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "hideLogo", "updatePoweredByVisibility", "onDestroyView", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "Landroidx/constraintlayout/widget/Group;", "Lcom/sumsub/sns/internal/core/common/z;", "o", "()Landroidx/constraintlayout/widget/Group;", "gContent", "Landroidx/viewpager2/widget/ViewPager2;", "r", "()Landroidx/viewpager2/widget/ViewPager2;", "photosPager", "Lcom/sumsub/sns/presentation/screen/preview/photo/c;", "c", "Lcom/sumsub/sns/presentation/screen/preview/photo/c;", "photosAdapter", "Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", "d", "q", "()Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", "ivPhoto", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "e", "v", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "uploadProgress", "Landroid/widget/Button;", "f", "k", "()Landroid/widget/Button;", "btnReadableDocument", "g", "n", "btnTakeAnotherPhoto", "Lcom/sumsub/sns/core/widget/SNSImageView;", "h", "p", "()Lcom/sumsub/sns/core/widget/SNSImageView;", "ivContentIcon", "Landroid/widget/TextView;", "i", "u", "()Landroid/widget/TextView;", "tvTitle", "j", "t", "tvSubtitle", "s", "tvIdDoc", "Landroid/view/ViewGroup;", "l", "w", "()Landroid/view/ViewGroup;", "vgWarning", "Landroid/widget/ImageButton;", "m", "()Landroid/widget/ImageButton;", "btnRotateCW", "btnRotateCCW", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bsbWarning", "Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/n1;", "bottomSheetJob", "I", "currentPage", "getPoweredByText", "poweredByText", "", "", "", "getCancelPayload", "()Ljava/util/Map;", "cancelPayload", "getClosePayload", "closePayload", "getOpenPayload", "openPayload", "getAppearPayload", "appearPayload", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class f<VM extends SNSPreviewPhotoDocumentViewModel> extends com.sumsub.sns.presentation.screen.preview.a<SNSPreviewPhotoDocumentViewModel.g, VM> {

    /* renamed from: r  reason: collision with root package name */
    public static final a f39963r = new a((r) null);

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39964s = {Reflection.j(new PropertyReference1Impl(f.class, "gContent", "getGContent()Landroidx/constraintlayout/widget/Group;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "photosPager", "getPhotosPager()Landroidx/viewpager2/widget/ViewPager2;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "ivPhoto", "getIvPhoto()Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "uploadProgress", "getUploadProgress()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "btnReadableDocument", "getBtnReadableDocument()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "btnTakeAnotherPhoto", "getBtnTakeAnotherPhoto()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "ivContentIcon", "getIvContentIcon()Lcom/sumsub/sns/core/widget/SNSImageView;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "tvIdDoc", "getTvIdDoc()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "vgWarning", "getVgWarning()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "btnRotateCW", "getBtnRotateCW()Landroid/widget/ImageButton;", 0)), Reflection.j(new PropertyReference1Impl(f.class, "btnRotateCCW", "getBtnRotateCCW()Landroid/widget/ImageButton;", 0))};

    /* renamed from: t  reason: collision with root package name */
    public static final String f39965t = "PreviewPhotoDocumentFragment";

    /* renamed from: u  reason: collision with root package name */
    public static final String f39966u = "request_image_rotation";

    /* renamed from: v  reason: collision with root package name */
    public static final String f39967v = "request_photo_picker";

    /* renamed from: w  reason: collision with root package name */
    public static final String f39968w = "current_page";

    /* renamed from: x  reason: collision with root package name */
    public static final long f39969x = 300;

    /* renamed from: a  reason: collision with root package name */
    public final z f39970a = a0.a(this, R.id.sns_content);

    /* renamed from: b  reason: collision with root package name */
    public final z f39971b = a0.a(this, R.id.sns_photos);

    /* renamed from: c  reason: collision with root package name */
    public c f39972c;

    /* renamed from: d  reason: collision with root package name */
    public final z f39973d = a0.a(this, R.id.sns_photo);

    /* renamed from: e  reason: collision with root package name */
    public final z f39974e = a0.a(this, R.id.sns_upload_progress);

    /* renamed from: f  reason: collision with root package name */
    public final z f39975f = a0.a(this, R.id.sns_primary_button);

    /* renamed from: g  reason: collision with root package name */
    public final z f39976g = a0.a(this, R.id.sns_secondary_button);

    /* renamed from: h  reason: collision with root package name */
    public final z f39977h = a0.a(this, R.id.sns_content_icon);

    /* renamed from: i  reason: collision with root package name */
    public final z f39978i = a0.a(this, R.id.sns_title);

    /* renamed from: j  reason: collision with root package name */
    public final z f39979j = a0.a(this, R.id.sns_subtitle);

    /* renamed from: k  reason: collision with root package name */
    public final z f39980k = a0.a(this, R.id.sns_iddoc);

    /* renamed from: l  reason: collision with root package name */
    public final z f39981l = a0.a(this, R.id.sns_warning);

    /* renamed from: m  reason: collision with root package name */
    public final z f39982m = a0.a(this, R.id.sns_rotate_cw);

    /* renamed from: n  reason: collision with root package name */
    public final z f39983n = a0.a(this, R.id.sns_rotate_ccw);

    /* renamed from: o  reason: collision with root package name */
    public BottomSheetBehavior<ViewGroup> f39984o;

    /* renamed from: p  reason: collision with root package name */
    public n1 f39985p;

    /* renamed from: q  reason: collision with root package name */
    public int f39986q;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39987a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f39988b;

        static {
            int[] iArr = new int[SNSPreviewPhotoDocumentViewModel.Content.Icon.values().length];
            iArr[SNSPreviewPhotoDocumentViewModel.Content.Icon.WARNING.ordinal()] = 1;
            f39987a = iArr;
            int[] iArr2 = new int[SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.values().length];
            iArr2[SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.CONTINUE.ordinal()] = 1;
            iArr2[SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN.ordinal()] = 2;
            f39988b = iArr2;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$hideWarning$1", f = "SNSPreviewPhotoDocumentFragment.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f<VM> f39990b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f<VM> fVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f39990b = fVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f39990b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39989a == 0) {
                k.b(obj);
                BottomSheetBehavior b11 = this.f39990b.f39984o;
                if (b11 != null) {
                    b11.setHideable(true);
                }
                BottomSheetBehavior b12 = this.f39990b.f39984o;
                if (b12 != null) {
                    b12.setState(5);
                }
                TextView d11 = this.f39990b.s();
                if (d11 != null) {
                    d11.setVisibility(8);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f<VM> f39991a;

        public d(f<VM> fVar) {
            this.f39991a = fVar;
        }

        public void onPageSelected(int i11) {
            this.f39991a.f39986q = i11;
            f.f(this.f39991a).a(i11);
        }
    }

    public static final class e extends Lambda implements p<Integer, b, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f<VM> f39992a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(f<VM> fVar) {
            super(2);
            this.f39992a = fVar;
        }

        public final void a(int i11, b bVar) {
            k0 a11;
            File d11 = bVar.d();
            if (d11 != null && (a11 = this.f39992a.getAppListener()) != null) {
                a11.a(d11, bVar.f(), this.f39992a.getIdDocSetType(), f.f39966u);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), (b) obj2);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.sumsub.sns.presentation.screen.preview.photo.f$f  reason: collision with other inner class name */
    public static final class C0536f extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f<VM> f39993a;

        public C0536f(f<VM> fVar) {
            this.f39993a = fVar;
        }

        public void onSlide(View view, float f11) {
        }

        public void onStateChanged(View view, int i11) {
            if (i11 == 3) {
                this.f39993a.getAnalyticsDelegate().b(this.f39993a.getScreen(), f.f(this.f39993a).F());
                BottomSheetBehavior b11 = this.f39993a.f39984o;
                if (b11 != null) {
                    b11.setHideable(false);
                }
            } else if (i11 == 4) {
                this.f39993a.getAnalyticsDelegate().a(this.f39993a.getScreen(), (Map<String, ? extends Object>) f.f(this.f39993a).F());
            }
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f39994a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f39995b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f39996c;

        public g(View view, f fVar, List list) {
            this.f39994a = view;
            this.f39995b = fVar;
            this.f39996c = list;
        }

        public final void run() {
            this.f39995b.a((List<Bitmap>) this.f39996c);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment$showWarning$1", f = "SNSPreviewPhotoDocumentFragment.kt", l = {576}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39997a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f<VM> f39998b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel.k f39999c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(f<VM> fVar, SNSPreviewPhotoDocumentViewModel.k kVar, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f39998b = fVar;
            this.f39999c = kVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f39998b, this.f39999c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39997a;
            if (i11 == 0) {
                k.b(obj);
                this.f39998b.b(this.f39999c);
                this.f39997a = 1;
                if (DelayKt.b(300, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BottomSheetBehavior b11 = this.f39998b.f39984o;
            if (b11 != null) {
                b11.setState(3);
            }
            return Unit.f56620a;
        }
    }

    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f40000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f40001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f40002c;

        public i(View view, TextView textView, f fVar) {
            this.f40000a = view;
            this.f40001b = textView;
            this.f40002c = fVar;
        }

        public final void run() {
            TextView textView = this.f40001b;
            int i11 = 0;
            int height = textView != null ? textView.getHeight() : 0;
            BottomSheetBehavior b11 = this.f40002c.f39984o;
            if (b11 != null) {
                ViewGroup e11 = this.f40002c.w();
                if (e11 != null) {
                    i11 = e11.getHeight();
                }
                b11.setPeekHeight(i11 - height);
            }
        }
    }

    public static final /* synthetic */ SNSPreviewPhotoDocumentViewModel f(f fVar) {
        return (SNSPreviewPhotoDocumentViewModel) fVar.getViewModel();
    }

    public Map<String, Object> getAppearPayload() {
        return ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F();
    }

    public Map<String, Object> getCancelPayload() {
        return ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F();
    }

    public Map<String, Object> getClosePayload() {
        return ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_preview_photo_document;
    }

    public Map<String, Object> getOpenPayload() {
        return ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F();
    }

    public TextView getPoweredByText() {
        ViewGroup w11 = w();
        if (w11 != null) {
            return (TextView) w11.findViewById(R.id.sns_powered);
        }
        return null;
    }

    public void handleEvent(a.j jVar) {
        super.handleEvent(jVar);
        if (jVar instanceof SNSPreviewPhotoDocumentViewModel.h) {
            if (isAdded()) {
                SNSPreviewPhotoDocumentViewModel.h hVar = (SNSPreviewPhotoDocumentViewModel.h) jVar;
                new SNSAlertDialogBuilder(requireContext()).setMessage(hVar.f()).setPositiveButton(hVar.e(), (DialogInterface.OnClickListener) new h(this)).setNegativeButton(hVar.d(), (DialogInterface.OnClickListener) new j(this)).show();
            }
        } else if (jVar instanceof SNSPreviewPhotoDocumentViewModel.e.a) {
            a.C0274a aVar = com.sumsub.sns.camera.photo.presentation.document.a.f30639o;
            SNSPreviewPhotoDocumentViewModel.e.a aVar2 = (SNSPreviewPhotoDocumentViewModel.e.a) jVar;
            navigateTo(aVar.a(aVar2.b().p(), aVar2.b().i().getType(), aVar2.b().o(), aVar2.b().j(), aVar2.b().k(), aVar2.b().l(), aVar2.b().n(), aVar2.b().m()).forResult(f39967v), com.sumsub.sns.internal.log.c.a(aVar));
        } else if (jVar instanceof SNSPreviewPhotoDocumentViewModel.e.b) {
            a.C0276a aVar3 = com.sumsub.sns.camera.photo.presentation.selfie.a.F;
            SNSPreviewPhotoDocumentViewModel.e.b bVar = (SNSPreviewPhotoDocumentViewModel.e.b) jVar;
            navigateTo(aVar3.a(bVar.b().i().getType(), bVar.b().j()).forResult(f39967v), com.sumsub.sns.internal.log.c.a(aVar3));
        } else if (jVar instanceof SNSPreviewPhotoDocumentViewModel.c) {
            Context context = getContext();
            String str = null;
            f0 d11 = context != null ? com.sumsub.sns.internal.core.common.i.d(context) : null;
            com.sumsub.sns.internal.log.a aVar4 = com.sumsub.sns.internal.log.a.f34862a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NFC message: ");
            if (d11 != null) {
                str = d11.a();
            }
            sb2.append(str);
            com.sumsub.log.logger.a.b(aVar4, com.sumsub.sns.internal.nfc.c.f35143b, sb2.toString(), (Throwable) null, 4, (Object) null);
            if (d11 instanceof f0.b) {
                k0 appListener = getAppListener();
                if (appListener != null) {
                    appListener.a(((SNSPreviewPhotoDocumentViewModel.c) jVar).b());
                    return;
                }
                return;
            }
            k0 appListener2 = getAppListener();
            if (appListener2 != null) {
                appListener2.a(((SNSPreviewPhotoDocumentViewModel.c) jVar).b().j().getType());
            }
            if (d11 instanceof f0.c) {
                aVar4.e(com.sumsub.sns.internal.nfc.c.f35143b, "NFC Error", ((f0.c) d11).b());
            }
        } else if (jVar instanceof SNSPreviewPhotoDocumentViewModel.j) {
            a(((SNSPreviewPhotoDocumentViewModel.j) jVar).b());
        } else if (jVar instanceof SNSPreviewPhotoDocumentViewModel.i) {
            SNSPreviewPhotoDocumentViewModel.i iVar = (SNSPreviewPhotoDocumentViewModel.i) jVar;
            a(iVar.c(), iVar.d());
        }
    }

    public final Button k() {
        return (Button) this.f39975f.a(this, f39964s[4]);
    }

    public final ImageButton l() {
        return (ImageButton) this.f39983n.a(this, f39964s[12]);
    }

    public final ImageButton m() {
        return (ImageButton) this.f39982m.a(this, f39964s[11]);
    }

    public final Button n() {
        return (Button) this.f39976g.a(this, f39964s[5]);
    }

    public final Group o() {
        return (Group) this.f39970a.a(this, f39964s[0]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f39984o = null;
    }

    public boolean onFinishCalled(q qVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "finishing preview screen r=" + qVar, (Throwable) null, 4, (Object) null);
        ((SNSPreviewPhotoDocumentViewModel) getViewModel()).L();
        return super.onFinishCalled(qVar);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f39968w, this.f39986q);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Integer a11;
        Integer a12;
        super.onViewCreated(view, bundle);
        ViewPager2 r11 = r();
        if (r11 != null) {
            r11.setOffscreenPageLimit(2);
        }
        ViewPager2 r12 = r();
        if (r12 != null) {
            r12.registerOnPageChangeCallback(new d(this));
        }
        c cVar = new c();
        cVar.a((p<? super Integer, ? super b, Unit>) new e(this));
        this.f39972c = cVar;
        ViewPager2 r13 = r();
        if (r13 != null) {
            r13.setAdapter(this.f39972c);
        }
        if (bundle != null) {
            this.f39986q = bundle.getInt(f39968w, 0);
        }
        ImageButton m11 = m();
        if (m11 != null) {
            m11.setVisibility(4);
            m11.setOnClickListener(new k(this));
            m11.setImageDrawable(com.sumsub.sns.core.presentation.helper.a.f31095a.a(requireContext(), SNSIconHandler.SNSCommonIcons.ROTATE_CW.getImageName()));
        }
        ImageButton l11 = l();
        if (l11 != null) {
            l11.setVisibility(4);
            l11.setOnClickListener(new l(this));
            l11.setImageDrawable(com.sumsub.sns.core.presentation.helper.a.f31095a.a(requireContext(), SNSIconHandler.SNSCommonIcons.ROTATE_CCW.getImageName()));
        }
        TextView s11 = s();
        if (s11 != null) {
            s11.setVisibility(8);
        }
        LinearProgressIndicator v11 = v();
        if (v11 != null) {
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            SNSColorElement sNSColorElement = SNSColorElement.PROGRESS_BAR_TINT;
            com.sumsub.sns.internal.core.theme.d a13 = aVar.a();
            if (!(a13 == null || (a12 = aVar.a(a13, sNSColorElement, aVar.a((View) v11))) == null)) {
                v11.setIndicatorColor(a12.intValue(), 0);
            }
            SNSColorElement sNSColorElement2 = SNSColorElement.PROGRESS_BAR_BACKGROUND;
            com.sumsub.sns.internal.core.theme.d a14 = aVar.a();
            if (!(a14 == null || (a11 = aVar.a(a14, sNSColorElement2, aVar.a((View) v11))) == null)) {
                v11.setTrackColor(a11.intValue());
            }
        }
        z();
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        requireActivity().getSupportFragmentManager().H1(f39966u, this, new q(this));
        requireActivity().getSupportFragmentManager().H1(f39967v, this, new r(this));
    }

    public final SNSImageView p() {
        return (SNSImageView) this.f39977h.a(this, f39964s[6]);
    }

    public final SNSRotationZoomableImageView q() {
        return (SNSRotationZoomableImageView) this.f39973d.a(this, f39964s[2]);
    }

    public final ViewPager2 r() {
        return (ViewPager2) this.f39971b.a(this, f39964s[1]);
    }

    public final TextView s() {
        return (TextView) this.f39980k.a(this, f39964s[9]);
    }

    public final TextView t() {
        return (TextView) this.f39979j.a(this, f39964s[8]);
    }

    public final TextView u() {
        return (TextView) this.f39978i.a(this, f39964s[7]);
    }

    public void updatePoweredByVisibility(boolean z11) {
        TextView poweredByText = getPoweredByText();
        if (poweredByText != null) {
            poweredByText.setVisibility(z11 ? 4 : 0);
        }
        View findViewById = requireView().findViewById(R.id.sns_powered);
        if (findViewById != null) {
            com.sumsub.sns.internal.core.common.i.a(findViewById, z11);
        }
    }

    public final LinearProgressIndicator v() {
        return (LinearProgressIndicator) this.f39974e.a(this, f39964s[3]);
    }

    public final ViewGroup w() {
        return (ViewGroup) this.f39981l.a(this, f39964s[10]);
    }

    public final void x() {
        n1 n1Var = this.f39985p;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f39985p = kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new c(this, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
    }

    public void y() {
    }

    public final void z() {
        ViewGroup w11 = w();
        if (w11 != null) {
            BottomSheetBehavior<ViewGroup> from = BottomSheetBehavior.from(w11);
            from.addBottomSheetCallback(new C0536f(this));
            this.f39984o = from;
            x();
        }
    }

    public static final void b(f fVar, View view) {
        fVar.getAnalyticsDelegate().b(fVar.getScreen(), fVar.getIdDocSetType(), Control.RotateButton, ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).F());
        fVar.a(false);
    }

    public static final void a(f fVar, View view) {
        fVar.getAnalyticsDelegate().b(fVar.getScreen(), fVar.getIdDocSetType(), Control.RotateButton, ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).F());
        fVar.a(true);
    }

    public static final void b(f fVar, String str, Bundle bundle) {
        n nVar = (n) bundle.getParcelable(n0.d.f32148b);
        com.sumsub.sns.internal.core.data.model.l lVar = (com.sumsub.sns.internal.core.data.model.l) bundle.getParcelable(n0.d.f32149c);
        b.a aVar = com.sumsub.sns.core.presentation.b.Companion;
        if (aVar.b(bundle)) {
            if (lVar != null) {
                ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).a(lVar);
            } else {
                ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).a(nVar);
            }
        } else if (aVar.a(bundle) == 100) {
            ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).M();
        } else {
            fVar.y();
        }
    }

    public final void a(boolean z11) {
        ViewPager2 r11;
        View a11;
        SNSRotationZoomableImageView sNSRotationZoomableImageView;
        ViewPager2 r12 = r();
        if (r12 != null) {
            int currentItem = r12.getCurrentItem();
            c cVar = this.f39972c;
            if (cVar != null && (r11 = r()) != null && (a11 = d1.a(r11)) != null && (sNSRotationZoomableImageView = (SNSRotationZoomableImageView) a11.findViewById(R.id.sns_photo)) != null) {
                if (z11) {
                    sNSRotationZoomableImageView.rotateCW();
                } else {
                    sNSRotationZoomableImageView.rotateCCW();
                }
                File d11 = cVar.a().get(currentItem).d();
                if (d11 != null) {
                    ((SNSPreviewPhotoDocumentViewModel) getViewModel()).a(d11, sNSRotationZoomableImageView.getRotation());
                }
            }
        }
    }

    public static final void b(f fVar, DialogInterface dialogInterface, int i11) {
        ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).d(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(com.sumsub.sns.presentation.screen.preview.photo.f r0, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content r1, android.view.View r2) {
        /*
            if (r1 == 0) goto L_0x000d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r1 = r1.h()
            if (r1 == 0) goto L_0x000d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = r1.c()
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            r0.a((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.f.b(com.sumsub.sns.presentation.screen.preview.photo.f, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content, android.view.View):void");
    }

    /* JADX WARNING: type inference failed for: r0v14, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k r4) {
        /*
            r3 = this;
            android.view.ViewGroup r0 = r3.w()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            int r2 = com.sumsub.sns.R.id.sns_warning_icon
            android.view.View r0 = r0.findViewById(r2)
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x0012
            goto L_0x001f
        L_0x0012:
            boolean r2 = r4.j()
            if (r2 == 0) goto L_0x001a
            r2 = 0
            goto L_0x001c
        L_0x001a:
            r2 = 8
        L_0x001c:
            r0.setVisibility(r2)
        L_0x001f:
            android.view.ViewGroup r0 = r3.w()
            if (r0 == 0) goto L_0x002e
            int r1 = com.sumsub.sns.R.id.sns_warning_message
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x002e:
            if (r1 == 0) goto L_0x0037
            java.lang.CharSequence r0 = r4.i()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r1, (java.lang.CharSequence) r0)
        L_0x0037:
            android.view.ViewGroup r0 = r3.w()
            if (r0 == 0) goto L_0x0056
            int r2 = com.sumsub.sns.R.id.sns_warning_primary_button
            android.view.View r0 = r0.findViewById(r2)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0056
            java.lang.CharSequence r2 = r4.g()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            com.sumsub.sns.presentation.screen.preview.photo.o r2 = new com.sumsub.sns.presentation.screen.preview.photo.o
            r2.<init>(r3, r4)
            r0.setOnClickListener(r2)
        L_0x0056:
            android.view.ViewGroup r0 = r3.w()
            if (r0 == 0) goto L_0x0075
            int r2 = com.sumsub.sns.R.id.sns_warning_secondary_button
            android.view.View r0 = r0.findViewById(r2)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0075
            java.lang.CharSequence r2 = r4.h()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            com.sumsub.sns.presentation.screen.preview.photo.p r2 = new com.sumsub.sns.presentation.screen.preview.photo.p
            r2.<init>(r3, r4)
            r0.setOnClickListener(r2)
        L_0x0075:
            android.view.ViewGroup r0 = r3.w()
            if (r0 == 0) goto L_0x008c
            int r2 = com.sumsub.sns.R.id.sns_warning_title
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x008c
            java.lang.CharSequence r4 = r4.k()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x008c:
            android.view.ViewGroup r4 = r3.w()
            if (r4 == 0) goto L_0x009a
            com.sumsub.sns.presentation.screen.preview.photo.f$i r0 = new com.sumsub.sns.presentation.screen.preview.photo.f$i
            r0.<init>(r4, r1, r3)
            androidx.core.view.y.a(r4, r0)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.f.b(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k):void");
    }

    public void a(boolean z11, Parcelable parcelable) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "On instructions showed, success=" + z11 + ", payload=" + parcelable, (Throwable) null, 4, (Object) null);
        if (z11) {
            ((SNSPreviewPhotoDocumentViewModel) getViewModel()).a(parcelable);
        }
    }

    public static final void a(f fVar, String str, Bundle bundle) {
        int i11 = bundle.getInt("rotation", 0);
        File file = (File) bundle.getSerializable("file");
        if (file != null) {
            ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).a(file, i11);
        }
    }

    public static final void a(f fVar, DialogInterface dialogInterface, int i11) {
        ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).d(true);
    }

    public final void a(e.a<com.sumsub.sns.internal.ml.badphotos.models.a> aVar) {
        String str;
        Context context = getContext();
        if (context != null) {
            if (aVar instanceof e.a.d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\n                        Result: Success in ");
                e.a.d dVar = (e.a.d) aVar;
                sb2.append(((com.sumsub.sns.internal.ml.badphotos.models.a) dVar.c()).a());
                sb2.append(" ms\n                        Raw model output: ");
                sb2.append(((com.sumsub.sns.internal.ml.badphotos.models.a) dVar.c()).c());
                sb2.append("\n                    ");
                str = StringsKt__IndentKt.f(sb2.toString());
            } else if (aVar instanceof e.a.b) {
                str = StringsKt__IndentKt.f("\n                        Result: Failure\n                        Error: " + ((e.a.b) aVar).c().getMessage() + "                                        \n                    ");
            } else if (aVar instanceof e.a.c) {
                str = "Timeout";
            } else if (aVar instanceof e.a.C0411e) {
                str = "Skipped";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Toast.makeText(context, str, 1).show();
        }
    }

    @SensorsDataInstrumented
    public static final void b(f fVar, SNSPreviewPhotoDocumentViewModel.k kVar, View view) {
        fVar.x();
        if (!kVar.l()) {
            ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).O();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0124 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleState(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g r14, android.os.Bundle r15) {
        /*
            r13 = this;
            java.util.List r15 = r14.g()
            boolean r15 = r15.isEmpty()
            r0 = 1
            r15 = r15 ^ r0
            if (r15 == 0) goto L_0x000f
            r13.a((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r14)
        L_0x000f:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k r15 = r14.j()
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 0
            r5 = 0
            if (r15 == 0) goto L_0x0051
            android.content.Context r6 = r13.getContext()
            if (r6 != 0) goto L_0x0021
            goto L_0x004e
        L_0x0021:
            r13.a((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k) r15)
            android.widget.TextView r6 = r13.s()
            if (r6 == 0) goto L_0x0031
            java.lang.CharSequence r15 = r15.k()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r6, (java.lang.CharSequence) r15)
        L_0x0031:
            android.view.View[] r15 = new android.view.View[r3]
            android.widget.TextView r6 = r13.u()
            r15[r5] = r6
            android.widget.TextView r6 = r13.t()
            r15[r0] = r6
            android.widget.Button r6 = r13.k()
            r15[r2] = r6
            android.widget.Button r6 = r13.n()
            r15[r1] = r6
            com.sumsub.sns.internal.core.common.i.b((android.view.View[]) r15)
        L_0x004e:
            kotlin.Unit r15 = kotlin.Unit.f56620a
            goto L_0x0052
        L_0x0051:
            r15 = r4
        L_0x0052:
            if (r15 != 0) goto L_0x0074
            r13.x()
            android.view.View[] r15 = new android.view.View[r3]
            android.widget.TextView r6 = r13.u()
            r15[r5] = r6
            android.widget.TextView r6 = r13.t()
            r15[r0] = r6
            android.widget.Button r6 = r13.k()
            r15[r2] = r6
            android.widget.Button r6 = r13.n()
            r15[r1] = r6
            com.sumsub.sns.internal.core.common.i.c((android.view.View[]) r15)
        L_0x0074:
            com.sumsub.sns.internal.log.a r7 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r8 = com.sumsub.sns.internal.log.c.a(r13)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "showContent: show="
            r15.append(r6)
            r15.append(r14)
            java.lang.String r6 = ".showContent"
            r15.append(r6)
            java.lang.String r9 = r15.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            com.sumsub.log.logger.a.d(r7, r8, r9, r10, r11, r12)
            androidx.constraintlayout.widget.Group r15 = r13.o()
            r6 = 8
            if (r15 != 0) goto L_0x009f
            goto L_0x00ab
        L_0x009f:
            boolean r7 = r14.i()
            if (r7 == 0) goto L_0x00a7
            r7 = r5
            goto L_0x00a8
        L_0x00a7:
            r7 = r6
        L_0x00a8:
            r15.setVisibility(r7)
        L_0x00ab:
            java.util.List r15 = r14.g()
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r15)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d r15 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.d) r15
            java.util.List r7 = r14.g()
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r0
            if (r7 == 0) goto L_0x00cc
            java.util.List r15 = r14.g()
            int r7 = r13.f39986q
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.d0(r15, r7)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d r15 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.d) r15
        L_0x00cc:
            boolean r7 = r14.h()
            if (r7 == 0) goto L_0x00e1
            if (r15 == 0) goto L_0x00dc
            boolean r15 = r15.h()
            if (r15 != r0) goto L_0x00dc
            r15 = r0
            goto L_0x00dd
        L_0x00dc:
            r15 = r5
        L_0x00dd:
            if (r15 == 0) goto L_0x00e1
            r15 = r0
            goto L_0x00e2
        L_0x00e1:
            r15 = r5
        L_0x00e2:
            android.widget.ImageButton r7 = r13.m()
            if (r7 != 0) goto L_0x00e9
            goto L_0x00f3
        L_0x00e9:
            r8 = r15 ^ 1
            if (r8 == 0) goto L_0x00ef
            r8 = r3
            goto L_0x00f0
        L_0x00ef:
            r8 = r5
        L_0x00f0:
            r7.setVisibility(r8)
        L_0x00f3:
            android.widget.ImageButton r7 = r13.l()
            if (r7 != 0) goto L_0x00fa
            goto L_0x0103
        L_0x00fa:
            r15 = r15 ^ r0
            if (r15 == 0) goto L_0x00ff
            r15 = r3
            goto L_0x0100
        L_0x00ff:
            r15 = r5
        L_0x0100:
            r7.setVisibility(r15)
        L_0x0103:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r15 = r14.f()
            com.sumsub.sns.core.presentation.base.a r7 = r13.getViewModel()
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r7
            boolean r7 = r7.o()
            r13.updatePoweredByVisibility(r7)
            android.widget.TextView r7 = r13.s()
            if (r7 != 0) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r7.setVisibility(r6)
        L_0x011e:
            boolean r7 = r14.i()
            if (r7 == 0) goto L_0x02ae
            if (r15 == 0) goto L_0x0132
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r1 = r15.k()
            if (r1 == 0) goto L_0x0132
            java.lang.CharSequence r1 = r1.c()
            if (r1 != 0) goto L_0x013a
        L_0x0132:
            if (r15 == 0) goto L_0x0139
            java.lang.CharSequence r1 = r15.n()
            goto L_0x013a
        L_0x0139:
            r1 = r4
        L_0x013a:
            android.widget.TextView r2 = r13.u()
            if (r2 == 0) goto L_0x0143
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r2, (java.lang.CharSequence) r1)
        L_0x0143:
            android.widget.TextView r1 = r13.t()
            if (r1 == 0) goto L_0x0154
            if (r15 == 0) goto L_0x0150
            java.lang.CharSequence r2 = r15.m()
            goto L_0x0151
        L_0x0150:
            r2 = r4
        L_0x0151:
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r1, (java.lang.CharSequence) r2)
        L_0x0154:
            if (r15 == 0) goto L_0x015b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$Icon r1 = r15.j()
            goto L_0x015c
        L_0x015b:
            r1 = r4
        L_0x015c:
            if (r1 != 0) goto L_0x0175
            com.sumsub.sns.core.widget.SNSImageView r1 = r13.p()
            if (r1 != 0) goto L_0x0165
            goto L_0x0168
        L_0x0165:
            r1.setVisibility(r6)
        L_0x0168:
            android.widget.TextView r1 = r13.t()
            if (r1 != 0) goto L_0x016f
            goto L_0x01af
        L_0x016f:
            r2 = 17
            r1.setGravity(r2)
            goto L_0x01af
        L_0x0175:
            com.sumsub.sns.core.widget.SNSImageView r2 = r13.p()
            if (r2 != 0) goto L_0x017c
            goto L_0x017f
        L_0x017c:
            r2.setVisibility(r5)
        L_0x017f:
            android.widget.TextView r2 = r13.t()
            if (r2 != 0) goto L_0x0186
            goto L_0x018c
        L_0x0186:
            r7 = 8388611(0x800003, float:1.1754948E-38)
            r2.setGravity(r7)
        L_0x018c:
            int[] r2 = com.sumsub.sns.presentation.screen.preview.photo.f.b.f39987a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 != r0) goto L_0x01af
            com.sumsub.sns.core.widget.SNSImageView r1 = r13.p()
            if (r1 == 0) goto L_0x01af
            com.sumsub.sns.core.presentation.helper.a r2 = com.sumsub.sns.core.presentation.helper.a.f31095a
            android.content.Context r7 = r13.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r8 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.WARNING
            java.lang.String r8 = r8.getImageName()
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r7, (java.lang.String) r8)
            r1.setImageDrawable(r2)
        L_0x01af:
            android.widget.Button r1 = r13.k()
            if (r1 == 0) goto L_0x01e9
            if (r15 == 0) goto L_0x01c2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r2 = r15.i()
            if (r2 == 0) goto L_0x01c2
            java.lang.CharSequence r2 = r2.d()
            goto L_0x01c3
        L_0x01c2:
            r2 = r4
        L_0x01c3:
            r1.setText(r2)
            com.sumsub.sns.presentation.screen.preview.photo.m r2 = new com.sumsub.sns.presentation.screen.preview.photo.m
            r2.<init>(r13, r15)
            r1.setOnClickListener(r2)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k r14 = r14.j()
            if (r14 != 0) goto L_0x01e0
            if (r15 == 0) goto L_0x01db
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r14 = r15.i()
            goto L_0x01dc
        L_0x01db:
            r14 = r4
        L_0x01dc:
            if (r14 == 0) goto L_0x01e0
            r14 = r0
            goto L_0x01e1
        L_0x01e0:
            r14 = r5
        L_0x01e1:
            if (r14 == 0) goto L_0x01e5
            r14 = r5
            goto L_0x01e6
        L_0x01e5:
            r14 = r6
        L_0x01e6:
            r1.setVisibility(r14)
        L_0x01e9:
            android.widget.Button r14 = r13.n()
            if (r14 == 0) goto L_0x021d
            if (r15 == 0) goto L_0x01fc
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r1 = r15.h()
            if (r1 == 0) goto L_0x01fc
            java.lang.CharSequence r1 = r1.d()
            goto L_0x01fd
        L_0x01fc:
            r1 = r4
        L_0x01fd:
            r14.setText(r1)
            com.sumsub.sns.presentation.screen.preview.photo.n r1 = new com.sumsub.sns.presentation.screen.preview.photo.n
            r1.<init>(r13, r15)
            r14.setOnClickListener(r1)
            if (r15 == 0) goto L_0x020f
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r1 = r15.h()
            goto L_0x0210
        L_0x020f:
            r1 = r4
        L_0x0210:
            if (r1 == 0) goto L_0x0214
            r1 = r0
            goto L_0x0215
        L_0x0214:
            r1 = r5
        L_0x0215:
            if (r1 == 0) goto L_0x0219
            r1 = r5
            goto L_0x021a
        L_0x0219:
            r1 = r6
        L_0x021a:
            r14.setVisibility(r1)
        L_0x021d:
            if (r15 == 0) goto L_0x0224
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r14 = r15.k()
            goto L_0x0225
        L_0x0224:
            r14 = r4
        L_0x0225:
            if (r14 == 0) goto L_0x023b
            android.widget.TextView r14 = r13.t()
            if (r14 != 0) goto L_0x022e
            goto L_0x0231
        L_0x022e:
            r14.setVisibility(r3)
        L_0x0231:
            com.sumsub.sns.core.widget.SNSImageView r14 = r13.p()
            if (r14 != 0) goto L_0x0238
            goto L_0x023b
        L_0x0238:
            r14.setVisibility(r6)
        L_0x023b:
            android.widget.Button r14 = r13.k()
            if (r14 != 0) goto L_0x0242
            goto L_0x0252
        L_0x0242:
            if (r15 == 0) goto L_0x0249
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r1 = r15.k()
            goto L_0x024a
        L_0x0249:
            r1 = r4
        L_0x024a:
            if (r1 != 0) goto L_0x024e
            r1 = r0
            goto L_0x024f
        L_0x024e:
            r1 = r5
        L_0x024f:
            r14.setEnabled(r1)
        L_0x0252:
            android.widget.Button r14 = r13.n()
            if (r14 != 0) goto L_0x0259
            goto L_0x0269
        L_0x0259:
            if (r15 == 0) goto L_0x0260
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r1 = r15.k()
            goto L_0x0261
        L_0x0260:
            r1 = r4
        L_0x0261:
            if (r1 != 0) goto L_0x0265
            r1 = r0
            goto L_0x0266
        L_0x0265:
            r1 = r5
        L_0x0266:
            r14.setEnabled(r1)
        L_0x0269:
            if (r15 == 0) goto L_0x026f
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r4 = r15.k()
        L_0x026f:
            if (r4 == 0) goto L_0x0272
            goto L_0x0273
        L_0x0272:
            r0 = r5
        L_0x0273:
            com.google.android.material.progressindicator.LinearProgressIndicator r14 = r13.v()
            if (r14 == 0) goto L_0x02f5
            if (r0 == 0) goto L_0x027c
            r6 = r5
        L_0x027c:
            r14.setVisibility(r6)
            if (r15 == 0) goto L_0x028c
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r15 = r15.k()
            if (r15 == 0) goto L_0x028c
            int r15 = r15.d()
            goto L_0x028d
        L_0x028c:
            r15 = r5
        L_0x028d:
            r14.setProgress(r15)
            android.widget.ImageButton r14 = r13.m()
            if (r14 != 0) goto L_0x0297
            goto L_0x029f
        L_0x0297:
            if (r0 == 0) goto L_0x029b
            r15 = r3
            goto L_0x029c
        L_0x029b:
            r15 = r5
        L_0x029c:
            r14.setVisibility(r15)
        L_0x029f:
            android.widget.ImageButton r14 = r13.l()
            if (r14 != 0) goto L_0x02a6
            goto L_0x02f5
        L_0x02a6:
            if (r0 == 0) goto L_0x02a9
            goto L_0x02aa
        L_0x02a9:
            r3 = r5
        L_0x02aa:
            r14.setVisibility(r3)
            goto L_0x02f5
        L_0x02ae:
            r14 = 7
            android.view.View[] r14 = new android.view.View[r14]
            android.widget.TextView r15 = r13.u()
            r14[r5] = r15
            android.widget.TextView r15 = r13.t()
            r14[r0] = r15
            android.widget.Button r15 = r13.k()
            r14[r2] = r15
            android.widget.Button r15 = r13.n()
            r14[r1] = r15
            com.sumsub.sns.core.widget.SNSImageView r15 = r13.p()
            r14[r3] = r15
            androidx.viewpager2.widget.ViewPager2 r15 = r13.r()
            r0 = 5
            r14[r0] = r15
            com.google.android.material.progressindicator.LinearProgressIndicator r15 = r13.v()
            r0 = 6
            r14[r0] = r15
            com.sumsub.sns.internal.core.common.i.a((android.view.View[]) r14)
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView r14 = r13.q()
            if (r14 == 0) goto L_0x02e9
            r14.clearImage()
        L_0x02e9:
            com.sumsub.sns.presentation.screen.preview.photo.c r14 = r13.f39972c
            if (r14 != 0) goto L_0x02ee
            goto L_0x02f5
        L_0x02ee:
            java.util.List r15 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            r14.a((java.util.List<com.sumsub.sns.presentation.screen.preview.photo.b>) r15)
        L_0x02f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.f.handleState(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.i();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.sumsub.sns.presentation.screen.preview.photo.f r0, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content r1, android.view.View r2) {
        /*
            if (r1 == 0) goto L_0x000d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r1 = r1.i()
            if (r1 == 0) goto L_0x000d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = r1.c()
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            r0.a((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.f.a(com.sumsub.sns.presentation.screen.preview.photo.f, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content, android.view.View):void");
    }

    public final void a(SNSPreviewPhotoDocumentViewModel.g gVar) {
        List<SNSPreviewPhotoDocumentViewModel.d> g11 = gVar.g();
        ArrayList arrayList = new ArrayList();
        for (SNSPreviewPhotoDocumentViewModel.d f11 : g11) {
            Bitmap f12 = f11.f();
            if (f12 != null) {
                arrayList.add(f12);
            }
        }
        ViewPager2 r11 = r();
        if (r11 != null) {
            r11.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        }
        if (!arrayList.isEmpty()) {
            ViewPager2 r12 = r();
            if ((r12 != null ? r12.getHeight() : 0) > 0) {
                a((List<Bitmap>) arrayList);
            } else {
                ViewPager2 r13 = r();
                if (r13 != null) {
                    y.a(r13, new g(r13, this, arrayList));
                }
            }
            List<SNSPreviewPhotoDocumentViewModel.d> g12 = gVar.g();
            ArrayList<SNSPreviewPhotoDocumentViewModel.d> arrayList2 = new ArrayList<>();
            for (T next : g12) {
                if (((SNSPreviewPhotoDocumentViewModel.d) next).f() != null) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList2, 10));
            for (SNSPreviewPhotoDocumentViewModel.d dVar : arrayList2) {
                Bitmap f13 = dVar.f();
                if (f13 != null) {
                    arrayList3.add(new b(f13, dVar.e(), dVar.g()));
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            c cVar = this.f39972c;
            if (cVar != null) {
                cVar.a((List<b>) arrayList3);
            }
            ViewPager2 r14 = r();
            if (r14 != null) {
                r14.setCurrentItem(this.f39986q);
            }
        }
    }

    public final void a(List<Bitmap> list) {
        ViewPager2 r11 = r();
        if (r11 != null) {
            int height = r11.getHeight();
            ViewPager2 r12 = r();
            if (r12 != null) {
                int itemDecorationCount = r12.getItemDecorationCount();
                for (int i11 = 0; i11 < itemDecorationCount; i11++) {
                    r12.removeItemDecorationAt(0);
                }
                Iterator<T> it2 = list.iterator();
                if (it2.hasNext()) {
                    T next = it2.next();
                    if (!it2.hasNext()) {
                        Bitmap bitmap = (Bitmap) next;
                        int width = (int) ((((float) getResources().getDisplayMetrics().widthPixels) - (((float) bitmap.getWidth()) * (((float) height) / ((float) bitmap.getHeight())))) / 2.0f);
                        r12.addItemDecoration(new a(width));
                        r12.setPageTransformer(new i(width, getResources().getDimensionPixelSize(R.dimen.sns_margin_large)));
                    } else {
                        int width2 = ((Bitmap) next).getWidth();
                        do {
                            T next2 = it2.next();
                            int width3 = ((Bitmap) next2).getWidth();
                            if (width2 > width3) {
                                next = next2;
                                width2 = width3;
                            }
                        } while (it2.hasNext());
                    }
                    Bitmap bitmap2 = (Bitmap) next;
                    int width4 = (int) ((((float) getResources().getDisplayMetrics().widthPixels) - (((float) bitmap2.getWidth()) * (((float) height) / ((float) bitmap2.getHeight())))) / 2.0f);
                    r12.addItemDecoration(new a(width4));
                    r12.setPageTransformer(new i(width4, getResources().getDimensionPixelSize(R.dimen.sns_margin_large)));
                    return;
                }
                throw new NoSuchElementException();
            }
        }
    }

    public static final void a(int i11, int i12, View view, float f11) {
        view.setTranslationX(((float) ((i11 + i12) * -1)) * f11);
    }

    public final void a(SNSPreviewPhotoDocumentViewModel.Content.ButtonAction buttonAction) {
        int i11 = buttonAction == null ? -1 : b.f39988b[buttonAction.ordinal()];
        if (i11 == 1) {
            getAnalyticsDelegate().b(getScreen(), getIdDocSetType(), Control.AcceptButton, ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F());
            ((SNSPreviewPhotoDocumentViewModel) getViewModel()).y();
        } else if (i11 == 2) {
            getAnalyticsDelegate().b(getScreen(), getIdDocSetType(), Control.RetakeButton, ((SNSPreviewPhotoDocumentViewModel) getViewModel()).F());
            ((SNSPreviewPhotoDocumentViewModel) getViewModel()).z();
        }
    }

    public final void a(SNSPreviewPhotoDocumentViewModel.k kVar) {
        n1 n1Var = this.f39985p;
        boolean z11 = true;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior = this.f39984o;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 3) {
            z11 = false;
        }
        if (z11) {
            b(kVar);
        } else {
            this.f39985p = kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new h(this, kVar, (kotlin.coroutines.c<? super h>) null), 3, (Object) null);
        }
    }

    @SensorsDataInstrumented
    public static final void a(f fVar, SNSPreviewPhotoDocumentViewModel.k kVar, View view) {
        fVar.x();
        if (kVar.l()) {
            ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).O();
        } else {
            ((SNSPreviewPhotoDocumentViewModel) fVar.getViewModel()).P();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
