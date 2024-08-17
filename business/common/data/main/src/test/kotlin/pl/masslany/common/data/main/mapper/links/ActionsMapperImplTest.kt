package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.ActionsMapperImpl
import pl.masslany.business.common.data.network.models.common.ActionsDto
import pl.masslany.business.common.domain.models.common.Actions
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ActionsMapperImplTest {
    private val sut = ActionsMapperImpl()

    @Test
    fun `Given ActionDto When map Then return domain model`() {
        // Given
        val actionsDto =
            mockk<ActionsDto> {
                every { create } returns true
                every { createFavourite } returns true
                every { delete } returns true
                every { deleteFavourite } returns true
                every { finishAma } returns true
                every { report } returns true
                every { startAma } returns true
                every { undoVote } returns true
                every { update } returns true
                every { voteDown } returns true
                every { voteUp } returns true
            }

        // When
        val result = sut.map(actionsDto)

        // Then
        assertIs<Actions>(result)
        assertTrue(result.create)
        assertTrue(result.createFavourite)
        assertTrue(result.delete)
        assertTrue(result.deleteFavourite)
        assertTrue(result.finishAma)
        assertTrue(result.report)
        assertTrue(result.startAma)
        assertTrue(result.undoVote)
        assertTrue(result.update)
        assertTrue(result.voteDown)
        assertTrue(result.voteUp)
    }
}
