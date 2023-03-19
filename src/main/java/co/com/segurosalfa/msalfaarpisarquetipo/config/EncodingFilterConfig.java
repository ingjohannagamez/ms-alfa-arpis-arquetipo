package co.com.segurosalfa.msalfaarpisarquetipo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class EncodingFilterConfig  {
    
    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilterUTF() {
        final FilterRegistrationBean<CharacterEncodingFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new CharacterEncodingFilter());
        filterRegBean.addUrlPatterns("/*");
        filterRegBean.addInitParameter("encoding", "UTF-8");
        filterRegBean.addInitParameter("forceEncoding", "true");
        filterRegBean.setName("encodingFilter");
        filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegBean;
    }
}
