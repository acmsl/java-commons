//;-*- mode: java -*-
/*
                        ACM-SL Commons

    Copyright (C) 2002-today  Jose San Leandro Armendariz
                              chous@acm-sl.org

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

    Thanks to ACM S.L. for distributing this library under the LGPL license.
    Contact info: jose.sanleandro@acm-sl.com

 ******************************************************************************
 *
 * Filename: ValueObjectPrimaryKey.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents primary keys that uniquely identifies each
 *              value object.
 *
 */
package org.acmsl.commons.patterns.dao;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.patterns.dao.ValueObjectField;
import org.acmsl.commons.patterns.dao.ValueObjectFieldIterator;

/**
 * Importing some JDK classes.
 */
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents primary keys that uniquely identifies each {@link ValueObject}.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
public class ValueObjectPrimaryKey
{
    /**
     * Field collection.
     */
    private ArrayList m__alFields = new ArrayList();

    /**
     * Adds a field to this primary key.
     * @param field the field to add.
     */
    protected void add(final ValueObjectField field)
    {
        m__alFields.add(field);
    }

    /**
     * Retrieves a list of all the fields included in the PK.
     * @return the iterator to browse the list.
     */
    public ValueObjectFieldIterator iterator()
    {
        return new _FieldIterator(m__alFields.iterator());
    }

    /**
     * Generic ValueObjectFieldIterator implementation.
     * @author <a href="mailto:jsanleandro@yahoo.es"
               >Jose San Leandro Armendáriz</a>
     * @version $Revision: 419 $
     */
    private static class _FieldIterator
        implements  ValueObjectFieldIterator
    {
        Iterator m__Iterator;

        /**
         * Constructs an iterator using given generic iterator.
         * @param iterator the actual iterator.
         */
        public _FieldIterator(Iterator iterator)
        {
            m__Iterator = iterator;
        }

        /**
         * Checks whether there's more fields to browse or not.
         * @return true if there are more fields to browse.
         */
        public boolean hasNext()
        {
            return m__Iterator.hasNext();
        }

        /**
         * Retrieves the next field to browse.
         * @return the next field.
         */
        public ValueObjectField next()
        {
            return (ValueObjectField) m__Iterator.next();
        }
    }
}
