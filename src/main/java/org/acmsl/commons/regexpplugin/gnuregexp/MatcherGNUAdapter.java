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
 * Description: GNU Regexp 1.1.4 specific matcher adapter. This class
 *              makes possible the use of GNU Regexp 1.1.4 matchers
 *              inside this API.
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
package org.acmsl.commons.regexpplugin.gnuregexp;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.regexpplugin.gnuregexp.PatternGNUAdapter;
import org.acmsl.commons.regexpplugin.Matcher;
import org.acmsl.commons.regexpplugin.MatchResult;
import org.acmsl.commons.regexpplugin.Pattern;

/*
 * Importing GNU Regexp 1.1.4 classes.
 */
import gnu.regexp.RE;
import gnu.regexp.REMatchEnumeration;


/**
 * GNU Regexp 1.1.4 matcher adapter. This class makes possible
 * the use of GNU Regexp 1.1.4 matchers inside this API.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armend�riz</a>
 * @version $Revision$
 */
public class MatcherGNUAdapter
    implements  Matcher
{
    /**
     * Concrete engine implementation.
     */
    private REMatchEnumeration m__REMatchEnumeration;

    /**
     * Group count.
     */
    private int m__iGroups;

    /**
     * Constructs a MatcherGNUAdapter.
     */
    public MatcherGNUAdapter()  {};

    /**
     * Checks if given text contains specified pattern.
     * @param text the text to analyze.
     * @param pattern the regular expression to apply.
     * @return true if the pattern is found.
     */
    public boolean contains(String text, Pattern pattern)
    {
        boolean result = false;

        if  (   (pattern != null)
             && (pattern instanceof PatternGNUAdapter))
        {
            RE t_RE = ((PatternGNUAdapter) pattern).getDelegatedInstance();

            if  (t_RE != null)
            {
                setREMatchEnumeration(t_RE.getMatchEnumeration(text));

                setGroups(t_RE.getNumSubs());

                result =
                    (   (getREMatchEnumeration() != null)
                     && (getREMatchEnumeration().hasMoreMatches()));
            }
        }

        return result;
    }

    /**
     * Sets the match enumeration.
     * @param matchEnumeration such instance.
     */
    protected void setREMatchEnumeration(REMatchEnumeration reMatchEnumeration)
    {
        m__REMatchEnumeration = reMatchEnumeration;
    }

    /**
     * Retrieves the match enumeration.
     * @return such instance.
     */
    protected REMatchEnumeration getREMatchEnumeration()
    {
        return m__REMatchEnumeration;
    }

    /**
     * Sets the group count.
     * @param groups the number of groups.
     */
    protected void setGroups(int groups)
    {
        m__iGroups = groups;
    }

    /**
     * Retrieves the group count.
     * @return the number of groups.
     */
    protected int getGroups()
    {
        return m__iGroups;
    }

    /**
     * Retrieves the last match found due to a previous call to
     * <i>contains</i> method.
     * @return such match result.
     */
    public MatchResult getMatch()
    {
        MatchResult result = null;

        if  (getREMatchEnumeration() != null)
        {
            result =
                new MatchResultGNUAdapter(
                    getREMatchEnumeration().nextMatch(),
                    getGroups());
        }

        return result;
    }
}