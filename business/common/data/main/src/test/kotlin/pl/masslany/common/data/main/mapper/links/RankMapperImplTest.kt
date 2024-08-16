package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.RankMapperImpl
import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Rank
import kotlin.test.assertIs

class RankMapperImplTest {
    private val sut = RankMapperImpl()

    @Test
    fun `Given rankDto When map Then return domain model`() {
        // Given
        val rankDto = mockk<RankDto>(relaxed = true)

        // When
        val result = sut.map(rankDto)

        // Then
        assertIs<Rank>(result)
    }
}
