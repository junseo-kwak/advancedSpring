package com.spring.advancedSpring.trace.hellotrace;

import com.spring.advancedSpring.trace.TraceStatus;
import com.spring.advancedSpring.trace.helloTrace.HelloTraceV1;
import com.spring.advancedSpring.trace.helloTrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {


    @Test
    void begin_end(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();

        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(),"hello2");
        helloTraceV2.end(status2);
        helloTraceV2.end(status1);
    }

    @Test
    void begin_exception(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();

        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(),"hello2");
        helloTraceV2.exception(status2,new IllegalArgumentException());
        helloTraceV2.exception(status1,new IllegalArgumentException());

    }


}
