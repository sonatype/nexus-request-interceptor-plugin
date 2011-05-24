package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import java.util.Map;

import org.sonatype.nexus.plugins.capabilities.api.AbstractCapability;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptorConfiguration;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptors;

public class RequestInterceptorCapability
    extends AbstractCapability
{

    public static final String ID = "requestInterceptorCapability";

    private final RequestInterceptors requestInterceptors;

    private RequestInterceptorConfiguration configuration;

    public RequestInterceptorCapability( final String id, final RequestInterceptors requestInterceptors )
    {
        super( id );
        this.requestInterceptors = requestInterceptors;
    }

    @Override
    public void create( final Map<String, String> properties )
    {
        load( properties );
    }

    @Override
    public void load( final Map<String, String> properties )
    {
        configuration = createConfiguration( properties );
        requestInterceptors.addConfiguration( configuration );
    }

    @Override
    public void update( final Map<String, String> properties )
    {
        final RequestInterceptorConfiguration newConfiguration = createConfiguration( properties );
        if ( !configuration.equals( newConfiguration ) )
        {
            remove();
            create( properties );
        }
    }

    @Override
    public void remove()
    {
        requestInterceptors.removeConfiguration( configuration );
    }

    protected RequestInterceptorConfiguration createConfiguration( final Map<String, String> properties )
    {
        return new RequestInterceptorConfiguration( properties );
    }

}
