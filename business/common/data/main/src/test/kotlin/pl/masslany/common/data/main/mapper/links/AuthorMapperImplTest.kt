package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toAuthor
import pl.masslany.business.common.data.main.mapper.common.toRank
import pl.masslany.business.common.data.main.mapper.toGender
import pl.masslany.business.common.data.main.mapper.toNameColor
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Author
import kotlin.test.assertIs

class AuthorMapperImplTest {
    @Test
    fun `Given authorDto When map Then return domain model`() {
        // Given
        val mockRank = mockk<RankDto>()
        val nameColor = "orange"
        val authorGender = "m"
        val authorDto =
            mockk<AuthorDto>(relaxed = true) {
                every { rank } returns mockRank
                every { color } returns nameColor
                every { gender } returns authorGender
            }
        mockkStatic(String::toNameColor)
        mockkStatic(String::toGender)
        mockkStatic(RankDto::toRank)
        every { mockRank.toRank() } returns mockk()
        every { nameColor.toNameColor() } returns mockk()
        every { authorGender.toGender() } returns mockk()

        // When
        val result = authorDto.toAuthor()

        // Then
        assertIs<Author>(result)
    }
}
