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
 * Description: Jakarta Regexp-specific regexp compiler adapter.
 *              This class makes possible the use of Jakarta Regexp
 *              compilers inside this API. Delegation is used to be
 *              able to write compile(String) method with different
 *              signature as Jakarta Regexp's.
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
package org.acmsl.commons.regexpplugin.jakartaregexp;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.regexpplugin.Compiler;
import org.acmsl.commons.regexpplugin.MalformedPatternException;
import org.acmsl.commons.regexpplugin.Pattern;
import org.acmsl.commons.version.Version;
import org.acmsl.commons.version.VersionFactory;

/*
 * Importing Jakarta Regexp classes.
 */
import org.apache.regexp.RE;
import org.apache.regexp.RECompiler;
import org.apache.regexp.REProgram;
import org.apache.regexp.RESyntaxException;

/*
 * Importing some Commons-Logging classes.
 */
import org.apache.commons.logging.LogFactory;

/**
 * Jakarta Regexp-specific regexp compiler adapter. This class makes
 * possible the use of Jakarta Regexp compilers inside this API.
 * Delegation is used to be able to write compile(String) method
 * with different signature as Jakarta Regexp's.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armendáriz</a>
 * @version $Revision$
 */
public class CompilerRegexpAdapter
    implements  Compiler
{
    /**
     * Delegated instance.
     */
    private RECompiler m__Instance;

    /**
     * Case sensitiveness.
     */
    private boolean m__bCaseSensitive;

    /**
     * Multiline parsing.
     */
    private boolean m__bMultiline;

    /**
     * Specifies the adapted instance.
     * @param compiler the compiler to adapt.
     */
    protected void setRECompiler(RECompiler compiler)
    {
        m__Instance = compiler;
    }

    /**
     * Retrieves an instance of RECompilerCompiler class.
     * @return a new (or already existing) compiler.
     */
    protected synchronized RECompiler getRECompiler()
    {
        RECompiler result = m__Instance;

        if  (result == null)
        {
            result = new RECompiler();

            setRECompiler(result);
        }

        return result;
    }

    /**
     * Sets whether the compiler should care about case sensitiveness
     * or not.
     * @param caseSensitive true for differentiate upper from lower case.
     */
    public void setCaseSensitive(boolean caseSensitive)
    {
        m__bCaseSensitive = caseSensitive;
    }

    /**
     * Retrieves whether the compiler should care about case sensitiveness
     * or not.
     * @return true if upper from lower cases are processed differently.
     */
    public boolean isCaseSensitive()
    {
        return m__bCaseSensitive;
    }

    /**
     * Sets whether the compiler should care about new line delimiters
     * or not.
     * @param multiline false for parsing each line at a time.
     */
    public void setMultiline(boolean multiline)
    {
        m__bMultiline = multiline;
    }

    /**
     * Sets whether the compiler should care about new line delimiters
     * or not.
     * @return false if the engine parses each line one at a time.
     */
    public boolean isMultiline()
    {
        return m__bMultiline;
    }

    /**
     * Compiles given regular expression and creates a Pattern object to
     * apply such rule on concrete text contents.
     * @param regexp the regular expression to compile.
     * @return the Pattern associated to such regular expression.
     * @exception MalformedPatternException if given regexp is malformed.
     */
    public Pattern compile(String regexp)
        throws  MalformedPatternException
    {
        Pattern result = null;

        try
        {
            RECompiler t_Compiler = getRECompiler();

            if  (t_Compiler != null)
            {
                REProgram t_REProgram = t_Compiler.compile(regexp);

                RE t_RE = new RE(t_REProgram);

                int t_iOptions = 0;

                t_iOptions |=
                    (isCaseSensitive())
                    ?  RE.MATCH_NORMAL
                    :  RE.MATCH_CASEINDEPENDENT;

                t_iOptions |=
                    (isMultiline())
                    ?  RE.MATCH_MULTILINE
                    :  RE.MATCH_SINGLELINE;

                if (t_iOptions != 0)
                {
                    t_RE.setMatchFlags(t_iOptions);
                }

                result = new PatternRegexpAdapter(t_REProgram, t_RE);
            }
            else 
            {
                LogFactory.getLog(getClass()).error(
                    "compiler not accessible");
            }
        }
        catch  (RESyntaxException exception)
        {
            throw new MalformedPatternExceptionRegexpAdapter(exception);
        }
        catch  (IllegalArgumentException illegalArgumentException)
        {
            if  (resetOptions())
            {
                result = compile(regexp);
            }
        }

        return result;
    }

    /**
     * Resets the compiler options.
     * @return true if the options actually changed.
     */
    private boolean resetOptions()
    {
        boolean result = false;

        result =
            (   (isCaseSensitive())
             || (isMultiline()));

        if  (result)
        {
            setCaseSensitive(false);

            setMultiline(false);
        }

        return result;
    }

    /**
     * Concrete version object updated everytime it's checked-in in a CVS
     * repository.
     */
    public static final Version VERSION =
        VersionFactory.createVersion("$Revision$");

    /**
     * Retrieves the current version of this object.
     * @return the version object with such information.
     */
    public Version getVersion()
    {
        return VERSION;
    }

    /**
     * Retrieves the current version of this class.
     * @return the object with class version information.
     */
    public static Version getClassVersion()
    {
        return VERSION;
    }
}
