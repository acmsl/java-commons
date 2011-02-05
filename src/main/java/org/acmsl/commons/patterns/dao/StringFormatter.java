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
 * Filename: StringFormatter.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Is able to format ValueObjectField.String objects.
 */
package org.acmsl.commons.patterns.dao;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.patterns.dao.ValueObjectField;
import org.acmsl.commons.patterns.dao.ValueObjectFieldFormatter;

/**
 * Is able to format {@link ValueObjectField.String} objects.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
public class StringFormatter
    implements  ValueObjectFieldFormatter
{
    /**
     * Singleton instance.
     */
    private static StringFormatter m__Singleton;

    /**
     * Retrieves a StringFormatter instance.
     * @return a string formatter.
     */
    public static StringFormatter getInstance()
    {
        StringFormatter result = m__Singleton;

        if  (m__Singleton == null)
        {
            m__Singleton = new StringFormatter();

            result = m__Singleton;
        }

        return result;
    }

    /**
     * Formats the field in a correct way.
     * @param valueObjectField the field to format.
     * @return the String format.
     */
    public String format(ValueObjectField valueObjectField)
    {
        String result = "";

        if  (valueObjectField instanceof ValueObjectField.String)
        {
            result = format((ValueObjectField.String) valueObjectField);
        }

        return result;
    }

    /**
     * Formats the string field in a correct way.
     * @param stringField the field to format.
     * @return the String format.
     */
    public String format(ValueObjectField.String stringField)
    {
        return "\"" + stringField.getValue() + "\"";
    }
}
