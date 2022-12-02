/*
 * This file is part of MastodonX.
 *
 * MastodonX is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * MastodonX is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with MastodonX. If not, see <https://www.gnu.org/licenses/>.
 */
package social.androiddev.signedout.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import social.androiddev.common.composables.buttons.MastodonButton
import social.androiddev.common.composables.text.MastodonTextField
import social.androiddev.common.theme.MastodonTheme
import social.androiddev.signedout.navigation.SelectServerComponent

/**
 * Select Server view that delegates business/navigation logic to [SelectServerComponent]
 * for when a user wants to select their mastodon domain/server
 */
@Composable
fun SelectServerContent(
    modifier: Modifier,
    component: SelectServerComponent,
) {
    SelectServerContent(
        modifier = modifier,
        onServerSelected = component::onServerSelected,
    )
}

@Composable
fun SelectServerContent(
    modifier: Modifier,
    onServerSelected: (String) -> Unit,
) {

    var server by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        MastodonTextField(
            value = server,
            onValueChange = { v ->
                server = v
            },
        )

        Spacer(Modifier.height(24.dp))

        MastodonButton(
            text = "Select",
            onClick = {
                onServerSelected(server)
            },
        )
    }
}

// @Preview
@Composable
private fun PreviewLandingContent() {
    MastodonTheme(true) {
        SelectServerContent(
            modifier = Modifier.fillMaxSize(),
            onServerSelected = {},
        )
    }
}