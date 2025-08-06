package com.tencent.ugc.videobase.chain;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.lang.reflect.Array;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TXCGPUImageTopoSortFilter extends TXCGPUImageFilter {
    private static final String INPUT_TEXTURE_NAME_FOR_ON_DRAW = "input-texture-name-for-on-draw";
    private Node mFinalNode;
    private final Map<Node, Integer> mIndicesMap = new HashMap();
    private final Node mInitNode;
    private FloatBuffer mInputCubeCoordsBuffer;
    private FloatBuffer mInputTextureCoordsBuffer;
    private int mInputTextureId;
    private final List<Node> mNodes;
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    private GLTexture mOutputTexture;
    private int[] mUsedCountOneDraw;

    public static class Node {
        /* access modifiers changed from: private */
        public int countAsInput;
        /* access modifiers changed from: private */
        public final TXCGPUImageFilter filter;
        /* access modifiers changed from: private */
        public GLTexture glTexture;
        /* access modifiers changed from: private */
        public final Map<String, Node> inputNodeMap;

        public void addExtraInput(String str, Node node) {
            node.countAsInput++;
            this.inputNodeMap.put(str, node);
        }

        public void setInputForOnDraw(Node node) {
            node.countAsInput++;
            this.inputNodeMap.put(TXCGPUImageTopoSortFilter.INPUT_TEXTURE_NAME_FOR_ON_DRAW, node);
        }

        private Node(TXCGPUImageFilter tXCGPUImageFilter) {
            this.inputNodeMap = new HashMap();
            this.glTexture = null;
            this.countAsInput = 0;
            this.filter = tXCGPUImageFilter;
        }
    }

    public TXCGPUImageTopoSortFilter() {
        ArrayList arrayList = new ArrayList();
        this.mNodes = arrayList;
        Node node = new Node((TXCGPUImageFilter) null);
        this.mInitNode = node;
        arrayList.add(node);
    }

    private void doReverseDraw(Node node) {
        for (Node node2 : node.inputNodeMap.values()) {
            if (node2 != this.mInitNode && node2.glTexture == null) {
                doReverseDraw(node2);
            }
        }
        if (node.filter instanceof TXCGPUImageMultipleInputFilter) {
            TXCGPUImageMultipleInputFilter tXCGPUImageMultipleInputFilter = (TXCGPUImageMultipleInputFilter) node.filter;
            for (Map.Entry entry : node.inputNodeMap.entrySet()) {
                if (!INPUT_TEXTURE_NAME_FOR_ON_DRAW.equals(entry.getKey())) {
                    if (entry.getValue() == this.mInitNode) {
                        tXCGPUImageMultipleInputFilter.setInputTexture((String) entry.getKey(), this.mInputTextureId);
                    } else {
                        tXCGPUImageMultipleInputFilter.setInputTexture((String) entry.getKey(), ((Node) entry.getValue()).glTexture.getId());
                    }
                }
            }
        }
        GLTexture gLTexture = this.mOutputTexture;
        Size size = this.mOutputSize;
        int i11 = size.width;
        int i12 = size.height;
        if (node != this.mFinalNode) {
            i11 = node.filter.getOutputSize().width;
            i12 = node.filter.getOutputSize().height;
            GLTexture unused = node.glTexture = this.mTexturePool.obtain(i11, i12);
            gLTexture = node.glTexture;
        }
        Node node3 = (Node) node.inputNodeMap.get(INPUT_TEXTURE_NAME_FOR_ON_DRAW);
        GLES20.glViewport(0, 0, i11, i12);
        if (node3 == this.mInitNode) {
            node.filter.onDraw(this.mInputTextureId, gLTexture, this.mInputCubeCoordsBuffer, this.mInputTextureCoordsBuffer);
        } else {
            node.filter.onDraw(node3.glTexture.getId(), gLTexture, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
        }
        for (Node node4 : node.inputNodeMap.values()) {
            int intValue = this.mIndicesMap.get(node4).intValue();
            int[] iArr = this.mUsedCountOneDraw;
            iArr[intValue] = iArr[intValue] + 1;
            if (node4.glTexture != null && this.mUsedCountOneDraw[intValue] == node4.countAsInput) {
                node4.glTexture.release();
                GLTexture unused2 = node4.glTexture = null;
            }
        }
    }

    private Node findFinalNode() {
        int size = this.mNodes.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        int[] iArr = new int[2];
        iArr[1] = size;
        iArr[0] = size;
        boolean[][] zArr = (boolean[][]) Array.newInstance(boolean.class, iArr);
        for (int i12 = 0; i12 < this.mNodes.size(); i12++) {
            Arrays.fill(zArr[i12], false);
        }
        for (Node next : this.mNodes) {
            int intValue = this.mIndicesMap.get(next).intValue();
            for (Node node : next.inputNodeMap.values()) {
                zArr[this.mIndicesMap.get(node).intValue()][intValue] = true;
            }
        }
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        while (arrayList.size() > 1) {
            Arrays.fill(iArr2, 0);
            Arrays.fill(iArr3, 0);
            arrayList2.clear();
            for (int i13 = 0; i13 < size; i13++) {
                for (int i14 = 0; i14 < size; i14++) {
                    if (zArr[i13][i14]) {
                        iArr3[i13] = iArr3[i13] + 1;
                        iArr2[i14] = iArr2[i14] + 1;
                    }
                }
            }
            for (Integer intValue2 : arrayList) {
                int intValue3 = intValue2.intValue();
                if (iArr2[intValue3] == 0 && iArr3[intValue3] != 0) {
                    arrayList2.add(Integer.valueOf(intValue3));
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            arrayList.removeAll(arrayList2);
            for (Integer intValue4 : arrayList2) {
                Arrays.fill(zArr[intValue4.intValue()], false);
            }
        }
        if (arrayList.size() == 1) {
            return this.mNodes.get(((Integer) arrayList.get(0)).intValue());
        }
        return null;
    }

    public Node createNodeFromFilter(TXCGPUImageFilter tXCGPUImageFilter) {
        Node node = new Node(tXCGPUImageFilter);
        this.mNodes.add(node);
        return node;
    }

    public Node getInitNode() {
        return this.mInitNode;
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            this.mInputTextureId = i11;
            this.mOutputTexture = gLTexture;
            this.mInputCubeCoordsBuffer = floatBuffer;
            this.mInputTextureCoordsBuffer = floatBuffer2;
            Arrays.fill(this.mUsedCountOneDraw, 0);
            doReverseDraw(this.mFinalNode);
            for (Node access$200 : this.mNodes) {
                GLTexture unused = access$200.glTexture;
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        for (Node next : this.mNodes) {
            if (next.filter != null) {
                next.filter.initialize(gLTexturePool);
            }
        }
        for (int i11 = 0; i11 < this.mNodes.size(); i11++) {
            this.mIndicesMap.put(this.mNodes.get(i11), Integer.valueOf(i11));
        }
        Node findFinalNode = findFinalNode();
        this.mFinalNode = findFinalNode;
        if (findFinalNode != null) {
            this.mUsedCountOneDraw = new int[this.mNodes.size()];
            return;
        }
        throw new RuntimeException("Directed acyclic graph can't find a final node.");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        for (Node next : this.mNodes) {
            if (next.filter != null) {
                next.filter.onOutputSizeChanged(i11, i12);
            }
        }
    }

    public void onUninit() {
        super.onUninit();
        for (Node next : this.mNodes) {
            if (next.filter != null) {
                next.filter.uninitialize();
            }
        }
    }
}
