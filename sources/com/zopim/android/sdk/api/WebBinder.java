package com.zopim.android.sdk.api;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.attachment.FileExtension;
import com.zopim.android.sdk.breadcrumbs.Event;
import com.zopim.android.sdk.breadcrumbs.Events;
import com.zopim.android.sdk.data.LivechatChatLogPath;
import com.zopim.android.sdk.data.WebWidgetListener;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.util.AppInfo;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import mz.f;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;

final class WebBinder extends ChatCommunication {
    private static final String BASE_URL = "https://dashboard.zopim.com/bin/";
    private static final String BRIDGE = "jsinterface";
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "WebBinder";
    private static final long TEARDOWN_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
    private static final String WIDGET_VERSION = "mobile_sdk.js";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private String mUserAgent;
    /* access modifiers changed from: private */
    public WebView mWebView;

    /* renamed from: com.zopim.android.sdk.api.WebBinder$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$Rating[] r0 = com.zopim.android.sdk.model.ChatLog.Rating.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating = r0
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.GOOD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.BAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.UNRATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.WebBinder.AnonymousClass4.<clinit>():void");
        }
    }

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
            return null;
        }
    }

    public class TeardownRunnable implements Runnable {
        private final WebView webView;

        public TeardownRunnable(WebView webView2) {
            this.webView = webView2;
        }

        public void run() {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.stopLoading();
                this.webView.destroy();
            }
        }
    }

    static {
        ajc$preClinit();
    }

    private WebBinder() {
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("WebBinder.java", WebBinder.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 73);
    }

    private boolean isValid(File file) {
        if (file == null || file.getName() == null || file.getName().isEmpty()) {
            Logger.l(LOG_TAG, "File can not be null or empty", new Object[0]);
            return false;
        } else if (file.isDirectory()) {
            Logger.l(LOG_TAG, "Directory is not supported", new Object[0]);
            return false;
        } else if (file.exists()) {
            return true;
        } else {
            Logger.l(LOG_TAG, "File can not be found or you don't have permissions to access it", new Object[0]);
            return false;
        }
    }

    @TargetApi(19)
    private synchronized void loadUrl(final String str) {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (WebBinder.this.mWebView == null) {
                    Logger.l(WebBinder.LOG_TAG, "Can't run the web function, web view is null. WebBinder should be initialized.", new Object[0]);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    WebBinder.this.mWebView.evaluateJavascript(str, (ValueCallback) null);
                } else {
                    WebView access$000 = WebBinder.this.mWebView;
                    String str = str;
                    access$000.loadUrl(str);
                    SensorsDataAutoTrackHelper.loadUrl2(access$000, str);
                }
            }
        });
    }

    private void prepareAttachmentUpload(File file) {
        if (isValid(file)) {
            String add = FileTransfers.INSTANCE.add(file);
            if (add == null || add.isEmpty()) {
                Logger.l(LOG_TAG, "File name is invalid. Will not prepare attachment upload.", new Object[0]);
                return;
            }
            String a11 = f.a(add);
            String a12 = f.a(InstructionFileId.DOT + FileExtension.getExtension(file).getValue());
            String valueOf = String.valueOf(file.length());
            loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendFile('%s', '%s', '%s');", new Object[]{a11, a12, valueOf}));
        }
    }

    public void addNote(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Note must not be null. Will not add the note.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.appendNotes('%s');", new Object[]{a11}));
    }

    public void addTags(String... strArr) {
        if (strArr == null) {
            Logger.l(LOG_TAG, "Tags must not be null. Will not set tags.", new Object[0]);
            return;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr2[i11] = f.a(strArr[i11]);
        }
        String arrays = Arrays.toString(strArr2);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.addTags('%s');", new Object[]{arrays.substring(1, arrays.length() - 1)}));
    }

    public void clearPushToken() {
        loadUrl("javascript:__z_sdk.setPushToken('');");
    }

    public void disconnect() {
        this.mHandler.post(new Runnable() {
            private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;

            /* renamed from: com.zopim.android.sdk.api.WebBinder$3$AjcClosure1 */
            public class AjcClosure1 extends AroundClosure {
                public AjcClosure1(Object[] objArr) {
                    super(objArr);
                }

                public Object run(Object[] objArr) {
                    Object[] objArr2 = this.state;
                    ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
                    return null;
                }
            }

            static {
                ajc$preClinit();
            }

