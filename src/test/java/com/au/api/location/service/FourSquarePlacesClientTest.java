package com.au.api.location.service;

import com.au.api.location.LocationPaths;
import com.au.api.location.entity.VenueResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FourSquarePlacesClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private LocationPaths locationPaths;

    @InjectMocks
    private FourSquarePlacesClient classToTest;

    @Test
    public void shouldCallFourSquareVenuesApiWithPlaceName(){
        // Given
        String placeName = "London";
        String url = "http://url";

        given(locationPaths.getVenuesUrl(placeName)).willReturn(url);
        
        // When
        classToTest.getPlacesByName(placeName);
        
        // Then
        verify(restTemplate).getForEntity(url, VenueResponse.class);
    }
    
}