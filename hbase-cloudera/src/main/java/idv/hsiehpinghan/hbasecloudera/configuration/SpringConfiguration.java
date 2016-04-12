package idv.hsiehpinghan.hbasecloudera.configuration;

import idv.hsiehpinghan.hbasecloudera.entity.HbaseEntityBase;

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = { "idv.hsiehpinghan.hbasecloudera" })
public class SpringConfiguration {
	@Bean
	public org.apache.hadoop.conf.Configuration hBaseConfiguration()
			throws IOException {
		org.apache.hadoop.conf.Configuration config = HBaseConfiguration
				.create();
		config.addResource(new ClassPathResource("hbase-site.xml")
				.getInputStream());
		return config;
	}

	@Bean
	public HColumnDescriptor hColumnDescriptor() {
		HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(
				HbaseEntityBase.COLUMN_FAMILY_NAME);
		return hColumnDescriptor;
	}

	@Bean
	public HTableDescriptor hTableDescriptor(HColumnDescriptor hColumnDescriptor) {
		return new HTableDescriptor(HbaseEntityBase.TABLE_NAME);
	}

}
