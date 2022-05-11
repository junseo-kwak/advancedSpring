package com.spring.advancedSpring.trace.strategy;

import com.spring.advancedSpring.trace.strategy.code.strategy.ContextV1;
import com.spring.advancedSpring.trace.strategy.code.strategy.StrategyLogic1;
import com.spring.advancedSpring.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV1(){
        ContextV1 context1 = new ContextV1(new StrategyLogic1());
        ContextV1 context2 = new ContextV1(new StrategyLogic2());
        
        context1.execute();
        context2.execute();
        
        
    }

}
