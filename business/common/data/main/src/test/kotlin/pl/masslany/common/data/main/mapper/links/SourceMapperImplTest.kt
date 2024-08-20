package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toSource
import pl.masslany.business.common.data.network.models.common.SourceDto
import pl.masslany.business.common.domain.models.common.Source
import kotlin.test.assertIs

class SourceMapperImplTest {

    @Test
    fun `Given sourceDto When map Then return domain model`() {
        // Given
        val sourceDto = mockk<SourceDto>(relaxed = true)

        // When
        val result = sourceDto.toSource()

        // Then
        assertIs<Source>(result)
    }
}
