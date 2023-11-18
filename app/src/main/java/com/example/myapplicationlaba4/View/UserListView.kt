
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplicationlaba4.Models.user

@Composable
fun UserListView(viewModel: MainViewModel) {
    var userList by remember { mutableStateOf(emptyList<user.User>()) }

    LaunchedEffect(true) {
        // Загрузка данных из ViewModel при первом отображении
        userList = viewModel.getUserList()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            Body(userList = userList)
            Spacer(modifier = Modifier.height(16.dp))
            Footer()
        }
    }
}

@Composable
fun Header() {
    // Ваш код для заголовка
    Text(text = "User List", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun Body(userList: List<user.User>) {
    LazyColumn {
        items(userList) { user ->
            UserListItem(user = user)
        }
    }
}

@Composable
fun UserListItem(user: user.User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "ID: ${user.id}")
        Text(text = "Name: ${user.name}")
        Text(text = "Age: ${user.age}")
    }
}

@Composable
fun Footer() {
    // Ваш код для подвала
    Text(text = "End of User List", style = MaterialTheme.typography.displayMedium)
}