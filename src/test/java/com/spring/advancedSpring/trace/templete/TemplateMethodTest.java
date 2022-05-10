package com.spring.advancedSpring.trace.templete;


import com.spring.advancedSpring.trace.templete.code.AbstractTemplateClass;
import com.spring.advancedSpring.trace.templete.code.SubClassLogic1;
import com.spring.advancedSpring.trace.templete.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodTest(){
        logic1();
        logic2();

    }

    @Test
    void templateMethodV1(){
        AbstractTemplateClass subClass1 = new SubClassLogic1();
        AbstractTemplateClass subClass2 = new SubClassLogic2();

        subClass1.execute();
        subClass2.execute();
    }
    
    @Test
    void templateMethodV2(){
        AbstractTemplateClass abstractTemplateClass1 = new AbstractTemplateClass() {
            @Override
            protected void call() {
                log.info("비즈니스로직 1 실행");
            }
        };

        AbstractTemplateClass abstractTemplateClass2 = new AbstractTemplateClass() {
            @Override
            protected void call() {
                log.info("비즈니스로직 2 실행");
            }
        };
        log.info("클래스 1 이름 : " + abstractTemplateClass1.getClass());
        abstractTemplateClass1.execute();
        log.info("클래스 2 이름 : " + abstractTemplateClass2.getClass());
        abstractTemplateClass2.execute();


    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime = {}", resultTime);
    }


}

