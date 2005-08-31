/*
                        ACM-SL Commons

    Copyright (C) 2002-2003  Jose San Leandro Armendáriz
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
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-307  USA


    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: jsr000@terra.es
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabañas
                    Boadilla del monte

 ******************************************************************************
 *
 * Filename: $RCSfile$
 *
 * Author: Jose San Leandro Armendáriz
 *
 * Description: Responsible of converting values from one type to another.
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
package org.acmsl.commons.utils;

/*
 * Importing some ACM-SL classes
 */
import org.acmsl.commons.patterns.Utils;

/*
 * Importing Commons-BeanUtils classes.
 */
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.ConvertUtils;

/*
 * Importing some JDK classes.
 */
import java.lang.ref.WeakReference;
import java.util.Date;
import java.math.BigDecimal;

/**
 * Responsible of converting values from one type to another.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armendáriz</a>
 * @stereotype validator
 * @version $Revision$
 */
public class ConversionUtils
    implements  Utils
{
    /**
     * Singleton implemented as a weak reference.
     */
    private static WeakReference singleton;

    /**
     * Protected constructor to avoid accidental instantiation.
     */
    protected ConversionUtils() {};

    /**
     * Specifies a new weak reference.
     * @param utils the utils instance to use.
     */
    protected static void setReference(final ConversionUtils utils)
    {
        singleton = new WeakReference(utils);
    }

    /**
     * Retrieves the weak reference.
     * @return such reference.
     */
    protected static WeakReference getReference()
    {
        return singleton;
    }

    /**
     * Retrieves a ConversionUtils instance.
     * @return such instance.
     */
    public static ConversionUtils getInstance()
    {
        ConversionUtils result = null;

        WeakReference reference = getReference();

        if  (reference != null) 
        {
            result = (ConversionUtils) reference.get();
        }

        if  (result == null) 
        {
            result = new ConversionUtils();

            setReference(result);
        }

        return result;
    }

    /**
     * Retrieves the given value (useful for code generators, to avoid
     * type-aware logic, and instead using toXXX(value), where XXX is the type).
     * @param value the value.
     * @return given value.
     * @precondition value != null
     */
    public String toString(final String value)
    {
        return toStringIfNotNull(value);
    }

    /**
     * Retrieves the given value (useful for code generators, to avoid
     * type-aware logic, and instead using toXXX(value), where XXX is the type).
     * @param value the value.
     * @return given value.
     */
    public String toStringIfNotNull(final String value)
    {
        return value;
    }

    /**
     * Converts given String to boolean.
     * @param value the value to convert.
     * @return the converted value.
     */
    public boolean toBoolean(final String value)
    {
        boolean result = false;

        Boolean t_Result = toBooleanIfNotNull(value);

        if  (t_Result != null) 
        {
            result = t_Result.booleanValue();
        }

        return result;
    }

    /**
     * Converts given String to boolean, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public Boolean toBooleanIfNotNull(final String value)
    {
        Boolean result = null;

        Converter t_Converter = ConvertUtils.lookup(Boolean.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Boolean.TYPE, value);

            if  (t_Result instanceof Boolean)
            {
                result = (Boolean) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to int.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public int toInt(final String value)
    {
        int result = 0;

        Integer t_Result = toIntIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.intValue();
        }

        return result;
    }

    /**
     * Converts given String to int if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Integer toIntIfNotNull(final String value)
    {
        Integer result = null;

        Converter t_Converter = ConvertUtils.lookup(Integer.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Integer.TYPE, value);

            if  (t_Result instanceof Integer)
            {
                result = (Integer) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to long.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public long toLong(final String value)
    {
        long result = 0L;

        Long t_Result = toLongIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.longValue();
        }

        return result;
    }

    /**
     * Converts given String to long if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Long toLongIfNotNull(final String value)
    {
        Long result = null;

        Converter t_Converter = ConvertUtils.lookup(Long.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Long.TYPE, value);

            if  (t_Result instanceof Long)
            {
                result = (Long) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to float.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public float toFloat(final String value)
    {
        float result = 0.0f;

        Float t_Result = toFloatIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.floatValue();
        }

        return result;
    }

    /**
     * Converts given String to float, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Float toFloatIfNotNull(final String value)
    {
        Float result = null;

        Converter t_Converter = ConvertUtils.lookup(Float.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Float.TYPE, value);

            if  (t_Result instanceof Float)
            {
                result = (Float) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to double.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public double toDouble(final String value)
    {
        double result = 0.0d;

        Double t_Result = toDoubleIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.doubleValue();
        }

        return result;
    }

    /**
     * Converts given String to double, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Double toDoubleIfNotNull(final String value)
    {
        Double result = null;

        Converter t_Converter = ConvertUtils.lookup(Double.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Double.TYPE, value);

            if  (t_Result instanceof Double)
            {
                result = (Double) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to char.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public char toChar(final String value)
    {
        char result = (char) -1;

        Character t_Result = toCharIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.charValue();
        }

        if  (!value.equals(Character.toString(result)))
        {
            result = (char) -1;
        }

        return result;
    }

    /**
     * Converts given String to char, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Character toCharIfNotNull(final String value)
    {
        Character result = null;

        Converter t_Converter = ConvertUtils.lookup(Character.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Character.TYPE, value);

            if  (t_Result instanceof Character)
            {
                result = (Character) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to short.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public short toShort(final String value)
    {
        short result = 0;

        Short t_Result = toShortIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.shortValue();
        }

        return result;
    }

    /**
     * Converts given String to short, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Short toShortIfNotNull(final String value)
    {
        Short result = null;

        Converter t_Converter = ConvertUtils.lookup(Short.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Short.TYPE, value);

            if  (t_Result instanceof Short)
            {
                result = (Short) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to byte.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public byte toByte(final String value)
    {
        byte result = 0;

        Byte t_Result = toByteIfNotNull(value);

        if  (t_Result != null)
        {
            result = t_Result.byteValue();
        }

        return result;
    }

    /**
     * Converts given String to byte, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Byte toByteIfNotNull(final String value)
    {
        Byte result = null;

        Converter t_Converter = ConvertUtils.lookup(Byte.TYPE);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Byte.TYPE, value);

            if  (t_Result instanceof Byte)
            {
                result = (Byte) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to bigDecimal.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public BigDecimal toBigDecimal(final String value)
    {
        return toBigDecimalIfNotNull(value);
    }

    /**
     * Converts given String to BigDecimal, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public BigDecimal toBigDecimalIfNotNull(final String value)
    {
        BigDecimal result = null;

        Converter t_Converter = ConvertUtils.lookup(BigDecimal.class);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(BigDecimal.class, value);

            if  (t_Result instanceof BigDecimal)
            {
                result = (BigDecimal) t_Result;
            }
        }

        return result;
    }

    /**
     * Converts given String to date.
     * @param value the value to convert.
     * @return the converted value.
     * @precondition value != null
     */
    public Date toDate(final String value)
    {
        return toDateIfNotNull(value);
    }

    /**
     * Converts given String to date, if given value is not null.
     * @param value the value to convert.
     * @return the converted value.
     */
    public Date toDateIfNotNull(final String value)
    {
        Date result = null;

        Converter t_Converter = ConvertUtils.lookup(Date.class);

        if  (t_Converter != null)
        {
            Object t_Result = t_Converter.convert(Date.class, value);

            if  (t_Result instanceof Date)
            {
                result = (Date) t_Result;
            }
        }

        return result;
    }
}
