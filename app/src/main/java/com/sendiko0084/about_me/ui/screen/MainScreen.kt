package com.sendiko0084.about_me.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sendiko0084.about_me.R
import kotlin.math.pow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        ScreenContent(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
) {
    var width by remember { mutableStateOf("") }
    var length by remember { mutableStateOf("") }

    var bmi by remember { mutableFloatStateOf(0f) }
    var kategori by remember { mutableIntStateOf(0) }

    var widthError by remember { mutableStateOf(false) }
    var lengthError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "stringResource(R.string.bmi_intro)",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = width,
            onValueChange = {
                width = it
            },
            label = {
                Text(
                    text = stringResource(R.string.width),
                )
            },
            trailingIcon = {
                IconPicker(isError = widthError, "Kg")
            },
            supportingText = {
                ErrorHint(
                    isError = widthError
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = length,
            onValueChange = {
                length = it
            },
            label = {
                Text(
                    text = stringResource(R.string.length),
                )
            },
            trailingIcon = {
                IconPicker(isError = lengthError, "cm")
            },
            supportingText = {
                ErrorHint(
                    isError = lengthError
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Button(
            onClick = {
                widthError = (width == "" || width == "0")
                lengthError = (length == "" || length == "0")
                if (widthError || lengthError) return@Button
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.count_)
            )
        }
        if (bmi != 0f) {
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(kategori).uppercase(),
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }

}

@Composable
fun GenderOption(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    label: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun IconPicker(
    isError: Boolean,
    unit: String
) {
    if (isError) {
        Icon(
            imageVector = Icons.Filled.Warning,
            contentDescription = null
        )
    } else {
        Text(text = unit)
    }
}

@Composable
fun ErrorHint(
    modifier: Modifier = Modifier,
    isError: Boolean
) {
    if (isError)
        Text(
            text = stringResource(R.string.input_invalid)
        )
}