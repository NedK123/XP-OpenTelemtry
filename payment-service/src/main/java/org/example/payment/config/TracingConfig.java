package org.example.payment.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationPredicate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.observation.ServerRequestObservationContext;

@Configuration
public class TracingConfig {

    @Bean
    ObservationPredicate ignoreActuator() {
        return (s, context) -> ignoreActuatorRecursive(context);
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
