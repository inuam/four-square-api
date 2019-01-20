package com.au.api.location.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonDeserialize(builder = Place.class)
public final class Place {

    private final String placeName;
    private final String city;
    private final String state;
    private final String postalCode;

    public String getPlaceName() {
        return placeName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        return new EqualsBuilder()
                .append(placeName, place.placeName)
                .append(city, place.city)
                .append(state, place.state)
                .append(postalCode, place.postalCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(placeName)
                .append(city)
                .append(state)
                .append(postalCode)
                .toHashCode();
    }

    private Place(Builder builder) {
        placeName = builder.placeName;
        city = builder.city;
        state = builder.state;
        postalCode = builder.postalCode;
    }

    public static Builder newPlace() {
        return new Builder();
    }

    public static Builder newPlace(Place copy) {
        Builder builder = new Builder();
        builder.placeName = copy.getPlaceName();
        builder.city = copy.getCity();
        builder.state = copy.getState();
        builder.postalCode = copy.getPostalCode();
        return builder;
    }


    public static final class Builder {
        private String placeName;
        private String city;
        private String state;
        private String postalCode;

        private Builder() {
        }

        public Builder withPlaceName(String val) {
            placeName = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withState(String val) {
            state = val;
            return this;
        }

        public Builder withPostalCode(String val) {
            postalCode = val;
            return this;
        }

        public Place build() {
            return new Place(this);
        }
    }
}
