package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toVotes
import pl.masslany.business.common.data.network.models.common.VotesDto
import pl.masslany.business.common.domain.models.common.Votes
import kotlin.test.assertIs

class VotesMapperImplTest {

    @Test
    fun `Given votesDto When map Then return domain model`() {
        // Given
        val votesDto = mockk<VotesDto>(relaxed = true)

        // When
        val result = votesDto.toVotes()

        // Then
        assertIs<Votes>(result)
    }
}
