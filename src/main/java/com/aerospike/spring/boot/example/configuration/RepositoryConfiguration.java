package com.aerospike.spring.boot.example.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;

@Configuration
@EnableAerospikeRepositories(basePackages = {"com.aerospike.spring.boot.example.repository"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class RepositoryConfiguration {

	public @Bean(destroyMethod = "close") AerospikeClient aerospikeClient() {
		ClientPolicy policy = new ClientPolicy();
		policy.failIfNotConnected = true;

		return new AerospikeClient(policy, "localhost", 3000);
	}

	public @Bean AerospikeTemplate aerospikeTemplate() {
		return new AerospikeTemplate(aerospikeClient(), "test");
	}
}
