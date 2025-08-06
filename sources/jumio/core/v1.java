package jumio.core;

import androidx.core.util.c;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.IOUtils;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class v1<T> extends ApiCall<T> {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f56332h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final String f56333i = LogUtils.NEW_LINE;

    /* renamed from: j  reason: collision with root package name */
    public final String f56334j;

    /* renamed from: k  reason: collision with root package name */
    public final String f56335k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f56336l;

    public v1(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        String str = "+++Android_JMSDK_mobile_" + UUID.randomUUID() + "+++";
        this.f56334j = "--" + str + LogUtils.NEW_LINE;
        this.f56335k = "--" + str + "--" + LogUtils.NEW_LINE;
        Map<String, String> y11 = MapsKt__MapsKt.y(super.getHeaders());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("multipart/form-data; boundary=");
        sb2.append(str);
        y11.put("Content-Type", sb2.toString());
        this.f56336l = y11;
    }

    public static /* synthetic */ void addPart$default(v1 v1Var, String[] strArr, Object obj, int i11, int i12, Object obj2) {
        if (obj2 == null) {
            if ((i12 & 4) != 0) {
                i11 = -1;
            }
            v1Var.addPart(strArr, obj, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPart");
    }

    public static /* synthetic */ void getParts$jumio_core_release$annotations() {
    }

    public final void addPart(String[] strArr, Object obj, int i11) {
        boolean z11 = true;
        if (!(obj instanceof InputStream ? true : obj instanceof File ? true : obj instanceof String)) {
            z11 = obj instanceof byte[];
        }
        if (!z11) {
            String simpleName = obj.getClass().getSimpleName();
            throw new Exception(simpleName + " is not supported");
        } else if (i11 == -1) {
            this.f56332h.add(new c(strArr, obj));
        } else {
            this.f56332h.add(i11, new c(strArr, obj));
        }
    }

    public void fillRequest(OutputStream outputStream) throws IOException {
        Iterator it2 = this.f56332h.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            outputStream.write(this.f56334j.getBytes(Charset.forName("UTF-8")));
            for (String bytes : (String[]) cVar.f8468a) {
                outputStream.write(bytes.getBytes(Charset.forName("UTF-8")));
                outputStream.write(this.f56333i.getBytes(Charset.forName("UTF-8")));
            }
            outputStream.write(this.f56333i.getBytes(Charset.forName("UTF-8")));
            S s11 = cVar.f8469b;
            if (s11 instanceof InputStream) {
                IOUtils.copy((InputStream) s11, outputStream);
                IOUtils.closeQuietly((InputStream) cVar.f8469b);
            } else if (s11 instanceof File) {
                FileInputStream fileInputStream = new FileInputStream((File) cVar.f8469b);
                IOUtils.copy(fileInputStream, outputStream);
                IOUtils.closeQuietly(fileInputStream);
            } else if (s11 instanceof String) {
                outputStream.write(((String) s11).getBytes(Charset.forName("UTF-8")));
            } else if (s11 instanceof byte[]) {
                outputStream.write((byte[]) s11);
            }
            outputStream.write(this.f56333i.getBytes(Charset.forName("UTF-8")));
        }
        outputStream.write(this.f56335k.getBytes(Charset.forName("UTF-8")));
    }

    public Map<String, String> getHeaders() {
        return this.f56336l;
    }

    public final List<c<String[], Object>> getParts$jumio_core_release() {
        return this.f56332h;
    }

    public abstract void prepareData() throws Exception;

    public int prepareRequest() throws Exception {
        this.f56332h.clear();
        prepareData();
        if (this.f56332h.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            Iterator it2 = this.f56332h.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                int length = this.f56334j.length() + i11;
                sb2.append(this.f56334j);
                for (String str : (String[]) cVar.f8468a) {
                    length = this.f56333i.length() + str.length() + length;
                    sb2.append(str);
                    sb2.append(this.f56333i);
                }
                int length2 = this.f56333i.length() + length;
                sb2.append(this.f56333i);
                S s11 = cVar.f8469b;
                if (s11 instanceof InputStream) {
                    try {
                        length2 += ((InputStream) s11).available();
                        sb2.append("<InputStream>");
                    } catch (IOException e11) {
                        Log.e(getTAG(), (Throwable) e11);
                    }
                } else if (s11 instanceof File) {
                    length2 += (int) ((File) s11).length();
                    sb2.append("<File>");
                } else if (s11 instanceof String) {
                    length2 += ((String) s11).length();
                    sb2.append((String) cVar.f8469b);
                } else if (s11 instanceof byte[]) {
                    length2 += ((byte[]) s11).length;
                    sb2.append("<byte[]>");
                }
                i11 = length2 + this.f56333i.length();
                sb2.append(this.f56333i);
            }
            int length3 = this.f56335k.length() + i11;
            sb2.append(this.f56335k);
            LogUtils.INSTANCE.logServerRequest(getClass().getSimpleName(), sb2.toString());
            return length3;
        }
        throw new Exception("Nothing to upload");
    }
}
