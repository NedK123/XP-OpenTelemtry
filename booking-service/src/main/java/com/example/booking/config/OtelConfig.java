package com.example.booking.config;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelConfig {

    @Value("${monitoring.endpoint.url}")
    private String monitoringToolEndpointUrl;

    @Bean
    SpanExporter otlpHttpSpanExporter() {
        System.out.println(monitoringToolEndpointUrl);
        return OtlpHttpSpanExporter.builder()
                .addHeader("Content-Type", "application/x-protobuf")
                .setEndpoint(monitoringToolEndpointUrl)
                .build();
    }

}
