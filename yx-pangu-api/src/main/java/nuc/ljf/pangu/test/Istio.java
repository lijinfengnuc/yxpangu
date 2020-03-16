/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import me.snowdrop.istio.api.cexl.AttributeVocabulary;
import me.snowdrop.istio.api.cexl.TypedValue;
import me.snowdrop.istio.client.DefaultIstioClient;
import me.snowdrop.istio.client.IstioClient;
import me.snowdrop.istio.mixer.template.metric.Metric;
import me.snowdrop.istio.mixer.template.metric.MetricBuilder;

/**
 * ClassName: Istio <br/>
 * Function: <br/>
 * date: 2019年05月23日 16:24 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class Istio {

    public static void main(String[] args) {
        Config config = new ConfigBuilder().withMasterUrl("http://172.16.3.25:23333").build();
        IstioClient istioClient = new DefaultIstioClient(config);
        Metric metric = new MetricBuilder()
                .withNewMetadata()
                .withName("recommendationrequestcount")
                .withNamespace("istio-system")
                .endMetadata()
                .withNewSpec()
                .withNewValue().withExpression("1").endValue()
                .addToDimensions("source", TypedValue.from(AttributeVocabulary.source_service + "|\"unknown\""))
                .addToDimensions("destination", TypedValue.from(AttributeVocabulary.destination_service + "|\"unknown \""))
                .addToDimensions("version", TypedValue.from(AttributeVocabulary.destination_labels + "[\"version\"] | \"unknown\""))
                .addToDimensions("user_agent", TypedValue.from(AttributeVocabulary.request_headers + "[\"user-agent\"]|\"unknown\""))
                .withMonitoredResourceType("UNSPECIFIED")
                .endSpec()
                .build();

        //when
        Metric resultResource = istioClient.mixer().metric().create(metric);
        System.out.println(resultResource.toString());
    }

}
