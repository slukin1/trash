package com.sumsub.sns.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.camera.core.CameraInfo;
import androidx.fragment.app.Fragment;
import com.google.android.gms.security.ProviderInstaller;
import com.sumsub.log.logger.Logger;
import com.sumsub.sentry.c0;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSDefaultIconHandler;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.listener.SNSUrlHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSDocumentDefinition;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSInitConfig;
import com.sumsub.sns.core.data.model.SNSInvalidParametersException;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.theme.SNSCustomizationFileFormat;
import com.sumsub.sns.core.theme.SNSJsonCustomization;
import com.sumsub.sns.core.theme.SNSTheme;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.analytics.b;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.g0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q0;
import com.sumsub.sns.internal.core.common.u0;
import com.sumsub.sns.internal.core.common.w0;
import com.sumsub.sns.internal.core.common.x;
import com.sumsub.sns.internal.core.data.model.LogParams;
import com.sumsub.sns.internal.core.theme.c;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.log.a;
import com.sumsub.sns.internal.log.cacher.e;
import com.sumsub.sns.internal.log.logger.d;
import com.sumsub.sns.prooface.SNSProoface;
import d10.l;
import d10.p;
import d10.t;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.n1;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004qrstB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010g\u001a\u0004\u0018\u00010;2\u0006\u0010h\u001a\u00020?H\u0001J\u0010\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0004H\u0002J\u0010\u0010l\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0004H\u0002J\u0011\u0010m\u001a\u00020.2\u0006\u0010h\u001a\u00020?H\u0001J\u0006\u0010n\u001a\u00020jJ\u0010\u0010o\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0004H\u0002J\b\u0010p\u001a\u00020?H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\"X\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010*X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020.X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010/R\u0012\u00100\u001a\u000201X\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u001e\u00106\u001a\u0002052\u0006\u00104\u001a\u000205@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020;0:8BX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR \u0010B\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020D\u0018\u00010CX\u0005¢\u0006\u0006\u001a\u0004\bE\u0010FR \u0010G\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010CX\u0005¢\u0006\u0006\u001a\u0004\bH\u0010FR\u0012\u0010I\u001a\u00020JX\u0005¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u0004\u0018\u00010NX\u0005¢\u0006\u0006\u001a\u0004\bO\u0010PR \u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010:X\u000f¢\u0006\f\u001a\u0004\bS\u0010=\"\u0004\bT\u0010UR\u001e\u0010V\u001a\u00020\n2\u0006\u00104\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u0004\u0018\u00010ZX\u0005¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u0004\u0018\u00010^X\u0005¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0012\u0010a\u001a\u00020?X\u0005¢\u0006\u0006\u001a\u0004\bb\u0010AR\u0012\u0010c\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\bd\u0010XR\u0012\u0010e\u001a\u00020?X\u0005¢\u0006\u0006\u001a\u0004\bf\u0010A¨\u0006u"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK;", "Lcom/sumsub/sns/core/MobileSdk;", "()V", "_sdk", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "actionResultHandler", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "autoCloseOnApproveTimeout", "", "getAutoCloseOnApproveTimeout", "()Ljava/lang/Integer;", "completeHandler", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "conf", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "getConf", "()Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "countryPicker", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "getCountryPicker", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "customization", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "getCustomization", "()Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "errorHandler", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "eventHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "iconHandler", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "getIconHandler", "()Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "instructionsViewHandler", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "getInstructionsViewHandler", "()Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "isDebug", "", "()Z", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "<set-?>", "Lcom/sumsub/log/logger/Logger;", "logTree", "getLogTree", "()Lcom/sumsub/log/logger/Logger;", "modules", "", "Lcom/sumsub/sns/core/SNSModule;", "getModules", "()Ljava/util/List;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "preferredDocumentsDefinitions", "", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "getPreferredDocumentsDefinitions", "()Ljava/util/Map;", "settings", "getSettings", "state", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "getState", "()Lcom/sumsub/sns/core/data/model/SNSSDKState;", "stateChangedHandler", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "supportItems", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "getSupportItems", "setSupportItems", "(Ljava/util/List;)V", "theme", "getTheme", "()I", "tokenExpirationHandler", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getTokenExpirationHandler", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "urlHandler", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "getUrlHandler", "()Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "version", "getVersion", "versionCode", "getVersionCode", "versionName", "getVersionName", "getPluggedModule", "className", "initFeatures", "", "sdk", "initLogger", "isModuleAvailable", "shutdown", "start", "toString", "Builder", "SDK", "SNSExceptionHandler", "SNSSDK", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSMobileSDK implements MobileSdk {
    public static final SNSMobileSDK INSTANCE = new SNSMobileSDK();
    /* access modifiers changed from: private */
    public static SDK _sdk;
    private static Logger logTree = d.f34907a;
    private static int theme = R.style.Theme_SNSCore;
    private final /* synthetic */ e0 $$delegate_0 = e0.f32018a;

    @Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u001c\u0012\u0007\u0010½\u0001\u001a\u00020c\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001B\u0014\b\u0016\u0012\u0007\u0010½\u0001\u001a\u00020c¢\u0006\u0006\b¾\u0001\u0010À\u0001J\u001a\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004Jî\u0001\u0010\u001a\u001a\u00020\u00002\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u001e\b\u0002\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072<\b\u0002\u0010\u0017\u001a6\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00142\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000bJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!J\u0010\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010)\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010'J\u0014\u0010-\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u0014\u00100\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*J\u000e\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0018J\u000e\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u000205J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u000208J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020;J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>J\u0010\u0010C\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010AJ\u0010\u0010F\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010DJ\u0010\u0010I\u001a\u00020\u00002\b\u0010H\u001a\u0004\u0018\u00010GJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0002J\u0016\u0010O\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00022\u0006\u0010N\u001a\u00020MJ\"\u0010R\u001a\u00020\u00002\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010P2\u0006\u0010N\u001a\u00020MJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020SJ\u0016\u0010O\u001a\u00020\u00002\u0006\u0010U\u001a\u00020T2\u0006\u0010N\u001a\u00020MJ\u001c\u0010W\u001a\u00020\u00002\u0014\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010PJ\u001c\u0010Z\u001a\u00020\u00002\u0014\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020X\u0018\u00010PJ\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020>J\u0010\u0010_\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010]J\u0006\u0010a\u001a\u00020`R \u0010d\u001a\b\u0012\u0004\u0012\u00020c0b8\u0000X\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR$\u0010J\u001a\u00020\u00022\u0006\u0010h\u001a\u00020\u00028\u0000@BX\u000e¢\u0006\f\n\u0004\bJ\u0010i\u001a\u0004\bj\u0010kR(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010h\u001a\u0004\u0018\u00010\u00028\u0000@BX\u000e¢\u0006\f\n\u0004\b\u0003\u0010i\u001a\u0004\bl\u0010kR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010h\u001a\u0004\u0018\u00010\u00048\u0000@BX\u000e¢\u0006\f\n\u0004\b\u0005\u0010m\u001a\u0004\bn\u0010oR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010h\u001a\u0004\u0018\u00010\u001b8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u001c\u0010p\u001a\u0004\bq\u0010rR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010h\u001a\u0004\u0018\u00010\u001e8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010s\u001a\u0004\bt\u0010uR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010h\u001a\u0004\u0018\u00010!8\u0000@BX\u000e¢\u0006\f\n\u0004\b\"\u0010v\u001a\u0004\bw\u0010xR(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010h\u001a\u0004\u0018\u00010$8\u0000@BX\u000e¢\u0006\f\n\u0004\b%\u0010y\u001a\u0004\bz\u0010{R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010h\u001a\u0004\u0018\u00010'8\u0000@BX\u000e¢\u0006\f\n\u0004\b(\u0010|\u001a\u0004\b}\u0010~R)\u0010\u001a\u0004\u0018\u00010D8\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010H\u001a\u0004\u0018\u00010G8\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\bH\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R+\u00106\u001a\u0004\u0018\u0001052\b\u0010h\u001a\u0004\u0018\u0001058\u0000@BX\u000e¢\u0006\u000f\n\u0005\b6\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R'\u00103\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00188\u0000@BX\u000e¢\u0006\u000f\n\u0005\b3\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R)\u0010B\u001a\u0004\u0018\u00010A8\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\bB\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R3\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020+0*8\u0000@BX\u000e¢\u0006\u000f\n\u0005\b,\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R9\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010*2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010*8\u0000@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00188\u0000@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R'\u00109\u001a\u0002082\u0006\u0010h\u001a\u0002088\u0000@BX\u000e¢\u0006\u000f\n\u0005\b9\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R'\u0010<\u001a\u00020;2\u0006\u0010h\u001a\u00020;8\u0000@BX\u000e¢\u0006\u000f\n\u0005\b<\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001R+\u0010?\u001a\u0004\u0018\u00010>2\b\u0010h\u001a\u0004\u0018\u00010>8\u0000@BX\u000e¢\u0006\u000f\n\u0005\b?\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R,\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R5\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010P8\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\bV\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R7\u0010±\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020X\u0018\u00010P8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010¬\u0001\u001a\u0006\b²\u0001\u0010®\u0001\"\u0006\b³\u0001\u0010°\u0001R+\u0010´\u0001\u001a\u0004\u0018\u00010>8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010¢\u0001\u001a\u0006\bµ\u0001\u0010¤\u0001\"\u0006\b¶\u0001\u0010·\u0001R)\u0010^\u001a\u0004\u0018\u00010]8\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\b^\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001¨\u0006Á\u0001"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "", "", "accessToken", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "onTokenExpiration", "withAccessToken", "Lkotlin/Function1;", "Lcom/sumsub/sns/core/data/model/SNSException;", "", "onError", "Lkotlin/Function2;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "onStateChanged", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCompleted", "Lcom/sumsub/sns/core/SNSActionResult;", "onActionResult", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "onEvent", "Lkotlin/Function6;", "Landroid/content/Context;", "Landroid/view/View;", "onSNSInstructionsView", "", "onUrl", "withHandlers", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "stateChangedHandler", "withStateChangedHandler", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "completeHandler", "withCompleteHandler", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "errorHandler", "withErrorHandler", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "actionResultHandler", "withActionResultHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "eventHandler", "withEventHandler", "", "Lcom/sumsub/sns/core/SNSModule;", "modules", "withModules", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "items", "withSupportItems", "debug", "withDebug", "isAnalyticsEnabled", "withAnalyticsEnabled", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "conf", "withConf", "Lcom/sumsub/log/logger/Logger;", "logTree", "withLogTree", "Ljava/util/Locale;", "locale", "withLocale", "", "theme", "withTheme", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "iconHandler", "withIconHandler", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "instructionsViewHandler", "withInstructionsViewHandler", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "countryPicker", "withCountryPicker", "url", "withBaseUrl", "json", "Lcom/sumsub/sns/core/theme/SNSCustomizationFileFormat;", "format", "withJsonTheme", "", "map", "withMappedTheme", "Lcom/sumsub/sns/core/theme/SNSTheme;", "Lorg/json/JSONObject;", "jsonObject", "settings", "withSettings", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "definitions", "withPreferredDocumentDefinitions", "timeInSecs", "withAutoCloseOnApprove", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "urlHandler", "withUrlHandler", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "build", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "weakActivity", "Ljava/lang/ref/WeakReference;", "getWeakActivity$idensic_mobile_sdk_aar_release", "()Ljava/lang/ref/WeakReference;", "<set-?>", "Ljava/lang/String;", "getUrl$idensic_mobile_sdk_aar_release", "()Ljava/lang/String;", "getAccessToken$idensic_mobile_sdk_aar_release", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getOnTokenExpiration$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "instructionsHandler", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "getInstructionsHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "setInstructionsHandler$idensic_mobile_sdk_aar_release", "(Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;)V", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "getCountryPicker$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "setCountryPicker$idensic_mobile_sdk_aar_release", "(Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;)V", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "getConf$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "Z", "isAnalyticsEnabled$idensic_mobile_sdk_aar_release", "()Z", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "getIconHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "setIconHandler$idensic_mobile_sdk_aar_release", "(Lcom/sumsub/sns/core/data/listener/SNSIconHandler;)V", "Ljava/util/List;", "getModules$idensic_mobile_sdk_aar_release", "()Ljava/util/List;", "supportItems", "getSupportItems$idensic_mobile_sdk_aar_release", "isDebug", "isDebug$idensic_mobile_sdk_aar_release", "Lcom/sumsub/log/logger/Logger;", "getLogTree$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/log/logger/Logger;", "Ljava/util/Locale;", "getLocale$idensic_mobile_sdk_aar_release", "()Ljava/util/Locale;", "Ljava/lang/Integer;", "getTheme$idensic_mobile_sdk_aar_release", "()Ljava/lang/Integer;", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "customization", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "getCustomization$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "setCustomization$idensic_mobile_sdk_aar_release", "(Lcom/sumsub/sns/core/theme/SNSJsonCustomization;)V", "Ljava/util/Map;", "getSettings$idensic_mobile_sdk_aar_release", "()Ljava/util/Map;", "setSettings$idensic_mobile_sdk_aar_release", "(Ljava/util/Map;)V", "preferredDocumentsDefinitions", "getPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release", "setPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release", "autoCloseOnApproveTimeout", "getAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release", "setAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release", "(Ljava/lang/Integer;)V", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "getUrlHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "setUrlHandler$idensic_mobile_sdk_aar_release", "(Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;)V", "activity", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "(Landroid/app/Activity;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Builder {
        private String accessToken;
        private SNSActionResultHandler actionResultHandler;
        private Integer autoCloseOnApproveTimeout;
        private SNSCompleteHandler completeHandler;
        private SNSInitConfig conf;
        private SNSCountryPicker countryPicker;
        private SNSJsonCustomization customization;
        private SNSErrorHandler errorHandler;
        private SNSEventHandler eventHandler;
        private SNSIconHandler iconHandler;
        private SNSInstructionsViewHandler instructionsHandler;
        private boolean isAnalyticsEnabled;
        private boolean isDebug;
        private Locale locale;
        private Logger logTree;
        private List<? extends SNSModule> modules;
        private TokenExpirationHandler onTokenExpiration;
        private Map<String, SNSDocumentDefinition> preferredDocumentsDefinitions;
        private Map<String, String> settings;
        private SNSStateChangedHandler stateChangedHandler;
        private List<SNSSupportItem> supportItems;
        private Integer theme;
        private String url;
        private SNSUrlHandler urlHandler;
        private final WeakReference<Activity> weakActivity;

        public Builder(Activity activity, String str) {
            SNSMobileSDK.INSTANCE.isDebug();
            this.weakActivity = new WeakReference<>(activity);
            this.url = str == null ? "https://api.sumsub.com/" : str;
            this.isAnalyticsEnabled = true;
            this.iconHandler = new SNSDefaultIconHandler();
            this.modules = CollectionsKt__CollectionsKt.k();
            this.logTree = d.f34907a;
            this.locale = i.a();
        }

        public static /* synthetic */ Builder withAccessToken$default(Builder builder, String str, TokenExpirationHandler tokenExpirationHandler, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            return builder.withAccessToken(str, tokenExpirationHandler);
        }

        public static /* synthetic */ Builder withHandlers$default(Builder builder, l lVar, p pVar, p pVar2, p pVar3, l lVar2, t tVar, p pVar4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                lVar = null;
            }
            if ((i11 & 2) != 0) {
                pVar = null;
            }
            if ((i11 & 4) != 0) {
                pVar2 = null;
            }
            if ((i11 & 8) != 0) {
                pVar3 = null;
            }
            if ((i11 & 16) != 0) {
                lVar2 = null;
            }
            if ((i11 & 32) != 0) {
                tVar = null;
            }
            if ((i11 & 64) != 0) {
                pVar4 = null;
            }
            return builder.withHandlers(lVar, pVar, pVar2, pVar3, lVar2, tVar, pVar4);
        }

        public final SDK build() throws SNSInvalidParametersException {
            return new SNSSDK(this);
        }

        public final String getAccessToken$idensic_mobile_sdk_aar_release() {
            return this.accessToken;
        }

        public final SNSActionResultHandler getActionResultHandler$idensic_mobile_sdk_aar_release() {
            return this.actionResultHandler;
        }

        public final Integer getAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release() {
            return this.autoCloseOnApproveTimeout;
        }

        public final SNSCompleteHandler getCompleteHandler$idensic_mobile_sdk_aar_release() {
            return this.completeHandler;
        }

        public final SNSInitConfig getConf$idensic_mobile_sdk_aar_release() {
            return this.conf;
        }

        public final SNSCountryPicker getCountryPicker$idensic_mobile_sdk_aar_release() {
            return this.countryPicker;
        }

        public final SNSJsonCustomization getCustomization$idensic_mobile_sdk_aar_release() {
            return this.customization;
        }

        public final SNSErrorHandler getErrorHandler$idensic_mobile_sdk_aar_release() {
            return this.errorHandler;
        }

        public final SNSEventHandler getEventHandler$idensic_mobile_sdk_aar_release() {
            return this.eventHandler;
        }

        public final SNSIconHandler getIconHandler$idensic_mobile_sdk_aar_release() {
            return this.iconHandler;
        }

        public final SNSInstructionsViewHandler getInstructionsHandler$idensic_mobile_sdk_aar_release() {
            return this.instructionsHandler;
        }

        public final Locale getLocale$idensic_mobile_sdk_aar_release() {
            return this.locale;
        }

        public final Logger getLogTree$idensic_mobile_sdk_aar_release() {
            return this.logTree;
        }

        public final List<SNSModule> getModules$idensic_mobile_sdk_aar_release() {
            return this.modules;
        }

        public final TokenExpirationHandler getOnTokenExpiration$idensic_mobile_sdk_aar_release() {
            return this.onTokenExpiration;
        }

        public final Map<String, SNSDocumentDefinition> getPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release() {
            return this.preferredDocumentsDefinitions;
        }

        public final Map<String, String> getSettings$idensic_mobile_sdk_aar_release() {
            return this.settings;
        }

        public final SNSStateChangedHandler getStateChangedHandler$idensic_mobile_sdk_aar_release() {
            return this.stateChangedHandler;
        }

        public final List<SNSSupportItem> getSupportItems$idensic_mobile_sdk_aar_release() {
            return this.supportItems;
        }

        public final Integer getTheme$idensic_mobile_sdk_aar_release() {
            return this.theme;
        }

        public final String getUrl$idensic_mobile_sdk_aar_release() {
            return this.url;
        }

        public final SNSUrlHandler getUrlHandler$idensic_mobile_sdk_aar_release() {
            return this.urlHandler;
        }

        public final WeakReference<Activity> getWeakActivity$idensic_mobile_sdk_aar_release() {
            return this.weakActivity;
        }

        public final boolean isAnalyticsEnabled$idensic_mobile_sdk_aar_release() {
            return this.isAnalyticsEnabled;
        }

        public final boolean isDebug$idensic_mobile_sdk_aar_release() {
            return this.isDebug;
        }

        public final void setAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release(Integer num) {
            this.autoCloseOnApproveTimeout = num;
        }

        public final void setCountryPicker$idensic_mobile_sdk_aar_release(SNSCountryPicker sNSCountryPicker) {
            this.countryPicker = sNSCountryPicker;
        }

        public final void setCustomization$idensic_mobile_sdk_aar_release(SNSJsonCustomization sNSJsonCustomization) {
            this.customization = sNSJsonCustomization;
        }

        public final void setIconHandler$idensic_mobile_sdk_aar_release(SNSIconHandler sNSIconHandler) {
            this.iconHandler = sNSIconHandler;
        }

        public final void setInstructionsHandler$idensic_mobile_sdk_aar_release(SNSInstructionsViewHandler sNSInstructionsViewHandler) {
            this.instructionsHandler = sNSInstructionsViewHandler;
        }

        public final void setPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release(Map<String, SNSDocumentDefinition> map) {
            this.preferredDocumentsDefinitions = map;
        }

        public final void setSettings$idensic_mobile_sdk_aar_release(Map<String, String> map) {
            this.settings = map;
        }

        public final void setUrlHandler$idensic_mobile_sdk_aar_release(SNSUrlHandler sNSUrlHandler) {
            this.urlHandler = sNSUrlHandler;
        }

        public final Builder withAccessToken(String str, TokenExpirationHandler tokenExpirationHandler) {
            this.accessToken = str;
            this.onTokenExpiration = tokenExpirationHandler;
            return this;
        }

        public final Builder withActionResultHandler(SNSActionResultHandler sNSActionResultHandler) {
            this.actionResultHandler = sNSActionResultHandler;
            return this;
        }

        public final Builder withAnalyticsEnabled(boolean z11) {
            this.isAnalyticsEnabled = z11;
            return this;
        }

        public final Builder withAutoCloseOnApprove(int i11) {
            this.autoCloseOnApproveTimeout = Integer.valueOf(i11);
            return this;
        }

        public final Builder withBaseUrl(String str) {
            this.url = str;
            return this;
        }

        public final Builder withCompleteHandler(SNSCompleteHandler sNSCompleteHandler) {
            this.completeHandler = sNSCompleteHandler;
            return this;
        }

        public final Builder withConf(SNSInitConfig sNSInitConfig) {
            this.conf = sNSInitConfig;
            return this;
        }

        public final Builder withCountryPicker(SNSCountryPicker sNSCountryPicker) {
            this.countryPicker = sNSCountryPicker;
            return this;
        }

        public final Builder withDebug(boolean z11) {
            this.isDebug = z11;
            return this;
        }

        public final Builder withErrorHandler(SNSErrorHandler sNSErrorHandler) {
            this.errorHandler = sNSErrorHandler;
            return this;
        }

        public final Builder withEventHandler(SNSEventHandler sNSEventHandler) {
            this.eventHandler = sNSEventHandler;
            return this;
        }

        public final Builder withHandlers(l<? super SNSException, Unit> lVar, p<? super SNSSDKState, ? super SNSSDKState, Unit> pVar, p<? super SNSCompletionResult, ? super SNSSDKState, Unit> pVar2, p<? super String, ? super String, ? extends SNSActionResult> pVar3, l<? super SNSEvent, Unit> lVar2, t<? super Context, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends View> tVar, p<? super Context, ? super String, Boolean> pVar4) {
            SNSMobileSDK$Builder$withHandlers$1$7$1 sNSMobileSDK$Builder$withHandlers$1$7$1 = null;
            this.errorHandler = lVar != null ? new SNSMobileSDK$Builder$withHandlers$1$1$1(lVar) : null;
            this.stateChangedHandler = pVar != null ? new SNSMobileSDK$Builder$withHandlers$1$2$1(pVar) : null;
            this.completeHandler = pVar2 != null ? new SNSMobileSDK$Builder$withHandlers$1$3$1(pVar2) : null;
            this.actionResultHandler = pVar3 != null ? new SNSMobileSDK$Builder$withHandlers$1$4$1(pVar3) : null;
            this.eventHandler = lVar2 != null ? new SNSMobileSDK$Builder$withHandlers$1$5$1(lVar2) : null;
            this.instructionsHandler = tVar != null ? new SNSMobileSDK$Builder$withHandlers$1$6$1(tVar) : null;
            if (pVar4 != null) {
                sNSMobileSDK$Builder$withHandlers$1$7$1 = new SNSMobileSDK$Builder$withHandlers$1$7$1(pVar4);
            }
            this.urlHandler = sNSMobileSDK$Builder$withHandlers$1$7$1;
            return this;
        }

        public final Builder withIconHandler(SNSIconHandler sNSIconHandler) {
            this.iconHandler = sNSIconHandler;
            return this;
        }

        public final Builder withInstructionsViewHandler(SNSInstructionsViewHandler sNSInstructionsViewHandler) {
            this.instructionsHandler = sNSInstructionsViewHandler;
            return this;
        }

        public final Builder withJsonTheme(String str, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
            SNSJsonCustomization create = SNSJsonCustomization.Companion.create();
            create.loadTheme(x.a(false, 1, (Object) null), str, sNSCustomizationFileFormat);
            this.customization = create;
            return this;
        }

        public final Builder withLocale(Locale locale2) {
            this.locale = locale2;
            return this;
        }

        public final Builder withLogTree(Logger logger) {
            this.logTree = logger;
            return this;
        }

        public final Builder withMappedTheme(Map<String, ? extends Object> map, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
            SNSJsonCustomization create = SNSJsonCustomization.Companion.create();
            create.loadTheme(map, sNSCustomizationFileFormat);
            this.customization = create;
            return this;
        }

        public final Builder withModules(List<? extends SNSModule> list) {
            this.modules = list;
            return this;
        }

        public final Builder withPreferredDocumentDefinitions(Map<String, SNSDocumentDefinition> map) {
            this.preferredDocumentsDefinitions = map;
            return this;
        }

        public final Builder withSettings(Map<String, String> map) {
            this.settings = map;
            return this;
        }

        public final Builder withStateChangedHandler(SNSStateChangedHandler sNSStateChangedHandler) {
            this.stateChangedHandler = sNSStateChangedHandler;
            return this;
        }

        public final Builder withSupportItems(List<SNSSupportItem> list) {
            this.supportItems = list;
            return this;
        }

        public final Builder withTheme(int i11) {
            this.theme = Integer.valueOf(i11);
            return this;
        }

        public final Builder withUrlHandler(SNSUrlHandler sNSUrlHandler) {
            this.urlHandler = sNSUrlHandler;
            return this;
        }

        public final Builder withTheme(SNSTheme sNSTheme) {
            SNSJsonCustomization create = SNSJsonCustomization.Companion.create();
            create.loadTheme(sNSTheme);
            this.customization = create;
            return this;
        }

        public final Builder withJsonTheme(JSONObject jSONObject, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
            try {
                SNSJsonCustomization create = SNSJsonCustomization.Companion.create();
                create.loadTheme(c.a(jSONObject), sNSCustomizationFileFormat);
                this.customization = create;
            } catch (Exception e11) {
                a.f34862a.e(b.f30747a, "Can't parse theme", e11);
            }
            return this;
        }

        public Builder(Activity activity) {
            this(activity, (String) null);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0013\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0017J\u0006\u0010\r\u001a\u00020\u000bJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\u0010R \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00028\u0000X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R*\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0000X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u0001018\u0000X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u0001068\u0000X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010;8\u0000X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0000X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010F\u001a\u0004\u0018\u00010E8\u0000X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0000X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0000X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010U\u001a\u00020T8\u0000X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020T8\u0000X\u0004¢\u0006\f\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010XR\u001a\u0010\\\u001a\u00020[8\u0000X\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010a\u001a\u00020`8\u0000X\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001c\u0010f\u001a\u0004\u0018\u00010e8\u0000X\u0004¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001c\u0010k\u001a\u0004\u0018\u00010j8\u0000X\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001c\u0010p\u001a\u0004\u0018\u00010o8\u0000X\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR(\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010t8\u0000X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR(\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020y\u0018\u00010t8\u0000X\u0004¢\u0006\f\n\u0004\bz\u0010v\u001a\u0004\b{\u0010xR\u001c\u0010|\u001a\u0004\u0018\u00010j8\u0000X\u0004¢\u0006\f\n\u0004\b|\u0010l\u001a\u0004\b}\u0010nR\u001f\u0010\u001a\u0004\u0018\u00010~8\u0000X\u0004¢\u0006\u000f\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "", "", "", "isParametersValid", "Landroid/content/Context;", "context", "Ljava/lang/Thread$UncaughtExceptionHandler;", "prevExceptionHandler", "Lcom/sumsub/sentry/c0;", "createSentryErrorHandler", "", "launch", "dismiss", "apiUrl", "installUncaughtExceptionHandler$idensic_mobile_sdk_aar_release", "(Ljava/lang/String;)V", "installUncaughtExceptionHandler", "removeUncaughtExceptionHandler$idensic_mobile_sdk_aar_release", "()V", "removeUncaughtExceptionHandler", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "weakActivity", "Ljava/lang/ref/WeakReference;", "getWeakActivity$idensic_mobile_sdk_aar_release", "()Ljava/lang/ref/WeakReference;", "url", "Ljava/lang/String;", "getUrl$idensic_mobile_sdk_aar_release", "()Ljava/lang/String;", "accessToken", "getAccessToken$idensic_mobile_sdk_aar_release", "setAccessToken$idensic_mobile_sdk_aar_release", "Lcom/sumsub/sns/core/SNSModule;", "modules", "Ljava/util/List;", "getModules$idensic_mobile_sdk_aar_release", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "supportItems", "getSupportItems$idensic_mobile_sdk_aar_release", "setSupportItems$idensic_mobile_sdk_aar_release", "(Ljava/util/List;)V", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "onTokenExpiration", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getOnTokenExpiration$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "completeHandler", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "errorHandler", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "actionResultHandler", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "eventHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "iconHandler", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "getIconHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "instructionsViewHandler", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "getInstructionsViewHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "countryPicker", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "getCountryPicker$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "", "isDebug", "Z", "isDebug$idensic_mobile_sdk_aar_release", "()Z", "isAnalyticsEnabled", "isAnalyticsEnabled$idensic_mobile_sdk_aar_release", "Lcom/sumsub/log/logger/Logger;", "logTree", "Lcom/sumsub/log/logger/Logger;", "getLogTree$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/log/logger/Logger;", "Ljava/util/Locale;", "locale", "Ljava/util/Locale;", "getLocale$idensic_mobile_sdk_aar_release", "()Ljava/util/Locale;", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "conf", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "getConf$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "", "theme", "Ljava/lang/Integer;", "getTheme$idensic_mobile_sdk_aar_release", "()Ljava/lang/Integer;", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "customization", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "getCustomization$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "", "settings", "Ljava/util/Map;", "getSettings$idensic_mobile_sdk_aar_release", "()Ljava/util/Map;", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "preferredDocumentsDefinitions", "getPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release", "autoCloseOnApproveTimeout", "getAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "snsUrlHandler", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "getSnsUrlHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "exceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "builder", "<init>", "(Lcom/sumsub/sns/core/SNSMobileSDK$Builder;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class SDK {
        private String accessToken;
        private final SNSActionResultHandler actionResultHandler;
        private final Integer autoCloseOnApproveTimeout;
        private final SNSCompleteHandler completeHandler;
        private final SNSInitConfig conf;
        private final SNSCountryPicker countryPicker;
        private final SNSJsonCustomization customization;
        private final SNSErrorHandler errorHandler;
        private final SNSEventHandler eventHandler;
        private Thread.UncaughtExceptionHandler exceptionHandler;
        private final SNSIconHandler iconHandler;
        private final SNSInstructionsViewHandler instructionsViewHandler;
        private final boolean isAnalyticsEnabled;
        private final boolean isDebug;
        private final Locale locale;
        private final Logger logTree;
        private final List<SNSModule> modules;
        private final TokenExpirationHandler onTokenExpiration;
        private final Map<String, SNSDocumentDefinition> preferredDocumentsDefinitions;
        private final Map<String, String> settings;
        private final SNSUrlHandler snsUrlHandler;
        private List<SNSSupportItem> supportItems;
        private final Integer theme;
        private final String url;
        private final WeakReference<Activity> weakActivity;

        public SDK(Builder builder) {
            String str;
            Context applicationContext;
            String c11;
            this.weakActivity = builder.getWeakActivity$idensic_mobile_sdk_aar_release();
            String str2 = null;
            if (StringsKt__StringsKt.W(builder.getUrl$idensic_mobile_sdk_aar_release(), '/', false, 2, (Object) null)) {
                str = builder.getUrl$idensic_mobile_sdk_aar_release();
            } else {
                str = builder.getUrl$idensic_mobile_sdk_aar_release() + '/';
            }
            this.url = str;
            this.accessToken = builder.getAccessToken$idensic_mobile_sdk_aar_release();
            this.modules = builder.getModules$idensic_mobile_sdk_aar_release();
            this.supportItems = builder.getSupportItems$idensic_mobile_sdk_aar_release();
            this.onTokenExpiration = builder.getOnTokenExpiration$idensic_mobile_sdk_aar_release();
            this.completeHandler = builder.getCompleteHandler$idensic_mobile_sdk_aar_release();
            this.errorHandler = builder.getErrorHandler$idensic_mobile_sdk_aar_release();
            this.actionResultHandler = builder.getActionResultHandler$idensic_mobile_sdk_aar_release();
            this.eventHandler = builder.getEventHandler$idensic_mobile_sdk_aar_release();
            this.iconHandler = builder.getIconHandler$idensic_mobile_sdk_aar_release();
            this.instructionsViewHandler = builder.getInstructionsHandler$idensic_mobile_sdk_aar_release();
            this.countryPicker = builder.getCountryPicker$idensic_mobile_sdk_aar_release();
            this.isDebug = builder.isDebug$idensic_mobile_sdk_aar_release();
            this.isAnalyticsEnabled = builder.isAnalyticsEnabled$idensic_mobile_sdk_aar_release();
            this.logTree = builder.getLogTree$idensic_mobile_sdk_aar_release();
            this.locale = builder.getLocale$idensic_mobile_sdk_aar_release();
            this.conf = builder.getConf$idensic_mobile_sdk_aar_release();
            this.theme = builder.getTheme$idensic_mobile_sdk_aar_release();
            this.customization = builder.getCustomization$idensic_mobile_sdk_aar_release();
            this.settings = builder.getSettings$idensic_mobile_sdk_aar_release();
            this.preferredDocumentsDefinitions = builder.getPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release();
            this.autoCloseOnApproveTimeout = builder.getAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release();
            this.snsUrlHandler = builder.getUrlHandler$idensic_mobile_sdk_aar_release();
            List<String> isParametersValid = isParametersValid();
            if (!(!isParametersValid.isEmpty())) {
                Activity activity = builder.getWeakActivity$idensic_mobile_sdk_aar_release().get();
                Context applicationContext2 = activity != null ? activity.getApplicationContext() : null;
                e0 e0Var = e0.f32018a;
                str2 = applicationContext2 != null ? applicationContext2.getPackageName() : str2;
                String str3 = CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
                str2 = str2 == null ? str3 : str2;
                if (!(applicationContext2 == null || (c11 = i.c(applicationContext2)) == null)) {
                    str3 = c11;
                }
                e0Var.a(str2, str3, applicationContext2 != null ? i.b(applicationContext2) : -1);
                if (applicationContext2 != null && (applicationContext = applicationContext2.getApplicationContext()) != null) {
                    ProviderInstaller.installIfNeededAsync(applicationContext, new SNSMobileSDK$SDK$1$1());
                    return;
                }
                return;
            }
            throw new SNSInvalidParametersException(isParametersValid);
        }

        private final c0 createSentryErrorHandler(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            return new c0(context, new SNSMobileSDK$SDK$createSentryErrorHandler$1(context), uncaughtExceptionHandler);
        }

        private final List<String> isParametersValid() {
            ArrayList arrayList;
            ArrayList arrayList2 = new ArrayList();
            boolean z11 = false;
            if (this.url.length() == 0) {
                arrayList2.add("Api url must be non-empty. url=" + this.url);
            }
            if (!g0.c(this.url)) {
                arrayList2.add("Api url must be valid. url=" + this.url);
            }
            List<SNSSupportItem> list = this.supportItems;
            if (list != null) {
                arrayList = new ArrayList();
                for (SNSSupportItem isValid : list) {
                    String isValid2 = isValid.isValid();
                    if (isValid2 != null) {
                        arrayList.add(isValid2);
                    }
                }
            } else {
                arrayList = null;
            }
            ArrayList arrayList3 = arrayList;
            if (arrayList3 != null && (!arrayList3.isEmpty())) {
                z11 = true;
            }
            if (z11) {
                arrayList2.add("Support items have invalid support items. Why are support items invalid? (" + CollectionsKt___CollectionsKt.k0(arrayList3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SNSMobileSDK$SDK$isParametersValid$1.INSTANCE, 31, (Object) null) + ')');
            }
            return arrayList2;
        }

        public final void dismiss() {
            Activity activity = this.weakActivity.get();
            if (activity != null) {
                Intent intent = new Intent(n0.f.f32173d);
                intent.setPackage(SNSMobileSDK.INSTANCE.getPackageName());
                activity.sendBroadcast(intent);
            }
        }

        public final String getAccessToken$idensic_mobile_sdk_aar_release() {
            return this.accessToken;
        }

        public final SNSActionResultHandler getActionResultHandler$idensic_mobile_sdk_aar_release() {
            return this.actionResultHandler;
        }

        public final Integer getAutoCloseOnApproveTimeout$idensic_mobile_sdk_aar_release() {
            return this.autoCloseOnApproveTimeout;
        }

        public final SNSCompleteHandler getCompleteHandler$idensic_mobile_sdk_aar_release() {
            return this.completeHandler;
        }

        public final SNSInitConfig getConf$idensic_mobile_sdk_aar_release() {
            return this.conf;
        }

        public final SNSCountryPicker getCountryPicker$idensic_mobile_sdk_aar_release() {
            return this.countryPicker;
        }

        public final SNSJsonCustomization getCustomization$idensic_mobile_sdk_aar_release() {
            return this.customization;
        }

        public final SNSErrorHandler getErrorHandler$idensic_mobile_sdk_aar_release() {
            return this.errorHandler;
        }

        public final SNSEventHandler getEventHandler$idensic_mobile_sdk_aar_release() {
            return this.eventHandler;
        }

        public final SNSIconHandler getIconHandler$idensic_mobile_sdk_aar_release() {
            return this.iconHandler;
        }

        public final SNSInstructionsViewHandler getInstructionsViewHandler$idensic_mobile_sdk_aar_release() {
            return this.instructionsViewHandler;
        }

        public final Locale getLocale$idensic_mobile_sdk_aar_release() {
            return this.locale;
        }

        public final Logger getLogTree$idensic_mobile_sdk_aar_release() {
            return this.logTree;
        }

        public final List<SNSModule> getModules$idensic_mobile_sdk_aar_release() {
            return this.modules;
        }

        public final TokenExpirationHandler getOnTokenExpiration$idensic_mobile_sdk_aar_release() {
            return this.onTokenExpiration;
        }

        public final Map<String, SNSDocumentDefinition> getPreferredDocumentsDefinitions$idensic_mobile_sdk_aar_release() {
            return this.preferredDocumentsDefinitions;
        }

        public final Map<String, String> getSettings$idensic_mobile_sdk_aar_release() {
            return this.settings;
        }

        public final SNSUrlHandler getSnsUrlHandler$idensic_mobile_sdk_aar_release() {
            return this.snsUrlHandler;
        }

        public final List<SNSSupportItem> getSupportItems$idensic_mobile_sdk_aar_release() {
            return this.supportItems;
        }

        public final Integer getTheme$idensic_mobile_sdk_aar_release() {
            return this.theme;
        }

        public final String getUrl$idensic_mobile_sdk_aar_release() {
            return this.url;
        }

        public final WeakReference<Activity> getWeakActivity$idensic_mobile_sdk_aar_release() {
            return this.weakActivity;
        }

        public final void installUncaughtExceptionHandler$idensic_mobile_sdk_aar_release(String str) {
            Context applicationContext;
            this.exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Activity activity = this.weakActivity.get();
            if (activity != null && (applicationContext = activity.getApplicationContext()) != null) {
                e eVar = new e(new q0(applicationContext, str), applicationContext.getCacheDir());
                eVar.a("_SNSExceptionSink");
                com.sumsub.sns.internal.log.cacher.d.f34872a.a(eVar);
                Thread.setDefaultUncaughtExceptionHandler(createSentryErrorHandler(applicationContext, new SNSExceptionHandler(applicationContext, eVar, this.exceptionHandler)));
            }
        }

        public final boolean isAnalyticsEnabled$idensic_mobile_sdk_aar_release() {
            return this.isAnalyticsEnabled;
        }

        public final boolean isDebug$idensic_mobile_sdk_aar_release() {
            return this.isDebug;
        }

        public void launch() {
        }

        public final void removeUncaughtExceptionHandler$idensic_mobile_sdk_aar_release() {
            Thread.setDefaultUncaughtExceptionHandler(this.exceptionHandler);
        }

        public final void setAccessToken$idensic_mobile_sdk_aar_release(String str) {
            this.accessToken = str;
        }

        public final void setSupportItems$idensic_mobile_sdk_aar_release(List<SNSSupportItem> list) {
            this.supportItems = list;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$SNSExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "", "e", "Lcom/sumsub/sns/internal/core/data/model/LogParams;", "prepareLogParams", "ex", "", "isSumSubException", "Ljava/lang/Thread;", "t", "", "uncaughtException", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/sumsub/sns/internal/log/cacher/c;", "sink", "Lcom/sumsub/sns/internal/log/cacher/c;", "previousHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "<init>", "(Landroid/content/Context;Lcom/sumsub/sns/internal/log/cacher/c;Ljava/lang/Thread$UncaughtExceptionHandler;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class SNSExceptionHandler implements Thread.UncaughtExceptionHandler {
        private final Context context;
        private final Thread.UncaughtExceptionHandler previousHandler;
        /* access modifiers changed from: private */
        public final com.sumsub.sns.internal.log.cacher.c<LogParams> sink;

        public SNSExceptionHandler(Context context2, com.sumsub.sns.internal.log.cacher.c<LogParams> cVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.context = context2;
            this.sink = cVar;
            this.previousHandler = uncaughtExceptionHandler;
        }

        private final boolean isSumSubException(Throwable th2) {
            boolean z11 = false;
            if (th2 == null) {
                return false;
            }
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (StringsKt__StringsJVMKt.M(stackTrace[i11].getClassName(), "com.sumsub", false, 2, (Object) null)) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            return !z11 ? isSumSubException(th2.getCause()) : z11;
        }

        /* access modifiers changed from: private */
        public final LogParams prepareLogParams(Throwable th2) {
            String str;
            String str2;
            if (!isSumSubException(th2)) {
                return null;
            }
            StackTraceElement[] stackTrace = th2.getStackTrace();
            String string = this.context.getSharedPreferences(n0.f32115c, 0).getString(n0.i.f32195c, "");
            if (string == null) {
                str = "";
            } else {
                str = string;
            }
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String valueOf = String.valueOf(stackTrace[0].getLineNumber());
            String fileName = stackTrace[0].getFileName();
            String str3 = fileName + ':' + valueOf;
            String message = th2.getMessage();
            if (message == null) {
                str2 = "";
            } else {
                str2 = message;
            }
            return new LogParams("uncaughtException", str3, (String) null, fileName, str, str2, (String) null, stringWriter.toString(), 64, (r) null);
        }

        public void uncaughtException(Thread thread, Throwable th2) {
            try {
                n1 unused = kotlinx.coroutines.i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SNSMobileSDK$SNSExceptionHandler$uncaughtException$1(this, th2, (kotlin.coroutines.c<? super SNSMobileSDK$SNSExceptionHandler$uncaughtException$1>) null), 3, (Object) null);
            } catch (Exception unused2) {
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$SNSSDK;", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "builder", "Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "(Lcom/sumsub/sns/core/SNSMobileSDK$Builder;)V", "stateChangedHandler", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "launch", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SNSSDK extends SDK {
        private final SNSStateChangedHandler stateChangedHandler;

        public SNSSDK(Builder builder) {
            super(builder);
            this.stateChangedHandler = builder.getStateChangedHandler$idensic_mobile_sdk_aar_release();
        }

        public final SNSStateChangedHandler getStateChangedHandler$idensic_mobile_sdk_aar_release() {
            return this.stateChangedHandler;
        }

        public void launch() {
            installUncaughtExceptionHandler$idensic_mobile_sdk_aar_release(getUrl$idensic_mobile_sdk_aar_release());
            super.launch();
            SNSMobileSDK.INSTANCE.start(this);
        }
    }

    static {
        SNSJsonCustomization.Companion.setDefaultJsonCustomizationProvider(AnonymousClass1.INSTANCE);
        e0 e0Var = e0.f32018a;
        e0Var.a(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE, AnonymousClass5.INSTANCE, AnonymousClass6.INSTANCE, AnonymousClass7.INSTANCE, AnonymousClass8.INSTANCE, AnonymousClass9.INSTANCE, AnonymousClass10.INSTANCE, AnonymousClass11.INSTANCE, AnonymousClass12.INSTANCE, AnonymousClass13.INSTANCE, AnonymousClass14.INSTANCE, AnonymousClass15.INSTANCE, AnonymousClass16.INSTANCE);
        e0Var.a((d10.a<? extends List<SNSSupportItem>>) AnonymousClass17.INSTANCE, (l<? super List<SNSSupportItem>, Unit>) AnonymousClass18.INSTANCE);
        com.sumsub.sns.core.presentation.c cVar = com.sumsub.sns.core.presentation.c.f30925a;
        cVar.a((l<? super Fragment, ? extends Screen>) AnonymousClass19.INSTANCE);
        if (b.f31873a.h() && u0.b()) {
            cVar.a((l<? super Fragment, ? extends Screen>) AnonymousClass20.INSTANCE);
        }
    }

    private SNSMobileSDK() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getModules$idensic_mobile_sdk_aar_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.sumsub.sns.core.SNSModule> getModules() {
        /*
            r1 = this;
            com.sumsub.sns.core.SNSMobileSDK$SDK r0 = _sdk
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = r0.getModules$idensic_mobile_sdk_aar_release()
            if (r0 != 0) goto L_0x000e
        L_0x000a:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.SNSMobileSDK.getModules():java.util.List");
    }

    private final void initFeatures(SDK sdk) {
        com.sumsub.sns.internal.ff.a.f34215a.G();
        c cVar = c.f30748a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initFeatures: ");
        List<SNSModule> modules$idensic_mobile_sdk_aar_release = sdk.getModules$idensic_mobile_sdk_aar_release();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(modules$idensic_mobile_sdk_aar_release, 10));
        for (SNSModule name : modules$idensic_mobile_sdk_aar_release) {
            arrayList.add(name.getName());
        }
        sb2.append(arrayList);
        c.b(cVar, b.f30747a, sb2.toString(), (Throwable) null, 4, (Object) null);
        for (SNSModule sNSModule : sdk.getModules$idensic_mobile_sdk_aar_release()) {
            if (sNSModule instanceof SNSProoface) {
                com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
                SNSProoface sNSProoface = (SNSProoface) sNSModule;
                com.sumsub.sns.internal.ff.core.a.a(aVar.p(), sNSProoface.isDebug(), (String) null, 2, (Object) null);
                com.sumsub.sns.internal.ff.core.a.a(aVar.q(), sNSProoface.isShowSettingsDialog(), (String) null, 2, (Object) null);
            }
            if (sNSModule instanceof SNSCoreModule) {
                com.sumsub.sns.internal.ff.a aVar2 = com.sumsub.sns.internal.ff.a.f34215a;
                SNSCoreModule sNSCoreModule = (SNSCoreModule) sNSModule;
                com.sumsub.sns.internal.ff.core.a.a(aVar2.o(), sNSCoreModule.isFullScreenCamera(), (String) null, 2, (Object) null);
                com.sumsub.sns.internal.ff.core.a.a(aVar2.y(), sNSCoreModule.isSkipGeolocationForm(), (String) null, 2, (Object) null);
            }
        }
    }

    private final void initLogger(SDK sdk) {
        a aVar = a.f34862a;
        aVar.a(sdk.isDebug$idensic_mobile_sdk_aar_release());
        aVar.f();
        if (!sdk.isDebug$idensic_mobile_sdk_aar_release()) {
            return;
        }
        if (sdk.getLogTree$idensic_mobile_sdk_aar_release() instanceof d) {
            aVar.a(LoggerType.LOG_CAT, sdk.getLogTree$idensic_mobile_sdk_aar_release(), true);
            return;
        }
        aVar.a(LoggerType.LOG_CAT, d.f34907a, true);
        aVar.a(LoggerType.SDK_CLIENT, sdk.getLogTree$idensic_mobile_sdk_aar_release(), true);
    }

    /* access modifiers changed from: private */
    public final void start(SDK sdk) {
        SNSErrorHandler errorHandler$idensic_mobile_sdk_aar_release;
        SNSJsonCustomization customization$idensic_mobile_sdk_aar_release;
        Activity activity = sdk.getWeakActivity$idensic_mobile_sdk_aar_release().get();
        if (activity != null) {
            initFeatures(sdk);
            initLogger(sdk);
            com.sumsub.sentry.t.f30497a.a(activity.getApplicationContext());
            _sdk = sdk;
            e0.f32018a.a(sdk.isDebug$idensic_mobile_sdk_aar_release(), sdk.getLocale$idensic_mobile_sdk_aar_release());
            logTree = sdk.getLogTree$idensic_mobile_sdk_aar_release();
            Integer theme$idensic_mobile_sdk_aar_release = sdk.getTheme$idensic_mobile_sdk_aar_release();
            theme = theme$idensic_mobile_sdk_aar_release != null ? theme$idensic_mobile_sdk_aar_release.intValue() : theme;
            try {
                SDK sdk2 = _sdk;
                if (!(sdk2 == null || (customization$idensic_mobile_sdk_aar_release = sdk2.getCustomization$idensic_mobile_sdk_aar_release()) == null)) {
                    customization$idensic_mobile_sdk_aar_release.loadResources(activity.getApplicationContext());
                }
                b.f31873a.a(sdk.isAnalyticsEnabled$idensic_mobile_sdk_aar_release());
                c cVar = c.f30748a;
                c.b(cVar, b.f30747a, "starting: debug=" + sdk.isDebug$idensic_mobile_sdk_aar_release() + " locale=" + sdk.getLocale$idensic_mobile_sdk_aar_release() + " analytics=" + sdk.isAnalyticsEnabled$idensic_mobile_sdk_aar_release(), (Throwable) null, 4, (Object) null);
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), n0.f.f32171b);
                String url$idensic_mobile_sdk_aar_release = sdk.getUrl$idensic_mobile_sdk_aar_release();
                String accessToken$idensic_mobile_sdk_aar_release = sdk.getAccessToken$idensic_mobile_sdk_aar_release();
                if (accessToken$idensic_mobile_sdk_aar_release == null) {
                    accessToken$idensic_mobile_sdk_aar_release = "";
                }
                intent.putExtra("sns_extra_session", new SNSSession((UUID) null, url$idensic_mobile_sdk_aar_release, accessToken$idensic_mobile_sdk_aar_release, getLocale(), isDebug(), getPackageName(), getVersionName(), getVersionCode(), sdk.getTheme$idensic_mobile_sdk_aar_release(), 1, (r) null));
                activity.startActivity(intent);
            } catch (Exception e11) {
                c.f30748a.a(b.f30747a, "start error!!!", e11);
                SDK sdk3 = _sdk;
                if (!(sdk3 == null || (errorHandler$idensic_mobile_sdk_aar_release = sdk3.getErrorHandler$idensic_mobile_sdk_aar_release()) == null)) {
                    errorHandler$idensic_mobile_sdk_aar_release.onError(new SNSException.Unknown(e11));
                }
            }
            com.sumsub.sns.internal.log.cacher.d.f34872a.b();
        }
    }

    public SNSActionResultHandler getActionResultHandler() {
        return this.$$delegate_0.getActionResultHandler();
    }

    public Integer getAutoCloseOnApproveTimeout() {
        return this.$$delegate_0.getAutoCloseOnApproveTimeout();
    }

    public final SNSCompleteHandler getCompleteHandler() {
        SDK sdk = _sdk;
        if (sdk != null) {
            return sdk.getCompleteHandler$idensic_mobile_sdk_aar_release();
        }
        return null;
    }

    public SNSInitConfig getConf() {
        return this.$$delegate_0.getConf();
    }

    public SNSCountryPicker getCountryPicker() {
        return this.$$delegate_0.getCountryPicker();
    }

    public SNSJsonCustomization getCustomization() {
        return this.$$delegate_0.getCustomization();
    }

    public SNSErrorHandler getErrorHandler() {
        return this.$$delegate_0.getErrorHandler();
    }

    public SNSEventHandler getEventHandler() {
        return this.$$delegate_0.getEventHandler();
    }

    public SNSIconHandler getIconHandler() {
        return this.$$delegate_0.getIconHandler();
    }

    public SNSInstructionsViewHandler getInstructionsViewHandler() {
        return this.$$delegate_0.getInstructionsViewHandler();
    }

    public Locale getLocale() {
        return this.$$delegate_0.getLocale();
    }

    public final Logger getLogTree() {
        return logTree;
    }

    public String getPackageName() {
        return this.$$delegate_0.getPackageName();
    }

    public SNSModule getPluggedModule(String str) {
        return this.$$delegate_0.getPluggedModule(str);
    }

    public Map<String, SNSDocumentDefinition> getPreferredDocumentsDefinitions() {
        return this.$$delegate_0.getPreferredDocumentsDefinitions();
    }

    public Map<String, String> getSettings() {
        return this.$$delegate_0.getSettings();
    }

    public SNSSDKState getState() {
        return this.$$delegate_0.getState();
    }

    public SNSStateChangedHandler getStateChangedHandler() {
        return this.$$delegate_0.getStateChangedHandler();
    }

    public List<SNSSupportItem> getSupportItems() {
        return this.$$delegate_0.getSupportItems();
    }

    public final int getTheme() {
        return theme;
    }

    public TokenExpirationHandler getTokenExpirationHandler() {
        return this.$$delegate_0.getTokenExpirationHandler();
    }

    public SNSUrlHandler getUrlHandler() {
        return this.$$delegate_0.getUrlHandler();
    }

    public String getVersion() {
        return this.$$delegate_0.getVersion();
    }

    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    public boolean isModuleAvailable(String str) {
        return this.$$delegate_0.isModuleAvailable(str);
    }

    public void setSupportItems(List<SNSSupportItem> list) {
        this.$$delegate_0.setSupportItems(list);
    }

    public final void shutdown() {
        c.b(c.f30748a, b.f30747a, "shutdown", (Throwable) null, 4, (Object) null);
        a aVar = a.f34862a;
        aVar.flush();
        aVar.d();
        b.f31873a.j();
        com.sumsub.sns.internal.log.cacher.d.f34872a.c();
        SDK sdk = _sdk;
        if (sdk != null) {
            sdk.removeUncaughtExceptionHandler$idensic_mobile_sdk_aar_release();
        }
        _sdk = null;
    }

    public String toString() {
        String str;
        String accessToken$idensic_mobile_sdk_aar_release;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SNSMobileSDK: Api Url: ");
        SDK sdk = _sdk;
        String str2 = null;
        sb2.append(sdk != null ? sdk.getUrl$idensic_mobile_sdk_aar_release() : null);
        sb2.append(", Access Token: ");
        SDK sdk2 = _sdk;
        if (!(sdk2 == null || (accessToken$idensic_mobile_sdk_aar_release = sdk2.getAccessToken$idensic_mobile_sdk_aar_release()) == null)) {
            str2 = w0.a(accessToken$idensic_mobile_sdk_aar_release, 3);
        }
        sb2.append(str2);
        sb2.append(",Modules: ");
        if (getModules().isEmpty()) {
            str = "Empty";
        } else {
            str = '[' + CollectionsKt___CollectionsKt.k0(getModules(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SNSMobileSDK$toString$1.INSTANCE, 31, (Object) null) + ']';
        }
        sb2.append(str);
        sb2.append(", isDebug: ");
        sb2.append(isDebug());
        return sb2.toString();
    }
}
