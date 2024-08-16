package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.ResourceMapper
import pl.masslany.business.common.data.main.mapper.common.ActionsMapper
import pl.masslany.business.common.data.main.mapper.common.AuthorMapper
import pl.masslany.business.common.data.main.mapper.common.CommentsMapper
import pl.masslany.business.common.data.main.mapper.common.DeletedMapper
import pl.masslany.business.common.data.main.mapper.common.MediaMapper
import pl.masslany.business.common.data.main.mapper.common.ResourceItemMapperImpl
import pl.masslany.business.common.data.main.mapper.common.SourceMapper
import pl.masslany.business.common.data.main.mapper.common.VotesMapper
import pl.masslany.business.common.data.network.models.common.ActionsDto
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.data.network.models.common.ResourceItemDto
import pl.masslany.business.common.data.network.models.common.SourceDto
import pl.masslany.business.common.data.network.models.common.VotesDto
import pl.masslany.business.common.domain.models.common.ResourceItem
import kotlin.test.assertIs

class ResourceItemMapperImplTest {
    private val mockActionsMapper = mockk<ActionsMapper>()
    private val mockAuthorMapper = mockk<AuthorMapper>()
    private val mockCommentsMapper = mockk<CommentsMapper>()
    private val mockMediaMapper = mockk<MediaMapper>()
    private val mockSourceMapper = mockk<SourceMapper>()
    private val mockVotesMapper = mockk<VotesMapper>()
    private val mockResourceMapper = mockk<ResourceMapper>()
    private val mockDeletedMapper = mockk<DeletedMapper>()

    private val sut =
        ResourceItemMapperImpl(
            mockActionsMapper,
            mockAuthorMapper,
            mockCommentsMapper,
            mockMediaMapper,
            mockSourceMapper,
            mockVotesMapper,
            mockResourceMapper,
            mockDeletedMapper,
        )

    @Test
    fun `Given dataDto When map Then return domain model`() {
        // Given
        val mockActionsDto = mockk<ActionsDto>()
        val mockAuthorDto = mockk<AuthorDto>()
        val mockCommentsDto = mockk<CommentsDto>()
        val mockMediaDto = mockk<MediaDto>()
        val mockSourceDto = mockk<SourceDto>()
        val mockVotesDto = mockk<VotesDto>()
        val dataDto =
            mockk<ResourceItemDto>(relaxed = true) {
                every { actions } returns mockActionsDto
                every { author } returns mockAuthorDto
                every { comments } returns mockCommentsDto
                every { media } returns mockMediaDto
                every { source } returns mockSourceDto
                every { votes } returns mockVotesDto
                every { resource } returns "link"
                every { deleted } returns null
            }
        every { mockActionsMapper.map(mockActionsDto) } returns mockk()
        every { mockAuthorMapper.map(mockAuthorDto) } returns mockk()
        every { mockCommentsMapper.map(mockCommentsDto) } returns mockk()
        every { mockMediaMapper.map(mockMediaDto) } returns mockk()
        every { mockSourceMapper.map(mockSourceDto) } returns mockk()
        every { mockVotesMapper.map(mockVotesDto) } returns mockk()
        every { mockResourceMapper.map("link") } returns mockk()
        every { mockDeletedMapper.map(null) } returns mockk()

        // When
        val result = sut.map(listOf(dataDto))

        // Then
        assertIs<ResourceItem>(result.first())
        verify { mockActionsMapper.map(mockActionsDto) }
        verify { mockAuthorMapper.map(mockAuthorDto) }
        verify { mockCommentsMapper.map(mockCommentsDto) }
        verify { mockMediaMapper.map(mockMediaDto) }
        verify { mockSourceMapper.map(mockSourceDto) }
        verify { mockVotesMapper.map(mockVotesDto) }
        verify { mockResourceMapper.map("link") }
    }
}
