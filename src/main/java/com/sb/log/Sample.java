package com.sb.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by sboursault on 26/07/16.
 */
@Component
public class Sample {

    @LogInfo("'Calling test method with ' + #input1 + ' and ' + #input2")
    public void testMethodWithAnnotation(String input1, String input2) {
        // do stuff
    }

}
