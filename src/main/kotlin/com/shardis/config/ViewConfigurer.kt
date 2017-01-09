package com.shardis.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import java.util.concurrent.TimeUnit

@Configuration
open class ViewConfigurer : WebMvcConfigurerAdapter() {

  override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry
      .addResourceHandler("/**")
      .addResourceLocations("classpath:/static/")
      .setCachePeriod(TimeUnit.HOURS.toSeconds(24L).toInt())
      .resourceChain(true)
      .addResolver(PushStateResourceResolver())
  }
}
