package zendesk.support.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.QuoteSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Xml;
import android.view.View;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$string;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mz.f;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.UiUtils;

class DocumentRenderer {
    private final ActionHandlerRegistry actionHandlerRegistry;
    private final ConfigurationHelper configHelper;
    private final Configuration configuration;
    private final Style.Factory styleFactory;

    /* renamed from: zendesk.support.request.DocumentRenderer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                zendesk.support.request.DocumentRenderer$Node$Type[] r0 = zendesk.support.request.DocumentRenderer.Node.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type = r0
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.B     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H2     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H3     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H4     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H5     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.H6     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.I     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Code     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.A     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0084 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.P     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x0090 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Div     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x009c }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Br     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x00a8 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Img     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x00b4 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Li     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type     // Catch:{ NoSuchFieldError -> 0x00c0 }
                zendesk.support.request.DocumentRenderer$Node$Type r1 = zendesk.support.request.DocumentRenderer.Node.Type.Quote     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.DocumentRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Node {
        /* access modifiers changed from: private */
        public final Map<String, String> attributes;
        /* access modifiers changed from: private */
        public final List<Node> children;
        private final Node parent;
        private final String text;
        private final Type type;

        public enum Type {
            B("b"),
            I("i"),
            Code("code"),
            H1("h1"),
            H2("h2"),
            H3("h3"),
            H4("h4"),
            H5("h5"),
            H6("h6"),
            Strong("strong"),
            U("u"),
            Em(UserDataStore.EMAIL),
            Br(TtmlNode.TAG_BR),
            Hr("hr"),
            Div(TtmlNode.TAG_DIV),
            P(TtmlNode.TAG_P),
            Li("li"),
            A("a"),
            Ol("ol"),
            Ul("ul"),
            Img("img"),
            Quote("blockquote"),
            Text("$text"),
            Document("$document"),
            Unknown("$unknown");
            
            private final String tag;

            private Type(String str) {
                this.tag = str;
            }

            public static Type forTag(String str) {
                for (Type type : values()) {
                    if (type.getTag().equalsIgnoreCase(str)) {
                        return type;
                    }
                }
                return Unknown;
            }

            public String getTag() {
                return this.tag;
            }
        }

        private Node(Type type2, String str, List<Node> list, Node node, Map<String, String> map) {
            this.type = type2;
            this.text = str;
            this.children = list;
            this.parent = node;
            this.attributes = map;
        }

        public static Node withContent(Node node, String str, Map<String, String> map) {
            return new Node(Type.Text, str, new ArrayList(), node, map);
        }

        public static Node withTag(String str, Node node, Map<String, String> map) {
            return new Node(Type.forTag(str), (String) null, new ArrayList(), node, map);
        }

        public void addChild(Node node) {
            this.children.add(node);
        }

        public Map<String, String> getAttributes() {
            return this.attributes;
        }

        public List<Node> getChildren() {
            return this.children;
        }

        public Node getParent() {
            return this.parent;
        }

        public CharSequence getText() {
            return this.text;
        }

