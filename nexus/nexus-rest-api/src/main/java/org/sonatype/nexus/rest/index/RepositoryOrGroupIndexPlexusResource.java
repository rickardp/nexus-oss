package org.sonatype.nexus.rest.index;

import org.codehaus.plexus.component.annotations.Component;
import org.sonatype.plexus.rest.resource.PlexusResource;

@Component( role = PlexusResource.class, hint = "RepositoryOrGroupIndexPlexusResource" )
public class RepositoryOrGroupIndexPlexusResource
    extends AbstractIndexPlexusResource
{

    @Override
    public String getResourceUri()
    {
        return "/data_index/{" + IndexResourceHandler.DOMAIN + "}/{" + IndexResourceHandler.TARGET_ID + "}";
    }

}
