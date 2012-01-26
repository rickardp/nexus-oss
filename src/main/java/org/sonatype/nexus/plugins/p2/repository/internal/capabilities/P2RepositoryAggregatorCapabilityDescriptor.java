/**
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2007-2012 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.plugins.p2.repository.internal.capabilities;

import static org.sonatype.nexus.plugins.capabilities.CapabilityType.capabilityType;
import static org.sonatype.nexus.plugins.p2.repository.internal.capabilities.P2RepositoryAggregatorCapabilityDescriptor.TYPE_ID;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.RepoOrGroupComboFormField;
import org.sonatype.nexus.plugins.capabilities.CapabilityDescriptor;
import org.sonatype.nexus.plugins.capabilities.CapabilityType;
import org.sonatype.nexus.plugins.capabilities.support.CapabilityDescriptorSupport;
import org.sonatype.nexus.plugins.p2.repository.P2RepositoryAggregatorConfiguration;

@Singleton
@Named( TYPE_ID )
public class P2RepositoryAggregatorCapabilityDescriptor
    extends CapabilityDescriptorSupport
    implements CapabilityDescriptor
{

    public static final String TYPE_ID = "p2.repository.aggregator";

    private static final CapabilityType TYPE = capabilityType( TYPE_ID );

    public P2RepositoryAggregatorCapabilityDescriptor()
    {
        super(
            TYPE,
            "P2 Repository Aggregator capability",
            "Aggregates P2 metadata/artifacts of all OSGi bundles from selected repository",
            new RepoOrGroupComboFormField( P2RepositoryAggregatorConfiguration.REPOSITORY, FormField.MANDATORY )
        );
    }

}
