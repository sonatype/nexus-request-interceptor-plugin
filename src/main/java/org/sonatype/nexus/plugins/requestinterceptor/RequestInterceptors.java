package org.sonatype.nexus.plugins.requestinterceptor;

import java.util.Collection;

import org.sonatype.nexus.proxy.access.Action;

public interface RequestInterceptors
{
    void handle( String repositoryId, String requestPath, Action action );

    void addConfiguration( final RequestInterceptorConfiguration configuration );

    void removeConfiguration( final RequestInterceptorConfiguration configuration );

    Collection<RequestInterceptorConfiguration> getConfigurations( String repositoryId );

}
