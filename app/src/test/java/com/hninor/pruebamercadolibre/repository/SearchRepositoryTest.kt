import com.hninor.pruebamercadolibre.repository.SearchRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class SearchRepositoryTest {


    private lateinit var repository: SearchRepository

    @Before
    fun setupRepository() {
        repository = SearchRepository()
    }

    @Test
    fun fetchResults() = runTest {
        val result = repository.fetchResults("motorola")
        Assert.assertNotNull(result)
    }
}