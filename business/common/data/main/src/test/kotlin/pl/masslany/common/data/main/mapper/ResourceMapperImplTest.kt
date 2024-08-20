package pl.masslany.common.data.main.mapper

import org.junit.Test
import pl.masslany.business.common.data.main.mapper.toResource
import pl.masslany.business.common.domain.models.common.Resource
import kotlin.test.assertIs

class ResourceMapperImplTest {

    @Test
    fun `Given link When map Then return Resource Link`() {
        // Given
        val data = "link"

        // When
        val result = data.toResource()

        // Then
        assertIs<Resource.Link>(result)
    }

    @Test
    fun `Given entry When map Then return Resource Entry`() {
        // Given
        val data = "entry"

        // When
        val result = data.toResource()

        // Then
        assertIs<Resource.Entry>(result)
    }

    @Test
    fun `Given entry_comment When map Then return Resource EntryComment`() {
        // Given
        val data = "entry_comment"

        // When
        val result = data.toResource()

        // Then
        assertIs<Resource.EntryComment>(result)
    }

    @Test
    fun `Given link_comment When map Then return Resource LinkComment`() {
        // Given
        val data = "link_comment"

        // When
        val result = data.toResource()

        // Then
        assertIs<Resource.LinkComment>(result)
    }

    @Test
    fun `Given wrong data When map Then return Resource Unknown`() {
        // Given
        val data = "unknown_res"

        // When
        val result = data.toResource()

        // Then
        assertIs<Resource.Unknown>(result)
    }
}
