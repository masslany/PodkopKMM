package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.toMedia
import pl.masslany.business.common.data.network.models.common.EmbedDto
import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.data.network.models.common.PhotoDto
import pl.masslany.business.common.data.network.models.entries.SurveyDto
import pl.masslany.business.common.domain.models.common.Media
import kotlin.test.assertIs

class MediaMapperImplTest {

    @Test
    fun `Given mediaDto When map Then return domain model`() {
        // Given
        val mockEmbedDto = mockk<EmbedDto>()
        val mockPhotoDto = mockk<PhotoDto>()
        val mockSurveyDto = mockk<SurveyDto>()
        val mediaDto =
            mockk<MediaDto>(relaxed = true) {
                every { embed } returns mockEmbedDto
                every { photo } returns mockPhotoDto
                every { survey } returns mockSurveyDto
            }
        // When
        val result = mediaDto.toMedia()

        // Then
        assertIs<Media>(result)
    }
}
