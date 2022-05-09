package com.spring.advancedSpring.trace.logtrace;

import com.spring.advancedSpring.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);


}
