package cn.videon.meeting.voice.web.rest.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BadRequestAlertException extends AbstractThrowableProblem {

    private final static Logger log = LoggerFactory.getLogger(BadRequestAlertException.class);

    private static final long serialVersionUID = 1L;

    private final String params;

    private final String errorKey;

    public BadRequestAlertException(String defaultMessage, String params, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, params, errorKey);
        log.warn(defaultMessage);
    }

    public BadRequestAlertException(URI type, String defaultMessage, String params, String errorKey) {
        super(type, params, Status.BAD_REQUEST, null, null, null, getAlertParameters(params, errorKey));
        this.params = params;
        this.errorKey = errorKey;
    }

    public String getParams() {
        return params;
    }

    public String getErrorKey() {
        return errorKey;
    }

    private static Map<String, Object> getAlertParameters(String params, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", errorKey);
        parameters.put("params", params);
        return parameters;
    }
}
