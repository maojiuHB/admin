package cn.videon.meeting.voice.web.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import static cn.videon.meeting.voice.config.Constants.APPLICATION_NAME;


/**
 * Utility class for HTTP headers creation.
 */
public final class HeaderUtil {

    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    private HeaderUtil() {
    }

    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + APPLICATION_NAME + "-alert", message);
        headers.add("X-" + APPLICATION_NAME + "-params", param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String param) {
        return createAlert("creation", param);
    }

    public static HttpHeaders createEntityUpdateAlert( String param) {
        return createAlert("update", param);
    }

    public static HttpHeaders createEntityDeletionAlert( String param) {
        return createAlert("deletion", param);
    }

    public static HttpHeaders createSuccessAlert() {
        return createAlert("success", "");
    }
    public static HttpHeaders createErrorAlert() {
        return createFailureAlert("error", "");
    }
    public static HttpHeaders createFailureAlert( String errorKey, String params) {
        log.error("Entity processing failed, {}", params);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + APPLICATION_NAME + "-error", errorKey);
        headers.add("X-" + APPLICATION_NAME + "-params", params);
        return headers;
    }
}
