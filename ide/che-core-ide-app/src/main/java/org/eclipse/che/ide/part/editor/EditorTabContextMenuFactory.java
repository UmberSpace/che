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
package org.eclipse.che.ide.part.editor;

import org.eclipse.che.ide.part.widgets.editortab.EditorTab;

/**
 * Editor tab context menu factory.
 *
 * @author Vlad Zhukovskiy
 */
public interface EditorTabContextMenuFactory {
    /**
     * Creates new context menu for editor tab.
     *
     * @param editorTab
     *         editor tab item
     * @return new context menu
     */
    EditorTabContextMenu newContextMenu(EditorTab editorTab);
}
