package com.spring.advancedSpring.trace.strategy;


import com.spring.advancedSpring.trace.strategy.code.template.CallBack;
import com.spring.advancedSpring.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {

    private TimeLogTemplate template = new TimeLogTemplate();

    @Test
    void callBackV1(){

        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    @Test
    void callBackV2(){
        
        template.execute(()->{
            log.info("비즈니스 로직 1 실행");
        });

        template.execute(() -> {
            log.info("비즈니스 로직 2 실행");
        });
    }

}
