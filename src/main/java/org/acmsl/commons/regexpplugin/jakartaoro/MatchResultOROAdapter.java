/*
                        ACM-SL Commons

    Copyright (C) 2002-2003  Jose San Leandro Armendáriz
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
                    Urb. Valdecabañas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: $RCSfile$
 *
 * Author: Jose San Leandro Armendáriz
 *
 * Description: Represents the result of match in a regexp parsing process
 *              using Jakarta ORO package.
 *
 * Last modified.commons by: $Author: chous $ at $Date: 2004-12-01 09:50:27 +0100 (Wed, 01 Dec 2004) $
 *
 * File version: $Revision: 473 $
 *
 * Project version: $Name$
 *                  ("Name" means no concrete version has been checked out)
 *
 * $Id: MatchResultOROAdapter.java 473 2004-12-01 08:50:27Z chous $
 *
 */
package org.acmsl.commons.regexpplugin.jakartaoro;

/*
 * Importing some Jakarta-ORO classes.
 */
import org.apache.oro.text.regex.MatchResult;

/**
 * Represents the result of match in a regexp parsing process using Jakarta
 * ORO package.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armendáriz</a>
 * @version $Revision: 473 $
 */
public class MatchResultOROAdapter
    implements  org.acmsl.commons.regexpplugin.MatchResult
{
    /**
     * Adapted object.
     */
    private MatchResult m__Adaptee;

    /**
     * Constructs a MatchResultOROAdapter from given Jakarta ORO-specific
     * instance.
     * @param matchResult Jakarta ORO match result object to adapt.
     */
    public MatchResultOROAdapter(final MatchResult matchResult)
    {
        inmutableSetMatchResult(matchResult);
    }

    /**
     * Specifies the adaptee.
     * @param adaptee the instance to adapt.
     */
    private void inmutableSetMatchResult(final MatchResult adaptee)
    {
        m__Adaptee = adaptee;
    }

    /**
     * Specifies the adaptee.
     * @param adaptee the instance to adapt.
     */
    protected void setMatchResult(final MatchResult adaptee)
    {
        inmutableSetMatchResult(adaptee);
    }

    /**
     * Retrieves the adaptee.
     * @return the adapted instance.
     */
    protected MatchResult getMatchResult()
    {
        return m__Adaptee;
    }

    /**
     * Taken from Jakarta ORO javadoc:
     * <i>Returns the contents of the parenthesized subgroups of a match,
     * counting parentheses from left to right and starting from 1. Group 0
     * always refers to the entire match. For example, if the pattern foo(\d+)
     * is used to extract a match from the input abfoo123 , then group(0) will
     * return foo123 and group(1) will return 123 . group(2) will return null
     * because there is only one subgroup in the original pattern.</i>
     * @param group The pattern subgroup to return.
     * @return A string containing the indicated pattern subgroup. Group 0
     * always refers to the entire match. If a group was never matched, it
     * returns null. This is not to be confused with a group matching the null
     * string, which will return a String of length 0.
     */
    public String group(final int group)
    {
        String result = "";

        MatchResult t_MatchResult = getMatchResult();

        if  (t_MatchResult != null)
        {
            result = t_MatchResult.group(group);
        }

        return result;
    }

    /**
     * Taken from Jakarta ORO 2.0.6 javadoc:
     * <i>The number of groups contained in the result. This number
     * includes the 0th group. In other words, the result refers to
     * the number of parenthesized subgroups plus the entire match
     * itself.</i>.
     * @return such value.
     */
    public int groups()
    {
        int result = 0;

        MatchResult t_MatchResult = getMatchResult();

        if  (t_MatchResult != null)
        {
            result = t_MatchResult.groups();
        }

        return result;
    }
}
