package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    static final Logger logger = LogManager.getLogger(Logs.class);

    public static void log(String msg, String leve) {
        logger.info(msg);
    }
}
