package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.plugins.capabilities.api.Capability;
import org.sonatype.nexus.plugins.capabilities.api.CapabilityFactory;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptors;

@Named( RequestInterceptorCapability.ID )
@Singleton
public class RequestInterceptorCapabilityFactory
    implements CapabilityFactory
{

    private final RequestInterceptors requestInterceptors;

    @Inject
    RequestInterceptorCapabilityFactory( final RequestInterceptors requestInterceptors )
    {
        this.requestInterceptors = requestInterceptors;
    }

    @Override
    public Capability create( final String id )
    {
        return new RequestInterceptorCapability( id, requestInterceptors );
    }

}
