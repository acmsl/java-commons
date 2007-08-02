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
 * Description: Provides some useful methods when working with files.
 *
 * File version: $Revision: 550 $
 *
 * Project version: $Name$
 *                  ("Name" means no concrete version has been checked out)
 *
 * $Id: FileUtils.java 550 2006-06-14 19:01:54Z chous $
 *
 */
package org.acmsl.commons.utils.io;

/*
 * Importing some ACM-SL classes.
 */
import org.acmsl.commons.patterns.Singleton;
import org.acmsl.commons.patterns.Utils;
import org.acmsl.commons.regexpplugin.Helper;
import org.acmsl.commons.regexpplugin.MalformedPatternException;
import org.acmsl.commons.regexpplugin.RegexpEngine;
import org.acmsl.commons.regexpplugin.RegexpEngineNotFoundException;
import org.acmsl.commons.regexpplugin.RegexpManager;
import org.acmsl.commons.regexpplugin.RegexpPluginMisconfiguredException;

/*
 * Importing some JDK1.3 classes.
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/*
 * Importing commons-logging classes.
 */
import org.apache.commons.logging.LogFactory;

/**
 * Provides some useful methods when working with files.
 * @author <a href="mailto:jsanleandro@yahoo.es"
           >Jose San Leandro Armendáriz</a>
 * @version $Revision: 550 $ $Date: 2006-06-14 21:01:54 +0200 (Wed, 14 Jun 2006) $
 * @stereotype Utils
 */
