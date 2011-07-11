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

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.RepoOrGroupComboFormField;
import org.sonatype.nexus.plugins.capabilities.api.descriptor.CapabilityDescriptor;

@Singleton
@Named( RequestInterceptorCapability.ID )
public class RequestInterceptorCapabilityDescriptor
    implements CapabilityDescriptor
{

    public static final String ID = RequestInterceptorCapability.ID;

    public static final String REPO_OR_GROUP_ID = "repoOrGroup";

    private final FormField repoOrGroup;

    private final FormField mapping;

    private final FormField generator;

    public RequestInterceptorCapabilityDescriptor()
    {
        repoOrGroup = new RepoOrGroupComboFormField( REPO_OR_GROUP_ID, FormField.MANDATORY );
        mapping = new RequestInterceptorMappingFormField();
        generator = new RequestInterceptorGeneratorFormField();
    }

    @Override
    public String id()
    {
        return ID;
    }

    @Override
    public String name()
    {
        return "Request Interceptor capability";
    }

    @Override
    public List<FormField> formFields()
    {
        return Arrays.asList( repoOrGroup, mapping, generator );
    }

    @Override
    public boolean isExposed()
    {
        return false;
    }

}
