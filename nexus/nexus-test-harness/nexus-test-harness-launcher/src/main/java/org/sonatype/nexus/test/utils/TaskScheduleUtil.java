/**
 * Copyright (c) 2008-2011 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions
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
package org.sonatype.nexus.test.utils;

import java.io.IOException;
import java.util.List;

import org.hamcrest.Matcher;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.sonatype.nexus.integrationtests.RequestFacade;
import org.sonatype.nexus.rest.model.ScheduledServiceBaseResource;
import org.sonatype.nexus.rest.model.ScheduledServiceListResource;
import org.sonatype.nexus.rest.model.ScheduledServicePropertyResource;
import org.sonatype.nexus.scheduling.NexusTask;

/**
 * Util class to talk with nexus tasks
 */
public class TaskScheduleUtil
{

    private static final NexusTasksRestClient nexusTasksRestClient;

    static
    {
        nexusTasksRestClient = new NexusTasksRestClient( RequestFacade.getNexusRestClient() );
    }

    public static Status create( ScheduledServiceBaseResource task, Matcher<Response>... matchers )
        throws IOException
    {
        return nexusTasksRestClient.create( task, matchers );
    }

    public static ScheduledServiceListResource getTask( String name )
        throws Exception
    {
        return nexusTasksRestClient.getTask( name );
    }

    /**
     * @return only tasks visible from nexus UI
     */
    public static List<ScheduledServiceListResource> getTasks()
        throws IOException
    {
        return nexusTasksRestClient.getTasks();
    }

    /**
     * @return all tasks, even internal ones
     */
    public static List<ScheduledServiceListResource> getAllTasks()
        throws IOException
    {
        return nexusTasksRestClient.getAllTasks();
    }

    public static String getStatus( String name )
        throws Exception
    {
        return nexusTasksRestClient.getStatus( name );
    }

    public static void deleteAllTasks()
        throws Exception
    {
        nexusTasksRestClient.deleteAllTasks();
    }

    /**
     * Holds execution until all tasks stop running
     */
    public static void waitForAllTasksToStop()
        throws Exception
    {
        nexusTasksRestClient.waitForAllTasksToStop();
    }

    /**
     * Holds execution until all tasks of a given type stop running
     *
     * @param taskType task type
     */
    public static void waitForAllTasksToStop( String taskType )
        throws Exception
    {
        nexusTasksRestClient.waitForAllTasksToStop( taskType );
    }

    /**
     * Holds execution until all tasks of a given type stop running
     *
     * @param maxAttempts how many times check for tasks being stopped
     */
    public static void waitForAllTasksToStop( int maxAttempts )
        throws Exception
    {
        nexusTasksRestClient.waitForAllTasksToStop( maxAttempts );
    }

    /**
     * Holds execution until all tasks of a given type stop running
     *
     * @param taskClass task type
     */
    public static void waitForAllTasksToStop( Class<? extends NexusTask<?>> taskClass )
        throws Exception
    {
        nexusTasksRestClient.waitForAllTasksToStop( taskClass );
    }

    /**
     * Holds execution until all tasks of a given type stop running
     *
     * @param taskType    task type
     * @param maxAttempts how many times check for tasks being stopped
     */
    public static void waitForAllTasksToStop( int maxAttempts, String taskType )
        throws Exception
    {
        nexusTasksRestClient.waitForAllTasksToStop( maxAttempts, taskType );
    }

    /**
     * Blocks while waiting for a task to finish.
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static void waitForTask( String name, int maxAttempts )
        throws Exception
    {
        nexusTasksRestClient.waitForTask( name, maxAttempts );
    }

    public static Status update( ScheduledServiceBaseResource task, Matcher<Response>... matchers )
        throws IOException
    {
        return nexusTasksRestClient.update( task, matchers );
    }

    public static Status deleteTask( String id )
        throws IOException
    {
        return nexusTasksRestClient.deleteTask( id );
    }

    public static Status run( String taskId )
        throws IOException
    {
        return nexusTasksRestClient.run( taskId );
    }

    public static Status cancel( String taskId )
        throws IOException
    {
        return nexusTasksRestClient.cancel( taskId );
    }

    public static void runTask( String typeId, ScheduledServicePropertyResource... properties )
        throws Exception
    {
        nexusTasksRestClient.runTask( typeId, properties );
    }

    public static void runTask( String taskName, String typeId, ScheduledServicePropertyResource... properties )
        throws Exception
    {
        nexusTasksRestClient.runTask( taskName, typeId, properties );
    }

    public static void runTask( String taskName, String typeId, int maxAttempts,
                                ScheduledServicePropertyResource... properties )
        throws Exception
    {
        nexusTasksRestClient.runTask( taskName, typeId, maxAttempts, properties );
    }

    public static ScheduledServicePropertyResource newProperty( String name, String value )
    {
        return NexusTasksRestClient.newProperty( name, value );
    }
}
