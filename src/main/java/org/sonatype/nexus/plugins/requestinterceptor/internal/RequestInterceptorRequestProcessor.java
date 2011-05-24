package org.sonatype.nexus.plugins.requestinterceptor.internal;

import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptors;
import org.sonatype.nexus.proxy.ResourceStoreRequest;
import org.sonatype.nexus.proxy.access.Action;
import org.sonatype.nexus.proxy.repository.AbstractRequestProcessor;
import org.sonatype.nexus.proxy.repository.Repository;
import org.sonatype.nexus.proxy.repository.RequestProcessor;

public class RequestInterceptorRequestProcessor
    extends AbstractRequestProcessor
    implements RequestProcessor
{

    private final RequestInterceptors requestInterceptors;

    public RequestInterceptorRequestProcessor( final RequestInterceptors requestInterceptors )
    {
        this.requestInterceptors = requestInterceptors;
    }

    @Override
    public boolean process( final Repository repository, final ResourceStoreRequest request, final Action action )
    {
        if ( !action.isReadAction() )
        {
            return true;
        }

        requestInterceptors.handle( repository.getId(), request.getRequestPath(), action );

        return true;
    }

}
