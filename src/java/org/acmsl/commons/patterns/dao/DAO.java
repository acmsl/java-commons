/*
                        ACM-SL Commons

    Copyright (C) 2002-2003  Jose San Leandro Armend�riz
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
 * Description:	Data Access Object able to access and retrieve ValueObject
 *              elements.
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
package org.acmsl.commons.patterns.dao;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.patterns.dao.ValueObjectPrimaryKey;
import org.acmsl.commons.version.Version;
import org.acmsl.commons.version.Versionable;
import org.acmsl.commons.version.VersionFactory;

/**
 * Data Access Object able to access and retrieve ValueObject elements.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armend�riz</a>
 * @version $Revision$
 */
public interface DAO
    extends  Versionable
{
    /**
     * Loads a value object from the persistence layer with given id.
     * @param pk the identifier used to select the concrete value object to
     * load.
     * @return the information associated to such id in the underlying
     * persistente layer.
     */
    public ValueObject load(ValueObjectPrimaryKey pk);

    /**
     * Stores the value object into the persistent layer.
     * @param valueObject the information to be persisted.
     * @param reload whether or not the reload is needed.
     * @return true if the operation ends up successfully.
     */
    public ValueObject store(ValueObject valueObject, boolean reload);

    /**
     * Removes a value object in the persistence layer.
     * @param valueObject the value object to be removed.
     * @return true if the operation ends up successfully.
     */
    public abstract boolean remove(ValueObject valueObject);

    /**
     * Removes a value object in the persistence layer.
     * @param valueObject the value object to be removed.
     * @param reload whether or not the reload is needed.
     * @return true if the operation ends up successfully.
     */
    public abstract ValueObject update(
       ValueObject valueObject,
       boolean reload);

    /**
     * Concrete version object updated everytime it's checked-in in a
     * CVS repository.
     */
    public static final Version VERSION =
        VersionFactory.createVersion("$Revision$");
}
