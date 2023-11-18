import androidx.lifecycle.ViewModel
import com.example.myapplicationlaba4.Models.user
import com.example.myapplicationlaba4.Repository.MainRepository

class MainViewModel : ViewModel() {

    private val userRepository = MainRepository() // Предполагается, что у вас есть класс репозитория

    fun getUserList(): List<user.User> {
        return userRepository.getUserList()
    }
}