            private static /* synthetic */ void ajc$preClinit() {
                c cVar = new c("WebBinder.java", AnonymousClass3.class);
                ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 726);
            }

            public void run() {
                if (WebBinder.this.mWebView != null) {
                    WebBinder.this.mWebView.removeJavascriptInterface("JSInterface");
                    WebView access$000 = WebBinder.this.mWebView;
                    JoinPoint c11 = c.c(ajc$tjp_0, this, access$000, (Object) null);
                    WoodPeckerWebViewAspect.h().g(new AjcClosure1(new Object[]{this, access$000, null, c11}).linkClosureAndJoinPoint(4112));
                    WebBinder.this.mWebView.destroy();
                    WebView unused = WebBinder.this.mWebView = null;
                }
            }
        });
    }

    public boolean emailTranscript(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Email address must not be null or empty. Will not email transcript.", new Object[0]);
            return false;
        }
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendEmailTranscript('%s');", new Object[]{str}));
        return true;
    }

    public void endChat() {
        loadUrl("javascript:$zopim.livechat.endChat();");
        loadUrl("javascript:__z_sdk.sendDisconnectTimeout(1);");
        this.mHandler.postDelayed(new TeardownRunnable(this.mWebView), TEARDOWN_TIMEOUT);
        this.mHandler.post(new Runnable() {
            public void run() {
                WebView unused = WebBinder.this.mWebView = null;
            }
        });
    }

    public void init(String str, String str2, String str3, String str4) {
        if (str2 != null) {
            Logger.j(LOG_TAG, "Reconnecting to previous chat id: " + str2, new Object[0]);
        }
        if (str2 == null) {
            str2 = "";
        }
        init(str, BRIDGE, str2, this.mUserAgent, str3, "", str4);
    }

    public void keepAlive() {
        loadUrl("javascript:__z_sdk.sendActive();");
    }

    public void removeTags(String... strArr) {
        LinkedList linkedList = new LinkedList();
        for (String a11 : strArr) {
            linkedList.add(f.a(a11));
        }
        String arrays = Arrays.toString(strArr);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.removeTags('%s');", new Object[]{arrays.substring(1, arrays.length() - 1)}));
    }

    public void resend(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Message ID must not be null or empty. Will not resend message.", new Object[0]);
            return;
        }
        ChatLog chatLog = (ChatLog) LivechatChatLogPath.getInstance().getData().get(str);
        if (chatLog == null) {
            Logger.g(LOG_TAG, "Could not resend the message. No message with message id = " + str, new Object[0]);
        }
        chatLog.setFailed(false);
        String a11 = f.a(chatLog.getMessage());
        String a12 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendChatMsg('%s', '%s');", new Object[]{a11, a12}));
    }

    public void send(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Message must not be null. Will not send message.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendChatMsg('%s');", new Object[]{a11}));
    }

    public void sendChatButtonClicked() {
        loadUrl("javascript:__z_sdk.sendButtonClicked();");
    }

    public void sendChatComment(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Comment must not be null. Will not comment on this chat.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendChatComment('%s');", new Object[]{a11}));
    }

    public void sendChatRating(ChatLog.Rating rating) {
        if (rating == null) {
            Logger.l(LOG_TAG, "Rating must not be null. Will not rate this chat.", new Object[0]);
            return;
        }
        int i11 = AnonymousClass4.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating[rating.ordinal()];
        if (i11 == 1 || i11 == 2) {
            String a11 = f.a(rating.getValue());
            loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendChatRating('%s');", new Object[]{a11}));
        } else if (i11 != 3) {
            Logger.j(LOG_TAG, "Unknown rating " + rating + " will not be sent", new Object[0]);
        } else {
            loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendChatRating(null);", new Object[0]));
        }
    }

    public void sendEvents(Event... eventArr) {
        if (eventArr == null || eventArr.length == 0) {
            Logger.l(LOG_TAG, "Events must not be null or empty", new Object[0]);
            return;
        }
        for (int i11 = 0; i11 < eventArr.length; i11++) {
            if (i11 > 0) {
                while (eventArr[i11].equals(eventArr[i11 - 1])) {
                    eventArr[i11] = new Event(eventArr[i11].getTitle(), eventArr[i11].getTimestamp() + 1);
                }
            }
        }
        if (eventArr.length == 1) {
            sendVisitorPath(eventArr[0]);
        } else if (eventArr.length > 1) {
            sendVisitorPaths(eventArr);
        }
        for (Event offer : eventArr) {
            Events.getQueue().offer(offer);
        }
    }

    public boolean sendOfflineMessage(String str, String str2, String str3) {
        if (str2 == null || str2.isEmpty()) {
            Logger.l(LOG_TAG, "Email address must not be null or empty. Will not send email.", new Object[0]);
            return false;
        } else if (str3 == null || str3.isEmpty()) {
            Logger.l(LOG_TAG, "Message must not be null or empty. Will not send email.", new Object[0]);
            return false;
        } else {
            if (str == null) {
                str = "";
            }
            String a11 = f.a(str);
            String a12 = f.a(str2);
            String a13 = f.a(str3);
            loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendOfflineMsg('%s', '%s', '%s');", new Object[]{a11, a12, a13}));
            return true;
        }
    }

    public void sendVisitorPath(Event event) {
        if (event == null) {
            Logger.l(LOG_TAG, "Visitor path must not be null", new Object[0]);
            return;
        }
        WebView webView = this.mWebView;
        Context context = webView != null ? webView.getContext() : null;
        Locale locale = Locale.US;
        loadUrl(String.format(locale, "javascript:__z_sdk.sendVisitorPath(%s);", new Object[]{String.format(locale, "{title:\"%s\", url:\"%s://%d\"}", new Object[]{event.getTitle(), AppInfo.getApplicationName(context).replaceAll("\\s+", ""), Long.valueOf(event.getTimestamp())})}));
    }

    public void sendVisitorPaths(Event[] eventArr) {
        if (eventArr == null || eventArr.length == 0) {
            Logger.l(LOG_TAG, "Visitor paths must not be null or zero size", new Object[0]);
            return;
        }
        WebView webView = this.mWebView;
        Context context = webView != null ? webView.getContext() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i11 = 0; i11 < eventArr.length; i11++) {
            if (eventArr[i11] != null) {
                sb2.append(String.format(Locale.US, "{title:\"%s\", url:\"%s://%d\"}", new Object[]{eventArr[i11].getTitle(), AppInfo.getApplicationName(context).replaceAll("\\s+", ""), Long.valueOf(eventArr[i11].getTimestamp())}));
                if (i11 < eventArr.length - 1) {
                    sb2.append(", ");
                }
            }
        }
        sb2.append("]");
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.sendVisitorPaths(%s);", new Object[]{sb2.toString()}));
    }

    public void setDepartment(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Department must not be null. Will not set department.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.departments.setVisitorDepartment('%s');", new Object[]{a11}));
    }

    public void setEmail(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Email must not be null. Will not set email.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.setEmail('%s');", new Object[]{a11}));
    }

    public void setName(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Name must not be null. Will not set name.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.setName('%s');", new Object[]{a11}));
    }

    public void setNote(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Note must not be null. Will not set the note.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.setNotes('%s');", new Object[]{a11}));
    }

    public void setPhoneNumber(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Phone number must not be null. Will not set phone number.", new Object[0]);
            return;
        }
        String a11 = f.a(str);
        loadUrl(String.format(Locale.US, "javascript:$zopim.livechat.setPhone('%s');", new Object[]{a11}));
    }

    public void setPushToken(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Token must not be null. Will not set token.", new Object[0]);
            return;
        }
        loadUrl(String.format(Locale.US, "javascript:__z_sdk.setPushToken('%s');", new Object[]{str}));
    }

    public WebBinder(Context context) {
        WebView webView = new WebView(context.getApplicationContext());
        this.mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        WebWidgetListener webWidgetListener = new WebWidgetListener();
        this.mWebView.addJavascriptInterface(webWidgetListener, "JSInterface");
        WebView webView2 = this.mWebView;
        JoinPoint c11 = c.c(ajc$tjp_0, this, webView2, webWidgetListener);
        WoodPeckerWebViewAspect.h().g(new AjcClosure1(new Object[]{this, webView2, webWidgetListener, c11}).linkClosureAndJoinPoint(4112));
        Locale locale = Locale.US;
        this.mUserAgent = String.format(locale, "%s %s %s", new Object[]{this.mWebView.getSettings().getUserAgentString(), String.format(locale, "%s/%s-%s", new Object[]{AppInfo.getApplicationName(context).replaceAll("\\s+", ""), AppInfo.getApplicationVersionName(context), AppInfo.getApplicationStage(context)}), String.format(locale, "%s/%s", new Object[]{AppInfo.getChatSdkName().replaceAll("\\s+", ""), AppInfo.getChatSdkVersionName()})});
    }

    private void init(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Locale locale = Locale.US;
        String format = String.format(locale, "<!DOCTYPE html><html><head></head><body><script src=\"%s?%s\"></script><script type=\"text/javascript\">%s</script></body></html>", new Object[]{WIDGET_VERSION, str, String.format(locale, "window.__z_sdk.initApp({bridge: '%s',register: {mID: '%s',ua: '%s',title: '%s',url: '%s',ref: '%s',source: 'android_sdk'}});", new Object[]{str2, str3, str4, str5, str6, str7})});
        WebView webView = this.mWebView;
        String str8 = BASE_URL;
        String str9 = format;
        String str10 = "text/html";
        String str11 = "UTF-8";
        String str12 = "";
        webView.loadDataWithBaseURL(str8, str9, str10, str11, str12);
        SensorsDataAutoTrackHelper.loadDataWithBaseURL2(webView, str8, str9, str10, str11, str12);
    }

    public void send(File file) {
        if (!isValid(file)) {
            Logger.l(LOG_TAG, "Could not send file", new Object[0]);
        } else {
            prepareAttachmentUpload(file);
        }
    }
}
