package br.com.dtidigital.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.microsoft.azure.spring.data.cosmosdb.config.AbstractDocumentDbConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.DocumentDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;

@Configuration
@EnableDocumentDbRepositories
public class AppConfiguration extends AbstractDocumentDbConfiguration{

    @Value("${azure.cosmosdb.uri}")
    private String uri;

    @Value("${azure.cosmosdb.key}")
    private String key;

    @Value("${azure.cosmosdb.database}")
    private String dbName;
	
	@Override
	public DocumentDBConfig getConfig() {
        return DocumentDBConfig.builder(uri, key, dbName).build();
	}

}
