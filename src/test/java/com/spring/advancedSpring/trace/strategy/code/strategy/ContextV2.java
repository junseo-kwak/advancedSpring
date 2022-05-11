package com.spring.advancedSpring.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/* 
    Strategy를 파라미터로 받는 전략 패턴
 */

@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy){
        log.info("execute start");
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("종료 시간 : " + resultTime);

    }

}
