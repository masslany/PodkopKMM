package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toRank
import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Rank
import kotlin.test.assertIs

class RankMapperImplTest {

    @Test
    fun `Given rankDto When map Then return domain model`() {
        // Given
        val rankDto = mockk<RankDto>(relaxed = true)

        // When
        val result = rankDto.toRank()

        // Then
        assertIs<Rank>(result)
    }
}
