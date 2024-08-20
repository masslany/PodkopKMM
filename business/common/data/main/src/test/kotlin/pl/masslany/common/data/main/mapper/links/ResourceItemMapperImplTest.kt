package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toResourceItem
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

        // When
        val result = dataDto.toResourceItem()

        // Then
        assertIs<ResourceItem>(result)
    }
}
