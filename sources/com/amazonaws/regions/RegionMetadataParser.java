package com.amazonaws.regions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Deprecated
public class RegionMetadataParser {
    public static void a(Region region, Element element, boolean z11) {
        String b11 = b("ServiceName", element);
        String b12 = b("Hostname", element);
        String b13 = b("Http", element);
        String b14 = b("Https", element);
        if (!z11 || f(b12)) {
            region.h().put(b11, b12);
            region.b().put(b11, Boolean.valueOf("true".equals(b13)));
            region.c().put(b11, Boolean.valueOf("true".equals(b14)));
            return;
        }
        throw new IllegalStateException("Invalid service endpoint (" + b12 + ") is detected.");
    }

    public static String b(String str, Element element) {
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null) {
            return null;
        }
        return item.getChildNodes().item(0).getNodeValue();
    }

    public static List<Region> c(InputStream inputStream, boolean z11) throws IOException {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            NodeList elementsByTagName = parse.getElementsByTagName("Region");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < elementsByTagName.getLength(); i11++) {
                Node item = elementsByTagName.item(i11);
                if (item.getNodeType() == 1) {
                    arrayList.add(d((Element) item, z11));
                }
            }
            return arrayList;
        } catch (IOException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IOException("Unable to parse region metadata file: " + e12.getMessage(), e12);
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }

    public static Region d(Element element, boolean z11) {
        Region region = new Region(b("Name", element), b("Domain", element));
        NodeList elementsByTagName = element.getElementsByTagName("Endpoint");
        for (int i11 = 0; i11 < elementsByTagName.getLength(); i11++) {
            a(region, (Element) elementsByTagName.item(i11), z11);
        }
        return region;
    }

    public static boolean f(String str) {
        return str.endsWith(".amazonaws.com");
    }

    @Deprecated
    public List<Region> e(InputStream inputStream) throws IOException {
        return c(inputStream, false);
    }
}
