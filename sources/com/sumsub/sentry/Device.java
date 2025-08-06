package com.sumsub.sentry;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.vulcan.model.VulcanInfo;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.c0;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.o1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00012\u00020\u0001:\u0004\b\n\u0001B\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010h\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010h\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010h\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010|\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010,¢\u0006\u0006\b\u0001\u0010\u0001B\u0014\b\u0010\u0012\u0007\u0010\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u0001\u0010\u0001B¡\u0003\b\u0017\u0012\u0007\u0010\u0001\u001a\u00020h\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010,\u0012\n\b\u0001\u00109\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010=\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010D\u001a\u0004\u0018\u00010>\u0012\n\b\u0001\u0010H\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010P\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010T\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010X\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010[\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010_\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010b\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010e\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010g\u001a\u0004\u0018\u00010I\u0012\n\b\u0001\u0010o\u001a\u0004\u0018\u00010h\u0012\n\b\u0001\u0010s\u001a\u0004\u0018\u00010h\u0012\n\b\u0001\u0010w\u001a\u0004\u0018\u00010,\u0012\n\b\u0001\u0010{\u001a\u0004\u0018\u00010h\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010|\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010,\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\rR\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001a\u0010\rR\"\u0010 \u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001e\u0010\rR\"\u0010$\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b!\u0010\u000b\u0012\u0004\b#\u0010\u000f\u001a\u0004\b\"\u0010\rR0\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u000f\u001a\u0004\b\b\u0010(\"\u0004\b\b\u0010)R*\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010-\u0012\u0004\b0\u0010\u000f\u001a\u0004\b\u0011\u0010.\"\u0004\b\b\u0010/R*\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b3\u00104\u0012\u0004\b8\u0010\u000f\u001a\u0004\b5\u00106\"\u0004\b\b\u00107R*\u0010=\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b:\u00104\u0012\u0004\b<\u0010\u000f\u001a\u0004\b;\u00106\"\u0004\b\u0011\u00107R\"\u0010D\u001a\u0004\u0018\u00010>8\u0006X\u0004¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bC\u0010\u000f\u001a\u0004\bA\u0010BR*\u0010H\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bE\u00104\u0012\u0004\bG\u0010\u000f\u001a\u0004\bF\u00106\"\u0004\b\u0015\u00107R*\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bJ\u0010K\u0012\u0004\bO\u0010\u000f\u001a\u0004\bL\u0010M\"\u0004\b\u0019\u0010NR*\u0010T\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bQ\u0010K\u0012\u0004\bS\u0010\u000f\u001a\u0004\bR\u0010M\"\u0004\b\u0011\u0010NR\"\u0010X\u001a\u0004\u0018\u00010I8\u0006X\u0004¢\u0006\u0012\n\u0004\bU\u0010K\u0012\u0004\bW\u0010\u000f\u001a\u0004\bV\u0010MR*\u0010[\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001a\u00104\u0012\u0004\bZ\u0010\u000f\u001a\u0004\bY\u00106\"\u0004\b\n\u00107R*\u0010_\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\\\u0010K\u0012\u0004\b^\u0010\u000f\u001a\u0004\b]\u0010M\"\u0004\b\u001d\u0010NR*\u0010b\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bR\u0010K\u0012\u0004\ba\u0010\u000f\u001a\u0004\b`\u0010M\"\u0004\b\u0015\u0010NR*\u0010e\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bc\u0010K\u0012\u0004\bd\u0010\u000f\u001a\u0004\bQ\u0010M\"\u0004\b\n\u0010NR*\u0010g\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b`\u0010K\u0012\u0004\bf\u0010\u000f\u001a\u0004\bE\u0010M\"\u0004\b\b\u0010NR*\u0010o\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bi\u0010j\u0012\u0004\bn\u0010\u000f\u001a\u0004\bk\u0010l\"\u0004\b\u0011\u0010mR*\u0010s\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bp\u0010j\u0012\u0004\br\u0010\u000f\u001a\u0004\bq\u0010l\"\u0004\b\n\u0010mR*\u0010w\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bt\u0010-\u0012\u0004\bv\u0010\u000f\u001a\u0004\bu\u0010.\"\u0004\b\u0011\u0010/R*\u0010{\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bx\u0010j\u0012\u0004\bz\u0010\u000f\u001a\u0004\by\u0010l\"\u0004\b\b\u0010mR-\u0010\u0001\u001a\u0004\u0018\u00010|8\u0006@\u0006X\u000e¢\u0006\u001a\n\u0004\b}\u0010~\u0012\u0005\b\u0001\u0010\u000f\u001a\u0004\b!\u0010\"\u0005\b\b\u0010\u0001R/\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010\u000b\u0012\u0005\b\u0001\u0010\u000f\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0019\u0010\u0001R.\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u001b\n\u0005\b\u0001\u0010\u000b\u0012\u0005\b\u0001\u0010\u000f\u001a\u0004\bp\u0010\r\"\u0005\b\n\u0010\u0001R-\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u001a\n\u0004\b\u0012\u0010\u000b\u0012\u0005\b\u0001\u0010\u000f\u001a\u0004\bx\u0010\r\"\u0005\b\u0011\u0010\u0001R/\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010\u000b\u0012\u0005\b\u0001\u0010\u000f\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0015\u0010\u0001R-\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u001a\n\u0004\bL\u0010\u000b\u0012\u0005\b\u0001\u0010\u000f\u001a\u0004\b:\u0010\r\"\u0005\b\b\u0010\u0001R-\u0010\u0001\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u001a\n\u0005\b\u0001\u0010-\u0012\u0005\b\u0001\u0010\u000f\u001a\u0004\b\u0019\u0010.\"\u0004\b\n\u0010/¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sentry/Device;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Ljava/lang/String;", "K", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "c", "C", "getManufacturer$annotations", "manufacturer", "d", "i", "getBrand$annotations", "brand", "e", "q", "getFamily$annotations", "family", "f", "G", "getModel$annotations", "model", "g", "I", "getModelId$annotations", "modelId", "", "h", "[Ljava/lang/String;", "()[Ljava/lang/String;", "([Ljava/lang/String;)V", "getArchs$annotations", "archs", "", "Ljava/lang/Float;", "()Ljava/lang/Float;", "(Ljava/lang/Float;)V", "getBatteryLevel$annotations", "batteryLevel", "", "j", "Ljava/lang/Boolean;", "c0", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "isCharging$annotations", "isCharging", "k", "g0", "isOnline$annotations", "isOnline", "Lcom/sumsub/sentry/Device$DeviceOrientation;", "l", "Lcom/sumsub/sentry/Device$DeviceOrientation;", "M", "()Lcom/sumsub/sentry/Device$DeviceOrientation;", "getOrientation$annotations", "orientation", "m", "i0", "isSimulator$annotations", "isSimulator", "", "n", "Ljava/lang/Long;", "E", "()Ljava/lang/Long;", "(Ljava/lang/Long;)V", "getMemorySize$annotations", "memorySize", "o", "s", "getFreeMemory$annotations", "freeMemory", "p", "a0", "getUsableMemory$annotations", "usableMemory", "e0", "isLowMemory$annotations", "isLowMemory", "r", "W", "getStorageSize$annotations", "storageSize", "u", "getFreeStorage$annotations", "freeStorage", "t", "getExternalStorageSize$annotations", "externalStorageSize", "getExternalFreeStorage$annotations", "externalFreeStorage", "", "v", "Ljava/lang/Integer;", "U", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "getScreenWidthPixels$annotations", "screenWidthPixels", "w", "S", "getScreenHeightPixels$annotations", "screenHeightPixels", "x", "O", "getScreenDensity$annotations", "screenDensity", "y", "Q", "getScreenDpi$annotations", "screenDpi", "Ljava/util/Date;", "z", "Ljava/util/Date;", "()Ljava/util/Date;", "(Ljava/util/Date;)V", "getBootTime$annotations", "bootTime", "A", "Y", "(Ljava/lang/String;)V", "getTimezone$annotations", "timezone", "B", "getId$annotations", "id", "getLanguage$annotations", "language", "D", "getLocale$annotations", "locale", "getConnectionType$annotations", "connectionType", "F", "getBatteryTemperature$annotations", "batteryTemperature", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sumsub/sentry/Device$DeviceOrientation;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "device", "(Lcom/sumsub/sentry/Device;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sumsub/sentry/Device$DeviceOrientation;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lkotlinx/serialization/internal/q1;)V", "Companion", "DeviceOrientation", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class Device {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public static final String f30205a = "device";
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public Float F;

    /* renamed from: b  reason: collision with root package name */
    public final String f30206b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30207c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30208d;

    /* renamed from: e  reason: collision with root package name */
    public final String f30209e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30210f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30211g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f30212h;

    /* renamed from: i  reason: collision with root package name */
    public Float f30213i;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f30214j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f30215k;

    /* renamed from: l  reason: collision with root package name */
    public final DeviceOrientation f30216l;

    /* renamed from: m  reason: collision with root package name */
    public Boolean f30217m;

    /* renamed from: n  reason: collision with root package name */
    public Long f30218n;

    /* renamed from: o  reason: collision with root package name */
    public Long f30219o;

    /* renamed from: p  reason: collision with root package name */
    public final Long f30220p;

    /* renamed from: q  reason: collision with root package name */
    public Boolean f30221q;

    /* renamed from: r  reason: collision with root package name */
    public Long f30222r;

    /* renamed from: s  reason: collision with root package name */
    public Long f30223s;

    /* renamed from: t  reason: collision with root package name */
    public Long f30224t;

    /* renamed from: u  reason: collision with root package name */
    public Long f30225u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f30226v;

    /* renamed from: w  reason: collision with root package name */
    public Integer f30227w;

    /* renamed from: x  reason: collision with root package name */
    public Float f30228x;

    /* renamed from: y  reason: collision with root package name */
    public Integer f30229y;

    /* renamed from: z  reason: collision with root package name */
    public Date f30230z;

    @f
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sentry/Device$DeviceOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "PORTRAIT", "LANDSCAPE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public enum DeviceOrientation {
        PORTRAIT,
        LANDSCAPE;
        
        public static final b Companion = null;

        public static final class a implements d0<DeviceOrientation> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f30231a = null;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f30232b = null;

            static {
                f30231a = new a();
                EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sentry.Device.DeviceOrientation", 2);
                enumDescriptor.k("portrait", false);
                enumDescriptor.k("landscape", false);
                f30232b = enumDescriptor;
            }

            /* renamed from: a */
            public DeviceOrientation deserialize(c cVar) {
                return DeviceOrientation.values()[cVar.s(getDescriptor())];
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[0];
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f30232b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(d dVar, DeviceOrientation deviceOrientation) {
                dVar.g(getDescriptor(), deviceOrientation.ordinal());
            }
        }

        public static final class b {
            public /* synthetic */ b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<DeviceOrientation> serializer() {
                return a.f30231a;
            }

            public b() {
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new b((r) null);
        }
    }

    public static final class a implements d0<Device> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30233a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30234b;

        static {
            a aVar = new a();
            f30233a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Device", aVar, 31);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("manufacturer", true);
            pluginGeneratedSerialDescriptor.k("brand", true);
            pluginGeneratedSerialDescriptor.k("family", true);
            pluginGeneratedSerialDescriptor.k(DeviceRequestsHelper.DEVICE_INFO_MODEL, true);
            pluginGeneratedSerialDescriptor.k("model_id", true);
            pluginGeneratedSerialDescriptor.k("archs", true);
            pluginGeneratedSerialDescriptor.k("battery_level", true);
            pluginGeneratedSerialDescriptor.k("charging", true);
            pluginGeneratedSerialDescriptor.k(SymbolBean.ONLINE, true);
            pluginGeneratedSerialDescriptor.k("orientation", true);
            pluginGeneratedSerialDescriptor.k("simulator", true);
            pluginGeneratedSerialDescriptor.k("memory_size", true);
            pluginGeneratedSerialDescriptor.k(VulcanInfo.FREE_MEMORY, true);
            pluginGeneratedSerialDescriptor.k("usable_memory", true);
            pluginGeneratedSerialDescriptor.k("low_memory", true);
            pluginGeneratedSerialDescriptor.k("storage_size", true);
            pluginGeneratedSerialDescriptor.k("free_storage", true);
            pluginGeneratedSerialDescriptor.k("external_storage_size", true);
            pluginGeneratedSerialDescriptor.k("external_free_storage", true);
            pluginGeneratedSerialDescriptor.k("screen_width_pixels", true);
            pluginGeneratedSerialDescriptor.k("screen_height_pixels", true);
            pluginGeneratedSerialDescriptor.k("screen_density", true);
            pluginGeneratedSerialDescriptor.k("screen_dpi", true);
            pluginGeneratedSerialDescriptor.k("boot_time", true);
            pluginGeneratedSerialDescriptor.k("timezone", true);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("language", true);
            pluginGeneratedSerialDescriptor.k("locale", true);
            pluginGeneratedSerialDescriptor.k("connection_type", true);
            pluginGeneratedSerialDescriptor.k("battery_temperature", true);
            f30234b = pluginGeneratedSerialDescriptor;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v1, resolved type: java.lang.Object} */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x01bd, code lost:
            r56 = r3;
            r18 = r15;
            r28 = r34;
            r23 = r35;
            r22 = r36;
            r21 = r37;
            r20 = r38;
            r24 = r39;
            r25 = r40;
            r26 = r42;
            r29 = r43;
            r27 = r46;
            r31 = r47;
            r32 = r50;
            r10 = r52;
            r9 = r9;
            r7 = r7;
            r5 = r5;
            r14 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x026b, code lost:
            r18 = r15;
            r28 = r34;
            r23 = r35;
            r22 = r36;
            r21 = r37;
            r20 = r38;
            r24 = r39;
            r25 = r40;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x02a4, code lost:
            r26 = r42;
            r29 = r43;
            r27 = r46;
            r31 = r47;
            r32 = r50;
            r10 = r52;
            r6 = r57;
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x02b2, code lost:
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x03b2, code lost:
            r26 = r42;
            r29 = r43;
            r27 = r46;
            r31 = r47;
            r32 = r50;
            r10 = r52;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x047f, code lost:
            r20 = r6;
            r18 = r15;
            r6 = r57;
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0486, code lost:
            r15 = r0;
            r0 = r49;
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x04c9, code lost:
            r6 = r57;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x04cb, code lost:
            r15 = r3;
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0566, code lost:
            r25 = r10;
            r24 = r18;
            r4 = r20;
            r10 = r33;
            r28 = r34;
            r26 = r42;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0572, code lost:
            r27 = r46;
            r20 = r6;
            r18 = r15;
            r6 = r57;
            r15 = r0;
            r0 = r31;
            r31 = r47;
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x06dc, code lost:
            r52 = r10;
            r41 = r41 | r15;
            r15 = r18;
            r18 = r24;
            r10 = r55;
            r24 = r0;
            r0 = r54;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x072a, code lost:
            r14 = r14;
            r9 = r9;
            r7 = r7;
            r5 = r5;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.Device deserialize(kotlinx.serialization.encoding.c r93) {
            /*
                r92 = this;
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                kotlinx.serialization.descriptors.f r1 = r92.getDescriptor()
                r2 = r93
                kotlinx.serialization.encoding.a r2 = r2.b(r1)
                boolean r3 = r2.k()
                r12 = 10
                r13 = 9
                r14 = 7
                r15 = 6
                r4 = 5
                r5 = 3
                r6 = 8
                r7 = 4
                r8 = 2
                r9 = 1
                r10 = 0
                r11 = 0
                if (r3 == 0) goto L_0x012a
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r24 = r2.j(r1, r10, r3, r11)
                java.lang.Object r9 = r2.j(r1, r9, r3, r11)
                java.lang.Object r8 = r2.j(r1, r8, r3, r11)
                java.lang.Object r5 = r2.j(r1, r5, r3, r11)
                java.lang.Object r7 = r2.j(r1, r7, r3, r11)
                java.lang.Object r4 = r2.j(r1, r4, r3, r11)
                kotlinx.serialization.internal.o1 r10 = new kotlinx.serialization.internal.o1
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                r10.<init>(r0, r3)
                java.lang.Object r0 = r2.j(r1, r15, r10, r11)
                kotlinx.serialization.internal.c0 r10 = kotlinx.serialization.internal.c0.f57699a
                java.lang.Object r14 = r2.j(r1, r14, r10, r11)
                kotlinx.serialization.internal.h r15 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r6 = r2.j(r1, r6, r15, r11)
                java.lang.Object r13 = r2.j(r1, r13, r15, r11)
                r26 = r0
                com.sumsub.sentry.Device$DeviceOrientation$a r0 = com.sumsub.sentry.Device.DeviceOrientation.a.f30231a
                java.lang.Object r0 = r2.j(r1, r12, r0, r11)
                r12 = 11
                java.lang.Object r12 = r2.j(r1, r12, r15, r11)
                r23 = r0
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r27 = r4
                r4 = 12
                java.lang.Object r4 = r2.j(r1, r4, r0, r11)
                r22 = r4
                r4 = 13
                java.lang.Object r4 = r2.j(r1, r4, r0, r11)
                r21 = r4
                r4 = 14
                java.lang.Object r4 = r2.j(r1, r4, r0, r11)
                r20 = r4
                r4 = 15
                java.lang.Object r4 = r2.j(r1, r4, r15, r11)
                r15 = 16
                java.lang.Object r15 = r2.j(r1, r15, r0, r11)
                r18 = r4
                r4 = 17
                java.lang.Object r4 = r2.j(r1, r4, r0, r11)
                r17 = r4
                r4 = 18
                java.lang.Object r4 = r2.j(r1, r4, r0, r11)
                r16 = r4
                r4 = 19
                java.lang.Object r0 = r2.j(r1, r4, r0, r11)
                kotlinx.serialization.internal.m0 r4 = kotlinx.serialization.internal.m0.f57742a
                r93 = r0
                r0 = 20
                java.lang.Object r0 = r2.j(r1, r0, r4, r11)
                r19 = r0
                r0 = 21
                java.lang.Object r0 = r2.j(r1, r0, r4, r11)
                r28 = r0
                r0 = 22
                java.lang.Object r0 = r2.j(r1, r0, r10, r11)
                r29 = r0
                r0 = 23
                java.lang.Object r0 = r2.j(r1, r0, r4, r11)
                kotlinx.serialization.ContextualSerializer r4 = new kotlinx.serialization.ContextualSerializer
                java.lang.Class<java.util.Date> r30 = java.util.Date.class
                r31 = r0
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r30)
                r30 = r5
                r5 = 0
                kotlinx.serialization.b[] r5 = new kotlinx.serialization.b[r5]
                r4.<init>(r0, r11, r5)
                r0 = 24
                java.lang.Object r0 = r2.j(r1, r0, r4, r11)
                r4 = 25
                java.lang.Object r4 = r2.j(r1, r4, r3, r11)
                r5 = 26
                java.lang.Object r5 = r2.j(r1, r5, r3, r11)
                r25 = r0
                r0 = 27
                java.lang.Object r0 = r2.j(r1, r0, r3, r11)
                r32 = r0
                r0 = 28
                java.lang.Object r0 = r2.j(r1, r0, r3, r11)
                r33 = r0
                r0 = 29
                java.lang.Object r0 = r2.j(r1, r0, r3, r11)
                r3 = 30
                java.lang.Object r3 = r2.j(r1, r3, r10, r11)
                r10 = 2147483647(0x7fffffff, float:NaN)
                r56 = r5
                r58 = r10
                r51 = r14
                r55 = r15
                r10 = r24
                r15 = r25
                r5 = r28
                r14 = r32
                r24 = r8
                r25 = r9
                r9 = r93
                r8 = r7
                r7 = r29
                goto L_0x079a
            L_0x012a:
                r45 = r0
                r44 = r9
                r0 = r11
                r3 = r0
                r4 = r3
                r5 = r4
                r6 = r5
                r7 = r6
                r8 = r7
                r9 = r8
                r10 = r9
                r12 = r10
                r13 = r12
                r14 = r13
                r15 = r14
                r34 = r15
                r35 = r34
                r36 = r35
                r37 = r36
                r38 = r37
                r39 = r38
                r40 = r39
                r42 = r40
                r43 = r42
                r46 = r43
                r47 = r46
                r48 = r47
                r49 = r48
                r50 = r49
                r51 = r50
                r52 = r51
                r53 = r52
                r41 = 0
            L_0x015f:
                r54 = r0
                if (r44 == 0) goto L_0x074a
                int r0 = r2.w(r1)
                switch(r0) {
                    case -1: goto L_0x06ed;
                    case 0: goto L_0x0695;
                    case 1: goto L_0x0650;
                    case 2: goto L_0x060c;
                    case 3: goto L_0x05c7;
                    case 4: goto L_0x0582;
                    case 5: goto L_0x053c;
                    case 6: goto L_0x0508;
                    case 7: goto L_0x04cf;
                    case 8: goto L_0x048b;
                    case 9: goto L_0x0445;
                    case 10: goto L_0x0406;
                    case 11: goto L_0x03c0;
                    case 12: goto L_0x0386;
                    case 13: goto L_0x0359;
                    case 14: goto L_0x032e;
                    case 15: goto L_0x02f3;
                    case 16: goto L_0x02b5;
                    case 17: goto L_0x027c;
                    case 18: goto L_0x0256;
                    case 19: goto L_0x0244;
                    case 20: goto L_0x0232;
                    case 21: goto L_0x0220;
                    case 22: goto L_0x020e;
                    case 23: goto L_0x01fc;
                    case 24: goto L_0x01dd;
                    case 25: goto L_0x01b1;
                    case 26: goto L_0x01a4;
                    case 27: goto L_0x0197;
                    case 28: goto L_0x018a;
                    case 29: goto L_0x017d;
                    case 30: goto L_0x0170;
                    default: goto L_0x016a;
                }
            L_0x016a:
                kotlinx.serialization.UnknownFieldException r1 = new kotlinx.serialization.UnknownFieldException
                r1.<init>((int) r0)
                throw r1
            L_0x0170:
                kotlinx.serialization.internal.c0 r0 = kotlinx.serialization.internal.c0.f57699a
                r55 = r10
                r10 = 30
                java.lang.Object r12 = r2.j(r1, r10, r0, r12)
                r0 = 1073741824(0x40000000, float:2.0)
                goto L_0x01bd
            L_0x017d:
                r55 = r10
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r10 = 29
                java.lang.Object r13 = r2.j(r1, r10, r0, r13)
                r0 = 536870912(0x20000000, float:1.0842022E-19)
                goto L_0x01bd
            L_0x018a:
                r55 = r10
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r10 = 28
                java.lang.Object r6 = r2.j(r1, r10, r0, r6)
                r0 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x01bd
            L_0x0197:
                r55 = r10
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r10 = 27
                java.lang.Object r14 = r2.j(r1, r10, r0, r14)
                r0 = 134217728(0x8000000, float:3.85186E-34)
                goto L_0x01bd
            L_0x01a4:
                r55 = r10
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r10 = 26
                java.lang.Object r3 = r2.j(r1, r10, r0, r3)
                r0 = 67108864(0x4000000, float:1.5046328E-36)
                goto L_0x01bd
            L_0x01b1:
                r55 = r10
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r10 = 25
                java.lang.Object r11 = r2.j(r1, r10, r0, r11)
                r0 = 33554432(0x2000000, float:9.403955E-38)
            L_0x01bd:
                r56 = r3
                r18 = r15
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r20 = r38
                r24 = r39
                r25 = r40
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
                r10 = r52
                goto L_0x02b2
            L_0x01dd:
                r55 = r10
                kotlinx.serialization.ContextualSerializer r0 = new kotlinx.serialization.ContextualSerializer
                java.lang.Class<java.util.Date> r10 = java.util.Date.class
                kotlin.reflect.c r10 = kotlin.jvm.internal.Reflection.b(r10)
                r56 = r3
                r57 = r6
                r3 = 0
                kotlinx.serialization.b[] r6 = new kotlinx.serialization.b[r3]
                r3 = 0
                r0.<init>(r10, r3, r6)
                r6 = 24
                java.lang.Object r15 = r2.j(r1, r6, r0, r15)
                r0 = 16777216(0x1000000, float:2.3509887E-38)
                goto L_0x026b
            L_0x01fc:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                kotlinx.serialization.internal.m0 r0 = kotlinx.serialization.internal.m0.f57742a
                r6 = 23
                java.lang.Object r4 = r2.j(r1, r6, r0, r4)
                r0 = 8388608(0x800000, float:1.17549435E-38)
                goto L_0x026b
            L_0x020e:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                kotlinx.serialization.internal.c0 r0 = kotlinx.serialization.internal.c0.f57699a
                r6 = 22
                java.lang.Object r7 = r2.j(r1, r6, r0, r7)
                r0 = 4194304(0x400000, float:5.877472E-39)
                goto L_0x026b
            L_0x0220:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                kotlinx.serialization.internal.m0 r0 = kotlinx.serialization.internal.m0.f57742a
                r6 = 21
                java.lang.Object r5 = r2.j(r1, r6, r0, r5)
                r0 = 2097152(0x200000, float:2.938736E-39)
                goto L_0x026b
            L_0x0232:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                kotlinx.serialization.internal.m0 r0 = kotlinx.serialization.internal.m0.f57742a
                r6 = 20
                java.lang.Object r8 = r2.j(r1, r6, r0, r8)
                r0 = 1048576(0x100000, float:1.469368E-39)
                goto L_0x026b
            L_0x0244:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r6 = 19
                java.lang.Object r9 = r2.j(r1, r6, r0, r9)
                r0 = 524288(0x80000, float:7.34684E-40)
                goto L_0x026b
            L_0x0256:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = 0
                r6 = 19
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r10 = r40
                r3 = 18
                java.lang.Object r40 = r2.j(r1, r3, r0, r10)
                r0 = 262144(0x40000, float:3.67342E-40)
            L_0x026b:
                r18 = r15
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r20 = r38
                r24 = r39
                r25 = r40
                goto L_0x02a4
            L_0x027c:
                r56 = r3
                r57 = r6
                r55 = r10
                r10 = r40
                r3 = 18
                r6 = 19
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r3 = r39
                r6 = 17
                java.lang.Object r39 = r2.j(r1, r6, r0, r3)
                r0 = 131072(0x20000, float:1.83671E-40)
                r25 = r10
                r18 = r15
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r20 = r38
                r24 = r39
            L_0x02a4:
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
                r10 = r52
                r6 = r57
            L_0x02b2:
                r3 = 0
                goto L_0x0486
            L_0x02b5:
                r56 = r3
                r57 = r6
                r55 = r10
                r3 = r39
                r10 = r40
                r6 = 17
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r18 = r3
                r3 = r55
                r6 = 16
                java.lang.Object r0 = r2.j(r1, r6, r0, r3)
                r3 = 65536(0x10000, float:9.18355E-41)
                r55 = r0
                r25 = r10
                r24 = r18
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r20 = r38
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r0 = r49
                r32 = r50
                r10 = r52
                r6 = r57
                r18 = r15
                goto L_0x04cb
            L_0x02f3:
                r56 = r3
                r57 = r6
                r3 = r10
                r18 = r39
                r10 = r40
                r6 = 16
                kotlinx.serialization.internal.h r0 = kotlinx.serialization.internal.h.f57720a
                r55 = r3
                r6 = r38
                r3 = 15
                java.lang.Object r38 = r2.j(r1, r3, r0, r6)
                r0 = 32768(0x8000, float:4.5918E-41)
                r25 = r10
                r24 = r18
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r20 = r38
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
                r10 = r52
                r6 = r57
                r3 = 0
                r18 = r15
                goto L_0x0486
            L_0x032e:
                r56 = r3
                r57 = r6
                r55 = r10
                r6 = r38
                r18 = r39
                r10 = r40
                r3 = 15
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r20 = r4
                r3 = r37
                r4 = 14
                java.lang.Object r37 = r2.j(r1, r4, r0, r3)
                r0 = 16384(0x4000, float:2.2959E-41)
                r25 = r10
                r24 = r18
                r4 = r20
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                goto L_0x03b2
            L_0x0359:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r3 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r4 = 14
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r21 = r3
                r4 = r36
                r3 = 13
                java.lang.Object r36 = r2.j(r1, r3, r0, r4)
                r0 = 8192(0x2000, float:1.14794E-41)
                r25 = r10
                r24 = r18
                r4 = r20
                r28 = r34
                r23 = r35
                r22 = r36
                goto L_0x03b2
            L_0x0386:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r4 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r3 = 13
                kotlinx.serialization.internal.x0 r0 = kotlinx.serialization.internal.x0.f57786a
                r22 = r4
                r3 = r35
                r4 = 12
                java.lang.Object r35 = r2.j(r1, r4, r0, r3)
                r0 = 4096(0x1000, float:5.74E-42)
                r25 = r10
                r24 = r18
                r4 = r20
                r28 = r34
                r23 = r35
            L_0x03b2:
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
                r10 = r52
                goto L_0x047f
            L_0x03c0:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r3 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r4 = 12
                kotlinx.serialization.internal.h r0 = kotlinx.serialization.internal.h.f57720a
                r23 = r3
                r4 = r54
                r3 = 11
                java.lang.Object r0 = r2.j(r1, r3, r0, r4)
                r4 = 2048(0x800, float:2.87E-42)
                r54 = r0
                r25 = r10
                r24 = r18
                r28 = r34
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r0 = r49
                r32 = r50
                r10 = r52
                r3 = 0
                r18 = r15
                r15 = r4
                r4 = r20
                r20 = r6
                r6 = r57
                goto L_0x06dc
            L_0x0406:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r4 = r54
                r3 = 11
                com.sumsub.sentry.Device$DeviceOrientation$a r0 = com.sumsub.sentry.Device.DeviceOrientation.a.f30231a
                r3 = r52
                r4 = 10
                java.lang.Object r0 = r2.j(r1, r4, r0, r3)
                r3 = 1024(0x400, float:1.435E-42)
                r25 = r10
                r24 = r18
                r4 = r20
                r28 = r34
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
                r10 = r0
                r20 = r6
                r18 = r15
                r0 = r49
                goto L_0x04c9
            L_0x0445:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r3 = r52
                r4 = 10
                kotlinx.serialization.internal.h r0 = kotlinx.serialization.internal.h.f57720a
                r33 = r3
                r4 = r50
                r3 = 9
                java.lang.Object r50 = r2.j(r1, r3, r0, r4)
                r0 = 512(0x200, float:7.175E-43)
                r25 = r10
                r24 = r18
                r4 = r20
                r10 = r33
                r28 = r34
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r32 = r50
            L_0x047f:
                r3 = 0
                r20 = r6
                r18 = r15
                r6 = r57
            L_0x0486:
                r15 = r0
                r0 = r49
                goto L_0x06dc
            L_0x048b:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r4 = r50
                r33 = r52
                r3 = 9
                kotlinx.serialization.internal.h r0 = kotlinx.serialization.internal.h.f57720a
                r32 = r4
                r3 = r49
                r4 = 8
                java.lang.Object r0 = r2.j(r1, r4, r0, r3)
                r3 = 256(0x100, float:3.59E-43)
                r25 = r10
                r24 = r18
                r4 = r20
                r10 = r33
                r28 = r34
                r26 = r42
                r29 = r43
                r27 = r46
                r31 = r47
                r20 = r6
                r18 = r15
            L_0x04c9:
                r6 = r57
            L_0x04cb:
                r15 = r3
                r3 = 0
                goto L_0x06dc
            L_0x04cf:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r3 = r49
                r32 = r50
                r33 = r52
                r4 = 8
                kotlinx.serialization.internal.c0 r0 = kotlinx.serialization.internal.c0.f57699a
                r31 = r3
                r4 = r51
                r3 = 7
                java.lang.Object r51 = r2.j(r1, r3, r0, r4)
                r0 = 128(0x80, float:1.794E-43)
                r25 = r10
                r24 = r18
                r4 = r20
                r10 = r33
                r28 = r34
                r26 = r42
                r29 = r43
                goto L_0x0572
            L_0x0508:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r31 = r49
                r32 = r50
                r4 = r51
                r33 = r52
                r3 = 7
                kotlinx.serialization.internal.o1 r0 = new kotlinx.serialization.internal.o1
                kotlin.reflect.c r3 = kotlin.jvm.internal.Reflection.b(r45)
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r0.<init>(r3, r4)
                r3 = r43
                r4 = 6
                java.lang.Object r3 = r2.j(r1, r4, r0, r3)
                r0 = 64
                r29 = r3
                goto L_0x0566
            L_0x053c:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r3 = r43
                r31 = r49
                r32 = r50
                r33 = r52
                r4 = 6
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r29 = r3
                r4 = r34
                r3 = 5
                java.lang.Object r34 = r2.j(r1, r3, r0, r4)
                r0 = 32
            L_0x0566:
                r25 = r10
                r24 = r18
                r4 = r20
                r10 = r33
                r28 = r34
                r26 = r42
            L_0x0572:
                r27 = r46
                r3 = 0
                r20 = r6
                r18 = r15
                r6 = r57
                r15 = r0
                r0 = r31
                r31 = r47
                goto L_0x06dc
            L_0x0582:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r4 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r29 = r43
                r31 = r49
                r32 = r50
                r33 = r52
                r3 = 5
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r28 = r4
                r3 = r46
                r4 = 4
                java.lang.Object r46 = r2.j(r1, r4, r0, r3)
                r25 = r10
                r24 = r18
                r4 = r20
                r0 = r31
                r10 = r33
                r26 = r42
                r27 = r46
                r31 = r47
                r3 = 0
                r20 = r6
                r18 = r15
                r6 = r57
                r15 = 16
                goto L_0x06dc
            L_0x05c7:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r29 = r43
                r3 = r46
                r31 = r49
                r32 = r50
                r33 = r52
                r4 = 4
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r27 = r3
                r4 = r42
                r3 = 3
                java.lang.Object r42 = r2.j(r1, r3, r0, r4)
                r25 = r10
                r24 = r18
                r4 = r20
                r0 = r31
                r10 = r33
                r26 = r42
                r31 = r47
                r3 = 0
                r20 = r6
                r18 = r15
                r6 = r57
                r15 = 8
                goto L_0x06dc
            L_0x060c:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r4 = r42
                r29 = r43
                r27 = r46
                r31 = r49
                r32 = r50
                r33 = r52
                r3 = 3
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r26 = r4
                r3 = r47
                r4 = 2
                java.lang.Object r47 = r2.j(r1, r4, r0, r3)
                r25 = r10
                r24 = r18
                r4 = r20
                r0 = r31
                r10 = r33
                r31 = r47
                r3 = 0
                r20 = r6
                r18 = r15
                r6 = r57
                r15 = 4
                goto L_0x06dc
            L_0x0650:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r26 = r42
                r29 = r43
                r27 = r46
                r3 = r47
                r31 = r49
                r32 = r50
                r33 = r52
                r4 = 2
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r24 = r3
                r4 = r48
                r3 = 1
                java.lang.Object r48 = r2.j(r1, r3, r0, r4)
                r25 = r10
                r4 = r20
                r0 = r31
                r10 = r33
                r3 = 0
                r20 = r6
                r31 = r24
                r6 = r57
                r24 = r18
                r18 = r15
                r15 = 2
                goto L_0x06dc
            L_0x0695:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r26 = r42
                r29 = r43
                r27 = r46
                r24 = r47
                r4 = r48
                r31 = r49
                r32 = r50
                r33 = r52
                r3 = 1
                kotlinx.serialization.internal.v1 r0 = kotlinx.serialization.internal.v1.f57779a
                r25 = r4
                r4 = r53
                r3 = 0
                java.lang.Object r53 = r2.j(r1, r3, r0, r4)
                r4 = r20
                r48 = r25
                r0 = r31
                r20 = r6
                r25 = r10
                r31 = r24
                r10 = r33
                r6 = r57
                r24 = r18
                r18 = r15
                r15 = 1
            L_0x06dc:
                r15 = r41 | r15
                r52 = r10
                r41 = r15
                r15 = r18
                r18 = r24
                r10 = r55
                r24 = r0
                r0 = r54
                goto L_0x072a
            L_0x06ed:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r26 = r42
                r29 = r43
                r27 = r46
                r24 = r47
                r25 = r48
                r31 = r49
                r32 = r50
                r33 = r52
                r4 = r53
                r3 = 0
                r44 = r3
                r4 = r20
                r0 = r54
                r20 = r6
                r25 = r10
                r10 = r55
                r6 = r57
                r91 = r31
                r31 = r24
                r24 = r91
            L_0x072a:
                kotlin.Unit r33 = kotlin.Unit.f56620a
                r39 = r18
                r38 = r20
                r37 = r21
                r36 = r22
                r35 = r23
                r49 = r24
                r40 = r25
                r42 = r26
                r46 = r27
                r34 = r28
                r43 = r29
                r47 = r31
                r50 = r32
                r3 = r56
                goto L_0x015f
            L_0x074a:
                r56 = r3
                r20 = r4
                r57 = r6
                r55 = r10
                r28 = r34
                r23 = r35
                r22 = r36
                r21 = r37
                r6 = r38
                r18 = r39
                r10 = r40
                r26 = r42
                r29 = r43
                r27 = r46
                r24 = r47
                r25 = r48
                r31 = r49
                r32 = r50
                r33 = r52
                r4 = r53
                r19 = r8
                r16 = r10
                r3 = r12
                r0 = r13
                r17 = r18
                r30 = r26
                r8 = r27
                r27 = r28
                r26 = r29
                r13 = r32
                r58 = r41
                r12 = r54
                r10 = r4
                r18 = r6
                r4 = r11
                r6 = r31
                r31 = r20
                r20 = r21
                r21 = r22
                r22 = r23
                r23 = r33
                r33 = r57
            L_0x079a:
                r2.c(r1)
                com.sumsub.sentry.Device r1 = new com.sumsub.sentry.Device
                r57 = r1
                r59 = r10
                java.lang.String r59 = (java.lang.String) r59
                r60 = r25
                java.lang.String r60 = (java.lang.String) r60
                r61 = r24
                java.lang.String r61 = (java.lang.String) r61
                r62 = r30
                java.lang.String r62 = (java.lang.String) r62
                r63 = r8
                java.lang.String r63 = (java.lang.String) r63
                r64 = r27
                java.lang.String r64 = (java.lang.String) r64
                r65 = r26
                java.lang.String[] r65 = (java.lang.String[]) r65
                r66 = r51
                java.lang.Float r66 = (java.lang.Float) r66
                r67 = r6
                java.lang.Boolean r67 = (java.lang.Boolean) r67
                r68 = r13
                java.lang.Boolean r68 = (java.lang.Boolean) r68
                r69 = r23
                com.sumsub.sentry.Device$DeviceOrientation r69 = (com.sumsub.sentry.Device.DeviceOrientation) r69
                r70 = r12
                java.lang.Boolean r70 = (java.lang.Boolean) r70
                r71 = r22
                java.lang.Long r71 = (java.lang.Long) r71
                r72 = r21
                java.lang.Long r72 = (java.lang.Long) r72
                r73 = r20
                java.lang.Long r73 = (java.lang.Long) r73
                r74 = r18
                java.lang.Boolean r74 = (java.lang.Boolean) r74
                r75 = r55
                java.lang.Long r75 = (java.lang.Long) r75
                r76 = r17
                java.lang.Long r76 = (java.lang.Long) r76
                r77 = r16
                java.lang.Long r77 = (java.lang.Long) r77
                r78 = r9
                java.lang.Long r78 = (java.lang.Long) r78
                r79 = r19
                java.lang.Integer r79 = (java.lang.Integer) r79
                r80 = r5
                java.lang.Integer r80 = (java.lang.Integer) r80
                r81 = r7
                java.lang.Float r81 = (java.lang.Float) r81
                r82 = r31
                java.lang.Integer r82 = (java.lang.Integer) r82
                r83 = r15
                java.util.Date r83 = (java.util.Date) r83
                r84 = r4
                java.lang.String r84 = (java.lang.String) r84
                r85 = r56
                java.lang.String r85 = (java.lang.String) r85
                r86 = r14
                java.lang.String r86 = (java.lang.String) r86
                r87 = r33
                java.lang.String r87 = (java.lang.String) r87
                r88 = r0
                java.lang.String r88 = (java.lang.String) r88
                r89 = r3
                java.lang.Float r89 = (java.lang.Float) r89
                r90 = 0
                r57.<init>((int) r58, (java.lang.String) r59, (java.lang.String) r60, (java.lang.String) r61, (java.lang.String) r62, (java.lang.String) r63, (java.lang.String) r64, (java.lang.String[]) r65, (java.lang.Float) r66, (java.lang.Boolean) r67, (java.lang.Boolean) r68, (com.sumsub.sentry.Device.DeviceOrientation) r69, (java.lang.Boolean) r70, (java.lang.Long) r71, (java.lang.Long) r72, (java.lang.Long) r73, (java.lang.Boolean) r74, (java.lang.Long) r75, (java.lang.Long) r76, (java.lang.Long) r77, (java.lang.Long) r78, (java.lang.Integer) r79, (java.lang.Integer) r80, (java.lang.Float) r81, (java.lang.Integer) r82, (java.util.Date) r83, (java.lang.String) r84, (java.lang.String) r85, (java.lang.String) r86, (java.lang.String) r87, (java.lang.String) r88, (java.lang.Float) r89, (kotlinx.serialization.internal.q1) r90)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.Device.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.Device");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            c0 c0Var = c0.f57699a;
            h hVar = h.f57720a;
            x0 x0Var = x0.f57786a;
            m0 m0Var = m0.f57742a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new o1(Reflection.b(String.class), v1Var)), h10.a.u(c0Var), h10.a.u(hVar), h10.a.u(hVar), h10.a.u(DeviceOrientation.a.f30231a), h10.a.u(hVar), h10.a.u(x0Var), h10.a.u(x0Var), h10.a.u(x0Var), h10.a.u(hVar), h10.a.u(x0Var), h10.a.u(x0Var), h10.a.u(x0Var), h10.a.u(x0Var), h10.a.u(m0Var), h10.a.u(m0Var), h10.a.u(c0Var), h10.a.u(m0Var), h10.a.u(new ContextualSerializer(Reflection.b(Date.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(c0Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30234b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, Device device) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            Device.a(device, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<Device> serializer() {
            return a.f30233a;
        }

        public b() {
        }
    }

    public Device() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String[]) null, (Float) null, (Boolean) null, (Boolean) null, (DeviceOrientation) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Float) null, (Integer) null, (Date) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Float) null, Integer.MAX_VALUE, (r) null);
    }

    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ void F() {
    }

    public static /* synthetic */ void H() {
    }

    public static /* synthetic */ void J() {
    }

    public static /* synthetic */ void L() {
    }

    public static /* synthetic */ void N() {
    }

    public static /* synthetic */ void P() {
    }

    public static /* synthetic */ void R() {
    }

    public static /* synthetic */ void T() {
    }

    public static /* synthetic */ void V() {
    }

    public static /* synthetic */ void X() {
    }

    public static /* synthetic */ void Z() {
    }

    public static final void a(Device device, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || device.f30206b != null) {
            bVar.y(fVar, 0, v1.f57779a, device.f30206b);
        }
        if (bVar.q(fVar, 1) || device.f30207c != null) {
            bVar.y(fVar, 1, v1.f57779a, device.f30207c);
        }
        if (bVar.q(fVar, 2) || device.f30208d != null) {
            bVar.y(fVar, 2, v1.f57779a, device.f30208d);
        }
        if (bVar.q(fVar, 3) || device.f30209e != null) {
            bVar.y(fVar, 3, v1.f57779a, device.f30209e);
        }
        if (bVar.q(fVar, 4) || device.f30210f != null) {
            bVar.y(fVar, 4, v1.f57779a, device.f30210f);
        }
        if (bVar.q(fVar, 5) || device.f30211g != null) {
            bVar.y(fVar, 5, v1.f57779a, device.f30211g);
        }
        if (bVar.q(fVar, 6) || device.f30212h != null) {
            bVar.y(fVar, 6, new o1(Reflection.b(String.class), v1.f57779a), device.f30212h);
        }
        if (bVar.q(fVar, 7) || device.f30213i != null) {
            bVar.y(fVar, 7, c0.f57699a, device.f30213i);
        }
        if (bVar.q(fVar, 8) || device.f30214j != null) {
            bVar.y(fVar, 8, h.f57720a, device.f30214j);
        }
        if (bVar.q(fVar, 9) || device.f30215k != null) {
            bVar.y(fVar, 9, h.f57720a, device.f30215k);
        }
        if (bVar.q(fVar, 10) || device.f30216l != null) {
            bVar.y(fVar, 10, DeviceOrientation.a.f30231a, device.f30216l);
        }
        if (bVar.q(fVar, 11) || device.f30217m != null) {
            bVar.y(fVar, 11, h.f57720a, device.f30217m);
        }
        if (bVar.q(fVar, 12) || device.f30218n != null) {
            bVar.y(fVar, 12, x0.f57786a, device.f30218n);
        }
        if (bVar.q(fVar, 13) || device.f30219o != null) {
            bVar.y(fVar, 13, x0.f57786a, device.f30219o);
        }
        if (bVar.q(fVar, 14) || device.f30220p != null) {
            bVar.y(fVar, 14, x0.f57786a, device.f30220p);
        }
        if (bVar.q(fVar, 15) || device.f30221q != null) {
            bVar.y(fVar, 15, h.f57720a, device.f30221q);
        }
        if (bVar.q(fVar, 16) || device.f30222r != null) {
            bVar.y(fVar, 16, x0.f57786a, device.f30222r);
        }
        if (bVar.q(fVar, 17) || device.f30223s != null) {
            bVar.y(fVar, 17, x0.f57786a, device.f30223s);
        }
        if (bVar.q(fVar, 18) || device.f30224t != null) {
            bVar.y(fVar, 18, x0.f57786a, device.f30224t);
        }
        if (bVar.q(fVar, 19) || device.f30225u != null) {
            bVar.y(fVar, 19, x0.f57786a, device.f30225u);
        }
        if (bVar.q(fVar, 20) || device.f30226v != null) {
            bVar.y(fVar, 20, m0.f57742a, device.f30226v);
        }
        if (bVar.q(fVar, 21) || device.f30227w != null) {
            bVar.y(fVar, 21, m0.f57742a, device.f30227w);
        }
        if (bVar.q(fVar, 22) || device.f30228x != null) {
            bVar.y(fVar, 22, c0.f57699a, device.f30228x);
        }
        if (bVar.q(fVar, 23) || device.f30229y != null) {
            bVar.y(fVar, 23, m0.f57742a, device.f30229y);
        }
        if (bVar.q(fVar, 24) || device.f30230z != null) {
            bVar.y(fVar, 24, new ContextualSerializer(Reflection.b(Date.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]), device.f30230z);
        }
        if (bVar.q(fVar, 25) || device.A != null) {
            bVar.y(fVar, 25, v1.f57779a, device.A);
        }
        if (bVar.q(fVar, 26) || device.B != null) {
            bVar.y(fVar, 26, v1.f57779a, device.B);
        }
        if (bVar.q(fVar, 27) || device.C != null) {
            bVar.y(fVar, 27, v1.f57779a, device.C);
        }
        if (bVar.q(fVar, 28) || device.D != null) {
            bVar.y(fVar, 28, v1.f57779a, device.D);
        }
        if (bVar.q(fVar, 29) || device.E != null) {
            bVar.y(fVar, 29, v1.f57779a, device.E);
        }
        if (bVar.q(fVar, 30) || device.F != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 30, c0.f57699a, device.F);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void b0() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void d0() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void f0() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void h0() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void j0() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public static /* synthetic */ void r() {
    }

    public static /* synthetic */ void t() {
    }

    public static /* synthetic */ void v() {
    }

    public static /* synthetic */ void x() {
    }

    public static /* synthetic */ void z() {
    }

    public final String A() {
        return this.D;
    }

    public final String C() {
        return this.f30207c;
    }

    public final Long E() {
        return this.f30218n;
    }

    public final String G() {
        return this.f30210f;
    }

    public final String I() {
        return this.f30211g;
    }

    public final String K() {
        return this.f30206b;
    }

    public final DeviceOrientation M() {
        return this.f30216l;
    }

    public final Float O() {
        return this.f30228x;
    }

    public final Integer Q() {
        return this.f30229y;
    }

    public final Integer S() {
        return this.f30227w;
    }

    public final Integer U() {
        return this.f30226v;
    }

    public final Long W() {
        return this.f30222r;
    }

    public final String Y() {
        return this.A;
    }

    public final Long a0() {
        return this.f30220p;
    }

    public final void b(Boolean bool) {
        this.f30221q = bool;
    }

    public final Float c() {
        return this.f30213i;
    }

    public final Boolean c0() {
        return this.f30214j;
    }

    public final void d(Boolean bool) {
        this.f30217m = bool;
    }

    public final void e(Long l11) {
        this.f30218n = l11;
    }

    public final Boolean e0() {
        return this.f30221q;
    }

    public final void f(Long l11) {
        this.f30222r = l11;
    }

    public final Date g() {
        return this.f30230z;
    }

    public final Boolean g0() {
        return this.f30215k;
    }

    public final String i() {
        return this.f30208d;
    }

    public final Boolean i0() {
        return this.f30217m;
    }

    public final String k() {
        return this.E;
    }

    public final Long m() {
        return this.f30225u;
    }

    public final Long o() {
        return this.f30224t;
    }

    public final String q() {
        return this.f30209e;
    }

    public final Long s() {
        return this.f30219o;
    }

    public final Long u() {
        return this.f30223s;
    }

    public final String w() {
        return this.B;
    }

    public final String y() {
        return this.C;
    }

    public /* synthetic */ Device(int i11, String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, Float f11, Boolean bool, Boolean bool2, DeviceOrientation deviceOrientation, Boolean bool3, Long l11, Long l12, Long l13, Boolean bool4, Long l14, Long l15, Long l16, Long l17, Integer num, Integer num2, Float f12, Integer num3, Date date, String str7, String str8, String str9, String str10, String str11, Float f13, q1 q1Var) {
        int i12 = i11;
        if ((i12 & 0) != 0) {
            h1.a(i11, 0, a.f30233a.getDescriptor());
        }
        if ((i12 & 1) == 0) {
            this.f30206b = null;
        } else {
            this.f30206b = str;
        }
        if ((i12 & 2) == 0) {
            this.f30207c = null;
        } else {
            this.f30207c = str2;
        }
        if ((i12 & 4) == 0) {
            this.f30208d = null;
        } else {
            this.f30208d = str3;
        }
        if ((i12 & 8) == 0) {
            this.f30209e = null;
        } else {
            this.f30209e = str4;
        }
        if ((i12 & 16) == 0) {
            this.f30210f = null;
        } else {
            this.f30210f = str5;
        }
        if ((i12 & 32) == 0) {
            this.f30211g = null;
        } else {
            this.f30211g = str6;
        }
        if ((i12 & 64) == 0) {
            this.f30212h = null;
        } else {
            this.f30212h = strArr;
        }
        if ((i12 & 128) == 0) {
            this.f30213i = null;
        } else {
            this.f30213i = f11;
        }
        if ((i12 & 256) == 0) {
            this.f30214j = null;
        } else {
            this.f30214j = bool;
        }
        if ((i12 & 512) == 0) {
            this.f30215k = null;
        } else {
            this.f30215k = bool2;
        }
        if ((i12 & 1024) == 0) {
            this.f30216l = null;
        } else {
            this.f30216l = deviceOrientation;
        }
        if ((i12 & 2048) == 0) {
            this.f30217m = null;
        } else {
            this.f30217m = bool3;
        }
        if ((i12 & 4096) == 0) {
            this.f30218n = null;
        } else {
            this.f30218n = l11;
        }
        if ((i12 & 8192) == 0) {
            this.f30219o = null;
        } else {
            this.f30219o = l12;
        }
        if ((i12 & 16384) == 0) {
            this.f30220p = null;
        } else {
            this.f30220p = l13;
        }
        if ((32768 & i12) == 0) {
            this.f30221q = null;
        } else {
            this.f30221q = bool4;
        }
        if ((65536 & i12) == 0) {
            this.f30222r = null;
        } else {
            this.f30222r = l14;
        }
        if ((131072 & i12) == 0) {
            this.f30223s = null;
        } else {
            this.f30223s = l15;
        }
        if ((262144 & i12) == 0) {
            this.f30224t = null;
        } else {
            this.f30224t = l16;
        }
        if ((524288 & i12) == 0) {
            this.f30225u = null;
        } else {
            this.f30225u = l17;
        }
        if ((1048576 & i12) == 0) {
            this.f30226v = null;
        } else {
            this.f30226v = num;
        }
        if ((2097152 & i12) == 0) {
            this.f30227w = null;
        } else {
            this.f30227w = num2;
        }
        if ((4194304 & i12) == 0) {
            this.f30228x = null;
        } else {
            this.f30228x = f12;
        }
        if ((8388608 & i12) == 0) {
            this.f30229y = null;
        } else {
            this.f30229y = num3;
        }
        if ((16777216 & i12) == 0) {
            this.f30230z = null;
        } else {
            this.f30230z = date;
        }
        if ((33554432 & i12) == 0) {
            this.A = null;
        } else {
            this.A = str7;
        }
        if ((67108864 & i12) == 0) {
            this.B = null;
        } else {
            this.B = str8;
        }
        if ((134217728 & i12) == 0) {
            this.C = null;
        } else {
            this.C = str9;
        }
        if ((268435456 & i12) == 0) {
            this.D = null;
        } else {
            this.D = str10;
        }
        if ((536870912 & i12) == 0) {
            this.E = null;
        } else {
            this.E = str11;
        }
        if ((i12 & 1073741824) == 0) {
            this.F = null;
        } else {
            this.F = f13;
        }
    }

    public final String[] a() {
        return this.f30212h;
    }

    public final void b(Long l11) {
        this.f30224t = l11;
    }

    public final void c(Boolean bool) {
        this.f30215k = bool;
    }

    public final void d(Long l11) {
        this.f30223s = l11;
    }

    public final void e(String str) {
        this.A = str;
    }

    public Device(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, Float f11, Boolean bool, Boolean bool2, DeviceOrientation deviceOrientation, Boolean bool3, Long l11, Long l12, Long l13, Boolean bool4, Long l14, Long l15, Long l16, Long l17, Integer num, Integer num2, Float f12, Integer num3, Date date, String str7, String str8, String str9, String str10, String str11, Float f13) {
        this.f30206b = str;
        this.f30207c = str2;
        this.f30208d = str3;
        this.f30209e = str4;
        this.f30210f = str5;
        this.f30211g = str6;
        this.f30212h = strArr;
        this.f30213i = f11;
        this.f30214j = bool;
        this.f30215k = bool2;
        this.f30216l = deviceOrientation;
        this.f30217m = bool3;
        this.f30218n = l11;
        this.f30219o = l12;
        this.f30220p = l13;
        this.f30221q = bool4;
        this.f30222r = l14;
        this.f30223s = l15;
        this.f30224t = l16;
        this.f30225u = l17;
        this.f30226v = num;
        this.f30227w = num2;
        this.f30228x = f12;
        this.f30229y = num3;
        this.f30230z = date;
        this.A = str7;
        this.B = str8;
        this.C = str9;
        this.D = str10;
        this.E = str11;
        this.F = f13;
    }

    public final void a(String[] strArr) {
        this.f30212h = strArr;
    }

    public final void b(Integer num) {
        this.f30227w = num;
    }

    public final void c(Long l11) {
        this.f30219o = l11;
    }

    public final void d(String str) {
        this.D = str;
    }

    public final Float e() {
        return this.F;
    }

    public final void a(Float f11) {
        this.f30213i = f11;
    }

    public final void b(String str) {
        this.B = str;
    }

    public final void c(Integer num) {
        this.f30226v = num;
    }

    public final void a(Boolean bool) {
        this.f30214j = bool;
    }

    public final void b(Float f11) {
        this.F = f11;
    }

    public final void c(Float f11) {
        this.f30228x = f11;
    }

    public final void a(Long l11) {
        this.f30225u = l11;
    }

    public final void c(String str) {
        this.C = str;
    }

    public final void a(Integer num) {
        this.f30229y = num;
    }

    public final void a(Date date) {
        this.f30230z = date;
    }

    public final void a(String str) {
        this.E = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Device(java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String[] r39, java.lang.Float r40, java.lang.Boolean r41, java.lang.Boolean r42, com.sumsub.sentry.Device.DeviceOrientation r43, java.lang.Boolean r44, java.lang.Long r45, java.lang.Long r46, java.lang.Long r47, java.lang.Boolean r48, java.lang.Long r49, java.lang.Long r50, java.lang.Long r51, java.lang.Long r52, java.lang.Integer r53, java.lang.Integer r54, java.lang.Float r55, java.lang.Integer r56, java.util.Date r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.Float r63, int r64, kotlin.jvm.internal.r r65) {
        /*
            r32 = this;
            r0 = r64
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r33
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r34
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r35
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r36
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r37
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r38
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r39
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r40
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r41
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r42
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r43
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r44
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r45
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r46
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r47
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r48
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r49
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r50
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r51
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r52
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r53
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r54
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r55
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r56
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r57
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r58
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r59
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r60
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            r29 = 0
            goto L_0x0115
        L_0x0113:
            r29 = r61
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r62
        L_0x0120:
            r31 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r31
            if (r0 == 0) goto L_0x0128
            r0 = 0
            goto L_0x012a
        L_0x0128:
            r0 = r63
        L_0x012a:
            r33 = r32
            r34 = r1
            r35 = r3
            r36 = r4
            r37 = r5
            r38 = r6
            r39 = r7
            r40 = r8
            r41 = r9
            r42 = r10
            r43 = r11
            r44 = r12
            r45 = r13
            r46 = r14
            r47 = r15
            r48 = r2
            r49 = r16
            r50 = r17
            r51 = r18
            r52 = r19
            r53 = r20
            r54 = r21
            r55 = r22
            r56 = r23
            r57 = r24
            r58 = r25
            r59 = r26
            r60 = r27
            r61 = r28
            r62 = r29
            r63 = r30
            r64 = r0
            r33.<init>(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.Device.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.Float, java.lang.Boolean, java.lang.Boolean, com.sumsub.sentry.Device$DeviceOrientation, java.lang.Boolean, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Float, java.lang.Integer, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Float, int, kotlin.jvm.internal.r):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Device(com.sumsub.sentry.Device r37) {
        /*
            r36 = this;
            r0 = r37
            java.lang.String r1 = r0.f30206b
            java.lang.String r2 = r0.f30207c
            java.lang.String r3 = r0.f30208d
            java.lang.String r4 = r0.f30209e
            java.lang.String r5 = r0.f30210f
            java.lang.String r6 = r0.f30211g
            java.lang.Boolean r9 = r0.f30214j
            java.lang.Boolean r10 = r0.f30215k
            com.sumsub.sentry.Device$DeviceOrientation r11 = r0.f30216l
            java.lang.Boolean r12 = r0.f30217m
            java.lang.Long r13 = r0.f30218n
            java.lang.Long r14 = r0.f30219o
            java.lang.Long r15 = r0.f30220p
            java.lang.Boolean r8 = r0.f30221q
            java.lang.Long r7 = r0.f30222r
            r16 = r15
            java.lang.Long r15 = r0.f30223s
            r17 = r15
            java.lang.Long r15 = r0.f30224t
            r18 = r15
            java.lang.Long r15 = r0.f30225u
            r19 = r15
            java.lang.Integer r15 = r0.f30226v
            r20 = r15
            java.lang.Integer r15 = r0.f30227w
            r21 = r15
            java.lang.Float r15 = r0.f30228x
            r22 = r15
            java.lang.Integer r15 = r0.f30229y
            r23 = r7
            java.util.Date r7 = r0.f30230z
            r24 = 0
            if (r7 == 0) goto L_0x004b
            java.lang.Object r7 = r7.clone()
            r25 = r8
            goto L_0x004f
        L_0x004b:
            r25 = r8
            r7 = r24
        L_0x004f:
            boolean r8 = r7 instanceof java.util.Date
            if (r8 == 0) goto L_0x0058
            java.util.Date r7 = (java.util.Date) r7
            r26 = r7
            goto L_0x005a
        L_0x0058:
            r26 = r24
        L_0x005a:
            java.lang.String r8 = r0.B
            java.lang.String r7 = r0.E
            r27 = r15
            java.lang.Float r15 = r0.F
            r29 = r8
            java.lang.Float r8 = r0.f30213i
            r30 = r7
            java.lang.String[] r7 = r0.f30212h
            if (r7 == 0) goto L_0x0075
            java.lang.Object r7 = r7.clone()
            java.lang.String[] r7 = (java.lang.String[]) r7
            r31 = r15
            goto L_0x0079
        L_0x0075:
            r31 = r15
            r7 = r24
        L_0x0079:
            java.lang.String r15 = r0.D
            java.lang.String r0 = r0.A
            r34 = r15
            if (r0 == 0) goto L_0x008d
            java.lang.StringBuffer r15 = new java.lang.StringBuffer
            r15.<init>(r0)
            java.lang.String r0 = r15.toString()
            r35 = r0
            goto L_0x008f
        L_0x008d:
            r35 = r24
        L_0x008f:
            r28 = 0
            r32 = 134217728(0x8000000, float:3.85186E-34)
            r33 = 0
            r0 = r36
            r24 = r25
            r25 = r22
            r22 = r21
            r21 = r20
            r20 = r19
            r19 = r18
            r18 = r17
            r15 = r16
            r16 = r24
            r17 = r23
            r23 = r25
            r24 = r27
            r25 = r26
            r26 = r35
            r27 = r29
            r29 = r34
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String[]) r7, (java.lang.Float) r8, (java.lang.Boolean) r9, (java.lang.Boolean) r10, (com.sumsub.sentry.Device.DeviceOrientation) r11, (java.lang.Boolean) r12, (java.lang.Long) r13, (java.lang.Long) r14, (java.lang.Long) r15, (java.lang.Boolean) r16, (java.lang.Long) r17, (java.lang.Long) r18, (java.lang.Long) r19, (java.lang.Long) r20, (java.lang.Integer) r21, (java.lang.Integer) r22, (java.lang.Float) r23, (java.lang.Integer) r24, (java.util.Date) r25, (java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.Float) r31, (int) r32, (kotlin.jvm.internal.r) r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.Device.<init>(com.sumsub.sentry.Device):void");
    }
}
