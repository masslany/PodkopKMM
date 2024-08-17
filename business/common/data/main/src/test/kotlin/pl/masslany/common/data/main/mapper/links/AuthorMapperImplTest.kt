package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.GenderMapper
import pl.masslany.business.common.data.main.mapper.NameColorMapper
import pl.masslany.business.common.data.main.mapper.common.AuthorMapperImpl
import pl.masslany.business.common.data.main.mapper.common.RankMapper
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Author
import kotlin.test.assertIs

class AuthorMapperImplTest {
    private val mockRankMapper = mockk<RankMapper>()
    private val mockNameColorMapper = mockk<NameColorMapper>()
    private val mockGenderMapper = mockk<GenderMapper>()

    private val sut =
        AuthorMapperImpl(
            mockRankMapper,
            mockNameColorMapper,
            mockGenderMapper,
        )

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
        every { mockRankMapper.map(mockRank) } returns mockk()
        every { mockNameColorMapper.map(nameColor) } returns mockk()
        every { mockGenderMapper.map(authorGender) } returns mockk()

        // When
        val result = sut.map(authorDto)

        // Then
        assertIs<Author>(result)
        verify { mockRankMapper.map(mockRank) }
    }
}
