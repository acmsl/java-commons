/*
                        ACM-SL Commons

    Copyright (C) 2002-2004  Jose San Leandro Armendáriz
                             jsanleandro@yahoo.es
                             chousz@yahoo.com

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: jsr000@terra.es
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabañas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: $RCSfile$
 *
 * Author: Jose San Leandro Armendáriz
 *
 * Description: Represents nodes in automatons or state diagrams, that is,
 *              known points in the behaviour of entities that follow a
 *              deterministic finite-state automata (DFSA).
 *
 * Last modified by: $Author$ at $Date$
 *
 * File version: $Revision$
 *
 * Project version: $Name$
 *                  ("Name" means no concrete version has been checked out)
 *
 * $Id$
 *
 */
package org.acmsl.commons.automata;

/*
 * Importing some project classes.
 */
import org.acmsl.commons.automata.State;

/*
 * Importing some JDK classes.
 */
import java.io.Serializable;

/**
 * Represents nodes in automatons or state diagrams, that is, known
 * points in the behaviour of entities that follow a deterministic finite-state
 * automata (DFSA).
 * @author <a href="mailto:jsanleandro@yahoo.es"
 *          >Jose San Leandro Armendáriz</a>
 * @version $Revision$
 */
public interface Transition
    extends  Serializable
{
    /**
     * Retrieves the origin of the directed link represented by this
     * transition.
     * @return the origin state.
     */
    public State getOrigin();

    /**
     * Retrieves the destination of the directed link represented by
     * this transition.
     * @return the destination state.
     */
    public State getDestination();
}
