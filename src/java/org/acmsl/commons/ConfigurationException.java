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
 * Description: Represents misconfiguration errors.
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
package org.acmsl.commons;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.NonCheckedException;

/*
 * Importing some JDK classes.
 */
import java.lang.Throwable;

/**
 * Represents misconfiguration errors.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armend�riz</a>
 * @version $Revision$ $Date$
 */
public class ConfigurationException
    extends  NonCheckedException
{
    /**
     * Creates a ConfigurationException with given message.
     * @param messageKey the key to build the exception message.
     * @param params the parameters to build the exception message.
     * @precondition messageKey != null
     * @precondition params != null
     */
    public ConfigurationException(
        final String messageKey, final Object[] params)
    {
        super(messageKey, params);
    }

    /**
     * Creates a ConfigurationException with given cause.
     * @param messageKey the key to build the exception message.
     * @param params the parameters to build the exception message.
     * @param cause the error cause.
     * @precondition messageKey != null
     * @precondition params != null
     * @precondition cause != null
     */
    public ConfigurationException(
        final String messageKey,
        final Object[] params,
        final Throwable cause)
    {
        super(messageKey, params, cause);
    }
}
