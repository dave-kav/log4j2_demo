package com.dk.me.filters;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

@Plugin(name = "FibonacciFilter", category = "Core", elementType = "filter", printObject = true)
public class FibonacciFilter extends AbstractFilter {

    private final Level level;

    private FibonacciFilter(Level level, Result onMatch, Result onMismatch) {
        super(onMatch, onMismatch);
        this.level = level;
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object[] params) {
        return filter(msg);
    }

    public Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        return filter(msg.toString());
    }

    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return filter(msg.toString());
    }

    @Override
    public Result filter(LogEvent event) {
        return filter(event.getMessage().getFormattedMessage());
    }

    private Result filter(String msg) {
//        System.out.println(String.format("Message in filter: %s", msg));
        return msg.toLowerCase().contains("fibonacci") ? onMatch : onMismatch;
    }

    @Override
    public String toString() {
        return level.toString();
    }

    /**
     * Create a FibonacciFilter.
     * @param level The log Level.
     * @param onMatch The action to take on a match.
     * @param onMismatch The action to take on a mismatch.
     * @return The created FibonacciFilter.
     */
    @PluginFactory
    public static FibonacciFilter createFilter(@PluginAttribute(value = "level", defaultString = "ERROR") Level level,
                                               @PluginAttribute(value = "onMatch", defaultString = "NEUTRAL") Result onMatch,
                                               @PluginAttribute(value = "onMismatch", defaultString = "DENY") Result onMismatch) {
        return new FibonacciFilter(level, onMatch, onMismatch);
    }
}
