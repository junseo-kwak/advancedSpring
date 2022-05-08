package com.spring.advancedSpring.trace.hellotrace;

import com.spring.advancedSpring.trace.TraceStatus;
import com.spring.advancedSpring.trace.helloTrace.HelloTraceV1;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {


    @Test
    void begin_end(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();

        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.end(status);
    }

    @Test
    void begin_exception(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();

        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.exception(status,new IllegalArgumentException());

    }


}
