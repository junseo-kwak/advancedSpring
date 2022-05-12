package com.spring.advancedSpring.app.v5;


import com.spring.advancedSpring.trace.callback.TraceTemplate;
import com.spring.advancedSpring.trace.logtrace.LogTrace;
import com.spring.advancedSpring.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId){

        template.execute("OrderService.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }

}
