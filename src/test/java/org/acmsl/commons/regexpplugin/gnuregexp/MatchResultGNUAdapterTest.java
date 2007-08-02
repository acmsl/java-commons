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
* Last modified by: $Author: chous $ at $Date: 2006-04-02 12:15:23 +0200 (Sun, 02 Apr 2006) $
*
* File version: $Revision: 548 $
*
* Project version: $Name$
*
* $Id: MatchResultGNUAdapterTest.java 548 2006-04-02 10:15:23Z chous $
*/
package org.acmsl.commons.regexpplugin.gnuregexp;

/*
* Importing project classes.
*/
// JUnitDoclet begin import
import org.acmsl.commons.regexpplugin.gnuregexp.MatchResultGNUAdapter;
import gnu.regexp.RE;
import gnu.regexp.REMatch;
import gnu.regexp.REMatchEnumeration;
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
* Tests MatchResultGNUAdapterTest class.
* @version $Revision: 548 $
* @see org.acmsl.commons.regexpplugin.gnuregexp.MatchResultGNUAdapter
*/
public class MatchResultGNUAdapterTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
    MatchResultGNUAdapter matchResultGNUAdapter = null;

    /**
     * Specifies the adapter.
     * @param adapter the adapter.
     */
    protected void setMatchResultGNUAdapter(MatchResultGNUAdapter adapter)
    {
        matchResultGNUAdapter = adapter;
    }

    /**
     * Retrieves the adapter.
     * @return such adapter.
     */
    public MatchResultGNUAdapter getMatchResultGNUAdapter()
    {
        return matchResultGNUAdapter;
    }
  // JUnitDoclet end class
  
  /**
  * Creates a MatchResultGNUAdapterTest with given name.
  * @param name such name.
  */
  public MatchResultGNUAdapterTest(String name)
  {
    // JUnitDoclet begin method MatchResultGNUAdapterTest
    super(name);
    // JUnitDoclet end method MatchResultGNUAdapterTest
  }
  
  /**
  * Creates an instance of the tested class.
  * @return such instance.
  
  */
  public org.acmsl.commons.regexpplugin.gnuregexp.MatchResultGNUAdapter createInstance()
  throws Exception
  {
    // JUnitDoclet begin method testcase.createInstance
      RE t_RE = new RE("(.*?):(.*)");
      REMatchEnumeration t_REMatchEnumeration =
          t_RE.getMatchEnumeration("one:two");

      return
          new MatchResultGNUAdapter(
              t_REMatchEnumeration.nextMatch(),
              t_RE.getNumSubs());
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
    setMatchResultGNUAdapter(createInstance());
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
    setMatchResultGNUAdapter(null);
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  /**
  * Tests MatchResultGNUAdapterTestgroups()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.regexpplugin.gnuregexp.MatchResultGNUAdapter#groups()
  */
  public void testGroups()
  throws Exception
  {
    // JUnitDoclet begin method groups
      assertNotNull(getMatchResultGNUAdapter());
      assertTrue(getMatchResultGNUAdapter().groups() == 2);
    // JUnitDoclet end method groups
  }
  
  /**
  * Tests MatchResultGNUAdapterTestgroup()
  * @throws Exception if an unexpected situation occurs.
  * @see org.acmsl.commons.regexpplugin.gnuregexp.MatchResultGNUAdapter#group(int)
  */
  public void testGroup()
  throws Exception
  {
    // JUnitDoclet begin method group
      assertNotNull(getMatchResultGNUAdapter());
      assertEquals(getMatchResultGNUAdapter().group(1), "one");
      assertEquals(getMatchResultGNUAdapter().group(2), "two");
    // JUnitDoclet end method group
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
    junit.textui.TestRunner.run(MatchResultGNUAdapterTest.class);
    // JUnitDoclet end method testcase.main
  }
}
