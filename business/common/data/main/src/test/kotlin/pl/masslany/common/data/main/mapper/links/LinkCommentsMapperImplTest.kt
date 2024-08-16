package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.CommentItemMapper
import pl.masslany.business.common.data.main.mapper.common.CommentsMapperImpl
import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.domain.models.common.Comments
import kotlin.test.assertIs

class LinkCommentsMapperImplTest {
    private val mockCommentItemMapper = mockk<CommentItemMapper>()

    private val sut = CommentsMapperImpl(mockCommentItemMapper)

    @Test
    fun `Given commentsDto When map Then return domain model`() {
        // Given
        val commentsDto =
            mockk<CommentsDto>(relaxed = true) {
                every { items } returns emptyList()
            }
        every { mockCommentItemMapper.map(emptyList()) } returns mockk()

        // When
        val result = sut.map(commentsDto)

        // Then
        assertIs<Comments>(result)
    }
}
