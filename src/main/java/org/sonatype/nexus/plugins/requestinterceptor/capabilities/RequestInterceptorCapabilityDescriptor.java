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

import static org.sonatype.nexus.plugins.capabilities.CapabilityType.capabilityType;
import static org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorCapabilityDescriptor.TYPE_ID;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.RepoOrGroupComboFormField;
import org.sonatype.nexus.plugins.capabilities.CapabilityDescriptor;
import org.sonatype.nexus.plugins.capabilities.CapabilityType;
import org.sonatype.nexus.plugins.capabilities.support.CapabilityDescriptorSupport;

@Singleton
@Named( TYPE_ID )
public class RequestInterceptorCapabilityDescriptor
    extends CapabilityDescriptorSupport
    implements CapabilityDescriptor
{

    public static final String TYPE_ID = "request-interceptor";

    private static final CapabilityType TYPE = capabilityType( TYPE_ID );

    public static final String REPOSITORY = "repositoryId";

    public RequestInterceptorCapabilityDescriptor()
    {
        super(
            TYPE,
            "Request Interceptor capability",
            "Intercepts a request to specified repository content and forwards it to selected generator",
            new RepoOrGroupComboFormField( REPOSITORY, FormField.MANDATORY ),
            new RequestInterceptorMappingFormField(),
            new RequestInterceptorGeneratorFormField()
        );
    }

    @Override
    public boolean isExposed()
    {
        return false;
    }

}
