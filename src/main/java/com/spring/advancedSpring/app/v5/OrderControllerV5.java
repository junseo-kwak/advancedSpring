package com.spring.advancedSpring.app.v5;

import com.spring.advancedSpring.trace.callback.TraceCallBack;
import com.spring.advancedSpring.trace.callback.TraceTemplate;
import com.spring.advancedSpring.trace.logtrace.LogTrace;
import com.spring.advancedSpring.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;


    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId){

        return template.execute("OrderController.request()", () -> {
                        orderService.orderItem(itemId);
                        return "OK";
                }
        );
    }

}
