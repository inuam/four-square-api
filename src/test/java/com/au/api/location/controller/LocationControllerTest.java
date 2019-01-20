package com.au.api.location.controller;

import com.au.api.location.domain.Place;
import com.au.api.location.service.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class LocationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LocationService locationService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new LocationController(locationService)).build();
    }

    @Test
    public void shouldReturnLocations() throws Exception {
        // Given
        Place trafalgarSquare = Place.newPlace()
                .withPlaceName("Trafalgar Square")
                .withCity("London")
                .withState("Greater London")
                .withPostalCode("WC2N 5DX")
                .build();

        given(locationService.findPlace("london")).willReturn(singletonList(trafalgarSquare));

        // When
        mockMvc.perform(get("/api/place/search?placeName=london"))
//                .andDo(MockMvcResultHandlers.print())
                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placeName").value("Trafalgar Square"))
                .andExpect(jsonPath("$[0].city").value("London"))
                .andExpect(jsonPath("$[0].state").value("Greater London"))
                .andExpect(jsonPath("$[0].postalCode").value("WC2N 5DX"));
    }
}