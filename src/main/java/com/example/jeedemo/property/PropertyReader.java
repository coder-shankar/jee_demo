package com.example.jeedemo.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by prkandel on 3/30/17.
 */
public class PropertyReader {

    private static Properties properties;

    @Property
    @Produces
    public String produceString(final InjectionPoint ip) {
        return this.properties.getProperty(getKey(ip));
    }

    @Property
    @Produces
    public long produceLong(final InjectionPoint ip) {
        return Long.valueOf(this.properties.getProperty(getKey(ip)));
    }

    @Property
    @Produces
    public boolean produceBoolean(final InjectionPoint ip) {
        return Boolean.valueOf(this.properties.getProperty(getKey(ip)));
    }

    @Property
    @Produces
    public List<String> produceListString(final InjectionPoint ip) {
        return Arrays.asList(String.valueOf(this.properties.getProperty(getKey(ip))).split(","));
    }


    private String getKey(final InjectionPoint injectionPoint) {
        return injectionPoint.getQualifiers().stream().filter(Property.class::isInstance).map(Property.class::cast).findAny().map(Property::value)
            .orElseThrow(RuntimeException::new);
    }

    @PostConstruct
    public void init() {
        if (properties == null) {
            this.properties = new Properties();
            final InputStream stream = PropertyReader.class
                    .getResourceAsStream("/config.properties");
            if (stream == null) {
                throw new RuntimeException("No properties!!!");
            }
            try {
                this.properties.load(stream);
            } catch (final IOException e) {
                throw new RuntimeException("Configuration could not be loaded!");
            }
        }
    }
}
