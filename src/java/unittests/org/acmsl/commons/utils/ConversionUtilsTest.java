/*
                      Project tests

Copyright (C) 2003  Jose San Leandro Armend?riz
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
Urb. Valdecaba?as
Boadilla del monte
28660 Madrid
Spain

******************************************************************************
*
* Filename: $RCSfile$
*
* Author: Jose San Leandro Armend?riz
*
* Description: Executes all tests defined for package
*              unittests.org.acmsl.commons.utils.
*
* Last modified by: $Author$ at $Date$
*
* File version: $Revision$
*
* Project version: $Name$
*
* $Id$
*/
package unittests.org.acmsl.commons.utils;

/*
* Importing project classes.
*/
// JUnitDoclet begin import
import org.acmsl.commons.utils.ConversionUtils;
// JUnitDoclet end import

/*
* Importing JUnit classes.
*/
import junit.framework.TestCase;

/*
This file is part of  JUnitDoclet, a project to generate basic
test cases  from source code and  helping to keep them in sync
during refactoring.

Copyright (C) 2002  ObjectFab GmbH  (http://www.objectfab.de/)

This library is  free software; you can redistribute it and/or
modify  it under the  terms of  the  GNU Lesser General Public
License as published  by the  Free Software Foundation; either
version 2.1  of the  License, or  (at your option)  any  later
version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or  FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You  should  have  received a  copy of the  GNU Lesser General
Public License along with this  library; if not, write  to the
Free  Software  Foundation, Inc.,  59 Temple Place,  Suite 330,
Boston, MA  02111-1307  USA
*/


