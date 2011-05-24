package org.sonatype.nexus.plugins.requestinterceptor;

import org.sonatype.nexus.proxy.access.Action;
import org.sonatype.nexus.proxy.repository.Repository;

public interface RequestInterceptor
{

    void execute( Repository repository, String path, Action action );

}
