package com.au.api.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.au.utils.SubstitutePathParameters.substitutePath;

@Component
public class LocationPaths {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationPaths.class);
    private static final String VENUES = "/venues/search?near=${placeName}&client_id=${clientId}&client_secret=${secretKey}&v=20190114";

    private final String basePath;
    private final String clientId;
    private final String secretKey;

    public LocationPaths(@Value("${four.square.base.path}") String basePath
            , @Value("${four.square.clientId}") String clientId
            , @Value("${four.square.secretKey}") String secretKey) {
        this.basePath = basePath;
        this.clientId = clientId;
        this.secretKey = secretKey;
    }

    public String getVenuesUrl(String placeName) {
        return pathTo(substitutePath(VENUES)
                .parameter("placeName", placeName)
                .parameter("clientId", clientId)
                .parameter("secretKey", secretKey)
                .path());
    }

    private String pathTo(String somewhere) {
        String path = basePath + somewhere;
        LOGGER.debug("Path is {}", path);
        return path;
    }
}
