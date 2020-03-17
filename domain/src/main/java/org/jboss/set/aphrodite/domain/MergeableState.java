/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
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
package org.jboss.set.aphrodite.domain;

public enum MergeableState {

    // The head ref is out of date.
    BEHIND("behind"),
    // The merge is blocked.
    BLOCKED("blocked"),
    // Mergeable and passing commit status.
    CLEAN("clean"),
    // The merge commit cannot be cleanly created.
    DIRTY("dirty"),
    // The merge is blocked due to the pull request being a draft.
    DRAFT("draft"),
    // Mergeable with passing commit status and pre-receive hooks.
    HAS_HOOKS("has_hooks"),
    // The state cannot currently be determined.
    UNKNOWN("unknown"),
    // Mergeable with non-passing commit status.
    UNSTABLE("unstable");

    private final String mergeableState;

    private MergeableState(final String miniME) {
        this.mergeableState = miniME;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.mergeableState;
    }
}
