package com.sumsub.sns.prooface.presentation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.v;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.core.widget.SNSLivenessFaceView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.PermissionPayload;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.AnswerType;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.u;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.prooface.presentation.b;
import d10.p;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0019\u0018\u0000 \b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002°\u0001B\t¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J \u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0003J,\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002J\u0010\u0010\b\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0003J\b\u0010-\u001a\u00020*H\u0014J+\u00104\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020.H\u0016J\u001a\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010=\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010#\u001a\u00020>H\u0014J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010:H\u0014J\b\u0010A\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\b\u0010E\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010#\u001a\u00020FH\u0016J\u001a\u0010K\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010J\u001a\u00020*H\u0016R\u001b\u0010P\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001a\u0010V\u001a\u00020Q8\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001d\u0010[\u001a\u0004\u0018\u0001088BX\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001d\u0010_\u001a\u0004\u0018\u00010\\8BX\u0002¢\u0006\f\n\u0004\b!\u0010X\u001a\u0004\b]\u0010^R\u001d\u0010c\u001a\u0004\u0018\u00010`8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010X\u001a\u0004\ba\u0010bR\u001d\u0010h\u001a\u0004\u0018\u00010d8BX\u0002¢\u0006\f\n\u0004\be\u0010X\u001a\u0004\bf\u0010gR\u001d\u0010k\u001a\u0004\u0018\u00010d8BX\u0002¢\u0006\f\n\u0004\bi\u0010X\u001a\u0004\bj\u0010gR\u001d\u0010o\u001a\u0004\u0018\u00010l8BX\u0002¢\u0006\f\n\u0004\bm\u0010X\u001a\u0004\be\u0010nR\u001d\u0010s\u001a\u0004\u0018\u00010p8BX\u0002¢\u0006\f\n\u0004\bY\u0010X\u001a\u0004\bq\u0010rR\u001d\u0010u\u001a\u0004\u0018\u00010d8BX\u0002¢\u0006\f\n\u0004\bq\u0010X\u001a\u0004\bt\u0010gR\u001d\u0010x\u001a\u0004\u0018\u00010d8BX\u0002¢\u0006\f\n\u0004\bv\u0010X\u001a\u0004\bw\u0010gR\u001d\u0010y\u001a\u0004\u0018\u00010`8BX\u0002¢\u0006\f\n\u0004\ba\u0010X\u001a\u0004\bv\u0010bR\u001d\u0010{\u001a\u0004\u0018\u00010d8TX\u0002¢\u0006\f\n\u0004\bw\u0010X\u001a\u0004\bz\u0010gR\u001d\u0010~\u001a\u0004\u0018\u00010|8BX\u0002¢\u0006\f\n\u0004\bt\u0010X\u001a\u0004\bi\u0010}R\u0016\u0010\u0001\u001a\u000208\u0002X\u0004¢\u0006\u0007\n\u0005\bj\u0010\u0001R\u0018\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bf\u0010\u0001R\u0018\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b]\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bN\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010\u0001R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b$\u0010\u0001R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b%\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b \u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010\u0001R\u0017\u0010\u0001\u001a\u00020\u000e8\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\r0\u0001\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u00158BX\u0004¢\u0006\u0007\u001a\u0005\bm\u0010\u0001R#\u0010¢\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002000\f8BX\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R\u0017\u0010¥\u0001\u001a\u00020\r8TX\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R#\u0010§\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002000\f8VX\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010¡\u0001R#\u0010©\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002000\f8VX\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010¡\u0001R#\u0010«\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002000\f8VX\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010¡\u0001R#\u0010­\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002000\f8VX\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010¡\u0001¨\u0006±\u0001"}, d2 = {"Lcom/sumsub/sns/prooface/presentation/SNSLiveness3dFaceFragment;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/prooface/presentation/b$i;", "Lcom/sumsub/sns/internal/prooface/presentation/b;", "Landroid/hardware/SensorEventListener;", "Lcom/sumsub/sns/internal/core/data/model/u$b;", "finishEvent", "", "a", "Lcom/sumsub/sns/internal/core/data/model/u$c;", "result", "A", "", "", "", "grantResults", "handlePermissionResults", "Lcom/sumsub/sns/internal/prooface/presentation/b$f;", "status", "F", "l", "Landroid/graphics/RectF;", "faceBox", "Lcom/sumsub/sns/internal/prooface/presentation/b$g$f;", "E", "G", "Lcom/sumsub/sns/prooface/data/j;", "session", "Lkotlin/Pair;", "Landroid/graphics/drawable/Drawable;", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "z", "D", "k", "Lcom/sumsub/sns/core/presentation/base/a$n;", "event", "B", "C", "Lcom/sumsub/sns/internal/prooface/presentation/b$j;", "dialog", "Landroid/content/Context;", "context", "", "screenBrightnessMode", "screenBrightnessValue", "getLayoutId", "Lcom/sumsub/sns/internal/core/common/q;", "reason", "", "payload", "", "delay", "finish", "(Lcom/sumsub/sns/internal/core/common/q;Ljava/lang/Object;Ljava/lang/Long;)V", "finishReason", "onFinishCalled", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onViewModelPrepared", "Lcom/sumsub/sns/core/presentation/base/a$j;", "handleEvent", "state", "onStart", "onDestroyView", "onStop", "onResume", "onPause", "Landroid/hardware/SensorEvent;", "onSensorChanged", "Landroid/hardware/Sensor;", "sensor", "accuracy", "onAccuracyChanged", "h", "Lkotlin/i;", "y", "()Lcom/sumsub/sns/internal/prooface/presentation/b;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "i", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "j", "Lcom/sumsub/sns/internal/core/common/z;", "p", "()Landroid/view/View;", "content", "Landroid/view/ViewGroup;", "x", "()Landroid/view/ViewGroup;", "vgResult", "Landroid/widget/ImageView;", "s", "()Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "m", "w", "()Landroid/widget/TextView;", "tvTitle", "n", "v", "tvSubTitle", "Landroid/widget/Button;", "o", "()Landroid/widget/Button;", "btnTryAgain", "Lcom/sumsub/sns/core/widget/SNSLivenessFaceView;", "q", "()Lcom/sumsub/sns/core/widget/SNSLivenessFaceView;", "faceView", "u", "tvHint", "r", "t", "tvDebug", "ivCompleteImage", "getPoweredByText", "poweredByText", "Landroidx/camera/view/PreviewView;", "()Landroidx/camera/view/PreviewView;", "cameraView", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "cameraX", "I", "brightnessMode", "brightnessValue", "Z", "needRestoreBrightness", "", "illumination", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog;", "lackOfPermissionDialog", "writeSettingDialog", "Landroid/hardware/SensorManager;", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/Sensor;", "lightSensor", "isLivenessStarted", "writeSettingDialogShown", "isDebug", "H", "allowSettingsDialog", "Landroidx/activity/result/ActivityResultLauncher;", "", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "J", "Lcom/sumsub/sns/internal/prooface/presentation/b$f;", "previousFaceDetectorStatus", "()Landroid/graphics/RectF;", "capturingBox", "getPermissionsPayload", "()Ljava/util/Map;", "permissionsPayload", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "getOpenPayload", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "<init>", "()V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSLiveness3dFaceFragment extends com.sumsub.sns.core.presentation.b<b.i, com.sumsub.sns.internal.prooface.presentation.b> implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f40279a = new Companion((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f40280b = {Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "content", "getContent()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "vgResult", "getVgResult()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "ivIcon", "getIvIcon()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "tvSubTitle", "getTvSubTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "btnTryAgain", "getBtnTryAgain()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "faceView", "getFaceView()Lcom/sumsub/sns/core/widget/SNSLivenessFaceView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "tvHint", "getTvHint()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "tvDebug", "getTvDebug()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "ivCompleteImage", "getIvCompleteImage()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "poweredByText", "getPoweredByText()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSLiveness3dFaceFragment.class, "cameraView", "getCameraView()Landroidx/camera/view/PreviewView;", 0))};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f40281c = {"android.permission.CAMERA"};

    /* renamed from: d  reason: collision with root package name */
    public static final long f40282d = 2000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f40283e = 10;

    /* renamed from: f  reason: collision with root package name */
    public static final int f40284f = 720;

    /* renamed from: g  reason: collision with root package name */
    public static final int f40285g = 1280;
    public AlertDialog A;
    public AlertDialog B;
    public SensorManager C;
    public Sensor D;
    public boolean E;
    public boolean F;
    public final boolean G;
    public final boolean H;
    public ActivityResultLauncher<String[]> I;
    public b.f J;

    /* renamed from: h  reason: collision with root package name */
    public final kotlin.i f40286h;

    /* renamed from: i  reason: collision with root package name */
    public final Screen f40287i = Screen.LivenessScreen;

    /* renamed from: j  reason: collision with root package name */
    public final z f40288j = a0.a(this, R.id.sns_content);

    /* renamed from: k  reason: collision with root package name */
    public final z f40289k = a0.a(this, R.id.sns_container);

    /* renamed from: l  reason: collision with root package name */
    public final z f40290l = a0.a(this, R.id.sns_icon);

    /* renamed from: m  reason: collision with root package name */
    public final z f40291m = a0.a(this, R.id.sns_title);

    /* renamed from: n  reason: collision with root package name */
    public final z f40292n = a0.a(this, R.id.sns_subtitle);

    /* renamed from: o  reason: collision with root package name */
    public final z f40293o = a0.a(this, R.id.sns_primary_button);

    /* renamed from: p  reason: collision with root package name */
    public final z f40294p = a0.a(this, R.id.sns_face_view);

    /* renamed from: q  reason: collision with root package name */
    public final z f40295q = a0.a(this, R.id.sns_hint);

    /* renamed from: r  reason: collision with root package name */
    public final z f40296r = a0.a(this, R.id.sns_debug);

    /* renamed from: s  reason: collision with root package name */
    public final z f40297s = a0.a(this, R.id.sns_complete_icon);

    /* renamed from: t  reason: collision with root package name */
    public final z f40298t = a0.a(this, R.id.sns_powered);

    /* renamed from: u  reason: collision with root package name */
    public final z f40299u = a0.a(this, R.id.sns_camera_preview);

    /* renamed from: v  reason: collision with root package name */
    public final CameraX f40300v = new CameraX(CameraX.Mode.ANALYZER, new Size(1280, 720), (CameraX.b) null, CameraSelector.DEFAULT_FRONT_CAMERA, new a(this), 4, (r) null);

    /* renamed from: w  reason: collision with root package name */
    public int f40301w;

    /* renamed from: x  reason: collision with root package name */
    public int f40302x = 255;

    /* renamed from: y  reason: collision with root package name */
    public boolean f40303y;

    /* renamed from: z  reason: collision with root package name */
    public float f40304z = Float.MAX_VALUE;

    @Keep
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/prooface/presentation/SNSLiveness3dFaceFragment$Companion;", "", "()V", "MINIMUM_LIGHT", "", "OPTIMAL_IMAGE_HEIGHT", "OPTIMAL_IMAGE_WIDTH", "REQUIRED_PERMISSIONS", "", "", "[Ljava/lang/String;", "RESULT_DELAY", "", "newInstance", "Landroidx/fragment/app/Fragment;", "documentType", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        @Keep
        public final Fragment newInstance(DocumentType documentType) {
            SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment = new SNSLiveness3dFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_ID_DOC_SET_TYPE", documentType.c());
            sNSLiveness3dFaceFragment.setArguments(bundle);
            return sNSLiveness3dFaceFragment;
        }

        private Companion() {
        }
    }

    public static final class a implements com.sumsub.sns.internal.core.domain.camera.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40305a;

        public a(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment) {
            this.f40305a = sNSLiveness3dFaceFragment;
        }

        public Object a(ImageProxy imageProxy, com.sumsub.sns.internal.core.domain.camera.c cVar, kotlin.coroutines.c<? super Unit> cVar2) {
            this.f40305a.getViewModel().a(imageProxy, this.f40305a.o(), cVar.d());
            return Unit.f56620a;
        }

        public /* synthetic */ void a(CameraX.c cVar) {
            com.sumsub.sns.internal.core.domain.camera.h.b(this, cVar);
        }

        public /* synthetic */ void a(File file) {
            com.sumsub.sns.internal.core.domain.camera.h.c(this, file);
        }

        public /* synthetic */ void b(File file) {
            com.sumsub.sns.internal.core.domain.camera.h.d(this, file);
        }

        public void c() {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "onPreviewReady()", (Throwable) null, 4, (Object) null);
            this.f40305a.E();
            SNSLivenessFaceView d11 = this.f40305a.q();
            if (d11 != null) {
                d11.setVisibility(0);
            }
            this.f40305a.C();
        }

        public void onError(Exception exc) {
            this.f40305a.getViewModel().a(exc);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment$onViewModelPrepared$1", f = "SNSLiveness3dFaceFragment.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<b.f, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f40306a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f40307b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40308c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f40308c = sNSLiveness3dFaceFragment;
        }

        /* renamed from: a */
        public final Object invoke(b.f fVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(fVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f40308c, cVar);
            bVar.f40307b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f40306a == 0) {
                kotlin.k.b(obj);
                b.f fVar = (b.f) this.f40307b;
                if (fVar != null) {
                    this.f40308c.a(fVar);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment$onViewModelPrepared$2", f = "SNSLiveness3dFaceFragment.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<b.g, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f40309a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f40310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40311c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f40311c = sNSLiveness3dFaceFragment;
        }

        /* renamed from: a */
        public final Object invoke(b.g gVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f40311c, cVar);
            cVar2.f40310b = obj;
            return cVar2;
        }

        public final Object invokeSuspend(Object obj) {
            ImageView e11;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f40309a == 0) {
                kotlin.k.b(obj);
                b.g gVar = (b.g) this.f40310b;
                View view = null;
                com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "livenessResult: " + gVar, (Throwable) null, 4, (Object) null);
                if (!(gVar instanceof b.g.e)) {
                    if (gVar instanceof b.g.f) {
                        this.f40311c.a((b.g.f) gVar);
                    } else if (gVar instanceof b.g.C0496g) {
                        View view2 = this.f40311c.getView();
                        if (view2 != null) {
                            view = view2.findViewById(R.id.sns_camera);
                        }
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        TextView g11 = this.f40311c.u();
                        if (g11 != null) {
                            g11.setText(((b.g.C0496g) gVar).d());
                        }
                        SNSLivenessFaceView d11 = this.f40311c.q();
                        if (d11 != null) {
                            d11.setRecognizingState();
                        }
                        ImageView e12 = this.f40311c.r();
                        if (e12 != null) {
                            e12.setVisibility(8);
                        }
                        if (((b.g.C0496g) gVar).c()) {
                            com.sumsub.sns.internal.core.domain.camera.c f11 = this.f40311c.f40300v.f();
                            this.f40311c.getViewModel().a(f11.d(), f11.f(), f11.e());
                        }
                    } else if (gVar instanceof b.g.d) {
                        TextView g12 = this.f40311c.u();
                        if (g12 != null) {
                            g12.setText(((b.g.d) gVar).b());
                        }
                    } else if (gVar instanceof b.g.C0495b) {
                        TransitionSet transitionSet = new TransitionSet();
                        boolean z11 = true;
                        Fade fade = new Fade(1);
                        transitionSet.g(fade);
                        Fade fade2 = new Fade(2);
                        fade2.setStartDelay(fade.getDuration());
                        transitionSet.g(fade2);
                        TransitionManager.b((ViewGroup) this.f40311c.requireView().findViewById(R.id.sns_overlay), transitionSet);
                        TextView g13 = this.f40311c.u();
                        if (g13 != null) {
                            g13.setText(((b.g.C0495b) gVar).d());
                        }
                        this.f40311c.G();
                        SNSLivenessFaceView d12 = this.f40311c.q();
                        if (d12 != null) {
                            d12.setFaceAnalyzingState();
                        }
                        ImageView e13 = this.f40311c.r();
                        if (e13 == null || e13.getVisibility() != 0) {
                            z11 = false;
                        }
                        if (!z11 && (e11 = this.f40311c.r()) != null) {
                            e11.setImageBitmap(((b.g.C0495b) gVar).c());
                            e11.setVisibility(0);
                            e11.setAlpha(0.0f);
                            e11.animate().alpha(1.0f).setDuration((long) e11.getResources().getInteger(17694720)).start();
                        }
                    } else if (gVar instanceof b.g.a) {
                        String a11 = com.sumsub.sns.internal.log.c.a(this.f40311c);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Calibrate, set exposure = ");
                        b.g.a aVar = (b.g.a) gVar;
                        sb2.append(aVar.b());
                        com.sumsub.sns.prooface.a.a(a11, sb2.toString(), (Throwable) null, 4, (Object) null);
                        this.f40311c.f40300v.a(aVar.b());
                    } else if (gVar instanceof b.g.c) {
                        String a12 = com.sumsub.sns.internal.log.c.a(this.f40311c);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Calibrate, set exposure = ");
                        b.g.c cVar = (b.g.c) gVar;
                        sb3.append(cVar.b());
                        com.sumsub.sns.prooface.a.a(a12, sb3.toString(), (Throwable) null, 4, (Object) null);
                        this.f40311c.f40300v.a(cVar.b());
                        this.f40311c.getViewModel().E();
                    }
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d implements SNSLivenessFaceView.SNSFaceStateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40312a;

        public d(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment) {
            this.f40312a = sNSLiveness3dFaceFragment;
        }

        public void onState(SNSLivenessFaceView.SNSFaceViewState sNSFaceViewState) {
            this.f40312a.getViewModel().d(sNSFaceViewState == SNSLivenessFaceView.SNSFaceViewState.Recognized);
            if (sNSFaceViewState == SNSLivenessFaceView.SNSFaceViewState.Complete) {
                this.f40312a.k();
            }
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40313a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment) {
            super(0);
            this.f40313a = sNSLiveness3dFaceFragment;
        }

        public final void a() {
            this.f40313a.A = null;
            this.f40313a.getViewModel().A();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment$showResult$1", f = "SNSLiveness3dFaceFragment.kt", l = {488}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f40314a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40315b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.prooface.data.j f40316c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, com.sumsub.sns.prooface.data.j jVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f40315b = sNSLiveness3dFaceFragment;
            this.f40316c = jVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f(this.f40315b, this.f40316c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f40314a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f40314a = 1;
                if (DelayKt.b(2000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ViewGroup h11 = this.f40315b.x();
            if (h11 != null) {
                h11.setVisibility(8);
            }
            com.sumsub.sns.internal.prooface.presentation.b y11 = this.f40315b.getViewModel();
            Boolean a11 = this.f40316c.a();
            y11.a(a11 != null ? a11.booleanValue() : false, this.f40316c.c());
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40317a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
            super(0);
            this.f40317a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40317a;
        }
    }

    public static final class h extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40318a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d10.a aVar) {
            super(0);
            this.f40318a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40318a.invoke();
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40319a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(kotlin.i iVar) {
            super(0);
            this.f40319a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40319a).getViewModelStore();
        }
    }

    public static final class j extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40321b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f40320a = aVar;
            this.f40321b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40320a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40321b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class k extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40323b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f40322a = fragment;
            this.f40323b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40323b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40322a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class l extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSLiveness3dFaceFragment f40324a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment) {
            super(0);
            this.f40324a = sNSLiveness3dFaceFragment;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment = this.f40324a;
            return new com.sumsub.sns.internal.prooface.presentation.c(sNSLiveness3dFaceFragment, sNSLiveness3dFaceFragment.getServiceLocator(), this.f40324a.getArguments());
        }
    }

    public SNSLiveness3dFaceFragment() {
        l lVar = new l(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new h(new g(this)));
        this.f40286h = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.prooface.presentation.b.class), new i(b11), new j((d10.a) null, b11), lVar);
        com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
        this.G = aVar.p().g();
        this.H = aVar.q().g();
    }

    public final void A() {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Init camera", (Throwable) null, 4, (Object) null);
        this.f40300v.a(getViewLifecycleOwner(), n());
    }

    public final void B() {
        if (Build.VERSION.SDK_INT >= 23 && this.f40303y && a(requireContext())) {
            a(requireContext(), this.f40301w, this.f40302x);
            this.f40303y = false;
        }
    }

    public final void C() {
        if (Build.VERSION.SDK_INT >= 23 && this.f40304z < 10.0f && !this.f40303y && a(requireContext())) {
            Pair<Integer, Integer> a11 = a(requireContext(), 0, 255);
            this.f40301w = a11.getFirst().intValue();
            this.f40302x = a11.getSecond().intValue();
            this.f40303y = true;
        }
    }

    public final void D() {
        SNSLivenessFaceView q11 = q();
        if (q11 != null) {
            q11.setScanCompleteState();
        }
    }

    public final void E() {
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(8);
        }
        if (getArguments() != null) {
            getViewModel().c("Built-in front camera");
        }
        this.E = true;
    }

    public final void F() {
        getViewModel().F();
        this.f40300v.g();
    }

    public final void G() {
        this.E = false;
    }

    public void finish(q qVar, Object obj, Long l11) {
        if (obj instanceof u.b) {
            a((u.b) obj);
        } else if (obj instanceof u.c) {
            a((u.c) obj);
        } else {
            super.finish(qVar, obj, l11);
        }
    }

    public Map<String, Object> getAppearPayload() {
        return getPermissionsPayload();
    }

    public Map<String, Object> getCancelPayload() {
        return getPermissionsPayload();
    }

    public Map<String, Object> getClosePayload() {
        return getPermissionsPayload();
    }

    public String getIdDocSetType() {
        return getViewModel().u().c();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_liveness_3dface;
    }

    public Map<String, Object> getOpenPayload() {
        return getPermissionsPayload();
    }

    public final Map<String, Object> getPermissionsPayload() {
        Context context = getContext();
        if (context == null) {
            return MapsKt__MapsKt.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PermissionPayload.CAMERA_PERMISSION.toString(), Boolean.valueOf(com.sumsub.sns.internal.core.common.j.a(context, "android.permission.CAMERA")));
        return linkedHashMap;
    }

    public TextView getPoweredByText() {
        return (TextView) this.f40298t.a(this, f40280b[10]);
    }

    public Screen getScreen() {
        return this.f40287i;
    }

    public void handleEvent(a.j jVar) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "handleEvent: " + jVar, (Throwable) null, 4, (Object) null);
        if (jVar instanceof a.n) {
            a((a.n) jVar);
        } else if (jVar instanceof b.e) {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "HandleErrorEvent: " + ((b.e) jVar).b(), (Throwable) null, 4, (Object) null);
            updateShowProgress(true);
            A();
        } else if (jVar instanceof a.d) {
            F();
            a.d dVar = (a.d) jVar;
            getBaseActivity().a(dVar.e(), dVar.f(), dVar.d());
        } else {
            super.handleEvent(jVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handlePermissionResults(java.util.Map<java.lang.String, java.lang.Boolean> r8) {
        /*
            r7 = this;
            boolean r0 = r8.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0009
            goto L_0x002b
        L_0x0009:
            java.util.Set r0 = r8.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x002b
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x0011
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "handlePermissionResults: granted="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4 = 4
            java.lang.String r5 = "Prooface"
            r6 = 0
            com.sumsub.sns.prooface.a.a(r5, r3, r6, r4, r6)
            boolean r3 = r8.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0094
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L_0x0052
            goto L_0x0075
        L_0x0052:
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x005a:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0075
            java.lang.Object r3 = r8.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x005a
            r8 = r2
            goto L_0x0076
        L_0x0075:
            r8 = r1
        L_0x0076:
            if (r8 == 0) goto L_0x0094
            java.lang.String[] r8 = f40281c
            int r3 = r8.length
            r4 = r1
        L_0x007c:
            if (r4 >= r3) goto L_0x008b
            r5 = r8[r4]
            boolean r5 = r7.shouldShowRequestPermissionRationale(r5)
            if (r5 == 0) goto L_0x0088
            r1 = r2
            goto L_0x008b
        L_0x0088:
            int r4 = r4 + 1
            goto L_0x007c
        L_0x008b:
            r8 = r1 ^ 1
            com.sumsub.sns.internal.prooface.presentation.b r1 = r7.getViewModel()
            r1.c((boolean) r8)
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r7.A()
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment.handlePermissionResults(java.util.Map):void");
    }

    public final void l() {
        String[] strArr = f40281c;
        int length = strArr.length;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = true;
                break;
            }
            if (!com.sumsub.sns.internal.core.common.j.a(requireContext(), strArr[i11])) {
                break;
            }
            i11++;
        }
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "checkPermissions: granted=" + z11, (Throwable) null, 4, (Object) null);
        if (!z11) {
            ActivityResultLauncher<String[]> activityResultLauncher = this.I;
            if (activityResultLauncher != null) {
                activityResultLauncher.a(f40281c);
                return;
            }
            return;
        }
        A();
    }

    public final Button m() {
        return (Button) this.f40293o.a(this, f40280b[5]);
    }

    public final PreviewView n() {
        return (PreviewView) this.f40299u.a(this, f40280b[11]);
    }

    public final RectF o() {
        Rect faceCapturingRect = q().getFaceCapturingRect();
        int[] iArr = new int[2];
        n().getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        q().getLocationInWindow(iArr2);
        return new RectF(((float) ((iArr2[0] - iArr[0]) + faceCapturingRect.left)) / ((float) n().getWidth()), ((float) ((iArr2[1] - iArr[1]) + faceCapturingRect.top)) / ((float) n().getHeight()), ((float) ((iArr2[0] - iArr[0]) + faceCapturingRect.right)) / ((float) n().getWidth()), ((float) ((iArr2[1] - iArr[1]) + faceCapturingRect.bottom)) / ((float) n().getHeight()));
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f40300v.g();
    }

    public boolean onFinishCalled(q qVar) {
        if (!(qVar instanceof q.c)) {
            return super.onFinishCalled(qVar);
        }
        View p11 = p();
        if (p11 != null) {
            p11.setVisibility(4);
        }
        getViewModel().z();
        return false;
    }

    public void onPause() {
        super.onPause();
        SensorManager sensorManager = this.C;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        B();
    }

    public void onResume() {
        super.onResume();
        SensorManager sensorManager = this.C;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.D, 3);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f40304z = sensorEvent.values[0];
        C();
    }

    public void onStart() {
        super.onStart();
        if (isPrepared()) {
            l();
        }
    }

    public void onStop() {
        AlertDialog alertDialog = this.A;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.A = null;
        AlertDialog alertDialog2 = this.B;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.B = null;
        getViewModel().F();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.I = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new e(this));
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        SNSLivenessFaceView q11 = q();
        if (q11 != null) {
            q11.setVisibility(4);
        }
        SensorManager sensorManager = (SensorManager) requireContext().getSystemService("sensor");
        this.C = sensorManager;
        this.D = sensorManager != null ? sensorManager.getDefaultSensor(5) : null;
        b0.b(getViewModel().x(), (LifecycleOwner) this, new b(this, (kotlin.coroutines.c<? super b>) null));
        b0.b(getViewModel().v(), (LifecycleOwner) this, new c(this, (kotlin.coroutines.c<? super c>) null));
        SNSLivenessFaceView q12 = q();
        if (q12 != null) {
            q12.setStateListener(new d(this));
        }
        TextView t11 = t();
        if (t11 != null) {
            t11.setVisibility(this.G ? 0 : 8);
        }
        l();
    }

    public final View p() {
        return this.f40288j.a(this, f40280b[0]);
    }

    public final SNSLivenessFaceView q() {
        return (SNSLivenessFaceView) this.f40294p.a(this, f40280b[6]);
    }

    public final ImageView r() {
        return (ImageView) this.f40297s.a(this, f40280b[9]);
    }

    public final ImageView s() {
        return (ImageView) this.f40290l.a(this, f40280b[2]);
    }

    public final TextView t() {
        return (TextView) this.f40296r.a(this, f40280b[8]);
    }

    public final TextView u() {
        return (TextView) this.f40295q.a(this, f40280b[7]);
    }

    public final TextView v() {
        return (TextView) this.f40292n.a(this, f40280b[4]);
    }

    public final TextView w() {
        return (TextView) this.f40291m.a(this, f40280b[3]);
    }

    public final ViewGroup x() {
        return (ViewGroup) this.f40289k.a(this, f40280b[1]);
    }

    /* renamed from: y */
    public com.sumsub.sns.internal.prooface.presentation.b getViewModel() {
        return (com.sumsub.sns.internal.prooface.presentation.b) this.f40286h.getValue();
    }

    public final void z() {
        TextView u11 = u();
        if (u11 != null) {
            u11.setAlpha(0.0f);
            u11.animate().alpha(1.0f).start();
        }
        SNSLivenessFaceView q11 = q();
        if (q11 != null) {
            q11.setRecognizingState();
        }
        ViewGroup x11 = x();
        if (x11 != null) {
            x11.setVisibility(8);
        }
    }

    @SensorsDataInstrumented
    public static final void b(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        sNSLiveness3dFaceFragment.B = null;
        sNSLiveness3dFaceFragment.getViewModel().B();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    @SensorsDataInstrumented
    public static final void c(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, DialogInterface dialogInterface, int i11) {
        sNSLiveness3dFaceFragment.B = null;
        dialogInterface.dismiss();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    public final void k() {
        ViewGroup x11 = x();
        if (!(x11 != null && x11.getVisibility() == 0)) {
            ViewGroup x12 = x();
            if (x12 != null) {
                x12.setVisibility(0);
            }
            ImageView s11 = s();
            if (s11 != null) {
                s11.setScaleX(0.0f);
            }
            androidx.dynamicanimation.animation.c cVar = new androidx.dynamicanimation.animation.c(s(), androidx.dynamicanimation.animation.b.f9343p, 1.0f);
            cVar.r().f(200.0f);
            cVar.r().d(0.75f);
            cVar.m();
            ImageView s12 = s();
            if (s12 != null) {
                s12.setScaleY(0.0f);
            }
            androidx.dynamicanimation.animation.c cVar2 = new androidx.dynamicanimation.animation.c(s(), androidx.dynamicanimation.animation.b.f9344q, 1.0f);
            cVar2.r().f(200.0f);
            cVar2.r().d(0.75f);
            cVar2.m();
            Button m11 = m();
            if (m11 != null && m11.getVisibility() == 0) {
                m11.setAlpha(0.0f);
                m11.animate().alpha(1.0f).start();
            }
            TextView u11 = u();
            if (u11 != null) {
                u11.setAlpha(1.0f);
                u11.animate().alpha(0.0f).start();
            }
            B();
        }
    }

    public final void a(u.b bVar) {
        SNSLivenessReason c11 = bVar.c();
        if (c11 instanceof SNSLivenessReason.NetworkError) {
            F();
            Exception exception = ((SNSLivenessReason.NetworkError) c11).getException();
            if (exception != null) {
                getViewModel().b(exception);
                return;
            }
            return;
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.d(new SNSCompletionResult.SuccessTermination(c11)), (Object) null, (Long) null, 6, (Object) null);
    }

    public final void a(u.c cVar) {
        SNSLivenessReason d11 = cVar.d();
        if (d11 instanceof SNSLivenessReason.VeritifcationSuccessfully) {
            k0 appListener = getAppListener();
            if (appListener != null) {
                appListener.a(cVar.c());
            }
        } else if (d11 instanceof SNSLivenessReason.CompletedUnsuccessfullyAllowContinue) {
            com.sumsub.sns.core.presentation.b.finish$default(this, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        } else if (d11 instanceof SNSLivenessReason.UserCancelled) {
            com.sumsub.sns.core.presentation.b.finish$default(this, q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
        } else if (d11 instanceof SNSLivenessReason.NetworkError) {
            F();
            com.sumsub.sns.internal.prooface.presentation.b y11 = getViewModel();
            Throwable exception = ((SNSLivenessReason.NetworkError) cVar.d()).getException();
            if (exception == null) {
                exception = new IOException();
            }
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) y11, exception, getIdDocSetType(), (Object) null, 4, (Object) null);
        } else if (d11 instanceof SNSLivenessReason.InitializationError) {
            F();
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) getViewModel(), (Throwable) ((SNSLivenessReason.InitializationError) cVar.d()).getException(), getIdDocSetType(), (Object) null, 4, (Object) null);
        } else {
            com.sumsub.sns.core.presentation.b.finish$default(this, q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
        }
    }

    public static final void a(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, Map map) {
        sNSLiveness3dFaceFragment.handlePermissionResults(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if ((r0.getVisibility() == 0) == true) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.prooface.presentation.b.f r6) {
        /*
            r5 = this;
            com.sumsub.sns.internal.prooface.presentation.b$f r0 = r5.J
            r1 = 1
            if (r0 == 0) goto L_0x001b
            java.lang.Class r2 = r6.getClass()
            kotlin.reflect.c r2 = kotlin.jvm.internal.Reflection.b(r2)
            java.lang.Class r0 = r0.getClass()
            kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
            boolean r0 = kotlin.jvm.internal.x.b(r2, r0)
            r0 = r0 ^ r1
            goto L_0x001c
        L_0x001b:
            r0 = r1
        L_0x001c:
            r2 = 0
            if (r0 == 0) goto L_0x0021
            r0 = r6
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x003b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "face detector status: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 4
            java.lang.String r4 = "Prooface"
            com.sumsub.sns.prooface.a.a(r4, r0, r2, r3, r2)
        L_0x003b:
            r5.J = r6
            android.view.ViewGroup r0 = r5.x()
            r3 = 0
            if (r0 == 0) goto L_0x0050
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x004c
            r0 = r1
            goto L_0x004d
        L_0x004c:
            r0 = r3
        L_0x004d:
            if (r0 != r1) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = r3
        L_0x0051:
            if (r1 == 0) goto L_0x005e
            com.sumsub.sns.core.widget.SNSLivenessFaceView r6 = r5.q()
            if (r6 == 0) goto L_0x00f5
            r6.setScanCompleteState()
            goto L_0x00f5
        L_0x005e:
            boolean r0 = r5.E
            if (r0 == 0) goto L_0x00f5
            android.widget.TextView r0 = r5.u()
            if (r0 != 0) goto L_0x0069
            goto L_0x0070
        L_0x0069:
            java.lang.CharSequence r1 = r6.a()
            r0.setText(r1)
        L_0x0070:
            boolean r0 = r6 instanceof com.sumsub.sns.internal.prooface.presentation.b.f.C0494b
            if (r0 == 0) goto L_0x008e
            com.sumsub.sns.core.widget.SNSLivenessFaceView r6 = r5.q()
            if (r6 == 0) goto L_0x007d
            r6.setRecognizingState()
        L_0x007d:
            boolean r6 = r5.G
            if (r6 == 0) goto L_0x00f5
            com.sumsub.sns.core.widget.SNSLivenessFaceView r6 = r5.q()
            if (r6 != 0) goto L_0x0089
            goto L_0x00f5
        L_0x0089:
            r6.setFaceRectangle(r2)
            goto L_0x00f5
        L_0x008e:
            boolean r0 = r6 instanceof com.sumsub.sns.internal.prooface.presentation.b.f.c
            if (r0 == 0) goto L_0x00b4
            com.sumsub.sns.core.widget.SNSLivenessFaceView r0 = r5.q()
            if (r0 == 0) goto L_0x009b
            r0.setRecognizingState()
        L_0x009b:
            boolean r0 = r5.G
            if (r0 == 0) goto L_0x00f5
            com.sumsub.sns.core.widget.SNSLivenessFaceView r0 = r5.q()
            if (r0 != 0) goto L_0x00a6
            goto L_0x00f5
        L_0x00a6:
            com.sumsub.sns.internal.prooface.presentation.b$f$c r6 = (com.sumsub.sns.internal.prooface.presentation.b.f.c) r6
            android.graphics.RectF r6 = r6.d()
            android.graphics.RectF r6 = r5.a((android.graphics.RectF) r6)
            r0.setFaceRectangle(r6)
            goto L_0x00f5
        L_0x00b4:
            boolean r0 = r6 instanceof com.sumsub.sns.internal.prooface.presentation.b.f.d
            if (r0 == 0) goto L_0x00d0
            com.sumsub.sns.core.widget.SNSLivenessFaceView r6 = r5.q()
            if (r6 == 0) goto L_0x00c1
            r6.setRecognizingState()
        L_0x00c1:
            boolean r6 = r5.G
            if (r6 == 0) goto L_0x00f5
            com.sumsub.sns.core.widget.SNSLivenessFaceView r6 = r5.q()
            if (r6 != 0) goto L_0x00cc
            goto L_0x00f5
        L_0x00cc:
            r6.setFaceRectangle(r2)
            goto L_0x00f5
        L_0x00d0:
            boolean r0 = r6 instanceof com.sumsub.sns.internal.prooface.presentation.b.f.a
            if (r0 == 0) goto L_0x00f5
            com.sumsub.sns.core.widget.SNSLivenessFaceView r0 = r5.q()
            if (r0 == 0) goto L_0x00dd
            r0.setFaceDetectedState()
        L_0x00dd:
            boolean r0 = r5.G
            if (r0 == 0) goto L_0x00f5
            com.sumsub.sns.core.widget.SNSLivenessFaceView r0 = r5.q()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00f5
        L_0x00e8:
            com.sumsub.sns.internal.prooface.presentation.b$f$a r6 = (com.sumsub.sns.internal.prooface.presentation.b.f.a) r6
            android.graphics.RectF r6 = r6.d()
            android.graphics.RectF r6 = r5.a((android.graphics.RectF) r6)
            r0.setFaceRectangle(r6)
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment.a(com.sumsub.sns.internal.prooface.presentation.b$f):void");
    }

    /* renamed from: a */
    public void handleState(b.i iVar, Bundle bundle) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "handleState: " + iVar, (Throwable) null, 4, (Object) null);
        if (Build.VERSION.SDK_INT >= 23 && !a(requireContext()) && this.H && !getViewModel().r()) {
            a(iVar.b());
        }
    }

    public final RectF a(RectF rectF) {
        int[] iArr = new int[2];
        PreviewView n11 = n();
        if (n11 != null) {
            n11.getLocationInWindow(iArr);
        }
        int[] iArr2 = new int[2];
        SNSLivenessFaceView q11 = q();
        if (q11 != null) {
            q11.getLocationInWindow(iArr2);
        }
        return new RectF(((rectF.left * ((float) n().getWidth())) - ((float) iArr2[0])) + ((float) iArr[0]), ((rectF.top * ((float) n().getHeight())) - ((float) iArr2[1])) + ((float) iArr[1]), ((rectF.right * ((float) n().getWidth())) - ((float) iArr2[0])) + ((float) iArr[0]), ((rectF.bottom * ((float) n().getHeight())) - ((float) iArr2[1])) + ((float) iArr[1]));
    }

    public final void a(b.g.f fVar) {
        com.sumsub.sns.prooface.data.j f11 = fVar.f();
        Pair<Drawable, SNSStepState> a11 = a(f11);
        Drawable component1 = a11.component1();
        SNSStepState component2 = a11.component2();
        ImageView s11 = s();
        if (s11 != null) {
            SNSStepViewExtensionsKt.setSnsStepState(s11, component2);
        }
        ImageView s12 = s();
        if (s12 != null) {
            s12.setImageDrawable(component1);
        }
        TextView w11 = w();
        if (w11 != null) {
            w11.setText(fVar.h());
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setText(fVar.g());
        }
        if (!x.b(f11 != null ? f11.c() : null, AnswerType.Green.getValue())) {
            if (!(f11 != null ? x.b(f11.a(), Boolean.TRUE) : false)) {
                Button m11 = m();
                if (m11 != null) {
                    m11.setVisibility(0);
                }
                Button m12 = m();
                if (m12 != null) {
                    m12.setText(fVar.e());
                }
                Button m13 = m();
                if (m13 != null) {
                    m13.setOnClickListener(new d(this));
                }
                D();
            }
        }
        Button m14 = m();
        if (m14 != null) {
            m14.setVisibility(8);
        }
        n1 unused = kotlinx.coroutines.i.d(v.a(getViewLifecycleOwner()), (CoroutineContext) null, (CoroutineStart) null, new f(this, f11, (kotlin.coroutines.c<? super f>) null), 3, (Object) null);
        D();
    }

    @SensorsDataInstrumented
    public static final void a(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(sNSLiveness3dFaceFragment.getAnalyticsDelegate(), Screen.LivenessScreen, sNSLiveness3dFaceFragment.getIdDocSetType(), Control.RetryButton, (Map) null, 8, (Object) null);
        sNSLiveness3dFaceFragment.z();
        sNSLiveness3dFaceFragment.E();
        sNSLiveness3dFaceFragment.C();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final Pair<Drawable, SNSStepState> a(com.sumsub.sns.prooface.data.j jVar) {
        String c11 = jVar != null ? jVar.c() : null;
        AnswerType answerType = AnswerType.Green;
        if (x.b(c11, answerType.getValue())) {
            return new Pair<>(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSResultIcons.SUCCESS.getImageName()), SNSStepState.APPROVED);
        }
        if (!(jVar != null ? x.b(jVar.a(), Boolean.TRUE) : false) || x.b(jVar.c(), answerType.getValue())) {
            return new Pair<>(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSResultIcons.FAILURE.getImageName()), SNSStepState.REJECTED);
        }
        return new Pair<>(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSResultIcons.SUBMITTED.getImageName()), SNSStepState.PENDING);
    }

    public final void a(a.n nVar) {
        AlertDialog a11 = com.sumsub.sns.internal.core.android.c.a(com.sumsub.sns.internal.core.android.c.f31946a, requireActivity(), nVar.f(), nVar.h(), nVar.g(), new e(this), (d10.a) null, 32, (Object) null);
        a11.show();
        this.A = a11;
    }

    public final void a(b.j jVar) {
        if (jVar != null && !this.F) {
            this.F = true;
            AlertDialog create = new SNSAlertDialogBuilder(requireContext()).setMessage(jVar.h()).setPositiveButton(jVar.g(), (DialogInterface.OnClickListener) new a(this)).setNegativeButton(jVar.e(), (DialogInterface.OnClickListener) new b(this)).setNeutralButton(jVar.f(), (DialogInterface.OnClickListener) new c(this)).create();
            this.B = create;
            if (create != null) {
                create.show();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void a(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        sNSLiveness3dFaceFragment.B = null;
        sNSLiveness3dFaceFragment.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS").addFlags(268435456));
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    public final Pair<Integer, Integer> a(Context context, int i11, int i12) {
        int i13 = Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode", -1);
        int i14 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        if (!(i13 == -1 || i14 == -1)) {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness_mode", i11);
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", i12);
            WindowManager.LayoutParams attributes = requireActivity().getWindow().getAttributes();
            attributes.screenBrightness = ((float) i12) / 255.0f;
            requireActivity().getWindow().setAttributes(attributes);
        }
        return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public final boolean a(Context context) {
        return Settings.System.canWrite(context);
    }
}
