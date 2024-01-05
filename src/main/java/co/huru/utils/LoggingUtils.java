package co.huru.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Base64;

public class LoggingUtils {

    private static final Logger log = LogManager.getLogger(LoggingUtils.class);

    private LoggingUtils() {

    }

    public static void log(File file, String message) {
        log.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message);
    }

    public static void log(byte[] bytes, String message) {
        log.info("RP_MESSAGE#BASE64#{}#{}", Base64.getEncoder().encodeToString(bytes), message);
    }

    public static void log(String base64, String message) {
        log.info("RP_MESSAGE#BASE64#{}#{}", base64, message);
    }
}
