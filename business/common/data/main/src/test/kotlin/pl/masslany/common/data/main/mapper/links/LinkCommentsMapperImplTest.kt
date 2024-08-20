package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toComments
import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.domain.models.common.Comments
import kotlin.test.assertIs

class LinkCommentsMapperImplTest {

    @Test
    fun `Given commentsDto When map Then return domain model`() {
        // Given
        val commentsDto =
            mockk<CommentsDto>(relaxed = true) {
                every { items } returns emptyList()
            }

        // When
        val result = commentsDto.toComments()

        // Then
        assertIs<Comments>(result)
    }
}
