package pl.masslany.common.data.main.mapper.links

import io.mockk.mockk
import org.junit.Test
import pl.masslany.business.common.data.main.mapper.common.PhotoMapperImpl
import pl.masslany.business.common.data.network.models.common.PhotoDto
import pl.masslany.business.common.domain.models.common.Photo
import kotlin.test.assertIs

class PhotoMapperImplTest {
    private val sut = PhotoMapperImpl()

    @Test
    fun `Given photoDto When map Then return domain model`() {
        // Given
        val photoDto = mockk<PhotoDto>(relaxed = true)

        // When
        val result = sut.map(photoDto)

        // Then
        assertIs<Photo>(result)
    }
}
