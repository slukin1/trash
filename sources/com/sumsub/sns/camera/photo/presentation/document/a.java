package com.sumsub.sns.camera.photo.presentation.document;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.SNSDocBoundsCheckResultView;
import com.sumsub.sns.core.widget.SNSProgressBarView;
import com.sumsub.sns.core.widget.SNSSegmentedToggleView;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.v;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\t¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001aH\u0002J\f\u0010\n\u001a\u00020\u001c*\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u001a\u0010 \u001a\u00020\u00052\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eH\u0002J*\u0010\n\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u0011H\u0014J\u001a\u0010*\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010/\u001a\u000200H\u0014J\b\u00101\u001a\u00020\u0005H\u0014J#\u0010\u0006\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u00106J\u0010\u0010\n\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0011H\u0014J\u0010\u00109\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u000208H\u0014R\u001b\u0010>\u001a\u00020\u00028TX\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010F\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010BR\u001d\u0010I\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010BR\u001d\u0010L\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\bJ\u0010@\u001a\u0004\bK\u0010BR\u001d\u0010Q\u001a\u0004\u0018\u00010M8TX\u0002¢\u0006\f\n\u0004\bN\u0010@\u001a\u0004\bO\u0010PR\u001d\u0010S\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\bR\u0010@\u001a\u0004\bR\u0010BR\u001d\u0010V\u001a\u0004\u0018\u00010T8TX\u0002¢\u0006\f\n\u0004\bA\u0010@\u001a\u0004\b?\u0010UR\u001d\u0010Y\u001a\u0004\u0018\u00010T8TX\u0002¢\u0006\f\n\u0004\bW\u0010@\u001a\u0004\bX\u0010UR\u001d\u0010[\u001a\u0004\u0018\u00010T8TX\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bZ\u0010UR\u001d\u0010_\u001a\u0004\u0018\u00010\\8TX\u0002¢\u0006\f\n\u0004\b]\u0010@\u001a\u0004\b:\u0010^R\u001d\u0010a\u001a\u0004\u0018\u00010\\8TX\u0002¢\u0006\f\n\u0004\bH\u0010@\u001a\u0004\b`\u0010^R\u001d\u0010c\u001a\u0004\u0018\u00010\u000f8TX\u0002¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bb\u0010BR\u001d\u0010g\u001a\u0004\u0018\u00010d8TX\u0002¢\u0006\f\n\u0004\be\u0010@\u001a\u0004\bN\u0010fR\u001d\u0010j\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\f\n\u0004\bh\u0010@\u001a\u0004\bi\u0010^R\u001d\u0010n\u001a\u0004\u0018\u00010k8BX\u0002¢\u0006\f\n\u0004\b1\u0010@\u001a\u0004\bl\u0010mR\u001d\u0010s\u001a\u0004\u0018\u00010o8BX\u0002¢\u0006\f\n\u0004\bp\u0010@\u001a\u0004\bq\u0010rR\u001d\u0010v\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\f\n\u0004\bt\u0010@\u001a\u0004\bu\u0010^R\u001d\u0010y\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\f\n\u0004\bw\u0010@\u001a\u0004\bx\u0010^R\u0018\u0010{\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010zR\u001d\u0010~\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\f\n\u0004\b|\u0010@\u001a\u0004\b}\u0010BR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\r\n\u0004\b\u0010@\u001a\u0005\b\u0001\u0010BR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\r\n\u0004\b\u0013\u0010@\u001a\u0005\b\u0001\u0010^R\u0019\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010@\u001a\u0005\b\u0001\u0010BR \u0010\u0001\u001a\u00030\u00018\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u00020\u000b8\u0016XD¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\bW\u0010\u0001R\u001e\u0010\u0001\u001a\u00020\u000b8\u0016XD¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\bh\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010;\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000e\n\u0004\bi\u0010;\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bx\u0010\u0001R\u001b\u0010¡\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bu\u0010 \u0001R\u0018\u0010¥\u0001\u001a\u00030¢\u00018\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010§\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010 \u0001R\u0018\u0010¨\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0016\u0010¬\u0001\u001a\u00020\u000b8\u0002XD¢\u0006\u0007\n\u0005\bl\u0010\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u0019\u0010±\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u0001R\u0017\u0010³\u0001\u001a\u00020\u00118BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010²\u0001R\u0018\u0010´\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010UR\u0018\u0010¶\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010UR\u0018\u0010·\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010UR\u0018\u0010¸\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010UR\u0018\u0010¹\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010UR\u0018\u0010º\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010UR\u001a\u0010½\u0001\u001a\u0005\u0018\u00010»\u00018BX\u0004¢\u0006\b\u001a\u0006\b­\u0001\u0010¼\u0001R\u0018\u0010¾\u0001\u001a\u0004\u0018\u00010T8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010UR\u001a\u0010Á\u0001\u001a\u0005\u0018\u00010¿\u00018BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010À\u0001R\u0017\u0010Â\u0001\u001a\u0004\u0018\u00010\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010BR\u0017\u0010Å\u0001\u001a\u00020\u001c8TX\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R$\u0010É\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0005\u0012\u00030Ç\u00010Æ\u00018PX\u0004¢\u0006\u0007\u001a\u0005\bJ\u0010È\u0001R\u0018\u0010Í\u0001\u001a\u00030Ê\u00018TX\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006Ð\u0001"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/document/a;", "Lcom/sumsub/sns/camera/b;", "Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel;", "Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$c;", "state", "", "b", "e", "c", "d", "a", "", "force", "l0", "appear", "Landroid/view/View;", "view", "", "frameContainerHeight", "M", "width", "height", "Landroid/graphics/Bitmap;", "Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$j;", "event", "j0", "Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$h;", "", "", "k0", "Lkotlin/Function0;", "finishCallback", "showPhotoMadeAnimation", "", "scaleX", "scaleY", "Lcom/sumsub/sns/internal/ml/docdetector/a;", "detectionResult", "save", "getLayoutId", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "Ljava/io/File;", "file", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX$c;", "F", "Landroidx/camera/core/ImageProxy;", "image", "Lcom/sumsub/sns/internal/core/domain/camera/c;", "exposure", "(Landroidx/camera/core/ImageProxy;Lcom/sumsub/sns/internal/core/domain/camera/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "peekHeight", "Lcom/sumsub/sns/core/presentation/base/a$j;", "handleEvent", "q", "Lkotlin/i;", "i0", "()Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel;", "viewModel", "r", "Lcom/sumsub/sns/internal/core/common/z;", "x", "()Landroid/view/View;", "rootView", "s", "z", "takePictureProgressView", "t", "B", "takePictureViewContainer", "u", "J", "takeGalleryView", "Lcom/sumsub/sns/core/widget/SNSToolbarView;", "v", "C", "()Lcom/sumsub/sns/core/widget/SNSToolbarView;", "toolbar", "w", "progressBar", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "helperTitle", "y", "o", "helperBrief", "p", "helperDetails", "Landroid/view/ViewGroup;", "A", "()Landroid/view/ViewGroup;", "helperDetailsFrame", "g0", "helperView", "m", "darkOverlay", "Landroidx/camera/view/PreviewView;", "D", "()Landroidx/camera/view/PreviewView;", "previewView", "E", "U", "container", "Lcom/sumsub/sns/core/widget/SNSDocBoundsCheckResultView;", "b0", "()Lcom/sumsub/sns/core/widget/SNSDocBoundsCheckResultView;", "docDetectionResultView", "Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground;", "G", "e0", "()Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground;", "frameWithBackground", "H", "W", "debugInfoView", "I", "V", "debugInfoRightView", "Landroid/view/ViewGroup;", "frameHintContainer", "K", "h0", "photoFrameContainerView", "L", "O", "autoCaptureHint", "Q", "autoManual", "N", "Z", "photoMadeAnimation", "getPhotoMadeIndicator", "photoMadeIndicator", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "P", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "()Z", "shouldShowFlash", "R", "isFrontFacingCamera", "S", "isAnimatingPopup", "Lcom/sumsub/sns/internal/ml/autocapture/a;", "T", "()Lcom/sumsub/sns/internal/ml/autocapture/a;", "autoCaptureConfig", "Ljava/text/DecimalFormat;", "()Ljava/text/DecimalFormat;", "confidenceDecimalFormat", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "photoToPreviewTransform", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "photoFrameRect", "Landroid/graphics/RectF;", "X", "Landroid/graphics/RectF;", "photoFrameOnPhotoRectF", "Y", "photoFrameOnPhotoRect", "previewToPhotoMatrix", "a0", "Landroid/graphics/Bitmap;", "frameBitmap", "showDebugInfo", "c0", "Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$c;", "currentCaptureState", "d0", "processingFrame", "()I", "cameraContentColor", "docBoundsConfView", "f0", "goodDocConfView", "debugText1Right", "debugText2Right", "debugText3Right", "frameHintText", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "frameHintIcon", "autoCaptureHintText", "Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView;", "()Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView;", "autoManualSwitch", "takePictureView", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "", "", "()Ljava/util/Map;", "permissionsPayload", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "l", "()Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "cameraMode", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.camera.b<SNSPhotoDocumentPickerViewModel> {

    /* renamed from: o  reason: collision with root package name */
    public static final C0274a f30639o = new C0274a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f30640p = {Reflection.j(new PropertyReference1Impl(a.class, "rootView", "getRootView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takePictureProgressView", "getTakePictureProgressView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takePictureViewContainer", "getTakePictureViewContainer()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takeGalleryView", "getTakeGalleryView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "toolbar", "getToolbar()Lcom/sumsub/sns/core/widget/SNSToolbarView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "progressBar", "getProgressBar()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperTitle", "getHelperTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperBrief", "getHelperBrief()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperDetails", "getHelperDetails()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperDetailsFrame", "getHelperDetailsFrame()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperView", "getHelperView()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "darkOverlay", "getDarkOverlay()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "previewView", "getPreviewView()Landroidx/camera/view/PreviewView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, TtmlNode.RUBY_CONTAINER, "getContainer()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "docDetectionResultView", "getDocDetectionResultView()Lcom/sumsub/sns/core/widget/SNSDocBoundsCheckResultView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "frameWithBackground", "getFrameWithBackground()Lcom/sumsub/sns/camera/photo/presentation/document/SNSFrameViewWithBackground;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "debugInfoView", "getDebugInfoView()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "debugInfoRightView", "getDebugInfoRightView()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "photoFrameContainerView", "getPhotoFrameContainerView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "autoCaptureHint", "getAutoCaptureHint()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "autoManual", "getAutoManual()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "photoMadeIndicator", "getPhotoMadeIndicator()Landroid/view/View;", 0))};
    public final z A = a0.a(this, R.id.sns_helper_details_frame);
    public final z B = a0.a(this, R.id.sns_helper);
    public final z C = a0.a(this, R.id.sns_dark_overlay);
    public final z D = a0.a(this, R.id.sns_camera_preview);
    public final z E = a0.a(this, R.id.sns_camera_preview_container);
    public final z F = a0.a(this, R.id.sns_doc_detection_result);
    public final z G = a0.a(this, R.id.sns_frame_with_background);
    public final z H = a0.a(this, R.id.sns_debug_info);
    public final z I = a0.a(this, R.id.sns_debug_info_right);
    public ViewGroup J;
    public final z K = a0.a(this, R.id.sns_frame_container);
    public final z L = a0.a(this, R.id.sns_autocapture_hint);
    public final z M = a0.a(this, R.id.sns_auto_manual);
    public boolean N;
    public final z O = a0.a(this, R.id.photo_made_indicator);
    public final Screen P = com.sumsub.sns.core.presentation.c.f30925a.a((Fragment) this);
    public final boolean Q = true;
    public final boolean R;
    public boolean S;
    public final kotlin.i T = LazyKt__LazyJVMKt.a(b.f30655a);
    public final kotlin.i U = LazyKt__LazyJVMKt.a(c.f30656a);
    public Matrix V = new Matrix();
    public Rect W;
    public final RectF X = new RectF();
    public final Rect Y = new Rect();
    public final Matrix Z = new Matrix();

    /* renamed from: a0  reason: collision with root package name */
    public Bitmap f30641a0;

    /* renamed from: b0  reason: collision with root package name */
    public final boolean f30642b0;

    /* renamed from: c0  reason: collision with root package name */
    public SNSPhotoDocumentPickerViewModel.c f30643c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f30644d0;

    /* renamed from: q  reason: collision with root package name */
    public final kotlin.i f30645q;

    /* renamed from: r  reason: collision with root package name */
    public final z f30646r = a0.a(this, R.id.sns_content);

    /* renamed from: s  reason: collision with root package name */
    public final z f30647s = a0.a(this, R.id.sns_primary_button_progress);

    /* renamed from: t  reason: collision with root package name */
    public final z f30648t = a0.a(this, R.id.sns_primary_button);

    /* renamed from: u  reason: collision with root package name */
    public final z f30649u = a0.a(this, R.id.sns_gallery);

    /* renamed from: v  reason: collision with root package name */
    public final z f30650v = a0.a(this, R.id.sns_toolbar);

    /* renamed from: w  reason: collision with root package name */
    public final z f30651w = a0.a(this, R.id.sns_picker_progress);

    /* renamed from: x  reason: collision with root package name */
    public final z f30652x = a0.a(this, R.id.sns_helper_title);

    /* renamed from: y  reason: collision with root package name */
    public final z f30653y = a0.a(this, R.id.sns_helper_brief);

    /* renamed from: z  reason: collision with root package name */
    public final z f30654z = a0.a(this, R.id.sns_helper_details);

    /* renamed from: com.sumsub.sns.camera.photo.presentation.document.a$a  reason: collision with other inner class name */
    public static final class C0274a {
        public /* synthetic */ C0274a(r rVar) {
            this();
        }

        public final a a(boolean z11, DocumentType documentType, List<? extends IdentitySide> list, boolean z12, String str, DocCapture.PreferredMode preferredMode, boolean z13, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putBoolean(com.sumsub.sns.internal.camera.a.f31318b, z11);
            bundle.putString(com.sumsub.sns.internal.camera.a.f31319c, documentType.c());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (IdentitySide value : list) {
                arrayList.add(value.getValue());
            }
            bundle.putStringArrayList(com.sumsub.sns.internal.camera.a.f31320d, new ArrayList(arrayList));
            bundle.putBoolean(com.sumsub.sns.internal.camera.a.f31323g, z12);
            bundle.putString(com.sumsub.sns.internal.camera.a.f31324h, preferredMode != null ? preferredMode.getValue() : null);
            bundle.putBoolean(com.sumsub.sns.internal.camera.a.f31325i, z13);
            if (str != null) {
                bundle.putString(com.sumsub.sns.internal.camera.a.f31321e, str);
            }
            if (bVar != null) {
                bundle.putParcelable(com.sumsub.sns.internal.camera.a.f31322f, bVar);
            }
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0274a() {
        }
    }

    public static final class b extends Lambda implements d10.a<com.sumsub.sns.internal.ml.autocapture.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f30655a = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.ml.autocapture.a invoke() {
            return com.sumsub.sns.internal.ml.autocapture.a.f34920m.a();
        }
    }

    public static final class c extends Lambda implements d10.a<DecimalFormat> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f30656a = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final DecimalFormat invoke() {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            return decimalFormat;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f30657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f30658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel.c f30659c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(boolean z11, a aVar, SNSPhotoDocumentPickerViewModel.c cVar) {
            super(0);
            this.f30657a = z11;
            this.f30658b = aVar;
            this.f30659c = cVar;
        }

        public final void a() {
            TextView b11;
            String str;
            if (this.f30657a && (b11 = this.f30658b.P()) != null) {
                SNSPhotoDocumentPickerViewModel.AutoCaptureHint f11 = this.f30659c.f();
                if (f11 == null || (str = f11.c()) == null) {
                    str = " ";
                }
                b11.setText(str);
            }
            TextView b12 = this.f30658b.P();
            if (b12 != null) {
                b12.setVisibility(this.f30657a ? 0 : 8);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30660a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.j f30661b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, a.j jVar) {
            super(0);
            this.f30660a = aVar;
            this.f30661b = jVar;
        }

        public final void a() {
            this.f30660a.N = false;
            ((SNSPhotoDocumentPickerViewModel.i) this.f30661b).b().invoke();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class f extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30662a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar) {
            super(0);
            this.f30662a = aVar;
        }

        public final void a() {
            View e11 = this.f30662a.h0();
            if (e11 != null) {
                e11.setVisibility(4);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.camera.photo.presentation.document.SNSPhotoDocumentPickerFragment$onFrameCaptured$2", f = "SNSPhotoDocumentPickerFragment.kt", l = {281}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public long f30663a;

        /* renamed from: b  reason: collision with root package name */
        public Object f30664b;

        /* renamed from: c  reason: collision with root package name */
        public Object f30665c;

        /* renamed from: d  reason: collision with root package name */
        public int f30666d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageProxy f30668f;

        /* renamed from: com.sumsub.sns.camera.photo.presentation.document.a$g$a  reason: collision with other inner class name */
        public static final class C0275a extends Lambda implements d10.p<Integer, Integer, Bitmap> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30669a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0275a(a aVar) {
                super(2);
                this.f30669a = aVar;
            }

            public final Bitmap a(int i11, int i12) {
                return this.f30669a.a(i11, i12);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a(((Number) obj).intValue(), ((Number) obj2).intValue());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, ImageProxy imageProxy, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f30667e = aVar;
            this.f30668f = imageProxy;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f30667e, this.f30668f, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Object obj2;
            long j11;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30666d;
            if (i11 == 0) {
                kotlin.k.b(obj);
                boolean b11 = x.b(this.f30667e.getViewModel().K().getValue().i().e(), kotlin.coroutines.jvm.internal.a.a(true));
                if (this.f30667e.f30644d0) {
                    if (e0.f32018a.isDebug()) {
                        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "skipped frame", (Throwable) null, 4, (Object) null);
                    }
                    return Unit.f56620a;
                }
                this.f30667e.f30644d0 = true;
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a11 = v.a(this.f30668f, new C0275a(this.f30667e));
                if (b11 && this.f30667e.W != null) {
                    Matrix j12 = this.f30667e.V;
                    int width = a11.getWidth();
                    int height = a11.getHeight();
                    PreviewView v11 = this.f30667e.v();
                    int width2 = v11 != null ? v11.getWidth() : 0;
                    PreviewView v12 = this.f30667e.v();
                    v.a(j12, width, height, width2, v12 != null ? v12.getHeight() : 0, 0, true);
                    this.f30667e.V.invert(this.f30667e.Z);
                    RectF g11 = this.f30667e.X;
                    Rect h11 = this.f30667e.W;
                    if (h11 != null) {
                        g11.set(h11);
                        this.f30667e.Z.mapRect(this.f30667e.X);
                        this.f30667e.Y.set((int) this.f30667e.X.left, (int) this.f30667e.X.top, (int) this.f30667e.X.right, (int) this.f30667e.X.bottom);
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                }
                Context context = this.f30667e.getContext();
                if (context != null) {
                    a aVar = this.f30667e;
                    SNSPhotoDocumentPickerViewModel i02 = aVar.getViewModel();
                    Rect f11 = aVar.Y;
                    this.f30664b = a11;
                    this.f30665c = context;
                    this.f30663a = currentTimeMillis;
                    this.f30666d = 1;
                    if (i02.a(context, a11, f11, (kotlin.coroutines.c<? super SNSPhotoDocumentPickerViewModel.FrameHandleResult>) this) == d11) {
                        return d11;
                    }
                    obj2 = context;
                } else {
                    obj2 = null;
                }
                j11 = currentTimeMillis;
                bitmap = a11;
            } else if (i11 == 1) {
                j11 = this.f30663a;
                obj2 = (Context) this.f30665c;
                bitmap = (Bitmap) this.f30664b;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (obj2 == null) {
                obj2 = SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED;
            }
            if (obj2 == SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED) {
                bitmap.recycle();
            }
            TextView c11 = this.f30667e.Z();
            if (c11 != null) {
                com.sumsub.sns.internal.core.common.i.a(c11, (CharSequence) "frame handle: " + this.f30667e.a(System.currentTimeMillis() - j11));
            }
            this.f30667e.f30644d0 = false;
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.camera.photo.presentation.document.SNSPhotoDocumentPickerFragment$onViewCreated$1", f = "SNSPhotoDocumentPickerFragment.kt", l = {}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements d10.p<SNSPhotoDocumentPickerViewModel.c, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30670a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30671b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f30672c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f30672c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSPhotoDocumentPickerViewModel.c cVar, kotlin.coroutines.c<? super Unit> cVar2) {
            return ((h) create(cVar, cVar2)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            h hVar = new h(this.f30672c, cVar);
            hVar.f30671b = obj;
            return hVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30670a == 0) {
                kotlin.k.b(obj);
                this.f30672c.b((SNSPhotoDocumentPickerViewModel.c) this.f30671b);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class i implements SNSSegmentedToggleView.OnItemSelected {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30673a;

        public i(a aVar) {
            this.f30673a = aVar;
        }

        public void onSelected(int i11) {
            this.f30673a.getViewModel().c(i11 == 0);
            this.f30673a.getAnalyticsDelegate().a(this.f30673a.getScreen(), this.f30673a.getIdDocSetType(), Control.AutocaptureSegmentedControl, this.f30673a.u());
        }
    }

    public static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f30674a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f30675b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SizeF f30676c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f30677d;

        public j(View view, a aVar, SizeF sizeF, boolean z11) {
            this.f30674a = view;
            this.f30675b = aVar;
            this.f30676c = sizeF;
            this.f30677d = z11;
        }

        public final void run() {
            SNSFrameViewWithBackground d11 = this.f30675b.e0();
            if (d11 != null) {
                d11.setFrameSize(this.f30676c);
            }
            SNSFrameViewWithBackground d12 = this.f30675b.e0();
            if (d12 != null) {
                d12.b();
            }
            this.f30675b.l0();
            this.f30675b.M();
            if (this.f30677d) {
                a aVar = this.f30675b;
                com.sumsub.sns.camera.a.a(aVar, true, aVar.h0(), (d10.a) null, 4, (Object) null);
            }
        }
    }

    public static final class k implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30678a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f30679b;

        public k(a aVar, d10.a<Unit> aVar2) {
            this.f30678a = aVar;
            this.f30679b = aVar2;
        }

        public void onAnimationEnd(Animation animation) {
            View i11 = this.f30678a.getPhotoMadeIndicator();
            if (i11 != null) {
                i11.setVisibility(8);
            }
            d10.a<Unit> aVar = this.f30679b;
            if (aVar != null) {
                aVar.invoke();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            View i11 = this.f30678a.getPhotoMadeIndicator();
            if (i11 != null) {
                i11.setVisibility(0);
            }
        }
    }

    public static final class l extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30680a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment) {
            super(0);
            this.f30680a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f30680a;
        }
    }

    public static final class m extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30681a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d10.a aVar) {
            super(0);
            this.f30681a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f30681a.invoke();
        }
    }

    public static final class n extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30682a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(kotlin.i iVar) {
            super(0);
            this.f30682a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f30682a).getViewModelStore();
        }
    }

    public static final class o extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30684b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f30683a = aVar;
            this.f30684b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f30683a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f30684b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class p extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30685a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30686b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f30685a = fragment;
            this.f30686b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f30686b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f30685a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class q extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30687a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(a aVar) {
            super(0);
            this.f30687a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f30687a;
            return new com.sumsub.sns.internal.camera.photo.presentation.document.d(aVar, aVar.getServiceLocator(), this.f30687a.getArguments());
        }
    }

    public a() {
        q qVar = new q(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new m(new l(this)));
        this.f30645q = FragmentViewModelLazyKt.c(this, Reflection.b(SNSPhotoDocumentPickerViewModel.class), new n(b11), new o((d10.a) null, b11), qVar);
    }

    /* access modifiers changed from: private */
    public final View getPhotoMadeIndicator() {
        return this.O.a(this, f30640p[21]);
    }

    public View A() {
        View B2 = B();
        if (B2 != null) {
            return B2.findViewById(R.id.sns_button);
        }
        return null;
    }

    public View B() {
        return this.f30648t.a(this, f30640p[2]);
    }

    public SNSToolbarView C() {
        return (SNSToolbarView) this.f30650v.a(this, f30640p[4]);
    }

    public boolean E() {
        return this.R;
    }

    public void F() {
        getViewModel().P();
    }

    public View J() {
        return this.f30649u.a(this, f30640p[3]);
    }

    public final void M() {
        Rect rect;
        RectF frameRect;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "configurePhotoFrameRect", (Throwable) null, 4, (Object) null);
        View h02 = h0();
        int top = h02 != null ? h02.getTop() : 0;
        SNSFrameViewWithBackground e02 = e0();
        if (e02 == null || (frameRect = e02.getFrameRect()) == null) {
            rect = null;
        } else {
            rect = new Rect((int) frameRect.left, ((int) frameRect.top) + top, (int) frameRect.right, top + ((int) frameRect.bottom));
            this.X.set(rect);
        }
        this.W = rect;
    }

    public final com.sumsub.sns.internal.ml.autocapture.a N() {
        return (com.sumsub.sns.internal.ml.autocapture.a) this.T.getValue();
    }

    public final View O() {
        return this.L.a(this, f30640p[19]);
    }

    public final TextView P() {
        View O2 = O();
        if (O2 instanceof TextView) {
            return (TextView) O2;
        }
        return null;
    }

    public final ViewGroup Q() {
        return (ViewGroup) this.M.a(this, f30640p[20]);
    }

    public final SNSSegmentedToggleView R() {
        ViewGroup Q2 = Q();
        if (Q2 != null) {
            return (SNSSegmentedToggleView) Q2.findViewById(R.id.sns_auto_manual_switch);
        }
        return null;
    }

    public final int S() {
        View x11 = x();
        if (x11 != null) {
            return com.sumsub.sns.core.presentation.helper.a.f31095a.a(x11, SNSColorElement.CAMERA_CONTENT, ContextCompat.getColor(requireContext(), R.color.sns_camera_content));
        }
        return -1;
    }

    public final DecimalFormat T() {
        return (DecimalFormat) this.U.getValue();
    }

    public final ViewGroup U() {
        return (ViewGroup) this.E.a(this, f30640p[13]);
    }

    public final ViewGroup V() {
        return (ViewGroup) this.I.a(this, f30640p[17]);
    }

    public final ViewGroup W() {
        return (ViewGroup) this.H.a(this, f30640p[16]);
    }

    public final TextView X() {
        ViewGroup V2 = V();
        if (V2 != null) {
            return (TextView) V2.findViewById(R.id.text1);
        }
        return null;
    }

    public final TextView Y() {
        ViewGroup V2 = V();
        if (V2 != null) {
            return (TextView) V2.findViewById(R.id.text2);
        }
        return null;
    }

    public final TextView Z() {
        ViewGroup V2 = V();
        if (V2 != null) {
            return (TextView) V2.findViewById(R.id.text3);
        }
        return null;
    }

    public final TextView a0() {
        ViewGroup W2 = W();
        if (W2 != null) {
            return (TextView) W2.findViewById(R.id.sns_doc_bounds_confidence);
        }
        return null;
    }

    public final SNSDocBoundsCheckResultView b0() {
        return (SNSDocBoundsCheckResultView) this.F.a(this, f30640p[14]);
    }

    public final ImageView c0() {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            return (ImageView) viewGroup.findViewById(R.id.sns_icon);
        }
        return null;
    }

    public final TextView d0() {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            return (TextView) viewGroup.findViewById(R.id.sns_text);
        }
        return null;
    }

    public final SNSFrameViewWithBackground e0() {
        return (SNSFrameViewWithBackground) this.G.a(this, f30640p[15]);
    }

    public final TextView f0() {
        ViewGroup W2 = W();
        if (W2 != null) {
            return (TextView) W2.findViewById(R.id.sns_good_photo_confidence);
        }
        return null;
    }

    /* renamed from: g0 */
    public ViewGroup s() {
        return (ViewGroup) this.B.a(this, f30640p[10]);
    }

    public String getIdDocSetType() {
        return getViewModel().u().c();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_document_picker;
    }

    public Screen getScreen() {
        return this.P;
    }

    public final View h0() {
        return this.K.a(this, f30640p[18]);
    }

    public void handleEvent(a.j jVar) {
        super.handleEvent(jVar);
        if (jVar instanceof SNSPhotoDocumentPickerViewModel.h) {
            SNSPhotoDocumentPickerViewModel.h hVar = (SNSPhotoDocumentPickerViewModel.h) jVar;
            float width = ((float) hVar.i().getWidth()) / ((float) hVar.k().getWidth());
            float height = ((float) hVar.i().getHeight()) / ((float) hVar.k().getHeight());
            a(hVar);
            if (hVar.g()) {
                a(width, height, hVar.j(), hVar.l());
            }
        } else if (jVar instanceof SNSPhotoDocumentPickerViewModel.e) {
            j0();
            k0();
        } else if (jVar instanceof SNSPhotoDocumentPickerViewModel.j) {
            a((SNSPhotoDocumentPickerViewModel.j) jVar);
        } else if (jVar instanceof SNSPhotoDocumentPickerViewModel.i) {
            if (!this.N) {
                this.N = true;
                showPhotoMadeAnimation(new e(this, jVar));
            }
        } else if (jVar instanceof SNSPhotoDocumentPickerViewModel.g) {
            com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 100, (Bundle) null, 2, (Object) null);
        }
    }

    /* renamed from: i0 */
    public SNSPhotoDocumentPickerViewModel getViewModel() {
        return (SNSPhotoDocumentPickerViewModel) this.f30645q.getValue();
    }

    public final void j0() {
        ViewGroup W2 = W();
        if (W2 != null) {
            W2.setVisibility(8);
        }
        ViewGroup V2 = V();
        if (V2 != null) {
            V2.setVisibility(8);
        }
        TextView a02 = a0();
        if (a02 != null) {
            com.sumsub.sns.internal.core.common.i.a(a02, (CharSequence) null);
        }
        TextView f02 = f0();
        if (f02 != null) {
            com.sumsub.sns.internal.core.common.i.a(f02, (CharSequence) null);
        }
    }

    public final void k0() {
        SNSDocBoundsCheckResultView b02 = b0();
        if (b02 != null) {
            b02.setDocRect((Rect) null);
        }
    }

    public final void l0() {
        RectF frameRect;
        Drawable background;
        SNSFrameViewWithBackground e02 = e0();
        if (e02 != null && (frameRect = e02.getFrameRect()) != null) {
            ViewGroup viewGroup = this.J;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.drawable.sns_round_rect_background);
            }
            ViewGroup viewGroup2 = this.J;
            if (!(viewGroup2 == null || (background = viewGroup2.getBackground()) == null)) {
                com.sumsub.sns.internal.core.common.m.a(background, e02.getFrameBackgroundColor());
            }
            ViewGroup viewGroup3 = this.J;
            if (viewGroup3 != null) {
                viewGroup3.setLeft((int) frameRect.left);
            }
            ViewGroup viewGroup4 = this.J;
            if (viewGroup4 != null) {
                viewGroup4.setTop((int) frameRect.top);
            }
            ViewGroup viewGroup5 = this.J;
            if (viewGroup5 != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                layoutParams.width = (int) frameRect.width();
                layoutParams.height = (int) frameRect.height();
                viewGroup5.setLayoutParams(layoutParams);
            }
        }
    }

    public TextView o() {
        return (TextView) this.f30653y.a(this, f30640p[7]);
    }

    public boolean onFinishCalled(com.sumsub.sns.internal.core.common.q qVar) {
        boolean onFinishCalled = super.onFinishCalled(qVar);
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "finishing photo screen: " + qVar, (Throwable) null, 4, (Object) null);
        return onFinishCalled;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View h02 = h0();
        if (h02 != null) {
            h02.setVisibility(4);
        }
        b0.b(getViewModel().K(), (LifecycleOwner) this, new h(this, (kotlin.coroutines.c<? super h>) null));
        SNSSegmentedToggleView R2 = R();
        if (R2 != null) {
            com.sumsub.sns.internal.core.common.i.a((View) R2, !getViewModel().D());
        }
        SNSSegmentedToggleView R3 = R();
        if (R3 != null) {
            R3.setOnItemSelected(new i(this));
        }
        View findViewById = requireView().findViewById(R.id.sns_save_frame);
        findViewById.setVisibility(8);
        findViewById.setOnClickListener(new d(this));
    }

    public TextView p() {
        return (TextView) this.f30654z.a(this, f30640p[8]);
    }

    public ViewGroup q() {
        return (ViewGroup) this.A.a(this, f30640p[9]);
    }

    public TextView r() {
        return (TextView) this.f30652x.a(this, f30640p[6]);
    }

    public final void showPhotoMadeAnimation(d10.a<Unit> aVar) {
        View photoMadeIndicator = getPhotoMadeIndicator();
        if (photoMadeIndicator != null) {
            photoMadeIndicator.setVisibility(4);
        }
        View photoMadeIndicator2 = getPhotoMadeIndicator();
        if (photoMadeIndicator2 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(new k(this, aVar));
            photoMadeIndicator2.startAnimation(alphaAnimation);
        }
    }

    public Map<String, Object> u() {
        Map<String, Object> y11 = MapsKt__MapsKt.y(super.u());
        Boolean h11 = getViewModel().K().getValue().i().h();
        if (h11 != null) {
            y11.put("isAutocaptureEnabled", Boolean.valueOf(h11.booleanValue()));
        }
        Boolean e11 = getViewModel().K().getValue().i().e();
        if (e11 != null) {
            y11.put("isAutocaptureActive", Boolean.valueOf(e11.booleanValue()));
        }
        return y11;
    }

    public PreviewView v() {
        return (PreviewView) this.D.a(this, f30640p[12]);
    }

    public View w() {
        return this.f30651w.a(this, f30640p[5]);
    }

    public View x() {
        return this.f30646r.a(this, f30640p[0]);
    }

    public boolean y() {
        return this.Q;
    }

    public View z() {
        return this.f30647s.a(this, f30640p[1]);
    }

    public static final void o(a aVar) {
        a(aVar, false, 1, (Object) null);
    }

    public final void c(SNSPhotoDocumentPickerViewModel.c cVar) {
        ViewGroup viewGroup;
        String d11;
        ImageView c02;
        SNSProgressBarView sNSProgressBarView;
        View requireView = requireView();
        int i11 = R.id.sns_popup_hint_container_background;
        View findViewById = requireView.findViewById(i11);
        int i12 = 8;
        boolean z11 = true;
        if (!(findViewById == null || (sNSProgressBarView = (SNSProgressBarView) findViewById.findViewById(R.id.sns_progress)) == null)) {
            SNSPhotoDocumentPickerViewModel.d h11 = cVar.h();
            sNSProgressBarView.setVisibility(h11 != null && h11.e() ? 0 : 8);
            sNSProgressBarView.setIndeterminateTintList(ColorStateList.valueOf(S()));
        }
        if (!this.S) {
            ViewGroup viewGroup2 = this.J;
            if (x.b(cVar.i().e(), Boolean.TRUE)) {
                viewGroup = (ViewGroup) requireView().findViewById(R.id.sns_frame_popup_hint_container);
            } else {
                viewGroup = (ViewGroup) requireView().findViewById(i11);
            }
            this.J = viewGroup;
            if (!x.b(viewGroup2, viewGroup) && viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (this.J != null) {
                TextView d02 = d0();
                if (d02 != null) {
                    SNSPhotoDocumentPickerViewModel.d h12 = cVar.h();
                    com.sumsub.sns.internal.core.common.i.a(d02, h12 != null ? h12.f() : null);
                }
                TextView d03 = d0();
                if (d03 != null) {
                    d03.setTextColor(S());
                }
                SNSPhotoDocumentPickerViewModel.d h13 = cVar.h();
                if (!(h13 == null || (d11 = h13.d()) == null || (c02 = c0()) == null)) {
                    c02.setImageDrawable(com.sumsub.sns.core.presentation.helper.a.f31095a.a(requireContext(), d11));
                }
                ImageView c03 = c0();
                if (c03 != null) {
                    c03.setImageTintList(ColorStateList.valueOf(S()));
                }
                ViewGroup viewGroup3 = this.J;
                if (viewGroup3 != null) {
                    if (cVar.h() == null) {
                        z11 = false;
                    }
                    if (z11) {
                        i12 = 0;
                    }
                    viewGroup3.setVisibility(i12);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r1 = r1.i();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c r10) {
        /*
            r9 = this;
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r0 = r10.i()
            java.lang.Boolean r1 = r0.e()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            r3 = 1
            r1 = r1 ^ r3
            com.sumsub.sns.core.widget.SNSSegmentedToggleView r4 = r9.R()
            r5 = 0
            if (r4 == 0) goto L_0x0042
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.CharSequence r7 = r0.f()
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0028
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0029
        L_0x0028:
            r7 = r8
        L_0x0029:
            r6[r5] = r7
            java.lang.CharSequence r7 = r0.g()
            if (r7 == 0) goto L_0x0039
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r8 = r7
        L_0x0039:
            r6[r3] = r8
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.n(r6)
            r4.setItems(r6, r1)
        L_0x0042:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r1 = r9.f30643c0
            if (r1 == 0) goto L_0x0051
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r1 = r1.i()
            if (r1 == 0) goto L_0x0051
            java.lang.Boolean r1 = r1.e()
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            java.lang.Boolean r4 = r0.h()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r2)
            if (r4 == 0) goto L_0x0084
            java.lang.Boolean r4 = r0.e()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r1)
            if (r4 != 0) goto L_0x0084
            java.lang.Boolean r4 = r0.e()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r2)
            android.view.ViewGroup r6 = r9.Q()
            r9.a((boolean) r4, (android.view.View) r6)
            java.lang.Boolean r4 = r0.e()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r2)
            com.sumsub.sns.core.widget.SNSToolbarView r6 = r9.C()
            r9.a((boolean) r4, (android.view.View) r6)
        L_0x0084:
            android.view.ViewGroup r4 = r9.Q()
            if (r4 != 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            java.lang.Boolean r6 = r0.h()
            boolean r6 = kotlin.jvm.internal.x.b(r6, r2)
            if (r6 == 0) goto L_0x0097
            r6 = r5
            goto L_0x0099
        L_0x0097:
            r6 = 8
        L_0x0099:
            r4.setVisibility(r6)
        L_0x009c:
            android.view.View r4 = r9.O()
            if (r4 != 0) goto L_0x00a3
            goto L_0x00b4
        L_0x00a3:
            java.lang.Boolean r6 = r0.e()
            boolean r6 = kotlin.jvm.internal.x.b(r6, r2)
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x00b0
            r3 = 4
            goto L_0x00b1
        L_0x00b0:
            r3 = r5
        L_0x00b1:
            r4.setVisibility(r3)
        L_0x00b4:
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            if (r1 == 0) goto L_0x00d2
            java.lang.Boolean r1 = r0.e()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x00d2
            android.view.View r1 = r9.h0()
            com.sumsub.sns.camera.photo.presentation.document.a$f r3 = new com.sumsub.sns.camera.photo.presentation.document.a$f
            r3.<init>(r9)
            r9.a((boolean) r5, (android.view.View) r1, (d10.a<kotlin.Unit>) r3)
        L_0x00d2:
            java.lang.Boolean r0 = r0.e()
            boolean r0 = kotlin.jvm.internal.x.b(r0, r2)
            if (r0 == 0) goto L_0x00ea
            android.view.View r0 = r9.O()
            if (r0 == 0) goto L_0x00ea
            com.sumsub.sns.camera.photo.presentation.document.e r1 = new com.sumsub.sns.camera.photo.presentation.document.e
            r1.<init>(r9)
            r0.post(r1)
        L_0x00ea:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r0 = r9.e0()
            if (r0 != 0) goto L_0x00f1
            goto L_0x0108
        L_0x00f1:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r10 = r10.f()
            if (r10 == 0) goto L_0x0103
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r10 = r10.d()
            if (r10 == 0) goto L_0x0103
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground$State r10 = com.sumsub.sns.camera.photo.presentation.document.b.b(r10)
            if (r10 != 0) goto L_0x0105
        L_0x0103:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground$State r10 = com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground.State.RED
        L_0x0105:
            r0.setState(r10)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.document.a.d(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = r3.j();
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c r10) {
        /*
            r9 = this;
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r0 = r10.j()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0061
            java.io.File r0 = r0.c()
            if (r0 == 0) goto L_0x0061
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r3 = r9.f30643c0
            r4 = 0
            if (r3 == 0) goto L_0x001e
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r3 = r3.j()
            if (r3 == 0) goto L_0x001e
            java.io.File r3 = r3.c()
            goto L_0x001f
        L_0x001e:
            r3 = r4
        L_0x001f:
            if (r3 != 0) goto L_0x0034
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r3 = r10.j()
            if (r3 == 0) goto L_0x002f
            boolean r3 = r3.d()
            if (r3 != r2) goto L_0x002f
            r3 = r2
            goto L_0x0030
        L_0x002f:
            r3 = r1
        L_0x0030:
            if (r3 == 0) goto L_0x0034
            r3 = r2
            goto L_0x0035
        L_0x0034:
            r3 = r1
        L_0x0035:
            if (r3 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = r4
        L_0x0039:
            if (r0 == 0) goto L_0x0061
            com.sumsub.sns.internal.camera.photo.presentation.document.b r3 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "start video recording: "
            r4.append(r5)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r5 = r9.getViewModel()
            com.sumsub.sns.internal.core.domain.camera.CameraX$b r5 = r5.v()
            r4.append(r5)
            java.lang.String r5 = r4.toString()
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r3, r4, r5, r6, r7, r8)
            r9.d(r0)
        L_0x0061:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r10 = r10.j()
            if (r10 == 0) goto L_0x006f
            boolean r10 = r10.d()
            if (r10 != 0) goto L_0x006f
            r10 = r2
            goto L_0x0070
        L_0x006f:
            r10 = r1
        L_0x0070:
            if (r10 == 0) goto L_0x0088
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r10 = r9.f30643c0
            if (r10 == 0) goto L_0x0083
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r10 = r10.j()
            if (r10 == 0) goto L_0x0083
            boolean r10 = r10.d()
            if (r10 != r2) goto L_0x0083
            r1 = r2
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            r9.H()
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.document.a.e(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c):void");
    }

    public CameraX.Mode l() {
        return getViewModel().G();
    }

    public View m() {
        return this.C.a(this, f30640p[11]);
    }

    public void b(File file) {
        getViewModel().b(file);
    }

    public Object b(ImageProxy imageProxy, com.sumsub.sns.internal.core.domain.camera.c cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        Object g11 = kotlinx.coroutines.g.g(v0.c(), new g(this, imageProxy, (kotlin.coroutines.c<? super g>) null), cVar2);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    public final void b(SNSPhotoDocumentPickerViewModel.c cVar) {
        View view;
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "handleDocumentCaptureState: " + cVar, (Throwable) null, 4, (Object) null);
        e(cVar);
        d(cVar);
        a(cVar);
        c(cVar);
        a.d g11 = cVar.g();
        if (!(g11 == null || (view = getView()) == null)) {
            view.post(new f(this, g11));
        }
        this.f30643c0 = cVar;
    }

    public static final void a(a aVar, View view) {
        aVar.getViewModel().f(true);
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "saving the screen", (Throwable) null, 4, (Object) null);
    }

    public void a(CameraX.c cVar) {
        getViewModel().a(cVar);
    }

    public static final void a(a aVar, a.d dVar) {
        aVar.getBaseActivity().a(dVar.e(), dVar.f(), dVar.d());
    }

    public final int b(int i11) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sns_autocapture_hint_min_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.sns_autocapture_switch_min_height) + (getResources().getDimensionPixelSize(R.dimen.sns_margin_medium) * 2);
        BottomSheetBehavior<View> t11 = t();
        int peekHeight = t11 != null ? t11.getPeekHeight() : 0;
        ViewGroup U2 = U();
        int height = U2 != null ? U2.getHeight() : 0;
        SNSToolbarView C2 = C();
        int height2 = ((height - (C2 != null ? C2.getHeight() : 0)) - i11) - peekHeight;
        int i12 = dimensionPixelSize + dimensionPixelSize2;
        if (RangesKt___RangesKt.d(height2, 0) < i12) {
            return i12 - height2;
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.i();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c r6) {
        /*
            r5 = this;
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r0 = r5.f30643c0
            if (r0 == 0) goto L_0x000f
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r0 = r0.i()
            if (r0 == 0) goto L_0x000f
            java.lang.Boolean r0 = r0.e()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r1 = r6.f()
            r2 = 0
            if (r1 == 0) goto L_0x002a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r1 = r6.i()
            java.lang.Boolean r1 = r1.e()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = r2
            goto L_0x002b
        L_0x002a:
            r1 = 1
        L_0x002b:
            r3 = r1 ^ 1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r4 = r6.i()
            java.lang.Boolean r4 = r4.e()
            boolean r0 = kotlin.jvm.internal.x.b(r4, r0)
            r4 = 8
            if (r0 != 0) goto L_0x005e
            android.view.View r0 = r5.O()
            if (r0 != 0) goto L_0x0044
            goto L_0x004a
        L_0x0044:
            if (r1 == 0) goto L_0x0047
            r2 = r4
        L_0x0047:
            r0.setVisibility(r2)
        L_0x004a:
            android.view.View r0 = r5.O()
            r5.a((boolean) r3, (android.view.View) r0)
            android.view.View r0 = r5.O()
            com.sumsub.sns.camera.photo.presentation.document.a$d r1 = new com.sumsub.sns.camera.photo.presentation.document.a$d
            r1.<init>(r3, r5, r6)
            r5.a((boolean) r3, (android.view.View) r0, (d10.a<kotlin.Unit>) r1)
            goto L_0x0087
        L_0x005e:
            if (r3 == 0) goto L_0x0079
            android.widget.TextView r0 = r5.P()
            if (r0 != 0) goto L_0x0067
            goto L_0x0079
        L_0x0067:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r6 = r6.f()
            if (r6 == 0) goto L_0x0074
            java.lang.String r6 = r6.c()
            if (r6 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            java.lang.String r6 = " "
        L_0x0076:
            r0.setText(r6)
        L_0x0079:
            android.widget.TextView r6 = r5.P()
            if (r6 != 0) goto L_0x0080
            goto L_0x0087
        L_0x0080:
            if (r3 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r2 = r4
        L_0x0084:
            r6.setVisibility(r2)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.document.a.a(com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c):void");
    }

    public void a(int i11) {
        if (x.b(getViewModel().K().getValue().i().e(), Boolean.TRUE)) {
            a(true);
        }
    }

    public static /* synthetic */ void a(a aVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        aVar.a(z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00db, code lost:
        if ((r0.getVisibility() == 0) == false) goto L_0x00df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r10) {
        /*
            r9 = this;
            android.view.View r0 = r9.h0()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != r1) goto L_0x0015
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            if (r10 != 0) goto L_0x001b
            return
        L_0x001b:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r3 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "showPhotoFrame: "
            r0.append(r4)
            r0.append(r10)
            java.lang.String r5 = r0.toString()
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r3, r4, r5, r6, r7, r8)
            android.view.View r10 = r9.h0()
            if (r10 == 0) goto L_0x015d
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            if (r10 == 0) goto L_0x015d
            android.view.View r10 = r9.h0()
            if (r10 == 0) goto L_0x004d
            int r10 = r10.getWidth()
            goto L_0x004e
        L_0x004d:
            r10 = r2
        L_0x004e:
            float r10 = (float) r10
            android.content.Context r0 = r9.requireContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            r3 = 5
            r4 = 1119092736(0x42b40000, float:90.0)
            float r0 = android.util.TypedValue.applyDimension(r3, r4, r0)
            android.content.res.Resources r3 = r9.getResources()
            int r4 = com.sumsub.sns.R.dimen.sns_margin_small
            int r3 = r3.getDimensionPixelSize(r4)
            android.content.res.Resources r4 = r9.getResources()
            int r5 = com.sumsub.sns.R.dimen.sns_margin_medium
            int r4 = r4.getDimensionPixelSize(r5)
            int r4 = r4 * 2
            float r4 = (float) r4
            float r4 = r10 - r4
            float r0 = kotlin.ranges.RangesKt___RangesKt.f(r4, r0)
            int r0 = (int) r0
            float r0 = (float) r0
            com.sumsub.sns.internal.ml.autocapture.a r4 = r9.N()
            float r4 = r4.q()
            float r4 = r0 / r4
            int r4 = (int) r4
            int r3 = r3 * 2
            int r3 = r3 + r4
            int r5 = r9.b((int) r3)
            if (r5 == 0) goto L_0x00ab
            int r4 = r4 - r5
            int r3 = r3 - r5
            com.sumsub.sns.core.widget.SNSSegmentedToggleView r5 = r9.R()
            if (r5 == 0) goto L_0x00ab
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            if (r5 == 0) goto L_0x00ab
            boolean r6 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto L_0x00ab
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            r5.topMargin = r2
        L_0x00ab:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r5 = r9.e0()
            if (r5 == 0) goto L_0x00c6
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            if (r5 == 0) goto L_0x00c6
            int r10 = (int) r10
            r5.width = r10
            r5.height = r3
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r10 = r9.e0()
            if (r10 != 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            r10.setLayoutParams(r5)
        L_0x00c6:
            android.util.SizeF r10 = new android.util.SizeF
            float r3 = (float) r4
            r10.<init>(r0, r3)
            android.view.View r0 = r9.h0()
            if (r0 == 0) goto L_0x00de
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00da
            r0 = r1
            goto L_0x00db
        L_0x00da:
            r0 = r2
        L_0x00db:
            if (r0 != 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r1 = r2
        L_0x00df:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r0 = r9.e0()
            if (r0 == 0) goto L_0x00ed
            com.sumsub.sns.camera.photo.presentation.document.a$j r3 = new com.sumsub.sns.camera.photo.presentation.document.a$j
            r3.<init>(r0, r9, r10, r1)
            androidx.core.view.y.a(r0, r3)
        L_0x00ed:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r0 = r9.e0()
            if (r0 != 0) goto L_0x00f4
            goto L_0x00f7
        L_0x00f4:
            r0.setFrameSize(r10)
        L_0x00f7:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r10 = r9.e0()
            if (r10 == 0) goto L_0x0100
            r10.b()
        L_0x0100:
            r9.M()
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground r10 = r9.e0()
            if (r10 != 0) goto L_0x010a
            goto L_0x010f
        L_0x010a:
            com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground$State r0 = com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground.State.RED
            r10.setState(r0)
        L_0x010f:
            android.view.View r10 = r9.O()
            if (r10 != 0) goto L_0x0116
            goto L_0x0146
        L_0x0116:
            android.view.View r0 = r9.O()
            if (r0 == 0) goto L_0x0142
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L_0x0142
            boolean r1 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r1 == 0) goto L_0x0143
            r1 = r0
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r9.t()
            if (r3 == 0) goto L_0x0134
            int r3 = r3.getPeekHeight()
            goto L_0x0135
        L_0x0134:
            r3 = r2
        L_0x0135:
            r1.bottomMargin = r3
            android.view.View r1 = r9.O()
            if (r1 != 0) goto L_0x013e
            goto L_0x0143
        L_0x013e:
            r1.setLayoutParams(r0)
            goto L_0x0143
        L_0x0142:
            r0 = 0
        L_0x0143:
            r10.setLayoutParams(r0)
        L_0x0146:
            android.view.View r10 = r9.h0()
            if (r10 != 0) goto L_0x014d
            goto L_0x015d
        L_0x014d:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r0 = r9.getViewModel()
            boolean r0 = r0.D()
            if (r0 == 0) goto L_0x0158
            goto L_0x015a
        L_0x0158:
            r2 = 8
        L_0x015a:
            r10.setVisibility(r2)
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.document.a.a(boolean):void");
    }

    public final void a(boolean z11, View view) {
        int i11;
        int color = ContextCompat.getColor(requireContext(), R.color.sns_auto_capture_frame_background);
        SNSFrameViewWithBackground e02 = e0();
        if (e02 != null) {
            color = e02.getFrameBackgroundColor();
        }
        if (z11) {
            i11 = 0;
        } else {
            i11 = color;
            color = 0;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluatorCompat(), new Object[]{Integer.valueOf(i11), Integer.valueOf(color)});
        ofObject.setDuration((long) n());
        ofObject.addUpdateListener(new c(view));
        ofObject.start();
    }

    public static final void a(View view, ValueAnimator valueAnimator) {
        if (view != null) {
            view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public final Bitmap a(int i11, int i12) {
        Bitmap bitmap = this.f30641a0;
        if (bitmap != null && bitmap.getWidth() == i11 && bitmap.getHeight() == i12 && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmap2 = this.f30641a0;
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.f30641a0 = null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "prepared frame bitmap " + createBitmap.getWidth() + 'x' + createBitmap.getHeight(), (Throwable) null, 4, (Object) null);
        Bitmap copy = createBitmap.copy(Bitmap.Config.ARGB_8888, true);
        if (createBitmap != copy) {
            createBitmap.recycle();
        }
        this.f30641a0 = copy;
        return copy;
    }

    public final void a(SNSPhotoDocumentPickerViewModel.j jVar) {
        ViewGroup W2 = W();
        if (W2 != null) {
            W2.setVisibility(this.f30642b0 ? 0 : 8);
        }
        if (this.f30642b0) {
            String str = "Good doc conf: " + T().format(Float.valueOf(jVar.d()));
            TextView f02 = f0();
            if (f02 != null) {
                com.sumsub.sns.internal.core.common.i.a(f02, (CharSequence) str);
            }
            TextView Y2 = Y();
            if (Y2 != null) {
                com.sumsub.sns.internal.core.common.i.a(Y2, (CharSequence) "badphotos time " + a(jVar.f()));
            }
        }
    }

    public final void a(SNSPhotoDocumentPickerViewModel.h hVar) {
        ViewGroup V2 = V();
        int i11 = 0;
        if (V2 != null) {
            V2.setVisibility(this.f30642b0 ? 0 : 8);
        }
        if (this.f30642b0) {
            String str = "Doc bounds conf: " + T().format(Float.valueOf(hVar.j().h()));
            TextView a02 = a0();
            if (a02 != null) {
                com.sumsub.sns.internal.core.common.i.a(a02, (CharSequence) str);
            }
            ViewGroup W2 = W();
            if (W2 != null) {
                if (!this.f30642b0) {
                    i11 = 8;
                }
                W2.setVisibility(i11);
            }
            TextView X2 = X();
            if (X2 != null) {
                com.sumsub.sns.internal.core.common.i.a(X2, (CharSequence) "auto cap time " + a(hVar.j().l()));
            }
        }
    }

    public final String a(long j11) {
        return j11 + " ms";
    }

    public static /* synthetic */ void a(a aVar, d10.a aVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar2 = null;
        }
        aVar.showPhotoMadeAnimation(aVar2);
    }

    public static /* synthetic */ void a(a aVar, float f11, float f12, com.sumsub.sns.internal.ml.docdetector.a aVar2, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        aVar.a(f11, f12, aVar2, z11);
    }

    public final void a(float f11, float f12, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11) {
        Rect a11 = com.sumsub.sns.internal.camera.photo.presentation.document.c.a(aVar.m(), f11, f12);
        if (z11) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "showDocumentFrameAndCheckPhotoFrame: " + a11, (Throwable) null, 4, (Object) null);
        }
        RectF rectF = new RectF(a11);
        this.V.mapRect(rectF);
        if (z11) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar2 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar2, DocCapture.f31492c, "showDocumentFrameAndCheckPhotoFrame: view rect=" + rectF, (Throwable) null, 4, (Object) null);
        }
        SNSDocBoundsCheckResultView b02 = b0();
        if (b02 != null) {
            b02.setDocRectF(rectF);
        }
    }
}