        public Type getType() {
            return this.type;
        }
    }

    public static class RichRenderingDocument {
        private final String fallbackText;
        private final Node tree;

        public RichRenderingDocument(Node node, String str) {
            this.tree = node;
            this.fallbackText = str;
        }

        public String getFallbackText() {
            return this.fallbackText;
        }

        public Node getNodeTree() {
            return this.tree;
        }

        public boolean isValid() {
            Node node = this.tree;
            return node != null && !node.getChildren().isEmpty();
        }
    }

    public interface Style {

        public static class Bold implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.applySpans(SpannableHelper.foldStrings(list), new StyleSpan(1));
            }
        }

        public static class Br implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.foldStrings(Arrays.asList(new CharSequence[]{SpannableHelper.foldStrings(list), f.f58291b}));
            }
        }

        public static class CodeSpan implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.applySpans(SpannableHelper.foldStrings(list), new TypefaceSpan("monospace"));
            }
        }

        public static class Factory {
            private final Context context;

            public Factory(Context context2) {
                this.context = context2;
            }

            public Style getStyleForType(Node.Type type) {
                switch (AnonymousClass1.$SwitchMap$zendesk$support$request$DocumentRenderer$Node$Type[type.ordinal()]) {
                    case 1:
                        return new Bold();
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        return new Header();
                    case 8:
                        return new Italic();
                    case 9:
                        return new CodeSpan();
                    case 10:
                        return new Link();
                    case 11:
                    case 12:
                    case 13:
                        return new Br();
                    case 14:
                        return new Image(this.context.getResources());
                    case 15:
                        return new Li();
                    case 16:
                        return new QuotationSpan(UiUtils.themeAttributeToColor(16842906, this.context, R$color.zs_fallback_text_color));
                    default:
                        return new Unknown();
                }
            }

            @SuppressLint({"InlinedApi"})
            public Spannable getStyledText(CharSequence charSequence) {
                if (charSequence != null) {
                    return new SpannableString(charSequence.toString().replaceAll("&nbsp;", " "));
                }
                return new SpannableString("");
            }
        }

        public static class Header extends Bold {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.foldStrings(Arrays.asList(new CharSequence[]{super.applyStyle(list, map), f.f58291b}));
            }
        }

        public static class Image implements Style {
            private final Resources resources;

            public Image(Resources resources2) {
                this.resources = resources2;
            }

            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                String str = map.get("src");
                String str2 = "Image";
                if (str == null || str.isEmpty()) {
                    return SpannableHelper.applySpans(new SpannableString(str2), new Object[0]);
                }
                String queryParameter = HttpUrl.parse(str).queryParameter("name");
                String string = this.resources.getString(R$string.request_message_inline_image_title_format);
                Object[] objArr = new Object[1];
                if (queryParameter != null) {
                    str2 = queryParameter;
                }
                objArr[0] = str2;
                return SpannableHelper.applySpans(new SpannableString(String.format(string, objArr)), new URLSpan(str));
            }
        }

        public static class Italic implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.applySpans(SpannableHelper.foldStrings(list), new StyleSpan(2));
            }
        }

        public static class Li implements Style {
            public static final String INDEX_ATTRIBUTE = "_index";
            public static final String PARENT_ATTRIBUTE = "_parent";
            public static final String UNICODE_BULLET = "•";

            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                String str = "";
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                String str2 = (map == null || !map.containsKey(PARENT_ATTRIBUTE)) ? str : map.get(PARENT_ATTRIBUTE);
                if (map != null && map.containsKey(INDEX_ATTRIBUTE)) {
                    str = map.get(INDEX_ATTRIBUTE);
                }
                for (CharSequence next : list) {
                    if (f.c(str2)) {
                        if (str2.equalsIgnoreCase("ol")) {
                            spannableStringBuilder.append(str);
                            if (f.c(str)) {
                                spannableStringBuilder.append(". ");
                            }
                        } else if (str2.equalsIgnoreCase("ul")) {
                            spannableStringBuilder.append(UNICODE_BULLET).append(" ");
                        }
                    }
                    spannableStringBuilder.append(next);
                    spannableStringBuilder.append(f.f58291b);
                }
                return new SpannableString(spannableStringBuilder);
            }
        }

        public static class Link implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                SpannableString foldStrings = SpannableHelper.foldStrings(list);
                String str = map.get(ShareConstants.WEB_DIALOG_PARAM_HREF);
                if (!f.c(str)) {
                    return foldStrings;
                }
                return SpannableHelper.applySpans(foldStrings, new URLSpan(str));
            }
        }

        public static class QuotationSpan implements Style {
            private int quoteColor;

            public QuotationSpan(int i11) {
                this.quoteColor = i11;
            }

            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(" ");
                arrayList.addAll(list);
                return SpannableHelper.applySpans(SpannableHelper.foldStrings(arrayList), new QuoteSpan(this.quoteColor), new ForegroundColorSpan(this.quoteColor));
            }
        }

        public static class SpannableHelper {
            private SpannableHelper() {
            }

            public static SpannableString applySpans(CharSequence charSequence, Object... objArr) {
                SpannableString spannableString = new SpannableString(charSequence);
                if (objArr != null) {
                    for (Object obj : objArr) {
                        if (obj != null) {
                            spannableString.setSpan(obj, 0, spannableString.length(), 33);
                        }
                    }
                }
                return spannableString;
            }

            public static SpannableString foldStrings(List<CharSequence> list) {
                return new SpannableString(TextUtils.concat((CharSequence[]) list.toArray(new CharSequence[list.size()])));
            }

            public static SpannableString trimSpannable(Spannable spannable) {
                String obj = spannable.toString();
                int i11 = 0;
                while (obj.length() > 0 && obj.startsWith("\n")) {
                    obj = obj.substring(1);
                    i11++;
                }
                int i12 = 0;
                while (obj.length() > 0 && obj.endsWith("\n")) {
                    obj = obj.substring(0, obj.length() - 1);
                    i12++;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
                if (spannableStringBuilder.length() > 0 && spannable.length() - i12 > 0 && spannable.length() - i12 != spannable.length()) {
                    spannableStringBuilder = spannableStringBuilder.delete(spannable.length() - i12, spannable.length());
                }
                if (i11 > 0 && i11 < spannable.length()) {
                    spannableStringBuilder = spannableStringBuilder.delete(0, i11);
                }
                return new SpannableString(spannableStringBuilder);
            }
        }

        public static class Unknown implements Style {
            public Spannable applyStyle(List<CharSequence> list, Map<String, String> map) {
                return SpannableHelper.foldStrings(list);
            }
        }

        Spannable applyStyle(List<CharSequence> list, Map<String, String> map);
    }

    public static class ZendeskUrlSpan extends URLSpan {
        private final ConfigurationHelper configHelper;
        private final Configuration configuration;
        private final ActionHandlerRegistry registry;

        public ZendeskUrlSpan(String str, ActionHandlerRegistry actionHandlerRegistry, ConfigurationHelper configurationHelper, Configuration configuration2) {
            super(str);
            this.registry = actionHandlerRegistry;
            this.configHelper = configurationHelper;
            this.configuration = configuration2;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String url = getURL();
            if (f.e(url)) {
                super.onClick(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ActionHandler handlerByAction = this.registry.handlerByAction(url);
            if (handlerByAction == null) {
                super.onClick(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ViewArticleActionHandler.HELP_CENTER_VIEW_ARTICLE, url);
            this.configHelper.d(hashMap, this.configuration);
            handlerByAction.handle(hashMap, view.getContext());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public DocumentRenderer(Context context, ActionHandlerRegistry actionHandlerRegistry2, ConfigurationHelper configurationHelper, Configuration configuration2) {
        this.styleFactory = new Style.Factory(context);
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.configHelper = configurationHelper;
        this.configuration = configuration2;
    }

    private Spannable installClickableLinks(Spannable spannable) {
        return replaceUrlSpans(linkifyAll(spannable));
    }

    private static Spannable linkifyAll(Spannable spannable) {
        SpannableString spannableString = new SpannableString(spannable);
        if (Linkify.addLinks(spannableString, 15)) {
            for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
                spannable.setSpan(uRLSpan, spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            }
        }
        return spannable;
    }

    private Spannable replaceUrlSpans(Spannable spannable) {
        SpannableString spannableString = new SpannableString(spannable);
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            String url = uRLSpan.getURL();
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            spannableString.removeSpan(uRLSpan);
            spannableString.setSpan(new ZendeskUrlSpan(url, this.actionHandlerRegistry, this.configHelper, this.configuration), spanStart, spanEnd, 33);
        }
        return spannableString;
    }

    public Spannable reduce(Node node) {
        Node.Type type = node.getType();
        List<Node> children = node.getChildren();
        if (type == Node.Type.Text) {
            return this.styleFactory.getStyledText(node.getText());
        }
        if (type == Node.Type.Ol || type == Node.Type.Ul) {
            int i11 = 0;
            for (Node node2 : node.children) {
                node2.attributes.put(Style.Li.PARENT_ATTRIBUTE, type.name());
                i11++;
                node2.attributes.put(Style.Li.INDEX_ATTRIBUTE, String.valueOf(i11));
            }
        }
        ArrayList arrayList = new ArrayList(children.size());
        for (Node reduce : children) {
            arrayList.add(reduce(reduce));
        }
        return this.styleFactory.getStyleForType(type).applyStyle(arrayList, node.getAttributes());
    }

    public CharSequence render(RichRenderingDocument richRenderingDocument) {
        if (richRenderingDocument.isValid()) {
            return render(richRenderingDocument.getNodeTree());
        }
        return installClickableLinks(new SpannableString(richRenderingDocument.getFallbackText()));
    }

    private CharSequence render(Node node) {
        return Style.SpannableHelper.trimSpannable(installClickableLinks(reduce(node)));
    }

    public DocumentRenderer(Style.Factory factory, ActionHandlerRegistry actionHandlerRegistry2, ConfigurationHelper configurationHelper, Configuration configuration2) {
        this.styleFactory = factory;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.configHelper = configurationHelper;
        this.configuration = configuration2;
    }

    public static class HtmlParser {
        private static final Set<String> UNCLOSED_TAGS = new HashSet(Arrays.asList(new String[]{TtmlNode.TAG_BR, "hr", "img"}));
        private final XmlPullParser xpp;

        public HtmlParser() {
            XmlPullParser xmlPullParser = null;
            try {
                XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                newInstance.setValidating(false);
                newInstance.setFeature(Xml.FEATURE_RELAXED, true);
                xmlPullParser = newInstance.newPullParser();
            } catch (XmlPullParserException e11) {
                Logger.l(RequestActivity.LOG_TAG, "Unable to parse rich text. Error: '%s' | '%s'", e11.getLocalizedMessage());
            } finally {
                this.xpp = xmlPullParser;
            }
        }

        private Node endTag(Node node) {
            return node.getParent();
        }

        private Map<String, String> getAttributes() {
            int attributeCount = this.xpp.getAttributeCount();
            HashMap hashMap = new HashMap(Math.max(0, attributeCount));
            if (attributeCount > 0) {
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    hashMap.put(this.xpp.getAttributeName(i11), this.xpp.getAttributeValue(i11));
                }
            }
            return hashMap;
        }

        private Node startDocument() {
            return Node.withTag(Node.Type.Document.getTag(), (Node) null, getAttributes());
        }

        private Node startTag(Node node) {
            String name = this.xpp.getName();
            Node withTag = Node.withTag(name, node, getAttributes());
            node.addChild(withTag);
            return UNCLOSED_TAGS.contains(name) ? node : withTag;
        }

        private void text(Node node) {
            String text = this.xpp.getText();
            if (f.c(text)) {
                node.addChild(Node.withContent(node, text, getAttributes()));
            }
        }

        public RichRenderingDocument parse(String str, String str2) {
            try {
                this.xpp.setInput(new StringReader(str));
                int eventType = this.xpp.getEventType();
                Node node = null;
                Node node2 = null;
                while (eventType != 1) {
                    if (eventType == 0) {
                        node = startDocument();
                        node2 = node;
                    } else if (eventType == 2) {
                        node2 = startTag(node2);
                    } else if (eventType == 3) {
                        node2 = endTag(node2);
                    } else if (eventType == 4) {
                        text(node2);
                    }
                    eventType = this.xpp.next();
                }
                if (node == node2) {
                    return new RichRenderingDocument(node, str2);
                }
            } catch (Exception e11) {
                Logger.l(RequestActivity.LOG_TAG, "Unable to parse rich text. Error: '%s' | '%s'", e11.getLocalizedMessage(), str);
            }
            return new RichRenderingDocument((Node) null, str2);
        }

        public HtmlParser(XmlPullParser xmlPullParser) {
            this.xpp = xmlPullParser;
        }
    }
}
