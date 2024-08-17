package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.EmbedMapperImpl
import pl.masslany.business.common.data.network.models.common.EmbedDto
import pl.masslany.business.common.domain.models.common.Embed
import kotlin.test.assertIs

class EmbedMapperImplTest {
    private val sut = EmbedMapperImpl()

    @Test
    fun `Given embedDto When map Then return domain model`() {
        // Given
        val embedDto = mockk<EmbedDto>(relaxed = true)

        // When
        val result = sut.map(embedDto)

        // Then
        assertIs<Embed>(result)
    }
}
