package com.spring.advancedSpring.app.v5;


import com.spring.advancedSpring.trace.logtrace.LogTrace;
import com.spring.advancedSpring.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {

    private final LogTrace trace;

    public void save(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")){
                    throw new IllegalArgumentException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
