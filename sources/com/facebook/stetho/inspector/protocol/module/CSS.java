package com.facebook.stetho.inspector.protocol.module;

import android.annotation.SuppressLint;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS implements ChromeDevtoolsDomain {
    /* access modifiers changed from: private */
    public final Document mDocument;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager;

    public static class CSSComputedStyleProperty {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private CSSComputedStyleProperty() {
        }
    }

    public static class CSSProperty {
        @JsonProperty
        public Boolean disabled;
        @JsonProperty
        public Boolean implicit;
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty
        public Boolean parsedOk;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public String text;
        @JsonProperty(required = true)
        public String value;

        private CSSProperty() {
        }
    }

    public static class CSSRule {
        @JsonProperty
        public Origin origin;
        @JsonProperty(required = true)
        public SelectorList selectorList;
        @JsonProperty
        public CSSStyle style;
        @JsonProperty
        public String styleSheetId;

        private CSSRule() {
        }
    }

    public static class CSSStyle {
        @JsonProperty(required = true)
        public List<CSSProperty> cssProperties;
        @JsonProperty
        public String cssText;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public List<ShorthandEntry> shorthandEntries;
        @JsonProperty
        public String styleSheetId;

        private CSSStyle() {
        }
    }

    public static class GetComputedStyleForNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;

        private GetComputedStyleForNodeRequest() {
        }
    }

    public static class GetComputedStyleForNodeResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<CSSComputedStyleProperty> computedStyle;

        private GetComputedStyleForNodeResult() {
        }
    }

    public static class GetMatchedStylesForNodeRequest implements JsonRpcResult {
        @JsonProperty
        public Boolean excludeInherited;
        @JsonProperty
        public Boolean excludePseudo;
        @JsonProperty(required = true)
        public int nodeId;

        private GetMatchedStylesForNodeRequest() {
        }
    }

    public static class GetMatchedStylesForNodeResult implements JsonRpcResult {
        @JsonProperty
        public List<InheritedStyleEntry> inherited;
        @JsonProperty
        public List<RuleMatch> matchedCSSRules;
        @JsonProperty
        public List<PseudoIdMatches> pseudoElements;

        private GetMatchedStylesForNodeResult() {
        }
    }

    public static class InheritedStyleEntry {
        @JsonProperty(required = true)
        public CSSStyle inlineStyle;
        @JsonProperty(required = true)
        public List<RuleMatch> matchedCSSRules;

        private InheritedStyleEntry() {
        }
    }

    public final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        public synchronized void onFirstPeerRegistered() {
            CSS.this.mDocument.addRef();
        }

        public synchronized void onLastPeerUnregistered() {
            CSS.this.mDocument.release();
        }
    }

    public static class PseudoIdMatches {
        @JsonProperty(required = true)
        public List<RuleMatch> matches = new ArrayList();
        @JsonProperty(required = true)
        public int pseudoId;
    }

    public static class RuleMatch {
        @JsonProperty
        public List<Integer> matchingSelectors;
        @JsonProperty
        public CSSRule rule;

        private RuleMatch() {
        }
    }

    public static class Selector {
        @JsonProperty
        public SourceRange range;
        @JsonProperty(required = true)
        public String value;

        private Selector() {
        }
    }

    public static class SelectorList {
        @JsonProperty
        public List<Selector> selectors;
        @JsonProperty
        public String text;

        private SelectorList() {
        }
    }

    public static class SetPropertyTextRequest implements JsonRpcResult {
        @JsonProperty(required = true)
        public String styleSheetId;
        @JsonProperty(required = true)
        public String text;

        private SetPropertyTextRequest() {
        }
    }

    public static class SetPropertyTextResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public CSSStyle style;

        private SetPropertyTextResult() {
        }
    }

    public static class ShorthandEntry {
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private ShorthandEntry() {
        }
    }

    public static class SourceRange {
        @JsonProperty(required = true)
        public int endColumn;
        @JsonProperty(required = true)
        public int endLine;
        @JsonProperty(required = true)
        public int startColumn;
        @JsonProperty(required = true)
        public int startLine;

        private SourceRange() {
        }
    }

    public CSS(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mPeerManager = chromePeerManager;
        chromePeerManager.setListener(new PeerManagerListener());
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getComputedStyleForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetComputedStyleForNodeRequest getComputedStyleForNodeRequest = (GetComputedStyleForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetComputedStyleForNodeRequest.class);
        final GetComputedStyleForNodeResult getComputedStyleForNodeResult = new GetComputedStyleForNodeResult();
        getComputedStyleForNodeResult.computedStyle = new ArrayList();
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getComputedStyleForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    LogUtil.e("Tried to get the style of an element that does not exist, using nodeid=" + getComputedStyleForNodeRequest.nodeId);
                    return;
                }
                CSS.this.mDocument.getElementComputedStyles(elementForNodeId, new ComputedStyleAccumulator() {
                    public void store(String str, String str2) {
                        CSSComputedStyleProperty cSSComputedStyleProperty = new CSSComputedStyleProperty();
                        cSSComputedStyleProperty.name = str;
                        cSSComputedStyleProperty.value = str2;
                        getComputedStyleForNodeResult.computedStyle.add(cSSComputedStyleProperty);
                    }
                });
            }
        });
        return getComputedStyleForNodeResult;
    }

    @ChromeDevtoolsMethod
    @SuppressLint({"DefaultLocale"})
    public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetMatchedStylesForNodeRequest getMatchedStylesForNodeRequest = (GetMatchedStylesForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetMatchedStylesForNodeRequest.class);
        final GetMatchedStylesForNodeResult getMatchedStylesForNodeResult = new GetMatchedStylesForNodeResult();
        getMatchedStylesForNodeResult.matchedCSSRules = new ArrayList();
        getMatchedStylesForNodeResult.inherited = Collections.emptyList();
        getMatchedStylesForNodeResult.pseudoElements = Collections.emptyList();
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                final Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getMatchedStylesForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + getMatchedStylesForNodeRequest.nodeId);
                    return;
                }
                CSS.this.mDocument.getElementStyleRuleNames(elementForNodeId, new StyleRuleNameAccumulator() {
                    public void store(String str, boolean z11) {
                        final ArrayList arrayList = new ArrayList();
                        RuleMatch ruleMatch = new RuleMatch();
                        ruleMatch.matchingSelectors = ListUtil.newImmutableList(0);
                        Selector selector = new Selector();
                        selector.value = str;
                        CSSRule cSSRule = new CSSRule();
                        cSSRule.origin = Origin.REGULAR;
                        SelectorList selectorList = new SelectorList();
                        cSSRule.selectorList = selectorList;
                        selectorList.selectors = ListUtil.newImmutableList(selector);
                        CSSStyle cSSStyle = new CSSStyle();
                        cSSRule.style = cSSStyle;
                        cSSStyle.cssProperties = arrayList;
                        cSSStyle.shorthandEntries = Collections.emptyList();
                        if (z11) {
                            cSSRule.style.styleSheetId = String.format("%s.%s", new Object[]{Integer.toString(getMatchedStylesForNodeRequest.nodeId), selector.value});
                        }
                        CSS.this.mDocument.getElementStyles(elementForNodeId, str, new StyleAccumulator() {
                            public void store(String str, String str2, boolean z11) {
                                CSSProperty cSSProperty = new CSSProperty();
                                cSSProperty.name = str;
                                cSSProperty.value = str2;
                                arrayList.add(cSSProperty);
                            }
                        });
                        ruleMatch.rule = cSSRule;
                        getMatchedStylesForNodeResult.matchedCSSRules.add(ruleMatch);
                    }
                });
            }
        });
        return getMatchedStylesForNodeResult;
    }

    @ChromeDevtoolsMethod
    public SetPropertyTextResult setPropertyText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final String str;
        final String str2;
        SetPropertyTextRequest setPropertyTextRequest = (SetPropertyTextRequest) this.mObjectMapper.convertValue(jSONObject, SetPropertyTextRequest.class);
        String[] split = setPropertyTextRequest.styleSheetId.split("\\.", 2);
        final int parseInt = Integer.parseInt(split[0]);
        final String str3 = split[1];
        String str4 = setPropertyTextRequest.text;
        if (str4 == null || !str4.contains(":")) {
            str2 = null;
            str = null;
        } else {
            String[] split2 = setPropertyTextRequest.text.split(":", 2);
            String trim = split2[0].trim();
            str = StringUtil.removeAll(split2[1], ';').trim();
            str2 = trim;
        }
        SetPropertyTextResult setPropertyTextResult = new SetPropertyTextResult();
        CSSStyle cSSStyle = new CSSStyle();
        setPropertyTextResult.style = cSSStyle;
        cSSStyle.styleSheetId = setPropertyTextRequest.styleSheetId;
        cSSStyle.cssProperties = new ArrayList();
        setPropertyTextResult.style.shorthandEntries = Collections.emptyList();
        final SetPropertyTextResult setPropertyTextResult2 = setPropertyTextResult;
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(parseInt);
                if (elementForNodeId == null) {
                    LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + parseInt);
                    return;
                }
                if (str2 != null) {
                    CSS.this.mDocument.setElementStyle(elementForNodeId, str3, str2, str);
                }
                CSS.this.mDocument.getElementStyles(elementForNodeId, str3, new StyleAccumulator() {
                    public void store(String str, String str2, boolean z11) {
                        CSSProperty cSSProperty = new CSSProperty();
                        cSSProperty.name = str;
                        cSSProperty.value = str2;
                        setPropertyTextResult2.style.cssProperties.add(cSSProperty);
                    }
                });
            }
        });
        return setPropertyTextResult;
    }
}
