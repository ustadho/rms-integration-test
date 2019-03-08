package com.mitrais.bootcamp.rms.controller.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

public final class HeaderUtil {
    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    public HeaderUtil(){}

    public static HttpHeaders createAlert(String message, String param){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-mitrais-alert", message);
        headers.add("X-mitrais-params", param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName, String param){
        return createAlert("A new "+entityName+" is created with identifier "+param, param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param){
        return createAlert("A new "+entityName+" is updated with identifier "+param, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param){
        return createAlert("A new "+entityName+" is deleted with identifier "+param, param);
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        log.error("Entity creation failed, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-mitrais-error", defaultMessage);
        headers.add("X-mitrais-params", entityName);
        return headers;
    }
}
