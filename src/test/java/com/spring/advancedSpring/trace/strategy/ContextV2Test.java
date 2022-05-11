package com.spring.advancedSpring.trace.strategy;

import com.spring.advancedSpring.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1(){
        ContextV2 context1 = new ContextV2();

        context1.execute(new StrategyLogic1());
        context1.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2(){
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");               
            }
        };
        
        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };

        ContextV2 context = new ContextV2();
        context.execute(strategy1);
        context.execute(strategy2);

    }

    @Test
    void strategyV3(){
        ContextV2 context = new ContextV2();
        context.execute(() -> {
            log.info("비즈니스 로직 1 실행");
        });
        
        context.execute(() -> {
            log.info("비즈니스 로직 2 실행");
        });


    }
}
