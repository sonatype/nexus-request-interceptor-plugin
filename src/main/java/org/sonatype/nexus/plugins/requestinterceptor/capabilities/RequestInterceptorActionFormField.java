package org.sonatype.nexus.plugins.requestinterceptor.capabilities;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.StringTextFormField;

// TODO this should be an fix values combo box
public class RequestInterceptorActionFormField
    extends StringTextFormField
{

    public static final String ID = "action";

    public RequestInterceptorActionFormField()
    {
        super( ID, "Action", "Specify type of request action on which interceptor should be executed.",
            FormField.OPTIONAL );
    }

}
