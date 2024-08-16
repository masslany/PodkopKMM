package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.PaginationMapper
import pl.masslany.business.common.data.main.mapper.common.ResourceItemMapper
import pl.masslany.business.common.data.main.mapper.common.ResourcesMapperImpl
import pl.masslany.business.common.data.network.models.common.PaginationDto
import pl.masslany.business.common.data.network.models.common.ResourceItemDto
import pl.masslany.business.common.data.network.models.common.ResourceResponseDto
import pl.masslany.business.common.domain.models.common.Resources
import kotlin.test.assertIs

class ResourcesMapperImplTest {
    private val mockResourceItemMapper = mockk<ResourceItemMapper>()
    private val mockPaginationMapper = mockk<PaginationMapper>()

    private val sut =
        ResourcesMapperImpl(
            mockResourceItemMapper,
            mockPaginationMapper,
        )

    @Test
    fun `Given resourcesDto When map Then return domain model`() {
        // Given
        val mockData = mockk<ResourceItemDto>()
        val mockPagination = mockk<PaginationDto>()
        val linksDto =
            mockk<ResourceResponseDto> {
                every { data } returns listOf(mockData)
                every { pagination } returns mockPagination
            }
        every { mockResourceItemMapper.map(listOf(mockData)) } returns mockk()
        every { mockPaginationMapper.map(mockPagination) } returns mockk()

        // When
        val result = sut.map(linksDto)

        // Then
        assertIs<Resources>(result)
        verify { mockResourceItemMapper.map(listOf(mockData)) }
        verify { mockPaginationMapper.map(mockPagination) }
    }
}
