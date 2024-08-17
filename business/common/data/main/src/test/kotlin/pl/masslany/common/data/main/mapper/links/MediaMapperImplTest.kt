package pl.masslany.common.data.main.mapper.links

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.EmbedMapper
import pl.masslany.business.common.data.main.mapper.common.MediaMapperImpl
import pl.masslany.business.common.data.main.mapper.common.PhotoMapper
import pl.masslany.business.common.data.main.mapper.common.SurveyMapper
import pl.masslany.business.common.data.network.models.common.EmbedDto
import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.data.network.models.common.PhotoDto
import pl.masslany.business.common.data.network.models.entries.SurveyDto
import pl.masslany.business.common.domain.models.common.Media
import kotlin.test.assertIs

class MediaMapperImplTest {
    private val mockEmbedMapper = mockk<EmbedMapper>()
    private val mockPhotoMapper = mockk<PhotoMapper>()
    private val mockSurveyMapper = mockk<SurveyMapper>()

    private val sut =
        MediaMapperImpl(
            mockEmbedMapper,
            mockPhotoMapper,
            mockSurveyMapper,
        )

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
        every { mockEmbedMapper.map(mockEmbedDto) } returns mockk()
        every { mockPhotoMapper.map(mockPhotoDto) } returns mockk()
        every { mockSurveyMapper.map(mockSurveyDto) } returns mockk()

        // When
        val result = sut.map(mediaDto)

        // Then
        assertIs<Media>(result)
    }
}
