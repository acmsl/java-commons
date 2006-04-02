/*
                        ACM-SL Commons

    Copyright (C) 2002-2004  Jose San Leandro Armend�riz
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
                    Urb. Valdecaba�as
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: $RCSfile$
 *
 * Author: Jose San Leandro Armend�riz
 *
 * Description: Models stateful entities.
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
import org.acmsl.commons.automata.Transition;

/*
 * Importing some JDK classes.
 */
import java.io.Serializable;

/**
 * Models stateful entities.
 * @author <a href="mailto:jsanleandro@yahoo.es"
 *          >Jose San Leandro Armend�riz</a>
 * @version $Revision$
 */
public interface Stateful
    extends  Serializable
{
    /**
     * Retrieves the current state.
     * @return such state.
     */
    public State getCurrentState();

    /**
     * Accepts given transition.
     * @param transition the transition.
     * @return the new state  this stateful instance has just reached.
     */
    public State acceptTransition(Transition transition);
}