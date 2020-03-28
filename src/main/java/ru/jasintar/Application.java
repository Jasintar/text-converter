package ru.jasintar;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Slf4j
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("App started");
    }

}
