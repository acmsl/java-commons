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
*              unittests.org.acmsl.commons.regexpplugin.gnuregexp.
*
* Last modified by: $Author$ at $Date$
*
* File version: $Revision$
*
* Project version: $Name$
*
* $Id$
*/
package unittests.org.acmsl.commons.regexpplugin.gnuregexp;

/*
* Importing project classes.
*/
// JUnitDoclet begin import
import org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter;
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
* Tests CompilerGNUAdapterTest class.
* @version $Revision$
* @see org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter
*/
public class CompilerGNUAdapterTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter compilergnuadapter = null;
  // JUnitDoclet end class
  
  /**
  * Creates a CompilerGNUAdapterTest with given name.
  * @param name such name.
  */
  public CompilerGNUAdapterTest(String name)
  {
    // JUnitDoclet begin method CompilerGNUAdapterTest
    super(name);
    // JUnitDoclet end method CompilerGNUAdapterTest
  }
  
  /**
  * Creates an instance of the tested class.
  * @return such instance.
  
  */
  public org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter createInstance()
  throws Exception
  {
    // JUnitDoclet begin method testcase.createInstance
    return new org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter();
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
    compilergnuadapter = createInstance();
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
    compilergnuadapter = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  /**
  * Tests CompilerGNUAdapterTestcompile()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter#compile(java.lang.String)
  */
  public void testCompile()
  throws Exception
  {
    // JUnitDoclet begin method compile
    // JUnitDoclet end method compile
  }
  
  /**
  * Tests CompilerGNUAdapterTest accessor methods.
  * @throws Exception if an unexpected situation occurs.
  */
  public void testSetIsCaseSensitive()
  throws Exception
  {
    // JUnitDoclet begin method setCaseSensitive isCaseSensitive
    boolean[] t_aTests = {true, false};
    
    for (int t_iTestIndex = 0; t_iTestIndex < t_aTests.length; t_iTestIndex++)
    {
      compilergnuadapter.setCaseSensitive(t_aTests[t_iTestIndex]);
      assertEquals(
      t_aTests[t_iTestIndex],
      compilergnuadapter.isCaseSensitive());
    }
    // JUnitDoclet end method setCaseSensitive isCaseSensitive
  }
  
  /**
  * Tests CompilerGNUAdapterTest accessor methods.
  * @throws Exception if an unexpected situation occurs.
  */
  public void testSetIsMultiline()
  throws Exception
  {
    // JUnitDoclet begin method setMultiline isMultiline
    boolean[] t_aTests = {true, false};
    
    for (int t_iTestIndex = 0; t_iTestIndex < t_aTests.length; t_iTestIndex++)
    {
      compilergnuadapter.setMultiline(t_aTests[t_iTestIndex]);
      assertEquals(
      t_aTests[t_iTestIndex],
      compilergnuadapter.isMultiline());
    }
    // JUnitDoclet end method setMultiline isMultiline
  }
  
  /**
  * Tests CompilerGNUAdapterTestgetVersion()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter#getVersion()
  */
  public void testGetVersion()
  throws Exception
  {
    // JUnitDoclet begin method getVersion
    // JUnitDoclet end method getVersion
  }
  
  /**
  * Tests CompilerGNUAdapterTestgetClassVersion()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.regexpplugin.gnuregexp.CompilerGNUAdapter#getClassVersion()
  */
  public void testGetClassVersion()
  throws Exception
  {
    // JUnitDoclet begin method getClassVersion
    // JUnitDoclet end method getClassVersion
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
    junit.textui.TestRunner.run(CompilerGNUAdapterTest.class);
    // JUnitDoclet end method testcase.main
  }
}
