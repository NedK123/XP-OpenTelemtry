package com.example.booking.config;

import io.lettuce.core.resource.ClientResources;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationPredicate;
import io.micrometer.observation.ObservationRegistry;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.observability.MicrometerTracingAdapter;
import org.springframework.http.server.observation.ServerRequestObservationContext;

@Configuration
public class TracingConfig {

    @Bean
    ObservationPredicate ignoreActuator() {
        return (s, context) -> ignoreActuatorRecursive(context);
    }

    @Bean
    public ClientResources clientResources(ObservationRegistry observationRegistry) {
        return ClientResources.builder()
                .tracing(new MicrometerTracingAdapter(observationRegistry, "redis"))
                .build();
    }

    public boolean ignoreActuatorRecursive(Observation.ContextView context) {
        if (context instanceof ServerRequestObservationContext serverRequestObservationContext) {
            HttpServletRequest carrier = serverRequestObservationContext.getCarrier();
            return !carrier.getServletPath().startsWith("/actuator"); // <----- Line (*)
        }

        if (context.getParentObservation() != null) {  // <-- Will the parent still be set if it was ignored in line (*)?
            return ignoreActuatorRecursive(context.getParentObservation().getContextView());
        }

        return true;
    }

}
