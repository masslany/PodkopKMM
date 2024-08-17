package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.SourceMapperImpl
import pl.masslany.business.common.data.network.models.common.SourceDto
import pl.masslany.business.common.domain.models.common.Source
import kotlin.test.assertIs

class SourceMapperImplTest {
    private val sut = SourceMapperImpl()

    @Test
    fun `Given sourceDto When map Then return domain model`() {
        // Given
        val sourceDto = mockk<SourceDto>(relaxed = true)

        // When
        val result = sut.map(sourceDto)

        // Then
        assertIs<Source>(result)
    }
}
