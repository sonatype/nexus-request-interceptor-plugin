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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.sonatype.nexus.plugins.capabilities.CapabilityContext;
import org.sonatype.nexus.plugins.capabilities.Condition;
import org.sonatype.nexus.plugins.capabilities.support.CapabilitySupport;
import org.sonatype.nexus.plugins.capabilities.support.condition.Conditions;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptorConfiguration;
import org.sonatype.nexus.plugins.requestinterceptor.RequestInterceptors;

public class RequestInterceptorCapability
    extends CapabilitySupport
{

    public static final String TYPE_ID = "request-interceptor";

    private final RequestInterceptors requestInterceptors;

    private final Conditions conditions;

    private RequestInterceptorConfiguration configuration;

    public RequestInterceptorCapability( final CapabilityContext context,
                                         final RequestInterceptors requestInterceptors,
                                         final Conditions conditions )
    {
        super( context );
        this.requestInterceptors = checkNotNull( requestInterceptors );
        this.conditions = checkNotNull( conditions );
    }

    @Override
    public void onActivate()
    {
        configuration = createConfiguration( context().properties() );
        requestInterceptors.addConfiguration( configuration );
    }

    @Override
    public void onPassivate()
    {
        requestInterceptors.removeConfiguration( configuration );
    }

    @Override
    public Condition activationCondition()
    {
        return conditions.capabilities().passivateCapabilityDuringUpdate( context().id() );
    }

    protected RequestInterceptorConfiguration createConfiguration( final Map<String, String> properties )
    {
        return new RequestInterceptorConfiguration( properties );
    }

}
