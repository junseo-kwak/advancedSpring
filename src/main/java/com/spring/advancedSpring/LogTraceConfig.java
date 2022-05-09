package com.spring.advancedSpring;

import com.spring.advancedSpring.trace.logtrace.FieldLogTrace;
import com.spring.advancedSpring.trace.logtrace.LogTrace;
import com.spring.advancedSpring.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
