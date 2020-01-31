package com.au.api.location;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocationPathsTest {

    private String basePath = "http://au.systems.com";
    private String clientId = "123";
    private String secretKey = "xyz";

    private LocationPaths classToTest = new LocationPaths(basePath, clientId, secretKey);

    @Test
    public void shouldReturnFQVenuesUrl() {
        // Given

        // When
        String actualUrl = classToTest.getVenuesUrl("kingston");

        // Then
        assertThat(actualUrl, is("http://au.systems.com/venues/search?near=kingston&client_id=123&client_secret=xyz&v=20190114"));
    }

}