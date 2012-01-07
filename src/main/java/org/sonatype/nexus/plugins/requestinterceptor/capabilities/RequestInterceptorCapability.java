/**
 * Copyright (c) 2008-2011 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://www.sonatype.com/products/nexus/attributions.
 *
 * This program is free software: you can redistribute it and/or modify it only under the terms of the GNU Affero General
 * Public License Version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License Version 3
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License Version 3 along with this program.  If not, see
 * http://www.gnu.org/licenses.
 *
 * Sonatype Nexus (TM) Open Source Version is available from Sonatype, Inc. Sonatype and Sonatype Nexus are trademarks of
 * Sonatype, Inc. Apache Maven is a trademark of the Apache Foundation. M2Eclipse is a trademark of the Eclipse Foundation.
 * All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import java.util.Map;

import org.sonatype.nexus.plugins.capabilities.CapabilityContext;
import org.sonatype.nexus.plugins.capabilities.support.CapabilitySupport;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptorConfiguration;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptors;

public class RequestInterceptorCapability
    extends CapabilitySupport
{

    public static final String TYPE_ID = "request-interceptor";

    private final RequestInterceptors requestInterceptors;

    private RequestInterceptorConfiguration configuration;

    public RequestInterceptorCapability( final CapabilityContext context,
                                         final RequestInterceptors requestInterceptors )
    {
        super( context );
        this.requestInterceptors = requestInterceptors;
    }

    @Override
    public void create( final Map<String, String> properties )
    {
        configuration = createConfiguration( properties );
    }

    @Override
    public void load( final Map<String, String> properties )
    {
        create( properties );
    }

    @Override
    public void update( final Map<String, String> properties )
    {
        final RequestInterceptorConfiguration newConfiguration = createConfiguration( properties );
        if ( !configuration.equals( newConfiguration ) )
        {
            passivate();
            create( properties );
            activate();
        }
    }

    @Override
    public void activate()
    {
        requestInterceptors.addConfiguration( configuration );
    }

    @Override
    public void passivate()
    {
        requestInterceptors.removeConfiguration( configuration );
    }

    protected RequestInterceptorConfiguration createConfiguration( final Map<String, String> properties )
    {
        return new RequestInterceptorConfiguration( properties );
    }

}
