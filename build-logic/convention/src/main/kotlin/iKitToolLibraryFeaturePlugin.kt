/*
 * iKitTool is an image editor for android
 * Copyright (c) 2024 T8RIN (Malik Mukhametzyanov)
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

import com.t8rin.ikittool.configureDetekt
import com.t8rin.ikittool.core
import com.t8rin.ikittool.crash
import com.t8rin.ikittool.data
import com.t8rin.ikittool.di
import com.t8rin.ikittool.domain
import com.t8rin.ikittool.implementation
import com.t8rin.ikittool.projects
import com.t8rin.ikittool.resources
import com.t8rin.ikittool.settings
import com.t8rin.ikittool.ui
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("UNUSED")
class iKitToolLibraryFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureDetekt(extensions.getByType<DetektExtension>())
            dependencies {
                implementation(projects.core.data)
                implementation(projects.core.ui)
                implementation(projects.core.domain)
                implementation(projects.core.resources)
                implementation(projects.core.settings)
                implementation(projects.core.di)
                implementation(projects.core.crash)
            }
        }
    }
}