package com.au.api.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.au.utils.SubstitutePathParameters.substitutePath;

public class LocationPaths {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationPaths.class);
    private static final String VENUES = "/venues/search?query=${placeName}&clientId=${clientId}&secretKey=${secretKey}";

    private final String basePath;
    private final String clientId;
    private final String secretKey;

    public LocationPaths(String basePath, String clientId, String secretKey) {
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
