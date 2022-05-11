package com.spring.advancedSpring.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/*
    Strategy를 필드에서 관리하는 전략 패턴
 */


@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }
    public void execute(){
        log.info("execute start");
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("종료 시간 : " + resultTime);

    }

}
