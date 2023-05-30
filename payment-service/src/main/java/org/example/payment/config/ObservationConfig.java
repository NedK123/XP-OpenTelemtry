package org.example.payment.config;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ObservationConfig {

    @Bean
    public OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
        return OtlpHttpSpanExporter.builder().setEndpoint(url).build();
    }

}
