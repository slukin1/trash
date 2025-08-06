package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.XksProxyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class XksProxyConfigurationTypeJsonUnmarshaller implements Unmarshaller<XksProxyConfigurationType, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static XksProxyConfigurationTypeJsonUnmarshaller f15108a;

    public static XksProxyConfigurationTypeJsonUnmarshaller b() {
        if (f15108a == null) {
            f15108a = new XksProxyConfigurationTypeJsonUnmarshaller();
        }
        return f15108a;
    }

    /* renamed from: c */
    public XksProxyConfigurationType a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        XksProxyConfigurationType xksProxyConfigurationType = new XksProxyConfigurationType();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Connectivity")) {
                xksProxyConfigurationType.setConnectivity(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("AccessKeyId")) {
                xksProxyConfigurationType.setAccessKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("UriEndpoint")) {
                xksProxyConfigurationType.setUriEndpoint(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("UriPath")) {
                xksProxyConfigurationType.setUriPath(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("VpcEndpointServiceName")) {
                xksProxyConfigurationType.setVpcEndpointServiceName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return xksProxyConfigurationType;
    }
}
