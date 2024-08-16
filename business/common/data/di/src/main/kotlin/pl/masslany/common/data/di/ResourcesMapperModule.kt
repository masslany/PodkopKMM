package pl.masslany.common.data.di

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import pl.masslany.business.common.data.main.mapper.GenderMapper
import pl.masslany.business.common.data.main.mapper.NameColorMapper
import pl.masslany.business.common.data.main.mapper.ResourceMapper
import pl.masslany.business.common.data.main.mapper.common.ActionsMapper
import pl.masslany.business.common.data.main.mapper.common.ActionsMapperImpl
import pl.masslany.business.common.data.main.mapper.common.AnswerMapper
import pl.masslany.business.common.data.main.mapper.common.AnswerMapperImpl
import pl.masslany.business.common.data.main.mapper.common.AuthorMapper
import pl.masslany.business.common.data.main.mapper.common.AuthorMapperImpl
import pl.masslany.business.common.data.main.mapper.common.CommentItemMapper
import pl.masslany.business.common.data.main.mapper.common.CommentItemMapperImpl
import pl.masslany.business.common.data.main.mapper.common.CommentsMapper
import pl.masslany.business.common.data.main.mapper.common.CommentsMapperImpl
import pl.masslany.business.common.data.main.mapper.common.DeletedMapper
import pl.masslany.business.common.data.main.mapper.common.DeletedMapperImpl
import pl.masslany.business.common.data.main.mapper.common.EmbedMapper
import pl.masslany.business.common.data.main.mapper.common.EmbedMapperImpl
import pl.masslany.business.common.data.main.mapper.common.MediaMapper
import pl.masslany.business.common.data.main.mapper.common.MediaMapperImpl
import pl.masslany.business.common.data.main.mapper.common.PaginationMapper
import pl.masslany.business.common.data.main.mapper.common.PaginationMapperImpl
import pl.masslany.business.common.data.main.mapper.common.PhotoMapper
import pl.masslany.business.common.data.main.mapper.common.PhotoMapperImpl
import pl.masslany.business.common.data.main.mapper.common.RankMapper
import pl.masslany.business.common.data.main.mapper.common.RankMapperImpl
import pl.masslany.business.common.data.main.mapper.common.ResourceItemMapper
import pl.masslany.business.common.data.main.mapper.common.ResourceItemMapperImpl
import pl.masslany.business.common.data.main.mapper.common.ResourcesMapper
import pl.masslany.business.common.data.main.mapper.common.ResourcesMapperImpl
import pl.masslany.business.common.data.main.mapper.common.SourceMapper
import pl.masslany.business.common.data.main.mapper.common.SourceMapperImpl
import pl.masslany.business.common.data.main.mapper.common.SurveyMapper
import pl.masslany.business.common.data.main.mapper.common.SurveyMapperImpl
import pl.masslany.business.common.data.main.mapper.common.VotesMapper
import pl.masslany.business.common.data.main.mapper.common.VotesMapperImpl
import pl.masslany.business.common.data.main.mapper.links.LinkMapper
import pl.masslany.business.common.data.main.mapper.links.LinkMapperImpl

@Suppress("TooManyFunctions")
@Module
object ResourcesMapperModule {

    @Factory
    fun provideActionsMapper(): ActionsMapper {
        return ActionsMapperImpl()
    }

    @Factory
    fun provideAuthorMapper(
        rankMapper: RankMapper,
        nameColorMapper: NameColorMapper,
        genderMapper: GenderMapper,
    ): AuthorMapper {
        return AuthorMapperImpl(
            rankMapper,
            nameColorMapper,
            genderMapper
        )
    }

    @Factory
    fun provideCommentsMapper(
        commentItemMapper: CommentItemMapper
    ): CommentsMapper {
        return CommentsMapperImpl(
            commentItemMapper
        )
    }

    @Suppress("LongParameterList")
    @Factory
    fun provideCommentItemMapper(
        actionsMapper: ActionsMapper,
        authorMapper: AuthorMapper,
        mediaMapper: MediaMapper,
        votesMapper: VotesMapper,
        resourceMapper: ResourceMapper,
        deletedMapper: DeletedMapper,
    ): CommentItemMapper {
        return CommentItemMapperImpl(
            actionsMapper,
            authorMapper,
            mediaMapper,
            votesMapper,
            resourceMapper,
            deletedMapper,
        )
    }

    @Suppress("LongParameterList")
    @Factory
    fun provideResourceItemMapper(
        actionsMapper: ActionsMapper,
        authorMapper: AuthorMapper,
        commentsMapper: CommentsMapper,
        mediaMapper: MediaMapper,
        sourceMapper: SourceMapper,
        votesMapper: VotesMapper,
        resourceMapper: ResourceMapper,
        deletedMapper: DeletedMapper,
    ): ResourceItemMapper {
        return ResourceItemMapperImpl(
            actionsMapper,
            authorMapper,
            commentsMapper,
            mediaMapper,
            sourceMapper,
            votesMapper,
            resourceMapper,
            deletedMapper
        )
    }

    @Factory
    fun provideEmbedMapper(): EmbedMapper {
        return EmbedMapperImpl()
    }

    @Factory
    fun provideLinksMapper(
        resourceItemMapper: ResourceItemMapper,
        paginationMapper: PaginationMapper
    ): ResourcesMapper {
        return ResourcesMapperImpl(
            resourceItemMapper,
            paginationMapper
        )
    }

    @Factory
    fun provideMediaMapper(
        embedMapper: EmbedMapper,
        photoMapper: PhotoMapper,
        surveyMapper: SurveyMapper,
    ): MediaMapper {
        return MediaMapperImpl(
            embedMapper,
            photoMapper,
            surveyMapper,
        )
    }

    @Factory
    fun providePaginationMapper(): PaginationMapper {
        return PaginationMapperImpl()
    }

    @Factory
    fun providePhotoMapper(): PhotoMapper {
        return PhotoMapperImpl()
    }

    @Factory
    fun provideRankMapper(): RankMapper {
        return RankMapperImpl()
    }

    @Factory
    fun provideSourceMapper(): SourceMapper {
        return SourceMapperImpl()
    }

    @Factory
    fun provideVotesMapper(): VotesMapper {
        return VotesMapperImpl()
    }

    @Factory
    fun provideLinkMapper(
        resourceItemMapper: ResourceItemMapper,
    ): LinkMapper {
        return LinkMapperImpl(
            resourceItemMapper,
        )
    }

    @Factory
    fun provideDeletedMapper(): DeletedMapper {
        return DeletedMapperImpl()
    }

    @Factory
    fun provideAnswerMapper(): AnswerMapper {
        return AnswerMapperImpl()
    }

    @Factory
    fun provideSurveyMapper(
        actionsMapper: ActionsMapper,
        answerMapper: AnswerMapper
    ): SurveyMapper {
        return SurveyMapperImpl(
            actionsMapper,
            answerMapper,
        )
    }
}
