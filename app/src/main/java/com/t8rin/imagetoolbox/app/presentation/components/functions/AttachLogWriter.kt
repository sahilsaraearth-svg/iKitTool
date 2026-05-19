/*
 * iKitTool is an image editor for android
 * Copyright (c) 2026 T8RIN (Malik Mukhametzyanov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * You should have received a copy of the Apache License
 * along with this program.  If not, see <http://www.apache.org/licenses/LICENSE-2.0>.
 */

package com.t8rin.ikittool.app.presentation.components.functions

import com.t8rin.ikittool.app.presentation.components.iKitToolApplication
import com.t8rin.ikittool.core.resources.R
import com.t8rin.ikittool.core.ui.utils.helper.DeviceInfo
import com.t8rin.ikittool.core.utils.Logger
import com.t8rin.ikittool.core.utils.attachLogWriter


internal fun iKitToolApplication.attachLogWriter() {
    Logger.attachLogWriter(
        context = this@attachLogWriter,
        fileProvider = getString(R.string.file_provider),
        logsFilename = "ikit_tool_logs.txt",
        startupLog = Logger.Log(
            tag = "Device Info",
            message = "--${DeviceInfo.get()}--",
            level = Logger.Level.Info
        ),
        errorHandler = analyticsManager::sendReport,
        isSyncCreate = false
    )
}