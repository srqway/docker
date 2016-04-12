package idv.hsiehpinghan.hbasecloudera.service;

import idv.hsiehpinghan.hbasecloudera.entity.HbaseGetEntity;
import idv.hsiehpinghan.hbasecloudera.entity.HbasePutEntity;
import idv.hsiehpinghan.hbasecloudera.suit.TestngSuitSetting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HbaseEntityServiceTest {
	private static final String ROWKEY = "ETUTEST";
	private HbaseEntityService service;

	@BeforeClass
	public void beforeClass() throws Exception {
		ApplicationContext applicationContext = TestngSuitSetting
				.getApplicationContext();
		service = applicationContext.getBean(HbaseEntityService.class);
	}

	// @Test
	public void get() throws IOException {
		HbaseGetEntity entity = service.get(ROWKEY);

		System.err.println(entity.getColumnFamily().getValueString());

		Assert.assertNotNull(entity.getColumnFamily().getValue());
	}

	// @Test
	public void put() {
		HbasePutEntity entity = generateHbasePutEntity(3);
		boolean result = service.put(entity);
		Assert.assertTrue(result);
	}

	@Test
	public void puts() {
		List<HbasePutEntity> entities = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			HbasePutEntity entity = generateHbasePutEntity(i);
			entities.add(entity);
		}
		boolean result = service.puts(entities);
		Assert.assertTrue(result);
	}

	private HbasePutEntity generateHbasePutEntity(int i) {
		Map<String, String> columnFamilyMap = new HashMap<String, String>();
		columnFamilyMap.put(HbasePutEntity.ColumnFamily.VALUE, "test value "
				+ i);
		HbasePutEntity entity = new HbasePutEntity("000000" + i,
				columnFamilyMap);
		return entity;
	}
}
