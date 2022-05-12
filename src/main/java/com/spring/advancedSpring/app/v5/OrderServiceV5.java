package com.spring.advancedSpring.app.v5;


import com.spring.advancedSpring.trace.logtrace.LogTrace;
import com.spring.advancedSpring.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final LogTrace trace;
    public void orderItem(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepositoryV5.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }

}
