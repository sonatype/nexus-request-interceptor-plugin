package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.StringTextFormField;

public class RequestInterceptorMappingFormField
    extends StringTextFormField
{

    public static final String ID = "mapping";

    public RequestInterceptorMappingFormField()
    {
        super( ID, "Mapping", "Specify an ANT-style pattern for interceptor.", FormField.MANDATORY );
    }

}
