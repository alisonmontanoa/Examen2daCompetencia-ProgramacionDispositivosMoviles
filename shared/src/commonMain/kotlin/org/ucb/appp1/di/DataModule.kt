package org.ucb.appp1.di

import org.koin.dsl.module
import org.ucb.appp1.userinformation.data.datasource.GithubRemoteDataSource
import org.ucb.appp1.userinformation.data.repository.GithubRepositoryImpl
import org.ucb.appp1.userinformation.data.service.GitHubApiService
import org.ucb.appp1.userinformation.domain.repository.GithubRepository
import org.ucb.appp1.earthquake.data.datasource.EarthquakeRemoteDataSource
import org.ucb.appp1.earthquake.data.mapper.EarthquakeMapper
import org.ucb.appp1.earthquake.data.repository.EarthquakeRepositoryImpl
import org.ucb.appp1.earthquake.data.service.EarthquakeService
import org.ucb.appp1.earthquake.domain.repository.EarthquakeRepository

val dataModule = module {

    single<GithubRemoteDataSource> { GitHubApiService() }
    single<GithubRepository> { GithubRepositoryImpl(get()) }

    single { EarthquakeService() }
    single { EarthquakeRemoteDataSource(get()) }
    single { EarthquakeMapper() }
    single<EarthquakeRepository> {
        EarthquakeRepositoryImpl(
            get(),
            get()
        )
    }
}