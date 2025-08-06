package com.sumsub.sns.videoident.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.b;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.core.widget.SNSVideoIdentDocumentView;
import com.sumsub.sns.core.widget.SNSWarningView;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.PermissionPayload;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.android.a;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.j;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType;
import com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState;
import com.sumsub.sns.internal.videoident.presentation.ButtonAction;
import com.sumsub.sns.internal.videoident.presentation.PhoneVerificationStatus;
import com.sumsub.sns.internal.videoident.presentation.SNSStepViewItem;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;
import com.sumsub.sns.internal.videoident.presentation.e;
import com.sumsub.sns.internal.videoident.presentation.f;
import com.sumsub.sns.internal.videoident.presentation.g;
import com.sumsub.sns.internal.videoident.presentation.h;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.sumsub.sns.videoident.service.SNSVideoChatService;
import com.twilio.video.VideoTextureView;
import com.twilio.video.VideoView;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import kotlinx.serialization.modules.d;
import tvi.webrtc.VideoSink;

@Metadata(bv = {}, d1 = {"\u0000Ç\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013*\u0003t\u0001\u0018\u0000 ë\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004ë\u0001ì\u0001B\b¢\u0006\u0005\bê\u0001\u0010sJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0016\u0010 \u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020/H\u0002J\u0018\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u0010\u0016\u001a\u00020/H\u0002J(\u0010:\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020/2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\u001e\u0010F\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\b\u0010G\u001a\u00020\u0004H\u0002J\u0012\u0010I\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020;2\b\u0010H\u001a\u0004\u0018\u00010&H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\b\u0010M\u001a\u00020\u0004H\u0016J\b\u0010N\u001a\u00020\u0004H\u0016J\u0010\u0010P\u001a\u00020\u00042\u0006\u0010O\u001a\u00020&H\u0016J\b\u0010Q\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020\u0006H\u0014J\u0010\u0010U\u001a\u00020\u00122\u0006\u0010T\u001a\u00020SH\u0016J\u0010\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020VH\u0014J\u001a\u0010Y\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010&H\u0014R\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b`\u0010aR$\u0010d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0c\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u00060fR\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010l8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010l8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010nR\u001e\u0010p\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\bp\u0010q\u0012\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001b\u0010}\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001d\u0010\u001a\u00020~8\u0016X\u0004¢\u0006\u000f\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00020\f8\u0014XD¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010\\R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\r \u0001*\u0005\u0018\u00010\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010¢\u0001\u001a\u0004\u0018\u00010A8BX\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R\u001a\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00018BX\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010©\u0001\u001a\u0004\u0018\u00010;8BX\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010«\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010\u0001R\u001a\u0010­\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u0001R\u001a\u0010¯\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010\u0001R\u0019\u0010±\u0001\u001a\u0004\u0018\u00010A8BX\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010¡\u0001R\u0019\u0010³\u0001\u001a\u0004\u0018\u00010;8BX\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010¨\u0001R\u001a\u0010µ\u0001\u001a\u0005\u0018\u00010£\u00018BX\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010¥\u0001R\u001a\u0010·\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010\u0001R\u001a\u0010¹\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010\u0001R\u0019\u0010¼\u0001\u001a\u0004\u0018\u0001038BX\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u0019\u0010¾\u0001\u001a\u0004\u0018\u0001038BX\u0004¢\u0006\b\u001a\u0006\b½\u0001\u0010»\u0001R\u0019\u0010À\u0001\u001a\u0004\u0018\u0001038BX\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010»\u0001R\u0019\u0010Â\u0001\u001a\u0004\u0018\u00010A8BX\u0004¢\u0006\b\u001a\u0006\bÁ\u0001\u0010¡\u0001R\u001a\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018BX\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u0005\u0018\u00010Ç\u00018BX\u0004¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0019\u0010Ì\u0001\u001a\u0004\u0018\u00010;8BX\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010¨\u0001R\u0019\u0010Î\u0001\u001a\u0004\u0018\u00010;8BX\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010¨\u0001R\u0019\u0010Ñ\u0001\u001a\u0004\u0018\u0001068BX\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ó\u0001\u001a\u0005\u0018\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010\u0001R\u0018\u0010B\u001a\u0004\u0018\u00010A8BX\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010¡\u0001R\u001d\u0010E\u001a\t\u0012\u0005\u0012\u00030Õ\u00010C8BX\u0004¢\u0006\b\u001a\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Ù\u0001\u001a\u0004\u0018\u00010A8BX\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010¡\u0001R$\u0010Ý\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118BX\u0004¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Ü\u0001R$\u0010ß\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118BX\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010Ü\u0001R$\u0010á\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118BX\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010Ü\u0001R$\u0010ã\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118VX\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010Ü\u0001R$\u0010å\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118VX\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010Ü\u0001R$\u0010ç\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118VX\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010Ü\u0001R$\u0010é\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030Ú\u00010\u00118VX\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010Ü\u0001¨\u0006í\u0001"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState;", "Lcom/sumsub/sns/internal/videoident/presentation/h;", "", "showPhoneVerificationFragment", "", "code", "onPhoneVerificationResult", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "calculateExpandedOffset", "", "docSetType", "Landroid/net/Uri;", "uri", "handleFileSelectedForDocSetType", "", "", "grantResults", "handlePermissionResults", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$d;", "state", "showRecordAudioPermissionDialog", "showCameraPermissionDialog", "switchCameraAndUpdateMirroring", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatController;", "videoChatController", "attachChatControllerListeners", "detachChatControllerListeners", "Lkotlin/Function0;", "finishCallback", "showPhotoMadeAnimation", "accessToken", "roomName", "doStartServiceAndConnectToRoom", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$b;", "handleSelectLanguage", "Landroid/os/Bundle;", "result", "handleLanguageSelectionResult", "hideLanguageSelection", "hidePhoneVerification", "permission", "requestPermission", "newState", "releaseCurrentStatePreviewIfChanged", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$e;", "updateLanguageSection", "showExitConfirmationState", "startBottomAnimation", "Landroid/widget/Button;", "button", "updateBottomPrimaryButton", "Lcom/twilio/video/VideoTextureView;", "remoteVideo", "showRemoteVideo", "wasHidden", "updateRemoteVideoView", "Landroid/view/View;", "videoView", "", "scale", "applyVideoViewSize", "updateRecordTimerText", "Landroid/view/ViewGroup;", "documentList", "", "Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem;", "documents", "populateDocumentList", "requestAllPermissions", "savedInstanceState", "onCreate", "view", "onViewCreated", "onStart", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "onCloseButtonClick", "getLayoutId", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "handleState", "Landroidx/appcompat/app/AlertDialog;", "lackOfPermissionDialog", "Landroidx/appcompat/app/AlertDialog;", "checkPermissionsOnStart", "Z", "Lcom/sumsub/sns/internal/core/android/a;", "pickerLifecycleObserver", "Lcom/sumsub/sns/internal/core/android/a;", "Landroidx/activity/result/ActivityResultLauncher;", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$SNSVideoChatAdapterImpl;", "videoChatAdapter", "Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$SNSVideoChatAdapterImpl;", "Lkotlinx/coroutines/h0;", "fragmentScope", "Lkotlinx/coroutines/h0;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "phoneVerificationBottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "remoteVideoScale", "Ljava/lang/Float;", "getRemoteVideoScale$annotations", "()V", "com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$uriContentLoader$1", "uriContentLoader", "Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$uriContentLoader$1;", "currentViewState", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState;", "viewModel$delegate", "Lkotlin/i;", "getViewModel", "()Lcom/sumsub/sns/internal/videoident/presentation/h;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "idDocSetType", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "previousVolumeControlStream", "I", "currentCameraId", "Lkotlinx/coroutines/n1;", "chatMessagesCollectJob", "Lkotlinx/coroutines/n1;", "chatStateCollectJob", "Lcom/sumsub/sns/internal/videoident/presentation/AnalyticsCallState;", "callState", "Lcom/sumsub/sns/internal/videoident/presentation/AnalyticsCallState;", "exitConfirmationDialog", "com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$serviceConnection$1", "serviceConnection", "Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$serviceConnection$1;", "Ljava/text/SimpleDateFormat;", "shortTimeFormat", "Ljava/text/SimpleDateFormat;", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "calendar", "Ljava/util/Calendar;", "Landroid/widget/TextView;", "getRecordTime", "()Landroid/widget/TextView;", "recordTime", "getBottomSheet", "()Landroid/view/ViewGroup;", "bottomSheet", "Lcom/sumsub/sns/core/widget/SNSWarningView;", "getMessage", "()Lcom/sumsub/sns/core/widget/SNSWarningView;", "message", "getSwitchCamera", "()Landroid/view/View;", "switchCamera", "getLanguageSectionTitle", "languageSectionTitle", "getLanguage", "language", "getChangeLanguage", "changeLanguage", "getLanguageSection", "languageSection", "getBottomProgressBar", "bottomProgressBar", "getBottomWarning", "bottomWarning", "getBottomText", "bottomText", "getBottomTitle", "bottomTitle", "getBottomPrimaryButton", "()Landroid/widget/Button;", "bottomPrimaryButton", "getBottomSecondaryButton", "bottomSecondaryButton", "getBottomTertiaryButton", "bottomTertiaryButton", "getPhotoPreviewContainer", "photoPreviewContainer", "Landroid/widget/ImageView;", "getPhotoPreview", "()Landroid/widget/ImageView;", "photoPreview", "Lcom/twilio/video/VideoView;", "getLocalVideoView", "()Lcom/twilio/video/VideoView;", "localVideoView", "getPhotoMadeIndicator", "photoMadeIndicator", "getRemoteVideoContainer", "remoteVideoContainer", "getRemoteVideoView", "()Lcom/twilio/video/VideoTextureView;", "remoteVideoView", "getOperatorName", "operatorName", "getDocumentList", "Lcom/sumsub/sns/internal/core/data/model/Document;", "getDocuments", "()Ljava/util/List;", "getPhoneVerificationBottomSheet", "phoneVerificationBottomSheet", "", "getCompletePayload", "()Ljava/util/Map;", "completePayload", "getCommonPayload", "commonPayload", "getPermissionsPayload", "permissionsPayload", "getOpenPayload", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "<init>", "Companion", "SNSVideoChatAdapterImpl", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSVideoIdentFragment extends b<SNSViewState, h> {
    private static final String ARG_DOCS = "docs";
    private static final String CALL_STATE = "call_state";
    private static final String CAMERA_ID = "camera_id";
    public static final Companion Companion = new Companion((r) null);
    private static final String LANGUAGE_REQUEST_KEY = "language_request_key";
    private static final String OBSERVER_ITEM_ID = "observer_item_id";
    public static final String TAG = "SNSVideoIdentFragment";
    private static final String VERIFICATION_REQUEST_KEY = "verification_request_key";
    private BottomSheetBehavior<ViewGroup> bottomSheetBehavior;
    private final Calendar calendar;
    private AnalyticsCallState callState;
    private n1 chatMessagesCollectJob;
    private n1 chatStateCollectJob;
    private boolean checkPermissionsOnStart;
    /* access modifiers changed from: private */
    public String currentCameraId;
    private SNSViewState currentViewState;
    private AlertDialog exitConfirmationDialog;
    private final h0 fragmentScope = i0.a(v0.c());
    private final String idDocSetType;
    private AlertDialog lackOfPermissionDialog;
    private ActivityResultLauncher<String[]> permissionLauncher;
    private BottomSheetBehavior<ViewGroup> phoneVerificationBottomSheetBehavior;
    /* access modifiers changed from: private */
    public a pickerLifecycleObserver;
    private int previousVolumeControlStream;
    private Float remoteVideoScale = Float.valueOf(1.66f);
    private final Screen screen;
    /* access modifiers changed from: private */
    public final SNSVideoIdentFragment$serviceConnection$1 serviceConnection;
    private final SimpleDateFormat shortTimeFormat;
    /* access modifiers changed from: private */
    public d10.a<Unit> startServiceAndConnectToRoom;
    /* access modifiers changed from: private */
    public final SNSVideoIdentFragment$uriContentLoader$1 uriContentLoader = new SNSVideoIdentFragment$uriContentLoader$1(this);
    /* access modifiers changed from: private */
    public final SNSVideoChatAdapterImpl videoChatAdapter = new SNSVideoChatAdapterImpl();
    private final i viewModel$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$Companion;", "", "()V", "ARG_DOCS", "", "CALL_STATE", "CAMERA_ID", "LANGUAGE_REQUEST_KEY", "OBSERVER_ITEM_ID", "TAG", "VERIFICATION_REQUEST_KEY", "create", "Landroidx/fragment/app/Fragment;", "documents", "", "Lcom/sumsub/sns/internal/core/data/model/Document;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Fragment create(List<Document> list) {
            SNSVideoIdentFragment sNSVideoIdentFragment = new SNSVideoIdentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(SNSVideoIdentFragment.ARG_DOCS, new ArrayList(list));
            sNSVideoIdentFragment.setArguments(bundle);
            return sNSVideoIdentFragment;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$SNSVideoChatAdapterImpl;", "Lcom/sumsub/sns/internal/videoident/presentation/g;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "", "asJson", "accessToken", "roomName", "", "connectToRoom", "disconnect", "makePhoto", "message", "sendMessage", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState;", "getState", "()Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState;", "state", "<init>", "(Lcom/sumsub/sns/videoident/presentation/SNSVideoIdentFragment;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public final class SNSVideoChatAdapterImpl implements g {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SNSMessage.ClientMessage.Type.values().length];
                iArr[SNSMessage.ClientMessage.Type.USER_VISIBILITY_STATE.ordinal()] = 1;
                iArr[SNSMessage.ClientMessage.Type.SCREENSHOT_MADE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public SNSVideoChatAdapterImpl() {
        }

        private final String asJson(SNSMessage.ClientMessage clientMessage) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[clientMessage.a().ordinal()];
            if (i11 == 1) {
                kotlinx.serialization.json.a t11 = SNSVideoIdentFragment.this.getServiceLocator().t();
                d a11 = t11.a();
                p n11 = Reflection.n(SNSMessage.ClientMessage.UserVisibilityState.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                return t11.b(kotlinx.serialization.h.d(a11, n11), (SNSMessage.ClientMessage.UserVisibilityState) clientMessage);
            } else if (i11 != 2) {
                kotlinx.serialization.json.a t12 = SNSVideoIdentFragment.this.getServiceLocator().t();
                d a12 = t12.a();
                p n12 = Reflection.n(SNSMessage.ClientMessage.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                return t12.b(kotlinx.serialization.h.d(a12, n12), clientMessage);
            } else {
                kotlinx.serialization.json.a t13 = SNSVideoIdentFragment.this.getServiceLocator().t();
                d a13 = t13.a();
                p n13 = Reflection.n(SNSMessage.ClientMessage.e.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                return t13.b(kotlinx.serialization.h.d(a13, n13), (SNSMessage.ClientMessage.e) clientMessage);
            }
        }

        public void connectToRoom(String str, String str2) {
            SNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1 sNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1 = new SNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1(SNSVideoIdentFragment.this, str, str2);
            if (SNSVideoIdentFragment.this.serviceConnection.getConnected()) {
                sNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1.invoke();
            } else {
                SNSVideoIdentFragment.this.startServiceAndConnectToRoom = sNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1;
            }
        }

        public void disconnect() {
            SNSVideoChatController videoChatController;
            SNSVideoChatService service = SNSVideoIdentFragment.this.serviceConnection.getService();
            if (service != null && (videoChatController = service.getVideoChatController()) != null) {
                videoChatController.a();
            }
        }

        public SNSVideoChatState getState() {
            SNSVideoChatController videoChatController;
            j1<SNSVideoChatState> l11;
            SNSVideoChatService service = SNSVideoIdentFragment.this.serviceConnection.getService();
            if (service == null || (videoChatController = service.getVideoChatController()) == null || (l11 = videoChatController.l()) == null) {
                return null;
            }
            return l11.getValue();
        }

        public void makePhoto() {
            SNSVideoChatController videoChatController;
            SNSVideoChatService service = SNSVideoIdentFragment.this.serviceConnection.getService();
            if (service != null && (videoChatController = service.getVideoChatController()) != null) {
                videoChatController.o();
            }
        }

        public void sendMessage(SNSMessage.ClientMessage clientMessage) {
            SNSVideoChatController videoChatController;
            if (SNSVideoIdentFragment.this.getServiceLocatorSafe() == null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "sendMessage failed. Detached from activity", (Throwable) null, 4, (Object) null);
                return;
            }
            String asJson = asJson(clientMessage);
            SNSVideoChatService service = SNSVideoIdentFragment.this.serviceConnection.getService();
            if (service != null && (videoChatController = service.getVideoChatController()) != null) {
                videoChatController.a(asJson);
            }
        }
    }

    public SNSVideoIdentFragment() {
        SNSVideoIdentFragment$viewModel$2 sNSVideoIdentFragment$viewModel$2 = new SNSVideoIdentFragment$viewModel$2(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new SNSVideoIdentFragment$special$$inlined$viewModels$default$2(new SNSVideoIdentFragment$special$$inlined$viewModels$default$1(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(h.class), new SNSVideoIdentFragment$special$$inlined$viewModels$default$3(b11), new SNSVideoIdentFragment$special$$inlined$viewModels$default$4((d10.a) null, b11), sNSVideoIdentFragment$viewModel$2);
        this.screen = Screen.VideoidentScreen;
        this.idDocSetType = DocumentType.f32356k;
        this.previousVolumeControlStream = Integer.MIN_VALUE;
        this.callState = AnalyticsCallState.PREPARING;
        this.serviceConnection = new SNSVideoIdentFragment$serviceConnection$1(this);
        this.shortTimeFormat = new SimpleDateFormat("mm:ss", Locale.US);
        this.calendar = Calendar.getInstance();
    }

    private final void applyVideoViewSize(View view, float f11) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "applying video scale " + f11, (Throwable) null, 4, (Object) null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int i11 = (getResources().getDisplayMetrics().widthPixels / 2) - (dimensionPixelSize * 2);
        layoutParams.width = i11;
        layoutParams.height = MathKt__MathJVMKt.b(((float) i11) / f11);
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public final void attachChatControllerListeners(SNSVideoChatController sNSVideoChatController) {
        this.chatMessagesCollectJob = kotlinx.coroutines.i.d(this.fragmentScope, (CoroutineContext) null, (CoroutineStart) null, new SNSVideoIdentFragment$attachChatControllerListeners$1(sNSVideoChatController, this, (c<? super SNSVideoIdentFragment$attachChatControllerListeners$1>) null), 3, (Object) null);
        this.chatStateCollectJob = b0.b(sNSVideoChatController.l(), (LifecycleOwner) this, new SNSVideoIdentFragment$attachChatControllerListeners$2(this, (c<? super SNSVideoIdentFragment$attachChatControllerListeners$2>) null));
        sNSVideoChatController.a((d10.a<Unit>) new SNSVideoIdentFragment$attachChatControllerListeners$3(this));
        sNSVideoChatController.b((d10.a<Unit>) new SNSVideoIdentFragment$attachChatControllerListeners$4(this));
        sNSVideoChatController.a((l<? super Bitmap, Unit>) new SNSVideoIdentFragment$attachChatControllerListeners$5(this));
        sNSVideoChatController.b((l<? super Long, Unit>) new SNSVideoIdentFragment$attachChatControllerListeners$6(this));
    }

    /* access modifiers changed from: private */
    public final int calculateExpandedOffset(CoordinatorLayout coordinatorLayout) {
        int i11 = 0;
        int b11 = (getContext() instanceof Activity ? com.sumsub.sns.internal.core.common.a.b(requireActivity(), R$attr.actionBarSize) + 0 : 0) + requireActivity().findViewById(R.id.above_bottom_sheet_container).getMeasuredHeight();
        SNSWarningView message = getMessage();
        boolean z11 = true;
        if (message != null) {
            if (message.getVisibility() == 0) {
                b11 += message.getHeight();
            }
        }
        View remoteVideoContainer = getRemoteVideoContainer();
        if (remoteVideoContainer != null) {
            if (remoteVideoContainer.getVisibility() != 0) {
                z11 = false;
            }
            if (z11 && this.remoteVideoScale != null) {
                b11 += remoteVideoContainer.getHeight();
            }
        }
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            bottomSheet.measure(View.MeasureSpec.makeMeasureSpec(coordinatorLayout.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(coordinatorLayout.getHeight() - b11, Integer.MIN_VALUE));
            i11 = coordinatorLayout.getHeight() - bottomSheet.getMeasuredHeight();
        }
        return Math.max(i11, b11);
    }

    /* access modifiers changed from: private */
    public final void detachChatControllerListeners(SNSVideoChatController sNSVideoChatController) {
        n1 n1Var = this.chatMessagesCollectJob;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            this.chatMessagesCollectJob = null;
        }
        sNSVideoChatController.b((d10.a<Unit>) null);
        sNSVideoChatController.a((l<? super Bitmap, Unit>) null);
        sNSVideoChatController.b((l<? super Long, Unit>) null);
    }

    /* access modifiers changed from: private */
    public final void doStartServiceAndConnectToRoom(String str, String str2) {
        SNSVideoChatController videoChatController;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("doStartServiceAndConnectToRoom: token=");
        boolean z11 = false;
        sb2.append(str.substring(0, 5));
        sb2.append(", room=");
        sb2.append(str2);
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, sb2.toString(), (Throwable) null, 4, (Object) null);
        SNSVideoChatService service = this.serviceConnection.getService();
        if (service != null) {
            z11 = service.isInForeground();
        }
        if (!z11) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "starting foreground", (Throwable) null, 4, (Object) null);
            Context requireContext = requireContext();
            Intent intent = new Intent(requireContext(), SNSVideoChatService.class);
            intent.setAction(SNSVideoChatService.ACTION_START_FOREGROUND);
            intent.putExtra("sns_extra_session", getSession());
            ContextCompat.startForegroundService(requireContext, intent);
        }
        SNSVideoChatService service2 = this.serviceConnection.getService();
        if (service2 != null && (videoChatController = service2.getVideoChatController()) != null) {
            videoChatController.a(requireContext(), str, str2);
        }
    }

    private final Button getBottomPrimaryButton() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (Button) bottomSheet.findViewById(R.id.sns_button1);
        }
        return null;
    }

    private final View getBottomProgressBar() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return bottomSheet.findViewById(R.id.sns_vi_bottom_progress_bar);
        }
        return null;
    }

    private final Button getBottomSecondaryButton() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (Button) bottomSheet.findViewById(R.id.sns_button2);
        }
        return null;
    }

    private final ViewGroup getBottomSheet() {
        View view = getView();
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.sns_web_view_bottom_sheet);
        }
        return null;
    }

    private final Button getBottomTertiaryButton() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (Button) bottomSheet.findViewById(R.id.sns_button3);
        }
        return null;
    }

    private final TextView getBottomText() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (TextView) bottomSheet.findViewById(R.id.sns_text);
        }
        return null;
    }

    private final TextView getBottomTitle() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (TextView) bottomSheet.findViewById(R.id.sns_title);
        }
        return null;
    }

    private final SNSWarningView getBottomWarning() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (SNSWarningView) bottomSheet.findViewById(R.id.sns_warning);
        }
        return null;
    }

    private final TextView getChangeLanguage() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (TextView) bottomSheet.findViewById(R.id.sns_button);
        }
        return null;
    }

    private final Map<String, Object> getCommonPayload() {
        Pair[] pairArr = new Pair[3];
        boolean z11 = false;
        pairArr[0] = kotlin.l.a("callState", this.callState.getValue());
        if (this.exitConfirmationDialog != null) {
            z11 = true;
        }
        pairArr[1] = kotlin.l.a("shouldConfirmExit", Boolean.valueOf(z11));
        pairArr[2] = kotlin.l.a("fromScreen", getScreen().getText());
        return MapsKt__MapsKt.l(pairArr);
    }

    private final Map<String, Object> getCompletePayload() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(getCommonPayload());
        linkedHashMap.putAll(getPermissionsPayload());
        return linkedHashMap;
    }

    private final ViewGroup getDocumentList() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (ViewGroup) bottomSheet.findViewById(R.id.documents);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.sumsub.sns.internal.core.data.model.Document> getDocuments() {
        /*
            r2 = this;
            android.os.Bundle r0 = r2.requireArguments()
            java.lang.String r1 = "docs"
            java.util.ArrayList r0 = r0.getParcelableArrayList(r1)
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r0)
            if (r0 != 0) goto L_0x0016
        L_0x0012:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment.getDocuments():java.util.List");
    }

    private final TextView getLanguage() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (TextView) bottomSheet.findViewById(R.id.sns_label);
        }
        return null;
    }

    private final ViewGroup getLanguageSection() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (ViewGroup) bottomSheet.findViewById(R.id.language_section);
        }
        return null;
    }

    private final TextView getLanguageSectionTitle() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (TextView) bottomSheet.findViewById(R.id.sns_language_section_title);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final VideoView getLocalVideoView() {
        View view = getView();
        if (view != null) {
            return view.findViewById(R.id.local_video_view);
        }
        return null;
    }

    private final SNSWarningView getMessage() {
        View view = getView();
        if (view != null) {
            return (SNSWarningView) view.findViewById(R.id.message);
        }
        return null;
    }

    private final TextView getOperatorName() {
        View remoteVideoContainer = getRemoteVideoContainer();
        if (remoteVideoContainer != null) {
            return (TextView) remoteVideoContainer.findViewById(R.id.title);
        }
        return null;
    }

    private final Map<String, Object> getPermissionsPayload() {
        Context context = getContext();
        if (context == null) {
            return MapsKt__MapsKt.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PermissionPayload.MICROPHONE_PERMISSION.toString(), Boolean.valueOf(j.a(context, "android.permission.RECORD_AUDIO")));
        linkedHashMap.put(PermissionPayload.CAMERA_PERMISSION.toString(), Boolean.valueOf(j.a(context, "android.permission.CAMERA")));
        linkedHashMap.put("hasNotificationsEnabled", Boolean.valueOf(j.b(context, SNSVideoChatService.NOTIFICATION_CHANNEL_ID)));
        return linkedHashMap;
    }

    private final ViewGroup getPhoneVerificationBottomSheet() {
        View view = getView();
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.phone_verification_bottom_sheet);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final View getPhotoMadeIndicator() {
        View view = getView();
        if (view != null) {
            return view.findViewById(R.id.photo_made_indicator);
        }
        return null;
    }

    private final ImageView getPhotoPreview() {
        ViewGroup photoPreviewContainer = getPhotoPreviewContainer();
        if (photoPreviewContainer != null) {
            return (ImageView) photoPreviewContainer.findViewById(R.id.sns_photo);
        }
        return null;
    }

    private final ViewGroup getPhotoPreviewContainer() {
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            return (ViewGroup) bottomSheet.findViewById(R.id.sns_photo_preview);
        }
        return null;
    }

    private final TextView getRecordTime() {
        View view = getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.timer);
        }
        return null;
    }

    private final View getRemoteVideoContainer() {
        View view = getView();
        if (view != null) {
            return view.findViewById(R.id.remote_video);
        }
        return null;
    }

    private static /* synthetic */ void getRemoteVideoScale$annotations() {
    }

    private final VideoTextureView getRemoteVideoView() {
        View remoteVideoContainer = getRemoteVideoContainer();
        if (remoteVideoContainer != null) {
            return remoteVideoContainer.findViewById(R.id.remote_video_view);
        }
        return null;
    }

    private final View getSwitchCamera() {
        View view = getView();
        if (view != null) {
            return view.findViewById(R.id.switchCamera);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void handleFileSelectedForDocSetType(String str, Uri uri) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleFileSelectedForDocSetType: " + str + ", " + uri, (Throwable) null, 4, (Object) null);
        if (uri != null) {
            getViewModel().a(uri);
        }
    }

    private final void handleLanguageSelectionResult(Bundle bundle) {
        hideLanguageSelection();
        getViewModel().b(bundle.getString("lang"));
    }

    private final void handlePermissionResults(Map<String, Boolean> map) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handlePermissionResults: " + map, (Throwable) null, 4, (Object) null);
        if (map.containsKey("android.permission.POST_NOTIFICATIONS")) {
            getViewModel().U();
        } else {
            getViewModel().a(map);
        }
    }

    private final void handleSelectLanguage(SNSViewState.b bVar) {
        getChildFragmentManager().q().t(R.id.phone_verification_fragment, LanguageSelectionFragment.Companion.getInstance(bVar).forResult(LANGUAGE_REQUEST_KEY)).h("language_fragment").k();
        getChildFragmentManager().H1(LANGUAGE_REQUEST_KEY, requireActivity(), new g(this));
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior2 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setState(3);
        }
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior3 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.setDraggable(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSelectLanguage$lambda-36  reason: not valid java name */
    public static final void m2290handleSelectLanguage$lambda36(SNSVideoIdentFragment sNSVideoIdentFragment, String str, Bundle bundle) {
        sNSVideoIdentFragment.handleLanguageSelectionResult(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleState$lambda-46$lambda-45  reason: not valid java name */
    public static final void m2291handleState$lambda46$lambda45(SNSVideoIdentFragment sNSVideoIdentFragment, View view) {
        sNSVideoIdentFragment.getViewModel().a0();
    }

    /* access modifiers changed from: private */
    /* renamed from: handleState$lambda-48$lambda-47  reason: not valid java name */
    public static final void m2292handleState$lambda48$lambda47(SNSVideoIdentFragment sNSVideoIdentFragment, View view) {
        sNSVideoIdentFragment.getViewModel().Z();
    }

    private final boolean hideLanguageSelection() {
        Fragment l02 = getChildFragmentManager().l0(R.id.phone_verification_fragment);
        if (l02 == null) {
            return false;
        }
        if (!(l02 instanceof LanguageSelectionFragment)) {
            l02 = null;
        }
        if (l02 == null) {
            return false;
        }
        getChildFragmentManager().j1();
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior2 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior2 == null) {
            return true;
        }
        bottomSheetBehavior2.setState(5);
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean hidePhoneVerification() {
        Fragment l02 = getChildFragmentManager().l0(R.id.phone_verification_fragment);
        if (l02 == null) {
            return false;
        }
        if (!(l02 instanceof com.sumsub.sns.core.presentation.screen.verification.a)) {
            l02 = null;
        }
        if (l02 == null) {
            return false;
        }
        getChildFragmentManager().j1();
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior2 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior2 == null) {
            return true;
        }
        bottomSheetBehavior2.setState(5);
        return true;
    }

    private final void onPhoneVerificationResult(int i11) {
        PhoneVerificationStatus phoneVerificationStatus;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onPhoneVerificationResult: code=" + i11, (Throwable) null, 4, (Object) null);
        if (i11 == 1) {
            hidePhoneVerification();
            phoneVerificationStatus = PhoneVerificationStatus.SUCCESS;
        } else if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    phoneVerificationStatus = PhoneVerificationStatus.RETRY_CODE;
                } else if (i11 != 5) {
                    com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.videoident.videoident.a.f36980b, "Unknown verification code " + i11, (Throwable) null, 4, (Object) null);
                } else {
                    hidePhoneVerification();
                    phoneVerificationStatus = PhoneVerificationStatus.CANCELED;
                }
            }
            phoneVerificationStatus = null;
        } else {
            phoneVerificationStatus = PhoneVerificationStatus.REQUESTED;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onPhoneVerificationResult: " + phoneVerificationStatus, (Throwable) null, 4, (Object) null);
        if (phoneVerificationStatus != null) {
            getViewModel().a(phoneVerificationStatus);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12  reason: not valid java name */
    public static final void m2293onViewCreated$lambda12(SNSVideoIdentFragment sNSVideoIdentFragment, View view) {
        sNSVideoIdentFragment.switchCameraAndUpdateMirroring();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-13  reason: not valid java name */
    public static final void m2294onViewCreated$lambda13(SNSVideoIdentFragment sNSVideoIdentFragment, Map map) {
        sNSVideoIdentFragment.handlePermissionResults(map);
    }

    private final void populateDocumentList(ViewGroup viewGroup, List<SNSStepViewItem> list) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "populateDocumentList: count=" + list.size(), (Throwable) null, 4, (Object) null);
        viewGroup.removeAllViews();
        int i11 = 0;
        for (T next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            SNSStepViewItem sNSStepViewItem = (SNSStepViewItem) next;
            SNSVideoIdentDocumentView sNSVideoIdentDocumentView = new SNSVideoIdentDocumentView(requireContext(), (AttributeSet) null, 0, 0, 14, (r) null);
            boolean z11 = true;
            sNSVideoIdentDocumentView.setSelected(sNSStepViewItem.getState() != SNSStepViewItem.State.DEFAULT);
            if (sNSStepViewItem.getState() != SNSStepViewItem.State.DONE) {
                z11 = false;
            }
            sNSVideoIdentDocumentView.setActivated(z11);
            String icon = sNSStepViewItem.getIcon();
            if (icon != null) {
                sNSVideoIdentDocumentView.setIconStart(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), icon));
            }
            CharSequence title = sNSStepViewItem.getTitle();
            sNSVideoIdentDocumentView.setTitle(title != null ? com.sumsub.sns.internal.core.common.i.a(title, requireContext()) : null);
            viewGroup.addView(sNSVideoIdentDocumentView);
            i11 = i12;
        }
    }

    private final boolean releaseCurrentStatePreviewIfChanged(SNSViewState sNSViewState) {
        Bitmap M;
        SNSViewState sNSViewState2 = this.currentViewState;
        SNSViewState.e eVar = sNSViewState2 instanceof SNSViewState.e ? (SNSViewState.e) sNSViewState2 : null;
        if (eVar == null || (M = eVar.M()) == null) {
            return false;
        }
        SNSViewState.e eVar2 = sNSViewState instanceof SNSViewState.e ? (SNSViewState.e) sNSViewState : null;
        if (eVar2 == null || x.b(eVar2.M(), M)) {
            return false;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleViewStateChange: releasing previewImage", (Throwable) null, 4, (Object) null);
        M.recycle();
        return true;
    }

    private final void requestAllPermissions() {
        ActivityResultLauncher<String[]> activityResultLauncher = this.permissionLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(getViewModel().G());
        }
    }

    private final void requestPermission(String str) {
        ActivityResultLauncher<String[]> activityResultLauncher;
        if (Build.VERSION.SDK_INT >= 33 && (activityResultLauncher = this.permissionLauncher) != null) {
            activityResultLauncher.a(new String[]{str});
        }
    }

    private final void showCameraPermissionDialog(SNSViewState.d dVar) {
        if (this.lackOfPermissionDialog == null) {
            com.sumsub.sns.internal.core.android.c cVar = com.sumsub.sns.internal.core.android.c.f31946a;
            FragmentActivity requireActivity = requireActivity();
            f d11 = dVar.d();
            CharSequence d12 = d11 != null ? d11.d() : null;
            f d13 = dVar.d();
            CharSequence f11 = d13 != null ? d13.f() : null;
            f d14 = dVar.d();
            AlertDialog a11 = com.sumsub.sns.internal.core.android.c.a(cVar, requireActivity, d12, f11, d14 != null ? d14.e() : null, new SNSVideoIdentFragment$showCameraPermissionDialog$2(this), (d10.a) null, 32, (Object) null);
            this.lackOfPermissionDialog = a11;
            if (a11 != null) {
                a11.setOnDismissListener(new j(this));
            }
            AlertDialog alertDialog = this.lackOfPermissionDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraPermissionDialog$lambda-31  reason: not valid java name */
    public static final void m2295showCameraPermissionDialog$lambda31(SNSVideoIdentFragment sNSVideoIdentFragment, DialogInterface dialogInterface) {
        sNSVideoIdentFragment.lackOfPermissionDialog = null;
    }

    private final void showExitConfirmationState(SNSViewState.e eVar) {
        AlertDialog alertDialog;
        Map e11 = MapsKt__MapsJVMKt.e(kotlin.l.a("fromScreen", getScreen().getText()));
        SNSViewState.a H = eVar.H();
        if (H == null || (alertDialog = new SNSAlertDialogBuilder(requireContext()).setMessage(H.f()).setPositiveButton(H.e(), (DialogInterface.OnClickListener) new i(this, e11)).setNegativeButton(H.d(), (DialogInterface.OnClickListener) new h(this, e11)).setOnCancelListener((DialogInterface.OnCancelListener) new b(this)).setOnDismissListener((DialogInterface.OnDismissListener) new l(this, e11)).create()) == null) {
            alertDialog = null;
        } else {
            alertDialog.setOnShowListener(new m(this, e11));
        }
        this.exitConfirmationDialog = alertDialog;
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.sumsub.sns.internal.core.analytics.Screen, android.content.DialogInterface] */
    /* JADX WARNING: type inference failed for: r0v0, types: [int, java.lang.String] */
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: showExitConfirmationState$lambda-58$lambda-54  reason: not valid java name */
    public static final void m2296showExitConfirmationState$lambda58$lambda54(SNSVideoIdentFragment sNSVideoIdentFragment, Map map, DialogInterface dialogInterface, int i11) {
        k0 appListener;
        dialogInterface.dismiss();
        com.sumsub.sns.internal.core.analytics.c analyticsDelegate = sNSVideoIdentFragment.getAnalyticsDelegate();
        ? r52 = Screen.VideoIdentExitPopup;
        ? idDocSetType2 = sNSVideoIdentFragment.getIdDocSetType();
        analyticsDelegate.b(r52, idDocSetType2, Control.ConfirmButton, map);
        sNSVideoIdentFragment.getViewModel().Q();
        if (com.sumsub.sns.internal.ff.a.f34215a.s().g() && (appListener = sNSVideoIdentFragment.getAppListener()) != null) {
            appListener.b();
        }
        SensorsDataAutoTrackHelper.trackDialog(r52, idDocSetType2);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.String, android.content.DialogInterface] */
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: showExitConfirmationState$lambda-58$lambda-55  reason: not valid java name */
    public static final void m2297showExitConfirmationState$lambda58$lambda55(SNSVideoIdentFragment sNSVideoIdentFragment, Map map, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        com.sumsub.sns.internal.core.analytics.c analyticsDelegate = sNSVideoIdentFragment.getAnalyticsDelegate();
        Screen screen2 = Screen.VideoIdentExitPopup;
        ? idDocSetType2 = sNSVideoIdentFragment.getIdDocSetType();
        analyticsDelegate.b(screen2, idDocSetType2, Control.CancelButton, map);
        SensorsDataAutoTrackHelper.trackDialog(idDocSetType2, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: showExitConfirmationState$lambda-58$lambda-56  reason: not valid java name */
    public static final void m2298showExitConfirmationState$lambda58$lambda56(SNSVideoIdentFragment sNSVideoIdentFragment, DialogInterface dialogInterface) {
        AlertDialog alertDialog = sNSVideoIdentFragment.exitConfirmationDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showExitConfirmationState$lambda-58$lambda-57  reason: not valid java name */
    public static final void m2299showExitConfirmationState$lambda58$lambda57(SNSVideoIdentFragment sNSVideoIdentFragment, Map map, DialogInterface dialogInterface) {
        sNSVideoIdentFragment.getAnalyticsDelegate().c(Screen.VideoIdentExitPopup, sNSVideoIdentFragment.getIdDocSetType(), map);
    }

    /* access modifiers changed from: private */
    /* renamed from: showExitConfirmationState$lambda-60$lambda-59  reason: not valid java name */
    public static final void m2300showExitConfirmationState$lambda60$lambda59(SNSVideoIdentFragment sNSVideoIdentFragment, Map map, DialogInterface dialogInterface) {
        sNSVideoIdentFragment.getAnalyticsDelegate().d(Screen.VideoIdentExitPopup, sNSVideoIdentFragment.getIdDocSetType(), map);
    }

    /* access modifiers changed from: private */
    public final void showPhoneVerificationFragment() {
        getChildFragmentManager().q().t(R.id.phone_verification_fragment, com.sumsub.sns.core.presentation.screen.verification.a.f31123p.a(ValidationIdentifierType.PHONE).forResult(VERIFICATION_REQUEST_KEY)).h("phone_verification_fragment").k();
        getChildFragmentManager().H1(VERIFICATION_REQUEST_KEY, requireActivity(), new f(this));
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior2 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setDraggable(true);
        }
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior3 = this.phoneVerificationBottomSheetBehavior;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.setState(3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showPhoneVerificationFragment$lambda-23  reason: not valid java name */
    public static final void m2301showPhoneVerificationFragment$lambda23(SNSVideoIdentFragment sNSVideoIdentFragment, String str, Bundle bundle) {
        sNSVideoIdentFragment.onPhoneVerificationResult(b.Companion.a(bundle));
    }

    /* access modifiers changed from: private */
    public final void showPhotoMadeAnimation(d10.a<Unit> aVar) {
        View photoMadeIndicator = getPhotoMadeIndicator();
        if (photoMadeIndicator != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(new SNSVideoIdentFragment$showPhotoMadeAnimation$1$1(this, aVar));
            photoMadeIndicator.startAnimation(alphaAnimation);
        }
    }

    private final void showRecordAudioPermissionDialog(SNSViewState.d dVar) {
        if (this.lackOfPermissionDialog == null) {
            com.sumsub.sns.internal.core.android.c cVar = com.sumsub.sns.internal.core.android.c.f31946a;
            FragmentActivity requireActivity = requireActivity();
            f d11 = dVar.d();
            CharSequence d12 = d11 != null ? d11.d() : null;
            f d13 = dVar.d();
            CharSequence f11 = d13 != null ? d13.f() : null;
            f d14 = dVar.d();
            AlertDialog a11 = com.sumsub.sns.internal.core.android.c.a(cVar, requireActivity, d12, f11, d14 != null ? d14.e() : null, new SNSVideoIdentFragment$showRecordAudioPermissionDialog$2(this), (d10.a) null, 32, (Object) null);
            this.lackOfPermissionDialog = a11;
            if (a11 != null) {
                a11.setOnDismissListener(new k(this));
            }
            AlertDialog alertDialog = this.lackOfPermissionDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showRecordAudioPermissionDialog$lambda-29  reason: not valid java name */
    public static final void m2302showRecordAudioPermissionDialog$lambda29(SNSVideoIdentFragment sNSVideoIdentFragment, DialogInterface dialogInterface) {
        sNSVideoIdentFragment.lackOfPermissionDialog = null;
    }

    private final void startBottomAnimation(SNSViewState.e eVar) {
        SNSViewState sNSViewState = this.currentViewState;
        SNSViewState.e eVar2 = sNSViewState instanceof SNSViewState.e ? (SNSViewState.e) sNSViewState : null;
        if (eVar2 != null) {
            if (!(!eVar2.I().isEmpty()) || eVar.S()) {
                TransitionSet transitionSet = new TransitionSet();
                Fade fade = new Fade(1);
                transitionSet.g(fade);
                transitionSet.g(new ChangeBounds());
                Fade fade2 = new Fade(2);
                fade2.setStartDelay(fade.getDuration());
                transitionSet.g(fade2);
                ViewGroup bottomSheet = getBottomSheet();
                if (bottomSheet != null) {
                    TransitionManager.b(bottomSheet, transitionSet);
                    return;
                }
                return;
            }
            ViewGroup bottomSheet2 = getBottomSheet();
            if (bottomSheet2 != null) {
                TransitionManager.a(bottomSheet2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void switchCameraAndUpdateMirroring() {
        SNSVideoChatController videoChatController;
        SNSVideoChatController.CameraId t11;
        SNSVideoChatService service = this.serviceConnection.getService();
        if (service != null && (videoChatController = service.getVideoChatController()) != null && (t11 = videoChatController.t()) != null) {
            VideoView localVideoView = getLocalVideoView();
            if (localVideoView != null) {
                localVideoView.setMirror(t11 == SNSVideoChatController.CameraId.FRONT);
            }
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "switchCamera: " + t11, (Throwable) null, 4, (Object) null);
        }
    }

    private final void updateBottomPrimaryButton(Button button, SNSViewState.e eVar) {
        com.sumsub.sns.internal.core.common.i.a((View) button, !eVar.P());
        button.setText(eVar.B());
        button.setEnabled(eVar.A());
        button.setOnClickListener(new n(eVar, this));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: updateBottomPrimaryButton$lambda-65  reason: not valid java name */
    public static final void m2303updateBottomPrimaryButton$lambda65(SNSViewState.e eVar, SNSVideoIdentFragment sNSVideoIdentFragment, View view) {
        ButtonAction z11 = eVar.z();
        if (z11 != null) {
            if (z11 == ButtonAction.START_CALL) {
                sNSVideoIdentFragment.getAnalyticsDelegate().b(Screen.VideoidentScreen, sNSVideoIdentFragment.getIdDocSetType(), Control.StartButton, sNSVideoIdentFragment.getCommonPayload());
            }
            sNSVideoIdentFragment.getViewModel().a(z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void updateLanguageSection(SNSViewState.e eVar) {
        SNSViewState.e.a.C0498a K = eVar.K();
        String str = null;
        if ((K != null ? K.e() : null) != null) {
            ViewGroup languageSection = getLanguageSection();
            if (languageSection != null) {
                languageSection.setVisibility(0);
            }
            TextView languageSectionTitle = getLanguageSectionTitle();
            if (languageSectionTitle != null) {
                SNSViewState.e.a.C0498a K2 = eVar.K();
                com.sumsub.sns.internal.core.common.i.a(languageSectionTitle, (CharSequence) K2 != null ? K2.f() : null);
            }
            TextView language = getLanguage();
            if (language != null) {
                SNSViewState.e.a.C0498a K3 = eVar.K();
                com.sumsub.sns.internal.core.common.i.a(language, (CharSequence) K3 != null ? K3.e() : null);
            }
            TextView changeLanguage = getChangeLanguage();
            if (changeLanguage != null) {
                SNSViewState.e.a.C0498a K4 = eVar.K();
                if (K4 != null) {
                    str = K4.d();
                }
                com.sumsub.sns.internal.core.common.i.a(changeLanguage, (CharSequence) str);
            }
            TextView changeLanguage2 = getChangeLanguage();
            if (changeLanguage2 != null) {
                changeLanguage2.setOnClickListener(new p(this));
                return;
            }
            return;
        }
        ViewGroup languageSection2 = getLanguageSection();
        if (languageSection2 != null) {
            languageSection2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: updateLanguageSection$lambda-53  reason: not valid java name */
    public static final void m2304updateLanguageSection$lambda53(SNSVideoIdentFragment sNSVideoIdentFragment, View view) {
        sNSVideoIdentFragment.getAnalyticsDelegate().b(sNSVideoIdentFragment.getScreen(), sNSVideoIdentFragment.getIdDocSetType(), Control.ChangeButton, sNSVideoIdentFragment.getCommonPayload());
        sNSVideoIdentFragment.getViewModel().R();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getVideoChatController();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateRecordTimerText() {
        /*
            r3 = this;
            java.util.Calendar r0 = r3.calendar
            com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$serviceConnection$1 r1 = r3.serviceConnection
            com.sumsub.sns.videoident.service.SNSVideoChatService r1 = r1.getService()
            if (r1 == 0) goto L_0x0015
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController r1 = r1.getVideoChatController()
            if (r1 == 0) goto L_0x0015
            long r1 = r1.h()
            goto L_0x0017
        L_0x0015:
            r1 = 0
        L_0x0017:
            r0.setTimeInMillis(r1)
            android.widget.TextView r0 = r3.getRecordTime()
            if (r0 != 0) goto L_0x0021
            goto L_0x0030
        L_0x0021:
            java.text.SimpleDateFormat r1 = r3.shortTimeFormat
            java.util.Calendar r2 = r3.calendar
            java.util.Date r2 = r2.getTime()
            java.lang.String r1 = r1.format(r2)
            r0.setText(r1)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment.updateRecordTimerText():void");
    }

    private final void updateRemoteVideoView(SNSViewState.e eVar, VideoTextureView videoTextureView, boolean z11, boolean z12) {
        SNSVideoChatController videoChatController;
        SNSVideoChatController videoChatController2;
        e O = eVar.O();
        int i11 = 0;
        boolean z13 = true;
        com.sumsub.sns.internal.core.common.i.b((View) videoTextureView, O != null && O.f());
        e O2 = eVar.O();
        TextView operatorName = getOperatorName();
        View view = null;
        if (operatorName != null) {
            CharSequence d11 = O2 != null ? O2.d() : null;
            operatorName.setVisibility(!(d11 == null || StringsKt__StringsJVMKt.z(d11)) && z11 ? 0 : 8);
        }
        TextView operatorName2 = getOperatorName();
        if (operatorName2 != null) {
            operatorName2.setText(O2 != null ? O2.d() : null);
        }
        if (z11 && z12) {
            Float f11 = this.remoteVideoScale;
            if (f11 != null) {
                applyVideoViewSize(videoTextureView, f11.floatValue());
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        e O3 = eVar.O();
        if (O3 != null && O3.f()) {
            SNSVideoChatService service = this.serviceConnection.getService();
            if (!(service == null || (videoChatController2 = service.getVideoChatController()) == null)) {
                videoChatController2.b((VideoSink) videoTextureView);
            }
        } else {
            SNSVideoChatService service2 = this.serviceConnection.getService();
            if (!(service2 == null || (videoChatController = service2.getVideoChatController()) == null)) {
                videoChatController.d((VideoSink) videoTextureView);
            }
        }
        View remoteVideoContainer = getRemoteVideoContainer();
        if (remoteVideoContainer != null) {
            view = remoteVideoContainer.findViewById(R.id.sns_progress_bar);
        }
        if (view != null) {
            e O4 = eVar.O();
            if (O4 == null || !O4.e()) {
                z13 = false;
            }
            if (!z13) {
                i11 = 8;
            }
            view.setVisibility(i11);
        }
    }

    public Map<String, Object> getAppearPayload() {
        return getCompletePayload();
    }

    public Map<String, Object> getCancelPayload() {
        return getCompletePayload();
    }

    public Map<String, Object> getClosePayload() {
        return getCompletePayload();
    }

    public String getIdDocSetType() {
        return this.idDocSetType;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_video_ident;
    }

    public Map<String, Object> getOpenPayload() {
        return getCompletePayload();
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.i) {
            requestPermission(((a.i) jVar).b());
        } else {
            super.handleEvent(jVar);
        }
    }

    public void onCloseButtonClick() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onCloseButtonClick", (Throwable) null, 4, (Object) null);
        getAnalyticsDelegate().b(getScreen(), getIdDocSetType(), Control.CloseButton, getCommonPayload());
    }

    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        super.onCreate(bundle);
        if (!(bundle == null || (string2 = bundle.getString(CALL_STATE)) == null)) {
            AnalyticsCallState a11 = AnalyticsCallState.Companion.a(string2);
            if (a11 == null) {
                a11 = AnalyticsCallState.PREPARING;
            }
            this.callState = a11;
        }
        com.sumsub.sns.internal.core.android.a aVar = new com.sumsub.sns.internal.core.android.a(requireActivity().getActivityResultRegistry(), getUniqueId(), com.sumsub.sns.internal.core.common.h.a(getResources().getString(R.string.sns_videoident_mime_types)), new SNSVideoIdentFragment$onCreate$2(this), (d10.p<? super String, ? super List<? extends Uri>, Unit>) null);
        if (!(bundle == null || (string = bundle.getString(OBSERVER_ITEM_ID)) == null)) {
            aVar.c(string);
        }
        getLifecycle().a(aVar);
        this.pickerLifecycleObserver = aVar;
    }

    public void onDestroyView() {
        i0.f(this.fragmentScope, (CancellationException) null, 1, (Object) null);
        SNSVideoChatService service = this.serviceConnection.getService();
        if (service != null) {
            detachChatControllerListeners(service.getVideoChatController());
        }
        if (this.serviceConnection.getConnected()) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleViewStateChange: disconnecting from service ...", (Throwable) null, 4, (Object) null);
            requireActivity().unbindService(this.serviceConnection);
        }
        super.onDestroyView();
    }

    public boolean onFinishCalled(q qVar) {
        boolean b11 = x.b(qVar, q.c.f32251b);
        if (b11 && hideLanguageSelection()) {
            getViewModel().b((String) null);
            return false;
        } else if (b11 && hidePhoneVerification()) {
            getViewModel().a(PhoneVerificationStatus.CANCELED);
            return false;
        } else if (!b11) {
            return super.onFinishCalled(qVar);
        } else {
            AlertDialog alertDialog = this.exitConfirmationDialog;
            if (alertDialog != null) {
                alertDialog.show();
                return false;
            }
            getViewModel().Q();
            return false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.sumsub.sns.internal.core.android.a aVar = this.pickerLifecycleObserver;
        if (aVar == null) {
            aVar = null;
        }
        String b11 = aVar.b();
        if (b11 != null) {
            bundle.putString(OBSERVER_ITEM_ID, b11);
        }
        String str = this.currentCameraId;
        if (str != null) {
            bundle.putString(CAMERA_ID, str);
        }
        bundle.putString(CALL_STATE, this.callState.getValue());
    }

    public void onStart() {
        SNSVideoChatController videoChatController;
        SNSVideoChatService service;
        SNSVideoChatController videoChatController2;
        SNSVideoChatController videoChatController3;
        SNSVideoChatController videoChatController4;
        super.onStart();
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onStart", (Throwable) null, 4, (Object) null);
        this.previousVolumeControlStream = requireActivity().getVolumeControlStream();
        requireActivity().setVolumeControlStream(0);
        getViewModel().b0();
        SNSVideoChatService service2 = this.serviceConnection.getService();
        if (!(service2 == null || (videoChatController = service2.getVideoChatController()) == null)) {
            VideoView localVideoView = getLocalVideoView();
            if (localVideoView != null) {
                SNSVideoChatService service3 = this.serviceConnection.getService();
                if (!(service3 == null || (videoChatController4 = service3.getVideoChatController()) == null)) {
                    videoChatController4.a(localVideoView);
                }
                SNSVideoChatService service4 = this.serviceConnection.getService();
                if (!(service4 == null || (videoChatController3 = service4.getVideoChatController()) == null)) {
                    videoChatController3.a((Context) requireActivity());
                }
                String str = this.currentCameraId;
                if (str != null) {
                    SNSVideoChatController.CameraId c11 = videoChatController.c();
                    if (!x.b(c11 != null ? c11.getValue() : null, str)) {
                        switchCameraAndUpdateMirroring();
                    }
                    this.currentCameraId = null;
                }
            }
            VideoTextureView remoteVideoView = getRemoteVideoView();
            if (!(remoteVideoView == null || (service = this.serviceConnection.getService()) == null || (videoChatController2 = service.getVideoChatController()) == null)) {
                videoChatController2.b((VideoSink) remoteVideoView);
            }
        }
        if (this.checkPermissionsOnStart) {
            requestAllPermissions();
            this.checkPermissionsOnStart = false;
        }
    }

    public void onStop() {
        SNSVideoChatService service;
        SNSVideoChatController videoChatController;
        SNSVideoChatController videoChatController2;
        SNSVideoChatController videoChatController3;
        SNSVideoChatController videoChatController4;
        SNSVideoChatController.CameraId c11;
        String str = null;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onStop", (Throwable) null, 4, (Object) null);
        requireActivity().setVolumeControlStream(this.previousVolumeControlStream);
        SNSVideoChatService service2 = this.serviceConnection.getService();
        if (!(service2 == null || (videoChatController4 = service2.getVideoChatController()) == null || (c11 = videoChatController4.c()) == null)) {
            str = c11.getValue();
        }
        this.currentCameraId = str;
        VideoView localVideoView = getLocalVideoView();
        if (localVideoView != null) {
            SNSVideoChatService service3 = this.serviceConnection.getService();
            if (!(service3 == null || (videoChatController3 = service3.getVideoChatController()) == null)) {
                videoChatController3.c((VideoSink) localVideoView);
            }
            SNSVideoChatService service4 = this.serviceConnection.getService();
            if (!(service4 == null || (videoChatController2 = service4.getVideoChatController()) == null)) {
                videoChatController2.q();
            }
        }
        VideoTextureView remoteVideoView = getRemoteVideoView();
        if (!(remoteVideoView == null || (service = this.serviceConnection.getService()) == null || (videoChatController = service.getVideoChatController()) == null)) {
            videoChatController.d((VideoSink) remoteVideoView);
        }
        AlertDialog alertDialog = this.exitConfirmationDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onViewCreated: docs=" + getDocuments().size(), (Throwable) null, 4, (Object) null);
        super.onViewCreated(view, bundle);
        getViewModel().a((g) this.videoChatAdapter);
        if (bundle != null) {
            this.currentCameraId = bundle.getString(CAMERA_ID);
        }
        ViewGroup bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            BottomSheetBehavior<ViewGroup> from = BottomSheetBehavior.from(bottomSheet);
            from.setState(3);
            from.setHideable(false);
            from.setDraggable(true);
            from.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.sns_margin_large));
            from.setFitToContents(false);
            if (from instanceof SNSCustomBehavior) {
                ((SNSCustomBehavior) from).setExpandedOffsetCallback(new SNSVideoIdentFragment$onViewCreated$2$2$1(this));
            }
            this.bottomSheetBehavior = from;
        }
        ViewGroup phoneVerificationBottomSheet = getPhoneVerificationBottomSheet();
        if (phoneVerificationBottomSheet != null) {
            BottomSheetBehavior<ViewGroup> from2 = BottomSheetBehavior.from(phoneVerificationBottomSheet);
            from2.setState(3);
            from2.setHideable(true);
            from2.setDraggable(true);
            from2.setFitToContents(false);
            from2.setExpandedOffset(0);
            from2.addBottomSheetCallback(new SNSVideoIdentFragment$onViewCreated$3$2$1(this));
            from2.setState(5);
            this.phoneVerificationBottomSheetBehavior = from2;
        }
        VideoView localVideoView = getLocalVideoView();
        if (localVideoView != null) {
            localVideoView.setMirror(true);
        }
        VideoTextureView remoteVideoView = getRemoteVideoView();
        if (remoteVideoView != null) {
            remoteVideoView.setMirror(true);
        }
        getViewModel().a((l<? super Boolean, Unit>) new SNSVideoIdentFragment$onViewCreated$4(this));
        getViewModel().b((l<? super String, Unit>) new SNSVideoIdentFragment$onViewCreated$5(this));
        getViewModel().a((d10.a<Unit>) new SNSVideoIdentFragment$onViewCreated$6(this));
        getViewModel().b((d10.a<Unit>) new SNSVideoIdentFragment$onViewCreated$7(this));
        View switchCamera = getSwitchCamera();
        if (switchCamera != null) {
            switchCamera.setOnClickListener(new o(this));
        }
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new e(this));
    }

    public h getViewModel() {
        return (h) this.viewModel$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleState(com.sumsub.sns.internal.videoident.presentation.SNSViewState r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "handleState: "
            r14.append(r0)
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "SNSVideoIdent"
            r1 = 0
            r2 = 4
            com.sumsub.sns.internal.videoident.videoident.a.a(r0, r14, r1, r2, r1)
            com.sumsub.sns.internal.videoident.presentation.h r14 = r12.getViewModel()
            boolean r3 = r13 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.c
            r14.b((boolean) r3)
            android.view.View r14 = r12.getView()
            r4 = 8
            r5 = 1
            r6 = 0
            if (r14 != 0) goto L_0x002c
            goto L_0x003d
        L_0x002c:
            if (r3 != 0) goto L_0x0034
            boolean r7 = r13 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.d
            if (r7 != 0) goto L_0x0034
            r7 = r5
            goto L_0x0035
        L_0x0034:
            r7 = r6
        L_0x0035:
            if (r7 == 0) goto L_0x0039
            r7 = r6
            goto L_0x003a
        L_0x0039:
            r7 = r4
        L_0x003a:
            r14.setVisibility(r7)
        L_0x003d:
            android.view.ViewGroup r14 = r12.getLanguageSection()
            if (r14 != 0) goto L_0x0044
            goto L_0x0050
        L_0x0044:
            boolean r7 = r13.isPreview()
            if (r7 == 0) goto L_0x004c
            r7 = r6
            goto L_0x004d
        L_0x004c:
            r7 = r4
        L_0x004d:
            r14.setVisibility(r7)
        L_0x0050:
            boolean r14 = r13 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.d
            if (r14 == 0) goto L_0x006e
            r14 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$d r14 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.d) r14
            boolean r7 = r14.e()
            if (r7 == 0) goto L_0x0061
            r12.showCameraPermissionDialog(r14)
            goto L_0x006e
        L_0x0061:
            boolean r7 = r14.f()
            if (r7 == 0) goto L_0x006b
            r12.showRecordAudioPermissionDialog(r14)
            goto L_0x006e
        L_0x006b:
            r12.requestAllPermissions()
        L_0x006e:
            boolean r14 = r13 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.b
            if (r14 == 0) goto L_0x0078
            r14 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$b r14 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.b) r14
            r12.handleSelectLanguage(r14)
        L_0x0078:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState r14 = r12.currentViewState
            boolean r7 = r12.releaseCurrentStatePreviewIfChanged(r13)
            r12.currentViewState = r13
            boolean r8 = r13 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r8 == 0) goto L_0x0088
            r9 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r9 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r9
            goto L_0x0089
        L_0x0088:
            r9 = r1
        L_0x0089:
            if (r9 == 0) goto L_0x0092
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r9 = r9.y()
            if (r9 == 0) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r9 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.PREPARING
        L_0x0094:
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r10 = r12.callState
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r11 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.COMPLETED
            if (r10 != r11) goto L_0x00a0
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r11 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.PREPARING
            if (r9 != r11) goto L_0x00a0
            r11 = r5
            goto L_0x00a1
        L_0x00a0:
            r11 = r6
        L_0x00a1:
            if (r3 != 0) goto L_0x00a9
            if (r9 == r10) goto L_0x00a9
            if (r11 != 0) goto L_0x00a9
            r3 = r5
            goto L_0x00aa
        L_0x00a9:
            r3 = r6
        L_0x00aa:
            if (r3 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r9 = r1
        L_0x00ae:
            if (r9 == 0) goto L_0x00c8
            r12.callState = r9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r10 = "handleViewStateChange: callState="
            r3.append(r10)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r0, r3, r1, r2, r1)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x00c8:
            if (r8 != 0) goto L_0x00f9
            android.view.ViewGroup r13 = r12.getBottomSheet()
            if (r13 == 0) goto L_0x00d5
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r13, (boolean) r5)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x00d5:
            android.widget.TextView r13 = r12.getRecordTime()
            if (r13 == 0) goto L_0x00e0
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r13, (boolean) r5)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x00e0:
            android.view.View r13 = r12.getSwitchCamera()
            if (r13 == 0) goto L_0x00eb
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r13, (boolean) r5)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x00eb:
            android.view.View r13 = r12.getRemoteVideoContainer()
            if (r13 == 0) goto L_0x00f6
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r13, (boolean) r5)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x00f6:
            r12.exitConfirmationDialog = r1
            return
        L_0x00f9:
            boolean r3 = r13.isPreview()
            if (r3 == 0) goto L_0x0105
            r3 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r3 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r3
            r12.updateLanguageSection(r3)
        L_0x0105:
            com.sumsub.sns.core.widget.SNSWarningView r3 = r12.getMessage()
            if (r3 != 0) goto L_0x010c
            goto L_0x0128
        L_0x010c:
            r8 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r8 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r8
            java.lang.CharSequence r8 = r8.L()
            if (r8 == 0) goto L_0x011e
            int r8 = r8.length()
            if (r8 != 0) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r8 = r6
            goto L_0x011f
        L_0x011e:
            r8 = r5
        L_0x011f:
            r8 = r8 ^ r5
            if (r8 == 0) goto L_0x0124
            r8 = r6
            goto L_0x0125
        L_0x0124:
            r8 = r4
        L_0x0125:
            r3.setVisibility(r8)
        L_0x0128:
            r3 = r13
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r3 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r3
            boolean r8 = r3.Q()
            if (r8 == 0) goto L_0x0164
            android.view.ViewGroup r8 = r12.getBottomSheet()
            if (r8 == 0) goto L_0x0144
            int r8 = r8.getVisibility()
            if (r8 != 0) goto L_0x013f
            r8 = r5
            goto L_0x0140
        L_0x013f:
            r8 = r6
        L_0x0140:
            if (r8 != r5) goto L_0x0144
            r8 = r5
            goto L_0x0145
        L_0x0144:
            r8 = r6
        L_0x0145:
            if (r8 == 0) goto L_0x0164
            boolean r8 = r14 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r8 == 0) goto L_0x0164
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$VideoStepState r8 = r3.V()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r14 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r14
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$VideoStepState r9 = r14.V()
            if (r8 != r9) goto L_0x0161
            boolean r8 = r3.S()
            boolean r14 = r14.S()
            if (r8 == r14) goto L_0x0164
        L_0x0161:
            r12.startBottomAnimation(r3)
        L_0x0164:
            android.view.View r14 = r12.getRemoteVideoContainer()
            if (r14 == 0) goto L_0x0177
            int r14 = r14.getVisibility()
            if (r14 != 0) goto L_0x0172
            r14 = r5
            goto L_0x0173
        L_0x0172:
            r14 = r6
        L_0x0173:
            if (r14 != 0) goto L_0x0177
            r14 = r5
            goto L_0x0178
        L_0x0177:
            r14 = r6
        L_0x0178:
            com.sumsub.sns.internal.videoident.presentation.e r8 = r3.O()
            if (r8 == 0) goto L_0x0180
            r8 = r5
            goto L_0x0181
        L_0x0180:
            r8 = r6
        L_0x0181:
            android.view.View r9 = r12.getRemoteVideoContainer()
            if (r9 != 0) goto L_0x0188
            goto L_0x0190
        L_0x0188:
            if (r8 == 0) goto L_0x018c
            r10 = r6
            goto L_0x018d
        L_0x018c:
            r10 = r4
        L_0x018d:
            r9.setVisibility(r10)
        L_0x0190:
            com.twilio.video.VideoTextureView r9 = r12.getRemoteVideoView()
            if (r9 == 0) goto L_0x019b
            r12.updateRemoteVideoView(r3, r9, r8, r14)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x019b:
            android.widget.Button r14 = r12.getBottomPrimaryButton()
            if (r14 == 0) goto L_0x01a6
            r12.updateBottomPrimaryButton(r14, r3)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x01a6:
            android.widget.Button r14 = r12.getBottomSecondaryButton()
            if (r14 == 0) goto L_0x01d0
            java.lang.CharSequence r8 = r3.C()
            if (r8 == 0) goto L_0x01bb
            int r8 = r8.length()
            if (r8 != 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            r8 = r6
            goto L_0x01bc
        L_0x01bb:
            r8 = r5
        L_0x01bc:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r14, (boolean) r8)
            java.lang.CharSequence r8 = r3.C()
            r14.setText(r8)
            com.sumsub.sns.videoident.presentation.d r8 = new com.sumsub.sns.videoident.presentation.d
            r8.<init>(r12)
            r14.setOnClickListener(r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x01d0:
            android.widget.Button r14 = r12.getBottomTertiaryButton()
            if (r14 == 0) goto L_0x01fa
            java.lang.CharSequence r8 = r3.F()
            if (r8 == 0) goto L_0x01e5
            int r8 = r8.length()
            if (r8 != 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r8 = r6
            goto L_0x01e6
        L_0x01e5:
            r8 = r5
        L_0x01e6:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r14, (boolean) r8)
            java.lang.CharSequence r8 = r3.F()
            r14.setText(r8)
            com.sumsub.sns.videoident.presentation.c r8 = new com.sumsub.sns.videoident.presentation.c
            r8.<init>(r12)
            r14.setOnClickListener(r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x01fa:
            com.sumsub.sns.core.widget.SNSWarningView r14 = r12.getMessage()
            if (r14 == 0) goto L_0x0220
            java.lang.CharSequence r8 = r3.L()
            r14.setSubtitle(r8)
            com.sumsub.sns.internal.core.common.e0 r8 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r8 = r8.getIconHandler()
            android.content.Context r9 = r12.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r10 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.NOTIFY
            java.lang.String r10 = r10.getImageName()
            android.graphics.drawable.Drawable r8 = r8.onResolveIcon(r9, r10)
            r14.setIconStart(r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x0220:
            android.widget.TextView r14 = r12.getRecordTime()
            if (r14 != 0) goto L_0x0227
            goto L_0x0233
        L_0x0227:
            boolean r8 = r3.T()
            if (r8 == 0) goto L_0x022f
            r8 = r6
            goto L_0x0230
        L_0x022f:
            r8 = r4
        L_0x0230:
            r14.setVisibility(r8)
        L_0x0233:
            r12.updateRecordTimerText()
            android.view.ViewGroup r14 = r12.getDocumentList()
            if (r14 == 0) goto L_0x0249
            java.util.List r8 = r3.I()
            boolean r8 = r8.isEmpty()
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r14, (boolean) r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x0249:
            android.view.ViewGroup r14 = r12.getDocumentList()
            if (r14 == 0) goto L_0x026a
            r14.removeAllViews()
            java.util.List r8 = r3.I()
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r5
            if (r8 == 0) goto L_0x025e
            goto L_0x025f
        L_0x025e:
            r14 = r1
        L_0x025f:
            if (r14 == 0) goto L_0x026a
            java.util.List r8 = r3.I()
            r12.populateDocumentList(r14, r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x026a:
            java.lang.CharSequence r14 = r3.D()
            if (r14 == 0) goto L_0x0279
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0277
            goto L_0x0279
        L_0x0277:
            r14 = r6
            goto L_0x027a
        L_0x0279:
            r14 = r5
        L_0x027a:
            r14 = r14 ^ r5
            android.widget.TextView r8 = r12.getBottomText()
            if (r8 != 0) goto L_0x0282
            goto L_0x028a
        L_0x0282:
            if (r14 == 0) goto L_0x0286
            r9 = r6
            goto L_0x0287
        L_0x0286:
            r9 = r4
        L_0x0287:
            r8.setVisibility(r9)
        L_0x028a:
            android.widget.TextView r8 = r12.getBottomText()
            if (r8 != 0) goto L_0x0291
            goto L_0x02a4
        L_0x0291:
            java.lang.CharSequence r9 = r3.D()
            if (r9 == 0) goto L_0x02a0
            android.content.Context r10 = r12.requireContext()
            android.text.Spanned r9 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r9, (android.content.Context) r10)
            goto L_0x02a1
        L_0x02a0:
            r9 = r1
        L_0x02a1:
            r8.setText(r9)
        L_0x02a4:
            if (r14 == 0) goto L_0x02dd
            java.lang.CharSequence r14 = r3.E()
            if (r14 == 0) goto L_0x02b5
            int r14 = r14.length()
            if (r14 != 0) goto L_0x02b3
            goto L_0x02b5
        L_0x02b3:
            r14 = r6
            goto L_0x02b6
        L_0x02b5:
            r14 = r5
        L_0x02b6:
            if (r14 != 0) goto L_0x02c3
            android.content.res.Resources r14 = r12.getResources()
            int r8 = com.sumsub.sns.R.dimen.sns_margin_medium
            int r14 = r14.getDimensionPixelSize(r8)
            goto L_0x02c4
        L_0x02c3:
            r14 = r6
        L_0x02c4:
            android.widget.TextView r8 = r12.getBottomText()
            if (r8 == 0) goto L_0x02cf
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            goto L_0x02d0
        L_0x02cf:
            r8 = r1
        L_0x02d0:
            boolean r9 = r8 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r9 == 0) goto L_0x02d7
            android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
            goto L_0x02d8
        L_0x02d7:
            r8 = r1
        L_0x02d8:
            if (r8 != 0) goto L_0x02db
            goto L_0x02dd
        L_0x02db:
            r8.topMargin = r14
        L_0x02dd:
            android.widget.TextView r14 = r12.getBottomTitle()
            if (r14 == 0) goto L_0x02f8
            java.lang.CharSequence r8 = r3.E()
            if (r8 == 0) goto L_0x02f2
            int r8 = r8.length()
            if (r8 != 0) goto L_0x02f0
            goto L_0x02f2
        L_0x02f0:
            r8 = r6
            goto L_0x02f3
        L_0x02f2:
            r8 = r5
        L_0x02f3:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r14, (boolean) r8)
            kotlin.Unit r14 = kotlin.Unit.f56620a
        L_0x02f8:
            android.widget.TextView r14 = r12.getBottomTitle()
            if (r14 != 0) goto L_0x02ff
            goto L_0x0306
        L_0x02ff:
            java.lang.CharSequence r8 = r3.E()
            r14.setText(r8)
        L_0x0306:
            com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$serviceConnection$1 r14 = r12.serviceConnection
            boolean r14 = r14.getConnected()
            if (r14 != 0) goto L_0x0345
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r8 = "handleViewStateChange: localViewViewVisible="
            r14.append(r8)
            com.twilio.video.VideoView r8 = r12.getLocalVideoView()
            if (r8 == 0) goto L_0x032c
            int r8 = r8.getVisibility()
            if (r8 != 0) goto L_0x0326
            r8 = r5
            goto L_0x0327
        L_0x0326:
            r8 = r6
        L_0x0327:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x032d
        L_0x032c:
            r8 = r1
        L_0x032d:
            r14.append(r8)
            java.lang.String r8 = ", serviceConnected="
            r14.append(r8)
            com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$serviceConnection$1 r8 = r12.serviceConnection
            boolean r8 = r8.getConnected()
            r14.append(r8)
            java.lang.String r14 = r14.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r0, r14, r1, r2, r1)
        L_0x0345:
            boolean r13 = r13.getHasVideo()
            if (r13 == 0) goto L_0x036f
            com.twilio.video.VideoView r13 = r12.getLocalVideoView()
            if (r13 == 0) goto L_0x035e
            int r13 = r13.getVisibility()
            if (r13 != 0) goto L_0x0359
            r13 = r5
            goto L_0x035a
        L_0x0359:
            r13 = r6
        L_0x035a:
            if (r13 != 0) goto L_0x035e
            r13 = r5
            goto L_0x035f
        L_0x035e:
            r13 = r6
        L_0x035f:
            if (r13 != 0) goto L_0x0365
            com.sumsub.sns.internal.videoident.presentation.SNSViewState r13 = r12.currentViewState
            if (r13 != 0) goto L_0x036f
        L_0x0365:
            com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$serviceConnection$1 r13 = r12.serviceConnection
            boolean r13 = r13.getConnected()
            if (r13 != 0) goto L_0x036f
            r13 = r5
            goto L_0x0370
        L_0x036f:
            r13 = r6
        L_0x0370:
            if (r13 == 0) goto L_0x03a0
            com.twilio.video.VideoView r13 = r12.getLocalVideoView()
            if (r13 != 0) goto L_0x0379
            goto L_0x037c
        L_0x0379:
            r13.setVisibility(r4)
        L_0x037c:
            android.view.View r13 = r12.getSwitchCamera()
            if (r13 != 0) goto L_0x0383
            goto L_0x0386
        L_0x0383:
            r13.setVisibility(r4)
        L_0x0386:
            android.content.Intent r13 = new android.content.Intent
            android.content.Context r14 = r12.requireContext()
            java.lang.Class<com.sumsub.sns.videoident.service.SNSVideoChatService> r3 = com.sumsub.sns.videoident.service.SNSVideoChatService.class
            r13.<init>(r14, r3)
            java.lang.String r14 = "handleViewStateChange: connecting to service ..."
            com.sumsub.sns.internal.videoident.videoident.a.a(r0, r14, r1, r2, r1)
            androidx.fragment.app.FragmentActivity r14 = r12.requireActivity()
            com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$serviceConnection$1 r0 = r12.serviceConnection
            r14.bindService(r13, r0, r5)
            return
        L_0x03a0:
            android.view.ViewGroup r13 = r12.getPhotoPreviewContainer()
            if (r13 != 0) goto L_0x03a7
            goto L_0x03b8
        L_0x03a7:
            android.graphics.Bitmap r14 = r3.M()
            if (r14 == 0) goto L_0x03af
            r14 = r5
            goto L_0x03b0
        L_0x03af:
            r14 = r6
        L_0x03b0:
            if (r14 == 0) goto L_0x03b4
            r14 = r6
            goto L_0x03b5
        L_0x03b4:
            r14 = r4
        L_0x03b5:
            r13.setVisibility(r14)
        L_0x03b8:
            android.widget.ImageView r13 = r12.getPhotoPreview()
            if (r13 == 0) goto L_0x03c7
            android.graphics.Bitmap r14 = r3.M()
            com.sumsub.sns.internal.core.common.s0.a(r13, r14, r7)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x03c7:
            com.twilio.video.VideoView r13 = r12.getLocalVideoView()
            if (r13 != 0) goto L_0x03ce
            goto L_0x03da
        L_0x03ce:
            boolean r14 = r3.R()
            if (r14 == 0) goto L_0x03d6
            r14 = r6
            goto L_0x03d7
        L_0x03d6:
            r14 = r4
        L_0x03d7:
            r13.setVisibility(r14)
        L_0x03da:
            android.view.View r13 = r12.getSwitchCamera()
            if (r13 != 0) goto L_0x03e1
            goto L_0x03ed
        L_0x03e1:
            boolean r14 = r3.U()
            if (r14 == 0) goto L_0x03e9
            r14 = r6
            goto L_0x03ea
        L_0x03e9:
            r14 = r4
        L_0x03ea:
            r13.setVisibility(r14)
        L_0x03ed:
            android.view.ViewGroup r13 = r12.getBottomSheet()
            if (r13 != 0) goto L_0x03f4
            goto L_0x0400
        L_0x03f4:
            boolean r14 = r3.Q()
            if (r14 == 0) goto L_0x03fc
            r14 = r6
            goto L_0x03fd
        L_0x03fc:
            r14 = r4
        L_0x03fd:
            r13.setVisibility(r14)
        L_0x0400:
            android.view.ViewGroup r13 = r12.getBottomSheet()
            if (r13 != 0) goto L_0x0407
            goto L_0x0413
        L_0x0407:
            boolean r14 = r3.Q()
            if (r14 == 0) goto L_0x040f
            r14 = r6
            goto L_0x0410
        L_0x040f:
            r14 = r4
        L_0x0410:
            r13.setVisibility(r14)
        L_0x0413:
            android.view.View r13 = r12.getBottomProgressBar()
            if (r13 == 0) goto L_0x0423
            boolean r14 = r3.S()
            r14 = r14 ^ r5
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r13, (boolean) r14)
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x0423:
            com.sumsub.sns.core.widget.SNSWarningView r13 = r12.getBottomWarning()
            if (r13 != 0) goto L_0x042a
            goto L_0x0438
        L_0x042a:
            com.sumsub.sns.internal.videoident.presentation.k r14 = r3.G()
            if (r14 == 0) goto L_0x0431
            goto L_0x0432
        L_0x0431:
            r5 = r6
        L_0x0432:
            if (r5 == 0) goto L_0x0435
            r4 = r6
        L_0x0435:
            r13.setVisibility(r4)
        L_0x0438:
            com.sumsub.sns.internal.videoident.presentation.k r13 = r3.G()
            if (r13 == 0) goto L_0x047a
            com.sumsub.sns.core.widget.SNSWarningView r14 = r12.getBottomWarning()
            if (r14 != 0) goto L_0x0445
            goto L_0x045c
        L_0x0445:
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r2 = r12.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.NOTIFY
            java.lang.String r4 = r4.getImageName()
            android.graphics.drawable.Drawable r0 = r0.onResolveIcon(r2, r4)
            r14.setIconStart(r0)
        L_0x045c:
            com.sumsub.sns.core.widget.SNSWarningView r14 = r12.getBottomWarning()
            if (r14 != 0) goto L_0x0463
            goto L_0x046a
        L_0x0463:
            java.lang.CharSequence r0 = r13.d()
            r14.setTitle(r0)
        L_0x046a:
            com.sumsub.sns.core.widget.SNSWarningView r14 = r12.getBottomWarning()
            if (r14 != 0) goto L_0x0471
            goto L_0x0478
        L_0x0471:
            java.lang.CharSequence r13 = r13.c()
            r14.setSubtitle(r13)
        L_0x0478:
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x047a:
            androidx.fragment.app.FragmentActivity r13 = r12.requireActivity()
            int r14 = androidx.appcompat.R$attr.actionBarSize
            com.sumsub.sns.internal.core.common.a.b(r13, r14)
            androidx.appcompat.app.AlertDialog r13 = r12.exitConfirmationDialog
            if (r13 != 0) goto L_0x0491
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r13 = r3.H()
            if (r13 == 0) goto L_0x0491
            r12.showExitConfirmationState(r3)
            goto L_0x04a2
        L_0x0491:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r13 = r3.H()
            if (r13 != 0) goto L_0x04a2
            androidx.appcompat.app.AlertDialog r13 = r12.exitConfirmationDialog
            if (r13 == 0) goto L_0x04a0
            r13.dismiss()
            kotlin.Unit r13 = kotlin.Unit.f56620a
        L_0x04a0:
            r12.exitConfirmationDialog = r1
        L_0x04a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment.handleState(com.sumsub.sns.internal.videoident.presentation.SNSViewState, android.os.Bundle):void");
    }
}
