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
package org.eclipse.che.ide.ext.debugger.client.actions;

import com.google.inject.Inject;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.debug.Debugger;
import org.eclipse.che.ide.debug.DebuggerManager;
import org.eclipse.che.ide.ext.debugger.client.DebuggerLocalizationConstant;
import org.eclipse.che.ide.ext.debugger.client.DebuggerResources;

/**
 * Action which allows disconnect debugger from running process
 *
 * @author Mykola Morhun
 */
public class DisconnectDebuggerAction extends Action {
    private final DebuggerManager debuggerManager;

    @Inject
    public DisconnectDebuggerAction(DebuggerManager debuggerManager,
                                    DebuggerLocalizationConstant locale,
                                    DebuggerResources resources) {
        super(locale.disconnectDebugger(), locale.disconnectDebuggerDescription(), null, resources.disconnectDebugger());

        this.debuggerManager = debuggerManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Debugger debugger = debuggerManager.getActiveDebugger();
        if (debugger != null) {
            debugger.disconnectDebugger();
        }
    }

    @Override
    public void update(ActionEvent e) {
        Debugger debugger = debuggerManager.getActiveDebugger();
        e.getPresentation().setEnabled(debugger != null && debugger.isConnected());
    }

}