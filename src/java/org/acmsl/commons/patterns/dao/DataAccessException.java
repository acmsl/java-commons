/*
                        QueryJ

    Copyright (C) 2002  Jose San Leandro Armendariz
                        jsanleandro@yahoo.es
                        chousz@yahoo.com

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: jsanleandro@yahoo.es
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabanas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: $RCSfile$
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents abnormal situations regarding data accessing.
 *
 * Last modified by: $Author$ at $Date$
 *
 * File version: $Revision$
 *
 * Project version: $Name$
 *
 * $Id$
 *
 */
package org.acmsl.commons.patterns.dao;

/*
 * Importing some ACM-SL Commons classes.
 */
import org.acmsl.commons.patterns.dao.DAO;

/**
 * Represents abnormal situations regarding data accessing.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro</a>
 * @version $Revision$
 */
public class DataAccessException
    extends  Exception
{
    /**
     * Specifies the DAO which throws the error.
     */
    private DAO m__DAO;

    /**
     * Builds a DataAccessException with a certain message.
     * @param message the message.
     * @param dao the DAO entity.
     * @precondition dao != null
     */
    public DataAccessException(final String message, final DAO dao)
    {
        super(message);
        immutableSetDAO(dao);
    }

    /**
     * Builds a DataAccessException to wrap given one.
     * @param message the message.
     * @param cause the exception to wrap.
     */
    public DataAccessException(
        final String message, final Throwable cause, final DAO dao)
    {
        super(message, cause);
        immutableSetDAO(dao);
    }

    /**
     * Specifies the DAO entity which throws the error.
     * @param dao the DAO instance.
     */
    private void immutableSetDAO(final DAO dao)
    {
        m__DAO = dao;
    }

    /**
     * Specifies the DAO entity which throws the error.
     * @param dao the DAO instance.
     */
    protected void setDAO(final DAO dao)
    {
        immutableSetDAO(dao);
    }

    /**
     * Retrieves the DAO entity with threw this error.
     * @return such instance.
     */
    public DAO getDAO()
    {
        return m__DAO;
    }

    /**
     * Outputs a text representation of this exception.
     * @return the error description.
     */
    public String toString()
    {
        StringBuffer t_sbResult = new StringBuffer();

        t_sbResult.append(getMessage());

        Throwable t_Cause = getCause();

        if  (t_Cause != null) 
        {
            t_sbResult.append(" (");
            t_sbResult.append(t_Cause.getMessage());
            t_sbResult.append(")");
        }

        t_sbResult.append(" [DAO:");
        t_sbResult.append("" + getDAO());
        t_sbResult.append("]");

        return t_sbResult.toString();
    }
}