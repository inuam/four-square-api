package com.au.utils;


import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;


public final class SubstitutePathParameters {

    private final String path;
    private final Map<String, String> parameters;

    private SubstitutePathParameters(String path, Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public static SubstitutePathParameters substitutePath(String path) {
        return new SubstitutePathParameters(Objects.requireNonNull(path, "Path name must NOT be null"), new HashMap<>());
    }

    public SubstitutePathParameters parameter(String name, String value) {
        parameters.put(requireNonNull(name, "Parameter name must NOT be null")
                , requireNonNull(value, "Parameter value must NOT be null"));
        return this;
    }

    public String path() {
        StringSubstitutor sub = new StringSubstitutor(parameters);
        return sub.replace(path);
    }
}
