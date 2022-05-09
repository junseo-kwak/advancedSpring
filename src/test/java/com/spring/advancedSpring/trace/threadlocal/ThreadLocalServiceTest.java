package com.spring.advancedSpring.trace.threadlocal;

import com.spring.advancedSpring.trace.threadlocal.code.FieldService;
import com.spring.advancedSpring.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {


    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = () ->{
            service.logic("userA");
        };

        Runnable userB = () ->{
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);
        threadA.setName("Thread-A");
        threadB.setName("Thread-B");

        threadA.start();
        sleep(100);
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
