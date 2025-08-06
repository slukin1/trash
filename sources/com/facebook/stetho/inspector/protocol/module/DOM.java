package com.facebook.stetho.inspector.protocol.module;

import android.graphics.Color;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.DocumentView;
import com.facebook.stetho.inspector.elements.ElementInfo;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class DOM implements ChromeDevtoolsDomain {
    private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
    private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
    /* access modifiers changed from: private */
    public final Document mDocument;
    /* access modifiers changed from: private */
    public final DocumentUpdateListener mListener;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    /* access modifiers changed from: private */
    public final ChromePeerManager mPeerManager;
    private final AtomicInteger mResultCounter;
    /* access modifiers changed from: private */
    public final Map<String, List<Integer>> mSearchResults;

    public static class AttributeModifiedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String value;

        private AttributeModifiedEvent() {
        }
    }

    public static class AttributeRemovedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;

        private AttributeRemovedEvent() {
        }
    }

    public static class ChildNodeInsertedEvent {
        @JsonProperty(required = true)
        public Node node;
        @JsonProperty(required = true)
        public int parentNodeId;
        @JsonProperty(required = true)
        public int previousNodeId;

        private ChildNodeInsertedEvent() {
        }
    }

    public static class ChildNodeRemovedEvent {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public int parentNodeId;

        private ChildNodeRemovedEvent() {
        }
    }

    public static class DiscardSearchResultsRequest {
        @JsonProperty(required = true)
        public String searchId;

        private DiscardSearchResultsRequest() {
        }
    }

    public final class DocumentUpdateListener implements Document.UpdateListener {
        private DocumentUpdateListener() {
        }

        public void onAttributeModified(Object obj, String str, String str2) {
            AttributeModifiedEvent attributeModifiedEvent = new AttributeModifiedEvent();
            attributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeModifiedEvent.name = str;
            attributeModifiedEvent.value = str2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeModified", attributeModifiedEvent);
        }

        public void onAttributeRemoved(Object obj, String str) {
            AttributeRemovedEvent attributeRemovedEvent = new AttributeRemovedEvent();
            attributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeRemovedEvent.name = str;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
        }

        public void onChildNodeInserted(DocumentView documentView, Object obj, int i11, int i12, Accumulator<Object> accumulator) {
            ChildNodeInsertedEvent access$1700 = DOM.this.acquireChildNodeInsertedEvent();
            access$1700.parentNodeId = i11;
            access$1700.previousNodeId = i12;
            access$1700.node = DOM.this.createNodeForElement(obj, documentView, accumulator);
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", access$1700);
            DOM.this.releaseChildNodeInsertedEvent(access$1700);
        }

        public void onChildNodeRemoved(int i11, int i12) {
            ChildNodeRemovedEvent access$1500 = DOM.this.acquireChildNodeRemovedEvent();
            access$1500.parentNodeId = i11;
            access$1500.nodeId = i12;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", access$1500);
            DOM.this.releaseChildNodeRemovedEvent(access$1500);
        }

        public void onInspectRequested(Object obj) {
            Integer nodeIdForElement = DOM.this.mDocument.getNodeIdForElement(obj);
            if (nodeIdForElement == null) {
                LogUtil.d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", obj);
                return;
            }
            InspectNodeRequestedEvent inspectNodeRequestedEvent = new InspectNodeRequestedEvent();
            inspectNodeRequestedEvent.nodeId = nodeIdForElement.intValue();
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", inspectNodeRequestedEvent);
        }
    }

    public static class GetDocumentResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Node root;

        private GetDocumentResponse() {
        }
    }

    public static class GetSearchResultsRequest {
        @JsonProperty(required = true)
        public int fromIndex;
        @JsonProperty(required = true)
        public String searchId;
        @JsonProperty(required = true)
        public int toIndex;

        private GetSearchResultsRequest() {
        }
    }

    public static class GetSearchResultsResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<Integer> nodeIds;

        private GetSearchResultsResponse() {
        }
    }

    public static class HighlightConfig {
        @JsonProperty
        public RGBAColor contentColor;

        private HighlightConfig() {
        }
    }

    public static class HighlightNodeRequest {
        @JsonProperty(required = true)
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Integer nodeId;
        @JsonProperty
        public String objectId;

        private HighlightNodeRequest() {
        }
    }

    public static class InspectNodeRequestedEvent {
        @JsonProperty
        public int nodeId;

        private InspectNodeRequestedEvent() {
        }
    }

    public static class Node implements JsonRpcResult {
        @JsonProperty
        public List<String> attributes;
        @JsonProperty
        public Integer childNodeCount;
        @JsonProperty
        public List<Node> children;
        @JsonProperty(required = true)
        public String localName;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String nodeName;
        @JsonProperty(required = true)
        public NodeType nodeType;
        @JsonProperty(required = true)
        public String nodeValue;

        private Node() {
        }
    }

    public final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        public synchronized void onFirstPeerRegistered() {
            DOM.this.mDocument.addRef();
            DOM.this.mDocument.addUpdateListener(DOM.this.mListener);
        }

        public synchronized void onLastPeerUnregistered() {
            DOM.this.mSearchResults.clear();
            DOM.this.mDocument.removeUpdateListener(DOM.this.mListener);
            DOM.this.mDocument.release();
        }
    }

    public static class PerformSearchRequest {
        @JsonProperty
        public Boolean includeUserAgentShadowDOM;
        @JsonProperty(required = true)
        public String query;

        private PerformSearchRequest() {
        }
    }

    public static class PerformSearchResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public int resultCount;
        @JsonProperty(required = true)
        public String searchId;

        private PerformSearchResponse() {
        }
    }

    public static class RGBAColor {
        @JsonProperty

        /* renamed from: a  reason: collision with root package name */
        public Double f65002a;
        @JsonProperty(required = true)

        /* renamed from: b  reason: collision with root package name */
        public int f65003b;
        @JsonProperty(required = true)

        /* renamed from: g  reason: collision with root package name */
        public int f65004g;
        @JsonProperty(required = true)

        /* renamed from: r  reason: collision with root package name */
        public int f65005r;

        private RGBAColor() {
        }

        public int getColor() {
            byte b11;
            Double d11 = this.f65002a;
            byte b12 = -1;
            if (d11 != null) {
                long round = Math.round(d11.doubleValue() * 255.0d);
                if (round < 0) {
                    b11 = 0;
                } else if (round < 255) {
                    b11 = (byte) ((int) round);
                }
                b12 = b11;
            }
            return Color.argb(b12, this.f65005r, this.f65004g, this.f65003b);
        }
    }

    public static class ResolveNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty
        public String objectGroup;

        private ResolveNodeRequest() {
        }
    }

    public static class ResolveNodeResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Runtime.RemoteObject object;

        private ResolveNodeResponse() {
        }
    }

    public static class SetAttributesAsTextRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String text;

        private SetAttributesAsTextRequest() {
        }
    }

    public static class SetInspectModeEnabledRequest {
        @JsonProperty(required = true)
        public boolean enabled;
        @JsonProperty
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Boolean inspectShadowDOM;

        private SetInspectModeEnabledRequest() {
        }
    }

    public DOM(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        this.mSearchResults = Collections.synchronizedMap(new HashMap());
        this.mResultCounter = new AtomicInteger(0);
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mPeerManager = chromePeerManager;
        chromePeerManager.setListener(new PeerManagerListener());
        this.mListener = new DocumentUpdateListener();
    }

    /* access modifiers changed from: private */
    public ChildNodeInsertedEvent acquireChildNodeInsertedEvent() {
        ChildNodeInsertedEvent childNodeInsertedEvent = this.mCachedChildNodeInsertedEvent;
        if (childNodeInsertedEvent == null) {
            childNodeInsertedEvent = new ChildNodeInsertedEvent();
        }
        this.mCachedChildNodeInsertedEvent = null;
        return childNodeInsertedEvent;
    }

    /* access modifiers changed from: private */
    public ChildNodeRemovedEvent acquireChildNodeRemovedEvent() {
        ChildNodeRemovedEvent childNodeRemovedEvent = this.mCachedChildNodeRemovedEvent;
        if (childNodeRemovedEvent == null) {
            childNodeRemovedEvent = new ChildNodeRemovedEvent();
        }
        this.mCachedChildNodeRemovedEvent = null;
        return childNodeRemovedEvent;
    }

    /* access modifiers changed from: private */
    public Node createNodeForElement(Object obj, DocumentView documentView, Accumulator<Object> accumulator) {
        List<Node> list;
        if (accumulator != null) {
            accumulator.store(obj);
        }
        NodeDescriptor nodeDescriptor = this.mDocument.getNodeDescriptor(obj);
        Node node = new Node();
        node.nodeId = this.mDocument.getNodeIdForElement(obj).intValue();
        node.nodeType = nodeDescriptor.getNodeType(obj);
        node.nodeName = nodeDescriptor.getNodeName(obj);
        node.localName = nodeDescriptor.getLocalName(obj);
        node.nodeValue = nodeDescriptor.getNodeValue(obj);
        Document.AttributeListAccumulator attributeListAccumulator = new Document.AttributeListAccumulator();
        nodeDescriptor.getAttributes(obj, attributeListAccumulator);
        node.attributes = attributeListAccumulator;
        ElementInfo elementInfo = documentView.getElementInfo(obj);
        if (elementInfo.children.size() == 0) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>(elementInfo.children.size());
        }
        int size = elementInfo.children.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.add(createNodeForElement(elementInfo.children.get(i11), documentView, accumulator));
        }
        node.children = list;
        node.childNodeCount = Integer.valueOf(list.size());
        return node;
    }

    /* access modifiers changed from: private */
    public void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent childNodeInsertedEvent) {
        childNodeInsertedEvent.parentNodeId = -1;
        childNodeInsertedEvent.previousNodeId = -1;
        childNodeInsertedEvent.node = null;
        if (this.mCachedChildNodeInsertedEvent == null) {
            this.mCachedChildNodeInsertedEvent = childNodeInsertedEvent;
        }
    }

    /* access modifiers changed from: private */
    public void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent childNodeRemovedEvent) {
        childNodeRemovedEvent.parentNodeId = -1;
        childNodeRemovedEvent.nodeId = -1;
        if (this.mCachedChildNodeRemovedEvent == null) {
            this.mCachedChildNodeRemovedEvent = childNodeRemovedEvent;
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void discardSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        String str = ((DiscardSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, DiscardSearchResultsRequest.class)).searchId;
        if (str != null) {
            this.mSearchResults.remove(str);
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDocument(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDocumentResponse getDocumentResponse = new GetDocumentResponse();
        getDocumentResponse.root = (Node) this.mDocument.postAndWait(new UncheckedCallable<Node>() {
            public Node call() {
                Object rootElement = DOM.this.mDocument.getRootElement();
                DOM dom = DOM.this;
                return dom.createNodeForElement(rootElement, dom.mDocument.getDocumentView(), (Accumulator<Object>) null);
            }
        });
        return getDocumentResponse;
    }

    @ChromeDevtoolsMethod
    public GetSearchResultsResponse getSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetSearchResultsRequest getSearchResultsRequest = (GetSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, GetSearchResultsRequest.class);
        String str = getSearchResultsRequest.searchId;
        if (str == null) {
            LogUtil.w("searchId may not be null");
            return null;
        }
        List list = this.mSearchResults.get(str);
        if (list == null) {
            LogUtil.w("\"" + getSearchResultsRequest.searchId + "\" is not a valid reference to a search result");
            return null;
        }
        List<Integer> subList = list.subList(getSearchResultsRequest.fromIndex, getSearchResultsRequest.toIndex);
        GetSearchResultsResponse getSearchResultsResponse = new GetSearchResultsResponse();
        getSearchResultsResponse.nodeIds = subList;
        return getSearchResultsResponse;
    }

    @ChromeDevtoolsMethod
    public void hideHighlight(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                DOM.this.mDocument.hideHighlight();
            }
        });
    }

    @ChromeDevtoolsMethod
    public void highlightNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final HighlightNodeRequest highlightNodeRequest = (HighlightNodeRequest) this.mObjectMapper.convertValue(jSONObject, HighlightNodeRequest.class);
        if (highlightNodeRequest.nodeId == null) {
            LogUtil.w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
            return;
        }
        final RGBAColor rGBAColor = highlightNodeRequest.highlightConfig.contentColor;
        if (rGBAColor == null) {
            LogUtil.w("DOM.highlightNode was not given a color to highlight with");
        } else {
            this.mDocument.postAndWait((Runnable) new Runnable() {
                public void run() {
                    Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(highlightNodeRequest.nodeId.intValue());
                    if (elementForNodeId != null) {
                        DOM.this.mDocument.highlightElement(elementForNodeId, rGBAColor.getColor());
                    }
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public PerformSearchResponse performSearch(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final PerformSearchRequest performSearchRequest = (PerformSearchRequest) this.mObjectMapper.convertValue(jSONObject, PerformSearchRequest.class);
        final ArrayListAccumulator arrayListAccumulator = new ArrayListAccumulator();
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                DOM.this.mDocument.findMatchingElements(performSearchRequest.query, arrayListAccumulator);
            }
        });
        String valueOf = String.valueOf(this.mResultCounter.getAndIncrement());
        this.mSearchResults.put(valueOf, arrayListAccumulator);
        PerformSearchResponse performSearchResponse = new PerformSearchResponse();
        performSearchResponse.searchId = valueOf;
        performSearchResponse.resultCount = arrayListAccumulator.size();
        return performSearchResponse;
    }

    @ChromeDevtoolsMethod
    public ResolveNodeResponse resolveNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        final ResolveNodeRequest resolveNodeRequest = (ResolveNodeRequest) this.mObjectMapper.convertValue(jSONObject, ResolveNodeRequest.class);
        Object postAndWait = this.mDocument.postAndWait(new UncheckedCallable<Object>() {
            public Object call() {
                return DOM.this.mDocument.getElementForNodeId(resolveNodeRequest.nodeId);
            }
        });
        if (postAndWait != null) {
            int mapObject = Runtime.mapObject(jsonRpcPeer, postAndWait);
            Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
            remoteObject.type = Runtime.ObjectType.OBJECT;
            remoteObject.subtype = Runtime.ObjectSubType.NODE;
            remoteObject.className = postAndWait.getClass().getName();
            remoteObject.value = null;
            remoteObject.description = null;
            remoteObject.objectId = String.valueOf(mapObject);
            ResolveNodeResponse resolveNodeResponse = new ResolveNodeResponse();
            resolveNodeResponse.object = remoteObject;
            return resolveNodeResponse;
        }
        JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.INVALID_PARAMS;
        throw new JsonRpcException(new JsonRpcError(errorCode, "No known nodeId=" + resolveNodeRequest.nodeId, (JSONObject) null));
    }

    @ChromeDevtoolsMethod
    public void setAttributesAsText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetAttributesAsTextRequest setAttributesAsTextRequest = (SetAttributesAsTextRequest) this.mObjectMapper.convertValue(jSONObject, SetAttributesAsTextRequest.class);
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(setAttributesAsTextRequest.nodeId);
                if (elementForNodeId != null) {
                    DOM.this.mDocument.setAttributesAsText(elementForNodeId, setAttributesAsTextRequest.text);
                }
            }
        });
    }

    @ChromeDevtoolsMethod
    public void setInspectModeEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetInspectModeEnabledRequest setInspectModeEnabledRequest = (SetInspectModeEnabledRequest) this.mObjectMapper.convertValue(jSONObject, SetInspectModeEnabledRequest.class);
        this.mDocument.postAndWait((Runnable) new Runnable() {
            public void run() {
                DOM.this.mDocument.setInspectModeEnabled(setInspectModeEnabledRequest.enabled);
            }
        });
    }
}
