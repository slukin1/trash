package com.tencent.liteav.txcvodplayer.b;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.a;
import com.tencent.liteav.txcvodplayer.b.f;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import com.tencent.rtmp.TXPlayInfoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public TXPlayInfoParams f21895a;

    /* renamed from: b  reason: collision with root package name */
    public b f21896b;

    /* renamed from: c  reason: collision with root package name */
    public b f21897c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21898d = "https://playvideo.qcloud.com/getplayinfo/v4";

    /* renamed from: e  reason: collision with root package name */
    private final String f21899e = "https://bkplayvideo.qcloud.com/getplayinfo/v4";

    /* renamed from: f  reason: collision with root package name */
    private Handler f21900f;

    /* renamed from: g  reason: collision with root package name */
    private f f21901g;

    /* renamed from: h  reason: collision with root package name */
    private String f21902h;

    public interface a {
        void a(int i11, String str);

        void a(c cVar, TXPlayInfoParams tXPlayInfoParams);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f21916a;

        /* renamed from: b  reason: collision with root package name */
        public String f21917b;

        /* renamed from: c  reason: collision with root package name */
        public String f21918c;

        /* renamed from: d  reason: collision with root package name */
        public String f21919d;
    }

    /* renamed from: com.tencent.liteav.txcvodplayer.b.c$c  reason: collision with other inner class name */
    public static class C0172c {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f21920a;

        /* renamed from: b  reason: collision with root package name */
        public String f21921b;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f21922a;

        /* renamed from: b  reason: collision with root package name */
        public float f21923b;

        public final String toString() {
            return "TCPlayKeyFrameDescInfo{content='" + this.f21922a + '\'' + ", time=" + this.f21923b + '}';
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f21924a;

        /* renamed from: b  reason: collision with root package name */
        public int f21925b;

        /* renamed from: c  reason: collision with root package name */
        public int f21926c;

        /* renamed from: d  reason: collision with root package name */
        public String f21927d;

        /* renamed from: e  reason: collision with root package name */
        public long f21928e;

        /* renamed from: f  reason: collision with root package name */
        public String f21929f;
    }

    public c(TXPlayInfoParams tXPlayInfoParams) {
        this.f21895a = tXPlayInfoParams;
        this.f21900f = ThreadUtils.getUiThreadHandler();
    }

    private String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("subversion=1&");
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb2.append("pcfg=" + null + ContainerUtils.FIELD_DELIMITER);
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append("psign=" + str + ContainerUtils.FIELD_DELIMITER);
        }
        a(sb2);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb2.append("context=" + null + ContainerUtils.FIELD_DELIMITER);
        }
        if (sb2.length() > 1) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public final void a(final a aVar) {
        if (this.f21895a != null) {
            com.tencent.liteav.txcplayer.common.a.a().execute(new Runnable() {
                public final void run() {
                    AsyncTask.execute(new Runnable(new a.b() {
                        public final void a(String str, Map<String, String> map) {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            if (c.this.a(str, map, aVar)) {
                                c.this.a((Runnable) new Runnable() {
                                    public final void run() {
                                        AnonymousClass1 r02 = AnonymousClass1.this;
                                        a aVar = aVar;
                                        c cVar = c.this;
                                        aVar.a(cVar, cVar.f21895a);
                                    }
                                });
                            }
                        }

                        public final void a() {
                            c.this.a((Runnable) new Runnable() {
                                public final void run() {
                                    a aVar = aVar;
                                    if (aVar != null) {
                                        aVar.a(-1, "http request error.");
                                    }
                                }
                            });
                        }
                    }, c.this) {

                        /* renamed from: a */
                        public final /* synthetic */ b f21871a;

                        /* renamed from: b */
                        public final /* synthetic */ c f21872b;

                        /* renamed from: d */
                        private int f21874d;

                        /* renamed from: e */
                        private boolean f21875e;

                        /* renamed from: f */
                        private String f21876f;

                        private void a(
/*
Method generation error in method: com.tencent.liteav.txcvodplayer.b.a.1.a():void, dex: classes11.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.txcvodplayer.b.a.1.a():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/

                        private java.net.URLConnection b(
/*
Method generation error in method: com.tencent.liteav.txcvodplayer.b.a.1.b():java.net.URLConnection, dex: classes11.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.txcvodplayer.b.a.1.b():java.net.URLConnection, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run(
/*
Method generation error in method: com.tencent.liteav.txcvodplayer.b.a.1.run():void, dex: classes11.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.txcvodplayer.b.a.1.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                }
            });
        }
    }

    public final String c() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final String d() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21878a;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.g();
        }
        return null;
    }

    public final String e() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21879b;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.h();
        }
        return null;
    }

    public final int f() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21881d;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.b();
        }
        return -1;
    }

    public final long g() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21882e;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            if (fVar.f21949b == null) {
                fVar.f21949b = fVar.c();
            }
            g gVar = fVar.f21949b;
            if (gVar != null) {
                return gVar.f21956d;
            }
        }
        return -1;
    }

    public final C0172c h() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21886i;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.i();
        }
        return null;
    }

    public final List<d> i() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21887j;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.j();
        }
        return null;
    }

    public final List<e> j() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21884g;
        }
        f fVar = this.f21901g;
        if (fVar == null) {
            return null;
        }
        List<f.a> k11 = fVar.k();
        List<g> e11 = this.f21901g.e();
        if (k11 == null || k11.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(k11.size());
        for (f.a next : k11) {
            e eVar = new e();
            eVar.f21924a = next.f21951b;
            List<Integer> list = next.f21952c;
            if (list != null) {
                Iterator<g> it2 = e11.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    g next2 = it2.next();
                    if (list.contains(Integer.valueOf(next2.f21961i))) {
                        int i11 = next2.f21955c;
                        eVar.f21925b = i11;
                        eVar.f21926c = next2.f21954b;
                        if (i11 > 0) {
                            eVar.f21927d = "video";
                        }
                        arrayList.add(eVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final String k() {
        b bVar = this.f21896b;
        return bVar != null ? bVar.f21885h : "";
    }

    public final String l() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x010c A[Catch:{ JSONException -> 0x011f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010d A[Catch:{ JSONException -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, final com.tencent.liteav.txcvodplayer.b.c.a r12) {
        /*
            r9 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            java.lang.String r2 = "TXCPlayInfoProtocolV4"
            if (r0 == 0) goto L_0x0017
            java.lang.String r10 = "parseJson err, content is empty!"
            com.tencent.liteav.base.util.LiteavLog.e(r2, r10)
            com.tencent.liteav.txcvodplayer.b.c$2 r10 = new com.tencent.liteav.txcvodplayer.b.c$2
            r10.<init>(r12)
            r9.a((java.lang.Runnable) r10)
            return r1
        L_0x0017:
            r0 = 1
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011f }
            r3.<init>(r10)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = "code"
            int r4 = r3.getInt(r4)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r5 = "message"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r6 = "warning"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r7 = "context"
            java.lang.String r7 = r3.optString(r7)     // Catch:{ JSONException -> 0x011f }
            r9.f21902h = r7     // Catch:{ JSONException -> 0x011f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x011f }
            java.lang.String r8 = "context : "
            r7.<init>(r8)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r8 = r9.f21902h     // Catch:{ JSONException -> 0x011f }
            r7.append(r8)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r7)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r7 = "message: "
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r7)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r7 = "warning: "
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r6 = r7.concat(r6)     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r6)     // Catch:{ JSONException -> 0x011f }
            if (r4 != 0) goto L_0x0116
            java.lang.String r4 = "version"
            int r4 = r3.getInt(r4)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r5 = "version: "
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r5)     // Catch:{ JSONException -> 0x011f }
            r5 = 2
            if (r4 != r5) goto L_0x0088
            r10 = 0
            r9.f21897c = r10     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.txcvodplayer.b.f r10 = new com.tencent.liteav.txcvodplayer.b.f     // Catch:{ JSONException -> 0x011f }
            r10.<init>(r3)     // Catch:{ JSONException -> 0x011f }
            r9.f21901g = r10     // Catch:{ JSONException -> 0x011f }
            goto L_0x0138
        L_0x0088:
            r5 = 4
            if (r4 != r5) goto L_0x0138
            com.tencent.liteav.txcvodplayer.b.b r4 = new com.tencent.liteav.txcvodplayer.b.b     // Catch:{ JSONException -> 0x011f }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x011f }
            r9.f21896b = r4     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.txcvodplayer.b.c$b r3 = r9.f21897c     // Catch:{ JSONException -> 0x011f }
            if (r3 == 0) goto L_0x0109
            java.lang.String r3 = r3.f21917b     // Catch:{ JSONException -> 0x011f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x011f }
            if (r3 != 0) goto L_0x0109
            com.tencent.liteav.txcvodplayer.b.c$b r3 = r9.f21897c     // Catch:{ JSONException -> 0x011f }
            java.lang.String r3 = r3.f21916a     // Catch:{ JSONException -> 0x011f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x011f }
            if (r3 == 0) goto L_0x00a9
            goto L_0x0109
        L_0x00a9:
            if (r11 == 0) goto L_0x00b4
            java.lang.String r3 = "X-Vod-Checksum"
            java.lang.Object r11 = r11.get(r3)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x011f }
            goto L_0x00b6
        L_0x00b4:
            java.lang.String r11 = ""
        L_0x00b6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x011f }
            r3.<init>()     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.txcvodplayer.b.c$b r4 = r9.f21897c     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = r4.f21916a     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ JSONException -> 0x011f }
            r3.append(r4)     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.txcvodplayer.b.c$b r4 = r9.f21897c     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = r4.f21917b     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ JSONException -> 0x011f }
            r3.append(r4)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r4 = r10.trim()     // Catch:{ JSONException -> 0x011f }
            r3.append(r4)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x011f }
            java.lang.String r3 = com.tencent.liteav.txcplayer.a.a.b(r3)     // Catch:{ JSONException -> 0x011f }
            boolean r4 = android.text.TextUtils.equals(r11, r3)     // Catch:{ JSONException -> 0x011f }
            if (r4 != 0) goto L_0x0109
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x011f }
            java.lang.String r5 = "[checkResponseDataValid], response content not valid, vodChecksum="
            r4.<init>(r5)     // Catch:{ JSONException -> 0x011f }
            r4.append(r11)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r11 = " ,bodyMd5="
            r4.append(r11)     // Catch:{ JSONException -> 0x011f }
            r4.append(r3)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r11 = " ,content="
            r4.append(r11)     // Catch:{ JSONException -> 0x011f }
            r4.append(r10)     // Catch:{ JSONException -> 0x011f }
            java.lang.String r10 = r4.toString()     // Catch:{ JSONException -> 0x011f }
            com.tencent.liteav.base.util.LiteavLog.w(r2, r10)     // Catch:{ JSONException -> 0x011f }
            r10 = r1
            goto L_0x010a
        L_0x0109:
            r10 = r0
        L_0x010a:
            if (r10 == 0) goto L_0x010d
            return r0
        L_0x010d:
            com.tencent.liteav.txcvodplayer.b.c$3 r10 = new com.tencent.liteav.txcvodplayer.b.c$3     // Catch:{ JSONException -> 0x011f }
            r10.<init>(r12)     // Catch:{ JSONException -> 0x011f }
            r9.a((java.lang.Runnable) r10)     // Catch:{ JSONException -> 0x011f }
            return r1
        L_0x0116:
            com.tencent.liteav.txcvodplayer.b.c$4 r10 = new com.tencent.liteav.txcvodplayer.b.c$4     // Catch:{ JSONException -> 0x011f }
            r10.<init>(r12, r4, r5)     // Catch:{ JSONException -> 0x011f }
            r9.a((java.lang.Runnable) r10)     // Catch:{ JSONException -> 0x011f }
            return r1
        L_0x011f:
            r10 = move-exception
            r10.printStackTrace()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "parseJson err: "
            r11.<init>(r12)
            java.lang.String r10 = com.tencent.liteav.base.Log.getStackTraceString(r10)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.tencent.liteav.base.util.LiteavLog.e(r2, r10)
        L_0x0138:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.b.c.a(java.lang.String, java.util.Map, com.tencent.liteav.txcvodplayer.b.c$a):boolean");
    }

    public final String b() {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.f21880c;
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public final String a(boolean z11) {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = z11 ? "https://bkplayvideo.qcloud.com/getplayinfo/v4" : "https://playvideo.qcloud.com/getplayinfo/v4";
        objArr[1] = Integer.valueOf(this.f21895a.getAppId());
        objArr[2] = this.f21895a.getFileId();
        String format = String.format(locale, "%s/%d/%s", objArr);
        String str = null;
        if (this.f21895a.getPSign() != null) {
            str = b(this.f21895a.getPSign());
        }
        if (!TextUtils.isEmpty(str)) {
            format = format + "?" + str;
        }
        LiteavLog.d("TXCPlayInfoProtocolV4", "request url: ".concat(String.valueOf(format)));
        return format;
    }

    private void a(StringBuilder sb2) {
        b a11 = com.tencent.liteav.txcvodplayer.c.a.a().a(this.f21895a.getAppId(), this.f21895a.getFileId());
        this.f21897c = a11;
        if (a11 == null || TextUtils.isEmpty(a11.f21916a)) {
            b bVar = new b();
            this.f21897c = bVar;
            bVar.f21916a = TXCHLSEncoder.a();
            this.f21897c.f21917b = TXCHLSEncoder.a();
        }
        LiteavLog.i("TXCPlayInfoProtocolV4", "V4 protocol send request fileId : " + this.f21895a.getFileId() + " | overlayKey: " + this.f21897c.f21916a + " | overlayIv: " + this.f21897c.f21917b);
        if (TextUtils.isEmpty(this.f21897c.f21918c)) {
            b bVar2 = this.f21897c;
            bVar2.f21918c = TXCHLSEncoder.a(bVar2.f21916a);
            b bVar3 = this.f21897c;
            bVar3.f21919d = TXCHLSEncoder.a(bVar3.f21917b);
        }
        String str = (TextUtils.isEmpty(this.f21897c.f21918c) || TextUtils.isEmpty(this.f21897c.f21919d)) ? "" : "1";
        if (!TextUtils.isEmpty(str)) {
            sb2.append("cipheredOverlayKey=");
            sb2.append(this.f21897c.f21918c);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append("cipheredOverlayIv=");
            sb2.append(this.f21897c.f21919d);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append("keyId=");
            sb2.append(str);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
        }
    }

    public final String a() {
        b bVar = this.f21896b;
        if (bVar != null) {
            String a11 = bVar.a("SimpleAES");
            if (!TextUtils.isEmpty(a11)) {
                return a11;
            }
            return this.f21896b.a(ChainInfo.CHAIN_TYPE_PLAIN);
        }
        f fVar = this.f21901g;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public final String a(String str) {
        b bVar = this.f21896b;
        if (bVar != null) {
            return bVar.a(str);
        }
        return null;
    }

    public final void a(Runnable runnable) {
        if (ThreadUtils.runningOnUiThread()) {
            runnable.run();
        } else {
            this.f21900f.post(runnable);
        }
    }
}
