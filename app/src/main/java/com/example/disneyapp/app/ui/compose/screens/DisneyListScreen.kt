package com.example.disneyapp.app.ui.compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disneyapp.app.model.Disney
import com.example.disneyapp.app.model.DisneyListModel
import com.example.disneyapp.app.ui.uiaction.DisneyListAction
import com.example.disneyapp.app.ui.uiaction.DisneyListSingleEvent
import com.example.disneyapp.app.ui.viewmodel.DisneyListViewModel
import com.example.disneyapp.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisneyListScreen(
    viewModel: DisneyListViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(DisneyListAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                DisneyList(it) { item ->
                    viewModel.submitAction(
                        DisneyListAction.DisneyItemClick(
                            item.name,
                            item.image,
                            item.sourceUrl,
                            item.updatedAt
                        )
                    )
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is DisneyListSingleEvent.GoToDetailsScreen -> {
                    navController.navigate(it.route)
                }
            }
        }
    }
}

@Composable
fun DisneyList(
    listModel: DisneyListModel,
    onItemClick: (Disney) -> Unit,
) {
    LazyColumn(
       contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(listModel.characters) {char ->
            DisneyItem(char = char, onItemClick = onItemClick)
        }
    }
}

@Composable
fun DisneyItem(char: Disney, onItemClick: (Disney) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(char) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("${char.name}")
        }
    }
}

