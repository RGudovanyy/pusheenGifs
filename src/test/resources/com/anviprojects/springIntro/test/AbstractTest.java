package com.anviprojects.springIntro.test;

import com.anviprojects.springIntro.AppConfig;
import javafx.application.Application;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
public abstract class AbstractTest {

    protected Logger logger = Logger.getLogger(this.getClass());
}
