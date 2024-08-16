package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.PaginationMapperImpl
import pl.masslany.business.common.data.network.models.common.PaginationDto
import pl.masslany.business.common.domain.models.common.Pagination
import kotlin.test.assertIs

class PaginationMapperImplTest {
    private val sut = PaginationMapperImpl()

    @Test
    fun `Given paginationDto When map Then return domain model`() {
        // Given
        val paginationDto = mockk<PaginationDto>(relaxed = true)

        // When
        val result = sut.map(paginationDto)

        // Then
        assertIs<Pagination>(result)
    }
}
