package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcplayer.model.TXSubtitleRenderModel;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.d;
import com.tencent.liteav.txcvodplayer.renderer.g;
import com.tencent.liteav.txcvodplayer.renderer.k;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.rtmp.ui.TXSubtitleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TXVodPlayer {
    public static final String TAG = "TXVodPlayer";
    private final a mPlayer;

    public TXVodPlayer(Context context) {
        this.mPlayer = new a(context);
    }

    public static String getEncryptedPlayKey(String str) {
        return a.b(str);
    }

    public void addSubtitleSource(String str, String str2, String str3) {
        LiteavLog.i(TAG, "setSubtitleView url =" + str + " ,name=" + str2 + " ,mimeType=" + str3 + " ,player=" + hashCode());
        TXCVodVideoView tXCVodVideoView = this.mPlayer.f21273e;
        if (!TextUtils.isEmpty(str)) {
            ITXVCubePlayer iTXVCubePlayer = tXCVodVideoView.f21792c;
            if (iTXVCubePlayer != null) {
                iTXVCubePlayer.addSubtitleSource(str, str2, str3);
            }
            if (tXCVodVideoView.f21797h == null) {
                tXCVodVideoView.f21797h = new ArrayList();
            }
            tXCVodVideoView.f21797h.add(new TXCVodVideoView.b(str, str2, str3));
        }
    }

    public void attachTRTC(Object obj) {
        LiteavLog.i(TAG, "attachTRTC=" + obj + " player=" + hashCode());
        a aVar = this.mPlayer;
        if (obj != null) {
            aVar.B = obj;
            if (aVar.A == null) {
                d dVar = new d(aVar);
                aVar.A = dVar;
                synchronized (dVar) {
                    if (dVar.f22017a != null) {
                        LiteavLog.w("VodRenderer", "VodRenderer is initialized!");
                    } else {
                        LiteavLog.i("VodRenderer", "initialize VodRenderer");
                        HandlerThread handlerThread = new HandlerThread("VodRenderer_" + dVar.hashCode());
                        handlerThread.start();
                        dVar.f22017a = new CustomHandler(handlerThread.getLooper());
                        dVar.a(k.a(dVar), "initialize");
                    }
                }
            }
            TXCVodVideoView tXCVodVideoView = aVar.f21273e;
            tXCVodVideoView.f21796g = obj;
            ITXVCubePlayer iTXVCubePlayer = tXCVodVideoView.f21792c;
            if (iTXVCubePlayer != null) {
                iTXVCubePlayer.attachTRTC(obj);
            }
        }
    }

    public void deselectTrack(int i11) {
        LiteavLog.i(TAG, "deselectTrack trackIndex =" + i11 + " ,player=" + hashCode());
        this.mPlayer.f21273e.a(i11);
    }

    public void detachTRTC() {
        LiteavLog.i(TAG, "detachTRTC player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.B = null;
        d dVar = aVar.A;
        if (dVar != null) {
            dVar.a(false);
            dVar.a((Runnable) new Runnable() {
                public final void run(
/*
Method generation error in method: com.tencent.liteav.txcvodplayer.renderer.d.1.run():void, dex: classes11.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.txcvodplayer.renderer.d.1.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
            }, "uninitialize");
            aVar.A = null;
        }
        aVar.e();
        aVar.c();
        TXCVodVideoView tXCVodVideoView = aVar.f21273e;
        tXCVodVideoView.f21796g = null;
        ITXVCubePlayer iTXVCubePlayer = tXCVodVideoView.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.detachTRTC();
        }
    }

    public boolean enableHardwareDecode(boolean z11) {
        LiteavLog.i(TAG, "enableHardwareDecode=" + z11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        if (z11) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
                LiteavLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + LiteavSystemInfo.getSystemOSVersionInt() + ", the minimum build.version should be 18(android 4.3 or later)");
                return false;
            }
            if (LiteavSystemInfo.getManufacturer().equalsIgnoreCase("HUAWEI") && LiteavSystemInfo.getModel().equalsIgnoreCase("Che2-TL00")) {
                LiteavLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + LiteavSystemInfo.getManufacturer() + ", MODEL" + LiteavSystemInfo.getModel());
                return false;
            }
        }
        aVar.f21279k = z11;
        aVar.a(aVar.f21274f);
        return true;
    }

    public List<TXTrackInfo> getAudioTrackInfo() {
        List<TXTrackInfo> a11 = this.mPlayer.a();
        if (a11.isEmpty()) {
            return new ArrayList(0);
        }
        return a.a(a11, 2);
    }

    public int getBitrateIndex() {
        return this.mPlayer.f21273e.getBitrateIndex();
    }

    public float getBufferDuration() {
        return ((float) this.mPlayer.f21273e.getBufferDuration()) / 1000.0f;
    }

    public float getCurrentPlaybackTime() {
        return ((float) this.mPlayer.f21273e.getCurrentPosition()) / 1000.0f;
    }

    public float getDuration() {
        return ((float) this.mPlayer.f21273e.getDuration()) / 1000.0f;
    }

    public int getHeight() {
        return this.mPlayer.f21273e.getVideoHeight();
    }

    public float getPlayableDuration() {
        return ((float) this.mPlayer.f21273e.getBufferDuration()) / 1000.0f;
    }

    public List<TXTrackInfo> getSubtitleTrackInfo() {
        List<TXTrackInfo> a11 = this.mPlayer.a();
        if (a11.isEmpty()) {
            return new ArrayList(0);
        }
        return a.a(a11, 3);
    }

    public ArrayList<TXBitrateItem> getSupportedBitrates() {
        a aVar = this.mPlayer;
        ArrayList<TXBitrateItem> arrayList = new ArrayList<>();
        ArrayList<com.tencent.liteav.txcplayer.model.a> supportedBitrates = aVar.f21273e.getSupportedBitrates();
        if (supportedBitrates != null) {
            Iterator<com.tencent.liteav.txcplayer.model.a> it2 = supportedBitrates.iterator();
            while (it2.hasNext()) {
                com.tencent.liteav.txcplayer.model.a next = it2.next();
                TXBitrateItem tXBitrateItem = new TXBitrateItem();
                tXBitrateItem.index = next.f21754a;
                tXBitrateItem.width = next.f21755b;
                tXBitrateItem.height = next.f21756c;
                tXBitrateItem.bitrate = next.f21757d;
                arrayList.add(tXBitrateItem);
            }
        }
        return arrayList;
    }

    public int getWidth() {
        return this.mPlayer.f21273e.getVideoWidth();
    }

    public boolean isLoop() {
        return this.mPlayer.f21293y;
    }

    public boolean isPlaying() {
        TXCVodVideoView tXCVodVideoView = this.mPlayer.f21273e;
        return tXCVodVideoView.b() && tXCVodVideoView.f21792c.isPlaying() && tXCVodVideoView.f21779a != 4;
    }

    public void pause() {
        LiteavLog.i(TAG, "pause player=" + hashCode());
        a aVar = this.mPlayer;
        TXCVodVideoView tXCVodVideoView = aVar.f21273e;
        tXCVodVideoView.f21791b = 4;
        LiteavLog.i("TXCVodVideoView", "pause vod=" + tXCVodVideoView.hashCode());
        if (tXCVodVideoView.b()) {
            try {
                tXCVodVideoView.f21792c.pause();
                tXCVodVideoView.f21806r.removeMessages(103);
            } catch (Exception e11) {
                LiteavLog.e("TXCVodVideoView", "pause exception: " + e11.getMessage());
            }
            tXCVodVideoView.f21779a = 4;
        }
        com.tencent.liteav.txcvodplayer.a.a aVar2 = aVar.f21275g;
        if (aVar2 != null) {
            LiteavLog.i("TXCVodPlayCollection", "pause " + aVar2.f21844k);
            if (!aVar2.f21839f) {
                aVar2.f21844k += System.currentTimeMillis() - aVar2.f21837d;
            }
            aVar2.f21839f = true;
            aVar2.f21837d = System.currentTimeMillis();
        }
    }

    public void publishAudio() {
        LiteavLog.i(TAG, "publishAudio player=" + hashCode());
        this.mPlayer.d();
    }

    public void publishVideo() {
        LiteavLog.i(TAG, "publishVideo player=" + hashCode());
        this.mPlayer.b();
    }

    public void resume() {
        LiteavLog.i(TAG, "resume player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21273e.setAutoPlay(true);
        aVar.f21273e.b(false);
        com.tencent.liteav.txcvodplayer.a.a aVar2 = aVar.f21275g;
        if (aVar2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aVar2.f21837d = currentTimeMillis;
            if (aVar2.f21840g) {
                aVar2.f21836c = currentTimeMillis;
                aVar2.f21840g = false;
            }
            LiteavLog.i("TXCVodPlayCollection", "[resume], mBeginPlayTS = " + aVar2.f21837d + " ,mIsPreLoading = " + aVar2.f21840g);
            aVar2.f21839f = false;
        }
    }

    public void seek(int i11) {
        LiteavLog.i(TAG, "seek time=" + i11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        float f11 = (float) i11;
        TXVodPlayConfig tXVodPlayConfig = aVar.f21274f;
        aVar.a(f11, tXVodPlayConfig != null ? tXVodPlayConfig.isEnableAccurateSeek() : false);
    }

    public void seekToPdtTime(long j11) {
        com.tencent.liteav.txcvodplayer.a.a aVar;
        LiteavLog.i(TAG, "seek pdtTimeMs=" + j11 + " player=" + hashCode());
        a aVar2 = this.mPlayer;
        TXCVodVideoView tXCVodVideoView = aVar2.f21273e;
        if (!tXCVodVideoView.f21798i) {
            LiteavLog.i("TXCVodVideoView", "has no advanced license! not support PDT seek. vod=" + tXCVodVideoView.hashCode());
        } else {
            LiteavLog.i("TXCVodVideoView", "seek to " + j11 + "vod=" + tXCVodVideoView.hashCode());
            int positionMs = (int) tXCVodVideoView.f21792c.getPositionMs(j11);
            if (positionMs >= 0) {
                int min = Math.min(positionMs, tXCVodVideoView.getDuration());
                e eVar = tXCVodVideoView.f21793d;
                tXCVodVideoView.a(min, eVar != null ? eVar.f21735i : false);
            }
        }
        if (aVar2.f21276h && (aVar = aVar2.f21275g) != null) {
            aVar.f();
        }
    }

    public void selectTrack(int i11) {
        LiteavLog.i(TAG, "selectTrack trackIndex =" + i11 + " ,player=" + hashCode());
        this.mPlayer.c(i11);
    }

    public void setAudioNormalization(float f11) {
        this.mPlayer.f21273e.setAudioNormalization(f11);
    }

    public void setAudioPlayoutVolume(int i11) {
        LiteavLog.i(TAG, "setAudioPlayoutVolume=" + i11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21290v = i11;
        aVar.f21273e.setAudioPlayoutVolume(i11);
    }

    public void setAutoPlay(boolean z11) {
        LiteavLog.i(TAG, "setAutoPlay=" + z11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21278j = z11;
        aVar.f21273e.setAutoPlay(z11);
    }

    public void setBitrateIndex(int i11) {
        LiteavLog.i(TAG, "setBitrateIndex=" + i11 + " player=" + hashCode());
        this.mPlayer.d(i11);
    }

    public void setConfig(TXVodPlayConfig tXVodPlayConfig) {
        this.mPlayer.a(tXVodPlayConfig);
    }

    public void setLoop(boolean z11) {
        LiteavLog.i(TAG, "setLoop=" + z11 + " player=" + hashCode());
        this.mPlayer.f21293y = z11;
    }

    public void setMirror(boolean z11) {
        LiteavLog.i(TAG, "setMirror=" + z11 + " player=" + hashCode());
        this.mPlayer.b(z11);
    }

    public void setMute(boolean z11) {
        LiteavLog.i(TAG, "setMute=" + z11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21289u = z11;
        aVar.f21273e.setMute(z11);
    }

    @Deprecated
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        LiteavLog.i(TAG, "setPlayListener=" + iTXLivePlayListener + " player=" + hashCode());
        this.mPlayer.f21270b = iTXLivePlayListener;
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        LiteavLog.i(TAG, "setPlayerView TXCloudVideoView=" + tXCloudVideoView + " player=" + hashCode());
        a aVar = this.mPlayer;
        TXCloudVideoView tXCloudVideoView2 = aVar.f21269a;
        if (tXCloudVideoView != tXCloudVideoView2) {
            if (tXCloudVideoView2 != null) {
                tXCloudVideoView2.removeVideoView();
            }
            if (tXCloudVideoView != null) {
                tXCloudVideoView.removeVideoView();
            }
        }
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setVisibility(0);
            if (aVar.A == null || aVar.B == null) {
                if (TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView) == null) {
                    TextureRenderView textureRenderView = new TextureRenderView(tXCloudVideoView.getContext());
                    tXCloudVideoView.addVideoView(textureRenderView);
                    aVar.f21273e.setTextureRenderView(textureRenderView);
                }
            } else if (TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView) == null) {
                tXCloudVideoView.addVideoView(new TextureView(tXCloudVideoView.getContext()));
                d dVar = aVar.A;
                dVar.a(g.a(dVar, new DisplayTarget(tXCloudVideoView)), "setDisplayTarget");
            }
            a.a(tXCloudVideoView, 0);
        }
        aVar.f21269a = tXCloudVideoView;
    }

    public void setRate(float f11) {
        LiteavLog.i(TAG, "setRate=" + f11 + " player=" + hashCode());
        this.mPlayer.a(f11);
    }

    public void setRenderMode(int i11) {
        LiteavLog.i(TAG, "setRenderMode=" + i11 + " player=" + hashCode());
        this.mPlayer.a(i11);
    }

    public void setRenderRotation(int i11) {
        LiteavLog.i(TAG, "setRenderRotation=" + i11 + " player=" + hashCode());
        this.mPlayer.b(i11);
    }

    public boolean setRequestAudioFocus(boolean z11) {
        LiteavLog.i(TAG, "setRequestAudioFocus=" + z11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21277i = z11;
        return aVar.f21273e.c(z11);
    }

    public void setStartTime(float f11) {
        LiteavLog.i(TAG, "setStartTime=" + f11 + " player=" + hashCode());
        this.mPlayer.b(f11);
    }

    public void setStringOption(String str, Object obj) {
        LiteavLog.i(TAG, "setStringOption key=" + str + " value=" + obj + "player=" + hashCode());
        TXCVodVideoView tXCVodVideoView = this.mPlayer.f21273e;
        if (!TextUtils.isEmpty(str)) {
            if ((TextUtils.equals(str, "PARAM_MODULE_TYPE") || TextUtils.equals(str, "PARAM_SUPER_RESOLUTION_TYPE")) && obj != null && (obj instanceof Integer)) {
                int intValue = ((Integer) obj).intValue();
                RenderProcessService.getInstance().updateRenderProcessMode(tXCVodVideoView.f21792c, intValue);
                LiteavLog.i("TXCVodVideoView", "updateRenderProcessMode:".concat(String.valueOf(intValue)));
            }
            if (TextUtils.equals(str, TXVodConstants.VOD_KEY_BACKUP_URL)) {
                if (obj == null || !(obj instanceof String)) {
                    tXCVodVideoView.f21802n = "";
                } else {
                    tXCVodVideoView.f21802n = (String) obj;
                }
                LiteavLog.i("TXCVodVideoView", "mBackupPlayUrl:" + tXCVodVideoView.f21802n);
            }
            if (!TextUtils.equals(str, TXVodConstants.VOD_KEY_MIMETYPE)) {
                return;
            }
            if (obj == null || !(obj instanceof String)) {
                tXCVodVideoView.f21801m = false;
            } else if (((String) obj).equals("video/hevc")) {
                tXCVodVideoView.f21801m = true;
                if (!TXCVodVideoView.f21778l) {
                    TXCVodVideoView.f21778l = true;
                    com.tencent.liteav.txcplayer.common.a.a().execute(new Runnable() {
                        public final void run(
/*
Method generation error in method: com.tencent.liteav.txcvodplayer.TXCVodVideoView.4.run():void, dex: classes11.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.txcvodplayer.TXCVodVideoView.4.run():void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
            }
        }
    }

    public void setSubtitleStyle(TXSubtitleRenderModel tXSubtitleRenderModel) {
        this.mPlayer.f21273e.setSubtitleStyle(tXSubtitleRenderModel);
    }

    public void setSubtitleView(TXSubtitleView tXSubtitleView) {
        LiteavLog.i(TAG, "setSubtitleView view =" + tXSubtitleView + " player=" + hashCode());
        this.mPlayer.C = tXSubtitleView;
    }

    public void setSurface(Surface surface) {
        LiteavLog.i(TAG, "setSurface Surface=" + surface + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21280l = surface;
        aVar.f21273e.setRenderSurface(surface);
    }

    public void setToken(String str) {
        LiteavLog.i(TAG, "setToken=" + str + " player=" + hashCode());
        this.mPlayer.f21282n = str;
    }

    public void setVodListener(ITXVodPlayListener iTXVodPlayListener) {
        LiteavLog.i(TAG, "setVodListener=" + iTXVodPlayListener + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21272d = this;
        aVar.f21271c = iTXVodPlayListener;
    }

    public void setVodSubtitleDataListener(ITXVodPlayListener.ITXVodSubtitleDataListener iTXVodSubtitleDataListener) {
        a aVar = this.mPlayer;
        aVar.f21273e.setTXCOnSubtitleDataListener(new ITXVCubePlayer.i(iTXVodSubtitleDataListener) {

            /* renamed from: a */
            public final /* synthetic */ ITXVodPlayListener.ITXVodSubtitleDataListener f21303a;

            public final void a(
/*
Method generation error in method: com.tencent.liteav.a.6.a(com.tencent.liteav.txcplayer.ITXVCubePlayer, com.tencent.thumbplayer.tcmedia.api.TPSubtitleData):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.6.a(com.tencent.liteav.txcplayer.ITXVCubePlayer, com.tencent.thumbplayer.tcmedia.api.TPSubtitleData):void, class status: UNLOADED
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

    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        LiteavLog.i(TAG, "snapshot=" + iTXSnapshotListener + " player=" + hashCode());
        a aVar = this.mPlayer;
        if (!aVar.f21285q && iTXSnapshotListener != null) {
            aVar.f21285q = true;
            TextureView textureViewSetByUser = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(aVar.f21269a);
            if (textureViewSetByUser != null) {
                Bitmap bitmap = textureViewSetByUser.getBitmap();
                if (bitmap != null) {
                    Matrix transform = textureViewSetByUser.getTransform((Matrix) null);
                    if (aVar.f21292x) {
                        transform.postScale(-1.0f, 1.0f);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), transform, true);
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(iTXSnapshotListener, bitmap) {

                    /* renamed from: a */
                    public final /* synthetic */ TXLivePlayer.ITXSnapshotListener f21300a;

                    /* renamed from: b */
                    public final /* synthetic */ Bitmap f21301b;

                    public final void run(
/*
Method generation error in method: com.tencent.liteav.a.5.run():void, dex: classes11.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.5.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                return;
            }
            aVar.f21285q = false;
        }
    }

    public int startPlayDrm(TXPlayerDrmBuilder tXPlayerDrmBuilder) {
        LiteavLog.i(TAG, "startPlayDrm [PlayUrl=" + tXPlayerDrmBuilder.mPlayUrl + "][KeyLicenseUrl=" + tXPlayerDrmBuilder.mKeyLicenseUrl + "][ProvisionUrl=" + tXPlayerDrmBuilder.getDeviceCertificateUrl() + "][player=" + hashCode() + "]");
        a aVar = this.mPlayer;
        aVar.f21286r = null;
        return aVar.a(tXPlayerDrmBuilder.getPlayUrl(), tXPlayerDrmBuilder.getKeyLicenseUrl(), tXPlayerDrmBuilder.getDeviceCertificateUrl(), (String) null, (c.b) null);
    }

    public int startVodPlay(String str) {
        LiteavLog.i(TAG, "StartPlay url=" + str + " player=" + hashCode());
        a aVar = this.mPlayer;
        aVar.f21286r = null;
        if (TextUtils.equals(str, aVar.f21288t)) {
            Object obj = aVar.f21283o.get("TXC_DRM_ENABLE");
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return aVar.a(str, (String) aVar.f21283o.get("TXC_DRM_KEY_URL"), new TXPlayerDrmBuilder().getDeviceCertificateUrl(), (String) aVar.f21283o.get("TXC_DRM_SIMPLE_AES_URL"), aVar.f21287s);
            }
        } else {
            aVar.f21287s = null;
        }
        aVar.g();
        return aVar.a(str);
    }

    public int stopPlay(boolean z11) {
        LiteavLog.i(TAG, "stopPlay needClearLastImg=" + z11 + " player=" + hashCode());
        return this.mPlayer.a(z11);
    }

    public void unpublishAudio() {
        LiteavLog.i(TAG, "unpublishAudio player=" + hashCode());
        this.mPlayer.e();
    }

    public void unpublishVideo() {
        LiteavLog.i(TAG, "unpublishVideo player=" + hashCode());
        this.mPlayer.c();
    }

    public void seek(float f11) {
        LiteavLog.i(TAG, "seek time=" + f11 + " player=" + hashCode());
        a aVar = this.mPlayer;
        TXVodPlayConfig tXVodPlayConfig = aVar.f21274f;
        aVar.a(f11, tXVodPlayConfig != null ? tXVodPlayConfig.isEnableAccurateSeek() : false);
    }

    public void seek(float f11, boolean z11) {
        LiteavLog.i(TAG, "seek time=" + f11 + ", isAccurateSeek=" + z11 + ", player=" + hashCode());
        this.mPlayer.a(f11, z11);
    }

    @Deprecated
    public int startVodPlay(TXPlayerAuthBuilder tXPlayerAuthBuilder) {
        LiteavLog.i(TAG, "startPlay [FileId=" + tXPlayerAuthBuilder.fileId + "][Timeout=" + tXPlayerAuthBuilder.timeout + "][Unique identification request=" + tXPlayerAuthBuilder.f48603us + "][Trial duration=" + tXPlayerAuthBuilder.exper + "][Sign=" + tXPlayerAuthBuilder.sign + "][player=" + hashCode() + "]");
        a aVar = this.mPlayer;
        aVar.f21286r = null;
        aVar.g();
        aVar.f21287s = null;
        com.tencent.liteav.txcvodplayer.b.d dVar = new com.tencent.liteav.txcvodplayer.b.d();
        aVar.f21291w = dVar;
        dVar.f21932c = tXPlayerAuthBuilder.isHttps();
        aVar.f21291w.a(new com.tencent.liteav.txcvodplayer.b.e() {
            public final void a(
/*
Method generation error in method: com.tencent.liteav.a.1.a(com.tencent.liteav.txcvodplayer.b.d):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.1.a(com.tencent.liteav.txcvodplayer.b.d):void, class status: UNLOADED
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
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void a(
/*
Method generation error in method: com.tencent.liteav.a.1.a(com.tencent.liteav.txcvodplayer.b.d, java.lang.String, int):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.1.a(com.tencent.liteav.txcvodplayer.b.d, java.lang.String, int):void, class status: UNLOADED
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
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
        LiteavLog.i("TXCVodPlayer", "startPlay [FileId:" + tXPlayerAuthBuilder.getFileId() + "][Timeout:" + tXPlayerAuthBuilder.getTimeout() + "][Unique identification request:" + tXPlayerAuthBuilder.getUs() + "][Trial duration:" + tXPlayerAuthBuilder.getExper() + "][Sign:" + tXPlayerAuthBuilder.getSign() + "]");
        return aVar.f21291w.a(tXPlayerAuthBuilder.getAppId(), tXPlayerAuthBuilder.getFileId(), tXPlayerAuthBuilder.getTimeout(), tXPlayerAuthBuilder.getUs(), tXPlayerAuthBuilder.getExper(), tXPlayerAuthBuilder.getSign());
    }

    public void setPlayerView(TextureRenderView textureRenderView) {
        LiteavLog.i(TAG, "setPlayerView TextureRenderView=" + textureRenderView + " player=" + hashCode());
        this.mPlayer.f21273e.setRenderView(textureRenderView);
    }

    public void startVodPlay(TXPlayInfoParams tXPlayInfoParams) {
        LiteavLog.i(TAG, "startPlay [FileId=" + tXPlayInfoParams.mFileId + "][AppId=" + tXPlayInfoParams.mAppId + "][PSign=" + tXPlayInfoParams.mPSign + "][player=" + hashCode() + "]");
        a aVar = this.mPlayer;
        aVar.f21286r = tXPlayInfoParams;
        aVar.g();
        int i11 = aVar.f21284p;
        aVar.a(false);
        aVar.f21284p = i11;
        aVar.f21281m = false;
        new c(tXPlayInfoParams).a((c.a) new c.a(tXPlayInfoParams) {

            /* renamed from: a */
            public final /* synthetic */ TXPlayInfoParams f21296a;

            public final void a(
/*
Method generation error in method: com.tencent.liteav.a.2.a(com.tencent.liteav.txcvodplayer.b.c, com.tencent.rtmp.TXPlayInfoParams):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.2.a(com.tencent.liteav.txcvodplayer.b.c, com.tencent.rtmp.TXPlayInfoParams):void, class status: UNLOADED
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
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void a(
/*
Method generation error in method: com.tencent.liteav.a.2.a(int, java.lang.String):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.a.2.a(int, java.lang.String):void, class status: UNLOADED
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
}
