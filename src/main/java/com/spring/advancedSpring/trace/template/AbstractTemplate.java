package com.spring.advancedSpring.trace.template;

import com.spring.advancedSpring.trace.TraceStatus;
import com.spring.advancedSpring.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message){

        TraceStatus status = null;

        try {
            status = logTrace.begin(message);
            // 비즈니스 로직
            T result = call();

            logTrace.end(status);
            return result;
        }catch(Exception e){
            logTrace.exception(status,e);
            throw e;
        }

    }

    protected abstract T call();


}
