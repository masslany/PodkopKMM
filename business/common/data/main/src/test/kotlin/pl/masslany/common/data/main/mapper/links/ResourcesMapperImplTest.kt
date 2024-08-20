package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toResources
import pl.masslany.business.common.data.network.models.common.PaginationDto
import pl.masslany.business.common.data.network.models.common.ResourceItemDto
import pl.masslany.business.common.data.network.models.common.ResourceResponseDto
import pl.masslany.business.common.domain.models.common.Resources
import kotlin.test.assertIs

class ResourcesMapperImplTest {

    @Test
    fun `Given resourcesDto When map Then return domain model`() {
        // Given
        val mockData = mockk<ResourceItemDto>()
        val mockPagination = mockk<PaginationDto>()
        val resourcesDto =
            mockk<ResourceResponseDto> {
                every { data } returns listOf(mockData)
                every { pagination } returns mockPagination
            }
        // When
        val result = resourcesDto.toResources()

        // Then
        assertIs<Resources>(result)
    }
}
