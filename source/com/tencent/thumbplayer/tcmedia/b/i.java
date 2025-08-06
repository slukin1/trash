package com.tencent.thumbplayer.tcmedia.b;

import android.util.Xml;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetExtraParam;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.b;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class i {
    private static String a(int i11, boolean z11) {
        return i11 == 1 ? z11 ? "av_tracks" : "av_track" : i11 == 2 ? z11 ? "video_tracks" : "video_track" : i11 == 3 ? z11 ? "audio_tracks" : "audio_track" : "";
    }

    public static String a(ITPMediaComposition iTPMediaComposition) {
        if (iTPMediaComposition == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        List<ITPMediaTrack> allAVTracks = iTPMediaComposition.getAllAVTracks();
        if (!b.a((Collection<? extends Object>) allAVTracks)) {
            a(newSerializer, allAVTracks, 1, 0);
        } else {
            List<ITPMediaTrack> allVideoTracks = iTPMediaComposition.getAllVideoTracks();
            List<ITPMediaTrack> allAudioTracks = iTPMediaComposition.getAllAudioTracks();
            if (b.a((Collection<? extends Object>) allVideoTracks) && b.a((Collection<? extends Object>) allAudioTracks)) {
                return "";
            }
            e eVar = (e) iTPMediaComposition;
            long a11 = eVar.a();
            a(newSerializer, allVideoTracks, 2, eVar.b());
            a(newSerializer, allAudioTracks, 3, a11);
        }
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    public static String a(ITPMediaDRMAsset iTPMediaDRMAsset) {
        if (iTPMediaDRMAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmPlayUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_drmType");
        newSerializer.text(String.valueOf(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapDrmType.class, iTPMediaDRMAsset.getDrmType())));
        newSerializer.endTag("", "clip_drmType");
        newSerializer.startTag("", "clip_drmProvisionUrl");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PROVISION_URL, "")));
        newSerializer.endTag("", "clip_drmProvisionUrl");
        newSerializer.startTag("", "clip_drmLicenseUrl");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, "")));
        newSerializer.endTag("", "clip_drmLicenseUrl");
        newSerializer.startTag("", "clip_drmUseL1");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_DRM_USEL1, "1"));
        newSerializer.endTag("", "clip_drmUseL1");
        newSerializer.startTag("", "clip_drmSavePath");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_SAVE_PATH, ""));
        newSerializer.endTag("", "clip_drmSavePath");
        newSerializer.startTag("", "clip_drmGuid");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_GUID, ""));
        newSerializer.endTag("", "clip_drmGuid");
        newSerializer.startTag("", "clip_drmPlatform");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PLATFORM, ""));
        newSerializer.endTag("", "clip_drmPlatform");
        newSerializer.startTag("", "clip_drmAppVersion");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_APPVER, ""));
        newSerializer.endTag("", "clip_drmAppVersion");
        newSerializer.startTag("", "clip_drmCookie");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_COOKIE, ""));
        newSerializer.endTag("", "clip_drmCookie");
        newSerializer.startTag("", "clip_drmLicenseStandardization");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_STANDARDIZATION, "0"));
        newSerializer.endTag("", "clip_drmLicenseStandardization");
        newSerializer.startTag("", "clip_drmCommonKey");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_EXT_X_KEY, ""));
        newSerializer.endTag("", "clip_drmCommonKey");
        newSerializer.startTag("", "clip_drmOfflineKeySetId");
        newSerializer.text(iTPMediaDRMAsset.getOfflineKeySetId());
        newSerializer.endTag("", "clip_drmOfflineKeySetId");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, (ITPMediaAsset) iTPMediaDRMAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    public static String a(ITPMediaRTCAsset iTPMediaRTCAsset) {
        if (iTPMediaRTCAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaRTCAsset.getRtcStreamUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_rtcServerUrl");
        newSerializer.text(a(iTPMediaRTCAsset.getRtcServerUrl()));
        newSerializer.endTag("", "clip_rtcServerUrl");
        newSerializer.startTag("", "clip_rtcSdpExchangeType");
        newSerializer.text(Integer.toString(iTPMediaRTCAsset.getRtcSdpExchangeType()));
        newSerializer.endTag("", "clip_rtcSdpExchangeType");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, (ITPMediaAsset) iTPMediaRTCAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    public static String a(ITPMediaUrlAsset iTPMediaUrlAsset) {
        if (iTPMediaUrlAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaUrlAsset.getStreamUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, (ITPMediaAsset) iTPMediaUrlAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    private static String a(String str) {
        return str.replaceAll("[^\t\r\n -퟿-�𐀀-􏿿]+", "");
    }

    public static String a(List<ITPMediaTrackClip> list, int i11) {
        String str;
        String str2;
        if (b.a((Collection<? extends Object>) list)) {
            return "";
        }
        if (i11 == 1) {
            str = "av_tracks";
            str2 = "av_track";
        } else if (i11 == 2) {
            str = "video_tracks";
            str2 = "video_track";
        } else if (i11 != 3) {
            return "";
        } else {
            str = "audio_tracks";
            str2 = "audio_track";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        a(newSerializer, list, str, str2);
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaAsset iTPMediaAsset) {
        ITPMediaAssetExtraParam extraParam = iTPMediaAsset.getExtraParam();
        if (extraParam != null) {
            a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_AUDIO);
            a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_SUBTITLE);
            a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_VIDEO);
        }
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaAssetExtraParam iTPMediaAssetExtraParam, String str) {
        c cVar = (c) iTPMediaAssetExtraParam.getExtraObject(str);
        if (cVar != null) {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(a(cVar.getKeyValueStr()));
            xmlSerializer.endTag("", str);
        }
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip) {
        a(xmlSerializer, iTPMediaTrackClip, 0);
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j11) {
        if (iTPMediaTrackClip instanceof a) {
            b(xmlSerializer, iTPMediaTrackClip, j11);
        } else if (iTPMediaTrackClip instanceof h) {
            c(xmlSerializer, iTPMediaTrackClip, j11);
        }
    }

    private static void a(XmlSerializer xmlSerializer, List<ITPMediaTrack> list, int i11, long j11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String a11 = a(i11, true);
                    String a12 = a(i11, false);
                    xmlSerializer.startTag("", a11);
                    for (ITPMediaTrack next : list) {
                        if (next.getMediaType() == i11) {
                            xmlSerializer.startTag("", a12);
                            xmlSerializer.startTag("", "track_id");
                            xmlSerializer.text(Integer.toString(next.getTrackId()));
                            xmlSerializer.endTag("", "track_id");
                            if (i11 != 1 && f.f48989a.equals("base_audio") && next.getTimelineDurationMs() > j11) {
                                long j12 = 0;
                                Iterator<ITPMediaTrackClip> it2 = next.getAllTrackClips().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    ITPMediaTrackClip next2 = it2.next();
                                    j12 += next2.getOriginalDurationMs();
                                    if (j12 > j11) {
                                        a(xmlSerializer, next2, j12 - j11);
                                        break;
                                    }
                                    a(xmlSerializer, next2);
                                }
                            } else {
                                for (ITPMediaTrackClip a13 : next.getAllTrackClips()) {
                                    a(xmlSerializer, a13);
                                }
                            }
                            xmlSerializer.endTag("", a12);
                        }
                    }
                    xmlSerializer.endTag("", a11);
                }
            } catch (IOException e11) {
                TPLogUtil.e("TPMediaCompositionXmlGenerator", (Throwable) e11);
            }
        }
    }

    private static void a(XmlSerializer xmlSerializer, List<ITPMediaTrackClip> list, String str, String str2) {
        xmlSerializer.startTag("", str);
        xmlSerializer.startTag("", str2);
        for (ITPMediaTrackClip a11 : list) {
            a(xmlSerializer, a11);
        }
        xmlSerializer.endTag("", str2);
        xmlSerializer.endTag("", str);
    }

    private static void b(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j11) {
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text("1");
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_playTimeMs");
        xmlSerializer.text(j11 > 0 ? Long.toString(iTPMediaTrackClip.getOriginalDurationMs() - j11) : Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        xmlSerializer.endTag("", "clip_playTimeMs");
        xmlSerializer.endTag("", "track_clip");
    }

    private static void c(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j11) {
        String str;
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text("0");
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_path");
        xmlSerializer.text(a(iTPMediaTrackClip.getFilePath()));
        xmlSerializer.endTag("", "clip_path");
        xmlSerializer.startTag("", "clip_startTimeMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getStartTimeMs()));
        xmlSerializer.endTag("", "clip_startTimeMs");
        xmlSerializer.startTag("", "clip_durationMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        xmlSerializer.endTag("", "clip_durationMs");
        if (j11 > 0) {
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getEndTimeMs() - j11));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            str = Long.toString(iTPMediaTrackClip.getOriginalDurationMs() - j11);
        } else {
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getEndTimeMs()));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            str = Long.toString(iTPMediaTrackClip.getOriginalDurationMs());
        }
        xmlSerializer.text(str);
        xmlSerializer.endTag("", "clip_playTimeMs");
        xmlSerializer.endTag("", "track_clip");
    }
}
