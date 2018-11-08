package com.dk.me.appenders;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

@Plugin(name = "MyAppender", category = "Core", elementType = "appender", printObject = true)
public final class MyAppender extends AbstractAppender {

    private MyAppender(String name, Layout<String> layout, Filter filter, boolean ignoreExceptions) {
        super(name, filter, layout);
    }

    @PluginFactory
    public static MyAppender createAppender(@PluginAttribute("name") String name,
                                              @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
                                              @PluginElement("Layout") Layout<String> layout,
                                              @PluginElement("Filters") Filter filter) {
        if (name == null) {
            return null;
        }

        if (layout == null) {
            layout = PatternLayout.newBuilder().withPattern(":) %d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n").build();
        }
        return new MyAppender(name, layout, filter, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {
        System.out.println(getLayout());
    }
}