/**
* Tests ConversionUtilsTest class.
* @version $Revision$
* @see org.acmsl.commons.utils.ConversionUtils
*/
public class ConversionUtilsTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  org.acmsl.commons.utils.ConversionUtils conversionutils = null;
  // JUnitDoclet end class
  
  /**
  * Creates a ConversionUtilsTest with given name.
  * @param name such name.
  */
  public ConversionUtilsTest(String name)
  {
    // JUnitDoclet begin method ConversionUtilsTest
    super(name);
    // JUnitDoclet end method ConversionUtilsTest
  }
  
  /**
  * Creates an instance of the tested class.
  * @return such instance.
  
  */
  public org.acmsl.commons.utils.ConversionUtils createInstance()
  throws Exception
  {
    // JUnitDoclet begin method testcase.createInstance
    return org.acmsl.commons.utils.ConversionUtils.getInstance();
    // JUnitDoclet end method testcase.createInstance
  }
  
  /**
  * Performs any required steps before each test.
  * @throws Exception if an unexpected situation occurs.
  */
  protected void setUp()
  throws Exception
  {
    // JUnitDoclet begin method testcase.setUp
    super.setUp();
    conversionutils = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Performs any required steps after each test.
  * @throws Exception if an unexpected situation occurs.
  */
  protected void tearDown()
  throws Exception
  {
    // JUnitDoclet begin method testcase.tearDown
    conversionutils = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  /**
  * Tests ConversionUtilsTestgetInstance()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#getInstance()
  */
  public void testGetInstance()
  throws Exception
  {
    // JUnitDoclet begin method getInstance
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);
    // JUnitDoclet end method getInstance
  }
  
  /**
  * Tests ConversionUtilsTesttoString()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toString(java.lang.String)
  */
  public void testToString()
  throws Exception
  {
    // JUnitDoclet begin method toString
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue("a".equals(t_ConversionUtils.toString("a")));
        assertTrue(
            Boolean.TRUE.toString().equals(
                t_ConversionUtils.toString(Boolean.TRUE.toString())));
        assertTrue("a".equals(t_ConversionUtils.toString("a")));
        assertTrue("something else".equals(t_ConversionUtils.toString("something else")));
    // JUnitDoclet end method toString
  }
  
  /**
  * Tests ConversionUtilsTesttoBoolean()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toBoolean(java.lang.String)
  */
  public void testToBoolean()
  throws Exception
  {
    // JUnitDoclet begin method toBoolean
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toBoolean("true"));
        assertTrue(t_ConversionUtils.toBoolean(Boolean.TRUE.toString()));
        assertTrue(!t_ConversionUtils.toBoolean("false"));
        assertTrue(!t_ConversionUtils.toBoolean(Boolean.FALSE.toString()));
        assertTrue(!t_ConversionUtils.toBoolean("something else"));
    // JUnitDoclet end method toBoolean
  }
  
  /**
  * Tests ConversionUtilsTesttoInt()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toInt(java.lang.String)
  */
  public void testToInt()
  throws Exception
  {
    // JUnitDoclet begin method toInt
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toInt("2") == 2);
        assertTrue(t_ConversionUtils.toInt("-2") == -2);
        assertTrue(t_ConversionUtils.toInt("1232323") == 1232323);
        assertTrue(t_ConversionUtils.toInt("something else") == 0);
    // JUnitDoclet end method toInt
  }
  
  /**
  * Tests ConversionUtilsTesttoLong()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toLong(java.lang.String)
  */
  public void testToLong()
  throws Exception
  {
    // JUnitDoclet begin method toLong
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toLong("2") == 2);
        assertTrue(t_ConversionUtils.toLong("-2") == -2);
        assertTrue(t_ConversionUtils.toLong("1232323") == 1232323);
        assertTrue(t_ConversionUtils.toLong("something else") == 0);
    // JUnitDoclet end method toLong
  }
  
  /**
  * Tests ConversionUtilsTesttoFloat()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toFloat(java.lang.String)
  */
  public void testToFloat()
  throws Exception
  {
    // JUnitDoclet begin method toFloat
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toFloat("2.0") == 2.0);
        assertTrue(t_ConversionUtils.toFloat("-2.0") == -2.0);
        assertTrue(t_ConversionUtils.toFloat("1232323.0") == 1232323.0);
        assertTrue(t_ConversionUtils.toFloat("something else") == 0.0);
    // JUnitDoclet end method toFloat
  }
  
  /**
  * Tests ConversionUtilsTesttoDouble()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toDouble(java.lang.String)
  */
  public void testToDouble()
  throws Exception
  {
    // JUnitDoclet begin method toDouble
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toDouble("2.0") == 2.0);
        assertTrue(t_ConversionUtils.toDouble("-2.0") == -2.0);
        assertTrue(t_ConversionUtils.toDouble("1232323.0") == 1232323.0);
        assertTrue(t_ConversionUtils.toDouble("something else") == 0.0);
    // JUnitDoclet end method toDouble
  }
  
  /**
  * Tests ConversionUtilsTesttoChar()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toChar(java.lang.String)
  */
  public void testToChar()
  throws Exception
  {
    // JUnitDoclet begin method toChar
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(Character.getNumericValue(t_ConversionUtils.toChar("2")) == 2);
        assertTrue(Character.getNumericValue(t_ConversionUtils.toChar("3")) == 3);
        assertTrue(Character.getNumericValue(t_ConversionUtils.toChar("something else")) == -1);
    // JUnitDoclet end method toChar
  }
  
  /**
  * Tests ConversionUtilsTesttoShort()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toShort(java.lang.String)
  */
  public void testToShort()
  throws Exception
  {
    // JUnitDoclet begin method toShort
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toShort("2") == 2);
        assertTrue(t_ConversionUtils.toShort("-2") == -2);
        assertTrue(t_ConversionUtils.toShort("something else") == 0);
    // JUnitDoclet end method toShort
  }
  
  /**
  * Tests ConversionUtilsTesttoByte()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toByte(java.lang.String)
  */
  public void testToByte()
  throws Exception
  {
    // JUnitDoclet begin method toByte
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        assertTrue(t_ConversionUtils.toByte("2") == 2);
        assertTrue(t_ConversionUtils.toByte("-2") == -2);
        assertTrue(t_ConversionUtils.toByte("something else") == 0);
    // JUnitDoclet end method toByte
  }
  
  /**
  * Tests ConversionUtilsTesttoBigDecimal()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toBigDecimal(java.lang.String)
  */
  public void testToBigDecimal()
  throws Exception
  {
    // JUnitDoclet begin method toBigDecimal
        ConversionUtils t_ConversionUtils =
            ConversionUtils.getInstance();

        assertNotNull(t_ConversionUtils);

        java.math.BigDecimal t_BigDecimal = t_ConversionUtils.toBigDecimal("2");
        assertNotNull(t_BigDecimal);
        assertTrue(
            t_BigDecimal.divide(
                new java.math.BigDecimal(1.0),
                1,
                java.math.BigDecimal.ROUND_HALF_EVEN).doubleValue()
            == 2.0);
    // JUnitDoclet end method toBigDecimal
  }
  
  /**
  * Tests ConversionUtilsTesttoDate()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.utils.ConversionUtils#toDate(java.lang.String)
  */
  public void testToDate()
  throws Exception
  {
    // JUnitDoclet begin method toDate
    // JUnitDoclet end method toDate
  }
  
  
  
  /**
  * JUnitDoclet moves marker to this method, if there is not match
  * for them in the regenerated code and if the marker is not empty.
  * This way, no test gets lost when regenerating after renaming.
  * Method testVault is supposed to be empty.
  * @throws Exception if an unexpected situation occurs.
  */
  public void testVault()
  throws Exception
  {
    // JUnitDoclet begin method testcase.testVault
    // JUnitDoclet end method testcase.testVault
  }
  
  public static void main(String[] args)
  {
    // JUnitDoclet begin method testcase.main
    junit.textui.TestRunner.run(ConversionUtilsTest.class);
    // JUnitDoclet end method testcase.main
  }
}
