package com.sb.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by sboursault on 6/25/16.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.sb.log")
public class Config {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Sample bean = (Sample) ctx.getBean(Sample.class);

        bean.testMethodWithAnnotation("1stValue", "2ndValue");
    }

}
