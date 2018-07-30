package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.presenter

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import retrofit2.Callback
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.data.repository.FruitsRepository
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.model.Fruits
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.Presenter
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.presenter.fruits.interfaces.View
import rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util.IOUtils

class FruitsPresenterTest {

    @Mock
    private lateinit var view: View

    @Mock
    private lateinit var repository: FruitsRepository

    @Mock
    private lateinit var callback: Callback<Fruits>

    private lateinit var presenter: Presenter

    private var json = ""

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        presenter = FruitsPresenter()
        presenter.bind(view, repository)
        presenter.request()
        json = IOUtils.readStringFromResourcePath("fruits.json")

    }

    @Test
    fun bind() {

        assertNotNull((presenter as FruitsPresenter).view)
        assertNotNull((presenter as FruitsPresenter).repository)

    }

    @Test
    fun requestSucess() {

        val listFruits = Gson().fromJson<Fruits>(json, Fruits::class.java)
        doAnswer {
            view.sucess(listFruits)
        }.`when`(repository).request(callback)

        repository.request(callback)
        verify(view).sucess(listFruits)


        assertEquals(12, listFruits.fruits.size)

        assertEquals("Apple", listFruits.fruits[0].name)
        assertEquals(35.0, listFruits.fruits[0].price, 0.01)
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg",
                 listFruits.fruits[0].image)

        assertEquals("Pineapple", listFruits.fruits[3].name)
        assertEquals(200.0, listFruits.fruits[3].price, 0.01)
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/286px-Pineapple_and_cross_section.jpg",
                listFruits.fruits[3].image)

        assertEquals("pear", listFruits.fruits[11].name)
        assertEquals(4.75, listFruits.fruits[11].price, 0.01)
        assertEquals("https://www.organicfacts.net/wp-content/uploads/pear.jpg",
                listFruits.fruits[11].image)

    }

    @Test
    fun requestError() {

        doAnswer {
            view.erro("Error")
        }.`when`(repository).request(callback)

        repository.request(callback)
        verify(view).erro("Error")
    }

}