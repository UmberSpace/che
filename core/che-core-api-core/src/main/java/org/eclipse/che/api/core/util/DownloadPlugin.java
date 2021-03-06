/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.core.util;

import java.io.IOException;

/**
 * Downloads remote file.
 *
 * @author andrew00x
 */
public interface DownloadPlugin {

    interface Callback {
        /**
         * Notified when file downloaded.
         *
         * @param downloaded
         *         downloaded file
         */
        void done(java.io.File downloaded);

        /**
         * Notified when error occurs.
         *
         * @param e
         *         error
         */
        void error(IOException e);
    }

    /**
     * Download file from specified location to local directory {@code downloadTo}.
     *
     * @param downloadUrl
     *         download URL
     * @param downloadTo
     *         local directory for download
     * @param callback
     *         notified when download is done or an error occurs
     */
    void download(String downloadUrl, java.io.File downloadTo, Callback callback);

    /**
     * Download file from specified location to local directory {@code downloadTo} and save it in file {@code fileName}.
     *
     * @param downloadUrl
     *         download URL
     * @param downloadTo
     *         local directory for download
     * @param fileName
     *         name of local file to save download result
     * @param replaceExisting
     *         replace existed file with the same name
     * @throws IOException if i/o error occurs when try download file or save it on local filesystem
     */
    void download(String downloadUrl, java.io.File downloadTo, String fileName, boolean replaceExisting) throws IOException;
}
