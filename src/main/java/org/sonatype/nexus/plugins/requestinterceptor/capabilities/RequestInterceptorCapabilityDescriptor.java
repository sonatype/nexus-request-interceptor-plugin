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
