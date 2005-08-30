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


    Thanks to ACM S.L. for distributing this library under the LGPL license.
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
 * Description: Provides some grammar rules for language.
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
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.CommonsBundleRepository;
import org.acmsl.commons.BundleI14able;
import org.acmsl.commons.patterns.Utils;

/*
 * Importing some JDK classes.
 */
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

/**
 * Provides some grammar rules for language.
 * @author <a href="mailto:jsanleandro@yahoo.es"
 *         >Jose San Leandro Armendáriz</a>
 * @version $Revision$
 */
public abstract class GrammarUtils
    implements  Utils
{
    /**
     * The locale.
     */
    private Locale m__Locale = null;

    /**
     * Protected constructor to avoid accidental instantiation.
     */
    protected GrammarUtils(final Locale locale)
    {
        immutableSetLocale(locale);
    }

    /**
     * Specifies the locale.
     * @param locale the locale.
     */
    private void immutableSetLocale(final Locale locale)
    {
        m__Locale = locale;
    }

    /**
     * Specifies the locale.
     * @param locale the locale.
     */
    protected void setLocale(final Locale locale)
    {
        immutableSetLocale(locale);
    }

    /**
     * Retrieves the locale.
     * @return such instance.
     */
    public Locale getLocale()
    {
        return m__Locale;
    }

    /**
     * Retrieves the words bundle.
     * @return such bundle name.
     */
    protected String retrieveGrammarBundleName()
    {
        return
            retrieveGrammarBundleName(
                CommonsBundleRepository.getInstance());
    }

    /**
     * Retrieves the words bundle.
     * @param bundleRepository the bundle repository.
     * @return such bundle name.
     * @precondition bundleRepository != null
     */
    protected String retrieveGrammarBundleName(
        final CommonsBundleRepository bundleRepository)
    {
        return bundleRepository.getGrammarBundleName();
    }

    /**
     * Converts given word to plural.
     * @param word the word to convert.
     * @return the converted word.
     * @precondition word != null
     */
    public String getSingular(final String word)
    {
        String result =
            getWord(
                new _BundleI14able(
                    word + ".singular", retrieveGrammarBundleName()),
                getLocale());

        if  (result == null)
        {
            result = getRegularSingularForm(word);
        }

        return result;
    }

    /**
     * Converts given word to plural.
     * @param word the word to convert.
     * @return the converted word.
     * @precondition word != null
     */
    public String getPlural(final String word)
    {
        String result =
            getWord(
                new _BundleI14able(
                    word + ".plural", retrieveGrammarBundleName()),
                getLocale());

        if  (result == null)
        {
            result = getRegularPluralForm(word);
        }

        return result;
    }

    /**
     * Converts given word to plural.
     * @param bundleI14able the bundleI14able instance.
     * @param locale the locale.
     * @return the converted word.
     * @precondition bundleI14able != null
     */
    public String getWord(final BundleI14able bundleI14able, final Locale locale)
    {
        String result = null;

        try
        {
            result = bundleI14able.toString(locale);
        }
        catch  (final MissingResourceException missingResourceException)
        {
            // Nothing to do.
        }

        return result;
    }

    /**
     * Manages the regular plural forms.
     * @param word the word.
     * @return the regular plural form.
     * @precondition word != null
     */
    protected abstract String getRegularPluralForm(final String word);

    /**
     * Manages the regular singular forms.
     * @param word the word.
     * @return the regular plural form.
     * @precondition word != null
     */
    protected abstract String getRegularSingularForm(final String word);

    /**
     * BundleI14able suited for <code>GrammarUtils</code> class.
     * @author <a href="mailto:jsanleandro@yahoo.es"
     *         >Jose San Leandro Armendariz</a>
     * @version $Revision$ $Date$
     */
    protected class _BundleI14able
        extends  BundleI14able
    {
        /**
         * Creates a _BundleI14able with given information.
         * @param messageKey the key to build the exception message.
         * @param params the parameters to build the exception message.
         * @param bundleName the name of the bundle.
         */
        protected _BundleI14able(
            final String messageKey,
            final String bundleName)
        {
            super(messageKey, bundleName);
        }
    }
}
