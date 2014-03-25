/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.pull.shared.connectors.bugzilla;

import java.util.Properties;
import org.jboss.pull.shared.Util;

public class BZHelper {

    private static final String BUGZILLA_BASE = "https://bugzilla.redhat.com/";

    private final String BUGZILLA_LOGIN;
    private final String BUGZILLA_PASSWORD;

    private final Bugzilla bugzillaClient;

    public BZHelper() {
        BUGZILLA_LOGIN = null;
        BUGZILLA_PASSWORD = null;

        bugzillaClient = null;
    }

    public BZHelper(final String configurationFileProperty, final String configurationFileDefault) throws Exception {
        try {
            Properties props = Util.loadProperties(configurationFileProperty, configurationFileDefault);

            BUGZILLA_LOGIN = Util.require(props, "bugzilla.login");
            BUGZILLA_PASSWORD = Util.require(props, "bugzilla.password");

            // initialize bugzilla client
            bugzillaClient = new Bugzilla(BUGZILLA_BASE, BUGZILLA_LOGIN, BUGZILLA_PASSWORD);
        } catch (Exception e) {
            System.err.printf("Cannot initialize: %s\n", e);
            e.printStackTrace(System.err);
            throw e;
        }
    }

    // -------- Bugzilla related methods
    public Bug getBug(Integer bugzillaId) {
        return bugzillaClient.getBug(bugzillaId);
    }

    public boolean updateBugzillaStatus(Integer bugzillaId, Bug.Status status) {
        return bugzillaClient.updateBugzillaStatus(bugzillaId, status);
    }

}