package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$string;
import com.zendesk.guide.sdk.R$style;
import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lz.a;
import lz.d;
import mz.b;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.StatusLine;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import zendesk.classic.messaging.MessagingActivity;
import zendesk.classic.messaging.c;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.NetworkAware;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.Article;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.AttachmentType;
import zendesk.support.HelpCenterAttachment;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettings;
import zendesk.support.HelpCenterSettingsProvider;
import zendesk.support.guide.ArticleConfiguration;

public class ViewArticleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String ARTICLE_DETAIL_FORMAT_STRING = "%s %s <span dir=\"auto\">%s</span>";
    private static final String CSS_FILE = "file:///android_asset/help_center_article_style.css";
    private static final long FETCH_ATTACHMENTS_DELAY_MILLIS = 250;
    public static final String LOG_TAG = "ViewArticleActivity";
    private static final Integer NETWORK_AWARE_ID = 57564;
    private static final String TYPE_TEXT_HTML = "text/html";
    private static final String UTF_8_ENCODING_TYPE = "UTF-8";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public ActionHandlerRegistry actionHandlerRegistry;
    /* access modifiers changed from: private */
    public ArticleAttachmentAdapter adapter;
    public ApplicationConfiguration applicationConfiguration;
    /* access modifiers changed from: private */
    public ArticleViewModel article;
    private WebView articleContentWebView;
    /* access modifiers changed from: private */
    public Long articleId;
    public ArticleVoteStorage articleVoteStorage;
    /* access modifiers changed from: private */
    public ArticleVotingView articleVotingView;
    /* access modifiers changed from: private */
    public ListView attachmentListView;
    private d<List<HelpCenterAttachment>> attachmentRequestCallback;
    /* access modifiers changed from: private */
    public ArticleConfiguration config;
    public ConfigurationHelper configurationHelper;
    /* access modifiers changed from: private */
    public CoordinatorLayout coordinatorLayout;
    private List<c> engines;
    private final Handler handler = new Handler();
    public HelpCenterProvider helpCenterProvider;
    private final NetworkAware networkConnectionCallbacks = new NetworkAware() {
        public boolean connected = true;

        public void onNetworkAvailable() {
            if (NetworkUtils.isConnectedOrConnecting(ViewArticleActivity.this)) {
                ViewArticleActivity.this.dimissSnackBar();
                this.connected = true;
                if (ViewArticleActivity.this.articleId != null && ViewArticleActivity.this.article == null) {
                    ViewArticleActivity viewArticleActivity = ViewArticleActivity.this;
                    viewArticleActivity.fetchArticle(viewArticleActivity.articleId.longValue());
                } else if (ViewArticleActivity.this.article != null) {
                    ViewArticleActivity viewArticleActivity2 = ViewArticleActivity.this;
                    viewArticleActivity2.fetchAttachmentsForArticle(viewArticleActivity2.article.getId());
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        public void onNetworkUnavailable() {
            if (!NetworkUtils.isConnectedOrConnecting(ViewArticleActivity.this) && this.connected) {
                this.connected = false;
                ViewArticleActivity.this.dimissSnackBar();
                ViewArticleActivity viewArticleActivity = ViewArticleActivity.this;
                Snackbar unused = viewArticleActivity.snackbar = Snackbar.make((View) viewArticleActivity.coordinatorLayout, R$string.zg_general_no_connection_message, -2);
                ViewArticleActivity.this.snackbar.show();
            }
        }
    };
    public NetworkInfoProvider networkInfoProvider;
    public OkHttpClient okHttpClient;
    private ProgressBar progressView;
    private final AggregatedCallback<HelpCenterSettings> settingsAggregatedCallback = new AggregatedCallback<>();
    public HelpCenterSettingsProvider settingsProvider;
    /* access modifiers changed from: private */
    public Snackbar snackbar;

    /* renamed from: zendesk.support.guide.ViewArticleActivity$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                zendesk.support.guide.ViewArticleActivity$LoadingState[] r0 = zendesk.support.guide.ViewArticleActivity.LoadingState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState = r0
                zendesk.support.guide.ViewArticleActivity$LoadingState r1 = zendesk.support.guide.ViewArticleActivity.LoadingState.LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.guide.ViewArticleActivity$LoadingState r1 = zendesk.support.guide.ViewArticleActivity.LoadingState.DISPLAYING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.support.guide.ViewArticleActivity$LoadingState r1 = zendesk.support.guide.ViewArticleActivity.LoadingState.ERRORED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.support.guide.ViewArticleActivity$LoadingState r1 = zendesk.support.guide.ViewArticleActivity.LoadingState.ERRORED_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.guide.ViewArticleActivity.AnonymousClass8.<clinit>():void");
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

    public static class ArticleAttachmentAdapter extends ArrayAdapter<HelpCenterAttachment> {
        public ArticleAttachmentAdapter(Context context) {
            super(context, R$layout.zs_row_article_attachment);
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            ArticleAttachmentRow articleAttachmentRow;
            if (view instanceof ArticleAttachmentRow) {
                articleAttachmentRow = (ArticleAttachmentRow) view;
            } else {
                articleAttachmentRow = new ArticleAttachmentRow(getContext());
            }
            articleAttachmentRow.bind((HelpCenterAttachment) getItem(i11));
            return articleAttachmentRow;
        }
    }

    public static class ArticleAttachmentRow extends RelativeLayout {
        private final TextView fileName = ((TextView) findViewById(R$id.article_attachment_row_filename_text));
        private final TextView fileSize = ((TextView) findViewById(R$id.article_attachment_row_filesize_text));

        public ArticleAttachmentRow(Context context) {
            super(context);
            RelativeLayout.inflate(context, R$layout.zs_row_article_attachment, this);
        }

        public void bind(HelpCenterAttachment helpCenterAttachment) {
            this.fileName.setText(helpCenterAttachment.getFileName());
            this.fileSize.setText(b.b(helpCenterAttachment.getSize()));
        }
    }

    public class AttachmentRequestCallback extends ZendeskCallback<List<HelpCenterAttachment>> {
        public AttachmentRequestCallback() {
        }

        public void onError(a aVar) {
            ViewArticleActivity.this.adapter.clear();
            ViewArticleActivity.this.setLoadingState(LoadingState.ERRORED_ATTACHMENT);
            Logger.e(ViewArticleActivity.LOG_TAG, aVar);
        }

        public void onSuccess(List<HelpCenterAttachment> list) {
            ViewArticleActivity.this.adapter.clear();
            ViewArticleActivity.this.adapter.addAll(list);
            ViewArticleActivity.setListViewHeightBasedOnChildren(ViewArticleActivity.this.attachmentListView);
            ViewArticleActivity.this.setLoadingState(LoadingState.DISPLAYING);
        }
    }

    public enum LoadingState {
        LOADING,
        DISPLAYING,
        ERRORED,
        ERRORED_ATTACHMENT
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("ViewArticleActivity.java", ViewArticleActivity.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), StatusLine.HTTP_PERM_REDIRECT);
    }

    /* access modifiers changed from: private */
    public void applyVoteButtonSettings() {
        loadSettings(new ZendeskCallback<HelpCenterSettings>() {
            public void onError(a aVar) {
                ViewArticleActivity.this.articleVotingView.setVisibility(8);
            }

            public void onSuccess(HelpCenterSettings helpCenterSettings) {
                if (helpCenterSettings.isArticleVotingEnabled()) {
                    ViewArticleActivity.this.articleVotingView.setVisibility(0);
                } else {
                    ViewArticleActivity.this.articleVotingView.setVisibility(8);
                }
            }
        });
    }

    public static ArticleConfiguration.Builder builder(Article article2) {
        return new ArticleConfiguration.Builder(article2);
    }

    /* access modifiers changed from: private */
    public void dimissSnackBar() {
        Snackbar snackbar2 = this.snackbar;
        if (snackbar2 != null) {
            snackbar2.dismiss();
            this.snackbar = null;
        }
    }

    /* access modifiers changed from: private */
    public void fetchArticle(long j11) {
        setLoadingState(LoadingState.LOADING);
        this.helpCenterProvider.getArticle(Long.valueOf(j11), new ZendeskCallback<Article>() {
            public void onError(a aVar) {
                ViewArticleActivity.this.setLoadingState(LoadingState.ERRORED);
            }

            public void onSuccess(Article article) {
                ArticleViewModel unused = ViewArticleActivity.this.article = new ArticleViewModel(article);
                ViewArticleActivity.this.loadArticleBody();
            }
        });
    }

    /* access modifiers changed from: private */
    public void fetchAttachmentsForArticle(long j11) {
        setLoadingState(LoadingState.LOADING);
        this.helpCenterProvider.getAttachments(Long.valueOf(j11), AttachmentType.BLOCK, this.attachmentRequestCallback);
    }

    private ActionBar initToolbar() {
        findViewById(R$id.view_article_compat_shadow).setVisibility(8);
        setSupportActionBar((Toolbar) findViewById(R$id.view_article_toolbar));
        return getSupportActionBar();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"RestrictedApi"})
    public void loadArticleBody() {
        String str;
        setTitle(getString(R$string.zs_view_article_loaded_accessibility, new Object[]{this.article.getTitle()}));
        setLoadingState(LoadingState.DISPLAYING);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(UiUtils.decodeHtmlEntities(this.article.getTitle()));
        }
        String str2 = null;
        String authorName = this.article.getAuthorName();
        if (this.article.getCreatedAt() != null) {
            str2 = DateFormat.getDateInstance(1, f.a(getResources().getConfiguration()).d(0)).format(this.article.getCreatedAt());
        }
        if (str2 == null || authorName == null) {
            str = "";
        } else {
            str = String.format(Locale.US, ARTICLE_DETAIL_FORMAT_STRING, new Object[]{authorName, getString(R$string.view_article_seperator), str2});
        }
        String string = getString(R$string.view_article_html_body, new Object[]{CSS_FILE, this.article.getTitle(), this.article.getBody(), str});
        WebView webView = this.articleContentWebView;
        String zendeskUrl = this.applicationConfiguration.getZendeskUrl();
        String str3 = string;
        String str4 = TYPE_TEXT_HTML;
        String str5 = "UTF-8";
        webView.loadDataWithBaseURL(zendeskUrl, str3, str4, str5, (String) null);
        SensorsDataAutoTrackHelper.loadDataWithBaseURL2(webView, zendeskUrl, str3, str4, str5, (String) null);
        this.handler.postDelayed(new Runnable() {
            public void run() {
                ViewArticleActivity viewArticleActivity = ViewArticleActivity.this;
                viewArticleActivity.fetchAttachmentsForArticle(viewArticleActivity.article.getId());
                ViewArticleActivity.this.applyVoteButtonSettings();
            }
        }, 250);
    }

    private void loadSettings(ZendeskCallback<HelpCenterSettings> zendeskCallback) {
        if (this.settingsAggregatedCallback.add(zendeskCallback)) {
            this.settingsProvider.getSettings(this.settingsAggregatedCallback);
        }
    }

    /* access modifiers changed from: private */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter2 = listView.getAdapter();
        if (adapter2 != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view = null;
            int i11 = 0;
            for (int i12 = 0; i12 < adapter2.getCount(); i12++) {
                view = adapter2.getView(i12, view, listView);
                if (i12 == 0) {
                    view.setLayoutParams(new ViewGroup.LayoutParams(makeMeasureSpec, -2));
                }
                view.measure(makeMeasureSpec, 0);
                i11 += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i11 + (listView.getDividerHeight() * (adapter2.getCount() - 1));
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }

    private void setupRequestInterceptor() {
        WebView webView = this.articleContentWebView;
        if (webView == null) {
            Logger.l(LOG_TAG, "The webview is null. Make sure you initialise it before trying to add the interceptor", new Object[0]);
            return;
        }
        AnonymousClass2 r22 = new WebViewClient() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.String} */
            /* JADX WARNING: type inference failed for: r0v8, types: [java.io.InputStream] */
            /* JADX WARNING: type inference failed for: r0v14 */
            /* JADX WARNING: type inference failed for: r0v21 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r9, java.lang.String r10) {
                /*
                    r8 = this;
                    zendesk.support.guide.ViewArticleActivity r0 = zendesk.support.guide.ViewArticleActivity.this
                    zendesk.core.ApplicationConfiguration r0 = r0.applicationConfiguration
                    java.lang.String r0 = r0.getZendeskUrl()
                    boolean r1 = mz.f.e(r0)
                    java.lang.String r2 = "ViewArticleActivity"
                    r3 = 0
                    if (r1 != 0) goto L_0x00c7
                    boolean r0 = r10.startsWith(r0)
                    if (r0 != 0) goto L_0x0019
                    goto L_0x00c7
                L_0x0019:
                    zendesk.core.Zendesk r0 = zendesk.core.Zendesk.INSTANCE
                    zendesk.core.Identity r0 = r0.getIdentity()
                    boolean r1 = zendesk.core.UrlHelper.isGuideRequest(r10)
                    if (r1 == 0) goto L_0x0035
                    boolean r0 = r0 instanceof zendesk.core.AnonymousIdentity
                    if (r0 == 0) goto L_0x0035
                    java.lang.Object[] r0 = new java.lang.Object[r3]
                    java.lang.String r1 = "Will not intercept request because it is anonymous guide request"
                    com.zendesk.logger.Logger.l(r2, r1, r0)
                    android.webkit.WebResourceResponse r9 = super.shouldInterceptRequest(r9, r10)
                    return r9
                L_0x0035:
                    r9 = 0
                    okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x00b7 }
                    r0.<init>()     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.Request$Builder r10 = r0.url((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.Request r10 = r10.build()     // Catch:{ Exception -> 0x00b7 }
                    zendesk.support.guide.ViewArticleActivity r0 = zendesk.support.guide.ViewArticleActivity.this     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.OkHttpClient r0 = r0.okHttpClient     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.Call r10 = r0.newCall(r10)     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.Response r10 = r10.execute()     // Catch:{ Exception -> 0x00b7 }
                    if (r10 == 0) goto L_0x00b2
                    boolean r0 = r10.isSuccessful()     // Catch:{ Exception -> 0x00b7 }
                    if (r0 == 0) goto L_0x00b2
                    okhttp3.ResponseBody r0 = r10.body()     // Catch:{ Exception -> 0x00b7 }
                    if (r0 == 0) goto L_0x00b2
                    okhttp3.ResponseBody r0 = r10.body()     // Catch:{ Exception -> 0x00b7 }
                    java.io.InputStream r0 = r0.byteStream()     // Catch:{ Exception -> 0x00b7 }
                    okhttp3.ResponseBody r10 = r10.body()     // Catch:{ Exception -> 0x00af }
                    okhttp3.MediaType r10 = r10.contentType()     // Catch:{ Exception -> 0x00af }
                    if (r10 == 0) goto L_0x00ab
                    java.lang.String r1 = r10.type()     // Catch:{ Exception -> 0x00af }
                    boolean r1 = mz.f.c(r1)     // Catch:{ Exception -> 0x00af }
                    if (r1 == 0) goto L_0x009c
                    java.lang.String r1 = r10.subtype()     // Catch:{ Exception -> 0x00af }
                    boolean r1 = mz.f.c(r1)     // Catch:{ Exception -> 0x00af }
                    if (r1 == 0) goto L_0x009c
                    java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x00af }
                    java.lang.String r4 = "%s/%s"
                    r5 = 2
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00af }
                    java.lang.String r6 = r10.type()     // Catch:{ Exception -> 0x00af }
                    r5[r3] = r6     // Catch:{ Exception -> 0x00af }
                    r6 = 1
                    java.lang.String r7 = r10.subtype()     // Catch:{ Exception -> 0x00af }
                    r5[r6] = r7     // Catch:{ Exception -> 0x00af }
                    java.lang.String r1 = java.lang.String.format(r1, r4, r5)     // Catch:{ Exception -> 0x00af }
                    goto L_0x009d
                L_0x009c:
                    r1 = r9
                L_0x009d:
                    java.nio.charset.Charset r10 = r10.charset()     // Catch:{ Exception -> 0x00a9 }
                    if (r10 == 0) goto L_0x00a7
                    java.lang.String r9 = r10.name()     // Catch:{ Exception -> 0x00a9 }
                L_0x00a7:
                    r10 = r9
                    goto L_0x00ad
                L_0x00a9:
                    r10 = move-exception
                    goto L_0x00ba
                L_0x00ab:
                    r10 = r9
                    r1 = r10
                L_0x00ad:
                    r9 = r0
                    goto L_0x00b4
                L_0x00af:
                    r10 = move-exception
                    r1 = r9
                    goto L_0x00ba
                L_0x00b2:
                    r10 = r9
                    r1 = r10
                L_0x00b4:
                    r0 = r9
                    r9 = r10
                    goto L_0x00c1
                L_0x00b7:
                    r10 = move-exception
                    r0 = r9
                    r1 = r0
                L_0x00ba:
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    java.lang.String r4 = "Exception encountered when trying to intercept request"
                    com.zendesk.logger.Logger.c(r2, r4, r10, r3)
                L_0x00c1:
                    android.webkit.WebResourceResponse r10 = new android.webkit.WebResourceResponse
                    r10.<init>(r1, r9, r0)
                    return r10
                L_0x00c7:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "Will not intercept request because the url is not hosted by Zendesk"
                    r0.append(r1)
                    r0.append(r10)
                    java.lang.String r0 = r0.toString()
                    java.lang.Object[] r1 = new java.lang.Object[r3]
                    com.zendesk.logger.Logger.l(r2, r0, r1)
                    android.webkit.WebResourceResponse r9 = super.shouldInterceptRequest(r9, r10)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: zendesk.support.guide.ViewArticleActivity.AnonymousClass2.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                ActionHandler handlerByAction = ViewArticleActivity.this.actionHandlerRegistry.handlerByAction(str);
                if (handlerByAction != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(ViewArticleActionHandler.HELP_CENTER_VIEW_ARTICLE, str);
                    ViewArticleActivity viewArticleActivity = ViewArticleActivity.this;
                    viewArticleActivity.configurationHelper.d(hashMap, viewArticleActivity.config);
                    handlerByAction.handle(hashMap, ViewArticleActivity.this);
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (intent.resolveActivity(webView.getContext().getPackageManager()) != null) {
                    webView.getContext().startActivity(intent);
                    return true;
                }
                Logger.b(ViewArticleActivity.LOG_TAG, "No browser available to open url: " + str, new Object[0]);
                return false;
            }
        };
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(ajc$tjp_0, this, webView, r22);
        WoodPeckerWebViewAspect.h().g(new AjcClosure1(new Object[]{this, webView, r22, c11}).linkClosureAndJoinPoint(4112));
    }

    private boolean shouldShowContactUsButton() {
        boolean z11 = this.actionHandlerRegistry.handlerByAction("action_contact_option") != null;
        boolean i11 = mz.a.i(this.engines);
        if (!this.config.isContactUsButtonVisible() || (!z11 && !i11)) {
            return false;
        }
        return true;
    }

    private void showCreateRequest(Map<String, Object> map) {
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_contact_option");
        if (handlerByAction != null) {
            ActionDescription actionDescription = handlerByAction.getActionDescription();
            Logger.b(LOG_TAG, "No Deflection ActionHandler Available, opening %s", actionDescription != null ? actionDescription.getLocalizedLabel() : handlerByAction.getClass().getSimpleName());
            handlerByAction.handle(map, this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getTheme().applyStyle(R$style.ZendeskActivityDefaultTheme, true);
        setContentView(R$layout.zs_activity_view_article);
        GuideSdkDependencyProvider guideSdkDependencyProvider = GuideSdkDependencyProvider.INSTANCE;
        if (!guideSdkDependencyProvider.isInitialized()) {
            Logger.d(LOG_TAG, GuideSdkDependencyProvider.NOT_INITIALIZED_LOG, new Object[0]);
            finish();
            return;
        }
        guideSdkDependencyProvider.provideGuideSdkComponent().inject(this);
        ActionBar initToolbar = initToolbar();
        ArticleConfiguration articleConfiguration = (ArticleConfiguration) this.configurationHelper.f(getIntent().getExtras(), ArticleConfiguration.class);
        this.config = articleConfiguration;
        if (articleConfiguration == null || articleConfiguration.getConfigurationState() == -1) {
            Logger.d(LOG_TAG, "No configuration found. Please use ViewArticleActivity.builder()", new Object[0]);
            finish();
            return;
        }
        this.engines = this.config.getEngines();
        this.attachmentListView = (ListView) findViewById(R$id.view_article_attachment_list);
        ArticleAttachmentAdapter articleAttachmentAdapter = new ArticleAttachmentAdapter(this);
        this.adapter = articleAttachmentAdapter;
        this.attachmentListView.setAdapter(articleAttachmentAdapter);
        this.attachmentListView.setOnItemClickListener(this);
        if (initToolbar != null) {
            initToolbar.setDisplayHomeAsUpEnabled(true);
        }
        WebView webView = (WebView) findViewById(R$id.view_article_content_webview);
        this.articleContentWebView = webView;
        webView.setWebChromeClient(new WebChromeClient());
        this.articleContentWebView.getSettings().setJavaScriptEnabled(true);
        setupRequestInterceptor();
        this.articleContentWebView.getSettings().setMixedContentMode(0);
        this.progressView = (ProgressBar) findViewById(R$id.view_article_progress);
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R$id.view_article_attachment_coordinator);
        if (this.config.getConfigurationState() == 2) {
            ArticleViewModel article2 = this.config.getArticle();
            this.article = article2;
            if (article2 != null) {
                this.articleId = Long.valueOf(article2.getId());
            }
            loadArticleBody();
        } else {
            fetchArticle(this.config.getArticleId());
            this.articleId = Long.valueOf(this.config.getArticleId());
        }
        if (shouldShowContactUsButton()) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R$id.contact_us_button);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    ViewArticleActivity.this.showContactZendesk();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            floatingActionButton.setVisibility(0);
        }
        ArticleVotingView articleVotingView2 = (ArticleVotingView) findViewById(R$id.article_voting_container);
        this.articleVotingView = articleVotingView2;
        articleVotingView2.bindTo(this.articleId, this.articleVoteStorage, this.helpCenterProvider);
        this.articleVotingView.setVisibility(8);
        applyVoteButtonSettings();
    }

    public void onDestroy() {
        super.onDestroy();
        this.settingsAggregatedCallback.cancel();
        WebView webView = this.articleContentWebView;
        if (webView != null) {
            webView.destroy();
        }
    }

    @SensorsDataInstrumented
    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        Object itemAtPosition = adapterView.getItemAtPosition(i11);
        if (itemAtPosition instanceof HelpCenterAttachment) {
            HelpCenterAttachment helpCenterAttachment = (HelpCenterAttachment) itemAtPosition;
            if (helpCenterAttachment.getContentUrl() != null) {
                Uri parse = Uri.parse(helpCenterAttachment.getContentUrl());
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(parse);
                startActivity(intent);
            } else {
                Logger.l(LOG_TAG, "Unable to launch viewer, unable to parse URI for attachment", new Object[0]);
            }
        }
        SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    public void onStart() {
        super.onStart();
        this.attachmentRequestCallback = d.a(new AttachmentRequestCallback());
        this.networkInfoProvider.addNetworkAwareListener(NETWORK_AWARE_ID, this.networkConnectionCallbacks);
        this.networkInfoProvider.register();
    }

    public void onStop() {
        super.onStop();
        d<List<HelpCenterAttachment>> dVar = this.attachmentRequestCallback;
        if (dVar != null) {
            dVar.cancel();
            this.attachmentRequestCallback = null;
        }
        this.networkInfoProvider.removeNetworkAwareListener(NETWORK_AWARE_ID);
        this.networkInfoProvider.unregister();
    }

    public void setLoadingState(LoadingState loadingState) {
        if (loadingState == null) {
            Logger.l(LOG_TAG, "LoadingState was null, nothing to do", new Object[0]);
            return;
        }
        int i11 = AnonymousClass8.$SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState[loadingState.ordinal()];
        if (i11 == 1) {
            UiUtils.setVisibility(this.progressView, 0);
            UiUtils.setVisibility(this.attachmentListView, 8);
        } else if (i11 == 2) {
            UiUtils.setVisibility(this.progressView, 8);
            UiUtils.setVisibility(this.attachmentListView, 0);
        } else if (i11 == 3) {
            showLoadingErrorState(R$string.zs_view_article_error);
        } else if (i11 == 4) {
            showLoadingErrorState(R$string.view_article_attachments_error);
        }
    }

    public void showContactZendesk() {
        HashMap hashMap = new HashMap();
        this.configurationHelper.d(hashMap, this.config);
        if (mz.a.i(this.engines)) {
            MessagingActivity.Af().k(this.engines).j(this, this.config.getConfigurations());
        } else {
            showCreateRequest(hashMap);
        }
    }

    public void showLoadingErrorState(int i11) {
        UiUtils.setVisibility(this.progressView, 8);
        UiUtils.setVisibility(this.attachmentListView, 8);
        dimissSnackBar();
        Snackbar action = Snackbar.make((View) this.coordinatorLayout, i11, -2).setAction(R$string.zui_retry_button_label, (View.OnClickListener) new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ViewArticleActivity.this.articleId != null && ViewArticleActivity.this.article == null) {
                    ViewArticleActivity viewArticleActivity = ViewArticleActivity.this;
                    viewArticleActivity.fetchArticle(viewArticleActivity.articleId.longValue());
                } else if (ViewArticleActivity.this.article != null) {
                    ViewArticleActivity viewArticleActivity2 = ViewArticleActivity.this;
                    viewArticleActivity2.fetchAttachmentsForArticle(viewArticleActivity2.article.getId());
                }
                ViewArticleActivity.this.dimissSnackBar();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.snackbar = action;
        action.show();
    }

    public static ArticleConfiguration.Builder builder(long j11) {
        return new ArticleConfiguration.Builder(j11);
    }

    public static ArticleConfiguration.Builder builder() {
        return new ArticleConfiguration.Builder();
    }
}
