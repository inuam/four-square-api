package com.au.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class SubstitutePathParametersTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldSubstitutePathWithParameters() {
        // Given
        String expected = "http://google?q=kingston";
        String path = "http://google?q=${query}";

        // When
        String actual = SubstitutePathParameters.substitutePath(path)
                .parameter("query", "kingston")
                .path();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldThrowExceptionWhenSubstitutingWithNullPath() {
        // Expect
        exception.expect(NullPointerException.class);
        exception.expectMessage(containsString("Path name must NOT be null"));

        // When
        SubstitutePathParameters.substitutePath(null);
    }

    @Test
    public void shouldThrowExceptionWhenSubstitutingWithNullParameterName() {
        // Expect
        exception.expect(NullPointerException.class);
        exception.expectMessage(containsString("Parameter name must NOT be null"));

        // When
        SubstitutePathParameters.substitutePath("SomePath")
                .parameter(null, "kingston")
                .path();
    }

    @Test
    public void shouldThrowExceptionWhenSubstitutingWithNullParameterValue() {
        // Expect
        exception.expect(NullPointerException.class);
        exception.expectMessage(containsString("Parameter value must NOT be null"));

        // When
        SubstitutePathParameters.substitutePath("SomePath")
                .parameter("city", null)
                .path();
    }
}