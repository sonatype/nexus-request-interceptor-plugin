package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.StringTextFormField;

public class RequestInterceptorGeneratorFormField
    extends StringTextFormField
{

    public static final String ID = "generator";

    public RequestInterceptorGeneratorFormField()
    {
        super( ID, "Generator", "Specify id of request interceptor to be executed.", FormField.MANDATORY );
    }

}
