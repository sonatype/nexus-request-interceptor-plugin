package org.sonatype.nexus.plugins.requestinterceptor;

import java.util.Map;

import org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorActionFormField;
import org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorCapabilityDescriptor;
import org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorGeneratorFormField;
import org.sonatype.nexus.plugins.requestinterceptor.capabilities.RequestInterceptorMappingFormField;
import org.sonatype.nexus.proxy.access.Action;

public class RequestInterceptorConfiguration
{

    private final String repositoryId;

    private final Action action;

    private final String mapping;

    private final String generator;

    public RequestInterceptorConfiguration( final Map<String, String> properties )
    {
        repositoryId = repository( properties );
        action = action( properties );
        mapping = mapping( properties );
        generator = generator( properties );
    }

    public String repositoryId()
    {
        return repositoryId;
    }

    public Action action()
    {
        return action;
    }

    public String mapping()
    {
        return mapping;
    }

    public String generator()
    {
        return generator;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( action == null ) ? 0 : action.hashCode() );
        result = prime * result + ( ( generator == null ) ? 0 : generator.hashCode() );
        result = prime * result + ( ( mapping == null ) ? 0 : mapping.hashCode() );
        result = prime * result + ( ( repositoryId == null ) ? 0 : repositoryId.hashCode() );
        return result;
    }

    @Override
    public boolean equals( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final RequestInterceptorConfiguration other = (RequestInterceptorConfiguration) obj;
        if ( action != other.action )
        {
            return false;
        }
        if ( generator == null )
        {
            if ( other.generator != null )
            {
                return false;
            }
        }
        else if ( !generator.equals( other.generator ) )
        {
            return false;
        }
        if ( mapping == null )
        {
            if ( other.mapping != null )
            {
                return false;
            }
        }
        else if ( !mapping.equals( other.mapping ) )
        {
            return false;
        }
        if ( repositoryId == null )
        {
            if ( other.repositoryId != null )
            {
                return false;
            }
        }
        else if ( !repositoryId.equals( other.repositoryId ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append( "RequestInterceptorConfiguration [" );
        if ( repositoryId != null )
        {
            builder.append( "repositoryId=" );
            builder.append( repositoryId );
            builder.append( ", " );
        }
        if ( action != null )
        {
            builder.append( "action=" );
            builder.append( action );
            builder.append( ", " );
        }
        if ( mapping != null )
        {
            builder.append( "mapping=" );
            builder.append( mapping );
            builder.append( ", " );
        }
        if ( generator != null )
        {
            builder.append( "generator=" );
            builder.append( generator );
        }
        builder.append( "]" );
        return builder.toString();
    }

    private static String repository( final Map<String, String> properties )
    {
        String repositoryId = properties.get( RequestInterceptorCapabilityDescriptor.REPO_OR_GROUP_ID );
        repositoryId = repositoryId.replaceFirst( "repo_", "" );
        repositoryId = repositoryId.replaceFirst( "group_", "" );
        return repositoryId;
    }

    private static Action action( final Map<String, String> properties )
    {
        final String value = properties.get( RequestInterceptorActionFormField.ID );
        return Action.valueOf( value );
    }

    private static String mapping( final Map<String, String> properties )
    {
        final String value = properties.get( RequestInterceptorMappingFormField.ID );
        return value;
    }

    private static String generator( final Map<String, String> properties )
    {
        final String value = properties.get( RequestInterceptorGeneratorFormField.ID );
        return value;
    }

}