public class FileUtils
    implements  Utils,
                Singleton
{
    /**
     * An empty char array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];

    /**
     * Singleton implemented to avoid the double-checked locking.
     */
    private static class FileUtilsSingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final FileUtils SINGLETON = new FileUtils();
    }

    /**
     * Retrieves a FileUtils instance.
     * @return such instance.
     */
    public static FileUtils getInstance()
    {
        return FileUtilsSingletonContainer.SINGLETON;
    }

    /**
     * Protected constructor to avoid accidental instantiation.
     */
    protected FileUtils() {};

    /**
     * Reads a file pointed by given path, and returns its contents.
     * @param filePath the path to the file to be read.
     * @return the contents of the file.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the operation is forbidden because of
     * security manager settings.
     * @throws IOException if some I/O exception occurs.
     * @precondition filePath != null
     */
    public String readFile(final String filePath)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        return readFile(new File(filePath));
    }

    /**
     * Reads a file and returns its contents.
     * @param file the file to be read.
     * @return the contents of the file.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the operation is forbidden because of
     * security manager settings.
     * @throws IOException if some I/O exception occurs.
     * @precondition file != null
     */
    public char[] readFileContents(final File file)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        char[] result = EMPTY_CHAR_ARRAY;;

        /*
         * Instantiate a FileReader object to read file's contents.
         */
        FileReader t_frPageReader = new FileReader(file);

        /*
         * To read file's contents it's better to use BufferedReader class.
         */
        BufferedReader t_frPageBufferedReader =
            new BufferedReader(t_frPageReader);

        if  (file.length() > Integer.MAX_VALUE)
        {
            throw
                new IOException(
                    "File too large (" + file.length() + " bytes)");
        }

        /*
         * Next, I find out the necessary size of the array where file's
         * contents will be copied into.
         */
        result = new char[(int) file.length()];

        /*
         * Now I actually read the file, and fill the array.
         */
        t_frPageBufferedReader.read(
            result,
            0,
            result.length);

        return result;
    }

    /**
     * Reads a file and returns its contents.
     * @param file the file to be read.
     * @return the contents of the file.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the operation is forbidden because of
     * security manager settings.
     * @throws IOException if some I/O exception occurs.
     * @precondition file != null
     */
    public String readFile(final File file)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        /*
         * we can use a String constructor that exactly
         * fits our needs.
         */
        return new String(readFileContents(file));
    }

    /**
     * Reads a file by its path and returns its contents, if possible. If some
     * exception occurs, it's ignored, and returns an empty String. This method
     * is used to avoid declaring try/catch blocks in client code.
     * @param filePath the path to the file to be read.
     * @return the contents of the file, or empty if reading cannot be
     * accomplished.
     * @precondition filePath != null
     */
    public String readFileIfPossible(final String filePath)
    {
        String result = new String();

        try
        {
            result = readFile(filePath);
        }
        catch  (final FileNotFoundException fileNotFoundException)
        {
            /*
            * We have chosen not to notify of exceptions, so this
            * block of code is only descriptive.
            */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + filePath,
                fileNotFoundException);
        }
        catch  (final SecurityException securityException)
        {
            /*
            * We have chosen not to notify of exceptions, so this
            * block of code is only descriptive.
            */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + filePath,
                securityException);
        }
        catch  (final IOException ioException)
        {
            /*
            * We have chosen not to notify of exceptions, so this
            * block of code is only descriptive.
            */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + filePath,
                ioException);
        }

        return result;
    }

    /**
     * Reads a file and returns its contents, if possible. If some exception
     * occurs, it's ignored, and returns an empty String. This method is used
     * to avoid declaring try/catch blocks in client code.
     * @param file the file to be read.
     * @return the contents of the file, or empty if reading cannot be
     * accomplished.
     * @precondition file != null
     */
    public String readFileIfPossible(final File file)
    {
        String result = new String();

        try
        {
            result = readFile(file);
        }
        catch  (final FileNotFoundException fileNotFoundException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + file,
                fileNotFoundException);
        }
        catch  (final SecurityException securityException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + file,
                securityException);
        }
        catch  (final IOException ioException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot read file " + file,
                ioException);
        }

        return result;
    }

    /**
     * Tries to read from given stream.
     * @param stream the stream to read from.
     * @return the contents read.
     * @throws IOException if the input stream could not be read or closed.
     * @precondition inputStream != null
     */
    public String read(final InputStream inputStream)
        throws  IOException
    {
        BufferedInputStream bufferedInputStream = null;

        if  (inputStream instanceof BufferedInputStream)
        {
            bufferedInputStream = (BufferedInputStream) inputStream;
        }
        else
        {
            bufferedInputStream = new BufferedInputStream(inputStream);
        }

        return read(bufferedInputStream);
    }

    /**
     * Tries to read from given stream.
     * @param stream the stream to read from.
     * @return the contents read.
     * @throws IOException if the input stream could not be read or closed.
     * @precondition bufferedInputStream != null
     */
    public String read(final BufferedInputStream bufferedInputStream)
        throws  IOException
    {
        StringWriter t_swResult = new StringWriter();

        PrintWriter t_Writer = new PrintWriter(t_swResult);

        int t_iReadChar = bufferedInputStream.read();

        while  (t_iReadChar != -1)
        {
            t_Writer.print((char) t_iReadChar);

            t_iReadChar = bufferedInputStream.read();
        }

        bufferedInputStream.close();

        t_Writer.close();

        return t_swResult.toString();
    }

    /**
     * Saves the contents to a file.
     * @param filePath the path of the file.
     * @param contents the text to save.
     * @return <code>true</code> if the process is successfully accomplished.
     * @precondition filePath != null
     * @precondition contents != null
     */
    public boolean writeFileIfPossible(
        final String filePath, final String contents)
    {
        return writeFileIfPossible(new File(filePath), contents);
    }

    /**
     * Saves the contents to a file.
     * @param file the file to be overwritten.
     * @param contents the text to save.
     * @return <code>true</code> if the process is successfully accomplished.
     * @precondition file != null
     * @precondition contents != null
     */
    public boolean writeFileIfPossible(final File file, final String contents)
    {
        boolean result = false;

        try
        {
            writeFile(file, contents);
        }
        catch  (final FileNotFoundException fileNotFoundException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot write file " + file,
                fileNotFoundException);
        }
        catch  (final SecurityException securityException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot write file " + file,
                securityException);
        }
        catch  (final IOException ioException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot write file " + file,
                ioException);
        }

        return result;
    }

    /**
     * Writes a file referred by given path, with given contents.
     * @param filePath the path of the file.
     * @param contents the text to write.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this
     * operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition filePath != null
     * @precondition contents != null
     */
    public void writeFile(final String filePath, final String contents)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        writeFile(new File(filePath), contents);
    }

    /**
     * Writes a file with given contents.
     * @param file the file to write.
     * @param contents the text to write.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this
     * operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition file != null
     * @precondition contents != null
     */
    public void writeFile(final File file, final String contents)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        if  (   (file     != null)
             && (contents != null))
        {
            FileWriter t_fwWriter = new FileWriter(file);

            PrintWriter t_pwWriter = new PrintWriter(t_fwWriter);

            t_pwWriter.println(contents);

            t_pwWriter.close();

            t_fwWriter.close();
        }
    }

    /**
     * Copies one file from its current path to another.
     * @param filePath file's path.
     * @param destinationPath the new path of the file.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this
     * operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition filePath != null
     * @precondition destinationPath != null
     */
    public void copy(final String filePath, final String destinationPath)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        copy(new File(filePath), new File(destinationPath));
    }

    /**
     * Copies the contents of a file to another.
     * @param original the content to copy.
     * @param destination the file to be overwritten.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this
     * operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition original != null
     * @precondition destination != null
     */
    public void copy(final File original, final File destination)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        FileWriter t_FileWriter = new FileWriter(destination);

        t_FileWriter.write(readFileContents(original));

        t_FileWriter.close();
    }

    /**
     * Copies the contents of a file (referred by given path) to another.
     * @param originalPath the path of the file to copy.
     * @param destinationPath the path of the file to be overwritten.
     * @return <code>true</code> if the operation ends up successfully.
     * @precondition originalPath != null
     * @precondition destinationPath != null
     */
    public boolean copyIfPossible(
        final String originalPath, final String destinationPath)
    {
        return
            copyIfPossible(new File(originalPath), new File(destinationPath));
    }

    /**
     * Copies the contents of a file to another.
     * @param original the content to copy.
     * @param destination the file to be overwritten.
     * @return <code>true</code> if the operation ends up successfully.
     * @precondition original != null
     * @precondition destination != null
     */
    public boolean copyIfPossible(final File original, final File destination)
    {
        boolean result = false;

        try
        {
            copy(original, destination);

            result = true;
        }
        catch  (final FileNotFoundException fileNotFoundException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot copy file " + original + " to " + destination,
                fileNotFoundException);
        }
        catch  (final SecurityException securityException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot copy file " + original + " to " + destination,
                securityException);
        }
        catch  (final IOException ioException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot copy file " + original + " to " + destination,
                ioException);
        }

        return result;
    }

    /**
     * Moves a file.
     * @param originalFile the file to move.
     * @param destinationFile the new file.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this
     * operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition originalFile != null
     * @precondition destinationFile != null
     */
    public void move(final File originalFile, final File destinationFile)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        copy(originalFile, destinationFile);

        originalFile.delete();
    }

    /**
     * Moves a file from one path to another, if possible.
     * @param filePath the path of the file to move.
     * @param destinationPath the new file's path.
     * @throws FileNotFoundException if the file is not found.
     * @throws SecurityException if the security manager forbids this 
     + operation.
     * @throws IOException if any other I/O error occurs.
     * @precondition filePath != null
     * @precondition destinationPath != null
     */
    public void move(final String filePath, final String destinationPath)
        throws  FileNotFoundException,
                SecurityException,
                IOException
    {
        move(new File(filePath), new File(destinationPath));
    }

    /**
     * Moves a file, if possible.
     * @param originalFile the file to move.
     * @param destinationFile the new file.
     * @return <code>true</code> if the operation ends up successfully.
     * @preocondition originalFile != null
     * @precondition destinationFile != null
     */
    public boolean moveIfPossible(
        final File originalFile, final File destinationFile)
    {
        boolean result = false;

        try
        {
            move(originalFile, destinationFile);
            result = true;
        }
        catch  (final FileNotFoundException fileNotFoundException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot move file " + originalFile + " to " + destinationFile,
                fileNotFoundException);
        }
        catch  (final SecurityException securityException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot move file " + originalFile + " to " + destinationFile,
                securityException);
        }
        catch  (final IOException ioException)
        {
            /*
             * We have chosen not to notify of exceptions, so this
             * block of code is only descriptive.
             */
            LogFactory.getLog(FileUtils.class).info(
                "Cannot move file " + originalFile + " to " + destinationFile,
                ioException);
        }

        return result;
    }

    /**
     * Moves a file from one path to another, if possible.
     * @param filePath the path of the file to move.
     * @param destinationPath the new file's path.
     * @return <code>true</code> if the operation ends up successfully.
     * @precondition filePath != null
     * @precondition destinationPath != null
     */
    public boolean moveIfPossible(
        final String filePath, final String destinationPath)
    {
        return
            moveIfPossible(
                new File(filePath),
                new File(destinationPath));
    }

    /**
     * Translates given package name to a relative path.
     * @param packageName the package name.
     * @return the path.
     * @precondition packageName != null
     */
    public String packageToPath(final String packageName)
    {
        String result = null;

        try
        {
            Helper t_Helper = createHelper(RegexpManager.getInstance());

            result =
                t_Helper.replaceAll(packageName, "\\.", File.separator);
        }
        catch  (final MalformedPatternException malformedPatternException)
        {
            /*
             * This exception is about pattern mismatch. In my opinion,
             * it's an error that should be detected at compile time,
             * but regexp API design cannot provide this functionality,
             * since all patterns are defined with strings, and therefore
             * they escape all compiler checks.
             */
            LogFactory.getLog(getClass()).warn(
                "Malformed static patterns are fatal coding errors.",
                malformedPatternException);
        }
        catch  (final RegexpEngineNotFoundException regengNotFoundException)
        {
            /*
             * This exception is thrown only if no regexp library is available
             * at runtime. Not only this one, but any method provided by this
             * class that use regexps will not work.
             */
            LogFactory.getLog(getClass()).fatal(
                "Cannot find any regexp engine.",
                regengNotFoundException);
        }
        catch  (final RegexpPluginMisconfiguredException
                      regexpPluginMisconfiguredException)
        {
            /*
             * This exception is thrown if RegexpPlugin cannot be configured
             * properly at runtime. Not only this one, but any method provided
             * by thisclass that use regexps will not work.
             */
            LogFactory.getLog(getClass()).fatal(
                "Cannot configure RegexpPlugin.",
                regexpPluginMisconfiguredException);
        }

        return result;
    }

    /**
     * Creates the helper.
     * @return the regexp helper.
     * @throws RegexpEngineNotFoundException if a suitable instance
     * cannot be created.
     * @throws RegexpPluginMisconfiguredException if RegexpPlugin is
     * misconfigured.
     */
    protected static synchronized Helper createHelper()
      throws RegexpEngineNotFoundException,
             RegexpPluginMisconfiguredException
    {
        return createHelper(RegexpManager.getInstance());
    }

    /**
     * Creates the helper.
     * @param regexpManager the RegexpManager instance.
     * @return the regexp helper.
     * @throws RegexpEngineNotFoundException if a suitable instance
     * cannot be created.
     * @throws RegexpPluginMisconfiguredException if RegexpPlugin is
     * misconfigured.
     * @precondition regexpManager != null
     */
    protected static synchronized Helper createHelper(
        final RegexpManager regexpManager)
      throws RegexpEngineNotFoundException,
             RegexpPluginMisconfiguredException
    {
        return createHelper(regexpManager.getEngine());
    }

    /**
     * Creates the helper.
     * @param regexpEngine the RegexpEngine instance.
     * @return the regexp helper.
     * @precondition regexpEngine != null
     */
    protected static synchronized Helper createHelper(
        final RegexpEngine regexpEngine)
    {
        return regexpEngine.createHelper();
    }
}
