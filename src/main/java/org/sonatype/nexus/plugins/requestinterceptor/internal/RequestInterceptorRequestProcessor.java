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
