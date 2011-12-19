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

import static org.sonatype.nexus.plugins.capabilities.api.CapabilityType.capabilityType;
import static org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorCapability.TYPE_ID;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.RepoOrGroupComboFormField;
import org.sonatype.nexus.plugins.capabilities.api.CapabilityType;
import org.sonatype.nexus.plugins.capabilities.api.descriptor.AbstractCapabilityDescriptor;
import org.sonatype.nexus.plugins.capabilities.api.descriptor.CapabilityDescriptor;

@Singleton
@Named( TYPE_ID )
public class RequestInterceptorCapabilityDescriptor
    extends AbstractCapabilityDescriptor
    implements CapabilityDescriptor
{

    private static final CapabilityType TYPE = capabilityType( TYPE_ID );

    public static final String REPO_OR_GROUP_ID = "repoOrGroup";

    public RequestInterceptorCapabilityDescriptor()
    {
        super(
            TYPE,
            "Request Interceptor capability",
            "Intercepts a request to specified repository content and forwards it to selected generator",
            new RepoOrGroupComboFormField( REPO_OR_GROUP_ID, FormField.MANDATORY ),
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
