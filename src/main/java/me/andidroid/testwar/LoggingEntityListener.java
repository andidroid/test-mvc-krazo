package me.andidroid.testwar;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

public class LoggingEntityListener
{
    /**
     * Logging via slf4j api
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoggingEntityListener.class);
    
    /**
     *
     */
    @PostConstruct
    public void initialize()
    {
        LOGGER.info("LoggingEntityListener.initialize()");
    }
    
    @Override
    @PreDestroy
    public void finalize()
    {
        
    }
    
    @PostPersist
    public void onCreated(Object obj)
    {
        LOGGER.info("LoggingEntityListener.onCreated: {}", obj);
    }
    
    @PostRemove
    public void onDeleted(Object obj)
    {
        LOGGER.info("LoggingEntityListener.onDeleted: {}", obj);
    }
    
    @PostUpdate
    public void onUpdated(Object obj)
    {
        LOGGER.info("LoggingEntityListener.onUpdated: {}", obj);
    }
    
    @PostLoad
    public void onRead(Object obj)
    {
        LOGGER.info("LoggingEntityListener.onRead: {}", obj);
    }
}
